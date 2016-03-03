package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the AREA_HISTORY_OPINION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 区县施工许可证历史审核意见
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 区县施工许可证历史审核意见
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : area
 * Projectable : false
 *
 * @hibernate.class
 *  table="AREA_HISTORY_OPINION"
 */

public abstract class BaseAreaHistoryOpinion  implements Serializable {

	public static String REF = "AreaHistoryOpinion";
	public static String PROP_PROJECT_TYPE = "projectType";
	public static String PROP_STATUS = "status";
	public static String PROP_SG_PERMIT = "sgPermit";
	public static String PROP_ID = "id";
	public static String PROP_OPINION = "opinion";
	public static String PROP_AUDIT_DATE = "auditDate";


	// constructors
	public BaseAreaHistoryOpinion () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAreaHistoryOpinion (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*审核日期*/
    /*审核日期*/
	private java.sql.Timestamp auditDate;
	
    /*审核意见*/
    /*审核意见*/
	private java.lang.String opinion;
	
    /*状态*/
    /*状态*/
	private java.lang.Integer status;
	

	// many to one
	private com.justonetech.biz.domain.AreaSgPermit sgPermit;
	private com.justonetech.system.domain.SysCodeDetail projectType;



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
	 * Return the value associated with the column: AUDIT_DATE
	 */
	public java.sql.Timestamp getAuditDate () {
		return auditDate;
	}

	/**
	 * Set the value related to the column: AUDIT_DATE
	 * @param auditDate the AUDIT_DATE value
	 */
	public void setAuditDate (java.sql.Timestamp auditDate) {
		this.auditDate = auditDate;
	}


	/**
	 * Return the value associated with the column: OPINION
	 */
	public java.lang.String getOpinion () {
		return opinion;
	}

	/**
	 * Set the value related to the column: OPINION
	 * @param opinion the OPINION value
	 */
	public void setOpinion (java.lang.String opinion) {
		this.opinion = opinion;
	}


	/**
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.Integer getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (java.lang.Integer status) {
		this.status = status;
	}


	/**
	 * Return the value associated with the column: SG_PERMIT_ID
	 */
	public com.justonetech.biz.domain.AreaSgPermit getSgPermit () {
		return sgPermit;
	}

	/**
	 * Set the value related to the column: SG_PERMIT_ID
	 * @param sgPermit the SG_PERMIT_ID value
	 */
	public void setSgPermit (com.justonetech.biz.domain.AreaSgPermit sgPermit) {
		this.sgPermit = sgPermit;
	}


	/**
	 * Return the value associated with the column: PROJECT_TYPE_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getProjectType () {
		return projectType;
	}

	/**
	 * Set the value related to the column: PROJECT_TYPE_ID
	 * @param projectType the PROJECT_TYPE_ID value
	 */
	public void setProjectType (com.justonetech.system.domain.SysCodeDetail projectType) {
		this.projectType = projectType;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.AreaHistoryOpinion)) return false;
		else {
			com.justonetech.biz.domain.AreaHistoryOpinion areaHistoryOpinion = (com.justonetech.biz.domain.AreaHistoryOpinion) obj;
			if (null == this.getId() || null == areaHistoryOpinion.getId()) return false;
			else return (this.getId().equals(areaHistoryOpinion.getId()));
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
		builder.append(auditDate);
		builder.append(opinion);
		builder.append(status);
		return builder.toString();
	}


}