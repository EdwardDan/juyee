package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the JD_INFORM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 质量监督告知书
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 质量监督告知书
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : jd
 * Projectable : false
 *
 * @hibernate.class
 *  table="JD_INFORM"
 */

public abstract class BaseJdInform  implements Serializable, Auditable {

	public static String REF = "JdInform";
	public static String PROP_DOCUMENT = "document";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_SGXK_DATE = "sgxkDate";
	public static String PROP_FAX = "fax";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_LXR = "lxr";
	public static String PROP_ZIP_CODE = "zipCode";
	public static String PROP_FG_AUDIT_TIME = "fgAuditTime";
	public static String PROP_AUDIT_USER = "auditUser";
	public static String PROP_STATUS = "status";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_AUDIT_TIME = "auditTime";
	public static String PROP_FG_AUDIT_USER = "fgAuditUser";
	public static String PROP_BJBH = "bjbh";
	public static String PROP_FG_OPINION = "fgOpinion";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_ADDRESS = "address";
	public static String PROP_ID = "id";
	public static String PROP_AUDIT_OPINION = "auditOpinion";
	public static String PROP_TEL = "tel";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseJdInform () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseJdInform (Long id) {
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
	
    /*监督联系人*/
    /*监督联系人*/
	private String lxr;
	
    /*联系电话*/
    /*联系电话*/
	private String tel;
	
    /*邮政编码*/
    /*邮政编码*/
	private String zipCode;
	
    /*联系地址*/
    /*联系地址*/
	private String address;
	
    /*传真号码*/
    /*传真号码*/
	private String fax;
	
    /*备注*/
    /*备注*/
	private String description;
	
    /*状态*/
    /*状态*/
	private Integer status;
	
    /*科长审核意见*/
    /*科长审核意见*/
	private String auditOpinion;
	
    /*科长审核时间*/
    /*科长审核时间*/
	private java.sql.Timestamp auditTime;
	
    /*科长审核用户名*/
    /*科长审核用户名*/
	private String auditUser;
	
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
	
    /*施工许可发放日期*/
    /*施工许可发放日期*/
	private java.sql.Date sgxkDate;
	

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
	 * Return the value associated with the column: LXR
	 */
	public String getLxr () {
		return lxr;
	}

	/**
	 * Set the value related to the column: LXR
	 * @param lxr the LXR value
	 */
	public void setLxr (String lxr) {
		this.lxr = lxr;
	}


	/**
	 * Return the value associated with the column: TEL
	 */
	public String getTel () {
		return tel;
	}

	/**
	 * Set the value related to the column: TEL
	 * @param tel the TEL value
	 */
	public void setTel (String tel) {
		this.tel = tel;
	}


	/**
	 * Return the value associated with the column: ZIP_CODE
	 */
	public String getZipCode () {
		return zipCode;
	}

	/**
	 * Set the value related to the column: ZIP_CODE
	 * @param zipCode the ZIP_CODE value
	 */
	public void setZipCode (String zipCode) {
		this.zipCode = zipCode;
	}


	/**
	 * Return the value associated with the column: ADDRESS
	 */
	public String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: ADDRESS
	 * @param address the ADDRESS value
	 */
	public void setAddress (String address) {
		this.address = address;
	}


	/**
	 * Return the value associated with the column: FAX
	 */
	public String getFax () {
		return fax;
	}

	/**
	 * Set the value related to the column: FAX
	 * @param fax the FAX value
	 */
	public void setFax (String fax) {
		this.fax = fax;
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
	 * Return the value associated with the column: SGXK_DATE
	 */
	public java.sql.Date getSgxkDate () {
		return sgxkDate;
	}

	/**
	 * Set the value related to the column: SGXK_DATE
	 * @param sgxkDate the SGXK_DATE value
	 */
	public void setSgxkDate (java.sql.Date sgxkDate) {
		this.sgxkDate = sgxkDate;
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
		if (!(obj instanceof com.justonetech.biz.domain.JdInform)) return false;
		else {
			com.justonetech.biz.domain.JdInform jdInform = (com.justonetech.biz.domain.JdInform) obj;
			if (null == this.getId() || null == jdInform.getId()) return false;
			else return (this.getId().equals(jdInform.getId()));
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
		builder.append(lxr);
		builder.append(tel);
		builder.append(zipCode);
		builder.append(address);
		builder.append(fax);
		builder.append(description);
		builder.append(status);
		builder.append(auditOpinion);
		builder.append(auditTime);
		builder.append(auditUser);
		builder.append(fgOpinion);
		builder.append(fgAuditTime);
		builder.append(fgAuditUser);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		builder.append(sgxkDate);
		return builder.toString();
	}


}