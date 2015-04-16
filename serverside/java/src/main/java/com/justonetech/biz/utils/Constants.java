package com.justonetech.biz.utils;

import com.justonetech.system.domain.SysPrivilege;

/**
 * 系统参数定义
 */
public class Constants {

    public static final String FLAG_TRUE = "1"; //true
    public static final String FLAG_FALSE = "0"; //false

    public static final String SYS_NOPICTURE_PIC = "no_picture.gif"; //无图片
    public static final String SYS_USER_ADMIN = "admin";  //系统管理员用户名
    public static final String SYS_DEPT_OWNER = "OWNER";  //业主单位代码
    public static final String SYS_DEPT_LEADER_NAME = "科长";  //各科室科长
    public static final String SYS_TOP_LEADER_NAME = "主任";  //建管署主任

    /**
     * *************************************** 系统代码 begin ******************************************************
     */
    //系统管理
    public static final String SYS_PRIVILEGE_TYPE = SysPrivilege.class.getSimpleName(); //权限类型分类
    public static final String SYS_PRIVILEGE_TYPE_PAGE = "page"; //权限类型---页面权限
    public static final String SYS_PRIVILEGE_TYPE_BUTTON = "button"; //权限类型---按钮权限

    public static final String SYS_EDUCATION = "education"; //学历/文化程度
    public static final String SYS_POLITICAL = "political"; //政治面貌
    public static final String REPORT_MEASURE_UNIT = "ReportMeasureUnit"; //报表结果计量单位

    //日志分类
    public static final String LOG_TYPE_CODE = "LOG_TYPE";   //日志分类-登录
    public static final String LOG_TYPE_LOGIN = "1";   //日志分类-登录
    public static final String LOG_TYPE_NORMAL = "2";  //日志分类-正常
    public static final String LOG_TYPE_ERROR = "3";   //日志分类-错误
    public static final String LOG_TYPE_LOGOUT = "4";  //日志分类-退出
    public static final String LOG_TYPE_WS = "5";   //日志分类-web service

    //OA办公
    public static final String OA_PARTY_INFORMATION = "PartyInformation"; //党员情况
    public static final String OA_HONOR_CATEGORY = "HonorCategory"; //荣誉类别
    public static final String OA_PERSON_NATURE = "PersonNature"; //人员性质
    public static final String OA_ARCHIVE_BID_TYPE = "ArchiveBidType"; //招标方式
    public static final String OA_DOC_TYPE = "ArchiveDocType"; //文书档案类别
    public static final String OA_ACCOUNT_TYPE = "ArchiveAccountType"; //会计档案类别
    public static final String OA_FILE_SHARE_TYPE = "FileShareType"; //共享文档类型
    public static final String OA_FILE_SECURITY = "FileSecurity"; //文件密级
    public static final String OA_FILE_SEND_TYPE = "FileSendType"; //发文文别
    public static final String OA_CAR_NO = "CarNo"; //车辆管理-车牌号
    public static final String OA_MEETING_ROOM = "OaMeetingRoom"; //会议室

    public static final String OA_PUBLIC_INFO_RANGE = "OaPublicInfoRange"; //公共信息发布--范围
    public static final String OA_PUBLIC_INFO_RANGE_OUT = "out"; //公共信息发布--范围--外网
    public static final String OA_PUBLIC_INFO_RANGE_IN = "in"; //公共信息发布--范围--外网
    public static final String OA_PUBLIC_INFO_RANGE_ALL = "all"; //公共信息发布--范围--内外网

