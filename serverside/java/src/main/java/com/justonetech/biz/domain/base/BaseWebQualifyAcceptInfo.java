package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the WEB_QUALIFY_ACCEPT_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 企业资质受理情况
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 企业资质受理情况
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : web
 * Projectable : false
 *
 * @hibernate.class
 *  table="WEB_QUALIFY_ACCEPT_INFO"
 */

public abstract class BaseWebQualifyAcceptInfo  implements Serializable {

	public static String REF = "WebQualifyAcceptInfo";
	public static String PROP_UNIT_NAME = "unitName";
	public static String PROP_LEGAL_PERSON = "legalPerson";
	public static String PROP_ZC_MONEY = "zcMoney";
	public static String PROP_ACCEPT_NO = "acceptNo";
	public static String PROP_LEGAL_PERSON_TITLE = "legalPersonTitle";
	public static String PROP_APPLYS = "applys";
	public static String PROP_UNIT_CATEGORY = "unitCategory";
	public static String PROP_ZC_ADDRESS = "zcAddress";
	public static String PROP_ID = "id";
	public static String PROP_PUBLIC_DATE = "publicDate";
	public static String PROP_LEGAL_PERSON_PERSION = "legalPersonPersion";


	// constructors
	public BaseWebQualifyAcceptInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWebQualifyAcceptInfo (Long id) {
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
	
    /*注册地址*/
    /*注册地址*/
	private String zcAddress;
	
    /*企业类型*/
    /*企业类型*/
	private String unitCategory;
	
    /*注册资本金*/
    /*注册资本金*/
	private String zcMoney;
	
    /*企业法人*/
    /*企业法人*/
	private String legalPerson;
	
    /*企业法人职称*/
    /*企业法人职称*/
	private String legalPersonTitle;
	
    /*企业法人职务*/
    /*企业法人职务*/
	private String legalPersonPersion;
	

	// collections
	private java.util.Set<com.justonetech.biz.domain.WebUnitApplyQualify> webUnitApplyQualifies;
	private java.util.Set<com.justonetech.biz.domain.WebUnitPersonInfo> webUnitPersonInfos;



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
	 * Return the value associated with the column: ZC_ADDRESS
	 */
	public String getZcAddress () {
		return zcAddress;
	}

	/**
	 * Set the value related to the column: ZC_ADDRESS
	 * @param zcAddress the ZC_ADDRESS value
	 */
	public void setZcAddress (String zcAddress) {
		this.zcAddress = zcAddress;
	}


	/**
	 * Return the value associated with the column: UNIT_CATEGORY
	 */
	public String getUnitCategory () {
		return unitCategory;
	}

	/**
	 * Set the value related to the column: UNIT_CATEGORY
	 * @param unitCategory the UNIT_CATEGORY value
	 */
	public void setUnitCategory (String unitCategory) {
		this.unitCategory = unitCategory;
	}


	/**
	 * Return the value associated with the column: ZC_MONEY
	 */
	public String getZcMoney () {
		return zcMoney;
	}

	/**
	 * Set the value related to the column: ZC_MONEY
	 * @param zcMoney the ZC_MONEY value
	 */
	public void setZcMoney (String zcMoney) {
		this.zcMoney = zcMoney;
	}


	/**
	 * Return the value associated with the column: LEGAL_PERSON
	 */
	public String getLegalPerson () {
		return legalPerson;
	}

	/**
	 * Set the value related to the column: LEGAL_PERSON
	 * @param legalPerson the LEGAL_PERSON value
	 */
	public void setLegalPerson (String legalPerson) {
		this.legalPerson = legalPerson;
	}


	/**
	 * Return the value associated with the column: LEGAL_PERSON_TITLE
	 */
	public String getLegalPersonTitle () {
		return legalPersonTitle;
	}

	/**
	 * Set the value related to the column: LEGAL_PERSON_TITLE
	 * @param legalPersonTitle the LEGAL_PERSON_TITLE value
	 */
	public void setLegalPersonTitle (String legalPersonTitle) {
		this.legalPersonTitle = legalPersonTitle;
	}


	/**
	 * Return the value associated with the column: LEGAL_PERSON_PERSION
	 */
	public String getLegalPersonPersion () {
		return legalPersonPersion;
	}

	/**
	 * Set the value related to the column: LEGAL_PERSON_PERSION
	 * @param legalPersonPersion the LEGAL_PERSON_PERSION value
	 */
	public void setLegalPersonPersion (String legalPersonPersion) {
		this.legalPersonPersion = legalPersonPersion;
	}


	/**
	 * Return the value associated with the column: webUnitApplyQualifies
	 */
	public java.util.Set<com.justonetech.biz.domain.WebUnitApplyQualify> getWebUnitApplyQualifies () {
		if(webUnitApplyQualifies == null){
			webUnitApplyQualifies = new java.util.LinkedHashSet<com.justonetech.biz.domain.WebUnitApplyQualify>();
		}
		return webUnitApplyQualifies;
	}

	/**
	 * Set the value related to the column: webUnitApplyQualifies
	 * @param webUnitApplyQualifies the webUnitApplyQualifies value
	 */
	public void setWebUnitApplyQualifies (java.util.Set<com.justonetech.biz.domain.WebUnitApplyQualify> webUnitApplyQualifies) {
		this.webUnitApplyQualifies = webUnitApplyQualifies;
	}

	public void addTowebUnitApplyQualifies (com.justonetech.biz.domain.WebUnitApplyQualify webUnitApplyQualify) {
		if (null == getWebUnitApplyQualifies()) setWebUnitApplyQualifies(new java.util.LinkedHashSet<com.justonetech.biz.domain.WebUnitApplyQualify>());
		getWebUnitApplyQualifies().add(webUnitApplyQualify);
	}


	/**
	 * Return the value associated with the column: webUnitPersonInfos
	 */
	public java.util.Set<com.justonetech.biz.domain.WebUnitPersonInfo> getWebUnitPersonInfos () {
		if(webUnitPersonInfos == null){
			webUnitPersonInfos = new java.util.LinkedHashSet<com.justonetech.biz.domain.WebUnitPersonInfo>();
		}
		return webUnitPersonInfos;
	}

	/**
	 * Set the value related to the column: webUnitPersonInfos
	 * @param webUnitPersonInfos the webUnitPersonInfos value
	 */
	public void setWebUnitPersonInfos (java.util.Set<com.justonetech.biz.domain.WebUnitPersonInfo> webUnitPersonInfos) {
		this.webUnitPersonInfos = webUnitPersonInfos;
	}

	public void addTowebUnitPersonInfos (com.justonetech.biz.domain.WebUnitPersonInfo webUnitPersonInfo) {
		if (null == getWebUnitPersonInfos()) setWebUnitPersonInfos(new java.util.LinkedHashSet<com.justonetech.biz.domain.WebUnitPersonInfo>());
		getWebUnitPersonInfos().add(webUnitPersonInfo);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.WebQualifyAcceptInfo)) return false;
		else {
			com.justonetech.biz.domain.WebQualifyAcceptInfo webQualifyAcceptInfo = (com.justonetech.biz.domain.WebQualifyAcceptInfo) obj;
			if (null == this.getId() || null == webQualifyAcceptInfo.getId()) return false;
			else return (this.getId().equals(webQualifyAcceptInfo.getId()));
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
		builder.append(zcAddress);
		builder.append(unitCategory);
		builder.append(zcMoney);
		builder.append(legalPerson);
		builder.append(legalPersonTitle);
		builder.append(legalPersonPersion);
		return builder.toString();
	}


}