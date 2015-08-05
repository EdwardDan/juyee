package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_WORK_WATCH table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 工作督办
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 工作督办
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class table="OA_WORK_WATCH"
 */

public abstract class BaseOaWorkWatch implements Serializable, Auditable {

    public static String REF = "OaWorkWatch";
    public static String PROP_REPORT_DEPT = "reportDept";
    public static String PROP_BEGIN_DATE = "beginDate";
    public static String PROP_DOCUMENT_ID = "documentId";
    public static String PROP_BGS_AUDIT_USER = "bgsAuditUser";
    public static String PROP_UPDATE_TIME = "updateTime";
    public static String PROP_KZ_AUDIT_USER = "kzAuditUser";
    public static String PROP_REPORT_USER = "reportUser";
    public static String PROP_KZ_AUDIT_TIME = "kzAuditTime";
    public static String PROP_ZR_AUDIT_USER = "zrAuditUser";
    public static String PROP_STATUS = "status";
    public static String PROP_CREATE_USER = "createUser";
    public static String PROP_ZR_OPINION = "zrOpinion";
    public static String PROP_BGS_AUDIT_TIME = "bgsAuditTime";
    public static String PROP_END_DATE = "endDate";
    public static String PROP_REPORT_PERSON = "reportPerson";
    public static String PROP_CREATE_TIME = "createTime";
    public static String PROP_KZ_OPINION = "kzOpinion";
    public static String PROP_ID = "id";
    public static String PROP_BGS_OPINION = "bgsOpinion";
    public static String PROP_ZR_AUDIT_TIME = "zrAuditTime";
    public static String PROP_UPDATE_USER = "updateUser";


    // constructors
    public BaseOaWorkWatch() {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseOaWorkWatch(Long id) {
        this.setId(id);
        initialize();
    }

    protected void initialize() {
    }


    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private Long id;

    // fields
    /*上报科室*/
    /*上报科室*/
    private String reportDept;

    /*上报人用户名*/
    /*上报人用户名*/
    private String reportUser;

    /*科室分管领导*/
    /*科室分管领导*/
    private String reportPerson;

    /*上报开始时间*/
    /*上报开始时间*/
    private Integer beginDate;

    /*上报结束时间*/
    /*上报结束时间*/
    private Integer endDate;

    /*附件ID(预留)*/
    /*附件ID(预留)*/
    private Long documentId;

    /*状态*/
    /*状态*/
    private Integer status;

    /*主任审核意见*/
    /*主任审核意见*/
    private String zrOpinion;

    /*主任审核时间*/
    /*主任审核时间*/
    private java.sql.Timestamp zrAuditTime;

    /*主任审核用户名*/
    /*主任审核用户名*/
    private String zrAuditUser;

    /*科长审核意见*/
    /*科长审核意见*/
    private String kzOpinion;

    /*科长审核时间*/
    /*科长审核时间*/
    private java.sql.Timestamp kzAuditTime;

    /*科长审核用户名*/
    /*科长审核用户名*/
    private String kzAuditUser;

    /*办公室审核意见*/
    /*办公室审核意见*/
    private String bgsOpinion;

    /*办公室审核时间*/
    /*办公室审核时间*/
    private java.sql.Timestamp bgsAuditTime;

    /*办公室审核用户名*/
    /*办公室审核用户名*/
    private String bgsAuditUser;

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


    // collections
    private java.util.Set<com.justonetech.biz.domain.OaWorkWatchItem> oaWorkWatchItems;


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
     * Return the value associated with the column: REPORT_DEPT
     */
    public String getReportDept() {
        return reportDept;
    }

    /**
     * Set the value related to the column: REPORT_DEPT
     *
     * @param reportDept the REPORT_DEPT value
     */
    public void setReportDept(String reportDept) {
        this.reportDept = reportDept;
    }


    /**
     * Return the value associated with the column: REPORT_USER
     */
    public String getReportUser() {
        return reportUser;
    }

    /**
     * Set the value related to the column: REPORT_USER
     *
     * @param reportUser the REPORT_USER value
     */
    public void setReportUser(String reportUser) {
        this.reportUser = reportUser;
    }


    /**
     * Return the value associated with the column: REPORT_PERSON
     */
    public String getReportPerson() {
        return reportPerson;
    }

    /**
     * Set the value related to the column: REPORT_PERSON
     *
     * @param reportPerson the REPORT_PERSON value
     */
    public void setReportPerson(String reportPerson) {
        this.reportPerson = reportPerson;
    }


    /**
     * Return the value associated with the column: BEGIN_DATE
     */
    public Integer getBeginDate() {
        return beginDate;
    }

    /**
     * Set the value related to the column: BEGIN_DATE
     *
     * @param beginDate the BEGIN_DATE value
     */
    public void setBeginDate(Integer beginDate) {
        this.beginDate = beginDate;
    }


    /**
     * Return the value associated with the column: END_DATE
     */
    public Integer getEndDate() {
        return endDate;
    }

    /**
     * Set the value related to the column: END_DATE
     *
     * @param endDate the END_DATE value
     */
    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }


