package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the POLLING_GROUP_USER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 工作组成员
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 工作组成员
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : polling
 * Projectable : false
 *
 * @hibernate.class
 *  table="POLLING_GROUP_USER"
 */

public abstract class BasePollingGroupUser implements Serializable {

	public static String REF = "PollingGroupUser";
	public static String PROP_USER = "user";
	public static String PROP_IS_CHARGE = "isCharge";
	public static String PROP_ID = "id";
	public static String PROP_GROUP = "group";


	// constructors
	public BasePollingGroupUser() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePollingGroupUser(Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*是否负责人*/
    /*是否负责人*/
	private Boolean isCharge;
	

	// many to one
	private com.justonetech.biz.domain.PollingWorkGroup group;
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
	 * Return the value associated with the column: IS_CHARGE
	 */
	public Boolean getIsCharge () {
		return isCharge;
	}

	/**
	 * Set the value related to the column: IS_CHARGE
	 * @param isCharge the IS_CHARGE value
	 */
	public void setIsCharge (Boolean isCharge) {
		this.isCharge = isCharge;
	}


	/**
	 * Return the value associated with the column: GROUP_ID
	 */
	public com.justonetech.biz.domain.PollingWorkGroup getGroup () {
		return group;
	}

	/**
	 * Set the value related to the column: GROUP_ID
	 * @param group the GROUP_ID value
	 */
	public void setGroup (com.justonetech.biz.domain.PollingWorkGroup group) {
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
		if (!(obj instanceof com.justonetech.biz.domain.PollingGroupUser)) return false;
		else {
			com.justonetech.biz.domain.PollingGroupUser pollingGroupUser = (com.justonetech.biz.domain.PollingGroupUser) obj;
			if (null == this.getId() || null == pollingGroupUser.getId()) return false;
			else return (this.getId().equals(pollingGroupUser.getId()));
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
		builder.append(isCharge);
		return builder.toString();
	}


}