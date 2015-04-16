package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHARE_PUNISH_CASE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 行政处罚记录
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 行政处罚记录
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : share
 * Projectable : false
 *
 * @hibernate.class
 *  table="SHARE_PUNISH_CASE"
 */

public abstract class BaseSharePunishCase  implements Serializable {

	public static String REF = "SharePunishCase";
	public static String PROP_UNIT_NAME = "unitName";
	public static String PROP_BREAK_LAW_RULES = "breakLawRules";
	public static String PROP_DC_COMPLETE_TIME = "dcCompleteTime";
	public static String PROP_EXE_UNIT_CODE = "exeUnitCode";
	public static String PROP_PERSON_CARD_TYPE = "personCardType";
	public static String PROP_PRO_ADDRESS = "proAddress";
	public static String PROP_PRO_TYPE = "proType";
	public static String PROP_PERSON_NAME = "personName";
	public static String PROP_EXE_UNIT_NAME = "exeUnitName";
	public static String PROP_CASE_CODE = "caseCode";
	public static String PROP_LA_COMPLETE_TIME = "laCompleteTime";
	public static String PROP_PERSON_WORK_UNIT = "personWorkUnit";
	public static String PROP_BREAK_LAW_CONTENT = "breakLawContent";
	public static String PROP_PERSON_CARD_NO = "personCardNo";
	public static String PROP_JA_UNIT_NAME = "jaUnitName";
	public static String PROP_JA_DATETIME = "jaDatetime";
	public static String PROP_UNIT_PROPERTY = "unitProperty";
	public static String PROP_BJBH = "bjbh";
	public static String PROP_SP_COMPLETE_TIME = "spCompleteTime";
	public static String PROP_PRO_NAME = "proName";
	public static String PROP_UNIT_ID = "unitId";
	public static String PROP_JA_UNIT_CODE = "jaUnitCode";
	public static String PROP_HAPPEN_ADDRESS = "happenAddress";
	public static String PROP_LA_UNIT_CODE = "laUnitCode";
	public static String PROP_UNIT_QUALIFY_TYPE_DESC = "unitQualifyTypeDesc";
	public static String PROP_JA_UNIT_JBR = "jaUnitJbr";
	public static String PROP_UNIT_QUALIFY_TYPE = "unitQualifyType";
	public static String PROP_LA_UNIT_JBR = "laUnitJbr";
	public static String PROP_BP_COMPLETE_TIME = "bpCompleteTime";
	public static String PROP_ZX_COMPLETE_TIME = "zxCompleteTime";
	public static String PROP_PRO_CONT_MONEY = "proContMoney";
	public static String PROP_LA_DATE = "laDate";
	public static String PROP_PERSON_CARD_TYPE_DESC = "personCardTypeDesc";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_PUNISH_LAW_RULES = "punishLawRules";
	public static String PROP_JA_COMPLETE_TIME = "jaCompleteTime";
	public static String PROP_LA_UNIT_NAME = "laUnitName";
	public static String PROP_LA_DATETIME = "laDatetime";
	public static String PROP_UNIT_CODE = "unitCode";
	public static String PROP_IS_HEARING = "isHearing";
	public static String PROP_HAPPEN_DATETIME = "happenDatetime";
	public static String PROP_ID = "id";
	public static String PROP_DECISION_CODE = "decisionCode";
	public static String PROP_STAGE = "stage";
	public static String PROP_IS_COMPANY = "isCompany";
	public static String PROP_IS_ABORT = "isAbort";


