package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the JD_JL_REPORT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 监理报告
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 监理报告
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : jd
 * Projectable : false
 *
 * @hibernate.class
 *  table="JD_JL_REPORT"
 */

public abstract class BaseJdJlReport  implements Serializable, Auditable {

	public static String REF = "JdJlReport";
	public static String PROP_DOCUMENT = "document";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_REPORT_TYPE = "reportType";
	public static String PROP_REPORT_DATE = "reportDate";
	public static String PROP_BJBH = "bjbh";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_REPORT_TYPE_DESC = "reportTypeDesc";
	public static String PROP_UPDATE_USER = "updateUser";
	public static String PROP_JL_DEPT_NAME = "jlDeptName";


	// constructors
	public BaseJdJlReport () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseJdJlReport (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*报建编号*/
    /*报建编号*/
	private String bjbh;
	
    /*报告类型中文描述*/
    /*报告类型中文描述*/
	private String reportTypeDesc;

    /*监理单位名称*/
    /*监理单位名称*/
	private String jlDeptName;

    /*提交日期*/
    /*提交日期*/
	private java.sql.Date reportDate;
	
    /*备注*/
    /*备注*/
	private String description;
	
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
	private com.justonetech.system.domain.SysCodeDetail reportType;
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
	 * Return the value associated with the column: BJBH
	 */
	public String getBjbh () {
		return bjbh;
	}

	/**
	 * Set the value related to the column: BJBH
	 * @param bjbh the BJBH value
	 */
	public void setBjbh (String bjbh) {
		this.bjbh = bjbh;
	}


	/**
	 * Return the value associated with the column: REPORT_TYPE_DESC
	 */
	public String getReportTypeDesc () {
		return reportTypeDesc;
	}

	/**
	 * Set the value related to the column: REPORT_TYPE_DESC
	 * @param reportTypeDesc the REPORT_TYPE_DESC value
	 */
	public void setReportTypeDesc (String reportTypeDesc) {
		this.reportTypeDesc = reportTypeDesc;
	}

    public String getJlDeptName() {
        return jlDeptName;
    }

    public void setJlDeptName(String jlDeptName) {
        this.jlDeptName = jlDeptName;
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
	 * Return the value associated with the column: DESCRIPTION
	 */
	public String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: DESCRIPTION
	 * @param description the DESCRIPTION value
	 */
	public void setDescription (String description) {
		this.description = description;
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
	 * Return the value associated with the column: REPORT_TYPE_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getReportType () {
		return reportType;
	}

	/**
	 * Set the value related to the column: REPORT_TYPE_ID
	 * @param reportType the REPORT_TYPE_ID value
	 */
	public void setReportType (com.justonetech.system.domain.SysCodeDetail reportType) {
		this.reportType = reportType;
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
		if (!(obj instanceof com.justonetech.biz.domain.JdJlReport)) return false;
		else {
			com.justonetech.biz.domain.JdJlReport jdJlReport = (com.justonetech.biz.domain.JdJlReport) obj;
			if (null == this.getId() || null == jdJlReport.getId()) return false;
			else return (this.getId().equals(jdJlReport.getId()));
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
		builder.append(bjbh);
		builder.append(reportTypeDesc);
		builder.append(jlDeptName);
		builder.append(reportDate);
		builder.append(description);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}