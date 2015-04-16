package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_MATERIAL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 物资设备采购管理
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 物资设备采购管理
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_MATERIAL"
 */

public abstract class BaseOaMaterial  implements Serializable, Auditable {

	public static String REF = "OaMaterial";
	public static String PROP_REPORT_DEPT = "reportDept";
	public static String PROP_OFFICE_AUDIT_TIME = "officeAuditTime";
	public static String PROP_DOCUMENT_ID = "documentId";
	public static String PROP_LEADER_OPINION = "leaderOpinion";
	public static String PROP_REQUIRE_DESC = "requireDesc";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_CODE = "code";
	public static String PROP_OFFICE_OPINION = "officeOpinion";
	public static String PROP_LEADER_AUDIT_USER = "leaderAuditUser";
	public static String PROP_STATUS = "status";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_REPORT_DATE = "reportDate";
	public static String PROP_REPORT_PERSON = "reportPerson";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_OFFICE_AUDIT_USER = "officeAuditUser";
	public static String PROP_ID = "id";
	public static String PROP_LEADER_AUDIT_TIME = "leaderAuditTime";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseOaMaterial () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaMaterial (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*申请编号*/
    /*申请编号*/
	private java.lang.String code;
	
    /*申请日期*/
    /*申请日期*/
	private java.sql.Date reportDate;
	
    /*申请人*/
    /*申请人*/
	private java.lang.String reportPerson;
	
    /*申请部门*/
    /*申请部门*/
	private java.lang.String reportDept;
	
    /*备注要求*/
    /*备注要求*/
	private java.lang.String requireDesc;
	
    /*附件ID*/
    /*附件ID*/
	private java.lang.Long documentId;
	
    /*状态*/
    /*状态*/
	private java.lang.Integer status;
	
    /*办公室审核意见*/
    /*办公室审核意见*/
	private java.lang.String officeOpinion;
	
    /*办公室审核时间*/
    /*办公室审核时间*/
	private java.sql.Timestamp officeAuditTime;
	
    /*办公室审核用户名*/
    /*办公室审核用户名*/
	private java.lang.String officeAuditUser;
	
    /*主管领导审核意见*/
    /*主管领导审核意见*/
	private java.lang.String leaderOpinion;
	
    /*主管领导审核时间*/
    /*主管领导审核时间*/
	private java.sql.Timestamp leaderAuditTime;
	
    /*主管领导审核用户名*/
    /*主管领导审核用户名*/
	private java.lang.String leaderAuditUser;
	
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
	

	// collections
	private java.util.Set<com.justonetech.biz.domain.OaMaterialItem> oaMaterialItems;



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
	 * Return the value associated with the column: CODE
	 */
	public java.lang.String getCode () {
		return code;
	}

	/**
	 * Set the value related to the column: CODE
	 * @param code the CODE value
	 */
	public void setCode (java.lang.String code) {
		this.code = code;
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
	 * Return the value associated with the column: REPORT_DEPT
	 */
	public java.lang.String getReportDept () {
		return reportDept;
	}

	/**
	 * Set the value related to the column: REPORT_DEPT
	 * @param reportDept the REPORT_DEPT value
	 */
	public void setReportDept (java.lang.String reportDept) {
		this.reportDept = reportDept;
	}


	/**
	 * Return the value associated with the column: REQUIRE_DESC
	 */
	public java.lang.String getRequireDesc () {
		return requireDesc;
	}

	/**
	 * Set the value related to the column: REQUIRE_DESC
	 * @param requireDesc the REQUIRE_DESC value
	 */
	public void setRequireDesc (java.lang.String requireDesc) {
		this.requireDesc = requireDesc;
	}


	/**
	 * Return the value associated with the column: DOCUMENT_ID
	 */
	public java.lang.Long getDocumentId () {
		return documentId;
	}

	/**
	 * Set the value related to the column: DOCUMENT_ID
	 * @param documentId the DOCUMENT_ID value
	 */
	public void setDocumentId (java.lang.Long documentId) {
		this.documentId = documentId;
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
	 * Return the value associated with the column: OFFICE_OPINION
	 */
	public java.lang.String getOfficeOpinion () {
		return officeOpinion;
	}

	/**
	 * Set the value related to the column: OFFICE_OPINION
	 * @param officeOpinion the OFFICE_OPINION value
	 */
	public void setOfficeOpinion (java.lang.String officeOpinion) {
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
	public java.lang.String getOfficeAuditUser () {
		return officeAuditUser;
	}

	/**
	 * Set the value related to the column: OFFICE_AUDIT_USER
	 * @param officeAuditUser the OFFICE_AUDIT_USER value
	 */
	public void setOfficeAuditUser (java.lang.String officeAuditUser) {
		this.officeAuditUser = officeAuditUser;
	}


	/**
	 * Return the value associated with the column: LEADER_OPINION
	 */
	public java.lang.String getLeaderOpinion () {
		return leaderOpinion;
	}

	/**
	 * Set the value related to the column: LEADER_OPINION
	 * @param leaderOpinion the LEADER_OPINION value
	 */
	public void setLeaderOpinion (java.lang.String leaderOpinion) {
		this.leaderOpinion = leaderOpinion;
	}


	/**
	 * Return the value associated with the column: LEADER_AUDIT_TIME
	 */
	public java.sql.Timestamp getLeaderAuditTime () {
		return leaderAuditTime;
	}

	/**
	 * Set the value related to the column: LEADER_AUDIT_TIME
	 * @param leaderAuditTime the LEADER_AUDIT_TIME value
	 */
	public void setLeaderAuditTime (java.sql.Timestamp leaderAuditTime) {
		this.leaderAuditTime = leaderAuditTime;
	}


	/**
	 * Return the value associated with the column: LEADER_AUDIT_USER
	 */
	public java.lang.String getLeaderAuditUser () {
		return leaderAuditUser;
	}

	/**
	 * Set the value related to the column: LEADER_AUDIT_USER
	 * @param leaderAuditUser the LEADER_AUDIT_USER value
	 */
	public void setLeaderAuditUser (java.lang.String leaderAuditUser) {
		this.leaderAuditUser = leaderAuditUser;
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
	 * Return the value associated with the column: oaMaterialItems
	 */
	public java.util.Set<com.justonetech.biz.domain.OaMaterialItem> getOaMaterialItems () {
		if(oaMaterialItems == null){
			oaMaterialItems = new java.util.LinkedHashSet<com.justonetech.biz.domain.OaMaterialItem>();
		}
		return oaMaterialItems;
	}

	/**
	 * Set the value related to the column: oaMaterialItems
	 * @param oaMaterialItems the oaMaterialItems value
	 */
	public void setOaMaterialItems (java.util.Set<com.justonetech.biz.domain.OaMaterialItem> oaMaterialItems) {
		this.oaMaterialItems = oaMaterialItems;
	}

	public void addTooaMaterialItems (com.justonetech.biz.domain.OaMaterialItem oaMaterialItem) {
		if (null == getOaMaterialItems()) setOaMaterialItems(new java.util.LinkedHashSet<com.justonetech.biz.domain.OaMaterialItem>());
		getOaMaterialItems().add(oaMaterialItem);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaMaterial)) return false;
		else {
			com.justonetech.biz.domain.OaMaterial oaMaterial = (com.justonetech.biz.domain.OaMaterial) obj;
			if (null == this.getId() || null == oaMaterial.getId()) return false;
			else return (this.getId().equals(oaMaterial.getId()));
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
		builder.append(reportDate);
		builder.append(reportPerson);
		builder.append(reportDept);
		builder.append(requireDesc);
		builder.append(documentId);
		builder.append(status);
		builder.append(officeOpinion);
		builder.append(officeAuditTime);
		builder.append(officeAuditUser);
		builder.append(leaderOpinion);
		builder.append(leaderAuditTime);
		builder.append(leaderAuditUser);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}