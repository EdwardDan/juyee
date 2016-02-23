package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SERVICE_RETURN table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 送达回证
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 送达回证
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : service
 * Projectable : false
 *
 * @hibernate.class
 *  table="SERVICE_RETURN"
 */

public abstract class BaseServiceReturn  implements Serializable,Auditable {

	public static String REF = "ServiceReturn";
	public static String PROP_SERVICE_PERSON = "servicePerson";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_SERVICE_ADDRESS = "serviceAddress";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_MOEMO = "moemo";
	public static String PROP_SERVICE_UNIT = "serviceUnit";
	public static String PROP_CODE = "code";
	public static String PROP_UPDATE_USER = "updateUser";
	public static String PROP_THINGS_NAME = "thingsName";


	// constructors
	public BaseServiceReturn () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseServiceReturn (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*编号*/
    /*编号*/
	private java.lang.String code;
	
    /*受送达人*/
    /*受送达人*/
	private java.lang.String servicePerson;
	
    /*事项名称*/
    /*事项名称*/
	private java.lang.String thingsName;
	
    /*送达单位*/
    /*送达单位*/
	private java.lang.String serviceUnit;
	
    /*送达地点*/
    /*送达地点*/
	private java.lang.String serviceAddress;
	
    /*备注*/
    /*备注*/
	private java.lang.String moemo;
	
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
	private java.util.Set<com.justonetech.biz.domain.ServiceReturnItem> serviceReturnItems;



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
	 * Return the value associated with the column: CODE
	 */
	public java.lang.String getCode () {
		return code;
	}

	/**
	 * Set the value related to the column: CODE
	 * @param code the CODE value
	 */
	public void setCode (java.lang.String code) {
		this.code = code;
	}


	/**
	 * Return the value associated with the column: SERVICE_PERSON
	 */
	public java.lang.String getServicePerson () {
		return servicePerson;
	}

	/**
	 * Set the value related to the column: SERVICE_PERSON
	 * @param servicePerson the SERVICE_PERSON value
	 */
	public void setServicePerson (java.lang.String servicePerson) {
		this.servicePerson = servicePerson;
	}


	/**
	 * Return the value associated with the column: THINGS_NAME
	 */
	public java.lang.String getThingsName () {
		return thingsName;
	}

	/**
	 * Set the value related to the column: THINGS_NAME
	 * @param thingsName the THINGS_NAME value
	 */
	public void setThingsName (java.lang.String thingsName) {
		this.thingsName = thingsName;
	}


	/**
	 * Return the value associated with the column: SERVICE_UNIT
	 */
	public java.lang.String getServiceUnit () {
		return serviceUnit;
	}

	/**
	 * Set the value related to the column: SERVICE_UNIT
	 * @param serviceUnit the SERVICE_UNIT value
	 */
	public void setServiceUnit (java.lang.String serviceUnit) {
		this.serviceUnit = serviceUnit;
	}


	/**
	 * Return the value associated with the column: SERVICE_ADDRESS
	 */
	public java.lang.String getServiceAddress () {
		return serviceAddress;
	}

	/**
	 * Set the value related to the column: SERVICE_ADDRESS
	 * @param serviceAddress the SERVICE_ADDRESS value
	 */
	public void setServiceAddress (java.lang.String serviceAddress) {
		this.serviceAddress = serviceAddress;
	}


	/**
	 * Return the value associated with the column: MOEMO
	 */
	public java.lang.String getMoemo () {
		return moemo;
	}

	/**
	 * Set the value related to the column: MOEMO
	 * @param moemo the MOEMO value
	 */
	public void setMoemo (java.lang.String moemo) {
		this.moemo = moemo;
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
	 * Return the value associated with the column: serviceReturnItems
	 */
	public java.util.Set<com.justonetech.biz.domain.ServiceReturnItem> getServiceReturnItems () {
		if(serviceReturnItems == null){
			serviceReturnItems = new java.util.LinkedHashSet<com.justonetech.biz.domain.ServiceReturnItem>();
		}
		return serviceReturnItems;
	}

	/**
	 * Set the value related to the column: serviceReturnItems
	 * @param serviceReturnItems the serviceReturnItems value
	 */
	public void setServiceReturnItems (java.util.Set<com.justonetech.biz.domain.ServiceReturnItem> serviceReturnItems) {
		this.serviceReturnItems = serviceReturnItems;
	}

	public void addToserviceReturnItems (com.justonetech.biz.domain.ServiceReturnItem serviceReturnItem) {
		if (null == getServiceReturnItems()) setServiceReturnItems(new java.util.LinkedHashSet<com.justonetech.biz.domain.ServiceReturnItem>());
		getServiceReturnItems().add(serviceReturnItem);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ServiceReturn)) return false;
		else {
			com.justonetech.biz.domain.ServiceReturn serviceReturn = (com.justonetech.biz.domain.ServiceReturn) obj;
			if (null == this.getId() || null == serviceReturn.getId()) return false;
			else return (this.getId().equals(serviceReturn.getId()));
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
		builder.append(code);
		builder.append(servicePerson);
		builder.append(thingsName);
		builder.append(serviceUnit);
		builder.append(serviceAddress);
		builder.append(moemo);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}