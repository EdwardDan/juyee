package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the WEB_SG_PERMIT_SCOPE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 施工许可范围
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 施工许可范围
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : web
 * Projectable : false
 *
 * @hibernate.class
 *  table="WEB_SG_PERMIT_SCOPE"
 */

public abstract class BaseWebSgPermitScope  implements Serializable {

	public static String REF = "WebSgPermitScope";
	public static String PROP_SG_PERMIT_SCOPE = "sgPermitScope";
	public static String PROP_SG_PERMIT = "sgPermit";
	public static String PROP_MAIN_PROJECT_INFO = "mainProjectInfo";
	public static String PROP_ID = "id";


	// constructors
	public BaseWebSgPermitScope () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWebSgPermitScope (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*总项目信息*/
    /*总项目信息*/
	private String mainProjectInfo;
	
    /*施工许可范围*/
    /*施工许可范围*/
	private String sgPermitScope;
	

	// many to one
	private com.justonetech.biz.domain.WebSgPermit sgPermit;



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
	 * Return the value associated with the column: MAIN_PROJECT_INFO
	 */
	public String getMainProjectInfo () {
		return mainProjectInfo;
	}

	/**
	 * Set the value related to the column: MAIN_PROJECT_INFO
	 * @param mainProjectInfo the MAIN_PROJECT_INFO value
	 */
	public void setMainProjectInfo (String mainProjectInfo) {
		this.mainProjectInfo = mainProjectInfo;
	}


	/**
	 * Return the value associated with the column: SG_PERMIT_SCOPE
	 */
	public String getSgPermitScope () {
		return sgPermitScope;
	}

	/**
	 * Set the value related to the column: SG_PERMIT_SCOPE
	 * @param sgPermitScope the SG_PERMIT_SCOPE value
	 */
	public void setSgPermitScope (String sgPermitScope) {
		this.sgPermitScope = sgPermitScope;
	}


	/**
	 * Return the value associated with the column: SG_PERMIT_ID
	 */
	public com.justonetech.biz.domain.WebSgPermit getSgPermit () {
		return sgPermit;
	}

	/**
	 * Set the value related to the column: SG_PERMIT_ID
	 * @param sgPermit the SG_PERMIT_ID value
	 */
	public void setSgPermit (com.justonetech.biz.domain.WebSgPermit sgPermit) {
		this.sgPermit = sgPermit;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.WebSgPermitScope)) return false;
		else {
			com.justonetech.biz.domain.WebSgPermitScope webSgPermitScope = (com.justonetech.biz.domain.WebSgPermitScope) obj;
			if (null == this.getId() || null == webSgPermitScope.getId()) return false;
			else return (this.getId().equals(webSgPermitScope.getId()));
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
		builder.append(mainProjectInfo);
		builder.append(sgPermitScope);
		return builder.toString();
	}


}