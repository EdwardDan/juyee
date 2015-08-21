package com.justonetech.biz.utils;

import com.justonetech.system.domain.SysPrivilege;

/**
 * 系统字典及参数定义
 */
public class Constants {

    public static final String FLAG_TRUE = "1"; //true
    public static final String FLAG_FALSE = "0"; //false

    public static final String SYS_NOPICTURE_PIC = "no_picture.gif"; //无图片
    public static final String SYS_USER_ADMIN = "admin";  //系统管理员用户名
    public static final String SYS_DEPT_OWNER = "OWNER";  //业主单位代码

    public static final String GRID_SQL_KEY = "gsk";  //excel导出时将sql放入session所用的key

    //系统管理
    public static final String SYS_PRIVILEGE_TYPE = SysPrivilege.class.getSimpleName(); //权限类型分类
    public static final String SYS_PRIVILEGE_TYPE_PAGE = "page"; //权限类型---页面权限
    public static final String SYS_PRIVILEGE_TYPE_BUTTON = "button"; //权限类型---按钮权限


    public static final String SYS_DEPT_CATAGORY = "SysDeptCatagory";//单位类型
    public static final String OWNER_UNIT = "OwnerUnit";//单位类型---业主单位
    public static final String CONSTRUCTION_UNIT = "ConstructionUnit";//单位类型---建设单位
    public static final String SUPERVISING_UNIT = "SupervisingUnit";//单位类型---监理单位

    public static final String SYS_EDUCATION = "education"; //学历/文化程度
    public static final String SYS_POLITICAL = "political"; //政治面貌

    //日志分类
    public static final String LOG_TYPE_CODE = "LOG_TYPE";   //日志分类-登录
    public static final String LOG_TYPE_LOGIN = "1";   //日志分类-登录
    public static final String LOG_TYPE_NORMAL = "2";  //日志分类-正常
    public static final String LOG_TYPE_ERROR = "3";   //日志分类-错误
    public static final String LOG_TYPE_LOGOUT = "4";  //日志分类-退出
    public static final String LOG_TYPE_WS = "5";   //日志分类-web service

    //业务流程
    public static final String BPM_PROCESS_DEFINITION_CATEGORY = "BpmProcessDefinitionCategory"; //流程定义分类
    public static final String BPM_PROCESS_DEFINITION_CATEGORY_GD = "gd"; //流程定义分类--工地申报
    public static final String BPM_PROCESS_TEMPLATE_CATEGORY = "BpmProcessTemplateCategory"; //流程模板分类（流程模板和表单模板共用一个分类）
    public static final String BPM_PROJECT_GROUP_TYPE = "BpmProjectGroupType"; //项目组类型
    public static final String BPM_PROJECT_GROUP_DUTY_TYPE = "BpmProjectGroupDutyType"; //项目组岗位类型

    public static final String BPM_AUDIT_METHOD_SHARE = "0"; //审核方式--多人共享（多个人同时可以操作，只要任意一个人先做完提交则转入下个节点）
    public static final String BPM_AUDIT_METHOD_LIMIT = "1"; //审核方式--多人排他（只要任意一个人开始做则其他人不能再操作）
    public static final String BPM_AUDIT_METHOD_MULTI = "2"; //审核方式--多人会签（必须多个人同时做完提交流程才能转入下个节点）

    public static final String BPM_STATUS_START = "0";   // 流程实例状态--开启中
    public static final String BPM_STATUS_RUN = "1";     // 流程实例状态--执行中
    public static final String BPM_STATUS_END = "2";     // 流程实例状态--正常结束
    public static final String BPM_STATUS_CANCEL = "3";  // 流程实例状态--取消
    public static final String BPM_STATUS_HISTORY = "9"; // 流程实例状态--历史数据

    public static final String SEND_JBPM_MSG = "send_jbpm_msg";//短信模板-流程短信
    public static final String SEND_JBPM_CC_MSG = "send_jbpm_cc_msg";//短信模板-流程抄送短信
    public static final String SYS_WORKCALENDAR = "sys_workcalendar";//项目日历--系统参数表


