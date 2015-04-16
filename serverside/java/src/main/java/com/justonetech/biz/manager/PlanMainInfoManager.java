package com.justonetech.biz.manager;

import com.justonetech.biz.domain.*;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.biz.daoservice.PlanDetailService;
import com.justonetech.biz.daoservice.PlanMainInfoService;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * 主要用于监督计划的权限控制及任务执行
 * User: Chen Junping
 * Date: 12-4-19
 */
@Service
public class PlanMainInfoManager {
    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private PlanDetailService planDetailService;

    @Autowired
    private PlanMainInfoService planMainInfoService;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private OaTaskManager oaTaskManager;

    @Autowired
    private PollingRecordManager pollingRecordManager;

    @Autowired
    private MsgMessageManager msgMessageManager;

    @Autowired
    private ProjectManager projectManager;

    /**
     * 获取不同监督计划类型的权限编码
     *
     * @param planType 计划类型
     * @param isAudit  是否审核操作
     * @return 权限编码
     */
    public String getPrivilegeCode(String planType, Boolean isAudit) {
        String privilegeCode = "";
        if (Constants.PLAN_MAIN_INFO_TYPE_SAFE.equals(planType)) {
            privilegeCode = isAudit ? PrivilegeCode.PLAN_MAIN_INFO_SAFE_AUDIT : PrivilegeCode.PLAN_MAIN_INFO_SAFE_EDIT;
        } else if (Constants.PLAN_MAIN_INFO_TYPE_QUALITY.equals(planType)) {
            privilegeCode = isAudit ? PrivilegeCode.PLAN_MAIN_INFO_QUALITY_AUDIT : PrivilegeCode.PLAN_MAIN_INFO_QUALITY_EDIT;
        } else if (Constants.PLAN_MAIN_INFO_TYPE_SPECIAL.equals(planType)) {
            privilegeCode = isAudit ? PrivilegeCode.PLAN_MAIN_INFO_SPECIAL_AUDIT : PrivilegeCode.PLAN_MAIN_INFO_SPECIAL_EDIT;
        } else if (Constants.PLAN_MAIN_INFO_TYPE_ORDER.equals(planType)) {
            privilegeCode = isAudit ? PrivilegeCode.PLAN_MAIN_INFO_ORDER_AUDIT : PrivilegeCode.PLAN_MAIN_INFO_ORDER_EDIT;
        } else if (Constants.PLAN_MAIN_INFO_TYPE_CHECK.equals(planType)) {
            privilegeCode = isAudit ? PrivilegeCode.PLAN_MAIN_INFO_CHECK_AUDIT : PrivilegeCode.PLAN_MAIN_INFO_CHECK_EDIT;
        }
        return privilegeCode;
    }

