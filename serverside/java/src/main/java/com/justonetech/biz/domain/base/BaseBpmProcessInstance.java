package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BPM_PROCESS_INSTANCE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 业务流程实例表
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 业务流程实例表
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : workflow
 * Projectable : false
 *
 * @hibernate.class
 *  table="BPM_PROCESS_INSTANCE"
 */

public abstract class BaseBpmProcessInstance  implements Serializable,Auditable {

	public static String REF = "BpmProcessInstance";
	public static String PROP_PERSON_NAME = "personName";
	public static String PROP_BIZ_DATA1 = "bizData1";
	public static String PROP_BIZ_DATA2 = "bizData2";
	public static String PROP_BIZ_DATA3 = "bizData3";
	public static String PROP_BIZ_DATA4 = "bizData4";
	public static String PROP_BIZ_DATA5 = "bizData5";
	public static String PROP_JBPM_PROCESS_INSTANCE_ID = "jbpmProcessInstanceId";
	public static String PROP_BIZ_OBJECT_ID = "bizObjectId";
	public static String PROP_CODE = "code";
	public static String PROP_TITLE = "title";
	public static String PROP_PROCESS_DEFINITION = "processDefinition";
	public static String PROP_STATUS = "status";
	public static String PROP_CC_USER_IDS = "ccUserIds";
	public static String PROP_DEPT_NAME = "deptName";
	public static String PROP_REPORT_DATE = "reportDate";
	public static String PROP_ID = "id";
	public static String PROP_END_TIME = "endTime";
	public static String PROP_START_TIME = "startTime";
	public static String PROP_CONTENT = "content";
    public static String PROP_CREATE_USER = "createUser";
    public static String PROP_UPDATE_USER = "updateUser";
    public static String PROP_CREATE_TIME = "createTime";
    public static String PROP_UPDATE_TIME = "updateTime";

