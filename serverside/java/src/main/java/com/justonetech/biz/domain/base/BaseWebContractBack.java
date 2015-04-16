package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the WEB_CONTRACT_BACK table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 合同登记备案情况
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 合同登记备案情况
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : web
 * Projectable : false
 *
 * @hibernate.class
 *  table="WEB_CONTRACT_BACK"
 */

public abstract class BaseWebContractBack  implements Serializable {

	public static String REF = "WebContractBack";
	public static String PROP_CB_UNIT = "cbUnit";
	public static String PROP_PROJECT_NAME = "projectName";
	public static String PROP_ID = "id";
	public static String PROP_PROJECT_INFO = "projectInfo";
	public static String PROP_CONTRACT_MONRY = "contractMonry";
	public static String PROP_CONTRACT_CATEGORY = "contractCategory";


	// constructors
	public BaseWebContractBack () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWebContractBack (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*项目名称*/
    /*项目名称*/
	private String projectName;
	
    /*承包方*/
    /*承包方*/
	private String cbUnit;
	
    /*合同类别*/
    /*合同类别*/
	private String contractCategory;
	
    /*合同金额（万元）*/
    /*合同金额（万元）*/
	private String contractMonry;
	

	// many to one
	private com.justonetech.biz.domain.WebProjectInfo projectInfo;

	// collections
	private java.util.Set<com.justonetech.biz.domain.WebContractBackPags> webContractBackPags;



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
	 * Return the value associated with the column: PROJECT_NAME
	 */
	public String getProjectName () {
		return projectName;
	}

	/**
	 * Set the value related to the column: PROJECT_NAME
	 * @param projectName the PROJECT_NAME value
	 */
	public void setProjectName (String projectName) {
		this.projectName = projectName;
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
	 * Return the value associated with the column: CONTRACT_CATEGORY
	 */
	public String getContractCategory () {
		return contractCategory;
	}

	/**
	 * Set the value related to the column: CONTRACT_CATEGORY
	 * @param contractCategory the CONTRACT_CATEGORY value
	 */
	public void setContractCategory (String contractCategory) {
		this.contractCategory = contractCategory;
	}


	/**
	 * Return the value associated with the column: CONTRACT_MONRY
	 */
	public String getContractMonry () {
		return contractMonry;
	}

	/**
	 * Set the value related to the column: CONTRACT_MONRY
	 * @param contractMonry the CONTRACT_MONRY value
	 */
	public void setContractMonry (String contractMonry) {
		this.contractMonry = contractMonry;
	}


	/**
	 * Return the value associated with the column: PROJECT_INFO_ID
	 */
	public com.justonetech.biz.domain.WebProjectInfo getProjectInfo () {
		return projectInfo;
	}

	/**
	 * Set the value related to the column: PROJECT_INFO_ID
	 * @param projectInfo the PROJECT_INFO_ID value
	 */
	public void setProjectInfo (com.justonetech.biz.domain.WebProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
	}


	/**
	 * Return the value associated with the column: webContractBackPags
	 */
	public java.util.Set<com.justonetech.biz.domain.WebContractBackPags> getWebContractBackPags () {
		if(webContractBackPags == null){
			webContractBackPags = new java.util.LinkedHashSet<com.justonetech.biz.domain.WebContractBackPags>();
		}
		return webContractBackPags;
	}

	/**
	 * Set the value related to the column: webContractBackPags
	 * @param webContractBackPags the webContractBackPags value
	 */
	public void setWebContractBackPags (java.util.Set<com.justonetech.biz.domain.WebContractBackPags> webContractBackPags) {
		this.webContractBackPags = webContractBackPags;
	}

	public void addTowebContractBackPags (com.justonetech.biz.domain.WebContractBackPags webContractBackPags) {
		if (null == getWebContractBackPags()) setWebContractBackPags(new java.util.LinkedHashSet<com.justonetech.biz.domain.WebContractBackPags>());
		getWebContractBackPags().add(webContractBackPags);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.WebContractBack)) return false;
		else {
			com.justonetech.biz.domain.WebContractBack webContractBack = (com.justonetech.biz.domain.WebContractBack) obj;
			if (null == this.getId() || null == webContractBack.getId()) return false;
			else return (this.getId().equals(webContractBack.getId()));
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
		builder.append(cbUnit);
		builder.append(contractCategory);
		builder.append(contractMonry);
		return builder.toString();
	}


}