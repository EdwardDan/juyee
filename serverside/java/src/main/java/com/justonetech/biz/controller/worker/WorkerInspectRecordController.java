package com.justonetech.biz.controller.worker;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.WorkerInspectRecordService;
import com.justonetech.biz.domain.ShareProTobuild;
import com.justonetech.biz.domain.WorkerInspectRecord;
import com.justonetech.biz.manager.ProjectManager;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * note:现场检查记录
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class WorkerInspectRecordController extends BaseCRUDActionController<WorkerInspectRecord> {
    private Logger logger = LoggerFactory.getLogger(WorkerInspectRecordController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private WorkerInspectRecordService workerInspectRecordService;

    @Autowired
    private ProjectManager projectManager;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
//      model.addAttribute("canEdit",sysUserManager.hasPrivilege(PrivilegeCode.WORKER_INSPECT_RECORD_EDIT));
        model.addAttribute("canEdit", true);

        return "view/worker/workerInspectRecord/grid";
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
            String hql = "from WorkerInspectRecord order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = workerInspectRecordService.findByPage(pageModel, queryTranslate.toString());

            List<Map> list = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : list) {
                Object id = bean.get("id");
                if (null != id) {
                    WorkerInspectRecord workerInspectRecord = workerInspectRecordService.get(JspHelper.getLong(id));
                    bean.put("checkTime", workerInspectRecord.getCheckDate() + "&nbsp&nbsp&nbsp" + workerInspectRecord.getStartTime() + "~" + workerInspectRecord.getEndTime());
                    ShareProTobuild shareProTobuild = projectManager.getProject(workerInspectRecord.getBjbh());
                    bean.put("projectName",shareProTobuild.getProjectName());
                }
            }

            //输出显示
            String json = GridJq.toJSON(list, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }
    /**
     * 通过bjbh编号获取工程信息
     *
     * @param bjbh  .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String getProjectInfo(String bjbh, Model model) {
        Map<String, Object> map = projectManager.getProjectInfo(bjbh);
        ShareProTobuild shareProTobuild = (ShareProTobuild) map.get("data");
        Map<String, String> listMap = new HashMap<String, String>();
        listMap.put("buildAddress",shareProTobuild.getBuildAddress()); //建设地址
        listMap.put("faren",shareProTobuild.getBuildUnitLegal());  //建设单位法人
        listMap.put("tel",shareProTobuild.getBuildUnitTel());  //电话

        String string = JSONObject.fromObject(listMap).toString();
        model.addAttribute("msg", string);

        return "common/msg";

    }

    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        WorkerInspectRecord workerInspectRecord = new WorkerInspectRecord();
        //默认信息
        workerInspectRecord.setCheckDate(new Date(System.currentTimeMillis())); //默认当前日期
//        workerInspectRecord.setCheckPerson(sysUserManager.getSysUser().getDisplayName()); //默认当前登录用户名
        //默认当前登录用户名
        SysUser sysUser = sysUserManager.getSysUser();
        workerInspectRecord.setCheckPerson(sysUser.getDisplayName());

        //如需增加其他默认值请在此添加
        //设置起始时间
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String beginHourSelectOptions = DateTimeHelper.getHourSelectOptions(JspHelper.getString(timestamp.getHours()));
        String beginMinuteSelectOptions = DateTimeHelper.getMinuteSelectOptions(JspHelper.getString(timestamp.getMinutes()));
        String endHourSelectOptions = DateTimeHelper.getHourSelectOptions(JspHelper.getString(timestamp.getHours()));
        String endMinuteSelectOptions = DateTimeHelper.getMinuteSelectOptions(JspHelper.getString(timestamp.getMinutes()));
        model.addAttribute("beginHourSelectOptions", beginHourSelectOptions);
        model.addAttribute("beginMinuteSelectOptions", beginMinuteSelectOptions);
        model.addAttribute("endHourSelectOptions", endHourSelectOptions);
        model.addAttribute("endMinuteSelectOptions", endMinuteSelectOptions);
        model.addAttribute("bean", workerInspectRecord);

        return "view/worker/workerInspectRecord/input";
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
        WorkerInspectRecord workerInspectRecord = workerInspectRecordService.get(id);

        //处理其他业务逻辑
        //检查起止时间
        String useStartTime = workerInspectRecord.getStartTime();
        String useEndTime = workerInspectRecord.getEndTime();
        String[] startTime = StringHelper.split(useStartTime,":");
        String[] endTime = StringHelper.split(useEndTime,":");

        String beginHourSelectOptions = DateTimeHelper.getHourSelectOptions(startTime[0]);
        String beginMinuteSelectOptions = DateTimeHelper.getMinuteSelectOptions(startTime[1]);
        String endHourSelectOptions = DateTimeHelper.getHourSelectOptions(endTime[0]);
        String endMinuteSelectOptions = DateTimeHelper.getMinuteSelectOptions(endTime[1]);

        //起止时间选择
        model.addAttribute("beginHourSelectOptions", beginHourSelectOptions);
        model.addAttribute("beginMinuteSelectOptions", beginMinuteSelectOptions);
        model.addAttribute("endHourSelectOptions", endHourSelectOptions);
        model.addAttribute("endMinuteSelectOptions", endMinuteSelectOptions);
        model.addAttribute("bean", workerInspectRecord);

        return "view/worker/workerInspectRecord/input";
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
        WorkerInspectRecord workerInspectRecord = workerInspectRecordService.get(id);

        model.addAttribute("bean", workerInspectRecord);
        return "view/worker/workerInspectRecord/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") WorkerInspectRecord entity, HttpServletRequest request) throws Exception {
        try {
            WorkerInspectRecord target;
            if (entity.getId() != null) {
                target = workerInspectRecordService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "bjbh",
                        "checkAddress",
                        "checkDate",
                        "startTime",
                        "endTime",
                        "currentPerson",
                        "address",
                        "fr",
                        "tel",
                        "checkPerson",
                        "recordPerson",
                        "checkContent",
                        "isFromAndroid"
                });

            } else {
                target = entity;
            }
            //保存检查起止时间
            String beginHour = request.getParameter("beginHour");
            String beginMinute = request.getParameter("beginMinute");
            String startTime = JspHelper.getString(beginHour+":"+beginMinute);
            target.setStartTime(startTime);
            String endHour = request.getParameter("endHour");
            String endMinute = request.getParameter("endMinute");
            String endTime = JspHelper.getString(endHour+":"+endMinute);
            target.setEndTime(endTime);
            workerInspectRecordService.save(target);

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
        workerInspectRecordService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}