package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;
import com.justonetech.system.domain.SysCodeDetail;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BPM_PROCESS_DEFINITION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 业务流程定义表
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 业务流程定义表
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : workflow
 * Projectable : false
 *
 * @hibernate.class
 *  table="BPM_PROCESS_DEFINITION"
 */

public abstract class BaseBpmProcessDefinition  implements Serializable,Auditable {

	public static String REF = "BpmProcessDefinition";
	public static String PROP_BIZ_OBJECT = "bizObject";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_JBPM_DEFINITION_ID = "jbpmDefinitionId";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_FILE_CATEGORY = "fileCategory";
	public static String PROP_CODE = "code";
	public static String PROP_NAME = "name";
	public static String PROP_ORDER_NO = "orderNo";
	public static String PROP_FINISH_SCRIPT = "finishScript";
	public static String PROP_IS_VALID = "isValid";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_PROCESS_TEMPLATE = "processTemplate";
	public static String PROP_ID = "id";
	public static String PROP_UPDATE_SCRIPT = "updateScript";
	public static String PROP_INIT_SCRIPT = "initScript";
	public static String PROP_VERSION = "version";
	public static String PROP_COLUMN_XML = "columnXml";
	public static String PROP_VIEW_SWIMLANE_DEFINITION = "viewSwimlaneDefinition";
	public static String PROP_WORK_ID = "workId";
	public static String PROP_CATEGORY = "category";


