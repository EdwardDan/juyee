package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the DOC_DOCUMENT_ATTACH table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 文档附件
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 文档附件
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : document
 * Projectable : false
 *
 * @hibernate.class
 *  table="DOC_DOCUMENT_ATTACH"
 */

public abstract class BaseDocDocumentAttach  implements Serializable,Auditable {

	public static String REF = "DocDocumentAttach";
	public static String PROP_FILE_SIZE = "fileSize";
	public static String PROP_SAVE_FILE_NAME = "saveFileName";
	public static String PROP_DOCUMENT = "document";
	public static String PROP_DOC_VERSION = "docVersion";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_MIME_TYPE = "mimeType";
	public static String PROP_FILE_NAME = "fileName";
	public static String PROP_ID = "id";
	public static String PROP_UPDATE_DATE = "updateDate";
	public static String PROP_CONTENT = "content";
	public static String PROP_CREATE_DATE = "createDate";


	// constructors
	public BaseDocDocumentAttach () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDocDocumentAttach (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*创建人*/
    /*创建人*/
	private java.lang.String createUser;
	
    /*附件名称*/
    /*附件名称*/
	private java.lang.String fileName;
	
    /*保存文件名称*/
    /*保存文件名称*/
	private java.lang.String saveFileName;
	
    /*媒体类型*/
	private java.lang.String mimeType;
	
    /*创建日期*/
    /*创建日期*/
	private java.sql.Date createDate;
	
    /*最后修改日期*/
    /*最后修改日期*/
	private java.sql.Date updateDate;
	
    /*文件大小*/
    /*文件大小*/
	private java.lang.Double fileSize;
	
    /*说明*/
    /*说明*/
	private java.lang.String content;
	
    /*备注*/
    /*备注*/
	private java.lang.String description;
	
    /*版本*/
    /*版本*/
	private java.lang.Double docVersion;
	

	// many to one
	private com.justonetech.biz.domain.DocDocument document;



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
	 * Return the value associated with the column: FILE_NAME
	 */
	public java.lang.String getFileName () {
		return fileName;
	}

	/**
	 * Set the value related to the column: FILE_NAME
	 * @param fileName the FILE_NAME value
	 */
	public void setFileName (java.lang.String fileName) {
		this.fileName = fileName;
	}


	/**
	 * Return the value associated with the column: SAVE_FILE_NAME
	 */
	public java.lang.String getSaveFileName () {
		return saveFileName;
	}

	/**
	 * Set the value related to the column: SAVE_FILE_NAME
	 * @param saveFileName the SAVE_FILE_NAME value
	 */
	public void setSaveFileName (java.lang.String saveFileName) {
		this.saveFileName = saveFileName;
	}


	/**
	 * Return the value associated with the column: MIME_TYPE
	 */
	public java.lang.String getMimeType () {
		return mimeType;
	}

	/**
	 * Set the value related to the column: MIME_TYPE
	 * @param mimeType the MIME_TYPE value
	 */
	public void setMimeType (java.lang.String mimeType) {
		this.mimeType = mimeType;
	}


	/**
	 * Return the value associated with the column: CREATE_DATE
	 */
	public java.sql.Date getCreateDate () {
		return createDate;
	}

	/**
	 * Set the value related to the column: CREATE_DATE
	 * @param createDate the CREATE_DATE value
	 */
	public void setCreateDate (java.sql.Date createDate) {
		this.createDate = createDate;
	}


	/**
	 * Return the value associated with the column: UPDATE_DATE
	 */
	public java.sql.Date getUpdateDate () {
		return updateDate;
	}

	/**
	 * Set the value related to the column: UPDATE_DATE
	 * @param updateDate the UPDATE_DATE value
	 */
	public void setUpdateDate (java.sql.Date updateDate) {
		this.updateDate = updateDate;
	}


	/**
	 * Return the value associated with the column: FILE_SIZE
	 */
	public java.lang.Double getFileSize () {
		return fileSize;
	}

	/**
	 * Set the value related to the column: FILE_SIZE
	 * @param fileSize the FILE_SIZE value
	 */
	public void setFileSize (java.lang.Double fileSize) {
		this.fileSize = fileSize;
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
	 * Return the value associated with the column: DOC_VERSION
	 */
	public java.lang.Double getDocVersion () {
		return docVersion;
	}

	/**
	 * Set the value related to the column: DOC_VERSION
	 * @param docVersion the DOC_VERSION value
	 */
	public void setDocVersion (java.lang.Double docVersion) {
		this.docVersion = docVersion;
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



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.DocDocumentAttach)) return false;
		else {
			com.justonetech.biz.domain.DocDocumentAttach docDocumentAttach = (com.justonetech.biz.domain.DocDocumentAttach) obj;
			if (null == this.getId() || null == docDocumentAttach.getId()) return false;
			else return (this.getId().equals(docDocumentAttach.getId()));
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
		builder.append(createUser);
		builder.append(fileName);
		builder.append(saveFileName);
		builder.append(mimeType);
		builder.append(createDate);
		builder.append(updateDate);
		builder.append(fileSize);
		builder.append(content);
		builder.append(description);
		builder.append(docVersion);
		return builder.toString();
	}


}