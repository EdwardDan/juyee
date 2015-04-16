package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BPM_PROCESS_TEMPLATE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 流程图模板库
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 流程图模板库
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : workflow
 * Projectable : false
 *
 * @hibernate.class
 *  table="BPM_PROCESS_TEMPLATE"
 */

public abstract class BaseBpmProcessTemplate  implements Serializable {

	public static String REF = "BpmProcessTemplate";
	public static String PROP_NAME = "name";
	public static String PROP_CATEGORY = "category";
	public static String PROP_TOPOLOGY_XML = "topologyXml";
	public static String PROP_ORDER_NO = "orderNo";
	public static String PROP_VML_HTML = "vmlHtml";
	public static String PROP_UPLOAD_TIME = "uploadTime";
	public static String PROP_ID = "id";
	public static String PROP_VML_EMZ = "vmlEmz";
	public static String PROP_CODE = "code";
	public static String PROP_VISIO_PAR = "visioPar";


	// constructors
	public BaseBpmProcessTemplate () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBpmProcessTemplate (java.lang.Long id) {
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
	
    /*控制XML*/
    /*控制XML*/
	private java.lang.String topologyXml;
	
    /*模板压缩包*/
    /*模板压缩包*/
	private byte[] visioPar;
	
    /*VML_HTML*/
    /*VML_HTML*/
	private java.lang.String vmlHtml;
	
    /*VML_EMZ*/
    /*VML_EMZ*/
	private byte[] vmlEmz;
	
    /*编号*/
    /*编号*/
	private java.lang.String code;
	
    /*序号*/
    /*序号*/
	private java.lang.Long orderNo;
	

	// many to one
	private com.justonetech.system.domain.SysCodeDetail category;

	// collections
	private java.util.Set<com.justonetech.biz.domain.BpmProcessDefinition> bpmProcessDefinitions;



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
	 * Return the value associated with the column: TOPOLOGY_XML
	 */
	public java.lang.String getTopologyXml () {
		return topologyXml;
	}

	/**
	 * Set the value related to the column: TOPOLOGY_XML
	 * @param topologyXml the TOPOLOGY_XML value
	 */
	public void setTopologyXml (java.lang.String topologyXml) {
		this.topologyXml = topologyXml;
	}


	/**
	 * Return the value associated with the column: VISIO_PAR
	 */
	public byte[] getVisioPar () {
		return visioPar;
	}

	/**
	 * Set the value related to the column: VISIO_PAR
	 * @param visioPar the VISIO_PAR value
	 */
	public void setVisioPar (byte[] visioPar) {
		this.visioPar = visioPar;
	}


	/**
	 * Return the value associated with the column: VML_HTML
	 */
	public java.lang.String getVmlHtml () {
		return vmlHtml;
	}

	/**
	 * Set the value related to the column: VML_HTML
	 * @param vmlHtml the VML_HTML value
	 */
	public void setVmlHtml (java.lang.String vmlHtml) {
		this.vmlHtml = vmlHtml;
	}


	/**
	 * Return the value associated with the column: VML_EMZ
	 */
	public byte[] getVmlEmz () {
		return vmlEmz;
	}

	/**
	 * Set the value related to the column: VML_EMZ
	 * @param vmlEmz the VML_EMZ value
	 */
	public void setVmlEmz (byte[] vmlEmz) {
		this.vmlEmz = vmlEmz;
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
	 * Return the value associated with the column: bpmProcessDefinitions
	 */
	public java.util.Set<com.justonetech.biz.domain.BpmProcessDefinition> getBpmProcessDefinitions () {
		if(bpmProcessDefinitions == null){
			bpmProcessDefinitions = new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmProcessDefinition>();
		}
		return bpmProcessDefinitions;
	}

	/**
	 * Set the value related to the column: bpmProcessDefinitions
	 * @param bpmProcessDefinitions the bpmProcessDefinitions value
	 */
	public void setBpmProcessDefinitions (java.util.Set<com.justonetech.biz.domain.BpmProcessDefinition> bpmProcessDefinitions) {
		this.bpmProcessDefinitions = bpmProcessDefinitions;
	}

	public void addTobpmProcessDefinitions (com.justonetech.biz.domain.BpmProcessDefinition bpmProcessDefinition) {
		if (null == getBpmProcessDefinitions()) setBpmProcessDefinitions(new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmProcessDefinition>());
		getBpmProcessDefinitions().add(bpmProcessDefinition);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.BpmProcessTemplate)) return false;
		else {
			com.justonetech.biz.domain.BpmProcessTemplate bpmProcessTemplate = (com.justonetech.biz.domain.BpmProcessTemplate) obj;
			if (null == this.getId() || null == bpmProcessTemplate.getId()) return false;
			else return (this.getId().equals(bpmProcessTemplate.getId()));
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
		builder.append(topologyXml);
		builder.append(visioPar);
		builder.append(vmlHtml);
		builder.append(vmlEmz);
		builder.append(code);
		builder.append(orderNo);
		return builder.toString();
	}


}