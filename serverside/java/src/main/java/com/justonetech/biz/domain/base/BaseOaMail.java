package com.justonetech.biz.domain.base;

import com.justonetech.biz.domain.DocDocument;
import com.justonetech.biz.domain.OaMail;
import com.justonetech.biz.domain.OaMailUser;
import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_MAIL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 邮件信息
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 邮件信息
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class table="OA_MAIL"
 */

public abstract class BaseOaMail implements Serializable, Auditable {

    public static String REF = "OaMail";
    public static String PROP_SEND_PERSON = "sendPerson";
    public static String PROP_DOCUMENT = "document";
    public static String PROP_IS_NEED_REPLY = "isNeedReply";
    public static String PROP_IS_DELETE = "isDelete";
    public static String PROP_SEND_TIME = "sendTime";
    public static String PROP_UPDATE_TIME = "updateTime";
    public static String PROP_TITLE = "title";
    public static String PROP_CC_PERSONS = "ccPersons";
    public static String PROP_CREATE_USER = "createUser";
    public static String PROP_DELETE_TIME = "deleteTime";
    public static String PROP_SIGN = "sign";
    public static String PROP_CREATE_TIME = "createTime";
    public static String PROP_MAIL_FORMAT = "mailFormat";
    public static String PROP_ID = "id";
    public static String PROP_SEND_USER = "sendUser";
    public static String PROP_RECEIVE_PERSONS = "receivePersons";
    public static String PROP_CONTENT = "content";
    public static String PROP_UPDATE_USER = "updateUser";
    public static String PROP_IS_SEND = "isSend";


