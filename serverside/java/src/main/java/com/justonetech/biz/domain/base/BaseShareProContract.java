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

public abstract class BaseShareProContract implements Serializable {

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
	public BaseShareProContract() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShareProContract(String netCode) {
		this.setNetCode(netCode);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private String netCode;

	// fields
    /*报建编号*/
    /*报建编号*/
	private String bjbh;

    /*总包合同编号*/
    /*总包合同编号*/
	private String zbContCode;

    /*分包合同编号*/
    /*分包合同编号*/
	private String fbContCode;

    /*劳务分包合同编号*/
    /*劳务分包合同编号*/
	private String lwContCode;

    /*承包方式*/
    /*承包方式*/
	private String cbType;

    /*承包方式(中文)*/
    /*承包方式(中文)*/
	private String cbTypeName;

    /*项目名称*/
    /*项目名称*/
	private String proName;

    /*发包方*/
    /*发包方*/
	private String fbdw;

    /*总包单位*/
    /*总包单位*/
	private String zbUnit;

    /*总包单位代码*/
    /*总包单位代码*/
	private String zbUnitCode;

    /*承包单位*/
    /*承包单位*/
	private String cbUnit;

    /*承包单位代码*/
    /*承包单位代码*/
	private String cbUnitCode;

    /*承包单位_ID*/
    /*承包单位_ID*/
	private Long cbUnitId;

    /*项目负责人姓名*/
    /*项目负责人姓名*/
	private String proHeader;

    /*项目负责人电话*/
    /*项目负责人电话*/
	private String proHeaderPhone;

    /*项目负责人证件号*/
    /*项目负责人证件号*/
	private String proHeaderCard;

    /*项目负责人证件类型*/
    /*项目负责人证件类型*/
	private Long proHeaderCert;

    /*项目负责人证件类型（中文）*/
    /*项目负责人证件类型（中文）*/
	private String proHeaderCertDesc;

    /*一体化勘察单位*/
    /*一体化勘察单位*/
	private String ythKcUnit;

    /*一体化勘察单位代码*/
    /*一体化勘察单位代码*/
	private String ythKcUnitCode;

    /*一体化勘察单位ID*/
    /*一体化勘察单位ID*/
	private Long ythKcUnitId;

    /*一体化勘察单位负责人*/
    /*一体化勘察单位负责人*/
	private String ythKcHeader;

    /*一体化勘察单位负责人电话*/
    /*一体化勘察单位负责人电话*/
	private String ythKcHeaderPhone;

    /*一体化勘察单位负责人证件号*/
    /*一体化勘察单位负责人证件号*/
	private String ythKcHeaderCard;

    /*一体化勘察单位负责人证件类型*/
    /*一体化勘察单位负责人证件类型*/
	private String ythKcHeaderCert;

    /*一体化勘察单位负责人证件类型（中文）*/
    /*一体化勘察单位负责人证件类型（中文）*/
	private String ythKcHeaderCertDesc;

    /*一体化施工单位*/
    /*一体化施工单位*/
	private String ythSgUnit;

    /*一体化施工单位代码*/
    /*一体化施工单位代码*/
	private String ythSgUnitCode;

    /*一体化施工单位ID*/
    /*一体化施工单位ID*/
	private Long ythSgUnitId;

    /*一体化施工单位负责人*/
    /*一体化施工单位负责人*/
	private String ythSgHeader;

    /*一体化施工单位负责人电话*/
    /*一体化施工单位负责人电话*/
	private String ythSgHeaderPhone;

    /*一体化施工单位负责人证件号*/
    /*一体化施工单位负责人证件号*/
	private String ythSgHeaderCard;

    /*一体化施工单位负责人证件类型*/
    /*一体化施工单位负责人证件类型*/
	private String ythSgHeaderCert;

    /*一体化施工单位负责人证件类型（中文）*/
    /*一体化施工单位负责人证件类型（中文）*/
	private String ythSgHeaderCertDesc;

    /*联合体承包单位*/
    /*联合体承包单位*/
	private String lhtCbUnit;

    /*联合体承包单位代码*/
    /*联合体承包单位代码*/
	private String lhtCbUnitCode;

    /*一体化勘察费*/
    /*一体化勘察费*/
	private Double ythKcFee;

    /*一体化设计费*/
    /*一体化设计费*/
	private Double ythSjFee;

    /*合同金额*/
    /*合同金额*/
	private Double contMoney;

    /*受理时间*/
    /*受理时间*/
	private java.sql.Timestamp acceptTime;

    /*是否核销*/
    /*是否核销*/
	private String isCancel;

    /*核销完成时间*/
    /*核销完成时间*/
	private java.sql.Timestamp cancelTime;

    /*合同类别描述*/
    /*合同类别描述*/
	private String contTypeDesc;

    /*受理人*/
    /*受理人*/
	private String slr;

    /*受理人单位代码*/
    /*受理人单位代码*/
	private String slrUnitCode;

    /*受理人单位代码名称*/
    /*受理人单位代码名称*/
	private String slrUnitName;

    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updatetime;




	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="NET_CODE"
     */
	public String getNetCode () {
		return netCode;
	}

	/**
	 * Set the unique identifier of this class
	 * @param netCode the new ID
	 * @deprecated
	 */
	public void setNetCode (String netCode) {
		this.netCode = netCode;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: BJBH
	 */
	public String getBjbh () {
		return bjbh;
	}

	/**
	 * Set the value related to the column: BJBH
	 * @param bjbh the BJBH value
	 */
	public void setBjbh (String bjbh) {
		this.bjbh = bjbh;
	}


	/**
	 * Return the value associated with the column: ZB_CONT_CODE
	 */
	public String getZbContCode () {
		return zbContCode;
	}

	/**
	 * Set the value related to the column: ZB_CONT_CODE
	 * @param zbContCode the ZB_CONT_CODE value
	 */
	public void setZbContCode (String zbContCode) {
		this.zbContCode = zbContCode;
	}


	/**
	 * Return the value associated with the column: FB_CONT_CODE
	 */
	public String getFbContCode () {
		return fbContCode;
	}

	/**
	 * Set the value related to the column: FB_CONT_CODE
	 * @param fbContCode the FB_CONT_CODE value
	 */
	public void setFbContCode (String fbContCode) {
		this.fbContCode = fbContCode;
	}


	/**
	 * Return the value associated with the column: LW_CONT_CODE
	 */
	public String getLwContCode () {
		return lwContCode;
	}

	/**
	 * Set the value related to the column: LW_CONT_CODE
	 * @param lwContCode the LW_CONT_CODE value
	 */
	public void setLwContCode (String lwContCode) {
		this.lwContCode = lwContCode;
	}


	/**
	 * Return the value associated with the column: CB_TYPE
	 */
	public String getCbType () {
		return cbType;
	}

	/**
	 * Set the value related to the column: CB_TYPE
	 * @param cbType the CB_TYPE value
	 */
	public void setCbType (String cbType) {
		this.cbType = cbType;
	}


	/**
	 * Return the value associated with the column: CB_TYPE_NAME
	 */
	public String getCbTypeName () {
		return cbTypeName;
	}

	/**
	 * Set the value related to the column: CB_TYPE_NAME
	 * @param cbTypeName the CB_TYPE_NAME value
	 */
	public void setCbTypeName (String cbTypeName) {
		this.cbTypeName = cbTypeName;
	}


	/**
	 * Return the value associated with the column: PRO_NAME
	 */
	public String getProName () {
		return proName;
	}

	/**
	 * Set the value related to the column: PRO_NAME
	 * @param proName the PRO_NAME value
	 */
	public void setProName (String proName) {
		this.proName = proName;
	}


	/**
	 * Return the value associated with the column: FBDW
	 */
	public String getFbdw () {
		return fbdw;
	}

	/**
	 * Set the value related to the column: FBDW
	 * @param fbdw the FBDW value
	 */
	public void setFbdw (String fbdw) {
		this.fbdw = fbdw;
	}


	/**
	 * Return the value associated with the column: ZB_UNIT
	 */
	public String getZbUnit () {
		return zbUnit;
	}

	/**
	 * Set the value related to the column: ZB_UNIT
	 * @param zbUnit the ZB_UNIT value
	 */
	public void setZbUnit (String zbUnit) {
		this.zbUnit = zbUnit;
	}


	/**
	 * Return the value associated with the column: ZB_UNIT_CODE
	 */
	public String getZbUnitCode () {
		return zbUnitCode;
	}

	/**
	 * Set the value related to the column: ZB_UNIT_CODE
	 * @param zbUnitCode the ZB_UNIT_CODE value
	 */
	public void setZbUnitCode (String zbUnitCode) {
		this.zbUnitCode = zbUnitCode;
	}


	/**
	 * Return the value associated with the column: CB_UNIT
	 */
	public String getCbUnit () {
		return cbUnit;
	}

	/**
	 * Set the value related to the column: CB_UNIT
	 * @param cbUnit the CB_UNIT value
	 */
	public void setCbUnit (String cbUnit) {
		this.cbUnit = cbUnit;
	}


	/**
	 * Return the value associated with the column: CB_UNIT_CODE
	 */
	public String getCbUnitCode () {
		return cbUnitCode;
	}

	/**
	 * Set the value related to the column: CB_UNIT_CODE
	 * @param cbUnitCode the CB_UNIT_CODE value
	 */
	public void setCbUnitCode (String cbUnitCode) {
		this.cbUnitCode = cbUnitCode;
	}


	/**
	 * Return the value associated with the column: CB_UNIT_ID
	 */
	public Long getCbUnitId () {
		return cbUnitId;
	}

	/**
	 * Set the value related to the column: CB_UNIT_ID
	 * @param cbUnitId the CB_UNIT_ID value
	 */
	public void setCbUnitId (Long cbUnitId) {
		this.cbUnitId = cbUnitId;
	}


	/**
	 * Return the value associated with the column: PRO_HEADER
	 */
	public String getProHeader () {
		return proHeader;
	}

	/**
	 * Set the value related to the column: PRO_HEADER
	 * @param proHeader the PRO_HEADER value
	 */
	public void setProHeader (String proHeader) {
		this.proHeader = proHeader;
	}


	/**
	 * Return the value associated with the column: PRO_HEADER_PHONE
	 */
	public String getProHeaderPhone () {
		return proHeaderPhone;
	}

	/**
	 * Set the value related to the column: PRO_HEADER_PHONE
	 * @param proHeaderPhone the PRO_HEADER_PHONE value
	 */
	public void setProHeaderPhone (String proHeaderPhone) {
		this.proHeaderPhone = proHeaderPhone;
	}


	/**
	 * Return the value associated with the column: PRO_HEADER_CARD
	 */
	public String getProHeaderCard () {
		return proHeaderCard;
	}

	/**
	 * Set the value related to the column: PRO_HEADER_CARD
	 * @param proHeaderCard the PRO_HEADER_CARD value
	 */
	public void setProHeaderCard (String proHeaderCard) {
		this.proHeaderCard = proHeaderCard;
	}


	/**
	 * Return the value associated with the column: PRO_HEADER_CERT
	 */
	public Long getProHeaderCert () {
		return proHeaderCert;
	}

	/**
	 * Set the value related to the column: PRO_HEADER_CERT
	 * @param proHeaderCert the PRO_HEADER_CERT value
	 */
	public void setProHeaderCert (Long proHeaderCert) {
		this.proHeaderCert = proHeaderCert;
	}


	/**
	 * Return the value associated with the column: PRO_HEADER_CERT_DESC
	 */
	public String getProHeaderCertDesc () {
		return proHeaderCertDesc;
	}

	/**
	 * Set the value related to the column: PRO_HEADER_CERT_DESC
	 * @param proHeaderCertDesc the PRO_HEADER_CERT_DESC value
	 */
	public void setProHeaderCertDesc (String proHeaderCertDesc) {
		this.proHeaderCertDesc = proHeaderCertDesc;
	}


	/**
	 * Return the value associated with the column: YTH_KC_UNIT
	 */
	public String getYthKcUnit () {
		return ythKcUnit;
	}

	/**
	 * Set the value related to the column: YTH_KC_UNIT
	 * @param ythKcUnit the YTH_KC_UNIT value
	 */
	public void setYthKcUnit (String ythKcUnit) {
		this.ythKcUnit = ythKcUnit;
	}


	/**
	 * Return the value associated with the column: YTH_KC_UNIT_CODE
	 */
	public String getYthKcUnitCode () {
		return ythKcUnitCode;
	}

	/**
	 * Set the value related to the column: YTH_KC_UNIT_CODE
	 * @param ythKcUnitCode the YTH_KC_UNIT_CODE value
	 */
	public void setYthKcUnitCode (String ythKcUnitCode) {
		this.ythKcUnitCode = ythKcUnitCode;
	}


	/**
	 * Return the value associated with the column: YTH_KC_UNIT_ID
	 */
	public Long getYthKcUnitId () {
		return ythKcUnitId;
	}

	/**
	 * Set the value related to the column: YTH_KC_UNIT_ID
	 * @param ythKcUnitId the YTH_KC_UNIT_ID value
	 */
	public void setYthKcUnitId (Long ythKcUnitId) {
		this.ythKcUnitId = ythKcUnitId;
	}


	/**
	 * Return the value associated with the column: YTH_KC_HEADER
	 */
	public String getYthKcHeader () {
		return ythKcHeader;
	}

	/**
	 * Set the value related to the column: YTH_KC_HEADER
	 * @param ythKcHeader the YTH_KC_HEADER value
	 */
	public void setYthKcHeader (String ythKcHeader) {
		this.ythKcHeader = ythKcHeader;
	}


	/**
	 * Return the value associated with the column: YTH_KC_HEADER_PHONE
	 */
	public String getYthKcHeaderPhone () {
		return ythKcHeaderPhone;
	}

	/**
	 * Set the value related to the column: YTH_KC_HEADER_PHONE
	 * @param ythKcHeaderPhone the YTH_KC_HEADER_PHONE value
	 */
	public void setYthKcHeaderPhone (String ythKcHeaderPhone) {
		this.ythKcHeaderPhone = ythKcHeaderPhone;
	}


	/**
	 * Return the value associated with the column: YTH_KC_HEADER_CARD
	 */
	public String getYthKcHeaderCard () {
		return ythKcHeaderCard;
	}

	/**
	 * Set the value related to the column: YTH_KC_HEADER_CARD
	 * @param ythKcHeaderCard the YTH_KC_HEADER_CARD value
	 */
	public void setYthKcHeaderCard (String ythKcHeaderCard) {
		this.ythKcHeaderCard = ythKcHeaderCard;
	}


	/**
	 * Return the value associated with the column: YTH_KC_HEADER_CERT
	 */
	public String getYthKcHeaderCert () {
		return ythKcHeaderCert;
	}

	/**
	 * Set the value related to the column: YTH_KC_HEADER_CERT
	 * @param ythKcHeaderCert the YTH_KC_HEADER_CERT value
	 */
	public void setYthKcHeaderCert (String ythKcHeaderCert) {
		this.ythKcHeaderCert = ythKcHeaderCert;
	}


	/**
	 * Return the value associated with the column: YTH_KC_HEADER_CERT_DESC
	 */
	public String getYthKcHeaderCertDesc () {
		return ythKcHeaderCertDesc;
	}

	/**
	 * Set the value related to the column: YTH_KC_HEADER_CERT_DESC
	 * @param ythKcHeaderCertDesc the YTH_KC_HEADER_CERT_DESC value
	 */
	public void setYthKcHeaderCertDesc (String ythKcHeaderCertDesc) {
		this.ythKcHeaderCertDesc = ythKcHeaderCertDesc;
	}


	/**
	 * Return the value associated with the column: YTH_SG_UNIT
	 */
	public String getYthSgUnit () {
		return ythSgUnit;
	}

	/**
	 * Set the value related to the column: YTH_SG_UNIT
	 * @param ythSgUnit the YTH_SG_UNIT value
	 */
	public void setYthSgUnit (String ythSgUnit) {
		this.ythSgUnit = ythSgUnit;
	}


	/**
	 * Return the value associated with the column: YTH_SG_UNIT_CODE
	 */
	public String getYthSgUnitCode () {
		return ythSgUnitCode;
	}

	/**
	 * Set the value related to the column: YTH_SG_UNIT_CODE
	 * @param ythSgUnitCode the YTH_SG_UNIT_CODE value
	 */
	public void setYthSgUnitCode (String ythSgUnitCode) {
		this.ythSgUnitCode = ythSgUnitCode;
	}


	/**
	 * Return the value associated with the column: YTH_SG_UNIT_ID
	 */
	public Long getYthSgUnitId () {
		return ythSgUnitId;
	}

	/**
	 * Set the value related to the column: YTH_SG_UNIT_ID
	 * @param ythSgUnitId the YTH_SG_UNIT_ID value
	 */
	public void setYthSgUnitId (Long ythSgUnitId) {
		this.ythSgUnitId = ythSgUnitId;
	}


	/**
	 * Return the value associated with the column: YTH_SG_HEADER
	 */
	public String getYthSgHeader () {
		return ythSgHeader;
	}

	/**
	 * Set the value related to the column: YTH_SG_HEADER
	 * @param ythSgHeader the YTH_SG_HEADER value
	 */
	public void setYthSgHeader (String ythSgHeader) {
		this.ythSgHeader = ythSgHeader;
	}


	/**
	 * Return the value associated with the column: YTH_SG_HEADER_PHONE
	 */
	public String getYthSgHeaderPhone () {
		return ythSgHeaderPhone;
	}

	/**
	 * Set the value related to the column: YTH_SG_HEADER_PHONE
	 * @param ythSgHeaderPhone the YTH_SG_HEADER_PHONE value
	 */
	public void setYthSgHeaderPhone (String ythSgHeaderPhone) {
		this.ythSgHeaderPhone = ythSgHeaderPhone;
	}


	/**
	 * Return the value associated with the column: YTH_SG_HEADER_CARD
	 */
	public String getYthSgHeaderCard () {
		return ythSgHeaderCard;
	}

	/**
	 * Set the value related to the column: YTH_SG_HEADER_CARD
	 * @param ythSgHeaderCard the YTH_SG_HEADER_CARD value
	 */
	public void setYthSgHeaderCard (String ythSgHeaderCard) {
		this.ythSgHeaderCard = ythSgHeaderCard;
	}


	/**
	 * Return the value associated with the column: YTH_SG_HEADER_CERT
	 */
	public String getYthSgHeaderCert () {
		return ythSgHeaderCert;
	}

	/**
	 * Set the value related to the column: YTH_SG_HEADER_CERT
	 * @param ythSgHeaderCert the YTH_SG_HEADER_CERT value
	 */
	public void setYthSgHeaderCert (String ythSgHeaderCert) {
		this.ythSgHeaderCert = ythSgHeaderCert;
	}


	/**
	 * Return the value associated with the column: YTH_SG_HEADER_CERT_DESC
	 */
	public String getYthSgHeaderCertDesc () {
		return ythSgHeaderCertDesc;
	}

	/**
	 * Set the value related to the column: YTH_SG_HEADER_CERT_DESC
	 * @param ythSgHeaderCertDesc the YTH_SG_HEADER_CERT_DESC value
	 */
	public void setYthSgHeaderCertDesc (String ythSgHeaderCertDesc) {
		this.ythSgHeaderCertDesc = ythSgHeaderCertDesc;
	}


	/**
	 * Return the value associated with the column: LHT_CB_UNIT
	 */
	public String getLhtCbUnit () {
		return lhtCbUnit;
	}

	/**
	 * Set the value related to the column: LHT_CB_UNIT
	 * @param lhtCbUnit the LHT_CB_UNIT value
	 */
	public void setLhtCbUnit (String lhtCbUnit) {
		this.lhtCbUnit = lhtCbUnit;
	}


	/**
	 * Return the value associated with the column: LHT_CB_UNIT_CODE
	 */
	public String getLhtCbUnitCode () {
		return lhtCbUnitCode;
	}

	/**
	 * Set the value related to the column: LHT_CB_UNIT_CODE
	 * @param lhtCbUnitCode the LHT_CB_UNIT_CODE value
	 */
	public void setLhtCbUnitCode (String lhtCbUnitCode) {
		this.lhtCbUnitCode = lhtCbUnitCode;
	}


	/**
	 * Return the value associated with the column: YTH_KC_FEE
	 */
	public Double getYthKcFee () {
		return ythKcFee;
	}

	/**
	 * Set the value related to the column: YTH_KC_FEE
	 * @param ythKcFee the YTH_KC_FEE value
	 */
	public void setYthKcFee (Double ythKcFee) {
		this.ythKcFee = ythKcFee;
	}


	/**
	 * Return the value associated with the column: YTH_SJ_FEE
	 */
	public Double getYthSjFee () {
		return ythSjFee;
	}

	/**
	 * Set the value related to the column: YTH_SJ_FEE
	 * @param ythSjFee the YTH_SJ_FEE value
	 */
	public void setYthSjFee (Double ythSjFee) {
		this.ythSjFee = ythSjFee;
	}


	/**
	 * Return the value associated with the column: CONT_MONEY
	 */
	public Double getContMoney () {
		return contMoney;
	}

	/**
	 * Set the value related to the column: CONT_MONEY
	 * @param contMoney the CONT_MONEY value
	 */
	public void setContMoney (Double contMoney) {
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
	public String getIsCancel () {
		return isCancel;
	}

	/**
	 * Set the value related to the column: IS_CANCEL
	 * @param isCancel the IS_CANCEL value
	 */
	public void setIsCancel (String isCancel) {
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
	public String getContTypeDesc () {
		return contTypeDesc;
	}

	/**
	 * Set the value related to the column: CONT_TYPE_DESC
	 * @param contTypeDesc the CONT_TYPE_DESC value
	 */
	public void setContTypeDesc (String contTypeDesc) {
		this.contTypeDesc = contTypeDesc;
	}


	/**
	 * Return the value associated with the column: SLR
	 */
	public String getSlr () {
		return slr;
	}

	/**
	 * Set the value related to the column: SLR
	 * @param slr the SLR value
	 */
	public void setSlr (String slr) {
		this.slr = slr;
	}


	/**
	 * Return the value associated with the column: SLR_UNIT_CODE
	 */
	public String getSlrUnitCode () {
		return slrUnitCode;
	}

	/**
	 * Set the value related to the column: SLR_UNIT_CODE
	 * @param slrUnitCode the SLR_UNIT_CODE value
	 */
	public void setSlrUnitCode (String slrUnitCode) {
		this.slrUnitCode = slrUnitCode;
	}


	/**
	 * Return the value associated with the column: SLR_UNIT_NAME
	 */
	public String getSlrUnitName () {
		return slrUnitName;
	}

	/**
	 * Set the value related to the column: SLR_UNIT_NAME
	 * @param slrUnitName the SLR_UNIT_NAME value
	 */
	public void setSlrUnitName (String slrUnitName) {
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