package com.justonetech.biz.domain.base;


import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the JD_PERSON_SUBJECT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 监督人员专业管理
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 监督人员专业管理
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : report
 * Projectable : false
 *
 * @hibernate.class
 *  table="JD_PERSON_SUBJECT"
 */

public abstract class BaseJdPersonSubject  implements Serializable,Auditable {

	public static String REF = "JdPersonSubject";
	public static String PROP_CERTIFICATE_CODE = "certificateCode";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_SUBJECT = "subject";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_MEMO = "memo";
	public static String PROP_ID = "id";
	public static String PROP_PERSON = "person";


	// constructors
	public BaseJdPersonSubject () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseJdPersonSubject (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*监督证书编号*/
    /*监督证书编号*/
	private java.lang.String certificateCode;
	
    /*备注*/
    /*备注*/
	private java.lang.String memo;
	
    /*创建时间*/
    /*创建时间*/
	private java.sql.Timestamp createTime;
	
    /*创建人*/
    /*创建人*/
	private java.lang.String createUser;
	

	// many to one
	private com.justonetech.system.domain.SysPerson person;
	private com.justonetech.system.domain.SysCodeDetail subject;



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
	 * Return the value associated with the column: CERTIFICATE_CODE
	 */
	public java.lang.String getCertificateCode () {
		return certificateCode;
	}

	/**
	 * Set the value related to the column: CERTIFICATE_CODE
	 * @param certificateCode the CERTIFICATE_CODE value
	 */
	public void setCertificateCode (java.lang.String certificateCode) {
		this.certificateCode = certificateCode;
	}


	/**
	 * Return the value associated with the column: MEMO
	 */
	public java.lang.String getMemo () {
		return memo;
	}

	/**
	 * Set the value related to the column: MEMO
	 * @param memo the MEMO value
	 */
	public void setMemo (java.lang.String memo) {
		this.memo = memo;
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
	 * Return the value associated with the column: PERSON_ID
	 */
	public com.justonetech.system.domain.SysPerson getPerson () {
		return person;
	}

	/**
	 * Set the value related to the column: PERSON_ID
	 * @param person the PERSON_ID value
	 */
	public void setPerson (com.justonetech.system.domain.SysPerson person) {
		this.person = person;
	}


	/**
	 * Return the value associated with the column: SUBJECT_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getSubject () {
		return subject;
	}

	/**
	 * Set the value related to the column: SUBJECT_ID
	 * @param subject the SUBJECT_ID value
	 */
	public void setSubject (com.justonetech.system.domain.SysCodeDetail subject) {
		this.subject = subject;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.JdPersonSubject)) return false;
		else {
			com.justonetech.biz.domain.JdPersonSubject jdPersonSubject = (com.justonetech.biz.domain.JdPersonSubject) obj;
			if (null == this.getId() || null == jdPersonSubject.getId()) return false;
			else return (this.getId().equals(jdPersonSubject.getId()));
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
		builder.append(certificateCode);
		builder.append(memo);
		builder.append(createTime);
		builder.append(createUser);
		return builder.toString();
	}


}