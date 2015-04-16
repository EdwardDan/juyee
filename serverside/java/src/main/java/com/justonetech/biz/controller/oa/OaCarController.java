package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.OaCarService;
import com.justonetech.biz.domain.OaCar;
import com.justonetech.biz.manager.MsgMessageManager;
import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.OaCarApplyStatus;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysPersonManager;
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
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * note:车辆管理
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class OaCarController extends BaseCRUDActionController<OaCar> {
    private Logger logger = LoggerFactory.getLogger(OaCarController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private OaCarService oaCarService;

    @Autowired
    private OaTaskManager oaTaskManager;

    @Autowired
    private MsgMessageManager msgMessageManager;

    @Autowired
    private SysPersonManager sysPersonManager;


    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {

        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_CAR_EDIT));  //判断是否有编辑权限
        model.addAttribute("canAudit", sysUserManager.hasPrivilege(PrivilegeCode.OA_CAR_AUDIT));  //删除权限
        model.addAttribute("canDelete", sysUserManager.hasPrivilege(PrivilegeCode.OA_CAR_DELETE));//车辆管理-强制删除权限
        model.addAttribute("currentUser", sysUserManager.getSysUser().getLoginName());//当前用户名
        pushStaticValueToPage(model);
        return "view/oa/oaCar/grid";
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
            String hql = "from OaCar order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = oaCarService.findByPage(pageModel, queryTranslate.toString());

            List<Map> list = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : list) {
                Object id = bean.get("id");
                if (null != id) {
                    OaCar oacar = oaCarService.get(JspHelper.getLong(id));
                    if (null != oacar.getStatus()) {
                        bean.put("statusName", OaCarApplyStatus.getColorNameByCode(oacar.getStatus()));
                    }
                    bean.put("useTime", oacar.getUseBeginTime() + "~" + oacar.getUseEndTime());
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
     * 各种状态的编码
     *
     * @param model .
     */
    private void pushStaticValueToPage(Model model) {

        model.addAttribute("STATUS_EDIT", OaCarApplyStatus.STATUS_EDIT.getCode()); //填写
        model.addAttribute("STATUS_SUBMIT", OaCarApplyStatus.STATUS_SUBMIT.getCode()); //提交
        model.addAttribute("STATUS_BACK", OaCarApplyStatus.STATUS_BACK.getCode()); //退回修改
        model.addAttribute("STATUS_PASS", OaCarApplyStatus.STATUS_PASS.getCode()); //审核通过

    }

    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        OaCar oaCar = new OaCar();

        String applyPerson = sysUserManager.getSysUser().getDisplayName();//当前登录用户名
        String applyDept = sysUserManager.getSysUser().getPerson().getDept().getName();//当前登录用户的部门名称

        oaCar.setApplyPerson(applyPerson); //默认申请人
        oaCar.setApplyDept(applyDept); //默认申请部门
        oaCar.setUseDate(new Date(System.currentTimeMillis())); //默认申请日期
        model.addAttribute("carNo", Constants.OA_CAR_NO); //车牌号
        oaCar.setStatus(OaCarApplyStatus.STATUS_EDIT.getCode()); //设置当前状态
        oaCar.setIsArrangeDriver(false);  //设置是否拟派司机

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

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", oaCar);
        pushStaticValueToPage(model);
        return "view/oa/oaCar/input";
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
        OaCar oaCar = oaCarService.get(id);
        model.addAttribute("carNo", Constants.OA_CAR_NO); //车牌号
        //处理其他业务逻辑
        //起止时间
        String useBeginTime = oaCar.getUseBeginTime();
        String useEndTime = oaCar.getUseEndTime();
        String[] beginTime = StringHelper.split(useBeginTime, ":");
        String[] endTime = StringHelper.split(useEndTime, ":");

        String beginHourSelectOptions = DateTimeHelper.getHourSelectOptions(beginTime[0]);
        String beginMinuteSelectOptions = DateTimeHelper.getMinuteSelectOptions(beginTime[1]);
        String endHourSelectOptions = DateTimeHelper.getHourSelectOptions(endTime[0]);
        String endMinuteSelectOptions = DateTimeHelper.getMinuteSelectOptions(endTime[1]);
        //起止时间选择
        model.addAttribute("beginHourSelectOptions", beginHourSelectOptions);
        model.addAttribute("beginMinuteSelectOptions", beginMinuteSelectOptions);
        model.addAttribute("endHourSelectOptions", endHourSelectOptions);
        model.addAttribute("endMinuteSelectOptions", endMinuteSelectOptions);

        model.addAttribute("bean", oaCar);
        pushStaticValueToPage(model);
        return "view/oa/oaCar/input";
    }

    /**
     * 审核页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String audit(Model model, Long id) {
        OaCar oaCar = oaCarService.get(id);
        model.addAttribute("carNo", Constants.OA_CAR_NO); //车牌号
        //处理其他业务逻辑
        oaCar.setDriverName("王德发");   //默认司机
        oaCar.setDriverTel("13042158289");   //默认司机
        oaCar.setAuditOpinion("同意");
        //起止时间
        String useBeginTime = oaCar.getUseBeginTime();
        String useEndTime = oaCar.getUseEndTime();
        String[] beginTime = StringHelper.split(useBeginTime, ":");
        String[] endTime = StringHelper.split(useEndTime, ":");

        String beginHourSelectOptions = DateTimeHelper.getHourSelectOptions(beginTime[0]);
        String beginMinuteSelectOptions = DateTimeHelper.getMinuteSelectOptions(beginTime[1]);
        String endHourSelectOptions = DateTimeHelper.getHourSelectOptions(endTime[0]);
        String endMinuteSelectOptions = DateTimeHelper.getMinuteSelectOptions(endTime[1]);
        //起止时间选择
        model.addAttribute("beginHourSelectOptions", beginHourSelectOptions);
        model.addAttribute("beginMinuteSelectOptions", beginMinuteSelectOptions);
        model.addAttribute("endHourSelectOptions", endHourSelectOptions);
        model.addAttribute("endMinuteSelectOptions", endMinuteSelectOptions);

        model.addAttribute("bean", oaCar);
        pushStaticValueToPage(model);
        return "view/oa/oaCar/audit";
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
        OaCar oaCar = oaCarService.get(id);
        pushStaticValueToPage(model);
        model.addAttribute("bean", oaCar);
        return "view/oa/oaCar/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaCar entity, HttpServletRequest request, Integer status) throws Exception {
        try {
            OaCar target;
            if (entity.getId() != null) {
                target = oaCarService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "applyDept",
                        "applyPerson",
                        "useReason",
                        "useDate",
                        "useBeginTime",
                        "useEndTime",
                        "arrivalPlace",
                        "auditOpinion",
                        "auditTime",
                        "auditUser",
                        "personNum",
                        "description",
                        "status",
                        "carNo",
                        "isArrangeDriver",
                        "driverName",
                        "driverTel"
                });

            } else {
                target = entity;
            }
            if (target.getStatus() != OaCarApplyStatus.STATUS_PASS.getCode()) {
                target.setCarNo(null);
            }

            //保存用车起止时间
            String beginHour = request.getParameter("beginHour");
            String beginMinute = request.getParameter("beginMinute");
            target.setUseBeginTime(beginHour + ":" + beginMinute);
            String endHour = request.getParameter("endHour");
            String endMinute = request.getParameter("endMinute");
            target.setUseEndTime(endHour + ":" + endMinute);

            //保存申请状态
            target.setStatus(status);
            oaCarService.save(target);

            //创建待办事项
            if (target.getStatus() != OaCarApplyStatus.STATUS_EDIT.getCode()) {
                createOaTask(target);
            }

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 创建系统任务
     *
     * @param data .
     * @throws Exception .
     */
    public void createOaTask(OaCar data) throws Exception {
        //创建任务
        int Status = data.getStatus();
        if (Status == OaCarApplyStatus.STATUS_SUBMIT.getCode()) {

            String privilegeCode = PrivilegeCode.OA_CAR_AUDIT;
            String title = oaTaskManager.getTaskTitle(data, OaCar.class.getSimpleName());
            Set<Long> managers = sysUserManager.getUserIdsByPrivilegeCode(privilegeCode);
            if (managers.size() > 0 && !StringHelper.isEmpty(title)) {
                oaTaskManager.createTask(OaCar.class.getSimpleName(), data.getId(), title, managers, false, null, null);
            }

        }else if (Status == OaCarApplyStatus.STATUS_PASS.getCode() || Status == OaCarApplyStatus.STATUS_BACK.getCode()) {
            String msgTemp = oaTaskManager.getTaskTitle(data, OaCar.class.getSimpleName() + "_Pass");
            if (Status == OaCarApplyStatus.STATUS_BACK.getCode()) {
                msgTemp = oaTaskManager.getTaskTitle(data, OaCar.class.getSimpleName() + "_Back");
            }
            SysUser receiveUser = sysUserManager.getSysUserByDisplayName(data.getApplyPerson());
            if (null != receiveUser && !StringHelper.isEmpty(msgTemp)) {
                String[] ids = new String[1];
                ids[0] = String.valueOf(receiveUser.getId());
                msgMessageManager.sendSmsByUser(msgTemp, sysUserManager.getSysUser(), ids);
            }

            //移除任务
            oaTaskManager.removeTask(OaCar.class.getSimpleName(), data.getId());
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

        oaCarService.delete(id);

        oaTaskManager.removeTask(OaCar.class.getSimpleName(), id);//删除任务

        sendSuccessJSON(response, "删除成功");
    }
}