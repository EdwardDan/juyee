package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHARE_GD_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 工地基本信息
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 工地基本信息
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : share
 * Projectable : false
 *
 * @hibernate.class
 *  table="SHARE_GD_INFO"
 */

public abstract class BaseShareGdInfo  implements Serializable {

	public static String REF = "ShareGdInfo";
	public static String PROP_GD_STATUS_CODE = "gdStatusCode";
	public static String PROP_GD_CHANGETIME = "gdChangetime";
	public static String PROP_SG_TOTAL_UNIT_NAME = "sgTotalUnitName";
	public static String PROP_GD_STATUS_DESC = "gdStatusDesc";
	public static String PROP_JL_UNIT_CODE = "jlUnitCode";
	public static String PROP_SG_TOTAL_UNIT_CODE = "sgTotalUnitCode";
	public static String PROP_GD_CODE = "gdCode";
	public static String PROP_GD_NAME = "gdName";
	public static String PROP_JL_UNIT_NAME = "jlUnitName";
	public static String PROP_BJBH = "bjbh";
	public static String PROP_GD_CREATE_DATE = "gdCreateDate";
	public static String PROP_GD_ADDRESS = "gdAddress";
	public static String PROP_HANDING_UNIT_CODE = "handingUnitCode";
	public static String PROP_HANDING_UNIT_NAME = "handingUnitName";