    /**
     * 权限控制
     *
     * @param model        .
     * @param planMainInfo 主计划
     */
    public void getStatusAttribute(Model model, PlanMainInfo planMainInfo) {
        String statusCode = planMainInfo.getPlanStatus().getCode();
        String typeCode = planMainInfo.getPlanType().getCode();

        String editPrivilegeCode = getPrivilegeCode(typeCode, false);
        String auditPrivilegeCode = getPrivilegeCode(typeCode, true);
        Boolean isPermitEdit = sysUserManager.hasPrivilege(editPrivilegeCode);
        Boolean isPermitAudit = sysUserManager.hasPrivilege(auditPrivilegeCode);
        Boolean isEdit = false;
        Boolean isAudit = false;

        if (isPermitEdit && Constants.PLAN_MAIN_INFO_STATUS_EDIT.equals(statusCode) || Constants.PLAN_MAIN_INFO_STATUS_BACK.equals(statusCode)) {
            isEdit = true;
        }
        if (isPermitAudit && Constants.PLAN_MAIN_INFO_STATUS_SUBMIT.equals(statusCode)) {
            isAudit = true;
            BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
            if (loginUser != null) {
                planMainInfo.setCheckUserName(loginUser.getRealName());
                planMainInfo.setCheckUser(sysUserManager.getSysUser(loginUser.getLoginName()));
            }
            planMainInfo.setCheckDateTime(new Timestamp(System.currentTimeMillis()));
        }
        model.addAttribute("isEdit", isEdit);
        model.addAttribute("isAudit", isAudit);

        //状态
        model.addAttribute("status_edit", sysCodeManager.getCodeDetailByCode(Constants.PLAN_MAIN_INFO_STATUS, Constants.PLAN_MAIN_INFO_STATUS_EDIT).getId());
        model.addAttribute("status_submit", sysCodeManager.getCodeDetailByCode(Constants.PLAN_MAIN_INFO_STATUS, Constants.PLAN_MAIN_INFO_STATUS_SUBMIT).getId());
        model.addAttribute("status_back", sysCodeManager.getCodeDetailByCode(Constants.PLAN_MAIN_INFO_STATUS, Constants.PLAN_MAIN_INFO_STATUS_BACK).getId());
        model.addAttribute("status_pass", sysCodeManager.getCodeDetailByCode(Constants.PLAN_MAIN_INFO_STATUS, Constants.PLAN_MAIN_INFO_STATUS_EXCUTE).getId());

        //审核意见代码
        model.addAttribute("PLAN_MAIN_INFO_OPINION", Constants.PLAN_MAIN_INFO_OPINION);
        model.addAttribute("PLAN_MAIN_INFO_OPINION_OK", sysCodeManager.getCodeDetailByCode(Constants.PLAN_MAIN_INFO_OPINION, Constants.PLAN_MAIN_INFO_OPINION_OK).getId());
        model.addAttribute("PLAN_MAIN_INFO_OPINION_NO", sysCodeManager.getCodeDetailByCode(Constants.PLAN_MAIN_INFO_OPINION, Constants.PLAN_MAIN_INFO_OPINION_NO).getId());
    }

    /**
     * 设置任务的执行状态
     * 回写任务状态（1、列表取消任务；2、填报监督记录表后更新任务状态为已监督）
     *
     * @param planDetailId 计划明细id
     * @param status       设置状态编码
     * @param pollingDate  实际监督日期
     */
    public void setDetailStatus(Long planDetailId, String status, Date pollingDate) {
        PlanDetail target = planDetailService.get(planDetailId);
        target.setStatus(sysCodeManager.getCodeDetailByCode(Constants.PLAN_DETAIL_STATUS, status));
        if (pollingDate != null) {
            target.setPlanActTime(new Timestamp(pollingDate.getTime()));
        } else {
            target.setPlanActTime(null);
        }
        planDetailService.save(target);

        //当所有任务状态：为已监督、已取消时，主计划状态修改为已完成
        Boolean isAllComplete = true;
        PlanMainInfo plan = target.getPlan();
        Set<PlanDetail> details = plan.getPlanDetails();
        for (PlanDetail detail : details) {
            String detailStatus = detail.getStatus().getCode();
            if (!Constants.PLAN_DETAIL_STATUS_CHECKED.equals(detailStatus) && !Constants.PLAN_DETAIL_STATUS_CANCEL.equals(detailStatus)) {
                isAllComplete = false;
                break;
            }
        }
        if (isAllComplete) {
            plan.setPlanStatus(sysCodeManager.getCodeDetailByCode(Constants.PLAN_MAIN_INFO_STATUS, Constants.PLAN_MAIN_INFO_STATUS_COMPLETE));
            planMainInfoService.save(plan);
        }
    }

    /**
     * 获取计划编号
     * 编号规则（年份+4位自动编号）
     *
     * @param planType 计划类型
     * @return 编号
     */
    public String getPlanCode(String planType) {
        Long typeId = sysCodeManager.getCodeDetailByCode(Constants.PLAN_MAIN_INFO_TYPE, planType).getId();
        int codeLen = 4;
        Calendar c = Calendar.getInstance();
        String prefix = c.get(Calendar.YEAR) + "";
        String sql = "select substr(t.plan_code,{0},{1}) as code" +
                " from plan_main_info t where t.plan_code is not null" +
                " and t.plan_code like '{2}-%'" +
                " and t.plan_type={3}" +
                " order by plan_code desc";
        int maxCount = simpleQueryManager.getIntegerBySql(FormatUtils.format(sql, String.valueOf(prefix.length() + 2), String.valueOf(codeLen), prefix, String.valueOf(typeId)));
        return prefix + "-" + com.justonetech.core.utils.StringHelper.getPadCode(codeLen, maxCount + 1);
    }

