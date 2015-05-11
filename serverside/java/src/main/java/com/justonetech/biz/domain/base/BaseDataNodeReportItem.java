package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the DATA_NODE_REPORT_ITEM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 形象进度推进填报明细
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 形象进度推进填报明细
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : data
 * Projectable : false
 *
 * @hibernate.class
 *  table="DATA_NODE_REPORT_ITEM"
 */

public abstract class BaseDataNodeReportItem  implements Serializable ,Auditable{

	public static String REF = "DataNodeReportItem";
	public static String PROP_STEP = "step";
	public static String PROP_STAGE_REPORT = "nodeReport";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_PROBLEM = "problem";
	public static String PROP_NODE = "node";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_CONTENT = "content";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseDataNodeReportItem () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDataNodeReportItem (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*本月完成情况*/
    /*本月完成情况*/
	private String content;
	
    /*本月存在问题*/
    /*本月存在问题*/
	private String problem;
	
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
	private com.justonetech.biz.domain.ProjNode node;
	private com.justonetech.biz.domain.DataNodeReport nodeReport;
	private com.justonetech.system.domain.SysCodeDetail step;



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
	 * Return the value associated with the column: CONTENT
	 */
	public String getContent () {
		return content;
	}

	/**
	 * Set the value related to the column: CONTENT
	 * @param content the CONTENT value
	 */
	public void setContent (String content) {
		this.content = content;
	}


	/**
	 * Return the value associated with the column: PROBLEM
	 */
	public String getProblem () {
		return problem;
	}

	/**
	 * Set the value related to the column: PROBLEM
	 * @param problem the PROBLEM value
	 */
	public void setProblem (String problem) {
		this.problem = problem;
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
	 * Return the value associated with the column: NODE_ID
	 */
	public com.justonetech.biz.domain.ProjNode getNode () {
		return node;
	}

	/**
	 * Set the value related to the column: NODE_ID
	 * @param node the NODE_ID value
	 */
	public void setNode (com.justonetech.biz.domain.ProjNode node) {
		this.node = node;
	}


	/**
	 * Return the value associated with the column: STAGE_REPORT_ID
	 */
	public com.justonetech.biz.domain.DataNodeReport getNodeReport () {
		return nodeReport;
	}

	/**
	 * Set the value related to the column: STAGE_REPORT_ID
	 * @param nodeReport the STAGE_REPORT_ID value
	 */
	public void setNodeReport (com.justonetech.biz.domain.DataNodeReport nodeReport) {
		this.nodeReport = nodeReport;
	}


	/**
	 * Return the value associated with the column: STEP_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getStep () {
		return step;
	}

	/**
	 * Set the value related to the column: STEP_ID
	 * @param step the STEP_ID value
	 */
	public void setStep (com.justonetech.system.domain.SysCodeDetail step) {
		this.step = step;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.DataNodeReportItem)) return false;
		else {
			com.justonetech.biz.domain.DataNodeReportItem dataNodeReportItem = (com.justonetech.biz.domain.DataNodeReportItem) obj;
			if (null == this.getId() || null == dataNodeReportItem.getId()) return false;
			else return (this.getId().equals(dataNodeReportItem.getId()));
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
		builder.append(content);
		builder.append(problem);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}