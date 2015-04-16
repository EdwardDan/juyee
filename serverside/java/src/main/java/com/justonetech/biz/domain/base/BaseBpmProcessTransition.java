package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BPM_PROCESS_TRANSITION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 流程分支
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 流程分支
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : workflow
 * Projectable : false
 *
 * @hibernate.class
 *  table="BPM_PROCESS_TRANSITION"
 */

public abstract class BaseBpmProcessTransition  implements Serializable {

	public static String REF = "BpmProcessTransition";
	public static String PROP_PROCESS_DEFINITION = "processDefinition";
	public static String PROP_NAME = "name";
	public static String PROP_TO = "to";
	public static String PROP_ID = "id";
	public static String PROP_SHAPE_ID = "shapeId";
	public static String PROP_FROM = "from";
	public static String PROP_JBPM_TRANSITION_ID = "jbpmTransitionId";


	// constructors
	public BaseBpmProcessTransition () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBpmProcessTransition (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBpmProcessTransition (
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
    /*名称*/
    /*名称*/
	private java.lang.String name;
	
    /*页面形状_ID*/
    /*页面形状_ID*/
	private java.lang.Long shapeId;
	
    /*JBPM分支_ID*/
    /*JBPM分支_ID*/
	private java.lang.Long jbpmTransitionId;
	

	// many to one
	private com.justonetech.biz.domain.BpmNodeDefinition from;
	private com.justonetech.biz.domain.BpmNodeDefinition to;
	private com.justonetech.biz.domain.BpmProcessDefinition processDefinition;



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
	 * Return the value associated with the column: SHAPE_ID
	 */
	public java.lang.Long getShapeId () {
		return shapeId;
	}

	/**
	 * Set the value related to the column: SHAPE_ID
	 * @param shapeId the SHAPE_ID value
	 */
	public void setShapeId (java.lang.Long shapeId) {
		this.shapeId = shapeId;
	}


	/**
	 * Return the value associated with the column: JBPM_TRANSITION_ID
	 */
	public java.lang.Long getJbpmTransitionId () {
		return jbpmTransitionId;
	}

	/**
	 * Set the value related to the column: JBPM_TRANSITION_ID
	 * @param jbpmTransitionId the JBPM_TRANSITION_ID value
	 */
	public void setJbpmTransitionId (java.lang.Long jbpmTransitionId) {
		this.jbpmTransitionId = jbpmTransitionId;
	}


	/**
	 * Return the value associated with the column: FROM_ID
	 */
	public com.justonetech.biz.domain.BpmNodeDefinition getFrom () {
		return from;
	}

	/**
	 * Set the value related to the column: FROM_ID
	 * @param from the FROM_ID value
	 */
	public void setFrom (com.justonetech.biz.domain.BpmNodeDefinition from) {
		this.from = from;
	}


	/**
	 * Return the value associated with the column: TO_ID
	 */
	public com.justonetech.biz.domain.BpmNodeDefinition getTo () {
		return to;
	}

	/**
	 * Set the value related to the column: TO_ID
	 * @param to the TO_ID value
	 */
	public void setTo (com.justonetech.biz.domain.BpmNodeDefinition to) {
		this.to = to;
	}


	/**
	 * Return the value associated with the column: PROCESS_DEFINITION_ID
	 */
	public com.justonetech.biz.domain.BpmProcessDefinition getProcessDefinition () {
		return processDefinition;
	}

	/**
	 * Set the value related to the column: PROCESS_DEFINITION_ID
	 * @param processDefinition the PROCESS_DEFINITION_ID value
	 */
	public void setProcessDefinition (com.justonetech.biz.domain.BpmProcessDefinition processDefinition) {
		this.processDefinition = processDefinition;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.BpmProcessTransition)) return false;
		else {
			com.justonetech.biz.domain.BpmProcessTransition bpmProcessTransition = (com.justonetech.biz.domain.BpmProcessTransition) obj;
			if (null == this.getId() || null == bpmProcessTransition.getId()) return false;
			else return (this.getId().equals(bpmProcessTransition.getId()));
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
		builder.append(shapeId);
		builder.append(jbpmTransitionId);
		return builder.toString();
	}


}