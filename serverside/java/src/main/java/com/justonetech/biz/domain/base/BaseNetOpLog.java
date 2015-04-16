package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the NET_OP_LOG table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目审批操作日志
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 项目审批操作日志
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : net
 * Projectable : false
 *
 * @hibernate.class
 *  table="NET_OP_LOG"
 */

public abstract class BaseNetOpLog  implements Serializable,Auditable {

	public static String REF = "NetOpLog";
	public static String PROP_ACCEPT_STATUS = "acceptStatus";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_ACCEPT_DATE = "acceptDate";
	public static String PROP_BACK_CAUSE = "backCause";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_BIZ_CLASS = "bizClass";
	public static String PROP_ID = "id";
	public static String PROP_BIZ_ID = "bizId";
	public static String PROP_OP_PERSON = "opPerson";


	// constructors
	public BaseNetOpLog () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseNetOpLog (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*业务对象编码*/
    /*业务对象编码*/
	private String bizClass;
	
    /*业务记录ID*/
    /*业务记录ID*/
	private Long bizId;
	
    /*操作人*/
    /*操作人*/
	private String opPerson;
	
    /*受理日期*/
    /*受理日期*/
	private java.sql.Date acceptDate;
	
    /*退回原因*/
    /*退回原因*/
	private String backCause;
	
    /*备注*/
    /*备注*/
	private String description;
	
    /*操作时间*/
    /*操作时间*/
	private java.sql.Timestamp createTime;
	
    /*操作用户名*/
    /*操作用户名*/
	private String createUser;
	

	// many to one
	private com.justonetech.biz.domain.NetAcceptStatus acceptStatus;



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
	 * Return the value associated with the column: BIZ_CLASS
	 */
	public String getBizClass () {
		return bizClass;
	}

	/**
	 * Set the value related to the column: BIZ_CLASS
	 * @param bizClass the BIZ_CLASS value
	 */
	public void setBizClass (String bizClass) {
		this.bizClass = bizClass;
	}


	/**
	 * Return the value associated with the column: BIZ_ID
	 */
	public Long getBizId () {
		return bizId;
	}

	/**
	 * Set the value related to the column: BIZ_ID
	 * @param bizId the BIZ_ID value
	 */
	public void setBizId (Long bizId) {
		this.bizId = bizId;
	}


	/**
	 * Return the value associated with the column: OP_PERSON
	 */
	public String getOpPerson () {
		return opPerson;
	}

	/**
	 * Set the value related to the column: OP_PERSON
	 * @param opPerson the OP_PERSON value
	 */
	public void setOpPerson (String opPerson) {
		this.opPerson = opPerson;
	}


	/**
	 * Return the value associated with the column: ACCEPT_DATE
	 */
	public java.sql.Date getAcceptDate () {
		return acceptDate;
	}

	/**
	 * Set the value related to the column: ACCEPT_DATE
	 * @param acceptDate the ACCEPT_DATE value
	 */
	public void setAcceptDate (java.sql.Date acceptDate) {
		this.acceptDate = acceptDate;
	}


	/**
	 * Return the value associated with the column: BACK_CAUSE
	 */
	public String getBackCause () {
		return backCause;
	}

	/**
	 * Set the value related to the column: BACK_CAUSE
	 * @param backCause the BACK_CAUSE value
	 */
	public void setBackCause (String backCause) {
		this.backCause = backCause;
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
	 * Return the value associated with the column: ACCEPT_STATUS_ID
	 */
	public com.justonetech.biz.domain.NetAcceptStatus getAcceptStatus () {
		return acceptStatus;
	}

	/**
	 * Set the value related to the column: ACCEPT_STATUS_ID
	 * @param acceptStatus the ACCEPT_STATUS_ID value
	 */
	public void setAcceptStatus (com.justonetech.biz.domain.NetAcceptStatus acceptStatus) {
		this.acceptStatus = acceptStatus;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.NetOpLog)) return false;
		else {
			com.justonetech.biz.domain.NetOpLog netOpLog = (com.justonetech.biz.domain.NetOpLog) obj;
			if (null == this.getId() || null == netOpLog.getId()) return false;
			else return (this.getId().equals(netOpLog.getId()));
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
		builder.append(bizClass);
		builder.append(bizId);
		builder.append(opPerson);
		builder.append(acceptDate);
		builder.append(backCause);
		builder.append(description);
		builder.append(createTime);
		builder.append(createUser);
		return builder.toString();
	}


}