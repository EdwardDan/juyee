package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_WEEK_ARRANGE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 领导一周安排
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 领导一周安排
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_WEEK_ARRANGE"
 */

public abstract class BaseOaWeekArrange  implements Serializable {

	public static String REF = "OaWeekArrange";
	public static String PROP_USER = "user";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_IS_REST = "isRest";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_TIME_PERIOD = "timePeriod";
	public static String PROP_CONTENT = "content";
	public static String PROP_DAY = "day";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseOaWeekArrange () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaWeekArrange (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*日期*/
    /*日期*/
	private java.sql.Date day;
	
    /*事项*/
    /*事项*/
	private String content;
	
    /*是否休息*/
    /*是否休息*/
	private Boolean isRest;
	
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
	private com.justonetech.system.domain.SysCodeDetail timePeriod;
	private com.justonetech.system.domain.SysUser user;



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
	 * Return the value associated with the column: DAY
	 */
	public java.sql.Date getDay () {
		return day;
	}

	/**
	 * Set the value related to the column: DAY
	 * @param day the DAY value
	 */
	public void setDay (java.sql.Date day) {
		this.day = day;
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
	 * Return the value associated with the column: IS_REST
	 */
	public Boolean getIsRest () {
		return isRest;
	}

	/**
	 * Set the value related to the column: IS_REST
	 * @param isRest the IS_REST value
	 */
	public void setIsRest (Boolean isRest) {
		this.isRest = isRest;
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
	 * Return the value associated with the column: TIME_PERIOD
	 */
	public com.justonetech.system.domain.SysCodeDetail getTimePeriod () {
		return timePeriod;
	}

	/**
	 * Set the value related to the column: TIME_PERIOD
	 * @param timePeriod the TIME_PERIOD value
	 */
	public void setTimePeriod (com.justonetech.system.domain.SysCodeDetail timePeriod) {
		this.timePeriod = timePeriod;
	}


	/**
	 * Return the value associated with the column: USER_ID
	 */
	public com.justonetech.system.domain.SysUser getUser () {
		return user;
	}

	/**
	 * Set the value related to the column: USER_ID
	 * @param user the USER_ID value
	 */
	public void setUser (com.justonetech.system.domain.SysUser user) {
		this.user = user;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaWeekArrange)) return false;
		else {
			com.justonetech.biz.domain.OaWeekArrange oaWeekArrange = (com.justonetech.biz.domain.OaWeekArrange) obj;
			if (null == this.getId() || null == oaWeekArrange.getId()) return false;
			else return (this.getId().equals(oaWeekArrange.getId()));
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
		builder.append(day);
		builder.append(content);
		builder.append(isRest);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}