package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHARE_PRO_JL_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 施工监理承发包信息
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 施工监理承发包信息
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : share
 * Projectable : false
 *
 * @hibernate.class
 *  table="SHARE_PRO_JL_INFO"
 */

public abstract class BaseShareProJlInfo  implements Serializable {

	public static String REF = "ShareProJlInfo";
	public static String PROP_PROJECT_NAME = "projectName";
	public static String PROP_ZB_TYPE_ID = "zbTypeId";
	public static String PROP_SHOULD_ZB_TYPE_ID = "shouldZbTypeId";
	public static String PROP_JL_FEE = "jlFee";
	public static String PROP_SHOULD_ZB_TYPE = "shouldZbType";
	public static String PROP_JBR = "jbr";
	public static String PROP_BID_DATE = "bidDate";
	public static String PROP_ZB_TYPE = "zbType";
	public static String PROP_TOTAL_AREA = "totalArea";
	public static String PROP_DWMC = "dwmc";
	public static String PROP_FGW_EXCHANGE_CODE = "fgwExchangeCode";
	public static String PROP_ID = "id";
	public static String PROP_ZB_AGENT_UNIT_CODE = "zbAgentUnitCode";
	public static String PROP_BMDM = "bmdm";
	public static String PROP_ZB_AGENT_UNIT = "zbAgentUnit";
	public static String PROP_SHARE_STATUS = "shareStatus";
	public static String PROP_SHARE_DATETIME = "shareDatetime";


