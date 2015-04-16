package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ORDER_FORM_DEPLOY_USER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 监督预约监督人员
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 监督预约监督人员
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : order
 * Projectable : false
 *
 * @hibernate.class
 *  table="ORDER_FORM_DEPLOY_USER"
 */

public abstract class BaseOrderFormDeployUser  implements Serializable {

	public static String REF = "OrderFormDeployUser";
	public static String PROP_USER = "user";
	public static String PROP_ID = "id";
	public static String PROP_ORDER_FORM_DEPLOY = "orderFormDeploy";
	public static String PROP_IS_MANAGER = "isManager";


	// constructors
	public BaseOrderFormDeployUser () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOrderFormDeployUser (Long id) {
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
	private Boolean isManager;
	

	// many to one
	private com.justonetech.biz.domain.OrderFormDeploy orderFormDeploy;
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
	 * Return the value associated with the column: IS_MANAGER
	 */
	public Boolean getIsManager () {
		return isManager;
	}

	/**
	 * Set the value related to the column: IS_MANAGER
	 * @param isManager the IS_MANAGER value
	 */
	public void setIsManager (Boolean isManager) {
		this.isManager = isManager;
	}


	/**
	 * Return the value associated with the column: ORDER_FORM_DEPLOY_ID
	 */
	public com.justonetech.biz.domain.OrderFormDeploy getOrderFormDeploy () {
		return orderFormDeploy;
	}

	/**
	 * Set the value related to the column: ORDER_FORM_DEPLOY_ID
	 * @param orderFormDeploy the ORDER_FORM_DEPLOY_ID value
	 */
	public void setOrderFormDeploy (com.justonetech.biz.domain.OrderFormDeploy orderFormDeploy) {
		this.orderFormDeploy = orderFormDeploy;
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
		if (!(obj instanceof com.justonetech.biz.domain.OrderFormDeployUser)) return false;
		else {
			com.justonetech.biz.domain.OrderFormDeployUser orderFormDeployUser = (com.justonetech.biz.domain.OrderFormDeployUser) obj;
			if (null == this.getId() || null == orderFormDeployUser.getId()) return false;
			else return (this.getId().equals(orderFormDeployUser.getId()));
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
		builder.append(isManager);
		return builder.toString();
	}


}