    /**
     * Return the value associated with the column: DOCUMENT_ID
     */
    public Long getDocumentId() {
        return documentId;
    }

    /**
     * Set the value related to the column: DOCUMENT_ID
     *
     * @param documentId the DOCUMENT_ID value
     */
    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }


    /**
     * Return the value associated with the column: STATUS
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Set the value related to the column: STATUS
     *
     * @param status the STATUS value
     */
    public void setStatus(Integer status) {
        this.status = status;
    }


    /**
     * Return the value associated with the column: ZR_OPINION
     */
    public String getZrOpinion() {
        return zrOpinion;
    }

    /**
     * Set the value related to the column: ZR_OPINION
     *
     * @param zrOpinion the ZR_OPINION value
     */
    public void setZrOpinion(String zrOpinion) {
        this.zrOpinion = zrOpinion;
    }


    /**
     * Return the value associated with the column: ZR_AUDIT_TIME
     */
    public java.sql.Timestamp getZrAuditTime() {
        return zrAuditTime;
    }

    /**
     * Set the value related to the column: ZR_AUDIT_TIME
     *
     * @param zrAuditTime the ZR_AUDIT_TIME value
     */
    public void setZrAuditTime(java.sql.Timestamp zrAuditTime) {
        this.zrAuditTime = zrAuditTime;
    }


    /**
     * Return the value associated with the column: ZR_AUDIT_USER
     */
    public String getZrAuditUser() {
        return zrAuditUser;
    }

    /**
     * Set the value related to the column: ZR_AUDIT_USER
     *
     * @param zrAuditUser the ZR_AUDIT_USER value
     */
    public void setZrAuditUser(String zrAuditUser) {
        this.zrAuditUser = zrAuditUser;
    }


    /**
     * Return the value associated with the column: KZ_OPINION
     */
    public String getKzOpinion() {
        return kzOpinion;
    }

    /**
     * Set the value related to the column: KZ_OPINION
     *
     * @param kzOpinion the KZ_OPINION value
     */
    public void setKzOpinion(String kzOpinion) {
        this.kzOpinion = kzOpinion;
    }


    /**
     * Return the value associated with the column: KZ_AUDIT_TIME
     */
    public java.sql.Timestamp getKzAuditTime() {
        return kzAuditTime;
    }

    /**
     * Set the value related to the column: KZ_AUDIT_TIME
     *
     * @param kzAuditTime the KZ_AUDIT_TIME value
     */
    public void setKzAuditTime(java.sql.Timestamp kzAuditTime) {
        this.kzAuditTime = kzAuditTime;
    }


    /**
     * Return the value associated with the column: KZ_AUDIT_USER
     */
    public String getKzAuditUser() {
        return kzAuditUser;
    }

    /**
     * Set the value related to the column: KZ_AUDIT_USER
     *
     * @param kzAuditUser the KZ_AUDIT_USER value
     */
    public void setKzAuditUser(String kzAuditUser) {
        this.kzAuditUser = kzAuditUser;
    }


    /**
     * Return the value associated with the column: BGS_OPINION
     */
    public String getBgsOpinion() {
        return bgsOpinion;
    }

    /**
     * Set the value related to the column: BGS_OPINION
     *
     * @param bgsOpinion the BGS_OPINION value
     */
    public void setBgsOpinion(String bgsOpinion) {
        this.bgsOpinion = bgsOpinion;
    }


    /**
     * Return the value associated with the column: BGS_AUDIT_TIME
     */
    public java.sql.Timestamp getBgsAuditTime() {
        return bgsAuditTime;
    }

    /**
     * Set the value related to the column: BGS_AUDIT_TIME
     *
     * @param bgsAuditTime the BGS_AUDIT_TIME value
     */
    public void setBgsAuditTime(java.sql.Timestamp bgsAuditTime) {
        this.bgsAuditTime = bgsAuditTime;
    }


    /**
     * Return the value associated with the column: BGS_AUDIT_USER
     */
    public String getBgsAuditUser() {
        return bgsAuditUser;
    }

    /**
     * Set the value related to the column: BGS_AUDIT_USER
     *
     * @param bgsAuditUser the BGS_AUDIT_USER value
     */
    public void setBgsAuditUser(String bgsAuditUser) {
        this.bgsAuditUser = bgsAuditUser;
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
     * Return the value associated with the column: oaWorkWatchItems
     */
    public java.util.Set<com.justonetech.biz.domain.OaWorkWatchItem> getOaWorkWatchItems() {
        if (oaWorkWatchItems == null) {
            oaWorkWatchItems = new java.util.LinkedHashSet<com.justonetech.biz.domain.OaWorkWatchItem>();
        }
        return oaWorkWatchItems;
    }

    /**
     * Set the value related to the column: oaWorkWatchItems
     *
     * @param oaWorkWatchItems the oaWorkWatchItems value
     */
    public void setOaWorkWatchItems(java.util.Set<com.justonetech.biz.domain.OaWorkWatchItem> oaWorkWatchItems) {
        this.oaWorkWatchItems = oaWorkWatchItems;
    }

    public void addTooaWorkWatchItems(com.justonetech.biz.domain.OaWorkWatchItem oaWorkWatchItem) {
        if (null == getOaWorkWatchItems())
            setOaWorkWatchItems(new java.util.LinkedHashSet<com.justonetech.biz.domain.OaWorkWatchItem>());
        getOaWorkWatchItems().add(oaWorkWatchItem);
    }


    public boolean equals(Object obj) {
        if (null == obj) return false;
        if (!(obj instanceof com.justonetech.biz.domain.OaWorkWatch)) return false;
        else {
            com.justonetech.biz.domain.OaWorkWatch oaWorkWatch = (com.justonetech.biz.domain.OaWorkWatch) obj;
            if (null == this.getId() || null == oaWorkWatch.getId()) return false;
            else return (this.getId().equals(oaWorkWatch.getId()));
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
        builder.append(reportDept);
        builder.append(reportUser);
        builder.append(reportPerson);
        builder.append(beginDate);
        builder.append(endDate);
        builder.append(documentId);
        builder.append(status);
        builder.append(zrOpinion);
        builder.append(zrAuditTime);
        builder.append(zrAuditUser);
        builder.append(kzOpinion);
        builder.append(kzAuditTime);
        builder.append(kzAuditUser);
        builder.append(bgsOpinion);
        builder.append(bgsAuditTime);
        builder.append(bgsAuditUser);
        builder.append(createTime);
        builder.append(createUser);
        builder.append(updateTime);
        builder.append(updateUser);
        return builder.toString();
    }


}