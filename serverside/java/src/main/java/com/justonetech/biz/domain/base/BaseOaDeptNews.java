package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_DEPT_NEWS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 各科室新闻
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 各科室新闻
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_DEPT_NEWS"
 */

public abstract class BaseOaDeptNews  implements Serializable,Auditable {

	public static String REF = "OaDeptNews";
	public static String PROP_REPORT_DEPT = "reportDept";
	public static String PROP_OFFICE_AUDIT_TIME = "officeAuditTime";
	public static String PROP_DOCUMENT = "document";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_TITLE = "title";
	public static String PROP_VISIT_TIMES = "visitTimes";
	public static String PROP_OFFICE_OPINION = "officeOpinion";
	public static String PROP_STATUS = "status";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_REPORT_DATE = "reportDate";
	public static String PROP_REPORT_PERSON = "reportPerson";
	public static String PROP_OFFICE_AUDIT_USER = "officeAuditUser";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_ID = "id";
	public static String PROP_CONTENT = "content";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseOaDeptNews () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaDeptNews (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*主题*/
    /*主题*/
	private String title;
	
    /*发布人*/
    /*发布人*/
	private String reportPerson;
	
    /*发布科室*/
    /*发布科室*/
	private String reportDept;
	
    /*主要内容(预留)*/
    /*主要内容(预留)*/
	private String content;
	
    /*提交时间*/
    /*提交时间*/
	private java.sql.Date reportDate;
	
    /*阅读次数*/
    /*阅读次数*/
	private Long visitTimes;
	
    /*状态*/
    /*状态*/
	private Integer status;
	
    /*审核意见*/
    /*审核意见*/
	private String officeOpinion;
	
    /*审核时间*/
    /*审核时间*/
	private java.sql.Timestamp officeAuditTime;
	
    /*审核用户名*/
    /*审核用户名*/
	private String officeAuditUser;
	
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
	 * Return the value associated with the column: TITLE
	 */
	public String getTitle () {
		return title;
	}

	/**
	 * Set the value related to the column: TITLE
	 * @param title the TITLE value
	 */
	public void setTitle (String title) {
		this.title = title;
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
	 * Return the value associated with the column: CONTENT
	 */
	public String getContent () {
		return content;
	}

	/**
	 * Set the value related to the column: CONTENT
	 * @param content the CONTENT value
	 */
	public void setContent (String content) {
		this.content = content;
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
	 * Return the value associated with the column: VISIT_TIMES
	 */
	public Long getVisitTimes () {
		return visitTimes;
	}

	/**
	 * Set the value related to the column: VISIT_TIMES
	 * @param visitTimes the VISIT_TIMES value
	 */
	public void setVisitTimes (Long visitTimes) {
		this.visitTimes = visitTimes;
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
	 * Return the value associated with the column: OFFICE_OPINION
	 */
	public String getOfficeOpinion () {
		return officeOpinion;
	}

	/**
	 * Set the value related to the column: OFFICE_OPINION
	 * @param officeOpinion the OFFICE_OPINION value
	 */
	public void setOfficeOpinion (String officeOpinion) {
		this.officeOpinion = officeOpinion;
	}


	/**
	 * Return the value associated with the column: OFFICE_AUDIT_TIME
	 */
	public java.sql.Timestamp getOfficeAuditTime () {
		return officeAuditTime;
	}

	/**
	 * Set the value related to the column: OFFICE_AUDIT_TIME
	 * @param officeAuditTime the OFFICE_AUDIT_TIME value
	 */
	public void setOfficeAuditTime (java.sql.Timestamp officeAuditTime) {
		this.officeAuditTime = officeAuditTime;
	}


	/**
	 * Return the value associated with the column: OFFICE_AUDIT_USER
	 */
	public String getOfficeAuditUser () {
		return officeAuditUser;
	}

	/**
	 * Set the value related to the column: OFFICE_AUDIT_USER
	 * @param officeAuditUser the OFFICE_AUDIT_USER value
	 */
	public void setOfficeAuditUser (String officeAuditUser) {
		this.officeAuditUser = officeAuditUser;
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



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaDeptNews)) return false;
		else {
			com.justonetech.biz.domain.OaDeptNews oaDeptNews = (com.justonetech.biz.domain.OaDeptNews) obj;
			if (null == this.getId() || null == oaDeptNews.getId()) return false;
			else return (this.getId().equals(oaDeptNews.getId()));
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
		builder.append(reportPerson);
		builder.append(reportDept);
		builder.append(content);
		builder.append(reportDate);
		builder.append(visitTimes);
		builder.append(status);
		builder.append(officeOpinion);
		builder.append(officeAuditTime);
		builder.append(officeAuditUser);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}