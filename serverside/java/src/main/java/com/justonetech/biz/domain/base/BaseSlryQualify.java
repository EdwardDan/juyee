package com.justonetech.biz.domain.base;

import com.justonetech.biz.domain.DocDocument;

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
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_DOC_EDUCATION = "docEducation";
	public static String PROP_ID_CARD = "idCard";
	public static String PROP_BIRTH_DATE = "birthDate";
	public static String PROP_UNIT_TYPE = "unitType";
	public static String PROP_DOC_PHOTO = "docPhoto";
	public static String PROP_DOC_CARD = "docCard";
	public static String PROP_NAME = "name";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_APPLY_CER_TYPE = "applyCerType";
	public static String PROP_EDUCATION_TYPE = "educationType";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_ID = "id";
	public static String PROP_APPLY_TYPE = "applyType";
	public static String PROP_TECH_TYPE = "techType";
	public static String PROP_SEX = "sex";
	public static String PROP_UPDATE_USER = "updateUser";
	public static String PROP_STATUS = "status";
	public static String PROP_CS_OPINION = "csOpinion";


	// constructors
	public BaseSlryQualify () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSlryQualify (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*企业名称*/
    /*企业名称*/
	private Long unitName;
	
    /*备注*/
    /*备注*/
	private String description;
	
    /*姓名*/
    /*姓名*/
	private Integer name;
	
    /*性别*/
    /*性别*/
	private Boolean sex;
	
    /*出生日期*/
    /*出生日期*/
	private java.sql.Date birthDate;
	
    /*证件号码*/
    /*证件号码*/
	private String idCard;

	/*状态*/
    /*状态*/
	private Integer status;

	private String csOpinion;

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
	private com.justonetech.system.domain.SysCodeDetail applyCerType;
	private com.justonetech.system.domain.SysCodeDetail techType;
	private com.justonetech.system.domain.SysCodeDetail unitType;
	private com.justonetech.biz.domain.DocDocument docCard;
	private com.justonetech.system.domain.SysCodeDetail applyType;
	private com.justonetech.system.domain.SysCodeDetail educationType;
	private com.justonetech.biz.domain.DocDocument docEducation;
	private com.justonetech.biz.domain.DocDocument docPhoto;
	private com.justonetech.biz.domain.DocDocument docContract;



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
	 * Return the value associated with the column: UNIT_NAME
	 */
	public Long getUnitName () {
		return unitName;
	}

	/**
	 * Set the value related to the column: UNIT_NAME
	 * @param unitName the UNIT_NAME value
	 */
	public void setUnitName (Long unitName) {
		this.unitName = unitName;
	}


	/**
	 * Return the value associated with the column: DESCRIPTION
	 */
	public String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: DESCRIPTION
	 * @param description the DESCRIPTION value
	 */
	public void setDescription (String description) {
		this.description = description;
	}


	/**
	 * Return the value associated with the column: NAME
	 */
	public Integer getName () {
		return name;
	}

	/**
	 * Set the value related to the column: NAME
	 * @param name the NAME value
	 */
	public void setName (Integer name) {
		this.name = name;
	}


	/**
	 * Return the value associated with the column: SEX
	 */
	public Boolean getSex () {
		return sex;
	}

	/**
	 * Set the value related to the column: SEX
	 * @param sex the SEX value
	 */
	public void setSex (Boolean sex) {
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
	public String getIdCard () {
		return idCard;
	}

	/**
	 * Set the value related to the column: ID_CARD
	 * @param idCard the ID_CARD value
	 */
	public void setIdCard (String idCard) {
		this.idCard = idCard;
	}

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCsOpinion() {
        return csOpinion;
    }

    public void setCsOpinion(String csOpinion) {
        this.csOpinion = csOpinion;
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

    public DocDocument getDocContract() {
        return docContract;
    }

    public void setDocContract(DocDocument docContract) {
        this.docContract = docContract;
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
		builder.append(status);
		builder.append(csOpinion);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}