	// constructors
	public BaseShareProJlInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShareProJlInfo (com.justonetech.biz.domain.ShareProJlInfoPK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private com.justonetech.biz.domain.ShareProJlInfoPK id;

	// fields
    /*项目名称*/
    /*项目名称*/
	private java.lang.String projectName;
	
    /*招标方式*/
    /*招标方式*/
	private java.lang.String zbType;
	
    /*招标方式标识*/
    /*招标方式标识*/
	private java.lang.Long zbTypeId;
	
    /*标段应招标方式*/
    /*标段应招标方式*/
	private java.lang.String shouldZbType;
	
    /*标段应招标方式标识*/
    /*标段应招标方式标识*/
	private java.lang.Long shouldZbTypeId;
	
    /*中标日期*/
    /*中标日期*/
	private java.sql.Date bidDate;
	
    /*施工监理中标价*/
    /*施工监理中标价*/
	private java.lang.Double jlFee;
	
    /*建筑面积*/
    /*建筑面积*/
	private java.lang.Double totalArea;
	
    /*发改委交互码*/
    /*发改委交互码*/
	private java.lang.String fgwExchangeCode;
	
    /*经办人*/
    /*经办人*/
	private java.lang.String jbr;
	
    /*部门代码*/
    /*部门代码*/
	private java.lang.String bmdm;
	
    /*部门名称*/
    /*部门名称*/
	private java.lang.String dwmc;
	
    /*招标代理单位*/
    /*招标代理单位*/
	private java.lang.String zbAgentUnit;
	
    /*招标代理单位代码*/
    /*招标代理单位代码*/
	private java.lang.String zbAgentUnitCode;
	
    /*共享时间*/
    /*共享时间*/
	private java.sql.Timestamp shareDatetime;
	
    /*共享状态*/
    /*共享状态*/
	private java.lang.String shareStatus;
	



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public com.justonetech.biz.domain.ShareProJlInfoPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 * @deprecated
	 */
	public void setId (com.justonetech.biz.domain.ShareProJlInfoPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: PROJECT_NAME
	 */
	public java.lang.String getProjectName () {
		return projectName;
	}

	/**
	 * Set the value related to the column: PROJECT_NAME
	 * @param projectName the PROJECT_NAME value
	 */
	public void setProjectName (java.lang.String projectName) {
		this.projectName = projectName;
	}


	/**
	 * Return the value associated with the column: ZB_TYPE
	 */
	public java.lang.String getZbType () {
		return zbType;
	}

	/**
	 * Set the value related to the column: ZB_TYPE
	 * @param zbType the ZB_TYPE value
	 */
	public void setZbType (java.lang.String zbType) {
		this.zbType = zbType;
	}


	/**
	 * Return the value associated with the column: ZB_TYPE_ID
	 */
	public java.lang.Long getZbTypeId () {
		return zbTypeId;
	}

	/**
	 * Set the value related to the column: ZB_TYPE_ID
	 * @param zbTypeId the ZB_TYPE_ID value
	 */
	public void setZbTypeId (java.lang.Long zbTypeId) {
		this.zbTypeId = zbTypeId;
	}


	/**
	 * Return the value associated with the column: SHOULD_ZB_TYPE
	 */
	public java.lang.String getShouldZbType () {
		return shouldZbType;
	}

	/**
	 * Set the value related to the column: SHOULD_ZB_TYPE
	 * @param shouldZbType the SHOULD_ZB_TYPE value
	 */
	public void setShouldZbType (java.lang.String shouldZbType) {
		this.shouldZbType = shouldZbType;
	}


	/**
	 * Return the value associated with the column: SHOULD_ZB_TYPE_ID
	 */
	public java.lang.Long getShouldZbTypeId () {
		return shouldZbTypeId;
	}

	/**
	 * Set the value related to the column: SHOULD_ZB_TYPE_ID
	 * @param shouldZbTypeId the SHOULD_ZB_TYPE_ID value
	 */
	public void setShouldZbTypeId (java.lang.Long shouldZbTypeId) {
		this.shouldZbTypeId = shouldZbTypeId;
	}


	/**
	 * Return the value associated with the column: BID_DATE
	 */
	public java.sql.Date getBidDate () {
		return bidDate;
	}

	/**
	 * Set the value related to the column: BID_DATE
	 * @param bidDate the BID_DATE value
	 */
	public void setBidDate (java.sql.Date bidDate) {
		this.bidDate = bidDate;
	}


	/**
	 * Return the value associated with the column: JL_FEE
	 */
	public java.lang.Double getJlFee () {
		return jlFee;
	}

	/**
	 * Set the value related to the column: JL_FEE
	 * @param jlFee the JL_FEE value
	 */
	public void setJlFee (java.lang.Double jlFee) {
		this.jlFee = jlFee;
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
	 * Return the value associated with the column: BMDM
	 */
	public java.lang.String getBmdm () {
		return bmdm;
	}

	/**
	 * Set the value related to the column: BMDM
	 * @param bmdm the BMDM value
	 */
	public void setBmdm (java.lang.String bmdm) {
		this.bmdm = bmdm;
	}


	/**
	 * Return the value associated with the column: DWMC
	 */
	public java.lang.String getDwmc () {
		return dwmc;
	}

	/**
	 * Set the value related to the column: DWMC
	 * @param dwmc the DWMC value
	 */
	public void setDwmc (java.lang.String dwmc) {
		this.dwmc = dwmc;
	}


	/**
	 * Return the value associated with the column: ZB_AGENT_UNIT
	 */
	public java.lang.String getZbAgentUnit () {
		return zbAgentUnit;
	}

	/**
	 * Set the value related to the column: ZB_AGENT_UNIT
	 * @param zbAgentUnit the ZB_AGENT_UNIT value
	 */
	public void setZbAgentUnit (java.lang.String zbAgentUnit) {
		this.zbAgentUnit = zbAgentUnit;
	}


	/**
	 * Return the value associated with the column: ZB_AGENT_UNIT_CODE
	 */
	public java.lang.String getZbAgentUnitCode () {
		return zbAgentUnitCode;
	}

	/**
	 * Set the value related to the column: ZB_AGENT_UNIT_CODE
	 * @param zbAgentUnitCode the ZB_AGENT_UNIT_CODE value
	 */
	public void setZbAgentUnitCode (java.lang.String zbAgentUnitCode) {
		this.zbAgentUnitCode = zbAgentUnitCode;
	}


	/**
	 * Return the value associated with the column: SHARE_DATETIME
	 */
	public java.sql.Timestamp getShareDatetime () {
		return shareDatetime;
	}

	/**
	 * Set the value related to the column: SHARE_DATETIME
	 * @param shareDatetime the SHARE_DATETIME value
	 */
	public void setShareDatetime (java.sql.Timestamp shareDatetime) {
		this.shareDatetime = shareDatetime;
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
		if (!(obj instanceof com.justonetech.biz.domain.ShareProJlInfo)) return false;
		else {
			com.justonetech.biz.domain.ShareProJlInfo shareProJlInfo = (com.justonetech.biz.domain.ShareProJlInfo) obj;
			if (null == this.getId() || null == shareProJlInfo.getId()) return false;
			else return (this.getId().equals(shareProJlInfo.getId()));
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
		builder.append(projectName);
		builder.append(zbType);
		builder.append(zbTypeId);
		builder.append(shouldZbType);
		builder.append(shouldZbTypeId);
		builder.append(bidDate);
		builder.append(jlFee);
		builder.append(totalArea);
		builder.append(fgwExchangeCode);
		builder.append(jbr);
		builder.append(bmdm);
		builder.append(dwmc);
		builder.append(zbAgentUnit);
		builder.append(zbAgentUnitCode);
		builder.append(shareDatetime);
		builder.append(shareStatus);
		return builder.toString();
	}


}