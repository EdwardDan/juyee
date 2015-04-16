package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the REPORT_MONTH table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 综合报表月份上报
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 综合报表月份上报
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : report
 * Projectable : false
 *
 * @hibernate.class
 *  table="REPORT_MONTH"
 */

public abstract class BaseReportMonth  implements Serializable,Auditable {

	public static String REF = "ReportMonth";
	public static String PROP_YEAR = "year";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_REPORT_DEPT_DEFINE = "reportDeptDefine";
	public static String PROP_REPORT_DATE = "reportDate";
	public static String PROP_REPORT_PERSON = "reportPerson";
	public static String PROP_IS_VALID = "isValid";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_VERSION = "version";
	public static String PROP_MONTH = "month";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseReportMonth () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseReportMonth (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*报表年份*/
    /*报表年份*/
	private Integer year;
	
    /*报表月份*/
    /*报表月份*/
	private Integer month;
	
    /*填报人*/
    /*填报人*/
	private String reportPerson;
	
    /*提交时间*/
    /*提交时间*/
	private java.sql.Date reportDate;
	
    /*是否提交*/
    /*是否提交*/
	private Boolean isValid;
	
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
	private com.justonetech.biz.domain.ReportDeptDefine reportDeptDefine;
	private com.justonetech.biz.domain.ReportStructureVer version;

	// collections
	private java.util.Set<com.justonetech.biz.domain.ReportMonthDetail> reportMonthDetails;



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
	 * Return the value associated with the column: MONTH
	 */
	public Integer getMonth () {
		return month;
	}

	/**
	 * Set the value related to the column: MONTH
	 * @param month the MONTH value
	 */
	public void setMonth (Integer month) {
		this.month = month;
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
	 * Return the value associated with the column: IS_VALID
	 */
	public Boolean getIsValid () {
		return isValid;
	}

	/**
	 * Set the value related to the column: IS_VALID
	 * @param isValid the IS_VALID value
	 */
	public void setIsValid (Boolean isValid) {
		this.isValid = isValid;
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
	 * Return the value associated with the column: REPORT_DEPT_DEFINE_ID
	 */
	public com.justonetech.biz.domain.ReportDeptDefine getReportDeptDefine () {
		return reportDeptDefine;
	}

	/**
	 * Set the value related to the column: REPORT_DEPT_DEFINE_ID
	 * @param reportDeptDefine the REPORT_DEPT_DEFINE_ID value
	 */
	public void setReportDeptDefine (com.justonetech.biz.domain.ReportDeptDefine reportDeptDefine) {
		this.reportDeptDefine = reportDeptDefine;
	}


	/**
	 * Return the value associated with the column: VERSION_ID
	 */
	public com.justonetech.biz.domain.ReportStructureVer getVersion () {
		return version;
	}

	/**
	 * Set the value related to the column: VERSION_ID
	 * @param version the VERSION_ID value
	 */
	public void setVersion (com.justonetech.biz.domain.ReportStructureVer version) {
		this.version = version;
	}


	/**
	 * Return the value associated with the column: reportMonthDetails
	 */
	public java.util.Set<com.justonetech.biz.domain.ReportMonthDetail> getReportMonthDetails () {
		return reportMonthDetails;
	}

	/**
	 * Set the value related to the column: reportMonthDetails
	 * @param reportMonthDetails the reportMonthDetails value
	 */
	public void setReportMonthDetails (java.util.Set<com.justonetech.biz.domain.ReportMonthDetail> reportMonthDetails) {
		this.reportMonthDetails = reportMonthDetails;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ReportMonth)) return false;
		else {
			com.justonetech.biz.domain.ReportMonth reportMonth = (com.justonetech.biz.domain.ReportMonth) obj;
			if (null == this.getId() || null == reportMonth.getId()) return false;
			else return (this.getId().equals(reportMonth.getId()));
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
		builder.append(year);
		builder.append(month);
		builder.append(reportPerson);
		builder.append(reportDate);
		builder.append(isValid);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}