package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BPM_TASK_SWIMLANE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 任务泳道表
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 任务泳道表
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : workflow
 * Projectable : false
 *
 * @hibernate.class
 *  table="BPM_TASK_SWIMLANE"
 */

public abstract class BaseBpmTaskSwimlane  implements Serializable {

	public static String REF = "BpmTaskSwimlane";
	public static String PROP_NAME = "name";
	public static String PROP_SWIMLANE_DEFINITION = "swimlaneDefinition";
	public static String PROP_TASK = "task";
	public static String PROP_ID = "id";
	public static String PROP_PROCESS_SWIMLANE = "processSwimlane";


	// constructors
	public BaseBpmTaskSwimlane () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBpmTaskSwimlane (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBpmTaskSwimlane (
		java.lang.Long id,
		java.lang.String name) {

		this.setId(id);
		this.setName(name);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*泳道名称*/
    /*泳道名称*/
	private java.lang.String name;
	

	// many to one
	private com.justonetech.biz.domain.BpmSwimlaneDefinition swimlaneDefinition;
	private com.justonetech.biz.domain.BpmNodeDefinition task;
	private com.justonetech.biz.domain.BpmProcessSwimlane processSwimlane;



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
	 * Return the value associated with the column: NAME
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: NAME
	 * @param name the NAME value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}


	/**
	 * Return the value associated with the column: SWIMLANE_DEFINITION_ID
	 */
	public com.justonetech.biz.domain.BpmSwimlaneDefinition getSwimlaneDefinition () {
		return swimlaneDefinition;
	}

	/**
	 * Set the value related to the column: SWIMLANE_DEFINITION_ID
	 * @param swimlaneDefinition the SWIMLANE_DEFINITION_ID value
	 */
	public void setSwimlaneDefinition (com.justonetech.biz.domain.BpmSwimlaneDefinition swimlaneDefinition) {
		this.swimlaneDefinition = swimlaneDefinition;
	}


	/**
	 * Return the value associated with the column: TASK_ID
	 */
	public com.justonetech.biz.domain.BpmNodeDefinition getTask () {
		return task;
	}

	/**
	 * Set the value related to the column: TASK_ID
	 * @param task the TASK_ID value
	 */
	public void setTask (com.justonetech.biz.domain.BpmNodeDefinition task) {
		this.task = task;
	}


	/**
	 * Return the value associated with the column: PROCESS_SWIMLANE_ID
	 */
	public com.justonetech.biz.domain.BpmProcessSwimlane getProcessSwimlane () {
		return processSwimlane;
	}

	/**
	 * Set the value related to the column: PROCESS_SWIMLANE_ID
	 * @param processSwimlane the PROCESS_SWIMLANE_ID value
	 */
	public void setProcessSwimlane (com.justonetech.biz.domain.BpmProcessSwimlane processSwimlane) {
		this.processSwimlane = processSwimlane;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.BpmTaskSwimlane)) return false;
		else {
			com.justonetech.biz.domain.BpmTaskSwimlane bpmTaskSwimlane = (com.justonetech.biz.domain.BpmTaskSwimlane) obj;
			if (null == this.getId() || null == bpmTaskSwimlane.getId()) return false;
			else return (this.getId().equals(bpmTaskSwimlane.getId()));
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
		builder.append(name);
		return builder.toString();
	}


}