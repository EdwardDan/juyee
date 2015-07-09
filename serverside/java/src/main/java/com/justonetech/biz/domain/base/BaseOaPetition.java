package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_PETITION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 信访管理
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 信访管理
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_PETITION"
 */

public abstract class BaseOaPetition  implements Serializable,Auditable {

	public static String REF = "OaPetition";
	public static String PROP_DOC = "doc";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_JBR_USER = "jbrUser";
	public static String PROP_TYPE = "type";
	public static String PROP_DEAL_RESULT = "dealResult";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_SOURCE_DESC = "sourceDesc";
	public static String PROP_CODE = "code";
	public static String PROP_SOURCE = "source";
	public static String PROP_STATUS = "status";
	public static String PROP_TYPE_DESC = "typeDesc";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_END_DATE = "endDate";
	public static String PROP_STATUS_DESC = "statusDesc";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_RECEIVE_DATE = "receiveDate";
	public static String PROP_ADDRESS = "address";
	public static String PROP_JBR_NAME = "jbrName";
	public static String PROP_ID = "id";
	public static String PROP_CONTENT = "content";
	public static String PROP_PERSON = "person";
	public static String PROP_TEL = "tel";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseOaPetition () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaPetition (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*受理编号*/
    /*受理编号*/
	private String code;
	
    /*受理状态中文描述*/
    /*受理状态中文描述*/
	private String statusDesc;
	
    /*信访来源中文描述*/
    /*信访来源中文描述*/
	private String sourceDesc;
	
    /*信访种类中文描述*/
    /*信访种类中文描述*/
	private String typeDesc;
	
    /*信访人*/
    /*信访人*/
	private String person;
	
    /*联系电话*/
    /*联系电话*/
	private String tel;
	
    /*收信日期*/
    /*收信日期*/
	private java.sql.Date receiveDate;
	
    /*联系地址*/
    /*联系地址*/
	private String address;
	
    /*经办人姓名(冗余)*/
    /*经办人姓名(冗余)*/
	private String jbrName;
	
    /*结案日期*/
    /*结案日期*/
	private java.sql.Date endDate;
	
    /*信访事由*/
    /*信访事由*/
	private String content;
	
    /*处理结果*/
    /*处理结果*/
	private String dealResult;
	
    /*备注*/
    /*备注*/
	private String description;
	
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
	private com.justonetech.system.domain.SysUser jbrUser;
	private com.justonetech.system.domain.SysCodeDetail source;
	private com.justonetech.system.domain.SysCodeDetail status;
	private com.justonetech.biz.domain.DocDocument doc;
	private com.justonetech.system.domain.SysCodeDetail type;



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
	 * Return the value associated with the column: STATUS_DESC
	 */
	public String getStatusDesc () {
		return statusDesc;
	}

	/**
	 * Set the value related to the column: STATUS_DESC
	 * @param statusDesc the STATUS_DESC value
	 */
	public void setStatusDesc (String statusDesc) {
		this.statusDesc = statusDesc;
	}


	/**
	 * Return the value associated with the column: SOURCE_DESC
	 */
	public String getSourceDesc () {
		return sourceDesc;
	}

	/**
	 * Set the value related to the column: SOURCE_DESC
	 * @param sourceDesc the SOURCE_DESC value
	 */
	public void setSourceDesc (String sourceDesc) {
		this.sourceDesc = sourceDesc;
	}


	/**
	 * Return the value associated with the column: TYPE_DESC
	 */
	public String getTypeDesc () {
		return typeDesc;
	}

	/**
	 * Set the value related to the column: TYPE_DESC
	 * @param typeDesc the TYPE_DESC value
	 */
	public void setTypeDesc (String typeDesc) {
		this.typeDesc = typeDesc;
	}


	/**
	 * Return the value associated with the column: PERSON
	 */
	public String getPerson () {
		return person;
	}

	/**
	 * Set the value related to the column: PERSON
	 * @param person the PERSON value
	 */
	public void setPerson (String person) {
		this.person = person;
	}


	/**
	 * Return the value associated with the column: TEL
	 */
	public String getTel () {
		return tel;
	}

	/**
	 * Set the value related to the column: TEL
	 * @param tel the TEL value
	 */
	public void setTel (String tel) {
		this.tel = tel;
	}


	/**
	 * Return the value associated with the column: RECEIVE_DATE
	 */
	public java.sql.Date getReceiveDate () {
		return receiveDate;
	}

	/**
	 * Set the value related to the column: RECEIVE_DATE
	 * @param receiveDate the RECEIVE_DATE value
	 */
	public void setReceiveDate (java.sql.Date receiveDate) {
		this.receiveDate = receiveDate;
	}


	/**
	 * Return the value associated with the column: ADDRESS
	 */
	public String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: ADDRESS
	 * @param address the ADDRESS value
	 */
	public void setAddress (String address) {
		this.address = address;
	}


	/**
	 * Return the value associated with the column: JBR_NAME
	 */
	public String getJbrName () {
		return jbrName;
	}

	/**
	 * Set the value related to the column: JBR_NAME
	 * @param jbrName the JBR_NAME value
	 */
	public void setJbrName (String jbrName) {
		this.jbrName = jbrName;
	}


	/**
	 * Return the value associated with the column: END_DATE
	 */
	public java.sql.Date getEndDate () {
		return endDate;
	}

	/**
	 * Set the value related to the column: END_DATE
	 * @param endDate the END_DATE value
	 */
	public void setEndDate (java.sql.Date endDate) {
		this.endDate = endDate;
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
	 * Return the value associated with the column: DEAL_RESULT
	 */
	public String getDealResult () {
		return dealResult;
	}

	/**
	 * Set the value related to the column: DEAL_RESULT
	 * @param dealResult the DEAL_RESULT value
	 */
	public void setDealResult (String dealResult) {
		this.dealResult = dealResult;
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
	 * Return the value associated with the column: JBR_USER_ID
	 */
	public com.justonetech.system.domain.SysUser getJbrUser () {
		return jbrUser;
	}

	/**
	 * Set the value related to the column: JBR_USER_ID
	 * @param jbrUser the JBR_USER_ID value
	 */
	public void setJbrUser (com.justonetech.system.domain.SysUser jbrUser) {
		this.jbrUser = jbrUser;
	}


	/**
	 * Return the value associated with the column: SOURCE_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getSource () {
		return source;
	}

	/**
	 * Set the value related to the column: SOURCE_ID
	 * @param source the SOURCE_ID value
	 */
	public void setSource (com.justonetech.system.domain.SysCodeDetail source) {
		this.source = source;
	}


	/**
	 * Return the value associated with the column: STATUS_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS_ID
	 * @param status the STATUS_ID value
	 */
	public void setStatus (com.justonetech.system.domain.SysCodeDetail status) {
		this.status = status;
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
	 * Return the value associated with the column: TYPE_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getType () {
		return type;
	}

	/**
	 * Set the value related to the column: TYPE_ID
	 * @param type the TYPE_ID value
	 */
	public void setType (com.justonetech.system.domain.SysCodeDetail type) {
		this.type = type;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaPetition)) return false;
		else {
			com.justonetech.biz.domain.OaPetition oaPetition = (com.justonetech.biz.domain.OaPetition) obj;
			if (null == this.getId() || null == oaPetition.getId()) return false;
			else return (this.getId().equals(oaPetition.getId()));
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
		builder.append(statusDesc);
		builder.append(sourceDesc);
		builder.append(typeDesc);
		builder.append(person);
		builder.append(tel);
		builder.append(receiveDate);
		builder.append(address);
		builder.append(jbrName);
		builder.append(endDate);
		builder.append(content);
		builder.append(dealResult);
		builder.append(description);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}