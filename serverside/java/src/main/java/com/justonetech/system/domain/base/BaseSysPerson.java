package com.justonetech.system.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SYS_PERSON table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 系统人员
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 系统人员
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : system
 * Projectable : false
 *
 * @hibernate.class
 *  table="SYS_PERSON"
 */

public abstract class BaseSysPerson  implements Serializable,Auditable {

	public static String REF = "SysPerson";
	public static String PROP_BORN_PLACE = "bornPlace";
	public static String PROP_DOC = "doc";
	public static String PROP_AGE = "age";
	public static String PROP_WORK_YEAR = "workYear";
	public static String PROP_TECHNICAL_LEVEL = "technicalLevel";
	public static String PROP_IS_WORKING = "isWorking";
	public static String PROP_QQ_CODE = "qqCode";
	public static String PROP_ZIPCODE = "zipcode";
	public static String PROP_CODE = "code";
	public static String PROP_FAX_TEL = "faxTel";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_POLITICAL = "political";
	public static String PROP_MOBILE = "mobile";
	public static String PROP_SEX = "sex";
	public static String PROP_UPDATE_USER = "updateUser";
	public static String PROP_BORN_DATE = "bornDate";
	public static String PROP_OFFICE_TEL = "officeTel";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_MSN_CODE = "msnCode";
	public static String PROP_NAME = "name";
	public static String PROP_EDUCATION = "education";
	public static String PROP_EMAIL = "email";
	public static String PROP_MEMO = "memo";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_EDUCATION_DESC = "educationDesc";
	public static String PROP_ID = "id";
	public static String PROP_IS_SHOW_PERSON_OUT = "isShowPersonOut";
	public static String PROP_POLITICAL_DESC = "politicalDesc";
	public static String PROP_CARD = "card";


