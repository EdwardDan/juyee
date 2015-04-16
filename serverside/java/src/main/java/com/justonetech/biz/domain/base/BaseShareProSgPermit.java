package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHARE_PRO_SG_PERMIT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目施工许可
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 项目施工许可
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : share
 * Projectable : false
 *
 * @hibernate.class
 *  table="SHARE_PRO_SG_PERMIT"
 */

public abstract class BaseShareProSgPermit  implements Serializable {

	public static String REF = "ShareProSgPermit";
	public static String PROP_ISSUE_DATETIME = "issueDatetime";
	public static String PROP_ACCEPT_UNIT_NAME = "acceptUnitName";
	public static String PROP_SHARE_TIME = "shareTime";
	public static String PROP_JBR = "jbr";
	public static String PROP_CONT_MONEY = "contMoney";
	public static String PROP_SJ_UNIT = "sjUnit";
	public static String PROP_ACCEPT_UNIT_CODE = "acceptUnitCode";
	public static String PROP_TOTAL_AREA = "totalArea";
	public static String PROP_FGW_EXCHANGE_CODE = "fgwExchangeCode";
	public static String PROP_JL_UNIT = "jlUnit";
	public static String PROP_ID = "id";
	public static String PROP_SG_ZB_UNIT = "sgZbUnit";
	public static String PROP_PRO_NAME = "proName";
	public static String PROP_SHARE_STATUS = "shareStatus";


