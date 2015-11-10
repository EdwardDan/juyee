package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SG_AUDIT_OPINION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 施工审核意见
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 施工审核意见
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : sg
 * Projectable : false
 *
 * @hibernate.class
 *  table="SG_AUDIT_OPINION"
 */

public abstract class BaseSgAuditOpinion  implements Serializable, Auditable {

	public static String REF = "SgAuditOpinion";
	public static String PROP_IS_FH_OPINION = "isFhOpinion";
	public static String PROP_STATUS = "status";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_SG_PERMIT = "sgPermit";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_NO = "no";
	public static String PROP_IS_SH_OPINION = "isShOpinion";
	public static String PROP_UPDATE_USER = "updateUser";
	public static String PROP_IS_CS_OPINION = "isCsOpinion";


	// constructors
	public BaseSgAuditOpinion () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSgAuditOpinion (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*序号*/
    /*序号*/
	private Long no;
	
    /*初审意见*/
    /*初审意见*/
	private Boolean isCsOpinion;
	
    /*复核意见*/
    /*复核意见*/
	private Boolean isFhOpinion;
	
    /*审核意见*/
    /*审核意见*/
	private Boolean isShOpinion;
	
    /*状态*/
    /*状态*/
	private Integer status;
	
    /*创建时间*/
    /*创建时间*/
	private java.sql.Timestamp createTime;
	
    /*创建用户名*/
    /*创建用户名*/
	private String createUser;
	
    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updateTime;
	
    /*更新用户名*/
    /*更新用户名*/
	private String updateUser;
	

	// many to one
	private com.justonetech.biz.domain.SgPermit sgPermit;



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
	 * Return the value associated with the column: NO
	 */
	public Long getNo () {
		return no;
	}

	/**
	 * Set the value related to the column: NO
	 * @param no the NO value
	 */
	public void setNo (Long no) {
		this.no = no;
	}


	/**
	 * Return the value associated with the column: IS_CS_OPINION
	 */
	public Boolean getIsCsOpinion () {
		return isCsOpinion;
	}

	/**
	 * Set the value related to the column: IS_CS_OPINION
	 * @param isCsOpinion the IS_CS_OPINION value
	 */
	public void setIsCsOpinion (Boolean isCsOpinion) {
		this.isCsOpinion = isCsOpinion;
	}


	/**
	 * Return the value associated with the column: IS_FH_OPINION
	 */
	public Boolean getIsFhOpinion () {
		return isFhOpinion;
	}

	/**
	 * Set the value related to the column: IS_FH_OPINION
	 * @param isFhOpinion the IS_FH_OPINION value
	 */
	public void setIsFhOpinion (Boolean isFhOpinion) {
		this.isFhOpinion = isFhOpinion;
	}


	/**
	 * Return the value associated with the column: IS_SH_OPINION
	 */
	public Boolean getIsShOpinion () {
		return isShOpinion;
	}

	/**
	 * Set the value related to the column: IS_SH_OPINION
	 * @param isShOpinion the IS_SH_OPINION value
	 */
	public void setIsShOpinion (Boolean isShOpinion) {
		this.isShOpinion = isShOpinion;
	}


	/**
	 * Return the value associated with the column: STATUS
	 */
	public Integer getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (Integer status) {
		this.status = status;
	}


	/**
	 * Return the value associated with the column: CREATE_TIME
	 */
	public java.sql.Timestamp getCreateTime () {
		return createTime;
	}

	/**
	 * Set the value related to the column: CREATE_TIME
	 * @param createTime the CREATE_TIME value
	 */
	public void setCreateTime (java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}


	/**
	 * Return the value associated with the column: CREATE_USER
	 */
	public String getCreateUser () {
		return createUser;
	}

	/**
	 * Set the value related to the column: CREATE_USER
	 * @param createUser the CREATE_USER value
	 */
	public void setCreateUser (String createUser) {
		this.createUser = createUser;
	}


	/**
	 * Return the value associated with the column: UPDATE_TIME
	 */
	public java.sql.Timestamp getUpdateTime () {
		return updateTime;
	}

	/**
	 * Set the value related to the column: UPDATE_TIME
	 * @param updateTime the UPDATE_TIME value
	 */
	public void setUpdateTime (java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}


	/**
	 * Return the value associated with the column: UPDATE_USER
	 */
	public String getUpdateUser () {
		return updateUser;
	}

	/**
	 * Set the value related to the column: UPDATE_USER
	 * @param updateUser the UPDATE_USER value
	 */
	public void setUpdateUser (String updateUser) {
		this.updateUser = updateUser;
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
		if (!(obj instanceof com.justonetech.biz.domain.SgAuditOpinion)) return false;
		else {
			com.justonetech.biz.domain.SgAuditOpinion sgAuditOpinion = (com.justonetech.biz.domain.SgAuditOpinion) obj;
			if (null == this.getId() || null == sgAuditOpinion.getId()) return false;
			else return (this.getId().equals(sgAuditOpinion.getId()));
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
		builder.append(no);
		builder.append(isCsOpinion);
		builder.append(isFhOpinion);
		builder.append(isShOpinion);
		builder.append(status);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}