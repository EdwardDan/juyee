package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_THINGS_APPLY_ITEM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 办公用品申请明细
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 办公用品申请明细
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_THINGS_APPLY_ITEM"
 */

public abstract class BaseOaThingsApplyItem  implements Serializable {

	public static String REF = "OaThingsApplyItem";
	public static String PROP_NAME = "name";
	public static String PROP_AMOUNT = "amount";
	public static String PROP_MODEL = "model";
	public static String PROP_OA_THINGS_APPLY = "oaThingsApply";
	public static String PROP_PRICE = "price";
	public static String PROP_ID = "id";
	public static String PROP_OA_THINGS = "oaThings";
	public static String PROP_UNIT = "unit";


	// constructors
	public BaseOaThingsApplyItem () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaThingsApplyItem (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*名称(冗余)*/
    /*名称(冗余)*/
	private String name;
	
    /*型号(冗余)*/
    /*型号(冗余)*/
	private String model;
	
    /*单位(冗余)*/
    /*单位(冗余)*/
	private String unit;
	
    /*预计单价(冗余)*/
    /*预计单价(冗余)*/
	private Double price;
	
    /*数量*/
    /*数量*/
	private Double amount;
	

	// many to one
	private com.justonetech.biz.domain.OaThings oaThings;
	private com.justonetech.biz.domain.OaThingsApply oaThingsApply;



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
	 * Return the value associated with the column: OA_THINGS_ID
	 */
	public com.justonetech.biz.domain.OaThings getOaThings () {
		return oaThings;
	}

	/**
	 * Set the value related to the column: OA_THINGS_ID
	 * @param oaThings the OA_THINGS_ID value
	 */
	public void setOaThings (com.justonetech.biz.domain.OaThings oaThings) {
		this.oaThings = oaThings;
	}


	/**
	 * Return the value associated with the column: OA_THINGS_APPLY_ID
	 */
	public com.justonetech.biz.domain.OaThingsApply getOaThingsApply () {
		return oaThingsApply;
	}

	/**
	 * Set the value related to the column: OA_THINGS_APPLY_ID
	 * @param oaThingsApply the OA_THINGS_APPLY_ID value
	 */
	public void setOaThingsApply (com.justonetech.biz.domain.OaThingsApply oaThingsApply) {
		this.oaThingsApply = oaThingsApply;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaThingsApplyItem)) return false;
		else {
			com.justonetech.biz.domain.OaThingsApplyItem oaThingsApplyItem = (com.justonetech.biz.domain.OaThingsApplyItem) obj;
			if (null == this.getId() || null == oaThingsApplyItem.getId()) return false;
			else return (this.getId().equals(oaThingsApplyItem.getId()));
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
		builder.append(model);
		builder.append(unit);
		builder.append(price);
		builder.append(amount);
		return builder.toString();
	}


}