	// constructors
	public BaseShareProSgPermit () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShareProSgPermit (com.justonetech.biz.domain.ShareProSgPermitPK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private com.justonetech.biz.domain.ShareProSgPermitPK id;

	// fields
    /*发证日期*/
    /*发证日期*/
	private java.sql.Timestamp issueDatetime;
	
    /*项目名称*/
    /*项目名称*/
	private java.lang.String proName;
	
    /*合同金额*/
    /*合同金额*/
	private java.lang.Double contMoney;
	
    /*建筑总面积*/
    /*建筑总面积*/
	private java.lang.Double totalArea;
	
    /*发改委交互码*/
    /*发改委交互码*/
	private java.lang.String fgwExchangeCode;
	
    /*经办人*/
    /*经办人*/
	private java.lang.String jbr;
	
    /*施工单位*/
    /*施工单位*/
	private java.lang.String sgZbUnit;
	
    /*设计单位*/
    /*设计单位*/
	private java.lang.String sjUnit;
	
    /*监理单位*/
    /*监理单位*/
	private java.lang.String jlUnit;
	
    /*经办单位代码*/
    /*经办单位代码*/
	private java.lang.String acceptUnitCode;
	
    /*经办单位名称*/
    /*经办单位名称*/
	private java.lang.String acceptUnitName;
	
    /*共享时间*/
    /*共享时间*/
	private java.sql.Timestamp shareTime;
	
    /*共享状态*/
    /*共享状态*/
	private java.lang.String shareStatus;
	



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public com.justonetech.biz.domain.ShareProSgPermitPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 * @deprecated
	 */
	public void setId (com.justonetech.biz.domain.ShareProSgPermitPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: ISSUE_DATETIME
	 */
	public java.sql.Timestamp getIssueDatetime () {
		return issueDatetime;
	}

	/**
	 * Set the value related to the column: ISSUE_DATETIME
	 * @param issueDatetime the ISSUE_DATETIME value
	 */
	public void setIssueDatetime (java.sql.Timestamp issueDatetime) {
		this.issueDatetime = issueDatetime;
	}


	/**
	 * Return the value associated with the column: PRO_NAME
	 */
	public java.lang.String getProName () {
		return proName;
	}

	/**
	 * Set the value related to the column: PRO_NAME
	 * @param proName the PRO_NAME value
	 */
	public void setProName (java.lang.String proName) {
		this.proName = proName;
	}


	/**
	 * Return the value associated with the column: CONT_MONEY
	 */
	public java.lang.Double getContMoney () {
		return contMoney;
	}

	/**
	 * Set the value related to the column: CONT_MONEY
	 * @param contMoney the CONT_MONEY value
	 */
	public void setContMoney (java.lang.Double contMoney) {
		this.contMoney = contMoney;
	}


	/**
	 * Return the value associated with the column: TOTAL_AREA
	 */
	public java.lang.Double getTotalArea () {
		return totalArea;
	}

	/**
	 * Set the value related to the column: TOTAL_AREA
	 * @param totalArea the TOTAL_AREA value
	 */
	public void setTotalArea (java.lang.Double totalArea) {
		this.totalArea = totalArea;
	}


	/**
	 * Return the value associated with the column: FGW_EXCHANGE_CODE
	 */
	public java.lang.String getFgwExchangeCode () {
		return fgwExchangeCode;
	}

	/**
	 * Set the value related to the column: FGW_EXCHANGE_CODE
	 * @param fgwExchangeCode the FGW_EXCHANGE_CODE value
	 */
	public void setFgwExchangeCode (java.lang.String fgwExchangeCode) {
		this.fgwExchangeCode = fgwExchangeCode;
	}


	/**
	 * Return the value associated with the column: JBR
	 */
	public java.lang.String getJbr () {
		return jbr;
	}

	/**
	 * Set the value related to the column: JBR
	 * @param jbr the JBR value
	 */
	public void setJbr (java.lang.String jbr) {
		this.jbr = jbr;
	}


	/**
	 * Return the value associated with the column: SG_ZB_UNIT
	 */
	public java.lang.String getSgZbUnit () {
		return sgZbUnit;
	}

	/**
	 * Set the value related to the column: SG_ZB_UNIT
	 * @param sgZbUnit the SG_ZB_UNIT value
	 */
	public void setSgZbUnit (java.lang.String sgZbUnit) {
		this.sgZbUnit = sgZbUnit;
	}


	/**
	 * Return the value associated with the column: SJ_UNIT
	 */
	public java.lang.String getSjUnit () {
		return sjUnit;
	}

	/**
	 * Set the value related to the column: SJ_UNIT
	 * @param sjUnit the SJ_UNIT value
	 */
	public void setSjUnit (java.lang.String sjUnit) {
		this.sjUnit = sjUnit;
	}


	/**
	 * Return the value associated with the column: JL_UNIT
	 */
	public java.lang.String getJlUnit () {
		return jlUnit;
	}

	/**
	 * Set the value related to the column: JL_UNIT
	 * @param jlUnit the JL_UNIT value
	 */
	public void setJlUnit (java.lang.String jlUnit) {
		this.jlUnit = jlUnit;
	}


	/**
	 * Return the value associated with the column: ACCEPT_UNIT_CODE
	 */
	public java.lang.String getAcceptUnitCode () {
		return acceptUnitCode;
	}

	/**
	 * Set the value related to the column: ACCEPT_UNIT_CODE
	 * @param acceptUnitCode the ACCEPT_UNIT_CODE value
	 */
	public void setAcceptUnitCode (java.lang.String acceptUnitCode) {
		this.acceptUnitCode = acceptUnitCode;
	}


	/**
	 * Return the value associated with the column: ACCEPT_UNIT_NAME
	 */
	public java.lang.String getAcceptUnitName () {
		return acceptUnitName;
	}

	/**
	 * Set the value related to the column: ACCEPT_UNIT_NAME
	 * @param acceptUnitName the ACCEPT_UNIT_NAME value
	 */
	public void setAcceptUnitName (java.lang.String acceptUnitName) {
		this.acceptUnitName = acceptUnitName;
	}


	/**
	 * Return the value associated with the column: SHARE_TIME
	 */
	public java.sql.Timestamp getShareTime () {
		return shareTime;
	}

	/**
	 * Set the value related to the column: SHARE_TIME
	 * @param shareTime the SHARE_TIME value
	 */
	public void setShareTime (java.sql.Timestamp shareTime) {
		this.shareTime = shareTime;
	}


	/**
	 * Return the value associated with the column: SHARE_STATUS
	 */
	public java.lang.String getShareStatus () {
		return shareStatus;
	}

	/**
	 * Set the value related to the column: SHARE_STATUS
	 * @param shareStatus the SHARE_STATUS value
	 */
	public void setShareStatus (java.lang.String shareStatus) {
		this.shareStatus = shareStatus;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ShareProSgPermit)) return false;
		else {
			com.justonetech.biz.domain.ShareProSgPermit shareProSgPermit = (com.justonetech.biz.domain.ShareProSgPermit) obj;
			if (null == this.getId() || null == shareProSgPermit.getId()) return false;
			else return (this.getId().equals(shareProSgPermit.getId()));
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
		builder.append(issueDatetime);
		builder.append(proName);
		builder.append(contMoney);
		builder.append(totalArea);
		builder.append(fgwExchangeCode);
		builder.append(jbr);
		builder.append(sgZbUnit);
		builder.append(sjUnit);
		builder.append(jlUnit);
		builder.append(acceptUnitCode);
		builder.append(acceptUnitName);
		builder.append(shareTime);
		builder.append(shareStatus);
		return builder.toString();
	}


}