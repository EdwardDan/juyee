package com.justonetech.biz.domain.base;

import com.justonetech.biz.domain.CheckManager;

import java.io.Serializable;


/**
 * This is an object that contains data related to the CHECK_REASON table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 未考勤理由
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 未考勤理由
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : check
 * Projectable : false
 *
 * @hibernate.class
 *  table="CHECK_REASON"
 */

public abstract class BaseCheckReason  implements Serializable {

	public static String REF = "CheckReason";
	public static String PROP_GUID = "guid";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_DELETE_TIME = "deleteTime";
	public static String PROP_IS_DELETE = "isDelete";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_POSITION = "position";
	public static String PROP_DELETE_USER = "deleteUser";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_CHECK_REASON = "checkReason";
	public static String PROP_CHECK_DATE = "checkDate";
	public static String PROP_UPDATE_USER = "updateUser";
    public static String PROP_GD_CODE = "gdCode";


	// constructors
	public BaseCheckReason () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCheckReason (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
    private java.lang.Long id;

    /*工地编号*/
    /*工地编号*/
    private java.lang.String gdCode;

	// fields
    /*未考勤理由*/
    /*未考勤理由*/
	private java.lang.String checkReason;
	
    /*未考勤时间*/
    /*未考勤时间*/
	private java.sql.Date checkDate;
	
    /*创建时间*/
    /*创建时间*/
	private java.sql.Timestamp createTime;
	
    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updateTime;
	
    /*更新人*/
    /*更新人*/
	private java.lang.String updateUser;
	
    /*创建人*/
    /*创建人*/
	private java.lang.String createUser;
	
    /*删除人*/
    /*删除人*/
	private java.lang.String deleteUser;
	
    /*删除时间*/
    /*删除时间*/
	private java.sql.Timestamp deleteTime;
	
    /*逻辑删除*/
    /*逻辑删除*/
	private java.lang.Boolean isDelete;
	
    /*GUID*/
    /*GUID*/
	private java.lang.String guid;
	

	// many to one
	private CheckManager manager;



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

    public String getGdCode() {
        return gdCode;
    }

    public void setGdCode(String gdCode) {
        this.gdCode = gdCode;
    }

    /**
	 * Return the value associated with the column: CHECK_REASON
	 */
	public java.lang.String getCheckReason () {
		return checkReason;
	}

	/**
	 * Set the value related to the column: CHECK_REASON
	 * @param checkReason the CHECK_REASON value
	 */
	public void setCheckReason (java.lang.String checkReason) {
		this.checkReason = checkReason;
	}


	/**
	 * Return the value associated with the column: CHECK_DATE
	 */
	public java.sql.Date getCheckDate () {
		return checkDate;
	}

	/**
	 * Set the value related to the column: CHECK_DATE
	 * @param checkDate the CHECK_DATE value
	 */
	public void setCheckDate (java.sql.Date checkDate) {
		this.checkDate = checkDate;
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
	 * Return the value associated with the column: DELETE_USER
	 */
	public java.lang.String getDeleteUser () {
		return deleteUser;
	}

	/**
	 * Set the value related to the column: DELETE_USER
	 * @param deleteUser the DELETE_USER value
	 */
	public void setDeleteUser (java.lang.String deleteUser) {
		this.deleteUser = deleteUser;
	}


	/**
	 * Return the value associated with the column: DELETE_TIME
	 */
	public java.sql.Timestamp getDeleteTime () {
		return deleteTime;
	}

	/**
	 * Set the value related to the column: DELETE_TIME
	 * @param deleteTime the DELETE_TIME value
	 */
	public void setDeleteTime (java.sql.Timestamp deleteTime) {
		this.deleteTime = deleteTime;
	}


	/**
	 * Return the value associated with the column: IS_DELETE
	 */
	public java.lang.Boolean getIsDelete () {
		return isDelete;
	}

	/**
	 * Set the value related to the column: IS_DELETE
	 * @param isDelete the IS_DELETE value
	 */
	public void setIsDelete (java.lang.Boolean isDelete) {
		this.isDelete = isDelete;
	}


	/**
	 * Return the value associated with the column: GUID
	 */
	public java.lang.String getGuid () {
		return guid;
	}

	/**
	 * Set the value related to the column: GUID
	 * @param guid the GUID value
	 */
	public void setGuid (java.lang.String guid) {
		this.guid = guid;
	}


    public CheckManager getManager() {
        return manager;
    }

    public void setManager(CheckManager manager) {
        this.manager = manager;
    }

    public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.CheckReason)) return false;
		else {
			com.justonetech.biz.domain.CheckReason checkReason = (com.justonetech.biz.domain.CheckReason) obj;
			if (null == this.getId() || null == checkReason.getId()) return false;
			else return (this.getId().equals(checkReason.getId()));
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
		builder.append(checkReason);
		builder.append(checkDate);
		builder.append(createTime);
		builder.append(updateTime);
		builder.append(updateUser);
		builder.append(createUser);
		builder.append(deleteUser);
		builder.append(deleteTime);
		builder.append(isDelete);
		builder.append(guid);
		return builder.toString();
	}


}