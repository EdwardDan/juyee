package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


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
 * @hibernate.class
 *  table="SG_PERMIT"
 */

public abstract class BaseSgPermit  implements  Serializable, Auditable {

	public static String REF = "SgPermit";
	public static String PROP_RECEIVE_PERSON_PHONE = "receivePersonPhone";
	public static String PROP_CS_OPINION = "csOpinion";
	public static String PROP_FGLD_OPINION = "fgldOpinion";
	public static String PROP_PROJECT_TYPE = "projectType";
	public static String PROP_MATERIAL_PERSON = "materialPerson";
	public static String PROP_YEAR = "year";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_BJBH = "bjbh";
	public static String PROP_SH_OPINION = "shOpinion";
	public static String PROP_HJG_NUM = "hjgNum";
	public static String PROP_APPLY_NUM = "applyNum";
	public static String PROP_FH_OPINION = "fhOpinion";
	public static String PROP_UPDATE_USER = "updateUser";
	public static String PROP_ZXLD_OPINION = "zxldOpinion";
	public static String PROP_PROJECT_NAME = "projectName";
	public static String PROP_MATERIAL_PERSON_ADDRESS = "materialPersonAddress";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_BUILD_NAME = "buildName";
	public static String PROP_RECEIVE_PERSON = "receivePerson";
	public static String PROP_APPLY_MATTER = "applyMatter";
	public static String PROP_STATUS = "status";
	public static String PROP_APPLY_PERSON = "applyPerson";
	public static String PROP_HJG_YEAR = "hjgYear";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_ID = "id";
	public static String PROP_MATERIAL_PERSON_PHONE = "materialPersonPhone";


