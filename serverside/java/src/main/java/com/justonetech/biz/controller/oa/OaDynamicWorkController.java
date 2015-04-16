package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.OaDynamicWorkService;
import com.justonetech.biz.domain.OaDynamicWork;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.system.domain.SysUser;
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
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;


/**
 * note:实时工作动态
 * author: zhangchaofan
 * create date:
 * modify date:
 */
@Controller
public class OaDynamicWorkController extends BaseCRUDActionController<OaDynamicWork> {
    private Logger logger = LoggerFactory.getLogger(OaDynamicWorkController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private OaDynamicWorkService oaDynamicWorkService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_DYNAMIC_WORK_EDIT));
        model.addAttribute("currentUser", sysUserManager.getSysUser().getLoginName());
        return "view/oa/oaDynamicWork/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from OaDynamicWork order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = oaDynamicWorkService.findByPage(pageModel, query);

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
        OaDynamicWork oaDynamicWork = new OaDynamicWork();
        //部门获取
        SysUser sysUser = sysUserManager.getSysUser();
        String sysDeptName = sysUser.getPerson().getDeptName();
        oaDynamicWork.setReportDept(sysDeptName);
        oaDynamicWork.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        //如需增加其他默认值请在此添加
        model.addAttribute("bean", oaDynamicWork);

        return "view/oa/oaDynamicWork/input";
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
        OaDynamicWork oaDynamicWork = oaDynamicWorkService.get(id);
        SysUser sysUser = sysUserManager.getSysUser();
        String sysDeptName = sysUser.getPerson().getDeptName();
        oaDynamicWork.setReportDept(sysDeptName);
        oaDynamicWork.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        //处理其他业务逻辑
        model.addAttribute("bean", oaDynamicWork);

        return "view/oa/oaDynamicWork/input";
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
        OaDynamicWork oaDynamicWork = oaDynamicWorkService.get(id);

        model.addAttribute("bean", oaDynamicWork);
        return "view/oa/oaDynamicWork/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaDynamicWork entity, HttpServletRequest request) throws Exception {
        try {
            OaDynamicWork target;
            if (entity.getId() != null) {
                target = oaDynamicWorkService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "content",
                        "reportDept"
                });

            } else {
                target = entity;
            }

            Timestamp updateTime = new Timestamp(System.currentTimeMillis());
            target.setUpdateTime(updateTime);
            target.setIsValid(true);
            oaDynamicWorkService.save(target);

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
        OaDynamicWork oaDynamicWork = oaDynamicWorkService.get(id);

        oaDynamicWorkService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}