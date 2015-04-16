package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_MONTHPLAN table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 月度总结和计划
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 月度总结和计划
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_MONTHPLAN"
 */

public abstract class BaseOaMonthplan  implements Serializable, Auditable {

	public static String REF = "OaMonthplan";
	public static String PROP_REPORT_DEPT = "reportDept";
	public static String PROP_PERIOD = "period";
	public static String PROP_DOCUMENT = "document";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_FG_AUDIT_TIME = "fgAuditTime";
	public static String PROP_YEAR = "year";
	public static String PROP_STATUS = "status";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_FG_AUDIT_USER = "fgAuditUser";
	public static String PROP_REPORT_DATE = "reportDate";
	public static String PROP_REPORT_PERSON = "reportPerson";
	public static String PROP_FG_OPINION = "fgOpinion";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_ID = "id";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseOaMonthplan () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaMonthplan (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*提交部门*/
    /*提交部门*/
	private String reportDept;
	
    /*责任人*/
    /*责任人*/
	private String reportPerson;
	
    /*报告年份*/
    /*报告年份*/
	private Integer year;
	
    /*报告月份*/
    /*报告月份*/
	private Integer period;
	
    /*提交时间*/
    /*提交时间*/
	private java.sql.Date reportDate;
	
    /*状态*/
    /*状态*/
	private Integer status;
	
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
	

	// many to one
	private com.justonetech.biz.domain.DocDocument document;

	// collections
	private java.util.Set<com.justonetech.biz.domain.OaMonthplanItem> oaMonthplanItems;



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
	 * Return the value associated with the column: YEAR
	 */
	public Integer getYear () {
		return year;
	}

	/**
	 * Set the value related to the column: YEAR
	 * @param year the YEAR value
	 */
	public void setYear (Integer year) {
		this.year = year;
	}


	/**
	 * Return the value associated with the column: PERIOD
	 */
	public Integer getPeriod () {
		return period;
	}

	/**
	 * Set the value related to the column: PERIOD
	 * @param period the PERIOD value
	 */
	public void setPeriod (Integer period) {
		this.period = period;
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
	 * Return the value associated with the column: oaMonthplanItems
	 */
	public java.util.Set<com.justonetech.biz.domain.OaMonthplanItem> getOaMonthplanItems () {
		if(oaMonthplanItems == null){
			oaMonthplanItems = new java.util.LinkedHashSet<com.justonetech.biz.domain.OaMonthplanItem>();
		}
		return oaMonthplanItems;
	}

	/**
	 * Set the value related to the column: oaMonthplanItems
	 * @param oaMonthplanItems the oaMonthplanItems value
	 */
	public void setOaMonthplanItems (java.util.Set<com.justonetech.biz.domain.OaMonthplanItem> oaMonthplanItems) {
		this.oaMonthplanItems = oaMonthplanItems;
	}

	public void addTooaMonthplanItems (com.justonetech.biz.domain.OaMonthplanItem oaMonthplanItem) {
		if (null == getOaMonthplanItems()) setOaMonthplanItems(new java.util.LinkedHashSet<com.justonetech.biz.domain.OaMonthplanItem>());
		getOaMonthplanItems().add(oaMonthplanItem);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaMonthplan)) return false;
		else {
			com.justonetech.biz.domain.OaMonthplan oaMonthplan = (com.justonetech.biz.domain.OaMonthplan) obj;
			if (null == this.getId() || null == oaMonthplan.getId()) return false;
			else return (this.getId().equals(oaMonthplan.getId()));
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
		builder.append(reportPerson);
		builder.append(year);
		builder.append(period);
		builder.append(reportDate);
		builder.append(status);
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