package com.justonetech.system.domain.base;

import com.justonetech.biz.domain.OaMailGroupUser;
import com.justonetech.system.domain.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;


/**
 * This is an object that contains data related to the SYS_USER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 用户
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 用户管理
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : system
 * Projectable : false
 *
 * @hibernate.class table="SYS_USER"
 */

public abstract class BaseSysUser implements Serializable {

    public static String REF = "SysUser";
    public static String PROP_DISPLAY_NAME = "displayName";
    public static String PROP_STATUS = "status";
    public static String PROP_UPDATE_TIME = "updateTime";
    public static String PROP_LOGIN_NAME = "loginName";
    public static String PROP_OPEN_DATE = "openDate";
    public static String PROP_CREATE_TIME = "createTime";
    public static String PROP_REASON_DESC = "reasonDesc";
    public static String PROP_PERSON = "person";
    public static String PROP_PASSWORD = "password";
    public static String PROP_CREATE_USER = "createUser";
    public static String PROP_CLOSE_DATE = "closeDate";
    public static String PROP_UPDATE_USER = "updateUser";
    public static String PROP_ID = "id";
    public static String PROP_USER_TYPE = "userType";
    public static String PROP_REG_PERSON = "regPerson";
    public static String PROP_PASSWORD_UPDATE_TIME = "passwordUpdateTime";
    public static String PROP_SKIN = "skin";
    public static String PROP_MD5 = "md5Pass";


    // constructors
    public BaseSysUser() {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseSysUser(Long id) {
        this.setId(id);
        initialize();
    }

    /**
     * Constructor for required fields
     */
    public BaseSysUser(
            Long id,
            String loginName) {

        this.setId(id);
        this.setLoginName(loginName);
        initialize();
    }

    protected void initialize() {
    }


    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private Long id;

    // fields
    /*登陆名*/
    /*登陆名*/
    private String loginName;

    /*密码*/
    /*密码*/
    private String password;
    private String md5Pass;

    /*显示名称*/
    /*显示名称*/
    private String displayName;

    /*帐号状态*/
    /*帐号状态：正常、锁定、失效*/
    private String status;

    /*失效/锁定原因*/
    /*失效/锁定原因*/
    private String reasonDesc;

    /*开通日期*/
    /*开通日期*/
    private java.sql.Date openDate;

    /*截止日期*/
    /*截止日期*/
    private java.sql.Date closeDate;

    /*创建时间*/
    /*创建时间*/
    private java.sql.Timestamp createTime;

    /*更新时间*/
    /*更新时间*/
    private java.sql.Timestamp updateTime;

    /*更新人*/
    /*更新人(记录帐号）*/
    private String updateUser;

    /*创建人*/
    /*创建人(记录帐号）*/
    private String createUser;

    /*密码修改时间 */
    /*密码修改时间 */
    private java.sql.Timestamp passwordUpdateTime;


    // many to one
    private com.justonetech.system.domain.SysPerson person;
    private com.justonetech.system.domain.SysRegPerson regPerson;
    private SysCodeDetail userType;
    private SysSkin skin;

    // collections
    private java.util.Set<SysUserRole> sysUserRoles;
    private java.util.Set<SysUserPrivilege> sysUserPrivileges;
    private java.util.Set<OaMailGroupUser> oaMailGroupUsers;



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
     * Return the value associated with the column: LOGIN_NAME
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * Set the value related to the column: LOGIN_NAME
     *
     * @param loginName the LOGIN_NAME value
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }


    /**
     * Return the value associated with the column: PASSWORD
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value related to the column: PASSWORD
     *
     * @param password the PASSWORD value
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String getMd5Pass() {
        return md5Pass;
    }

    public void setMd5Pass(String md5Pass) {
        this.md5Pass = md5Pass;
    }

    public Timestamp getPasswordUpdateTime() {
        return passwordUpdateTime;
    }

    public void setPasswordUpdateTime(Timestamp passwordUpdateTime) {
        this.passwordUpdateTime = passwordUpdateTime;
    }

    /**
     * Return the value associated with the column: DISPLAY_NAME
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Set the value related to the column: DISPLAY_NAME
     *
     * @param displayName the DISPLAY_NAME value
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }


    /**
     * Return the value associated with the column: STATUS
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set the value related to the column: STATUS
     *
     * @param status the STATUS value
     */
    public void setStatus(String status) {
        this.status = status;
    }


