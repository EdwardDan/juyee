package com.justonetech.system.domain.base;

import com.justonetech.biz.domain.ShareUnitQualify;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHARE_UNIT_QUALIFY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 企业资质信息
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 企业资质信息
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : share
 * Projectable : false
 *
 * @hibernate.class
 *  table="SHARE_UNIT_QUALIFY"
 */

public abstract class BaseShareUnitQualify implements Serializable {

	public static String REF = "ShareUnitQualify";
	public static String PROP_UNIT_BELONG_DESC = "unitBelongDesc";
	public static String PROP_IS_MAIN_QUALIFY = "isMainQualify";
	public static String PROP_LINK_PHONE = "linkPhone";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_TEMP_DATETIME = "tempDatetime";
	public static String PROP_ACCEPT_DATETIME = "acceptDatetime";
	public static String PROP_VALID_DATETIME = "validDatetime";
	public static String PROP_QUALIFY_CODE = "qualifyCode";
	public static String PROP_HOLD_WORK_SCOPE = "holdWorkScope";
	public static String PROP_QUALIFY_TYPE = "qualifyType";
	public static String PROP_QUALIFY_LEVEL_DESC = "qualifyLevelDesc";
	public static String PROP_QUALIFY_TYPE_DESC = "qualifyTypeDesc";
	public static String PROP_QUALIFY_BIG_TYPE = "qualifyBigType";
	public static String PROP_UNIT_BELONG_ID = "unitBelongId";
	public static String PROP_QUALIFY_LEVEL = "qualifyLevel";
	public static String PROP_LINK_MOBILE = "linkMobile";
	public static String PROP_QUALIFY_BIG_TYPE_DESC = "qualifyBigTypeDesc";
	public static String PROP_ID = "id";
	public static String PROP_LINK_MAN = "linkMan";
	public static String PROP_UNIT_ID = "unitId";
	public static String PROP_LIMIT = "limit";


