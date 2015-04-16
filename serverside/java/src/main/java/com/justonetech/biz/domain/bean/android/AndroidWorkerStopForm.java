package com.justonetech.biz.domain.bean.android;

import java.io.Serializable;

/**
 * note: 法管理停工单
 * User: Shaxj
 * Date: 14-12-24
 * Time: 下午2:01
 */
public class AndroidWorkerStopForm implements Serializable {
    // primary key
    private Long id;

    // fields
    /*工程名称*/
    /*工程名称*/
    private String projectName;

    /*字*/
    /*字*/
    private String formFont;

    /*号*/
    /*号*/
    private String formCode;

    /*责任主体*/
    /*责任主体*/
    private String unitName;

    /*停工日期*/
    /*停工日期*/
    private java.sql.Timestamp stopTime;

    /*签发时间*/
    /*签发时间*/
    private java.sql.Date signDate;

    /*检查人员*/
    /*检查人员*/
    private String checkPerson;

    /*签发人*/
    /*签发人*/
    private String signPerson;

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
     * Return the value associated with the column: PROJECT_NAME
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Set the value related to the column: PROJECT_NAME
     *
     * @param projectName the PROJECT_NAME value
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    /**
     * Return the value associated with the column: FORM_FONT
     */
    public String getFormFont() {
        return formFont;
    }

    /**
     * Set the value related to the column: FORM_FONT
     *
     * @param formFont the FORM_FONT value
     */
    public void setFormFont(String formFont) {
        this.formFont = formFont;
    }


    /**
     * Return the value associated with the column: FORM_CODE
     */
    public String getFormCode() {
        return formCode;
    }

    /**
     * Set the value related to the column: FORM_CODE
     *
     * @param formCode the FORM_CODE value
     */
    public void setFormCode(String formCode) {
        this.formCode = formCode;
    }


    /**
     * Return the value associated with the column: UNIT_NAME
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * Set the value related to the column: UNIT_NAME
     *
     * @param unitName the UNIT_NAME value
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }


    /**
     * Return the value associated with the column: STOP_TIME
     */
    public java.sql.Timestamp getStopTime() {
        return stopTime;
    }

    /**
     * Set the value related to the column: STOP_TIME
     *
     * @param stopTime the STOP_TIME value
     */
    public void setStopTime(java.sql.Timestamp stopTime) {
        this.stopTime = stopTime;
    }


    /**
     * Return the value associated with the column: SIGN_DATE
     */
    public java.sql.Date getSignDate() {
        return signDate;
    }

    /**
     * Set the value related to the column: SIGN_DATE
     *
     * @param signDate the SIGN_DATE value
     */
    public void setSignDate(java.sql.Date signDate) {
        this.signDate = signDate;
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
     * Return the value associated with the column: SIGN_PERSON
     */
    public String getSignPerson() {
        return signPerson;
    }

    /**
     * Set the value related to the column: SIGN_PERSON
     *
     * @param signPerson the SIGN_PERSON value
     */
    public void setSignPerson(String signPerson) {
        this.signPerson = signPerson;
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
        final StringBuffer sb = new StringBuffer("AndroidWorkerStopForm{");
        sb.append("id=").append(id);
        sb.append(", projectName='").append(projectName).append('\'');
        sb.append(", formFont='").append(formFont).append('\'');
        sb.append(", formCode='").append(formCode).append('\'');
        sb.append(", unitName='").append(unitName).append('\'');
        sb.append(", stopTime=").append(stopTime);
        sb.append(", signDate=").append(signDate);
        sb.append(", checkPerson='").append(checkPerson).append('\'');
        sb.append(", signPerson='").append(signPerson).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser='").append(createUser).append('\'');
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateUser='").append(updateUser).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
