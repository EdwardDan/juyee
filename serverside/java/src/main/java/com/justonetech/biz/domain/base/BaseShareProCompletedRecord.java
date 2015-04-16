package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHARE_PRO_COMPLETED_RECORD table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 竣工备案主表
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 竣工备案主表
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : share
 * Projectable : false
 *
 * @hibernate.class
 *  table="SHARE_PRO_COMPLETED_RECORD"
 */

public abstract class BaseShareProCompletedRecord  implements Serializable {

	public static String REF = "ShareProCompletedRecord";
	public static String PROP_ACCEPT_UNIT_NAME = "acceptUnitName";
	public static String PROP_SHARE_TIME = "shareTime";
	public static String PROP_ACCEPT_DATETIME = "acceptDatetime";
	public static String PROP_JBR = "jbr";
	public static String PROP_CONT_MONEY = "contMoney";
	public static String PROP_BJBH = "bjbh";
	public static String PROP_RECORD_CODE = "recordCode";
	public static String PROP_ACCEPT_UNIT_CODE = "acceptUnitCode";
	public static String PROP_TOTAL_AREA = "totalArea";
	public static String PROP_FGW_EXCHANGE_CODE = "fgwExchangeCode";
	public static String PROP_ID = "id";
	public static String PROP_PRO_NAME = "proName";
	public static String PROP_SHARE_STATUS = "shareStatus";


	// constructors
	public BaseShareProCompletedRecord () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShareProCompletedRecord (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*报建编号*/
    /*报建编号*/
	private java.lang.String bjbh;
	
    /*项目名称*/
    /*项目名称*/
	private java.lang.String proName;
	
    /*备案编码*/
    /*备案编码*/
	private java.lang.String recordCode;
	
    /*受理日期*/
    /*受理日期*/
	private java.sql.Timestamp acceptDatetime;
	
    /*发改委交互码*/
    /*发改委交互码*/
	private java.lang.String fgwExchangeCode;
	
    /*经办人*/
    /*经办人*/
	private java.lang.String jbr;
	
    /*受理单位代码*/
    /*受理单位代码*/
	private java.lang.String acceptUnitCode;
	
    /*受理单位名称*/
    /*受理单位名称*/
	private java.lang.String acceptUnitName;
	
    /*共享时间*/
    /*共享时间*/
	private java.sql.Timestamp shareTime;
	
    /*共享状态*/
    /*共享状态*/
	private java.lang.String shareStatus;
	
    /*总面积*/
    /*总面积*/
	private java.lang.Double totalArea;
	
    /*合同资金*/
    /*合同资金*/
	private java.lang.Double contMoney;
	



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
	 * Return the value associated with the column: RECORD_CODE
	 */
	public java.lang.String getRecordCode () {
		return recordCode;
	}

	/**
	 * Set the value related to the column: RECORD_CODE
	 * @param recordCode the RECORD_CODE value
	 */
	public void setRecordCode (java.lang.String recordCode) {
		this.recordCode = recordCode;
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



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ShareProCompletedRecord)) return false;
		else {
			com.justonetech.biz.domain.ShareProCompletedRecord shareProCompletedRecord = (com.justonetech.biz.domain.ShareProCompletedRecord) obj;
			if (null == this.getId() || null == shareProCompletedRecord.getId()) return false;
			else return (this.getId().equals(shareProCompletedRecord.getId()));
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
		builder.append(bjbh);
		builder.append(proName);
		builder.append(recordCode);
		builder.append(acceptDatetime);
		builder.append(fgwExchangeCode);
		builder.append(jbr);
		builder.append(acceptUnitCode);
		builder.append(acceptUnitName);
		builder.append(shareTime);
		builder.append(shareStatus);
		builder.append(totalArea);
		builder.append(contMoney);
		return builder.toString();
	}


}