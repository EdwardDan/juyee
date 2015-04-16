package com.justonetech.system.utils;

import com.justonetech.biz.domain.*;
import com.justonetech.system.domain.*;

/**
 * 权限编码定义
 * User: Chen Junping
 * Date: 12-3-16
 */
public class PrivilegeCode {
    /**
     * ***************************************系统管理******************************************************
     */
    public static final String SYS_SAMPLE_EDIT = Sample.class.getSimpleName() + "_edit";     //样例_编辑
    public static final String SYS_DEPT_EDIT = SysDept.class.getSimpleName() + "_edit";     //单位部门_编辑
    public static final String SYS_PERSON_EDIT = SysPerson.class.getSimpleName() + "_edit"; //人员_编辑
    public static final String SYS_REGPERSON_EDIT = SysRegPerson.class.getSimpleName() + "_edit"; //注册账号管理_编辑
    public static final String SYS_USER_EDIT = SysUser.class.getSimpleName() + "_edit";      //用户_编辑
    public static final String SYS_ROLE_EDIT = SysRole.class.getSimpleName() + "_edit";      //角色_编辑
    public static final String SYS_PRIVILEGE_EDIT = SysPrivilege.class.getSimpleName() + "_edit";  //权限_编辑
    public static final String SYS_MENU_EDIT = SysMenu.class.getSimpleName() + "_edit";             //菜单_编辑
    public static final String SYS_LOG_EDIT = SysLog.class.getSimpleName() + "_edit";               //日志_编辑
    public static final String SYS_CODE_EDIT = SysCode.class.getSimpleName() + "_edit";//系统字典_编辑
    public static final String SYS_PROBLEM_EDIT = PollingDict.class.getSimpleName() + "_edit";       //问题字典_编辑
    public static final String SYS_TASKTYPE_EDIT = OaTaskType.class.getSimpleName() + "_edit";       //系统任务_编辑
    public static final String SYS_TASK_VIEW_ALL = OaTask.class.getSimpleName() + "_viewAll"; //查看所有任务
    public static final String CONFIG_TABLE_EDIT = ConfigTable.class.getSimpleName() + "_edit"; //表操作日志设置
    public static final String SYS_OPERATION_TABLE_LOG_EDIT = SysOperationTableLog.class.getSimpleName() + "_edit"; //表操作日志查看

    public static final String SYS_PUSH_DEFINE_EDIT = SysPushDefine.class.getSimpleName() + "_edit"; //系统首页推送定义
    public static final String SYS_CUSTOM_GRID_EDIT = SysCustomGrid.class.getSimpleName() + "_edit"; //系统首页板块设置
    public static final String SYS_OAFGLDSET_EDIT = OaFgldSet.class.getSimpleName() + "_edit";//分管领导审批设置

    public static final String SYS_SKIN_EDIT = SysSkin.class.getSimpleName() + "_edit"; //系统皮肤设置
    public static final String SYS_PARAMETER_EDIT = SysParameter.class.getSimpleName() + "_edit";//系统参数维护

    /**
     * ***************************************协同办公******************************************************
     */
    public static final String OA_PUBLIC_INFO_EDIT = OaPublicInfo.class.getSimpleName() + "_edit";  //公共信息发布_编辑

    public static final String OA_CAR_EDIT = OaCar.class.getSimpleName() + "_edit"; //车辆管理_编辑
    public static final String OA_CAR_AUDIT = OaCar.class.getSimpleName() + "_audit"; //车辆管理_审核
    public static final String OA_CAR_DELETE = OaCar.class.getSimpleName() + "_delete"; //车辆管理_强制删除

    public static final String OA_KNOWLEDGE_EDIT = OaKnowledge.class.getSimpleName() + "_edit"; //知识管理_编辑
    public static final String OA_KNOWLEDGE_DELETE = OaKnowledge.class.getSimpleName() + "_delete"; //知识管理_强制删除

    public static final String OA_NEWS_EDIT = OaNews.class.getSimpleName() + "_edit"; //新闻管理_编辑
    public static final String OA_NEWS_DELETE = OaNews.class.getSimpleName() + "_delete"; //新闻管理_强制删除

