package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the WEB_UNIT_APPLY_QUALIFY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 企业申请资质
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 企业申请资质
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : web
 * Projectable : false
 *
 * @hibernate.class
 *  table="WEB_UNIT_APPLY_QUALIFY"
 */

public abstract class BaseWebUnitApplyQualify  implements Serializable {

	public static String REF = "WebUnitApplyQualify";
	public static String PROP_QUALIFY_ACCEPT_INFO = "qualifyAcceptInfo";
	public static String PROP_QUALIFY_LEVEL = "qualifyLevel";
	public static String PROP_ID = "id";
	public static String PROP_QUALIFY_ORDER = "qualifyOrder";
	public static String PROP_QUALIFY_CATEGORY = "qualifyCategory";


	// constructors
	public BaseWebUnitApplyQualify () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWebUnitApplyQualify (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*资质序列*/
    /*资质序列*/
	private String qualifyOrder;
	
    /*资质类别*/
    /*资质类别*/
	private String qualifyCategory;
	
    /*资质等级*/
    /*资质等级*/
	private String qualifyLevel;
	

	// many to one
	private com.justonetech.biz.domain.WebQualifyAcceptInfo qualifyAcceptInfo;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="com.justonetech.core.orm.hibernate.LongIdGenerator"
     *  column="id"
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
	 * Return the value associated with the column: QUALIFY_ORDER
	 */
	public String getQualifyOrder () {
		return qualifyOrder;
	}

	/**
	 * Set the value related to the column: QUALIFY_ORDER
	 * @param qualifyOrder the QUALIFY_ORDER value
	 */
	public void setQualifyOrder (String qualifyOrder) {
		this.qualifyOrder = qualifyOrder;
	}


	/**
	 * Return the value associated with the column: QUALIFY_CATEGORY
	 */
	public String getQualifyCategory () {
		return qualifyCategory;
	}

	/**
	 * Set the value related to the column: QUALIFY_CATEGORY
	 * @param qualifyCategory the QUALIFY_CATEGORY value
	 */
	public void setQualifyCategory (String qualifyCategory) {
		this.qualifyCategory = qualifyCategory;
	}


	/**
	 * Return the value associated with the column: QUALIFY_LEVEL
	 */
	public String getQualifyLevel () {
		return qualifyLevel;
	}

	/**
	 * Set the value related to the column: QUALIFY_LEVEL
	 * @param qualifyLevel the QUALIFY_LEVEL value
	 */
	public void setQualifyLevel (String qualifyLevel) {
		this.qualifyLevel = qualifyLevel;
	}


	/**
	 * Return the value associated with the column: QUALIFY_ACCEPT_INFO_ID
	 */
	public com.justonetech.biz.domain.WebQualifyAcceptInfo getQualifyAcceptInfo () {
		return qualifyAcceptInfo;
	}

	/**
	 * Set the value related to the column: QUALIFY_ACCEPT_INFO_ID
	 * @param qualifyAcceptInfo the QUALIFY_ACCEPT_INFO_ID value
	 */
	public void setQualifyAcceptInfo (com.justonetech.biz.domain.WebQualifyAcceptInfo qualifyAcceptInfo) {
		this.qualifyAcceptInfo = qualifyAcceptInfo;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.WebUnitApplyQualify)) return false;
		else {
			com.justonetech.biz.domain.WebUnitApplyQualify webUnitApplyQualify = (com.justonetech.biz.domain.WebUnitApplyQualify) obj;
			if (null == this.getId() || null == webUnitApplyQualify.getId()) return false;
			else return (this.getId().equals(webUnitApplyQualify.getId()));
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
		builder.append(qualifyOrder);
		builder.append(qualifyCategory);
		builder.append(qualifyLevel);
		return builder.toString();
	}


}