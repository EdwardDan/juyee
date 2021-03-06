package com.justonetech.system.domain.base;


import com.justonetech.biz.domain.ShareProTobuild;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHARE_PRO_TOBUILD table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目报建信息
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 项目报建信息
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : share
 * Projectable : false
 *
 * @hibernate.class
 *  table="SHARE_PRO_TOBUILD"
 */

public abstract class BaseShareProTobuild implements Serializable {

	public static String REF = "ShareProTobuild";
	public static String PROP_STRUCTURE_FORM = "structureForm";
	public static String PROP_BUILD_UNIT_PROPERTY = "buildUnitProperty";
	public static String PROP_LX_LEVEL_ID = "lxLevelId";
	public static String PROP_BUILD_UNIT_ADDRESS = "buildUnitAddress";
	public static String PROP_FBZG = "fbzg";
	public static String PROP_APPROVAL_DATE = "approvalDate";
	public static String PROP_PROJECT_TYPE = "projectType";
	public static String PROP_GIS_LINE = "gisLine";
	public static String PROP_IS_STATE_HOLDING = "isStateHolding";
	public static String PROP_BUILD_UNIT_ORG_CODE = "buildUnitOrgCode";
	public static String PROP_BUILD_UNIT_LEGAL = "buildUnitLegal";
	public static String PROP_BMMC = "bmmc";
	public static String PROP_BUILD_UNIT_PROPERTY_ID = "buildUnitPropertyId";
	public static String PROP_PROJECT_TYPE_ID = "projectTypeId";
	public static String PROP_GIS_Y = "gisY";
	public static String PROP_PROJECT_NAME = "projectName";
	public static String PROP_PREPARE_THING = "prepareThing";
	public static String PROP_LX_FILE_CODE = "lxFileCode";
	public static String PROP_GIS_X = "gisX";
	public static String PROP_BUILD_ADDRESS = "buildAddress";
	public static String PROP_FUND_SOURCE5 = "fundSource5";
	public static String PROP_FUND_SOURCE4 = "fundSource4";
	public static String PROP_FUND_SOURCE7 = "fundSource7";
	public static String PROP_BUILD_PROPERTY = "buildProperty";
	public static String PROP_FUND_SOURCE6 = "fundSource6";
	public static String PROP_FUND_SOURCE1 = "fundSource1";
	public static String PROP_PROJECT_PROPERTY = "projectProperty";
	public static String PROP_FUND_SOURCE3 = "fundSource3";
	public static String PROP_FUND_SOURCE2 = "fundSource2";
	public static String PROP_BUILD_START_DATE = "buildStartDate";
	public static String PROP_FUND_SOURCE9 = "fundSource9";
	public static String PROP_BJ_PROJECT_PROPERTY_ID = "bjProjectPropertyId";
	public static String PROP_LX_LEVEL = "lxLevel";
	public static String PROP_FUND_SOURCE8 = "fundSource8";
	public static String PROP_SHARE_DATETIME = "shareDatetime";
	public static String PROP_STRUCTURE_FORM_ID = "structureFormId";
	public static String PROP_PRO_SPECIAL_FLAG_SG = "proSpecialFlagSg";
	public static String PROP_PRO_SPECIAL_FLAG_SJ = "proSpecialFlagSj";
	public static String PROP_BJ_PROJECT_PROPERTY = "bjProjectProperty";
	public static String PROP_BUILD_PROPERTY_ID = "buildPropertyId";
	public static String PROP_BUILD_UNIT_REG_MONEY = "buildUnitRegMoney";
	public static String PROP_BJ_DATE = "bjDate";
	public static String PROP_PRO_SPECIAL_FLAG_KC = "proSpecialFlagKc";
	public static String PROP_LX_CLASS = "lxClass";
	public static String PROP_LX_FILE = "lxFile";
	public static String PROP_BJBH = "bjbh";
	public static String PROP_PRO_SPECIAL_FLAG_DEV = "proSpecialFlagDev";
	public static String PROP_TOTAL_AREA = "totalArea";
	public static String PROP_FGW_EXCHANGE_CODE = "fgwExchangeCode";
	public static String PROP_BJ_MEMO = "bjMemo";
	public static String PROP_CARD_ID = "cardId";
	public static String PROP_BUILD_UNIT_TEL = "buildUnitTel";
	public static String PROP_TOTAL_INVESTMENT = "totalInvestment";
	public static String PROP_PROJECT_PROPERTY_ID = "projectPropertyId";
	public static String PROP_PRO_SPECIAL_FLAG_JL = "proSpecialFlagJl";
	public static String PROP_DEV_INVESTMENT = "devInvestment";
	public static String PROP_BUILD_UNIT_ZIPCODE = "buildUnitZipcode";
	public static String PROP_EXPLAIN_THING = "explainThing";
	public static String PROP_LX_CLASS_ID = "lxClassId";
	public static String PROP_JBR = "jbr";
	public static String PROP_JSB_CODE = "jsbCode";
	public static String PROP_BUILD_UNIT_LINKMAN = "buildUnitLinkman";
	public static String PROP_APPROVAL_UNIT = "approvalUnit";
	public static String PROP_BUILD_UNIT_NAME = "buildUnitName";
	public static String PROP_BUILD_SCALE = "buildScale";
	public static String PROP_BELONG_AREA = "belongArea";
	public static String PROP_BMDM = "bmdm";
	public static String PROP_SHARE_STATUS = "shareStatus";


