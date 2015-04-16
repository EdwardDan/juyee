package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BPM_FORM_ACTION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 表单操作
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 表单操作
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : workflow
 * Projectable : false
 *
 * @hibernate.class
 *  table="BPM_FORM_ACTION"
 */

public abstract class BaseBpmFormAction  implements Serializable {

	public static String REF = "BpmFormAction";
	public static String PROP_DOCUMENT = "document";
	public static String PROP_SUBMIT_TIME = "submitTime";
	public static String PROP_TASK_INSTANCE = "taskInstance";
	public static String PROP_SUBMIT_USER = "submitUser";
	public static String PROP_PROCESS_INSTANCE = "processInstance";
	public static String PROP_FORM_XML = "formXml";
	public static String PROP_ID = "id";
	public static String PROP_FORM_TEMPLATE = "formTemplate";


	// constructors
	public BaseBpmFormAction () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBpmFormAction (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*表单数据*/
    /*表单数据*/
	private java.lang.String formXml;
	
    /*提交时间*/
    /*提交时间*/
	private java.sql.Timestamp submitTime;
	

	// many to one
	private com.justonetech.biz.domain.BpmProcessInstance processInstance;
	private com.justonetech.biz.domain.BpmTaskInstance taskInstance;
	private com.justonetech.biz.domain.BpmFormTemplate formTemplate;
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
	 * Return the value associated with the column: FORM_XML
	 */
	public java.lang.String getFormXml () {
		return formXml;
	}

	/**
	 * Set the value related to the column: FORM_XML
	 * @param formXml the FORM_XML value
	 */
	public void setFormXml (java.lang.String formXml) {
		this.formXml = formXml;
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
	 * Return the value associated with the column: FORM_TEMPLATE_ID
	 */
	public com.justonetech.biz.domain.BpmFormTemplate getFormTemplate () {
		return formTemplate;
	}

	/**
	 * Set the value related to the column: FORM_TEMPLATE_ID
	 * @param formTemplate the FORM_TEMPLATE_ID value
	 */
	public void setFormTemplate (com.justonetech.biz.domain.BpmFormTemplate formTemplate) {
		this.formTemplate = formTemplate;
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
		if (!(obj instanceof com.justonetech.biz.domain.BpmFormAction)) return false;
		else {
			com.justonetech.biz.domain.BpmFormAction bpmFormAction = (com.justonetech.biz.domain.BpmFormAction) obj;
			if (null == this.getId() || null == bpmFormAction.getId()) return false;
			else return (this.getId().equals(bpmFormAction.getId()));
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
		builder.append(formXml);
		builder.append(submitTime);
		return builder.toString();
	}


}