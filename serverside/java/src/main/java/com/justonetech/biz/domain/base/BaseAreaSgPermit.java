package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the AREA_SG_PERMIT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 区县施工许可证
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 区县施工许可证
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : area
 * Projectable : false
 *
 * @hibernate.class
 *  table="AREA_SG_PERMIT"
 */

public abstract class BaseAreaSgPermit  implements Serializable, Auditable {

	public static String REF = "AreaSgPermit";
	public static String PROP_SPC_OPINION = "spcOpinion";
	public static String PROP_PROPERTY_TYPE = "propertyType";
	public static String PROP_BUILD_UNIT_PERSON = "buildUnitPerson";
	public static String PROP_ACCEPT_CODE = "acceptCode";
	public static String PROP_BUILD_UNIT_ADDRESS = "buildUnitAddress";
	public static String PROP_CS_OPINION = "csOpinion";
	public static String PROP_HJG_NUM = "hjgNum";
	public static String PROP_FGLD_OPINION = "fgldOpinion";
	public static String PROP_PROJECT_TYPE = "projectType";
	public static String PROP_SUBMIT_DATE = "submitDate";
	public static String PROP_ZB_PRICE = "zbPrice";
	public static String PROP_SH_OPINION = "shOpinion";
	public static String PROP_CS_USER = "csUser";
	public static String PROP_AREA_NAME = "areaName";
	public static String PROP_START_WORK_CON = "startWorkCon";
	public static String PROP_SJ_UNIT_NAME = "sjUnitName";
	public static String PROP_APPLY_NUM = "applyNum";
	public static String PROP_PROJECT_NAME = "projectName";
	public static String PROP_BUILD_LB_IDS = "buildLbIds";
	public static String PROP_FGLD_DATE = "fgldDate";
	public static String PROP_CONTRACT_PRICE = "contractPrice";
	public static String PROP_BUILD_SITE = "buildSite";
	public static String PROP_MATERIAL_PERSON_ADDRESS = "materialPersonAddress";
	public static String PROP_BUILD_NAME = "buildName";
	public static String PROP_RECEIVE_PERSON = "receivePerson";
	public static String PROP_PROJECT_PLAN_COST = "projectPlanCost";
	public static String PROP_APPLY_MATTER = "applyMatter";
	public static String PROP_ACCEPT_PERSON = "acceptPerson";
	public static String PROP_SPC_USER = "spcUser";
	public static String PROP_APPLY_PERSON = "applyPerson";
	public static String PROP_AREA_CODE = "areaCode";
	public static String PROP_JSC_OPINION = "jscOpinion";
	public static String PROP_BIZ_CODE = "bizCode";
	public static String PROP_ZXLD_DATE = "zxldDate";
	public static String PROP_ID = "id";
	public static String PROP_FGLD_USER = "fgldUser";
	public static String PROP_WLD_USER = "wldUser";
	public static String PROP_BUILD_XKZ_CODE = "buildXkzCode";
	public static String PROP_CONTRACT_PERIOD = "contractPeriod";
	public static String PROP_CONTRACT_END_DATE = "contractEndDate";
	public static String PROP_BUILD_PROJ_SIZE = "buildProjSize";
	public static String PROP_RECEIVE_PERSON_PHONE = "receivePersonPhone";
	public static String PROP_ACCEPT_OPINION = "acceptOpinion";
	public static String PROP_JSC_DATE = "jscDate";
	public static String PROP_BUILD_UNIT_MOBILE = "buildUnitMobile";
	public static String PROP_FH_DATE = "fhDate";
	public static String PROP_SH_DATE = "shDate";
	public static String PROP_YEAR = "year";
	public static String PROP_MATERIAL_PERSON = "materialPerson";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_JL_UNIT_NAME = "jlUnitName";
	public static String PROP_SPC_DATE = "spcDate";
	public static String PROP_BJBH = "bjbh";
	public static String PROP_BUILD_SX = "buildSx";
	public static String PROP_WLD_DATE = "wldDate";
	public static String PROP_BUILD_FILE_CODE = "buildFileCode";
	public static String PROP_CONTRACT_BEGIN_DATE = "contractBeginDate";
	public static String PROP_JSC_USER = "jscUser";
	public static String PROP_BZ_BACK_MATERIAL = "bzBackMaterial";
	public static String PROP_SH_USER = "shUser";
	public static String PROP_UPDATE_USER = "updateUser";
	public static String PROP_FH_OPINION = "fhOpinion";
	public static String PROP_ZXLD_OPINION = "zxldOpinion";
	public static String PROP_CS_DATE = "csDate";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_BUILD_UNIT_TYPE = "buildUnitType";
	public static String PROP_SG_UNIT_NAME = "sgUnitName";
	public static String PROP_ZXLD_USER = "zxldUser";
	public static String PROP_WLD_OPINION = "wldOpinion";
	public static String PROP_BUILD_UNIT_PHONE = "buildUnitPhone";
	public static String PROP_BUILD_LB = "buildLb";
	public static String PROP_STATUS = "status";
	public static String PROP_FR = "fr";
	public static String PROP_ACCEPT_DATE = "acceptDate";
	public static String PROP_HJG_YEAR = "hjgYear";
	public static String PROP_FH_USER = "fhUser";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_BACK_NUM = "backNum";
	public static String PROP_MATERIAL_PERSON_PHONE = "materialPersonPhone";


