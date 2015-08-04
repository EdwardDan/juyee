package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_WORK_PLAN_SUM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 科室上报汇总
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 科室上报汇总
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_WORK_PLAN_SUM"
 */

public abstract class BaseOaWorkPlanSum  implements Serializable {

	public static String REF = "OaWorkPlanSum";
	public static String PROP_LEADER_AUDIT_USER = "leaderAuditUser";
	public static String PROP_STATUS = "status";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_LEADER_OPINION = "leaderOpinion";
	public static String PROP_DOCUMENT_ID = "documentId";
	public static String PROP_END_DATE = "endDate";
	public static String PROP_BEGIN_DATE = "beginDate";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_LEADER_AUDIT_TIME = "leaderAuditTime";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseOaWorkPlanSum () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaWorkPlanSum (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*上报开始时间*/
    /*上报开始时间*/
	private java.sql.Date beginDate;
	
    /*上报结束时间*/
    /*上报结束时间*/
	private java.sql.Date endDate;
	
    /*附件ID(预留)*/
    /*附件ID(预留)*/
	private Long documentId;
	
    /*状态*/
    /*状态*/
	private Integer status;
	
    /*领导审核意见*/
    /*领导审核意见*/
	private String leaderOpinion;
	
    /*领导审核时间*/
    /*领导审核时间*/
	private java.sql.Timestamp leaderAuditTime;
	
    /*领导审核用户名*/
    /*领导审核用户名*/
	private String leaderAuditUser;
	
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
	

	// collections
	private java.util.Set<com.justonetech.biz.domain.OaWorkPlanSumItem> oaWorkPlanSumItems;



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
	 * Return the value associated with the column: BEGIN_DATE
	 */
	public java.sql.Date getBeginDate () {
		return beginDate;
	}

	/**
	 * Set the value related to the column: BEGIN_DATE
	 * @param beginDate the BEGIN_DATE value
	 */
	public void setBeginDate (java.sql.Date beginDate) {
		this.beginDate = beginDate;
	}


	/**
	 * Return the value associated with the column: END_DATE
	 */
	public java.sql.Date getEndDate () {
		return endDate;
	}

	/**
	 * Set the value related to the column: END_DATE
	 * @param endDate the END_DATE value
	 */
	public void setEndDate (java.sql.Date endDate) {
		this.endDate = endDate;
	}


	/**
	 * Return the value associated with the column: DOCUMENT_ID
	 */
	public Long getDocumentId () {
		return documentId;
	}

	/**
	 * Set the value related to the column: DOCUMENT_ID
	 * @param documentId the DOCUMENT_ID value
	 */
	public void setDocumentId (Long documentId) {
		this.documentId = documentId;
	}


	/**
	 * Return the value associated with the column: STATUS
	 */
	public Integer getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (Integer status) {
		this.status = status;
	}


	/**
	 * Return the value associated with the column: LEADER_OPINION
	 */
	public String getLeaderOpinion () {
		return leaderOpinion;
	}

	/**
	 * Set the value related to the column: LEADER_OPINION
	 * @param leaderOpinion the LEADER_OPINION value
	 */
	public void setLeaderOpinion (String leaderOpinion) {
		this.leaderOpinion = leaderOpinion;
	}


	/**
	 * Return the value associated with the column: LEADER_AUDIT_TIME
	 */
	public java.sql.Timestamp getLeaderAuditTime () {
		return leaderAuditTime;
	}

	/**
	 * Set the value related to the column: LEADER_AUDIT_TIME
	 * @param leaderAuditTime the LEADER_AUDIT_TIME value
	 */
	public void setLeaderAuditTime (java.sql.Timestamp leaderAuditTime) {
		this.leaderAuditTime = leaderAuditTime;
	}


	/**
	 * Return the value associated with the column: LEADER_AUDIT_USER
	 */
	public String getLeaderAuditUser () {
		return leaderAuditUser;
	}

	/**
	 * Set the value related to the column: LEADER_AUDIT_USER
	 * @param leaderAuditUser the LEADER_AUDIT_USER value
	 */
	public void setLeaderAuditUser (String leaderAuditUser) {
		this.leaderAuditUser = leaderAuditUser;
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
	 * Return the value associated with the column: oaWorkPlanSumItems
	 */
	public java.util.Set<com.justonetech.biz.domain.OaWorkPlanSumItem> getOaWorkPlanSumItems () {
		if(oaWorkPlanSumItems == null){
			oaWorkPlanSumItems = new java.util.LinkedHashSet<com.justonetech.biz.domain.OaWorkPlanSumItem>();
		}
		return oaWorkPlanSumItems;
	}

	/**
	 * Set the value related to the column: oaWorkPlanSumItems
	 * @param oaWorkPlanSumItems the oaWorkPlanSumItems value
	 */
	public void setOaWorkPlanSumItems (java.util.Set<com.justonetech.biz.domain.OaWorkPlanSumItem> oaWorkPlanSumItems) {
		this.oaWorkPlanSumItems = oaWorkPlanSumItems;
	}

	public void addTooaWorkPlanSumItems (com.justonetech.biz.domain.OaWorkPlanSumItem oaWorkPlanSumItem) {
		if (null == getOaWorkPlanSumItems()) setOaWorkPlanSumItems(new java.util.LinkedHashSet<com.justonetech.biz.domain.OaWorkPlanSumItem>());
		getOaWorkPlanSumItems().add(oaWorkPlanSumItem);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaWorkPlanSum)) return false;
		else {
			com.justonetech.biz.domain.OaWorkPlanSum oaWorkPlanSum = (com.justonetech.biz.domain.OaWorkPlanSum) obj;
			if (null == this.getId() || null == oaWorkPlanSum.getId()) return false;
			else return (this.getId().equals(oaWorkPlanSum.getId()));
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
		builder.append(beginDate);
		builder.append(endDate);
		builder.append(documentId);
		builder.append(status);
		builder.append(leaderOpinion);
		builder.append(leaderAuditTime);
		builder.append(leaderAuditUser);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}