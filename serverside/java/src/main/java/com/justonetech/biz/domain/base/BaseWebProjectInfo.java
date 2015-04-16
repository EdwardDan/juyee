package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the WEB_PROJECT_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目信息
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 项目信息
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : web
 * Projectable : false
 *
 * @hibernate.class
 *  table="WEB_PROJECT_INFO"
 */

public abstract class BaseWebProjectInfo  implements Serializable {

	public static String REF = "WebProjectInfo";
	public static String PROP_SJ_UNIT = "sjUnit";
	public static String PROP_PROJECTNAME = "project＿name";
	public static String PROP_SG_PERMIT = "sgPermit";
	public static String PROP_BJBH = "bjbh";
	public static String PROP_SJ_ADDRESS = "sjAddress";
	public static String PROP_TOTAL_AREA = "totalArea";
	public static String PROP_ID = "id";
	public static String PROP_BJ_DATE = "bjDate";
	public static String PROP_TOTAL_MONEY = "totalMoney";
	public static String PROP_PROJECT_CATEGORY = "projectCategory";


	// constructors
	public BaseWebProjectInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWebProjectInfo (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*报建编号*/
    /*报建编号*/
	private String bjbh;
	
    /*项目名称*/
    /*项目名称*/
	private String project＿name;
	
    /*报建日期*/
    /*报建日期*/
	private java.sql.Date bjDate;
	
    /*项目分类*/
    /*项目分类*/
	private String projectCategory;
	
    /*施工许可*/
    /*施工许可*/
	private String sgPermit;
	
    /*建设单位*/
    /*建设单位*/
	private String sjUnit;
	
    /*建设地点*/
    /*建设地点*/
	private String sjAddress;
	
    /*总投资*/
    /*总投资*/
	private String totalMoney;
	
    /*建设规模（面积）*/
    /*建设规模（面积）*/
	private String totalArea;
	

	// collections
	private java.util.Set<com.justonetech.biz.domain.WebSgPermit> webSgPermits;
	private java.util.Set<com.justonetech.biz.domain.WebContractBack> webContractBacks;



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
	 * Return the value associated with the column: PROJECT＿NAME
	 */
	public String getProject＿name () {
		return project＿name;
	}

	/**
	 * Set the value related to the column: PROJECT＿NAME
	 * @param project＿name the PROJECT＿NAME value
	 */
	public void setProject＿name (String project＿name) {
		this.project＿name = project＿name;
	}


	/**
	 * Return the value associated with the column: BJ_DATE
	 */
	public java.sql.Date getBjDate () {
		return bjDate;
	}

	/**
	 * Set the value related to the column: BJ_DATE
	 * @param bjDate the BJ_DATE value
	 */
	public void setBjDate (java.sql.Date bjDate) {
		this.bjDate = bjDate;
	}


	/**
	 * Return the value associated with the column: PROJECT_CATEGORY
	 */
	public String getProjectCategory () {
		return projectCategory;
	}

	/**
	 * Set the value related to the column: PROJECT_CATEGORY
	 * @param projectCategory the PROJECT_CATEGORY value
	 */
	public void setProjectCategory (String projectCategory) {
		this.projectCategory = projectCategory;
	}


	/**
	 * Return the value associated with the column: SG_PERMIT
	 */
	public String getSgPermit () {
		return sgPermit;
	}

	/**
	 * Set the value related to the column: SG_PERMIT
	 * @param sgPermit the SG_PERMIT value
	 */
	public void setSgPermit (String sgPermit) {
		this.sgPermit = sgPermit;
	}


	/**
	 * Return the value associated with the column: SJ_UNIT
	 */
	public String getSjUnit () {
		return sjUnit;
	}

	/**
	 * Set the value related to the column: SJ_UNIT
	 * @param sjUnit the SJ_UNIT value
	 */
	public void setSjUnit (String sjUnit) {
		this.sjUnit = sjUnit;
	}


	/**
	 * Return the value associated with the column: SJ_ADDRESS
	 */
	public String getSjAddress () {
		return sjAddress;
	}

	/**
	 * Set the value related to the column: SJ_ADDRESS
	 * @param sjAddress the SJ_ADDRESS value
	 */
	public void setSjAddress (String sjAddress) {
		this.sjAddress = sjAddress;
	}


	/**
	 * Return the value associated with the column: TOTAL_MONEY
	 */
	public String getTotalMoney () {
		return totalMoney;
	}

	/**
	 * Set the value related to the column: TOTAL_MONEY
	 * @param totalMoney the TOTAL_MONEY value
	 */
	public void setTotalMoney (String totalMoney) {
		this.totalMoney = totalMoney;
	}


	/**
	 * Return the value associated with the column: TOTAL_AREA
	 */
	public String getTotalArea () {
		return totalArea;
	}

	/**
	 * Set the value related to the column: TOTAL_AREA
	 * @param totalArea the TOTAL_AREA value
	 */
	public void setTotalArea (String totalArea) {
		this.totalArea = totalArea;
	}


	/**
	 * Return the value associated with the column: webSgPermits
	 */
	public java.util.Set<com.justonetech.biz.domain.WebSgPermit> getWebSgPermits () {
		if(webSgPermits == null){
			webSgPermits = new java.util.LinkedHashSet<com.justonetech.biz.domain.WebSgPermit>();
		}
		return webSgPermits;
	}

	/**
	 * Set the value related to the column: webSgPermits
	 * @param webSgPermits the webSgPermits value
	 */
	public void setWebSgPermits (java.util.Set<com.justonetech.biz.domain.WebSgPermit> webSgPermits) {
		this.webSgPermits = webSgPermits;
	}

	public void addTowebSgPermits (com.justonetech.biz.domain.WebSgPermit webSgPermit) {
		if (null == getWebSgPermits()) setWebSgPermits(new java.util.LinkedHashSet<com.justonetech.biz.domain.WebSgPermit>());
		getWebSgPermits().add(webSgPermit);
	}


	/**
	 * Return the value associated with the column: webContractBacks
	 */
	public java.util.Set<com.justonetech.biz.domain.WebContractBack> getWebContractBacks () {
		if(webContractBacks == null){
			webContractBacks = new java.util.LinkedHashSet<com.justonetech.biz.domain.WebContractBack>();
		}
		return webContractBacks;
	}

	/**
	 * Set the value related to the column: webContractBacks
	 * @param webContractBacks the webContractBacks value
	 */
	public void setWebContractBacks (java.util.Set<com.justonetech.biz.domain.WebContractBack> webContractBacks) {
		this.webContractBacks = webContractBacks;
	}

	public void addTowebContractBacks (com.justonetech.biz.domain.WebContractBack webContractBack) {
		if (null == getWebContractBacks()) setWebContractBacks(new java.util.LinkedHashSet<com.justonetech.biz.domain.WebContractBack>());
		getWebContractBacks().add(webContractBack);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.WebProjectInfo)) return false;
		else {
			com.justonetech.biz.domain.WebProjectInfo webProjectInfo = (com.justonetech.biz.domain.WebProjectInfo) obj;
			if (null == this.getId() || null == webProjectInfo.getId()) return false;
			else return (this.getId().equals(webProjectInfo.getId()));
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
		builder.append(project＿name);
		builder.append(bjDate);
		builder.append(projectCategory);
		builder.append(sgPermit);
		builder.append(sjUnit);
		builder.append(sjAddress);
		builder.append(totalMoney);
		builder.append(totalArea);
		return builder.toString();
	}


}