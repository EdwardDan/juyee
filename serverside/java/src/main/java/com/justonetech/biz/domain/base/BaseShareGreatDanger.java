package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHARE_GREAT_DANGER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 重大危险源信息
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 重大危险源信息
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : share
 * Projectable : false
 *
 * @hibernate.class
 *  table="SHARE_GREAT_DANGER"
 */

public abstract class BaseShareGreatDanger  implements Serializable {

	public static String REF = "ShareGreatDanger";
	public static String PROP_DANGER_CODE_DESC = "dangerCodeDesc";
	public static String PROP_RELATE_ID = "relateId";
	public static String PROP_DANGER_LEVEL = "dangerLevel";
	public static String PROP_DANGER_TYPE_DESC = "dangerTypeDesc";
	public static String PROP_OPERATE_FLAG = "operateFlag";
	public static String PROP_CHANGER_DATETIME = "changerDatetime";
	public static String PROP_DANGER_LEVEL_DESC = "dangerLevelDesc";
	public static String PROP_END_DATE = "endDate";
	public static String PROP_SUBJECT_CB_UNIT_NAME = "subjectCbUnitName";
	public static String PROP_START_DATE = "startDate";
	public static String PROP_SQBH = "sqbh";
	public static String PROP_ID = "id";
	public static String PROP_SUBJECT_CB_UNIT_CODE = "subjectCbUnitCode";
	public static String PROP_DANGER_TYPE = "dangerType";
	public static String PROP_DANGER_CODE = "dangerCode";


