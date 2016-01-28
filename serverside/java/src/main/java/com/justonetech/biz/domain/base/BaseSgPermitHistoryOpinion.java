package com.justonetech.biz.domain.base;

import com.justonetech.system.domain.SysCodeDetail;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * This is an object that contains data related to the SG_PERMIT_HISTORY_OPINION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 施工许可证历史审核意见
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 施工许可证历史审核意见
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : sg
 * Projectable : false
 *
 * @hibernate.class
 *  table="SG_PERMIT_HISTORY_OPINION"
 */

public abstract class BaseSgPermitHistoryOpinion  implements Serializable {

	public static String REF = "SgPermitHistoryOpinion";
	public static String PROP_STATUS = "status";
	public static String PROP_SG_PERMIT = "sgPermit";
	public static String PROP_PROPERTY_TYPE = "propertyType";
	public static String PROP_ID = "id";
	public static String PROP_OPINION = "opinion";


	// constructors
	public BaseSgPermitHistoryOpinion () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSgPermitHistoryOpinion (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	/*审核日期*/
    /*审核日期*/
	private java.sql.Timestamp auditDate;

	// fields
    /*审核意见*/
    /*审核意见*/
	private java.lang.String opinion;

    /*状态*/
    /*状态*/
	private java.lang.Integer status;


	// many to one
	private com.justonetech.system.domain.SysCodeDetail projectType;
	private com.justonetech.biz.domain.SgPermit sgPermit;



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

	public Timestamp getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Timestamp auditDate) {
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


	public SysCodeDetail getProjectType() {
		return projectType;
	}

	public void setProjectType(SysCodeDetail projectType) {
		this.projectType = projectType;
	}

	/**
	 * Return the value associated with the column: SG_PERMIT_ID
	 */
	public com.justonetech.biz.domain.SgPermit getSgPermit () {
		return sgPermit;
	}

	/**
	 * Set the value related to the column: SG_PERMIT_ID
	 * @param sgPermit the SG_PERMIT_ID value
	 */
	public void setSgPermit (com.justonetech.biz.domain.SgPermit sgPermit) {
		this.sgPermit = sgPermit;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.SgPermitHistoryOpinion)) return false;
		else {
			com.justonetech.biz.domain.SgPermitHistoryOpinion sgPermitHistoryOpinion = (com.justonetech.biz.domain.SgPermitHistoryOpinion) obj;
			if (null == this.getId() || null == sgPermitHistoryOpinion.getId()) return false;
			else return (this.getId().equals(sgPermitHistoryOpinion.getId()));
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
		builder.append(opinion);
		builder.append(status);
		return builder.toString();
	}


}