    public static final String OA_PUBLIC_INFO_TYPE = "OaPublicInfoType"; //公共信息发布--类型
    public static final String OA_PUBLIC_INFO_TYPE_BULLETIN = "bulletin"; //公共信息发布--类型--通知公告
    public static final String OA_PUBLIC_INFO_TYPE_POLICY = "policy"; //公共信息发布--类型--政策法规
    public static final String OA_PUBLIC_INFO_TYPE_RULE = "rule"; //公共信息发布--类型--规章制度
    public static final String OA_PUBLIC_INFO_TYPE_PLAN = "plan"; //公共信息发布--类型--工作计划
    public static final String OA_PUBLIC_INFO_TYPE_STUDY = "study"; //公共信息发布--类型--学习资料
    public static final String OA_PUBLIC_INFO_TYPE_INTRODUCTION = "intro"; //公共信息发布--类型--管理机构介绍
    public static final String OA_PUBLIC_INFO_TYPE_WORK = "work"; //公共信息发布--类型--工作动态
    public static final String OA_PUBLIC_INFO_TYPE_POLICYOPEN = "policyopen"; //公共信息发布--类型--政务公开
    public static final String OA_PUBLIC_INFO_TYPE_NEWS = "news"; //公共信息发布--类型--建管要闻
    public static final String OA_PUBLIC_INFO_TYPE_STANDARD = "standard"; //公共信息发布--类型--现行标准
    public static final String OA_PUBLIC_INFO_TYPE_PIC = "pic"; //公共信息发布--类型--行业风采
    public static final String OA_PUBLIC_INO_TYPE_PARTYMEMBER = "partyMeber";//  公共信息发布--类型--党群天地
    public static final String OA_PUBLIC_INO_TYPE_WSBSLC = "wsbslc";//  公共信息发布--类型--网上办事流程
    public static final String OA_PERSON_OUT_TYPE = "OaPersonOutType";//  人员去向类型
    public static final String OA_PERSON_OUT_TYPE_NORMAL = "normal";//  人员去向类型--在岗
    public static final String OA_PERSON_OUT_TYPE_MEETTING = "meetting";//  人员去向类型--开会
    public static final String OA_PERSON_OUT_TYPE_OUT = "out";//  人员去向类型--外出
    public static final String OA_PERSON_OUT_TYPE_HOLIDAY = "holiday";//  人员去向类型--休假

    //监督预约状态
    public static final String ORDER_FORM_STATUS = "OrderFormStatus";
    public static final String ORDER_FORM_STATUS_EDIT = "edit";            //填写
    public static final String ORDER_FORM_STATUS_ACCEPT = "accept";        //已受理
    public static final String ORDER_FORM_STATUS_NOTACCEPT = "notaccept"; //未受理
    public static final String ORDER_FORM_STATUS_BACK = "back";            //退回

    public static final String ORDER_FORM_MEMO = "orderFormMemo";            //监督预约备注信息
    public static final String PLAN_DETAIL_DAY_SET = "PlanTimeset";    //巡检计划判断时间间隔，默认30天内
    public static final String PLAN_DETAIL_SELECT_CAUSE = "PlanDetailSelectCause";    //巡检计划选择工程的原因
    public static final String PLAN_DETAIL_SELECT_CAUSE_OTHER = "other";    //巡检计划选择工程的原因--其它

    //监督预约受理意见
    public static final String ORDER_FORM_DEPLOY_OPINION = "OrderFormDeployOpinion";
    public static final String ORDER_FORM_DEPLOY_OPINION_ARRANGE = "arrange";        //安排监督
    public static final String ORDER_FORM_DEPLOY_OPINION_NOTARRANGE = "notarrange"; //不安排监督
    public static final String ORDER_FORM_DEPLOY_OPINION_BACK = "back";               //退回


    //监督管理
    public static final String POLLING_RECORD_CLASS = "PollingRecordClass"; //监督管理--类别
    public static final String POLLING_RECORD_STAGE = "PollingRecordStage"; //监督管理--阶段
    public static final String POLLING_BORROW_REASON = "BorrowReason"; //监督管理--借阅用途

    //单据管理
    public static final String POLLING_FORM_CLASS = "PollingFormClass"; //单据--业务类别（质量、安全）
    public static final String POLLING_FORM_CLASS_SAFE = "safe"; //单据--业务类别--安全
    public static final String POLLING_FORM_CLASS_QUALITY = "quality"; //单据--业务类别--质量

    //整改单据的隐患类型
    public static final String POLLING_FORM_DANGER_TYPE_QUALITY = "PollingFormDangerTypeQuality"; //隐患类型--质量
    public static final String POLLING_FORM_DANGER_TYPE_SAFE = "PollingFormDangerTypeSafe"; //隐患类型--安全