	// constructors
	public BaseShareGreatDanger () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShareGreatDanger (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*申请编号(对应tab_sqbh)*/
    /*申请编号(对应tab_sqbh)*/
	private java.lang.String sqbh;
	
    /*危险源类别*/
    /*危险源类别*/
	private java.lang.String dangerType;
	
    /*危险源类别翻译*/
    /*危险源类别翻译*/
	private java.lang.String dangerTypeDesc;
	
    /*危险源编号*/
    /*危险源编号*/
	private java.lang.String dangerCode;
	
    /*危险源编号翻译*/
    /*危险源编号翻译*/
	private java.lang.String dangerCodeDesc;
	
    /*危险性程度*/
    /*危险性程度*/
	private java.lang.String dangerLevel;
	
    /*危险性程度翻译*/
    /*危险性程度翻译*/
	private java.lang.String dangerLevelDesc;
	
    /*开始日期*/
    /*开始日期*/
	private java.sql.Date startDate;
	
    /*结束日期*/
    /*结束日期*/
	private java.sql.Date endDate;
	
    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp changerDatetime;
	
    /*操作标记*/
    /*操作标记*/
	private java.lang.Long operateFlag;
	
    /*关联序号*/
    /*关联序号*/
	private java.lang.Long relateId;
	
    /*专业承包单位代码*/
    /*专业承包单位代码*/
	private java.lang.String subjectCbUnitCode;
	
    /*专业承包单位名称*/
    /*专业承包单位名称*/
	private java.lang.String subjectCbUnitName;
	



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
	 * Return the value associated with the column: SQBH
	 */
	public java.lang.String getSqbh () {
		return sqbh;
	}

	/**
	 * Set the value related to the column: SQBH
	 * @param sqbh the SQBH value
	 */
	public void setSqbh (java.lang.String sqbh) {
		this.sqbh = sqbh;
	}


	/**
	 * Return the value associated with the column: DANGER_TYPE
	 */
	public java.lang.String getDangerType () {
		return dangerType;
	}

	/**
	 * Set the value related to the column: DANGER_TYPE
	 * @param dangerType the DANGER_TYPE value
	 */
	public void setDangerType (java.lang.String dangerType) {
		this.dangerType = dangerType;
	}


	/**
	 * Return the value associated with the column: DANGER_TYPE_DESC
	 */
	public java.lang.String getDangerTypeDesc () {
		return dangerTypeDesc;
	}

	/**
	 * Set the value related to the column: DANGER_TYPE_DESC
	 * @param dangerTypeDesc the DANGER_TYPE_DESC value
	 */
	public void setDangerTypeDesc (java.lang.String dangerTypeDesc) {
		this.dangerTypeDesc = dangerTypeDesc;
	}


	/**
	 * Return the value associated with the column: DANGER_CODE
	 */
	public java.lang.String getDangerCode () {
		return dangerCode;
	}

	/**
	 * Set the value related to the column: DANGER_CODE
	 * @param dangerCode the DANGER_CODE value
	 */
	public void setDangerCode (java.lang.String dangerCode) {
		this.dangerCode = dangerCode;
	}


	/**
	 * Return the value associated with the column: DANGER_CODE_DESC
	 */
	public java.lang.String getDangerCodeDesc () {
		return dangerCodeDesc;
	}

	/**
	 * Set the value related to the column: DANGER_CODE_DESC
	 * @param dangerCodeDesc the DANGER_CODE_DESC value
	 */
	public void setDangerCodeDesc (java.lang.String dangerCodeDesc) {
		this.dangerCodeDesc = dangerCodeDesc;
	}


	/**
	 * Return the value associated with the column: DANGER_LEVEL
	 */
	public java.lang.String getDangerLevel () {
		return dangerLevel;
	}

	/**
	 * Set the value related to the column: DANGER_LEVEL
	 * @param dangerLevel the DANGER_LEVEL value
	 */
	public void setDangerLevel (java.lang.String dangerLevel) {
		this.dangerLevel = dangerLevel;
	}


	/**
	 * Return the value associated with the column: DANGER_LEVEL_DESC
	 */
	public java.lang.String getDangerLevelDesc () {
		return dangerLevelDesc;
	}

	/**
	 * Set the value related to the column: DANGER_LEVEL_DESC
	 * @param dangerLevelDesc the DANGER_LEVEL_DESC value
	 */
	public void setDangerLevelDesc (java.lang.String dangerLevelDesc) {
		this.dangerLevelDesc = dangerLevelDesc;
	}


	/**
	 * Return the value associated with the column: START_DATE
	 */
	public java.sql.Date getStartDate () {
		return startDate;
	}

	/**
	 * Set the value related to the column: START_DATE
	 * @param startDate the START_DATE value
	 */
	public void setStartDate (java.sql.Date startDate) {
		this.startDate = startDate;
	}


	/**
	 * Return the value associated with the column: END_DATE
	 */
	public java.sql.Date getEndDate () {
		return endDate;
	}

	/**
	 * Set the value related to the column: END_DATE
	 * @param endDate the END_DATE value
	 */
	public void setEndDate (java.sql.Date endDate) {
		this.endDate = endDate;
	}


	/**
	 * Return the value associated with the column: CHANGER_DATETIME
	 */
	public java.sql.Timestamp getChangerDatetime () {
		return changerDatetime;
	}

	/**
	 * Set the value related to the column: CHANGER_DATETIME
	 * @param changerDatetime the CHANGER_DATETIME value
	 */
	public void setChangerDatetime (java.sql.Timestamp changerDatetime) {
		this.changerDatetime = changerDatetime;
	}


	/**
	 * Return the value associated with the column: OPERATE_FLAG
	 */
	public java.lang.Long getOperateFlag () {
		return operateFlag;
	}

	/**
	 * Set the value related to the column: OPERATE_FLAG
	 * @param operateFlag the OPERATE_FLAG value
	 */
	public void setOperateFlag (java.lang.Long operateFlag) {
		this.operateFlag = operateFlag;
	}


	/**
	 * Return the value associated with the column: RELATE_ID
	 */
	public java.lang.Long getRelateId () {
		return relateId;
	}

	/**
	 * Set the value related to the column: RELATE_ID
	 * @param relateId the RELATE_ID value
	 */
	public void setRelateId (java.lang.Long relateId) {
		this.relateId = relateId;
	}


	/**
	 * Return the value associated with the column: SUBJECT_CB_UNIT_CODE
	 */
	public java.lang.String getSubjectCbUnitCode () {
		return subjectCbUnitCode;
	}

	/**
	 * Set the value related to the column: SUBJECT_CB_UNIT_CODE
	 * @param subjectCbUnitCode the SUBJECT_CB_UNIT_CODE value
	 */
	public void setSubjectCbUnitCode (java.lang.String subjectCbUnitCode) {
		this.subjectCbUnitCode = subjectCbUnitCode;
	}


	/**
	 * Return the value associated with the column: SUBJECT_CB_UNIT_NAME
	 */
	public java.lang.String getSubjectCbUnitName () {
		return subjectCbUnitName;
	}

	/**
	 * Set the value related to the column: SUBJECT_CB_UNIT_NAME
	 * @param subjectCbUnitName the SUBJECT_CB_UNIT_NAME value
	 */
	public void setSubjectCbUnitName (java.lang.String subjectCbUnitName) {
		this.subjectCbUnitName = subjectCbUnitName;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ShareGreatDanger)) return false;
		else {
			com.justonetech.biz.domain.ShareGreatDanger shareGreatDanger = (com.justonetech.biz.domain.ShareGreatDanger) obj;
			if (null == this.getId() || null == shareGreatDanger.getId()) return false;
			else return (this.getId().equals(shareGreatDanger.getId()));
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
		builder.append(sqbh);
		builder.append(dangerType);
		builder.append(dangerTypeDesc);
		builder.append(dangerCode);
		builder.append(dangerCodeDesc);
		builder.append(dangerLevel);
		builder.append(dangerLevelDesc);
		builder.append(startDate);
		builder.append(endDate);
		builder.append(changerDatetime);
		builder.append(operateFlag);
		builder.append(relateId);
		builder.append(subjectCbUnitCode);
		builder.append(subjectCbUnitName);
		return builder.toString();
	}


}