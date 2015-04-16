package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the WORKER_COMPLAIN table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 务工人员投诉管理
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 务工人员投诉管理
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : worker
 * Projectable : false
 *
 * @hibernate.class
 *  table="WORKER_COMPLAIN"
 */

public abstract class BaseWorkerComplain  implements Serializable ,Auditable{

	public static String REF = "WorkerComplain";
	public static String PROP_DOC = "doc";
	public static String PROP_PERSON_COUNT = "personCount";
	public static String PROP_MANAGER_TEL = "managerTel";
	public static String PROP_PERSON_NAME = "personName";
	public static String PROP_DEAL_DATE = "dealDate";
	public static String PROP_DEBT_MONEY = "debtMoney";
	public static String PROP_ZB_DEPT_LXR = "zbDeptLxr";
	public static String PROP_CODE = "code";
	public static String PROP_JS_DEPT = "jsDept";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_DEAL_JBR = "dealJbr";
	public static String PROP_ZB_DEPT_TEL = "zbDeptTel";
	public static String PROP_BJBH = "bjbh";
	public static String PROP_MANAGER = "manager";
	public static String PROP_PERSON_TEL = "personTel";
	public static String PROP_PERSON_ADDRESS = "personAddress";
	public static String PROP_ZB_DEPT = "zbDept";
	public static String PROP_DEBT_PERSONS = "debtPersons";
	public static String PROP_FB_DEPT_LXR = "fbDeptLxr";
	public static String PROP_PERSON_IDCARD = "personIdcard";
	public static String PROP_CONTENT = "content";
	public static String PROP_MONEY_TYPE = "moneyType";
	public static String PROP_FB_DEPT = "fbDept";
	public static String PROP_UPDATE_USER = "updateUser";
	public static String PROP_PROJECT_NAME = "projectName";
	public static String PROP_FB_DEPT_TEL = "fbDeptTel";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_VISIT_DATE = "visitDate";
	public static String PROP_DEBT_PERSON = "debtPerson";
	public static String PROP_JS_DEPT_LXR = "jsDeptLxr";
	public static String PROP_DEAL_OPINION = "dealOpinion";
	public static String PROP_PROJECT_ADDRESS = "projectAddress";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_JS_DEPT_TEL = "jsDeptTel";
	public static String PROP_ID = "id";
	public static String PROP_DEBT_CERT = "debtCert";
    public static String PROP_OUTER_ID = "outerId";