	// constructors
	public BaseBpmProcessDefinition () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBpmProcessDefinition (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBpmProcessDefinition (
		java.lang.Long id,
		java.lang.String code,
		java.lang.String name) {

		this.setId(id);
		this.setCode(code);
		this.setName(name);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*JBPM流程定义ID*/
    /*JBPM流程定义ID*/
	private java.lang.Long jbpmDefinitionId;
	
    /*业务流程编码*/
    /*业务流程编码*/
	private java.lang.String code;
	
    /*业务流程名称*/
    /*业务流程名称*/
	private java.lang.String name;
	
    /*版本*/
    /*版本*/
	private java.lang.Integer version;
	
    /*排序*/
    /*排序*/
	private java.lang.Long orderNo;
	
    /*是否有效*/
    /*是否有效*/
	private java.lang.Boolean isValid;
	
    /*备注*/
    /*备注*/
	private java.lang.String description;
	
    /*关联作业ID*/
    /*关联作业ID*/
	private java.lang.Long workId;
	
    /*最后修改时间*/
    /*最后修改时间*/
	private java.sql.Timestamp updateTime;
	
    /*创建时间*/
    /*创建时间*/
	private java.sql.Timestamp createTime;
	
    /*列表显示配置*/
    /*列表显示配置（针对BpmProcessInstance）*/
	private java.lang.String columnXml;
	
    /*业务对象名*/
    /*业务对象名*/
	private java.lang.String bizObject;
	
    /*初始化脚本*/
    /*初始化脚本*/
	private java.lang.String initScript;
	
    /*更新脚本*/
    /*更新脚本*/
	private java.lang.String updateScript;
	
    /*结束脚本*/
    /*结束脚本*/
	private java.lang.String finishScript;
	

	// many to one
	private com.justonetech.biz.domain.BpmSwimlaneDefinition viewSwimlaneDefinition;
	private com.justonetech.biz.domain.DocCategory fileCategory;
	private com.justonetech.biz.domain.BpmProcessTemplate processTemplate;
	private com.justonetech.system.domain.SysCodeDetail category;

	// collections
	private java.util.Set<com.justonetech.biz.domain.BpmNodeDefinition> bpmNodeDefinitions;
	private java.util.Set<com.justonetech.biz.domain.BpmProcessInstance> bpmProcessInstances;
	private java.util.Set<com.justonetech.biz.domain.BpmProcessDefinitionForm> bpmProcessDefinitionForms;
	private java.util.Set<com.justonetech.biz.domain.BpmProcessSwimlane> bpmProcessSwimlanes;
	private java.util.Set<com.justonetech.biz.domain.BpmProcessTransition> bpmProcessTransitions;



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
	 * Return the value associated with the column: JBPM_DEFINITION_ID
	 */
	public java.lang.Long getJbpmDefinitionId () {
		return jbpmDefinitionId;
	}

	/**
	 * Set the value related to the column: JBPM_DEFINITION_ID
	 * @param jbpmDefinitionId the JBPM_DEFINITION_ID value
	 */
	public void setJbpmDefinitionId (java.lang.Long jbpmDefinitionId) {
		this.jbpmDefinitionId = jbpmDefinitionId;
	}


	/**
	 * Return the value associated with the column: CODE
	 */
	public java.lang.String getCode () {
		return code;
	}

	/**
	 * Set the value related to the column: CODE
	 * @param code the CODE value
	 */
	public void setCode (java.lang.String code) {
		this.code = code;
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
	 * Return the value associated with the column: VERSION
	 */
	public java.lang.Integer getVersion () {
		return version;
	}

	/**
	 * Set the value related to the column: VERSION
	 * @param version the VERSION value
	 */
	public void setVersion (java.lang.Integer version) {
		this.version = version;
	}


	/**
	 * Return the value associated with the column: ORDER_NO
	 */
	public java.lang.Long getOrderNo () {
		return orderNo;
	}

	/**
	 * Set the value related to the column: ORDER_NO
	 * @param orderNo the ORDER_NO value
	 */
	public void setOrderNo (java.lang.Long orderNo) {
		this.orderNo = orderNo;
	}


	/**
	 * Return the value associated with the column: IS_VALID
	 */
	public java.lang.Boolean getIsValid () {
		return isValid;
	}

	/**
	 * Set the value related to the column: IS_VALID
	 * @param isValid the IS_VALID value
	 */
	public void setIsValid (java.lang.Boolean isValid) {
		this.isValid = isValid;
	}


	/**
	 * Return the value associated with the column: DESCRIPTION
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: DESCRIPTION
	 * @param description the DESCRIPTION value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}


	/**
	 * Return the value associated with the column: WORK_ID
	 */
	public java.lang.Long getWorkId () {
		return workId;
	}

	/**
	 * Set the value related to the column: WORK_ID
	 * @param workId the WORK_ID value
	 */
	public void setWorkId (java.lang.Long workId) {
		this.workId = workId;
	}


	/**
	 * Return the value associated with the column: UPDATE_TIME
	 */
	public java.sql.Timestamp getUpdateTime () {
		return updateTime;
	}

	/**
	 * Set the value related to the column: UPDATE_TIME
	 * @param updateTime the UPDATE_TIME value
	 */
	public void setUpdateTime (java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
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
	 * Return the value associated with the column: COLUMN_XML
	 */
	public java.lang.String getColumnXml () {
		return columnXml;
	}

	/**
	 * Set the value related to the column: COLUMN_XML
	 * @param columnXml the COLUMN_XML value
	 */
	public void setColumnXml (java.lang.String columnXml) {
		this.columnXml = columnXml;
	}


	/**
	 * Return the value associated with the column: BIZ_OBJECT
	 */
	public java.lang.String getBizObject () {
		return bizObject;
	}

	/**
	 * Set the value related to the column: BIZ_OBJECT
	 * @param bizObject the BIZ_OBJECT value
	 */
	public void setBizObject (java.lang.String bizObject) {
		this.bizObject = bizObject;
	}


	/**
	 * Return the value associated with the column: INIT_SCRIPT
	 */
	public java.lang.String getInitScript () {
		return initScript;
	}

	/**
	 * Set the value related to the column: INIT_SCRIPT
	 * @param initScript the INIT_SCRIPT value
	 */
	public void setInitScript (java.lang.String initScript) {
		this.initScript = initScript;
	}


	/**
	 * Return the value associated with the column: UPDATE_SCRIPT
	 */
	public java.lang.String getUpdateScript () {
		return updateScript;
	}

	/**
	 * Set the value related to the column: UPDATE_SCRIPT
	 * @param updateScript the UPDATE_SCRIPT value
	 */
	public void setUpdateScript (java.lang.String updateScript) {
		this.updateScript = updateScript;
	}


	/**
	 * Return the value associated with the column: FINISH_SCRIPT
	 */
	public java.lang.String getFinishScript () {
		return finishScript;
	}

	/**
	 * Set the value related to the column: FINISH_SCRIPT
	 * @param finishScript the FINISH_SCRIPT value
	 */
	public void setFinishScript (java.lang.String finishScript) {
		this.finishScript = finishScript;
	}


	/**
	 * Return the value associated with the column: VIEW_SWIMLANE_DEFINITION_ID
	 */
	public com.justonetech.biz.domain.BpmSwimlaneDefinition getViewSwimlaneDefinition () {
		return viewSwimlaneDefinition;
	}

	/**
	 * Set the value related to the column: VIEW_SWIMLANE_DEFINITION_ID
	 * @param viewSwimlaneDefinition the VIEW_SWIMLANE_DEFINITION_ID value
	 */
	public void setViewSwimlaneDefinition (com.justonetech.biz.domain.BpmSwimlaneDefinition viewSwimlaneDefinition) {
		this.viewSwimlaneDefinition = viewSwimlaneDefinition;
	}


	/**
	 * Return the value associated with the column: FILE_CATEGORY_ID
	 */
	public com.justonetech.biz.domain.DocCategory getFileCategory () {
		return fileCategory;
	}

	/**
	 * Set the value related to the column: FILE_CATEGORY_ID
	 * @param fileCategory the FILE_CATEGORY_ID value
	 */
	public void setFileCategory (com.justonetech.biz.domain.DocCategory fileCategory) {
		this.fileCategory = fileCategory;
	}


	/**
	 * Return the value associated with the column: PROCESS_TEMPLATE_ID
	 */
	public com.justonetech.biz.domain.BpmProcessTemplate getProcessTemplate () {
		return processTemplate;
	}

	/**
	 * Set the value related to the column: PROCESS_TEMPLATE_ID
	 * @param processTemplate the PROCESS_TEMPLATE_ID value
	 */
	public void setProcessTemplate (com.justonetech.biz.domain.BpmProcessTemplate processTemplate) {
		this.processTemplate = processTemplate;
	}

    public SysCodeDetail getCategory() {
        return category;
    }

    public void setCategory(SysCodeDetail category) {
        this.category = category;
    }

    /**
	 * Return the value associated with the column: bpmNodeDefinitions
	 */
	public java.util.Set<com.justonetech.biz.domain.BpmNodeDefinition> getBpmNodeDefinitions () {
		if(bpmNodeDefinitions == null){
			bpmNodeDefinitions = new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmNodeDefinition>();
		}
		return bpmNodeDefinitions;
	}

	/**
	 * Set the value related to the column: bpmNodeDefinitions
	 * @param bpmNodeDefinitions the bpmNodeDefinitions value
	 */
	public void setBpmNodeDefinitions (java.util.Set<com.justonetech.biz.domain.BpmNodeDefinition> bpmNodeDefinitions) {
		this.bpmNodeDefinitions = bpmNodeDefinitions;
	}

	public void addTobpmNodeDefinitions (com.justonetech.biz.domain.BpmNodeDefinition bpmNodeDefinition) {
		if (null == getBpmNodeDefinitions()) setBpmNodeDefinitions(new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmNodeDefinition>());
		getBpmNodeDefinitions().add(bpmNodeDefinition);
	}


	/**
	 * Return the value associated with the column: bpmProcessInstances
	 */
	public java.util.Set<com.justonetech.biz.domain.BpmProcessInstance> getBpmProcessInstances () {
		if(bpmProcessInstances == null){
			bpmProcessInstances = new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmProcessInstance>();
		}
		return bpmProcessInstances;
	}

	/**
	 * Set the value related to the column: bpmProcessInstances
	 * @param bpmProcessInstances the bpmProcessInstances value
	 */
	public void setBpmProcessInstances (java.util.Set<com.justonetech.biz.domain.BpmProcessInstance> bpmProcessInstances) {
		this.bpmProcessInstances = bpmProcessInstances;
	}

	public void addTobpmProcessInstances (com.justonetech.biz.domain.BpmProcessInstance bpmProcessInstance) {
		if (null == getBpmProcessInstances()) setBpmProcessInstances(new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmProcessInstance>());
		getBpmProcessInstances().add(bpmProcessInstance);
	}


	/**
	 * Return the value associated with the column: bpmProcessDefinitionForms
	 */
	public java.util.Set<com.justonetech.biz.domain.BpmProcessDefinitionForm> getBpmProcessDefinitionForms () {
		if(bpmProcessDefinitionForms == null){
			bpmProcessDefinitionForms = new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmProcessDefinitionForm>();
		}
		return bpmProcessDefinitionForms;
	}

	/**
	 * Set the value related to the column: bpmProcessDefinitionForms
	 * @param bpmProcessDefinitionForms the bpmProcessDefinitionForms value
	 */
	public void setBpmProcessDefinitionForms (java.util.Set<com.justonetech.biz.domain.BpmProcessDefinitionForm> bpmProcessDefinitionForms) {
		this.bpmProcessDefinitionForms = bpmProcessDefinitionForms;
	}

	public void addTobpmProcessDefinitionForms (com.justonetech.biz.domain.BpmProcessDefinitionForm bpmProcessDefinitionForm) {
		if (null == getBpmProcessDefinitionForms()) setBpmProcessDefinitionForms(new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmProcessDefinitionForm>());
		getBpmProcessDefinitionForms().add(bpmProcessDefinitionForm);
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
	 * Return the value associated with the column: bpmProcessTransitions
	 */
	public java.util.Set<com.justonetech.biz.domain.BpmProcessTransition> getBpmProcessTransitions () {
		if(bpmProcessTransitions == null){
			bpmProcessTransitions = new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmProcessTransition>();
		}
		return bpmProcessTransitions;
	}

	/**
	 * Set the value related to the column: bpmProcessTransitions
	 * @param bpmProcessTransitions the bpmProcessTransitions value
	 */
	public void setBpmProcessTransitions (java.util.Set<com.justonetech.biz.domain.BpmProcessTransition> bpmProcessTransitions) {
		this.bpmProcessTransitions = bpmProcessTransitions;
	}

	public void addTobpmProcessTransitions (com.justonetech.biz.domain.BpmProcessTransition bpmProcessTransition) {
		if (null == getBpmProcessTransitions()) setBpmProcessTransitions(new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmProcessTransition>());
		getBpmProcessTransitions().add(bpmProcessTransition);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.BpmProcessDefinition)) return false;
		else {
			com.justonetech.biz.domain.BpmProcessDefinition bpmProcessDefinition = (com.justonetech.biz.domain.BpmProcessDefinition) obj;
			if (null == this.getId() || null == bpmProcessDefinition.getId()) return false;
			else return (this.getId().equals(bpmProcessDefinition.getId()));
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
		builder.append(jbpmDefinitionId);
		builder.append(code);
		builder.append(name);
		builder.append(version);
		builder.append(orderNo);
		builder.append(isValid);
		builder.append(description);
		builder.append(workId);
		builder.append(updateTime);
		builder.append(createTime);
		builder.append(columnXml);
		builder.append(bizObject);
		builder.append(initScript);
		builder.append(updateScript);
		builder.append(finishScript);
		return builder.toString();
	}


}