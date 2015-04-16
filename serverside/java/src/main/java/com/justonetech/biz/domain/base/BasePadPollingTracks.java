package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PAD_POLLING_TRACKS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 移动巡检轨迹
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 移动巡检轨迹
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : pad
 * Projectable : false
 *
 * @hibernate.class
 *  table="PAD_POLLING_TRACKS"
 */

public abstract class BasePadPollingTracks  implements Serializable,Auditable {

	public static String REF = "PadPollingTracks";
	public static String PROP_USER = "user";
	public static String PROP_IMEI = "imei";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_LATITUDE = "latitude";
	public static String PROP_ID = "id";
	public static String PROP_LONGITUDE = "longitude";
	public static String PROP_USER_NAME = "userName";
	public static String PROP_MOVE_TIME = "moveTime";


	// constructors
	public BasePadPollingTracks () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePadPollingTracks (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*用户名称*/
    /*用户名称*/
	private String userName;
	
    /*设备标识码*/
    /*设备标识码*/
	private String imei;
	
    /*经度*/
    /*经度*/
	private Double longitude;
	
    /*纬度*/
    /*纬度*/
	private Double latitude;
	
    /*移动时间*/
    /*移动时间*/
	private java.sql.Timestamp moveTime;
	
    /*创建时间*/
    /*创建时间*/
	private java.sql.Timestamp createTime;
	
    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updateTime;
	

	// many to one
	private com.justonetech.system.domain.SysUser user;



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
	 * Return the value associated with the column: USER_NAME
	 */
	public String getUserName () {
		return userName;
	}

	/**
	 * Set the value related to the column: USER_NAME
	 * @param userName the USER_NAME value
	 */
	public void setUserName (String userName) {
		this.userName = userName;
	}


	/**
	 * Return the value associated with the column: IMEI
	 */
	public String getImei () {
		return imei;
	}

	/**
	 * Set the value related to the column: IMEI
	 * @param imei the IMEI value
	 */
	public void setImei (String imei) {
		this.imei = imei;
	}


	/**
	 * Return the value associated with the column: LONGITUDE
	 */
	public Double getLongitude () {
		return longitude;
	}

	/**
	 * Set the value related to the column: LONGITUDE
	 * @param longitude the LONGITUDE value
	 */
	public void setLongitude (Double longitude) {
		this.longitude = longitude;
	}


	/**
	 * Return the value associated with the column: LATITUDE
	 */
	public Double getLatitude () {
		return latitude;
	}

	/**
	 * Set the value related to the column: LATITUDE
	 * @param latitude the LATITUDE value
	 */
	public void setLatitude (Double latitude) {
		this.latitude = latitude;
	}


	/**
	 * Return the value associated with the column: MOVE_TIME
	 */
	public java.sql.Timestamp getMoveTime () {
		return moveTime;
	}

	/**
	 * Set the value related to the column: MOVE_TIME
	 * @param moveTime the MOVE_TIME value
	 */
	public void setMoveTime (java.sql.Timestamp moveTime) {
		this.moveTime = moveTime;
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
	 * Return the value associated with the column: USER_ID
	 */
	public com.justonetech.system.domain.SysUser getUser () {
		return user;
	}

	/**
	 * Set the value related to the column: USER_ID
	 * @param user the USER_ID value
	 */
	public void setUser (com.justonetech.system.domain.SysUser user) {
		this.user = user;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.PadPollingTracks)) return false;
		else {
			com.justonetech.biz.domain.PadPollingTracks padPollingTracks = (com.justonetech.biz.domain.PadPollingTracks) obj;
			if (null == this.getId() || null == padPollingTracks.getId()) return false;
			else return (this.getId().equals(padPollingTracks.getId()));
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
		builder.append(userName);
		builder.append(imei);
		builder.append(longitude);
		builder.append(latitude);
		builder.append(moveTime);
		builder.append(createTime);
		builder.append(updateTime);
		return builder.toString();
	}


}