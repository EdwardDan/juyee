package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;
import com.justonetech.core.entity.Guidable;
import com.justonetech.biz.domain.CheckDeviceInfo;
import com.justonetech.biz.domain.CheckInfo;
import com.justonetech.biz.domain.CheckManager;

import java.io.Serializable;


/**
 * This is an object that contains data related to the CHECK_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 考勤记录表
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 考勤记录表
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : check
 * Projectable : false
 *
 * @hibernate.class
 *  table="CHECK_INFO"
 */

public abstract class BaseCheckInfo implements Serializable,Auditable,Guidable {

	public static String REF = "CheckInfo";
	public static String PROP_VERIFY_CODE = "verifyCode";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_DEV_SN = "devSn";
	public static String PROP_DEV = "dev";
	public static String PROP_CARD_NO = "cardNo";
	public static String PROP_GD_CODE = "gdCode";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_CHECK_STATUS = "checkStatus";
	public static String PROP_POSITION_TIME = "positionTime";
	public static String PROP_GUID = "guid";
	public static String PROP_MANAGER = "manager";
	public static String PROP_MANAGER_NAME = "managerName";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_CHECK_TIME = "checkTime";
	public static String PROP_LATITUDE = "latitude";
	public static String PROP_ID = "id";
	public static String PROP_LONGITUDE = "longitude";
	public static String PROP_UPDATE_USER = "updateUser";
    public static String PROP_PHOTO_FILE = "photoFile";


	// constructors
	public BaseCheckInfo() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCheckInfo(java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*人员姓名*/
    /*人员姓名*/
	private java.lang.String managerName;
	
    /*身份证号*/
    /*身份证号*/
	private java.lang.String cardNo;
	
    /*考勤时间*/
    /*考勤时间*/
	private java.sql.Timestamp checkTime;
	
    /*工地编号*/
    /*工地编号*/
	private java.lang.String gdCode;
	
    /*设备序号*/
    /*设备序号*/
	private java.lang.String devSn;
	
    /*考勤状态（上班、下班）*/
    /*考勤状态（上班、下班）*/
	private java.lang.String checkStatus;
	
    /*识别标识（指纹、卡、指纹+面部）*/
    /*识别标识（指纹、卡、指纹+面部）*/
	private java.lang.String verifyCode;
	
    /*经度*/
    /*经度*/
	private java.lang.Double longitude;
	
    /*纬度*/
    /*纬度*/
	private java.lang.Double latitude;
	
    /*定位时间*/
    /*定位时间*/
	private java.sql.Timestamp positionTime;
	
    /*GUID*/
    /*GUID*/
	private java.lang.String guid;

    /*照片*/
    /*照片*/
    private String photoFile;
	
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
	

	// many to one
	private CheckManager manager;
	private CheckDeviceInfo dev;



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
	 * Return the value associated with the column: MANAGER_NAME
	 */
	public java.lang.String getManagerName () {
		return managerName;
	}

	/**
	 * Set the value related to the column: MANAGER_NAME
	 * @param managerName the MANAGER_NAME value
	 */
	public void setManagerName (java.lang.String managerName) {
		this.managerName = managerName;
	}


	/**
	 * Return the value associated with the column: CARD_NO
	 */
	public java.lang.String getCardNo () {
		return cardNo;
	}

	/**
	 * Set the value related to the column: CARD_NO
	 * @param cardNo the CARD_NO value
	 */
	public void setCardNo (java.lang.String cardNo) {
		this.cardNo = cardNo;
	}


	/**
	 * Return the value associated with the column: CHECK_TIME
	 */
	public java.sql.Timestamp getCheckTime () {
		return checkTime;
	}

	/**
	 * Set the value related to the column: CHECK_TIME
	 * @param checkTime the CHECK_TIME value
	 */
	public void setCheckTime (java.sql.Timestamp checkTime) {
		this.checkTime = checkTime;
	}


	/**
	 * Return the value associated with the column: GD_CODE
	 */
	public java.lang.String getGdCode () {
		return gdCode;
	}

	/**
	 * Set the value related to the column: GD_CODE
	 * @param gdCode the GD_CODE value
	 */
	public void setGdCode (java.lang.String gdCode) {
		this.gdCode = gdCode;
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
	 * Return the value associated with the column: CHECK_STATUS
	 */
	public java.lang.String getCheckStatus () {
		return checkStatus;
	}

	/**
	 * Set the value related to the column: CHECK_STATUS
	 * @param checkStatus the CHECK_STATUS value
	 */
	public void setCheckStatus (java.lang.String checkStatus) {
		this.checkStatus = checkStatus;
	}


	/**
	 * Return the value associated with the column: VERIFY_CODE
	 */
	public java.lang.String getVerifyCode () {
		return verifyCode;
	}

	/**
	 * Set the value related to the column: VERIFY_CODE
	 * @param verifyCode the VERIFY_CODE value
	 */
	public void setVerifyCode (java.lang.String verifyCode) {
		this.verifyCode = verifyCode;
	}


	/**
	 * Return the value associated with the column: LONGITUDE
	 */
	public java.lang.Double getLongitude () {
		return longitude;
	}

	/**
	 * Set the value related to the column: LONGITUDE
	 * @param longitude the LONGITUDE value
	 */
	public void setLongitude (java.lang.Double longitude) {
		this.longitude = longitude;
	}


	/**
	 * Return the value associated with the column: LATITUDE
	 */
	public java.lang.Double getLatitude () {
		return latitude;
	}

	/**
	 * Set the value related to the column: LATITUDE
	 * @param latitude the LATITUDE value
	 */
	public void setLatitude (java.lang.Double latitude) {
		this.latitude = latitude;
	}


	/**
	 * Return the value associated with the column: POSITION_TIME
	 */
	public java.sql.Timestamp getPositionTime () {
		return positionTime;
	}

	/**
	 * Set the value related to the column: POSITION_TIME
	 * @param positionTime the POSITION_TIME value
	 */
	public void setPositionTime (java.sql.Timestamp positionTime) {
		this.positionTime = positionTime;
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


	/**
	 * Return the value associated with the column: DEV_ID
	 */
	public CheckDeviceInfo getDev () {
		return dev;
	}

	/**
	 * Set the value related to the column: DEV_ID
	 * @param dev the DEV_ID value
	 */
	public void setDev (CheckDeviceInfo dev) {
		this.dev = dev;
	}

    public String getPhotoFile() {
        return photoFile;
    }

    public void setPhotoFile(String photoFile) {
        this.photoFile = photoFile;
    }

    public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof CheckInfo)) return false;
		else {
			CheckInfo checkInfo = (CheckInfo) obj;
			if (null == this.getId() || null == checkInfo.getId()) return false;
			else return (this.getId().equals(checkInfo.getId()));
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
		builder.append(managerName);
		builder.append(cardNo);
		builder.append(checkTime);
		builder.append(gdCode);
		builder.append(devSn);
		builder.append(checkStatus);
		builder.append(verifyCode);
		builder.append(longitude);
		builder.append(latitude);
		builder.append(positionTime);
		builder.append(guid);
		builder.append(createTime);
		builder.append(updateTime);
		builder.append(updateUser);
		builder.append(createUser);
		builder.append(photoFile);
		return builder.toString();
	}


}