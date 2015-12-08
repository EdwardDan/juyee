package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;
import java.sql.Date;


/**
 * This is an object that contains data related to the SG_PERMIT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 施工许可证
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 施工许可证
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : sg
 * Projectable : false
 *
 * @hibernate.class table="SG_PERMIT"
 */

public abstract class BaseSgPermit implements Serializable, Auditable {

    public static String REF = "SgPermit";
    public static String PROP_BUILD_UNIT_PERSON = "buildUnitPerson";
    public static String PROP_BUILD_UNIT_ADDRESS = "buildUnitAddress";
    public static String PROP_CS_OPINION = "csOpinion";
    public static String PROP_HJG_NUM = "hjgNum";
    public static String PROP_FGLD_OPINION = "fgldOpinion";
    public static String PROP_PROJECT_TYPE = "projectType";
    public static String PROP_SH_OPINION = "shOpinion";
    public static String PROP_CS_USER = "csUser";
    public static String PROP_START_WORK_CON = "startWorkCon";
    public static String PROP_APPLY_NUM = "applyNum";
    public static String PROP_PROJECT_NAME = "projectName";
    public static String PROP_FGLD_DATE = "fgldDate";
    public static String PROP_CONTRACT_PRICE = "contractPrice";
    public static String PROP_BUILD_SITE = "buildSite";
    public static String PROP_MATERIAL_PERSON_ADDRESS = "materialPersonAddress";
    public static String PROP_BUILD_NAME = "buildName";
    public static String PROP_RECEIVE_PERSON = "receivePerson";
    public static String PROP_APPLY_MATTER = "applyMatter";
    public static String PROP_APPLY_PERSON = "applyPerson";
    public static String PROP_ZXLD_DATE = "zxldDate";
    public static String PROP_ID = "id";
    public static String PROP_FGLD_USER = "fgldUser";
    public static String PROP_WLD_USER = "wldUser";
    public static String PROP_BUILD_XKZ_CODE = "buildXkzCode";
    public static String PROP_CONTRACT_PERIOD = "contractPeriod";
    public static String PROP_BUILD_PROJ_SIZE = "buildProjSize";
    public static String PROP_RECEIVE_PERSON_PHONE = "receivePersonPhone";
    public static String PROP_BUILD_UNIT_MOBILE = "buildUnitMobile";
    public static String PROP_FH_DATE = "fhDate";
    public static String PROP_SH_DATE = "shDate";
    public static String PROP_MATERIAL_PERSON = "materialPerson";
    public static String PROP_YEAR = "year";
    public static String PROP_CREATE_USER = "createUser";
    public static String PROP_BJBH = "bjbh";
    public static String PROP_BUILD_FILE_CODE = "buildFileCode";
    public static String PROP_WLD_DATE = "wldDate";
    public static String PROP_SH_USER = "shUser";
    public static String PROP_UPDATE_USER = "updateUser";
    public static String PROP_FH_OPINION = "fhOpinion";
    public static String PROP_ZXLD_OPINION = "zxldOpinion";
    public static String PROP_CS_DATE = "csDate";
    public static String PROP_UPDATE_TIME = "updateTime";
    public static String PROP_BUILD_UNIT_TYPE = "buildUnitType";
    public static String PROP_ZXLD_USER = "zxldUser";
    public static String PROP_WLD_OPINION = "wldOpinion";
    public static String PROP_BUILD_UNIT_PHONE = "buildUnitPhone";
    public static String PROP_STATUS = "status";
    public static String PROP_FR = "fr";
    public static String PROP_HJG_YEAR = "hjgYear";
    public static String PROP_FH_USER = "fhUser";
    public static String PROP_CREATE_TIME = "createTime";
    public static String PROP_MATERIAL_PERSON_PHONE = "materialPersonPhone";