    public static final String OA_MEETING_EDIT = OaMeeting.class.getSimpleName() + "_edit"; //会议室管理_编辑
    public static final String OA_MEETING_AUDIT = OaMeeting.class.getSimpleName() + "_audit"; //会议室管理_审核
    public static final String OA_MEETING_DELETE = OaMeeting.class.getSimpleName() + "_delete"; //会议室管理_强制删除

    public static final String OA_EXPERTISE_EDIT = OaExpertise.class.getSimpleName() + "_edit"; //专业技术学习_编辑
    public static final String OA_EXPERTISE_AUDIT = OaExpertise.class.getSimpleName() + "_audit"; //专业技术学习_审核
    public static final String OA_EXPERTISE_DELETE = OaExpertise.class.getSimpleName() + "_delete"; //专业技术学习_强制删除

    public static final String OA_MATERIAL_EDIT = OaMaterial.class.getSimpleName() + "_edit"; //材料采购_编辑
    public static final String OA_MATERIAL_OFFICE_AUDIT = OaMaterial.class.getSimpleName() + "_office_audit"; //材料采购_办公室审核
    public static final String OA_MATERIAL_LEADER_AUDIT = OaMaterial.class.getSimpleName() + "_leader_audit"; //材料采购_领导审核
    public static final String OA_MATERIAL_DELETE = OaMaterial.class.getSimpleName() + "_delete"; //材料采购_强制删除

    public static final String OA_LEAVEAPPLY_EDIT = OaLeaveApply.class.getSimpleName() + "_edit"; //请假单_编辑
    public static final String OA_LEAVEAPPLY_OFFICE_AUDIT = OaLeaveApply.class.getSimpleName() + "_office_audit"; //请假单_办公室审核
    public static final String OA_LEAVEAPPLY_LEADER_AUDIT = OaLeaveApply.class.getSimpleName() + "_leader_audit"; //请假单_领导审核
    public static final String OA_LEAVEAPPLY_DELETE = OaLeaveApply.class.getSimpleName() + "_delete"; //请假单_强制删除
    public static final String OA_LEAVEAPPLY_VIEWALL = OaLeaveApply.class.getSimpleName() + "_viewAll"; //请假单_查看所有人
    public static final String OA_LEAVEAPPLY_NOTICE = OaLeaveApply.class.getSimpleName() + "_notice"; //请假单_通知食堂

    public static final String OA_MONTHPLAN_EDIT = OaMonthplan.class.getSimpleName() + "_edit";   //月度总结计划_编辑
    public static final String OA_MONTHPLAN_AUDIT = OaMonthplan.class.getSimpleName() + "_audit"; //月度总结计划_审核

    public static final String OA_MONTHPLAN_SUM_EDIT = OaMonthplanSum.class.getSimpleName() + "_edit";   //月度总结计划汇总_编辑
    public static final String OA_MONTHPLAN_SUM_AUDIT = OaMonthplanSum.class.getSimpleName() + "_audit"; //月度总结计划汇总_审核

    public static final String OA_QUARTERPLAN_EDIT = OaQuarterplan.class.getSimpleName() + "_edit";   //季度年度总结计划_编辑
    public static final String OA_QUARTERPLAN_AUDIT = OaQuarterplan.class.getSimpleName() + "_audit"; //季度年度总结计划_审核

    public static final String OA_QUARTERPLAN_SUM_EDIT = OaQuarterplanSum.class.getSimpleName() + "_edit";   //季度年度总结计划汇总_编辑
    public static final String OA_QUARTERPLAN_SUM_AUDIT = OaQuarterplanSum.class.getSimpleName() + "_audit"; //季度年度总结计划汇总_审核

    public static final String OA_DEPT_NEWS_EDIT = OaDeptNews.class.getSimpleName() + "_edit";   //科室新闻上报_编辑
    public static final String OA_DEPT_NEWS_AUDIT = OaDeptNews.class.getSimpleName() + "_audit"; //科室新闻上报_审核

    public static final String OA_DYNAMIC_WORK_EDIT = OaDynamicWork.class.getSimpleName() + "_edit"; //实时工作动态_编辑