	// constructors
	public BaseSysPerson () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSysPerson (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*编号*/
    /*编号*/
	private java.lang.String code;
	
    /*姓名*/
    /*姓名*/
	private java.lang.String name;
	
    /*身份证号*/
    /*身份证号*/
	private java.lang.String card;
	
    /*年龄*/
    /*年龄*/
	private java.lang.Integer age;
	
    /*性别*/
    /*性别*/
	private java.lang.Boolean sex;
	
    /*出生年月*/
    /*出生年月*/
	private java.sql.Date bornDate;
	
    /*籍贯*/
    /*籍贯*/
	private java.lang.String bornPlace;
	
    /*移动电话*/
    /*移动电话*/
	private java.lang.String mobile;
	
    /*固定电话*/
    /*固定电话*/
	private java.lang.String officeTel;
	
    /*传真*/
    /*传真*/
	private java.lang.String faxTel;
	
    /*邮件*/
    /*邮件*/
	private java.lang.String email;
	
    /*邮政编码*/
    /*邮政编码*/
	private java.lang.String zipcode;
	
    /*工作年限*/
    /*工作年限*/
	private java.lang.Integer workYear;
	
    /*MSN_CODE*/
    /*MSN_CODE*/
	private java.lang.String msnCode;
	
    /*QQ_CODE*/
    /*QQ_CODE*/
	private java.lang.String qqCode;
	
    /*备注*/
    /*备注*/
	private java.lang.String memo;
	
    /*创建时间*/
    /*创建时间*/
	private java.sql.Timestamp createTime;
	
    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updateTime;
	
    /*更新人*/
    /*更新人*/
	private java.lang.String updateUser;
	
    /*创建人*/
    /*创建人*/
	private java.lang.String createUser;
	
    /*是否显示在去向列表*/
    /*是否显示在去向列表*/
	private java.lang.Boolean isShowPersonOut;
	
    /*学历中文描述*/
    /*学历中文描述*/
	private java.lang.String educationDesc;
	
    /*政治面貌中文描述*/
    /*政治面貌中文描述*/
	private java.lang.String politicalDesc;
	
    /*技术职称或等级*/
    /*技术职称或等级*/
	private java.lang.String technicalLevel;
	
    /*是否编内*/
    /*是否编内*/
	private java.lang.Boolean isWorking;
	

	// many to one
	private com.justonetech.system.domain.SysCodeDetail education;
	private com.justonetech.system.domain.SysCodeDetail political;
	private com.justonetech.biz.domain.DocDocument doc;

	// collections
	private java.util.Set<com.justonetech.system.domain.SysPersonDept> sysPersonDepts;
	private java.util.Set<com.justonetech.system.domain.SysUser> sysUsers;



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
	 * Return the value associated with the column: CARD
	 */
	public java.lang.String getCard () {
		return card;
	}

	/**
	 * Set the value related to the column: CARD
	 * @param card the CARD value
	 */
	public void setCard (java.lang.String card) {
		this.card = card;
	}


	/**
	 * Return the value associated with the column: AGE
	 */
	public java.lang.Integer getAge () {
		return age;
	}

	/**
	 * Set the value related to the column: AGE
	 * @param age the AGE value
	 */
	public void setAge (java.lang.Integer age) {
		this.age = age;
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
	 * Return the value associated with the column: BORN_DATE
	 */
	public java.sql.Date getBornDate () {
		return bornDate;
	}

	/**
	 * Set the value related to the column: BORN_DATE
	 * @param bornDate the BORN_DATE value
	 */
	public void setBornDate (java.sql.Date bornDate) {
		this.bornDate = bornDate;
	}


	/**
	 * Return the value associated with the column: BORN_PLACE
	 */
	public java.lang.String getBornPlace () {
		return bornPlace;
	}

	/**
	 * Set the value related to the column: BORN_PLACE
	 * @param bornPlace the BORN_PLACE value
	 */
	public void setBornPlace (java.lang.String bornPlace) {
		this.bornPlace = bornPlace;
	}


	/**
	 * Return the value associated with the column: MOBILE
	 */
	public java.lang.String getMobile () {
		return mobile;
	}

	/**
	 * Set the value related to the column: MOBILE
	 * @param mobile the MOBILE value
	 */
	public void setMobile (java.lang.String mobile) {
		this.mobile = mobile;
	}


	/**
	 * Return the value associated with the column: OFFICE_TEL
	 */
	public java.lang.String getOfficeTel () {
		return officeTel;
	}

	/**
	 * Set the value related to the column: OFFICE_TEL
	 * @param officeTel the OFFICE_TEL value
	 */
	public void setOfficeTel (java.lang.String officeTel) {
		this.officeTel = officeTel;
	}


	/**
	 * Return the value associated with the column: FAX_TEL
	 */
	public java.lang.String getFaxTel () {
		return faxTel;
	}

	/**
	 * Set the value related to the column: FAX_TEL
	 * @param faxTel the FAX_TEL value
	 */
	public void setFaxTel (java.lang.String faxTel) {
		this.faxTel = faxTel;
	}


	/**
	 * Return the value associated with the column: EMAIL
	 */
	public java.lang.String getEmail () {
		return email;
	}

	/**
	 * Set the value related to the column: EMAIL
	 * @param email the EMAIL value
	 */
	public void setEmail (java.lang.String email) {
		this.email = email;
	}


	/**
	 * Return the value associated with the column: ZIPCODE
	 */
	public java.lang.String getZipcode () {
		return zipcode;
	}

	/**
	 * Set the value related to the column: ZIPCODE
	 * @param zipcode the ZIPCODE value
	 */
	public void setZipcode (java.lang.String zipcode) {
		this.zipcode = zipcode;
	}


	/**
	 * Return the value associated with the column: WORK_YEAR
	 */
	public java.lang.Integer getWorkYear () {
		return workYear;
	}

	/**
	 * Set the value related to the column: WORK_YEAR
	 * @param workYear the WORK_YEAR value
	 */
	public void setWorkYear (java.lang.Integer workYear) {
		this.workYear = workYear;
	}


	/**
	 * Return the value associated with the column: MSN_CODE
	 */
	public java.lang.String getMsnCode () {
		return msnCode;
	}

	/**
	 * Set the value related to the column: MSN_CODE
	 * @param msnCode the MSN_CODE value
	 */
	public void setMsnCode (java.lang.String msnCode) {
		this.msnCode = msnCode;
	}


	/**
	 * Return the value associated with the column: QQ_CODE
	 */
	public java.lang.String getQqCode () {
		return qqCode;
	}

	/**
	 * Set the value related to the column: QQ_CODE
	 * @param qqCode the QQ_CODE value
	 */
	public void setQqCode (java.lang.String qqCode) {
		this.qqCode = qqCode;
	}


	/**
	 * Return the value associated with the column: MEMO
	 */
	public java.lang.String getMemo () {
		return memo;
	}

	/**
	 * Set the value related to the column: MEMO
	 * @param memo the MEMO value
	 */
	public void setMemo (java.lang.String memo) {
		this.memo = memo;
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
	 * Return the value associated with the column: IS_SHOW_PERSON_OUT
	 */
	public java.lang.Boolean getIsShowPersonOut () {
		return isShowPersonOut;
	}

	/**
	 * Set the value related to the column: IS_SHOW_PERSON_OUT
	 * @param isShowPersonOut the IS_SHOW_PERSON_OUT value
	 */
	public void setIsShowPersonOut (java.lang.Boolean isShowPersonOut) {
		this.isShowPersonOut = isShowPersonOut;
	}


	/**
	 * Return the value associated with the column: EDUCATION_DESC
	 */
	public java.lang.String getEducationDesc () {
		return educationDesc;
	}

	/**
	 * Set the value related to the column: EDUCATION_DESC
	 * @param educationDesc the EDUCATION_DESC value
	 */
	public void setEducationDesc (java.lang.String educationDesc) {
		this.educationDesc = educationDesc;
	}


	/**
	 * Return the value associated with the column: POLITICAL_DESC
	 */
	public java.lang.String getPoliticalDesc () {
		return politicalDesc;
	}

	/**
	 * Set the value related to the column: POLITICAL_DESC
	 * @param politicalDesc the POLITICAL_DESC value
	 */
	public void setPoliticalDesc (java.lang.String politicalDesc) {
		this.politicalDesc = politicalDesc;
	}


	/**
	 * Return the value associated with the column: TECHNICAL_LEVEL
	 */
	public java.lang.String getTechnicalLevel () {
		return technicalLevel;
	}

	/**
	 * Set the value related to the column: TECHNICAL_LEVEL
	 * @param technicalLevel the TECHNICAL_LEVEL value
	 */
	public void setTechnicalLevel (java.lang.String technicalLevel) {
		this.technicalLevel = technicalLevel;
	}


	/**
	 * Return the value associated with the column: IS_WORKING
	 */
	public java.lang.Boolean getIsWorking () {
		return isWorking;
	}

	/**
	 * Set the value related to the column: IS_WORKING
	 * @param isWorking the IS_WORKING value
	 */
	public void setIsWorking (java.lang.Boolean isWorking) {
		this.isWorking = isWorking;
	}


	/**
	 * Return the value associated with the column: EDUCATION_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getEducation () {
		return education;
	}

	/**
	 * Set the value related to the column: EDUCATION_ID
	 * @param education the EDUCATION_ID value
	 */
	public void setEducation (com.justonetech.system.domain.SysCodeDetail education) {
		this.education = education;
	}


	/**
	 * Return the value associated with the column: POLITICAL_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getPolitical () {
		return political;
	}

	/**
	 * Set the value related to the column: POLITICAL_ID
	 * @param political the POLITICAL_ID value
	 */
	public void setPolitical (com.justonetech.system.domain.SysCodeDetail political) {
		this.political = political;
	}


	/**
	 * Return the value associated with the column: DOC_ID
	 */
	public com.justonetech.biz.domain.DocDocument getDoc () {
		return doc;
	}

	/**
	 * Set the value related to the column: DOC_ID
	 * @param doc the DOC_ID value
	 */
	public void setDoc (com.justonetech.biz.domain.DocDocument doc) {
		this.doc = doc;
	}


	/**
	 * Return the value associated with the column: sysPersonDepts
	 */
	public java.util.Set<com.justonetech.system.domain.SysPersonDept> getSysPersonDepts () {
        if(sysPersonDepts==null){
            sysPersonDepts = new java.util.LinkedHashSet<com.justonetech.system.domain.SysPersonDept>();
        }
		return sysPersonDepts;
	}

	/**
	 * Set the value related to the column: sysPersonDepts
	 * @param sysPersonDepts the sysPersonDepts value
	 */
	public void setSysPersonDepts (java.util.Set<com.justonetech.system.domain.SysPersonDept> sysPersonDepts) {
		this.sysPersonDepts = sysPersonDepts;
	}


	/**
	 * Return the value associated with the column: sysUsers
	 */
	public java.util.Set<com.justonetech.system.domain.SysUser> getSysUsers () {
        if(sysUsers==null){
            sysUsers = new java.util.LinkedHashSet<com.justonetech.system.domain.SysUser>();
        }
		return sysUsers;
	}

	/**
	 * Set the value related to the column: sysUsers
	 * @param sysUsers the sysUsers value
	 */
	public void setSysUsers (java.util.Set<com.justonetech.system.domain.SysUser> sysUsers) {
		this.sysUsers = sysUsers;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.system.domain.SysPerson)) return false;
		else {
			com.justonetech.system.domain.SysPerson sysPerson = (com.justonetech.system.domain.SysPerson) obj;
			if (null == this.getId() || null == sysPerson.getId()) return false;
			else return (this.getId().equals(sysPerson.getId()));
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
		builder.append(name);
		builder.append(card);
		builder.append(age);
		builder.append(sex);
		builder.append(bornDate);
		builder.append(bornPlace);
		builder.append(mobile);
		builder.append(officeTel);
		builder.append(faxTel);
		builder.append(email);
		builder.append(zipcode);
		builder.append(workYear);
		builder.append(msnCode);
		builder.append(qqCode);
		builder.append(memo);
		builder.append(createTime);
		builder.append(updateTime);
		builder.append(updateUser);
		builder.append(createUser);
		builder.append(isShowPersonOut);
		builder.append(educationDesc);
		builder.append(politicalDesc);
		builder.append(technicalLevel);
		builder.append(isWorking);
		return builder.toString();
	}


}