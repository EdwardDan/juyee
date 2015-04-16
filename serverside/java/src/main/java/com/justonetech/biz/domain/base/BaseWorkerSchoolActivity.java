package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the WORKER_SCHOOL_ACTIVITY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 务工人员学校活动开展
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 务工人员学校活动开展
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : worker
 * Projectable : false
 *
 * @hibernate.class
 *  table="WORKER_SCHOOL_ACTIVITY"
 */

public abstract class BaseWorkerSchoolActivity  implements Serializable ,Auditable {

	public static String REF = "WorkerSchoolActivity";
	public static String PROP_ATTEND_COUNT = "attendCount";
	public static String PROP_DOC = "doc";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_OPEN_DATE = "openDate";
	public static String PROP_ID = "id";
	public static String PROP_PROPERTY = "property";
	public static String PROP_CONTENT = "content";
	public static String PROP_SCHOOL = "school";
	public static String PROP_TITLE = "title";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseWorkerSchoolActivity () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWorkerSchoolActivity (Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseWorkerSchoolActivity (
		Long id,
		com.justonetech.biz.domain.WorkerSchool school) {

		this.setId(id);
		this.setSchool(school);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*活动开展时间*/
    /*活动开展时间*/
	private java.sql.Date openDate;
	
    /*活动性质*/
    /*活动性质*/
	private String property;
	
    /*参加人数*/
    /*参加人数*/
	private Integer attendCount;
	
    /*活动主题*/
    /*活动主题*/
	private String title;
	
    /*活动内容*/
    /*活动内容*/
	private String content;
	
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
	private com.justonetech.biz.domain.DocDocument doc;
	private com.justonetech.biz.domain.WorkerSchool school;



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
	 * Return the value associated with the column: OPEN_DATE
	 */
	public java.sql.Date getOpenDate () {
		return openDate;
	}

	/**
	 * Set the value related to the column: OPEN_DATE
	 * @param openDate the OPEN_DATE value
	 */
	public void setOpenDate (java.sql.Date openDate) {
		this.openDate = openDate;
	}


	/**
	 * Return the value associated with the column: PROPERTY
	 */
	public String getProperty () {
		return property;
	}

	/**
	 * Set the value related to the column: PROPERTY
	 * @param property the PROPERTY value
	 */
	public void setProperty (String property) {
		this.property = property;
	}


	/**
	 * Return the value associated with the column: ATTEND_COUNT
	 */
	public Integer getAttendCount () {
		return attendCount;
	}

	/**
	 * Set the value related to the column: ATTEND_COUNT
	 * @param attendCount the ATTEND_COUNT value
	 */
	public void setAttendCount (Integer attendCount) {
		this.attendCount = attendCount;
	}


	/**
	 * Return the value associated with the column: TITLE
	 */
	public String getTitle () {
		return title;
	}

	/**
	 * Set the value related to the column: TITLE
	 * @param title the TITLE value
	 */
	public void setTitle (String title) {
		this.title = title;
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
	 * Return the value associated with the column: DOC_ID
	 */
	public com.justonetech.biz.domain.DocDocument getDoc () {
		return doc;
	}

	/**
	 * Set the value related to the column: DOC_ID
	 * @param doc the DOC_ID value
	 */
	public void setDoc (com.justonetech.biz.domain.DocDocument doc) {
		this.doc = doc;
	}


	/**
	 * Return the value associated with the column: SCHOOL_ID
	 */
	public com.justonetech.biz.domain.WorkerSchool getSchool () {
		return school;
	}

	/**
	 * Set the value related to the column: SCHOOL_ID
	 * @param school the SCHOOL_ID value
	 */
	public void setSchool (com.justonetech.biz.domain.WorkerSchool school) {
		this.school = school;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.WorkerSchoolActivity)) return false;
		else {
			com.justonetech.biz.domain.WorkerSchoolActivity workerSchoolActivity = (com.justonetech.biz.domain.WorkerSchoolActivity) obj;
			if (null == this.getId() || null == workerSchoolActivity.getId()) return false;
			else return (this.getId().equals(workerSchoolActivity.getId()));
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
		builder.append(openDate);
		builder.append(property);
		builder.append(attendCount);
		builder.append(title);
		builder.append(content);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}