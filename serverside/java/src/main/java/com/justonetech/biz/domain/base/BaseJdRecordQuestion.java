package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the JD_RECORD_QUESTION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 安全质量监督--问题
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 安全质量监督--问题
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : jd
 * Projectable : false
 *
 * @hibernate.class
 *  table="JD_RECORD_QUESTION"
 */

public abstract class BaseJdRecordQuestion  implements Serializable {

	public static String REF = "JdRecordQuestion";
	public static String PROP_UNLAW_DESC = "unlawDesc";
	public static String PROP_QUESTION_DESC = "questionDesc";
	public static String PROP_RECORD_ID = "recordId";
	public static String PROP_DEAL_ADVISE = "dealAdvise";
	public static String PROP_JD_PERSON_DESC = "jdPersonDesc";
	public static String PROP_PLAN_END_DATE = "planEndDate";
	public static String PROP_JD_PERSON_ID = "jdPersonId";
	public static String PROP_IS_FORM = "isForm";
	public static String PROP_JD_TYPE_CODE = "jdTypeCode";
	public static String PROP_TYPE_CODE = "typeCode";
	public static String PROP_ORDER_NO = "orderNo";
	public static String PROP_ID = "id";
	public static String PROP_QUESTION_ID = "questionId";
	public static String PROP_UNLAW_ID = "unlawId";