    public static final String SYS_REGPERSON_TYPE = "SysRegPersonType"; //注册人员类型--类型（工地,项目,企业）
    //    public static final String SYS_REGPERSON_TYPE_Unit = "company"; //注册人员类型--类型-企业
//    public static final String SYS_REGPERSON_TYPE_Pro = "project"; //注册人员类型--类型--项目
    public static final String SYS_REGPERSON_TYPE_Gd = "gongdi"; //注册人员类型--类型--工地--暂时保留
    public static final String SYS_REGPERSON_TYPE_UNIT_SG = "sg";  //注册人员类型--类型-施工单位(原类型：企业)
    public static final String SYS_REGPERSON_TYPE_UNIT_JL = "jl";  //注册人员类型--类型-监理单位
    public static final String SYS_REGPERSON_TYPE_UNIT_JS = "js";  //注册人员类型--类型-建设单位(原类型：项目)


    /**
     * *************************************** 任务模块 begin ******************************************************
     */
    public static final String OA_TASK_NULL_PAGE = "../oaTask/nullPage.do?id=";    //未找到关联记录的提示页面

    public static final String OA_PRIORITY_NORMAL = "0";    //紧急程度--普通
    public static final String OA_PRIORITY_IMPORTANT = "1"; //紧急程度--紧急

    public static final String OA_TASK_NOTREAD = "0"; //系统任务处理状态--未读
    public static final String OA_TASK_READ = "1"; //系统任务处理状态--已读
    public static final String OA_TASK_ACCEPT = "2"; //系统任务处理状态--已接受
    public static final String OA_TASK_DELETE = "9"; //系统任务处理状态--已删除

    public static final String OA_AUDIT_METHOD_SHARE = "0"; //审核方式--多人共享（多个人同时可以操作，只要任意一个人先做完提交则转入下个节点）
    public static final String OA_AUDIT_METHOD_LIMIT = "1"; //审核方式--多人排他（只要任意一个人开始做则其他人不能再操作）
    public static final String OA_AUDIT_METHOD_MULTI = "2"; //审核方式--多人会签（必须多个人同时做完提交流程才能转入下个节点）
    /****************************************** 任务模块 end *******************************************************/

    /**
     * *************************************** 项目管理begin*********************************************************
     */
    public static final String PROJ_INFO_PROPERTY = "ProjProperty"; //管理属性
    public static final String PROJ_INFO_STAGE = "ProjStage"; //项目状态
    public static final String PROJ_INFO_CATEGORY = "ProjCategory"; //业务类别
    public static final String PROJ_INFO_SOURCE = "ProjSources"; //项目来源
    public static final String PROJ_INFO_BELONG_AREA = "ProjBelongArea"; //涉及区（县）
    public static final String PROJ_INFO_DBSX = "dbsx"; //打包属性

    /****************************************** 项目管理 end *******************************************************/

    /**
     * *************************************** 数据填报 begin*********************************************************
     */
    public static final String DATA_STAGE_RESULT = "DataStageResult"; //办证推进结果
    public static final String DATA_STAGE_RESULT_1 = "1"; //办证推进结果--计划办理
    public static final String DATA_STAGE_RESULT_2 = "2"; //办证推进结果--办理中(未上报)
    public static final String DATA_STAGE_RESULT_6 = "6"; //办证推进结果--办理中（已上报）
    public static final String DATA_STAGE_RESULT_3 = "3"; //办证推进结果--办理完成
    public static final String DATA_STAGE_RESULT_4 = "4"; //办证推进结果--办理受阻
    public static final String DATA_STAGE_RESULT_5 = "5"; //办证推进结果--无需办理

    public static final String DATA_REPORT_STEP = "DataReportStep"; //项目推进填报步骤
    /****************************************** 数据填报 end *******************************************************/