	// constructors
	public BaseShareGdInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShareGdInfo (java.lang.String gdCode) {
		this.setGdCode(gdCode);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String gdCode;

	// fields
    /*报建编号*/
    /*报建编号*/
	private java.lang.String bjbh;
	
    /*工地名称*/
    /*工地名称*/
	private java.lang.String gdName;
	
    /*工地生成日期*/
    /*工地生成日期*/
	private java.sql.Date gdCreateDate;
	
    /*工地地址*/
    /*工地地址*/
	private java.lang.String gdAddress;
	
    /*工地状态*/
    /*工地状态*/
	private java.lang.String gdStatusCode;
	
    /*工地状态翻译*/
    /*工地状态翻译*/
	private java.lang.String gdStatusDesc;
	
    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp gdChangetime;
	
    /*经办单位代码*/
    /*经办单位代码*/
	private java.lang.String handingUnitCode;
	
    /*经办单位名称*/
    /*经办单位名称*/
	private java.lang.String handingUnitName;
	
    /*施工总包单位代码*/
    /*施工总包单位代码*/
	private java.lang.String sgTotalUnitCode;
	
    /*施工总包单位名称*/
    /*施工总包单位名称*/
	private java.lang.String sgTotalUnitName;
	
    /*监理单位代码*/
    /*监理单位代码*/
	private java.lang.String jlUnitCode;
	
    /*监理单位名称*/
    /*监理单位名称*/
	private java.lang.String jlUnitName;
	



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="GD_CODE"
     */
	public java.lang.String getGdCode () {
		return gdCode;
	}

	/**
	 * Set the unique identifier of this class
	 * @param gdCode the new ID
	 * @deprecated
	 */
	public void setGdCode (java.lang.String gdCode) {
		this.gdCode = gdCode;
		this.hashCode = Integer.MIN_VALUE;
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
	 * Return the value associated with the column: GD_NAME
	 */
	public java.lang.String getGdName () {
		return gdName;
	}

	/**
	 * Set the value related to the column: GD_NAME
	 * @param gdName the GD_NAME value
	 */
	public void setGdName (java.lang.String gdName) {
		this.gdName = gdName;
	}


	/**
	 * Return the value associated with the column: GD_CREATE_DATE
	 */
	public java.sql.Date getGdCreateDate () {
		return gdCreateDate;
	}

	/**
	 * Set the value related to the column: GD_CREATE_DATE
	 * @param gdCreateDate the GD_CREATE_DATE value
	 */
	public void setGdCreateDate (java.sql.Date gdCreateDate) {
		this.gdCreateDate = gdCreateDate;
	}


	/**
	 * Return the value associated with the column: GD_ADDRESS
	 */
	public java.lang.String getGdAddress () {
		return gdAddress;
	}

	/**
	 * Set the value related to the column: GD_ADDRESS
	 * @param gdAddress the GD_ADDRESS value
	 */
	public void setGdAddress (java.lang.String gdAddress) {
		this.gdAddress = gdAddress;
	}


	/**
	 * Return the value associated with the column: GD_STATUS_CODE
	 */
	public java.lang.String getGdStatusCode () {
		return gdStatusCode;
	}

	/**
	 * Set the value related to the column: GD_STATUS_CODE
	 * @param gdStatusCode the GD_STATUS_CODE value
	 */
	public void setGdStatusCode (java.lang.String gdStatusCode) {
		this.gdStatusCode = gdStatusCode;
	}


	/**
	 * Return the value associated with the column: GD_STATUS_DESC
	 */
	public java.lang.String getGdStatusDesc () {
		return gdStatusDesc;
	}

	/**
	 * Set the value related to the column: GD_STATUS_DESC
	 * @param gdStatusDesc the GD_STATUS_DESC value
	 */
	public void setGdStatusDesc (java.lang.String gdStatusDesc) {
		this.gdStatusDesc = gdStatusDesc;
	}


	/**
	 * Return the value associated with the column: GD_CHANGETIME
	 */
	public java.sql.Timestamp getGdChangetime () {
		return gdChangetime;
	}

	/**
	 * Set the value related to the column: GD_CHANGETIME
	 * @param gdChangetime the GD_CHANGETIME value
	 */
	public void setGdChangetime (java.sql.Timestamp gdChangetime) {
		this.gdChangetime = gdChangetime;
	}


	/**
	 * Return the value associated with the column: HANDING_UNIT_CODE
	 */
	public java.lang.String getHandingUnitCode () {
		return handingUnitCode;
	}

	/**
	 * Set the value related to the column: HANDING_UNIT_CODE
	 * @param handingUnitCode the HANDING_UNIT_CODE value
	 */
	public void setHandingUnitCode (java.lang.String handingUnitCode) {
		this.handingUnitCode = handingUnitCode;
	}


	/**
	 * Return the value associated with the column: HANDING_UNIT_NAME
	 */
	public java.lang.String getHandingUnitName () {
		return handingUnitName;
	}

	/**
	 * Set the value related to the column: HANDING_UNIT_NAME
	 * @param handingUnitName the HANDING_UNIT_NAME value
	 */
	public void setHandingUnitName (java.lang.String handingUnitName) {
		this.handingUnitName = handingUnitName;
	}


	/**
	 * Return the value associated with the column: SG_TOTAL_UNIT_CODE
	 */
	public java.lang.String getSgTotalUnitCode () {
		return sgTotalUnitCode;
	}

	/**
	 * Set the value related to the column: SG_TOTAL_UNIT_CODE
	 * @param sgTotalUnitCode the SG_TOTAL_UNIT_CODE value
	 */
	public void setSgTotalUnitCode (java.lang.String sgTotalUnitCode) {
		this.sgTotalUnitCode = sgTotalUnitCode;
	}


	/**
	 * Return the value associated with the column: SG_TOTAL_UNIT_NAME
	 */
	public java.lang.String getSgTotalUnitName () {
		return sgTotalUnitName;
	}

	/**
	 * Set the value related to the column: SG_TOTAL_UNIT_NAME
	 * @param sgTotalUnitName the SG_TOTAL_UNIT_NAME value
	 */
	public void setSgTotalUnitName (java.lang.String sgTotalUnitName) {
		this.sgTotalUnitName = sgTotalUnitName;
	}


	/**
	 * Return the value associated with the column: JL_UNIT_CODE
	 */
	public java.lang.String getJlUnitCode () {
		return jlUnitCode;
	}

	/**
	 * Set the value related to the column: JL_UNIT_CODE
	 * @param jlUnitCode the JL_UNIT_CODE value
	 */
	public void setJlUnitCode (java.lang.String jlUnitCode) {
		this.jlUnitCode = jlUnitCode;
	}


	/**
	 * Return the value associated with the column: JL_UNIT_NAME
	 */
	public java.lang.String getJlUnitName () {
		return jlUnitName;
	}

	/**
	 * Set the value related to the column: JL_UNIT_NAME
	 * @param jlUnitName the JL_UNIT_NAME value
	 */
	public void setJlUnitName (java.lang.String jlUnitName) {
		this.jlUnitName = jlUnitName;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ShareGdInfo)) return false;
		else {
			com.justonetech.biz.domain.ShareGdInfo shareGdInfo = (com.justonetech.biz.domain.ShareGdInfo) obj;
			if (null == this.getGdCode() || null == shareGdInfo.getGdCode()) return false;
			else return (this.getGdCode().equals(shareGdInfo.getGdCode()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getGdCode()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getGdCode().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
		builder.append(gdCode);
		builder.append(bjbh);
		builder.append(gdName);
		builder.append(gdCreateDate);
		builder.append(gdAddress);
		builder.append(gdStatusCode);
		builder.append(gdStatusDesc);
		builder.append(gdChangetime);
		builder.append(handingUnitCode);
		builder.append(handingUnitName);
		builder.append(sgTotalUnitCode);
		builder.append(sgTotalUnitName);
		builder.append(jlUnitCode);
		builder.append(jlUnitName);
		return builder.toString();
	}


}