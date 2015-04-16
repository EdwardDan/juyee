package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_EXPERTISE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 专业知识学习
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 专业知识学习
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_EXPERTISE"
 */

public abstract class BaseOaExpertise  implements Serializable ,Auditable {

	public static String REF = "OaExpertise";
	public static String PROP_DOCUMENT = "document";
	public static String PROP_BEGIN_DATE = "beginDate";
	public static String PROP_STUDY_CONTENT = "studyContent";
	public static String PROP_METHOD = "method";
	public static String PROP_FEE = "fee";
	public static String PROP_STUDY_TARGET = "studyTarget";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_TITLE = "title";
	public static String PROP_STATUS = "status";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_STUDY_DESC = "studyDesc";
	public static String PROP_END_DATE = "endDate";
	public static String PROP_AUDIT_MEMO = "auditMemo";
	public static String PROP_REPORT_DATE = "reportDate";
	public static String PROP_REPORT_PERSON = "reportPerson";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_DURATION = "duration";
	public static String PROP_ID = "id";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseOaExpertise () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaExpertise (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*主题*/
    /*主题*/
	private java.lang.String title;
	
    /*学习开始日期*/
    /*学习开始日期*/
	private java.sql.Date beginDate;
	
    /*学习结束日期*/
    /*学习结束日期*/
	private java.sql.Date endDate;
	
    /*学习时长*/
    /*学习时长*/
	private java.lang.String duration;
	
    /*责任人*/
    /*责任人*/
	private java.lang.String reportPerson;
	
    /*措施与方法*/
    /*措施与方法*/
	private java.lang.String method;
	
    /*费用*/
    /*费用*/
	private java.lang.String fee;
	
    /*学习目标*/
    /*学习目标*/
	private java.lang.String studyTarget;
	
    /*学习内容*/
    /*学习内容*/
	private java.lang.String studyContent;
	
    /*提交时间*/
    /*提交时间*/
	private java.sql.Date reportDate;
	
    /*状态*/
    /*状态*/
	private java.lang.Integer status;
	
    /*审核备注*/
    /*审核备注*/
	private java.lang.String auditMemo;
	
    /*学习情况描述*/
    /*学习情况描述*/
	private java.lang.String studyDesc;
	
    /*创建时间*/
    /*创建时间*/
	private java.sql.Timestamp createTime;
	
    /*创建用户名*/
    /*创建用户名*/
	private java.lang.String createUser;
	
    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updateTime;
	
    /*更新用户名*/
    /*更新用户名*/
	private java.lang.String updateUser;
	

	// many to one
	private com.justonetech.biz.domain.DocDocument document;

	// collections
	private java.util.Set<com.justonetech.biz.domain.OaExpertiseUser> oaExpertiseUsers;



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
	 * Return the value associated with the column: TITLE
	 */
	public java.lang.String getTitle () {
		return title;
	}

	/**
	 * Set the value related to the column: TITLE
	 * @param title the TITLE value
	 */
	public void setTitle (java.lang.String title) {
		this.title = title;
	}


	/**
	 * Return the value associated with the column: BEGIN_DATE
	 */
	public java.sql.Date getBeginDate () {
		return beginDate;
	}

	/**
	 * Set the value related to the column: BEGIN_DATE
	 * @param beginDate the BEGIN_DATE value
	 */
	public void setBeginDate (java.sql.Date beginDate) {
		this.beginDate = beginDate;
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
	 * Return the value associated with the column: DURATION
	 */
	public java.lang.String getDuration () {
		return duration;
	}

	/**
	 * Set the value related to the column: DURATION
	 * @param duration the DURATION value
	 */
	public void setDuration (java.lang.String duration) {
		this.duration = duration;
	}


	/**
	 * Return the value associated with the column: REPORT_PERSON
	 */
	public java.lang.String getReportPerson () {
		return reportPerson;
	}

	/**
	 * Set the value related to the column: REPORT_PERSON
	 * @param reportPerson the REPORT_PERSON value
	 */
	public void setReportPerson (java.lang.String reportPerson) {
		this.reportPerson = reportPerson;
	}


	/**
	 * Return the value associated with the column: METHOD
	 */
	public java.lang.String getMethod () {
		return method;
	}

	/**
	 * Set the value related to the column: METHOD
	 * @param method the METHOD value
	 */
	public void setMethod (java.lang.String method) {
		this.method = method;
	}


	/**
	 * Return the value associated with the column: FEE
	 */
	public java.lang.String getFee () {
		return fee;
	}

	/**
	 * Set the value related to the column: FEE
	 * @param fee the FEE value
	 */
	public void setFee (java.lang.String fee) {
		this.fee = fee;
	}


	/**
	 * Return the value associated with the column: STUDY_TARGET
	 */
	public java.lang.String getStudyTarget () {
		return studyTarget;
	}

	/**
	 * Set the value related to the column: STUDY_TARGET
	 * @param studyTarget the STUDY_TARGET value
	 */
	public void setStudyTarget (java.lang.String studyTarget) {
		this.studyTarget = studyTarget;
	}


	/**
	 * Return the value associated with the column: STUDY_CONTENT
	 */
	public java.lang.String getStudyContent () {
		return studyContent;
	}

	/**
	 * Set the value related to the column: STUDY_CONTENT
	 * @param studyContent the STUDY_CONTENT value
	 */
	public void setStudyContent (java.lang.String studyContent) {
		this.studyContent = studyContent;
	}


	/**
	 * Return the value associated with the column: REPORT_DATE
	 */
	public java.sql.Date getReportDate () {
		return reportDate;
	}

	/**
	 * Set the value related to the column: REPORT_DATE
	 * @param reportDate the REPORT_DATE value
	 */
	public void setReportDate (java.sql.Date reportDate) {
		this.reportDate = reportDate;
	}


	/**
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.Integer getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (java.lang.Integer status) {
		this.status = status;
	}


	/**
	 * Return the value associated with the column: AUDIT_MEMO
	 */
	public java.lang.String getAuditMemo () {
		return auditMemo;
	}

	/**
	 * Set the value related to the column: AUDIT_MEMO
	 * @param auditMemo the AUDIT_MEMO value
	 */
	public void setAuditMemo (java.lang.String auditMemo) {
		this.auditMemo = auditMemo;
	}


	/**
	 * Return the value associated with the column: STUDY_DESC
	 */
	public java.lang.String getStudyDesc () {
		return studyDesc;
	}

	/**
	 * Set the value related to the column: STUDY_DESC
	 * @param studyDesc the STUDY_DESC value
	 */
	public void setStudyDesc (java.lang.String studyDesc) {
		this.studyDesc = studyDesc;
	}


	/**
	 * Return the value associated with the column: CREATE_TIME
	 */
	public java.sql.Timestamp getCreateTime () {
		return createTime;
	}

	/**
	 * Set the value related to the column: CREATE_TIME
	 * @param createTime the CREATE_TIME value
	 */
	public void setCreateTime (java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}


	/**
	 * Return the value associated with the column: CREATE_USER
	 */
	public java.lang.String getCreateUser () {
		return createUser;
	}

	/**
	 * Set the value related to the column: CREATE_USER
	 * @param createUser the CREATE_USER value
	 */
	public void setCreateUser (java.lang.String createUser) {
		this.createUser = createUser;
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


	/**
	 * Return the value associated with the column: UPDATE_USER
	 */
	public java.lang.String getUpdateUser () {
		return updateUser;
	}

	/**
	 * Set the value related to the column: UPDATE_USER
	 * @param updateUser the UPDATE_USER value
	 */
	public void setUpdateUser (java.lang.String updateUser) {
		this.updateUser = updateUser;
	}


	/**
	 * Return the value associated with the column: DOCUMENT_ID
	 */
	public com.justonetech.biz.domain.DocDocument getDocument () {
		return document;
	}

	/**
	 * Set the value related to the column: DOCUMENT_ID
	 * @param document the DOCUMENT_ID value
	 */
	public void setDocument (com.justonetech.biz.domain.DocDocument document) {
		this.document = document;
	}


	/**
	 * Return the value associated with the column: oaExpertiseUsers
	 */
	public java.util.Set<com.justonetech.biz.domain.OaExpertiseUser> getOaExpertiseUsers () {
		if(oaExpertiseUsers == null){
			oaExpertiseUsers = new java.util.LinkedHashSet<com.justonetech.biz.domain.OaExpertiseUser>();
		}
		return oaExpertiseUsers;
	}

	/**
	 * Set the value related to the column: oaExpertiseUsers
	 * @param oaExpertiseUsers the oaExpertiseUsers value
	 */
	public void setOaExpertiseUsers (java.util.Set<com.justonetech.biz.domain.OaExpertiseUser> oaExpertiseUsers) {
		this.oaExpertiseUsers = oaExpertiseUsers;
	}

	public void addTooaExpertiseUsers (com.justonetech.biz.domain.OaExpertiseUser oaExpertiseUser) {
		if (null == getOaExpertiseUsers()) setOaExpertiseUsers(new java.util.LinkedHashSet<com.justonetech.biz.domain.OaExpertiseUser>());
		getOaExpertiseUsers().add(oaExpertiseUser);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaExpertise)) return false;
		else {
			com.justonetech.biz.domain.OaExpertise oaExpertise = (com.justonetech.biz.domain.OaExpertise) obj;
			if (null == this.getId() || null == oaExpertise.getId()) return false;
			else return (this.getId().equals(oaExpertise.getId()));
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
		builder.append(title);
		builder.append(beginDate);
		builder.append(endDate);
		builder.append(duration);
		builder.append(reportPerson);
		builder.append(method);
		builder.append(fee);
		builder.append(studyTarget);
		builder.append(studyContent);
		builder.append(reportDate);
		builder.append(status);
		builder.append(auditMemo);
		builder.append(studyDesc);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}