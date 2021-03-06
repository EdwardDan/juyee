package com.justonetech.biz.domain.base;


import com.justonetech.biz.domain.SharePersonQualify;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHARE_PERSON_QUALIFY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 注册人员资质证书
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 注册人员资质证书
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : share
 * Projectable : false
 *
 * @hibernate.class
 *  table="SHARE_PERSON_QUALIFY"
 */

public abstract class BaseSharePersonQualify implements Serializable {

	public static String REF = "SharePersonQualify";
	public static String PROP_REG_UNIT_NAME = "regUnitName";
	public static String PROP_REG_UNIT_CODE = "regUnitCode";
	public static String PROP_SEAL_CODE = "sealCode";
	public static String PROP_PERSON_CARD_TYPE = "personCardType";
	public static String PROP_PERSON_NAME = "personName";
	public static String PROP_JL_SPECIALITY_TYPE_DESC2 = "jlSpecialityTypeDesc2";
	public static String PROP_REG_CODE = "regCode";
	public static String PROP_VALID_DATE = "validDate";
	public static String PROP_JL_SPECIALITY_TYPE1 = "jlSpecialityType1";
	public static String PROP_JL_SPECIALITY_TYPE2 = "jlSpecialityType2";
	public static String PROP_CARD_NO = "cardNo";
	public static String PROP_QUALIFY_LEVEL_DESC = "qualifyLevelDesc";
	public static String PROP_QUALIFY_TYPE_DESC = "qualifyTypeDesc";
	public static String PROP_PERSON_BIRTH_DATE = "personBirthDate";
	public static String PROP_JL_SPECIALITY_TYPE_DESC1 = "jlSpecialityTypeDesc1";
	public static String PROP_REG_QUALIFY_CODE = "regQualifyCode";
	public static String PROP_REG_DATETIME = "regDatetime";
	public static String PROP_REG_UNIT_ID = "regUnitId";
	public static String PROP_CARD_NO15 = "cardNo15";
	public static String PROP_QUALIFY_BELONG = "qualifyBelong";
	public static String PROP_JZ_SPECIALITY_TYPE = "jzSpecialityType";
	public static String PROP_PERSON_CARD_TYPE_DESC = "personCardTypeDesc";
	public static String PROP_QUALIFY_BELONG_DESC = "qualifyBelongDesc";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_QUALIFY_STATUS = "qualifyStatus";
	public static String PROP_QUALIFY_TYPE = "qualifyType";
	public static String PROP_QUALIFY_LEVEL = "qualifyLevel";
	public static String PROP_PERSON_ID = "personId";
	public static String PROP_PERSON_SEX = "personSex";
	public static String PROP_ID = "id";
	public static String PROP_JZ_SPECIALITY_TYPE_DESC = "jzSpecialityTypeDesc";
	public static String PROP_QUALIFY_STATUS_DESC = "qualifyStatusDesc";


