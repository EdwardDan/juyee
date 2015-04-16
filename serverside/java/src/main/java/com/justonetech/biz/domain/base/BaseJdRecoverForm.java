package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the JD_RECOVER_FORM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 安全质量监督--复工通知单
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 安全质量监督--复工通知单
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : jd
 * Projectable : false
 *
 * @hibernate.class
 *  table="JD_RECOVER_FORM"
 */

public abstract class BaseJdRecoverForm  implements Serializable,Auditable {

	public static String REF = "JdRecoverForm";
	public static String PROP_SIGN_PERSON = "signPerson";
	public static String PROP_DOCUMENT = "document";
	public static String PROP_SIGN_DEPT = "signDept";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_PROJECT_NAME = "projectName";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_SIGN_DATE = "signDate";
	public static String PROP_YEAR = "year";
	public static String PROP_STATUS = "status";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_STOP_FORM = "stopForm";
	public static String PROP_ORDER_NO = "orderNo";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_REFORM_BEGIN_DATE = "reformBeginDate";
	public static String PROP_ID = "id";
	public static String PROP_DUTY_DEPT = "dutyDept";
	public static String PROP_RECOVER_DATE = "recoverDate";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseJdRecoverForm () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseJdRecoverForm (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*年份*/
    /*年份*/
	private java.lang.Integer year;
	
    /*序号*/
    /*序号*/
	private java.lang.String orderNo;
	
    /*责任主体*/
    /*责任主体*/
	private java.lang.String dutyDept;
	
    /*工程名称(冗余)*/
    /*工程名称(冗余)*/
	private java.lang.String projectName;
	
    /*整改起始时间*/
    /*整改起始时间*/
	private java.sql.Date reformBeginDate;
	
    /*恢复施工时间*/
    /*恢复施工时间*/
	private java.sql.Date recoverDate;
	
    /*签发单位*/
    /*签发单位*/
	private java.lang.String signDept;
	
    /*签发人*/
    /*签发人*/
	private java.lang.String signPerson;
	
    /*签发日期*/
    /*签发日期*/
	private java.sql.Date signDate;
	
    /*备注*/
    /*备注*/
	private java.lang.String description;
	
    /*状态*/
    /*状态*/
	private java.lang.Integer status;
	
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
	

	// many to one
	private com.justonetech.biz.domain.DocDocument document;
	private com.justonetech.biz.domain.JdStopOrder stopForm;



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
	 * Return the value associated with the column: ORDER_NO
	 */
	public java.lang.String getOrderNo () {
		return orderNo;
	}

	/**
	 * Set the value related to the column: ORDER_NO
	 * @param orderNo the ORDER_NO value
	 */
	public void setOrderNo (java.lang.String orderNo) {
		this.orderNo = orderNo;
	}


	/**
	 * Return the value associated with the column: DUTY_DEPT
	 */
	public java.lang.String getDutyDept () {
		return dutyDept;
	}

	/**
	 * Set the value related to the column: DUTY_DEPT
	 * @param dutyDept the DUTY_DEPT value
	 */
	public void setDutyDept (java.lang.String dutyDept) {
		this.dutyDept = dutyDept;
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
	 * Return the value associated with the column: REFORM_BEGIN_DATE
	 */
	public java.sql.Date getReformBeginDate () {
		return reformBeginDate;
	}

	/**
	 * Set the value related to the column: REFORM_BEGIN_DATE
	 * @param reformBeginDate the REFORM_BEGIN_DATE value
	 */
	public void setReformBeginDate (java.sql.Date reformBeginDate) {
		this.reformBeginDate = reformBeginDate;
	}


	/**
	 * Return the value associated with the column: RECOVER_DATE
	 */
	public java.sql.Date getRecoverDate () {
		return recoverDate;
	}

	/**
	 * Set the value related to the column: RECOVER_DATE
	 * @param recoverDate the RECOVER_DATE value
	 */
	public void setRecoverDate (java.sql.Date recoverDate) {
		this.recoverDate = recoverDate;
	}


	/**
	 * Return the value associated with the column: SIGN_DEPT
	 */
	public java.lang.String getSignDept () {
		return signDept;
	}

	/**
	 * Set the value related to the column: SIGN_DEPT
	 * @param signDept the SIGN_DEPT value
	 */
	public void setSignDept (java.lang.String signDept) {
		this.signDept = signDept;
	}


	/**
	 * Return the value associated with the column: SIGN_PERSON
	 */
	public java.lang.String getSignPerson () {
		return signPerson;
	}

	/**
	 * Set the value related to the column: SIGN_PERSON
	 * @param signPerson the SIGN_PERSON value
	 */
	public void setSignPerson (java.lang.String signPerson) {
		this.signPerson = signPerson;
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
	 * Return the value associated with the column: DOCUMENT_ID
	 */
	public com.justonetech.biz.domain.DocDocument getDocument () {
		return document;
	}

	/**
	 * Set the value related to the column: DOCUMENT_ID
	 * @param document the DOCUMENT_ID value
	 */
	public void setDocument (com.justonetech.biz.domain.DocDocument document) {
		this.document = document;
	}


	/**
	 * Return the value associated with the column: STOP_FORM_ID
	 */
	public com.justonetech.biz.domain.JdStopOrder getStopForm () {
		return stopForm;
	}

	/**
	 * Set the value related to the column: STOP_FORM_ID
	 * @param stopForm the STOP_FORM_ID value
	 */
	public void setStopForm (com.justonetech.biz.domain.JdStopOrder stopForm) {
		this.stopForm = stopForm;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.JdRecoverForm)) return false;
		else {
			com.justonetech.biz.domain.JdRecoverForm jdRecoverForm = (com.justonetech.biz.domain.JdRecoverForm) obj;
			if (null == this.getId() || null == jdRecoverForm.getId()) return false;
			else return (this.getId().equals(jdRecoverForm.getId()));
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
		builder.append(orderNo);
		builder.append(dutyDept);
		builder.append(projectName);
		builder.append(reformBeginDate);
		builder.append(recoverDate);
		builder.append(signDept);
		builder.append(signPerson);
		builder.append(signDate);
		builder.append(description);
		builder.append(status);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}