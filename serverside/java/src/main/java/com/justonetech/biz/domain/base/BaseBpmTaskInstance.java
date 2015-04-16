package com.justonetech.biz.domain.base;

import com.justonetech.biz.domain.BpmFormAction;
import com.justonetech.biz.domain.BpmStandardAction;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BPM_TASK_INSTANCE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 业务流程任务实例表
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 业务流程任务实例表
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : workflow
 * Projectable : false
 *
 * @hibernate.class
 *  table="BPM_TASK_INSTANCE"
 */

public abstract class BaseBpmTaskInstance  implements Serializable {

	public static String REF = "BpmTaskInstance";
	public static String PROP_TASK_DATA = "taskData";
	public static String PROP_PROCESS_INSTANCE = "processInstance";
	public static String PROP_TASK_DEFINITION = "taskDefinition";
	public static String PROP_ID = "id";
	public static String PROP_END_TIME = "endTime";
	public static String PROP_START_TIME = "startTime";
	public static String PROP_JBPM_TASK_INSTANCE_ID = "jbpmTaskInstanceId";
	public static String PROP_REFER_ID = "referId";


	// constructors
	public BaseBpmTaskInstance () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBpmTaskInstance (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*任务实例ID*/
    /*任务实例ID*/
	private java.lang.Long jbpmTaskInstanceId;
	
    /*开始时间*/
    /*开始时间*/
	private java.sql.Timestamp startTime;
	
    /*结束时间*/
    /*结束时间*/
	private java.sql.Timestamp endTime;
	
    /*任务数据(XML)*/
    /*任务数据(XML)*/
	private java.lang.String taskData;
	
    /*业务ID*/
    /*业务ID*/
	private java.lang.Long referId;
	

	// many to one
	private com.justonetech.biz.domain.BpmProcessInstance processInstance;
	private com.justonetech.biz.domain.BpmNodeDefinition taskDefinition;

	// collections
    private com.justonetech.biz.domain.BpmFormAction bpmFormAction;
    private com.justonetech.biz.domain.BpmStandardAction bpmStandardAction;



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
	 * Return the value associated with the column: JBPM_TASK_INSTANCE_ID
	 */
	public java.lang.Long getJbpmTaskInstanceId () {
		return jbpmTaskInstanceId;
	}

	/**
	 * Set the value related to the column: JBPM_TASK_INSTANCE_ID
	 * @param jbpmTaskInstanceId the JBPM_TASK_INSTANCE_ID value
	 */
	public void setJbpmTaskInstanceId (java.lang.Long jbpmTaskInstanceId) {
		this.jbpmTaskInstanceId = jbpmTaskInstanceId;
	}


	/**
	 * Return the value associated with the column: START_TIME
	 */
	public java.sql.Timestamp getStartTime () {
		return startTime;
	}

	/**
	 * Set the value related to the column: START_TIME
	 * @param startTime the START_TIME value
	 */
	public void setStartTime (java.sql.Timestamp startTime) {
		this.startTime = startTime;
	}


	/**
	 * Return the value associated with the column: END_TIME
	 */
	public java.sql.Timestamp getEndTime () {
		return endTime;
	}

	/**
	 * Set the value related to the column: END_TIME
	 * @param endTime the END_TIME value
	 */
	public void setEndTime (java.sql.Timestamp endTime) {
		this.endTime = endTime;
	}


	/**
	 * Return the value associated with the column: TASK_DATA
	 */
	public java.lang.String getTaskData () {
		return taskData;
	}

	/**
	 * Set the value related to the column: TASK_DATA
	 * @param taskData the TASK_DATA value
	 */
	public void setTaskData (java.lang.String taskData) {
		this.taskData = taskData;
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
	 * Return the value associated with the column: TASK_DEFINITION_ID
	 */
	public com.justonetech.biz.domain.BpmNodeDefinition getTaskDefinition () {
		return taskDefinition;
	}

	/**
	 * Set the value related to the column: TASK_DEFINITION_ID
	 * @param taskDefinition the TASK_DEFINITION_ID value
	 */
	public void setTaskDefinition (com.justonetech.biz.domain.BpmNodeDefinition taskDefinition) {
		this.taskDefinition = taskDefinition;
	}

    public BpmFormAction getBpmFormAction() {
        return bpmFormAction;
    }

    public void setBpmFormAction(BpmFormAction bpmFormAction) {
        this.bpmFormAction = bpmFormAction;
    }

    public BpmStandardAction getBpmStandardAction() {
        return bpmStandardAction;
    }

    public void setBpmStandardAction(BpmStandardAction bpmStandardAction) {
        this.bpmStandardAction = bpmStandardAction;
    }

    public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.BpmTaskInstance)) return false;
		else {
			com.justonetech.biz.domain.BpmTaskInstance bpmTaskInstance = (com.justonetech.biz.domain.BpmTaskInstance) obj;
			if (null == this.getId() || null == bpmTaskInstance.getId()) return false;
			else return (this.getId().equals(bpmTaskInstance.getId()));
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
		builder.append(jbpmTaskInstanceId);
		builder.append(startTime);
		builder.append(endTime);
		builder.append(taskData);
		builder.append(referId);
		return builder.toString();
	}


}