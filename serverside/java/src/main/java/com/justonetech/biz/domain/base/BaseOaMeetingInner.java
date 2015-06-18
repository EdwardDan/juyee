package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_MEETING_INNER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 内部会议
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 内部会议
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_MEETING_INNER"
 */

public abstract class BaseOaMeetingInner  implements Serializable {

	public static String REF = "OaMeetingInner";
	public static String PROP_DOC = "doc";
	public static String PROP_INNER_PERSONS = "innerPersons";
	public static String PROP_TYPE = "type";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_TITLE = "title";
	public static String PROP_OUTER_PERSONS = "outerPersons";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_BEGIN_TIME = "beginTime";
	public static String PROP_IS_VALID = "isValid";
	public static String PROP_ADDRESS = "address";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_ID = "id";
	public static String PROP_END_TIME = "endTime";
	public static String PROP_CONTENT = "content";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseOaMeetingInner () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaMeetingInner (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*会议开始时间*/
    /*会议开始时间*/
	private java.sql.Timestamp beginTime;
	
    /*会议结束时间*/
    /*会议结束时间*/
	private java.sql.Timestamp endTime;
	
    /*会议地点*/
    /*会议地点*/
	private String address;
	
    /*内部人员*/
    /*内部人员*/
	private String innerPersons;
	
    /*外部人员*/
    /*外部人员*/
	private String outerPersons;
	
    /*会议议题*/
    /*会议议题*/
	private String title;
	
    /*会议内容*/
    /*会议内容*/
	private String content;
	
    /*是否提交*/
    /*是否提交*/
	private Boolean isValid;
	
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
	private com.justonetech.system.domain.SysCodeDetail type;



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
	 * Return the value associated with the column: BEGIN_TIME
	 */
	public java.sql.Timestamp getBeginTime () {
		return beginTime;
	}

	/**
	 * Set the value related to the column: BEGIN_TIME
	 * @param beginTime the BEGIN_TIME value
	 */
	public void setBeginTime (java.sql.Timestamp beginTime) {
		this.beginTime = beginTime;
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
	 * Return the value associated with the column: ADDRESS
	 */
	public String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: ADDRESS
	 * @param address the ADDRESS value
	 */
	public void setAddress (String address) {
		this.address = address;
	}


	/**
	 * Return the value associated with the column: INNER_PERSONS
	 */
	public String getInnerPersons () {
		return innerPersons;
	}

	/**
	 * Set the value related to the column: INNER_PERSONS
	 * @param innerPersons the INNER_PERSONS value
	 */
	public void setInnerPersons (String innerPersons) {
		this.innerPersons = innerPersons;
	}


	/**
	 * Return the value associated with the column: OUTER_PERSONS
	 */
	public String getOuterPersons () {
		return outerPersons;
	}

	/**
	 * Set the value related to the column: OUTER_PERSONS
	 * @param outerPersons the OUTER_PERSONS value
	 */
	public void setOuterPersons (String outerPersons) {
		this.outerPersons = outerPersons;
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
	 * Return the value associated with the column: IS_VALID
	 */
	public Boolean getIsValid () {
		return isValid;
	}

	/**
	 * Set the value related to the column: IS_VALID
	 * @param isValid the IS_VALID value
	 */
	public void setIsValid (Boolean isValid) {
		this.isValid = isValid;
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
	 * Return the value associated with the column: TYPE_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getType () {
		return type;
	}

	/**
	 * Set the value related to the column: TYPE_ID
	 * @param type the TYPE_ID value
	 */
	public void setType (com.justonetech.system.domain.SysCodeDetail type) {
		this.type = type;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaMeetingInner)) return false;
		else {
			com.justonetech.biz.domain.OaMeetingInner oaMeetingInner = (com.justonetech.biz.domain.OaMeetingInner) obj;
			if (null == this.getId() || null == oaMeetingInner.getId()) return false;
			else return (this.getId().equals(oaMeetingInner.getId()));
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
		builder.append(beginTime);
		builder.append(endTime);
		builder.append(address);
		builder.append(innerPersons);
		builder.append(outerPersons);
		builder.append(title);
		builder.append(content);
		builder.append(isValid);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}