package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHARE_GD_STD_SQ table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 安全质量标准化达标工地信息
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 安全质量标准化达标工地信息
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : share
 * Projectable : false
 *
 * @hibernate.class
 *  table="SHARE_GD_STD_SQ"
 */

public abstract class BaseShareGdStdSq  implements Serializable {

	public static String REF = "ShareGdStdSq";
	public static String PROP_GD_PHONE = "gdPhone";
	public static String PROP_JI_UNIT_CODE = "jiUnitCode";
	public static String PROP_BUILD_AREA = "buildArea";
	public static String PROP_NO_JL_UNIT = "noJlUnit";
	public static String PROP_FYBL = "fybl";
	public static String PROP_GD_CODE = "gdCode";
	public static String PROP_COMPANY_PHONE = "companyPhone";
	public static String PROP_START_DATE = "startDate";
	public static String PROP_BJBH = "bjbh";
	public static String PROP_CONFIRM_TYPE = "confirmType";
	public static String PROP_CHANGETIME = "changetime";
	public static String PROP_CONFIRM_TYPE_DESC = "confirmTypeDesc";
	public static String PROP_BUILD_UNIT_HEADER = "buildUnitHeader";
	public static String PROP_COMPANY_LINKMAN = "companyLinkman";
	public static String PROP_TOTAL_INVESTMENT = "totalInvestment";
	public static String PROP_ADMIN_UNIT_NAME = "adminUnitName";
	public static String PROP_ZB_UNIT = "zbUnit";
	public static String PROP_BUILD_UNIT = "buildUnit";
	public static String PROP_ZB_UNIT_CODE = "zbUnitCode";
	public static String PROP_APPLY_DATE = "applyDate";
	public static String PROP_ADMIN_UNIT_CODE = "adminUnitCode";
	public static String PROP_BUILD_ADDRESS = "buildAddress";
	public static String PROP_GD_LINKMAN = "gdLinkman";
	public static String PROP_GD_NAME = "gdName";
	public static String PROP_END_DATE = "endDate";
	public static String PROP_STD_STATUS = "stdStatus";
	public static String PROP_JL_UNIT = "jlUnit";
	public static String PROP_SQ_LICENCE = "sqLicence";
	public static String PROP_APPLY_CODE = "applyCode";
	public static String PROP_SAFE_FEE = "safeFee";