    public static final String POLLING_FORM_TYPE = "PollingFormType"; //单据--类型（问题整改通知书、局部暂停施工指令单、停止施工指令单）
    public static final String POLLING_FORM_TYPE_QUESTION = "question"; //单据--类型--问题整改通知书
    public static final String POLLING_FORM_TYPE_PARTSTOP = "partstop"; //单据--类型--局部暂停施工指令单
    public static final String POLLING_FORM_TYPE_STOP = "stop";          //单据--类型--停止施工指令单

    public static final String POLLING_FORM_STATUS = "PollingFormStatus"; //单据--状态
    public static final String POLLING_FORM_STATUS_NOCHANGE = "noChange"; //单据--状态--未整改的
    public static final String POLLING_FORM_STATUS_HASCHANGE = "hasChange"; //单据--状态--已整改的
    public static final String POLLING_FORM_STATUS_HASARCHIVE = "hasArchive"; //单据--状态--已归档的

    public static final String POLLING_REVIEW_OPINION = "PollingReviewOpinion"; //单据复查意见类型
    public static final String POLLING_REVIEW_OPINION_PASS = "pass"; //单据复查意见类型--同意

    //单据流水号管理
    public static final String POLLING_FORM_SERIAL_STATUS = "PollingFormSerial"; //流水号--状态
    public static final String POLLING_FORM_SERIAL_STATUS_UNASSIGNED = "unAssigned"; //流水号--状态--未分配的
    public static final String POLLING_FORM_SERIAL_STATUS_ASSIGNED = "assigned"; //流水号--状态--已分配的
    public static final String POLLING_FORM_SERIAL_STATUS_HASUSED = "used"; //流水号--状态--已使用

    //计划管理类型
    public static final String PLAN_MAIN_INFO_TYPE = "PlanMainInfoType"; //计划管理类型
    public static final String PLAN_MAIN_INFO_TYPE_SAFE = "safe"; //计划管理类型--安全监督计划
    public static final String PLAN_MAIN_INFO_TYPE_QUALITY = "quality"; //计划管理类型--质量监督计划
    public static final String PLAN_MAIN_INFO_TYPE_SPECIAL = "special"; //计划管理类型--专项监督计划
    public static final String PLAN_MAIN_INFO_TYPE_ORDER = "order"; //计划管理类型--预约监督
    public static final String PLAN_MAIN_INFO_TYPE_CHECK = "check"; //计划管理类型--稽查监督计划

    //计划管理状态
    public static final String PLAN_MAIN_INFO_STATUS = "PlanMainInfoStatus"; //计划管理状态
    public static final String PLAN_MAIN_INFO_STATUS_EDIT = "edit"; //计划管理状态--填写中
    public static final String PLAN_MAIN_INFO_STATUS_SUBMIT = "submit"; //计划管理状态--待审核
    public static final String PLAN_MAIN_INFO_STATUS_BACK = "back"; //计划管理状态--审核退回
    public static final String PLAN_MAIN_INFO_STATUS_EXCUTE = "excute"; //计划管理状态--执行中
    public static final String PLAN_MAIN_INFO_STATUS_COMPLETE = "complete"; //计划管理状态--已完成

    //计划管理审核意见
    public static final String PLAN_MAIN_INFO_OPINION = "PlanMainInfoOpinion"; //计划管理审核意见
    public static final String PLAN_MAIN_INFO_OPINION_OK = "ok"; //计划管理审核意见--同意
    public static final String PLAN_MAIN_INFO_OPINION_NO = "no"; //计划管理审核意见--不同意

    //计划管理监督状态
    public static final String PLAN_DETAIL_STATUS = "PlanDetailStatus"; //计划管理监督状态
    public static final String PLAN_DETAIL_STATUS_NOCHECK = "nocheck"; //计划管理监督状态--未监督
    public static final String PLAN_DETAIL_STATUS_CHECKED = "checked"; //计划管理监督状态--已监督
    public static final String PLAN_DETAIL_STATUS_CANCEL = "cancel"; //计划管理监督状态--已取消

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

