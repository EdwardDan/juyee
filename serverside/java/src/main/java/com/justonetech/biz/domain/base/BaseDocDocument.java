package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the DOC_DOCUMENT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 文档信息
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 文档信息
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : document
 * Projectable : false
 *
 * @hibernate.class
 *  table="DOC_DOCUMENT"
 */

public abstract class BaseDocDocument  implements Serializable,Auditable {

	public static String REF = "DocDocument";
	public static String PROP_ABSTRACT_CONTENT = "abstractContent";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_FORMAT = "format";
	public static String PROP_DEPT = "dept";
	public static String PROP_AUTHOR = "author";
	public static String PROP_ORIGIN_CODE = "originCode";
	public static String PROP_CODE = "code";
	public static String PROP_NAME = "name";
	public static String PROP_CATEGORY = "category";
	public static String PROP_ID = "id";
	public static String PROP_ACH_STATUS = "achStatus";
	public static String PROP_KEYWORDS = "keywords";
    public static String PROP_CREATE_USER = "createUser";
    public static String PROP_UPDATE_USER = "updateUser";
    public static String PROP_CREATE_TIME = "createTime";
    public static String PROP_UPDATE_TIME = "updateTime";


	// constructors
	public BaseDocDocument () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDocDocument (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*原始编号*/
    /*原始编号*/
	private java.lang.String originCode;
	
    /*编号*/
    /*编号*/
	private java.lang.String code;
	
    /*标题*/
    /*标题*/
	private java.lang.String name;
	
    /*作者*/
    /*作者*/
	private java.lang.String author;
	
    /*关键字*/
    /*关键字*/
	private java.lang.String keywords;
	
    /*摘要*/
    /*摘要*/
	private java.lang.String abstractContent;
	
    /*归档状态*/
    /*归档状态*/
	private java.lang.Integer achStatus;
	
    /*描述*/
    /*描述*/
	private java.lang.String description;

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
	

	// many to one
	private com.justonetech.system.domain.SysDept dept;
	private com.justonetech.biz.domain.DocCategory category;
	private com.justonetech.system.domain.SysCodeDetail format;

	// collections
	private java.util.Set<com.justonetech.biz.domain.DocDocumentAttach> docDocumentAttachs;



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
	 * Return the value associated with the column: ORIGIN_CODE
	 */
	public java.lang.String getOriginCode () {
		return originCode;
	}

	/**
	 * Set the value related to the column: ORIGIN_CODE
	 * @param originCode the ORIGIN_CODE value
	 */
	public void setOriginCode (java.lang.String originCode) {
		this.originCode = originCode;
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
	 * Return the value associated with the column: AUTHOR
	 */
	public java.lang.String getAuthor () {
		return author;
	}

	/**
	 * Set the value related to the column: AUTHOR
	 * @param author the AUTHOR value
	 */
	public void setAuthor (java.lang.String author) {
		this.author = author;
	}


	/**
	 * Return the value associated with the column: KEYWORDS
	 */
	public java.lang.String getKeywords () {
		return keywords;
	}

	/**
	 * Set the value related to the column: KEYWORDS
	 * @param keywords the KEYWORDS value
	 */
	public void setKeywords (java.lang.String keywords) {
		this.keywords = keywords;
	}


	/**
	 * Return the value associated with the column: ABSTRACT_CONTENT
	 */
	public java.lang.String getAbstractContent () {
		return abstractContent;
	}

	/**
	 * Set the value related to the column: ABSTRACT_CONTENT
	 * @param abstractContent the ABSTRACT_CONTENT value
	 */
	public void setAbstractContent (java.lang.String abstractContent) {
		this.abstractContent = abstractContent;
	}


	/**
	 * Return the value associated with the column: CREATE_TIME
     * @return .
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
	 * Return the value associated with the column: ACH_STATUS
	 */
	public java.lang.Integer getAchStatus () {
		return achStatus;
	}

	/**
	 * Set the value related to the column: ACH_STATUS
	 * @param achStatus the ACH_STATUS value
	 */
	public void setAchStatus (java.lang.Integer achStatus) {
		this.achStatus = achStatus;
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
	 * Return the value associated with the column: DEPT_ID
	 */
	public com.justonetech.system.domain.SysDept getDept () {
		return dept;
	}

	/**
	 * Set the value related to the column: DEPT_ID
	 * @param dept the DEPT_ID value
	 */
	public void setDept (com.justonetech.system.domain.SysDept dept) {
		this.dept = dept;
	}


	/**
	 * Return the value associated with the column: CATEGORY_ID
	 */
	public com.justonetech.biz.domain.DocCategory getCategory () {
		return category;
	}

	/**
	 * Set the value related to the column: CATEGORY_ID
	 * @param category the CATEGORY_ID value
	 */
	public void setCategory (com.justonetech.biz.domain.DocCategory category) {
		this.category = category;
	}


	/**
	 * Return the value associated with the column: FORMAT_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getFormat () {
		return format;
	}

	/**
	 * Set the value related to the column: FORMAT_ID
	 * @param format the FORMAT_ID value
	 */
	public void setFormat (com.justonetech.system.domain.SysCodeDetail format) {
		this.format = format;
	}


	/**
	 * Return the value associated with the column: docDocumentAttachs
	 */
	public java.util.Set<com.justonetech.biz.domain.DocDocumentAttach> getDocDocumentAttachs () {
		if(docDocumentAttachs == null){
			docDocumentAttachs = new java.util.LinkedHashSet<com.justonetech.biz.domain.DocDocumentAttach>();
		}
		return docDocumentAttachs;
	}

	/**
	 * Set the value related to the column: docDocumentAttachs
	 * @param docDocumentAttachs the docDocumentAttachs value
	 */
	public void setDocDocumentAttachs (java.util.Set<com.justonetech.biz.domain.DocDocumentAttach> docDocumentAttachs) {
		this.docDocumentAttachs = docDocumentAttachs;
	}

	public void addTodocDocumentAttachs (com.justonetech.biz.domain.DocDocumentAttach docDocumentAttach) {
		if (null == getDocDocumentAttachs()) setDocDocumentAttachs(new java.util.LinkedHashSet<com.justonetech.biz.domain.DocDocumentAttach>());
		getDocDocumentAttachs().add(docDocumentAttach);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.DocDocument)) return false;
		else {
			com.justonetech.biz.domain.DocDocument docDocument = (com.justonetech.biz.domain.DocDocument) obj;
			if (null == this.getId() || null == docDocument.getId()) return false;
			else return (this.getId().equals(docDocument.getId()));
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
		builder.append(originCode);
		builder.append(code);
		builder.append(name);
		builder.append(author);
		builder.append(keywords);
		builder.append(abstractContent);
		builder.append(achStatus);
		builder.append(description);
        builder.append(createUser);
		builder.append(updateUser);
		builder.append(createTime);
		builder.append(updateTime);
		return builder.toString();
	}


}