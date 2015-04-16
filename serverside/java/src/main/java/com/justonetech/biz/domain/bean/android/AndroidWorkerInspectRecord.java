package com.justonetech.biz.domain.bean.android;

import java.io.Serializable;

/**
 * note:现场检查记录
 * User: Shaxj
 * Date: 14-12-24
 * Time: 下午1:59
 */
public class AndroidWorkerInspectRecord implements Serializable {

    // primary key
    private Long id;

    // fields
    /*报建编号*/
    /*报建编号*/
    private String bjbh;

    /*检查地点*/
    /*检查地点*/
    private String checkAddress;

    /*检查日期*/
    /*检查日期*/
    private java.sql.Date checkDate;

    /*检查起始时分*/
    /*检查起始时分*/
    private String startTime;

    /*检查结束时分*/
    /*检查结束时分*/
    private String endTime;

    /*当事人*/
    /*当事人*/
    private String currentPerson;

    /*地址*/
    /*地址*/
    private String address;

    /*法定代表人*/
    /*法定代表人*/
    private String fr;

    /*电话*/
    /*电话*/
    private String tel;

    /*检查人员*/
    /*检查人员*/
    private String checkPerson;

    /*记录人*/
    /*记录人*/
    private String recordPerson;

    /*现场检查情况*/
    /*现场检查情况*/
    private String checkContent;

    /*是否来源手持终端*/
    /*是否来源手持终端*/
    private Boolean isFromAndroid;

    /*创建时间*/
    /*创建时间*/
    private java.sql.Timestamp createTime;

    /*创建用户名*/
    /*创建用户名*/
    private String createUser;

    /*更新时间*/
    /*更新时间*/
    private java.sql.Timestamp updateTime;

