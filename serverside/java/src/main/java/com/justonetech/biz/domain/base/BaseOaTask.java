package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_TASK table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 任务
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 任务
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_TASK"
 */

public abstract class BaseOaTask  implements Serializable {

	public static String REF = "OaTask";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_TYPE = "type";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_ID = "id";
	public static String PROP_AUDIT_METHOD = "auditMethod";
	public static String PROP_TITLE = "title";
	public static String PROP_PRIORITY = "priority";
	public static String PROP_REFER_ID = "referId";


	// constructors
	public BaseOaTask () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaTask (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseOaTask (
		java.lang.Long id,
		java.lang.String title) {

		this.setId(id);
		this.setTitle(title);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*业务记录_ID*/
    /*业务记录_ID*/
	private java.lang.Long referId;
	
    /*标题*/
    /*标题*/
	private java.lang.String title;
	
    /*创建时间*/
    /*创建时间*/
	private java.sql.Timestamp createTime;
	
    /*紧急程度*/
    /*紧急程度*/
	private java.lang.String priority;
	
    /*审核模式*/
    /*审核模式*/
	private java.lang.String auditMethod;
	

	// many to one
	private com.justonetech.biz.domain.OaTaskType type;
	private com.justonetech.system.domain.SysUser createUser;

	// collections
	private java.util.Set<com.justonetech.biz.domain.OaTaskDeal> oaTaskDeals;



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
	 * Return the value associated with the column: REFER_ID
	 */
	public java.lang.Long getReferId () {
		return referId;
	}

	/**
	 * Set the value related to the column: REFER_ID
	 * @param referId the REFER_ID value
	 */
	public void setReferId (java.lang.Long referId) {
		this.referId = referId;
	}


	/**
	 * Return the value associated with the column: TITLE
	 */
	public java.lang.String getTitle () {
		return title;
	}

	/**
	 * Set the value related to the column: TITLE
	 * @param title the TITLE value
	 */
	public void setTitle (java.lang.String title) {
		this.title = title;
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
	 * Return the value associated with the column: PRIORITY
	 */
	public java.lang.String getPriority () {
		return priority;
	}

	/**
	 * Set the value related to the column: PRIORITY
	 * @param priority the PRIORITY value
	 */
	public void setPriority (java.lang.String priority) {
		this.priority = priority;
	}


	/**
	 * Return the value associated with the column: AUDIT_METHOD
	 */
	public java.lang.String getAuditMethod () {
		return auditMethod;
	}

	/**
	 * Set the value related to the column: AUDIT_METHOD
	 * @param auditMethod the AUDIT_METHOD value
	 */
	public void setAuditMethod (java.lang.String auditMethod) {
		this.auditMethod = auditMethod;
	}


	/**
	 * Return the value associated with the column: TYPE_ID
	 */
	public com.justonetech.biz.domain.OaTaskType getType () {
		return type;
	}

	/**
	 * Set the value related to the column: TYPE_ID
	 * @param type the TYPE_ID value
	 */
	public void setType (com.justonetech.biz.domain.OaTaskType type) {
		this.type = type;
	}


	/**
	 * Return the value associated with the column: CREATE_USER_ID
	 */
	public com.justonetech.system.domain.SysUser getCreateUser () {
		return createUser;
	}

	/**
	 * Set the value related to the column: CREATE_USER_ID
	 * @param createUser the CREATE_USER_ID value
	 */
	public void setCreateUser (com.justonetech.system.domain.SysUser createUser) {
		this.createUser = createUser;
	}


	/**
	 * Return the value associated with the column: oaTaskDeals
	 */
	public java.util.Set<com.justonetech.biz.domain.OaTaskDeal> getOaTaskDeals () {
		if(oaTaskDeals == null){
			oaTaskDeals = new java.util.LinkedHashSet<com.justonetech.biz.domain.OaTaskDeal>();
		}
		return oaTaskDeals;
	}

	/**
	 * Set the value related to the column: oaTaskDeals
	 * @param oaTaskDeals the oaTaskDeals value
	 */
	public void setOaTaskDeals (java.util.Set<com.justonetech.biz.domain.OaTaskDeal> oaTaskDeals) {
		this.oaTaskDeals = oaTaskDeals;
	}

	public void addTooaTaskDeals (com.justonetech.biz.domain.OaTaskDeal oaTaskDeal) {
		if (null == getOaTaskDeals()) setOaTaskDeals(new java.util.LinkedHashSet<com.justonetech.biz.domain.OaTaskDeal>());
		getOaTaskDeals().add(oaTaskDeal);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaTask)) return false;
		else {
			com.justonetech.biz.domain.OaTask oaTask = (com.justonetech.biz.domain.OaTask) obj;
			if (null == this.getId() || null == oaTask.getId()) return false;
			else return (this.getId().equals(oaTask.getId()));
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
		builder.append(referId);
		builder.append(title);
		builder.append(createTime);
		builder.append(priority);
		builder.append(auditMethod);
		return builder.toString();
	}


}