    //OA办公
    public static final String OA_PUBLIC_INFO_RANGE = "OaPublicInfoRange"; //公共信息发布--范围
    public static final String OA_PUBLIC_INFO_RANGE_OUT = "out"; //公共信息发布--范围--外网
    public static final String OA_PUBLIC_INFO_RANGE_IN = "in"; //公共信息发布--范围--外网
    public static final String OA_PUBLIC_INFO_RANGE_ALL = "all"; //公共信息发布--范围--内外网

    public static final String OA_PUBLIC_INFO_TYPE = "OaPublicInfoType"; //公共信息发布--类型
    public static final String OA_PUBLIC_INFO_TYPE_BULLETIN = "bulletin"; //公共信息发布--类型--公示公告
    public static final String OA_PUBLIC_INFO_TYPE_MEETING = "meeting"; //公共信息发布--类型--会议纪要
    public static final String OA_PUBLIC_INFO_TYPE_NOTICE = "notice"; //公共信息发布--类型--情况通报
    public static final String OA_PUBLIC_INFO_TYPE_RULE = "rule"; //公共信息发布--类型--规章制度
    public static final String OA_PUBLIC_INFO_TYPE_WORK = "work"; //公共信息发布--类型--工作动态
    public static final String OA_PUBLIC_INFO_TYPE_POLICY = "policy"; //公共信息发布--类型--法律法规
    public static final String OA_PUBLIC_INFO_TYPE_TXL = "txl"; //公共信息发布--类型--通讯录

    public static final String OA_MEETING_TYPE_INNER = "OaMeetingTypeInner"; //内部会议类型
    public static final String OA_MEETING_TYPE_OUTER = "OaMeetingTypeOuter"; //内部会议类型
    public static final String OA_CAR_SELECT = "OaCarSelect"; //车辆选择
    public static final String OA_THINGS_TYPE = "OaThingsType"; //办公用品分类
    public static final String OA_THINGS_UNIT = "OaThingsUnit"; //办公用品计量单位
    public static final String OA_WEEK_ARRANGE_PERIOD = "OaWeekArrangePeriod"; //领导一周安排的时间段
    public static final String OA_PETITION_TYPE = "OaPetitionType"; //信访种类
    public static final String OA_PETITION_SOURCE = "OaPetitionSource"; //信访来源
    public static final String OA_PETITION_STATUS = "OaPetitionStatus"; //信访受理状态
    public static final String OA_WEEK_ARRANGE_ZXLD = "zxld"; //领导一周安排中心领导

    //项目办证阶段管理
    public static final String PROJ_STAGE_PSOPINIONS = "PSOpinions";//规划选址意见书
    public static final String PROJ_STAGE_REPLY4WORKERS = "Reply4Workers";//工可批复
    public static final String PROJ_STAGE_PREDESIGN = "PreDesign";//初步设计
    public static final String PROJ_STAGE_LANDUSERPLANNING = "LandUsePlanning";//用地规划许可证
    public static final String PROJ_STAGE_LANDUSERAPPROVAL = "LandUseApproval";//用地批准书
    public static final String PROJ_STAGE_ENGINEERPLANNINGPERMIT = "EngineerPlanningPermit";//工程规划许可证
    public static final String PROJ_STAGE_CONSTRUCTIONPERMITS = "ConstructionPermits";//施工许可证

    //发文类型
    public static final String OA_AEND_FILE = "OaSendFile";
    public static final String OA_AEND_FILE_1 = "1";
    public static final String OA_AEND_FILE_2 = "2";
    public static final String OA_AEND_FILE_3 = "3";
    public static final String OA_AEND_FILE_4 = "4";
    public static final String OA_AEND_FILE_5 = "5";
    public static final String OA_AEND_FILE_6 = "6";

    //密级
    public static final String FILE_SECURITY = "FileSecurity";
    public static final String FILE_SECURITY_1 = "1";
    public static final String FILE_SECURITY_2 = "2";
    public static final String FILE_SECURITY_3 = "3";
    public static final String FILE_SECURITY_4 = "4";

    //紧急程度
    public static final String EMERGENCY = "Emergency";
    public static final String EMERGENCY_1 = "1";
    public static final String EMERGENCY_2 = "2";
    public static final String EMERGENCY_3 = "3";


}
