package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PROJ_BID table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目标段管理
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 项目标段管理
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : project
 * Projectable : false
 *
 * @hibernate.class
 *  table="PROJ_BID"
 */

public abstract class BaseProjBid  implements Serializable,Auditable {

    public static String REF = "ProjBid";
    public static String PROP_JSDW_NAME = "jsdwName";
    public static String PROP_JSDW_TEL = "jsdwTel";
    public static String PROP_SJDW_PERSON = "sjdwPerson";
    public static String PROP_SGDW_NAME = "sgdwName";
    public static String PROP_CODE = "code";
    public static String PROP_JLDW_NAME = "jldwName";
    public static String PROP_CREATE_USER = "createUser";
    public static String PROP_SJDW_NAME = "sjdwName";
    public static String PROP_START_DATE = "startDate";
    public static String PROP_JLDW_PERSON = "jldwPerson";
    public static String PROP_TYPE_CODE = "typeCode";
    public static String PROP_KCDW_TEL = "kcdwTel";
    public static String PROP_PROJECT = "project";
    public static String PROP_UPDATE_USER = "updateUser";
    public static String PROP_KCDW_NAME = "kcdwName";
    public static String PROP_JSDW_PERSON = "jsdwPerson";
    public static String PROP_SGDW_PERSON = "sgdwPerson";
    public static String PROP_UPDATE_TIME = "updateTime";
    public static String PROP_SGDW_TEL = "sgdwTel";
    public static String PROP_NO = "no";
    public static String PROP_NAME = "name";
    public static String PROP_LINK_TEL = "linkTel";
    public static String PROP_JLDW_TEL = "jldwTel";
    public static String PROP_KCDW_PERSON = "kcdwPerson";
    public static String PROP_CREATE_TIME = "createTime";
    public static String PROP_BUILD_MILEAGE = "buildMileage";
    public static String PROP_ID = "id";
    public static String PROP_PROJ_LINK = "projLink";
    public static String PROP_SJDW_TEL = "sjdwTel";


