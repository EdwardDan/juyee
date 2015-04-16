package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;
import com.justonetech.core.entity.Guidable;
import com.justonetech.biz.domain.CheckDeviceInfo;
import com.justonetech.biz.domain.CheckInfo;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * This is an object that contains data related to the CHECK_DEVICE_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 设备注册表
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 设备注册表
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : check
 * Projectable : false
 *
 * @hibernate.class                                                             CHECK_DEVICE_INFO
 *  table="CHECK_DEVICE_INFO"
 */

public abstract class BaseCheckDeviceInfo implements Serializable, Auditable, Guidable {

    public static String REF = "CheckDeviceInfo";
    public static String PROP_CANCEL_DATE_TIME = "cancelDateTime";
    public static String PROP_LAST_ONLINE_TIME = "lastOnlineTime";
    public static String PROP_DEV_SN = "devSn";
    public static String PROP_CANCEL_USER_NAME = "cancelUserName";
    public static String PROP_STREET_AREA = "streetArea";
    public static String PROP_GD_CODE = "gdCode";
    public static String PROP_POSITION_TIME = "positionTime";
    public static String PROP_GUID = "guid";
    public static String PROP_CANCEL_STATUS = "cancelStatus";
    public static String PROP_DEV_MODE = "devMode";
    public static String PROP_BJBH = "bjbh";
    public static String PROP_JD_TASK_CODE = "jdTaskCode";
    public static String PROP_LATITUDE = "latitude";
    public static String PROP_DELETE_USER = "deleteUser";
    public static String PROP_REG_DATE_TIME = "regDateTime";
    public static String PROP_IS_DELETE = "isDelete";
    public static String PROP_DEV_IP = "devIp";
    public static String PROP_DEV_NAME = "devName";
    public static String PROP_CANCEL_USER = "cancelUser";
    public static String PROP_REG_USER = "regUser";
    public static String PROP_REG_USER_NAME = "regUserName";
    public static String PROP_GD_NAME = "gdName";
    public static String PROP_DELETE_TIME = "deleteTime";
    public static String PROP_CURRENT_LONGITUDE = "currentLongitude";
    public static String PROP_ONLINE_STATUS = "onlineStatus";
    public static String PROP_CURRENT_LATITUDE = "currentLatitude";
    public static String PROP_ID = "id";
    public static String PROP_LONGITUDE = "longitude";
    public static String PROP_BELONG_AREA = "belongArea";
    public static String PROP_DEV_SIM = "devSim";


