package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BPM_STANDARD_ACTION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 标准操作
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 标准操作
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : workflow
 * Projectable : false
 *
 * @hibernate.class
 *  table="BPM_STANDARD_ACTION"
 */

public abstract class BaseBpmStandardAction  implements Serializable {

	public static String REF = "BpmStandardAction";
	public static String PROP_DOCUMENT = "document";
	public static String PROP_SUBMIT_TIME = "submitTime";
	public static String PROP_TASK_INSTANCE = "taskInstance";
	public static String PROP_PERMIT_VALUE = "permitValue";
	public static String PROP_SUBMIT_USER = "submitUser";
	public static String PROP_PROCESS_INSTANCE = "processInstance";
	public static String PROP_IS_READ = "isRead";
	public static String PROP_ID = "id";
	public static String PROP_OPINION = "opinion";


	// constructors
	public BaseBpmStandardAction () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBpmStandardAction (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*批准结果*/
    /*批准结果:批准、未批准、保留意见*/
	private java.lang.String permitValue;
	
    /*是否已阅*/
    /*是否已阅*/
	private java.lang.Boolean isRead;
	
    /*审核意见*/
    /*审核意见*/
	private java.lang.String opinion;
	
    /*提交时间*/
    /*提交时间*/
	private java.sql.Timestamp submitTime;
	

	// many to one
	private com.justonetech.biz.domain.BpmProcessInstance processInstance;
	private com.justonetech.biz.domain.BpmTaskInstance taskInstance;
	private com.justonetech.biz.domain.DocDocument document;
	private com.justonetech.system.domain.SysUser submitUser;



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
	 * Return the value associated with the column: PERMIT_VALUE
	 */
	public java.lang.String getPermitValue () {
		return permitValue;
	}

	/**
	 * Set the value related to the column: PERMIT_VALUE
	 * @param permitValue the PERMIT_VALUE value
	 */
	public void setPermitValue (java.lang.String permitValue) {
		this.permitValue = permitValue;
	}


	/**
	 * Return the value associated with the column: IS_READ
	 */
	public java.lang.Boolean getIsRead () {
		return isRead;
	}

	/**
	 * Set the value related to the column: IS_READ
	 * @param isRead the IS_READ value
	 */
	public void setIsRead (java.lang.Boolean isRead) {
		this.isRead = isRead;
	}


	/**
	 * Return the value associated with the column: OPINION
	 */
	public java.lang.String getOpinion () {
		return opinion;
	}

	/**
	 * Set the value related to the column: OPINION
	 * @param opinion the OPINION value
	 */
	public void setOpinion (java.lang.String opinion) {
		this.opinion = opinion;
	}


	/**
	 * Return the value associated with the column: SUBMIT_TIME
	 */
	public java.sql.Timestamp getSubmitTime () {
		return submitTime;
	}

	/**
	 * Set the value related to the column: SUBMIT_TIME
	 * @param submitTime the SUBMIT_TIME value
	 */
	public void setSubmitTime (java.sql.Timestamp submitTime) {
		this.submitTime = submitTime;
	}


	/**
	 * Return the value associated with the column: PROCESS_INSTANCE_ID
	 */
	public com.justonetech.biz.domain.BpmProcessInstance getProcessInstance () {
		return processInstance;
	}

	/**
	 * Set the value related to the column: PROCESS_INSTANCE_ID
	 * @param processInstance the PROCESS_INSTANCE_ID value
	 */
	public void setProcessInstance (com.justonetech.biz.domain.BpmProcessInstance processInstance) {
		this.processInstance = processInstance;
	}


	/**
	 * Return the value associated with the column: TASK_INSTANCE_ID
	 */
	public com.justonetech.biz.domain.BpmTaskInstance getTaskInstance () {
		return taskInstance;
	}

	/**
	 * Set the value related to the column: TASK_INSTANCE_ID
	 * @param taskInstance the TASK_INSTANCE_ID value
	 */
	public void setTaskInstance (com.justonetech.biz.domain.BpmTaskInstance taskInstance) {
		this.taskInstance = taskInstance;
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


	/**
	 * Return the value associated with the column: SUBMIT_USER_ID
	 */
	public com.justonetech.system.domain.SysUser getSubmitUser () {
		return submitUser;
	}

	/**
	 * Set the value related to the column: SUBMIT_USER_ID
	 * @param submitUser the SUBMIT_USER_ID value
	 */
	public void setSubmitUser (com.justonetech.system.domain.SysUser submitUser) {
		this.submitUser = submitUser;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.BpmStandardAction)) return false;
		else {
			com.justonetech.biz.domain.BpmStandardAction bpmStandardAction = (com.justonetech.biz.domain.BpmStandardAction) obj;
			if (null == this.getId() || null == bpmStandardAction.getId()) return false;
			else return (this.getId().equals(bpmStandardAction.getId()));
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
		builder.append(permitValue);
		builder.append(isRead);
		builder.append(opinion);
		builder.append(submitTime);
		return builder.toString();
	}


}