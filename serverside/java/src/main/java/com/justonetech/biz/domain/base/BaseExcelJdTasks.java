package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the EXCEL_JD_TASKS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : Excel导入监督任务书
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : Excel导入监督任务书
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : syn
 * Projectable : false
 *
 * @hibernate.class
 *  table="EXCEL_JD_TASKS"
 */

public abstract class BaseExcelJdTasks  implements Serializable {

    public static String REF = "ExcelJdTasks";
    public static String PROP_BID = "bid";
    public static String PROP_OTHER2 = "other2";
    public static String PROP_OTHER3 = "other3";
    public static String PROP_KC_UNIT_NAME = "kcUnitName";
    public static String PROP_JD_DATETIME = "jdDatetime";
    public static String PROP_PROPERTY = "property";
    public static String PROP_OTHER1 = "other1";
    public static String PROP_CONT_MONEY = "contMoney";
    public static String PROP_OTHER4 = "other4";
    public static String PROP_OTHER5 = "other5";
    public static String PROP_JL_LINKMAN = "jlLinkman";
    public static String PROP_JAGZL = "jagzl";
    public static String PROP_SGZB_UNIT_CODE = "sgzbUnitCode";
    public static String PROP_FLOW_CODE = "flowCode";
    public static String PROP_JD_TASK_CODE = "jdTaskCode";
    public static String PROP_SJ_PHONE = "sjPhone";
    public static String PROP_SYN_DATETIME = "synDatetime";
    public static String PROP_SJ_UNIT_NAME = "sjUnitName";
    public static String PROP_PROJECT_NAME = "projectName";
    public static String PROP_SG_PHONE = "sgPhone";
    public static String PROP_JS_PHONE = "jsPhone";
    public static String PROP_PROJECT_ADD = "projectAdd";
    public static String PROP_SG_LINKMAN = "sgLinkman";
    public static String PROP_JS_LINKMAN = "jsLinkman";
    public static String PROP_MEMO = "memo";
    public static String PROP_ID = "id";
    public static String PROP_SGZB_PHONE = "sgzbPhone";
    public static String PROP_DTSL = "dtsl";
    public static String PROP_CHANGE_TIME = "changeTime";
    public static String PROP_BUILD_AREA = "buildArea";
    public static String PROP_JL_UNIT_CODE = "jlUnitCode";
    public static String PROP_ZIPCODE = "zipcode";
    public static String PROP_KC_PHONE = "kcPhone";
    public static String PROP_REPORT_TYPE = "reportType";
    public static String PROP_JL_UNIT_NAME = "jlUnitName";
    public static String PROP_BJBH = "bjbh";
    public static String PROP_IS_MANAGER_CHECK = "isManagerCheck";
    public static String PROP_SG_UNIT_CODE = "sgUnitCode";
    public static String PROP_JS_UNIT_NAME = "jsUnitName";
    public static String PROP_Y = "y";
    public static String PROP_X = "x";
    public static String PROP_SGZB_LINKMAN = "sgzbLinkman";
    public static String PROP_JS_UNIT_ADD = "jsUnitAdd";
    public static String PROP_IS_REMOTE_MONITOR = "isRemoteMonitor";
    public static String PROP_JS_UNIT_CODE = "jsUnitCode";
    public static String PROP_SJ_LINKMAN = "sjLinkman";
    public static String PROP_SG_UNIT_NAME = "sgUnitName";
    public static String PROP_KC_LINKMAN = "kcLinkman";
    public static String PROP_KC_UNIT_CODE = "kcUnitCode";
    public static String PROP_SJ_UNIT_CODE = "sjUnitCode";
    public static String PROP_POSITION = "position";
    public static String PROP_BELONG_AREA = "belongArea";
    public static String PROP_SGZB_UNIT_NAME = "sgzbUnitName";
    public static String PROP_JL_PHONE = "jlPhone";