    /**
     * 创建系统任务
     *
     * @param data .
     * @throws Exception .
     */
    public void createPlanTask(PlanMainInfo data) throws Exception {
        //创建任务
        Set<Long> allUserIds = new HashSet<Long>();

        String temp = "编号为[{0}]的{1}计划需要{2}对项目[{3}]进行监督，请及时填报监督记录";
//        List<PlanDetail> details = planDetailService.findByQuery("from PlanDetail where plan.id=" + data.getId() + " order by id asc");
//        System.out.println("data.getId() = " + data.getId());
        Set<PlanDetail> planDetails = data.getPlanDetails();
            for (PlanDetail detail : planDetails) {
                Set<PlanDetailUser> user = detail.getPlanDetailUsers();
                Set<Long> managers = new HashSet<Long>();
                String names = "";
                if (null != user) {
                    for (PlanDetailUser p : user) {
                        managers.add(p.getUser().getId());
                        if ("".equals(names)) {
                            names += p.getUser().getDisplayName();
                        } else {
                            names += "," + p.getUser().getDisplayName();
                        }
                    }
                }
//            Set<Long> managers = pollingRecordManager.getGroupManagers(group);
                if (managers.size() > 0) {
//                System.out.println("......................detail.getId() = " + detail.getId());
                    String projectName = "";
                    ShareProTobuild project = projectManager.getProject(detail.getBjbh());
                    if (project != null) projectName = project.getProjectName();
                    String taskTitle = FormatUtils.format(temp, data.getPlanCode(), data.getPlanType().getName(), names, projectName);

                    oaTaskManager.createTask(PlanDetail.class.getSimpleName(), detail.getId(), taskTitle, managers, false, null, null);

                    allUserIds.addAll(managers);
                }
            }
//        for (PlanDetail detail : details) {
//            Set<PlanDetailUser> user = detail.getPlanDetailUsers();
//            Set<Long> managers = new HashSet<Long>();
//            String names = "";
//            if (null != user) {
//                for (PlanDetailUser p : user) {
//                    managers.add(p.getUser().getId());
//                    if ("".equals(names)) {
//                        names += p.getUser().getDisplayName();
//                    } else {
//                        names += "," + p.getUser().getDisplayName();
//                    }
//                }
//            }
////            Set<Long> managers = pollingRecordManager.getGroupManagers(group);
//            if (managers.size() > 0) {
////                System.out.println("......................detail.getId() = " + detail.getId());
//                String projectName = "";
//                ShareProTobuild project = projectManager.getProject(detail.getBjbh());
//                if (project != null) projectName = project.getProjectName();
//                String taskTitle = FormatUtils.format(temp, data.getPlanCode(), data.getPlanType().getName(), names, projectName);
//
//                oaTaskManager.createTask(PlanDetail.class.getSimpleName(), detail.getId(), taskTitle, managers, false, null, null);
//
//                allUserIds.addAll(managers);
//            }
//        }

        //发送消息
        if (allUserIds.size() > 0) {
            String[] ids = new String[allUserIds.size()];
            int i = 0;
            for (Long userId : allUserIds) {
                ids[i] = String.valueOf(userId);
                i++;
            }
            SysUser sysUser = sysUserManager.getSysUser();
            String msgTemp = "计划编号{0}的周检查计划，已审批通过，请查阅执行";
            msgMessageManager.sendSmsByUser(FormatUtils.format(msgTemp, data.getPlanCode())+" 提交人：" + sysUser.getDisplayName(), sysUser, ids);
        }

    }
}
