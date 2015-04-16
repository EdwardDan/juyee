package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;
import java.sql.Date;


/**
 * This is an object that contains data related to the PROJECT_BID_SIGN_DEPT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 招标报名单位
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 招标报名单位
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : project
 * Projectable : false
 *
 * @hibernate.class table="PROJECT_BID_SIGN_DEPT"
 */

public abstract class BaseProjectBidSignDept implements Serializable, Auditable {

    public static String REF = "ProjectBidSignDept";
    public static String PROP_RETURN_ACCOUNT = "returnAccount";
    public static String PROP_SIGN_UNIT = "signUnit";
    public static String PROP_UPDATE_TIME = "updateTime";
    public static String PROP_RETURN_DATE = "returnDate";
    public static String PROP_SIGN_DATE = "signDate";
    public static String PROP_PROJECT_BID_SIGN = "projectBidSign";
    public static String PROP_CREATE_USER = "createUser";
    public static String PROP_LINK_TEL = "linkTel";
    public static String PROP_LINK_PERSON = "linkPerson";
    public static String PROP_CREATE_TIME = "createTime";
    public static String PROP_PAY_ACCOUNT = "payAccount";
    public static String PROP_ID = "id";
    public static String PROP_PAY_DATE = "payDate";
    public static String PROP_UPDATE_USER = "updateUser";
    public static String PROP_IS_AFFORD = "isAfford";
    public static String PROP_NEED_BACK = "needBack";


    // constructors
    public BaseProjectBidSignDept() {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseProjectBidSignDept(Long id) {
        this.setId(id);
        initialize();
    }

    protected void initialize() {
    }


    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private Long id;
    // 是否已缴纳保证金
    private Long isAfford;

    // 是否需要退回保证金
    private Long needBack;

    // fields
    /*报名单位*/
    /*报名单位*/
    private String signUnit;

    /*联系人*/
    /*联系人*/
    private String linkPerson;

    /*联系电话*/
    /*联系电话*/
    private String linkTel;

    /*报名时间*/
    /*报名时间*/
    private java.sql.Timestamp signDate;

    /*缴纳时间*/
    /*缴纳时间*/
    private java.sql.Date payDate;

    /*缴纳金额*/
    /*缴纳金额*/
    private Double payAccount;

    /*退还金额*/
    /*退还金额*/
    private Double returnAccount;

    /*退还日期*/
    /*退还日期*/
    private java.sql.Date returnDate;

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


    // many to one
    private com.justonetech.biz.domain.ProjectBidSign projectBidSign;


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

    public Long getNeedBack() {
        return needBack;
    }

    public void setNeedBack(Long needBack) {
        this.needBack = needBack;
    }

    public Long getIsAfford() {
        return isAfford;
    }

    public void setIsAfford(Long isAfford) {
        this.isAfford = isAfford;
    }

    /**
     * Return the value associated with the column: SIGN_UNIT
     */
    public String getSignUnit() {
        return signUnit;
    }

    /**
     * Set the value related to the column: SIGN_UNIT
     *
     * @param signUnit the SIGN_UNIT value
     */
    public void setSignUnit(String signUnit) {
        this.signUnit = signUnit;
    }


    /**
     * Return the value associated with the column: LINK_PERSON
     */
    public String getLinkPerson() {
        return linkPerson;
    }

    /**
     * Set the value related to the column: LINK_PERSON
     *
     * @param linkPerson the LINK_PERSON value
     */
    public void setLinkPerson(String linkPerson) {
        this.linkPerson = linkPerson;
    }


    /**
     * Return the value associated with the column: LINK_TEL
     */
    public String getLinkTel() {
        return linkTel;
    }

    /**
     * Set the value related to the column: LINK_TEL
     *
     * @param linkTel the LINK_TEL value
     */
    public void setLinkTel(String linkTel) {
        this.linkTel = linkTel;
    }


    /**
     * Return the value associated with the column: SIGN_DATE
     */
    public java.sql.Timestamp getSignDate() {
        return signDate;
    }

    /**
     * Set the value related to the column: SIGN_DATE
     *
     * @param signDate the SIGN_DATE value
     */
    public void setSignDate(java.sql.Timestamp signDate) {
        this.signDate = signDate;
    }


    /**
     * Return the value associated with the column: PAY_DATE
     */
    public java.sql.Date getPayDate() {
        return payDate;
    }

    /**
     * Set the value related to the column: PAY_DATE
     *
     * @param payDate the PAY_DATE value
     */
    public void setPayDate(java.sql.Date payDate) {
        this.payDate = payDate;
    }


    /**
     * Return the value associated with the column: PAY_ACCOUNT
     */
    public Double getPayAccount() {
        return payAccount;
    }

    /**
     * Set the value related to the column: PAY_ACCOUNT
     *
     * @param payAccount the PAY_ACCOUNT value
     */
    public void setPayAccount(Double payAccount) {
        this.payAccount = payAccount;
    }


    /**
     * Return the value associated with the column: RETURN_ACCOUNT
     */
    public Double getReturnAccount() {
        return returnAccount;
    }

    /**
     * Set the value related to the column: RETURN_ACCOUNT
     *
     * @param returnAccount the RETURN_ACCOUNT value
     */
    public void setReturnAccount(Double returnAccount) {
        this.returnAccount = returnAccount;
    }


    /**
     * Return the value associated with the column: RETURN_DATE
     */
    public java.sql.Date getReturnDate() {
        return returnDate;
    }

    /**
     * Set the value related to the column: RETURN_DATE
     *
     * @param returnDate the RETURN_DATE value
     */
    public void setReturnDate(java.sql.Date returnDate) {
        this.returnDate = returnDate;
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


    /**
     * Return the value associated with the column: PROJECT_BID_SIGN_ID
     */
    public com.justonetech.biz.domain.ProjectBidSign getProjectBidSign() {
        return projectBidSign;
    }

    /**
     * Set the value related to the column: PROJECT_BID_SIGN_ID
     *
     * @param projectBidSign the PROJECT_BID_SIGN_ID value
     */
    public void setProjectBidSign(com.justonetech.biz.domain.ProjectBidSign projectBidSign) {
        this.projectBidSign = projectBidSign;
    }


    public boolean equals(Object obj) {
        if (null == obj) return false;
        if (!(obj instanceof com.justonetech.biz.domain.ProjectBidSignDept)) return false;
        else {
            com.justonetech.biz.domain.ProjectBidSignDept projectBidSignDept = (com.justonetech.biz.domain.ProjectBidSignDept) obj;
            if (null == this.getId() || null == projectBidSignDept.getId()) return false;
            else return (this.getId().equals(projectBidSignDept.getId()));
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
        builder.append(signUnit);
        builder.append(linkPerson);
        builder.append(linkTel);
        builder.append(signDate);
        builder.append(payDate);
        builder.append(payAccount);
        builder.append(returnAccount);
        builder.append(returnDate);
        builder.append(createTime);
        builder.append(createUser);
        builder.append(updateTime);
        builder.append(updateUser);
        return builder.toString();
    }


}