package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_EXPERTISE_USER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 专业知识学习参与人员
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 专业知识学习参与人员
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_EXPERTISE_USER"
 */

public abstract class BaseOaExpertiseUser  implements Serializable,Auditable {

	public static String REF = "OaExpertiseUser";
	public static String PROP_USER = "user";
	public static String PROP_EXPERTISE = "expertise";
	public static String PROP_IS_READ = "isRead";
	public static String PROP_ID = "id";
	public static String PROP_READ_TIME = "readTime";


	// constructors
	public BaseOaExpertiseUser () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaExpertiseUser (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*是否已读*/
    /*是否已读*/
	private java.lang.Boolean isRead;
	
    /*阅读时间*/
    /*阅读时间*/
	private java.sql.Timestamp readTime;
	

	// many to one
	private com.justonetech.biz.domain.OaExpertise expertise;
	private com.justonetech.system.domain.SysUser user;



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
	 * Return the value associated with the column: IS_READ
	 */
	public java.lang.Boolean getIsRead () {
		return isRead;
	}

	/**
	 * Set the value related to the column: IS_READ
	 * @param isRead the IS_READ value
	 */
	public void setIsRead (java.lang.Boolean isRead) {
		this.isRead = isRead;
	}


	/**
	 * Return the value associated with the column: READ_TIME
	 */
	public java.sql.Timestamp getReadTime () {
		return readTime;
	}

	/**
	 * Set the value related to the column: READ_TIME
	 * @param readTime the READ_TIME value
	 */
	public void setReadTime (java.sql.Timestamp readTime) {
		this.readTime = readTime;
	}


	/**
	 * Return the value associated with the column: EXPERTISE_ID
	 */
	public com.justonetech.biz.domain.OaExpertise getExpertise () {
		return expertise;
	}

	/**
	 * Set the value related to the column: EXPERTISE_ID
	 * @param expertise the EXPERTISE_ID value
	 */
	public void setExpertise (com.justonetech.biz.domain.OaExpertise expertise) {
		this.expertise = expertise;
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
		if (!(obj instanceof com.justonetech.biz.domain.OaExpertiseUser)) return false;
		else {
			com.justonetech.biz.domain.OaExpertiseUser oaExpertiseUser = (com.justonetech.biz.domain.OaExpertiseUser) obj;
			if (null == this.getId() || null == oaExpertiseUser.getId()) return false;
			else return (this.getId().equals(oaExpertiseUser.getId()));
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
		builder.append(isRead);
		builder.append(readTime);
		return builder.toString();
	}


}