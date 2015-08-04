package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_WORK_PLAN table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 科室工作周上报
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 科室工作周上报
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_WORK_PLAN"
 */

public abstract class BaseOaWorkPlan  implements Serializable {

	public static String REF = "OaWorkPlan";
	public static String PROP_REPORT_DEPT = "reportDept";
	public static String PROP_BEGIN_DATE = "beginDate";
	public static String PROP_DOCUMENT_ID = "documentId";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_KZ_AUDIT_USER = "kzAuditUser";
	public static String PROP_REPORT_USER = "reportUser";
	public static String PROP_KZ_AUDIT_TIME = "kzAuditTime";
	public static String PROP_FG_AUDIT_TIME = "fgAuditTime";
	public static String PROP_STATUS = "status";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_END_DATE = "endDate";
	public static String PROP_FG_AUDIT_USER = "fgAuditUser";
	public static String PROP_REPORT_PERSON = "reportPerson";
	public static String PROP_FG_OPINION = "fgOpinion";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_KZ_OPINION = "kzOpinion";
	public static String PROP_ID = "id";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseOaWorkPlan () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaWorkPlan (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*上报科室*/
    /*上报科室*/
	private String reportDept;
	
    /*上报人用户名*/
    /*上报人用户名*/
	private String reportUser;
	
    /*上报人姓名*/
    /*上报人姓名*/
	private String reportPerson;
	
    /*上报开始时间*/
    /*上报开始时间*/
	private Integer beginDate;
	
    /*上报结束时间*/
    /*上报结束时间*/
	private Integer endDate;
	
    /*附件ID(预留)*/
    /*附件ID(预留)*/
	private Long documentId;
	
    /*状态*/
    /*状态*/
	private Integer status;
	
    /*科长审核意见*/
    /*科长审核意见*/
	private String kzOpinion;
	
    /*科长审核时间*/
    /*科长审核时间*/
	private java.sql.Timestamp kzAuditTime;
	
    /*科长审核用户名*/
    /*科长审核用户名*/
	private String kzAuditUser;
	
    /*分管领导审核意见*/
    /*分管领导审核意见*/
	private String fgOpinion;
	
    /*分管领导审核时间*/
    /*分管领导审核时间*/
	private java.sql.Timestamp fgAuditTime;
	
    /*分管领导审核用户名*/
    /*分管领导审核用户名*/
	private String fgAuditUser;
	
    /*创建时间*/
    /*创建时间*/
	private java.sql.Timestamp createTime;
	
    /*创建用户名*/
    /*创建用户名*/
	private String createUser;
	
    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updateTime;
	
    /*更新用户名*/
    /*更新用户名*/
	private String updateUser;
	

	// collections
	private java.util.Set<com.justonetech.biz.domain.OaWorkPlanItem> oaWorkPlanItems;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="com.justonetech.core.orm.hibernate.LongIdGenerator"
     *  column="ID"
     */
	public Long getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 * @deprecated
	 */
	public void setId (Long id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: REPORT_DEPT
	 */
	public String getReportDept () {
		return reportDept;
	}

	/**
	 * Set the value related to the column: REPORT_DEPT
	 * @param reportDept the REPORT_DEPT value
	 */
	public void setReportDept (String reportDept) {
		this.reportDept = reportDept;
	}


	/**
	 * Return the value associated with the column: REPORT_USER
	 */
	public String getReportUser () {
		return reportUser;
	}

	/**
	 * Set the value related to the column: REPORT_USER
	 * @param reportUser the REPORT_USER value
	 */
	public void setReportUser (String reportUser) {
		this.reportUser = reportUser;
	}


	/**
	 * Return the value associated with the column: REPORT_PERSON
	 */
	public String getReportPerson () {
		return reportPerson;
	}

	/**
	 * Set the value related to the column: REPORT_PERSON
	 * @param reportPerson the REPORT_PERSON value
	 */
	public void setReportPerson (String reportPerson) {
		this.reportPerson = reportPerson;
	}


	/**
	 * Return the value associated with the column: BEGIN_DATE
	 */
	public Integer getBeginDate () {
		return beginDate;
	}

	/**
	 * Set the value related to the column: BEGIN_DATE
	 * @param beginDate the BEGIN_DATE value
	 */
	public void setBeginDate (Integer beginDate) {
		this.beginDate = beginDate;
	}


	/**
	 * Return the value associated with the column: END_DATE
	 */
	public Integer getEndDate () {
		return endDate;
	}

	/**
	 * Set the value related to the column: END_DATE
	 * @param endDate the END_DATE value
	 */
	public void setEndDate (Integer endDate) {
		this.endDate = endDate;
	}


	/**
	 * Return the value associated with the column: DOCUMENT_ID
	 */
	public Long getDocumentId () {
		return documentId;
	}

	/**
	 * Set the value related to the column: DOCUMENT_ID
	 * @param documentId the DOCUMENT_ID value
	 */
	public void setDocumentId (Long documentId) {
		this.documentId = documentId;
	}


	/**
	 * Return the value associated with the column: STATUS
	 */
	public Integer getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (Integer status) {
		this.status = status;
	}


	/**
	 * Return the value associated with the column: KZ_OPINION
	 */
	public String getKzOpinion () {
		return kzOpinion;
	}

	/**
	 * Set the value related to the column: KZ_OPINION
	 * @param kzOpinion the KZ_OPINION value
	 */
	public void setKzOpinion (String kzOpinion) {
		this.kzOpinion = kzOpinion;
	}


	/**
	 * Return the value associated with the column: KZ_AUDIT_TIME
	 */
	public java.sql.Timestamp getKzAuditTime () {
		return kzAuditTime;
	}

	/**
	 * Set the value related to the column: KZ_AUDIT_TIME
	 * @param kzAuditTime the KZ_AUDIT_TIME value
	 */
	public void setKzAuditTime (java.sql.Timestamp kzAuditTime) {
		this.kzAuditTime = kzAuditTime;
	}


	/**
	 * Return the value associated with the column: KZ_AUDIT_USER
	 */
	public String getKzAuditUser () {
		return kzAuditUser;
	}

	/**
	 * Set the value related to the column: KZ_AUDIT_USER
	 * @param kzAuditUser the KZ_AUDIT_USER value
	 */
	public void setKzAuditUser (String kzAuditUser) {
		this.kzAuditUser = kzAuditUser;
	}


	/**
	 * Return the value associated with the column: FG_OPINION
	 */
	public String getFgOpinion () {
		return fgOpinion;
	}

	/**
	 * Set the value related to the column: FG_OPINION
	 * @param fgOpinion the FG_OPINION value
	 */
	public void setFgOpinion (String fgOpinion) {
		this.fgOpinion = fgOpinion;
	}


	/**
	 * Return the value associated with the column: FG_AUDIT_TIME
	 */
	public java.sql.Timestamp getFgAuditTime () {
		return fgAuditTime;
	}

	/**
	 * Set the value related to the column: FG_AUDIT_TIME
	 * @param fgAuditTime the FG_AUDIT_TIME value
	 */
	public void setFgAuditTime (java.sql.Timestamp fgAuditTime) {
		this.fgAuditTime = fgAuditTime;
	}


	/**
	 * Return the value associated with the column: FG_AUDIT_USER
	 */
	public String getFgAuditUser () {
		return fgAuditUser;
	}

	/**
	 * Set the value related to the column: FG_AUDIT_USER
	 * @param fgAuditUser the FG_AUDIT_USER value
	 */
	public void setFgAuditUser (String fgAuditUser) {
		this.fgAuditUser = fgAuditUser;
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
	public String getCreateUser () {
		return createUser;
	}

	/**
	 * Set the value related to the column: CREATE_USER
	 * @param createUser the CREATE_USER value
	 */
	public void setCreateUser (String createUser) {
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
	public String getUpdateUser () {
		return updateUser;
	}

	/**
	 * Set the value related to the column: UPDATE_USER
	 * @param updateUser the UPDATE_USER value
	 */
	public void setUpdateUser (String updateUser) {
		this.updateUser = updateUser;
	}


	/**
	 * Return the value associated with the column: oaWorkPlanItems
	 */
	public java.util.Set<com.justonetech.biz.domain.OaWorkPlanItem> getOaWorkPlanItems () {
		if(oaWorkPlanItems == null){
			oaWorkPlanItems = new java.util.LinkedHashSet<com.justonetech.biz.domain.OaWorkPlanItem>();
		}
		return oaWorkPlanItems;
	}

	/**
	 * Set the value related to the column: oaWorkPlanItems
	 * @param oaWorkPlanItems the oaWorkPlanItems value
	 */
	public void setOaWorkPlanItems (java.util.Set<com.justonetech.biz.domain.OaWorkPlanItem> oaWorkPlanItems) {
		this.oaWorkPlanItems = oaWorkPlanItems;
	}

	public void addTooaWorkPlanItems (com.justonetech.biz.domain.OaWorkPlanItem oaWorkPlanItem) {
		if (null == getOaWorkPlanItems()) setOaWorkPlanItems(new java.util.LinkedHashSet<com.justonetech.biz.domain.OaWorkPlanItem>());
		getOaWorkPlanItems().add(oaWorkPlanItem);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaWorkPlan)) return false;
		else {
			com.justonetech.biz.domain.OaWorkPlan oaWorkPlan = (com.justonetech.biz.domain.OaWorkPlan) obj;
			if (null == this.getId() || null == oaWorkPlan.getId()) return false;
			else return (this.getId().equals(oaWorkPlan.getId()));
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
		builder.append(reportDept);
		builder.append(reportUser);
		builder.append(reportPerson);
		builder.append(beginDate);
		builder.append(endDate);
		builder.append(documentId);
		builder.append(status);
		builder.append(kzOpinion);
		builder.append(kzAuditTime);
		builder.append(kzAuditUser);
		builder.append(fgOpinion);
		builder.append(fgAuditTime);
		builder.append(fgAuditUser);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}