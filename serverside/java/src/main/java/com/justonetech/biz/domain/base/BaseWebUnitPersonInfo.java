package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the WEB_UNIT_PERSON_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 企业人员信息
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 企业人员信息
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : web
 * Projectable : false
 *
 * @hibernate.class
 *  table="WEB_UNIT_PERSON_INFO"
 */

public abstract class BaseWebUnitPersonInfo  implements Serializable {

	public static String REF = "WebUnitPersonInfo";
	public static String PROP_NAME = "name";
	public static String PROP_MAJOR = "major";
	public static String PROP_QUALIFY_ACCEPT_INFO = "qualifyAcceptInfo";
	public static String PROP_PERSON_CATEGOR = "personCategor";
	public static String PROP_ZC_TYPE = "zcType";
	public static String PROP_POSITION = "position";
	public static String PROP_ID = "id";
	public static String PROP_TITLE = "title";


	// constructors
	public BaseWebUnitPersonInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWebUnitPersonInfo (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*人员类型*/
    /*人员类型*/
	private String personCategor;
	
    /*姓名*/
    /*姓名*/
	private String name;
	
    /*职务*/
    /*职务*/
	private String position;
	
    /*职称*/
    /*职称*/
	private String title;
	
    /*所学专业*/
    /*所学专业*/
	private String major;
	
    /*注册类型*/
    /*注册类型*/
	private String zcType;
	

	// many to one
	private com.justonetech.biz.domain.WebQualifyAcceptInfo qualifyAcceptInfo;

	// collections
	private java.util.Set<com.justonetech.biz.domain.WebPersonPerformance> webPersonPerformances;



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
	 * Return the value associated with the column: PERSON_CATEGOR
	 */
	public String getPersonCategor () {
		return personCategor;
	}

	/**
	 * Set the value related to the column: PERSON_CATEGOR
	 * @param personCategor the PERSON_CATEGOR value
	 */
	public void setPersonCategor (String personCategor) {
		this.personCategor = personCategor;
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
	 * Return the value associated with the column: POSITION
	 */
	public String getPosition () {
		return position;
	}

	/**
	 * Set the value related to the column: POSITION
	 * @param position the POSITION value
	 */
	public void setPosition (String position) {
		this.position = position;
	}


	/**
	 * Return the value associated with the column: TITLE
	 */
	public String getTitle () {
		return title;
	}

	/**
	 * Set the value related to the column: TITLE
	 * @param title the TITLE value
	 */
	public void setTitle (String title) {
		this.title = title;
	}


	/**
	 * Return the value associated with the column: MAJOR
	 */
	public String getMajor () {
		return major;
	}

	/**
	 * Set the value related to the column: MAJOR
	 * @param major the MAJOR value
	 */
	public void setMajor (String major) {
		this.major = major;
	}


	/**
	 * Return the value associated with the column: ZC_TYPE
	 */
	public String getZcType () {
		return zcType;
	}

	/**
	 * Set the value related to the column: ZC_TYPE
	 * @param zcType the ZC_TYPE value
	 */
	public void setZcType (String zcType) {
		this.zcType = zcType;
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


	/**
	 * Return the value associated with the column: webPersonPerformances
	 */
	public java.util.Set<com.justonetech.biz.domain.WebPersonPerformance> getWebPersonPerformances () {
		if(webPersonPerformances == null){
			webPersonPerformances = new java.util.LinkedHashSet<com.justonetech.biz.domain.WebPersonPerformance>();
		}
		return webPersonPerformances;
	}

	/**
	 * Set the value related to the column: webPersonPerformances
	 * @param webPersonPerformances the webPersonPerformances value
	 */
	public void setWebPersonPerformances (java.util.Set<com.justonetech.biz.domain.WebPersonPerformance> webPersonPerformances) {
		this.webPersonPerformances = webPersonPerformances;
	}

	public void addTowebPersonPerformances (com.justonetech.biz.domain.WebPersonPerformance webPersonPerformance) {
		if (null == getWebPersonPerformances()) setWebPersonPerformances(new java.util.LinkedHashSet<com.justonetech.biz.domain.WebPersonPerformance>());
		getWebPersonPerformances().add(webPersonPerformance);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.WebUnitPersonInfo)) return false;
		else {
			com.justonetech.biz.domain.WebUnitPersonInfo webUnitPersonInfo = (com.justonetech.biz.domain.WebUnitPersonInfo) obj;
			if (null == this.getId() || null == webUnitPersonInfo.getId()) return false;
			else return (this.getId().equals(webUnitPersonInfo.getId()));
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
		builder.append(personCategor);
		builder.append(name);
		builder.append(position);
		builder.append(title);
		builder.append(major);
		builder.append(zcType);
		return builder.toString();
	}


}