    public static final String JD_REPORT_TYPE = "JdReportType";//监督报告类型
    public static final String JD_REPORT_TYPE_CITY = "city";//监督报告类型--市政
    public static final String JD_REPORT_TYPE_ZHUANGXIU = "zx";//监督报告类型--装修
    public static final String JD_REPORT_TYPE_NOJN = "nojn";//监督报告类型--无节能
    public static final String JD_REPORT_TYPE_HASJN = "hasjn";//监督报告类型--有节能

    public static final String JD_PERSON_SUBJECT_TYPE = "JdPersonSubject";//监督人员专业类别

    public static final String JD_TASK_FILTER_DWDW = "'A2AZSH','B2AZSJ','B2JGSJ'";//监督任务书过滤单位代码

    public static final String GRID_SQL_KEY = "gsk";  //excel导出时将sql放入session所用的key

    public static final String SYS_REGPERSON_TYPE = "SysRegPersonType"; //注册人员类型--类型（工地,项目,企业）
    //    public static final String SYS_REGPERSON_TYPE_Unit = "company"; //注册人员类型--类型-企业
//    public static final String SYS_REGPERSON_TYPE_Pro = "project"; //注册人员类型--类型--项目
    public static final String SYS_REGPERSON_TYPE_Gd = "gongdi"; //注册人员类型--类型--工地--暂时保留
    public static final String SYS_REGPERSON_TYPE_UNIT_SG = "sg";  //注册人员类型--类型-施工单位(原类型：企业)
    public static final String SYS_REGPERSON_TYPE_UNIT_JL = "jl";  //注册人员类型--类型-监理单位
    public static final String SYS_REGPERSON_TYPE_UNIT_JS = "js";  //注册人员类型--类型-建设单位(原类型：项目)


    public static final String SYS_JDARCHIEVINFO_STATUS = "JdArchiveInfoStatus";          //监督档案--状态
    public static final String SYS_JDARCHIEVINFO_STATUS_NORMAL = "normal";          //监督档案--正常
    public static final String SYS_JDARCHIEVINFO_STATUS_BORROW = "outborrow";          //监督档案--借出

    //信访管理
    public static final String PETITON_RECORD_STATUS = "PetitonRecordStatus";          //信访管理受理状态
    public static final String PETITON_RECORD_SOURCE = "PetitonRecordSource";          //信访管理来源类型
    public static final String PETITON_RECORD_TYPE = "PetitonRecordType";              //信访管理信访种类

    //工作组管理
    public static final String POLLING_WORK_GROUP_ZRQU = "zrqu";       //工作组管理责任区域

    //工地考勤
    public static final String CHECK_MANAGER_POSITION = "positionType";       //工地岗位类型
    public static final String CHECK_MANAGER_POSITION_SBGUL = "sbgul";       //设备管理员

    //六无工地状态
    public static final String POLLING_UNLAWFUL_PROJECT_STATUS = "PollingUnlawfulProjectStatus"; //六无工地处理状态
    public static final String POLLING_UNLAWFUL_PROJECT_STATUS_PROCESSED = "processed"; //已处理
    public static final String POLLING_UNLAWFUL_PROJECT_STATUS_UNPROCESSED = "unprocessed"; //未处理

    /****************************************** 系统代码 end *******************************************************/

    /**
     * *************************************** 业务模块 begin ******************************************************
     */
    //标段单位类型
    public static final String BID_UNIT_TYPE_SG = "sg"; //施工单位
    public static final String BID_UNIT_TYPE_JL = "jl"; //监理单位
    public static final String BID_UNIT_TYPE_KC = "kc"; //勘察单位
    public static final String BID_UNIT_TYPE_SJ = "sj"; //设计单位
    public static final String BID_UNIT_TYPE_Small = "small"; //小型项目

