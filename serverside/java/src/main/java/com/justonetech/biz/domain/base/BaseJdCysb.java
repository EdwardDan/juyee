package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the JD_CYSB table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 创优申报
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 创优申报
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : jd
 * Projectable : false
 *
 * @hibernate.class
 *  table="JD_CYSB"
 */

public abstract class BaseJdCysb  implements Serializable, Auditable {

	public static String REF = "JdCysb";
	public static String PROP_DOCUMENT = "document";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_BUILD_AREA = "buildArea";
	public static String PROP_AUDIT_USER = "auditUser";
	public static String PROP_STATUS = "status";
	public static String PROP_AUDIT_TIME = "auditTime";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_REPORT_TYPE = "reportType";
	public static String PROP_BJBH = "bjbh";
	public static String PROP_STRUCTURE_TYPE = "structureType";
	public static String PROP_PROJECT_ADDRESS = "projectAddress";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_ID = "id";
	public static String PROP_STRUCTURE_LEVEL = "structureLevel";
	public static String PROP_REPORT_TYPE_DESC = "reportTypeDesc";
	public static String PROP_AUDIT_OPINION = "auditOpinion";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseJdCysb () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseJdCysb (Long id) {
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
	
    /*申报类型中文描述*/
    /*申报类型中文描述*/
	private String reportTypeDesc;
	
    /*工程地址*/
    /*工程地址*/
	private String projectAddress;
	
    /*建筑面积*/
    /*建筑面积*/
	private Double buildArea;
	
    /*结构类型*/
    /*结构类型*/
	private String structureType;
	
    /*结构层次*/
    /*结构层次*/
	private String structureLevel;
	
    /*状态*/
    /*状态*/
	private Integer status;
	
    /*质量科审核意见*/
    /*质量科审核意见*/
	private String auditOpinion;
	
    /*质量科审核时间*/
    /*质量科审核时间*/
	private java.sql.Timestamp auditTime;
	
    /*质量科审核用户名*/
    /*质量科审核用户名*/
	private String auditUser;
	
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


	/**
	 * Return the value associated with the column: PROJECT_ADDRESS
	 */
	public String getProjectAddress () {
		return projectAddress;
	}

	/**
	 * Set the value related to the column: PROJECT_ADDRESS
	 * @param projectAddress the PROJECT_ADDRESS value
	 */
	public void setProjectAddress (String projectAddress) {
		this.projectAddress = projectAddress;
	}


	/**
	 * Return the value associated with the column: BUILD_AREA
	 */
	public Double getBuildArea () {
		return buildArea;
	}

	/**
	 * Set the value related to the column: BUILD_AREA
	 * @param buildArea the BUILD_AREA value
	 */
	public void setBuildArea (Double buildArea) {
		this.buildArea = buildArea;
	}


	/**
	 * Return the value associated with the column: STRUCTURE_TYPE
	 */
	public String getStructureType () {
		return structureType;
	}

	/**
	 * Set the value related to the column: STRUCTURE_TYPE
	 * @param structureType the STRUCTURE_TYPE value
	 */
	public void setStructureType (String structureType) {
		this.structureType = structureType;
	}


	/**
	 * Return the value associated with the column: STRUCTURE_LEVEL
	 */
	public String getStructureLevel () {
		return structureLevel;
	}

	/**
	 * Set the value related to the column: STRUCTURE_LEVEL
	 * @param structureLevel the STRUCTURE_LEVEL value
	 */
	public void setStructureLevel (String structureLevel) {
		this.structureLevel = structureLevel;
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
	 * Return the value associated with the column: AUDIT_OPINION
	 */
	public String getAuditOpinion () {
		return auditOpinion;
	}

	/**
	 * Set the value related to the column: AUDIT_OPINION
	 * @param auditOpinion the AUDIT_OPINION value
	 */
	public void setAuditOpinion (String auditOpinion) {
		this.auditOpinion = auditOpinion;
	}


	/**
	 * Return the value associated with the column: AUDIT_TIME
	 */
	public java.sql.Timestamp getAuditTime () {
		return auditTime;
	}

	/**
	 * Set the value related to the column: AUDIT_TIME
	 * @param auditTime the AUDIT_TIME value
	 */
	public void setAuditTime (java.sql.Timestamp auditTime) {
		this.auditTime = auditTime;
	}


	/**
	 * Return the value associated with the column: AUDIT_USER
	 */
	public String getAuditUser () {
		return auditUser;
	}

	/**
	 * Set the value related to the column: AUDIT_USER
	 * @param auditUser the AUDIT_USER value
	 */
	public void setAuditUser (String auditUser) {
		this.auditUser = auditUser;
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
		if (!(obj instanceof com.justonetech.biz.domain.JdCysb)) return false;
		else {
			com.justonetech.biz.domain.JdCysb jdCysb = (com.justonetech.biz.domain.JdCysb) obj;
			if (null == this.getId() || null == jdCysb.getId()) return false;
			else return (this.getId().equals(jdCysb.getId()));
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
		builder.append(projectAddress);
		builder.append(buildArea);
		builder.append(structureType);
		builder.append(structureLevel);
		builder.append(status);
		builder.append(auditOpinion);
		builder.append(auditTime);
		builder.append(auditUser);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}