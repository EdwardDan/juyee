package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BPM_FORM_DATA table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 表单数据
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 表单数据
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : workflow
 * Projectable : false
 *
 * @hibernate.class
 *  table="BPM_FORM_DATA"
 */

public abstract class BaseBpmFormData  implements Serializable {

	public static String REF = "BpmFormData";
	public static String PROP_PERSON_NAME = "personName";
	public static String PROP_BIZ_DATA1 = "bizData1";
	public static String PROP_BIZ_DATA2 = "bizData2";
	public static String PROP_BIZ_DATA3 = "bizData3";
	public static String PROP_BIZ_DATA4 = "bizData4";
	public static String PROP_PROCESS_INSTANCE = "processInstance";
	public static String PROP_BIZ_DATA5 = "bizData5";
	public static String PROP_FORM_XML = "formXml";
	public static String PROP_CODE = "code";
	public static String PROP_TITLE = "title";
	public static String PROP_DEPT_NAME = "deptName";
	public static String PROP_REPORT_DATE = "reportDate";
	public static String PROP_ID = "id";
	public static String PROP_END_TIME = "endTime";
	public static String PROP_START_TIME = "startTime";
	public static String PROP_FORM_TEMPLATE = "formTemplate";
	public static String PROP_CONTENT = "content";