    /**
     * ***************************************综合查询******************************************************
     */
    public static final String PROJECT_QUERY = "ProjectQuery";                //项目查询


    /**
     * ***************************************短信发送******************************************************
     */
    public static final String MSG_MESSAGE_EDIT = MsgMessage.class.getSimpleName() + "_edit";  //短信发送_编辑

    /**
     * ***************************************业务流程******************************************************
     */
    public static final String BPM_PROCESS_DEFINITION_EDIT = BpmProcessDefinition.class.getSimpleName() + "_edit"; //业务流程定义_编辑
    public static final String BPM_PROCESS_TEMPLATE_EDIT = BpmProcessTemplate.class.getSimpleName() + "_edit"; //流程模板_编辑
    public static final String BPM_FORM_TEMPLATE_EDIT = BpmFormTemplate.class.getSimpleName() + "_edit"; //表单模板_编辑
    public static final String BPM_PROJECT_GROUP_EDIT = BpmProjectGroup.class.getSimpleName() + "_edit"; //项目组_编辑
    public static final String BPM_SWIMLANE_EDIT = BpmSwimlane.class.getSimpleName() + "_edit"; //系统泳道_编辑
    public static final String BPM_PROCESS_INSTANCE_FORCE_DELETE = BpmProcessInstance.class.getSimpleName() + "_delete";     //流程实例_强制删除

    /**
     * ***************************************管理人员考勤******************************************************
     */
    public static final String CHECK_DEVICE_INFO_EDIT = CheckDeviceInfo.class.getSimpleName() + "_edit"; //考勤设备_编辑
    public static final String CHECK_MANAGER_EDIT = CheckManager.class.getSimpleName() + "_edit"; //考勤人员_编辑

    /**
     * ***************************************文档管理******************************************************
     */
    public static final String DOC_CATEGORY_EDIT = DocCategory.class.getSimpleName() + "_edit"; //文档目录_编辑
    public static final String DOC_DOCUMENT_EDIT = DocDocument.class.getSimpleName() + "_edit"; //文档管理_编辑

    /**
     * ***************************************质量安全监督***********************************************
     */
    public static final String JD_JL_REPORT_EDIT = JdJlReport.class.getSimpleName() + "_edit"; //监理报告_编辑
    public static final String JD_JL_REPORT_ALERT_NORMAL = JdJlReport.class.getSimpleName() + "_alert_normal"; //监理报告_通知_普通
    public static final String JD_JL_REPORT_ALERT_URGENT = JdJlReport.class.getSimpleName() + "_alert_urgent"; //监理报告_通知_紧急

    public static final String JD_CYSB_EDIT = JdCysb.class.getSimpleName() + "_edit"; //监督创优申报_编辑
    public static final String JD_CYSB_AUDIT = JdCysb.class.getSimpleName() + "_audit"; //监督创优申报_审核

    public static final String JD_INFORM_EDIT = JdInform.class.getSimpleName() + "_edit"; //监督告知书_编辑
    public static final String JD_INFORM_AUDIT_KZ = JdInform.class.getSimpleName() + "_audit_kz"; //监督告知书_审核_科长
    public static final String JD_INFORM_AUDIT_FG = JdInform.class.getSimpleName() + "_audit_fg"; //监督告知书_审核_分管领导
    /**
     * ***************************************监督记录******************************************************
     */
    public static final String JD_RECORD_EDIT = "JdRecord_edit"; //监督记录_编辑
    public static final String JD_RECORD_FIRST_EDIT = JdRecordFirst.class.getSimpleName() + "_edit"; //首次监督_编辑
    public static final String JD_RECORD_SAFE_EDIT = JdRecordSafe.class.getSimpleName() + "_edit"; //过程安全监督_编辑
    public static final String JD_RECORD_QUALITY_EDIT = JdRecordQuality.class.getSimpleName() + "_edit"; //过程质量监督_编辑
    public static final String JD_RECORD_COMPLETE_EDIT = JdRecordComplete.class.getSimpleName() + "_edit"; //竣工验收监督_编辑

