package com.justonetech.system.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SYS_SKIN table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 系统皮肤
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 系统皮肤
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : system
 * Projectable : false
 *
 * @hibernate.class
 *  table="SYS_SKIN"
 */

public abstract class BaseSysSkin  implements Serializable,Auditable {

	public static String REF = "SysSkin";
	public static String PROP_NAME = "name";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_IS_DEFAULT = "isDefault";
	public static String PROP_IS_VALID = "isValid";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_CUSTOM_DEFINE = "customDefine";
	public static String PROP_UPDATE_USER = "updateUser";
	public static String PROP_PATH = "path";


	// constructors
	public BaseSysSkin () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSysSkin (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*皮肤名称*/
    /*皮肤名称*/
	private java.lang.String name;
	
    /*路径*/
    /*路径*/
	private java.lang.String path;
	
    /*是否有效*/
    /*是否有效*/
	private java.lang.Boolean isValid;
	
    /*是否缺省*/
    /*是否缺省*/
	private java.lang.Boolean isDefault;
	
    /*自定义属性*/
    /*自定义属性*/
	private java.lang.String customDefine;
	
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
	

	// collections
	private java.util.Set<com.justonetech.system.domain.SysUser> sysUsers;



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
	 * Return the value associated with the column: NAME
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: NAME
	 * @param name the NAME value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}


	/**
	 * Return the value associated with the column: PATH
	 */
	public java.lang.String getPath () {
		return path;
	}

	/**
	 * Set the value related to the column: PATH
	 * @param path the PATH value
	 */
	public void setPath (java.lang.String path) {
		this.path = path;
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
	 * Return the value associated with the column: IS_DEFAULT
	 */
	public java.lang.Boolean getIsDefault () {
		return isDefault;
	}

	/**
	 * Set the value related to the column: IS_DEFAULT
	 * @param isDefault the IS_DEFAULT value
	 */
	public void setIsDefault (java.lang.Boolean isDefault) {
		this.isDefault = isDefault;
	}


	/**
	 * Return the value associated with the column: CUSTOM_DEFINE
	 */
	public java.lang.String getCustomDefine () {
		return customDefine;
	}

	/**
	 * Set the value related to the column: CUSTOM_DEFINE
	 * @param customDefine the CUSTOM_DEFINE value
	 */
	public void setCustomDefine (java.lang.String customDefine) {
		this.customDefine = customDefine;
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
	 * Return the value associated with the column: sysUsers
	 */
	public java.util.Set<com.justonetech.system.domain.SysUser> getSysUsers () {
		return sysUsers;
	}

	/**
	 * Set the value related to the column: sysUsers
	 * @param sysUsers the sysUsers value
	 */
	public void setSysUsers (java.util.Set<com.justonetech.system.domain.SysUser> sysUsers) {
		this.sysUsers = sysUsers;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.system.domain.SysSkin)) return false;
		else {
			com.justonetech.system.domain.SysSkin sysSkin = (com.justonetech.system.domain.SysSkin) obj;
			if (null == this.getId() || null == sysSkin.getId()) return false;
			else return (this.getId().equals(sysSkin.getId()));
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
		builder.append(name);
		builder.append(path);
		builder.append(isValid);
		builder.append(isDefault);
		builder.append(customDefine);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}