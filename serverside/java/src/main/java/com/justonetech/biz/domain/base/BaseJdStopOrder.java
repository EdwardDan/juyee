package com.justonetech.biz.domain.base;

import com.justonetech.biz.domain.JdStopOrderQuestion;

import java.io.Serializable;


/**
 * This is an object that contains data related to the JD_STOP_ORDER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 安全质量监督--整改/暂缓施工/停工单
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 安全质量监督--整改/暂缓施工/停工单
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : jd
 * Projectable : false
 *
 * @hibernate.class
 *  table="JD_STOP_ORDER"
 */

public abstract class BaseJdStopOrder  implements Serializable {

	public static String REF = "JdStopOrder";
	public static String PROP_SIGN_PERSON = "signPerson";
	public static String PROP_DOCUMENT = "document";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_SIGN_DEPT = "signDept";
	public static String PROP_PROJECT_NAME = "projectName";
	public static String PROP_RECORD_ID = "recordId";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_SIGN_DATE = "signDate";
	public static String PROP_STATUS = "status";
	public static String PROP_YEAR = "year";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_JD_TYPE_CODE = "jdTypeCode";
	public static String PROP_JD_ATTRIBUTE_CODE = "jdAttributeCode";
	public static String PROP_RECHECK_OTHER = "recheckOther";
	public static String PROP_REFORM_AREA = "reformArea";
	public static String PROP_BJBH = "bjbh";
	public static String PROP_ORDER_NO = "orderNo";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_REFORM_BEGIN_DATE = "reformBeginDate";
	public static String PROP_REFORM_LIMIT = "reformLimit";
	public static String PROP_ID = "id";
	public static String PROP_DUTY_DEPT = "dutyDept";
	public static String PROP_FORM_CODE = "formCode";
	public static String PROP_RECHECK_DEPT = "recheckDept";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseJdStopOrder () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseJdStopOrder (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*表单类别(整改/暂缓/停工)*/
    /*表单类别(整改/暂缓/停工)*/
	private java.lang.String formCode;
	
    /*监督类别编码*/
    /*监督类别编码*/
	private java.lang.String jdTypeCode;

	 /*监督属性类别编码*/
    /*监督属性类别编码*/
	private java.lang.String jdAttributeCode;
	
    /*监督id(首次/安全/质量/竣工)*/
    /*监督id(首次/安全/质量/竣工)*/
	private java.lang.Long recordId;
	
    /*报建编号*/
    /*报建编号*/
	private java.lang.String bjbh;
	
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
	
    /*复查单位*/
    /*复查单位*/
	private java.lang.String recheckDept;
	
    /*复查单位其他*/
    /*复查单位其他*/
	private java.lang.String recheckOther;
	
    /*整改范围*/
    /*整改范围*/
	private java.lang.String reformArea;
	
    /*整改起始时间*/
    /*整改起始时间*/
	private java.sql.Timestamp reformBeginDate;
	
    /*整改期限*/
    /*整改期限*/
	private java.sql.Date reformLimit;
	
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

	// collections
	private java.util.Set<com.justonetech.biz.domain.JdRecoverForm> jdRecoverForms;
	private java.util.Set<com.justonetech.biz.domain.JdReformReply> jdReformReplies;
	private java.util.Set<com.justonetech.biz.domain.JdStopOrderQuestion> jdStopOrderQuestions;



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
	 * Return the value associated with the column: FORM_CODE
	 */
	public java.lang.String getFormCode () {
		return formCode;
	}

	/**
	 * Set the value related to the column: FORM_CODE
	 * @param formCode the FORM_CODE value
	 */
	public void setFormCode (java.lang.String formCode) {
		this.formCode = formCode;
	}


	/**
	 * Return the value associated with the column: JD_TYPE_CODE
	 */
	public java.lang.String getJdTypeCode () {
		return jdTypeCode;
	}

	/**
	 * Set the value related to the column: JD_TYPE_CODE
	 * @param jdTypeCode the JD_TYPE_CODE value
	 */
	public void setJdTypeCode (java.lang.String jdTypeCode) {
		this.jdTypeCode = jdTypeCode;
	}
	/**
	 * Return the value associated with the column: JD_TYPE_CODE
	 */
	public java.lang.String getJdAttributeCode () {
		return jdAttributeCode;
	}

	/**
	 * Set the value related to the column: JD_TYPE_CODE
	 * @param jdAttributeCode the JD_TYPE_CODE value
	 */
	public void setJdAttributeCode (java.lang.String jdAttributeCode) {
		this.jdAttributeCode = jdAttributeCode;
	}


	/**
	 * Return the value associated with the column: RECORD_ID
	 */
	public java.lang.Long getRecordId () {
		return recordId;
	}

	/**
	 * Set the value related to the column: RECORD_ID
	 * @param recordId the RECORD_ID value
	 */
	public void setRecordId (java.lang.Long recordId) {
		this.recordId = recordId;
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
	 * Return the value associated with the column: RECHECK_DEPT
	 */
	public java.lang.String getRecheckDept () {
		return recheckDept;
	}

	/**
	 * Set the value related to the column: RECHECK_DEPT
	 * @param recheckDept the RECHECK_DEPT value
	 */
	public void setRecheckDept (java.lang.String recheckDept) {
		this.recheckDept = recheckDept;
	}


	/**
	 * Return the value associated with the column: RECHECK_OTHER
	 */
	public java.lang.String getRecheckOther () {
		return recheckOther;
	}

	/**
	 * Set the value related to the column: RECHECK_OTHER
	 * @param recheckOther the RECHECK_OTHER value
	 */
	public void setRecheckOther (java.lang.String recheckOther) {
		this.recheckOther = recheckOther;
	}


	/**
	 * Return the value associated with the column: REFORM_AREA
	 */
	public java.lang.String getReformArea () {
		return reformArea;
	}

	/**
	 * Set the value related to the column: REFORM_AREA
	 * @param reformArea the REFORM_AREA value
	 */
	public void setReformArea (java.lang.String reformArea) {
		this.reformArea = reformArea;
	}


	/**
	 * Return the value associated with the column: REFORM_BEGIN_DATE
	 */
	public java.sql.Timestamp getReformBeginDate () {
		return reformBeginDate;
	}

	/**
	 * Set the value related to the column: REFORM_BEGIN_DATE
	 * @param reformBeginDate the REFORM_BEGIN_DATE value
	 */
	public void setReformBeginDate (java.sql.Timestamp reformBeginDate) {
		this.reformBeginDate = reformBeginDate;
	}


	/**
	 * Return the value associated with the column: REFORM_LIMIT
	 */
	public java.sql.Date getReformLimit () {
		return reformLimit;
	}

	/**
	 * Set the value related to the column: REFORM_LIMIT
	 * @param reformLimit the REFORM_LIMIT value
	 */
	public void setReformLimit (java.sql.Date reformLimit) {
		this.reformLimit = reformLimit;
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
	 * Return the value associated with the column: jdRecoverForms
	 */
	public java.util.Set<com.justonetech.biz.domain.JdRecoverForm> getJdRecoverForms () {
		return jdRecoverForms;
	}

	/**
	 * Set the value related to the column: jdRecoverForms
	 * @param jdRecoverForms the jdRecoverForms value
	 */
	public void setJdRecoverForms (java.util.Set<com.justonetech.biz.domain.JdRecoverForm> jdRecoverForms) {
		this.jdRecoverForms = jdRecoverForms;
	}


	/**
	 * Return the value associated with the column: jdReformReplies
	 */
	public java.util.Set<com.justonetech.biz.domain.JdReformReply> getJdReformReplies () {
		if(jdReformReplies == null){
			jdReformReplies = new java.util.LinkedHashSet<com.justonetech.biz.domain.JdReformReply>();
		}
		return jdReformReplies;
	}

	/**
	 * Set the value related to the column: jdReformReplies
	 * @param jdReformReplies the jdReformReplies value
	 */
	public void setJdReformReplies (java.util.Set<com.justonetech.biz.domain.JdReformReply> jdReformReplies) {
		this.jdReformReplies = jdReformReplies;
	}

	public void addTojdReformReplies (com.justonetech.biz.domain.JdReformReply jdReformReply) {
		if (null == getJdReformReplies()) setJdReformReplies(new java.util.LinkedHashSet<com.justonetech.biz.domain.JdReformReply>());
		getJdReformReplies().add(jdReformReply);
	}


	/**
	 * Return the value associated with the column: jdStopOrderQuestions
	 */
	public java.util.Set<com.justonetech.biz.domain.JdStopOrderQuestion> getJdStopOrderQuestions () {
        if(jdStopOrderQuestions == null){
            jdStopOrderQuestions = new java.util.LinkedHashSet<com.justonetech.biz.domain.JdStopOrderQuestion>();
        }
		return jdStopOrderQuestions;
	}

	/**
	 * Set the value related to the column: jdStopOrderQuestions
	 * @param jdStopOrderQuestions the jdStopOrderQuestions value
	 */
	public void setJdStopOrderQuestions (java.util.Set<com.justonetech.biz.domain.JdStopOrderQuestion> jdStopOrderQuestions) {
		this.jdStopOrderQuestions = jdStopOrderQuestions;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.JdStopOrder)) return false;
		else {
			com.justonetech.biz.domain.JdStopOrder jdStopOrder = (com.justonetech.biz.domain.JdStopOrder) obj;
			if (null == this.getId() || null == jdStopOrder.getId()) return false;
			else return (this.getId().equals(jdStopOrder.getId()));
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
		builder.append(formCode);
		builder.append(jdTypeCode);
		builder.append(jdAttributeCode);
		builder.append(recordId);
		builder.append(bjbh);
		builder.append(year);
		builder.append(orderNo);
		builder.append(dutyDept);
		builder.append(projectName);
		builder.append(recheckDept);
		builder.append(recheckOther);
		builder.append(reformArea);
		builder.append(reformBeginDate);
		builder.append(reformLimit);
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