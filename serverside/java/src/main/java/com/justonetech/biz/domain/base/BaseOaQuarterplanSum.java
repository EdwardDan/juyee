package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_QUARTERPLAN_SUM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 季度年度总结计划汇总
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 季度年度总结计划汇总
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_QUARTERPLAN_SUM"
 */

public abstract class BaseOaQuarterplanSum  implements Serializable {

	public static String REF = "OaQuarterplanSum";
	public static String PROP_PERIOD = "period";
	public static String PROP_DOCUMENT = "document";
	public static String PROP_LEADER_OPINION = "leaderOpinion";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_LEADER_AUDIT_USER = "leaderAuditUser";
	public static String PROP_YEAR = "year";
	public static String PROP_STATUS = "status";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_REPORT_DATE = "reportDate";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_ID = "id";
	public static String PROP_LEADER_AUDIT_TIME = "leaderAuditTime";
	public static String PROP_UPDATE_USER = "updateUser";
	public static String PROP_SUM_CONTENT = "sumContent";


	// constructors
	public BaseOaQuarterplanSum () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaQuarterplanSum (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*报告年份*/
    /*报告年份*/
	private Integer year;
	
    /*报告季度*/
    /*报告季度*/
	private Integer period;
	
    /*提交时间*/
    /*提交时间*/
	private java.sql.Date reportDate;
	
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

    /*总工作内容*/
    /*总工作内容*/
    private String sumContent;
	

	// many to one
	private com.justonetech.biz.domain.DocDocument document;

	// collections
	private java.util.Set<com.justonetech.biz.domain.OaQuarterplanSumItem> oaQuarterplanSumItems;



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
	 * Return the value associated with the column: YEAR
	 */
	public Integer getYear () {
		return year;
	}

	/**
	 * Set the value related to the column: YEAR
	 * @param year the YEAR value
	 */
	public void setYear (Integer year) {
		this.year = year;
	}


	/**
	 * Return the value associated with the column: PERIOD
	 */
	public Integer getPeriod () {
		return period;
	}

	/**
	 * Set the value related to the column: PERIOD
	 * @param period the PERIOD value
	 */
	public void setPeriod (Integer period) {
		this.period = period;
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
     *
     * @return .
     */
    public String getSumContent() {
        return sumContent;
    }

    /**
     *
     * @param sumContent .
     */
    public void setSumContent(String sumContent) {
        this.sumContent = sumContent;
    }


	/**
	 * Return the value associated with the column: DOCUMENT_ID
	 */
	public com.justonetech.biz.domain.DocDocument getDocument () {
		return document;
	}

	/**
	 * Set the value related to the column: DOCUMENT_ID
	 * @param document the DOCUMENT_ID value
	 */
	public void setDocument (com.justonetech.biz.domain.DocDocument document) {
		this.document = document;
	}


	/**
	 * Return the value associated with the column: oaQuarterplanSumItems
	 */
	public java.util.Set<com.justonetech.biz.domain.OaQuarterplanSumItem> getOaQuarterplanSumItems () {
		if(oaQuarterplanSumItems == null){
			oaQuarterplanSumItems = new java.util.LinkedHashSet<com.justonetech.biz.domain.OaQuarterplanSumItem>();
		}
		return oaQuarterplanSumItems;
	}

	/**
	 * Set the value related to the column: oaQuarterplanSumItems
	 * @param oaQuarterplanSumItems the oaQuarterplanSumItems value
	 */
	public void setOaQuarterplanSumItems (java.util.Set<com.justonetech.biz.domain.OaQuarterplanSumItem> oaQuarterplanSumItems) {
		this.oaQuarterplanSumItems = oaQuarterplanSumItems;
	}

	public void addTooaQuarterplanSumItems (com.justonetech.biz.domain.OaQuarterplanSumItem oaQuarterplanSumItem) {
		if (null == getOaQuarterplanSumItems()) setOaQuarterplanSumItems(new java.util.LinkedHashSet<com.justonetech.biz.domain.OaQuarterplanSumItem>());
		getOaQuarterplanSumItems().add(oaQuarterplanSumItem);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaQuarterplanSum)) return false;
		else {
			com.justonetech.biz.domain.OaQuarterplanSum oaQuarterplanSum = (com.justonetech.biz.domain.OaQuarterplanSum) obj;
			if (null == this.getId() || null == oaQuarterplanSum.getId()) return false;
			else return (this.getId().equals(oaQuarterplanSum.getId()));
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
		builder.append(year);
		builder.append(period);
		builder.append(reportDate);
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