	// constructors
	public BaseShareProTobuild() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShareProTobuild(String bjbh) {
		this.setBjbh(bjbh);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private String bjbh;

	// fields
    /*报建日期*/
    /*报建日期*/
	private java.sql.Date bjDate;

    /*建设单位*/
    /*建设单位*/
	private String buildUnitName;

    /*建设单位性质*/
    /*建设单位性质*/
	private String buildUnitProperty;

    /*建设单位性质标识*/
    /*建设单位性质标识*/
	private Long buildUnitPropertyId;

    /*建设单位地址*/
    /*建设单位地址*/
	private String buildUnitAddress;

    /*建设单位电话*/
    /*建设单位电话*/
	private String buildUnitTel;

    /*建设单位法人*/
    /*建设单位法人*/
	private String buildUnitLegal;

    /*建设单位联系人*/
    /*建设单位联系人*/
	private String buildUnitLinkman;

    /*建设单位邮编*/
    /*建设单位邮编*/
	private String buildUnitZipcode;

    /*建设单位注册资金*/
    /*建设单位注册资金*/
	private Double buildUnitRegMoney;

    /*项目名称*/
    /*项目名称*/
	private String projectName;

    /*建设地点*/
    /*建设地点*/
	private String buildAddress;

    /*立项文件*/
    /*立项文件*/
	private String lxFile;

    /*立项文号*/
    /*立项文号*/
	private String lxFileCode;

    /*立项级别*/
    /*立项级别*/
	private String lxLevel;

    /*立项级别标识*/
    /*立项级别标识*/
	private Long lxLevelId;

    /*立项分类*/
    /*立项分类*/
	private String lxClass;

    /*立项分类标识*/
    /*立项分类标识*/
	private Long lxClassId;

    /*批准机关*/
    /*批准机关*/
	private String approvalUnit;

    /*批准日期*/
    /*批准日期*/
	private java.sql.Date approvalDate;

    /*总投资*/
    /*总投资*/
	private Double totalInvestment;

    /*设备投资*/
    /*设备投资*/
	private Double devInvestment;

    /*建设性质*/
    /*建设性质*/
	private String buildProperty;

    /*建设性质标识*/
    /*建设性质标识*/
	private Long buildPropertyId;

    /*建设规模*/
    /*建设规模*/
	private String buildScale;

    /*总面积*/
    /*总面积*/
	private Double totalArea;

    /*开工日期*/
    /*开工日期*/
	private java.sql.Date buildStartDate;

    /*项目性质*/
    /*项目性质*/
	private String projectProperty;

    /*项目性质标识*/
    /*项目性质标识*/
	private Long projectPropertyId;

    /*筹建情况*/
    /*筹建情况*/
	private String prepareThing;

    /*说明情况*/
    /*说明情况*/
	private String explainThing;

    /*资金来源--国家投资*/
    /*资金来源--国家投资*/
	private Double fundSource1;

    /*资金来源--国家融资*/
    /*资金来源--国家融资*/
	private Double fundSource2;

    /*资金来源--国际组织外国政府资金*/
    /*资金来源--国际组织外国政府资金*/
	private Double fundSource3;

    /*资金来源--集体经济投资*/
    /*资金来源--集体经济投资*/
	private Double fundSource4;

    /*资金来源--外商投资*/
    /*资金来源--外商投资*/
	private Double fundSource5;

    /*资金来源--私民营投资*/
    /*资金来源--私民营投资*/
	private Double fundSource6;

    /*资金来源--自有资金*/
    /*资金来源--自有资金*/
	private Double fundSource7;

    /*资金来源--其他*/
    /*资金来源--其他*/
	private Double fundSource8;

    /*资金来源--港、澳、台投资*/
    /*资金来源--港、澳、台投资*/
	private Double fundSource9;

    /*结构形式*/
    /*结构形式*/
	private String structureForm;

    /*结构形式标识*/
    /*结构形式标识*/
	private Long structureFormId;

    /*项目分类*/
    /*项目分类*/
	private String projectType;

    /*项目分类标识*/
    /*项目分类标识*/
	private Long projectTypeId;

    /*部门代码*/
    /*部门代码*/
	private String bmdm;

    /*部门名称*/
    /*部门名称*/
	private String bmmc;

    /*是否国有资本控股*/
    /*是否国有资本控股*/
	private String isStateHolding;

    /*建设单位机构代码*/
    /*建设单位机构代码*/
	private String buildUnitOrgCode;

    /*报建项目性质*/
    /*报建项目性质*/
	private String bjProjectProperty;

    /*报建项目性质标识*/
    /*报建项目性质标识*/
	private Long bjProjectPropertyId;

    /*发改委交互码*/
    /*发改委交互码*/
	private String fgwExchangeCode;

    /*所属区县*/
    /*所属区县*/
	private String belongArea;

    /*报建备注*/
    /*报建备注*/
	private String bjMemo;

    /*发包资格*/
    /*发包资格*/
	private String fbzg;

    /*经办人*/
    /*经办人*/
	private String jbr;

    /*建设部编号*/
    /*建设部编号*/
	private String jsbCode;

    /*gis x坐标*/
    /*gis x坐标*/
	private Double gisX;

    /*gis y坐标*/
    /*gis y坐标*/
	private Double gisY;

    /*Gis 线段*/
    /*Gis 线段*/
	private String gisLine;

    /*共享时间*/
    /*共享时间*/
	private java.sql.Timestamp shareDatetime;

    /*状态*/
    /*状态*/
	private String shareStatus;

    /*卡号*/
    /*卡号*/
	private String cardId;

    /*勘察环节无需办理或特别通过*/
    /*勘察环节无需办理或特别通过*/
	private Long proSpecialFlagKc;

    /*设计环节无需办理或特别通过*/
    /*设计环节无需办理或特别通过*/
	private Long proSpecialFlagSj;

    /*施工环节无需办理或特别通过*/
    /*施工环节无需办理或特别通过*/
	private Long proSpecialFlagSg;

    /*施工监理环节无需办理或特别通过*/
    /*施工监理环节无需办理或特别通过*/
	private Long proSpecialFlagJl;

    /*设备监理环节无需办理或特别通过*/
    /*设备监理环节无需办理或特别通过*/
	private Long proSpecialFlagDev;




	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="BJBH"
     */
	public String getBjbh () {
		return bjbh;
	}

	/**
	 * Set the unique identifier of this class
	 * @param bjbh the new ID
	 * @deprecated
	 */
	public void setBjbh (String bjbh) {
		this.bjbh = bjbh;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: BJ_DATE
	 */
	public java.sql.Date getBjDate () {
		return bjDate;
	}

	/**
	 * Set the value related to the column: BJ_DATE
	 * @param bjDate the BJ_DATE value
	 */
	public void setBjDate (java.sql.Date bjDate) {
		this.bjDate = bjDate;
	}


	/**
	 * Return the value associated with the column: BUILD_UNIT_NAME
	 */
	public String getBuildUnitName () {
		return buildUnitName;
	}

	/**
	 * Set the value related to the column: BUILD_UNIT_NAME
	 * @param buildUnitName the BUILD_UNIT_NAME value
	 */
	public void setBuildUnitName (String buildUnitName) {
		this.buildUnitName = buildUnitName;
	}


	/**
	 * Return the value associated with the column: BUILD_UNIT_PROPERTY
	 */
	public String getBuildUnitProperty () {
		return buildUnitProperty;
	}

	/**
	 * Set the value related to the column: BUILD_UNIT_PROPERTY
	 * @param buildUnitProperty the BUILD_UNIT_PROPERTY value
	 */
	public void setBuildUnitProperty (String buildUnitProperty) {
		this.buildUnitProperty = buildUnitProperty;
	}


	/**
	 * Return the value associated with the column: BUILD_UNIT_PROPERTY_ID
	 */
	public Long getBuildUnitPropertyId () {
		return buildUnitPropertyId;
	}

	/**
	 * Set the value related to the column: BUILD_UNIT_PROPERTY_ID
	 * @param buildUnitPropertyId the BUILD_UNIT_PROPERTY_ID value
	 */
	public void setBuildUnitPropertyId (Long buildUnitPropertyId) {
		this.buildUnitPropertyId = buildUnitPropertyId;
	}


	/**
	 * Return the value associated with the column: BUILD_UNIT_ADDRESS
	 */
	public String getBuildUnitAddress () {
		return buildUnitAddress;
	}

	/**
	 * Set the value related to the column: BUILD_UNIT_ADDRESS
	 * @param buildUnitAddress the BUILD_UNIT_ADDRESS value
	 */
	public void setBuildUnitAddress (String buildUnitAddress) {
		this.buildUnitAddress = buildUnitAddress;
	}


	/**
	 * Return the value associated with the column: BUILD_UNIT_TEL
	 */
	public String getBuildUnitTel () {
		return buildUnitTel;
	}

	/**
	 * Set the value related to the column: BUILD_UNIT_TEL
	 * @param buildUnitTel the BUILD_UNIT_TEL value
	 */
	public void setBuildUnitTel (String buildUnitTel) {
		this.buildUnitTel = buildUnitTel;
	}


	/**
	 * Return the value associated with the column: BUILD_UNIT_LEGAL
	 */
	public String getBuildUnitLegal () {
		return buildUnitLegal;
	}

	/**
	 * Set the value related to the column: BUILD_UNIT_LEGAL
	 * @param buildUnitLegal the BUILD_UNIT_LEGAL value
	 */
	public void setBuildUnitLegal (String buildUnitLegal) {
		this.buildUnitLegal = buildUnitLegal;
	}


	/**
	 * Return the value associated with the column: BUILD_UNIT_LINKMAN
	 */
	public String getBuildUnitLinkman () {
		return buildUnitLinkman;
	}

	/**
	 * Set the value related to the column: BUILD_UNIT_LINKMAN
	 * @param buildUnitLinkman the BUILD_UNIT_LINKMAN value
	 */
	public void setBuildUnitLinkman (String buildUnitLinkman) {
		this.buildUnitLinkman = buildUnitLinkman;
	}


	/**
	 * Return the value associated with the column: BUILD_UNIT_ZIPCODE
	 */
	public String getBuildUnitZipcode () {
		return buildUnitZipcode;
	}

	/**
	 * Set the value related to the column: BUILD_UNIT_ZIPCODE
	 * @param buildUnitZipcode the BUILD_UNIT_ZIPCODE value
	 */
	public void setBuildUnitZipcode (String buildUnitZipcode) {
		this.buildUnitZipcode = buildUnitZipcode;
	}


	/**
	 * Return the value associated with the column: BUILD_UNIT_REG_MONEY
	 */
	public Double getBuildUnitRegMoney () {
		return buildUnitRegMoney;
	}

	/**
	 * Set the value related to the column: BUILD_UNIT_REG_MONEY
	 * @param buildUnitRegMoney the BUILD_UNIT_REG_MONEY value
	 */
	public void setBuildUnitRegMoney (Double buildUnitRegMoney) {
		this.buildUnitRegMoney = buildUnitRegMoney;
	}


	/**
	 * Return the value associated with the column: PROJECT_NAME
	 */
	public String getProjectName () {
		return projectName;
	}

	/**
	 * Set the value related to the column: PROJECT_NAME
	 * @param projectName the PROJECT_NAME value
	 */
	public void setProjectName (String projectName) {
		this.projectName = projectName;
	}


	/**
	 * Return the value associated with the column: BUILD_ADDRESS
	 */
	public String getBuildAddress () {
		return buildAddress;
	}

	/**
	 * Set the value related to the column: BUILD_ADDRESS
	 * @param buildAddress the BUILD_ADDRESS value
	 */
	public void setBuildAddress (String buildAddress) {
		this.buildAddress = buildAddress;
	}


	/**
	 * Return the value associated with the column: LX_FILE
	 */
	public String getLxFile () {
		return lxFile;
	}

	/**
	 * Set the value related to the column: LX_FILE
	 * @param lxFile the LX_FILE value
	 */
	public void setLxFile (String lxFile) {
		this.lxFile = lxFile;
	}


	/**
	 * Return the value associated with the column: LX_FILE_CODE
	 */
	public String getLxFileCode () {
		return lxFileCode;
	}

	/**
	 * Set the value related to the column: LX_FILE_CODE
	 * @param lxFileCode the LX_FILE_CODE value
	 */
	public void setLxFileCode (String lxFileCode) {
		this.lxFileCode = lxFileCode;
	}


	/**
	 * Return the value associated with the column: LX_LEVEL
	 */
	public String getLxLevel () {
		return lxLevel;
	}

	/**
	 * Set the value related to the column: LX_LEVEL
	 * @param lxLevel the LX_LEVEL value
	 */
	public void setLxLevel (String lxLevel) {
		this.lxLevel = lxLevel;
	}


	/**
	 * Return the value associated with the column: LX_LEVEL_ID
	 */
	public Long getLxLevelId () {
		return lxLevelId;
	}

	/**
	 * Set the value related to the column: LX_LEVEL_ID
	 * @param lxLevelId the LX_LEVEL_ID value
	 */
	public void setLxLevelId (Long lxLevelId) {
		this.lxLevelId = lxLevelId;
	}


	/**
	 * Return the value associated with the column: LX_CLASS
	 */
	public String getLxClass () {
		return lxClass;
	}

	/**
	 * Set the value related to the column: LX_CLASS
	 * @param lxClass the LX_CLASS value
	 */
	public void setLxClass (String lxClass) {
		this.lxClass = lxClass;
	}


	/**
	 * Return the value associated with the column: LX_CLASS_ID
	 */
	public Long getLxClassId () {
		return lxClassId;
	}

	/**
	 * Set the value related to the column: LX_CLASS_ID
	 * @param lxClassId the LX_CLASS_ID value
	 */
	public void setLxClassId (Long lxClassId) {
		this.lxClassId = lxClassId;
	}


	/**
	 * Return the value associated with the column: APPROVAL_UNIT
	 */
	public String getApprovalUnit () {
		return approvalUnit;
	}

	/**
	 * Set the value related to the column: APPROVAL_UNIT
	 * @param approvalUnit the APPROVAL_UNIT value
	 */
	public void setApprovalUnit (String approvalUnit) {
		this.approvalUnit = approvalUnit;
	}


	/**
	 * Return the value associated with the column: APPROVAL_DATE
	 */
	public java.sql.Date getApprovalDate () {
		return approvalDate;
	}

	/**
	 * Set the value related to the column: APPROVAL_DATE
	 * @param approvalDate the APPROVAL_DATE value
	 */
	public void setApprovalDate (java.sql.Date approvalDate) {
		this.approvalDate = approvalDate;
	}


	/**
	 * Return the value associated with the column: TOTAL_INVESTMENT
	 */
	public Double getTotalInvestment () {
		return totalInvestment;
	}

	/**
	 * Set the value related to the column: TOTAL_INVESTMENT
	 * @param totalInvestment the TOTAL_INVESTMENT value
	 */
	public void setTotalInvestment (Double totalInvestment) {
		this.totalInvestment = totalInvestment;
	}


	/**
	 * Return the value associated with the column: DEV_INVESTMENT
	 */
	public Double getDevInvestment () {
		return devInvestment;
	}

	/**
	 * Set the value related to the column: DEV_INVESTMENT
	 * @param devInvestment the DEV_INVESTMENT value
	 */
	public void setDevInvestment (Double devInvestment) {
		this.devInvestment = devInvestment;
	}


	/**
	 * Return the value associated with the column: BUILD_PROPERTY
	 */
	public String getBuildProperty () {
		return buildProperty;
	}

	/**
	 * Set the value related to the column: BUILD_PROPERTY
	 * @param buildProperty the BUILD_PROPERTY value
	 */
	public void setBuildProperty (String buildProperty) {
		this.buildProperty = buildProperty;
	}


	/**
	 * Return the value associated with the column: BUILD_PROPERTY_ID
	 */
	public Long getBuildPropertyId () {
		return buildPropertyId;
	}

	/**
	 * Set the value related to the column: BUILD_PROPERTY_ID
	 * @param buildPropertyId the BUILD_PROPERTY_ID value
	 */
	public void setBuildPropertyId (Long buildPropertyId) {
		this.buildPropertyId = buildPropertyId;
	}


	/**
	 * Return the value associated with the column: BUILD_SCALE
	 */
	public String getBuildScale () {
		return buildScale;
	}

	/**
	 * Set the value related to the column: BUILD_SCALE
	 * @param buildScale the BUILD_SCALE value
	 */
	public void setBuildScale (String buildScale) {
		this.buildScale = buildScale;
	}


	/**
	 * Return the value associated with the column: TOTAL_AREA
	 */
	public Double getTotalArea () {
		return totalArea;
	}

	/**
	 * Set the value related to the column: TOTAL_AREA
	 * @param totalArea the TOTAL_AREA value
	 */
	public void setTotalArea (Double totalArea) {
		this.totalArea = totalArea;
	}


	/**
	 * Return the value associated with the column: BUILD_START_DATE
	 */
	public java.sql.Date getBuildStartDate () {
		return buildStartDate;
	}

	/**
	 * Set the value related to the column: BUILD_START_DATE
	 * @param buildStartDate the BUILD_START_DATE value
	 */
	public void setBuildStartDate (java.sql.Date buildStartDate) {
		this.buildStartDate = buildStartDate;
	}


	/**
	 * Return the value associated with the column: PROJECT_PROPERTY
	 */
	public String getProjectProperty () {
		return projectProperty;
	}

	/**
	 * Set the value related to the column: PROJECT_PROPERTY
	 * @param projectProperty the PROJECT_PROPERTY value
	 */
	public void setProjectProperty (String projectProperty) {
		this.projectProperty = projectProperty;
	}


	/**
	 * Return the value associated with the column: PROJECT_PROPERTY_ID
	 */
	public Long getProjectPropertyId () {
		return projectPropertyId;
	}

	/**
	 * Set the value related to the column: PROJECT_PROPERTY_ID
	 * @param projectPropertyId the PROJECT_PROPERTY_ID value
	 */
	public void setProjectPropertyId (Long projectPropertyId) {
		this.projectPropertyId = projectPropertyId;
	}


	/**
	 * Return the value associated with the column: PREPARE_THING
	 */
	public String getPrepareThing () {
		return prepareThing;
	}

	/**
	 * Set the value related to the column: PREPARE_THING
	 * @param prepareThing the PREPARE_THING value
	 */
	public void setPrepareThing (String prepareThing) {
		this.prepareThing = prepareThing;
	}


	/**
	 * Return the value associated with the column: EXPLAIN_THING
	 */
	public String getExplainThing () {
		return explainThing;
	}

	/**
	 * Set the value related to the column: EXPLAIN_THING
	 * @param explainThing the EXPLAIN_THING value
	 */
	public void setExplainThing (String explainThing) {
		this.explainThing = explainThing;
	}


	/**
	 * Return the value associated with the column: FUND_SOURCE_1
	 */
	public Double getFundSource1 () {
		return fundSource1;
	}

	/**
	 * Set the value related to the column: FUND_SOURCE_1
	 * @param fundSource1 the FUND_SOURCE_1 value
	 */
	public void setFundSource1 (Double fundSource1) {
		this.fundSource1 = fundSource1;
	}


	/**
	 * Return the value associated with the column: FUND_SOURCE_2
	 */
	public Double getFundSource2 () {
		return fundSource2;
	}

	/**
	 * Set the value related to the column: FUND_SOURCE_2
	 * @param fundSource2 the FUND_SOURCE_2 value
	 */
	public void setFundSource2 (Double fundSource2) {
		this.fundSource2 = fundSource2;
	}


	/**
	 * Return the value associated with the column: FUND_SOURCE_3
	 */
	public Double getFundSource3 () {
		return fundSource3;
	}

	/**
	 * Set the value related to the column: FUND_SOURCE_3
	 * @param fundSource3 the FUND_SOURCE_3 value
	 */
	public void setFundSource3 (Double fundSource3) {
		this.fundSource3 = fundSource3;
	}


	/**
	 * Return the value associated with the column: FUND_SOURCE_4
	 */
	public Double getFundSource4 () {
		return fundSource4;
	}

	/**
	 * Set the value related to the column: FUND_SOURCE_4
	 * @param fundSource4 the FUND_SOURCE_4 value
	 */
	public void setFundSource4 (Double fundSource4) {
		this.fundSource4 = fundSource4;
	}


	/**
	 * Return the value associated with the column: FUND_SOURCE_5
	 */
	public Double getFundSource5 () {
		return fundSource5;
	}

	/**
	 * Set the value related to the column: FUND_SOURCE_5
	 * @param fundSource5 the FUND_SOURCE_5 value
	 */
	public void setFundSource5 (Double fundSource5) {
		this.fundSource5 = fundSource5;
	}


	/**
	 * Return the value associated with the column: FUND_SOURCE_6
	 */
	public Double getFundSource6 () {
		return fundSource6;
	}

	/**
	 * Set the value related to the column: FUND_SOURCE_6
	 * @param fundSource6 the FUND_SOURCE_6 value
	 */
	public void setFundSource6 (Double fundSource6) {
		this.fundSource6 = fundSource6;
	}


	/**
	 * Return the value associated with the column: FUND_SOURCE_7
	 */
	public Double getFundSource7 () {
		return fundSource7;
	}

	/**
	 * Set the value related to the column: FUND_SOURCE_7
	 * @param fundSource7 the FUND_SOURCE_7 value
	 */
	public void setFundSource7 (Double fundSource7) {
		this.fundSource7 = fundSource7;
	}


	/**
	 * Return the value associated with the column: FUND_SOURCE_8
	 */
	public Double getFundSource8 () {
		return fundSource8;
	}

	/**
	 * Set the value related to the column: FUND_SOURCE_8
	 * @param fundSource8 the FUND_SOURCE_8 value
	 */
	public void setFundSource8 (Double fundSource8) {
		this.fundSource8 = fundSource8;
	}


	/**
	 * Return the value associated with the column: FUND_SOURCE_9
	 */
	public Double getFundSource9 () {
		return fundSource9;
	}

	/**
	 * Set the value related to the column: FUND_SOURCE_9
	 * @param fundSource9 the FUND_SOURCE_9 value
	 */
	public void setFundSource9 (Double fundSource9) {
		this.fundSource9 = fundSource9;
	}


	/**
	 * Return the value associated with the column: STRUCTURE_FORM
	 */
	public String getStructureForm () {
		return structureForm;
	}

	/**
	 * Set the value related to the column: STRUCTURE_FORM
	 * @param structureForm the STRUCTURE_FORM value
	 */
	public void setStructureForm (String structureForm) {
		this.structureForm = structureForm;
	}


	/**
	 * Return the value associated with the column: STRUCTURE_FORM_ID
	 */
	public Long getStructureFormId () {
		return structureFormId;
	}

	/**
	 * Set the value related to the column: STRUCTURE_FORM_ID
	 * @param structureFormId the STRUCTURE_FORM_ID value
	 */
	public void setStructureFormId (Long structureFormId) {
		this.structureFormId = structureFormId;
	}


	/**
	 * Return the value associated with the column: PROJECT_TYPE
	 */
	public String getProjectType () {
		return projectType;
	}

	/**
	 * Set the value related to the column: PROJECT_TYPE
	 * @param projectType the PROJECT_TYPE value
	 */
	public void setProjectType (String projectType) {
		this.projectType = projectType;
	}


	/**
	 * Return the value associated with the column: PROJECT_TYPE_ID
	 */
	public Long getProjectTypeId () {
		return projectTypeId;
	}

	/**
	 * Set the value related to the column: PROJECT_TYPE_ID
	 * @param projectTypeId the PROJECT_TYPE_ID value
	 */
	public void setProjectTypeId (Long projectTypeId) {
		this.projectTypeId = projectTypeId;
	}


	/**
	 * Return the value associated with the column: BMDM
	 */
	public String getBmdm () {
		return bmdm;
	}

	/**
	 * Set the value related to the column: BMDM
	 * @param bmdm the BMDM value
	 */
	public void setBmdm (String bmdm) {
		this.bmdm = bmdm;
	}


	/**
	 * Return the value associated with the column: BMMC
	 */
	public String getBmmc () {
		return bmmc;
	}

	/**
	 * Set the value related to the column: BMMC
	 * @param bmmc the BMMC value
	 */
	public void setBmmc (String bmmc) {
		this.bmmc = bmmc;
	}


	/**
	 * Return the value associated with the column: IS_STATE_HOLDING
	 */
	public String getIsStateHolding () {
		return isStateHolding;
	}

	/**
	 * Set the value related to the column: IS_STATE_HOLDING
	 * @param isStateHolding the IS_STATE_HOLDING value
	 */
	public void setIsStateHolding (String isStateHolding) {
		this.isStateHolding = isStateHolding;
	}


	/**
	 * Return the value associated with the column: BUILD_UNIT_ORG_CODE
	 */
	public String getBuildUnitOrgCode () {
		return buildUnitOrgCode;
	}

	/**
	 * Set the value related to the column: BUILD_UNIT_ORG_CODE
	 * @param buildUnitOrgCode the BUILD_UNIT_ORG_CODE value
	 */
	public void setBuildUnitOrgCode (String buildUnitOrgCode) {
		this.buildUnitOrgCode = buildUnitOrgCode;
	}


	/**
	 * Return the value associated with the column: BJ_PROJECT_PROPERTY
	 */
	public String getBjProjectProperty () {
		return bjProjectProperty;
	}

	/**
	 * Set the value related to the column: BJ_PROJECT_PROPERTY
	 * @param bjProjectProperty the BJ_PROJECT_PROPERTY value
	 */
	public void setBjProjectProperty (String bjProjectProperty) {
		this.bjProjectProperty = bjProjectProperty;
	}


	/**
	 * Return the value associated with the column: BJ_PROJECT_PROPERTY_ID
	 */
	public Long getBjProjectPropertyId () {
		return bjProjectPropertyId;
	}

	/**
	 * Set the value related to the column: BJ_PROJECT_PROPERTY_ID
	 * @param bjProjectPropertyId the BJ_PROJECT_PROPERTY_ID value
	 */
	public void setBjProjectPropertyId (Long bjProjectPropertyId) {
		this.bjProjectPropertyId = bjProjectPropertyId;
	}


	/**
	 * Return the value associated with the column: FGW_EXCHANGE_CODE
	 */
	public String getFgwExchangeCode () {
		return fgwExchangeCode;
	}

	/**
	 * Set the value related to the column: FGW_EXCHANGE_CODE
	 * @param fgwExchangeCode the FGW_EXCHANGE_CODE value
	 */
	public void setFgwExchangeCode (String fgwExchangeCode) {
		this.fgwExchangeCode = fgwExchangeCode;
	}


	/**
	 * Return the value associated with the column: BELONG_AREA
	 */
	public String getBelongArea () {
		return belongArea;
	}

	/**
	 * Set the value related to the column: BELONG_AREA
	 * @param belongArea the BELONG_AREA value
	 */
	public void setBelongArea (String belongArea) {
		this.belongArea = belongArea;
	}


	/**
	 * Return the value associated with the column: BJ_MEMO
	 */
	public String getBjMemo () {
		return bjMemo;
	}

	/**
	 * Set the value related to the column: BJ_MEMO
	 * @param bjMemo the BJ_MEMO value
	 */
	public void setBjMemo (String bjMemo) {
		this.bjMemo = bjMemo;
	}


	/**
	 * Return the value associated with the column: FBZG
	 */
	public String getFbzg () {
		return fbzg;
	}

	/**
	 * Set the value related to the column: FBZG
	 * @param fbzg the FBZG value
	 */
	public void setFbzg (String fbzg) {
		this.fbzg = fbzg;
	}


	/**
	 * Return the value associated with the column: JBR
	 */
	public String getJbr () {
		return jbr;
	}

	/**
	 * Set the value related to the column: JBR
	 * @param jbr the JBR value
	 */
	public void setJbr (String jbr) {
		this.jbr = jbr;
	}


	/**
	 * Return the value associated with the column: JSB_CODE
	 */
	public String getJsbCode () {
		return jsbCode;
	}

	/**
	 * Set the value related to the column: JSB_CODE
	 * @param jsbCode the JSB_CODE value
	 */
	public void setJsbCode (String jsbCode) {
		this.jsbCode = jsbCode;
	}


	/**
	 * Return the value associated with the column: GIS_X
	 */
	public Double getGisX () {
		return gisX;
	}

	/**
	 * Set the value related to the column: GIS_X
	 * @param gisX the GIS_X value
	 */
	public void setGisX (Double gisX) {
		this.gisX = gisX;
	}


	/**
	 * Return the value associated with the column: GIS_Y
	 */
	public Double getGisY () {
		return gisY;
	}

	/**
	 * Set the value related to the column: GIS_Y
	 * @param gisY the GIS_Y value
	 */
	public void setGisY (Double gisY) {
		this.gisY = gisY;
	}


	/**
	 * Return the value associated with the column: GIS_LINE
	 */
	public String getGisLine () {
		return gisLine;
	}

	/**
	 * Set the value related to the column: GIS_LINE
	 * @param gisLine the GIS_LINE value
	 */
	public void setGisLine (String gisLine) {
		this.gisLine = gisLine;
	}


	/**
	 * Return the value associated with the column: SHARE_DATETIME
	 */
	public java.sql.Timestamp getShareDatetime () {
		return shareDatetime;
	}

	/**
	 * Set the value related to the column: SHARE_DATETIME
	 * @param shareDatetime the SHARE_DATETIME value
	 */
	public void setShareDatetime (java.sql.Timestamp shareDatetime) {
		this.shareDatetime = shareDatetime;
	}


	/**
	 * Return the value associated with the column: SHARE_STATUS
	 */
	public String getShareStatus () {
		return shareStatus;
	}

	/**
	 * Set the value related to the column: SHARE_STATUS
	 * @param shareStatus the SHARE_STATUS value
	 */
	public void setShareStatus (String shareStatus) {
		this.shareStatus = shareStatus;
	}


	/**
	 * Return the value associated with the column: CARD_ID
	 */
	public String getCardId () {
		return cardId;
	}

	/**
	 * Set the value related to the column: CARD_ID
	 * @param cardId the CARD_ID value
	 */
	public void setCardId (String cardId) {
		this.cardId = cardId;
	}


	/**
	 * Return the value associated with the column: PRO_SPECIAL_FLAG_KC
	 */
	public Long getProSpecialFlagKc () {
		return proSpecialFlagKc;
	}

	/**
	 * Set the value related to the column: PRO_SPECIAL_FLAG_KC
	 * @param proSpecialFlagKc the PRO_SPECIAL_FLAG_KC value
	 */
	public void setProSpecialFlagKc (Long proSpecialFlagKc) {
		this.proSpecialFlagKc = proSpecialFlagKc;
	}


	/**
	 * Return the value associated with the column: PRO_SPECIAL_FLAG_SJ
	 */
	public Long getProSpecialFlagSj () {
		return proSpecialFlagSj;
	}

	/**
	 * Set the value related to the column: PRO_SPECIAL_FLAG_SJ
	 * @param proSpecialFlagSj the PRO_SPECIAL_FLAG_SJ value
	 */
	public void setProSpecialFlagSj (Long proSpecialFlagSj) {
		this.proSpecialFlagSj = proSpecialFlagSj;
	}


	/**
	 * Return the value associated with the column: PRO_SPECIAL_FLAG_SG
	 */
	public Long getProSpecialFlagSg () {
		return proSpecialFlagSg;
	}

	/**
	 * Set the value related to the column: PRO_SPECIAL_FLAG_SG
	 * @param proSpecialFlagSg the PRO_SPECIAL_FLAG_SG value
	 */
	public void setProSpecialFlagSg (Long proSpecialFlagSg) {
		this.proSpecialFlagSg = proSpecialFlagSg;
	}


	/**
	 * Return the value associated with the column: PRO_SPECIAL_FLAG_JL
	 */
	public Long getProSpecialFlagJl () {
		return proSpecialFlagJl;
	}

	/**
	 * Set the value related to the column: PRO_SPECIAL_FLAG_JL
	 * @param proSpecialFlagJl the PRO_SPECIAL_FLAG_JL value
	 */
	public void setProSpecialFlagJl (Long proSpecialFlagJl) {
		this.proSpecialFlagJl = proSpecialFlagJl;
	}


	/**
	 * Return the value associated with the column: PRO_SPECIAL_FLAG_DEV
	 */
	public Long getProSpecialFlagDev () {
		return proSpecialFlagDev;
	}

	/**
	 * Set the value related to the column: PRO_SPECIAL_FLAG_DEV
	 * @param proSpecialFlagDev the PRO_SPECIAL_FLAG_DEV value
	 */
	public void setProSpecialFlagDev (Long proSpecialFlagDev) {
		this.proSpecialFlagDev = proSpecialFlagDev;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof ShareProTobuild)) return false;
		else {
			ShareProTobuild shareProTobuild = (ShareProTobuild) obj;
			if (null == this.getBjbh() || null == shareProTobuild.getBjbh()) return false;
			else return (this.getBjbh().equals(shareProTobuild.getBjbh()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getBjbh()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getBjbh().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
		builder.append(bjbh);
		builder.append(bjDate);
		builder.append(buildUnitName);
		builder.append(buildUnitProperty);
		builder.append(buildUnitPropertyId);
		builder.append(buildUnitAddress);
		builder.append(buildUnitTel);
		builder.append(buildUnitLegal);
		builder.append(buildUnitLinkman);
		builder.append(buildUnitZipcode);
		builder.append(buildUnitRegMoney);
		builder.append(projectName);
		builder.append(buildAddress);
		builder.append(lxFile);
		builder.append(lxFileCode);
		builder.append(lxLevel);
		builder.append(lxLevelId);
		builder.append(lxClass);
		builder.append(lxClassId);
		builder.append(approvalUnit);
		builder.append(approvalDate);
		builder.append(totalInvestment);
		builder.append(devInvestment);
		builder.append(buildProperty);
		builder.append(buildPropertyId);
		builder.append(buildScale);
		builder.append(totalArea);
		builder.append(buildStartDate);
		builder.append(projectProperty);
		builder.append(projectPropertyId);
		builder.append(prepareThing);
		builder.append(explainThing);
		builder.append(fundSource1);
		builder.append(fundSource2);
		builder.append(fundSource3);
		builder.append(fundSource4);
		builder.append(fundSource5);
		builder.append(fundSource6);
		builder.append(fundSource7);
		builder.append(fundSource8);
		builder.append(fundSource9);
		builder.append(structureForm);
		builder.append(structureFormId);
		builder.append(projectType);
		builder.append(projectTypeId);
		builder.append(bmdm);
		builder.append(bmmc);
		builder.append(isStateHolding);
		builder.append(buildUnitOrgCode);
		builder.append(bjProjectProperty);
		builder.append(bjProjectPropertyId);
		builder.append(fgwExchangeCode);
		builder.append(belongArea);
		builder.append(bjMemo);
		builder.append(fbzg);
		builder.append(jbr);
		builder.append(jsbCode);
		builder.append(gisX);
		builder.append(gisY);
		builder.append(gisLine);
		builder.append(shareDatetime);
		builder.append(shareStatus);
		builder.append(cardId);
		builder.append(proSpecialFlagKc);
		builder.append(proSpecialFlagSj);
		builder.append(proSpecialFlagSg);
		builder.append(proSpecialFlagJl);
		builder.append(proSpecialFlagDev);
		return builder.toString();
	}


}