package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PAD_REG_VERSION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 终端注册版本信息
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 终端注册版本信息
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : pad
 * Projectable : false
 *
 * @hibernate.class
 *  table="PAD_REG_VERSION"
 */

public abstract class BasePadRegVersion  implements Serializable {

	public static String REF = "PadRegVersion";
	public static String PROP_PAD_IMEI = "padImei";
	public static String PROP_VERSION_CODE = "versionCode";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_VERSION_TYPE = "versionType";


	// constructors
	public BasePadRegVersion () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePadRegVersion (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*设备标识码*/
    /*设备标识码*/
	private String padImei;

    /*程序版本号*/
    /*程序版本号*/
	private String versionCode;

    /*版本类型*/
    /*版本类型*/
	private Long versionType;

    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updateTime;




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
	 * Return the value associated with the column: PAD_IMEI
	 */
	public String getPadImei () {
		return padImei;
	}

	/**
	 * Set the value related to the column: PAD_IMEI
	 * @param padImei the PAD_IMEI value
	 */
	public void setPadImei (String padImei) {
		this.padImei = padImei;
	}


	/**
	 * Return the value associated with the column: VERSION_CODE
	 */
	public String getVersionCode () {
		return versionCode;
	}

	/**
	 * Set the value related to the column: VERSION_CODE
	 * @param versionCode the VERSION_CODE value
	 */
	public void setVersionCode (String versionCode) {
		this.versionCode = versionCode;
	}


	/**
	 * Return the value associated with the column: VERSION_TYPE
	 */
	public Long getVersionType () {
		return versionType;
	}

	/**
	 * Set the value related to the column: VERSION_TYPE
	 * @param versionType the VERSION_TYPE value
	 */
	public void setVersionType (Long versionType) {
		this.versionType = versionType;
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



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.PadRegVersion)) return false;
		else {
			com.justonetech.biz.domain.PadRegVersion padRegVersion = (com.justonetech.biz.domain.PadRegVersion) obj;
			if (null == this.getId() || null == padRegVersion.getId()) return false;
			else return (this.getId().equals(padRegVersion.getId()));
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
		builder.append(padImei);
		builder.append(versionCode);
		builder.append(versionType);
		builder.append(updateTime);
		return builder.toString();
	}


}