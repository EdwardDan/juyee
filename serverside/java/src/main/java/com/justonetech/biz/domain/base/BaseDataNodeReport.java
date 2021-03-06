package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the DATA_NODE_REPORT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 形象进度推进填报
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 形象进度推进填报
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : data
 * Projectable : true
 *
 * @hibernate.class
 *  table="DATA_NODE_REPORT"
 */

public abstract class BaseDataNodeReport  implements Serializable,Auditable {

	public static String REF = "DataNodeReport";
	public static String PROP_STEP = "step";
	public static String PROP_YEAR = "year";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_BID = "bid";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_PROJECT = "project";
	public static String PROP_MONTH = "month";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseDataNodeReport () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDataNodeReport (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*年份*/
    /*年份*/
	private Integer year;
	
    /*月份*/
    /*月份*/
	private Integer month;
	
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
	private com.justonetech.biz.domain.ProjBid bid;
	private com.justonetech.biz.domain.ProjInfo project;
	private com.justonetech.system.domain.SysCodeDetail step;

	// collections
	private java.util.Set<com.justonetech.biz.domain.DataNodeReportItem> dataNodeReportItems;



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
	 * Return the value associated with the column: MONTH
	 */
	public Integer getMonth () {
		return month;
	}

	/**
	 * Set the value related to the column: MONTH
	 * @param month the MONTH value
	 */
	public void setMonth (Integer month) {
		this.month = month;
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
	 * Return the value associated with the column: BID_ID
	 */
	public com.justonetech.biz.domain.ProjBid getBid () {
		return bid;
	}

	/**
	 * Set the value related to the column: BID_ID
	 * @param bid the BID_ID value
	 */
	public void setBid (com.justonetech.biz.domain.ProjBid bid) {
		this.bid = bid;
	}


	/**
	 * Return the value associated with the column: PROJECT_ID
	 */
	public com.justonetech.biz.domain.ProjInfo getProject () {
		return project;
	}

	/**
	 * Set the value related to the column: PROJECT_ID
	 * @param project the PROJECT_ID value
	 */
	public void setProject (com.justonetech.biz.domain.ProjInfo project) {
		this.project = project;
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


	/**
	 * Return the value associated with the column: dataNodeReportItems
	 */
	public java.util.Set<com.justonetech.biz.domain.DataNodeReportItem> getDataNodeReportItems () {
		if(dataNodeReportItems == null){
			dataNodeReportItems = new java.util.LinkedHashSet<com.justonetech.biz.domain.DataNodeReportItem>();
		}
		return dataNodeReportItems;
	}

	/**
	 * Set the value related to the column: dataNodeReportItems
	 * @param dataNodeReportItems the dataNodeReportItems value
	 */
	public void setDataNodeReportItems (java.util.Set<com.justonetech.biz.domain.DataNodeReportItem> dataNodeReportItems) {
		this.dataNodeReportItems = dataNodeReportItems;
	}

	public void addTodataNodeReportItems (com.justonetech.biz.domain.DataNodeReportItem dataNodeReportItem) {
		if (null == getDataNodeReportItems()) setDataNodeReportItems(new java.util.LinkedHashSet<com.justonetech.biz.domain.DataNodeReportItem>());
		getDataNodeReportItems().add(dataNodeReportItem);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.DataNodeReport)) return false;
		else {
			com.justonetech.biz.domain.DataNodeReport dataNodeReport = (com.justonetech.biz.domain.DataNodeReport) obj;
			if (null == this.getId() || null == dataNodeReport.getId()) return false;
			else return (this.getId().equals(dataNodeReport.getId()));
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
		builder.append(month);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}