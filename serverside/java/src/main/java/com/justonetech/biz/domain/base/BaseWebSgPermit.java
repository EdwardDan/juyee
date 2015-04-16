package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the WEB_SG_PERMIT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 施工许可
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 施工许可
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : web
 * Projectable : false
 *
 * @hibernate.class
 *  table="WEB_SG_PERMIT"
 */

public abstract class BaseWebSgPermit  implements Serializable {

	public static String REF = "WebSgPermit";
	public static String PROP_SJ_UNIT = "sjUnit";
	public static String PROP_PERMIT_NO = "permitNo";
	public static String PROP_PERMIT_DATE = "permitDate";
	public static String PROP_START_DATE = "startDate";
	public static String PROP_AREA = "area";
	public static String PROP_CONTRACT_MONEY = "contractMoney";
	public static String PROP_SG_UNIT = "sgUnit";
	public static String PROP_JL_UNIT = "jlUnit";
	public static String PROP_ID = "id";
	public static String PROP_PROJECT_INFO = "projectInfo";
	public static String PROP_COMPLETE_DATE = "completeDate";


	// constructors
	public BaseWebSgPermit () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWebSgPermit (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*许可证号*/
    /*许可证号*/
	private String permitNo;
	
    /*许可日期*/
    /*许可日期*/
	private java.sql.Date permitDate;
	
    /*设计单位*/
    /*设计单位*/
	private String sjUnit;
	
    /*施工总包单位*/
    /*施工总包单位*/
	private String sgUnit;
	
    /*监理单位*/
    /*监理单位*/
	private String jlUnit;
	
    /*合同价格*/
    /*合同价格*/
	private String contractMoney;
	
    /*建设规模（面积）*/
    /*建设规模（面积）*/
	private String area;
	
    /*合同开工日期*/
    /*合同开工日期*/
	private java.sql.Date startDate;
	
    /*合同竣工日期*/
    /*合同竣工日期*/
	private java.sql.Date completeDate;
	

	// many to one
	private com.justonetech.biz.domain.WebProjectInfo projectInfo;

	// collections
	private java.util.Set<com.justonetech.biz.domain.WebSgPermitScope> webSgPermitScopes;



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
	 * Return the value associated with the column: PERMIT_NO
	 */
	public String getPermitNo () {
		return permitNo;
	}

	/**
	 * Set the value related to the column: PERMIT_NO
	 * @param permitNo the PERMIT_NO value
	 */
	public void setPermitNo (String permitNo) {
		this.permitNo = permitNo;
	}


	/**
	 * Return the value associated with the column: PERMIT_DATE
	 */
	public java.sql.Date getPermitDate () {
		return permitDate;
	}

	/**
	 * Set the value related to the column: PERMIT_DATE
	 * @param permitDate the PERMIT_DATE value
	 */
	public void setPermitDate (java.sql.Date permitDate) {
		this.permitDate = permitDate;
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
	 * Return the value associated with the column: SG_UNIT
	 */
	public String getSgUnit () {
		return sgUnit;
	}

	/**
	 * Set the value related to the column: SG_UNIT
	 * @param sgUnit the SG_UNIT value
	 */
	public void setSgUnit (String sgUnit) {
		this.sgUnit = sgUnit;
	}


	/**
	 * Return the value associated with the column: JL_UNIT
	 */
	public String getJlUnit () {
		return jlUnit;
	}

	/**
	 * Set the value related to the column: JL_UNIT
	 * @param jlUnit the JL_UNIT value
	 */
	public void setJlUnit (String jlUnit) {
		this.jlUnit = jlUnit;
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
	 * Return the value associated with the column: AREA
	 */
	public String getArea () {
		return area;
	}

	/**
	 * Set the value related to the column: AREA
	 * @param area the AREA value
	 */
	public void setArea (String area) {
		this.area = area;
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
	 * Return the value associated with the column: COMPLETE_DATE
	 */
	public java.sql.Date getCompleteDate () {
		return completeDate;
	}

	/**
	 * Set the value related to the column: COMPLETE_DATE
	 * @param completeDate the COMPLETE_DATE value
	 */
	public void setCompleteDate (java.sql.Date completeDate) {
		this.completeDate = completeDate;
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
	 * Return the value associated with the column: webSgPermitScopes
	 */
	public java.util.Set<com.justonetech.biz.domain.WebSgPermitScope> getWebSgPermitScopes () {
		if(webSgPermitScopes == null){
			webSgPermitScopes = new java.util.LinkedHashSet<com.justonetech.biz.domain.WebSgPermitScope>();
		}
		return webSgPermitScopes;
	}

	/**
	 * Set the value related to the column: webSgPermitScopes
	 * @param webSgPermitScopes the webSgPermitScopes value
	 */
	public void setWebSgPermitScopes (java.util.Set<com.justonetech.biz.domain.WebSgPermitScope> webSgPermitScopes) {
		this.webSgPermitScopes = webSgPermitScopes;
	}

	public void addTowebSgPermitScopes (com.justonetech.biz.domain.WebSgPermitScope webSgPermitScope) {
		if (null == getWebSgPermitScopes()) setWebSgPermitScopes(new java.util.LinkedHashSet<com.justonetech.biz.domain.WebSgPermitScope>());
		getWebSgPermitScopes().add(webSgPermitScope);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.WebSgPermit)) return false;
		else {
			com.justonetech.biz.domain.WebSgPermit webSgPermit = (com.justonetech.biz.domain.WebSgPermit) obj;
			if (null == this.getId() || null == webSgPermit.getId()) return false;
			else return (this.getId().equals(webSgPermit.getId()));
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
		builder.append(permitNo);
		builder.append(permitDate);
		builder.append(sjUnit);
		builder.append(sgUnit);
		builder.append(jlUnit);
		builder.append(contractMoney);
		builder.append(area);
		builder.append(startDate);
		builder.append(completeDate);
		return builder.toString();
	}


}