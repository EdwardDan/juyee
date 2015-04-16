package com.justonetech.biz.domain.base;

import com.justonetech.biz.domain.OrderFormDeployUser;

import java.io.Serializable;
import java.util.Set;


/**
 * This is an object that contains data related to the ORDER_FORM_DEPLOY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 预约单调配
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 预约单调配
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : order
 * Projectable : false
 *
 * @hibernate.class
 *  table="ORDER_FORM_DEPLOY"
 */

public abstract class BaseOrderFormDeploy implements Serializable {

	public static String REF = "OrderFormDeploy";
	public static String PROP_ACCEPT_OPINION = "acceptOpinion";
	public static String PROP_ACCEPT_OPINION_DESC = "acceptOpinionDesc";
	public static String PROP_ACCEPT_USER_NAME = "acceptUserName";
	public static String PROP_ORDER_FORM = "orderForm";
	public static String PROP_ID = "id";
	public static String PROP_ACCEPT_DATETIME = "acceptDatetime";
	public static String PROP_ACCEPT_USER = "acceptUser";
	public static String PROP_WORK_GROUP = "workGroup";


	// constructors
	public BaseOrderFormDeploy() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOrderFormDeploy(Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*受理人*/
    /*受理人*/
	private String acceptUserName;
	
    /*受理时间*/
    /*受理时间*/
	private java.sql.Timestamp acceptDatetime;
	
    /*受理备注*/
    /*受理备注*/
	private String acceptOpinionDesc;
    // collections
    private java.util.Set<OrderFormDeployUser> orderFormDeployUser;

	// many to one
	private com.justonetech.biz.domain.OrderForm orderForm;
	private com.justonetech.biz.domain.PollingWorkGroup workGroup;
	private com.justonetech.system.domain.SysCodeDetail acceptOpinion;
	private com.justonetech.system.domain.SysUser acceptUser;

    public Set<OrderFormDeployUser> getOrderFormDeployUser() {
        return orderFormDeployUser;
    }

    public void setOrderFormDeployUser(Set<OrderFormDeployUser> orderFormDeployUser) {
        this.orderFormDeployUser = orderFormDeployUser;
    }

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
	 * Return the value associated with the column: ACCEPT_USER_NAME
	 */
	public String getAcceptUserName () {
		return acceptUserName;
	}

	/**
	 * Set the value related to the column: ACCEPT_USER_NAME
	 * @param acceptUserName the ACCEPT_USER_NAME value
	 */
	public void setAcceptUserName (String acceptUserName) {
		this.acceptUserName = acceptUserName;
	}


	/**
	 * Return the value associated with the column: ACCEPT_DATETIME
	 */
	public java.sql.Timestamp getAcceptDatetime () {
		return acceptDatetime;
	}

	/**
	 * Set the value related to the column: ACCEPT_DATETIME
	 * @param acceptDatetime the ACCEPT_DATETIME value
	 */
	public void setAcceptDatetime (java.sql.Timestamp acceptDatetime) {
		this.acceptDatetime = acceptDatetime;
	}


	/**
	 * Return the value associated with the column: ACCEPT_OPINION_DESC
	 */
	public String getAcceptOpinionDesc () {
		return acceptOpinionDesc;
	}

	/**
	 * Set the value related to the column: ACCEPT_OPINION_DESC
	 * @param acceptOpinionDesc the ACCEPT_OPINION_DESC value
	 */
	public void setAcceptOpinionDesc (String acceptOpinionDesc) {
		this.acceptOpinionDesc = acceptOpinionDesc;
	}


	/**
	 * Return the value associated with the column: ORDER_FORM_ID
	 */
	public com.justonetech.biz.domain.OrderForm getOrderForm () {
		return orderForm;
	}

	/**
	 * Set the value related to the column: ORDER_FORM_ID
	 * @param orderForm the ORDER_FORM_ID value
	 */
	public void setOrderForm (com.justonetech.biz.domain.OrderForm orderForm) {
		this.orderForm = orderForm;
	}


	/**
	 * Return the value associated with the column: WORK_GROUP_ID
	 */
	public com.justonetech.biz.domain.PollingWorkGroup getWorkGroup () {
		return workGroup;
	}

	/**
	 * Set the value related to the column: WORK_GROUP_ID
	 * @param workGroup the WORK_GROUP_ID value
	 */
	public void setWorkGroup (com.justonetech.biz.domain.PollingWorkGroup workGroup) {
		this.workGroup = workGroup;
	}


	/**
	 * Return the value associated with the column: ACCEPT_OPINION
	 */
	public com.justonetech.system.domain.SysCodeDetail getAcceptOpinion () {
		return acceptOpinion;
	}

	/**
	 * Set the value related to the column: ACCEPT_OPINION
	 * @param acceptOpinion the ACCEPT_OPINION value
	 */
	public void setAcceptOpinion (com.justonetech.system.domain.SysCodeDetail acceptOpinion) {
		this.acceptOpinion = acceptOpinion;
	}


	/**
	 * Return the value associated with the column: ACCEPT_USER_ID
	 */
	public com.justonetech.system.domain.SysUser getAcceptUser () {
		return acceptUser;
	}

	/**
	 * Set the value related to the column: ACCEPT_USER_ID
	 * @param acceptUser the ACCEPT_USER_ID value
	 */
	public void setAcceptUser (com.justonetech.system.domain.SysUser acceptUser) {
		this.acceptUser = acceptUser;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OrderFormDeploy)) return false;
		else {
			com.justonetech.biz.domain.OrderFormDeploy orderFormDeploy = (com.justonetech.biz.domain.OrderFormDeploy) obj;
			if (null == this.getId() || null == orderFormDeploy.getId()) return false;
			else return (this.getId().equals(orderFormDeploy.getId()));
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
		builder.append(acceptUserName);
		builder.append(acceptDatetime);
		builder.append(acceptOpinionDesc);
		return builder.toString();
	}


}