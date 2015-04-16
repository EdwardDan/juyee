package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the WEB_QUALIFY_PERMIT_ITEMS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 企业资质核准条目
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 企业资质核准条目
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : web
 * Projectable : false
 *
 * @hibernate.class
 *  table="WEB_QUALIFY_PERMIT_ITEMS"
 */

public abstract class BaseWebQualifyPermitItems  implements Serializable {

	public static String REF = "WebQualifyPermitItems";
	public static String PROP_PERMIT_ITEM = "permitItem";
	public static String PROP_QUALIFY_LEVEL = "qualifyLevel";
	public static String PROP_ID = "id";
	public static String PROP_QUALIFY_PERMIT = "qualifyPermit";
	public static String PROP_QUALIFY_TYPE = "qualifyType";


	// constructors
	public BaseWebQualifyPermitItems () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWebQualifyPermitItems (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*核准事项*/
    /*核准事项*/
	private String permitItem;
	
    /*资质类别*/
    /*资质类别*/
	private String qualifyType;
	
    /*资质等级*/
    /*资质等级*/
	private String qualifyLevel;
	

	// many to one
	private com.justonetech.biz.domain.WebUnitQualifyPermit qualifyPermit;



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
	 * Return the value associated with the column: PERMIT_ITEM
	 */
	public String getPermitItem () {
		return permitItem;
	}

	/**
	 * Set the value related to the column: PERMIT_ITEM
	 * @param permitItem the PERMIT_ITEM value
	 */
	public void setPermitItem (String permitItem) {
		this.permitItem = permitItem;
	}


	/**
	 * Return the value associated with the column: QUALIFY_TYPE
	 */
	public String getQualifyType () {
		return qualifyType;
	}

	/**
	 * Set the value related to the column: QUALIFY_TYPE
	 * @param qualifyType the QUALIFY_TYPE value
	 */
	public void setQualifyType (String qualifyType) {
		this.qualifyType = qualifyType;
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
	 * Return the value associated with the column: QUALIFY_PERMIT_ID
	 */
	public com.justonetech.biz.domain.WebUnitQualifyPermit getQualifyPermit () {
		return qualifyPermit;
	}

	/**
	 * Set the value related to the column: QUALIFY_PERMIT_ID
	 * @param qualifyPermit the QUALIFY_PERMIT_ID value
	 */
	public void setQualifyPermit (com.justonetech.biz.domain.WebUnitQualifyPermit qualifyPermit) {
		this.qualifyPermit = qualifyPermit;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.WebQualifyPermitItems)) return false;
		else {
			com.justonetech.biz.domain.WebQualifyPermitItems webQualifyPermitItems = (com.justonetech.biz.domain.WebQualifyPermitItems) obj;
			if (null == this.getId() || null == webQualifyPermitItems.getId()) return false;
			else return (this.getId().equals(webQualifyPermitItems.getId()));
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
		builder.append(permitItem);
		builder.append(qualifyType);
		builder.append(qualifyLevel);
		return builder.toString();
	}


}