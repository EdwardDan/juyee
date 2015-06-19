package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_THINGS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 办公用品信息
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 办公用品信息
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_THINGS"
 */

public abstract class BaseOaThings  implements Serializable,Auditable{

	public static String REF = "OaThings";
	public static String PROP_AMOUNT = "amount";
	public static String PROP_MODEL = "model";
	public static String PROP_TYPE = "type";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_UNIT = "unit";
	public static String PROP_NAME = "name";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_ORDER_NO = "orderNo";
	public static String PROP_IS_VALID = "isValid";
	public static String PROP_PRICE = "price";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_ID = "id";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseOaThings () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaThings (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*序号*/
    /*序号*/
	private Integer orderNo;
	
    /*办公用品名称*/
    /*办公用品名称*/
	private String name;
	
    /*型号*/
    /*型号*/
	private String model;
	
    /*单价*/
    /*单价*/
	private Double price;
	
    /*单位*/
    /*单位*/
	private String unit;
	
    /*库存*/
    /*库存*/
	private Double amount;
	
    /*是否有效*/
    /*是否有效*/
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
	private com.justonetech.system.domain.SysCodeDetail type;

	// collections
	private java.util.Set<com.justonetech.biz.domain.OaThingsApplyItem> oaThingsApplyItems;



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
	 * Return the value associated with the column: ORDER_NO
	 */
	public Integer getOrderNo () {
		return orderNo;
	}

	/**
	 * Set the value related to the column: ORDER_NO
	 * @param orderNo the ORDER_NO value
	 */
	public void setOrderNo (Integer orderNo) {
		this.orderNo = orderNo;
	}


	/**
	 * Return the value associated with the column: NAME
	 */
	public String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: NAME
	 * @param name the NAME value
	 */
	public void setName (String name) {
		this.name = name;
	}


	/**
	 * Return the value associated with the column: MODEL
	 */
	public String getModel () {
		return model;
	}

	/**
	 * Set the value related to the column: MODEL
	 * @param model the MODEL value
	 */
	public void setModel (String model) {
		this.model = model;
	}


	/**
	 * Return the value associated with the column: PRICE
	 */
	public Double getPrice () {
		return price;
	}

	/**
	 * Set the value related to the column: PRICE
	 * @param price the PRICE value
	 */
	public void setPrice (Double price) {
		this.price = price;
	}


	/**
	 * Return the value associated with the column: UNIT
	 */
	public String getUnit () {
		return unit;
	}

	/**
	 * Set the value related to the column: UNIT
	 * @param unit the UNIT value
	 */
	public void setUnit (String unit) {
		this.unit = unit;
	}


	/**
	 * Return the value associated with the column: AMOUNT
	 */
	public Double getAmount () {
		return amount;
	}

	/**
	 * Set the value related to the column: AMOUNT
	 * @param amount the AMOUNT value
	 */
	public void setAmount (Double amount) {
		this.amount = amount;
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


	/**
	 * Return the value associated with the column: oaThingsApplyItems
	 */
	public java.util.Set<com.justonetech.biz.domain.OaThingsApplyItem> getOaThingsApplyItems () {
		if(oaThingsApplyItems == null){
			oaThingsApplyItems = new java.util.LinkedHashSet<com.justonetech.biz.domain.OaThingsApplyItem>();
		}
		return oaThingsApplyItems;
	}

	/**
	 * Set the value related to the column: oaThingsApplyItems
	 * @param oaThingsApplyItems the oaThingsApplyItems value
	 */
	public void setOaThingsApplyItems (java.util.Set<com.justonetech.biz.domain.OaThingsApplyItem> oaThingsApplyItems) {
		this.oaThingsApplyItems = oaThingsApplyItems;
	}

	public void addTooaThingsApplyItems (com.justonetech.biz.domain.OaThingsApplyItem oaThingsApplyItem) {
		if (null == getOaThingsApplyItems()) setOaThingsApplyItems(new java.util.LinkedHashSet<com.justonetech.biz.domain.OaThingsApplyItem>());
		getOaThingsApplyItems().add(oaThingsApplyItem);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaThings)) return false;
		else {
			com.justonetech.biz.domain.OaThings oaThings = (com.justonetech.biz.domain.OaThings) obj;
			if (null == this.getId() || null == oaThings.getId()) return false;
			else return (this.getId().equals(oaThings.getId()));
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
		builder.append(orderNo);
		builder.append(name);
		builder.append(model);
		builder.append(price);
		builder.append(unit);
		builder.append(amount);
		builder.append(isValid);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}