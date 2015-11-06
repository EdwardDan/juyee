package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SLRY_QUALIFY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 三类人员
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 三类人员
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : slry
 * Projectable : false
 *
 * @hibernate.class
 *  table="SLRY_QUALIFY"
 */

public abstract class BaseSlryQualify  implements Serializable {

    public static String REF = "SlryQualify";
    public static String PROP_UNIT_NAME = "unitName";
    public static String PROP_MAJOR = "major";
    public static String PROP_CS_OPINION = "csOpinion";
    public static String PROP_UNIT_TYPE = "unitType";
    public static String PROP_DOC_PHOTO = "docPhoto";
    public static String PROP_DOC_CARD = "docCard";
    public static String PROP_CREATE_USER = "createUser";
    public static String PROP_APPLY_CER_TYPE = "applyCerType";
    public static String PROP_WORK_RESUME = "workResume";
    public static String PROP_CARD_TYPE = "cardType";
    public static String PROP_APPLY_TYPE = "applyType";
    public static String PROP_TECH_TYPE = "techType";
    public static String PROP_SEX = "sex";
    public static String PROP_UPDATE_USER = "updateUser";
    public static String PROP_DESCRIPTION = "description";
    public static String PROP_GRADUATION_TIME = "graduationTime";
    public static String PROP_UPDATE_TIME = "updateTime";
    public static String PROP_DOC_EDUCATION = "docEducation";
    public static String PROP_ID_CARD = "idCard";
    public static String PROP_DOC_CONTRACT = "docContract";
    public static String PROP_GRADUATION_SCHOOL = "graduationSchool";
    public static String PROP_BIRTH_DATE = "birthDate";
    public static String PROP_NAME = "name";
    public static String PROP_STATUS = "status";
    public static String PROP_EDUCATION_TYPE = "educationType";
    public static String PROP_PRODUCTION = "production";
    public static String PROP_CREATE_TIME = "createTime";
    public static String PROP_ID = "id";


