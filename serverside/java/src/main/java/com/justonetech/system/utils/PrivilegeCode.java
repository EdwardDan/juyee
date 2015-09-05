package com.justonetech.system.utils;

import com.justonetech.biz.domain.*;
import com.justonetech.system.domain.*;

/**
 * 权限编码定义
 * User: Chen Junping
 * Date: 12-3-16
 * select 'public static final String '||upper(t.code)||' = "'||t.code||'";  //'||t.name,t.* from sys_privilege t where t.tree_id like '00004%' and t.type=89 order by tree_id
 */
public class PrivilegeCode {
    /**
     * ***************************************系统管理******************************************************
     */
    public static final String SYS_SAMPLE_EDIT = Sample.class.getSimpleName() + "_edit";     //样例_编辑
    public static final String SYS_DEPT_EDIT = SysDept.class.getSimpleName() + "_edit";     //单位部门_编辑
    public static final String SYS_PERSON_EDIT = SysPerson.class.getSimpleName() + "_edit"; //人员_编辑
    public static final String SYS_USER_EDIT = SysUser.class.getSimpleName() + "_edit";      //用户_编辑
    public static final String SYS_ROLE_EDIT = SysRole.class.getSimpleName() + "_edit";      //角色_编辑
    public static final String SYS_PRIVILEGE_EDIT = SysPrivilege.class.getSimpleName() + "_edit";  //权限_编辑
    public static final String SYS_MENU_EDIT = SysMenu.class.getSimpleName() + "_edit";             //菜单_编辑
    public static final String SYS_LOG_EDIT = SysLog.class.getSimpleName() + "_edit";               //日志_编辑
    public static final String SYS_CODE_EDIT = SysCode.class.getSimpleName() + "_edit";//系统字典_编辑
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
     * ***************************************业务流程******************************************************
     */
    public static final String BPM_PROCESS_DEFINITION_EDIT = BpmProcessDefinition.class.getSimpleName() + "_edit"; //业务流程定义_编辑
    public static final String BPM_PROCESS_TEMPLATE_EDIT = BpmProcessTemplate.class.getSimpleName() + "_edit"; //流程模板_编辑
    public static final String BPM_FORM_TEMPLATE_EDIT = BpmFormTemplate.class.getSimpleName() + "_edit"; //表单模板_编辑
    public static final String BPM_PROJECT_GROUP_EDIT = BpmProjectGroup.class.getSimpleName() + "_edit"; //项目组_编辑
    public static final String BPM_SWIMLANE_EDIT = BpmSwimlane.class.getSimpleName() + "_edit"; //系统泳道_编辑
    public static final String BPM_PROCESS_INSTANCE_FORCE_DELETE = BpmProcessInstance.class.getSimpleName() + "_delete";     //流程实例_强制删除

    /**
     * ***************************************文档管理******************************************************
     */
    public static final String DOC_CATEGORY_EDIT = DocCategory.class.getSimpleName() + "_edit"; //文档目录_编辑
    public static final String DOC_DOCUMENT_EDIT = DocDocument.class.getSimpleName() + "_edit"; //文档管理_编辑

    /**
     * ***************************************项目管理******************************************************
     */
    public static final String PROJ_INFO_EDIT = ProjInfo.class.getSimpleName() + "_edit";//项目基本信息管理_编辑
    public static final String PROJ_STAGE_EDIT = ProjStage.class.getSimpleName() + "_edit";//项目办证阶段管理_编辑
    public static final String PROJ_NODE_EDIT = ProjNode.class.getSimpleName() + "_edit";//形象进度节点管理_编辑
    public static final String PROJ_RELATE_DEPT_EDIT = ProjRelateDept.class.getSimpleName() + "_edit";//建设单位管理_编辑
    public static final String PROJ_BID_STAGE_EDIT = ProjBid.class.getSimpleName() + "Stage_edit";//办证推进标段_编辑
    public static final String PROJ_BID_NODE_EDIT = ProjBid.class.getSimpleName() + "Node_edit";//形象进度标段_编辑

    /**
     * ***************************************数据上报******************************************************
     */
    public static final String DATA_NODE_REPORT_EDIT = DataNodeReport.class.getSimpleName() + "_edit";//形象进度推进填报_编辑
    public static final String DATA_STAGE_REPORT_EDIT = DataStageReport.class.getSimpleName() + "_edit";//承担项目办证推进_编辑

    /**
     * ***************************************项目查询******************************************************
     */
    public static final String PROJECT_QUERY_STAGE_SUM = "ProjectQueryStage_sum";//办证推进汇总查询
    public static final String PROJECT_QUERY_NODE_SUM = "ProjectQueryNode_sum";  //形象进度汇总查询
    public static final String DATA_STAGE_REPORT_SUM = "DataStageReportSum_sum";  //办证推进完成情况汇总