    /**
     * Return the value associated with the column: REASON_DESC
     */
    public String getReasonDesc() {
        return reasonDesc;
    }

    /**
     * Set the value related to the column: REASON_DESC
     *
     * @param reasonDesc the REASON_DESC value
     */
    public void setReasonDesc(String reasonDesc) {
        this.reasonDesc = reasonDesc;
    }


    /**
     * Return the value associated with the column: OPEN_DATE
     */
    public java.sql.Date getOpenDate() {
        return openDate;
    }

    /**
     * Set the value related to the column: OPEN_DATE
     *
     * @param openDate the OPEN_DATE value
     */
    public void setOpenDate(java.sql.Date openDate) {
        this.openDate = openDate;
    }


    /**
     * Return the value associated with the column: CLOSE_DATE
     */
    public java.sql.Date getCloseDate() {
        return closeDate;
    }

    /**
     * Set the value related to the column: CLOSE_DATE
     *
     * @param closeDate the CLOSE_DATE value
     */
    public void setCloseDate(java.sql.Date closeDate) {
        this.closeDate = closeDate;
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
     * Return the value associated with the column: PERSON_ID
     */
    public com.justonetech.system.domain.SysPerson getPerson() {
        return person;
    }

    /**
     * Set the value related to the column: PERSON_ID
     *
     * @param person the PERSON_ID value
     */
    public void setPerson(com.justonetech.system.domain.SysPerson person) {
        this.person = person;
    }

    public Set<SysUserRole> getSysUserRoles() {
        if (sysUserRoles == null) {
            sysUserRoles = new java.util.LinkedHashSet<com.justonetech.system.domain.SysUserRole>();
        }
        return sysUserRoles;
    }

    public void setSysUserRoles(Set<SysUserRole> sysUserRoles) {
        this.sysUserRoles = sysUserRoles;
    }

    public Set<SysUserPrivilege> getSysUserPrivileges() {
        if (sysUserPrivileges == null) {
            sysUserPrivileges = new java.util.LinkedHashSet<com.justonetech.system.domain.SysUserPrivilege>();
        }
        return sysUserPrivileges;
    }

    public void setSysUserPrivileges(Set<SysUserPrivilege> sysUserPrivileges) {
        this.sysUserPrivileges = sysUserPrivileges;
    }

    public Set<OaMailGroupUser> getOaMailGroupUsers() {
        if (oaMailGroupUsers == null) {
            oaMailGroupUsers = new java.util.LinkedHashSet<com.justonetech.biz.domain.OaMailGroupUser>();
        }
        return oaMailGroupUsers;
    }

    public void setOaMailGroupUsers(Set<OaMailGroupUser> oaMailGroupUsers) {
        this.oaMailGroupUsers = oaMailGroupUsers;
    }
    public SysRegPerson getRegPerson() {
        return regPerson;
    }

    public void setRegPerson(SysRegPerson regPerson) {
        this.regPerson = regPerson;
    }

    public SysCodeDetail getUserType() {
        return userType;
    }

    public void setUserType(SysCodeDetail userType) {
        this.userType = userType;
    }

    public SysSkin getSkin() {
        return skin;
    }

    public void setSkin(SysSkin skin) {
        this.skin = skin;
    }

    public boolean equals(Object obj) {
        if (null == obj) return false;
        if (!(obj instanceof com.justonetech.system.domain.SysUser)) return false;
        else {
            com.justonetech.system.domain.SysUser sysUser = (com.justonetech.system.domain.SysUser) obj;
            if (null == this.getId() || null == sysUser.getId()) return false;
            else return (this.getId().equals(sysUser.getId()));
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
        builder.append(loginName);
        builder.append(password);
        builder.append(md5Pass);
        builder.append(displayName);
        builder.append(status);
        builder.append(reasonDesc);
        builder.append(openDate);
        builder.append(closeDate);
        builder.append(createTime);
        builder.append(updateTime);
        builder.append(updateUser);
        builder.append(createUser);
        return builder.toString();
    }


}