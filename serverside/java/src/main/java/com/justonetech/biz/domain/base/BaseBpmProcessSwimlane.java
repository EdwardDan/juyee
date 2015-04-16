package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BPM_PROCESS_SWIMLANE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 流程泳道表
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 流程泳道表
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : workflow
 * Projectable : false
 *
 * @hibernate.class
 *  table="BPM_PROCESS_SWIMLANE"
 */

public abstract class BaseBpmProcessSwimlane  implements Serializable {

	public static String REF = "BpmProcessSwimlane";
	public static String PROP_PROCESS_DEFINITION = "processDefinition";
	public static String PROP_NAME = "name";
	public static String PROP_SWIMLANE_DEFINITION = "swimlaneDefinition";
	public static String PROP_SWIMLANE = "swimlane";
	public static String PROP_ID = "id";
	public static String PROP_SHAPE_ID = "shapeId";


	// constructors
	public BaseBpmProcessSwimlane () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBpmProcessSwimlane (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBpmProcessSwimlane (
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
	
    /*页面形状ID*/
    /*页面形状ID*/
	private java.lang.Long shapeId;
	

	// many to one
	private com.justonetech.biz.domain.BpmSwimlane swimlane;
	private com.justonetech.biz.domain.BpmProcessDefinition processDefinition;
	private com.justonetech.biz.domain.BpmSwimlaneDefinition swimlaneDefinition;

	// collections
	private java.util.Set<com.justonetech.biz.domain.BpmTaskSwimlane> bpmTaskSwimlanes;



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
	 * Return the value associated with the column: SWIMLANE_ID
	 */
	public com.justonetech.biz.domain.BpmSwimlane getSwimlane () {
		return swimlane;
	}

	/**
	 * Set the value related to the column: SWIMLANE_ID
	 * @param swimlane the SWIMLANE_ID value
	 */
	public void setSwimlane (com.justonetech.biz.domain.BpmSwimlane swimlane) {
		this.swimlane = swimlane;
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
	 * Return the value associated with the column: bpmTaskSwimlanes
	 */
	public java.util.Set<com.justonetech.biz.domain.BpmTaskSwimlane> getBpmTaskSwimlanes () {
		if(bpmTaskSwimlanes == null){
			bpmTaskSwimlanes = new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmTaskSwimlane>();
		}
		return bpmTaskSwimlanes;
	}

	/**
	 * Set the value related to the column: bpmTaskSwimlanes
	 * @param bpmTaskSwimlanes the bpmTaskSwimlanes value
	 */
	public void setBpmTaskSwimlanes (java.util.Set<com.justonetech.biz.domain.BpmTaskSwimlane> bpmTaskSwimlanes) {
		this.bpmTaskSwimlanes = bpmTaskSwimlanes;
	}

	public void addTobpmTaskSwimlanes (com.justonetech.biz.domain.BpmTaskSwimlane bpmTaskSwimlane) {
		if (null == getBpmTaskSwimlanes()) setBpmTaskSwimlanes(new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmTaskSwimlane>());
		getBpmTaskSwimlanes().add(bpmTaskSwimlane);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.BpmProcessSwimlane)) return false;
		else {
			com.justonetech.biz.domain.BpmProcessSwimlane bpmProcessSwimlane = (com.justonetech.biz.domain.BpmProcessSwimlane) obj;
			if (null == this.getId() || null == bpmProcessSwimlane.getId()) return false;
			else return (this.getId().equals(bpmProcessSwimlane.getId()));
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
		return builder.toString();
	}


}