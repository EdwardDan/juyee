package com.justonetech.system.controller;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.system.daoservice.SysCustomGridService;
import com.justonetech.system.domain.SysCustomGrid;
import com.justonetech.system.domain.SysPrivilege;
import com.justonetech.system.manager.SysPrivilegeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * note:系统首页板块设置
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class SysCustomGridController extends BaseCRUDActionController<SysCustomGrid> {
    private Logger logger = LoggerFactory.getLogger(SysCustomGridController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysPrivilegeManager sysPrivilegeManager;

    @Autowired
    private SysCustomGridService sysCustomGridService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_CUSTOM_GRID_EDIT));

        return "view/system/sysCustomGrid/grid";
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
            String hql = "from SysCustomGrid order by orderNo asc,id asc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = sysCustomGridService.findByPage(pageModel, queryTranslate.toString());

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
        SysCustomGrid sysCustomGrid = new SysCustomGrid();

        //如需增加其他默认值请在此添加
        sysCustomGrid.setIsValid(true);
        model.addAttribute("bean", sysCustomGrid);

        //系统权限
        model.addAttribute("privileges", getPrivileges());

        return "view/system/sysCustomGrid/input";
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
        SysCustomGrid sysCustomGrid = sysCustomGridService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", sysCustomGrid);

        //系统权限
        model.addAttribute("privileges", getPrivileges());

        return "view/system/sysCustomGrid/input";
    }

    /**
     * 获取系统权限列表
     *
     * @return .
     */
    private List<SysPrivilege> getPrivileges() {
        //系统权限
        List<SysPrivilege> privileges = sysPrivilegeManager.getAllPrivileges();
        for (SysPrivilege privilege : privileges) {
            privilege.setDescription(JspHelper.getLevelStr(privilege.getTreeId(), "---"));
        }
        return privileges;
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
        SysCustomGrid sysCustomGrid = sysCustomGridService.get(id);

        model.addAttribute("bean", sysCustomGrid);
        return "view/system/sysCustomGrid/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") SysCustomGrid entity, HttpServletRequest request) throws Exception {
        try {
            SysCustomGrid target;
            if (entity.getId() != null) {
                target = sysCustomGridService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "modelCode",
                        "modelName",
                        "isValid",
                        "privilege",
                        "moreLink",
                        "orderNo"
                });

            } else {
                target = entity;
            }

            if (target.getOrderNo() == null) {
                target.setOrderNo(sysCustomGridService.findByQuery("from SysCustomGrid").size() + 1);
            }
            sysCustomGridService.save(target);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
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
        sysCustomGridService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}