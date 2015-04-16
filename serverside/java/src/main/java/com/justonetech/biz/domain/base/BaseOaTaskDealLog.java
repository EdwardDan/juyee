package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_TASK_DEAL_LOG table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 任务处理记录日志
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 任务处理记录日志
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_TASK_DEAL_LOG"
 */

public abstract class BaseOaTaskDealLog  implements Serializable {

	public static String REF = "OaTaskDealLog";
	public static String PROP_USER = "user";
	public static String PROP_STATUS = "status";
	public static String PROP_TASK = "task";
	public static String PROP_OP_DATETIME = "opDatetime";
	public static String PROP_ID = "id";
	public static String PROP_ACCEPT_TIME = "acceptTime";


	// constructors
	public BaseOaTaskDealLog () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaTaskDealLog (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*接收时间*/
    /*接收时间*/
	private java.sql.Timestamp acceptTime;
	
    /*状态*/
    /*状态*/
	private java.lang.String status;
	
    /*操作时间*/
    /*操作时间*/
	private java.sql.Timestamp opDatetime;
	

	// many to one
	private com.justonetech.system.domain.SysUser user;
	private com.justonetech.biz.domain.OaTaskLog task;



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
	 * Return the value associated with the column: ACCEPT_TIME
	 */
	public java.sql.Timestamp getAcceptTime () {
		return acceptTime;
	}

	/**
	 * Set the value related to the column: ACCEPT_TIME
	 * @param acceptTime the ACCEPT_TIME value
	 */
	public void setAcceptTime (java.sql.Timestamp acceptTime) {
		this.acceptTime = acceptTime;
	}


	/**
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}


	/**
	 * Return the value associated with the column: OP_DATETIME
	 */
	public java.sql.Timestamp getOpDatetime () {
		return opDatetime;
	}

	/**
	 * Set the value related to the column: OP_DATETIME
	 * @param opDatetime the OP_DATETIME value
	 */
	public void setOpDatetime (java.sql.Timestamp opDatetime) {
		this.opDatetime = opDatetime;
	}


	/**
	 * Return the value associated with the column: USER_ID
	 */
	public com.justonetech.system.domain.SysUser getUser () {
		return user;
	}

	/**
	 * Set the value related to the column: USER_ID
	 * @param user the USER_ID value
	 */
	public void setUser (com.justonetech.system.domain.SysUser user) {
		this.user = user;
	}


	/**
	 * Return the value associated with the column: TASK_ID
	 */
	public com.justonetech.biz.domain.OaTaskLog getTask () {
		return task;
	}

	/**
	 * Set the value related to the column: TASK_ID
	 * @param task the TASK_ID value
	 */
	public void setTask (com.justonetech.biz.domain.OaTaskLog task) {
		this.task = task;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaTaskDealLog)) return false;
		else {
			com.justonetech.biz.domain.OaTaskDealLog oaTaskDealLog = (com.justonetech.biz.domain.OaTaskDealLog) obj;
			if (null == this.getId() || null == oaTaskDealLog.getId()) return false;
			else return (this.getId().equals(oaTaskDealLog.getId()));
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
		builder.append(acceptTime);
		builder.append(status);
		builder.append(opDatetime);
		return builder.toString();
	}


}