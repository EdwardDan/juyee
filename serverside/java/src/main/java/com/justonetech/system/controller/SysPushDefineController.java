package com.justonetech.system.controller;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.system.daoservice.SysPushDefineService;
import com.justonetech.system.domain.SysMenu;
import com.justonetech.system.domain.SysPushDefine;
import com.justonetech.system.manager.SysMenuManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Collection;
import java.util.List;


/**
 * note:系统首页推送定义
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class SysPushDefineController extends BaseCRUDActionController<SysPushDefine> {
    private Logger logger = LoggerFactory.getLogger(SysPushDefineController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysMenuManager sysMenuManager;

    @Autowired
    private SysPushDefineService sysPushDefineService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_PUSH_DEFINE_EDIT));

        return "view/system/sysPushDefine/grid";
    }

    /**
     * 获取列表数据
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from SysPushDefine order by orderNo asc,id asc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = sysPushDefineService.findByPage(pageModel, queryTranslate.toString());

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        SysPushDefine sysPushDefine = new SysPushDefine();
        sysPushDefine.setIsValid(true);

        String[] menuIcons = getMenuIcons();
        sysPushDefine.setTaskImg(menuIcons[0]);
        model.addAttribute("bean", sysPushDefine);

        //菜单
        model.addAttribute("menus", getMenus());

        //图标
        model.addAttribute("TASK_ICON_LIST", menuIcons);

        return "view/system/sysPushDefine/input";
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long id) {
        SysPushDefine sysPushDefine = sysPushDefineService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", sysPushDefine);

        //菜单
        model.addAttribute("menus", getMenus());

        //图标
        model.addAttribute("TASK_ICON_LIST", getMenuIcons());

        return "view/system/sysPushDefine/input";
    }

    //获取菜单图标供选择
    private String[] getMenuIcons(){
        String iconPath = getServletContext().getRealPath("/")+"skin\\default\\index_new\\task_img";
        IOFileFilter ioFileFilter = FileFilterUtils.prefixFileFilter("");
        Collection<File> files = FileUtils.listFiles(new File(iconPath), ioFileFilter, null);
        String[] icons = new String[files.size()];
        int i = 0;
        for (File file : files) {
            icons[i] = FilenameUtils.getBaseName(file.getName());
            i++;
        }
        return icons;
    }

    /**
     * 获取系统权限
     *
     * @return .
     */
    private List<SysMenu> getMenus() {
        List<SysMenu> menus = sysMenuManager.getNewAllMenus(null);
        for (SysMenu menu : menus) {
            menu.setTarget(JspHelper.getLevelStr(menu.getTreeId(), "---"));
        }
        return menus;
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        SysPushDefine sysPushDefine = sysPushDefineService.get(id);

        model.addAttribute("bean", sysPushDefine);
        return "view/system/sysPushDefine/view";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") SysPushDefine entity, HttpServletRequest request) throws Exception {
        Boolean checkOk = false;
        try {
            List<SysPushDefine> check;
            if (entity.getId() != null) {
                check = sysPushDefineService.findByQuery("from SysPushDefine where menu.id=? and id<>?", entity.getMenu().getId(), entity.getId());
            } else {
                check = sysPushDefineService.findByQuery("from SysPushDefine where menu.id=?", entity.getMenu().getId());
            }
            checkOk = !(check.size() > 0);

            if (checkOk) {
                SysPushDefine target;
                if (entity.getId() != null) {
                    target = sysPushDefineService.get(entity.getId());
                    ReflectionUtils.copyBean(entity, target, new String[]{
                            "modelName",
                            "pushDelay",
                            "isValid",
                            "querySql",
                            "orderNo",
                            "taskImg",
                            "menu"
                    });

                } else {
                    target = entity;
                }
                target.setModelName(target.getMenu().getName());

                if (target.getOrderNo() == null) {
                    target.setOrderNo(sysPushDefineService.findByQuery("from SysPushDefine").size() + 1);
                }
                sysPushDefineService.save(target);
            }

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        if (checkOk) {
            sendSuccessJSON(response, "保存成功");
        } else {
            sendFailureJSON(response, "保存失败，已存在相同模块");
        }
    }

    /**
     * 删除操作
     *
     * @param response .
     * @param id       .
     * @throws Exception .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long id) throws Exception {
        sysPushDefineService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}