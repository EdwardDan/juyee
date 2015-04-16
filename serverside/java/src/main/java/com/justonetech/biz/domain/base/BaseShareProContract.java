package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHARE_PRO_CONTRACT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 合同备案信息
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 合同备案信息
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : share
 * Projectable : false
 *
 * @hibernate.class
 *  table="SHARE_PRO_CONTRACT"
 */

public abstract class BaseShareProContract  implements Serializable {

	public static String REF = "ShareProContract";
	public static String PROP_YTH_SG_UNIT = "ythSgUnit";
	public static String PROP_YTH_KC_HEADER_CARD = "ythKcHeaderCard";
	public static String PROP_CANCEL_TIME = "cancelTime";
	public static String PROP_PRO_HEADER_CERT_DESC = "proHeaderCertDesc";
	public static String PROP_IS_CANCEL = "isCancel";
	public static String PROP_YTH_KC_UNIT_ID = "ythKcUnitId";
	public static String PROP_YTH_KC_UNIT = "ythKcUnit";
	public static String PROP_YTH_KC_HEADER_PHONE = "ythKcHeaderPhone";
	public static String PROP_CONT_MONEY = "contMoney";
	public static String PROP_PRO_HEADER_CARD = "proHeaderCard";
	public static String PROP_CB_UNIT_CODE = "cbUnitCode";
	public static String PROP_YTH_KC_HEADER = "ythKcHeader";
	public static String PROP_BJBH = "bjbh";
	public static String PROP_YTH_KC_UNIT_CODE = "ythKcUnitCode";
	public static String PROP_SLR = "slr";
	public static String PROP_YTH_SG_HEADER_CERT_DESC = "ythSgHeaderCertDesc";
	public static String PROP_YTH_SG_HEADER = "ythSgHeader";
	public static String PROP_YTH_SG_HEADER_PHONE = "ythSgHeaderPhone";
	public static String PROP_NET_CODE = "netCode";
	public static String PROP_YTH_KC_HEADER_CERT_DESC = "ythKcHeaderCertDesc";
	public static String PROP_PRO_NAME = "proName";
	public static String PROP_UPDATETIME = "updatetime";
	public static String PROP_ZB_CONT_CODE = "zbContCode";
	public static String PROP_YTH_SG_HEADER_CERT = "ythSgHeaderCert";
	public static String PROP_CB_TYPE_NAME = "cbTypeName";
	public static String PROP_LHT_CB_UNIT = "lhtCbUnit";
	public static String PROP_YTH_KC_HEADER_CERT = "ythKcHeaderCert";
	public static String PROP_PRO_HEADER = "proHeader";
	public static String PROP_FBDW = "fbdw";
	public static String PROP_ZB_UNIT = "zbUnit";
	public static String PROP_ZB_UNIT_CODE = "zbUnitCode";
	public static String PROP_LHT_CB_UNIT_CODE = "lhtCbUnitCode";
	public static String PROP_YTH_SG_UNIT_CODE = "ythSgUnitCode";
	public static String PROP_SLR_UNIT_NAME = "slrUnitName";
	public static String PROP_ACCEPT_TIME = "acceptTime";
	public static String PROP_YTH_KC_FEE = "ythKcFee";
	public static String PROP_CB_UNIT = "cbUnit";
	public static String PROP_CB_UNIT_ID = "cbUnitId";
	public static String PROP_FB_CONT_CODE = "fbContCode";
	public static String PROP_CONT_TYPE_DESC = "contTypeDesc";
	public static String PROP_CB_TYPE = "cbType";
	public static String PROP_PRO_HEADER_CERT = "proHeaderCert";
	public static String PROP_PRO_HEADER_PHONE = "proHeaderPhone";
	public static String PROP_SLR_UNIT_CODE = "slrUnitCode";
	public static String PROP_YTH_SJ_FEE = "ythSjFee";
	public static String PROP_YTH_SG_HEADER_CARD = "ythSgHeaderCard";
	public static String PROP_YTH_SG_UNIT_ID = "ythSgUnitId";
	public static String PROP_LW_CONT_CODE = "lwContCode";


