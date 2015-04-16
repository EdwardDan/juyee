package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the WEB_UNIT_QUALIFY_SUGGEST table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 企业资质审查意见公示
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 企业资质审查意见公示
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : web
 * Projectable : false
 *
 * @hibernate.class
 *  table="WEB_UNIT_QUALIFY_SUGGEST"
 */

public abstract class BaseWebUnitQualifySuggest  implements Serializable {

	public static String REF = "WebUnitQualifySuggest";
	public static String PROP_UNIT_NAME = "unitName";
	public static String PROP_ACCEPT_NO = "acceptNo";
	public static String PROP_APPLYS = "applys";
	public static String PROP_ID = "id";
	public static String PROP_PUBLIC_DATE = "publicDate";


	// constructors
	public BaseWebUnitQualifySuggest () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWebUnitQualifySuggest (Long id) {
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
	
    /*申请事项*/
    /*申请事项*/
	private String applys;
	
    /*受理批次*/
    /*受理批次*/
	private String acceptNo;
	
    /*公示时间*/
    /*公示时间*/
	private java.sql.Date publicDate;
	

	// collections
	private java.util.Set<com.justonetech.biz.domain.WebQualifySuggestResults> webQualifySuggestResults;



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
	 * Return the value associated with the column: UNIT_NAME
	 */
	public String getUnitName () {
		return unitName;
	}

	/**
	 * Set the value related to the column: UNIT_NAME
	 * @param unitName the UNIT_NAME value
	 */
	public void setUnitName (String unitName) {
		this.unitName = unitName;
	}


	/**
	 * Return the value associated with the column: APPLYS
	 */
	public String getApplys () {
		return applys;
	}

	/**
	 * Set the value related to the column: APPLYS
	 * @param applys the APPLYS value
	 */
	public void setApplys (String applys) {
		this.applys = applys;
	}


	/**
	 * Return the value associated with the column: ACCEPT_NO
	 */
	public String getAcceptNo () {
		return acceptNo;
	}

	/**
	 * Set the value related to the column: ACCEPT_NO
	 * @param acceptNo the ACCEPT_NO value
	 */
	public void setAcceptNo (String acceptNo) {
		this.acceptNo = acceptNo;
	}


	/**
	 * Return the value associated with the column: PUBLIC_DATE
	 */
	public java.sql.Date getPublicDate () {
		return publicDate;
	}

	/**
	 * Set the value related to the column: PUBLIC_DATE
	 * @param publicDate the PUBLIC_DATE value
	 */
	public void setPublicDate (java.sql.Date publicDate) {
		this.publicDate = publicDate;
	}


	/**
	 * Return the value associated with the column: webQualifySuggestResults
	 */
	public java.util.Set<com.justonetech.biz.domain.WebQualifySuggestResults> getWebQualifySuggestResults () {
		if(webQualifySuggestResults == null){
			webQualifySuggestResults = new java.util.LinkedHashSet<com.justonetech.biz.domain.WebQualifySuggestResults>();
		}
		return webQualifySuggestResults;
	}

	/**
	 * Set the value related to the column: webQualifySuggestResults
	 * @param webQualifySuggestResults the webQualifySuggestResults value
	 */
	public void setWebQualifySuggestResults (java.util.Set<com.justonetech.biz.domain.WebQualifySuggestResults> webQualifySuggestResults) {
		this.webQualifySuggestResults = webQualifySuggestResults;
	}

	public void addTowebQualifySuggestResults (com.justonetech.biz.domain.WebQualifySuggestResults webQualifySuggestResults) {
		if (null == getWebQualifySuggestResults()) setWebQualifySuggestResults(new java.util.LinkedHashSet<com.justonetech.biz.domain.WebQualifySuggestResults>());
		getWebQualifySuggestResults().add(webQualifySuggestResults);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.WebUnitQualifySuggest)) return false;
		else {
			com.justonetech.biz.domain.WebUnitQualifySuggest webUnitQualifySuggest = (com.justonetech.biz.domain.WebUnitQualifySuggest) obj;
			if (null == this.getId() || null == webUnitQualifySuggest.getId()) return false;
			else return (this.getId().equals(webUnitQualifySuggest.getId()));
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
		builder.append(applys);
		builder.append(acceptNo);
		builder.append(publicDate);
		return builder.toString();
	}


}