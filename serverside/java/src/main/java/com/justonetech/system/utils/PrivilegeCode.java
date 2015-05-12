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

    public static final String SYS_SKIN_EDIT = SysSkin.class.getSimpleName() + "_edit"; //系统皮肤设置
    public static final String SYS_PARAMETER_EDIT = SysParameter.class.getSimpleName() + "_edit";//系统参数维护

    /**
     * ***************************************协同办公******************************************************
     */
    public static final String OA_PUBLIC_INFO_EDIT = OaPublicInfo.class.getSimpleName() + "_edit";  //公共信息发布_编辑
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
    public static final String PROJ_BID_STAGE_EDIT = ProjBid.class.getSimpleName()+"Stage_edit";//办证推进标段_编辑
    public static final String PROJ_BID_NODE_EDIT = ProjBid.class.getSimpleName()+"Node_edit";//形象进度标段_编辑

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

}