    // constructors
    public BaseExcelJdTasks () {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseExcelJdTasks (java.lang.Long id) {
        this.setId(id);
        initialize();
    }

    protected void initialize () {}



    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Long id;

    // fields
    /*流转编号*/
    /*流转编号*/
    private java.lang.String flowCode;

    /*报监日期*/
    /*报监日期*/
    private java.sql.Timestamp jdDatetime;

    /*报建编号*/
    /*报建编号*/
    private java.lang.String bjbh;

    /*监督任务书编号*/
    /*监督任务书编号*/
    private java.lang.String jdTaskCode;

    /*标段号*/
    /*标段号*/
    private java.lang.String bid;

    /*项目名称*/
    /*项目名称*/
    private java.lang.String projectName;

    /*工程地点*/
    /*工程地点*/
    private java.lang.String projectAdd;

    /*所在区县*/
    /*所在区县*/
    private java.lang.String belongArea;

    /*合同价*/
    /*合同价*/
    private java.lang.Double contMoney;

    /*建设单位*/
    /*建设单位*/
    private java.lang.String jsUnitName;

    /*建设单位地址*/
    /*建设单位地址*/
    private java.lang.String jsUnitAdd;

    /*邮政编码*/
    /*邮政编码*/
    private java.lang.String zipcode;

    /*建设单位联系人*/
    /*建设单位联系人*/
    private java.lang.String jsLinkman;

    /*建设单位联系电话*/
    /*建设单位联系电话*/
    private java.lang.String jsPhone;

    /*施工总包单位*/
    /*施工总包单位*/
    private java.lang.String sgzbUnitName;

    /*施工总包单位联系人*/
    /*施工总包单位联系人*/
    private java.lang.String sgzbLinkman;

    /*施工总包单位联系电话*/
    /*施工总包单位联系电话*/
    private java.lang.String sgzbPhone;

    /*勘察单位*/
    /*勘察单位*/
    private java.lang.String kcUnitName;

    /*勘察单位联系人*/
    /*勘察单位联系人*/
    private java.lang.String kcLinkman;

    /*勘察单位联系电话*/
    /*勘察单位联系电话*/
    private java.lang.String kcPhone;

    /*设计单位*/
    /*设计单位*/
    private java.lang.String sjUnitName;

    /*设计单位联系人*/
    /*设计单位联系人*/
    private java.lang.String sjLinkman;

    /*设计单位联系电话*/
    /*设计单位联系电话*/
    private java.lang.String sjPhone;

    /*监理单位*/
    /*监理单位*/
    private java.lang.String jlUnitName;

    /*监理单位联系人*/
    /*监理单位联系人*/
    private java.lang.String jlLinkman;

    /*监理单位联系电话*/
    /*监理单位联系电话*/
    private java.lang.String jlPhone;

    /*施工单位*/
    /*施工单位*/
    private java.lang.String sgUnitName;

    /*施工单位联系人*/
    /*施工单位联系人*/
    private java.lang.String sgLinkman;

    /*施工单位联系电话*/
    /*施工单位联系电话*/
    private java.lang.String sgPhone;

    /*备注*/
    /*备注*/
    private java.lang.String memo;

    /*变化时间*/
    /*变化时间*/
    private java.sql.Timestamp changeTime;

    /*同步时间*/
    /*同步时间*/
    private java.sql.Timestamp synDatetime;

    /*建安工作量*/
    /*建安工作量*/
    private double jagzl;

    /*面积*/
    /*面积*/
    private double buildArea;

    /*单体数量*/
    /*单体数量*/
    private java.lang.Integer dtsl;

    /*工程性质*/
    /*工程性质*/
    private java.lang.String property;

    /*地图标注X*/
    /*地图标注X*/
    private java.lang.Double x;

    /*地图标注Y*/
    /*地图标注Y*/
    private java.lang.Double y;

    /*是否远程监控*/
    /*是否远程监控*/
    private java.lang.Boolean isRemoteMonitor;

    /*是否管理人员考勤*/
    /*是否管理人员考勤*/
    private java.lang.Boolean isManagerCheck;

    /*其他信息1*/
    /*其他信息1*/
    private java.lang.String other1;

    /*其他信息2*/
    /*其他信息2*/
    private java.lang.String other2;

    /*其他信息3*/
    /*其他信息3*/
    private java.lang.String other3;

    /*其他信息4*/
    /*其他信息4*/
    private java.lang.String other4;

    /*其他信息5*/
    /*其他信息5*/
    private java.lang.String other5;

    /*项目属地*/
    /*项目属地*/
    private java.lang.String position;

    /*项目类型*/
    /*项目类型*/
    private java.lang.String reportType;

    /*建设单位代码*/
    /*建设单位代码*/
    private java.lang.String jsUnitCode;

    /*施工总包单位代码*/
    /*施工总包单位代码*/
    private java.lang.String sgzbUnitCode;

    /*勘察单位代码*/
    /*勘察单位代码*/
    private java.lang.String kcUnitCode;

    /*设计单位代码*/
    /*设计单位代码*/
    private java.lang.String sjUnitCode;

    /*监理单位代码*/
    /*监理单位代码*/
    private java.lang.String jlUnitCode;

    /*施工单位代码*/
    /*施工单位代码*/
    private java.lang.String sgUnitCode;




    /**
     * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="com.justonetech.core.orm.hibernate.LongIdGenerator"
     *  column="ID"
     */
    public java.lang.Long getId () {
        return id;
    }

    /**
     * Set the unique identifier of this class
     * @param id the new ID
     * @deprecated
     */
    public void setId (java.lang.Long id) {
        this.id = id;
        this.hashCode = Integer.MIN_VALUE;
    }




    /**
     * Return the value associated with the column: FLOW_CODE
     */
    public java.lang.String getFlowCode () {
        return flowCode;
    }

    /**
     * Set the value related to the column: FLOW_CODE
     * @param flowCode the FLOW_CODE value
     */
    public void setFlowCode (java.lang.String flowCode) {
        this.flowCode = flowCode;
    }


    /**
     * Return the value associated with the column: JD_DATETIME
     */
    public java.sql.Timestamp getJdDatetime () {
        return jdDatetime;
    }

    /**
     * Set the value related to the column: JD_DATETIME
     * @param jdDatetime the JD_DATETIME value
     */
    public void setJdDatetime (java.sql.Timestamp jdDatetime) {
        this.jdDatetime = jdDatetime;
    }


    /**
     * Return the value associated with the column: BJBH
     */
    public java.lang.String getBjbh () {
        return bjbh;
    }

    /**
     * Set the value related to the column: BJBH
     * @param bjbh the BJBH value
     */
    public void setBjbh (java.lang.String bjbh) {
        this.bjbh = bjbh;
    }


    /**
     * Return the value associated with the column: JD_TASK_CODE
     */
    public java.lang.String getJdTaskCode () {
        return jdTaskCode;
    }

    /**
     * Set the value related to the column: JD_TASK_CODE
     * @param jdTaskCode the JD_TASK_CODE value
     */
    public void setJdTaskCode (java.lang.String jdTaskCode) {
        this.jdTaskCode = jdTaskCode;
    }


    /**
     * Return the value associated with the column: BID
     */
    public java.lang.String getBid () {
        return bid;
    }

    /**
     * Set the value related to the column: BID
     * @param bid the BID value
     */
    public void setBid (java.lang.String bid) {
        this.bid = bid;
    }


    /**
     * Return the value associated with the column: PROJECT_NAME
     */
    public java.lang.String getProjectName () {
        return projectName;
    }

    /**
     * Set the value related to the column: PROJECT_NAME
     * @param projectName the PROJECT_NAME value
     */
    public void setProjectName (java.lang.String projectName) {
        this.projectName = projectName;
    }


    /**
     * Return the value associated with the column: PROJECT_ADD
     */
    public java.lang.String getProjectAdd () {
        return projectAdd;
    }

    /**
     * Set the value related to the column: PROJECT_ADD
     * @param projectAdd the PROJECT_ADD value
     */
    public void setProjectAdd (java.lang.String projectAdd) {
        this.projectAdd = projectAdd;
    }


    /**
     * Return the value associated with the column: BELONG_AREA
     */
    public java.lang.String getBelongArea () {
        return belongArea;
    }

    /**
     * Set the value related to the column: BELONG_AREA
     * @param belongArea the BELONG_AREA value
     */
    public void setBelongArea (java.lang.String belongArea) {
        this.belongArea = belongArea;
    }


    /**
     * Return the value associated with the column: CONT_MONEY
     */
    public java.lang.Double getContMoney () {
        return contMoney;
    }

    /**
     * Set the value related to the column: CONT_MONEY
     * @param contMoney the CONT_MONEY value
     */
    public void setContMoney (java.lang.Double contMoney) {
        this.contMoney = contMoney;
    }


    /**
     * Return the value associated with the column: JS_UNIT_NAME
     */
    public java.lang.String getJsUnitName () {
        return jsUnitName;
    }

    /**
     * Set the value related to the column: JS_UNIT_NAME
     * @param jsUnitName the JS_UNIT_NAME value
     */
    public void setJsUnitName (java.lang.String jsUnitName) {
        this.jsUnitName = jsUnitName;
    }


    /**
     * Return the value associated with the column: JS_UNIT_ADD
     */
    public java.lang.String getJsUnitAdd () {
        return jsUnitAdd;
    }

    /**
     * Set the value related to the column: JS_UNIT_ADD
     * @param jsUnitAdd the JS_UNIT_ADD value
     */
    public void setJsUnitAdd (java.lang.String jsUnitAdd) {
        this.jsUnitAdd = jsUnitAdd;
    }


    /**
     * Return the value associated with the column: ZIPCODE
     */
    public java.lang.String getZipcode () {
        return zipcode;
    }

    /**
     * Set the value related to the column: ZIPCODE
     * @param zipcode the ZIPCODE value
     */
    public void setZipcode (java.lang.String zipcode) {
        this.zipcode = zipcode;
    }


    /**
     * Return the value associated with the column: JS_LINKMAN
     */
    public java.lang.String getJsLinkman () {
        return jsLinkman;
    }

    /**
     * Set the value related to the column: JS_LINKMAN
     * @param jsLinkman the JS_LINKMAN value
     */
    public void setJsLinkman (java.lang.String jsLinkman) {
        this.jsLinkman = jsLinkman;
    }


    /**
     * Return the value associated with the column: JS_PHONE
     */
    public java.lang.String getJsPhone () {
        return jsPhone;
    }

    /**
     * Set the value related to the column: JS_PHONE
     * @param jsPhone the JS_PHONE value
     */
    public void setJsPhone (java.lang.String jsPhone) {
        this.jsPhone = jsPhone;
    }


    /**
     * Return the value associated with the column: SGZB_UNIT_NAME
     */
    public java.lang.String getSgzbUnitName () {
        return sgzbUnitName;
    }

    /**
     * Set the value related to the column: SGZB_UNIT_NAME
     * @param sgzbUnitName the SGZB_UNIT_NAME value
     */
    public void setSgzbUnitName (java.lang.String sgzbUnitName) {
        this.sgzbUnitName = sgzbUnitName;
    }


    /**
     * Return the value associated with the column: SGZB_LINKMAN
     */
    public java.lang.String getSgzbLinkman () {
        return sgzbLinkman;
    }

    /**
     * Set the value related to the column: SGZB_LINKMAN
     * @param sgzbLinkman the SGZB_LINKMAN value
     */
    public void setSgzbLinkman (java.lang.String sgzbLinkman) {
        this.sgzbLinkman = sgzbLinkman;
    }


    /**
     * Return the value associated with the column: SGZB_PHONE
     */
    public java.lang.String getSgzbPhone () {
        return sgzbPhone;
    }

    /**
     * Set the value related to the column: SGZB_PHONE
     * @param sgzbPhone the SGZB_PHONE value
     */
    public void setSgzbPhone (java.lang.String sgzbPhone) {
        this.sgzbPhone = sgzbPhone;
    }


    /**
     * Return the value associated with the column: KC_UNIT_NAME
     */
    public java.lang.String getKcUnitName () {
        return kcUnitName;
    }

    /**
     * Set the value related to the column: KC_UNIT_NAME
     * @param kcUnitName the KC_UNIT_NAME value
     */
    public void setKcUnitName (java.lang.String kcUnitName) {
        this.kcUnitName = kcUnitName;
    }


    /**
     * Return the value associated with the column: KC_LINKMAN
     */
    public java.lang.String getKcLinkman () {
        return kcLinkman;
    }

    /**
     * Set the value related to the column: KC_LINKMAN
     * @param kcLinkman the KC_LINKMAN value
     */
    public void setKcLinkman (java.lang.String kcLinkman) {
        this.kcLinkman = kcLinkman;
    }


    /**
     * Return the value associated with the column: KC_PHONE
     */
    public java.lang.String getKcPhone () {
        return kcPhone;
    }

    /**
     * Set the value related to the column: KC_PHONE
     * @param kcPhone the KC_PHONE value
     */
    public void setKcPhone (java.lang.String kcPhone) {
        this.kcPhone = kcPhone;
    }


    /**
     * Return the value associated with the column: SJ_UNIT_NAME
     */
    public java.lang.String getSjUnitName () {
        return sjUnitName;
    }

    /**
     * Set the value related to the column: SJ_UNIT_NAME
     * @param sjUnitName the SJ_UNIT_NAME value
     */
    public void setSjUnitName (java.lang.String sjUnitName) {
        this.sjUnitName = sjUnitName;
    }


    /**
     * Return the value associated with the column: SJ_LINKMAN
     */
    public java.lang.String getSjLinkman () {
        return sjLinkman;
    }

    /**
     * Set the value related to the column: SJ_LINKMAN
     * @param sjLinkman the SJ_LINKMAN value
     */
    public void setSjLinkman (java.lang.String sjLinkman) {
        this.sjLinkman = sjLinkman;
    }


    /**
     * Return the value associated with the column: SJ_PHONE
     */
    public java.lang.String getSjPhone () {
        return sjPhone;
    }

    /**
     * Set the value related to the column: SJ_PHONE
     * @param sjPhone the SJ_PHONE value
     */
    public void setSjPhone (java.lang.String sjPhone) {
        this.sjPhone = sjPhone;
    }


    /**
     * Return the value associated with the column: JL_UNIT_NAME
     */
    public java.lang.String getJlUnitName () {
        return jlUnitName;
    }

    /**
     * Set the value related to the column: JL_UNIT_NAME
     * @param jlUnitName the JL_UNIT_NAME value
     */
    public void setJlUnitName (java.lang.String jlUnitName) {
        this.jlUnitName = jlUnitName;
    }


    /**
     * Return the value associated with the column: JL_LINKMAN
     */
    public java.lang.String getJlLinkman () {
        return jlLinkman;
    }

    /**
     * Set the value related to the column: JL_LINKMAN
     * @param jlLinkman the JL_LINKMAN value
     */
    public void setJlLinkman (java.lang.String jlLinkman) {
        this.jlLinkman = jlLinkman;
    }


    /**
     * Return the value associated with the column: JL_PHONE
     */
    public java.lang.String getJlPhone () {
        return jlPhone;
    }

    /**
     * Set the value related to the column: JL_PHONE
     * @param jlPhone the JL_PHONE value
     */
    public void setJlPhone (java.lang.String jlPhone) {
        this.jlPhone = jlPhone;
    }


    /**
     * Return the value associated with the column: SG_UNIT_NAME
     */
    public java.lang.String getSgUnitName () {
        return sgUnitName;
    }

    /**
     * Set the value related to the column: SG_UNIT_NAME
     * @param sgUnitName the SG_UNIT_NAME value
     */
    public void setSgUnitName (java.lang.String sgUnitName) {
        this.sgUnitName = sgUnitName;
    }


    /**
     * Return the value associated with the column: SG_LINKMAN
     */
    public java.lang.String getSgLinkman () {
        return sgLinkman;
    }

    /**
     * Set the value related to the column: SG_LINKMAN
     * @param sgLinkman the SG_LINKMAN value
     */
    public void setSgLinkman (java.lang.String sgLinkman) {
        this.sgLinkman = sgLinkman;
    }


    /**
     * Return the value associated with the column: SG_PHONE
     */
    public java.lang.String getSgPhone () {
        return sgPhone;
    }

    /**
     * Set the value related to the column: SG_PHONE
     * @param sgPhone the SG_PHONE value
     */
    public void setSgPhone (java.lang.String sgPhone) {
        this.sgPhone = sgPhone;
    }


    /**
     * Return the value associated with the column: MEMO
     */
    public java.lang.String getMemo () {
        return memo;
    }

    /**
     * Set the value related to the column: MEMO
     * @param memo the MEMO value
     */
    public void setMemo (java.lang.String memo) {
        this.memo = memo;
    }


    /**
     * Return the value associated with the column: CHANGE_TIME
     */
    public java.sql.Timestamp getChangeTime () {
        return changeTime;
    }

    /**
     * Set the value related to the column: CHANGE_TIME
     * @param changeTime the CHANGE_TIME value
     */
    public void setChangeTime (java.sql.Timestamp changeTime) {
        this.changeTime = changeTime;
    }


    /**
     * Return the value associated with the column: SYN_DATETIME
     */
    public java.sql.Timestamp getSynDatetime () {
        return synDatetime;
    }

    /**
     * Set the value related to the column: SYN_DATETIME
     * @param synDatetime the SYN_DATETIME value
     */
    public void setSynDatetime (java.sql.Timestamp synDatetime) {
        this.synDatetime = synDatetime;
    }


    /**
     * Return the value associated with the column: JAGZL
     */
    public double getJagzl () {
        return jagzl;
    }

    /**
     * Set the value related to the column: JAGZL
     * @param jagzl the JAGZL value
     */
    public void setJagzl (double jagzl) {
        this.jagzl = jagzl;
    }


    /**
     * Return the value associated with the column: BUILD_AREA
     */
    public double getBuildArea () {
        return buildArea;
    }

    /**
     * Set the value related to the column: BUILD_AREA
     * @param buildArea the BUILD_AREA value
     */
    public void setBuildArea (double buildArea) {
        this.buildArea = buildArea;
    }


    /**
     * Return the value associated with the column: DTSL
     */
    public java.lang.Integer getDtsl () {
        return dtsl;
    }

    /**
     * Set the value related to the column: DTSL
     * @param dtsl the DTSL value
     */
    public void setDtsl (java.lang.Integer dtsl) {
        this.dtsl = dtsl;
    }


    /**
     * Return the value associated with the column: PROPERTY
     */
    public java.lang.String getProperty () {
        return property;
    }

    /**
     * Set the value related to the column: PROPERTY
     * @param property the PROPERTY value
     */
    public void setProperty (java.lang.String property) {
        this.property = property;
    }


    /**
     * Return the value associated with the column: X
     */
    public java.lang.Double getX () {
        return x;
    }

    /**
     * Set the value related to the column: X
     * @param x the X value
     */
    public void setX (java.lang.Double x) {
        this.x = x;
    }


    /**
     * Return the value associated with the column: Y
     */
    public java.lang.Double getY () {
        return y;
    }

    /**
     * Set the value related to the column: Y
     * @param y the Y value
     */
    public void setY (java.lang.Double y) {
        this.y = y;
    }


    /**
     * Return the value associated with the column: IS_REMOTE_MONITOR
     */
    public java.lang.Boolean getIsRemoteMonitor () {
        return isRemoteMonitor;
    }

    /**
     * Set the value related to the column: IS_REMOTE_MONITOR
     * @param isRemoteMonitor the IS_REMOTE_MONITOR value
     */
    public void setIsRemoteMonitor (java.lang.Boolean isRemoteMonitor) {
        this.isRemoteMonitor = isRemoteMonitor;
    }


    /**
     * Return the value associated with the column: IS_MANAGER_CHECK
     */
    public java.lang.Boolean getIsManagerCheck () {
        return isManagerCheck;
    }

    /**
     * Set the value related to the column: IS_MANAGER_CHECK
     * @param isManagerCheck the IS_MANAGER_CHECK value
     */
    public void setIsManagerCheck (java.lang.Boolean isManagerCheck) {
        this.isManagerCheck = isManagerCheck;
    }


    /**
     * Return the value associated with the column: OTHER1
     */
    public java.lang.String getOther1 () {
        return other1;
    }

    /**
     * Set the value related to the column: OTHER1
     * @param other1 the OTHER1 value
     */
    public void setOther1 (java.lang.String other1) {
        this.other1 = other1;
    }


    /**
     * Return the value associated with the column: OTHER2
     */
    public java.lang.String getOther2 () {
        return other2;
    }

    /**
     * Set the value related to the column: OTHER2
     * @param other2 the OTHER2 value
     */
    public void setOther2 (java.lang.String other2) {
        this.other2 = other2;
    }


    /**
     * Return the value associated with the column: OTHER3
     */
    public java.lang.String getOther3 () {
        return other3;
    }

    /**
     * Set the value related to the column: OTHER3
     * @param other3 the OTHER3 value
     */
    public void setOther3 (java.lang.String other3) {
        this.other3 = other3;
    }


    /**
     * Return the value associated with the column: OTHER4
     */
    public java.lang.String getOther4 () {
        return other4;
    }

    /**
     * Set the value related to the column: OTHER4
     * @param other4 the OTHER4 value
     */
    public void setOther4 (java.lang.String other4) {
        this.other4 = other4;
    }


    /**
     * Return the value associated with the column: OTHER5
     */
    public java.lang.String getOther5 () {
        return other5;
    }

    /**
     * Set the value related to the column: OTHER5
     * @param other5 the OTHER5 value
     */
    public void setOther5 (java.lang.String other5) {
        this.other5 = other5;
    }


    /**
     * Return the value associated with the column: POSITION
     */
    public java.lang.String getPosition () {
        return position;
    }

    /**
     * Set the value related to the column: POSITION
     * @param position the POSITION value
     */
    public void setPosition (java.lang.String position) {
        this.position = position;
    }


    /**
     * Return the value associated with the column: REPORT_TYPE
     */
    public java.lang.String getReportType () {
        return reportType;
    }

    /**
     * Set the value related to the column: REPORT_TYPE
     * @param reportType the REPORT_TYPE value
     */
    public void setReportType (java.lang.String reportType) {
        this.reportType = reportType;
    }


    /**
     * Return the value associated with the column: JS_UNIT_CODE
     */
    public java.lang.String getJsUnitCode () {
        return jsUnitCode;
    }

    /**
     * Set the value related to the column: JS_UNIT_CODE
     * @param jsUnitCode the JS_UNIT_CODE value
     */
    public void setJsUnitCode (java.lang.String jsUnitCode) {
        this.jsUnitCode = jsUnitCode;
    }


    /**
     * Return the value associated with the column: SGZB_UNIT_CODE
     */
    public java.lang.String getSgzbUnitCode () {
        return sgzbUnitCode;
    }

    /**
     * Set the value related to the column: SGZB_UNIT_CODE
     * @param sgzbUnitCode the SGZB_UNIT_CODE value
     */
    public void setSgzbUnitCode (java.lang.String sgzbUnitCode) {
        this.sgzbUnitCode = sgzbUnitCode;
    }


    /**
     * Return the value associated with the column: KC_UNIT_CODE
     */
    public java.lang.String getKcUnitCode () {
        return kcUnitCode;
    }

    /**
     * Set the value related to the column: KC_UNIT_CODE
     * @param kcUnitCode the KC_UNIT_CODE value
     */
    public void setKcUnitCode (java.lang.String kcUnitCode) {
        this.kcUnitCode = kcUnitCode;
    }


    /**
     * Return the value associated with the column: SJ_UNIT_CODE
     */
    public java.lang.String getSjUnitCode () {
        return sjUnitCode;
    }

    /**
     * Set the value related to the column: SJ_UNIT_CODE
     * @param sjUnitCode the SJ_UNIT_CODE value
     */
    public void setSjUnitCode (java.lang.String sjUnitCode) {
        this.sjUnitCode = sjUnitCode;
    }


    /**
     * Return the value associated with the column: JL_UNIT_CODE
     */
    public java.lang.String getJlUnitCode () {
        return jlUnitCode;
    }

    /**
     * Set the value related to the column: JL_UNIT_CODE
     * @param jlUnitCode the JL_UNIT_CODE value
     */
    public void setJlUnitCode (java.lang.String jlUnitCode) {
        this.jlUnitCode = jlUnitCode;
    }


    /**
     * Return the value associated with the column: SG_UNIT_CODE
     */
    public java.lang.String getSgUnitCode () {
        return sgUnitCode;
    }

    /**
     * Set the value related to the column: SG_UNIT_CODE
     * @param sgUnitCode the SG_UNIT_CODE value
     */
    public void setSgUnitCode (java.lang.String sgUnitCode) {
        this.sgUnitCode = sgUnitCode;
    }



    public boolean equals (Object obj) {
        if (null == obj) return false;
        if (!(obj instanceof com.justonetech.biz.domain.ExcelJdTasks)) return false;
        else {
            com.justonetech.biz.domain.ExcelJdTasks excelJdTasks = (com.justonetech.biz.domain.ExcelJdTasks) obj;
            if (null == this.getId() || null == excelJdTasks.getId()) return false;
            else return (this.getId().equals(excelJdTasks.getId()));
        }
    }

    public int hashCode () {
        if (Integer.MIN_VALUE == this.hashCode) {
            if (null == this.getId()) return super.hashCode();
            else {
                String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
                this.hashCode = hashStr.hashCode();
            }
        }
        return this.hashCode;
    }


    public String toString () {
        org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append(id);
        builder.append(flowCode);
        builder.append(jdDatetime);
        builder.append(bjbh);
        builder.append(jdTaskCode);
        builder.append(bid);
        builder.append(projectName);
        builder.append(projectAdd);
        builder.append(belongArea);
        builder.append(contMoney);
        builder.append(jsUnitName);
        builder.append(jsUnitAdd);
        builder.append(zipcode);
        builder.append(jsLinkman);
        builder.append(jsPhone);
        builder.append(sgzbUnitName);
        builder.append(sgzbLinkman);
        builder.append(sgzbPhone);
        builder.append(kcUnitName);
        builder.append(kcLinkman);
        builder.append(kcPhone);
        builder.append(sjUnitName);
        builder.append(sjLinkman);
        builder.append(sjPhone);
        builder.append(jlUnitName);
        builder.append(jlLinkman);
        builder.append(jlPhone);
        builder.append(sgUnitName);
        builder.append(sgLinkman);
        builder.append(sgPhone);
        builder.append(memo);
        builder.append(changeTime);
        builder.append(synDatetime);
        builder.append(jagzl);
        builder.append(buildArea);
        builder.append(dtsl);
        builder.append(property);
        builder.append(x);
        builder.append(y);
        builder.append(isRemoteMonitor);
        builder.append(isManagerCheck);
        builder.append(other1);
        builder.append(other2);
        builder.append(other3);
        builder.append(other4);
        builder.append(other5);
        builder.append(position);
        builder.append(reportType);
        builder.append(jsUnitCode);
        builder.append(sgzbUnitCode);
        builder.append(kcUnitCode);
        builder.append(sjUnitCode);
        builder.append(jlUnitCode);
        builder.append(sgUnitCode);
        return builder.toString();
    }
}