	// constructors
	public BaseJdRecordQuestion () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseJdRecordQuestion (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*监督id(首次/安全/质量/竣工)*/
    /*监督id(首次/安全/质量/竣工)*/
	private java.lang.Long recordId;
	
    /*监督类别编码*/
    /*监督类别编码*/
	private java.lang.String jdTypeCode;
	
    /*问题类别编码*/
    /*问题类别编码*/
	private java.lang.String typeCode;
	
    /*序号*/
    /*序号*/
	private java.lang.Integer orderNo;
	
    /*问题id*/
    /*问题id*/
	private java.lang.Long questionId;
	
    /*问题描述*/
    /*问题描述*/
	private java.lang.String questionDesc;
	
    /*处理建议*/
    /*处理建议*/
	private java.lang.String dealAdvise;
	
    /*违法条款id*/
    /*违法条款id*/
	private java.lang.Long unlawId;
	
    /*违法条款描述*/
    /*违法条款描述*/
	private java.lang.String unlawDesc;
	
    /*监督员id*/
    /*监督员id*/
	private java.lang.Long jdPersonId;
	
    /*监督员描述*/
    /*监督员描述*/
	private java.lang.String jdPersonDesc;
	
    /*拟整改截止日期*/
    /*拟整改截止日期*/
	private java.sql.Date planEndDate;
	
    /*是否开单*/
    /*是否开单*/
	private java.lang.Boolean isForm;
	



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
	 * Return the value associated with the column: TYPE_CODE
	 */
	public java.lang.String getTypeCode () {
		return typeCode;
	}

	/**
	 * Set the value related to the column: TYPE_CODE
	 * @param typeCode the TYPE_CODE value
	 */
	public void setTypeCode (java.lang.String typeCode) {
		this.typeCode = typeCode;
	}


	/**
	 * Return the value associated with the column: ORDER_NO
	 */
	public java.lang.Integer getOrderNo () {
		return orderNo;
	}

	/**
	 * Set the value related to the column: ORDER_NO
	 * @param orderNo the ORDER_NO value
	 */
	public void setOrderNo (java.lang.Integer orderNo) {
		this.orderNo = orderNo;
	}


	/**
	 * Return the value associated with the column: QUESTION_ID
	 */
	public java.lang.Long getQuestionId () {
		return questionId;
	}

	/**
	 * Set the value related to the column: QUESTION_ID
	 * @param questionId the QUESTION_ID value
	 */
	public void setQuestionId (java.lang.Long questionId) {
		this.questionId = questionId;
	}


	/**
	 * Return the value associated with the column: QUESTION_DESC
	 */
	public java.lang.String getQuestionDesc () {
		return questionDesc;
	}

	/**
	 * Set the value related to the column: QUESTION_DESC
	 * @param questionDesc the QUESTION_DESC value
	 */
	public void setQuestionDesc (java.lang.String questionDesc) {
		this.questionDesc = questionDesc;
	}


	/**
	 * Return the value associated with the column: DEAL_ADVISE
	 */
	public java.lang.String getDealAdvise () {
		return dealAdvise;
	}

	/**
	 * Set the value related to the column: DEAL_ADVISE
	 * @param dealAdvise the DEAL_ADVISE value
	 */
	public void setDealAdvise (java.lang.String dealAdvise) {
		this.dealAdvise = dealAdvise;
	}


	/**
	 * Return the value associated with the column: UNLAW_ID
	 */
	public java.lang.Long getUnlawId () {
		return unlawId;
	}

	/**
	 * Set the value related to the column: UNLAW_ID
	 * @param unlawId the UNLAW_ID value
	 */
	public void setUnlawId (java.lang.Long unlawId) {
		this.unlawId = unlawId;
	}


	/**
	 * Return the value associated with the column: UNLAW_DESC
	 */
	public java.lang.String getUnlawDesc () {
		return unlawDesc;
	}

	/**
	 * Set the value related to the column: UNLAW_DESC
	 * @param unlawDesc the UNLAW_DESC value
	 */
	public void setUnlawDesc (java.lang.String unlawDesc) {
		this.unlawDesc = unlawDesc;
	}


	/**
	 * Return the value associated with the column: JD_PERSON_ID
	 */
	public java.lang.Long getJdPersonId () {
		return jdPersonId;
	}

	/**
	 * Set the value related to the column: JD_PERSON_ID
	 * @param jdPersonId the JD_PERSON_ID value
	 */
	public void setJdPersonId (java.lang.Long jdPersonId) {
		this.jdPersonId = jdPersonId;
	}


	/**
	 * Return the value associated with the column: JD_PERSON_DESC
	 */
	public java.lang.String getJdPersonDesc () {
		return jdPersonDesc;
	}

	/**
	 * Set the value related to the column: JD_PERSON_DESC
	 * @param jdPersonDesc the JD_PERSON_DESC value
	 */
	public void setJdPersonDesc (java.lang.String jdPersonDesc) {
		this.jdPersonDesc = jdPersonDesc;
	}


	/**
	 * Return the value associated with the column: PLAN_END_DATE
	 */
	public java.sql.Date getPlanEndDate () {
		return planEndDate;
	}

	/**
	 * Set the value related to the column: PLAN_END_DATE
	 * @param planEndDate the PLAN_END_DATE value
	 */
	public void setPlanEndDate (java.sql.Date planEndDate) {
		this.planEndDate = planEndDate;
	}


	/**
	 * Return the value associated with the column: IS_FORM
	 */
	public java.lang.Boolean getIsForm () {
		return isForm;
	}

	/**
	 * Set the value related to the column: IS_FORM
	 * @param isForm the IS_FORM value
	 */
	public void setIsForm (java.lang.Boolean isForm) {
		this.isForm = isForm;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.JdRecordQuestion)) return false;
		else {
			com.justonetech.biz.domain.JdRecordQuestion jdRecordQuestion = (com.justonetech.biz.domain.JdRecordQuestion) obj;
			if (null == this.getId() || null == jdRecordQuestion.getId()) return false;
			else return (this.getId().equals(jdRecordQuestion.getId()));
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
		builder.append(recordId);
		builder.append(jdTypeCode);
		builder.append(typeCode);
		builder.append(orderNo);
		builder.append(questionId);
		builder.append(questionDesc);
		builder.append(dealAdvise);
		builder.append(unlawId);
		builder.append(unlawDesc);
		builder.append(jdPersonId);
		builder.append(jdPersonDesc);
		builder.append(planEndDate);
		builder.append(isForm);
		return builder.toString();
	}


}