    /*更新用户名*/
    /*更新用户名*/
    private String updateUser;


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
    }


    /**
     * Return the value associated with the column: BJBH
     */
    public String getBjbh() {
        return bjbh;
    }

    /**
     * Set the value related to the column: BJBH
     *
     * @param bjbh the BJBH value
     */
    public void setBjbh(String bjbh) {
        this.bjbh = bjbh;
    }


    /**
     * Return the value associated with the column: CHECK_ADDRESS
     */
    public String getCheckAddress() {
        return checkAddress;
    }

    /**
     * Set the value related to the column: CHECK_ADDRESS
     *
     * @param checkAddress the CHECK_ADDRESS value
     */
    public void setCheckAddress(String checkAddress) {
        this.checkAddress = checkAddress;
    }


    /**
     * Return the value associated with the column: CHECK_DATE
     */
    public java.sql.Date getCheckDate() {
        return checkDate;
    }

    /**
     * Set the value related to the column: CHECK_DATE
     *
     * @param checkDate the CHECK_DATE value
     */
    public void setCheckDate(java.sql.Date checkDate) {
        this.checkDate = checkDate;
    }


    /**
     * Return the value associated with the column: START_TIME
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Set the value related to the column: START_TIME
     *
     * @param startTime the START_TIME value
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }


    /**
     * Return the value associated with the column: END_TIME
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * Set the value related to the column: END_TIME
     *
     * @param endTime the END_TIME value
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


    /**
     * Return the value associated with the column: CURRENT_PERSON
     */
    public String getCurrentPerson() {
        return currentPerson;
    }

    /**
     * Set the value related to the column: CURRENT_PERSON
     *
     * @param currentPerson the CURRENT_PERSON value
     */
    public void setCurrentPerson(String currentPerson) {
        this.currentPerson = currentPerson;
    }


    /**
     * Return the value associated with the column: ADDRESS
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the value related to the column: ADDRESS
     *
     * @param address the ADDRESS value
     */
    public void setAddress(String address) {
        this.address = address;
    }


    /**
     * Return the value associated with the column: FR
     */
    public String getFr() {
        return fr;
    }

    /**
     * Set the value related to the column: FR
     *
     * @param fr the FR value
     */
    public void setFr(String fr) {
        this.fr = fr;
    }


    /**
     * Return the value associated with the column: TEL
     */
    public String getTel() {
        return tel;
    }

    /**
     * Set the value related to the column: TEL
     *
     * @param tel the TEL value
     */
    public void setTel(String tel) {
        this.tel = tel;
    }


    /**
     * Return the value associated with the column: CHECK_PERSON
     */
    public String getCheckPerson() {
        return checkPerson;
    }

    /**
     * Set the value related to the column: CHECK_PERSON
     *
     * @param checkPerson the CHECK_PERSON value
     */
    public void setCheckPerson(String checkPerson) {
        this.checkPerson = checkPerson;
    }


    /**
     * Return the value associated with the column: RECORD_PERSON
     */
    public String getRecordPerson() {
        return recordPerson;
    }

    /**
     * Set the value related to the column: RECORD_PERSON
     *
     * @param recordPerson the RECORD_PERSON value
     */
    public void setRecordPerson(String recordPerson) {
        this.recordPerson = recordPerson;
    }


    /**
     * Return the value associated with the column: CHECK_CONTENT
     */
    public String getCheckContent() {
        return checkContent;
    }

    /**
     * Set the value related to the column: CHECK_CONTENT
     *
     * @param checkContent the CHECK_CONTENT value
     */
    public void setCheckContent(String checkContent) {
        this.checkContent = checkContent;
    }


    /**
     * Return the value associated with the column: IS_FROM_ANDROID
     */
    public Boolean getIsFromAndroid() {
        return isFromAndroid;
    }

    /**
     * Set the value related to the column: IS_FROM_ANDROID
     *
     * @param isFromAndroid the IS_FROM_ANDROID value
     */
    public void setIsFromAndroid(Boolean isFromAndroid) {
        this.isFromAndroid = isFromAndroid;
    }


    /**
     * Return the value associated with the column: CREATE_TIME
     */
    public java.sql.Timestamp getCreateTime() {
        return createTime;
    }

    /**
     * Set the value related to the column: CREATE_TIME
     *
     * @param createTime the CREATE_TIME value
     */
    public void setCreateTime(java.sql.Timestamp createTime) {
        this.createTime = createTime;
    }


    /**
     * Return the value associated with the column: CREATE_USER
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * Set the value related to the column: CREATE_USER
     *
     * @param createUser the CREATE_USER value
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }


    /**
     * Return the value associated with the column: UPDATE_TIME
     */
    public java.sql.Timestamp getUpdateTime() {
        return updateTime;
    }

    /**
     * Set the value related to the column: UPDATE_TIME
     *
     * @param updateTime the UPDATE_TIME value
     */
    public void setUpdateTime(java.sql.Timestamp updateTime) {
        this.updateTime = updateTime;
    }


    /**
     * Return the value associated with the column: UPDATE_USER
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * Set the value related to the column: UPDATE_USER
     *
     * @param updateUser the UPDATE_USER value
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AndroidWorkerInspectRecord{");
        sb.append("id=").append(id);
        sb.append(", bjbh='").append(bjbh).append('\'');
        sb.append(", checkAddress='").append(checkAddress).append('\'');
        sb.append(", checkDate=").append(checkDate);
        sb.append(", startTime='").append(startTime).append('\'');
        sb.append(", endTime='").append(endTime).append('\'');
        sb.append(", currentPerson='").append(currentPerson).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", fr='").append(fr).append('\'');
        sb.append(", tel='").append(tel).append('\'');
        sb.append(", checkPerson='").append(checkPerson).append('\'');
        sb.append(", recordPerson='").append(recordPerson).append('\'');
        sb.append(", checkContent='").append(checkContent).append('\'');
        sb.append(", isFromAndroid=").append(isFromAndroid);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser='").append(createUser).append('\'');
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateUser='").append(updateUser).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