	// constructors
	public BaseAreaSgPermit () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAreaSgPermit (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*业务编号*/
    /*业务编号*/
	private java.lang.String bizCode;

    /*年*/
    /*年*/
	private java.lang.Integer year;

    /*区县编码*/
    /*区县编码*/
	private java.lang.String areaCode;

    /*区县名称*/
    /*区县名称*/
	private java.lang.String areaName;

    /*报建编号*/
    /*报建编号*/
	private java.lang.String bjbh;
	/*标段号*/
    /*标段号*/
	private String bdh;

    /*项目名称*/
    /*项目名称*/
	private java.lang.String projectName;

    /*建设单位*/
    /*建设单位*/
	private java.lang.String buildName;

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
	private java.lang.Integer hjgYear;

    /*沪交管收字_号*/
    /*沪交管收字_号*/
	private java.lang.Integer hjgNum;

    /*申请人*/
    /*申请人*/
	private java.lang.String applyPerson;

    /*申请事项*/
    /*申请事项*/
	private java.lang.String applyMatter;

    /*申请号*/
    /*申请号*/
	private java.lang.String applyNum;

    /*材料提交人*/
    /*材料提交人*/
	private java.lang.String materialPerson;

    /*材料提交人联系电话*/
    /*材料提交人联系电话*/
	private java.lang.String materialPersonPhone;

    /*材料提交人联系地址*/
    /*材料提交人联系地址*/
	private java.lang.String materialPersonAddress;

    /*收件人*/
    /*收件人*/
	private java.lang.String receivePerson;

    /*收件人联系电话*/
    /*收件人联系电话*/
	private java.lang.String receivePersonPhone;

    /*状态*/
    /*状态*/
	private java.lang.Integer status;

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
	private java.lang.String createUser;

    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updateTime;

    /*更新用户名*/
    /*更新用户名*/
	private java.lang.String updateUser;

    /*提交日期*/
    /*提交日期*/
	private java.sql.Timestamp submitDate;

    /*退回编号*/
    /*退回编号*/
	private java.lang.Integer backNum;

    /*受理编号*/
    /*受理编号*/
	private java.lang.String acceptCode;

    /*受理人*/
    /*受理人*/
	private java.lang.String acceptPerson;

    /*受理日期*/
    /*受理日期*/
	private java.sql.Timestamp acceptDate;

    /*受理意见*/
    /*受理意见*/
	private java.lang.String acceptOpinion;

    /*合同开工日期*/
    /*合同开工日期*/
	private java.sql.Date contractBeginDate;

    /*合同竣工日期*/
    /*合同竣工日期*/
	private java.sql.Date contractEndDate;

    /*中标价（万元）*/
    /*中标价（万元）*/
	private java.lang.Double zbPrice;

    /*建设工程类别ids*/
    /*建设工程类别ids*/
	private java.lang.String buildLbIds;

    /*补正退回材料*/
    /*补正退回材料*/
	private java.lang.String bzBackMaterial;

    /*项目投资估算（万元）*/
    /*项目投资估算（万元）*/
	private java.lang.Double projectPlanCost;

    /*施工单位*/
    /*施工单位*/
	private java.lang.String sgUnitName;

    /*监理单位*/
    /*监理单位*/
	private java.lang.String jlUnitName;

    /*设计单位*/
    /*设计单位*/
	private java.lang.String sjUnitName;


	// many to one
	private com.justonetech.system.domain.SysCodeDetail buildSx;
	private com.justonetech.system.domain.SysCodeDetail buildLb;
	private com.justonetech.system.domain.SysCodeDetail propertyType;
	private com.justonetech.system.domain.SysCodeDetail projectType;

	// collections
	private java.util.Set<com.justonetech.biz.domain.AreaHistoryOpinion> areaHistoryOpinions;
	private java.util.Set<com.justonetech.biz.domain.AreaSgMaterial> areaSgMaterials;
	private java.util.Set<com.justonetech.biz.domain.AreaPermitOperation> areaPermitOperations;
	private java.util.Set<com.justonetech.biz.domain.AreaProjPerson> areaProjPersons;
	private java.util.Set<com.justonetech.biz.domain.AreaPermitHdExtend> areaPermitHdExtends;
	private java.util.Set<com.justonetech.biz.domain.AreaSgUnitProj> areaSgUnitProjs;
	private java.util.Set<com.justonetech.biz.domain.AreaAuditOpinion> areaAuditOpinions;



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
	 * Return the value associated with the column: BIZ_CODE
	 */
	public java.lang.String getBizCode () {
		return bizCode;
	}

	/**
	 * Set the value related to the column: BIZ_CODE
	 * @param bizCode the BIZ_CODE value
	 */
	public void setBizCode (java.lang.String bizCode) {
		this.bizCode = bizCode;
	}


	/**
	 * Return the value associated with the column: YEAR
	 */
	public java.lang.Integer getYear () {
		return year;
	}

	/**
	 * Set the value related to the column: YEAR
	 * @param year the YEAR value
	 */
	public void setYear (java.lang.Integer year) {
		this.year = year;
	}


	/**
	 * Return the value associated with the column: AREA_CODE
	 */
	public java.lang.String getAreaCode () {
		return areaCode;
	}

	/**
	 * Set the value related to the column: AREA_CODE
	 * @param areaCode the AREA_CODE value
	 */
	public void setAreaCode (java.lang.String areaCode) {
		this.areaCode = areaCode;
	}


	/**
	 * Return the value associated with the column: AREA_NAME
	 */
	public java.lang.String getAreaName () {
		return areaName;
	}

	/**
	 * Set the value related to the column: AREA_NAME
	 * @param areaName the AREA_NAME value
	 */
	public void setAreaName (java.lang.String areaName) {
		this.areaName = areaName;
	}


	/**
	 * Return the value associated with the column: BJBH
	 */
	public java.lang.String getBjbh () {
		return bjbh;
	}

	/**
	 * Set the value related to the column: BJBH
	 * @param bjbh the BJBH value
	 */
	public void setBjbh (java.lang.String bjbh) {
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
	public java.lang.String getProjectName () {
		return projectName;
	}

	/**
	 * Set the value related to the column: PROJECT_NAME
	 * @param projectName the PROJECT_NAME value
	 */
	public void setProjectName (java.lang.String projectName) {
		this.projectName = projectName;
	}


	/**
	 * Return the value associated with the column: BUILD_NAME
	 */
	public java.lang.String getBuildName () {
		return buildName;
	}

	/**
	 * Set the value related to the column: BUILD_NAME
	 * @param buildName the BUILD_NAME value
	 */
	public void setBuildName (java.lang.String buildName) {
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


	/**
	 * Return the value associated with the column: HJG_YEAR
	 */
	public java.lang.Integer getHjgYear () {
		return hjgYear;
	}

	/**
	 * Set the value related to the column: HJG_YEAR
	 * @param hjgYear the HJG_YEAR value
	 */
	public void setHjgYear (java.lang.Integer hjgYear) {
		this.hjgYear = hjgYear;
	}


	/**
	 * Return the value associated with the column: HJG_NUM
	 */
	public java.lang.Integer getHjgNum () {
		return hjgNum;
	}

	/**
	 * Set the value related to the column: HJG_NUM
	 * @param hjgNum the HJG_NUM value
	 */
	public void setHjgNum (java.lang.Integer hjgNum) {
		this.hjgNum = hjgNum;
	}


	/**
	 * Return the value associated with the column: APPLY_PERSON
	 */
	public java.lang.String getApplyPerson () {
		return applyPerson;
	}

	/**
	 * Set the value related to the column: APPLY_PERSON
	 * @param applyPerson the APPLY_PERSON value
	 */
	public void setApplyPerson (java.lang.String applyPerson) {
		this.applyPerson = applyPerson;
	}


	/**
	 * Return the value associated with the column: APPLY_MATTER
	 */
	public java.lang.String getApplyMatter () {
		return applyMatter;
	}

	/**
	 * Set the value related to the column: APPLY_MATTER
	 * @param applyMatter the APPLY_MATTER value
	 */
	public void setApplyMatter (java.lang.String applyMatter) {
		this.applyMatter = applyMatter;
	}


	/**
	 * Return the value associated with the column: APPLY_NUM
	 */
	public java.lang.String getApplyNum () {
		return applyNum;
	}

	/**
	 * Set the value related to the column: APPLY_NUM
	 * @param applyNum the APPLY_NUM value
	 */
	public void setApplyNum (java.lang.String applyNum) {
		this.applyNum = applyNum;
	}


	/**
	 * Return the value associated with the column: MATERIAL_PERSON
	 */
	public java.lang.String getMaterialPerson () {
		return materialPerson;
	}

	/**
	 * Set the value related to the column: MATERIAL_PERSON
	 * @param materialPerson the MATERIAL_PERSON value
	 */
	public void setMaterialPerson (java.lang.String materialPerson) {
		this.materialPerson = materialPerson;
	}


	/**
	 * Return the value associated with the column: MATERIAL_PERSON_PHONE
	 */
	public java.lang.String getMaterialPersonPhone () {
		return materialPersonPhone;
	}

	/**
	 * Set the value related to the column: MATERIAL_PERSON_PHONE
	 * @param materialPersonPhone the MATERIAL_PERSON_PHONE value
	 */
	public void setMaterialPersonPhone (java.lang.String materialPersonPhone) {
		this.materialPersonPhone = materialPersonPhone;
	}


	/**
	 * Return the value associated with the column: MATERIAL_PERSON_ADDRESS
	 */
	public java.lang.String getMaterialPersonAddress () {
		return materialPersonAddress;
	}

	/**
	 * Set the value related to the column: MATERIAL_PERSON_ADDRESS
	 * @param materialPersonAddress the MATERIAL_PERSON_ADDRESS value
	 */
	public void setMaterialPersonAddress (java.lang.String materialPersonAddress) {
		this.materialPersonAddress = materialPersonAddress;
	}


	/**
	 * Return the value associated with the column: RECEIVE_PERSON
	 */
	public java.lang.String getReceivePerson () {
		return receivePerson;
	}

	/**
	 * Set the value related to the column: RECEIVE_PERSON
	 * @param receivePerson the RECEIVE_PERSON value
	 */
	public void setReceivePerson (java.lang.String receivePerson) {
		this.receivePerson = receivePerson;
	}


	/**
	 * Return the value associated with the column: RECEIVE_PERSON_PHONE
	 */
	public java.lang.String getReceivePersonPhone () {
		return receivePersonPhone;
	}

	/**
	 * Set the value related to the column: RECEIVE_PERSON_PHONE
	 * @param receivePersonPhone the RECEIVE_PERSON_PHONE value
	 */
	public void setReceivePersonPhone (java.lang.String receivePersonPhone) {
		this.receivePersonPhone = receivePersonPhone;
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
	 * Return the value associated with the column: CS_USER
	 */
	public java.lang.String getCsUser () {
		return csUser;
	}

	/**
	 * Set the value related to the column: CS_USER
	 * @param csUser the CS_USER value
	 */
	public void setCsUser (java.lang.String csUser) {
		this.csUser = csUser;
	}


	/**
	 * Return the value associated with the column: CS_DATE
	 */
	public java.sql.Timestamp getCsDate () {
		return csDate;
	}

	/**
	 * Set the value related to the column: CS_DATE
	 * @param csDate the CS_DATE value
	 */
	public void setCsDate (java.sql.Timestamp csDate) {
		this.csDate = csDate;
	}


	/**
	 * Return the value associated with the column: FH_OPINION
	 */
	public java.lang.String getFhOpinion () {
		return fhOpinion;
	}

	/**
	 * Set the value related to the column: FH_OPINION
	 * @param fhOpinion the FH_OPINION value
	 */
	public void setFhOpinion (java.lang.String fhOpinion) {
		this.fhOpinion = fhOpinion;
	}


	/**
	 * Return the value associated with the column: FH_USER
	 */
	public java.lang.String getFhUser () {
		return fhUser;
	}

	/**
	 * Set the value related to the column: FH_USER
	 * @param fhUser the FH_USER value
	 */
	public void setFhUser (java.lang.String fhUser) {
		this.fhUser = fhUser;
	}


	/**
	 * Return the value associated with the column: FH_DATE
	 */
	public java.sql.Timestamp getFhDate () {
		return fhDate;
	}

	/**
	 * Set the value related to the column: FH_DATE
	 * @param fhDate the FH_DATE value
	 */
	public void setFhDate (java.sql.Timestamp fhDate) {
		this.fhDate = fhDate;
	}


	/**
	 * Return the value associated with the column: SH_OPINION
	 */
	public java.lang.String getShOpinion () {
		return shOpinion;
	}

	/**
	 * Set the value related to the column: SH_OPINION
	 * @param shOpinion the SH_OPINION value
	 */
	public void setShOpinion (java.lang.String shOpinion) {
		this.shOpinion = shOpinion;
	}


	/**
	 * Return the value associated with the column: SH_USER
	 */
	public java.lang.String getShUser () {
		return shUser;
	}

	/**
	 * Set the value related to the column: SH_USER
	 * @param shUser the SH_USER value
	 */
	public void setShUser (java.lang.String shUser) {
		this.shUser = shUser;
	}


	/**
	 * Return the value associated with the column: SH_DATE
	 */
	public java.sql.Timestamp getShDate () {
		return shDate;
	}

	/**
	 * Set the value related to the column: SH_DATE
	 * @param shDate the SH_DATE value
	 */
	public void setShDate (java.sql.Timestamp shDate) {
		this.shDate = shDate;
	}


	/**
	 * Return the value associated with the column: FGLD_OPINION
	 */
	public java.lang.String getFgldOpinion () {
		return fgldOpinion;
	}

	/**
	 * Set the value related to the column: FGLD_OPINION
	 * @param fgldOpinion the FGLD_OPINION value
	 */
	public void setFgldOpinion (java.lang.String fgldOpinion) {
		this.fgldOpinion = fgldOpinion;
	}


	/**
	 * Return the value associated with the column: FGLD_USER
	 */
	public java.lang.String getFgldUser () {
		return fgldUser;
	}

	/**
	 * Set the value related to the column: FGLD_USER
	 * @param fgldUser the FGLD_USER value
	 */
	public void setFgldUser (java.lang.String fgldUser) {
		this.fgldUser = fgldUser;
	}


	/**
	 * Return the value associated with the column: FGLD_DATE
	 */
	public java.sql.Timestamp getFgldDate () {
		return fgldDate;
	}

	/**
	 * Set the value related to the column: FGLD_DATE
	 * @param fgldDate the FGLD_DATE value
	 */
	public void setFgldDate (java.sql.Timestamp fgldDate) {
		this.fgldDate = fgldDate;
	}


	/**
	 * Return the value associated with the column: ZXLD_OPINION
	 */
	public java.lang.String getZxldOpinion () {
		return zxldOpinion;
	}

	/**
	 * Set the value related to the column: ZXLD_OPINION
	 * @param zxldOpinion the ZXLD_OPINION value
	 */
	public void setZxldOpinion (java.lang.String zxldOpinion) {
		this.zxldOpinion = zxldOpinion;
	}


	/**
	 * Return the value associated with the column: ZXLD_USER
	 */
	public java.lang.String getZxldUser () {
		return zxldUser;
	}

	/**
	 * Set the value related to the column: ZXLD_USER
	 * @param zxldUser the ZXLD_USER value
	 */
	public void setZxldUser (java.lang.String zxldUser) {
		this.zxldUser = zxldUser;
	}


	/**
	 * Return the value associated with the column: ZXLD_DATE
	 */
	public java.sql.Timestamp getZxldDate () {
		return zxldDate;
	}

	/**
	 * Set the value related to the column: ZXLD_DATE
	 * @param zxldDate the ZXLD_DATE value
	 */
	public void setZxldDate (java.sql.Timestamp zxldDate) {
		this.zxldDate = zxldDate;
	}


	/**
	 * Return the value associated with the column: JSC_OPINION
	 */
	public java.lang.String getJscOpinion () {
		return jscOpinion;
	}

	/**
	 * Set the value related to the column: JSC_OPINION
	 * @param jscOpinion the JSC_OPINION value
	 */
	public void setJscOpinion (java.lang.String jscOpinion) {
		this.jscOpinion = jscOpinion;
	}


	/**
	 * Return the value associated with the column: JSC_USER
	 */
	public java.lang.String getJscUser () {
		return jscUser;
	}

	/**
	 * Set the value related to the column: JSC_USER
	 * @param jscUser the JSC_USER value
	 */
	public void setJscUser (java.lang.String jscUser) {
		this.jscUser = jscUser;
	}


	/**
	 * Return the value associated with the column: JSC_DATE
	 */
	public java.sql.Timestamp getJscDate () {
		return jscDate;
	}

	/**
	 * Set the value related to the column: JSC_DATE
	 * @param jscDate the JSC_DATE value
	 */
	public void setJscDate (java.sql.Timestamp jscDate) {
		this.jscDate = jscDate;
	}


	/**
	 * Return the value associated with the column: SPC_OPINION
	 */
	public java.lang.String getSpcOpinion () {
		return spcOpinion;
	}

	/**
	 * Set the value related to the column: SPC_OPINION
	 * @param spcOpinion the SPC_OPINION value
	 */
	public void setSpcOpinion (java.lang.String spcOpinion) {
		this.spcOpinion = spcOpinion;
	}


	/**
	 * Return the value associated with the column: SPC_USER
	 */
	public java.lang.String getSpcUser () {
		return spcUser;
	}

	/**
	 * Set the value related to the column: SPC_USER
	 * @param spcUser the SPC_USER value
	 */
	public void setSpcUser (java.lang.String spcUser) {
		this.spcUser = spcUser;
	}


	/**
	 * Return the value associated with the column: SPC_DATE
	 */
	public java.sql.Timestamp getSpcDate () {
		return spcDate;
	}

	/**
	 * Set the value related to the column: SPC_DATE
	 * @param spcDate the SPC_DATE value
	 */
	public void setSpcDate (java.sql.Timestamp spcDate) {
		this.spcDate = spcDate;
	}


	/**
	 * Return the value associated with the column: WLD_OPINION
	 */
	public java.lang.String getWldOpinion () {
		return wldOpinion;
	}

	/**
	 * Set the value related to the column: WLD_OPINION
	 * @param wldOpinion the WLD_OPINION value
	 */
	public void setWldOpinion (java.lang.String wldOpinion) {
		this.wldOpinion = wldOpinion;
	}


	/**
	 * Return the value associated with the column: WLD_USER
	 */
	public java.lang.String getWldUser () {
		return wldUser;
	}

	/**
	 * Set the value related to the column: WLD_USER
	 * @param wldUser the WLD_USER value
	 */
	public void setWldUser (java.lang.String wldUser) {
		this.wldUser = wldUser;
	}


	/**
	 * Return the value associated with the column: WLD_DATE
	 */
	public java.sql.Timestamp getWldDate () {
		return wldDate;
	}

	/**
	 * Set the value related to the column: WLD_DATE
	 * @param wldDate the WLD_DATE value
	 */
	public void setWldDate (java.sql.Timestamp wldDate) {
		this.wldDate = wldDate;
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
	 * Return the value associated with the column: SUBMIT_DATE
	 */
	public java.sql.Timestamp getSubmitDate () {
		return submitDate;
	}

	/**
	 * Set the value related to the column: SUBMIT_DATE
	 * @param submitDate the SUBMIT_DATE value
	 */
	public void setSubmitDate (java.sql.Timestamp submitDate) {
		this.submitDate = submitDate;
	}


	/**
	 * Return the value associated with the column: BACK_NUM
	 */
	public java.lang.Integer getBackNum () {
		return backNum;
	}

	/**
	 * Set the value related to the column: BACK_NUM
	 * @param backNum the BACK_NUM value
	 */
	public void setBackNum (java.lang.Integer backNum) {
		this.backNum = backNum;
	}


	/**
	 * Return the value associated with the column: ACCEPT_CODE
	 */
	public java.lang.String getAcceptCode () {
		return acceptCode;
	}

	/**
	 * Set the value related to the column: ACCEPT_CODE
	 * @param acceptCode the ACCEPT_CODE value
	 */
	public void setAcceptCode (java.lang.String acceptCode) {
		this.acceptCode = acceptCode;
	}


	/**
	 * Return the value associated with the column: ACCEPT_PERSON
	 */
	public java.lang.String getAcceptPerson () {
		return acceptPerson;
	}

	/**
	 * Set the value related to the column: ACCEPT_PERSON
	 * @param acceptPerson the ACCEPT_PERSON value
	 */
	public void setAcceptPerson (java.lang.String acceptPerson) {
		this.acceptPerson = acceptPerson;
	}


	/**
	 * Return the value associated with the column: ACCEPT_DATE
	 */
	public java.sql.Timestamp getAcceptDate () {
		return acceptDate;
	}

	/**
	 * Set the value related to the column: ACCEPT_DATE
	 * @param acceptDate the ACCEPT_DATE value
	 */
	public void setAcceptDate (java.sql.Timestamp acceptDate) {
		this.acceptDate = acceptDate;
	}


	/**
	 * Return the value associated with the column: ACCEPT_OPINION
	 */
	public java.lang.String getAcceptOpinion () {
		return acceptOpinion;
	}

	/**
	 * Set the value related to the column: ACCEPT_OPINION
	 * @param acceptOpinion the ACCEPT_OPINION value
	 */
	public void setAcceptOpinion (java.lang.String acceptOpinion) {
		this.acceptOpinion = acceptOpinion;
	}


	/**
	 * Return the value associated with the column: CONTRACT_BEGIN_DATE
	 */
	public java.sql.Date getContractBeginDate () {
		return contractBeginDate;
	}

	/**
	 * Set the value related to the column: CONTRACT_BEGIN_DATE
	 * @param contractBeginDate the CONTRACT_BEGIN_DATE value
	 */
	public void setContractBeginDate (java.sql.Date contractBeginDate) {
		this.contractBeginDate = contractBeginDate;
	}


	/**
	 * Return the value associated with the column: CONTRACT_END_DATE
	 */
	public java.sql.Date getContractEndDate () {
		return contractEndDate;
	}

	/**
	 * Set the value related to the column: CONTRACT_END_DATE
	 * @param contractEndDate the CONTRACT_END_DATE value
	 */
	public void setContractEndDate (java.sql.Date contractEndDate) {
		this.contractEndDate = contractEndDate;
	}


	/**
	 * Return the value associated with the column: ZB_PRICE
	 */
	public java.lang.Double getZbPrice () {
		return zbPrice;
	}

	/**
	 * Set the value related to the column: ZB_PRICE
	 * @param zbPrice the ZB_PRICE value
	 */
	public void setZbPrice (java.lang.Double zbPrice) {
		this.zbPrice = zbPrice;
	}


	/**
	 * Return the value associated with the column: BUILD_LB_IDS
	 */
	public java.lang.String getBuildLbIds () {
		return buildLbIds;
	}

	/**
	 * Set the value related to the column: BUILD_LB_IDS
	 * @param buildLbIds the BUILD_LB_IDS value
	 */
	public void setBuildLbIds (java.lang.String buildLbIds) {
		this.buildLbIds = buildLbIds;
	}


	/**
	 * Return the value associated with the column: BZ_BACK_MATERIAL
	 */
	public java.lang.String getBzBackMaterial () {
		return bzBackMaterial;
	}

	/**
	 * Set the value related to the column: BZ_BACK_MATERIAL
	 * @param bzBackMaterial the BZ_BACK_MATERIAL value
	 */
	public void setBzBackMaterial (java.lang.String bzBackMaterial) {
		this.bzBackMaterial = bzBackMaterial;
	}


	/**
	 * Return the value associated with the column: PROJECT_PLAN_COST
	 */
	public java.lang.Double getProjectPlanCost () {
		return projectPlanCost;
	}

	/**
	 * Set the value related to the column: PROJECT_PLAN_COST
	 * @param projectPlanCost the PROJECT_PLAN_COST value
	 */
	public void setProjectPlanCost (java.lang.Double projectPlanCost) {
		this.projectPlanCost = projectPlanCost;
	}


	/**
	 * Return the value associated with the column: SG_UNIT_NAME
	 */
	public java.lang.String getSgUnitName () {
		return sgUnitName;
	}

	/**
	 * Set the value related to the column: SG_UNIT_NAME
	 * @param sgUnitName the SG_UNIT_NAME value
	 */
	public void setSgUnitName (java.lang.String sgUnitName) {
		this.sgUnitName = sgUnitName;
	}


	/**
	 * Return the value associated with the column: JL_UNIT_NAME
	 */
	public java.lang.String getJlUnitName () {
		return jlUnitName;
	}

	/**
	 * Set the value related to the column: JL_UNIT_NAME
	 * @param jlUnitName the JL_UNIT_NAME value
	 */
	public void setJlUnitName (java.lang.String jlUnitName) {
		this.jlUnitName = jlUnitName;
	}


	/**
	 * Return the value associated with the column: SJ_UNIT_NAME
	 */
	public java.lang.String getSjUnitName () {
		return sjUnitName;
	}

	/**
	 * Set the value related to the column: SJ_UNIT_NAME
	 * @param sjUnitName the SJ_UNIT_NAME value
	 */
	public void setSjUnitName (java.lang.String sjUnitName) {
		this.sjUnitName = sjUnitName;
	}


	/**
	 * Return the value associated with the column: BUILD_SX_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getBuildSx () {
		return buildSx;
	}

	/**
	 * Set the value related to the column: BUILD_SX_ID
	 * @param buildSx the BUILD_SX_ID value
	 */
	public void setBuildSx (com.justonetech.system.domain.SysCodeDetail buildSx) {
		this.buildSx = buildSx;
	}


	/**
	 * Return the value associated with the column: BUILD_LB_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getBuildLb () {
		return buildLb;
	}

	/**
	 * Set the value related to the column: BUILD_LB_ID
	 * @param buildLb the BUILD_LB_ID value
	 */
	public void setBuildLb (com.justonetech.system.domain.SysCodeDetail buildLb) {
		this.buildLb = buildLb;
	}


	/**
	 * Return the value associated with the column: PROPERTY_TYPE_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getPropertyType () {
		return propertyType;
	}

	/**
	 * Set the value related to the column: PROPERTY_TYPE_ID
	 * @param propertyType the PROPERTY_TYPE_ID value
	 */
	public void setPropertyType (com.justonetech.system.domain.SysCodeDetail propertyType) {
		this.propertyType = propertyType;
	}


	/**
	 * Return the value associated with the column: PROJECT_TYPE_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getProjectType () {
		return projectType;
	}

	/**
	 * Set the value related to the column: PROJECT_TYPE_ID
	 * @param projectType the PROJECT_TYPE_ID value
	 */
	public void setProjectType (com.justonetech.system.domain.SysCodeDetail projectType) {
		this.projectType = projectType;
	}


	/**
	 * Return the value associated with the column: areaHistoryOpinions
	 */
	public java.util.Set<com.justonetech.biz.domain.AreaHistoryOpinion> getAreaHistoryOpinions () {
		if(areaHistoryOpinions == null){
			areaHistoryOpinions = new java.util.LinkedHashSet<com.justonetech.biz.domain.AreaHistoryOpinion>();
		}
		return areaHistoryOpinions;
	}

	/**
	 * Set the value related to the column: areaHistoryOpinions
	 * @param areaHistoryOpinions the areaHistoryOpinions value
	 */
	public void setAreaHistoryOpinions (java.util.Set<com.justonetech.biz.domain.AreaHistoryOpinion> areaHistoryOpinions) {
		this.areaHistoryOpinions = areaHistoryOpinions;
	}

	public void addToareaHistoryOpinions (com.justonetech.biz.domain.AreaHistoryOpinion areaHistoryOpinion) {
		if (null == getAreaHistoryOpinions()) setAreaHistoryOpinions(new java.util.LinkedHashSet<com.justonetech.biz.domain.AreaHistoryOpinion>());
		getAreaHistoryOpinions().add(areaHistoryOpinion);
	}


	/**
	 * Return the value associated with the column: areaSgMaterials
	 */
	public java.util.Set<com.justonetech.biz.domain.AreaSgMaterial> getAreaSgMaterials () {
		if(areaSgMaterials == null){
			areaSgMaterials = new java.util.LinkedHashSet<com.justonetech.biz.domain.AreaSgMaterial>();
		}
		return areaSgMaterials;
	}

	/**
	 * Set the value related to the column: areaSgMaterials
	 * @param areaSgMaterials the areaSgMaterials value
	 */
	public void setAreaSgMaterials (java.util.Set<com.justonetech.biz.domain.AreaSgMaterial> areaSgMaterials) {
		this.areaSgMaterials = areaSgMaterials;
	}

	public void addToareaSgMaterials (com.justonetech.biz.domain.AreaSgMaterial areaSgMaterial) {
		if (null == getAreaSgMaterials()) setAreaSgMaterials(new java.util.LinkedHashSet<com.justonetech.biz.domain.AreaSgMaterial>());
		getAreaSgMaterials().add(areaSgMaterial);
	}


	/**
	 * Return the value associated with the column: areaPermitOperations
	 */
	public java.util.Set<com.justonetech.biz.domain.AreaPermitOperation> getAreaPermitOperations () {
		if(areaPermitOperations == null){
			areaPermitOperations = new java.util.LinkedHashSet<com.justonetech.biz.domain.AreaPermitOperation>();
		}
		return areaPermitOperations;
	}

	/**
	 * Set the value related to the column: areaPermitOperations
	 * @param areaPermitOperations the areaPermitOperations value
	 */
	public void setAreaPermitOperations (java.util.Set<com.justonetech.biz.domain.AreaPermitOperation> areaPermitOperations) {
		this.areaPermitOperations = areaPermitOperations;
	}

	public void addToareaPermitOperations (com.justonetech.biz.domain.AreaPermitOperation areaPermitOperation) {
		if (null == getAreaPermitOperations()) setAreaPermitOperations(new java.util.LinkedHashSet<com.justonetech.biz.domain.AreaPermitOperation>());
		getAreaPermitOperations().add(areaPermitOperation);
	}


	/**
	 * Return the value associated with the column: areaProjPersons
	 */
	public java.util.Set<com.justonetech.biz.domain.AreaProjPerson> getAreaProjPersons () {
		if(areaProjPersons == null){
			areaProjPersons = new java.util.LinkedHashSet<com.justonetech.biz.domain.AreaProjPerson>();
		}
		return areaProjPersons;
	}

	/**
	 * Set the value related to the column: areaProjPersons
	 * @param areaProjPersons the areaProjPersons value
	 */
	public void setAreaProjPersons (java.util.Set<com.justonetech.biz.domain.AreaProjPerson> areaProjPersons) {
		this.areaProjPersons = areaProjPersons;
	}

	public void addToareaProjPersons (com.justonetech.biz.domain.AreaProjPerson areaProjPerson) {
		if (null == getAreaProjPersons()) setAreaProjPersons(new java.util.LinkedHashSet<com.justonetech.biz.domain.AreaProjPerson>());
		getAreaProjPersons().add(areaProjPerson);
	}


	/**
	 * Return the value associated with the column: areaPermitHdExtends
	 */
	public java.util.Set<com.justonetech.biz.domain.AreaPermitHdExtend> getAreaPermitHdExtends () {
		if(areaPermitHdExtends == null){
			areaPermitHdExtends = new java.util.LinkedHashSet<com.justonetech.biz.domain.AreaPermitHdExtend>();
		}
		return areaPermitHdExtends;
	}

	/**
	 * Set the value related to the column: areaPermitHdExtends
	 * @param areaPermitHdExtends the areaPermitHdExtends value
	 */
	public void setAreaPermitHdExtends (java.util.Set<com.justonetech.biz.domain.AreaPermitHdExtend> areaPermitHdExtends) {
		this.areaPermitHdExtends = areaPermitHdExtends;
	}

	public void addToareaPermitHdExtends (com.justonetech.biz.domain.AreaPermitHdExtend areaPermitHdExtend) {
		if (null == getAreaPermitHdExtends()) setAreaPermitHdExtends(new java.util.LinkedHashSet<com.justonetech.biz.domain.AreaPermitHdExtend>());
		getAreaPermitHdExtends().add(areaPermitHdExtend);
	}


	/**
	 * Return the value associated with the column: areaSgUnitProjs
	 */
	public java.util.Set<com.justonetech.biz.domain.AreaSgUnitProj> getAreaSgUnitProjs () {
		if(areaSgUnitProjs == null){
			areaSgUnitProjs = new java.util.LinkedHashSet<com.justonetech.biz.domain.AreaSgUnitProj>();
		}
		return areaSgUnitProjs;
	}

	/**
	 * Set the value related to the column: areaSgUnitProjs
	 * @param areaSgUnitProjs the areaSgUnitProjs value
	 */
	public void setAreaSgUnitProjs (java.util.Set<com.justonetech.biz.domain.AreaSgUnitProj> areaSgUnitProjs) {
		this.areaSgUnitProjs = areaSgUnitProjs;
	}

	public void addToareaSgUnitProjs (com.justonetech.biz.domain.AreaSgUnitProj areaSgUnitProj) {
		if (null == getAreaSgUnitProjs()) setAreaSgUnitProjs(new java.util.LinkedHashSet<com.justonetech.biz.domain.AreaSgUnitProj>());
		getAreaSgUnitProjs().add(areaSgUnitProj);
	}


	/**
	 * Return the value associated with the column: areaAuditOpinions
	 */
	public java.util.Set<com.justonetech.biz.domain.AreaAuditOpinion> getAreaAuditOpinions () {
		if(areaAuditOpinions == null){
			areaAuditOpinions = new java.util.LinkedHashSet<com.justonetech.biz.domain.AreaAuditOpinion>();
		}
		return areaAuditOpinions;
	}

	/**
	 * Set the value related to the column: areaAuditOpinions
	 * @param areaAuditOpinions the areaAuditOpinions value
	 */
	public void setAreaAuditOpinions (java.util.Set<com.justonetech.biz.domain.AreaAuditOpinion> areaAuditOpinions) {
		this.areaAuditOpinions = areaAuditOpinions;
	}

	public void addToareaAuditOpinions (com.justonetech.biz.domain.AreaAuditOpinion areaAuditOpinion) {
		if (null == getAreaAuditOpinions()) setAreaAuditOpinions(new java.util.LinkedHashSet<com.justonetech.biz.domain.AreaAuditOpinion>());
		getAreaAuditOpinions().add(areaAuditOpinion);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.AreaSgPermit)) return false;
		else {
			com.justonetech.biz.domain.AreaSgPermit areaSgPermit = (com.justonetech.biz.domain.AreaSgPermit) obj;
			if (null == this.getId() || null == areaSgPermit.getId()) return false;
			else return (this.getId().equals(areaSgPermit.getId()));
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
		builder.append(bizCode);
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
		builder.append(jscOpinion);
		builder.append(jscUser);
		builder.append(jscDate);
		builder.append(spcOpinion);
		builder.append(spcUser);
		builder.append(spcDate);
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
		builder.append(acceptPerson);
		builder.append(acceptDate);
		builder.append(acceptOpinion);
		builder.append(contractBeginDate);
		builder.append(contractEndDate);
		builder.append(zbPrice);
		builder.append(buildLbIds);
		builder.append(bzBackMaterial);
		builder.append(projectPlanCost);
		builder.append(sgUnitName);
		builder.append(jlUnitName);
		builder.append(sjUnitName);
		return builder.toString();
	}


}
