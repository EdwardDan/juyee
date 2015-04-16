package com.justonetech.biz.domain.base;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * This is an object that contains data related to the SHARE_PRO_DWGC_MONITOR table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目报监单位工程信息
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 项目报监单位工程信息
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : share
 * Projectable : false
 *
 * @hibernate.class table="SHARE_PRO_DWGC_MONITOR"
 */

public abstract class BaseShareProDwgcMonitor implements Serializable {

    public static String REF = "ShareProDwgcMonitor";
    public static String PROP_SG_UNIT_QUALIFY_TYPE_DESC = "sgUnitQualifyTypeDesc";
    public static String PROP_DWGC_NAME = "dwgcName";
    public static String PROP_ACCEPT_UNIT_NAME = "acceptUnitName";
    public static String PROP_CS = "cs";
    public static String PROP_SG_UNIT_PHONE = "sgUnitPhone";
    public static String PROP_SG_UNIT_MANAGER_CODE = "sgUnitManagerCode";
    public static String PROP_KC_UNIT_NAME = "kcUnitName";
    public static String PROP_SG_UNIT_MANAGER = "sgUnitManager";
    public static String PROP_DWGC_SUB_BUILD_MONEY = "dwgcSubBuildMoney";
    public static String PROP_BUILD_AREA = "buildArea";
    public static String PROP_JL_UNIT_CODE = "jlUnitCode";
    public static String PROP_DWGCH = "dwgch";
    public static String PROP_YN_TOTAL_FIX = "ynTotalFix";
    public static String PROP_DWGC_SUB_TYPE = "dwgcSubType";
    public static String PROP_JL_UNIT_NAME = "jlUnitName";
    public static String PROP_UNDER_CS = "underCs";
    public static String PROP_BJBH = "bjbh";
    public static String PROP_SG_MAIN_UNIT_CODE = "sgMainUnitCode";
    public static String PROP_DWGC_SUB_NAME = "dwgcSubName";
    public static String PROP_SG_UNIT_CODE = "sgUnitCode";
    public static String PROP_SJ_UNIT_NAME = "sjUnitName";
    public static String PROP_TS = "ts";
    public static String PROP_YN_DWGC = "ynDwgc";
    public static String PROP_DWGC_SUB_TYPE_DESC = "dwgcSubTypeDesc";
    public static String PROP_DWGC_TYPE = "dwgcType";
    public static String PROP_UPDATE_TIME = "updateTime";
    public static String PROP_SG_UNIT_NAME = "sgUnitName";
    public static String PROP_BUILD_MONEY = "buildMoney";
    public static String PROP_JBR = "jbr";
    public static String PROP_ACCEPT_TIME = "acceptTime";
    public static String PROP_DWGC_TYPE_DESC = "dwgcTypeDesc";
    public static String PROP_ACCEPT_UNIT_CODE = "acceptUnitCode";
    public static String PROP_KC_UNIT_CODE = "kcUnitCode";
    public static String PROP_FBID = "fbid";
    public static String PROP_SJ_UNIT_CODE = "sjUnitCode";
    public static String PROP_ID = "id";
    public static String PROP_SG_UNIT_QUALIFY_TYPE = "sgUnitQualifyType";
    public static String PROP_SG_MAIN_UNIT_NAME = "sgMainUnitName";
    public static String PROP_CIVIL_AREA = "civilArea";
    public static String PROP_JDRWSBH = "jdrwsbh";
    public static String PROP_JDRWSMC = "jdrwsmc";
    public static String PROP_JDRWSSCRQ = "jdrwsscrq";
    public static String PROP_JDRWSDWDM = "jdrwsdwdm";
    public static String PROP_JDRWSDWMC = "jdrwsdwmc";
    public static String PROP_JDRWSJBR = "jdrwsjbr";
    public static String PROP_JDRWSWTYN = "jdrwswtyn";
    public static String PROP_JDRWSWTRQ = "jdrwswtrq";
    public static String PROP_JDRWSWTDWDM = "jdrwswtdwdm";
    public static String PROP_JDRWSWTDWMC = "jdrwswtdwmc";
    public static String PROP_JDRWSWTJBR = "jdrwswtjbr";


