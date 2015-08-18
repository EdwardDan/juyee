package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_RECEIVE_NODE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 收文管理流转节点
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 收文管理流转节点
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_RECEIVE_NODE"
 */

public abstract class BaseOaReceiveNode  implements Serializable ,Auditable {

	public static String REF = "OaReceiveNode";
    public static String PROP_ID = "id";
    public static String PROP_OPERATION = "operation";
    public static String PROP_DEAL_DEPT = "dealDept";
    public static String PROP_DEAL_RESULT = "dealResult";
    public static String PROP_RECEIVE_TIME = "receiveTime";
    public static String PROP_COMPLETE_TIME = "completeTime";
    public static String PROP_OPEN_TIME = "openTime";
    public static String PROP_OA_RECEIVE = "oaReceive";
    public static String PROP_DEAL_USER = "dealUser";
    public static String PROP_STEP_ID = "stepId";
    public static String PROP_IS_DEAL = "isDeal";
    public static String PROP_CREATE_USER = "createUser";
    public static String PROP_CREATE_TIME = "createTime";
    public static String PROP_UPDATE_USER = "updateUser";
    public static String PROP_UPDATE_TIME = "updateTime";


	// constructors
	public BaseOaReceiveNode () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaReceiveNode (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*流转步骤ID*/
    /*流转步骤ID*/
	private Long stepId;
	
    /*是否处理*/
    /*是否处理*/
	private Boolean isDeal;
	
    /*处理人*/
    /*处理人*/
	private String dealUser;
	
    /*处理结果*/
    /*处理结果*/
	private String dealResult;
	
    /*收到时间*/
    /*收到时间*/
	private java.sql.Timestamp receiveTime;
	
    /*打开时间*/
    /*打开时间*/
	private java.sql.Timestamp openTime;
	
    /*处理完成时间*/
    /*处理完成时间*/
	private java.sql.Timestamp completeTime;
	
    /*创建时间*/
    /*创建时间*/
	private java.sql.Timestamp createTime;
	
    /*创建用户名*/
    /*创建用户名*/
	private String createUser;
	
    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updateTime;
	
    /*更新用户名*/
    /*更新用户名*/
	private String updateUser;
	

	// many to one
	private com.justonetech.system.domain.SysDept dealDept;
	private com.justonetech.biz.domain.OaReceive oaReceive;
	private com.justonetech.biz.domain.OaReceiveOperation operation;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="com.justonetech.core.orm.hibernate.LongIdGenerator"
     *  column="ID"
     */
	public Long getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 * @deprecated
	 */
	public void setId (Long id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: STEP_ID
	 */
	public Long getStepId () {
		return stepId;
	}

	/**
	 * Set the value related to the column: STEP_ID
	 * @param stepId the STEP_ID value
	 */
	public void setStepId (Long stepId) {
		this.stepId = stepId;
	}


	/**
	 * Return the value associated with the column: IS_DEAL
	 */
	public Boolean getIsDeal () {
		return isDeal;
	}

	/**
	 * Set the value related to the column: IS_DEAL
	 * @param isDeal the IS_DEAL value
	 */
	public void setIsDeal (Boolean isDeal) {
		this.isDeal = isDeal;
	}


	/**
	 * Return the value associated with the column: DEAL_USER
	 */
	public String getDealUser () {
		return dealUser;
	}

	/**
	 * Set the value related to the column: DEAL_USER
	 * @param dealUser the DEAL_USER value
	 */
	public void setDealUser (String dealUser) {
		this.dealUser = dealUser;
	}


	/**
	 * Return the value associated with the column: DEAL_RESULT
	 */
	public String getDealResult () {
		return dealResult;
	}

	/**
	 * Set the value related to the column: DEAL_RESULT
	 * @param dealResult the DEAL_RESULT value
	 */
	public void setDealResult (String dealResult) {
		this.dealResult = dealResult;
	}


	/**
	 * Return the value associated with the column: RECEIVE_TIME
	 */
	public java.sql.Timestamp getReceiveTime () {
		return receiveTime;
	}

	/**
	 * Set the value related to the column: RECEIVE_TIME
	 * @param receiveTime the RECEIVE_TIME value
	 */
	public void setReceiveTime (java.sql.Timestamp receiveTime) {
		this.receiveTime = receiveTime;
	}


	/**
	 * Return the value associated with the column: OPEN_TIME
	 */
	public java.sql.Timestamp getOpenTime () {
		return openTime;
	}

	/**
	 * Set the value related to the column: OPEN_TIME
	 * @param openTime the OPEN_TIME value
	 */
	public void setOpenTime (java.sql.Timestamp openTime) {
		this.openTime = openTime;
	}


	/**
	 * Return the value associated with the column: COMPLETE_TIME
	 */
	public java.sql.Timestamp getCompleteTime () {
		return completeTime;
	}

	/**
	 * Set the value related to the column: COMPLETE_TIME
	 * @param completeTime the COMPLETE_TIME value
	 */
	public void setCompleteTime (java.sql.Timestamp completeTime) {
		this.completeTime = completeTime;
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
	 * Return the value associated with the column: CREATE_USER
	 */
	public String getCreateUser () {
		return createUser;
	}

	/**
	 * Set the value related to the column: CREATE_USER
	 * @param createUser the CREATE_USER value
	 */
	public void setCreateUser (String createUser) {
		this.createUser = createUser;
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
	public String getUpdateUser () {
		return updateUser;
	}

	/**
	 * Set the value related to the column: UPDATE_USER
	 * @param updateUser the UPDATE_USER value
	 */
	public void setUpdateUser (String updateUser) {
		this.updateUser = updateUser;
	}


	/**
	 * Return the value associated with the column: DEAL_DEPT_ID
	 */
	public com.justonetech.system.domain.SysDept getDealDept () {
		return dealDept;
	}

	/**
	 * Set the value related to the column: DEAL_DEPT_ID
	 * @param dealDept the DEAL_DEPT_ID value
	 */
	public void setDealDept (com.justonetech.system.domain.SysDept dealDept) {
		this.dealDept = dealDept;
	}


	/**
	 * Return the value associated with the column: OA_RECEIVE_ID
	 */
	public com.justonetech.biz.domain.OaReceive getOaReceive () {
		return oaReceive;
	}

	/**
	 * Set the value related to the column: OA_RECEIVE_ID
	 * @param oaReceive the OA_RECEIVE_ID value
	 */
	public void setOaReceive (com.justonetech.biz.domain.OaReceive oaReceive) {
		this.oaReceive = oaReceive;
	}


	/**
	 * Return the value associated with the column: OPERATION_ID
	 */
	public com.justonetech.biz.domain.OaReceiveOperation getOperation () {
		return operation;
	}

	/**
	 * Set the value related to the column: OPERATION_ID
	 * @param operation the OPERATION_ID value
	 */
	public void setOperation (com.justonetech.biz.domain.OaReceiveOperation operation) {
		this.operation = operation;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaReceiveNode)) return false;
		else {
			com.justonetech.biz.domain.OaReceiveNode oaReceiveNode = (com.justonetech.biz.domain.OaReceiveNode) obj;
			if (null == this.getId() || null == oaReceiveNode.getId()) return false;
			else return (this.getId().equals(oaReceiveNode.getId()));
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
		builder.append(stepId);
		builder.append(isDeal);
		builder.append(dealUser);
		builder.append(dealResult);
		builder.append(receiveTime);
		builder.append(openTime);
		builder.append(completeTime);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}