	// constructors
	public BaseSgPermit () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSgPermit (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



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
	private String csOpinion;
	
    /*复核意见*/
    /*复核意见*/
	private String fhOpinion;
	
    /*审核意见*/
    /*审核意见*/
	private String shOpinion;
	
    /*分管领导审核意见*/
    /*分管领导审核意见*/
	private String fgldOpinion;
	
    /*中心领导审核意见*/
    /*中心领导审核意见*/
	private String zxldOpinion;
	
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



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="com.justonetech.core.orm.hibernate.LongIdGenerator"
     *  column="ID"
     */
	public Long getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 * @deprecated
	 */
	public void setId (Long id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: YEAR
	 */
	public Integer getYear () {
		return year;
	}

	/**
	 * Set the value related to the column: YEAR
	 * @param year the YEAR value
	 */
	public void setYear (Integer year) {
		this.year = year;
	}


	/**
	 * Return the value associated with the column: BJBH
	 */
	public String getBjbh () {
		return bjbh;
	}

	/**
	 * Set the value related to the column: BJBH
	 * @param bjbh the BJBH value
	 */
	public void setBjbh (String bjbh) {
		this.bjbh = bjbh;
	}


	/**
	 * Return the value associated with the column: PROJECT_NAME
	 */
	public String getProjectName () {
		return projectName;
	}

	/**
	 * Set the value related to the column: PROJECT_NAME
	 * @param projectName the PROJECT_NAME value
	 */
	public void setProjectName (String projectName) {
		this.projectName = projectName;
	}


	/**
	 * Return the value associated with the column: BUILD_NAME
	 */
	public String getBuildName () {
		return buildName;
	}

	/**
	 * Set the value related to the column: BUILD_NAME
	 * @param buildName the BUILD_NAME value
	 */
	public void setBuildName (String buildName) {
		this.buildName = buildName;
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
	public String getApplyPerson () {
		return applyPerson;
	}

	/**
	 * Set the value related to the column: APPLY_PERSON
	 * @param applyPerson the APPLY_PERSON value
	 */
	public void setApplyPerson (String applyPerson) {
		this.applyPerson = applyPerson;
	}


	/**
	 * Return the value associated with the column: APPLY_MATTER
	 */
	public String getApplyMatter () {
		return applyMatter;
	}

	/**
	 * Set the value related to the column: APPLY_MATTER
	 * @param applyMatter the APPLY_MATTER value
	 */
	public void setApplyMatter (String applyMatter) {
		this.applyMatter = applyMatter;
	}


	/**
	 * Return the value associated with the column: APPLY_NUM
	 */
	public String getApplyNum () {
		return applyNum;
	}

	/**
	 * Set the value related to the column: APPLY_NUM
	 * @param applyNum the APPLY_NUM value
	 */
	public void setApplyNum (String applyNum) {
		this.applyNum = applyNum;
	}


	/**
	 * Return the value associated with the column: MATERIAL_PERSON
	 */
	public String getMaterialPerson () {
		return materialPerson;
	}

	/**
	 * Set the value related to the column: MATERIAL_PERSON
	 * @param materialPerson the MATERIAL_PERSON value
	 */
	public void setMaterialPerson (String materialPerson) {
		this.materialPerson = materialPerson;
	}


	/**
	 * Return the value associated with the column: MATERIAL_PERSON_PHONE
	 */
	public String getMaterialPersonPhone () {
		return materialPersonPhone;
	}

	/**
	 * Set the value related to the column: MATERIAL_PERSON_PHONE
	 * @param materialPersonPhone the MATERIAL_PERSON_PHONE value
	 */
	public void setMaterialPersonPhone (String materialPersonPhone) {
		this.materialPersonPhone = materialPersonPhone;
	}


	/**
	 * Return the value associated with the column: MATERIAL_PERSON_ADDRESS
	 */
	public String getMaterialPersonAddress () {
		return materialPersonAddress;
	}

	/**
	 * Set the value related to the column: MATERIAL_PERSON_ADDRESS
	 * @param materialPersonAddress the MATERIAL_PERSON_ADDRESS value
	 */
	public void setMaterialPersonAddress (String materialPersonAddress) {
		this.materialPersonAddress = materialPersonAddress;
	}


	/**
	 * Return the value associated with the column: RECEIVE_PERSON
	 */
	public String getReceivePerson () {
		return receivePerson;
	}

	/**
	 * Set the value related to the column: RECEIVE_PERSON
	 * @param receivePerson the RECEIVE_PERSON value
	 */
	public void setReceivePerson (String receivePerson) {
		this.receivePerson = receivePerson;
	}


	/**
	 * Return the value associated with the column: RECEIVE_PERSON_PHONE
	 */
	public String getReceivePersonPhone () {
		return receivePersonPhone;
	}

	/**
	 * Set the value related to the column: RECEIVE_PERSON_PHONE
	 * @param receivePersonPhone the RECEIVE_PERSON_PHONE value
	 */
	public void setReceivePersonPhone (String receivePersonPhone) {
		this.receivePersonPhone = receivePersonPhone;
	}


	/**
	 * Return the value associated with the column: STATUS
	 */
	public Integer getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (Integer status) {
		this.status = status;
	}


	/**
	 * Return the value associated with the column: CS_OPINION
	 */
	public String getCsOpinion () {
		return csOpinion;
	}

	/**
	 * Set the value related to the column: CS_OPINION
	 * @param csOpinion the CS_OPINION value
	 */
	public void setCsOpinion (String csOpinion) {
		this.csOpinion = csOpinion;
	}


	/**
	 * Return the value associated with the column: FH_OPINION
	 */
	public String getFhOpinion () {
		return fhOpinion;
	}

	/**
	 * Set the value related to the column: FH_OPINION
	 * @param fhOpinion the FH_OPINION value
	 */
	public void setFhOpinion (String fhOpinion) {
		this.fhOpinion = fhOpinion;
	}


	/**
	 * Return the value associated with the column: SH_OPINION
	 */
	public String getShOpinion () {
		return shOpinion;
	}

	/**
	 * Set the value related to the column: SH_OPINION
	 * @param shOpinion the SH_OPINION value
	 */
	public void setShOpinion (String shOpinion) {
		this.shOpinion = shOpinion;
	}


	/**
	 * Return the value associated with the column: FGLD_OPINION
	 */
	public String getFgldOpinion () {
		return fgldOpinion;
	}

	/**
	 * Set the value related to the column: FGLD_OPINION
	 * @param fgldOpinion the FGLD_OPINION value
	 */
	public void setFgldOpinion (String fgldOpinion) {
		this.fgldOpinion = fgldOpinion;
	}


	/**
	 * Return the value associated with the column: ZXLD_OPINION
	 */
	public String getZxldOpinion () {
		return zxldOpinion;
	}

	/**
	 * Set the value related to the column: ZXLD_OPINION
	 * @param zxldOpinion the ZXLD_OPINION value
	 */
	public void setZxldOpinion (String zxldOpinion) {
		this.zxldOpinion = zxldOpinion;
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
	public String getCreateUser () {
		return createUser;
	}

	/**
	 * Set the value related to the column: CREATE_USER
	 * @param createUser the CREATE_USER value
	 */
	public void setCreateUser (String createUser) {
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
	public String getUpdateUser () {
		return updateUser;
	}

	/**
	 * Set the value related to the column: UPDATE_USER
	 * @param updateUser the UPDATE_USER value
	 */
	public void setUpdateUser (String updateUser) {
		this.updateUser = updateUser;
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
	 * Return the value associated with the column: sgPermitOperations
	 */
	public java.util.Set<com.justonetech.biz.domain.SgPermitOperation> getSgPermitOperations () {
		if(sgPermitOperations == null){
			sgPermitOperations = new java.util.LinkedHashSet<com.justonetech.biz.domain.SgPermitOperation>();
		}
		return sgPermitOperations;
	}

	/**
	 * Set the value related to the column: sgPermitOperations
	 * @param sgPermitOperations the sgPermitOperations value
	 */
	public void setSgPermitOperations (java.util.Set<com.justonetech.biz.domain.SgPermitOperation> sgPermitOperations) {
		this.sgPermitOperations = sgPermitOperations;
	}

	public void addTosgPermitOperations (com.justonetech.biz.domain.SgPermitOperation sgPermitOperation) {
		if (null == getSgPermitOperations()) setSgPermitOperations(new java.util.LinkedHashSet<com.justonetech.biz.domain.SgPermitOperation>());
		getSgPermitOperations().add(sgPermitOperation);
	}


	/**
	 * Return the value associated with the column: sgAuditOpinions
	 */
	public java.util.Set<com.justonetech.biz.domain.SgAuditOpinion> getSgAuditOpinions () {
		if(sgAuditOpinions == null){
			sgAuditOpinions = new java.util.LinkedHashSet<com.justonetech.biz.domain.SgAuditOpinion>();
		}
		return sgAuditOpinions;
	}

	/**
	 * Set the value related to the column: sgAuditOpinions
	 * @param sgAuditOpinions the sgAuditOpinions value
	 */
	public void setSgAuditOpinions (java.util.Set<com.justonetech.biz.domain.SgAuditOpinion> sgAuditOpinions) {
		this.sgAuditOpinions = sgAuditOpinions;
	}

	public void addTosgAuditOpinions (com.justonetech.biz.domain.SgAuditOpinion sgAuditOpinion) {
		if (null == getSgAuditOpinions()) setSgAuditOpinions(new java.util.LinkedHashSet<com.justonetech.biz.domain.SgAuditOpinion>());
		getSgAuditOpinions().add(sgAuditOpinion);
	}


	/**
	 * Return the value associated with the column: sgMaterials
	 */
	public java.util.Set<com.justonetech.biz.domain.SgMaterial> getSgMaterials () {
		if(sgMaterials == null){
			sgMaterials = new java.util.LinkedHashSet<com.justonetech.biz.domain.SgMaterial>();
		}
		return sgMaterials;
	}

	/**
	 * Set the value related to the column: sgMaterials
	 * @param sgMaterials the sgMaterials value
	 */
	public void setSgMaterials (java.util.Set<com.justonetech.biz.domain.SgMaterial> sgMaterials) {
		this.sgMaterials = sgMaterials;
	}

	public void addTosgMaterials (com.justonetech.biz.domain.SgMaterial sgMaterial) {
		if (null == getSgMaterials()) setSgMaterials(new java.util.LinkedHashSet<com.justonetech.biz.domain.SgMaterial>());
		getSgMaterials().add(sgMaterial);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.SgPermit)) return false;
		else {
			com.justonetech.biz.domain.SgPermit sgPermit = (com.justonetech.biz.domain.SgPermit) obj;
			if (null == this.getId() || null == sgPermit.getId()) return false;
			else return (this.getId().equals(sgPermit.getId()));
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
		builder.append(year);
		builder.append(bjbh);
		builder.append(projectName);
		builder.append(buildName);
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
		builder.append(fhOpinion);
		builder.append(shOpinion);
		builder.append(fgldOpinion);
		builder.append(zxldOpinion);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}