    // constructors
    public BaseShareProDwgcMonitor() {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseShareProDwgcMonitor(java.lang.Long id) {
        this.setId(id);
        initialize();
    }

    protected void initialize() {
    }


    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Long id;

    // fields
    /*报建编号*/
    /*报建编号*/
    private java.lang.String bjbh;

    /*副表ID*/
    /*副表ID*/
    private java.lang.String fbid;

    /*工程名称*/
    /*工程名称*/
    private java.lang.String dwgcName;

    /*工程类型*/
    /*工程类型*/
    private java.lang.Long dwgcType;

    /*工程类型描述*/
    /*工程类型描述*/
    private java.lang.String dwgcTypeDesc;

    /*建筑面积*/
    /*建筑面积*/
    private java.lang.Double buildArea;

    /*工程造价*/
    /*工程造价*/
    private java.lang.Double buildMoney;

    /*层数*/
    /*层数*/
    private java.lang.Long cs;

    /*台数*/
    /*台数*/
    private java.lang.Long ts;

    /*是否单位工程*/
    /*是否单位工程*/
    private java.lang.String ynDwgc;

    /*地下层数*/
    /*地下层数*/
    private java.lang.String underCs;

    /*单位工程号*/
    /*单位工程号*/
    private java.lang.String dwgch;

    /*分部分项工程名称*/
    /*分部分项工程名称*/
    private java.lang.String dwgcSubName;

    /*分部分项类别*/
    /*分部分项类别*/
    private java.lang.String dwgcSubType;

    /*分部分项类别_中文*/
    /*分部分项类别_中文*/
    private java.lang.String dwgcSubTypeDesc;

    /*施工单位名称*/
    /*施工单位名称*/
    private java.lang.String sgUnitName;

    /*施工单位代码*/
    /*施工单位代码*/
    private java.lang.String sgUnitCode;

    /*施工单位项目经理*/
    /*施工单位项目经理*/
    private java.lang.String sgUnitManager;

    /*施工单位项目经理代码*/
    /*施工单位项目经理代码*/
    private java.lang.String sgUnitManagerCode;

    /*施工单位电话*/
    /*施工单位电话*/
    private java.lang.String sgUnitPhone;

    /*施工单位证件类型*/
    /*施工单位证件类型*/
    private java.lang.Long sgUnitQualifyType;

    /*施工单位证件类型描述*/
    /*施工单位证件类型描述*/
    private java.lang.String sgUnitQualifyTypeDesc;

    /*分部分项工程造价*/
    /*分部分项工程造价*/
    private java.lang.Double dwgcSubBuildMoney;

    /*民防面积*/
    /*民防面积*/
    private java.lang.Double civilArea;

    /*是否全装修*/
    /*是否全装修*/
    private java.lang.String ynTotalFix;

    /*设计单位名称*/
    /*设计单位名称*/
    private java.lang.String sjUnitName;

    /*设计单位代码*/
    /*设计单位代码*/
    private java.lang.String sjUnitCode;

    /*勘察单位名称*/
    /*勘察单位名称*/
    private java.lang.String kcUnitName;

    /*勘察单位代码*/
    /*勘察单位代码*/
    private java.lang.String kcUnitCode;

    /*施工总包单位名称*/
    /*施工总包单位名称*/
    private java.lang.String sgMainUnitName;

    /*施工总包单位代码*/
    /*施工总包单位代码*/
    private java.lang.String sgMainUnitCode;

    /*监理单位名称*/
    /*监理单位名称*/
    private java.lang.String jlUnitName;

    /*监理单位代码*/
    /*监理单位代码*/
    private java.lang.String jlUnitCode;

    /*经办人*/
    /*经办人*/
    private java.lang.String jbr;

    /*经办单位代码*/
    /*经办单位代码*/
    private java.lang.String acceptUnitCode;

    /*经办单位名称*/
    /*经办单位名称*/
    private java.lang.String acceptUnitName;

    /*受理时间*/
    /*受理时间*/
    private java.sql.Timestamp acceptTime;

    /*更新时间*/
    /*更新时间*/
    private java.sql.Timestamp updateTime;

    /*监督任务书编号*/
    /*监督任务书编号*/
    private java.lang.String jdrwsbh;

    /*监督任务书名称*/
    /*监督任务书名称*/
    private java.lang.String jdrwsmc;

    /*监督任务书生成日期*/
    /*监督任务书生成日期*/
    private java.sql.Timestamp jdrwsscrq;

    /*监督任务书单位代码*/
    /*监督任务书单位代码*/
    private java.lang.String jdrwsdwdm;

    /*监督任务书单位名称*/
    /*监督任务书单位名称*/
    private java.lang.String jdrwsdwmc;

    /*监督任务书经办人*/
    /*监督任务书经办人*/
    private java.lang.String jdrwsjbr;

    /*监督任务书是否委托*/
    /*监督任务书是否委托*/
    private java.lang.String jdrwswtyn;

    /*监督任务书委托日期*/
    /*监督任务书委托日期*/
    private java.sql.Timestamp jdrwswtrq;

    /*监督任务书委托单位代码*/
    /*监督任务书委托单位代码*/
    private java.lang.String jdrwswtdwdm;

    /*监督任务书委托单位名称*/
    /*监督任务书委托单位名称*/
    private java.lang.String jdrwswtdwmc;

    /*监督任务书委托经办人*/
    /*监督任务书委托经办人*/
    private java.lang.String jdrwswtjbr;


    /**
     * Return the unique identifier of this class
     *
     * @hibernate.id generator-class="com.justonetech.core.orm.hibernate.LongIdGenerator"
     * column="ID"
     */
    public java.lang.Long getId() {
        return id;
    }

    /**
     * Set the unique identifier of this class
     *
     * @param id the new ID
     * @deprecated
     */
    public void setId(java.lang.Long id) {
        this.id = id;
        this.hashCode = Integer.MIN_VALUE;
    }


    /**
     * Return the value associated with the column: BJBH
     */
    public java.lang.String getBjbh() {
        return bjbh;
    }

    /**
     * Set the value related to the column: BJBH
     *
     * @param bjbh the BJBH value
     */
    public void setBjbh(java.lang.String bjbh) {
        this.bjbh = bjbh;
    }


    /**
     * Return the value associated with the column: FBID
     */
    public java.lang.String getFbid() {
        return fbid;
    }

    /**
     * Set the value related to the column: FBID
     *
     * @param fbid the FBID value
     */
    public void setFbid(java.lang.String fbid) {
        this.fbid = fbid;
    }


    /**
     * Return the value associated with the column: DWGC_NAME
     */
    public java.lang.String getDwgcName() {
        return dwgcName;
    }

    /**
     * Set the value related to the column: DWGC_NAME
     *
     * @param dwgcName the DWGC_NAME value
     */
    public void setDwgcName(java.lang.String dwgcName) {
        this.dwgcName = dwgcName;
    }

    public String getJdrwsbh() {
        return jdrwsbh;
    }

    public void setJdrwsbh(String jdrwsbh) {
        this.jdrwsbh = jdrwsbh;
    }

    public String getJdrwsmc() {
        return jdrwsmc;
    }

    public void setJdrwsmc(String jdrwsmc) {
        this.jdrwsmc = jdrwsmc;
    }

    public Timestamp getJdrwsscrq() {
        return jdrwsscrq;
    }

    public void setJdrwsscrq(Timestamp jdrwsscrq) {
        this.jdrwsscrq = jdrwsscrq;
    }

    public String getJdrwsdwdm() {
        return jdrwsdwdm;
    }

    public void setJdrwsdwdm(String jdrwsdwdm) {
        this.jdrwsdwdm = jdrwsdwdm;
    }

    public String getJdrwsdwmc() {
        return jdrwsdwmc;
    }

    public void setJdrwsdwmc(String jdrwsdwmc) {
        this.jdrwsdwmc = jdrwsdwmc;
    }

    public String getJdrwsjbr() {
        return jdrwsjbr;
    }

    public void setJdrwsjbr(String jdrwsjbr) {
        this.jdrwsjbr = jdrwsjbr;
    }

    public String getJdrwswtyn() {
        return jdrwswtyn;
    }

    public void setJdrwswtyn(String jdrwswtyn) {
        this.jdrwswtyn = jdrwswtyn;
    }

    public Timestamp getJdrwswtrq() {
        return jdrwswtrq;
    }

    public void setJdrwswtrq(Timestamp jdrwswtrq) {
        this.jdrwswtrq = jdrwswtrq;
    }

    public String getJdrwswtdwdm() {
        return jdrwswtdwdm;
    }

    public void setJdrwswtdwdm(String jdrwswtdwdm) {
        this.jdrwswtdwdm = jdrwswtdwdm;
    }

    public String getJdrwswtdwmc() {
        return jdrwswtdwmc;
    }

    public void setJdrwswtdwmc(String jdrwswtdwmc) {
        this.jdrwswtdwmc = jdrwswtdwmc;
    }

    public String getJdrwswtjbr() {
        return jdrwswtjbr;
    }

    public void setJdrwswtjbr(String jdrwswtjbr) {
        this.jdrwswtjbr = jdrwswtjbr;
    }

    /**
     * Return the value associated with the column: DWGC_TYPE
     */
    public java.lang.Long getDwgcType() {
        return dwgcType;
    }

    /**
     * Set the value related to the column: DWGC_TYPE
     *
     * @param dwgcType the DWGC_TYPE value
     */
    public void setDwgcType(java.lang.Long dwgcType) {
        this.dwgcType = dwgcType;
    }


    /**
     * Return the value associated with the column: DWGC_TYPE_DESC
     */
    public java.lang.String getDwgcTypeDesc() {
        return dwgcTypeDesc;
    }

    /**
     * Set the value related to the column: DWGC_TYPE_DESC
     *
     * @param dwgcTypeDesc the DWGC_TYPE_DESC value
     */
    public void setDwgcTypeDesc(java.lang.String dwgcTypeDesc) {
        this.dwgcTypeDesc = dwgcTypeDesc;
    }


    /**
     * Return the value associated with the column: BUILD_AREA
     */
    public java.lang.Double getBuildArea() {
        return buildArea;
    }

    /**
     * Set the value related to the column: BUILD_AREA
     *
     * @param buildArea the BUILD_AREA value
     */
    public void setBuildArea(java.lang.Double buildArea) {
        this.buildArea = buildArea;
    }


    /**
     * Return the value associated with the column: BUILD_MONEY
     */
    public java.lang.Double getBuildMoney() {
        return buildMoney;
    }

    /**
     * Set the value related to the column: BUILD_MONEY
     *
     * @param buildMoney the BUILD_MONEY value
     */
    public void setBuildMoney(java.lang.Double buildMoney) {
        this.buildMoney = buildMoney;
    }


    /**
     * Return the value associated with the column: CS
     */
    public java.lang.Long getCs() {
        return cs;
    }

    /**
     * Set the value related to the column: CS
     *
     * @param cs the CS value
     */
    public void setCs(java.lang.Long cs) {
        this.cs = cs;
    }


    /**
     * Return the value associated with the column: TS
     */
    public java.lang.Long getTs() {
        return ts;
    }

    /**
     * Set the value related to the column: TS
     *
     * @param ts the TS value
     */
    public void setTs(java.lang.Long ts) {
        this.ts = ts;
    }


    /**
     * Return the value associated with the column: YN_DWGC
     */
    public java.lang.String getYnDwgc() {
        return ynDwgc;
    }

    /**
     * Set the value related to the column: YN_DWGC
     *
     * @param ynDwgc the YN_DWGC value
     */
    public void setYnDwgc(java.lang.String ynDwgc) {
        this.ynDwgc = ynDwgc;
    }


    /**
     * Return the value associated with the column: UNDER_CS
     */
    public java.lang.String getUnderCs() {
        return underCs;
    }

    /**
     * Set the value related to the column: UNDER_CS
     *
     * @param underCs the UNDER_CS value
     */
    public void setUnderCs(java.lang.String underCs) {
        this.underCs = underCs;
    }


    /**
     * Return the value associated with the column: DWGCH
     */
    public java.lang.String getDwgch() {
        return dwgch;
    }

    /**
     * Set the value related to the column: DWGCH
     *
     * @param dwgch the DWGCH value
     */
    public void setDwgch(java.lang.String dwgch) {
        this.dwgch = dwgch;
    }


    /**
     * Return the value associated with the column: DWGC_SUB_NAME
     */
    public java.lang.String getDwgcSubName() {
        return dwgcSubName;
    }

    /**
     * Set the value related to the column: DWGC_SUB_NAME
     *
     * @param dwgcSubName the DWGC_SUB_NAME value
     */
    public void setDwgcSubName(java.lang.String dwgcSubName) {
        this.dwgcSubName = dwgcSubName;
    }


    /**
     * Return the value associated with the column: DWGC_SUB_TYPE
     */
    public java.lang.String getDwgcSubType() {
        return dwgcSubType;
    }

    /**
     * Set the value related to the column: DWGC_SUB_TYPE
     *
     * @param dwgcSubType the DWGC_SUB_TYPE value
     */
    public void setDwgcSubType(java.lang.String dwgcSubType) {
        this.dwgcSubType = dwgcSubType;
    }


    /**
     * Return the value associated with the column: DWGC_SUB_TYPE_DESC
     */
    public java.lang.String getDwgcSubTypeDesc() {
        return dwgcSubTypeDesc;
    }

    /**
     * Set the value related to the column: DWGC_SUB_TYPE_DESC
     *
     * @param dwgcSubTypeDesc the DWGC_SUB_TYPE_DESC value
     */
    public void setDwgcSubTypeDesc(java.lang.String dwgcSubTypeDesc) {
        this.dwgcSubTypeDesc = dwgcSubTypeDesc;
    }


    /**
     * Return the value associated with the column: SG_UNIT_NAME
     */
    public java.lang.String getSgUnitName() {
        return sgUnitName;
    }

    /**
     * Set the value related to the column: SG_UNIT_NAME
     *
     * @param sgUnitName the SG_UNIT_NAME value
     */
    public void setSgUnitName(java.lang.String sgUnitName) {
        this.sgUnitName = sgUnitName;
    }


    /**
     * Return the value associated with the column: SG_UNIT_CODE
     */
    public java.lang.String getSgUnitCode() {
        return sgUnitCode;
    }

    /**
     * Set the value related to the column: SG_UNIT_CODE
     *
     * @param sgUnitCode the SG_UNIT_CODE value
     */
    public void setSgUnitCode(java.lang.String sgUnitCode) {
        this.sgUnitCode = sgUnitCode;
    }


    /**
     * Return the value associated with the column: SG_UNIT_MANAGER
     */
    public java.lang.String getSgUnitManager() {
        return sgUnitManager;
    }

    /**
     * Set the value related to the column: SG_UNIT_MANAGER
     *
     * @param sgUnitManager the SG_UNIT_MANAGER value
     */
    public void setSgUnitManager(java.lang.String sgUnitManager) {
        this.sgUnitManager = sgUnitManager;
    }


    /**
     * Return the value associated with the column: SG_UNIT_MANAGER_CODE
     */
    public java.lang.String getSgUnitManagerCode() {
        return sgUnitManagerCode;
    }

    /**
     * Set the value related to the column: SG_UNIT_MANAGER_CODE
     *
     * @param sgUnitManagerCode the SG_UNIT_MANAGER_CODE value
     */
    public void setSgUnitManagerCode(java.lang.String sgUnitManagerCode) {
        this.sgUnitManagerCode = sgUnitManagerCode;
    }


    /**
     * Return the value associated with the column: SG_UNIT_PHONE
     */
    public java.lang.String getSgUnitPhone() {
        return sgUnitPhone;
    }

    /**
     * Set the value related to the column: SG_UNIT_PHONE
     *
     * @param sgUnitPhone the SG_UNIT_PHONE value
     */
    public void setSgUnitPhone(java.lang.String sgUnitPhone) {
        this.sgUnitPhone = sgUnitPhone;
    }


    /**
     * Return the value associated with the column: SG_UNIT_QUALIFY_TYPE
     */
    public java.lang.Long getSgUnitQualifyType() {
        return sgUnitQualifyType;
    }

    /**
     * Set the value related to the column: SG_UNIT_QUALIFY_TYPE
     *
     * @param sgUnitQualifyType the SG_UNIT_QUALIFY_TYPE value
     */
    public void setSgUnitQualifyType(java.lang.Long sgUnitQualifyType) {
        this.sgUnitQualifyType = sgUnitQualifyType;
    }


    /**
     * Return the value associated with the column: SG_UNIT_QUALIFY_TYPE_DESC
     */
    public java.lang.String getSgUnitQualifyTypeDesc() {
        return sgUnitQualifyTypeDesc;
    }

    /**
     * Set the value related to the column: SG_UNIT_QUALIFY_TYPE_DESC
     *
     * @param sgUnitQualifyTypeDesc the SG_UNIT_QUALIFY_TYPE_DESC value
     */
    public void setSgUnitQualifyTypeDesc(java.lang.String sgUnitQualifyTypeDesc) {
        this.sgUnitQualifyTypeDesc = sgUnitQualifyTypeDesc;
    }


    /**
     * Return the value associated with the column: DWGC_SUB_BUILD_MONEY
     */
    public java.lang.Double getDwgcSubBuildMoney() {
        return dwgcSubBuildMoney;
    }

    /**
     * Set the value related to the column: DWGC_SUB_BUILD_MONEY
     *
     * @param dwgcSubBuildMoney the DWGC_SUB_BUILD_MONEY value
     */
    public void setDwgcSubBuildMoney(java.lang.Double dwgcSubBuildMoney) {
        this.dwgcSubBuildMoney = dwgcSubBuildMoney;
    }


    /**
     * Return the value associated with the column: CIVIL_AREA
     */
    public java.lang.Double getCivilArea() {
        return civilArea;
    }

    /**
     * Set the value related to the column: CIVIL_AREA
     *
     * @param civilArea the CIVIL_AREA value
     */
    public void setCivilArea(java.lang.Double civilArea) {
        this.civilArea = civilArea;
    }


    /**
     * Return the value associated with the column: YN_TOTAL_FIX
     */
    public java.lang.String getYnTotalFix() {
        return ynTotalFix;
    }

    /**
     * Set the value related to the column: YN_TOTAL_FIX
     *
     * @param ynTotalFix the YN_TOTAL_FIX value
     */
    public void setYnTotalFix(java.lang.String ynTotalFix) {
        this.ynTotalFix = ynTotalFix;
    }


    /**
     * Return the value associated with the column: SJ_UNIT_NAME
     */
    public java.lang.String getSjUnitName() {
        return sjUnitName;
    }

    /**
     * Set the value related to the column: SJ_UNIT_NAME
     *
     * @param sjUnitName the SJ_UNIT_NAME value
     */
    public void setSjUnitName(java.lang.String sjUnitName) {
        this.sjUnitName = sjUnitName;
    }


    /**
     * Return the value associated with the column: SJ_UNIT_CODE
     */
    public java.lang.String getSjUnitCode() {
        return sjUnitCode;
    }

    /**
     * Set the value related to the column: SJ_UNIT_CODE
     *
     * @param sjUnitCode the SJ_UNIT_CODE value
     */
    public void setSjUnitCode(java.lang.String sjUnitCode) {
        this.sjUnitCode = sjUnitCode;
    }


    /**
     * Return the value associated with the column: KC_UNIT_NAME
     */
    public java.lang.String getKcUnitName() {
        return kcUnitName;
    }

    /**
     * Set the value related to the column: KC_UNIT_NAME
     *
     * @param kcUnitName the KC_UNIT_NAME value
     */
    public void setKcUnitName(java.lang.String kcUnitName) {
        this.kcUnitName = kcUnitName;
    }


    /**
     * Return the value associated with the column: KC_UNIT_CODE
     */
    public java.lang.String getKcUnitCode() {
        return kcUnitCode;
    }

    /**
     * Set the value related to the column: KC_UNIT_CODE
     *
     * @param kcUnitCode the KC_UNIT_CODE value
     */
    public void setKcUnitCode(java.lang.String kcUnitCode) {
        this.kcUnitCode = kcUnitCode;
    }


    /**
     * Return the value associated with the column: SG_MAIN_UNIT_NAME
     */
    public java.lang.String getSgMainUnitName() {
        return sgMainUnitName;
    }

    /**
     * Set the value related to the column: SG_MAIN_UNIT_NAME
     *
     * @param sgMainUnitName the SG_MAIN_UNIT_NAME value
     */
    public void setSgMainUnitName(java.lang.String sgMainUnitName) {
        this.sgMainUnitName = sgMainUnitName;
    }


    /**
     * Return the value associated with the column: SG_MAIN_UNIT_CODE
     */
    public java.lang.String getSgMainUnitCode() {
        return sgMainUnitCode;
    }

    /**
     * Set the value related to the column: SG_MAIN_UNIT_CODE
     *
     * @param sgMainUnitCode the SG_MAIN_UNIT_CODE value
     */
    public void setSgMainUnitCode(java.lang.String sgMainUnitCode) {
        this.sgMainUnitCode = sgMainUnitCode;
    }


    /**
     * Return the value associated with the column: JL_UNIT_NAME
     */
    public java.lang.String getJlUnitName() {
        return jlUnitName;
    }

    /**
     * Set the value related to the column: JL_UNIT_NAME
     *
     * @param jlUnitName the JL_UNIT_NAME value
     */
    public void setJlUnitName(java.lang.String jlUnitName) {
        this.jlUnitName = jlUnitName;
    }


    /**
     * Return the value associated with the column: JL_UNIT_CODE
     */
    public java.lang.String getJlUnitCode() {
        return jlUnitCode;
    }

    /**
     * Set the value related to the column: JL_UNIT_CODE
     *
     * @param jlUnitCode the JL_UNIT_CODE value
     */
    public void setJlUnitCode(java.lang.String jlUnitCode) {
        this.jlUnitCode = jlUnitCode;
    }


    /**
     * Return the value associated with the column: JBR
     */
    public java.lang.String getJbr() {
        return jbr;
    }

    /**
     * Set the value related to the column: JBR
     *
     * @param jbr the JBR value
     */
    public void setJbr(java.lang.String jbr) {
        this.jbr = jbr;
    }


    /**
     * Return the value associated with the column: ACCEPT_UNIT_CODE
     */
    public java.lang.String getAcceptUnitCode() {
        return acceptUnitCode;
    }

    /**
     * Set the value related to the column: ACCEPT_UNIT_CODE
     *
     * @param acceptUnitCode the ACCEPT_UNIT_CODE value
     */
    public void setAcceptUnitCode(java.lang.String acceptUnitCode) {
        this.acceptUnitCode = acceptUnitCode;
    }


    /**
     * Return the value associated with the column: ACCEPT_UNIT_NAME
     */
    public java.lang.String getAcceptUnitName() {
        return acceptUnitName;
    }

    /**
     * Set the value related to the column: ACCEPT_UNIT_NAME
     *
     * @param acceptUnitName the ACCEPT_UNIT_NAME value
     */
    public void setAcceptUnitName(java.lang.String acceptUnitName) {
        this.acceptUnitName = acceptUnitName;
    }


    /**
     * Return the value associated with the column: ACCEPT_TIME
     */
    public java.sql.Timestamp getAcceptTime() {
        return acceptTime;
    }

    /**
     * Set the value related to the column: ACCEPT_TIME
     *
     * @param acceptTime the ACCEPT_TIME value
     */
    public void setAcceptTime(java.sql.Timestamp acceptTime) {
        this.acceptTime = acceptTime;
    }


    /**
     * Return the value associated with the column: UPDATE_TIME
     */
    public java.sql.Timestamp getUpdateTime() {
        return updateTime;
    }

    /**
     * Set the value related to the column: UPDATE_TIME
     *
     * @param updateTime the UPDATE_TIME value
     */
    public void setUpdateTime(java.sql.Timestamp updateTime) {
        this.updateTime = updateTime;
    }


    public boolean equals(Object obj) {
        if (null == obj) return false;
        if (!(obj instanceof com.justonetech.biz.domain.ShareProDwgcMonitor)) return false;
        else {
            com.justonetech.biz.domain.ShareProDwgcMonitor shareProDwgcMonitor = (com.justonetech.biz.domain.ShareProDwgcMonitor) obj;
            if (null == this.getId() || null == shareProDwgcMonitor.getId()) return false;
            else return (this.getId().equals(shareProDwgcMonitor.getId()));
        }
    }

    public int hashCode() {
        if (Integer.MIN_VALUE == this.hashCode) {
            if (null == this.getId()) return super.hashCode();
            else {
                String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
                this.hashCode = hashStr.hashCode();
            }
        }
        return this.hashCode;
    }


    public String toString() {
        org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append(id);
        builder.append(bjbh);
        builder.append(fbid);
        builder.append(dwgcName);
        builder.append(dwgcType);
        builder.append(dwgcTypeDesc);
        builder.append(buildArea);
        builder.append(buildMoney);
        builder.append(cs);
        builder.append(ts);
        builder.append(ynDwgc);
        builder.append(underCs);
        builder.append(dwgch);
        builder.append(dwgcSubName);
        builder.append(dwgcSubType);
        builder.append(dwgcSubTypeDesc);
        builder.append(sgUnitName);
        builder.append(sgUnitCode);
        builder.append(sgUnitManager);
        builder.append(sgUnitManagerCode);
        builder.append(sgUnitPhone);
        builder.append(sgUnitQualifyType);
        builder.append(sgUnitQualifyTypeDesc);
        builder.append(dwgcSubBuildMoney);
        builder.append(civilArea);
        builder.append(ynTotalFix);
        builder.append(sjUnitName);
        builder.append(sjUnitCode);
        builder.append(kcUnitName);
        builder.append(kcUnitCode);
        builder.append(sgMainUnitName);
        builder.append(sgMainUnitCode);
        builder.append(jlUnitName);
        builder.append(jlUnitCode);
        builder.append(jbr);
        builder.append(acceptUnitCode);
        builder.append(acceptUnitName);
        builder.append(acceptTime);
        builder.append(updateTime);
        return builder.toString();
    }


}