package com.justonetech.biz.domain.base;

import com.justonetech.biz.domain.OaMail;
import com.justonetech.biz.domain.OaMailUser;
import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_MAIL_USER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 邮件接收人员
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 邮件接收人员
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class table="OA_MAIL_USER"
 */

public abstract class BaseOaMailUser implements Serializable, Auditable {

    public static String REF = "OaMailUser";
    public static String PROP_CREATE_USER = "createUser";
    public static String PROP_DELETE_TIME = "deleteTime";
    public static String PROP_TYPE_CODE = "typeCode";
    public static String PROP_CREATE_TIME = "createTime";
    public static String PROP_IS_DELETE = "isDelete";
    public static String PROP_UPDATE_TIME = "updateTime";
    public static String PROP_IS_READ = "isRead";
    public static String PROP_ID = "id";
    public static String PROP_USER_NAME = "userName";
    public static String PROP_MAIL = "mail";
    public static String PROP_READ_TIME = "readTime";
    public static String PROP_UPDATE_USER = "updateUser";


    // constructors
    public BaseOaMailUser() {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseOaMailUser(java.lang.Long id) {
        this.setId(id);
        initialize();
    }

    protected void initialize() {
    }


    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Long id;

    // fields
    /*类型（TO接收/CC抄送）*/
    /*类型（TO接收/CC抄送）*/
    private java.lang.String typeCode;

    /*接收用户名*/
    /*接收用户名*/
    private java.lang.String userName;

    /*是否已阅*/
    /*是否已阅*/
    private java.lang.Boolean isRead;

    /*阅读时间*/
    /*阅读时间*/
    private java.sql.Timestamp readTime;

    /*是否已删除(针对收件人)*/
    /*是否已删除(针对收件人)*/
    private java.lang.Boolean isDelete;

    /*删除时间*/
    /*删除时间*/
    private java.sql.Timestamp deleteTime;

    /*创建时间*/
    /*创建时间*/
    private java.sql.Timestamp createTime;

    /*创建用户名*/
    /*创建用户名*/
    private java.lang.String createUser;

    /*更新时间*/
    /*更新时间*/
    private java.sql.Timestamp updateTime;

    /*更新用户名*/
    /*更新用户名*/
    private java.lang.String updateUser;


    // many to one
    private OaMail mail;


    /**
     * Return the unique identifier of this class
     *
     * @hibernate.id generator-class="com.justonetech.core.orm.hibernate.LongIdGenerator"
     * column="ID"
     */
    public java.lang.Long getId() {
        return id;
    }

    /**
     * Set the unique identifier of this class
     *
     * @param id the new ID
     * @deprecated
     */
    public void setId(java.lang.Long id) {
        this.id = id;
        this.hashCode = Integer.MIN_VALUE;
    }


    /**
     * Return the value associated with the column: TYPE_CODE
     */
    public java.lang.String getTypeCode() {
        return typeCode;
    }

    /**
     * Set the value related to the column: TYPE_CODE
     *
     * @param typeCode the TYPE_CODE value
     */
    public void setTypeCode(java.lang.String typeCode) {
        this.typeCode = typeCode;
    }


    /**
     * Return the value associated with the column: USER_NAME
     */
    public java.lang.String getUserName() {
        return userName;
    }

    /**
     * Set the value related to the column: USER_NAME
     *
     * @param userName the USER_NAME value
     */
    public void setUserName(java.lang.String userName) {
        this.userName = userName;
    }


    /**
     * Return the value associated with the column: IS_READ
     */
    public java.lang.Boolean getIsRead() {
        return isRead;
    }

    /**
     * Set the value related to the column: IS_READ
     *
     * @param isRead the IS_READ value
     */
    public void setIsRead(java.lang.Boolean isRead) {
        this.isRead = isRead;
    }


    /**
     * Return the value associated with the column: READ_TIME
     */
    public java.sql.Timestamp getReadTime() {
        return readTime;
    }

    /**
     * Set the value related to the column: READ_TIME
     *
     * @param readTime the READ_TIME value
     */
    public void setReadTime(java.sql.Timestamp readTime) {
        this.readTime = readTime;
    }


    /**
     * Return the value associated with the column: IS_DELETE
     */
    public java.lang.Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * Set the value related to the column: IS_DELETE
     *
     * @param isDelete the IS_DELETE value
     */
    public void setIsDelete(java.lang.Boolean isDelete) {
        this.isDelete = isDelete;
    }


    /**
     * Return the value associated with the column: DELETE_TIME
     */
    public java.sql.Timestamp getDeleteTime() {
        return deleteTime;
    }

    /**
     * Set the value related to the column: DELETE_TIME
     *
     * @param deleteTime the DELETE_TIME value
     */
    public void setDeleteTime(java.sql.Timestamp deleteTime) {
        this.deleteTime = deleteTime;
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
    public java.lang.String getCreateUser() {
        return createUser;
    }

    /**
     * Set the value related to the column: CREATE_USER
     *
     * @param createUser the CREATE_USER value
     */
    public void setCreateUser(java.lang.String createUser) {
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
    public java.lang.String getUpdateUser() {
        return updateUser;
    }

    /**
     * Set the value related to the column: UPDATE_USER
     *
     * @param updateUser the UPDATE_USER value
     */
    public void setUpdateUser(java.lang.String updateUser) {
        this.updateUser = updateUser;
    }


    /**
     * Return the value associated with the column: MAIL_ID
     */
    public OaMail getMail() {
        return mail;
    }

    /**
     * Set the value related to the column: MAIL_ID
     *
     * @param mail the MAIL_ID value
     */
    public void setMail(OaMail mail) {
        this.mail = mail;
    }


    public boolean equals(Object obj) {
        if (null == obj) return false;
        if (!(obj instanceof OaMailUser)) return false;
        else {
            OaMailUser oaMailUser = (OaMailUser) obj;
            if (null == this.getId() || null == oaMailUser.getId()) return false;
            else return (this.getId().equals(oaMailUser.getId()));
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
        builder.append(typeCode);
        builder.append(userName);
        builder.append(isRead);
        builder.append(readTime);
        builder.append(isDelete);
        builder.append(deleteTime);
        builder.append(createTime);
        builder.append(createUser);
        builder.append(updateTime);
        builder.append(updateUser);
        return builder.toString();
    }


}