    // constructors
    public BaseProjBid () {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseProjBid (java.lang.Long id) {
        this.setId(id);
        initialize();
    }

    protected void initialize () {}



    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Long id;

    // fields
    /*标段编号*/
    /*标段编号*/
    private java.lang.String code;

    /*标段序号*/
    /*标段序号*/
    private java.lang.Integer no;

    /*标段名称*/
    /*标段名称*/
    private java.lang.String name;

    /*标段类别编码(形象进度/办证推进)*/
    /*标段类别编码(形象进度/办证推进)*/
    private java.lang.String typeCode;

    /*建设里程*/
    /*建设里程*/
    private java.lang.String buildMileage;

    /*项目联系人*/
    /*项目联系人*/
    private java.lang.String projLink;

    /*联系电话*/
    /*联系电话*/
    private java.lang.String linkTel;

    /*开工日期*/
    /*开工日期*/
    private java.sql.Date startDate;

    /*建设单位名称*/
    /*建设单位名称*/
    private java.lang.String jsdwName;

    /*建设单位联系人*/
    /*建设单位联系人*/
    private java.lang.String jsdwPerson;

    /*建设单位联系电话*/
    /*建设单位联系电话*/
    private java.lang.String jsdwTel;

    /*勘察单位名称*/
    /*勘察单位名称*/
    private java.lang.String kcdwName;

    /*勘察单位联系人*/
    /*勘察单位联系人*/
    private java.lang.String kcdwPerson;

    /*勘察单位联系电话*/
    /*勘察单位联系电话*/
    private java.lang.String kcdwTel;

    /*设计单位名称*/
    /*设计单位名称*/
    private java.lang.String sjdwName;

    /*设计单位联系人*/
    /*设计单位联系人*/
    private java.lang.String sjdwPerson;

    /*设计单位联系电话*/
    /*设计单位联系电话*/
    private java.lang.String sjdwTel;

    /*施工单位名称*/
    /*施工单位名称*/
    private java.lang.String sgdwName;

    /*施工单位联系人*/
    /*施工单位联系人*/
    private java.lang.String sgdwPerson;

    /*施工单位联系电话*/
    /*施工单位联系电话*/
    private java.lang.String sgdwTel;

    /*监理单位名称*/
    /*监理单位名称*/
    private java.lang.String jldwName;

    /*监理单位联系人*/
    /*监理单位联系人*/
    private java.lang.String jldwPerson;

    /*监理单位联系电话*/
    /*监理单位联系电话*/
    private java.lang.String jldwTel;

    /*创建时间*/
    /*创建时间*/
    private java.sql.Timestamp createTime;

    /*更新时间*/
    /*更新时间*/
    private java.sql.Timestamp updateTime;

    /*创建人*/
    /*创建人(记录帐号）*/
    private java.lang.String createUser;

    /*更新人*/
    /*更新人(记录帐号）*/
    private java.lang.String updateUser;


    // many to one
    private com.justonetech.biz.domain.ProjInfo project;

    // collections
    private java.util.Set<com.justonetech.biz.domain.DataNodeReport> dataNodeReports;
    private java.util.Set<com.justonetech.biz.domain.DataStageReport> dataStageReports;
    private java.util.Set<com.justonetech.biz.domain.ProjBidArea> projBidAreas;



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
     * Return the value associated with the column: CODE
     */
    public java.lang.String getCode () {
        return code;
    }

    /**
     * Set the value related to the column: CODE
     * @param code the CODE value
     */
    public void setCode (java.lang.String code) {
        this.code = code;
    }


    /**
     * Return the value associated with the column: NO
     */
    public java.lang.Integer getNo () {
        return no;
    }

    /**
     * Set the value related to the column: NO
     * @param no the NO value
     */
    public void setNo (java.lang.Integer no) {
        this.no = no;
    }


    /**
     * Return the value associated with the column: NAME
     */
    public java.lang.String getName () {
        return name;
    }

    /**
     * Set the value related to the column: NAME
     * @param name the NAME value
     */
    public void setName (java.lang.String name) {
        this.name = name;
    }


    /**
     * Return the value associated with the column: TYPE_CODE
     */
    public java.lang.String getTypeCode () {
        return typeCode;
    }

    /**
     * Set the value related to the column: TYPE_CODE
     * @param typeCode the TYPE_CODE value
     */
    public void setTypeCode (java.lang.String typeCode) {
        this.typeCode = typeCode;
    }


    /**
     * Return the value associated with the column: BUILD_MILEAGE
     */
    public java.lang.String getBuildMileage () {
        return buildMileage;
    }

    /**
     * Set the value related to the column: BUILD_MILEAGE
     * @param buildMileage the BUILD_MILEAGE value
     */
    public void setBuildMileage (java.lang.String buildMileage) {
        this.buildMileage = buildMileage;
    }


    /**
     * Return the value associated with the column: PROJ_LINK
     */
    public java.lang.String getProjLink () {
        return projLink;
    }

    /**
     * Set the value related to the column: PROJ_LINK
     * @param projLink the PROJ_LINK value
     */
    public void setProjLink (java.lang.String projLink) {
        this.projLink = projLink;
    }


    /**
     * Return the value associated with the column: LINK_TEL
     */
    public java.lang.String getLinkTel () {
        return linkTel;
    }

    /**
     * Set the value related to the column: LINK_TEL
     * @param linkTel the LINK_TEL value
     */
    public void setLinkTel (java.lang.String linkTel) {
        this.linkTel = linkTel;
    }


    /**
     * Return the value associated with the column: START_DATE
     */
    public java.sql.Date getStartDate () {
        return startDate;
    }

    /**
     * Set the value related to the column: START_DATE
     * @param startDate the START_DATE value
     */
    public void setStartDate (java.sql.Date startDate) {
        this.startDate = startDate;
    }


    /**
     * Return the value associated with the column: JSDW_NAME
     */
    public java.lang.String getJsdwName () {
        return jsdwName;
    }

    /**
     * Set the value related to the column: JSDW_NAME
     * @param jsdwName the JSDW_NAME value
     */
    public void setJsdwName (java.lang.String jsdwName) {
        this.jsdwName = jsdwName;
    }


    /**
     * Return the value associated with the column: JSDW_PERSON
     */
    public java.lang.String getJsdwPerson () {
        return jsdwPerson;
    }

    /**
     * Set the value related to the column: JSDW_PERSON
     * @param jsdwPerson the JSDW_PERSON value
     */
    public void setJsdwPerson (java.lang.String jsdwPerson) {
        this.jsdwPerson = jsdwPerson;
    }


    /**
     * Return the value associated with the column: JSDW_TEL
     */
    public java.lang.String getJsdwTel () {
        return jsdwTel;
    }

    /**
     * Set the value related to the column: JSDW_TEL
     * @param jsdwTel the JSDW_TEL value
     */
    public void setJsdwTel (java.lang.String jsdwTel) {
        this.jsdwTel = jsdwTel;
    }


    /**
     * Return the value associated with the column: KCDW_NAME
     */
    public java.lang.String getKcdwName () {
        return kcdwName;
    }

    /**
     * Set the value related to the column: KCDW_NAME
     * @param kcdwName the KCDW_NAME value
     */
    public void setKcdwName (java.lang.String kcdwName) {
        this.kcdwName = kcdwName;
    }


    /**
     * Return the value associated with the column: KCDW_PERSON
     */
    public java.lang.String getKcdwPerson () {
        return kcdwPerson;
    }

    /**
     * Set the value related to the column: KCDW_PERSON
     * @param kcdwPerson the KCDW_PERSON value
     */
    public void setKcdwPerson (java.lang.String kcdwPerson) {
        this.kcdwPerson = kcdwPerson;
    }


    /**
     * Return the value associated with the column: KCDW_TEL
     */
    public java.lang.String getKcdwTel () {
        return kcdwTel;
    }

    /**
     * Set the value related to the column: KCDW_TEL
     * @param kcdwTel the KCDW_TEL value
     */
    public void setKcdwTel (java.lang.String kcdwTel) {
        this.kcdwTel = kcdwTel;
    }


    /**
     * Return the value associated with the column: SJDW_NAME
     */
    public java.lang.String getSjdwName () {
        return sjdwName;
    }

    /**
     * Set the value related to the column: SJDW_NAME
     * @param sjdwName the SJDW_NAME value
     */
    public void setSjdwName (java.lang.String sjdwName) {
        this.sjdwName = sjdwName;
    }


    /**
     * Return the value associated with the column: SJDW_PERSON
     */
    public java.lang.String getSjdwPerson () {
        return sjdwPerson;
    }

    /**
     * Set the value related to the column: SJDW_PERSON
     * @param sjdwPerson the SJDW_PERSON value
     */
    public void setSjdwPerson (java.lang.String sjdwPerson) {
        this.sjdwPerson = sjdwPerson;
    }


    /**
     * Return the value associated with the column: SJDW_TEL
     */
    public java.lang.String getSjdwTel () {
        return sjdwTel;
    }

    /**
     * Set the value related to the column: SJDW_TEL
     * @param sjdwTel the SJDW_TEL value
     */
    public void setSjdwTel (java.lang.String sjdwTel) {
        this.sjdwTel = sjdwTel;
    }


    /**
     * Return the value associated with the column: SGDW_NAME
     */
    public java.lang.String getSgdwName () {
        return sgdwName;
    }

    /**
     * Set the value related to the column: SGDW_NAME
     * @param sgdwName the SGDW_NAME value
     */
    public void setSgdwName (java.lang.String sgdwName) {
        this.sgdwName = sgdwName;
    }


    /**
     * Return the value associated with the column: SGDW_PERSON
     */
    public java.lang.String getSgdwPerson () {
        return sgdwPerson;
    }

    /**
     * Set the value related to the column: SGDW_PERSON
     * @param sgdwPerson the SGDW_PERSON value
     */
    public void setSgdwPerson (java.lang.String sgdwPerson) {
        this.sgdwPerson = sgdwPerson;
    }


    /**
     * Return the value associated with the column: SGDW_TEL
     */
    public java.lang.String getSgdwTel () {
        return sgdwTel;
    }

    /**
     * Set the value related to the column: SGDW_TEL
     * @param sgdwTel the SGDW_TEL value
     */
    public void setSgdwTel (java.lang.String sgdwTel) {
        this.sgdwTel = sgdwTel;
    }


    /**
     * Return the value associated with the column: JLDW_NAME
     */
    public java.lang.String getJldwName () {
        return jldwName;
    }

    /**
     * Set the value related to the column: JLDW_NAME
     * @param jldwName the JLDW_NAME value
     */
    public void setJldwName (java.lang.String jldwName) {
        this.jldwName = jldwName;
    }


    /**
     * Return the value associated with the column: JLDW_PERSON
     */
    public java.lang.String getJldwPerson () {
        return jldwPerson;
    }

    /**
     * Set the value related to the column: JLDW_PERSON
     * @param jldwPerson the JLDW_PERSON value
     */
    public void setJldwPerson (java.lang.String jldwPerson) {
        this.jldwPerson = jldwPerson;
    }


    /**
     * Return the value associated with the column: JLDW_TEL
     */
    public java.lang.String getJldwTel () {
        return jldwTel;
    }

    /**
     * Set the value related to the column: JLDW_TEL
     * @param jldwTel the JLDW_TEL value
     */
    public void setJldwTel (java.lang.String jldwTel) {
        this.jldwTel = jldwTel;
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
     * Return the value associated with the column: PROJECT_ID
     */
    public com.justonetech.biz.domain.ProjInfo getProject () {
        return project;
    }

    /**
     * Set the value related to the column: PROJECT_ID
     * @param project the PROJECT_ID value
     */
    public void setProject (com.justonetech.biz.domain.ProjInfo project) {
        this.project = project;
    }


    /**
     * Return the value associated with the column: dataNodeReports
     */
    public java.util.Set<com.justonetech.biz.domain.DataNodeReport> getDataNodeReports () {
        return dataNodeReports;
    }

    /**
     * Set the value related to the column: dataNodeReports
     * @param dataNodeReports the dataNodeReports value
     */
    public void setDataNodeReports (java.util.Set<com.justonetech.biz.domain.DataNodeReport> dataNodeReports) {
        this.dataNodeReports = dataNodeReports;
    }


    /**
     * Return the value associated with the column: dataStageReports
     */
    public java.util.Set<com.justonetech.biz.domain.DataStageReport> getDataStageReports () {
        return dataStageReports;
    }

    /**
     * Set the value related to the column: dataStageReports
     * @param dataStageReports the dataStageReports value
     */
    public void setDataStageReports (java.util.Set<com.justonetech.biz.domain.DataStageReport> dataStageReports) {
        this.dataStageReports = dataStageReports;
    }


    /**
     * Return the value associated with the column: projBidAreas
     */
    public java.util.Set<com.justonetech.biz.domain.ProjBidArea> getProjBidAreas () {
        return projBidAreas;
    }

    /**
     * Set the value related to the column: projBidAreas
     * @param projBidAreas the projBidAreas value
     */
    public void setProjBidAreas (java.util.Set<com.justonetech.biz.domain.ProjBidArea> projBidAreas) {
        this.projBidAreas = projBidAreas;
    }



    public boolean equals (Object obj) {
        if (null == obj) return false;
        if (!(obj instanceof com.justonetech.biz.domain.ProjBid)) return false;
        else {
            com.justonetech.biz.domain.ProjBid projBid = (com.justonetech.biz.domain.ProjBid) obj;
            if (null == this.getId() || null == projBid.getId()) return false;
            else return (this.getId().equals(projBid.getId()));
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
        builder.append(code);
        builder.append(no);
        builder.append(name);
        builder.append(typeCode);
        builder.append(buildMileage);
        builder.append(projLink);
        builder.append(linkTel);
        builder.append(startDate);
        builder.append(jsdwName);
        builder.append(jsdwPerson);
        builder.append(jsdwTel);
        builder.append(kcdwName);
        builder.append(kcdwPerson);
        builder.append(kcdwTel);
        builder.append(sjdwName);
        builder.append(sjdwPerson);
        builder.append(sjdwTel);
        builder.append(sgdwName);
        builder.append(sgdwPerson);
        builder.append(sgdwTel);
        builder.append(jldwName);
        builder.append(jldwPerson);
        builder.append(jldwTel);
        builder.append(createTime);
        builder.append(updateTime);
        builder.append(createUser);
        builder.append(updateUser);
        return builder.toString();
    }


}