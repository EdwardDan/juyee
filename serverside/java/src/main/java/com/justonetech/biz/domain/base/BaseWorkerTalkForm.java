package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the WORKER_TALK_FORM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 执法管理谈话通知书
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 执法管理谈话通知书
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : worker
 * Projectable : false
 *
 * @hibernate.class
 *  table="WORKER_TALK_FORM"
 */

public abstract class BaseWorkerTalkForm  implements Serializable ,Auditable{

	public static String REF = "WorkerTalkForm";
	public static String PROP_SIGN_PERSON = "signPerson";
	public static String PROP_PROJECT_NAME = "projectName";
	public static String PROP_TALK_PERSON = "talkPerson";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_MATERIAL_IDS = "materialIds";
	public static String PROP_SIGN_DATE = "signDate";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_TALK_TIME = "talkTime";
	public static String PROP_ID = "id";
	public static String PROP_UNIT_NAME2 = "unitName2";
	public static String PROP_UNIT_NAME1 = "unitName1";
	public static String PROP_CONTENT = "content";
	public static String PROP_FORM_CODE = "formCode";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseWorkerTalkForm () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWorkerTalkForm (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*工程名称*/
    /*工程名称*/
	private String projectName;
	
    /*号*/
    /*号*/
	private String formCode;
	
    /*谈话单位1*/
    /*谈话单位1*/
	private String unitName1;
	
    /*谈话单位2*/
    /*谈话单位2*/
	private String unitName2;
	
    /*谈话事由*/
    /*谈话事由*/
	private String content;
	
    /*谈话时间*/
    /*谈话时间*/
	private java.sql.Timestamp talkTime;
	
    /*签发时间*/
    /*签发时间*/
	private java.sql.Date signDate;
	
    /*签发人*/
    /*签发人*/
	private String signPerson;
	
    /*内部谈话人*/
    /*内部谈话人*/
	private String talkPerson;
	
    /*携带材料*/
    /*携带材料*/
	private String materialIds;
	
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
	 * Return the value associated with the column: FORM_CODE
	 */
	public String getFormCode () {
		return formCode;
	}

	/**
	 * Set the value related to the column: FORM_CODE
	 * @param formCode the FORM_CODE value
	 */
	public void setFormCode (String formCode) {
		this.formCode = formCode;
	}


	/**
	 * Return the value associated with the column: UNIT_NAME1
	 */
	public String getUnitName1 () {
		return unitName1;
	}

	/**
	 * Set the value related to the column: UNIT_NAME1
	 * @param unitName1 the UNIT_NAME1 value
	 */
	public void setUnitName1 (String unitName1) {
		this.unitName1 = unitName1;
	}


	/**
	 * Return the value associated with the column: UNIT_NAME2
	 */
	public String getUnitName2 () {
		return unitName2;
	}

	/**
	 * Set the value related to the column: UNIT_NAME2
	 * @param unitName2 the UNIT_NAME2 value
	 */
	public void setUnitName2 (String unitName2) {
		this.unitName2 = unitName2;
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
	 * Return the value associated with the column: TALK_TIME
	 */
	public java.sql.Timestamp getTalkTime () {
		return talkTime;
	}

	/**
	 * Set the value related to the column: TALK_TIME
	 * @param talkTime the TALK_TIME value
	 */
	public void setTalkTime (java.sql.Timestamp talkTime) {
		this.talkTime = talkTime;
	}


	/**
	 * Return the value associated with the column: SIGN_DATE
	 */
	public java.sql.Date getSignDate () {
		return signDate;
	}

	/**
	 * Set the value related to the column: SIGN_DATE
	 * @param signDate the SIGN_DATE value
	 */
	public void setSignDate (java.sql.Date signDate) {
		this.signDate = signDate;
	}


	/**
	 * Return the value associated with the column: SIGN_PERSON
	 */
	public String getSignPerson () {
		return signPerson;
	}

	/**
	 * Set the value related to the column: SIGN_PERSON
	 * @param signPerson the SIGN_PERSON value
	 */
	public void setSignPerson (String signPerson) {
		this.signPerson = signPerson;
	}


	/**
	 * Return the value associated with the column: TALK_PERSON
	 */
	public String getTalkPerson () {
		return talkPerson;
	}

	/**
	 * Set the value related to the column: TALK_PERSON
	 * @param talkPerson the TALK_PERSON value
	 */
	public void setTalkPerson (String talkPerson) {
		this.talkPerson = talkPerson;
	}


	/**
	 * Return the value associated with the column: MATERIAL_IDS
	 */
	public String getMaterialIds () {
		return materialIds;
	}

	/**
	 * Set the value related to the column: MATERIAL_IDS
	 * @param materialIds the MATERIAL_IDS value
	 */
	public void setMaterialIds (String materialIds) {
		this.materialIds = materialIds;
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



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.WorkerTalkForm)) return false;
		else {
			com.justonetech.biz.domain.WorkerTalkForm workerTalkForm = (com.justonetech.biz.domain.WorkerTalkForm) obj;
			if (null == this.getId() || null == workerTalkForm.getId()) return false;
			else return (this.getId().equals(workerTalkForm.getId()));
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
		builder.append(projectName);
		builder.append(formCode);
		builder.append(unitName1);
		builder.append(unitName2);
		builder.append(content);
		builder.append(talkTime);
		builder.append(signDate);
		builder.append(signPerson);
		builder.append(talkPerson);
		builder.append(materialIds);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}