    // constructors
    public BaseSgPermit() {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseSgPermit(Long id) {
        this.setId(id);
        initialize();
    }

    protected void initialize() {
    }


    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private Long id;

    // fields
    /*年*/
    /*年*/
    private Integer year;

    /*报建编号*/
    /*报建编号*/
    private String bjbh;

    /*项目名称*/
    /*项目名称*/
    private String projectName;

    /*建设单位*/
    /*建设单位*/
    private String buildName;

    /*建设单位性质*/
    /*建设单位性质*/
    private java.lang.String buildUnitType;

    /*建设单位地址*/
    /*建设单位地址*/
    private java.lang.String buildUnitAddress;

    /*建设地点*/
    /*建设地点*/
    private java.lang.String buildSite;

    /*建设工程规模*/
    /*建设工程规模*/
    private java.lang.String buildProjSize;

    /*合同价格*/
    /*合同价格*/
    private java.lang.Integer contractPrice;

    /*合同工期*/
    /*合同工期*/
    private java.lang.String contractPeriod;

    /*法定代表人*/
    /*法定代表人*/
    private java.lang.String fr;

    /*建设单位联系电话*/
    /*建设单位联系电话*/
    private java.lang.String buildUnitPhone;

    /*建设单位联系人*/
    /*建设单位联系人*/
    private java.lang.String buildUnitPerson;

    /*手机号*/
    /*手机号*/
    private java.lang.String buildUnitMobile;

    /*建设用地批准文件编号*/
    /*建设用地批准文件编号*/
    private java.lang.String buildFileCode;

    /*建设工程规划许可证编号*/
    /*建设工程规划许可证编号*/
    private java.lang.String buildXkzCode;

    /*现场开工情况*/
    /*现场开工情况*/
    private java.lang.String startWorkCon;

    /*沪交管收字_年*/
    /*沪交管收字_年*/
    private Integer hjgYear;

    /*沪交管收字_号*/
    /*沪交管收字_号*/
    private Integer hjgNum;

    /*申请人*/
    /*申请人*/
    private String applyPerson;

    /*申请事项*/
    /*申请事项*/
    private String applyMatter;

    /*申请号*/
    /*申请号*/
    private String applyNum;

    /*材料提交人*/
    /*材料提交人*/
    private String materialPerson;

    /*材料提交人联系电话*/
    /*材料提交人联系电话*/
    private String materialPersonPhone;

    /*材料提交人联系地址*/
    /*材料提交人联系地址*/
    private String materialPersonAddress;

    /*收件人*/
    /*收件人*/
    private String receivePerson;

    /*收件人联系电话*/
    /*收件人联系电话*/
    private String receivePersonPhone;

    /*状态*/
    /*状态*/
    private Integer status;

    /*初审意见*/
    /*初审意见*/
    private java.lang.String csOpinion;

    /*初审用户*/
    /*初审用户*/
    private java.lang.String csUser;

    /*初审日期*/
    /*初审日期*/
    private java.sql.Date csDate;

    /*复核意见*/
    /*复核意见*/
    private java.lang.String fhOpinion;

    /*复核用户*/
    /*复核用户*/
    private java.lang.String fhUser;

    /*复核日期*/
    /*复核日期*/
    private java.sql.Date fhDate;

    /*审核意见*/
    /*审核意见*/
    private java.lang.String shOpinion;

    /*审核用户*/
    /*审核用户*/
    private java.lang.String shUser;

    /*审核日期*/
    /*审核日期*/
    private java.sql.Date shDate;

    /*分管领导审核意见*/
    /*分管领导审核意见*/
    private java.lang.String fgldOpinion;

    /*分管领导审核用户*/
    /*分管领导审核用户*/
    private java.lang.String fgldUser;

    /*分管领导审核日期*/
    /*分管领导审核日期*/
    private java.sql.Date fgldDate;

    /*中心领导审核意见*/
    /*中心领导审核意见*/
    private java.lang.String zxldOpinion;

    /*中心领导审核用户*/
    /*中心领导审核用户*/
    private java.lang.String zxldUser;

    /*中心领导审核日期*/
    /*中心领导审核日期*/
    private java.sql.Date zxldDate;

    /*委领导审核意见*/
    /*委领导审核意见*/
    private java.lang.String wldOpinion;

    /*委领导审核用户*/
    /*委领导审核用户*/
    private java.lang.String wldUser;

    /*委领导审核日期*/
    /*委领导审核日期*/
    private java.sql.Date wldDate;

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
    private com.justonetech.system.domain.SysCodeDetail projectType;

    // collections
    private java.util.Set<com.justonetech.biz.domain.SgPermitOperation> sgPermitOperations;
    private java.util.Set<com.justonetech.biz.domain.SgAuditOpinion> sgAuditOpinions;
    private java.util.Set<com.justonetech.biz.domain.SgMaterial> sgMaterials;
    private java.util.Set<com.justonetech.biz.domain.SgContractProjPerson> sgContractProjPersons;
    private java.util.Set<com.justonetech.biz.domain.SgUnitProj> sgUnitProjs;


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
     * Return the value associated with the column: YEAR
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Set the value related to the column: YEAR
     *
     * @param year the YEAR value
     */
    public void setYear(Integer year) {
        this.year = year;
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
     * Return the value associated with the column: BUILD_NAME
     */
    public String getBuildName() {
        return buildName;
    }

    /**
     * Set the value related to the column: BUILD_NAME
     *
     * @param buildName the BUILD_NAME value
     */
    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    /**
     * Return the value associated with the column: BUILD_UNIT_TYPE
     */
    public java.lang.String getBuildUnitType () {
        return buildUnitType;
    }

    /**
     * Set the value related to the column: BUILD_UNIT_TYPE
     * @param buildUnitType the BUILD_UNIT_TYPE value
     */
    public void setBuildUnitType (java.lang.String buildUnitType) {
        this.buildUnitType = buildUnitType;
    }


    /**
     * Return the value associated with the column: BUILD_UNIT_ADDRESS
     */
    public java.lang.String getBuildUnitAddress () {
        return buildUnitAddress;
    }

    /**
     * Set the value related to the column: BUILD_UNIT_ADDRESS
     * @param buildUnitAddress the BUILD_UNIT_ADDRESS value
     */
    public void setBuildUnitAddress (java.lang.String buildUnitAddress) {
        this.buildUnitAddress = buildUnitAddress;
    }


    /**
     * Return the value associated with the column: BUILD_SITE
     */
    public java.lang.String getBuildSite () {
        return buildSite;
    }

    /**
     * Set the value related to the column: BUILD_SITE
     * @param buildSite the BUILD_SITE value
     */
    public void setBuildSite (java.lang.String buildSite) {
        this.buildSite = buildSite;
    }


    /**
     * Return the value associated with the column: BUILD_PROJ_SIZE
     */
    public java.lang.String getBuildProjSize () {
        return buildProjSize;
    }

    /**
     * Set the value related to the column: BUILD_PROJ_SIZE
     * @param buildProjSize the BUILD_PROJ_SIZE value
     */
    public void setBuildProjSize (java.lang.String buildProjSize) {
        this.buildProjSize = buildProjSize;
    }


    /**
     * Return the value associated with the column: CONTRACT_PRICE
     */
    public java.lang.Integer getContractPrice () {
        return contractPrice;
    }

    /**
     * Set the value related to the column: CONTRACT_PRICE
     * @param contractPrice the CONTRACT_PRICE value
     */
    public void setContractPrice (java.lang.Integer contractPrice) {
        this.contractPrice = contractPrice;
    }


    /**
     * Return the value associated with the column: CONTRACT_PERIOD
     */
    public java.lang.String getContractPeriod () {
        return contractPeriod;
    }

    /**
     * Set the value related to the column: CONTRACT_PERIOD
     * @param contractPeriod the CONTRACT_PERIOD value
     */
    public void setContractPeriod (java.lang.String contractPeriod) {
        this.contractPeriod = contractPeriod;
    }


    /**
     * Return the value associated with the column: FR
     */
    public java.lang.String getFr () {
        return fr;
    }

    /**
     * Set the value related to the column: FR
     * @param fr the FR value
     */
    public void setFr (java.lang.String fr) {
        this.fr = fr;
    }


    /**
     * Return the value associated with the column: BUILD_UNIT_PHONE
     */
    public java.lang.String getBuildUnitPhone () {
        return buildUnitPhone;
    }

    /**
     * Set the value related to the column: BUILD_UNIT_PHONE
     * @param buildUnitPhone the BUILD_UNIT_PHONE value
     */
    public void setBuildUnitPhone (java.lang.String buildUnitPhone) {
        this.buildUnitPhone = buildUnitPhone;
    }


    /**
     * Return the value associated with the column: BUILD_UNIT_PERSON
     */
    public java.lang.String getBuildUnitPerson () {
        return buildUnitPerson;
    }

    /**
     * Set the value related to the column: BUILD_UNIT_PERSON
     * @param buildUnitPerson the BUILD_UNIT_PERSON value
     */
    public void setBuildUnitPerson (java.lang.String buildUnitPerson) {
        this.buildUnitPerson = buildUnitPerson;
    }


    /**
     * Return the value associated with the column: BUILD_UNIT_MOBILE
     */
    public java.lang.String getBuildUnitMobile () {
        return buildUnitMobile;
    }

    /**
     * Set the value related to the column: BUILD_UNIT_MOBILE
     * @param buildUnitMobile the BUILD_UNIT_MOBILE value
     */
    public void setBuildUnitMobile (java.lang.String buildUnitMobile) {
        this.buildUnitMobile = buildUnitMobile;
    }


    /**
     * Return the value associated with the column: BUILD_FILE_CODE
     */
    public java.lang.String getBuildFileCode () {
        return buildFileCode;
    }

    /**
     * Set the value related to the column: BUILD_FILE_CODE
     * @param buildFileCode the BUILD_FILE_CODE value
     */
    public void setBuildFileCode (java.lang.String buildFileCode) {
        this.buildFileCode = buildFileCode;
    }


    /**
     * Return the value associated with the column: BUILD_XKZ_CODE
     */
    public java.lang.String getBuildXkzCode () {
        return buildXkzCode;
    }

    /**
     * Set the value related to the column: BUILD_XKZ_CODE
     * @param buildXkzCode the BUILD_XKZ_CODE value
     */
    public void setBuildXkzCode (java.lang.String buildXkzCode) {
        this.buildXkzCode = buildXkzCode;
    }


    /**
     * Return the value associated with the column: START_WORK_CON
     */
    public java.lang.String getStartWorkCon () {
        return startWorkCon;
    }

    /**
     * Set the value related to the column: START_WORK_CON
     * @param startWorkCon the START_WORK_CON value
     */
    public void setStartWorkCon (java.lang.String startWorkCon) {
        this.startWorkCon = startWorkCon;
    }


    public Integer getHjgNum() {
        return hjgNum;
    }

    public void setHjgNum(Integer hjgNum) {
        this.hjgNum = hjgNum;
    }

    public Integer getHjgYear() {
        return hjgYear;
    }

    public void setHjgYear(Integer hjgYear) {
        this.hjgYear = hjgYear;
    }

    /**
     * Return the value associated with the column: APPLY_PERSON
     */
    public String getApplyPerson() {
        return applyPerson;
    }

    /**
     * Set the value related to the column: APPLY_PERSON
     *
     * @param applyPerson the APPLY_PERSON value
     */
    public void setApplyPerson(String applyPerson) {
        this.applyPerson = applyPerson;
    }


    /**
     * Return the value associated with the column: APPLY_MATTER
     */
    public String getApplyMatter() {
        return applyMatter;
    }

    /**
     * Set the value related to the column: APPLY_MATTER
     *
     * @param applyMatter the APPLY_MATTER value
     */
    public void setApplyMatter(String applyMatter) {
        this.applyMatter = applyMatter;
    }


    /**
     * Return the value associated with the column: APPLY_NUM
     */
    public String getApplyNum() {
        return applyNum;
    }

    /**
     * Set the value related to the column: APPLY_NUM
     *
     * @param applyNum the APPLY_NUM value
     */
    public void setApplyNum(String applyNum) {
        this.applyNum = applyNum;
    }


    /**
     * Return the value associated with the column: MATERIAL_PERSON
     */
    public String getMaterialPerson() {
        return materialPerson;
    }

    /**
     * Set the value related to the column: MATERIAL_PERSON
     *
     * @param materialPerson the MATERIAL_PERSON value
     */
    public void setMaterialPerson(String materialPerson) {
        this.materialPerson = materialPerson;
    }


    /**
     * Return the value associated with the column: MATERIAL_PERSON_PHONE
     */
    public String getMaterialPersonPhone() {
        return materialPersonPhone;
    }

    /**
     * Set the value related to the column: MATERIAL_PERSON_PHONE
     *
     * @param materialPersonPhone the MATERIAL_PERSON_PHONE value
     */
    public void setMaterialPersonPhone(String materialPersonPhone) {
        this.materialPersonPhone = materialPersonPhone;
    }


    /**
     * Return the value associated with the column: MATERIAL_PERSON_ADDRESS
     */
    public String getMaterialPersonAddress() {
        return materialPersonAddress;
    }

    /**
     * Set the value related to the column: MATERIAL_PERSON_ADDRESS
     *
     * @param materialPersonAddress the MATERIAL_PERSON_ADDRESS value
     */
    public void setMaterialPersonAddress(String materialPersonAddress) {
        this.materialPersonAddress = materialPersonAddress;
    }


    /**
     * Return the value associated with the column: RECEIVE_PERSON
     */
    public String getReceivePerson() {
        return receivePerson;
    }

    /**
     * Set the value related to the column: RECEIVE_PERSON
     *
     * @param receivePerson the RECEIVE_PERSON value
     */
    public void setReceivePerson(String receivePerson) {
        this.receivePerson = receivePerson;
    }


    /**
     * Return the value associated with the column: RECEIVE_PERSON_PHONE
     */
    public String getReceivePersonPhone() {
        return receivePersonPhone;
    }

    /**
     * Set the value related to the column: RECEIVE_PERSON_PHONE
     *
     * @param receivePersonPhone the RECEIVE_PERSON_PHONE value
     */
    public void setReceivePersonPhone(String receivePersonPhone) {
        this.receivePersonPhone = receivePersonPhone;
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

    public String getCsOpinion() {
        return csOpinion;
    }

    public void setCsOpinion(String csOpinion) {
        this.csOpinion = csOpinion;
    }

    public String getCsUser() {
        return csUser;
    }

    public void setCsUser(String csUser) {
        this.csUser = csUser;
    }

    public Date getCsDate() {
        return csDate;
    }

    public void setCsDate(Date csDate) {
        this.csDate = csDate;
    }

    public String getFhOpinion() {
        return fhOpinion;
    }

    public void setFhOpinion(String fhOpinion) {
        this.fhOpinion = fhOpinion;
    }

    public String getFhUser() {
        return fhUser;
    }

    public void setFhUser(String fhUser) {
        this.fhUser = fhUser;
    }

    public Date getFhDate() {
        return fhDate;
    }

    public void setFhDate(Date fhDate) {
        this.fhDate = fhDate;
    }

    public String getShOpinion() {
        return shOpinion;
    }

    public void setShOpinion(String shOpinion) {
        this.shOpinion = shOpinion;
    }

    public String getShUser() {
        return shUser;
    }

    public void setShUser(String shUser) {
        this.shUser = shUser;
    }

    public Date getShDate() {
        return shDate;
    }

    public void setShDate(Date shDate) {
        this.shDate = shDate;
    }

    public String getFgldOpinion() {
        return fgldOpinion;
    }

    public void setFgldOpinion(String fgldOpinion) {
        this.fgldOpinion = fgldOpinion;
    }

    public String getFgldUser() {
        return fgldUser;
    }

    public void setFgldUser(String fgldUser) {
        this.fgldUser = fgldUser;
    }

    public Date getFgldDate() {
        return fgldDate;
    }

    public void setFgldDate(Date fgldDate) {
        this.fgldDate = fgldDate;
    }

    public String getZxldOpinion() {
        return zxldOpinion;
    }

    public void setZxldOpinion(String zxldOpinion) {
        this.zxldOpinion = zxldOpinion;
    }

    public String getZxldUser() {
        return zxldUser;
    }

    public void setZxldUser(String zxldUser) {
        this.zxldUser = zxldUser;
    }

    public Date getZxldDate() {
        return zxldDate;
    }

    public void setZxldDate(Date zxldDate) {
        this.zxldDate = zxldDate;
    }

    public String getWldOpinion() {
        return wldOpinion;
    }

    public void setWldOpinion(String wldOpinion) {
        this.wldOpinion = wldOpinion;
    }

    public String getWldUser() {
        return wldUser;
    }

    public void setWldUser(String wldUser) {
        this.wldUser = wldUser;
    }

    public Date getWldDate() {
        return wldDate;
    }

    public void setWldDate(Date wldDate) {
        this.wldDate = wldDate;
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
     * Return the value associated with the column: PROJECT_TYPE_ID
     */
    public com.justonetech.system.domain.SysCodeDetail getProjectType() {
        return projectType;
    }

    /**
     * Set the value related to the column: PROJECT_TYPE_ID
     *
     * @param projectType the PROJECT_TYPE_ID value
     */
    public void setProjectType(com.justonetech.system.domain.SysCodeDetail projectType) {
        this.projectType = projectType;
    }


    /**
     * Return the value associated with the column: sgPermitOperations
     */
    public java.util.Set<com.justonetech.biz.domain.SgPermitOperation> getSgPermitOperations() {
        if (sgPermitOperations == null) {
            sgPermitOperations = new java.util.LinkedHashSet<com.justonetech.biz.domain.SgPermitOperation>();
        }
        return sgPermitOperations;
    }

    /**
     * Set the value related to the column: sgPermitOperations
     *
     * @param sgPermitOperations the sgPermitOperations value
     */
    public void setSgPermitOperations(java.util.Set<com.justonetech.biz.domain.SgPermitOperation> sgPermitOperations) {
        this.sgPermitOperations = sgPermitOperations;
    }

    public void addTosgPermitOperations(com.justonetech.biz.domain.SgPermitOperation sgPermitOperation) {
        if (null == getSgPermitOperations())
            setSgPermitOperations(new java.util.LinkedHashSet<com.justonetech.biz.domain.SgPermitOperation>());
        getSgPermitOperations().add(sgPermitOperation);
    }


    /**
     * Return the value associated with the column: sgAuditOpinions
     */
    public java.util.Set<com.justonetech.biz.domain.SgAuditOpinion> getSgAuditOpinions() {
        if (sgAuditOpinions == null) {
            sgAuditOpinions = new java.util.LinkedHashSet<com.justonetech.biz.domain.SgAuditOpinion>();
        }
        return sgAuditOpinions;
    }

    /**
     * Set the value related to the column: sgAuditOpinions
     *
     * @param sgAuditOpinions the sgAuditOpinions value
     */
    public void setSgAuditOpinions(java.util.Set<com.justonetech.biz.domain.SgAuditOpinion> sgAuditOpinions) {
        this.sgAuditOpinions = sgAuditOpinions;
    }

    public void addTosgAuditOpinions(com.justonetech.biz.domain.SgAuditOpinion sgAuditOpinion) {
        if (null == getSgAuditOpinions())
            setSgAuditOpinions(new java.util.LinkedHashSet<com.justonetech.biz.domain.SgAuditOpinion>());
        getSgAuditOpinions().add(sgAuditOpinion);
    }


    /**
     * Return the value associated with the column: sgMaterials
     */
    public java.util.Set<com.justonetech.biz.domain.SgMaterial> getSgMaterials() {
        if (sgMaterials == null) {
            sgMaterials = new java.util.LinkedHashSet<com.justonetech.biz.domain.SgMaterial>();
        }
        return sgMaterials;
    }

    /**
     * Set the value related to the column: sgMaterials
     *
     * @param sgMaterials the sgMaterials value
     */
    public void setSgMaterials(java.util.Set<com.justonetech.biz.domain.SgMaterial> sgMaterials) {
        this.sgMaterials = sgMaterials;
    }

    public void addTosgMaterials(com.justonetech.biz.domain.SgMaterial sgMaterial) {
        if (null == getSgMaterials())
            setSgMaterials(new java.util.LinkedHashSet<com.justonetech.biz.domain.SgMaterial>());
        getSgMaterials().add(sgMaterial);
    }

    /**
     * Return the value associated with the column: sgContractProjPersons
     */
    public java.util.Set<com.justonetech.biz.domain.SgContractProjPerson> getSgContractProjPersons () {
        if(sgContractProjPersons == null){
            sgContractProjPersons = new java.util.LinkedHashSet<com.justonetech.biz.domain.SgContractProjPerson>();
        }
        return sgContractProjPersons;
    }

    /**
     * Set the value related to the column: sgContractProjPersons
     * @param sgContractProjPersons the sgContractProjPersons value
     */
    public void setSgContractProjPersons (java.util.Set<com.justonetech.biz.domain.SgContractProjPerson> sgContractProjPersons) {
        this.sgContractProjPersons = sgContractProjPersons;
    }

    public void addTosgContractProjPersons (com.justonetech.biz.domain.SgContractProjPerson sgContractProjPerson) {
        if (null == getSgContractProjPersons()) setSgContractProjPersons(new java.util.LinkedHashSet<com.justonetech.biz.domain.SgContractProjPerson>());
        getSgContractProjPersons().add(sgContractProjPerson);
    }


    /**
     * Return the value associated with the column: sgUnitProjs
     */
    public java.util.Set<com.justonetech.biz.domain.SgUnitProj> getSgUnitProjs () {
        if(sgUnitProjs == null){
            sgUnitProjs = new java.util.LinkedHashSet<com.justonetech.biz.domain.SgUnitProj>();
        }
        return sgUnitProjs;
    }

    /**
     * Set the value related to the column: sgUnitProjs
     * @param sgUnitProjs the sgUnitProjs value
     */
    public void setSgUnitProjs (java.util.Set<com.justonetech.biz.domain.SgUnitProj> sgUnitProjs) {
        this.sgUnitProjs = sgUnitProjs;
    }

    public void addTosgUnitProjs (com.justonetech.biz.domain.SgUnitProj sgUnitProj) {
        if (null == getSgUnitProjs()) setSgUnitProjs(new java.util.LinkedHashSet<com.justonetech.biz.domain.SgUnitProj>());
        getSgUnitProjs().add(sgUnitProj);
    }


    public boolean equals(Object obj) {
        if (null == obj) return false;
        if (!(obj instanceof com.justonetech.biz.domain.SgPermit)) return false;
        else {
            com.justonetech.biz.domain.SgPermit sgPermit = (com.justonetech.biz.domain.SgPermit) obj;
            if (null == this.getId() || null == sgPermit.getId()) return false;
            else return (this.getId().equals(sgPermit.getId()));
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
        builder.append(year);
        builder.append(bjbh);
        builder.append(projectName);
        builder.append(buildName);
        builder.append(buildUnitType);
        builder.append(buildUnitAddress);
        builder.append(buildSite);
        builder.append(buildProjSize);
        builder.append(contractPrice);
        builder.append(contractPeriod);
        builder.append(fr);
        builder.append(buildUnitPhone);
        builder.append(buildUnitPerson);
        builder.append(buildUnitMobile);
        builder.append(buildFileCode);
        builder.append(buildXkzCode);
        builder.append(startWorkCon);
        builder.append(hjgYear);
        builder.append(hjgNum);
        builder.append(applyPerson);
        builder.append(applyMatter);
        builder.append(applyNum);
        builder.append(materialPerson);
        builder.append(materialPersonPhone);
        builder.append(materialPersonAddress);
        builder.append(receivePerson);
        builder.append(receivePersonPhone);
        builder.append(status);
        builder.append(csOpinion);
        builder.append(csUser);
        builder.append(csDate);
        builder.append(fhOpinion);
        builder.append(fhUser);
        builder.append(fhDate);
        builder.append(shOpinion);
        builder.append(shUser);
        builder.append(shDate);
        builder.append(fgldOpinion);
        builder.append(fgldUser);
        builder.append(fgldDate);
        builder.append(zxldOpinion);
        builder.append(zxldUser);
        builder.append(zxldDate);
        builder.append(wldOpinion);
        builder.append(wldUser);
        builder.append(wldDate);
        builder.append(createTime);
        builder.append(createUser);
        builder.append(updateTime);
        builder.append(updateUser);
        return builder.toString();
    }


}