package com.justonetech.system.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SYS_PUSH_DEFINE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 系统首页推送定义
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 系统首页推送定义
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : system
 * Projectable : false
 *
 * @hibernate.class
 *  table="SYS_PUSH_DEFINE"
 */

public abstract class BaseSysPushDefine  implements Serializable,Auditable {

	public static String REF = "SysPushDefine";
	public static String PROP_MENU = "menu";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_ORDER_NO = "orderNo";
	public static String PROP_MODEL_NAME = "modelName";
	public static String PROP_IS_VALID = "isValid";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_UPDATE_USER = "updateUser";
	public static String PROP_QUERY_SQL = "querySql";
	public static String PROP_PUSH_DELAY = "pushDelay";
    public static String PROP_TASK_IMG = "taskImg";


	// constructors
	public BaseSysPushDefine () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSysPushDefine (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*模块名称*/
    /*模块名称*/
	private java.lang.String modelName;

    /*图标*/
    /*图标*/
    private String taskImg;
	
    /*排序号*/
    /*排序号*/
	private java.lang.Integer orderNo;
	
    /*推送时间间隔(天)*/
    /*推送时间间隔(天)*/
	private java.lang.Integer pushDelay;
	
    /*是否有效*/
    /*是否有效*/
	private java.lang.Boolean isValid;
	
    /*查询语句*/
    /*查询语句*/
	private java.lang.String querySql;
	
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
	private com.justonetech.system.domain.SysMenu menu;

	// collections
	private java.util.Set<com.justonetech.system.domain.SysPushUser> sysPushUsers;



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

    public String getTaskImg() {
        return taskImg;
    }

    public void setTaskImg(String taskImg) {
        this.taskImg = taskImg;
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
	 * Return the value associated with the column: PUSH_DELAY
	 */
	public java.lang.Integer getPushDelay () {
		return pushDelay;
	}

	/**
	 * Set the value related to the column: PUSH_DELAY
	 * @param pushDelay the PUSH_DELAY value
	 */
	public void setPushDelay (java.lang.Integer pushDelay) {
		this.pushDelay = pushDelay;
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
	 * Return the value associated with the column: QUERY_SQL
	 */
	public java.lang.String getQuerySql () {
		return querySql;
	}

	/**
	 * Set the value related to the column: QUERY_SQL
	 * @param querySql the QUERY_SQL value
	 */
	public void setQuerySql (java.lang.String querySql) {
		this.querySql = querySql;
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
	 * Return the value associated with the column: MENU_ID
	 */
	public com.justonetech.system.domain.SysMenu getMenu () {
		return menu;
	}

	/**
	 * Set the value related to the column: MENU_ID
	 * @param menu the MENU_ID value
	 */
	public void setMenu (com.justonetech.system.domain.SysMenu menu) {
		this.menu = menu;
	}


	/**
	 * Return the value associated with the column: sysPushUsers
	 */
	public java.util.Set<com.justonetech.system.domain.SysPushUser> getSysPushUsers () {
		if(sysPushUsers == null){
			sysPushUsers = new java.util.LinkedHashSet<com.justonetech.system.domain.SysPushUser>();
		}
		return sysPushUsers;
	}

	/**
	 * Set the value related to the column: sysPushUsers
	 * @param sysPushUsers the sysPushUsers value
	 */
	public void setSysPushUsers (java.util.Set<com.justonetech.system.domain.SysPushUser> sysPushUsers) {
		this.sysPushUsers = sysPushUsers;
	}

	public void addTosysPushUsers (com.justonetech.system.domain.SysPushUser sysPushUser) {
		if (null == getSysPushUsers()) setSysPushUsers(new java.util.LinkedHashSet<com.justonetech.system.domain.SysPushUser>());
		getSysPushUsers().add(sysPushUser);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.system.domain.SysPushDefine)) return false;
		else {
			com.justonetech.system.domain.SysPushDefine sysPushDefine = (com.justonetech.system.domain.SysPushDefine) obj;
			if (null == this.getId() || null == sysPushDefine.getId()) return false;
			else return (this.getId().equals(sysPushDefine.getId()));
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
		builder.append(modelName);
		builder.append(taskImg);
		builder.append(orderNo);
		builder.append(pushDelay);
		builder.append(isValid);
		builder.append(querySql);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}