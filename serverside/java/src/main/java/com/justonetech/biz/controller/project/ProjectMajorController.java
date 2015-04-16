package com.justonetech.biz.controller.project;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.ProjectMajorService;
import com.justonetech.biz.domain.ProjectMajor;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysCodeDetailService;
import com.justonetech.system.domain.SysCodeDetail;
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


/**
 * note:项目重大工程
 * author: guoqiong zhangchaofan
 * modify date: 2014/07/14
 */
@Controller
public class ProjectMajorController extends BaseCRUDActionController<ProjectMajor> {
    private Logger logger = LoggerFactory.getLogger(ProjectMajorController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private ProjectMajorService projectMajorService;

    @Autowired
    private SysCodeDetailService sysCodeDetailService;


    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.PROJECT_MAJOR_EDIT));

        return "view/project/projectMajor/grid";
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
            String hql = "from ProjectMajor order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = projectMajorService.findByPage(pageModel, query);

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
        ProjectMajor projectMajor = new ProjectMajor();

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", projectMajor);

        return "view/project/projectMajor/input";
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
        ProjectMajor projectMajor = projectMajorService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", projectMajor);

        return "view/project/projectMajor/input";
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
        ProjectMajor projectMajor = projectMajorService.get(id);

        model.addAttribute("bean", projectMajor);
        return "view/project/projectMajor/view";
    }


    /**
     * 地图页面
     *
     * @param id    .
     * @param model .
     */
    @RequestMapping
    public String map(Model model, Long id, String level) {
        model.addAttribute("level", !StringHelper.isEmpty(level) ? level : "14");
        ProjectMajor pro = projectMajorService.get(id);
        String pos = "";
        String x = "";
        String y = "";

        if (null != pro.getPosX()) {
            x = String.valueOf(pro.getPosX());
        }
        if (null != pro.getPosY()) {
            y = String.valueOf(pro.getPosY());
        }
        pos = "{'name':'" + pro.getProjectName() + "','address':'" + pro.getProjectAdd() + "','x':'" + x + "','y':'" + y + "'}";

        if (pro.getPosX() == null && pro.getPosY() == null) {
            model.addAttribute("queryValue", 3);
        } else if (pro.getPosX() != null && pro.getPosY() != null) {
            model.addAttribute("queryValue", 2);
        } else {
            model.addAttribute("queryValue", 1);
        }
        model.addAttribute("pos", pos);

        model.addAttribute("name", pro.getProjectName());
        model.addAttribute("address", pro.getProjectAdd());
        model.addAttribute("id",id);
        return "view/project/projectMajor/map";
    }
    /**
     * 保存操作
     *
     * @param response .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void saveMap(HttpServletResponse response, Double x, Double y, Long id) throws Exception {
        try {
            ProjectMajor projectMajor = projectMajorService.get(id);
            projectMajor.setPosX(x);
            projectMajor.setPosY(y);
            projectMajorService.save(projectMajor);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") ProjectMajor entity, HttpServletRequest request) throws Exception {
        try {
            ProjectMajor target;
            if (entity.getId() != null) {
                target = projectMajorService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "bjbh",
                        "projectName",
                        "projectAdd",
                        "jsUnitName",
                        "projectTypeDesc",
                        "scheduleDesc"
                });

            } else {
                target = entity;
            }
            //项目类型
            String projectTypeId = request.getParameter("projectType");
            if (!StringHelper.isEmpty(projectTypeId)) {
                SysCodeDetail projectType = sysCodeDetailService.get(Long.valueOf(projectTypeId));
                target.setProjectType(projectType);
                target.setProjectTypeDesc(projectType.getName());
            }
            //当前进度
            String scheduleId = request.getParameter("schedule");
            if (!StringHelper.isEmpty(scheduleId)) {
                SysCodeDetail schedule = sysCodeDetailService.get(Long.valueOf(scheduleId));
                target.setSchedule(schedule);
                target.setScheduleDesc(schedule.getName());
            }
            projectMajorService.save(target);

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
        projectMajorService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}