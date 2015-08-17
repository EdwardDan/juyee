package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_WORK_WATCH_SUM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 工作督办汇总
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 工作督办汇总
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_WORK_WATCH_SUM"
 */

public abstract class BaseOaWorkWatchSum  implements Serializable,Auditable
{

	public static String REF = "OaWorkWatchSum";
	public static String PROP_YEAR = "year";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_WEEK = "week";
	public static String PROP_END_DATE = "endDate";
	public static String PROP_BEGIN_DATE = "beginDate";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_WORK_WATCH = "workWatch";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_MONTH = "month";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseOaWorkWatchSum () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaWorkWatchSum (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*年*/
    /*年*/
	private Integer year;
	
    /*月*/
    /*月*/
	private Integer month;
	
    /*周*/
    /*周*/
	private Integer week;
	
    /*开始日*/
    /*开始日*/
	private Integer beginDate;
	
    /*结束日*/
    /*结束日*/
	private Integer endDate;
	
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
	private com.justonetech.biz.domain.OaWorkWatch workWatch;



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
	 * Return the value associated with the column: WEEK
	 */
	public Integer getWeek () {
		return week;
	}

	/**
	 * Set the value related to the column: WEEK
	 * @param week the WEEK value
	 */
	public void setWeek (Integer week) {
		this.week = week;
	}


	/**
	 * Return the value associated with the column: BEGIN_DATE
	 */
	public Integer getBeginDate () {
		return beginDate;
	}

	/**
	 * Set the value related to the column: BEGIN_DATE
	 * @param beginDate the BEGIN_DATE value
	 */
	public void setBeginDate (Integer beginDate) {
		this.beginDate = beginDate;
	}


	/**
	 * Return the value associated with the column: END_DATE
	 */
	public Integer getEndDate () {
		return endDate;
	}

	/**
	 * Set the value related to the column: END_DATE
	 * @param endDate the END_DATE value
	 */
	public void setEndDate (Integer endDate) {
		this.endDate = endDate;
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
	 * Return the value associated with the column: WORK_WATCH_ID
	 */
	public com.justonetech.biz.domain.OaWorkWatch getWorkWatch () {
		return workWatch;
	}

	/**
	 * Set the value related to the column: WORK_WATCH_ID
	 * @param workWatch the WORK_WATCH_ID value
	 */
	public void setWorkWatch (com.justonetech.biz.domain.OaWorkWatch workWatch) {
		this.workWatch = workWatch;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaWorkWatchSum)) return false;
		else {
			com.justonetech.biz.domain.OaWorkWatchSum oaWorkWatchSum = (com.justonetech.biz.domain.OaWorkWatchSum) obj;
			if (null == this.getId() || null == oaWorkWatchSum.getId()) return false;
			else return (this.getId().equals(oaWorkWatchSum.getId()));
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
		builder.append(week);
		builder.append(beginDate);
		builder.append(endDate);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}