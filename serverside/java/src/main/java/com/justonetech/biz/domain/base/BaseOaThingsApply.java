package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_THINGS_APPLY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 办公用品申请
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 办公用品申请
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_THINGS_APPLY"
 */

public abstract class BaseOaThingsApply  implements Serializable,Auditable {

	public static String REF = "OaThingsApply";
	public static String PROP_ZR_AUDIT_OPINION = "zrAuditOpinion";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_KZ_AUDIT_USER = "kzAuditUser";
	public static String PROP_KZ_AUDIT_TIME = "kzAuditTime";
	public static String PROP_ZR_AUDIT_USER = "zrAuditUser";
	public static String PROP_APPLY_CONTENT = "applyContent";
	public static String PROP_DEAL_USER = "dealUser";
	public static String PROP_STATUS = "status";
	public static String PROP_KZ_AUDIT_OPINION = "kzAuditOpinion";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_APPLY_DEPT = "applyDept";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_APPLY_USER = "applyUser";
	public static String PROP_ID = "id";
	public static String PROP_ZR_AUDIT_TIME = "zrAuditTime";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseOaThingsApply () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaThingsApply (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*申请说明*/
    /*申请说明*/
	private String applyContent;
	
    /*科长审核意见*/
    /*科长审核意见*/
	private String kzAuditOpinion;
	
    /*科长审核时间*/
    /*科长审核时间*/
	private java.sql.Timestamp kzAuditTime;
	
    /*办公室主任审核意见*/
    /*办公室主任审核意见*/
	private String zrAuditOpinion;
	
    /*办公室主任审核时间*/
    /*办公室主任审核时间*/
	private java.sql.Timestamp zrAuditTime;
	
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
	private com.justonetech.system.domain.SysUser applyUser;
	private com.justonetech.system.domain.SysUser zrAuditUser;
	private com.justonetech.system.domain.SysUser kzAuditUser;
	private com.justonetech.system.domain.SysUser dealUser;
	private com.justonetech.system.domain.SysDept applyDept;

	// collections
	private java.util.Set<com.justonetech.biz.domain.OaThingsApplyItem> oaThingsApplyItems;



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
	 * Return the value associated with the column: APPLY_CONTENT
	 */
	public String getApplyContent () {
		return applyContent;
	}

	/**
	 * Set the value related to the column: APPLY_CONTENT
	 * @param applyContent the APPLY_CONTENT value
	 */
	public void setApplyContent (String applyContent) {
		this.applyContent = applyContent;
	}


	/**
	 * Return the value associated with the column: KZ_AUDIT_OPINION
	 */
	public String getKzAuditOpinion () {
		return kzAuditOpinion;
	}

	/**
	 * Set the value related to the column: KZ_AUDIT_OPINION
	 * @param kzAuditOpinion the KZ_AUDIT_OPINION value
	 */
	public void setKzAuditOpinion (String kzAuditOpinion) {
		this.kzAuditOpinion = kzAuditOpinion;
	}


	/**
	 * Return the value associated with the column: KZ_AUDIT_TIME
	 */
	public java.sql.Timestamp getKzAuditTime () {
		return kzAuditTime;
	}

	/**
	 * Set the value related to the column: KZ_AUDIT_TIME
	 * @param kzAuditTime the KZ_AUDIT_TIME value
	 */
	public void setKzAuditTime (java.sql.Timestamp kzAuditTime) {
		this.kzAuditTime = kzAuditTime;
	}


	/**
	 * Return the value associated with the column: ZR_AUDIT_OPINION
	 */
	public String getZrAuditOpinion () {
		return zrAuditOpinion;
	}

	/**
	 * Set the value related to the column: ZR_AUDIT_OPINION
	 * @param zrAuditOpinion the ZR_AUDIT_OPINION value
	 */
	public void setZrAuditOpinion (String zrAuditOpinion) {
		this.zrAuditOpinion = zrAuditOpinion;
	}


	/**
	 * Return the value associated with the column: ZR_AUDIT_TIME
	 */
	public java.sql.Timestamp getZrAuditTime () {
		return zrAuditTime;
	}

	/**
	 * Set the value related to the column: ZR_AUDIT_TIME
	 * @param zrAuditTime the ZR_AUDIT_TIME value
	 */
	public void setZrAuditTime (java.sql.Timestamp zrAuditTime) {
		this.zrAuditTime = zrAuditTime;
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
	 * Return the value associated with the column: APPLY_USER_ID
	 */
	public com.justonetech.system.domain.SysUser getApplyUser () {
		return applyUser;
	}

	/**
	 * Set the value related to the column: APPLY_USER_ID
	 * @param applyUser the APPLY_USER_ID value
	 */
	public void setApplyUser (com.justonetech.system.domain.SysUser applyUser) {
		this.applyUser = applyUser;
	}


	/**
	 * Return the value associated with the column: ZR_AUDIT_USER_ID
	 */
	public com.justonetech.system.domain.SysUser getZrAuditUser () {
		return zrAuditUser;
	}

	/**
	 * Set the value related to the column: ZR_AUDIT_USER_ID
	 * @param zrAuditUser the ZR_AUDIT_USER_ID value
	 */
	public void setZrAuditUser (com.justonetech.system.domain.SysUser zrAuditUser) {
		this.zrAuditUser = zrAuditUser;
	}


	/**
	 * Return the value associated with the column: KZ_AUDIT_USER_ID
	 */
	public com.justonetech.system.domain.SysUser getKzAuditUser () {
		return kzAuditUser;
	}

	/**
	 * Set the value related to the column: KZ_AUDIT_USER_ID
	 * @param kzAuditUser the KZ_AUDIT_USER_ID value
	 */
	public void setKzAuditUser (com.justonetech.system.domain.SysUser kzAuditUser) {
		this.kzAuditUser = kzAuditUser;
	}


	/**
	 * Return the value associated with the column: DEAL_USER_ID
	 */
	public com.justonetech.system.domain.SysUser getDealUser () {
		return dealUser;
	}

	/**
	 * Set the value related to the column: DEAL_USER_ID
	 * @param dealUser the DEAL_USER_ID value
	 */
	public void setDealUser (com.justonetech.system.domain.SysUser dealUser) {
		this.dealUser = dealUser;
	}


	/**
	 * Return the value associated with the column: APPLY_DEPT_ID
	 */
	public com.justonetech.system.domain.SysDept getApplyDept () {
		return applyDept;
	}

	/**
	 * Set the value related to the column: APPLY_DEPT_ID
	 * @param applyDept the APPLY_DEPT_ID value
	 */
	public void setApplyDept (com.justonetech.system.domain.SysDept applyDept) {
		this.applyDept = applyDept;
	}


	/**
	 * Return the value associated with the column: oaThingsApplyItems
	 */
	public java.util.Set<com.justonetech.biz.domain.OaThingsApplyItem> getOaThingsApplyItems () {
		if(oaThingsApplyItems == null){
			oaThingsApplyItems = new java.util.LinkedHashSet<com.justonetech.biz.domain.OaThingsApplyItem>();
		}
		return oaThingsApplyItems;
	}

	/**
	 * Set the value related to the column: oaThingsApplyItems
	 * @param oaThingsApplyItems the oaThingsApplyItems value
	 */
	public void setOaThingsApplyItems (java.util.Set<com.justonetech.biz.domain.OaThingsApplyItem> oaThingsApplyItems) {
		this.oaThingsApplyItems = oaThingsApplyItems;
	}

	public void addTooaThingsApplyItems (com.justonetech.biz.domain.OaThingsApplyItem oaThingsApplyItem) {
		if (null == getOaThingsApplyItems()) setOaThingsApplyItems(new java.util.LinkedHashSet<com.justonetech.biz.domain.OaThingsApplyItem>());
		getOaThingsApplyItems().add(oaThingsApplyItem);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaThingsApply)) return false;
		else {
			com.justonetech.biz.domain.OaThingsApply oaThingsApply = (com.justonetech.biz.domain.OaThingsApply) obj;
			if (null == this.getId() || null == oaThingsApply.getId()) return false;
			else return (this.getId().equals(oaThingsApply.getId()));
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
		builder.append(applyContent);
		builder.append(kzAuditOpinion);
		builder.append(kzAuditTime);
		builder.append(zrAuditOpinion);
		builder.append(zrAuditTime);
		builder.append(status);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}