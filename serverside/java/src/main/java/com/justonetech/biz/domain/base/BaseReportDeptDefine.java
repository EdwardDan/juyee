package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the REPORT_DEPT_DEFINE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 综合报表单位权限定义
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 综合报表单位权限定义
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : report
 * Projectable : false
 *
 * @hibernate.class
 *  table="REPORT_DEPT_DEFINE"
 */

public abstract class BaseReportDeptDefine  implements Serializable,Auditable {

	public static String REF = "ReportDeptDefine";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_DEPT_NAME = "deptName";
	public static String PROP_SYS_PRIVILEGE = "sysPrivilege";
	public static String PROP_ORDER_NO = "orderNo";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_CODE = "code";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseReportDeptDefine () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseReportDeptDefine (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*部门编码*/
    /*部门编码*/
	private String code;
	
    /*部门名称*/
    /*部门名称*/
	private String deptName;
	
    /*部门序号*/
    /*部门序号*/
	private Long orderNo;
	
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
	private com.justonetech.system.domain.SysPrivilege sysPrivilege;

	// collections
	private java.util.Set<com.justonetech.biz.domain.ReportStructure> reportStructures;
	private java.util.Set<com.justonetech.biz.domain.ReportMonth> reportMonths;



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
	 * Return the value associated with the column: CODE
	 */
	public String getCode () {
		return code;
	}

	/**
	 * Set the value related to the column: CODE
	 * @param code the CODE value
	 */
	public void setCode (String code) {
		this.code = code;
	}


	/**
	 * Return the value associated with the column: DEPT_NAME
	 */
	public String getDeptName () {
		return deptName;
	}

	/**
	 * Set the value related to the column: DEPT_NAME
	 * @param deptName the DEPT_NAME value
	 */
	public void setDeptName (String deptName) {
		this.deptName = deptName;
	}


	/**
	 * Return the value associated with the column: ORDER_NO
	 */
	public Long getOrderNo () {
		return orderNo;
	}

	/**
	 * Set the value related to the column: ORDER_NO
	 * @param orderNo the ORDER_NO value
	 */
	public void setOrderNo (Long orderNo) {
		this.orderNo = orderNo;
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
	 * Return the value associated with the column: SYS_PRIVILEGE_ID
	 */
	public com.justonetech.system.domain.SysPrivilege getSysPrivilege () {
		return sysPrivilege;
	}

	/**
	 * Set the value related to the column: SYS_PRIVILEGE_ID
	 * @param sysPrivilege the SYS_PRIVILEGE_ID value
	 */
	public void setSysPrivilege (com.justonetech.system.domain.SysPrivilege sysPrivilege) {
		this.sysPrivilege = sysPrivilege;
	}


	/**
	 * Return the value associated with the column: reportStructures
	 */
	public java.util.Set<com.justonetech.biz.domain.ReportStructure> getReportStructures () {
		if(reportStructures == null){
			reportStructures = new java.util.LinkedHashSet<com.justonetech.biz.domain.ReportStructure>();
		}
		return reportStructures;
	}

	/**
	 * Set the value related to the column: reportStructures
	 * @param reportStructures the reportStructures value
	 */
	public void setReportStructures (java.util.Set<com.justonetech.biz.domain.ReportStructure> reportStructures) {
		this.reportStructures = reportStructures;
	}

	public void addToreportStructures (com.justonetech.biz.domain.ReportStructure reportStructure) {
		if (null == getReportStructures()) setReportStructures(new java.util.LinkedHashSet<com.justonetech.biz.domain.ReportStructure>());
		getReportStructures().add(reportStructure);
	}


	/**
	 * Return the value associated with the column: reportMonths
	 */
	public java.util.Set<com.justonetech.biz.domain.ReportMonth> getReportMonths () {
		if(reportMonths == null){
			reportMonths = new java.util.LinkedHashSet<com.justonetech.biz.domain.ReportMonth>();
		}
		return reportMonths;
	}

	/**
	 * Set the value related to the column: reportMonths
	 * @param reportMonths the reportMonths value
	 */
	public void setReportMonths (java.util.Set<com.justonetech.biz.domain.ReportMonth> reportMonths) {
		this.reportMonths = reportMonths;
	}

	public void addToreportMonths (com.justonetech.biz.domain.ReportMonth reportMonth) {
		if (null == getReportMonths()) setReportMonths(new java.util.LinkedHashSet<com.justonetech.biz.domain.ReportMonth>());
		getReportMonths().add(reportMonth);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ReportDeptDefine)) return false;
		else {
			com.justonetech.biz.domain.ReportDeptDefine reportDeptDefine = (com.justonetech.biz.domain.ReportDeptDefine) obj;
			if (null == this.getId() || null == reportDeptDefine.getId()) return false;
			else return (this.getId().equals(reportDeptDefine.getId()));
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
		builder.append(code);
		builder.append(deptName);
		builder.append(orderNo);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}