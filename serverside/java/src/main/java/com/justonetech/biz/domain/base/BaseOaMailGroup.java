package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_MAIL_GROUP table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 邮件分组
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 邮件分组
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_MAIL_GROUP"
 */

public abstract class BaseOaMailGroup  implements Serializable,Auditable {

	public static String REF = "OaMailGroup";
	public static String PROP_NAME = "name";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseOaMailGroup () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaMailGroup (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*名称*/
    /*名称*/
	private java.lang.String name;
	
    /*备注*/
    /*备注*/
	private java.lang.String description;
	
    /*创建时间*/
    /*创建时间*/
	private java.sql.Timestamp createTime;
	
    /*创建用户名*/
    /*创建用户名*/
	private java.lang.String createUser;
	
    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updateTime;
	
    /*更新用户名*/
    /*更新用户名*/
	private java.lang.String updateUser;
	

	// collections
	private java.util.Set<com.justonetech.biz.domain.OaMailGroupUser> oaMailGroupUsers;



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
	 * Return the value associated with the column: NAME
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: NAME
	 * @param name the NAME value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}


	/**
	 * Return the value associated with the column: DESCRIPTION
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: DESCRIPTION
	 * @param description the DESCRIPTION value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
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
	 * Return the value associated with the column: oaMailGroupUsers
	 */
	public java.util.Set<com.justonetech.biz.domain.OaMailGroupUser> getOaMailGroupUsers () {
		if(oaMailGroupUsers == null){
			oaMailGroupUsers = new java.util.LinkedHashSet<com.justonetech.biz.domain.OaMailGroupUser>();
		}
		return oaMailGroupUsers;
	}

	/**
	 * Set the value related to the column: oaMailGroupUsers
	 * @param oaMailGroupUsers the oaMailGroupUsers value
	 */
	public void setOaMailGroupUsers (java.util.Set<com.justonetech.biz.domain.OaMailGroupUser> oaMailGroupUsers) {
		this.oaMailGroupUsers = oaMailGroupUsers;
	}

	public void addTooaMailGroupUsers (com.justonetech.biz.domain.OaMailGroupUser oaMailGroupUser) {
		if (null == getOaMailGroupUsers()) setOaMailGroupUsers(new java.util.LinkedHashSet<com.justonetech.biz.domain.OaMailGroupUser>());
		getOaMailGroupUsers().add(oaMailGroupUser);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaMailGroup)) return false;
		else {
			com.justonetech.biz.domain.OaMailGroup oaMailGroup = (com.justonetech.biz.domain.OaMailGroup) obj;
			if (null == this.getId() || null == oaMailGroup.getId()) return false;
			else return (this.getId().equals(oaMailGroup.getId()));
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
		builder.append(name);
		builder.append(description);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}