    //项目查询tab页标记区分
    public static final int PROJECT_QUERY_TAB_BJ = 1; //报建项目
    public static final int PROJECT_QUERY_TAB_ZJ = 2; //在建项目
    public static final int PROJECT_QUERY_TAB_WGWY = 3; //完工未验项目
    public static final int PROJECT_QUERY_SMALL_PROJECT = 4; //小型项目
    public static final String PROJECT_BID_SIGN_STATUS = "ProjectBidSignStatus"; //招标保证金管理状态
    public static final String PROJECT_BID_SIGN_STATUS_DJ = "1"; //招标保证金管理状态--招标登记
    public static final String PROJECT_BID_SIGN_STATUS_DS = "2"; //招标保证金管理状态--待收保证金
    public static final String PROJECT_BID_SIGN_STATUS_DT = "3"; //招标保证金管理状态--待退保证金
    public static final String PROJECT_BID_SIGN_STATUS_YQR = "4"; //招标保证金管理状态--已确认待退
    public static final String PROJECT_BID_SIGN_STATUS_YT = "5"; //招标保证金管理状态--已退保证金
    /****************************************** 业务模块 end *******************************************************/

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
     * *************************************** Excel监督任务书 begin ******************************************************
     */
    public static final String EXCEL_JDTASK_POSITION = "ProBelongArea"; //项目属地
    //    public static final String EXCEL_JDTASK_PROPERTY = "JdTaskProperty"; //工程性质
    public static final String EXCEL_JDTASK_OTHER1 = "JdTaskOther1"; //其他信息1
    public static final String EXCEL_JDTASK_OTHER2 = "JdTaskOther2"; //其他信息2
    public static final String EXCEL_JDTASK_OTHER3 = "JdTaskOther3"; //其他信息3
    public static final String EXCEL_JDTASK_OTHER4 = "JdTaskOther4"; //其他信息4
    public static final String EXCEL_JDTASK_OTHER5 = "JdTaskOther5"; //其他信息5
    public static final String EXCEL_JDTASK_SCHEDULE = "JdTaskDwgcSchedule"; //单位工程进度
    /****************************************** Excel监督任务书 end *******************************************************/

    /**
     * *************************************** 网上项目报建 begin ******************************************************
     */
    public static final String NET_FILE_CATEGORY = "NetFileCategory"; //申报材料环节
    public static final String NET_CONSTRUCTION_UNIT_PROPERTY = "NetConstructionUnitProperty"; //建设单位性质
    public static final String NET_BUILD_PROPERTY = "NetBuildProperty"; //建设性质
    public static final String NET_PROJECT_TYPE = "NetProjectType"; //项目分类
    public static final String NET_PROJECT_TYPE_OTHER = "NetProjectTypeOther"; //项目分类(其他)
    public static final String NET_PRO_HEADER_CERT = "NetProHeaderCert"; //身份类别

    /****************************************** 网上项目报建 end *******************************************************/

    /**
     * *************************************** 网上项目报建安全质量监督 begin ******************************************************
     */


    public static final String NET_KCDW = "NetKcdw";//安全质量监督勘察单位
    public static final String NET_SJDW = "NetSjdw";//安全质量监督设计单位
    public static final String NET_SGZBDW = "NetSgzbdw";//安全质量监督施工总包单位
    public static final String NET_JLDW = "NetJldw"; //安全质量监督监理单位
    public static final String NET_JSDW = "NetJsdw"; //安全质量监督建设单位
    /**
     * *************************************** 网上项目报建安全质量监督 end ******************************************************
     */

    /**
     * *************************************** 网上项目报建安全质量监督单位工程 begin ******************************************************
     */
    public static final String NET_JDTASK_DWGC_TYPE = "NetJdTaskDwgcType"; //安全质量监督单位工程类型
    public static final String NET_JDTASK_DWGC_CONSTRUCT_TYPE = "NetJdTaskDwgcConstructType"; //质量监督单位工程结构类型
    /****************************************** 网上项目报建安全质量监督单位工程 end *******************************************************/

    /**
     * *************************************** 市场监管 begin ******************************************************
     */
    public static final String SCJG_BID_RECORD_METHOD = "ScjgBidRecordMethod"; //招投标监管记录--招标方式
    public static final String SCJG_BID_RECORD_BIZTYPE = "ScjgBidRecordBiztype"; //招投标监管记录--业务类型(监督类别)
    public static final String SCJG_BID_RECORD_STAGE = "ScjgBidRecordStage"; //招投标监管记录--监督阶段(监督类别)
    public static final String SCJG_SPECIAL_WORKER_TYPE = "ScjgSpecialWorkerType"; //特种作业人员--种类
    /****************************************** 市场监管 end *******************************************************/

