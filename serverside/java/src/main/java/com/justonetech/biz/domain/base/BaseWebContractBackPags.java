package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the WEB_CONTRACT_BACK_PAGS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 合同备案分包情况
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 合同备案分包情况
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : web
 * Projectable : false
 *
 * @hibernate.class
 *  table="WEB_CONTRACT_BACK_PAGS"
 */

public abstract class BaseWebContractBackPags  implements Serializable {

	public static String REF = "WebContractBackPags";
	public static String PROP_CB_UNIT = "cbUnit";
	public static String PROP_PROJECT_NAME = "projectName";
	public static String PROP_CONTRACT_MONEY = "contractMoney";
	public static String PROP_ID = "id";
	public static String PROP_CONTRACT_BACK = "contractBack";
	public static String PROP_CONTRACT_CATEGORY = "contractCategory";


	// constructors
	public BaseWebContractBackPags () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWebContractBackPags (Long id) {
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
	private String contractMoney;
	

	// many to one
	private com.justonetech.biz.domain.WebContractBack contractBack;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="com.justonetech.core.orm.hibernate.LongIdGenerator"
     *  column="id"
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
	 * Return the value associated with the column: CONTRACT_MONEY
	 */
	public String getContractMoney () {
		return contractMoney;
	}

	/**
	 * Set the value related to the column: CONTRACT_MONEY
	 * @param contractMoney the CONTRACT_MONEY value
	 */
	public void setContractMoney (String contractMoney) {
		this.contractMoney = contractMoney;
	}


	/**
	 * Return the value associated with the column: CONTRACT_BACK_ID
	 */
	public com.justonetech.biz.domain.WebContractBack getContractBack () {
		return contractBack;
	}

	/**
	 * Set the value related to the column: CONTRACT_BACK_ID
	 * @param contractBack the CONTRACT_BACK_ID value
	 */
	public void setContractBack (com.justonetech.biz.domain.WebContractBack contractBack) {
		this.contractBack = contractBack;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.WebContractBackPags)) return false;
		else {
			com.justonetech.biz.domain.WebContractBackPags webContractBackPags = (com.justonetech.biz.domain.WebContractBackPags) obj;
			if (null == this.getId() || null == webContractBackPags.getId()) return false;
			else return (this.getId().equals(webContractBackPags.getId()));
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
		builder.append(contractMoney);
		return builder.toString();
	}


}