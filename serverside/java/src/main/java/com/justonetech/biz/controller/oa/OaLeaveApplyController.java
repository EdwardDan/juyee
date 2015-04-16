package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.OaFgldSetService;
import com.justonetech.biz.daoservice.OaLeaveApplyService;
import com.justonetech.biz.domain.OaLeaveApply;
import com.justonetech.biz.manager.MsgMessageManager;
import com.justonetech.biz.manager.OaFgldManager;
import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.OaLeaveApplyStatus;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysDept;
import com.justonetech.system.domain.SysPerson;
import com.justonetech.system.domain.SysPersonDept;
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

import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * note:请假单管理
 * author: 黄国荣
 * create date:
 * modify date:2014-04-22
 */
@Controller
public class OaLeaveApplyController extends BaseCRUDActionController<OaLeaveApply> {
    private Logger logger = LoggerFactory.getLogger(OaLeaveApplyController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private OaLeaveApplyService oaLeaveApplyService;

    @Autowired
    private OaFgldManager oaFgldManager;


    @Autowired
    private OaTaskManager oaTaskManager;

    @Autowired
    private OaFgldSetService oaFgldSetService;

    @Autowired
    private MsgMessageManager msgMessageManager;

    @Autowired
    private SysUserService sysUserService;


    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_LEAVEAPPLY_EDIT));//请假申请_编辑
        model.addAttribute("canLeaderAudit", sysUserManager.hasPrivilege(PrivilegeCode.OA_LEAVEAPPLY_LEADER_AUDIT));  //请假申请_领导审核
        //删除权限
        model.addAttribute("canDelete", sysUserManager.hasPrivilege(PrivilegeCode.OA_LEAVEAPPLY_DELETE));
        //当前用户名
        model.addAttribute("currentUser", sysUserManager.getSysUser().getLoginName());

        setOaLeaveApplyStatus(model);
        return "view/oa/oaLeaveApply/grid";
    }

    /**
     * 编辑审核权限状态
     *
     * @param model .
     */
    private void setOaLeaveApplyStatus(Model model) {

        // 正在填写
        model.addAttribute("STATUS_EDIT", OaLeaveApplyStatus.STATUS_EDIT.getCode());
        // 提交领导审核
        model.addAttribute("STATUS_SUBMIT", OaLeaveApplyStatus.STATUS_SUBMIT.getCode());
        // 领导退回
        model.addAttribute("STATUS_BACK_LEADER", OaLeaveApplyStatus.STATUS_BACK_LEADER.getCode());
        // 审核通过
        model.addAttribute("STATUS_PASS", OaLeaveApplyStatus.STATUS_PASS.getCode());

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
            SysUser sysUser = sysUserManager.getSysUser();
            SysPerson person = sysUser.getPerson();
            SysPersonDept sysPersonDept = person.getPersonDept();
            String position = JspHelper.getString(sysPersonDept.getPosition());
            //查看所有人的权限
            Boolean viewAll = sysUserManager.hasPrivilege(PrivilegeCode.OA_LEAVEAPPLY_VIEWALL);
            // 分管领导
            String hql = "from OaLeaveApply where 1=1 ";
            if (!Constants.SYS_TOP_LEADER_NAME.equals(position) && !viewAll) {
                hql += " and (1=2 ";
                String[] personAndDepts = oaFgldManager.getManagerPersonAndDepts(sysUser);
                String deptNames = personAndDepts[0];
                String personNames = personAndDepts[1];
                if (!StringHelper.isEmpty(deptNames) || !StringHelper.isEmpty(personNames)) {
                    if (!StringHelper.isEmpty(deptNames)) {
                        hql += " or reportDept in('" + StringHelper.findAndReplace(deptNames, ",", "','") + "')";     //负责的分管部门
                    }
                    if (!StringHelper.isEmpty(personNames)) {
                        hql += " or reportPerson in('" + StringHelper.findAndReplace(personNames, ",", "','") + "')";  //负责的分管领导
                    }
                }
                hql += " or reportPerson='" + person.getName() + "'";   //自己的也要看
                hql += " or leaderAuditUser='" + sysUser.getLoginName() + "'";   //审核的记录
                hql += ")";
            }
            hql += " order by id desc";

//            // 主任查看全部数据
//            if (!"主任".equals(sysPersonDept.getPosition())) {
//                // 科长
//                if ("科长".equals(sysPersonDept.getPosition())) {
//                    String hql2 = "select  s.name" +
//                            "  from Sys_Person_Dept t " +
//                            " left join Sys_dept d on d.id=t.dept_id " +
//                            " left join sys_person s on s.id=t.person_id  " +
//                            "  where t.dept_id='" + dept.getId() + "' ";
//                    List list = oaLeaveApplyService.findBySql(hql2);
//                    String displayNames = "";
//                    for (Object o : list) {
//                        displayNames += ",'" + String.valueOf(o) + "'";
//                    }
//                    if (displayNames.length() > 0) displayNames = displayNames.substring(1);
//                    hql += " and ( reportPerson in (" + displayNames + ") or ";
//                    //  分管领导
//                } else if (null != auditUser && auditUser.getId().equals(sysUser.getId())) {
//                    List<OaFgldSet> oaFgldSet = oaFgldSetService.findByQuery(" from OaFgldSet where user.id=" + sysUser.getId());
//                    if (null != oaFgldSet && oaFgldSet.size() > 0) {
//                        Set<OaFgldSetItem> oaFgldSetItems = oaFgldSet.iterator().next().getOaFgldSetItems();
//                        String fgDept = "";
//                        for (OaFgldSetItem oaFgldSetItem : oaFgldSetItems) {
//                            if (null != oaFgldSetItem.getDept().getName()) {
//                                fgDept += "," + oaFgldSetItem.getDept().getId();
//                            }
//                        }
//                        if (fgDept.length() > 0) fgDept = fgDept.substring(1);
//
//                        String hql2 = "select s.name  " +
//                                "  from Sys_Person_Dept t " +
//                                " left join sys_person s on s.id=t.person_id  " +
//                                " left join Sys_dept d on d.id=t.dept_id" +
//                                "  where t.dept_id in (" + fgDept + ") ";
//                        List list = oaLeaveApplyService.findBySql(hql2);
//                        String displayNames = "";
//                        for (Object o : list) {
//                            displayNames += ",'" + String.valueOf(o) + "'";
//                        }
//                        if (displayNames.length() > 0) displayNames = displayNames.substring(1);
//                        hql += " and ( reportPerson in (" + displayNames + ") or ";
//                    }
//                    // 非领导级别
//                } else {
//                    hql += " and (";
//                }
//                // 主任查看全部数据
//            } else {
//                hql += " and (1=1 or ";
//            }
//            hql += "  reportPerson = '" + sysUser.getDisplayName() + "') order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = oaLeaveApplyService.findByPage(pageModel, queryTranslate.toString());

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
        OaLeaveApply oaLeaveApply = new OaLeaveApply();
        //默认申请人为当前用户
        SysUser sysUser = sysUserManager.getSysUser();
        oaLeaveApply.setReportPerson(sysUser.getDisplayName());
        //获取登录人的部门
        SysDept dept = sysUser.getPerson().getDept();
        oaLeaveApply.setReportDept(dept.getName());
        oaLeaveApply.setReportDate(new Date(System.currentTimeMillis()));
        oaLeaveApply.setStatus(OaLeaveApplyStatus.STATUS_EDIT.getCode());
        oaLeaveApply.setIsSendSms(true);
        //如需增加其他默认值请在此添加
        model.addAttribute("bean", oaLeaveApply);
        setOaLeaveApplyStatus(model);
        return "view/oa/oaLeaveApply/input";
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
        OaLeaveApply oaLeaveApply = oaLeaveApplyService.get(id);
        //处理其他业务逻辑
        model.addAttribute("bean", oaLeaveApply);
        setOaLeaveApplyStatus(model);
        return "view/oa/oaLeaveApply/input";
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
        OaLeaveApply oaLeaveApply = oaLeaveApplyService.get(id);
        model.addAttribute("bean", oaLeaveApply);
        return "view/oa/oaLeaveApply/view";
    }


    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param status   .
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaLeaveApply entity, String status) throws Exception {
        String msg = "保存成功";
        try {
            OaLeaveApply target;
            if (entity.getId() != null) {
                target = oaLeaveApplyService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "reportPerson",
                        "reportDept",
                        "reportDate",
                        "duty",
                        "durationTime",
                        "dayCount",
                        "cause",
                        "isSendSms",
                        "smsTimearea"
                });

            } else {
                target = entity;
            }
            target.setStatus(Integer.valueOf(status));

            if (target.getStatus() == OaLeaveApplyStatus.STATUS_SUBMIT.getCode()) {

                //建管署主任自己不需审核
                SysUser sysUser1 = sysUserManager.getSysUser();
                if (Constants.SYS_TOP_LEADER_NAME.equals(sysUser1.getPerson().getPersonDept().getPosition())) {
                    target.setLeaderAuditUser(sysUser1.getLoginName());
                    target.setStatus(OaLeaveApplyStatus.STATUS_PASS.getCode());

                } else {

                    Double dayCount = target.getDayCount();
                    if (target.getReportDept().contains("办公室")) {  //办公室
                        if (dayCount <= 1) {
                            //1天和1天以下由办公室主任审核
                            SysUser auditUser = oaFgldManager.getAuditUserId(target.getReportDept(), null);
                            if (auditUser != null) {
                                target.setLeaderAuditUser(auditUser.getLoginName());
                            }

                        } else {  //1天以上的由主任费克审核
                            String leaderAuditUser = oaFgldManager.getTopLeader();
                            target.setLeaderAuditUser(leaderAuditUser);   //领导审核用户名设置
                        }

                    } else if (target.getReportDept().contains("领导层")) {
                        String leaderAuditUser = oaFgldManager.getTopLeader();
                        target.setLeaderAuditUser(leaderAuditUser);
                    } else {    //其他部门
                        if (dayCount <= 1) {
                            //1天以内由科长审核
                            SysUser sysUser = sysUserManager.getSysUserByDisplayName(target.getReportPerson());
                            SysUser auditUser = oaFgldManager.getAuditUserId(target.getReportDept(), null);
                            //科长不能审核自己的申请
                            if (sysUser != null) {
                                String deptLeader = oaFgldManager.getDeptLeader(sysUser.getLoginName());
                                if (null != deptLeader && !deptLeader.equals(sysUser.getLoginName())) {
                                    target.setLeaderAuditUser(deptLeader);
                                } else {
                                    if (auditUser != null) {
                                        target.setLeaderAuditUser(auditUser.getLoginName()); //分管领导用户名
                                    }
                                }
                            }

                        } else if (dayCount > 1 && dayCount < 3) {
                            //1.5、2、2.5由分管领导审核
                            //获取审核该部门的分管领导姓名
                            SysUser auditUser = oaFgldManager.getAuditUserId(target.getReportDept(), null);
                            if (auditUser != null) {
                                target.setLeaderAuditUser(auditUser.getLoginName()); //分管领导用户名
                            }

                        } else if (dayCount >= 3) {
                            //3天以上由主任审核
                            String leaderAuditUser = oaFgldManager.getTopLeader();
                            target.setLeaderAuditUser(leaderAuditUser);   //领导审核用户名设置
                        }
                    }
                    if (target.getLeaderAuditUser() == null) {
                        msg = "提交失败！未找到审核人员，请检查设置！";
                        target.setStatus(OaLeaveApplyStatus.STATUS_EDIT.getCode());
                    }
                }
            }
            target.setSmsContent("<span style=\"color: #0000ff;\">"+target.getReportPerson() + "</span> 在 " + target.getSmsTimearea() + " 已 请 假 ，不 用 准 备 午 餐");
            oaLeaveApplyService.save(target);

            if (target.getStatus() != OaLeaveApplyStatus.STATUS_EDIT.getCode()) {//创建待办事项
                createOaTask(target);
            }

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, msg);
    }

    /**
     * 创建系统任务
     *
     * @param data .
     * @throws Exception .
     */
    public void createOaTask(OaLeaveApply data) throws Exception {
        int status = data.getStatus();
        //创建任务
        Set<Long> managers = new HashSet<Long>();
        if (OaLeaveApplyStatus.STATUS_SUBMIT.getCode() == status) {
            String title = oaTaskManager.getTaskTitle(data, OaLeaveApply.class.getSimpleName());
            String leaderAuditUser = data.getLeaderAuditUser();
            if (!StringHelper.isEmpty(leaderAuditUser)) {
                SysUser sysUser = sysUserManager.getSysUser(leaderAuditUser);
                if (sysUser != null && !StringHelper.isEmpty(title)) {
                    managers.add(sysUser.getId());
                    oaTaskManager.createTask(OaLeaveApply.class.getSimpleName(), data.getId(), title, managers, false, null, null);
                }
            }
        } else if (status == OaLeaveApplyStatus.STATUS_PASS.getCode() || status == OaLeaveApplyStatus.STATUS_BACK_LEADER.getCode()) {
            //仅发送短信
            SysUser receiveUser = sysUserManager.getSysUserByDisplayName(data.getReportPerson());
            String[] ids = new String[1];
            if (null != receiveUser) {
                ids[0] = String.valueOf(receiveUser.getId());
                String msgTemp = oaTaskManager.getTaskTitle(data, OaLeaveApply.class.getSimpleName() + "_Pass");
                if (status == OaLeaveApplyStatus.STATUS_BACK_LEADER.getCode()) {
                    msgTemp = oaTaskManager.getTaskTitle(data, OaLeaveApply.class.getSimpleName() + "_Back");
                }
                msgMessageManager.sendSmsByUser(msgTemp, sysUserManager.getSysUser(), ids);
            }

            //移除任务
            oaTaskManager.removeTask(OaLeaveApply.class.getSimpleName(), data.getId());
        }
    }


    /**
     * 审核保存操作
     *
     * @param response .
     * @param entity   .
     * @param status   .
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void auditSave(HttpServletResponse response, @ModelAttribute("bean") OaLeaveApply entity, String status) throws Exception {
        try {
            OaLeaveApply target;
            if (entity.getId() != null) {
                target = oaLeaveApplyService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "reportPerson",
                        "reportDept",
                        "reportDate",
                        "duty",
                        "durationTime",
                        "dayCount",
                        "cause",
                        "leaderOpinion",
                        "leaderAuditTime",
                        "smsTimearea",
                        "smsContent",
                        "isSendSms"
                });

            } else {
                target = entity;
            }
            target.setStatus(Integer.valueOf(status));
            oaLeaveApplyService.save(target);
            //发送食堂负责人短信
            List<SysUser> noticeUsers = sysUserManager.getUsersByPrivilegeCode(PrivilegeCode.OA_LEAVEAPPLY_NOTICE);
            if (noticeUsers.size() > 0) {
                if (target.getIsSendSms()) {
                    for (SysUser sysUser : noticeUsers) {
                        String mobile = sysUser.getPerson().getMobile();
                        if (StringHelper.isNotEmpty(mobile)) {
                            msgMessageManager.sendSms(target.getSmsContent(),mobile);
                        }
                    }
                    msgMessageManager.sendSms("", "");
                }
            }


            //创建待办事项
            createOaTask(target);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
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
        OaLeaveApply oaLeaveApply = oaLeaveApplyService.get(id);
        //设置审核时间为当前时间
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if (oaLeaveApply.getStatus() == OaLeaveApplyStatus.STATUS_SUBMIT.getCode())
            oaLeaveApply.setLeaderAuditTime(timestamp);
        //处理其他业务逻辑
        model.addAttribute("bean", oaLeaveApply);
        setOaLeaveApplyStatus(model);
        return "view/oa/oaLeaveApply/audit";
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
        oaLeaveApplyService.delete(id);
        oaTaskManager.removeTask(OaLeaveApply.class.getSimpleName(), id);//删除任务

        sendSuccessJSON(response, "删除成功");
    }

}