    /**
     * ***************************************OA******************************************************
     */
    public static final String OA_PUBLIC_INFO_EDIT = "OaPublicInfo_edit";  //信息发布_编辑
    public static final String MSG_MESSAGE_EDIT = MsgMessage.class.getSimpleName() + "_edit";  //短信发送_编辑

    public static final String OA_MEETING_OUTER_EDIT = "OaMeetingOuter_edit";  //外出会议管理_编辑
    public static final String OA_MEETING_OUTER_AUDIT_FG = "OaMeetingOuter_audit_fg";  //外出会议管理_审核_分管
    public static final String OA_MEETING_OUTER_AUDIT_ZR = "OaMeetingOuter_audit_zr";  //外出会议管理_审核_主任
    public static final String OA_MEETING_INNER_EDIT = "OaMeetingInner_edit";  //内部会议管理_编辑

    public static final String OA_MEETING_EDIT = OaMeeting.class.getSimpleName() + "_edit";     //内部会议管理(新)_编辑
    public static final String OA_MEETING_AUDIT = OaMeeting.class.getSimpleName() + "_audit";   //内部会议管理(新)_审核
    public static final String OA_MEETING_DELETE = OaMeeting.class.getSimpleName() + "_delete"; //内部会议管理(新)_强制删除

    public static final String OA_CAR_EDIT = "OaCar_edit";  //车辆申请_编辑
    public static final String OA_CAR_AUDIT_KZ = "OaCar_audit_kz";  //车辆申请_审核_科长
    public static final String OA_CAR_AUDIT_ZR = "OaCar_audit_zr";  //车辆申请_审核_主任
    public static final String OA_CAR_AUDIT_CLDD = "OaCarSchedule_audit";  //车辆申请_车辆调度
    public static final String OA_CAR_VIEW_ALL = "OaCarAll_view";//车辆申请分管领导主任查看所有部门信息
    public static final String OA_THINGS_EDIT = "OaThings_edit";  //办公用品库_编辑
    public static final String OA_THINGS_APPLY_EDIT = "OaThingsApply_edit";  //办公用品申请_编辑
    public static final String OA_THINGS_APPLY_AUDIT_KZ = "OaThingsApply_audit_kz";  //办公用品申请_审核_科长
    public static final String OA_THINGS_APPLY_AUDIT_ZR = "OaThingsApply_audit_zr";  //办公用品申请_审核_主任
    public static final String OA_WEEKARRANGE_EDIT = "OaWeekArrange_edit";  //领导一周工作安排_编辑
    public static final String OA_PETITION_EDIT = "OaPetition_edit";  //信访管理_编辑


    public static final String OA_WORK_WATCH_EDIT = "OaWorkWatch_edit";  // OA办公-工作督办_编辑
    public static final String OA_WORK_WATCH_AUDIT_ZR = "OaWorkWatch_audit_zr";  // OA办公-工作督办_审核_主任
    public static final String OA_WORK_WATCH_AUDIT_KZ = "OaWorkWatch_audit_kz";  // OA办公-工作督办_审核_科长
    public static final String OA_WORK_WATCH_AUDIT_B = "OaWorkWatch_audit_bgs";  // OA办公-工作督办_审核_办公室
    public static final String OA_WORK_WATCH_SUM = "OaWorkWatch_sum";  // OA办公-工作督办_汇总
    public static final String OA_WORK_PLAN_SUM_EDIT = "OaWorkPlanSum_edit";  //上报汇总_编辑
    public static final String OA_WORK_PLAN_SUM_AUDIT_ZR = "OaWorkPlanSum_audit";  //上报汇总_审核_主任
    public static final String OA_WORK_PLAN_EDIT = "OaWorkPlan_edit";  //科室上报
    public static final String OA_WORK_PLAN_AUDIZ_KZ = "OaWorkPlan_audit_kz";  //科室上报_科长审核
    public static final String OA_WORK_PLAN_AUDIT_FG = "OaWorkPlan_audit_fg";  //科室上报_分管领导审核
    public static final String OA_WORK_PLAN_VIEW_ALL = "OaWorkPlan_view_all";  //科室上报_查看所有

    public static final String OA_SEND_FILE_EDIT = OaSendFile.class.getSimpleName() + "_edit";  //发文记录_编辑
    public static final String OA_RECEIVE_STEP_EDIT = OaReceiveStep.class.getSimpleName() + "_edit";  //收文流程配置_编辑
    public static final String OA_RECEIVE_EDIT = OaReceive.class.getSimpleName() + "_edit";  //收文登记单_编辑
    public static final String OA_RECEIVE_AUDIT = OaReceive.class.getSimpleName() + "_audit";  //收文登记单_审核

    //项目推进编辑
    public static final String PROJ_EXTEND_EDIT = ProjExtend.class.getSimpleName() + "_edit";  //项目推进编辑
}

