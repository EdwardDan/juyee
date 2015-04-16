package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * This is an object that contains data related to the OA_KNOWLEDGE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 业务知识交流
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 业务知识交流
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_KNOWLEDGE"
 */

public abstract class BaseOaKnowledge  implements Serializable,Auditable {

    public static String REF = "OaKnowledge";
    public static String PROP_REPORT_DEPT = "reportDept";
    public static String PROP_DOCUMENT = "document";
    public static String PROP_TYPE = "type";
    public static String PROP_UPDATE_TIME = "updateTime";
    public static String PROP_TYPE_NAME = "typeName";
    public static String PROP_TITLE = "title";
    public static String PROP_VISIT_TIMES = "visitTimes";
    public static String PROP_CREATE_USER = "createUser";
    public static String PROP_REPORT_DATE = "reportDate";
    public static String PROP_REPORT_PERSON = "reportPerson";
    public static String PROP_IS_VALID = "isValid";
    public static String PROP_CREATE_TIME = "createTime";
    public static String PROP_ID = "id";
    public static String PROP_REFER = "refer";
    public static String PROP_CONTENT = "content";
    public static String PROP_UPDATE_USER = "updateUser";


    // constructors
    public BaseOaKnowledge () {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseOaKnowledge (java.lang.Long id) {
        this.setId(id);
        initialize();
    }

    protected void initialize () {}



    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Long id;

    // fields
    /*类型中文描述*/
    /*类型中文描述*/
    private java.lang.String typeName;

    /*主题名称*/
    /*主题名称*/
    private java.lang.String title;

    /*提出人*/
    /*提出人*/
    private java.lang.String reportPerson;

    /*提出部门*/
    /*提出部门*/
    private java.lang.String reportDept;

    /*主要内容*/
    /*主要内容*/
    private java.lang.String content;

    /*发布时间*/
    /*发布时间*/
    private Timestamp reportDate;

    /*访问次数*/
    /*访问次数*/
    private java.lang.Long visitTimes;

    /*是否有效*/
    /*是否有效*/
    private java.lang.Boolean isValid;

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
    private com.justonetech.biz.domain.OaKnowledge refer;
    private com.justonetech.biz.domain.DocDocument document;
    private com.justonetech.system.domain.SysCodeDetail type;

    // collections
    private java.util.Set<com.justonetech.biz.domain.OaKnowledge> oaKnowledges;



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
     * Return the value associated with the column: TYPE_NAME
     */
    public java.lang.String getTypeName () {
        return typeName;
    }

    /**
     * Set the value related to the column: TYPE_NAME
     * @param typeName the TYPE_NAME value
     */
    public void setTypeName (java.lang.String typeName) {
        this.typeName = typeName;
    }


    /**
     * Return the value associated with the column: TITLE
     */
    public java.lang.String getTitle () {
        return title;
    }

    /**
     * Set the value related to the column: TITLE
     * @param title the TITLE value
     */
    public void setTitle (java.lang.String title) {
        this.title = title;
    }


    /**
     * Return the value associated with the column: REPORT_PERSON
     */
    public java.lang.String getReportPerson () {
        return reportPerson;
    }

    /**
     * Set the value related to the column: REPORT_PERSON
     * @param reportPerson the REPORT_PERSON value
     */
    public void setReportPerson (java.lang.String reportPerson) {
        this.reportPerson = reportPerson;
    }


    /**
     * Return the value associated with the column: REPORT_DEPT
     */
    public java.lang.String getReportDept () {
        return reportDept;
    }

    /**
     * Set the value related to the column: REPORT_DEPT
     * @param reportDept the REPORT_DEPT value
     */
    public void setReportDept (java.lang.String reportDept) {
        this.reportDept = reportDept;
    }


    /**
     * Return the value associated with the column: CONTENT
     */
    public java.lang.String getContent () {
        return content;
    }

    /**
     * Set the value related to the column: CONTENT
     * @param content the CONTENT value
     */
    public void setContent (java.lang.String content) {
        this.content = content;
    }


    /**
     * Return the value associated with the column: REPORT_DATE
     */
    public Timestamp getReportDate () {
        return reportDate;
    }

    /**
     * Set the value related to the column: REPORT_DATE
     * @param reportDate the REPORT_DATE value
     */
    public void setReportDate (Timestamp reportDate) {
        this.reportDate = reportDate;
    }


    /**
     * Return the value associated with the column: VISIT_TIMES
     */
    public java.lang.Long getVisitTimes () {
        return visitTimes;
    }

    /**
     * Set the value related to the column: VISIT_TIMES
     * @param visitTimes the VISIT_TIMES value
     */
    public void setVisitTimes (java.lang.Long visitTimes) {
        this.visitTimes = visitTimes;
    }


    /**
     * Return the value associated with the column: IS_VALID
     */
    public java.lang.Boolean getIsValid () {
        return isValid;
    }

    /**
     * Set the value related to the column: IS_VALID
     * @param isValid the IS_VALID value
     */
    public void setIsValid (java.lang.Boolean isValid) {
        this.isValid = isValid;
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
     * Return the value associated with the column: REFER_ID
     */
    public com.justonetech.biz.domain.OaKnowledge getRefer () {
        return refer;
    }

    /**
     * Set the value related to the column: REFER_ID
     * @param refer the REFER_ID value
     */
    public void setRefer (com.justonetech.biz.domain.OaKnowledge refer) {
        this.refer = refer;
    }


    /**
     * Return the value associated with the column: DOCUMENT_ID
     */
    public com.justonetech.biz.domain.DocDocument getDocument () {
        return document;
    }

    /**
     * Set the value related to the column: DOCUMENT_ID
     * @param document the DOCUMENT_ID value
     */
    public void setDocument (com.justonetech.biz.domain.DocDocument document) {
        this.document = document;
    }


    /**
     * Return the value associated with the column: TYPE_ID
     */
    public com.justonetech.system.domain.SysCodeDetail getType () {
        return type;
    }

    /**
     * Set the value related to the column: TYPE_ID
     * @param type the TYPE_ID value
     */
    public void setType (com.justonetech.system.domain.SysCodeDetail type) {
        this.type = type;
    }


    /**
     * Return the value associated with the column: oaKnowledges
     */
    public java.util.Set<com.justonetech.biz.domain.OaKnowledge> getOaKnowledges () {
        if(oaKnowledges == null){
            oaKnowledges = new java.util.LinkedHashSet<com.justonetech.biz.domain.OaKnowledge>();
        }
        return oaKnowledges;
    }

    /**
     * Set the value related to the column: oaKnowledges
     * @param oaKnowledges the oaKnowledges value
     */
    public void setOaKnowledges (java.util.Set<com.justonetech.biz.domain.OaKnowledge> oaKnowledges) {
        this.oaKnowledges = oaKnowledges;
    }

    public void addTooaKnowledges (com.justonetech.biz.domain.OaKnowledge oaKnowledge) {
        if (null == getOaKnowledges()) setOaKnowledges(new java.util.LinkedHashSet<com.justonetech.biz.domain.OaKnowledge>());
        getOaKnowledges().add(oaKnowledge);
    }



    public boolean equals (Object obj) {
        if (null == obj) return false;
        if (!(obj instanceof com.justonetech.biz.domain.OaKnowledge)) return false;
        else {
            com.justonetech.biz.domain.OaKnowledge oaKnowledge = (com.justonetech.biz.domain.OaKnowledge) obj;
            if (null == this.getId() || null == oaKnowledge.getId()) return false;
            else return (this.getId().equals(oaKnowledge.getId()));
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
        builder.append(typeName);
        builder.append(title);
        builder.append(reportPerson);
        builder.append(reportDept);
        builder.append(content);
        builder.append(reportDate);
        builder.append(visitTimes);
        builder.append(isValid);
        builder.append(createTime);
        builder.append(createUser);
        builder.append(updateTime);
        builder.append(updateUser);
        return builder.toString();
    }


}