    /**
     * ***************************************监督预约******************************************************
     */
    public static final String ORDER_FORM_EDIT = OrderForm.class.getSimpleName()+"_edit";  //监督预约_编辑
    public static final String ORDER_FORM_AUDIT = OrderForm.class.getSimpleName()+"_audit";  //监督预约_受理
    public static final String ORDER_FORM_REDO = OrderForm.class.getSimpleName()+"_redo";  //监督预约_重新安排预约
    public static final String ORDER_FORM_MEMO_EDIT = OrderForm.class.getSimpleName()+"Memo_edit";  //监督预约备注信息_编辑
    /**
     * ***************************************巡查监督设置******************************************************
     */
    public static final String POLLING_WORKGROUP_EDIT = PollingWorkGroup.class.getSimpleName() + "_edit";  //巡查监督组_编辑
    public static final String JD_REPORT_EDIT = JdReport.class.getSimpleName() + "_edit";  //监督报告_编辑

    /**
     * ***************************************项目信息维护******************************************************
     */
    public static final String SYN_EXCEL_JD_TASKS_EDIT = ExcelJdTasks.class.getSimpleName() + "_edit";       //监督任务书导入_编辑
    public static final String PROJECT_EXTEND_EDIT = ProjectExtend.class.getSimpleName() + "_edit";       //项目属地维护_编辑
    public static final String PROJECT_EXTEND_COMPLETE_EDIT = "ProjectCompleteQuery_edit";       //竣工项目_编辑
    public static final String PROJECT_MAJOR_EDIT = ProjectMajor.class.getSimpleName() + "_edit";       //重大工程项目_编辑

    /**
     * ***************************************务工人员管理******************************************************
     */
    public static final String WORKER_COMPLAIN_EDIT = WorkerComplain.class.getSimpleName() + "_edit";       //务工人员投诉管理_编辑
    public static final String WORKER_SCHOOLE_EDIT = WorkerSchool.class.getSimpleName() + "_edit";       //务工人员投诉管理_编辑
    public static final String WORKER_INSPECT_RECORD_EDIT = WorkerInspectRecord.class.getSimpleName() + "_edit";  //现场检查记录_编辑


    /**
     * ***************************************监督单据管理******************************************************
     */
    public static final String POLLING_PREFIX_SAFE = "Safe";  //权限前缀_安全
    public static final String POLLING_PREFIX_QUALITY = "Quality";  //权限前缀_质量

    public static final String POLLING_FORM_EDIT =  "PollingForm_edit";  //单据管理_编辑
    public static final String POLLING_RECORD_EDIT =  "PollingRecord_edit";  //单据记录_编辑
    public static final String POLLING_UNLAWFUL_PROJECT_EDIT = PollingUnlawfulProject.class.getSimpleName() + "_edit";  //六无工程_编辑


    /**
     * ***************************************计划管理******************************************************
     */
    public static final String PLAN_MAIN_INFO_SAFE_EDIT = PlanMainInfo.class.getSimpleName()+"_safe_edit";          //安全监督计划_编辑
    public static final String PLAN_MAIN_INFO_SAFE_AUDIT = PlanMainInfo.class.getSimpleName()+"_safe_audit";        //安全监督计划_审核
    public static final String PLAN_MAIN_INFO_QUALITY_EDIT = PlanMainInfo.class.getSimpleName()+"_quality_edit";   //质量监督计划_编辑
    public static final String PLAN_MAIN_INFO_QUALITY_AUDIT = PlanMainInfo.class.getSimpleName()+"_quality_audit"; //质量监督计划_审核
    public static final String PLAN_MAIN_INFO_SPECIAL_EDIT = PlanMainInfo.class.getSimpleName()+"_special_edit";   //专项监督计划_编辑
    public static final String PLAN_MAIN_INFO_SPECIAL_AUDIT = PlanMainInfo.class.getSimpleName()+"_special_audit"; //专项监督计划_审核
    public static final String PLAN_MAIN_INFO_ORDER_EDIT = PlanMainInfo.class.getSimpleName()+"_order_edit";        //预约监督计划_编辑
    public static final String PLAN_MAIN_INFO_ORDER_AUDIT = PlanMainInfo.class.getSimpleName()+"_order_audit";      //预约监督计划_审核
    public static final String PLAN_MAIN_INFO_CHECK_EDIT = PlanMainInfo.class.getSimpleName()+"_check_edit";        //稽查监督计划_编辑
    public static final String PLAN_MAIN_INFO_CHECK_AUDIT = PlanMainInfo.class.getSimpleName()+"_check_audit";      //稽查监督计划_审核

