package com.justonetech.system.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SYS_REG_PERSON table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 注册人员
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 注册人员
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : system
 * Projectable : false
 *
 * @hibernate.class
 *  table="SYS_REG_PERSON"
 */

public abstract class BaseSysRegPerson  implements Serializable {

	public static String REF = "SysRegPerson";
	public static String PROP_REG_TYPE = "regType";
	public static String PROP_UNIT_NAME = "unitName";
	public static String PROP_PROJECT_NAME = "projectName";
	public static String PROP_PERSON_NAME = "personName";
	public static String PROP_ACCEPT_OPINION = "acceptOpinion";
	public static String PROP_UNIT_IDENTIFY_CODE = "unitIdentifyCode";
	public static String PROP_ACCEPT_DATETIME = "acceptDatetime";
	public static String PROP_PROJECT_CARD = "projectCard";
	public static String PROP_ACCEPT_USER = "acceptUser";
	public static String PROP_GD_CODE = "gdCode";
	public static String PROP_REG_RESOURCE = "regResource";
	public static String PROP_BJBH = "bjbh";
	public static String PROP_ACCEPT_DESC = "acceptDesc";
	public static String PROP_MOBILE = "mobile";
	public static String PROP_UNIT_CODE = "unitCode";
	public static String PROP_ID = "id";