	// constructors
	public BaseSharePersonQualify() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSharePersonQualify(Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*人员标识*/
    /*人员标识*/
	private Long personId;

    /*姓名*/
    /*姓名*/
	private String personName;

    /*证件类型*/
    /*证件类型*/
	private Long personCardType;

    /*证件类型描述*/
    /*证件类型描述*/
	private String personCardTypeDesc;

    /*证件号*/
    /*证件号*/
	private String cardNo;

    /*15位身份证号*/
    /*15位身份证号*/
	private String cardNo15;

    /*性别*/
    /*性别*/
	private String personSex;

    /*出生日期*/
    /*出生日期*/
	private java.sql.Date personBirthDate;

    /*注册证书类型*/
    /*注册证书类型*/
	private Long qualifyType;

    /*注册证书类型(中文)*/
    /*注册证书类型(中文)*/
	private String qualifyTypeDesc;

    /*注册证书等级*/
    /*注册证书等级*/
	private String qualifyLevel;

    /*注册证书等级(中文)*/
    /*注册证书等级(中文)*/
	private String qualifyLevelDesc;

    /*注册证书单位名称*/
    /*注册证书单位名称*/
	private String regUnitName;

    /*注册单位代码*/
    /*注册单位代码*/
	private String regUnitCode;

    /*注册单位ID*/
    /*注册单位ID*/
	private Long regUnitId;

    /*注册证书编号*/
    /*注册证书编号*/
	private String regQualifyCode;

    /*注册号*/
    /*注册号*/
	private String regCode;

    /*印章号*/
    /*印章号*/
	private String sealCode;

    /*有效期*/
    /*有效期*/
	private java.sql.Date validDate;

    /*注册时间*/
    /*注册时间*/
	private java.sql.Timestamp regDatetime;

    /*证书状态*/
    /*证书状态*/
	private Long qualifyStatus;

    /*证书状态（中文）*/
    /*证书状态（中文）*/
	private String qualifyStatusDesc;

    /*证书管理属地*/
    /*证书管理属地*/
	private Long qualifyBelong;

    /*证书管理属地(中文)*/
    /*证书管理属地(中文)*/
	private String qualifyBelongDesc;

    /*注册监理工程师证书专业1*/
    /*注册监理工程师证书专业1*/
	private Long jlSpecialityType1;

    /*注册监理工程师证书专业1(中文)*/
    /*注册监理工程师证书专业1(中文)*/
	private String jlSpecialityTypeDesc1;

    /*注册监理工程师证书专业2*/
    /*注册监理工程师证书专业2*/
	private Long jlSpecialityType2;

    /*注册监理工程师证书专业2(中文)*/
    /*注册监理工程师证书专业2(中文)*/
	private String jlSpecialityTypeDesc2;

    /*建造师、临时建造师专业*/
    /*建造师、临时建造师专业*/
	private String jzSpecialityType;

    /*建造师、临时建造师专业(中文)*/
    /*建造师、临时建造师专业(中文)*/
	private String jzSpecialityTypeDesc;

    /*中间数据库数据更新时间*/
    /*中间数据库数据更新时间*/
	private java.sql.Timestamp updateTime;




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
	 * Return the value associated with the column: PERSON_ID
	 */
	public Long getPersonId () {
		return personId;
	}

	/**
	 * Set the value related to the column: PERSON_ID
	 * @param personId the PERSON_ID value
	 */
	public void setPersonId (Long personId) {
		this.personId = personId;
	}


	/**
	 * Return the value associated with the column: PERSON_NAME
	 */
	public String getPersonName () {
		return personName;
	}

	/**
	 * Set the value related to the column: PERSON_NAME
	 * @param personName the PERSON_NAME value
	 */
	public void setPersonName (String personName) {
		this.personName = personName;
	}


	/**
	 * Return the value associated with the column: PERSON_CARD_TYPE
	 */
	public Long getPersonCardType () {
		return personCardType;
	}

	/**
	 * Set the value related to the column: PERSON_CARD_TYPE
	 * @param personCardType the PERSON_CARD_TYPE value
	 */
	public void setPersonCardType (Long personCardType) {
		this.personCardType = personCardType;
	}


	/**
	 * Return the value associated with the column: PERSON_CARD_TYPE_DESC
	 */
	public String getPersonCardTypeDesc () {
		return personCardTypeDesc;
	}

	/**
	 * Set the value related to the column: PERSON_CARD_TYPE_DESC
	 * @param personCardTypeDesc the PERSON_CARD_TYPE_DESC value
	 */
	public void setPersonCardTypeDesc (String personCardTypeDesc) {
		this.personCardTypeDesc = personCardTypeDesc;
	}


	/**
	 * Return the value associated with the column: CARD_NO
	 */
	public String getCardNo () {
		return cardNo;
	}

	/**
	 * Set the value related to the column: CARD_NO
	 * @param cardNo the CARD_NO value
	 */
	public void setCardNo (String cardNo) {
		this.cardNo = cardNo;
	}


	/**
	 * Return the value associated with the column: CARD_NO_15
	 */
	public String getCardNo15 () {
		return cardNo15;
	}

	/**
	 * Set the value related to the column: CARD_NO_15
	 * @param cardNo15 the CARD_NO_15 value
	 */
	public void setCardNo15 (String cardNo15) {
		this.cardNo15 = cardNo15;
	}


	/**
	 * Return the value associated with the column: PERSON_SEX
	 */
	public String getPersonSex () {
		return personSex;
	}

	/**
	 * Set the value related to the column: PERSON_SEX
	 * @param personSex the PERSON_SEX value
	 */
	public void setPersonSex (String personSex) {
		this.personSex = personSex;
	}


	/**
	 * Return the value associated with the column: PERSON_BIRTH_DATE
	 */
	public java.sql.Date getPersonBirthDate () {
		return personBirthDate;
	}

	/**
	 * Set the value related to the column: PERSON_BIRTH_DATE
	 * @param personBirthDate the PERSON_BIRTH_DATE value
	 */
	public void setPersonBirthDate (java.sql.Date personBirthDate) {
		this.personBirthDate = personBirthDate;
	}


	/**
	 * Return the value associated with the column: QUALIFY_TYPE
	 */
	public Long getQualifyType () {
		return qualifyType;
	}

	/**
	 * Set the value related to the column: QUALIFY_TYPE
	 * @param qualifyType the QUALIFY_TYPE value
	 */
	public void setQualifyType (Long qualifyType) {
		this.qualifyType = qualifyType;
	}


	/**
	 * Return the value associated with the column: QUALIFY_TYPE_DESC
	 */
	public String getQualifyTypeDesc () {
		return qualifyTypeDesc;
	}

	/**
	 * Set the value related to the column: QUALIFY_TYPE_DESC
	 * @param qualifyTypeDesc the QUALIFY_TYPE_DESC value
	 */
	public void setQualifyTypeDesc (String qualifyTypeDesc) {
		this.qualifyTypeDesc = qualifyTypeDesc;
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
	 * Return the value associated with the column: QUALIFY_LEVEL_DESC
	 */
	public String getQualifyLevelDesc () {
		return qualifyLevelDesc;
	}

	/**
	 * Set the value related to the column: QUALIFY_LEVEL_DESC
	 * @param qualifyLevelDesc the QUALIFY_LEVEL_DESC value
	 */
	public void setQualifyLevelDesc (String qualifyLevelDesc) {
		this.qualifyLevelDesc = qualifyLevelDesc;
	}


	/**
	 * Return the value associated with the column: REG_UNIT_NAME
	 */
	public String getRegUnitName () {
		return regUnitName;
	}

	/**
	 * Set the value related to the column: REG_UNIT_NAME
	 * @param regUnitName the REG_UNIT_NAME value
	 */
	public void setRegUnitName (String regUnitName) {
		this.regUnitName = regUnitName;
	}


	/**
	 * Return the value associated with the column: REG_UNIT_CODE
	 */
	public String getRegUnitCode () {
		return regUnitCode;
	}

	/**
	 * Set the value related to the column: REG_UNIT_CODE
	 * @param regUnitCode the REG_UNIT_CODE value
	 */
	public void setRegUnitCode (String regUnitCode) {
		this.regUnitCode = regUnitCode;
	}


	/**
	 * Return the value associated with the column: REG_UNIT_ID
	 */
	public Long getRegUnitId () {
		return regUnitId;
	}

	/**
	 * Set the value related to the column: REG_UNIT_ID
	 * @param regUnitId the REG_UNIT_ID value
	 */
	public void setRegUnitId (Long regUnitId) {
		this.regUnitId = regUnitId;
	}


	/**
	 * Return the value associated with the column: REG_QUALIFY_CODE
	 */
	public String getRegQualifyCode () {
		return regQualifyCode;
	}

	/**
	 * Set the value related to the column: REG_QUALIFY_CODE
	 * @param regQualifyCode the REG_QUALIFY_CODE value
	 */
	public void setRegQualifyCode (String regQualifyCode) {
		this.regQualifyCode = regQualifyCode;
	}


	/**
	 * Return the value associated with the column: REG_CODE
	 */
	public String getRegCode () {
		return regCode;
	}

	/**
	 * Set the value related to the column: REG_CODE
	 * @param regCode the REG_CODE value
	 */
	public void setRegCode (String regCode) {
		this.regCode = regCode;
	}


	/**
	 * Return the value associated with the column: SEAL_CODE
	 */
	public String getSealCode () {
		return sealCode;
	}

	/**
	 * Set the value related to the column: SEAL_CODE
	 * @param sealCode the SEAL_CODE value
	 */
	public void setSealCode (String sealCode) {
		this.sealCode = sealCode;
	}


	/**
	 * Return the value associated with the column: VALID_DATE
	 */
	public java.sql.Date getValidDate () {
		return validDate;
	}

	/**
	 * Set the value related to the column: VALID_DATE
	 * @param validDate the VALID_DATE value
	 */
	public void setValidDate (java.sql.Date validDate) {
		this.validDate = validDate;
	}


	/**
	 * Return the value associated with the column: REG_DATETIME
	 */
	public java.sql.Timestamp getRegDatetime () {
		return regDatetime;
	}

	/**
	 * Set the value related to the column: REG_DATETIME
	 * @param regDatetime the REG_DATETIME value
	 */
	public void setRegDatetime (java.sql.Timestamp regDatetime) {
		this.regDatetime = regDatetime;
	}


	/**
	 * Return the value associated with the column: QUALIFY_STATUS
	 */
	public Long getQualifyStatus () {
		return qualifyStatus;
	}

	/**
	 * Set the value related to the column: QUALIFY_STATUS
	 * @param qualifyStatus the QUALIFY_STATUS value
	 */
	public void setQualifyStatus (Long qualifyStatus) {
		this.qualifyStatus = qualifyStatus;
	}


	/**
	 * Return the value associated with the column: QUALIFY_STATUS_DESC
	 */
	public String getQualifyStatusDesc () {
		return qualifyStatusDesc;
	}

	/**
	 * Set the value related to the column: QUALIFY_STATUS_DESC
	 * @param qualifyStatusDesc the QUALIFY_STATUS_DESC value
	 */
	public void setQualifyStatusDesc (String qualifyStatusDesc) {
		this.qualifyStatusDesc = qualifyStatusDesc;
	}


	/**
	 * Return the value associated with the column: QUALIFY_BELONG
	 */
	public Long getQualifyBelong () {
		return qualifyBelong;
	}

	/**
	 * Set the value related to the column: QUALIFY_BELONG
	 * @param qualifyBelong the QUALIFY_BELONG value
	 */
	public void setQualifyBelong (Long qualifyBelong) {
		this.qualifyBelong = qualifyBelong;
	}


	/**
	 * Return the value associated with the column: QUALIFY_BELONG_DESC
	 */
	public String getQualifyBelongDesc () {
		return qualifyBelongDesc;
	}

	/**
	 * Set the value related to the column: QUALIFY_BELONG_DESC
	 * @param qualifyBelongDesc the QUALIFY_BELONG_DESC value
	 */
	public void setQualifyBelongDesc (String qualifyBelongDesc) {
		this.qualifyBelongDesc = qualifyBelongDesc;
	}


	/**
	 * Return the value associated with the column: JL_SPECIALITY_TYPE1
	 */
	public Long getJlSpecialityType1 () {
		return jlSpecialityType1;
	}

	/**
	 * Set the value related to the column: JL_SPECIALITY_TYPE1
	 * @param jlSpecialityType1 the JL_SPECIALITY_TYPE1 value
	 */
	public void setJlSpecialityType1 (Long jlSpecialityType1) {
		this.jlSpecialityType1 = jlSpecialityType1;
	}


	/**
	 * Return the value associated with the column: JL_SPECIALITY_TYPE_DESC1
	 */
	public String getJlSpecialityTypeDesc1 () {
		return jlSpecialityTypeDesc1;
	}

	/**
	 * Set the value related to the column: JL_SPECIALITY_TYPE_DESC1
	 * @param jlSpecialityTypeDesc1 the JL_SPECIALITY_TYPE_DESC1 value
	 */
	public void setJlSpecialityTypeDesc1 (String jlSpecialityTypeDesc1) {
		this.jlSpecialityTypeDesc1 = jlSpecialityTypeDesc1;
	}


	/**
	 * Return the value associated with the column: JL_SPECIALITY_TYPE2
	 */
	public Long getJlSpecialityType2 () {
		return jlSpecialityType2;
	}

	/**
	 * Set the value related to the column: JL_SPECIALITY_TYPE2
	 * @param jlSpecialityType2 the JL_SPECIALITY_TYPE2 value
	 */
	public void setJlSpecialityType2 (Long jlSpecialityType2) {
		this.jlSpecialityType2 = jlSpecialityType2;
	}


	/**
	 * Return the value associated with the column: JL_SPECIALITY_TYPE_DESC2
	 */
	public String getJlSpecialityTypeDesc2 () {
		return jlSpecialityTypeDesc2;
	}

	/**
	 * Set the value related to the column: JL_SPECIALITY_TYPE_DESC2
	 * @param jlSpecialityTypeDesc2 the JL_SPECIALITY_TYPE_DESC2 value
	 */
	public void setJlSpecialityTypeDesc2 (String jlSpecialityTypeDesc2) {
		this.jlSpecialityTypeDesc2 = jlSpecialityTypeDesc2;
	}


	/**
	 * Return the value associated with the column: JZ_SPECIALITY_TYPE
	 */
	public String getJzSpecialityType () {
		return jzSpecialityType;
	}

	/**
	 * Set the value related to the column: JZ_SPECIALITY_TYPE
	 * @param jzSpecialityType the JZ_SPECIALITY_TYPE value
	 */
	public void setJzSpecialityType (String jzSpecialityType) {
		this.jzSpecialityType = jzSpecialityType;
	}


	/**
	 * Return the value associated with the column: JZ_SPECIALITY_TYPE_DESC
	 */
	public String getJzSpecialityTypeDesc () {
		return jzSpecialityTypeDesc;
	}

	/**
	 * Set the value related to the column: JZ_SPECIALITY_TYPE_DESC
	 * @param jzSpecialityTypeDesc the JZ_SPECIALITY_TYPE_DESC value
	 */
	public void setJzSpecialityTypeDesc (String jzSpecialityTypeDesc) {
		this.jzSpecialityTypeDesc = jzSpecialityTypeDesc;
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



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof SharePersonQualify)) return false;
		else {
			SharePersonQualify sharePersonQualify = (SharePersonQualify) obj;
			if (null == this.getId() || null == sharePersonQualify.getId()) return false;
			else return (this.getId().equals(sharePersonQualify.getId()));
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
		builder.append(personId);
		builder.append(personName);
		builder.append(personCardType);
		builder.append(personCardTypeDesc);
		builder.append(cardNo);
		builder.append(cardNo15);
		builder.append(personSex);
		builder.append(personBirthDate);
		builder.append(qualifyType);
		builder.append(qualifyTypeDesc);
		builder.append(qualifyLevel);
		builder.append(qualifyLevelDesc);
		builder.append(regUnitName);
		builder.append(regUnitCode);
		builder.append(regUnitId);
		builder.append(regQualifyCode);
		builder.append(regCode);
		builder.append(sealCode);
		builder.append(validDate);
		builder.append(regDatetime);
		builder.append(qualifyStatus);
		builder.append(qualifyStatusDesc);
		builder.append(qualifyBelong);
		builder.append(qualifyBelongDesc);
		builder.append(jlSpecialityType1);
		builder.append(jlSpecialityTypeDesc1);
		builder.append(jlSpecialityType2);
		builder.append(jlSpecialityTypeDesc2);
		builder.append(jzSpecialityType);
		builder.append(jzSpecialityTypeDesc);
		builder.append(updateTime);
		return builder.toString();
	}


}