	// constructors
	public BaseBpmProcessInstance () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBpmProcessInstance (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*JBPM业务流程实例ID*/
    /*JBPM业务流程实例ID*/
	private java.lang.Long jbpmProcessInstanceId;
	
    /*业务编号*/
    /*业务编号*/
	private java.lang.String code;
	
    /*业务名称*/
    /*业务名称*/
	private java.lang.String title;
	
    /*开始时间*/
    /*开始时间*/
	private java.sql.Timestamp startTime;
	
    /*结束时间*/
    /*结束时间*/
	private java.sql.Timestamp endTime;
	
    /*状态*/
    /*状态*/
	private java.lang.String status;
	
    /*填写日期*/
    /*填写日期*/
	private java.sql.Date reportDate;
	
    /*单位名称*/
    /*单位名称*/
	private java.lang.String deptName;
	
    /*填写人*/
    /*填写人*/
	private java.lang.String personName;
	
    /*内容提要*/
    /*内容提要*/
	private java.lang.String content;
	
    /*BIZ_DATA1*/
    /*BIZ_DATA1*/
	private java.lang.String bizData1;
	
    /*BIZ_DATA2*/
    /*BIZ_DATA1*/
	private java.lang.String bizData2;
	
    /*BIZ_DATA3*/
    /*BIZ_DATA1*/
	private java.lang.String bizData3;
	
    /*BIZ_DATA4*/
    /*BIZ_DATA1*/
	private java.lang.String bizData4;
	
    /*BIZ_DATA5*/
    /*BIZ_DATA1*/
	private java.lang.String bizData5;
	
    /*业务对象ID*/
    /*业务对象ID*/
	private java.lang.Long bizObjectId;
	
    /*抄送用户ID集合*/
    /*抄送用户ID集合*/
	private java.lang.String ccUserIds;

    /*创建时间*/
    /*创建时间*/
	private java.sql.Timestamp createTime;

    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updateTime;

    /*更新人*/
    /*更新人*/
	private java.lang.String updateUser;

    /*创建人*/
    /*创建人*/
	private java.lang.String createUser;
	

	// many to one
	private com.justonetech.biz.domain.BpmProcessDefinition processDefinition;

	// collections
	private java.util.Set<com.justonetech.biz.domain.BpmStandardAction> bpmStandardActions;
	private java.util.Set<com.justonetech.biz.domain.BpmFormData> bpmFormDatas;
	private java.util.Set<com.justonetech.biz.domain.BpmTaskInstance> bpmTaskInstances;
	private java.util.Set<com.justonetech.biz.domain.BpmFormAction> bpmFormActions;



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
	 * Return the value associated with the column: JBPM_PROCESS_INSTANCE_ID
	 */
	public java.lang.Long getJbpmProcessInstanceId () {
		return jbpmProcessInstanceId;
	}

	/**
	 * Set the value related to the column: JBPM_PROCESS_INSTANCE_ID
	 * @param jbpmProcessInstanceId the JBPM_PROCESS_INSTANCE_ID value
	 */
	public void setJbpmProcessInstanceId (java.lang.Long jbpmProcessInstanceId) {
		this.jbpmProcessInstanceId = jbpmProcessInstanceId;
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
	 * Return the value associated with the column: TITLE
	 */
	public java.lang.String getTitle () {
		return title;
	}

	/**
	 * Set the value related to the column: TITLE
	 * @param title the TITLE value
	 */
	public void setTitle (java.lang.String title) {
		this.title = title;
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
	 * Return the value associated with the column: REPORT_DATE
	 */
	public java.sql.Date getReportDate () {
		return reportDate;
	}

	/**
	 * Set the value related to the column: REPORT_DATE
	 * @param reportDate the REPORT_DATE value
	 */
	public void setReportDate (java.sql.Date reportDate) {
		this.reportDate = reportDate;
	}


	/**
	 * Return the value associated with the column: DEPT_NAME
	 */
	public java.lang.String getDeptName () {
		return deptName;
	}

	/**
	 * Set the value related to the column: DEPT_NAME
	 * @param deptName the DEPT_NAME value
	 */
	public void setDeptName (java.lang.String deptName) {
		this.deptName = deptName;
	}


	/**
	 * Return the value associated with the column: PERSON_NAME
	 */
	public java.lang.String getPersonName () {
		return personName;
	}

	/**
	 * Set the value related to the column: PERSON_NAME
	 * @param personName the PERSON_NAME value
	 */
	public void setPersonName (java.lang.String personName) {
		this.personName = personName;
	}


	/**
	 * Return the value associated with the column: CONTENT
	 */
	public java.lang.String getContent () {
		return content;
	}

	/**
	 * Set the value related to the column: CONTENT
	 * @param content the CONTENT value
	 */
	public void setContent (java.lang.String content) {
		this.content = content;
	}


	/**
	 * Return the value associated with the column: BIZ_DATA1
	 */
	public java.lang.String getBizData1 () {
		return bizData1;
	}

	/**
	 * Set the value related to the column: BIZ_DATA1
	 * @param bizData1 the BIZ_DATA1 value
	 */
	public void setBizData1 (java.lang.String bizData1) {
		this.bizData1 = bizData1;
	}


	/**
	 * Return the value associated with the column: BIZ_DATA2
	 */
	public java.lang.String getBizData2 () {
		return bizData2;
	}

	/**
	 * Set the value related to the column: BIZ_DATA2
	 * @param bizData2 the BIZ_DATA2 value
	 */
	public void setBizData2 (java.lang.String bizData2) {
		this.bizData2 = bizData2;
	}


	/**
	 * Return the value associated with the column: BIZ_DATA3
	 */
	public java.lang.String getBizData3 () {
		return bizData3;
	}

	/**
	 * Set the value related to the column: BIZ_DATA3
	 * @param bizData3 the BIZ_DATA3 value
	 */
	public void setBizData3 (java.lang.String bizData3) {
		this.bizData3 = bizData3;
	}


	/**
	 * Return the value associated with the column: BIZ_DATA4
	 */
	public java.lang.String getBizData4 () {
		return bizData4;
	}

	/**
	 * Set the value related to the column: BIZ_DATA4
	 * @param bizData4 the BIZ_DATA4 value
	 */
	public void setBizData4 (java.lang.String bizData4) {
		this.bizData4 = bizData4;
	}


	/**
	 * Return the value associated with the column: BIZ_DATA5
	 */
	public java.lang.String getBizData5 () {
		return bizData5;
	}

	/**
	 * Set the value related to the column: BIZ_DATA5
	 * @param bizData5 the BIZ_DATA5 value
	 */
	public void setBizData5 (java.lang.String bizData5) {
		this.bizData5 = bizData5;
	}


	/**
	 * Return the value associated with the column: BIZ_OBJECT_ID
	 */
	public java.lang.Long getBizObjectId () {
		return bizObjectId;
	}

	/**
	 * Set the value related to the column: BIZ_OBJECT_ID
	 * @param bizObjectId the BIZ_OBJECT_ID value
	 */
	public void setBizObjectId (java.lang.Long bizObjectId) {
		this.bizObjectId = bizObjectId;
	}


	/**
	 * Return the value associated with the column: CC_USER_IDS
	 */
	public java.lang.String getCcUserIds () {
		return ccUserIds;
	}

	/**
	 * Set the value related to the column: CC_USER_IDS
	 * @param ccUserIds the CC_USER_IDS value
	 */
	public void setCcUserIds (java.lang.String ccUserIds) {
		this.ccUserIds = ccUserIds;
	}

    /**
	 * Return the value associated with the column: CREATE_TIME
     * @return .
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
	 * Return the value associated with the column: UPDATE_USER
	 */
	public java.lang.String getUpdateUser () {
		return updateUser;
	}

	/**
	 * Set the value related to the column: UPDATE_USER
	 * @param updateUser the UPDATE_USER value
	 */
	public void setUpdateUser (java.lang.String updateUser) {
		this.updateUser = updateUser;
	}


	/**
	 * Return the value associated with the column: CREATE_USER
	 */
	public java.lang.String getCreateUser () {
		return createUser;
	}

	/**
	 * Set the value related to the column: CREATE_USER
	 * @param createUser the CREATE_USER value
	 */
	public void setCreateUser (java.lang.String createUser) {
		this.createUser = createUser;
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
	 * Return the value associated with the column: bpmStandardActions
	 */
	public java.util.Set<com.justonetech.biz.domain.BpmStandardAction> getBpmStandardActions () {
		if(bpmStandardActions == null){
			bpmStandardActions = new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmStandardAction>();
		}
		return bpmStandardActions;
	}

	/**
	 * Set the value related to the column: bpmStandardActions
	 * @param bpmStandardActions the bpmStandardActions value
	 */
	public void setBpmStandardActions (java.util.Set<com.justonetech.biz.domain.BpmStandardAction> bpmStandardActions) {
		this.bpmStandardActions = bpmStandardActions;
	}

	public void addTobpmStandardActions (com.justonetech.biz.domain.BpmStandardAction bpmStandardAction) {
		if (null == getBpmStandardActions()) setBpmStandardActions(new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmStandardAction>());
		getBpmStandardActions().add(bpmStandardAction);
	}


	/**
	 * Return the value associated with the column: bpmFormDatas
	 */
	public java.util.Set<com.justonetech.biz.domain.BpmFormData> getBpmFormDatas () {
		if(bpmFormDatas == null){
			bpmFormDatas = new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmFormData>();
		}
		return bpmFormDatas;
	}

	/**
	 * Set the value related to the column: bpmFormDatas
	 * @param bpmFormDatas the bpmFormDatas value
	 */
	public void setBpmFormDatas (java.util.Set<com.justonetech.biz.domain.BpmFormData> bpmFormDatas) {
		this.bpmFormDatas = bpmFormDatas;
	}

	public void addTobpmFormDatas (com.justonetech.biz.domain.BpmFormData bpmFormData) {
		if (null == getBpmFormDatas()) setBpmFormDatas(new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmFormData>());
		getBpmFormDatas().add(bpmFormData);
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


	/**
	 * Return the value associated with the column: bpmFormActions
	 */
	public java.util.Set<com.justonetech.biz.domain.BpmFormAction> getBpmFormActions () {
		if(bpmFormActions == null){
			bpmFormActions = new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmFormAction>();
		}
		return bpmFormActions;
	}

	/**
	 * Set the value related to the column: bpmFormActions
	 * @param bpmFormActions the bpmFormActions value
	 */
	public void setBpmFormActions (java.util.Set<com.justonetech.biz.domain.BpmFormAction> bpmFormActions) {
		this.bpmFormActions = bpmFormActions;
	}

	public void addTobpmFormActions (com.justonetech.biz.domain.BpmFormAction bpmFormAction) {
		if (null == getBpmFormActions()) setBpmFormActions(new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmFormAction>());
		getBpmFormActions().add(bpmFormAction);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.BpmProcessInstance)) return false;
		else {
			com.justonetech.biz.domain.BpmProcessInstance bpmProcessInstance = (com.justonetech.biz.domain.BpmProcessInstance) obj;
			if (null == this.getId() || null == bpmProcessInstance.getId()) return false;
			else return (this.getId().equals(bpmProcessInstance.getId()));
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
		builder.append(jbpmProcessInstanceId);
		builder.append(code);
		builder.append(title);
		builder.append(startTime);
		builder.append(endTime);
		builder.append(status);
		builder.append(reportDate);
		builder.append(deptName);
		builder.append(personName);
		builder.append(content);
		builder.append(bizData1);
		builder.append(bizData2);
		builder.append(bizData3);
		builder.append(bizData4);
		builder.append(bizData5);
		builder.append(bizObjectId);
		builder.append(ccUserIds);
		builder.append(createUser);
		builder.append(updateUser);
		builder.append(createTime);
		builder.append(updateTime);
		return builder.toString();
	}


}