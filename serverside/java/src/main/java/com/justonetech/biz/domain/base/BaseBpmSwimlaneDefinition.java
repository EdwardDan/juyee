package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BPM_SWIMLANE_DEFINITION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 泳道定义
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 泳道定义
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : workflow
 * Projectable : false
 *
 * @hibernate.class
 *  table="BPM_SWIMLANE_DEFINITION"
 */

public abstract class BaseBpmSwimlaneDefinition  implements Serializable {

	public static String REF = "BpmSwimlaneDefinition";
	public static String PROP_POSITION_TYPE = "positionType";
	public static String PROP_ID = "id";
	public static String PROP_EXPRESSION = "expression";
	public static String PROP_GROUP = "group";


	// constructors
	public BaseBpmSwimlaneDefinition () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBpmSwimlaneDefinition (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*表达式*/
    /*表达式*/
	private java.lang.String expression;
	

	// many to one
	private com.justonetech.system.domain.SysCodeDetail positionType;
	private com.justonetech.system.domain.SysCodeDetail group;

	// collections
	private java.util.Set<com.justonetech.biz.domain.BpmSwimlane> bpmSwimlanes;
	private java.util.Set<com.justonetech.biz.domain.BpmProcessSwimlane> bpmProcessSwimlanes;
	private java.util.Set<com.justonetech.biz.domain.BpmProcessDefinition> bpmProcessDefinitions;
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
	 * Return the value associated with the column: EXPRESSION
	 */
	public java.lang.String getExpression () {
		return expression;
	}

	/**
	 * Set the value related to the column: EXPRESSION
	 * @param expression the EXPRESSION value
	 */
	public void setExpression (java.lang.String expression) {
		this.expression = expression;
	}


	/**
	 * Return the value associated with the column: POSITION_TYPE_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getPositionType () {
		return positionType;
	}

	/**
	 * Set the value related to the column: POSITION_TYPE_ID
	 * @param positionType the POSITION_TYPE_ID value
	 */
	public void setPositionType (com.justonetech.system.domain.SysCodeDetail positionType) {
		this.positionType = positionType;
	}


	/**
	 * Return the value associated with the column: GROUP_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getGroup () {
		return group;
	}

	/**
	 * Set the value related to the column: GROUP_ID
	 * @param group the GROUP_ID value
	 */
	public void setGroup (com.justonetech.system.domain.SysCodeDetail group) {
		this.group = group;
	}


	/**
	 * Return the value associated with the column: bpmSwimlanes
	 */
	public java.util.Set<com.justonetech.biz.domain.BpmSwimlane> getBpmSwimlanes () {
		if(bpmSwimlanes == null){
			bpmSwimlanes = new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmSwimlane>();
		}
		return bpmSwimlanes;
	}

	/**
	 * Set the value related to the column: bpmSwimlanes
	 * @param bpmSwimlanes the bpmSwimlanes value
	 */
	public void setBpmSwimlanes (java.util.Set<com.justonetech.biz.domain.BpmSwimlane> bpmSwimlanes) {
		this.bpmSwimlanes = bpmSwimlanes;
	}

	public void addTobpmSwimlanes (com.justonetech.biz.domain.BpmSwimlane bpmSwimlane) {
		if (null == getBpmSwimlanes()) setBpmSwimlanes(new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmSwimlane>());
		getBpmSwimlanes().add(bpmSwimlane);
	}


	/**
	 * Return the value associated with the column: bpmProcessSwimlanes
	 */
	public java.util.Set<com.justonetech.biz.domain.BpmProcessSwimlane> getBpmProcessSwimlanes () {
		if(bpmProcessSwimlanes == null){
			bpmProcessSwimlanes = new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmProcessSwimlane>();
		}
		return bpmProcessSwimlanes;
	}

	/**
	 * Set the value related to the column: bpmProcessSwimlanes
	 * @param bpmProcessSwimlanes the bpmProcessSwimlanes value
	 */
	public void setBpmProcessSwimlanes (java.util.Set<com.justonetech.biz.domain.BpmProcessSwimlane> bpmProcessSwimlanes) {
		this.bpmProcessSwimlanes = bpmProcessSwimlanes;
	}

	public void addTobpmProcessSwimlanes (com.justonetech.biz.domain.BpmProcessSwimlane bpmProcessSwimlane) {
		if (null == getBpmProcessSwimlanes()) setBpmProcessSwimlanes(new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmProcessSwimlane>());
		getBpmProcessSwimlanes().add(bpmProcessSwimlane);
	}


	/**
	 * Return the value associated with the column: bpmProcessDefinitions
	 */
	public java.util.Set<com.justonetech.biz.domain.BpmProcessDefinition> getBpmProcessDefinitions () {
		if(bpmProcessDefinitions == null){
			bpmProcessDefinitions = new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmProcessDefinition>();
		}
		return bpmProcessDefinitions;
	}

	/**
	 * Set the value related to the column: bpmProcessDefinitions
	 * @param bpmProcessDefinitions the bpmProcessDefinitions value
	 */
	public void setBpmProcessDefinitions (java.util.Set<com.justonetech.biz.domain.BpmProcessDefinition> bpmProcessDefinitions) {
		this.bpmProcessDefinitions = bpmProcessDefinitions;
	}

	public void addTobpmProcessDefinitions (com.justonetech.biz.domain.BpmProcessDefinition bpmProcessDefinition) {
		if (null == getBpmProcessDefinitions()) setBpmProcessDefinitions(new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmProcessDefinition>());
		getBpmProcessDefinitions().add(bpmProcessDefinition);
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
		if (!(obj instanceof com.justonetech.biz.domain.BpmSwimlaneDefinition)) return false;
		else {
			com.justonetech.biz.domain.BpmSwimlaneDefinition bpmSwimlaneDefinition = (com.justonetech.biz.domain.BpmSwimlaneDefinition) obj;
			if (null == this.getId() || null == bpmSwimlaneDefinition.getId()) return false;
			else return (this.getId().equals(bpmSwimlaneDefinition.getId()));
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
		builder.append(expression);
		return builder.toString();
	}


}