	// constructors
	public BaseWorkerComplain () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWorkerComplain (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*报建编号*/
    /*报建编号*/
	private String bjbh;
	
    /*项目名称*/
    /*项目名称*/
	private String projectName;
	
    /*项目地点*/
    /*项目地点*/
	private String projectAddress;
	
    /*建设单位名称*/
    /*建设单位名称*/
	private String jsDept;
	
    /*建设单位负责人*/
    /*建设单位负责人*/
	private String jsDeptLxr;
	
    /*建设单位联系电话*/
    /*建设单位联系电话*/
	private String jsDeptTel;
	
    /*总包单位名称*/
    /*总包单位名称*/
	private String zbDept;
	
    /*总包单位负责人*/
    /*总包单位负责人*/
	private String zbDeptLxr;
	
    /*总包单位联系电话*/
    /*总包单位联系电话*/
	private String zbDeptTel;
	
    /*分包单位名称*/
    /*分包单位名称*/
	private String fbDept;
	
    /*分包单位负责人*/
    /*分包单位负责人*/
	private String fbDeptLxr;
	
    /*分包单位联系电话*/
    /*分包单位联系电话*/
	private String fbDeptTel;
	
    /*项目经理*/
    /*项目经理*/
	private String manager;
	
    /*项目经理电话*/
    /*项目经理电话*/
	private String managerTel;
	
    /*来访日期*/
    /*来访日期*/
	private java.sql.Date visitDate;
	
    /*编号*/
    /*编号*/
	private String code;
	
    /*来访者姓名*/
    /*来访者姓名*/
	private String personName;
	
    /*来访人数*/
    /*来访人数*/
	private Integer personCount;
	
    /*来访者住址*/
    /*来访者住址*/
	private String personAddress;
	
    /*身份证号码*/
    /*身份证号码*/
	private String personIdcard;
	
    /*来访者联系电话*/
    /*来访者联系电话*/
	private String personTel;
	
    /*欠款人*/
    /*欠款人*/
	private String debtPerson;
	
    /*涉及工资款*/
    /*涉及工资款*/
	private Double debtMoney;
	
    /*涉及民工人数*/
    /*涉及民工人数*/
	private Integer debtPersons;
	
    /*款项类型*/
    /*款项类型*/
	private String moneyType;
	
    /*拖欠凭证*/
    /*拖欠凭证*/
	private String debtCert;
	
    /*投诉内容*/
    /*投诉内容*/
	private String content;
	
    /*处理情况*/
    /*处理情况*/
	private String dealOpinion;
	
    /*处理日期*/
    /*处理日期*/
	private java.sql.Date dealDate;
	
    /*经办人*/
    /*经办人*/
	private String dealJbr;
	
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

	private Long outerId;  //外部记录ID


	// many to one
	private com.justonetech.biz.domain.DocDocument doc;



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
	 * Return the value associated with the column: PROJECT_ADDRESS
	 */
	public String getProjectAddress () {
		return projectAddress;
	}

	/**
	 * Set the value related to the column: PROJECT_ADDRESS
	 * @param projectAddress the PROJECT_ADDRESS value
	 */
	public void setProjectAddress (String projectAddress) {
		this.projectAddress = projectAddress;
	}


	/**
	 * Return the value associated with the column: JS_DEPT
	 */
	public String getJsDept () {
		return jsDept;
	}

	/**
	 * Set the value related to the column: JS_DEPT
	 * @param jsDept the JS_DEPT value
	 */
	public void setJsDept (String jsDept) {
		this.jsDept = jsDept;
	}


	/**
	 * Return the value associated with the column: JS_DEPT_LXR
	 */
	public String getJsDeptLxr () {
		return jsDeptLxr;
	}

	/**
	 * Set the value related to the column: JS_DEPT_LXR
	 * @param jsDeptLxr the JS_DEPT_LXR value
	 */
	public void setJsDeptLxr (String jsDeptLxr) {
		this.jsDeptLxr = jsDeptLxr;
	}


	/**
	 * Return the value associated with the column: JS_DEPT_TEL
	 */
	public String getJsDeptTel () {
		return jsDeptTel;
	}

	/**
	 * Set the value related to the column: JS_DEPT_TEL
	 * @param jsDeptTel the JS_DEPT_TEL value
	 */
	public void setJsDeptTel (String jsDeptTel) {
		this.jsDeptTel = jsDeptTel;
	}


	/**
	 * Return the value associated with the column: ZB_DEPT
	 */
	public String getZbDept () {
		return zbDept;
	}

	/**
	 * Set the value related to the column: ZB_DEPT
	 * @param zbDept the ZB_DEPT value
	 */
	public void setZbDept (String zbDept) {
		this.zbDept = zbDept;
	}


	/**
	 * Return the value associated with the column: ZB_DEPT_LXR
	 */
	public String getZbDeptLxr () {
		return zbDeptLxr;
	}

	/**
	 * Set the value related to the column: ZB_DEPT_LXR
	 * @param zbDeptLxr the ZB_DEPT_LXR value
	 */
	public void setZbDeptLxr (String zbDeptLxr) {
		this.zbDeptLxr = zbDeptLxr;
	}


	/**
	 * Return the value associated with the column: ZB_DEPT_TEL
	 */
	public String getZbDeptTel () {
		return zbDeptTel;
	}

	/**
	 * Set the value related to the column: ZB_DEPT_TEL
	 * @param zbDeptTel the ZB_DEPT_TEL value
	 */
	public void setZbDeptTel (String zbDeptTel) {
		this.zbDeptTel = zbDeptTel;
	}


	/**
	 * Return the value associated with the column: FB_DEPT
	 */
	public String getFbDept () {
		return fbDept;
	}

	/**
	 * Set the value related to the column: FB_DEPT
	 * @param fbDept the FB_DEPT value
	 */
	public void setFbDept (String fbDept) {
		this.fbDept = fbDept;
	}


	/**
	 * Return the value associated with the column: FB_DEPT_LXR
	 */
	public String getFbDeptLxr () {
		return fbDeptLxr;
	}

	/**
	 * Set the value related to the column: FB_DEPT_LXR
	 * @param fbDeptLxr the FB_DEPT_LXR value
	 */
	public void setFbDeptLxr (String fbDeptLxr) {
		this.fbDeptLxr = fbDeptLxr;
	}


	/**
	 * Return the value associated with the column: FB_DEPT_TEL
	 */
	public String getFbDeptTel () {
		return fbDeptTel;
	}

	/**
	 * Set the value related to the column: FB_DEPT_TEL
	 * @param fbDeptTel the FB_DEPT_TEL value
	 */
	public void setFbDeptTel (String fbDeptTel) {
		this.fbDeptTel = fbDeptTel;
	}


	/**
	 * Return the value associated with the column: MANAGER
	 */
	public String getManager () {
		return manager;
	}

	/**
	 * Set the value related to the column: MANAGER
	 * @param manager the MANAGER value
	 */
	public void setManager (String manager) {
		this.manager = manager;
	}


	/**
	 * Return the value associated with the column: MANAGER_TEL
	 */
	public String getManagerTel () {
		return managerTel;
	}

	/**
	 * Set the value related to the column: MANAGER_TEL
	 * @param managerTel the MANAGER_TEL value
	 */
	public void setManagerTel (String managerTel) {
		this.managerTel = managerTel;
	}


	/**
	 * Return the value associated with the column: VISIT_DATE
	 */
	public java.sql.Date getVisitDate () {
		return visitDate;
	}

	/**
	 * Set the value related to the column: VISIT_DATE
	 * @param visitDate the VISIT_DATE value
	 */
	public void setVisitDate (java.sql.Date visitDate) {
		this.visitDate = visitDate;
	}


	/**
	 * Return the value associated with the column: CODE
	 */
	public String getCode () {
		return code;
	}

	/**
	 * Set the value related to the column: CODE
	 * @param code the CODE value
	 */
	public void setCode (String code) {
		this.code = code;
	}


	/**
	 * Return the value associated with the column: PERSON_NAME
	 */
	public String getPersonName () {
		return personName;
	}

	/**
	 * Set the value related to the column: PERSON_NAME
	 * @param personName the PERSON_NAME value
	 */
	public void setPersonName (String personName) {
		this.personName = personName;
	}


	/**
	 * Return the value associated with the column: PERSON_COUNT
	 */
	public Integer getPersonCount () {
		return personCount;
	}

	/**
	 * Set the value related to the column: PERSON_COUNT
	 * @param personCount the PERSON_COUNT value
	 */
	public void setPersonCount (Integer personCount) {
		this.personCount = personCount;
	}


	/**
	 * Return the value associated with the column: PERSON_ADDRESS
	 */
	public String getPersonAddress () {
		return personAddress;
	}

	/**
	 * Set the value related to the column: PERSON_ADDRESS
	 * @param personAddress the PERSON_ADDRESS value
	 */
	public void setPersonAddress (String personAddress) {
		this.personAddress = personAddress;
	}


	/**
	 * Return the value associated with the column: PERSON_IDCARD
	 */
	public String getPersonIdcard () {
		return personIdcard;
	}

	/**
	 * Set the value related to the column: PERSON_IDCARD
	 * @param personIdcard the PERSON_IDCARD value
	 */
	public void setPersonIdcard (String personIdcard) {
		this.personIdcard = personIdcard;
	}


	/**
	 * Return the value associated with the column: PERSON_TEL
	 */
	public String getPersonTel () {
		return personTel;
	}

	/**
	 * Set the value related to the column: PERSON_TEL
	 * @param personTel the PERSON_TEL value
	 */
	public void setPersonTel (String personTel) {
		this.personTel = personTel;
	}


	/**
	 * Return the value associated with the column: DEBT_PERSON
	 */
	public String getDebtPerson () {
		return debtPerson;
	}

	/**
	 * Set the value related to the column: DEBT_PERSON
	 * @param debtPerson the DEBT_PERSON value
	 */
	public void setDebtPerson (String debtPerson) {
		this.debtPerson = debtPerson;
	}


	/**
	 * Return the value associated with the column: DEBT_MONEY
	 */
	public Double getDebtMoney () {
		return debtMoney;
	}

	/**
	 * Set the value related to the column: DEBT_MONEY
	 * @param debtMoney the DEBT_MONEY value
	 */
	public void setDebtMoney (Double debtMoney) {
		this.debtMoney = debtMoney;
	}


	/**
	 * Return the value associated with the column: DEBT_PERSONS
	 */
	public Integer getDebtPersons () {
		return debtPersons;
	}

	/**
	 * Set the value related to the column: DEBT_PERSONS
	 * @param debtPersons the DEBT_PERSONS value
	 */
	public void setDebtPersons (Integer debtPersons) {
		this.debtPersons = debtPersons;
	}


	/**
	 * Return the value associated with the column: MONEY_TYPE
	 */
	public String getMoneyType () {
		return moneyType;
	}

	/**
	 * Set the value related to the column: MONEY_TYPE
	 * @param moneyType the MONEY_TYPE value
	 */
	public void setMoneyType (String moneyType) {
		this.moneyType = moneyType;
	}


	/**
	 * Return the value associated with the column: DEBT_CERT
	 */
	public String getDebtCert () {
		return debtCert;
	}

	/**
	 * Set the value related to the column: DEBT_CERT
	 * @param debtCert the DEBT_CERT value
	 */
	public void setDebtCert (String debtCert) {
		this.debtCert = debtCert;
	}


	/**
	 * Return the value associated with the column: CONTENT
	 */
	public String getContent () {
		return content;
	}

	/**
	 * Set the value related to the column: CONTENT
	 * @param content the CONTENT value
	 */
	public void setContent (String content) {
		this.content = content;
	}


	/**
	 * Return the value associated with the column: DEAL_OPINION
	 */
	public String getDealOpinion () {
		return dealOpinion;
	}

	/**
	 * Set the value related to the column: DEAL_OPINION
	 * @param dealOpinion the DEAL_OPINION value
	 */
	public void setDealOpinion (String dealOpinion) {
		this.dealOpinion = dealOpinion;
	}


	/**
	 * Return the value associated with the column: DEAL_DATE
	 */
	public java.sql.Date getDealDate () {
		return dealDate;
	}

	/**
	 * Set the value related to the column: DEAL_DATE
	 * @param dealDate the DEAL_DATE value
	 */
	public void setDealDate (java.sql.Date dealDate) {
		this.dealDate = dealDate;
	}


	/**
	 * Return the value associated with the column: DEAL_JBR
	 */
	public String getDealJbr () {
		return dealJbr;
	}

	/**
	 * Set the value related to the column: DEAL_JBR
	 * @param dealJbr the DEAL_JBR value
	 */
	public void setDealJbr (String dealJbr) {
		this.dealJbr = dealJbr;
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

    public Long getOuterId() {
        return outerId;
    }

    public void setOuterId(Long outerId) {
        this.outerId = outerId;
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



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.WorkerComplain)) return false;
		else {
			com.justonetech.biz.domain.WorkerComplain workerComplain = (com.justonetech.biz.domain.WorkerComplain) obj;
			if (null == this.getId() || null == workerComplain.getId()) return false;
			else return (this.getId().equals(workerComplain.getId()));
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
		builder.append(bjbh);
		builder.append(projectName);
		builder.append(projectAddress);
		builder.append(jsDept);
		builder.append(jsDeptLxr);
		builder.append(jsDeptTel);
		builder.append(zbDept);
		builder.append(zbDeptLxr);
		builder.append(zbDeptTel);
		builder.append(fbDept);
		builder.append(fbDeptLxr);
		builder.append(fbDeptTel);
		builder.append(manager);
		builder.append(managerTel);
		builder.append(visitDate);
		builder.append(code);
		builder.append(personName);
		builder.append(personCount);
		builder.append(personAddress);
		builder.append(personIdcard);
		builder.append(personTel);
		builder.append(debtPerson);
		builder.append(debtMoney);
		builder.append(debtPersons);
		builder.append(moneyType);
		builder.append(debtCert);
		builder.append(content);
		builder.append(dealOpinion);
		builder.append(dealDate);
		builder.append(dealJbr);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		builder.append(outerId);
		return builder.toString();
	}


}