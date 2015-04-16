package com.justonetech.system.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SYS_CUSTOM_GRID table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 系统首页板块设置
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 系统首页板块设置
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : system
 * Projectable : false
 *
 * @hibernate.class
 *  table="SYS_CUSTOM_GRID"
 */

public abstract class BaseSysCustomGrid  implements Serializable,Auditable {

	public static String REF = "SysCustomGrid";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_ORDER_NO = "orderNo";
	public static String PROP_MODEL_NAME = "modelName";
	public static String PROP_IS_VALID = "isValid";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_PRIVILEGE = "privilege";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_UPDATE_USER = "updateUser";
	public static String PROP_MODEL_CODE = "modelCode";
	public static String PROP_MORE_LINE = "moreLink";


	// constructors
	public BaseSysCustomGrid () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSysCustomGrid (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*板块编码*/
    /*板块编码*/
	private java.lang.String modelCode;
	
    /*板块名称*/
    /*板块名称*/
	private java.lang.String modelName;

    /*更多链接*/
    /*更多链接*/
	private java.lang.String moreLink;

    /*是否有效*/
    /*是否有效*/
	private java.lang.Boolean isValid;
	
    /*排序号*/
    /*排序号*/
	private java.lang.Integer orderNo;
	
    /*创建时间*/
    /*创建时间*/
	private java.sql.Timestamp createTime;
	
    /*创建用户名*/
    /*创建用户名*/
	private java.lang.String createUser;
	
    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updateTime;
	
    /*更新用户名*/
    /*更新用户名*/
	private java.lang.String updateUser;
	

	// many to one
	private com.justonetech.system.domain.SysPrivilege privilege;

	// collections
	private java.util.Set<com.justonetech.system.domain.SysCustomGridUser> sysCustomGridUsers;



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
	 * Return the value associated with the column: MODEL_CODE
	 */
	public java.lang.String getModelCode () {
		return modelCode;
	}

	/**
	 * Set the value related to the column: MODEL_CODE
	 * @param modelCode the MODEL_CODE value
	 */
	public void setModelCode (java.lang.String modelCode) {
		this.modelCode = modelCode;
	}


	/**
	 * Return the value associated with the column: MODEL_NAME
	 */
	public java.lang.String getModelName () {
		return modelName;
	}

	/**
	 * Set the value related to the column: MODEL_NAME
	 * @param modelName the MODEL_NAME value
	 */
	public void setModelName (java.lang.String modelName) {
		this.modelName = modelName;
	}

    public String getMoreLink() {
        return moreLink;
    }

    public void setMoreLink(String moreLink) {
        this.moreLink = moreLink;
    }

    /**
	 * Return the value associated with the column: IS_VALID
	 */
	public java.lang.Boolean getIsValid () {
		return isValid;
	}

	/**
	 * Set the value related to the column: IS_VALID
	 * @param isValid the IS_VALID value
	 */
	public void setIsValid (java.lang.Boolean isValid) {
		this.isValid = isValid;
	}


	/**
	 * Return the value associated with the column: ORDER_NO
	 */
	public java.lang.Integer getOrderNo () {
		return orderNo;
	}

	/**
	 * Set the value related to the column: ORDER_NO
	 * @param orderNo the ORDER_NO value
	 */
	public void setOrderNo (java.lang.Integer orderNo) {
		this.orderNo = orderNo;
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
	public java.lang.String getCreateUser () {
		return createUser;
	}

	/**
	 * Set the value related to the column: CREATE_USER
	 * @param createUser the CREATE_USER value
	 */
	public void setCreateUser (java.lang.String createUser) {
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
	public java.lang.String getUpdateUser () {
		return updateUser;
	}

	/**
	 * Set the value related to the column: UPDATE_USER
	 * @param updateUser the UPDATE_USER value
	 */
	public void setUpdateUser (java.lang.String updateUser) {
		this.updateUser = updateUser;
	}


	/**
	 * Return the value associated with the column: PRIVILEGE_ID
	 */
	public com.justonetech.system.domain.SysPrivilege getPrivilege () {
		return privilege;
	}

	/**
	 * Set the value related to the column: PRIVILEGE_ID
	 * @param privilege the PRIVILEGE_ID value
	 */
	public void setPrivilege (com.justonetech.system.domain.SysPrivilege privilege) {
		this.privilege = privilege;
	}


	/**
	 * Return the value associated with the column: sysCustomGridUsers
	 */
	public java.util.Set<com.justonetech.system.domain.SysCustomGridUser> getSysCustomGridUsers () {
		if(sysCustomGridUsers == null){
			sysCustomGridUsers = new java.util.LinkedHashSet<com.justonetech.system.domain.SysCustomGridUser>();
		}
		return sysCustomGridUsers;
	}

	/**
	 * Set the value related to the column: sysCustomGridUsers
	 * @param sysCustomGridUsers the sysCustomGridUsers value
	 */
	public void setSysCustomGridUsers (java.util.Set<com.justonetech.system.domain.SysCustomGridUser> sysCustomGridUsers) {
		this.sysCustomGridUsers = sysCustomGridUsers;
	}

	public void addTosysCustomGridUsers (com.justonetech.system.domain.SysCustomGridUser sysCustomGridUser) {
		if (null == getSysCustomGridUsers()) setSysCustomGridUsers(new java.util.LinkedHashSet<com.justonetech.system.domain.SysCustomGridUser>());
		getSysCustomGridUsers().add(sysCustomGridUser);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.system.domain.SysCustomGrid)) return false;
		else {
			com.justonetech.system.domain.SysCustomGrid sysCustomGrid = (com.justonetech.system.domain.SysCustomGrid) obj;
			if (null == this.getId() || null == sysCustomGrid.getId()) return false;
			else return (this.getId().equals(sysCustomGrid.getId()));
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
		builder.append(modelCode);
		builder.append(modelName);
		builder.append(moreLink);
		builder.append(isValid);
		builder.append(orderNo);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}