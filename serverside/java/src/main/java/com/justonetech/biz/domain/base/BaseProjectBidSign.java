package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PROJECT_BID_SIGN table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 招标登记
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 招标登记
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : project
 * Projectable : false
 *
 * @hibernate.class table="PROJECT_BID_SIGN"
 */

public abstract class BaseProjectBidSign implements Serializable, Auditable {

    public static String REF = "ProjectBidSign";
    public static String PROP_PROJECT_NAME = "projectName";
    public static String PROP_SIGN_LAST_DATE = "signLastDate";
    public static String PROP_SIGN_DATE = "signDate";
    public static String PROP_BUILD_UNIT = "buildUnit";
    public static String PROP_UPDATE_TIME = "updateTime";
    public static String PROP_BUILD_ADDRESS = "buildAddress";
    public static String PROP_SIGN_PROXY_UNIT = "signProxyUnit";
    public static String PROP_STATUS = "status";
    public static String PROP_CREATE_USER = "createUser";
    public static String PROP_BJBH = "bjbh";
    public static String PROP_LINK_TEL = "linkTel";
    public static String PROP_SIGN_ACCOUNT = "signAccount";
    public static String PROP_LINK_PERSON = "linkPerson";
    public static String PROP_CREATE_TIME = "createTime";
    public static String PROP_ID = "id";
    public static String PROP_BDH = "bdh";
    public static String PROP_UPDATE_USER = "updateUser";


    // constructors
    public BaseProjectBidSign() {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseProjectBidSign(Long id) {
        this.setId(id);
        initialize();
    }

    protected void initialize() {
    }


    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private Long id;

    // fields
    /*报建编号*/
    /*报建编号*/
    private String bjbh;

    /*标段号*/
    /*标段号*/
    private String bdh;

    /*项目名称*/
    /*项目名称*/
    private String projectName;

    /*建设单位*/
    /*建设单位*/
    private String buildUnit;

    /*建设地点*/
    /*建设地点*/
    private String buildAddress;

    /*报名截至时间*/
    /*报名截至时间*/
    private java.sql.Timestamp signLastDate;

    /* 开标日期*/
    private java.sql.Timestamp signDate;

    /*招标代理单位*/
    /*招标代理单位*/
    private String signProxyUnit;

    /*联系人*/
    /*联系人*/
    private String linkPerson;

    /*联系电话*/
    /*联系电话*/
    private String linkTel;


    //投标保证金
    private Double signAccount;

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
    private com.justonetech.system.domain.SysCodeDetail status;

    // collections
    private java.util.Set<com.justonetech.biz.domain.ProjectBidSignDept> projectBidSignDepts;


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
     * Return the value associated with the column: BDH
     */
    public String getBdh() {
        return bdh;
    }

    /**
     * Set the value related to the column: BDH
     *
     * @param bdh the BDH value
     */
    public void setBdh(String bdh) {
        this.bdh = bdh;
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
     * Return the value associated with the column: BUILD_UNIT
     */
    public String getBuildUnit() {
        return buildUnit;
    }

    /**
     * Set the value related to the column: BUILD_UNIT
     *
     * @param buildUnit the BUILD_UNIT value
     */
    public void setBuildUnit(String buildUnit) {
        this.buildUnit = buildUnit;
    }


    /**
     * Return the value associated with the column: BUILD_ADDRESS
     */
    public String getBuildAddress() {
        return buildAddress;
    }

    /**
     * Set the value related to the column: BUILD_ADDRESS
     *
     * @param buildAddress the BUILD_ADDRESS value
     */
    public void setBuildAddress(String buildAddress) {
        this.buildAddress = buildAddress;
    }


    /**
     * Return the value associated with the column: SIGN_LAST_DATE
     */
    public java.sql.Timestamp getSignLastDate() {
        return signLastDate;
    }

    /**
     * Set the value related to the column: SIGN_LAST_DATE
     *
     * @param signLastDate the SIGN_LAST_DATE value
     */
    public void setSignLastDate(java.sql.Timestamp signLastDate) {
        this.signLastDate = signLastDate;
    }

    /**
     * Return the value associated with the column: SIGN_DATE
     */
    public java.sql.Timestamp getSignDate() {
        return signDate;
    }

    /**
     * Set the value related to the column: SIGN_LAST_DATE
     *
     * @param signDate the SIGN__DATE value
     */
    public void setSignDate(java.sql.Timestamp signDate) {
        this.signDate = signDate;
    }


    /**
     * Return the value associated with the column: SIGN_PROXY_UNIT
     */
    public String getSignProxyUnit() {
        return signProxyUnit;
    }

    /**
     * Set the value related to the column: SIGN_PROXY_UNIT
     *
     * @param signProxyUnit the SIGN_PROXY_UNIT value
     */
    public void setSignProxyUnit(String signProxyUnit) {
        this.signProxyUnit = signProxyUnit;
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

    public Double getSignAccount() {
        return signAccount;
    }

    public void setSignAccount(Double signAccount) {
        this.signAccount = signAccount;
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
     * Return the value associated with the column: STATUS_ID
     */
    public com.justonetech.system.domain.SysCodeDetail getStatus() {
        return status;
    }

    /**
     * Set the value related to the column: STATUS_ID
     *
     * @param status the STATUS_ID value
     */
    public void setStatus(com.justonetech.system.domain.SysCodeDetail status) {
        this.status = status;
    }


    /**
     * Return the value associated with the column: projectBidSignDepts
     */
    public java.util.Set<com.justonetech.biz.domain.ProjectBidSignDept> getProjectBidSignDepts() {
        if (projectBidSignDepts == null) {
            projectBidSignDepts = new java.util.LinkedHashSet<com.justonetech.biz.domain.ProjectBidSignDept>();
        }
        return projectBidSignDepts;
    }

    /**
     * Set the value related to the column: projectBidSignDepts
     *
     * @param projectBidSignDepts the projectBidSignDepts value
     */
    public void setProjectBidSignDepts(java.util.Set<com.justonetech.biz.domain.ProjectBidSignDept> projectBidSignDepts) {
        this.projectBidSignDepts = projectBidSignDepts;
    }

    public void addToprojectBidSignDepts(com.justonetech.biz.domain.ProjectBidSignDept projectBidSignDept) {
        if (null == getProjectBidSignDepts())
            setProjectBidSignDepts(new java.util.LinkedHashSet<com.justonetech.biz.domain.ProjectBidSignDept>());
        getProjectBidSignDepts().add(projectBidSignDept);
    }


    public boolean equals(Object obj) {
        if (null == obj) return false;
        if (!(obj instanceof com.justonetech.biz.domain.ProjectBidSign)) return false;
        else {
            com.justonetech.biz.domain.ProjectBidSign projectBidSign = (com.justonetech.biz.domain.ProjectBidSign) obj;
            if (null == this.getId() || null == projectBidSign.getId()) return false;
            else return (this.getId().equals(projectBidSign.getId()));
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
        builder.append(bjbh);
        builder.append(bdh);
        builder.append(projectName);
        builder.append(buildUnit);
        builder.append(buildAddress);
        builder.append(signLastDate);
        builder.append(signDate);
        builder.append(signProxyUnit);
        builder.append(linkPerson);
        builder.append(linkTel);
        builder.append(createTime);
        builder.append(createUser);
        builder.append(updateTime);
        builder.append(updateUser);
        return builder.toString();
    }


}