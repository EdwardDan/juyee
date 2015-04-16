package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BPM_FORM_TEMPLATE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 表单模板库
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 表单模板库
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : workflow
 * Projectable : false
 *
 * @hibernate.class
 *  table="BPM_FORM_TEMPLATE"
 */

public abstract class BaseBpmFormTemplate  implements Serializable {

	public static String REF = "BpmFormTemplate";
	public static String PROP_NAME = "name";
	public static String PROP_PAR_XML = "parXml";
	public static String PROP_CATEGORY = "category";
	public static String PROP_ORDER_NO = "orderNo";
	public static String PROP_UPLOAD_TIME = "uploadTime";
	public static String PROP_HTML_TEMPLATE = "htmlTemplate";
	public static String PROP_PAR_HTML = "parHtml";
	public static String PROP_ID = "id";
	public static String PROP_CODE = "code";
	public static String PROP_FORM_PAR = "formPar";
	public static String PROP_COLUMN_XML = "columnXml";


	// constructors
	public BaseBpmFormTemplate () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBpmFormTemplate (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*名称*/
    /*名称*/
	private java.lang.String name;
	
    /*上传时间*/
    /*上传时间*/
	private java.sql.Timestamp uploadTime;
	
    /*页面模板*/
    /*页面模板*/
	private java.lang.String htmlTemplate;
	
    /*数据映射配置*/
    /*数据提取映射配置（针对BpmFormData）*/
	private java.lang.String columnXml;
	
    /*模板压缩包*/
    /*模板压缩包*/
	private byte[] formPar;
	
    /*模板定义HTML*/
    /*模板定义HTML*/
	private java.lang.String parHtml;
	
    /*模板定义XML*/
    /*模板定义XML*/
	private java.lang.String parXml;
	
    /*编号*/
    /*编号*/
	private java.lang.String code;
	
    /*序号*/
    /*序号*/
	private java.lang.Long orderNo;
	

	// many to one
	private com.justonetech.system.domain.SysCodeDetail category;

	// collections
	private java.util.Set<com.justonetech.biz.domain.BpmProcessDefinitionForm> bpmProcessDefinitionForms;
	private java.util.Set<com.justonetech.biz.domain.BpmFormData> bpmFormDatas;
	private java.util.Set<com.justonetech.biz.domain.BpmFormAction> bpmFormActions;



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
	 * Return the value associated with the column: UPLOAD_TIME
	 */
	public java.sql.Timestamp getUploadTime () {
		return uploadTime;
	}

	/**
	 * Set the value related to the column: UPLOAD_TIME
	 * @param uploadTime the UPLOAD_TIME value
	 */
	public void setUploadTime (java.sql.Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}


	/**
	 * Return the value associated with the column: HTML_TEMPLATE
	 */
	public java.lang.String getHtmlTemplate () {
		return htmlTemplate;
	}

	/**
	 * Set the value related to the column: HTML_TEMPLATE
	 * @param htmlTemplate the HTML_TEMPLATE value
	 */
	public void setHtmlTemplate (java.lang.String htmlTemplate) {
		this.htmlTemplate = htmlTemplate;
	}


	/**
	 * Return the value associated with the column: COLUMN_XML
	 */
	public java.lang.String getColumnXml () {
		return columnXml;
	}

	/**
	 * Set the value related to the column: COLUMN_XML
	 * @param columnXml the COLUMN_XML value
	 */
	public void setColumnXml (java.lang.String columnXml) {
		this.columnXml = columnXml;
	}


	/**
	 * Return the value associated with the column: FORM_PAR
	 */
	public byte[] getFormPar () {
		return formPar;
	}

	/**
	 * Set the value related to the column: FORM_PAR
	 * @param formPar the FORM_PAR value
	 */
	public void setFormPar (byte[] formPar) {
		this.formPar = formPar;
	}


	/**
	 * Return the value associated with the column: PAR_HTML
	 */
	public java.lang.String getParHtml () {
		return parHtml;
	}

	/**
	 * Set the value related to the column: PAR_HTML
	 * @param parHtml the PAR_HTML value
	 */
	public void setParHtml (java.lang.String parHtml) {
		this.parHtml = parHtml;
	}


	/**
	 * Return the value associated with the column: PAR_XML
	 */
	public java.lang.String getParXml () {
		return parXml;
	}

	/**
	 * Set the value related to the column: PAR_XML
	 * @param parXml the PAR_XML value
	 */
	public void setParXml (java.lang.String parXml) {
		this.parXml = parXml;
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
	 * Return the value associated with the column: ORDER_NO
	 */
	public java.lang.Long getOrderNo () {
		return orderNo;
	}

	/**
	 * Set the value related to the column: ORDER_NO
	 * @param orderNo the ORDER_NO value
	 */
	public void setOrderNo (java.lang.Long orderNo) {
		this.orderNo = orderNo;
	}


	/**
	 * Return the value associated with the column: CATEGORY_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getCategory () {
		return category;
	}

	/**
	 * Set the value related to the column: CATEGORY_ID
	 * @param category the CATEGORY_ID value
	 */
	public void setCategory (com.justonetech.system.domain.SysCodeDetail category) {
		this.category = category;
	}


	/**
	 * Return the value associated with the column: bpmProcessDefinitionForms
	 */
	public java.util.Set<com.justonetech.biz.domain.BpmProcessDefinitionForm> getBpmProcessDefinitionForms () {
		if(bpmProcessDefinitionForms == null){
			bpmProcessDefinitionForms = new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmProcessDefinitionForm>();
		}
		return bpmProcessDefinitionForms;
	}

	/**
	 * Set the value related to the column: bpmProcessDefinitionForms
	 * @param bpmProcessDefinitionForms the bpmProcessDefinitionForms value
	 */
	public void setBpmProcessDefinitionForms (java.util.Set<com.justonetech.biz.domain.BpmProcessDefinitionForm> bpmProcessDefinitionForms) {
		this.bpmProcessDefinitionForms = bpmProcessDefinitionForms;
	}

	public void addTobpmProcessDefinitionForms (com.justonetech.biz.domain.BpmProcessDefinitionForm bpmProcessDefinitionForm) {
		if (null == getBpmProcessDefinitionForms()) setBpmProcessDefinitionForms(new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmProcessDefinitionForm>());
		getBpmProcessDefinitionForms().add(bpmProcessDefinitionForm);
	}


	/**
	 * Return the value associated with the column: bpmFormDatas
	 */
	public java.util.Set<com.justonetech.biz.domain.BpmFormData> getBpmFormDatas () {
		if(bpmFormDatas == null){
			bpmFormDatas = new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmFormData>();
		}
		return bpmFormDatas;
	}

	/**
	 * Set the value related to the column: bpmFormDatas
	 * @param bpmFormDatas the bpmFormDatas value
	 */
	public void setBpmFormDatas (java.util.Set<com.justonetech.biz.domain.BpmFormData> bpmFormDatas) {
		this.bpmFormDatas = bpmFormDatas;
	}

	public void addTobpmFormDatas (com.justonetech.biz.domain.BpmFormData bpmFormData) {
		if (null == getBpmFormDatas()) setBpmFormDatas(new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmFormData>());
		getBpmFormDatas().add(bpmFormData);
	}


	/**
	 * Return the value associated with the column: bpmFormActions
	 */
	public java.util.Set<com.justonetech.biz.domain.BpmFormAction> getBpmFormActions () {
		if(bpmFormActions == null){
			bpmFormActions = new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmFormAction>();
		}
		return bpmFormActions;
	}

	/**
	 * Set the value related to the column: bpmFormActions
	 * @param bpmFormActions the bpmFormActions value
	 */
	public void setBpmFormActions (java.util.Set<com.justonetech.biz.domain.BpmFormAction> bpmFormActions) {
		this.bpmFormActions = bpmFormActions;
	}

	public void addTobpmFormActions (com.justonetech.biz.domain.BpmFormAction bpmFormAction) {
		if (null == getBpmFormActions()) setBpmFormActions(new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmFormAction>());
		getBpmFormActions().add(bpmFormAction);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.BpmFormTemplate)) return false;
		else {
			com.justonetech.biz.domain.BpmFormTemplate bpmFormTemplate = (com.justonetech.biz.domain.BpmFormTemplate) obj;
			if (null == this.getId() || null == bpmFormTemplate.getId()) return false;
			else return (this.getId().equals(bpmFormTemplate.getId()));
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
		builder.append(name);
		builder.append(uploadTime);
		builder.append(htmlTemplate);
		builder.append(columnXml);
		builder.append(formPar);
		builder.append(parHtml);
		builder.append(parXml);
		builder.append(code);
		builder.append(orderNo);
		return builder.toString();
	}


}