	// constructors
	public BaseShareProContract () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShareProContract (java.lang.String netCode) {
		this.setNetCode(netCode);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String netCode;

	// fields
    /*报建编号*/
    /*报建编号*/
	private java.lang.String bjbh;
	
    /*总包合同编号*/
    /*总包合同编号*/
	private java.lang.String zbContCode;
	
    /*分包合同编号*/
    /*分包合同编号*/
	private java.lang.String fbContCode;
	
    /*劳务分包合同编号*/
    /*劳务分包合同编号*/
	private java.lang.String lwContCode;
	
    /*承包方式*/
    /*承包方式*/
	private java.lang.String cbType;
	
    /*承包方式(中文)*/
    /*承包方式(中文)*/
	private java.lang.String cbTypeName;
	
    /*项目名称*/
    /*项目名称*/
	private java.lang.String proName;
	
    /*发包方*/
    /*发包方*/
	private java.lang.String fbdw;
	
    /*总包单位*/
    /*总包单位*/
	private java.lang.String zbUnit;
	
    /*总包单位代码*/
    /*总包单位代码*/
	private java.lang.String zbUnitCode;
	
    /*承包单位*/
    /*承包单位*/
	private java.lang.String cbUnit;
	
    /*承包单位代码*/
    /*承包单位代码*/
	private java.lang.String cbUnitCode;
	
    /*承包单位_ID*/
    /*承包单位_ID*/
	private java.lang.Long cbUnitId;
	
    /*项目负责人姓名*/
    /*项目负责人姓名*/
	private java.lang.String proHeader;
	
    /*项目负责人电话*/
    /*项目负责人电话*/
	private java.lang.String proHeaderPhone;
	
    /*项目负责人证件号*/
    /*项目负责人证件号*/
	private java.lang.String proHeaderCard;
	
    /*项目负责人证件类型*/
    /*项目负责人证件类型*/
	private java.lang.Long proHeaderCert;
	
    /*项目负责人证件类型（中文）*/
    /*项目负责人证件类型（中文）*/
	private java.lang.String proHeaderCertDesc;
	
    /*一体化勘察单位*/
    /*一体化勘察单位*/
	private java.lang.String ythKcUnit;
	
    /*一体化勘察单位代码*/
    /*一体化勘察单位代码*/
	private java.lang.String ythKcUnitCode;
	
    /*一体化勘察单位ID*/
    /*一体化勘察单位ID*/
	private java.lang.Long ythKcUnitId;
	
    /*一体化勘察单位负责人*/
    /*一体化勘察单位负责人*/
	private java.lang.String ythKcHeader;
	
    /*一体化勘察单位负责人电话*/
    /*一体化勘察单位负责人电话*/
	private java.lang.String ythKcHeaderPhone;
	
    /*一体化勘察单位负责人证件号*/
    /*一体化勘察单位负责人证件号*/
	private java.lang.String ythKcHeaderCard;
	
    /*一体化勘察单位负责人证件类型*/
    /*一体化勘察单位负责人证件类型*/
	private java.lang.String ythKcHeaderCert;
	
    /*一体化勘察单位负责人证件类型（中文）*/
    /*一体化勘察单位负责人证件类型（中文）*/
	private java.lang.String ythKcHeaderCertDesc;
	
    /*一体化施工单位*/
    /*一体化施工单位*/
	private java.lang.String ythSgUnit;
	
    /*一体化施工单位代码*/
    /*一体化施工单位代码*/
	private java.lang.String ythSgUnitCode;
	
    /*一体化施工单位ID*/
    /*一体化施工单位ID*/
	private java.lang.Long ythSgUnitId;
	
    /*一体化施工单位负责人*/
    /*一体化施工单位负责人*/
	private java.lang.String ythSgHeader;
	
    /*一体化施工单位负责人电话*/
    /*一体化施工单位负责人电话*/
	private java.lang.String ythSgHeaderPhone;
	
    /*一体化施工单位负责人证件号*/
    /*一体化施工单位负责人证件号*/
	private java.lang.String ythSgHeaderCard;
	
    /*一体化施工单位负责人证件类型*/
    /*一体化施工单位负责人证件类型*/
	private java.lang.String ythSgHeaderCert;
	
    /*一体化施工单位负责人证件类型（中文）*/
    /*一体化施工单位负责人证件类型（中文）*/
	private java.lang.String ythSgHeaderCertDesc;
	
    /*联合体承包单位*/
    /*联合体承包单位*/
	private java.lang.String lhtCbUnit;
	
    /*联合体承包单位代码*/
    /*联合体承包单位代码*/
	private java.lang.String lhtCbUnitCode;
	
    /*一体化勘察费*/
    /*一体化勘察费*/
	private java.lang.Double ythKcFee;
	
    /*一体化设计费*/
    /*一体化设计费*/
	private java.lang.Double ythSjFee;
	
    /*合同金额*/
    /*合同金额*/
	private java.lang.Double contMoney;
	
    /*受理时间*/
    /*受理时间*/
	private java.sql.Timestamp acceptTime;
	
    /*是否核销*/
    /*是否核销*/
	private java.lang.String isCancel;
	
    /*核销完成时间*/
    /*核销完成时间*/
	private java.sql.Timestamp cancelTime;
	
    /*合同类别描述*/
    /*合同类别描述*/
	private java.lang.String contTypeDesc;
	
    /*受理人*/
    /*受理人*/
	private java.lang.String slr;
	
    /*受理人单位代码*/
    /*受理人单位代码*/
	private java.lang.String slrUnitCode;
	
    /*受理人单位代码名称*/
    /*受理人单位代码名称*/
	private java.lang.String slrUnitName;
	
    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updatetime;
	



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="NET_CODE"
     */
	public java.lang.String getNetCode () {
		return netCode;
	}

	/**
	 * Set the unique identifier of this class
	 * @param netCode the new ID
	 * @deprecated
	 */
	public void setNetCode (java.lang.String netCode) {
		this.netCode = netCode;
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
	 * Return the value associated with the column: ZB_CONT_CODE
	 */
	public java.lang.String getZbContCode () {
		return zbContCode;
	}

	/**
	 * Set the value related to the column: ZB_CONT_CODE
	 * @param zbContCode the ZB_CONT_CODE value
	 */
	public void setZbContCode (java.lang.String zbContCode) {
		this.zbContCode = zbContCode;
	}


	/**
	 * Return the value associated with the column: FB_CONT_CODE
	 */
	public java.lang.String getFbContCode () {
		return fbContCode;
	}

	/**
	 * Set the value related to the column: FB_CONT_CODE
	 * @param fbContCode the FB_CONT_CODE value
	 */
	public void setFbContCode (java.lang.String fbContCode) {
		this.fbContCode = fbContCode;
	}


	/**
	 * Return the value associated with the column: LW_CONT_CODE
	 */
	public java.lang.String getLwContCode () {
		return lwContCode;
	}

	/**
	 * Set the value related to the column: LW_CONT_CODE
	 * @param lwContCode the LW_CONT_CODE value
	 */
	public void setLwContCode (java.lang.String lwContCode) {
		this.lwContCode = lwContCode;
	}


	/**
	 * Return the value associated with the column: CB_TYPE
	 */
	public java.lang.String getCbType () {
		return cbType;
	}

	/**
	 * Set the value related to the column: CB_TYPE
	 * @param cbType the CB_TYPE value
	 */
	public void setCbType (java.lang.String cbType) {
		this.cbType = cbType;
	}


	/**
	 * Return the value associated with the column: CB_TYPE_NAME
	 */
	public java.lang.String getCbTypeName () {
		return cbTypeName;
	}

	/**
	 * Set the value related to the column: CB_TYPE_NAME
	 * @param cbTypeName the CB_TYPE_NAME value
	 */
	public void setCbTypeName (java.lang.String cbTypeName) {
		this.cbTypeName = cbTypeName;
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
	 * Return the value associated with the column: FBDW
	 */
	public java.lang.String getFbdw () {
		return fbdw;
	}

	/**
	 * Set the value related to the column: FBDW
	 * @param fbdw the FBDW value
	 */
	public void setFbdw (java.lang.String fbdw) {
		this.fbdw = fbdw;
	}


	/**
	 * Return the value associated with the column: ZB_UNIT
	 */
	public java.lang.String getZbUnit () {
		return zbUnit;
	}

	/**
	 * Set the value related to the column: ZB_UNIT
	 * @param zbUnit the ZB_UNIT value
	 */
	public void setZbUnit (java.lang.String zbUnit) {
		this.zbUnit = zbUnit;
	}


	/**
	 * Return the value associated with the column: ZB_UNIT_CODE
	 */
	public java.lang.String getZbUnitCode () {
		return zbUnitCode;
	}

	/**
	 * Set the value related to the column: ZB_UNIT_CODE
	 * @param zbUnitCode the ZB_UNIT_CODE value
	 */
	public void setZbUnitCode (java.lang.String zbUnitCode) {
		this.zbUnitCode = zbUnitCode;
	}


	/**
	 * Return the value associated with the column: CB_UNIT
	 */
	public java.lang.String getCbUnit () {
		return cbUnit;
	}

	/**
	 * Set the value related to the column: CB_UNIT
	 * @param cbUnit the CB_UNIT value
	 */
	public void setCbUnit (java.lang.String cbUnit) {
		this.cbUnit = cbUnit;
	}


	/**
	 * Return the value associated with the column: CB_UNIT_CODE
	 */
	public java.lang.String getCbUnitCode () {
		return cbUnitCode;
	}

	/**
	 * Set the value related to the column: CB_UNIT_CODE
	 * @param cbUnitCode the CB_UNIT_CODE value
	 */
	public void setCbUnitCode (java.lang.String cbUnitCode) {
		this.cbUnitCode = cbUnitCode;
	}


	/**
	 * Return the value associated with the column: CB_UNIT_ID
	 */
	public java.lang.Long getCbUnitId () {
		return cbUnitId;
	}

	/**
	 * Set the value related to the column: CB_UNIT_ID
	 * @param cbUnitId the CB_UNIT_ID value
	 */
	public void setCbUnitId (java.lang.Long cbUnitId) {
		this.cbUnitId = cbUnitId;
	}


	/**
	 * Return the value associated with the column: PRO_HEADER
	 */
	public java.lang.String getProHeader () {
		return proHeader;
	}

	/**
	 * Set the value related to the column: PRO_HEADER
	 * @param proHeader the PRO_HEADER value
	 */
	public void setProHeader (java.lang.String proHeader) {
		this.proHeader = proHeader;
	}


	/**
	 * Return the value associated with the column: PRO_HEADER_PHONE
	 */
	public java.lang.String getProHeaderPhone () {
		return proHeaderPhone;
	}

	/**
	 * Set the value related to the column: PRO_HEADER_PHONE
	 * @param proHeaderPhone the PRO_HEADER_PHONE value
	 */
	public void setProHeaderPhone (java.lang.String proHeaderPhone) {
		this.proHeaderPhone = proHeaderPhone;
	}


	/**
	 * Return the value associated with the column: PRO_HEADER_CARD
	 */
	public java.lang.String getProHeaderCard () {
		return proHeaderCard;
	}

	/**
	 * Set the value related to the column: PRO_HEADER_CARD
	 * @param proHeaderCard the PRO_HEADER_CARD value
	 */
	public void setProHeaderCard (java.lang.String proHeaderCard) {
		this.proHeaderCard = proHeaderCard;
	}


	/**
	 * Return the value associated with the column: PRO_HEADER_CERT
	 */
	public java.lang.Long getProHeaderCert () {
		return proHeaderCert;
	}

	/**
	 * Set the value related to the column: PRO_HEADER_CERT
	 * @param proHeaderCert the PRO_HEADER_CERT value
	 */
	public void setProHeaderCert (java.lang.Long proHeaderCert) {
		this.proHeaderCert = proHeaderCert;
	}


	/**
	 * Return the value associated with the column: PRO_HEADER_CERT_DESC
	 */
	public java.lang.String getProHeaderCertDesc () {
		return proHeaderCertDesc;
	}

	/**
	 * Set the value related to the column: PRO_HEADER_CERT_DESC
	 * @param proHeaderCertDesc the PRO_HEADER_CERT_DESC value
	 */
	public void setProHeaderCertDesc (java.lang.String proHeaderCertDesc) {
		this.proHeaderCertDesc = proHeaderCertDesc;
	}


	/**
	 * Return the value associated with the column: YTH_KC_UNIT
	 */
	public java.lang.String getYthKcUnit () {
		return ythKcUnit;
	}

	/**
	 * Set the value related to the column: YTH_KC_UNIT
	 * @param ythKcUnit the YTH_KC_UNIT value
	 */
	public void setYthKcUnit (java.lang.String ythKcUnit) {
		this.ythKcUnit = ythKcUnit;
	}


	/**
	 * Return the value associated with the column: YTH_KC_UNIT_CODE
	 */
	public java.lang.String getYthKcUnitCode () {
		return ythKcUnitCode;
	}

	/**
	 * Set the value related to the column: YTH_KC_UNIT_CODE
	 * @param ythKcUnitCode the YTH_KC_UNIT_CODE value
	 */
	public void setYthKcUnitCode (java.lang.String ythKcUnitCode) {
		this.ythKcUnitCode = ythKcUnitCode;
	}


	/**
	 * Return the value associated with the column: YTH_KC_UNIT_ID
	 */
	public java.lang.Long getYthKcUnitId () {
		return ythKcUnitId;
	}

	/**
	 * Set the value related to the column: YTH_KC_UNIT_ID
	 * @param ythKcUnitId the YTH_KC_UNIT_ID value
	 */
	public void setYthKcUnitId (java.lang.Long ythKcUnitId) {
		this.ythKcUnitId = ythKcUnitId;
	}


	/**
	 * Return the value associated with the column: YTH_KC_HEADER
	 */
	public java.lang.String getYthKcHeader () {
		return ythKcHeader;
	}

	/**
	 * Set the value related to the column: YTH_KC_HEADER
	 * @param ythKcHeader the YTH_KC_HEADER value
	 */
	public void setYthKcHeader (java.lang.String ythKcHeader) {
		this.ythKcHeader = ythKcHeader;
	}


	/**
	 * Return the value associated with the column: YTH_KC_HEADER_PHONE
	 */
	public java.lang.String getYthKcHeaderPhone () {
		return ythKcHeaderPhone;
	}

	/**
	 * Set the value related to the column: YTH_KC_HEADER_PHONE
	 * @param ythKcHeaderPhone the YTH_KC_HEADER_PHONE value
	 */
	public void setYthKcHeaderPhone (java.lang.String ythKcHeaderPhone) {
		this.ythKcHeaderPhone = ythKcHeaderPhone;
	}


	/**
	 * Return the value associated with the column: YTH_KC_HEADER_CARD
	 */
	public java.lang.String getYthKcHeaderCard () {
		return ythKcHeaderCard;
	}

	/**
	 * Set the value related to the column: YTH_KC_HEADER_CARD
	 * @param ythKcHeaderCard the YTH_KC_HEADER_CARD value
	 */
	public void setYthKcHeaderCard (java.lang.String ythKcHeaderCard) {
		this.ythKcHeaderCard = ythKcHeaderCard;
	}


	/**
	 * Return the value associated with the column: YTH_KC_HEADER_CERT
	 */
	public java.lang.String getYthKcHeaderCert () {
		return ythKcHeaderCert;
	}

	/**
	 * Set the value related to the column: YTH_KC_HEADER_CERT
	 * @param ythKcHeaderCert the YTH_KC_HEADER_CERT value
	 */
	public void setYthKcHeaderCert (java.lang.String ythKcHeaderCert) {
		this.ythKcHeaderCert = ythKcHeaderCert;
	}


	/**
	 * Return the value associated with the column: YTH_KC_HEADER_CERT_DESC
	 */
	public java.lang.String getYthKcHeaderCertDesc () {
		return ythKcHeaderCertDesc;
	}

	/**
	 * Set the value related to the column: YTH_KC_HEADER_CERT_DESC
	 * @param ythKcHeaderCertDesc the YTH_KC_HEADER_CERT_DESC value
	 */
	public void setYthKcHeaderCertDesc (java.lang.String ythKcHeaderCertDesc) {
		this.ythKcHeaderCertDesc = ythKcHeaderCertDesc;
	}


	/**
	 * Return the value associated with the column: YTH_SG_UNIT
	 */
	public java.lang.String getYthSgUnit () {
		return ythSgUnit;
	}

	/**
	 * Set the value related to the column: YTH_SG_UNIT
	 * @param ythSgUnit the YTH_SG_UNIT value
	 */
	public void setYthSgUnit (java.lang.String ythSgUnit) {
		this.ythSgUnit = ythSgUnit;
	}


	/**
	 * Return the value associated with the column: YTH_SG_UNIT_CODE
	 */
	public java.lang.String getYthSgUnitCode () {
		return ythSgUnitCode;
	}

	/**
	 * Set the value related to the column: YTH_SG_UNIT_CODE
	 * @param ythSgUnitCode the YTH_SG_UNIT_CODE value
	 */
	public void setYthSgUnitCode (java.lang.String ythSgUnitCode) {
		this.ythSgUnitCode = ythSgUnitCode;
	}


	/**
	 * Return the value associated with the column: YTH_SG_UNIT_ID
	 */
	public java.lang.Long getYthSgUnitId () {
		return ythSgUnitId;
	}

	/**
	 * Set the value related to the column: YTH_SG_UNIT_ID
	 * @param ythSgUnitId the YTH_SG_UNIT_ID value
	 */
	public void setYthSgUnitId (java.lang.Long ythSgUnitId) {
		this.ythSgUnitId = ythSgUnitId;
	}


	/**
	 * Return the value associated with the column: YTH_SG_HEADER
	 */
	public java.lang.String getYthSgHeader () {
		return ythSgHeader;
	}

	/**
	 * Set the value related to the column: YTH_SG_HEADER
	 * @param ythSgHeader the YTH_SG_HEADER value
	 */
	public void setYthSgHeader (java.lang.String ythSgHeader) {
		this.ythSgHeader = ythSgHeader;
	}


	/**
	 * Return the value associated with the column: YTH_SG_HEADER_PHONE
	 */
	public java.lang.String getYthSgHeaderPhone () {
		return ythSgHeaderPhone;
	}

	/**
	 * Set the value related to the column: YTH_SG_HEADER_PHONE
	 * @param ythSgHeaderPhone the YTH_SG_HEADER_PHONE value
	 */
	public void setYthSgHeaderPhone (java.lang.String ythSgHeaderPhone) {
		this.ythSgHeaderPhone = ythSgHeaderPhone;
	}


	/**
	 * Return the value associated with the column: YTH_SG_HEADER_CARD
	 */
	public java.lang.String getYthSgHeaderCard () {
		return ythSgHeaderCard;
	}

	/**
	 * Set the value related to the column: YTH_SG_HEADER_CARD
	 * @param ythSgHeaderCard the YTH_SG_HEADER_CARD value
	 */
	public void setYthSgHeaderCard (java.lang.String ythSgHeaderCard) {
		this.ythSgHeaderCard = ythSgHeaderCard;
	}


	/**
	 * Return the value associated with the column: YTH_SG_HEADER_CERT
	 */
	public java.lang.String getYthSgHeaderCert () {
		return ythSgHeaderCert;
	}

	/**
	 * Set the value related to the column: YTH_SG_HEADER_CERT
	 * @param ythSgHeaderCert the YTH_SG_HEADER_CERT value
	 */
	public void setYthSgHeaderCert (java.lang.String ythSgHeaderCert) {
		this.ythSgHeaderCert = ythSgHeaderCert;
	}


	/**
	 * Return the value associated with the column: YTH_SG_HEADER_CERT_DESC
	 */
	public java.lang.String getYthSgHeaderCertDesc () {
		return ythSgHeaderCertDesc;
	}

	/**
	 * Set the value related to the column: YTH_SG_HEADER_CERT_DESC
	 * @param ythSgHeaderCertDesc the YTH_SG_HEADER_CERT_DESC value
	 */
	public void setYthSgHeaderCertDesc (java.lang.String ythSgHeaderCertDesc) {
		this.ythSgHeaderCertDesc = ythSgHeaderCertDesc;
	}


	/**
	 * Return the value associated with the column: LHT_CB_UNIT
	 */
	public java.lang.String getLhtCbUnit () {
		return lhtCbUnit;
	}

	/**
	 * Set the value related to the column: LHT_CB_UNIT
	 * @param lhtCbUnit the LHT_CB_UNIT value
	 */
	public void setLhtCbUnit (java.lang.String lhtCbUnit) {
		this.lhtCbUnit = lhtCbUnit;
	}


	/**
	 * Return the value associated with the column: LHT_CB_UNIT_CODE
	 */
	public java.lang.String getLhtCbUnitCode () {
		return lhtCbUnitCode;
	}

	/**
	 * Set the value related to the column: LHT_CB_UNIT_CODE
	 * @param lhtCbUnitCode the LHT_CB_UNIT_CODE value
	 */
	public void setLhtCbUnitCode (java.lang.String lhtCbUnitCode) {
		this.lhtCbUnitCode = lhtCbUnitCode;
	}


	/**
	 * Return the value associated with the column: YTH_KC_FEE
	 */
	public java.lang.Double getYthKcFee () {
		return ythKcFee;
	}

	/**
	 * Set the value related to the column: YTH_KC_FEE
	 * @param ythKcFee the YTH_KC_FEE value
	 */
	public void setYthKcFee (java.lang.Double ythKcFee) {
		this.ythKcFee = ythKcFee;
	}


	/**
	 * Return the value associated with the column: YTH_SJ_FEE
	 */
	public java.lang.Double getYthSjFee () {
		return ythSjFee;
	}

	/**
	 * Set the value related to the column: YTH_SJ_FEE
	 * @param ythSjFee the YTH_SJ_FEE value
	 */
	public void setYthSjFee (java.lang.Double ythSjFee) {
		this.ythSjFee = ythSjFee;
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
	 * Return the value associated with the column: ACCEPT_TIME
	 */
	public java.sql.Timestamp getAcceptTime () {
		return acceptTime;
	}

	/**
	 * Set the value related to the column: ACCEPT_TIME
	 * @param acceptTime the ACCEPT_TIME value
	 */
	public void setAcceptTime (java.sql.Timestamp acceptTime) {
		this.acceptTime = acceptTime;
	}


	/**
	 * Return the value associated with the column: IS_CANCEL
	 */
	public java.lang.String getIsCancel () {
		return isCancel;
	}

	/**
	 * Set the value related to the column: IS_CANCEL
	 * @param isCancel the IS_CANCEL value
	 */
	public void setIsCancel (java.lang.String isCancel) {
		this.isCancel = isCancel;
	}


	/**
	 * Return the value associated with the column: CANCEL_TIME
	 */
	public java.sql.Timestamp getCancelTime () {
		return cancelTime;
	}

	/**
	 * Set the value related to the column: CANCEL_TIME
	 * @param cancelTime the CANCEL_TIME value
	 */
	public void setCancelTime (java.sql.Timestamp cancelTime) {
		this.cancelTime = cancelTime;
	}


	/**
	 * Return the value associated with the column: CONT_TYPE_DESC
	 */
	public java.lang.String getContTypeDesc () {
		return contTypeDesc;
	}

	/**
	 * Set the value related to the column: CONT_TYPE_DESC
	 * @param contTypeDesc the CONT_TYPE_DESC value
	 */
	public void setContTypeDesc (java.lang.String contTypeDesc) {
		this.contTypeDesc = contTypeDesc;
	}


	/**
	 * Return the value associated with the column: SLR
	 */
	public java.lang.String getSlr () {
		return slr;
	}

	/**
	 * Set the value related to the column: SLR
	 * @param slr the SLR value
	 */
	public void setSlr (java.lang.String slr) {
		this.slr = slr;
	}


	/**
	 * Return the value associated with the column: SLR_UNIT_CODE
	 */
	public java.lang.String getSlrUnitCode () {
		return slrUnitCode;
	}

	/**
	 * Set the value related to the column: SLR_UNIT_CODE
	 * @param slrUnitCode the SLR_UNIT_CODE value
	 */
	public void setSlrUnitCode (java.lang.String slrUnitCode) {
		this.slrUnitCode = slrUnitCode;
	}


	/**
	 * Return the value associated with the column: SLR_UNIT_NAME
	 */
	public java.lang.String getSlrUnitName () {
		return slrUnitName;
	}

	/**
	 * Set the value related to the column: SLR_UNIT_NAME
	 * @param slrUnitName the SLR_UNIT_NAME value
	 */
	public void setSlrUnitName (java.lang.String slrUnitName) {
		this.slrUnitName = slrUnitName;
	}


	/**
	 * Return the value associated with the column: UPDATETIME
	 */
	public java.sql.Timestamp getUpdatetime () {
		return updatetime;
	}

	/**
	 * Set the value related to the column: UPDATETIME
	 * @param updatetime the UPDATETIME value
	 */
	public void setUpdatetime (java.sql.Timestamp updatetime) {
		this.updatetime = updatetime;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ShareProContract)) return false;
		else {
			com.justonetech.biz.domain.ShareProContract shareProContract = (com.justonetech.biz.domain.ShareProContract) obj;
			if (null == this.getNetCode() || null == shareProContract.getNetCode()) return false;
			else return (this.getNetCode().equals(shareProContract.getNetCode()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getNetCode()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getNetCode().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
		builder.append(netCode);
		builder.append(bjbh);
		builder.append(zbContCode);
		builder.append(fbContCode);
		builder.append(lwContCode);
		builder.append(cbType);
		builder.append(cbTypeName);
		builder.append(proName);
		builder.append(fbdw);
		builder.append(zbUnit);
		builder.append(zbUnitCode);
		builder.append(cbUnit);
		builder.append(cbUnitCode);
		builder.append(cbUnitId);
		builder.append(proHeader);
		builder.append(proHeaderPhone);
		builder.append(proHeaderCard);
		builder.append(proHeaderCert);
		builder.append(proHeaderCertDesc);
		builder.append(ythKcUnit);
		builder.append(ythKcUnitCode);
		builder.append(ythKcUnitId);
		builder.append(ythKcHeader);
		builder.append(ythKcHeaderPhone);
		builder.append(ythKcHeaderCard);
		builder.append(ythKcHeaderCert);
		builder.append(ythKcHeaderCertDesc);
		builder.append(ythSgUnit);
		builder.append(ythSgUnitCode);
		builder.append(ythSgUnitId);
		builder.append(ythSgHeader);
		builder.append(ythSgHeaderPhone);
		builder.append(ythSgHeaderCard);
		builder.append(ythSgHeaderCert);
		builder.append(ythSgHeaderCertDesc);
		builder.append(lhtCbUnit);
		builder.append(lhtCbUnitCode);
		builder.append(ythKcFee);
		builder.append(ythSjFee);
		builder.append(contMoney);
		builder.append(acceptTime);
		builder.append(isCancel);
		builder.append(cancelTime);
		builder.append(contTypeDesc);
		builder.append(slr);
		builder.append(slrUnitCode);
		builder.append(slrUnitName);
		builder.append(updatetime);
		return builder.toString();
	}


}