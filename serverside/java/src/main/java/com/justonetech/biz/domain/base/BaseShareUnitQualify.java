package com.justonetech.biz.domain.base;

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

public abstract class BaseShareUnitQualify  implements Serializable {

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
	public BaseShareUnitQualify () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShareUnitQualify (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*企业标识*/
    /*企业标识*/
	private java.lang.Long unitId;
	
    /*企业类别*/
    /*企业类别*/
	private java.lang.String qualifyType;
	
    /*企业类别描述*/
    /*企业类别描述*/
	private java.lang.String qualifyTypeDesc;
	
    /*资质等级*/
    /*资质等级*/
	private java.lang.Long qualifyLevel;
	
    /*资质等级描述*/
    /*资质等级描述*/
	private java.lang.String qualifyLevelDesc;
	
    /*是否主项资质（1是，0否）*/
    /*是否主项资质（1是，0否）*/
	private java.lang.Boolean isMainQualify;
	
    /*限定*/
    /*限定*/
	private java.lang.String limit;
	
    /*资质大类*/
    /*资质大类*/
	private java.lang.Long qualifyBigType;
	
    /*资质大类描述*/
    /*资质大类描述*/
	private java.lang.String qualifyBigTypeDesc;
	
    /*可承担工程范围*/
    /*可承担工程范围*/
	private java.lang.String holdWorkScope;
	
    /*资质证书编号*/
    /*资质证书编号*/
	private java.lang.String qualifyCode;
	
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
	private java.lang.Long unitBelongId;
	
    /*企业隶属关系描述*/
    /*企业隶属关系描述*/
	private java.lang.String unitBelongDesc;
	
    /*联系人姓名*/
    /*联系人姓名*/
	private java.lang.String linkMan;
	
    /*联系人电话*/
    /*联系人电话*/
	private java.lang.String linkPhone;
	
    /*联系人手机*/
    /*联系人手机*/
	private java.lang.String linkMobile;
	
    /*修改时间*/
    /*修改时间*/
	private java.sql.Timestamp updateTime;
	



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
	 * Return the value associated with the column: UNIT_ID
	 */
	public java.lang.Long getUnitId () {
		return unitId;
	}

	/**
	 * Set the value related to the column: UNIT_ID
	 * @param unitId the UNIT_ID value
	 */
	public void setUnitId (java.lang.Long unitId) {
		this.unitId = unitId;
	}


	/**
	 * Return the value associated with the column: QUALIFY_TYPE
	 */
	public java.lang.String getQualifyType () {
		return qualifyType;
	}

	/**
	 * Set the value related to the column: QUALIFY_TYPE
	 * @param qualifyType the QUALIFY_TYPE value
	 */
	public void setQualifyType (java.lang.String qualifyType) {
		this.qualifyType = qualifyType;
	}


	/**
	 * Return the value associated with the column: QUALIFY_TYPE_DESC
	 */
	public java.lang.String getQualifyTypeDesc () {
		return qualifyTypeDesc;
	}

	/**
	 * Set the value related to the column: QUALIFY_TYPE_DESC
	 * @param qualifyTypeDesc the QUALIFY_TYPE_DESC value
	 */
	public void setQualifyTypeDesc (java.lang.String qualifyTypeDesc) {
		this.qualifyTypeDesc = qualifyTypeDesc;
	}


	/**
	 * Return the value associated with the column: QUALIFY_LEVEL
	 */
	public java.lang.Long getQualifyLevel () {
		return qualifyLevel;
	}

	/**
	 * Set the value related to the column: QUALIFY_LEVEL
	 * @param qualifyLevel the QUALIFY_LEVEL value
	 */
	public void setQualifyLevel (java.lang.Long qualifyLevel) {
		this.qualifyLevel = qualifyLevel;
	}


	/**
	 * Return the value associated with the column: QUALIFY_LEVEL_DESC
	 */
	public java.lang.String getQualifyLevelDesc () {
		return qualifyLevelDesc;
	}

	/**
	 * Set the value related to the column: QUALIFY_LEVEL_DESC
	 * @param qualifyLevelDesc the QUALIFY_LEVEL_DESC value
	 */
	public void setQualifyLevelDesc (java.lang.String qualifyLevelDesc) {
		this.qualifyLevelDesc = qualifyLevelDesc;
	}


	/**
	 * Return the value associated with the column: IS_MAIN_QUALIFY
	 */
	public java.lang.Boolean getIsMainQualify () {
		return isMainQualify;
	}

	/**
	 * Set the value related to the column: IS_MAIN_QUALIFY
	 * @param isMainQualify the IS_MAIN_QUALIFY value
	 */
	public void setIsMainQualify (java.lang.Boolean isMainQualify) {
		this.isMainQualify = isMainQualify;
	}


	/**
	 * Return the value associated with the column: LIMIT
	 */
	public java.lang.String getLimit () {
		return limit;
	}

	/**
	 * Set the value related to the column: LIMIT
	 * @param limit the LIMIT value
	 */
	public void setLimit (java.lang.String limit) {
		this.limit = limit;
	}


	/**
	 * Return the value associated with the column: QUALIFY_BIG_TYPE
	 */
	public java.lang.Long getQualifyBigType () {
		return qualifyBigType;
	}

	/**
	 * Set the value related to the column: QUALIFY_BIG_TYPE
	 * @param qualifyBigType the QUALIFY_BIG_TYPE value
	 */
	public void setQualifyBigType (java.lang.Long qualifyBigType) {
		this.qualifyBigType = qualifyBigType;
	}


	/**
	 * Return the value associated with the column: QUALIFY_BIG_TYPE_DESC
	 */
	public java.lang.String getQualifyBigTypeDesc () {
		return qualifyBigTypeDesc;
	}

	/**
	 * Set the value related to the column: QUALIFY_BIG_TYPE_DESC
	 * @param qualifyBigTypeDesc the QUALIFY_BIG_TYPE_DESC value
	 */
	public void setQualifyBigTypeDesc (java.lang.String qualifyBigTypeDesc) {
		this.qualifyBigTypeDesc = qualifyBigTypeDesc;
	}


	/**
	 * Return the value associated with the column: HOLD_WORK_SCOPE
	 */
	public java.lang.String getHoldWorkScope () {
		return holdWorkScope;
	}

	/**
	 * Set the value related to the column: HOLD_WORK_SCOPE
	 * @param holdWorkScope the HOLD_WORK_SCOPE value
	 */
	public void setHoldWorkScope (java.lang.String holdWorkScope) {
		this.holdWorkScope = holdWorkScope;
	}


	/**
	 * Return the value associated with the column: QUALIFY_CODE
	 */
	public java.lang.String getQualifyCode () {
		return qualifyCode;
	}

	/**
	 * Set the value related to the column: QUALIFY_CODE
	 * @param qualifyCode the QUALIFY_CODE value
	 */
	public void setQualifyCode (java.lang.String qualifyCode) {
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
	public java.lang.Long getUnitBelongId () {
		return unitBelongId;
	}

	/**
	 * Set the value related to the column: UNIT_BELONG_ID
	 * @param unitBelongId the UNIT_BELONG_ID value
	 */
	public void setUnitBelongId (java.lang.Long unitBelongId) {
		this.unitBelongId = unitBelongId;
	}


	/**
	 * Return the value associated with the column: UNIT_BELONG_DESC
	 */
	public java.lang.String getUnitBelongDesc () {
		return unitBelongDesc;
	}

	/**
	 * Set the value related to the column: UNIT_BELONG_DESC
	 * @param unitBelongDesc the UNIT_BELONG_DESC value
	 */
	public void setUnitBelongDesc (java.lang.String unitBelongDesc) {
		this.unitBelongDesc = unitBelongDesc;
	}


	/**
	 * Return the value associated with the column: LINK_MAN
	 */
	public java.lang.String getLinkMan () {
		return linkMan;
	}

	/**
	 * Set the value related to the column: LINK_MAN
	 * @param linkMan the LINK_MAN value
	 */
	public void setLinkMan (java.lang.String linkMan) {
		this.linkMan = linkMan;
	}


	/**
	 * Return the value associated with the column: LINK_PHONE
	 */
	public java.lang.String getLinkPhone () {
		return linkPhone;
	}

	/**
	 * Set the value related to the column: LINK_PHONE
	 * @param linkPhone the LINK_PHONE value
	 */
	public void setLinkPhone (java.lang.String linkPhone) {
		this.linkPhone = linkPhone;
	}


	/**
	 * Return the value associated with the column: LINK_MOBILE
	 */
	public java.lang.String getLinkMobile () {
		return linkMobile;
	}

	/**
	 * Set the value related to the column: LINK_MOBILE
	 * @param linkMobile the LINK_MOBILE value
	 */
	public void setLinkMobile (java.lang.String linkMobile) {
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
		if (!(obj instanceof com.justonetech.biz.domain.ShareUnitQualify)) return false;
		else {
			com.justonetech.biz.domain.ShareUnitQualify shareUnitQualify = (com.justonetech.biz.domain.ShareUnitQualify) obj;
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