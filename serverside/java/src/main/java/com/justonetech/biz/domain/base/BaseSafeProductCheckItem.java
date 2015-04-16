package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SAFE_PRODUCT_CHECK_ITEM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 安全生产季度考核明细
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 安全生产季度考核明细
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : safe
 * Projectable : false
 *
 * @hibernate.class
 *  table="SAFE_PRODUCT_CHECK_ITEM"
 */

public abstract class BaseSafeProductCheckItem  implements Serializable {

	public static String REF = "SafeProductCheckItem";
	public static String PROP_PRODUCT_STANDARD = "productStandard";
	public static String PROP_ID = "id";
	public static String PROP_PRODUCT_CHECK = "productCheck";
	public static String PROP_SCORE = "score";


	// constructors
	public BaseSafeProductCheckItem () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSafeProductCheckItem (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*扣分*/
    /*扣分*/
	private Integer score;
	

	// many to one
	private com.justonetech.biz.domain.SafeProductCheck productCheck;
	private com.justonetech.biz.domain.SafeProductStandard productStandard;



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
	 * Return the value associated with the column: SCORE
	 */
	public Integer getScore () {
		return score;
	}

	/**
	 * Set the value related to the column: SCORE
	 * @param score the SCORE value
	 */
	public void setScore (Integer score) {
		this.score = score;
	}


	/**
	 * Return the value associated with the column: PRODUCT_CHECK_ID
	 */
	public com.justonetech.biz.domain.SafeProductCheck getProductCheck () {
		return productCheck;
	}

	/**
	 * Set the value related to the column: PRODUCT_CHECK_ID
	 * @param productCheck the PRODUCT_CHECK_ID value
	 */
	public void setProductCheck (com.justonetech.biz.domain.SafeProductCheck productCheck) {
		this.productCheck = productCheck;
	}


	/**
	 * Return the value associated with the column: PRODUCT_STANDARD_ID
	 */
	public com.justonetech.biz.domain.SafeProductStandard getProductStandard () {
		return productStandard;
	}

	/**
	 * Set the value related to the column: PRODUCT_STANDARD_ID
	 * @param productStandard the PRODUCT_STANDARD_ID value
	 */
	public void setProductStandard (com.justonetech.biz.domain.SafeProductStandard productStandard) {
		this.productStandard = productStandard;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.SafeProductCheckItem)) return false;
		else {
			com.justonetech.biz.domain.SafeProductCheckItem safeProductCheckItem = (com.justonetech.biz.domain.SafeProductCheckItem) obj;
			if (null == this.getId() || null == safeProductCheckItem.getId()) return false;
			else return (this.getId().equals(safeProductCheckItem.getId()));
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
		builder.append(score);
		return builder.toString();
	}


}