	// constructors
	public BaseSysRegPerson () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSysRegPerson (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*联系人*/
    /*联系人*/
	private java.lang.String personName;
	
    /*手机号码*/
    /*手机号码*/
	private java.lang.String mobile;
	
    /*工地编号*/
    /*工地编号*/
	private java.lang.String gdCode;
	
    /*报建编号*/
    /*报建编号*/
	private java.lang.String bjbh;
	
    /*项目卡号*/
    /*项目卡号*/
	private java.lang.String projectCard;
	
    /*工程名称*/
    /*工程名称*/
	private java.lang.String projectName;
	
    /*企业编码*/
    /*企业编码*/
	private java.lang.String unitCode;
	
    /*企业标识码*/
    /*企业标识码*/
	private java.lang.String unitIdentifyCode;
	
    /*企业名称*/
    /*企业名称*/
	private java.lang.String unitName;
	
    /*注册来源：网站、窗口*/
    /*注册来源：网站、窗口*/
	private java.lang.Integer regResource;
	
    /*受理意见：已通过、未通过、未受理*/
    /*受理意见：已通过、未通过、未受理*/
	private java.lang.Integer acceptOpinion;
	
    /*受理描述*/
    /*受理描述*/
	private java.lang.String acceptDesc;
	
    /*受理日期*/
    /*受理日期*/
	private java.sql.Timestamp acceptDatetime;
	

	// many to one
	private com.justonetech.system.domain.SysCodeDetail regType;
	private com.justonetech.system.domain.SysUser acceptUser;

	// collections
	private java.util.Set<com.justonetech.system.domain.SysUser> sysUsers;



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
	 * Return the value associated with the column: PERSON_NAME
	 */
	public java.lang.String getPersonName () {
		return personName;
	}

	/**
	 * Set the value related to the column: PERSON_NAME
	 * @param personName the PERSON_NAME value
	 */
	public void setPersonName (java.lang.String personName) {
		this.personName = personName;
	}


	/**
	 * Return the value associated with the column: MOBILE
	 */
	public java.lang.String getMobile () {
		return mobile;
	}

	/**
	 * Set the value related to the column: MOBILE
	 * @param mobile the MOBILE value
	 */
	public void setMobile (java.lang.String mobile) {
		this.mobile = mobile;
	}


	/**
	 * Return the value associated with the column: GD_CODE
	 */
	public java.lang.String getGdCode () {
		return gdCode;
	}

	/**
	 * Set the value related to the column: GD_CODE
	 * @param gdCode the GD_CODE value
	 */
	public void setGdCode (java.lang.String gdCode) {
		this.gdCode = gdCode;
	}


	/**
	 * Return the value associated with the column: BJBH
	 */
	public java.lang.String getBjbh () {
		return bjbh;
	}

	/**
	 * Set the value related to the column: BJBH
	 * @param bjbh the BJBH value
	 */
	public void setBjbh (java.lang.String bjbh) {
		this.bjbh = bjbh;
	}


	/**
	 * Return the value associated with the column: PROJECT_CARD
	 */
	public java.lang.String getProjectCard () {
		return projectCard;
	}

	/**
	 * Set the value related to the column: PROJECT_CARD
	 * @param projectCard the PROJECT_CARD value
	 */
	public void setProjectCard (java.lang.String projectCard) {
		this.projectCard = projectCard;
	}


	/**
	 * Return the value associated with the column: PROJECT_NAME
	 */
	public java.lang.String getProjectName () {
		return projectName;
	}

	/**
	 * Set the value related to the column: PROJECT_NAME
	 * @param projectName the PROJECT_NAME value
	 */
	public void setProjectName (java.lang.String projectName) {
		this.projectName = projectName;
	}


	/**
	 * Return the value associated with the column: UNIT_CODE
	 */
	public java.lang.String getUnitCode () {
		return unitCode;
	}

	/**
	 * Set the value related to the column: UNIT_CODE
	 * @param unitCode the UNIT_CODE value
	 */
	public void setUnitCode (java.lang.String unitCode) {
		this.unitCode = unitCode;
	}


	/**
	 * Return the value associated with the column: UNIT_IDENTIFY_CODE
	 */
	public java.lang.String getUnitIdentifyCode () {
		return unitIdentifyCode;
	}

	/**
	 * Set the value related to the column: UNIT_IDENTIFY_CODE
	 * @param unitIdentifyCode the UNIT_IDENTIFY_CODE value
	 */
	public void setUnitIdentifyCode (java.lang.String unitIdentifyCode) {
		this.unitIdentifyCode = unitIdentifyCode;
	}


	/**
	 * Return the value associated with the column: UNIT_NAME
	 */
	public java.lang.String getUnitName () {
		return unitName;
	}

	/**
	 * Set the value related to the column: UNIT_NAME
	 * @param unitName the UNIT_NAME value
	 */
	public void setUnitName (java.lang.String unitName) {
		this.unitName = unitName;
	}


	/**
	 * Return the value associated with the column: REG_RESOURCE
	 */
	public java.lang.Integer getRegResource () {
		return regResource;
	}

	/**
	 * Set the value related to the column: REG_RESOURCE
	 * @param regResource the REG_RESOURCE value
	 */
	public void setRegResource (java.lang.Integer regResource) {
		this.regResource = regResource;
	}


	/**
	 * Return the value associated with the column: ACCEPT_OPINION
	 */
	public java.lang.Integer getAcceptOpinion () {
		return acceptOpinion;
	}

	/**
	 * Set the value related to the column: ACCEPT_OPINION
	 * @param acceptOpinion the ACCEPT_OPINION value
	 */
	public void setAcceptOpinion (java.lang.Integer acceptOpinion) {
		this.acceptOpinion = acceptOpinion;
	}


	/**
	 * Return the value associated with the column: ACCEPT_DESC
	 */
	public java.lang.String getAcceptDesc () {
		return acceptDesc;
	}

	/**
	 * Set the value related to the column: ACCEPT_DESC
	 * @param acceptDesc the ACCEPT_DESC value
	 */
	public void setAcceptDesc (java.lang.String acceptDesc) {
		this.acceptDesc = acceptDesc;
	}


	/**
	 * Return the value associated with the column: ACCEPT_DATETIME
	 */
	public java.sql.Timestamp getAcceptDatetime () {
		return acceptDatetime;
	}

	/**
	 * Set the value related to the column: ACCEPT_DATETIME
	 * @param acceptDatetime the ACCEPT_DATETIME value
	 */
	public void setAcceptDatetime (java.sql.Timestamp acceptDatetime) {
		this.acceptDatetime = acceptDatetime;
	}


	/**
	 * Return the value associated with the column: REG_TYPE
	 */
	public com.justonetech.system.domain.SysCodeDetail getRegType () {
		return regType;
	}

	/**
	 * Set the value related to the column: REG_TYPE
	 * @param regType the REG_TYPE value
	 */
	public void setRegType (com.justonetech.system.domain.SysCodeDetail regType) {
		this.regType = regType;
	}


	/**
	 * Return the value associated with the column: ACCEPT_USER_ID
	 */
	public com.justonetech.system.domain.SysUser getAcceptUser () {
		return acceptUser;
	}

	/**
	 * Set the value related to the column: ACCEPT_USER_ID
	 * @param acceptUser the ACCEPT_USER_ID value
	 */
	public void setAcceptUser (com.justonetech.system.domain.SysUser acceptUser) {
		this.acceptUser = acceptUser;
	}


	/**
	 * Return the value associated with the column: sysUsers
	 */
	public java.util.Set<com.justonetech.system.domain.SysUser> getSysUsers () {
		return sysUsers;
	}

	/**
	 * Set the value related to the column: sysUsers
	 * @param sysUsers the sysUsers value
	 */
	public void setSysUsers (java.util.Set<com.justonetech.system.domain.SysUser> sysUsers) {
		this.sysUsers = sysUsers;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.system.domain.SysRegPerson)) return false;
		else {
			com.justonetech.system.domain.SysRegPerson sysRegPerson = (com.justonetech.system.domain.SysRegPerson) obj;
			if (null == this.getId() || null == sysRegPerson.getId()) return false;
			else return (this.getId().equals(sysRegPerson.getId()));
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
		builder.append(personName);
		builder.append(mobile);
		builder.append(gdCode);
		builder.append(bjbh);
		builder.append(projectCard);
		builder.append(projectName);
		builder.append(unitCode);
		builder.append(unitIdentifyCode);
		builder.append(unitName);
		builder.append(regResource);
		builder.append(acceptOpinion);
		builder.append(acceptDesc);
		builder.append(acceptDatetime);
		return builder.toString();
	}


}