package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PLAN_DETAIL_USER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 监督计划负责人
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 监督计划负责人
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : plan
 * Projectable : false
 *
 * @hibernate.class
 *  table="PLAN_DETAIL_USER"
 */

public abstract class BasePlanDetailUser  implements Serializable {

	public static String REF = "PlanDetailUser";
	public static String PROP_USER = "user";
	public static String PROP_PLAN_DETAIL = "planDetail";
	public static String PROP_ID = "id";
	public static String PROP_IS_MANAGER = "isManager";


	// constructors
	public BasePlanDetailUser () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePlanDetailUser (Long id) {
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
	private com.justonetech.system.domain.SysUser user;
	private com.justonetech.biz.domain.PlanDetail planDetail;



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


	/**
	 * Return the value associated with the column: PLAN_DETAIL_ID
	 */
	public com.justonetech.biz.domain.PlanDetail getPlanDetail () {
		return planDetail;
	}

	/**
	 * Set the value related to the column: PLAN_DETAIL_ID
	 * @param planDetail the PLAN_DETAIL_ID value
	 */
	public void setPlanDetail (com.justonetech.biz.domain.PlanDetail planDetail) {
		this.planDetail = planDetail;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.PlanDetailUser)) return false;
		else {
			com.justonetech.biz.domain.PlanDetailUser planDetailUser = (com.justonetech.biz.domain.PlanDetailUser) obj;
			if (null == this.getId() || null == planDetailUser.getId()) return false;
			else return (this.getId().equals(planDetailUser.getId()));
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