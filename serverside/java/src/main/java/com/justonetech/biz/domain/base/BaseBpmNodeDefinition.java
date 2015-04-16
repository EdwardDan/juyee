package com.justonetech.biz.domain.base;

import com.justonetech.biz.domain.BpmTaskSwimlane;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BPM_NODE_DEFINITION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 任务节点定义表
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 任务节点定义表
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : workflow
 * Projectable : false
 *
 * @hibernate.class
 *  table="BPM_NODE_DEFINITION"
 */

public abstract class BaseBpmNodeDefinition  implements Serializable {

	public static String REF = "BpmNodeDefinition";
	public static String PROP_PROCESS_DEFINITION = "processDefinition";
	public static String PROP_NAME = "name";
	public static String PROP_NODE_DEFINITION = "nodeDefinition";
	public static String PROP_NODE_TYPE = "nodeType";
	public static String PROP_ID = "id";
	public static String PROP_SHAPE_ID = "shapeId";
	public static String PROP_JBPM_NODE_ID = "jbpmNodeId";


	// constructors
	public BaseBpmNodeDefinition () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBpmNodeDefinition (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBpmNodeDefinition (
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
    /*JBPM_NODE ID*/
    /*JBPM_NODE ID*/
	private java.lang.Long jbpmNodeId;
	
    /*节点名称*/
    /*节点名称*/
	private java.lang.String name;
	
    /*动作定义XML*/
    /*动作定义XML*/
	private java.lang.String nodeDefinition;
	
    /*节点类型*/
    /*节点类型(开始/结束/进程/Desinion)*/
	private java.lang.String nodeType;
	
    /*页面形状ID*/
    /*页面形状ID*/
	private java.lang.Long shapeId;
	

	// many to one
	private com.justonetech.biz.domain.BpmProcessDefinition processDefinition;

	// collections
	private java.util.Set<com.justonetech.biz.domain.BpmTaskInstance> bpmTaskInstances;
//	private java.util.Set<com.justonetech.biz.domain.BpmTaskSwimlane> bpmTaskSwimlanes;
    private com.justonetech.biz.domain.BpmTaskSwimlane bpmTaskSwimlane;
	private java.util.Set<com.justonetech.biz.domain.BpmProcessTransition> bpmProcessTransitionsByfrom;
	private java.util.Set<com.justonetech.biz.domain.BpmProcessTransition> bpmProcessTransitionsByto;



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
	 * Return the value associated with the column: JBPM_NODE_ID
	 */
	public java.lang.Long getJbpmNodeId () {
		return jbpmNodeId;
	}

	/**
	 * Set the value related to the column: JBPM_NODE_ID
	 * @param jbpmNodeId the JBPM_NODE_ID value
	 */
	public void setJbpmNodeId (java.lang.Long jbpmNodeId) {
		this.jbpmNodeId = jbpmNodeId;
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
	 * Return the value associated with the column: NODE_DEFINITION
	 */
	public java.lang.String getNodeDefinition () {
		return nodeDefinition;
	}

	/**
	 * Set the value related to the column: NODE_DEFINITION
	 * @param nodeDefinition the NODE_DEFINITION value
	 */
	public void setNodeDefinition (java.lang.String nodeDefinition) {
		this.nodeDefinition = nodeDefinition;
	}


	/**
	 * Return the value associated with the column: NODE_TYPE
	 */
	public java.lang.String getNodeType () {
		return nodeType;
	}

	/**
	 * Set the value related to the column: NODE_TYPE
	 * @param nodeType the NODE_TYPE value
	 */
	public void setNodeType (java.lang.String nodeType) {
		this.nodeType = nodeType;
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
	 * Return the value associated with the column: bpmTaskInstances
	 */
	public java.util.Set<com.justonetech.biz.domain.BpmTaskInstance> getBpmTaskInstances () {
		if(bpmTaskInstances == null){
			bpmTaskInstances = new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmTaskInstance>();
		}
		return bpmTaskInstances;
	}

	/**
	 * Set the value related to the column: bpmTaskInstances
	 * @param bpmTaskInstances the bpmTaskInstances value
	 */
	public void setBpmTaskInstances (java.util.Set<com.justonetech.biz.domain.BpmTaskInstance> bpmTaskInstances) {
		this.bpmTaskInstances = bpmTaskInstances;
	}

	public void addTobpmTaskInstances (com.justonetech.biz.domain.BpmTaskInstance bpmTaskInstance) {
		if (null == getBpmTaskInstances()) setBpmTaskInstances(new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmTaskInstance>());
		getBpmTaskInstances().add(bpmTaskInstance);
	}

    public BpmTaskSwimlane getBpmTaskSwimlane() {
        return bpmTaskSwimlane;
    }

    public void setBpmTaskSwimlane(BpmTaskSwimlane bpmTaskSwimlane) {
        this.bpmTaskSwimlane = bpmTaskSwimlane;
    }

    /**
	 * Return the value associated with the column: bpmProcessTransitionsByfrom
	 */
	public java.util.Set<com.justonetech.biz.domain.BpmProcessTransition> getBpmProcessTransitionsByfrom () {
		if(bpmProcessTransitionsByfrom == null){
			bpmProcessTransitionsByfrom = new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmProcessTransition>();
		}
		return bpmProcessTransitionsByfrom;
	}

	/**
	 * Set the value related to the column: bpmProcessTransitionsByfrom
	 * @param bpmProcessTransitionsByfrom the bpmProcessTransitionsByfrom value
	 */
	public void setBpmProcessTransitionsByfrom (java.util.Set<com.justonetech.biz.domain.BpmProcessTransition> bpmProcessTransitionsByfrom) {
		this.bpmProcessTransitionsByfrom = bpmProcessTransitionsByfrom;
	}

	public void addTobpmProcessTransitionsByfrom (com.justonetech.biz.domain.BpmProcessTransition bpmProcessTransition) {
		if (null == getBpmProcessTransitionsByfrom()) setBpmProcessTransitionsByfrom(new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmProcessTransition>());
		getBpmProcessTransitionsByfrom().add(bpmProcessTransition);
	}


	/**
	 * Return the value associated with the column: bpmProcessTransitionsByto
	 */
	public java.util.Set<com.justonetech.biz.domain.BpmProcessTransition> getBpmProcessTransitionsByto () {
		if(bpmProcessTransitionsByto == null){
			bpmProcessTransitionsByto = new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmProcessTransition>();
		}
		return bpmProcessTransitionsByto;
	}

	/**
	 * Set the value related to the column: bpmProcessTransitionsByto
	 * @param bpmProcessTransitionsByto the bpmProcessTransitionsByto value
	 */
	public void setBpmProcessTransitionsByto (java.util.Set<com.justonetech.biz.domain.BpmProcessTransition> bpmProcessTransitionsByto) {
		this.bpmProcessTransitionsByto = bpmProcessTransitionsByto;
	}

	public void addTobpmProcessTransitionsByto (com.justonetech.biz.domain.BpmProcessTransition bpmProcessTransition) {
		if (null == getBpmProcessTransitionsByto()) setBpmProcessTransitionsByto(new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmProcessTransition>());
		getBpmProcessTransitionsByto().add(bpmProcessTransition);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.BpmNodeDefinition)) return false;
		else {
			com.justonetech.biz.domain.BpmNodeDefinition bpmNodeDefinition = (com.justonetech.biz.domain.BpmNodeDefinition) obj;
			if (null == this.getId() || null == bpmNodeDefinition.getId()) return false;
			else return (this.getId().equals(bpmNodeDefinition.getId()));
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
		builder.append(jbpmNodeId);
		builder.append(name);
		builder.append(nodeDefinition);
		builder.append(nodeType);
		builder.append(shapeId);
		return builder.toString();
	}


}