	// constructors
	public BaseSharePunishCase () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSharePunishCase (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*案件编号*/
    /*案件编号*/
	private java.lang.String caseCode;
	
    /*决定书编号*/
    /*决定书编号*/
	private java.lang.String decisionCode;
	
    /*案发日期*/
    /*案发日期*/
	private java.sql.Timestamp happenDatetime;
	
    /*案发地点*/
    /*案发地点*/
	private java.lang.String happenAddress;
	
    /*立案日期*/
    /*立案日期*/
	private java.sql.Date laDate;
	
    /*立案时间*/
    /*立案时间*/
	private java.sql.Timestamp laDatetime;
	
    /*结案日期*/
    /*结案日期*/
	private java.sql.Timestamp jaDatetime;
	
    /*立案完成日期*/
    /*立案完成日期*/
	private java.sql.Timestamp laCompleteTime;
	
    /*调查完成日期*/
    /*调查完成日期*/
	private java.sql.Timestamp dcCompleteTime;
	
    /*报批完成日期*/
    /*报批完成日期*/
	private java.sql.Timestamp bpCompleteTime;
	
    /*审批完成日期*/
    /*审批完成日期*/
	private java.sql.Timestamp spCompleteTime;
	
    /*执行完成日期*/
    /*执行完成日期*/
	private java.sql.Timestamp zxCompleteTime;
	
    /*结案完成日期*/
    /*结案完成日期*/
	private java.sql.Timestamp jaCompleteTime;
	
    /*是否(单位/个人)(1企业0个人)*/
    /*是否(单位/个人)(1企业0个人)*/
	private java.lang.Boolean isCompany;
	
    /*当事人（单位）*/
    /*当事人（单位）*/
	private java.lang.String unitName;
	
    /*企业id*/
    /*企业id*/
	private java.lang.Long unitId;
	
    /*企业编号*/
    /*企业编号*/
	private java.lang.String unitCode;
	
    /*企业性质*/
    /*企业性质*/
	private java.lang.String unitProperty;
	
    /*企业资质分类*/
    /*企业资质分类*/
	private java.lang.Long unitQualifyType;
	
    /*企业资质分类描述*/
    /*企业资质分类描述*/
	private java.lang.String unitQualifyTypeDesc;
	
    /*当事人姓名*/
    /*当事人姓名*/
	private java.lang.String personName;
	
    /*当事人证件类型*/
    /*当事人证件类型*/
	private java.lang.Long personCardType;
	
    /*当事人证件类型描述*/
    /*当事人证件类型描述*/
	private java.lang.String personCardTypeDesc;
	
    /*证件号*/
    /*证件号*/
	private java.lang.String personCardNo;
	
    /*当事人工作单位*/
    /*当事人工作单位*/
	private java.lang.String personWorkUnit;
	
    /*报建编号*/
    /*报建编号*/
	private java.lang.String bjbh;
	
    /*工程类型*/
    /*工程类型*/
	private java.lang.String proType;
	
    /*工程名称*/
    /*工程名称*/
	private java.lang.String proName;
	
    /*工程地址*/
    /*工程地址*/
	private java.lang.String proAddress;
	
    /*合同价（万元）*/
    /*合同价（万元）*/
	private java.lang.Double proContMoney;
	
    /*立案单位*/
    /*立案单位*/
	private java.lang.String laUnitName;
	
    /*立案单位编号*/
    /*立案单位编号*/
	private java.lang.String laUnitCode;
	
    /*立案单位经办人*/
    /*立案单位经办人*/
	private java.lang.String laUnitJbr;
	
    /*结案单位*/
    /*结案单位*/
	private java.lang.String jaUnitName;
	
    /*结案单位代码*/
    /*结案单位代码*/
	private java.lang.String jaUnitCode;
	
    /*结案单位经办人*/
    /*结案单位经办人*/
	private java.lang.String jaUnitJbr;
	
    /*违法行为*/
    /*违法行为*/
	private java.lang.String breakLawContent;
	
    /*违反条款*/
    /*违反条款*/
	private java.lang.String breakLawRules;
	
    /*处罚依据*/
    /*处罚依据*/
	private java.lang.String punishLawRules;
	
    /*执法主体*/
    /*执法主体*/
	private java.lang.String exeUnitName;
	
    /*执法主体代码*/
    /*执法主体代码*/
	private java.lang.String exeUnitCode;
	
    /*是否听证(1听证0不听证null未到阶段)*/
    /*是否听证(1听证0不听证null未到阶段)*/
	private java.lang.Boolean isHearing;
	
    /*是否中止(1 中止 0或NULL正常)*/
    /*是否中止(1 中止 0或NULL正常)*/
	private java.lang.Boolean isAbort;
	
    /*阶段*/
    /*阶段*/
	private java.lang.Long stage;
	
    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updateTime;
	



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
	 * Return the value associated with the column: CASE_CODE
	 */
	public java.lang.String getCaseCode () {
		return caseCode;
	}

	/**
	 * Set the value related to the column: CASE_CODE
	 * @param caseCode the CASE_CODE value
	 */
	public void setCaseCode (java.lang.String caseCode) {
		this.caseCode = caseCode;
	}


	/**
	 * Return the value associated with the column: DECISION_CODE
	 */
	public java.lang.String getDecisionCode () {
		return decisionCode;
	}

	/**
	 * Set the value related to the column: DECISION_CODE
	 * @param decisionCode the DECISION_CODE value
	 */
	public void setDecisionCode (java.lang.String decisionCode) {
		this.decisionCode = decisionCode;
	}


	/**
	 * Return the value associated with the column: HAPPEN_DATETIME
	 */
	public java.sql.Timestamp getHappenDatetime () {
		return happenDatetime;
	}

	/**
	 * Set the value related to the column: HAPPEN_DATETIME
	 * @param happenDatetime the HAPPEN_DATETIME value
	 */
	public void setHappenDatetime (java.sql.Timestamp happenDatetime) {
		this.happenDatetime = happenDatetime;
	}


	/**
	 * Return the value associated with the column: HAPPEN_ADDRESS
	 */
	public java.lang.String getHappenAddress () {
		return happenAddress;
	}

	/**
	 * Set the value related to the column: HAPPEN_ADDRESS
	 * @param happenAddress the HAPPEN_ADDRESS value
	 */
	public void setHappenAddress (java.lang.String happenAddress) {
		this.happenAddress = happenAddress;
	}


	/**
	 * Return the value associated with the column: LA_DATE
	 */
	public java.sql.Date getLaDate () {
		return laDate;
	}

	/**
	 * Set the value related to the column: LA_DATE
	 * @param laDate the LA_DATE value
	 */
	public void setLaDate (java.sql.Date laDate) {
		this.laDate = laDate;
	}


	/**
	 * Return the value associated with the column: LA_DATETIME
	 */
	public java.sql.Timestamp getLaDatetime () {
		return laDatetime;
	}

	/**
	 * Set the value related to the column: LA_DATETIME
	 * @param laDatetime the LA_DATETIME value
	 */
	public void setLaDatetime (java.sql.Timestamp laDatetime) {
		this.laDatetime = laDatetime;
	}


	/**
	 * Return the value associated with the column: JA_DATETIME
	 */
	public java.sql.Timestamp getJaDatetime () {
		return jaDatetime;
	}

	/**
	 * Set the value related to the column: JA_DATETIME
	 * @param jaDatetime the JA_DATETIME value
	 */
	public void setJaDatetime (java.sql.Timestamp jaDatetime) {
		this.jaDatetime = jaDatetime;
	}


	/**
	 * Return the value associated with the column: LA_COMPLETE_TIME
	 */
	public java.sql.Timestamp getLaCompleteTime () {
		return laCompleteTime;
	}

	/**
	 * Set the value related to the column: LA_COMPLETE_TIME
	 * @param laCompleteTime the LA_COMPLETE_TIME value
	 */
	public void setLaCompleteTime (java.sql.Timestamp laCompleteTime) {
		this.laCompleteTime = laCompleteTime;
	}


	/**
	 * Return the value associated with the column: DC_COMPLETE_TIME
	 */
	public java.sql.Timestamp getDcCompleteTime () {
		return dcCompleteTime;
	}

	/**
	 * Set the value related to the column: DC_COMPLETE_TIME
	 * @param dcCompleteTime the DC_COMPLETE_TIME value
	 */
	public void setDcCompleteTime (java.sql.Timestamp dcCompleteTime) {
		this.dcCompleteTime = dcCompleteTime;
	}


	/**
	 * Return the value associated with the column: BP_COMPLETE_TIME
	 */
	public java.sql.Timestamp getBpCompleteTime () {
		return bpCompleteTime;
	}

	/**
	 * Set the value related to the column: BP_COMPLETE_TIME
	 * @param bpCompleteTime the BP_COMPLETE_TIME value
	 */
	public void setBpCompleteTime (java.sql.Timestamp bpCompleteTime) {
		this.bpCompleteTime = bpCompleteTime;
	}


	/**
	 * Return the value associated with the column: SP_COMPLETE_TIME
	 */
	public java.sql.Timestamp getSpCompleteTime () {
		return spCompleteTime;
	}

	/**
	 * Set the value related to the column: SP_COMPLETE_TIME
	 * @param spCompleteTime the SP_COMPLETE_TIME value
	 */
	public void setSpCompleteTime (java.sql.Timestamp spCompleteTime) {
		this.spCompleteTime = spCompleteTime;
	}


	/**
	 * Return the value associated with the column: ZX_COMPLETE_TIME
	 */
	public java.sql.Timestamp getZxCompleteTime () {
		return zxCompleteTime;
	}

	/**
	 * Set the value related to the column: ZX_COMPLETE_TIME
	 * @param zxCompleteTime the ZX_COMPLETE_TIME value
	 */
	public void setZxCompleteTime (java.sql.Timestamp zxCompleteTime) {
		this.zxCompleteTime = zxCompleteTime;
	}


	/**
	 * Return the value associated with the column: JA_COMPLETE_TIME
	 */
	public java.sql.Timestamp getJaCompleteTime () {
		return jaCompleteTime;
	}

	/**
	 * Set the value related to the column: JA_COMPLETE_TIME
	 * @param jaCompleteTime the JA_COMPLETE_TIME value
	 */
	public void setJaCompleteTime (java.sql.Timestamp jaCompleteTime) {
		this.jaCompleteTime = jaCompleteTime;
	}


	/**
	 * Return the value associated with the column: IS_COMPANY
	 */
	public java.lang.Boolean getIsCompany () {
		return isCompany;
	}

	/**
	 * Set the value related to the column: IS_COMPANY
	 * @param isCompany the IS_COMPANY value
	 */
	public void setIsCompany (java.lang.Boolean isCompany) {
		this.isCompany = isCompany;
	}


	/**
	 * Return the value associated with the column: UNIT_NAME
	 */
	public java.lang.String getUnitName () {
		return unitName;
	}

	/**
	 * Set the value related to the column: UNIT_NAME
	 * @param unitName the UNIT_NAME value
	 */
	public void setUnitName (java.lang.String unitName) {
		this.unitName = unitName;
	}


	/**
	 * Return the value associated with the column: UNIT_ID
	 */
	public java.lang.Long getUnitId () {
		return unitId;
	}

	/**
	 * Set the value related to the column: UNIT_ID
	 * @param unitId the UNIT_ID value
	 */
	public void setUnitId (java.lang.Long unitId) {
		this.unitId = unitId;
	}


	/**
	 * Return the value associated with the column: UNIT_CODE
	 */
	public java.lang.String getUnitCode () {
		return unitCode;
	}

	/**
	 * Set the value related to the column: UNIT_CODE
	 * @param unitCode the UNIT_CODE value
	 */
	public void setUnitCode (java.lang.String unitCode) {
		this.unitCode = unitCode;
	}


	/**
	 * Return the value associated with the column: UNIT_PROPERTY
	 */
	public java.lang.String getUnitProperty () {
		return unitProperty;
	}

	/**
	 * Set the value related to the column: UNIT_PROPERTY
	 * @param unitProperty the UNIT_PROPERTY value
	 */
	public void setUnitProperty (java.lang.String unitProperty) {
		this.unitProperty = unitProperty;
	}


	/**
	 * Return the value associated with the column: UNIT_QUALIFY_TYPE
	 */
	public java.lang.Long getUnitQualifyType () {
		return unitQualifyType;
	}

	/**
	 * Set the value related to the column: UNIT_QUALIFY_TYPE
	 * @param unitQualifyType the UNIT_QUALIFY_TYPE value
	 */
	public void setUnitQualifyType (java.lang.Long unitQualifyType) {
		this.unitQualifyType = unitQualifyType;
	}


	/**
	 * Return the value associated with the column: UNIT_QUALIFY_TYPE_DESC
	 */
	public java.lang.String getUnitQualifyTypeDesc () {
		return unitQualifyTypeDesc;
	}

	/**
	 * Set the value related to the column: UNIT_QUALIFY_TYPE_DESC
	 * @param unitQualifyTypeDesc the UNIT_QUALIFY_TYPE_DESC value
	 */
	public void setUnitQualifyTypeDesc (java.lang.String unitQualifyTypeDesc) {
		this.unitQualifyTypeDesc = unitQualifyTypeDesc;
	}


	/**
	 * Return the value associated with the column: PERSON_NAME
	 */
	public java.lang.String getPersonName () {
		return personName;
	}

	/**
	 * Set the value related to the column: PERSON_NAME
	 * @param personName the PERSON_NAME value
	 */
	public void setPersonName (java.lang.String personName) {
		this.personName = personName;
	}


	/**
	 * Return the value associated with the column: PERSON_CARD_TYPE
	 */
	public java.lang.Long getPersonCardType () {
		return personCardType;
	}

	/**
	 * Set the value related to the column: PERSON_CARD_TYPE
	 * @param personCardType the PERSON_CARD_TYPE value
	 */
	public void setPersonCardType (java.lang.Long personCardType) {
		this.personCardType = personCardType;
	}


	/**
	 * Return the value associated with the column: PERSON_CARD_TYPE_DESC
	 */
	public java.lang.String getPersonCardTypeDesc () {
		return personCardTypeDesc;
	}

	/**
	 * Set the value related to the column: PERSON_CARD_TYPE_DESC
	 * @param personCardTypeDesc the PERSON_CARD_TYPE_DESC value
	 */
	public void setPersonCardTypeDesc (java.lang.String personCardTypeDesc) {
		this.personCardTypeDesc = personCardTypeDesc;
	}


	/**
	 * Return the value associated with the column: PERSON_CARD_NO
	 */
	public java.lang.String getPersonCardNo () {
		return personCardNo;
	}

	/**
	 * Set the value related to the column: PERSON_CARD_NO
	 * @param personCardNo the PERSON_CARD_NO value
	 */
	public void setPersonCardNo (java.lang.String personCardNo) {
		this.personCardNo = personCardNo;
	}


	/**
	 * Return the value associated with the column: PERSON_WORK_UNIT
	 */
	public java.lang.String getPersonWorkUnit () {
		return personWorkUnit;
	}

	/**
	 * Set the value related to the column: PERSON_WORK_UNIT
	 * @param personWorkUnit the PERSON_WORK_UNIT value
	 */
	public void setPersonWorkUnit (java.lang.String personWorkUnit) {
		this.personWorkUnit = personWorkUnit;
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
	 * Return the value associated with the column: PRO_TYPE
	 */
	public java.lang.String getProType () {
		return proType;
	}

	/**
	 * Set the value related to the column: PRO_TYPE
	 * @param proType the PRO_TYPE value
	 */
	public void setProType (java.lang.String proType) {
		this.proType = proType;
	}


	/**
	 * Return the value associated with the column: PRO_NAME
	 */
	public java.lang.String getProName () {
		return proName;
	}

	/**
	 * Set the value related to the column: PRO_NAME
	 * @param proName the PRO_NAME value
	 */
	public void setProName (java.lang.String proName) {
		this.proName = proName;
	}


	/**
	 * Return the value associated with the column: PRO_ADDRESS
	 */
	public java.lang.String getProAddress () {
		return proAddress;
	}

	/**
	 * Set the value related to the column: PRO_ADDRESS
	 * @param proAddress the PRO_ADDRESS value
	 */
	public void setProAddress (java.lang.String proAddress) {
		this.proAddress = proAddress;
	}


	/**
	 * Return the value associated with the column: PRO_CONT_MONEY
	 */
	public java.lang.Double getProContMoney () {
		return proContMoney;
	}

	/**
	 * Set the value related to the column: PRO_CONT_MONEY
	 * @param proContMoney the PRO_CONT_MONEY value
	 */
	public void setProContMoney (java.lang.Double proContMoney) {
		this.proContMoney = proContMoney;
	}


	/**
	 * Return the value associated with the column: LA_UNIT_NAME
	 */
	public java.lang.String getLaUnitName () {
		return laUnitName;
	}

	/**
	 * Set the value related to the column: LA_UNIT_NAME
	 * @param laUnitName the LA_UNIT_NAME value
	 */
	public void setLaUnitName (java.lang.String laUnitName) {
		this.laUnitName = laUnitName;
	}


	/**
	 * Return the value associated with the column: LA_UNIT_CODE
	 */
	public java.lang.String getLaUnitCode () {
		return laUnitCode;
	}

	/**
	 * Set the value related to the column: LA_UNIT_CODE
	 * @param laUnitCode the LA_UNIT_CODE value
	 */
	public void setLaUnitCode (java.lang.String laUnitCode) {
		this.laUnitCode = laUnitCode;
	}


	/**
	 * Return the value associated with the column: LA_UNIT_JBR
	 */
	public java.lang.String getLaUnitJbr () {
		return laUnitJbr;
	}

	/**
	 * Set the value related to the column: LA_UNIT_JBR
	 * @param laUnitJbr the LA_UNIT_JBR value
	 */
	public void setLaUnitJbr (java.lang.String laUnitJbr) {
		this.laUnitJbr = laUnitJbr;
	}


	/**
	 * Return the value associated with the column: JA_UNIT_NAME
	 */
	public java.lang.String getJaUnitName () {
		return jaUnitName;
	}

	/**
	 * Set the value related to the column: JA_UNIT_NAME
	 * @param jaUnitName the JA_UNIT_NAME value
	 */
	public void setJaUnitName (java.lang.String jaUnitName) {
		this.jaUnitName = jaUnitName;
	}


	/**
	 * Return the value associated with the column: JA_UNIT_CODE
	 */
	public java.lang.String getJaUnitCode () {
		return jaUnitCode;
	}

	/**
	 * Set the value related to the column: JA_UNIT_CODE
	 * @param jaUnitCode the JA_UNIT_CODE value
	 */
	public void setJaUnitCode (java.lang.String jaUnitCode) {
		this.jaUnitCode = jaUnitCode;
	}


	/**
	 * Return the value associated with the column: JA_UNIT_JBR
	 */
	public java.lang.String getJaUnitJbr () {
		return jaUnitJbr;
	}

	/**
	 * Set the value related to the column: JA_UNIT_JBR
	 * @param jaUnitJbr the JA_UNIT_JBR value
	 */
	public void setJaUnitJbr (java.lang.String jaUnitJbr) {
		this.jaUnitJbr = jaUnitJbr;
	}


	/**
	 * Return the value associated with the column: BREAK_LAW_CONTENT
	 */
	public java.lang.String getBreakLawContent () {
		return breakLawContent;
	}

	/**
	 * Set the value related to the column: BREAK_LAW_CONTENT
	 * @param breakLawContent the BREAK_LAW_CONTENT value
	 */
	public void setBreakLawContent (java.lang.String breakLawContent) {
		this.breakLawContent = breakLawContent;
	}


	/**
	 * Return the value associated with the column: BREAK_LAW_RULES
	 */
	public java.lang.String getBreakLawRules () {
		return breakLawRules;
	}

	/**
	 * Set the value related to the column: BREAK_LAW_RULES
	 * @param breakLawRules the BREAK_LAW_RULES value
	 */
	public void setBreakLawRules (java.lang.String breakLawRules) {
		this.breakLawRules = breakLawRules;
	}


	/**
	 * Return the value associated with the column: PUNISH_LAW_RULES
	 */
	public java.lang.String getPunishLawRules () {
		return punishLawRules;
	}

	/**
	 * Set the value related to the column: PUNISH_LAW_RULES
	 * @param punishLawRules the PUNISH_LAW_RULES value
	 */
	public void setPunishLawRules (java.lang.String punishLawRules) {
		this.punishLawRules = punishLawRules;
	}


	/**
	 * Return the value associated with the column: EXE_UNIT_NAME
	 */
	public java.lang.String getExeUnitName () {
		return exeUnitName;
	}

	/**
	 * Set the value related to the column: EXE_UNIT_NAME
	 * @param exeUnitName the EXE_UNIT_NAME value
	 */
	public void setExeUnitName (java.lang.String exeUnitName) {
		this.exeUnitName = exeUnitName;
	}


	/**
	 * Return the value associated with the column: EXE_UNIT_CODE
	 */
	public java.lang.String getExeUnitCode () {
		return exeUnitCode;
	}

	/**
	 * Set the value related to the column: EXE_UNIT_CODE
	 * @param exeUnitCode the EXE_UNIT_CODE value
	 */
	public void setExeUnitCode (java.lang.String exeUnitCode) {
		this.exeUnitCode = exeUnitCode;
	}


	/**
	 * Return the value associated with the column: IS_HEARING
	 */
	public java.lang.Boolean getIsHearing () {
		return isHearing;
	}

	/**
	 * Set the value related to the column: IS_HEARING
	 * @param isHearing the IS_HEARING value
	 */
	public void setIsHearing (java.lang.Boolean isHearing) {
		this.isHearing = isHearing;
	}


	/**
	 * Return the value associated with the column: IS_ABORT
	 */
	public java.lang.Boolean getIsAbort () {
		return isAbort;
	}

	/**
	 * Set the value related to the column: IS_ABORT
	 * @param isAbort the IS_ABORT value
	 */
	public void setIsAbort (java.lang.Boolean isAbort) {
		this.isAbort = isAbort;
	}


	/**
	 * Return the value associated with the column: STAGE
	 */
	public java.lang.Long getStage () {
		return stage;
	}

	/**
	 * Set the value related to the column: STAGE
	 * @param stage the STAGE value
	 */
	public void setStage (java.lang.Long stage) {
		this.stage = stage;
	}


	/**
	 * Return the value associated with the column: UPDATE_TIME
	 */
	public java.sql.Timestamp getUpdateTime () {
		return updateTime;
	}

	/**
	 * Set the value related to the column: UPDATE_TIME
	 * @param updateTime the UPDATE_TIME value
	 */
	public void setUpdateTime (java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.SharePunishCase)) return false;
		else {
			com.justonetech.biz.domain.SharePunishCase sharePunishCase = (com.justonetech.biz.domain.SharePunishCase) obj;
			if (null == this.getId() || null == sharePunishCase.getId()) return false;
			else return (this.getId().equals(sharePunishCase.getId()));
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
		builder.append(caseCode);
		builder.append(decisionCode);
		builder.append(happenDatetime);
		builder.append(happenAddress);
		builder.append(laDate);
		builder.append(laDatetime);
		builder.append(jaDatetime);
		builder.append(laCompleteTime);
		builder.append(dcCompleteTime);
		builder.append(bpCompleteTime);
		builder.append(spCompleteTime);
		builder.append(zxCompleteTime);
		builder.append(jaCompleteTime);
		builder.append(isCompany);
		builder.append(unitName);
		builder.append(unitId);
		builder.append(unitCode);
		builder.append(unitProperty);
		builder.append(unitQualifyType);
		builder.append(unitQualifyTypeDesc);
		builder.append(personName);
		builder.append(personCardType);
		builder.append(personCardTypeDesc);
		builder.append(personCardNo);
		builder.append(personWorkUnit);
		builder.append(bjbh);
		builder.append(proType);
		builder.append(proName);
		builder.append(proAddress);
		builder.append(proContMoney);
		builder.append(laUnitName);
		builder.append(laUnitCode);
		builder.append(laUnitJbr);
		builder.append(jaUnitName);
		builder.append(jaUnitCode);
		builder.append(jaUnitJbr);
		builder.append(breakLawContent);
		builder.append(breakLawRules);
		builder.append(punishLawRules);
		builder.append(exeUnitName);
		builder.append(exeUnitCode);
		builder.append(isHearing);
		builder.append(isAbort);
		builder.append(stage);
		builder.append(updateTime);
		return builder.toString();
	}


}