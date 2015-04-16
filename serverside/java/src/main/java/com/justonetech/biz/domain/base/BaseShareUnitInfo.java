package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHARE_UNIT_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 企业基本信息
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 企业基本信息
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : share
 * Projectable : false
 *
 * @hibernate.class
 *  table="SHARE_UNIT_INFO"
 */

public abstract class BaseShareUnitInfo  implements Serializable {

	public static String REF = "ShareUnitInfo";
	public static String PROP_UNIT_NAME = "unitName";
	public static String PROP_UNIT_ECO_TYPE = "unitEcoType";
	public static String PROP_REG_CITY_NAME = "regCityName";
	public static String PROP_ORG_CODE = "orgCode";
	public static String PROP_UNIT_ECO_NAME = "unitEcoName";
	public static String PROP_BELOG_PROVINCE = "belogProvince";
	public static String PROP_UNIT_CODE = "unitCode";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_REG_ADDRESS = "regAddress";
	public static String PROP_BELOG_PROVINCE_CODE = "belogProvinceCode";
	public static String PROP_REG_CITY_CODE = "regCityCode";


	// constructors
	public BaseShareUnitInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShareUnitInfo (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*单位名称*/
    /*单位名称*/
	private java.lang.String unitName;
	
    /*单位代码*/
    /*单位代码*/
	private java.lang.String unitCode;
	
    /*机构代码证*/
    /*机构代码证*/
	private java.lang.String orgCode;
	
    /*注册所在地代码*/
    /*注册所在地代码*/
	private java.lang.String regCityCode;
	
    /*注册所在地*/
    /*注册所在地*/
	private java.lang.String regCityName;
	
    /*隶属省市标识*/
    /*隶属省市标识*/
	private java.lang.Long belogProvinceCode;
	
    /*隶属省市名称*/
    /*隶属省市名称*/
	private java.lang.String belogProvince;
	
    /*注册地址*/
    /*注册地址*/
	private java.lang.String regAddress;
	
    /*经济类型*/
    /*经济类型*/
	private java.lang.Long unitEcoType;
	
    /*经济类型名称*/
    /*经济类型名称*/
	private java.lang.String unitEcoName;
	
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
	 * Return the value associated with the column: ORG_CODE
	 */
	public java.lang.String getOrgCode () {
		return orgCode;
	}

	/**
	 * Set the value related to the column: ORG_CODE
	 * @param orgCode the ORG_CODE value
	 */
	public void setOrgCode (java.lang.String orgCode) {
		this.orgCode = orgCode;
	}


	/**
	 * Return the value associated with the column: REG_CITY_CODE
	 */
	public java.lang.String getRegCityCode () {
		return regCityCode;
	}

	/**
	 * Set the value related to the column: REG_CITY_CODE
	 * @param regCityCode the REG_CITY_CODE value
	 */
	public void setRegCityCode (java.lang.String regCityCode) {
		this.regCityCode = regCityCode;
	}


	/**
	 * Return the value associated with the column: REG_CITY_NAME
	 */
	public java.lang.String getRegCityName () {
		return regCityName;
	}

	/**
	 * Set the value related to the column: REG_CITY_NAME
	 * @param regCityName the REG_CITY_NAME value
	 */
	public void setRegCityName (java.lang.String regCityName) {
		this.regCityName = regCityName;
	}


	/**
	 * Return the value associated with the column: BELOG_PROVINCE_CODE
	 */
	public java.lang.Long getBelogProvinceCode () {
		return belogProvinceCode;
	}

	/**
	 * Set the value related to the column: BELOG_PROVINCE_CODE
	 * @param belogProvinceCode the BELOG_PROVINCE_CODE value
	 */
	public void setBelogProvinceCode (java.lang.Long belogProvinceCode) {
		this.belogProvinceCode = belogProvinceCode;
	}


	/**
	 * Return the value associated with the column: BELOG_PROVINCE
	 */
	public java.lang.String getBelogProvince () {
		return belogProvince;
	}

	/**
	 * Set the value related to the column: BELOG_PROVINCE
	 * @param belogProvince the BELOG_PROVINCE value
	 */
	public void setBelogProvince (java.lang.String belogProvince) {
		this.belogProvince = belogProvince;
	}


	/**
	 * Return the value associated with the column: REG_ADDRESS
	 */
	public java.lang.String getRegAddress () {
		return regAddress;
	}

	/**
	 * Set the value related to the column: REG_ADDRESS
	 * @param regAddress the REG_ADDRESS value
	 */
	public void setRegAddress (java.lang.String regAddress) {
		this.regAddress = regAddress;
	}


	/**
	 * Return the value associated with the column: UNIT_ECO_TYPE
	 */
	public java.lang.Long getUnitEcoType () {
		return unitEcoType;
	}

	/**
	 * Set the value related to the column: UNIT_ECO_TYPE
	 * @param unitEcoType the UNIT_ECO_TYPE value
	 */
	public void setUnitEcoType (java.lang.Long unitEcoType) {
		this.unitEcoType = unitEcoType;
	}


	/**
	 * Return the value associated with the column: UNIT_ECO_NAME
	 */
	public java.lang.String getUnitEcoName () {
		return unitEcoName;
	}

	/**
	 * Set the value related to the column: UNIT_ECO_NAME
	 * @param unitEcoName the UNIT_ECO_NAME value
	 */
	public void setUnitEcoName (java.lang.String unitEcoName) {
		this.unitEcoName = unitEcoName;
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
		if (!(obj instanceof com.justonetech.biz.domain.ShareUnitInfo)) return false;
		else {
			com.justonetech.biz.domain.ShareUnitInfo shareUnitInfo = (com.justonetech.biz.domain.ShareUnitInfo) obj;
			if (null == this.getId() || null == shareUnitInfo.getId()) return false;
			else return (this.getId().equals(shareUnitInfo.getId()));
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
		builder.append(unitCode);
		builder.append(orgCode);
		builder.append(regCityCode);
		builder.append(regCityName);
		builder.append(belogProvinceCode);
		builder.append(belogProvince);
		builder.append(regAddress);
		builder.append(unitEcoType);
		builder.append(unitEcoName);
		builder.append(updateTime);
		return builder.toString();
	}


}