    // constructors
    public BaseOaMail() {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseOaMail(java.lang.Long id) {
        this.setId(id);
        initialize();
    }

    protected void initialize() {
    }


    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Long id;

    // fields
    /*主题*/
    /*主题*/
    private java.lang.String title;

    /*内容*/
    /*内容*/
    private java.lang.String content;

    /*发件用户名*/
    /*发件用户名*/
    private java.lang.String sendUser;

    /*发件人（冗余）*/
    /*发件人（冗余）*/
    private java.lang.String sendPerson;

    /*收件人（冗余）*/
    /*收件人（冗余）*/
    private java.lang.String receivePersons;

    /*抄送人（冗余）*/
    /*抄送人（冗余）*/
    private java.lang.String ccPersons;

    /*邮件格式(TEXT/HTML)*/
    /*邮件格式(TEXT/HTML)*/
    private java.lang.String mailFormat;

    /*是否要求回复*/
    /*是否要求回复*/
    private java.lang.Boolean isNeedReply;

    /*发送时间*/
    /*发送时间*/
    private java.sql.Timestamp sendTime;

    /*个性签名*/
    /*个性签名*/
    private java.lang.String sign;

    /*是否已删除(针对发件人)*/
    /*是否已删除(针对发件人)*/
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

    /*是否发送*/
    /*是否发送*/
    private java.lang.Boolean isSend;

    // many to one
    private DocDocument document;

    // collections
    private java.util.Set<OaMailUser> oaMailUsers;


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
     * Return the value associated with the column: TITLE
     */
    public java.lang.String getTitle() {
        return title;
    }

    /**
     * Set the value related to the column: TITLE
     *
     * @param title the TITLE value
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Return the value associated with the column: CONTENT
     */
    public java.lang.String getContent() {
        return content;
    }

    /**
     * Set the value related to the column: CONTENT
     *
     * @param content the CONTENT value
     */
    public void setContent(java.lang.String content) {
        this.content = content;
    }


    /**
     * Return the value associated with the column: SEND_USER
     */
    public java.lang.String getSendUser() {
        return sendUser;
    }

    /**
     * Set the value related to the column: SEND_USER
     *
     * @param sendUser the SEND_USER value
     */
    public void setSendUser(java.lang.String sendUser) {
        this.sendUser = sendUser;
    }


    /**
     * Return the value associated with the column: SEND_PERSON
     */
    public java.lang.String getSendPerson() {
        return sendPerson;
    }

    /**
     * Set the value related to the column: SEND_PERSON
     *
     * @param sendPerson the SEND_PERSON value
     */
    public void setSendPerson(java.lang.String sendPerson) {
        this.sendPerson = sendPerson;
    }


    /**
     * Return the value associated with the column: RECEIVE_PERSONS
     */
    public java.lang.String getReceivePersons() {
        return receivePersons;
    }

    /**
     * Set the value related to the column: RECEIVE_PERSONS
     *
     * @param receivePersons the RECEIVE_PERSONS value
     */
    public void setReceivePersons(java.lang.String receivePersons) {
        this.receivePersons = receivePersons;
    }


    /**
     * Return the value associated with the column: CC_PERSONS
     */
    public java.lang.String getCcPersons() {
        return ccPersons;
    }

    /**
     * Set the value related to the column: CC_PERSONS
     *
     * @param ccPersons the CC_PERSONS value
     */
    public void setCcPersons(java.lang.String ccPersons) {
        this.ccPersons = ccPersons;
    }


    /**
     * Return the value associated with the column: MAIL_FORMAT
     */
    public java.lang.String getMailFormat() {
        return mailFormat;
    }

    /**
     * Set the value related to the column: MAIL_FORMAT
     *
     * @param mailFormat the MAIL_FORMAT value
     */
    public void setMailFormat(java.lang.String mailFormat) {
        this.mailFormat = mailFormat;
    }


    /**
     * Return the value associated with the column: IS_NEED_REPLY
     */
    public java.lang.Boolean getIsNeedReply() {
        return isNeedReply;
    }

    /**
     * Set the value related to the column: IS_NEED_REPLY
     *
     * @param isNeedReply the IS_NEED_REPLY value
     */
    public void setIsNeedReply(java.lang.Boolean isNeedReply) {
        this.isNeedReply = isNeedReply;
    }


    /**
     * Return the value associated with the column: SEND_TIME
     */
    public java.sql.Timestamp getSendTime() {
        return sendTime;
    }

    /**
     * Set the value related to the column: SEND_TIME
     *
     * @param sendTime the SEND_TIME value
     */
    public void setSendTime(java.sql.Timestamp sendTime) {
        this.sendTime = sendTime;
    }


    /**
     * Return the value associated with the column: SIGN
     */
    public java.lang.String getSign() {
        return sign;
    }

    /**
     * Set the value related to the column: SIGN
     *
     * @param sign the SIGN value
     */
    public void setSign(java.lang.String sign) {
        this.sign = sign;
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
     * Return the value associated with the column: IS_SEND
     */
    public java.lang.Boolean getIsSend() {
        return isSend;
    }

    /**
     * Set the value related to the column: IS_SEND
     *
     * @param isSend the IS_SEND value
     */
    public void setIsSend(java.lang.Boolean isSend) {
        this.isSend = isSend;
    }

    /**
     * Return the value associated with the column: DOCUMENT_ID
     */
    public DocDocument getDocument() {
        return document;
    }

    /**
     * Set the value related to the column: DOCUMENT_ID
     *
     * @param document the DOCUMENT_ID value
     */
    public void setDocument(DocDocument document) {
        this.document = document;
    }


    /**
     * Return the value associated with the column: oaMailUsers
     */
    public java.util.Set<OaMailUser> getOaMailUsers() {
        if (oaMailUsers == null) {
            oaMailUsers = new java.util.LinkedHashSet<OaMailUser>();
        }
        return oaMailUsers;
    }

    /**
     * Set the value related to the column: oaMailUsers
     *
     * @param oaMailUsers the oaMailUsers value
     */
    public void setOaMailUsers(java.util.Set<OaMailUser> oaMailUsers) {
        this.oaMailUsers = oaMailUsers;
    }

    public void addTooaMailUsers(OaMailUser oaMailUser) {
        if (null == getOaMailUsers()) setOaMailUsers(new java.util.LinkedHashSet<OaMailUser>());
        getOaMailUsers().add(oaMailUser);
    }


    public boolean equals(Object obj) {
        if (null == obj) return false;
        if (!(obj instanceof OaMail)) return false;
        else {
            OaMail oaMail = (OaMail) obj;
            if (null == this.getId() || null == oaMail.getId()) return false;
            else return (this.getId().equals(oaMail.getId()));
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
        builder.append(title);
        builder.append(content);
        builder.append(sendUser);
        builder.append(sendPerson);
        builder.append(receivePersons);
        builder.append(ccPersons);
        builder.append(mailFormat);
        builder.append(isNeedReply);
        builder.append(sendTime);
        builder.append(sign);
        builder.append(isDelete);
        builder.append(deleteTime);
        builder.append(createTime);
        builder.append(createUser);
        builder.append(updateTime);
        builder.append(updateUser);
        builder.append(isSend);
        return builder.toString();
    }


}