    /**
     * *************************************** 企业信息上报 begin ******************************************************
     */
    public static final String FILE_TYPE = "FileType"; //文件类别
    public static final String FILE_TYPE_AQSCZC = "aqsczc"; //文件类别 ,安全生产自查情况
    public static final String FILE_TYPE_SGAQYS = "sgaqys"; //文件类别 ,施工安全因素指标

    public static final String PLAT_DANGERSOURCE_TYPE = "PlatDangersourceType"; //危险源上报--类别
    public static final String PLAT_DANGERSOURCE_ACTION = "PlatDangersourceAction"; //危险源上报--采取措施

    /****************************************** 企业信息上报 end *******************************************************/

    /**
     * *************************************** 新监督记录 begin ******************************************************
     */
    //问题类别--对应字段：JD_RECORD_QUESTION.TYPE_CODE
    public static final String JD_RECORD_FIRST_CHECK_NORMAL = "normal"; //首次监督--问题类别--正常
    public static final String JD_RECORD_SAFE_CHECK_BEHAVIOR = "behavior"; //安全监督--问题类别--行为检查
    public static final String JD_RECORD_SAFE_CHECK_FACILITY = "facility"; //安全监督--问题类别--设施检查
    public static final String JD_RECORD_QUALITY_CHECK_BEHAVIOR = "behavior"; //质量监督--问题类别--行为抽查
    public static final String JD_RECORD_QUALITY_CHECK_ENTITY = "entity"; //质量监督--问题类别--实体抽查
    public static final String JD_RECORD_COMPLETE_CHECK_OTHER = "other"; //竣工验收监督--问题类别--其他抽查
    public static final String JD_RECORD_SAFE_SS_TYPE = "JdRecordSafeSsType"; //过程安全监督-设施类型

    public static final String JD_RECORD_COMPLETE_CONDITION_TYPE = "JdRecordCompleteCondition"; //竣工验收监督--验收条件类别

    public static final String JD_JL_REPORT_TYPE = "JdJlReportType"; //监督--监理报告类型
    public static final String JD_CYSB_TYPE = "JdCysbType"; //监督--创优申报类型
    /****************************************** 新监督记录 end *******************************************************/

    /**
     * *************************************** 务工人员管理 begin ******************************************************
     */
    public static final String WORKER_MONEY_TYPE = "WorkerMoneyType"; //务工人员款项类型
    /****************************************** 务工人员管理 end *******************************************************/

    /**
     * *************************************** 安全监督 begin ******************************************************
     */
    public static final String SAFE_PRODUCT_CHECK_LEVEL = "SafeProductLevel"; //安全生产季度考核评定等级
    /****************************************** 安全监督 end *******************************************************/

    /**
     * *************************************** 项目审批 begin ******************************************************
     */
    public static final String NET_APPLY_FB_TYPE = "NetApplyFbType"; //项目审批_网上报建_发包类型
    public static final String NET_CFB_FB_TYPE = "NetCfbFbType"; //项目审批_承发包_发包类型
    public static final String NET_CFB_FB_TYPE_SG = "sg"; //项目审批_承发包_发包类型--施工
    public static final String NET_CONTRACT_TYPE = "NetContractType"; //项目合同备案--合同类型
    /****************************************** 项目审批 end *******************************************************/
    /**
     * ***************************************视频管理begin*********************************************************
     */
     public static final String MON_SERVER_TYPE ="MonServerType"; //视频服务器类型
     public static final String MON_CONNECT_TYPE ="MonConnectType";//连接类型
     public static final String MON_CAMERA_TYPE ="MonCameraType"; //探头类型
    /****************************************** 视频管理 end *******************************************************/


    /**
     * ***************************************执法监督管理begin*********************************************************
     */
    public static final String WORKER_TALK_FORM_LISTS ="WorkerTalkFormLists"; //视频服务器类型

    /****************************************** 执法监督管理 end *******************************************************/
}