	// constructors
	public BaseShareUnitQualify() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShareUnitQualify(Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*企业标识*/
    /*企业标识*/
	private Long unitId;

    /*企业类别*/
    /*企业类别*/
	private String qualifyType;

    /*企业类别描述*/
    /*企业类别描述*/
	private String qualifyTypeDesc;

    /*资质等级*/
    /*资质等级*/
	private Long qualifyLevel;

    /*资质等级描述*/
    /*资质等级描述*/
	private String qualifyLevelDesc;

    /*是否主项资质（1是，0否）*/
    /*是否主项资质（1是，0否）*/
	private Boolean isMainQualify;

    /*限定*/
    /*限定*/
	private String limit;

    /*资质大类*/
    /*资质大类*/
	private Long qualifyBigType;

    /*资质大类描述*/
    /*资质大类描述*/
	private String qualifyBigTypeDesc;

    /*可承担工程范围*/
    /*可承担工程范围*/
	private String holdWorkScope;

    /*资质证书编号*/
    /*资质证书编号*/
	private String qualifyCode;

    /*批准时间*/
    /*批准时间*/
	private java.sql.Timestamp acceptDatetime;

    /*资质有效期*/
    /*资质有效期*/
	private java.sql.Timestamp validDatetime;

    /*暂定日期*/
    /*暂定日期*/
	private java.sql.Timestamp tempDatetime;

    /*企业隶属关系*/
    /*企业隶属关系*/
	private Long unitBelongId;

    /*企业隶属关系描述*/
    /*企业隶属关系描述*/
	private String unitBelongDesc;

    /*联系人姓名*/
    /*联系人姓名*/
	private String linkMan;

    /*联系人电话*/
    /*联系人电话*/
	private String linkPhone;

    /*联系人手机*/
    /*联系人手机*/
	private String linkMobile;

    /*修改时间*/
    /*修改时间*/
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
	 * Return the value associated with the column: UNIT_ID
	 */
	public Long getUnitId () {
		return unitId;
	}

	/**
	 * Set the value related to the column: UNIT_ID
	 * @param unitId the UNIT_ID value
	 */
	public void setUnitId (Long unitId) {
		this.unitId = unitId;
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
	public Long getQualifyLevel () {
		return qualifyLevel;
	}

	/**
	 * Set the value related to the column: QUALIFY_LEVEL
	 * @param qualifyLevel the QUALIFY_LEVEL value
	 */
	public void setQualifyLevel (Long qualifyLevel) {
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
	 * Return the value associated with the column: IS_MAIN_QUALIFY
	 */
	public Boolean getIsMainQualify () {
		return isMainQualify;
	}

	/**
	 * Set the value related to the column: IS_MAIN_QUALIFY
	 * @param isMainQualify the IS_MAIN_QUALIFY value
	 */
	public void setIsMainQualify (Boolean isMainQualify) {
		this.isMainQualify = isMainQualify;
	}


	/**
	 * Return the value associated with the column: LIMIT
	 */
	public String getLimit () {
		return limit;
	}

	/**
	 * Set the value related to the column: LIMIT
	 * @param limit the LIMIT value
	 */
	public void setLimit (String limit) {
		this.limit = limit;
	}


	/**
	 * Return the value associated with the column: QUALIFY_BIG_TYPE
	 */
	public Long getQualifyBigType () {
		return qualifyBigType;
	}

	/**
	 * Set the value related to the column: QUALIFY_BIG_TYPE
	 * @param qualifyBigType the QUALIFY_BIG_TYPE value
	 */
	public void setQualifyBigType (Long qualifyBigType) {
		this.qualifyBigType = qualifyBigType;
	}


	/**
	 * Return the value associated with the column: QUALIFY_BIG_TYPE_DESC
	 */
	public String getQualifyBigTypeDesc () {
		return qualifyBigTypeDesc;
	}

	/**
	 * Set the value related to the column: QUALIFY_BIG_TYPE_DESC
	 * @param qualifyBigTypeDesc the QUALIFY_BIG_TYPE_DESC value
	 */
	public void setQualifyBigTypeDesc (String qualifyBigTypeDesc) {
		this.qualifyBigTypeDesc = qualifyBigTypeDesc;
	}


	/**
	 * Return the value associated with the column: HOLD_WORK_SCOPE
	 */
	public String getHoldWorkScope () {
		return holdWorkScope;
	}

	/**
	 * Set the value related to the column: HOLD_WORK_SCOPE
	 * @param holdWorkScope the HOLD_WORK_SCOPE value
	 */
	public void setHoldWorkScope (String holdWorkScope) {
		this.holdWorkScope = holdWorkScope;
	}


	/**
	 * Return the value associated with the column: QUALIFY_CODE
	 */
	public String getQualifyCode () {
		return qualifyCode;
	}

	/**
	 * Set the value related to the column: QUALIFY_CODE
	 * @param qualifyCode the QUALIFY_CODE value
	 */
	public void setQualifyCode (String qualifyCode) {
		this.qualifyCode = qualifyCode;
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
	 * Return the value associated with the column: VALID_DATETIME
	 */
	public java.sql.Timestamp getValidDatetime () {
		return validDatetime;
	}

	/**
	 * Set the value related to the column: VALID_DATETIME
	 * @param validDatetime the VALID_DATETIME value
	 */
	public void setValidDatetime (java.sql.Timestamp validDatetime) {
		this.validDatetime = validDatetime;
	}


	/**
	 * Return the value associated with the column: TEMP_DATETIME
	 */
	public java.sql.Timestamp getTempDatetime () {
		return tempDatetime;
	}

	/**
	 * Set the value related to the column: TEMP_DATETIME
	 * @param tempDatetime the TEMP_DATETIME value
	 */
	public void setTempDatetime (java.sql.Timestamp tempDatetime) {
		this.tempDatetime = tempDatetime;
	}


	/**
	 * Return the value associated with the column: UNIT_BELONG_ID
	 */
	public Long getUnitBelongId () {
		return unitBelongId;
	}

	/**
	 * Set the value related to the column: UNIT_BELONG_ID
	 * @param unitBelongId the UNIT_BELONG_ID value
	 */
	public void setUnitBelongId (Long unitBelongId) {
		this.unitBelongId = unitBelongId;
	}


	/**
	 * Return the value associated with the column: UNIT_BELONG_DESC
	 */
	public String getUnitBelongDesc () {
		return unitBelongDesc;
	}

	/**
	 * Set the value related to the column: UNIT_BELONG_DESC
	 * @param unitBelongDesc the UNIT_BELONG_DESC value
	 */
	public void setUnitBelongDesc (String unitBelongDesc) {
		this.unitBelongDesc = unitBelongDesc;
	}


	/**
	 * Return the value associated with the column: LINK_MAN
	 */
	public String getLinkMan () {
		return linkMan;
	}

	/**
	 * Set the value related to the column: LINK_MAN
	 * @param linkMan the LINK_MAN value
	 */
	public void setLinkMan (String linkMan) {
		this.linkMan = linkMan;
	}


	/**
	 * Return the value associated with the column: LINK_PHONE
	 */
	public String getLinkPhone () {
		return linkPhone;
	}

	/**
	 * Set the value related to the column: LINK_PHONE
	 * @param linkPhone the LINK_PHONE value
	 */
	public void setLinkPhone (String linkPhone) {
		this.linkPhone = linkPhone;
	}


	/**
	 * Return the value associated with the column: LINK_MOBILE
	 */
	public String getLinkMobile () {
		return linkMobile;
	}

	/**
	 * Set the value related to the column: LINK_MOBILE
	 * @param linkMobile the LINK_MOBILE value
	 */
	public void setLinkMobile (String linkMobile) {
		this.linkMobile = linkMobile;
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
		if (!(obj instanceof ShareUnitQualify)) return false;
		else {
			ShareUnitQualify shareUnitQualify = (ShareUnitQualify) obj;
			if (null == this.getId() || null == shareUnitQualify.getId()) return false;
			else return (this.getId().equals(shareUnitQualify.getId()));
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
		builder.append(unitId);
		builder.append(qualifyType);
		builder.append(qualifyTypeDesc);
		builder.append(qualifyLevel);
		builder.append(qualifyLevelDesc);
		builder.append(isMainQualify);
		builder.append(limit);
		builder.append(qualifyBigType);
		builder.append(qualifyBigTypeDesc);
		builder.append(holdWorkScope);
		builder.append(qualifyCode);
		builder.append(acceptDatetime);
		builder.append(validDatetime);
		builder.append(tempDatetime);
		builder.append(unitBelongId);
		builder.append(unitBelongDesc);
		builder.append(linkMan);
		builder.append(linkPhone);
		builder.append(linkMobile);
		builder.append(updateTime);
		return builder.toString();
	}


}