    // constructors
    public BaseSlryQualify () {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseSlryQualify (java.lang.Long id) {
        this.setId(id);
        initialize();
    }

    protected void initialize () {}



    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Long id;

    // fields
    /*企业名称*/
    /*企业名称*/
    private java.lang.String unitName;

    /*备注*/
    /*备注*/
    private java.lang.String description;

    /*姓名*/
    /*姓名*/
    private java.lang.String name;

    /*性别*/
    /*性别*/
    private java.lang.Boolean sex;

    /*出生日期*/
    /*出生日期*/
    private java.sql.Date birthDate;

    /*证件号码*/
    /*证件号码*/
    private java.lang.String idCard;

    /*毕业时间*/
    /*毕业时间*/
    private java.sql.Timestamp graduationTime;

    /*毕业院校*/
    /*毕业院校*/
    private java.lang.String graduationSchool;

    /*所学专业*/
    /*所学专业*/
    private java.lang.String major;

    /*工作简历*/
    /*工作简历*/
    private java.lang.String workResume;

    /*生产业绩*/
    /*生产业绩*/
    private java.lang.String production;

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

    /*状态*/
    /*状态*/
    private java.lang.Integer status;

    /*初审意见*/
    /*初审意见*/
    private java.lang.String csOpinion;


    // many to one
    private com.justonetech.system.domain.SysCodeDetail applyCerType;
    private com.justonetech.system.domain.SysCodeDetail techType;
    private com.justonetech.system.domain.SysCodeDetail unitType;
    private com.justonetech.system.domain.SysCodeDetail cardType;
    private com.justonetech.system.domain.SysCodeDetail educationType;
    private com.justonetech.system.domain.SysCodeDetail applyType;
    private com.justonetech.biz.domain.DocDocument docCard;
    private com.justonetech.biz.domain.DocDocument docContract;
    private com.justonetech.biz.domain.DocDocument docEducation;
    private com.justonetech.biz.domain.DocDocument docPhoto;



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
     * Return the value associated with the column: UNIT_NAME
     */
    public java.lang.String getUnitName () {
        return unitName;
    }

    /**
     * Set the value related to the column: UNIT_NAME
     * @param unitName the UNIT_NAME value
     */
    public void setUnitName (java.lang.String unitName) {
        this.unitName = unitName;
    }


    /**
     * Return the value associated with the column: DESCRIPTION
     */
    public java.lang.String getDescription () {
        return description;
    }

    /**
     * Set the value related to the column: DESCRIPTION
     * @param description the DESCRIPTION value
     */
    public void setDescription (java.lang.String description) {
        this.description = description;
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
     * Return the value associated with the column: SEX
     */
    public java.lang.Boolean getSex () {
        return sex;
    }

    /**
     * Set the value related to the column: SEX
     * @param sex the SEX value
     */
    public void setSex (java.lang.Boolean sex) {
        this.sex = sex;
    }


    /**
     * Return the value associated with the column: BIRTH_DATE
     */
    public java.sql.Date getBirthDate () {
        return birthDate;
    }

    /**
     * Set the value related to the column: BIRTH_DATE
     * @param birthDate the BIRTH_DATE value
     */
    public void setBirthDate (java.sql.Date birthDate) {
        this.birthDate = birthDate;
    }


    /**
     * Return the value associated with the column: ID_CARD
     */
    public java.lang.String getIdCard () {
        return idCard;
    }

    /**
     * Set the value related to the column: ID_CARD
     * @param idCard the ID_CARD value
     */
    public void setIdCard (java.lang.String idCard) {
        this.idCard = idCard;
    }


    /**
     * Return the value associated with the column: GRADUATION_TIME
     */
    public java.sql.Timestamp getGraduationTime () {
        return graduationTime;
    }

    /**
     * Set the value related to the column: GRADUATION_TIME
     * @param graduationTime the GRADUATION_TIME value
     */
    public void setGraduationTime (java.sql.Timestamp graduationTime) {
        this.graduationTime = graduationTime;
    }


    /**
     * Return the value associated with the column: GRADUATION_SCHOOL
     */
    public java.lang.String getGraduationSchool () {
        return graduationSchool;
    }

    /**
     * Set the value related to the column: GRADUATION_SCHOOL
     * @param graduationSchool the GRADUATION_SCHOOL value
     */
    public void setGraduationSchool (java.lang.String graduationSchool) {
        this.graduationSchool = graduationSchool;
    }


    /**
     * Return the value associated with the column: MAJOR
     */
    public java.lang.String getMajor () {
        return major;
    }

    /**
     * Set the value related to the column: MAJOR
     * @param major the MAJOR value
     */
    public void setMajor (java.lang.String major) {
        this.major = major;
    }


    /**
     * Return the value associated with the column: WORK_RESUME
     */
    public java.lang.String getWorkResume () {
        return workResume;
    }

    /**
     * Set the value related to the column: WORK_RESUME
     * @param workResume the WORK_RESUME value
     */
    public void setWorkResume (java.lang.String workResume) {
        this.workResume = workResume;
    }


    /**
     * Return the value associated with the column: PRODUCTION
     */
    public java.lang.String getProduction () {
        return production;
    }

    /**
     * Set the value related to the column: PRODUCTION
     * @param production the PRODUCTION value
     */
    public void setProduction (java.lang.String production) {
        this.production = production;
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
     * Return the value associated with the column: STATUS
     */
    public java.lang.Integer getStatus () {
        return status;
    }

    /**
     * Set the value related to the column: STATUS
     * @param status the STATUS value
     */
    public void setStatus (java.lang.Integer status) {
        this.status = status;
    }


    /**
     * Return the value associated with the column: CS_OPINION
     */
    public java.lang.String getCsOpinion () {
        return csOpinion;
    }

    /**
     * Set the value related to the column: CS_OPINION
     * @param csOpinion the CS_OPINION value
     */
    public void setCsOpinion (java.lang.String csOpinion) {
        this.csOpinion = csOpinion;
    }


    /**
     * Return the value associated with the column: APPLY_CER_TYPE_ID
     */
    public com.justonetech.system.domain.SysCodeDetail getApplyCerType () {
        return applyCerType;
    }

    /**
     * Set the value related to the column: APPLY_CER_TYPE_ID
     * @param applyCerType the APPLY_CER_TYPE_ID value
     */
    public void setApplyCerType (com.justonetech.system.domain.SysCodeDetail applyCerType) {
        this.applyCerType = applyCerType;
    }


    /**
     * Return the value associated with the column: TECH_TYPE_ID
     */
    public com.justonetech.system.domain.SysCodeDetail getTechType () {
        return techType;
    }

    /**
     * Set the value related to the column: TECH_TYPE_ID
     * @param techType the TECH_TYPE_ID value
     */
    public void setTechType (com.justonetech.system.domain.SysCodeDetail techType) {
        this.techType = techType;
    }


    /**
     * Return the value associated with the column: UNIT_TYPE_ID
     */
    public com.justonetech.system.domain.SysCodeDetail getUnitType () {
        return unitType;
    }

    /**
     * Set the value related to the column: UNIT_TYPE_ID
     * @param unitType the UNIT_TYPE_ID value
     */
    public void setUnitType (com.justonetech.system.domain.SysCodeDetail unitType) {
        this.unitType = unitType;
    }


    /**
     * Return the value associated with the column: CARD_TYPE_ID
     */
    public com.justonetech.system.domain.SysCodeDetail getCardType () {
        return cardType;
    }

    /**
     * Set the value related to the column: CARD_TYPE_ID
     * @param cardType the CARD_TYPE_ID value
     */
    public void setCardType (com.justonetech.system.domain.SysCodeDetail cardType) {
        this.cardType = cardType;
    }


    /**
     * Return the value associated with the column: EDUCATION_TYPE_ID
     */
    public com.justonetech.system.domain.SysCodeDetail getEducationType () {
        return educationType;
    }

    /**
     * Set the value related to the column: EDUCATION_TYPE_ID
     * @param educationType the EDUCATION_TYPE_ID value
     */
    public void setEducationType (com.justonetech.system.domain.SysCodeDetail educationType) {
        this.educationType = educationType;
    }


    /**
     * Return the value associated with the column: DOC_CARD_ID
     */
    public com.justonetech.biz.domain.DocDocument getDocCard () {
        return docCard;
    }

    /**
     * Set the value related to the column: DOC_CARD_ID
     * @param docCard the DOC_CARD_ID value
     */
    public void setDocCard (com.justonetech.biz.domain.DocDocument docCard) {
        this.docCard = docCard;
    }


    /**
     * Return the value associated with the column: APPLY_TYPE_ID
     */
    public com.justonetech.system.domain.SysCodeDetail getApplyType () {
        return applyType;
    }

    /**
     * Set the value related to the column: APPLY_TYPE_ID
     * @param applyType the APPLY_TYPE_ID value
     */
    public void setApplyType (com.justonetech.system.domain.SysCodeDetail applyType) {
        this.applyType = applyType;
    }


    /**
     * Return the value associated with the column: DOC_CONTRACT_ID
     */
    public com.justonetech.biz.domain.DocDocument getDocContract () {
        return docContract;
    }

    /**
     * Set the value related to the column: DOC_CONTRACT_ID
     * @param docContract the DOC_CONTRACT_ID value
     */
    public void setDocContract (com.justonetech.biz.domain.DocDocument docContract) {
        this.docContract = docContract;
    }


    /**
     * Return the value associated with the column: DOC_EDUCATION_ID
     */
    public com.justonetech.biz.domain.DocDocument getDocEducation () {
        return docEducation;
    }

    /**
     * Set the value related to the column: DOC_EDUCATION_ID
     * @param docEducation the DOC_EDUCATION_ID value
     */
    public void setDocEducation (com.justonetech.biz.domain.DocDocument docEducation) {
        this.docEducation = docEducation;
    }


    /**
     * Return the value associated with the column: DOC_PHOTO_ID
     */
    public com.justonetech.biz.domain.DocDocument getDocPhoto () {
        return docPhoto;
    }

    /**
     * Set the value related to the column: DOC_PHOTO_ID
     * @param docPhoto the DOC_PHOTO_ID value
     */
    public void setDocPhoto (com.justonetech.biz.domain.DocDocument docPhoto) {
        this.docPhoto = docPhoto;
    }



    public boolean equals (Object obj) {
        if (null == obj) return false;
        if (!(obj instanceof com.justonetech.biz.domain.SlryQualify)) return false;
        else {
            com.justonetech.biz.domain.SlryQualify slryQualify = (com.justonetech.biz.domain.SlryQualify) obj;
            if (null == this.getId() || null == slryQualify.getId()) return false;
            else return (this.getId().equals(slryQualify.getId()));
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
        builder.append(unitName);
        builder.append(description);
        builder.append(name);
        builder.append(sex);
        builder.append(birthDate);
        builder.append(idCard);
        builder.append(graduationTime);
        builder.append(graduationSchool);
        builder.append(major);
        builder.append(workResume);
        builder.append(production);
        builder.append(createTime);
        builder.append(createUser);
        builder.append(updateTime);
        builder.append(updateUser);
        builder.append(status);
        builder.append(csOpinion);
        return builder.toString();
    }


}