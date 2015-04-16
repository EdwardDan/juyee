package com.justonetech.biz.controller.project;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.ProjectBidSignDeptService;
import com.justonetech.biz.daoservice.ProjectBidSignService;
import com.justonetech.biz.domain.ProjectBidSignDept;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.ProjectManager;
import com.justonetech.biz.manager.RelateManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
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
 * note:招标报名单位
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class ProjectBidSignDeptController extends BaseCRUDActionController<ProjectBidSignDept> {
    private Logger logger = LoggerFactory.getLogger(ProjectBidSignDeptController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private RelateManager relateManager;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private ProjectBidSignDeptService projectBidSignDeptService;

    @Autowired
    private ProjectBidSignService projectBidSignService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model, Long projectBidSignId) {
        //判断是否有编辑权限
//        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_SAMPLE_EDIT));
        model.addAttribute("canEdit",true);
        model.addAttribute("projectBidSign", projectBidSignService.get(projectBidSignId));
        model.addAttribute("currentUser", sysUserManager.getSysUser().getLoginName());//当前用户名
        return "view/project/projectBidSignDept/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session, Long projectBidSignId) {
        try {
            Page pageModel = new Page(page, rows, true);
            String loginName = sysUserManager.getSysUser().getLoginName();        //当前登录用户名
            String hql = "from ProjectBidSignDept where projectBidSign.id=" + projectBidSignId + " and createUser='"+ loginName + "' order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = projectBidSignDeptService.findByPage(pageModel, query);

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
    public String add(Model model, Long projectBidSignId) {
        ProjectBidSignDept projectBidSignDept = new ProjectBidSignDept();
        projectBidSignDept.setProjectBidSign(projectBidSignService.get(projectBidSignId));
        //如需增加其他默认值请在此添加
        projectBidSignDept.setSignDate(new Timestamp(System.currentTimeMillis()));
        model.addAttribute("bean", projectBidSignDept);

        return "view/project/projectBidSignDept/input";
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
        ProjectBidSignDept projectBidSignDept = projectBidSignDeptService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", projectBidSignDept);

        return "view/project/projectBidSignDept/input";
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
        ProjectBidSignDept projectBidSignDept = projectBidSignDeptService.get(id);

        model.addAttribute("bean", projectBidSignDept);
        return "view/project/projectBidSignDept/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") ProjectBidSignDept entity, HttpServletRequest request) throws Exception {
        try {
            ProjectBidSignDept target;
            if (entity.getId() != null) {
                target = projectBidSignDeptService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "signUnit",
                        "linkPerson",
                        "linkTel",
                        "signDate"
                });

            } else {
                target = entity;
            }
            projectBidSignDeptService.save(target);

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
        projectBidSignDeptService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}