	// constructors
	public BaseBpmFormData () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBpmFormData (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*表单编号*/
    /*表单编号*/
	private java.lang.String code;
	
    /*表单名称*/
    /*表单名称*/
	private java.lang.String title;
	
    /*开始时间*/
    /*开始时间*/
	private java.sql.Timestamp startTime;
	
    /*结束时间*/
    /*结束时间*/
	private java.sql.Timestamp endTime;
	
    /*填写日期*/
    /*填写日期*/
	private java.sql.Date reportDate;
	
    /*单位名称*/
    /*单位名称*/
	private java.lang.String deptName;
	
    /*填写人*/
    /*填写人*/
	private java.lang.String personName;
	
    /*内容提要*/
    /*内容提要*/
	private java.lang.String content;
	
    /*BIZ_DATA1*/
    /*BIZ_DATA1*/
	private java.lang.String bizData1;
	
    /*BIZ_DATA2*/
    /*BIZ_DATA1*/
	private java.lang.String bizData2;
	
    /*BIZ_DATA3*/
    /*BIZ_DATA1*/
	private java.lang.String bizData3;
	
    /*BIZ_DATA4*/
    /*BIZ_DATA1*/
	private java.lang.String bizData4;
	
    /*BIZ_DATA5*/
    /*BIZ_DATA1*/
	private java.lang.String bizData5;
	
    /*表单数据*/
    /*表单数据*/
	private java.lang.String formXml;
	

	// many to one
	private com.justonetech.biz.domain.BpmProcessInstance processInstance;
	private com.justonetech.biz.domain.BpmFormTemplate formTemplate;



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
	 * Return the value associated with the column: TITLE
	 */
	public java.lang.String getTitle () {
		return title;
	}

	/**
	 * Set the value related to the column: TITLE
	 * @param title the TITLE value
	 */
	public void setTitle (java.lang.String title) {
		this.title = title;
	}


	/**
	 * Return the value associated with the column: START_TIME
	 */
	public java.sql.Timestamp getStartTime () {
		return startTime;
	}

	/**
	 * Set the value related to the column: START_TIME
	 * @param startTime the START_TIME value
	 */
	public void setStartTime (java.sql.Timestamp startTime) {
		this.startTime = startTime;
	}


	/**
	 * Return the value associated with the column: END_TIME
	 */
	public java.sql.Timestamp getEndTime () {
		return endTime;
	}

	/**
	 * Set the value related to the column: END_TIME
	 * @param endTime the END_TIME value
	 */
	public void setEndTime (java.sql.Timestamp endTime) {
		this.endTime = endTime;
	}


	/**
	 * Return the value associated with the column: REPORT_DATE
	 */
	public java.sql.Date getReportDate () {
		return reportDate;
	}

	/**
	 * Set the value related to the column: REPORT_DATE
	 * @param reportDate the REPORT_DATE value
	 */
	public void setReportDate (java.sql.Date reportDate) {
		this.reportDate = reportDate;
	}


	/**
	 * Return the value associated with the column: DEPT_NAME
	 */
	public java.lang.String getDeptName () {
		return deptName;
	}

	/**
	 * Set the value related to the column: DEPT_NAME
	 * @param deptName the DEPT_NAME value
	 */
	public void setDeptName (java.lang.String deptName) {
		this.deptName = deptName;
	}


	/**
	 * Return the value associated with the column: PERSON_NAME
	 */
	public java.lang.String getPersonName () {
		return personName;
	}

	/**
	 * Set the value related to the column: PERSON_NAME
	 * @param personName the PERSON_NAME value
	 */
	public void setPersonName (java.lang.String personName) {
		this.personName = personName;
	}


	/**
	 * Return the value associated with the column: CONTENT
	 */
	public java.lang.String getContent () {
		return content;
	}

	/**
	 * Set the value related to the column: CONTENT
	 * @param content the CONTENT value
	 */
	public void setContent (java.lang.String content) {
		this.content = content;
	}


	/**
	 * Return the value associated with the column: BIZ_DATA1
	 */
	public java.lang.String getBizData1 () {
		return bizData1;
	}

	/**
	 * Set the value related to the column: BIZ_DATA1
	 * @param bizData1 the BIZ_DATA1 value
	 */
	public void setBizData1 (java.lang.String bizData1) {
		this.bizData1 = bizData1;
	}


	/**
	 * Return the value associated with the column: BIZ_DATA2
	 */
	public java.lang.String getBizData2 () {
		return bizData2;
	}

	/**
	 * Set the value related to the column: BIZ_DATA2
	 * @param bizData2 the BIZ_DATA2 value
	 */
	public void setBizData2 (java.lang.String bizData2) {
		this.bizData2 = bizData2;
	}


	/**
	 * Return the value associated with the column: BIZ_DATA3
	 */
	public java.lang.String getBizData3 () {
		return bizData3;
	}

	/**
	 * Set the value related to the column: BIZ_DATA3
	 * @param bizData3 the BIZ_DATA3 value
	 */
	public void setBizData3 (java.lang.String bizData3) {
		this.bizData3 = bizData3;
	}


	/**
	 * Return the value associated with the column: BIZ_DATA4
	 */
	public java.lang.String getBizData4 () {
		return bizData4;
	}

	/**
	 * Set the value related to the column: BIZ_DATA4
	 * @param bizData4 the BIZ_DATA4 value
	 */
	public void setBizData4 (java.lang.String bizData4) {
		this.bizData4 = bizData4;
	}


	/**
	 * Return the value associated with the column: BIZ_DATA5
	 */
	public java.lang.String getBizData5 () {
		return bizData5;
	}

	/**
	 * Set the value related to the column: BIZ_DATA5
	 * @param bizData5 the BIZ_DATA5 value
	 */
	public void setBizData5 (java.lang.String bizData5) {
		this.bizData5 = bizData5;
	}


	/**
	 * Return the value associated with the column: FORM_XML
	 */
	public java.lang.String getFormXml () {
		return formXml;
	}

	/**
	 * Set the value related to the column: FORM_XML
	 * @param formXml the FORM_XML value
	 */
	public void setFormXml (java.lang.String formXml) {
		this.formXml = formXml;
	}


	/**
	 * Return the value associated with the column: PROCESS_INSTANCE_ID
	 */
	public com.justonetech.biz.domain.BpmProcessInstance getProcessInstance () {
		return processInstance;
	}

	/**
	 * Set the value related to the column: PROCESS_INSTANCE_ID
	 * @param processInstance the PROCESS_INSTANCE_ID value
	 */
	public void setProcessInstance (com.justonetech.biz.domain.BpmProcessInstance processInstance) {
		this.processInstance = processInstance;
	}


	/**
	 * Return the value associated with the column: FORM_TEMPLATE_ID
	 */
	public com.justonetech.biz.domain.BpmFormTemplate getFormTemplate () {
		return formTemplate;
	}

	/**
	 * Set the value related to the column: FORM_TEMPLATE_ID
	 * @param formTemplate the FORM_TEMPLATE_ID value
	 */
	public void setFormTemplate (com.justonetech.biz.domain.BpmFormTemplate formTemplate) {
		this.formTemplate = formTemplate;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.BpmFormData)) return false;
		else {
			com.justonetech.biz.domain.BpmFormData bpmFormData = (com.justonetech.biz.domain.BpmFormData) obj;
			if (null == this.getId() || null == bpmFormData.getId()) return false;
			else return (this.getId().equals(bpmFormData.getId()));
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
		builder.append(title);
		builder.append(startTime);
		builder.append(endTime);
		builder.append(reportDate);
		builder.append(deptName);
		builder.append(personName);
		builder.append(content);
		builder.append(bizData1);
		builder.append(bizData2);
		builder.append(bizData3);
		builder.append(bizData4);
		builder.append(bizData5);
		builder.append(formXml);
		return builder.toString();
	}


}