package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the WEB_UNIT_QUALIFY_PERMIT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 企业资质核准
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 企业资质核准
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : web
 * Projectable : false
 *
 * @hibernate.class
 *  table="WEB_UNIT_QUALIFY_PERMIT"
 */

public abstract class BaseWebUnitQualifyPermit  implements Serializable {

	public static String REF = "WebUnitQualifyPermit";
	public static String PROP_UNIT_NAME = "unitName";
	public static String PROP_TITLE_DATE = "titleDate";
	public static String PROP_ID = "id";
	public static String PROP_PERMIT_THINGS = "permitThings";
	public static String PROP_APPLY_NO = "applyNo";


	// constructors
	public BaseWebUnitQualifyPermit () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWebUnitQualifyPermit (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*企业名称*/
    /*企业名称*/
	private String unitName;
	
    /*核准事项*/
    /*核准事项*/
	private String permitThing;
	
    /*受理批次*/
    /*受理批次*/
	private String applyNo;
	
    /*公告日期*/
    /*公告日期*/
	private java.sql.Date titleDate;
	

	// collections
	private java.util.Set<com.justonetech.biz.domain.WebQualifyPermitItems> webQualifyPermitItems;



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
	 * Return the value associated with the column: 企业名称
	 */
	public String getUnitName () {
		return unitName;
	}

	/**
	 * Set the value related to the column: 企业名称
	 * @param unitName the 企业名称 value
	 */
	public void setUnitName (String unitName) {
		this.unitName = unitName;
	}


	/**
	 * Return the value associated with the column: 核准事项
	 */
	public String getPermitThing () {
		return permitThing;
	}

	/**
	 * Set the value related to the column: 核准事项
	 * @param permitThing the 核准事项 value
	 */
	public void setPermitThing (String permitThing) {
		this.permitThing = permitThing;
	}


	/**
	 * Return the value associated with the column: 受理批次
	 */
	public String getApplyNo () {
		return applyNo;
	}

	/**
	 * Set the value related to the column: 受理批次
	 * @param applyNo the 受理批次 value
	 */
	public void setApplyNo (String applyNo) {
		this.applyNo = applyNo;
	}


	/**
	 * Return the value associated with the column: 公告日期
	 */
	public java.sql.Date getTitleDate () {
		return titleDate;
	}

	/**
	 * Set the value related to the column: 公告日期
	 * @param titleDate the 公告日期 value
	 */
	public void setTitleDate (java.sql.Date titleDate) {
		this.titleDate = titleDate;
	}


	/**
	 * Return the value associated with the column: webQualifyPermitItems
	 */
	public java.util.Set<com.justonetech.biz.domain.WebQualifyPermitItems> getWebQualifyPermitItems () {
		if(webQualifyPermitItems == null){
			webQualifyPermitItems = new java.util.LinkedHashSet<com.justonetech.biz.domain.WebQualifyPermitItems>();
		}
		return webQualifyPermitItems;
	}

	/**
	 * Set the value related to the column: webQualifyPermitItems
	 * @param webQualifyPermitItems the webQualifyPermitItems value
	 */
	public void setWebQualifyPermitItems (java.util.Set<com.justonetech.biz.domain.WebQualifyPermitItems> webQualifyPermitItems) {
		this.webQualifyPermitItems = webQualifyPermitItems;
	}

	public void addTowebQualifyPermitItems (com.justonetech.biz.domain.WebQualifyPermitItems webQualifyPermitItems) {
		if (null == getWebQualifyPermitItems()) setWebQualifyPermitItems(new java.util.LinkedHashSet<com.justonetech.biz.domain.WebQualifyPermitItems>());
		getWebQualifyPermitItems().add(webQualifyPermitItems);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.WebUnitQualifyPermit)) return false;
		else {
			com.justonetech.biz.domain.WebUnitQualifyPermit webUnitQualifyPermit = (com.justonetech.biz.domain.WebUnitQualifyPermit) obj;
			if (null == this.getId() || null == webUnitQualifyPermit.getId()) return false;
			else return (this.getId().equals(webUnitQualifyPermit.getId()));
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
		builder.append(unitName);
		builder.append(permitThing);
		builder.append(applyNo);
		builder.append(titleDate);
		return builder.toString();
	}


}