	// constructors
	public BaseShareGdStdSq () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShareGdStdSq (java.lang.String applyCode) {
		this.setApplyCode(applyCode);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String applyCode;

	// fields
    /*总包单位*/
    /*总包单位*/
	private java.lang.String zbUnit;
	
    /*总包单位代码*/
    /*总包单位代码*/
	private java.lang.String zbUnitCode;
	
    /*安全生产许可证编号*/
    /*安全生产许可证编号*/
	private java.lang.String sqLicence;
	
    /*监理单位*/
    /*监理单位*/
	private java.lang.String jlUnit;
	
    /*监理单位代码*/
    /*监理单位代码*/
	private java.lang.String jiUnitCode;
	
    /*无监理单位*/
    /*无监理单位*/
	private java.lang.String noJlUnit;
	
    /*报建编号*/
    /*报建编号*/
	private java.lang.String bjbh;
	
    /*工地编号*/
    /*工地编号*/
	private java.lang.String gdCode;
	
    /*工地名称*/
    /*工地名称*/
	private java.lang.String gdName;
	
    /*管辖单位代码*/
    /*管辖单位代码*/
	private java.lang.String adminUnitCode;
	
    /*管辖单位名称*/
    /*管辖单位名称*/
	private java.lang.String adminUnitName;
	
    /*建设地点*/
    /*建设地点*/
	private java.lang.String buildAddress;
	
    /*申请日期*/
    /*申请日期*/
	private java.sql.Date applyDate;
	
    /*企业联系人*/
    /*企业联系人*/
	private java.lang.String companyLinkman;
	
    /*企业联系电话*/
    /*企业联系电话*/
	private java.lang.String companyPhone;
	
    /*工地联系人*/
    /*工地联系人*/
	private java.lang.String gdLinkman;
	
    /*工地联系电话*/
    /*工地联系电话*/
	private java.lang.String gdPhone;
	
    /*总投资*/
    /*总投资*/
	private java.math.BigDecimal totalInvestment;
	
    /*建筑面积*/
    /*建筑面积*/
	private java.math.BigDecimal buildArea;
	
    /*安全防护、文明施工措施费用*/
    /*安全防护、文明施工措施费用*/
	private java.math.BigDecimal safeFee;
	
    /*费用比率*/
    /*费用比率*/
	private java.math.BigDecimal fybl;
	
    /*开工日期*/
    /*开工日期*/
	private java.sql.Date startDate;
	
    /*竣工日期*/
    /*竣工日期*/
	private java.sql.Date endDate;
	
    /*建设单位*/
    /*建设单位*/
	private java.lang.String buildUnit;
	
    /*建设单位项目负责人*/
    /*建设单位项目负责人*/
	private java.lang.String buildUnitHeader;
	
    /*操作时间*/
    /*操作时间*/
	private java.sql.Timestamp changetime;
	
    /*竣工确认结论*/
    /*竣工确认结论*/
	private java.lang.String confirmType;
	
    /*竣工确认结论描述*/
    /*竣工确认结论描述*/
	private java.lang.String confirmTypeDesc;
	
    /*标准化状态*/
    /*标准化状态*/
	private java.lang.Long stdStatus;
	



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="APPLY_CODE"
     */
	public java.lang.String getApplyCode () {
		return applyCode;
	}

	/**
	 * Set the unique identifier of this class
	 * @param applyCode the new ID
	 * @deprecated
	 */
	public void setApplyCode (java.lang.String applyCode) {
		this.applyCode = applyCode;
		this.hashCode = Integer.MIN_VALUE;
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
	 * Return the value associated with the column: SQ_LICENCE
	 */
	public java.lang.String getSqLicence () {
		return sqLicence;
	}

	/**
	 * Set the value related to the column: SQ_LICENCE
	 * @param sqLicence the SQ_LICENCE value
	 */
	public void setSqLicence (java.lang.String sqLicence) {
		this.sqLicence = sqLicence;
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
	 * Return the value associated with the column: JI_UNIT_CODE
	 */
	public java.lang.String getJiUnitCode () {
		return jiUnitCode;
	}

	/**
	 * Set the value related to the column: JI_UNIT_CODE
	 * @param jiUnitCode the JI_UNIT_CODE value
	 */
	public void setJiUnitCode (java.lang.String jiUnitCode) {
		this.jiUnitCode = jiUnitCode;
	}


	/**
	 * Return the value associated with the column: NO_JL_UNIT
	 */
	public java.lang.String getNoJlUnit () {
		return noJlUnit;
	}

	/**
	 * Set the value related to the column: NO_JL_UNIT
	 * @param noJlUnit the NO_JL_UNIT value
	 */
	public void setNoJlUnit (java.lang.String noJlUnit) {
		this.noJlUnit = noJlUnit;
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
	 * Return the value associated with the column: ADMIN_UNIT_CODE
	 */
	public java.lang.String getAdminUnitCode () {
		return adminUnitCode;
	}

	/**
	 * Set the value related to the column: ADMIN_UNIT_CODE
	 * @param adminUnitCode the ADMIN_UNIT_CODE value
	 */
	public void setAdminUnitCode (java.lang.String adminUnitCode) {
		this.adminUnitCode = adminUnitCode;
	}


	/**
	 * Return the value associated with the column: ADMIN_UNIT_NAME
	 */
	public java.lang.String getAdminUnitName () {
		return adminUnitName;
	}

	/**
	 * Set the value related to the column: ADMIN_UNIT_NAME
	 * @param adminUnitName the ADMIN_UNIT_NAME value
	 */
	public void setAdminUnitName (java.lang.String adminUnitName) {
		this.adminUnitName = adminUnitName;
	}


	/**
	 * Return the value associated with the column: BUILD_ADDRESS
	 */
	public java.lang.String getBuildAddress () {
		return buildAddress;
	}

	/**
	 * Set the value related to the column: BUILD_ADDRESS
	 * @param buildAddress the BUILD_ADDRESS value
	 */
	public void setBuildAddress (java.lang.String buildAddress) {
		this.buildAddress = buildAddress;
	}


	/**
	 * Return the value associated with the column: APPLY_DATE
	 */
	public java.sql.Date getApplyDate () {
		return applyDate;
	}

	/**
	 * Set the value related to the column: APPLY_DATE
	 * @param applyDate the APPLY_DATE value
	 */
	public void setApplyDate (java.sql.Date applyDate) {
		this.applyDate = applyDate;
	}


	/**
	 * Return the value associated with the column: COMPANY_LINKMAN
	 */
	public java.lang.String getCompanyLinkman () {
		return companyLinkman;
	}

	/**
	 * Set the value related to the column: COMPANY_LINKMAN
	 * @param companyLinkman the COMPANY_LINKMAN value
	 */
	public void setCompanyLinkman (java.lang.String companyLinkman) {
		this.companyLinkman = companyLinkman;
	}


	/**
	 * Return the value associated with the column: COMPANY_PHONE
	 */
	public java.lang.String getCompanyPhone () {
		return companyPhone;
	}

	/**
	 * Set the value related to the column: COMPANY_PHONE
	 * @param companyPhone the COMPANY_PHONE value
	 */
	public void setCompanyPhone (java.lang.String companyPhone) {
		this.companyPhone = companyPhone;
	}


	/**
	 * Return the value associated with the column: GD_LINKMAN
	 */
	public java.lang.String getGdLinkman () {
		return gdLinkman;
	}

	/**
	 * Set the value related to the column: GD_LINKMAN
	 * @param gdLinkman the GD_LINKMAN value
	 */
	public void setGdLinkman (java.lang.String gdLinkman) {
		this.gdLinkman = gdLinkman;
	}


	/**
	 * Return the value associated with the column: GD_PHONE
	 */
	public java.lang.String getGdPhone () {
		return gdPhone;
	}

	/**
	 * Set the value related to the column: GD_PHONE
	 * @param gdPhone the GD_PHONE value
	 */
	public void setGdPhone (java.lang.String gdPhone) {
		this.gdPhone = gdPhone;
	}


	/**
	 * Return the value associated with the column: TOTAL_INVESTMENT
	 */
	public java.math.BigDecimal getTotalInvestment () {
		return totalInvestment;
	}

	/**
	 * Set the value related to the column: TOTAL_INVESTMENT
	 * @param totalInvestment the TOTAL_INVESTMENT value
	 */
	public void setTotalInvestment (java.math.BigDecimal totalInvestment) {
		this.totalInvestment = totalInvestment;
	}


	/**
	 * Return the value associated with the column: BUILD_AREA
	 */
	public java.math.BigDecimal getBuildArea () {
		return buildArea;
	}

	/**
	 * Set the value related to the column: BUILD_AREA
	 * @param buildArea the BUILD_AREA value
	 */
	public void setBuildArea (java.math.BigDecimal buildArea) {
		this.buildArea = buildArea;
	}


	/**
	 * Return the value associated with the column: SAFE_FEE
	 */
	public java.math.BigDecimal getSafeFee () {
		return safeFee;
	}

	/**
	 * Set the value related to the column: SAFE_FEE
	 * @param safeFee the SAFE_FEE value
	 */
	public void setSafeFee (java.math.BigDecimal safeFee) {
		this.safeFee = safeFee;
	}


	/**
	 * Return the value associated with the column: FYBL
	 */
	public java.math.BigDecimal getFybl () {
		return fybl;
	}

	/**
	 * Set the value related to the column: FYBL
	 * @param fybl the FYBL value
	 */
	public void setFybl (java.math.BigDecimal fybl) {
		this.fybl = fybl;
	}


	/**
	 * Return the value associated with the column: START_DATE
	 */
	public java.sql.Date getStartDate () {
		return startDate;
	}

	/**
	 * Set the value related to the column: START_DATE
	 * @param startDate the START_DATE value
	 */
	public void setStartDate (java.sql.Date startDate) {
		this.startDate = startDate;
	}


	/**
	 * Return the value associated with the column: END_DATE
	 */
	public java.sql.Date getEndDate () {
		return endDate;
	}

	/**
	 * Set the value related to the column: END_DATE
	 * @param endDate the END_DATE value
	 */
	public void setEndDate (java.sql.Date endDate) {
		this.endDate = endDate;
	}


	/**
	 * Return the value associated with the column: BUILD_UNIT
	 */
	public java.lang.String getBuildUnit () {
		return buildUnit;
	}

	/**
	 * Set the value related to the column: BUILD_UNIT
	 * @param buildUnit the BUILD_UNIT value
	 */
	public void setBuildUnit (java.lang.String buildUnit) {
		this.buildUnit = buildUnit;
	}


	/**
	 * Return the value associated with the column: BUILD_UNIT_HEADER
	 */
	public java.lang.String getBuildUnitHeader () {
		return buildUnitHeader;
	}

	/**
	 * Set the value related to the column: BUILD_UNIT_HEADER
	 * @param buildUnitHeader the BUILD_UNIT_HEADER value
	 */
	public void setBuildUnitHeader (java.lang.String buildUnitHeader) {
		this.buildUnitHeader = buildUnitHeader;
	}


	/**
	 * Return the value associated with the column: CHANGETIME
	 */
	public java.sql.Timestamp getChangetime () {
		return changetime;
	}

	/**
	 * Set the value related to the column: CHANGETIME
	 * @param changetime the CHANGETIME value
	 */
	public void setChangetime (java.sql.Timestamp changetime) {
		this.changetime = changetime;
	}


	/**
	 * Return the value associated with the column: CONFIRM_TYPE
	 */
	public java.lang.String getConfirmType () {
		return confirmType;
	}

	/**
	 * Set the value related to the column: CONFIRM_TYPE
	 * @param confirmType the CONFIRM_TYPE value
	 */
	public void setConfirmType (java.lang.String confirmType) {
		this.confirmType = confirmType;
	}


	/**
	 * Return the value associated with the column: CONFIRM_TYPE_DESC
	 */
	public java.lang.String getConfirmTypeDesc () {
		return confirmTypeDesc;
	}

	/**
	 * Set the value related to the column: CONFIRM_TYPE_DESC
	 * @param confirmTypeDesc the CONFIRM_TYPE_DESC value
	 */
	public void setConfirmTypeDesc (java.lang.String confirmTypeDesc) {
		this.confirmTypeDesc = confirmTypeDesc;
	}


	/**
	 * Return the value associated with the column: STD_STATUS
	 */
	public java.lang.Long getStdStatus () {
		return stdStatus;
	}

	/**
	 * Set the value related to the column: STD_STATUS
	 * @param stdStatus the STD_STATUS value
	 */
	public void setStdStatus (java.lang.Long stdStatus) {
		this.stdStatus = stdStatus;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ShareGdStdSq)) return false;
		else {
			com.justonetech.biz.domain.ShareGdStdSq shareGdStdSq = (com.justonetech.biz.domain.ShareGdStdSq) obj;
			if (null == this.getApplyCode() || null == shareGdStdSq.getApplyCode()) return false;
			else return (this.getApplyCode().equals(shareGdStdSq.getApplyCode()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getApplyCode()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getApplyCode().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
		builder.append(applyCode);
		builder.append(zbUnit);
		builder.append(zbUnitCode);
		builder.append(sqLicence);
		builder.append(jlUnit);
		builder.append(jiUnitCode);
		builder.append(noJlUnit);
		builder.append(bjbh);
		builder.append(gdCode);
		builder.append(gdName);
		builder.append(adminUnitCode);
		builder.append(adminUnitName);
		builder.append(buildAddress);
		builder.append(applyDate);
		builder.append(companyLinkman);
		builder.append(companyPhone);
		builder.append(gdLinkman);
		builder.append(gdPhone);
		builder.append(totalInvestment);
		builder.append(buildArea);
		builder.append(safeFee);
		builder.append(fybl);
		builder.append(startDate);
		builder.append(endDate);
		builder.append(buildUnit);
		builder.append(buildUnitHeader);
		builder.append(changetime);
		builder.append(confirmType);
		builder.append(confirmTypeDesc);
		builder.append(stdStatus);
		return builder.toString();
	}


}