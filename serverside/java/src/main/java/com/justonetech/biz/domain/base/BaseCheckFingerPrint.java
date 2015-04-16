package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;
import com.justonetech.core.entity.Guidable;
import com.justonetech.biz.domain.CheckManager;

import java.io.Serializable;


/**
 * This is an object that contains data related to the CHECK_FINGER_PRINT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 指纹信息表
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 指纹信息表
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : check
 * Projectable : false
 *
 * @hibernate.class
 *  table="CHECK_FINGER_PRINT"
 */

public abstract class BaseCheckFingerPrint  implements Serializable,Auditable,Guidable {

	public static String REF = "CheckFingerPrint";
	public static String PROP_TEMPLATE = "template";
	public static String PROP_BIO_TYPE = "bioType";
	public static String PROP_IS_DELETE = "isDelete";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_DEV_SN = "devSn";
	public static String PROP_FINGERID = "fingerid";
	public static String PROP_GUID = "guid";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_DELETE_TIME = "deleteTime";
	public static String PROP_TEMPLATE3 = "template3";
	public static String PROP_TEMPLATE2 = "template2";
	public static String PROP_MANAGER = "manager";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_FINGER_VERSION = "fingerVersion";
	public static String PROP_DELETE_USER = "deleteUser";
	public static String PROP_ID = "id";
	public static String PROP_TEMPLATE1 = "template1";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseCheckFingerPrint () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCheckFingerPrint (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*指纹模版*/
    /*指纹模版*/
	private java.lang.String template;
	
    /*手指标识(0,1....9)*/
    /*手指标识*/
	private java.lang.Long fingerid;
	
    /*指纹版本号*/
    /*指纹版本号*/
	private java.lang.String fingerVersion;
	
    /*模版类型（指纹、人脸）*/
    /*模版类型（指纹、人脸）*/
	private java.lang.Long bioType;
	
    /*设备序号*/
    /*设备序号*/
	private java.lang.String devSn;
	
    /*备注模版1*/
    /*备注模版1*/
	private java.lang.String template1;
	
    /*备注模版2*/
    /*备注模版2*/
	private java.lang.String template2;
	
    /*备注模版3*/
    /*备注模版3*/
	private java.lang.String template3;
	
    /*创建时间*/
    /*创建时间*/
	private java.sql.Timestamp createTime;
	
    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updateTime;
	
    /*创建人*/
    /*创建人*/
	private java.lang.String createUser;
	
    /*更新人*/
    /*更新人*/
	private java.lang.String updateUser;
	
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




	/**
	 * Return the value associated with the column: TEMPLATE
	 */
	public java.lang.String getTemplate () {
		return template;
	}

	/**
	 * Set the value related to the column: TEMPLATE
	 * @param template the TEMPLATE value
	 */
	public void setTemplate (java.lang.String template) {
		this.template = template;
	}


	/**
	 * Return the value associated with the column: FINGERID
	 */
	public java.lang.Long getFingerid () {
		return fingerid;
	}

	/**
	 * Set the value related to the column: FINGERID
	 * @param fingerid the FINGERID value
	 */
	public void setFingerid (java.lang.Long fingerid) {
		this.fingerid = fingerid;
	}


	/**
	 * Return the value associated with the column: FINGER_VERSION
	 */
	public java.lang.String getFingerVersion () {
		return fingerVersion;
	}

	/**
	 * Set the value related to the column: FINGER_VERSION
	 * @param fingerVersion the FINGER_VERSION value
	 */
	public void setFingerVersion (java.lang.String fingerVersion) {
		this.fingerVersion = fingerVersion;
	}


	/**
	 * Return the value associated with the column: BIO_TYPE
	 */
	public java.lang.Long getBioType () {
		return bioType;
	}

	/**
	 * Set the value related to the column: BIO_TYPE
	 * @param bioType the BIO_TYPE value
	 */
	public void setBioType (java.lang.Long bioType) {
		this.bioType = bioType;
	}


	/**
	 * Return the value associated with the column: DEV_SN
	 */
	public java.lang.String getDevSn () {
		return devSn;
	}

	/**
	 * Set the value related to the column: DEV_SN
	 * @param devSn the DEV_SN value
	 */
	public void setDevSn (java.lang.String devSn) {
		this.devSn = devSn;
	}


	/**
	 * Return the value associated with the column: TEMPLATE1
	 */
	public java.lang.String getTemplate1 () {
		return template1;
	}

	/**
	 * Set the value related to the column: TEMPLATE1
	 * @param template1 the TEMPLATE1 value
	 */
	public void setTemplate1 (java.lang.String template1) {
		this.template1 = template1;
	}


	/**
	 * Return the value associated with the column: TEMPLATE2
	 */
	public java.lang.String getTemplate2 () {
		return template2;
	}

	/**
	 * Set the value related to the column: TEMPLATE2
	 * @param template2 the TEMPLATE2 value
	 */
	public void setTemplate2 (java.lang.String template2) {
		this.template2 = template2;
	}


	/**
	 * Return the value associated with the column: TEMPLATE3
	 */
	public java.lang.String getTemplate3 () {
		return template3;
	}

	/**
	 * Set the value related to the column: TEMPLATE3
	 * @param template3 the TEMPLATE3 value
	 */
	public void setTemplate3 (java.lang.String template3) {
		this.template3 = template3;
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


	/**
	 * Return the value associated with the column: MANAGER_ID
	 */
	public CheckManager getManager () {
		return manager;
	}

	/**
	 * Set the value related to the column: MANAGER_ID
	 * @param manager the MANAGER_ID value
	 */
	public void setManager (CheckManager manager) {
		this.manager = manager;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.CheckFingerPrint)) return false;
		else {
			com.justonetech.biz.domain.CheckFingerPrint checkFingerPrint = (com.justonetech.biz.domain.CheckFingerPrint) obj;
			if (null == this.getId() || null == checkFingerPrint.getId()) return false;
			else return (this.getId().equals(checkFingerPrint.getId()));
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
		builder.append(template);
		builder.append(fingerid);
		builder.append(fingerVersion);
		builder.append(bioType);
		builder.append(devSn);
		builder.append(template1);
		builder.append(template2);
		builder.append(template3);
		builder.append(createTime);
		builder.append(updateTime);
		builder.append(createUser);
		builder.append(updateUser);
		builder.append(deleteUser);
		builder.append(deleteTime);
		builder.append(isDelete);
		builder.append(guid);
		return builder.toString();
	}


}