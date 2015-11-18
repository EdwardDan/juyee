package com.justonetech.biz.controller.project;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.ProjExtendScheduleService;
import com.justonetech.biz.daoservice.ProjExtendService;
import com.justonetech.biz.daoservice.ProjInfoService;
import com.justonetech.biz.domain.ProjExtend;
import com.justonetech.biz.domain.ProjExtendSchedule;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.ProjectRelateManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.hibernate.annotations.common.util.StringHelper;
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
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * note:项目建设情况
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class ProjExtendScheduleController extends BaseCRUDActionController<ProjExtendSchedule> {
    private Logger logger = LoggerFactory.getLogger(ProjExtendScheduleController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private ProjectRelateManager projectRelateManager;

    @Autowired
    private ProjInfoService projInfoService;

    @Autowired
    private ProjExtendService projExtendService;

    @Autowired
    private ProjExtendScheduleService projExtendScheduleService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_SAMPLE_EDIT));

        return "view/project/projExtendSchedule/grid";
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
            String hql = "from ProjExtendSchedule order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = projExtendScheduleService.findByPage(pageModel, query);

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
        ProjExtendSchedule projExtendSchedule = new ProjExtendSchedule();

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", projExtendSchedule);

        return "view/project/projExtendSchedule/input";
    }

    /**
     * 修改显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, HttpServletRequest request) {
        String projectId = request.getParameter("projectId");
        ProjExtend projExtend = projectRelateManager.getProjExtend(Long.valueOf(projectId));
        Date date = new Date(System.currentTimeMillis());
        if (null == projExtend) {
            projExtend = new ProjExtend();
            projExtend.setProject(projInfoService.get(Long.valueOf(projectId)));
        }
        if (null == projExtend.getGcjsEndTime()) {
            projExtend.setGcjsEndTime(date);
        }
        if (null == projExtend.getGcjsBeginTime()) {
            projExtend.setGcjsBeginTime(date);
        }
        //处理其他业务逻辑
        model.addAttribute("bean", projExtend);
        projExtendService.save(projExtend);
        List<ProjExtendSchedule> scheduleList = projExtendScheduleService.findByQuery("from ProjExtendSchedule where projExtend.id=" + projExtend.getId() + "  order by year ,month desc");
        if (null != scheduleList && scheduleList.size() > 0) {
            ProjExtendSchedule schedule = scheduleList.iterator().next();
            model.addAttribute("BigYear", schedule.getYear());
            model.addAttribute("BigMonth", schedule.getMonth());
        } else {
            model.addAttribute("BigYear", "0");
            model.addAttribute("BigMonth", "0");
        }
        return "view/project/projExtendSchedule/input";
    }

    /**
     * 查看页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, HttpServletRequest request) {
        String projectId = request.getParameter("projectId");
        ProjExtend projExtend = projectRelateManager.getProjExtend(Long.valueOf(projectId));
        if (null == projExtend) {
            projExtend = new ProjExtend();
            projExtend.setProject(projInfoService.get(Long.valueOf(projectId)));
        }
        //处理其他业务逻辑
        model.addAttribute("bean", projExtend);
        projExtendService.save(projExtend);
        return "view/project/projExtendSchedule/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") ProjExtend entity, HttpServletRequest request) throws Exception {
        try {
            ProjExtend target;
            if (entity.getId() != null) {
                target = projExtendService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "gcjsIsBigin",
                        "gcjsBeginTime",
                        "gcjsIsEnd",
                        "gcjsEndTime"
                });
            } else {
                target = entity;
            }
            projExtendService.save(target);
            Set<ProjExtendSchedule> projExtendSchedules = target.getProjExtendSchedules();
            List<ProjExtendSchedule> schedules = new ArrayList<ProjExtendSchedule>(projExtendSchedules);
            projExtendScheduleService.batchDelete(schedules, schedules.size());
            String[] year = request.getParameterValues("yearSch");
            String[] month = request.getParameterValues("monthSch");
            String[] titles = request.getParameterValues("titleSch");
            String[] projProgresses = request.getParameterValues("projProgress");
            String[] questions = request.getParameterValues("question");
            String[] improveOpinions = request.getParameterValues("improveOpinion");
            String[] descriptions = request.getParameterValues("description");
            if (null != titles && titles.length != 0) {
                for (int i = 0; !StringHelper.isEmpty(titles[i]) && i < titles.length; i++) {
                    ProjExtendSchedule schedule = new ProjExtendSchedule();
                    if (!StringHelper.isEmpty(year[i])) {
                        schedule.setYear(Integer.valueOf(year[i]));
                    }
                    if (!StringHelper.isEmpty(month[i])) {
                        schedule.setMonth(Integer.valueOf(month[i]));
                    }
                    if (!StringHelper.isEmpty(titles[i])) {
                        schedule.setTitle(titles[i]);
                    }
                    if (!StringHelper.isEmpty(projProgresses[i])) {
                        schedule.setProjProgress(projProgresses[i]);
                    }
                    if (!StringHelper.isEmpty(questions[i])) {
                        schedule.setQuestion(questions[i]);
                    }
                    if (!StringHelper.isEmpty(improveOpinions[i])) {
                        schedule.setImproveOpinion(improveOpinions[i]);
                    }
                    if (!StringHelper.isEmpty(descriptions[i])) {
                        schedule.setDescription(descriptions[i]);
                    }
                    schedule.setProjExtend(target);
                    projExtendScheduleService.save(schedule);
                }
            }

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
        projExtendScheduleService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}