    // constructors
    public BaseCheckDeviceInfo() {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseCheckDeviceInfo(java.lang.Long id) {
        this.setId(id);
        initialize();
    }

    protected void initialize () {}



    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Long id;

    // fields
    /*监督任务书编号*/
    /*监督任务书编号*/
    private java.lang.String jdTaskCode;

    /*报建编号*/
    /*报建编号*/
    private java.lang.String bjbh;

    /*工地编号*/
    /*工地编号*/
    private java.lang.String gdCode;

    /*工地名称*/
    /*工地名称*/
    private java.lang.String gdName;

    /*所属区县*/
    /*所属区县*/
    private java.lang.String belongArea;

    /*街镇*/
    /*街镇*/
    private java.lang.String streetArea;

    /*工地经度*/
    /*工地经度*/
    private java.lang.Double longitude;

    /*工地纬度*/
    /*工地纬度*/
    private java.lang.Double latitude;

    /*设备名称*/
    /*设备名称*/
    private java.lang.String devName;

    /*设备序号*/
    /*设备序号*/
    private java.lang.String devSn;

    /*设备型号*/
    /*设备型号*/
    private java.lang.String devMode;

    /*设备SIM卡*/
    /*设备SIM卡*/
    private java.lang.String devSim;

    /*设备IP*/
    /*设备IP*/
    private java.lang.String devIp;

    /*定位经度*/
    /*定位经度*/
    private java.lang.Double currentLongitude;

    /*定位纬度*/
    /*定位纬度*/
    private java.lang.Double currentLatitude;

    /*定位时间*/
    /*定位时间*/
    private java.sql.Timestamp positionTime;

    /*最近联机时间*/
    /*最近联机时间*/
    private java.sql.Timestamp lastOnlineTime;

    /*设备联机状态*/
    /*设备联机状态*/
    private java.lang.Long onlineStatus;

    /*注册时间*/
    /*注册时间*/
    private java.sql.Timestamp regDateTime;

    /*注册操作人*/
    /*注册操作人*/
    private java.lang.String regUserName;

    /*注销时间*/
    /*注销时间*/
    private java.sql.Timestamp cancelDateTime;

    /*注销状态*/
    /*注销状态*/
    private java.lang.Long cancelStatus;

    /*注销操作人*/
    /*注销操作人*/
    private java.lang.String cancelUserName;

    /*GUID*/
    /*GUID*/
    private java.lang.String guid;

    /*删除人*/
    /*删除人*/
    private java.lang.String deleteUser;

    /*删除时间*/
    /*删除时间*/
    private java.sql.Timestamp deleteTime;

    /*逻辑删除*/
    /*逻辑删除*/
    private java.lang.Boolean isDelete;

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

    // many to one
    private com.justonetech.system.domain.SysUser regUser;
    private com.justonetech.system.domain.SysUser cancelUser;

    // collections
    private java.util.Set<CheckInfo> checkInfos;



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
     * Return the value associated with the column: JD_TASK_CODE
     */
    public java.lang.String getJdTaskCode () {
        return jdTaskCode;
    }

    /**
     * Set the value related to the column: JD_TASK_CODE
     * @param jdTaskCode the JD_TASK_CODE value
     */
    public void setJdTaskCode (java.lang.String jdTaskCode) {
        this.jdTaskCode = jdTaskCode;
    }


    /**
     * Return the value associated with the column: BJBH
     */
    public java.lang.String getBjbh () {
        return bjbh;
    }

    /**
     * Set the value related to the column: BJBH
     * @param bjbh the BJBH value
     */
    public void setBjbh (java.lang.String bjbh) {
        this.bjbh = bjbh;
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
     * Return the value associated with the column: GD_NAME
     */
    public java.lang.String getGdName () {
        return gdName;
    }

    /**
     * Set the value related to the column: GD_NAME
     * @param gdName the GD_NAME value
     */
    public void setGdName (java.lang.String gdName) {
        this.gdName = gdName;
    }


    /**
     * Return the value associated with the column: BELONG_AREA
     */
    public java.lang.String getBelongArea () {
        return belongArea;
    }

    /**
     * Set the value related to the column: BELONG_AREA
     * @param belongArea the BELONG_AREA value
     */
    public void setBelongArea (java.lang.String belongArea) {
        this.belongArea = belongArea;
    }


    /**
     * Return the value associated with the column: STREET_AREA
     */
    public java.lang.String getStreetArea () {
        return streetArea;
    }

    /**
     * Set the value related to the column: STREET_AREA
     * @param streetArea the STREET_AREA value
     */
    public void setStreetArea (java.lang.String streetArea) {
        this.streetArea = streetArea;
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
     * Return the value associated with the column: DEV_NAME
     */
    public java.lang.String getDevName () {
        return devName;
    }

    /**
     * Set the value related to the column: DEV_NAME
     * @param devName the DEV_NAME value
     */
    public void setDevName (java.lang.String devName) {
        this.devName = devName;
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
     * Return the value associated with the column: DEV_MODE
     */
    public java.lang.String getDevMode () {
        return devMode;
    }

    /**
     * Set the value related to the column: DEV_MODE
     * @param devMode the DEV_MODE value
     */
    public void setDevMode (java.lang.String devMode) {
        this.devMode = devMode;
    }


    /**
     * Return the value associated with the column: DEV_SIM
     */
    public java.lang.String getDevSim () {
        return devSim;
    }

    /**
     * Set the value related to the column: DEV_SIM
     * @param devSim the DEV_SIM value
     */
    public void setDevSim (java.lang.String devSim) {
        this.devSim = devSim;
    }


    /**
     * Return the value associated with the column: DEV_IP
     */
    public java.lang.String getDevIp () {
        return devIp;
    }

    /**
     * Set the value related to the column: DEV_IP
     * @param devIp the DEV_IP value
     */
    public void setDevIp (java.lang.String devIp) {
        this.devIp = devIp;
    }


    /**
     * Return the value associated with the column: CURRENT_LONGITUDE
     */
    public java.lang.Double getCurrentLongitude () {
        return currentLongitude;
    }

    /**
     * Set the value related to the column: CURRENT_LONGITUDE
     * @param currentLongitude the CURRENT_LONGITUDE value
     */
    public void setCurrentLongitude (java.lang.Double currentLongitude) {
        this.currentLongitude = currentLongitude;
    }


    /**
     * Return the value associated with the column: CURRENT_LATITUDE
     */
    public java.lang.Double getCurrentLatitude () {
        return currentLatitude;
    }

    /**
     * Set the value related to the column: CURRENT_LATITUDE
     * @param currentLatitude the CURRENT_LATITUDE value
     */
    public void setCurrentLatitude (java.lang.Double currentLatitude) {
        this.currentLatitude = currentLatitude;
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
     * Return the value associated with the column: LAST_ONLINE_TIME
     */
    public java.sql.Timestamp getLastOnlineTime () {
        return lastOnlineTime;
    }

    /**
     * Set the value related to the column: LAST_ONLINE_TIME
     * @param lastOnlineTime the LAST_ONLINE_TIME value
     */
    public void setLastOnlineTime (java.sql.Timestamp lastOnlineTime) {
        this.lastOnlineTime = lastOnlineTime;
    }


    /**
     * Return the value associated with the column: ONLINE_STATUS
     */
    public java.lang.Long getOnlineStatus () {
        return onlineStatus;
    }

    /**
     * Set the value related to the column: ONLINE_STATUS
     * @param onlineStatus the ONLINE_STATUS value
     */
    public void setOnlineStatus (java.lang.Long onlineStatus) {
        this.onlineStatus = onlineStatus;
    }


    /**
     * Return the value associated with the column: REG_DATE_TIME
     */
    public java.sql.Timestamp getRegDateTime () {
        return regDateTime;
    }

    /**
     * Set the value related to the column: REG_DATE_TIME
     * @param regDateTime the REG_DATE_TIME value
     */
    public void setRegDateTime (java.sql.Timestamp regDateTime) {
        this.regDateTime = regDateTime;
    }


    /**
     * Return the value associated with the column: REG_USER_NAME
     */
    public java.lang.String getRegUserName () {
        return regUserName;
    }

    /**
     * Set the value related to the column: REG_USER_NAME
     * @param regUserName the REG_USER_NAME value
     */
    public void setRegUserName (java.lang.String regUserName) {
        this.regUserName = regUserName;
    }


    /**
     * Return the value associated with the column: CANCEL_DATE_TIME
     */
    public java.sql.Timestamp getCancelDateTime () {
        return cancelDateTime;
    }

    /**
     * Set the value related to the column: CANCEL_DATE_TIME
     * @param cancelDateTime the CANCEL_DATE_TIME value
     */
    public void setCancelDateTime (java.sql.Timestamp cancelDateTime) {
        this.cancelDateTime = cancelDateTime;
    }


    /**
     * Return the value associated with the column: CANCEL_STATUS
     */
    public java.lang.Long getCancelStatus () {
        return cancelStatus;
    }

    /**
     * Set the value related to the column: CANCEL_STATUS
     * @param cancelStatus the CANCEL_STATUS value
     */
    public void setCancelStatus (java.lang.Long cancelStatus) {
        this.cancelStatus = cancelStatus;
    }


    /**
     * Return the value associated with the column: CANCEL_USER_NAME
     */
    public java.lang.String getCancelUserName () {
        return cancelUserName;
    }

    /**
     * Set the value related to the column: CANCEL_USER_NAME
     * @param cancelUserName the CANCEL_USER_NAME value
     */
    public void setCancelUserName (java.lang.String cancelUserName) {
        this.cancelUserName = cancelUserName;
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
     * Return the value associated with the column: REG_USER_ID
     */
    public com.justonetech.system.domain.SysUser getRegUser () {
        return regUser;
    }

    /**
     * Set the value related to the column: REG_USER_ID
     * @param regUser the REG_USER_ID value
     */
    public void setRegUser (com.justonetech.system.domain.SysUser regUser) {
        this.regUser = regUser;
    }


    /**
     * Return the value associated with the column: CANCEL_USER_ID
     */
    public com.justonetech.system.domain.SysUser getCancelUser () {
        return cancelUser;
    }

    /**
     * Set the value related to the column: CANCEL_USER_ID
     * @param cancelUser the CANCEL_USER_ID value
     */
    public void setCancelUser (com.justonetech.system.domain.SysUser cancelUser) {
        this.cancelUser = cancelUser;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * Return the value associated with the column: checkInfos
     */
    public java.util.Set<CheckInfo> getCheckInfos() {
        if(checkInfos == null){
            checkInfos = new java.util.LinkedHashSet<CheckInfo>();
        }
        return checkInfos;
    }

    /**
     * Set the value related to the column: checkInfos
     * @param checkInfos the checkInfos value
     */
    public void setCheckInfos(java.util.Set<CheckInfo> checkInfos) {
        this.checkInfos = checkInfos;
    }

    public void addTocheckInfos (CheckInfo checkInfo) {
        if (null == getCheckInfos()) setCheckInfos(new java.util.LinkedHashSet<CheckInfo>());
        getCheckInfos().add(checkInfo);
    }



    public boolean equals (Object obj) {
        if (null == obj) return false;
        if (!(obj instanceof CheckDeviceInfo)) return false;
        else {
            CheckDeviceInfo checkDeviceInfo = (CheckDeviceInfo) obj;
            if (null == this.getId() || null == checkDeviceInfo.getId()) return false;
            else return (this.getId().equals(checkDeviceInfo.getId()));
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
        builder.append(jdTaskCode);
        builder.append(bjbh);
        builder.append(gdCode);
        builder.append(gdName);
        builder.append(belongArea);
        builder.append(streetArea);
        builder.append(longitude);
        builder.append(latitude);
        builder.append(devName);
        builder.append(devSn);
        builder.append(devMode);
        builder.append(devSim);
        builder.append(devIp);
        builder.append(currentLongitude);
        builder.append(currentLatitude);
        builder.append(positionTime);
        builder.append(lastOnlineTime);
        builder.append(onlineStatus);
        builder.append(regDateTime);
        builder.append(regUserName);
        builder.append(cancelDateTime);
        builder.append(cancelStatus);
        builder.append(cancelUserName);
        builder.append(guid);
        builder.append(deleteUser);
        builder.append(deleteTime);
        builder.append(isDelete);
        return builder.toString();
    }


}