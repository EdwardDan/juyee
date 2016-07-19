package com.justonetech.biz.domain.base;

import com.justonetech.biz.domain.SgPermitHdExtend;
import com.justonetech.biz.domain.SgPermitHistoryOpinion;
import com.justonetech.core.entity.Auditable;
import com.justonetech.system.domain.SysCodeDetail;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;


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

    //业务编号
    private String bizCode;

    // fields
    /*年*/
    /*年*/
    private Integer year;

    /*区县编码*/
    /*区县编码*/
    private java.lang.String areaCode;

    /*区县名称*/
    /*区县名称*/
    private java.lang.String areaName;

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
    private java.lang.Double contractPrice;

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
    private java.lang.String jgzxYsOpinion;

    /*初审用户*/
    /*初审用户*/
    private java.lang.String jgzxYsUser;

    /*初审日期*/
    /*初审日期*/
    private java.sql.Timestamp jgzxYsDate;

     /*初审意见*/
    /*初审意见*/
    private java.lang.String csOpinion;

    /*初审用户*/
    /*初审用户*/
    private java.lang.String csUser;

    /*初审日期*/
    /*初审日期*/
    private java.sql.Timestamp csDate;

    /*复核意见*/
    /*复核意见*/
    private java.lang.String fhOpinion;

    /*复核用户*/
    /*复核用户*/
    private java.lang.String fhUser;

    /*复核日期*/
    /*复核日期*/
    private java.sql.Timestamp fhDate;

    /*审核意见*/
    /*审核意见*/
    private java.lang.String shOpinion;

    /*审核用户*/
    /*审核用户*/
    private java.lang.String shUser;

    /*审核日期*/
    /*审核日期*/
    private java.sql.Timestamp shDate;

    /*分管领导审核意见*/
    /*分管领导审核意见*/
    private java.lang.String fgldOpinion;

    /*分管领导审核用户*/
    /*分管领导审核用户*/
    private java.lang.String fgldUser;

    /*分管领导审核日期*/
    /*分管领导审核日期*/
    private java.sql.Timestamp fgldDate;

    /*中心领导审核意见*/
    /*中心领导审核意见*/
    private java.lang.String zxldOpinion;

    /*中心领导审核用户*/
    /*中心领导审核用户*/
    private java.lang.String zxldUser;

    /*中心领导审核日期*/
    /*中心领导审核日期*/
    private java.sql.Timestamp zxldDate;

    /*建设处审核意见*/
    /*建设处审核意见*/
    private java.lang.String jscOpinion;

    /*建设处审核用户*/
    /*建设处审核用户*/
    private java.lang.String jscUser;

    /*建设处审核日期*/
    /*建设处审核日期*/
    private java.sql.Timestamp jscDate;

    /*审批处审核意见*/
    /*审批处审核意见*/
    private java.lang.String spcOpinion;

    /*审批处审核用户*/
    /*审批处审核用户*/
    private java.lang.String spcUser;

    /*审批处审核日期*/
    /*审批处审核日期*/
    private java.sql.Timestamp spcDate;

    /*委领导审核意见*/
    /*委领导审核意见*/
    private java.lang.String wldOpinion;

    /*委领导审核用户*/
    /*委领导审核用户*/
    private java.lang.String wldUser;

    /*委领导审核日期*/
    /*委领导审核日期*/
    private java.sql.Timestamp wldDate;

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

    /*提交日期*/
    /*提交日期*/
    private java.sql.Timestamp submitDate;

    /*退回编号*/
    /*退回编号*/
    private Integer backNum;

    /*受理编号*/
    /*受理编号*/
    private String acceptCode;

    //受理人
    private String acceptPerson;

    //受理日期
    private Timestamp acceptDate;

    //受理意见
    private String acceptOpinion;

    /*合同开工日期*/
    /*合同开工日期*/
    private Date contractBeginDate;

    /*合同竣工日期*/
    /*合同竣工日期*/
    private Date contractEndDate;

    /*中标价（万元）*/
    /*中标价（万元）*/
    private java.lang.Double zbPrice;

    /*建设工程类别ids*/
    /*建设工程类别ids*/
    private String buildLbIds;

    /*补正退回材料*/
    /*补正退回材料*/
    private String bzBackMaterial;

    //项目投资估算（万元）
    private java.lang.Double projectPlanCost;

    //施工单位
    private String sgUnitName;
    private String jlUnitName;
    private String sjUnitName;
    private String buildSiteCounty;
    private String nationalFundsPro;
    private String sgUnitManager;
    private String jlUnitManager;

    // many to one
    private com.justonetech.system.domain.SysCodeDetail projectType;
    private com.justonetech.system.domain.SysCodeDetail propertyType;
    private com.justonetech.system.domain.SysCodeDetail buildLb;
    private com.justonetech.system.domain.SysCodeDetail buildSx;

    // collections
    private java.util.Set<com.justonetech.biz.domain.SgPermitOperation> sgPermitOperations;
    private java.util.Set<com.justonetech.biz.domain.SgAuditOpinion> sgAuditOpinions;
    private java.util.Set<com.justonetech.biz.domain.SgMaterial> sgMaterials;
    private java.util.Set<com.justonetech.biz.domain.SgContractProjPerson> sgContractProjPersons;
    private java.util.Set<com.justonetech.biz.domain.SgUnitProj> sgUnitProjs;
    private java.util.Set<com.justonetech.biz.domain.SgPermitHdExtend> sgPermitHdExtends;
    private java.util.Set<com.justonetech.biz.domain.SgPermitHistoryOpinion> sgPermitHistoryOpinions;


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

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
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

    public String getBdh() {
        return bdh;
    }

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
    public java.lang.Double getContractPrice () {
        return contractPrice;
    }

    /**
     * Set the value related to the column: CONTRACT_PRICE
     * @param contractPrice the CONTRACT_PRICE value
     */
    public void setContractPrice (java.lang.Double contractPrice) {
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

    public String getJgzxYsOpinion() {
        return jgzxYsOpinion;
    }

    public void setJgzxYsOpinion(String jgzxYsOpinion) {
        this.jgzxYsOpinion = jgzxYsOpinion;
    }

    public String getJgzxYsUser() {
        return jgzxYsUser;
    }

    public void setJgzxYsUser(String jgzxYsUser) {
        this.jgzxYsUser = jgzxYsUser;
    }

    public Timestamp getJgzxYsDate() {
        return jgzxYsDate;
    }

    public void setJgzxYsDate(Timestamp jgzxYsDate) {
        this.jgzxYsDate = jgzxYsDate;
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

    public Timestamp getCsDate() {
        return csDate;
    }

    public void setCsDate(Timestamp csDate) {
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

    public Timestamp getFhDate() {
        return fhDate;
    }

    public void setFhDate(Timestamp fhDate) {
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

    public Timestamp getShDate() {
        return shDate;
    }

    public void setShDate(Timestamp shDate) {
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

    public Timestamp getFgldDate() {
        return fgldDate;
    }

    public void setFgldDate(Timestamp fgldDate) {
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

    public Timestamp getZxldDate() {
        return zxldDate;
    }

    public void setZxldDate(Timestamp zxldDate) {
        this.zxldDate = zxldDate;
    }

    public String getJscOpinion() {
        return jscOpinion;
    }

    public void setJscOpinion(String jscOpinion) {
        this.jscOpinion = jscOpinion;
    }

    public String getJscUser() {
        return jscUser;
    }

    public void setJscUser(String jscUser) {
        this.jscUser = jscUser;
    }

    public Timestamp getJscDate() {
        return jscDate;
    }

    public void setJscDate(Timestamp jscDate) {
        this.jscDate = jscDate;
    }

    public String getSpcOpinion() {
        return spcOpinion;
    }

    public void setSpcOpinion(String spcOpinion) {
        this.spcOpinion = spcOpinion;
    }

    public String getSpcUser() {
        return spcUser;
    }

    public void setSpcUser(String spcUser) {
        this.spcUser = spcUser;
    }

    public Timestamp getSpcDate() {
        return spcDate;
    }

    public void setSpcDate(Timestamp spcDate) {
        this.spcDate = spcDate;
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

    public Timestamp getWldDate() {
        return wldDate;
    }

    public void setWldDate(Timestamp wldDate) {
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

    public Timestamp getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Timestamp submitDate) {
        this.submitDate = submitDate;
    }

    public Integer getBackNum() {
        return backNum;
    }

    public void setBackNum(Integer backNum) {
        this.backNum = backNum;
    }

    public String getAcceptCode() {
        return acceptCode;
    }

    public void setAcceptCode(String acceptCode) {
        this.acceptCode = acceptCode;
    }

    public Date getContractBeginDate() {
        return contractBeginDate;
    }

    public void setContractBeginDate(Date contractBeginDate) {
        this.contractBeginDate = contractBeginDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public Double getZbPrice() {
        return zbPrice;
    }

    public void setZbPrice(Double zbPrice) {
        this.zbPrice = zbPrice;
    }

    public String getBuildLbIds() {
        return buildLbIds;
    }

    public void setBuildLbIds(String buildLbIds) {
        this.buildLbIds = buildLbIds;
    }

    public String getBzBackMaterial() {
        return bzBackMaterial;
    }

    public void setBzBackMaterial(String bzBackMaterial) {
        this.bzBackMaterial = bzBackMaterial;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getAcceptPerson() {
        return acceptPerson;
    }

    public void setAcceptPerson(String acceptPerson) {
        this.acceptPerson = acceptPerson;
    }

    public Timestamp getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Timestamp acceptDate) {
        this.acceptDate = acceptDate;
    }

    public String getAcceptOpinion() {
        return acceptOpinion;
    }

    public void setAcceptOpinion(String acceptOpinion) {
        this.acceptOpinion = acceptOpinion;
    }

    public Double getProjectPlanCost() {
        return projectPlanCost;
    }

    public void setProjectPlanCost(Double projectPlanCost) {
        this.projectPlanCost = projectPlanCost;
    }

    public String getSgUnitName() {
        return sgUnitName;
    }

    public void setSgUnitName(String sgUnitName) {
        this.sgUnitName = sgUnitName;
    }

    public String getJlUnitName() {
        return jlUnitName;
    }

    public void setJlUnitName(String jlUnitName) {
        this.jlUnitName = jlUnitName;
    }

    public String getSjUnitName() {
        return sjUnitName;
    }

    public void setSjUnitName(String sjUnitName) {
        this.sjUnitName = sjUnitName;
    }

    public String getBuildSiteCounty() {
        return buildSiteCounty;
    }

    public void setBuildSiteCounty(String buildSiteCounty) {
        this.buildSiteCounty = buildSiteCounty;
    }

    public String getNationalFundsPro() {
        return nationalFundsPro;
    }

    public void setNationalFundsPro(String nationalFundsPro) {
        this.nationalFundsPro = nationalFundsPro;
    }

    public String getSgUnitManager() {
        return sgUnitManager;
    }

    public void setSgUnitManager(String sgUnitManager) {
        this.sgUnitManager = sgUnitManager;
    }

    public String getJlUnitManager() {
        return jlUnitManager;
    }

    public void setJlUnitManager(String jlUnitManager) {
        this.jlUnitManager = jlUnitManager;
    }

    public SysCodeDetail getBuildLb() {
        return buildLb;
    }

    public void setBuildLb(SysCodeDetail buildLb) {
        this.buildLb = buildLb;
    }

    public SysCodeDetail getBuildSx() {
        return buildSx;
    }

    public void setBuildSx(SysCodeDetail buildSx) {
        this.buildSx = buildSx;
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

    public SysCodeDetail getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(SysCodeDetail propertyType) {
        this.propertyType = propertyType;
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

    public Set<SgPermitHdExtend> getSgPermitHdExtends() {
        if (null==sgPermitHdExtends){
            sgPermitHdExtends=new LinkedHashSet<SgPermitHdExtend>();
        }
        return sgPermitHdExtends;
    }

    public void setSgPermitHdExtends(Set<SgPermitHdExtend> sgPermitHdExtends) {
        this.sgPermitHdExtends = sgPermitHdExtends;
    }

    public Set<SgPermitHistoryOpinion> getSgPermitHistoryOpinions() {
        if (null==sgPermitHistoryOpinions){
            sgPermitHistoryOpinions=new LinkedHashSet<SgPermitHistoryOpinion>();
        }
        return sgPermitHistoryOpinions;
    }

    public void setSgPermitHistoryOpinions(Set<SgPermitHistoryOpinion> sgPermitHistoryOpinions) {
        this.sgPermitHistoryOpinions = sgPermitHistoryOpinions;
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
        builder.append(areaCode);
        builder.append(areaName);
        builder.append(bjbh);
        builder.append(bdh);
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
        builder.append(jgzxYsOpinion);
        builder.append(jgzxYsUser);
        builder.append(jgzxYsDate);
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
        builder.append(submitDate);
        builder.append(backNum);
        builder.append(acceptCode);
        builder.append(contractBeginDate);
        builder.append(contractEndDate);
        builder.append(zbPrice);
        builder.append(buildLbIds);
        builder.append(bizCode);
        builder.append(acceptDate);
        builder.append(acceptOpinion);
        builder.append(acceptPerson);
        builder.append(sgUnitName);
        builder.append(jlUnitName);
        builder.append(sjUnitName);
        builder.append(buildSiteCounty);
        builder.append(nationalFundsPro);
        builder.append(sgUnitManager);
        builder.append(jlUnitManager);
        builder.append(projectPlanCost);
        return builder.toString();
    }


}
