package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_MAIL_GROUP_USER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 邮件分组用户
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 邮件分组用户
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_MAIL_GROUP_USER"
 */

public abstract class BaseOaMailGroupUser  implements Serializable {

	public static String REF = "OaMailGroupUser";
	public static String PROP_USER = "user";
	public static String PROP_ID = "id";
	public static String PROP_GROUP = "group";


	// constructors
	public BaseOaMailGroupUser () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaMailGroupUser (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// many to one
	private com.justonetech.biz.domain.OaMailGroup group;
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
	 * Return the value associated with the column: GROUP_ID
	 */
	public com.justonetech.biz.domain.OaMailGroup getGroup () {
		return group;
	}

	/**
	 * Set the value related to the column: GROUP_ID
	 * @param group the GROUP_ID value
	 */
	public void setGroup (com.justonetech.biz.domain.OaMailGroup group) {
		this.group = group;
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
		if (!(obj instanceof com.justonetech.biz.domain.OaMailGroupUser)) return false;
		else {
			com.justonetech.biz.domain.OaMailGroupUser oaMailGroupUser = (com.justonetech.biz.domain.OaMailGroupUser) obj;
			if (null == this.getId() || null == oaMailGroupUser.getId()) return false;
			else return (this.getId().equals(oaMailGroupUser.getId()));
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
		return builder.toString();
	}


}