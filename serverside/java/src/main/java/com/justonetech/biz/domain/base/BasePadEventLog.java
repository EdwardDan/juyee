package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PAD_EVENT_LOG table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 移动巡检事件日志
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 移动巡检事件日志
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : pad
 * Projectable : false
 *
 * @hibernate.class table="PAD_EVENT_LOG"
 */

public abstract class BasePadEventLog implements Serializable {

    public static String REF = "PadEventLog";
    public static String PROP_PAD_IMEI = "padImei";
    public static String PROP_PAD_COMMIT_TIME = "padCommitTime";
    public static String PROP_EVENT_TIME = "eventTime";
    public static String PROP_EVENT_MSG = "eventMsg";
    public static String PROP_ID = "id";
    public static String PROP_EVENT_TYPE = "eventType";
    public static String PROP_REMARK = "remark";
    public static String USER_NAME = "userName";


    // constructors
    public BasePadEventLog() {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BasePadEventLog(Long id) {
        this.setId(id);
        initialize();
    }

    protected void initialize() {
    }


    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private Long id;

    // fields
    /*设备标识码*/
    /*设备标识码*/
    private String padImei;

    /*事件描述*/
    /*事件描述*/
    private String eventMsg;


    /*事件类型*/
    /*事件类型*/
    private Long eventType;

    /*事件发生时间*/
    /*事件发生时间*/
    private java.sql.Timestamp eventTime;

    /*设备上传时间*/
    /*设备上传时间*/
    private java.sql.Timestamp padCommitTime;

    /*备注*/
    /*备注*/
    private String remark;

    /*用户名*/
    /*用户名*/
    private String userName;


    // many to one
//	private com.justonetech.system.domain.SysCodeDetail eventType;


    /**
     * Return the unique identifier of this class
     *
     * @hibernate.id generator-class="com.justonetech.core.orm.hibernate.LongIdGenerator"
     * column="ID"
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the unique identifier of this class
     *
     * @param id the new ID
     * @deprecated
     */
    public void setId(Long id) {
        this.id = id;
        this.hashCode = Integer.MIN_VALUE;
    }

    /**
     * Return the value associated with the column: EVENT_TYPE
     */
    public Long getEventType() {
        return eventType;
    }

    /**
     * Set the value related to the column: EVENT_TYPE
     *
     * @param eventType the EVENT_TYPE value
     */
    public void setEventType(Long eventType) {
        this.eventType = eventType;
    }

    /**
     * Return the value associated with the column: PAD_IMEI
     */
    public String getPadImei() {
        return padImei;
    }

    /**
     * Set the value related to the column: PAD_IMEI
     *
     * @param padImei the PAD_IMEI value
     */
    public void setPadImei(String padImei) {
        this.padImei = padImei;
    }


    /**
     * Return the value associated with the column: EVENT_MSG
     */
    public String getEventMsg() {
        return eventMsg;
    }

    /**
     * Set the value related to the column: EVENT_MSG
     *
     * @param eventMsg the EVENT_MSG value
     */
    public void setEventMsg(String eventMsg) {
        this.eventMsg = eventMsg;
    }


    /**
     * Return the value associated with the column: EVENT_TIME
     */
    public java.sql.Timestamp getEventTime() {
        return eventTime;
    }

    /**
     * Set the value related to the column: EVENT_TIME
     *
     * @param eventTime the EVENT_TIME value
     */
    public void setEventTime(java.sql.Timestamp eventTime) {
        this.eventTime = eventTime;
    }


    /**
     * Return the value associated with the column: PAD_COMMIT_TIME
     */
    public java.sql.Timestamp getPadCommitTime() {
        return padCommitTime;
    }

    /**
     * Set the value related to the column: PAD_COMMIT_TIME
     *
     * @param padCommitTime the PAD_COMMIT_TIME value
     */
    public void setPadCommitTime(java.sql.Timestamp padCommitTime) {
        this.padCommitTime = padCommitTime;
    }


    /**
     * Return the value associated with the column: REMARK
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Return the value associated with the column: USER_NAME
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set the value related to the column: USER_NAME
     *
     * @param userName the USER_NAME value
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Set the value related to the column: REMARK
     *
     * @param remark the REMARK value
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }


    /**
     * Return the value associated with the column: EVENT_TYPE
     */
//    public com.justonetech.system.domain.SysCodeDetail getEventType() {
//        return eventType;
//    }

    /**
     * Set the value related to the column: EVENT_TYPE
     * <p/>
     * //     * @param eventType the EVENT_TYPE value
     */
//    public void setEventType(com.justonetech.system.domain.SysCodeDetail eventType) {
//        this.eventType = eventType;
//    }
    public boolean equals(Object obj) {
        if (null == obj) return false;
        if (!(obj instanceof com.justonetech.biz.domain.PadEventLog)) return false;
        else {
            com.justonetech.biz.domain.PadEventLog padEventLog = (com.justonetech.biz.domain.PadEventLog) obj;
            if (null == this.getId() || null == padEventLog.getId()) return false;
            else return (this.getId().equals(padEventLog.getId()));
        }
    }

    public int hashCode() {
        if (Integer.MIN_VALUE == this.hashCode) {
            if (null == this.getId()) return super.hashCode();
            else {
                String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
                this.hashCode = hashStr.hashCode();
            }
        }
        return this.hashCode;
    }


    public String toString() {
        org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append(id);
        builder.append(padImei);
        builder.append(eventMsg);
        builder.append(eventTime);
        builder.append(padCommitTime);
        builder.append(remark);
        builder.append(userName);
        return builder.toString();
    }


}