    /**
     * ***************************************安全监督******************************************************
     */
    public static final String SAFE_PRODUCT_CHECK_EDIT = SafeProductCheck.class.getSimpleName()+"_edit";        //安全生产季度考核_编辑
    public static final String SAFE_PRODUCT_STANDARD_EDIT = SafeProductStandard.class.getSimpleName()+"_edit";  //安全生产标准_编辑

    /**
     * ***************************************项目审批******************************************************
     */
    public static final String NET_ACCEPT_STEP_EDIT = NetAcceptStep.class.getSimpleName()+"_edit";  //审批环节_编辑
    public static final String NET_APPLY_EDIT = NetApply.class.getSimpleName()+"_edit";  //项目报建_编辑
    public static final String NET_APPLY_FORCE_DELETE = NetApply.class.getSimpleName()+"_force_delete";  //项目报建_强制删除
    public static final String NET_CFB_EDIT = NetCfb.class.getSimpleName()+"_edit";  //项目承发包_编辑
    public static final String NET_CONTRACT_EDIT = NetContract.class.getSimpleName()+"_edit";  //项目合同备案_编辑
    public static final String NET_MONITOR_EDIT = NetMonitor.class.getSimpleName()+"_edit";  //项目报监_编辑
    public static final String NET_SGPERMIT_EDIT = NetSgpermit.class.getSimpleName()+"_edit";  //项目施工许可_编辑

    /**
     * ***************************************视频管理******************************************************
     */
    public static final String MON_SERVER_EDIT = MonServer.class.getSimpleName()+"_edit"; //视频维护_编辑

    /**
     * ***************************************综合报表******************************************************
     */
    public static final String REPORT_DEPT_DEFINE_EDIT = ReportDeptDefine.class.getSimpleName()+"_edit"; //综合报表单位权限_编辑
    public static final String REPORT_STRUCTURE_EDIT = ReportStructure.class.getSimpleName()+"_edit"; //综合报表结构定义_编辑
    public static final String REPORT_MONTH_EDIT = "Report{0}_edit"; //综合报表上报_编辑，其中{0}替换为单位权限定义的编码

    /**
     * ***************************************保证金管理******************************************************
     */
    public static final String PROJECT_BID_SIGN_EDIT = ProjectBidSign.class.getSimpleName()+"_edit"; //保证金_登记
    public static final String PROJECT_BID_SIGN_DEPT_EDIT = ProjectBidSignDept.class.getSimpleName()+"_edit"; //招标单位报名登记_编辑
    public static final String PROJECT_BID_SIGN_PAY = "ProjectBidPay_edit"; //保证金_征收和退还
    public static final String PROJECT_BID_SIGN_CHECK = "ProjectBidCheck_edit"; //保证金_审核
    public static final String PROJECT_BID_PAY_BACK = "ProjectBidPay_back"; //银行退款短信提醒
    public static final String PROJECT_BID_PAY_APPLY = "ProjectBidPay_apply"; //征收保证金短信

    /**
     * ***************************************停工单**********************************************************
     */
    public static final String WORKER_STOP_FORM_EDIT = WorkerStopForm.class.getSimpleName() + "_edit"; //停工单_编辑

    public static final String WORKER_TALK_FORM_EDIT = WorkerTalkForm.class.getSimpleName() + "_edit"; //谈话通知单_编辑


    /**
     * ***************************************员工论坛**********************************************************
     */
    public static final String OABBS_EDIT = OaBbs.class.getSimpleName() + "_edit"; //员工论坛_编辑

    public static final String OABBS_MANAGER = OaBbs.class.getSimpleName() + "_manager"; //员工论坛_管理
}

