package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Treeable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the DOC_CATEGORY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 文档目录
 * SyncTemplatepatterns : tree\w*
 * SyncDao : false
 * TableName : 文档目录
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : true
 * SubSystem : document
 * Projectable : false
 *
 * @hibernate.class
 *  table="DOC_CATEGORY"
 */

public abstract class BaseDocCategory  implements Serializable,Treeable {

	public static String REF = "DocCategory";
	public static String PROP_NAME = "name";
	public static String PROP_PARENT = "parent";
	public static String PROP_BIZ_CODE = "bizCode";
	public static String PROP_IS_LEAF = "isLeaf";
	public static String PROP_BIZ_NAME = "bizName";
	public static String PROP_ID = "id";
	public static String PROP_TREE_ID = "treeId";
	public static String PROP_CODE = "code";
	public static String PROP_PATH = "path";


	// constructors
	public BaseDocCategory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDocCategory (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*编号*/
    /*编号*/
	private java.lang.String code;
	
    /*名称*/
    /*名称*/
	private java.lang.String name;
	
    /*路径*/
    /*路径*/
	private java.lang.String path;
	
    /*业务编码*/
    /*业务编码*/
	private java.lang.String bizCode;
	
    /*业务名称*/
    /*业务名称*/
	private java.lang.String bizName;
	
    /*是否叶节点*/
    /*是否叶节点*/
	private java.lang.Boolean isLeaf;
	
    /*树形层次*/
    /*树形层次*/
	private java.lang.String treeId;
	

	// many to one
	private com.justonetech.biz.domain.DocCategory parent;

	// collections
	private java.util.Set<com.justonetech.biz.domain.DocCategory> docCategories;
	private java.util.Set<com.justonetech.biz.domain.DocDocument> docDocuments;



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
	 * Return the value associated with the column: PATH
	 */
	public java.lang.String getPath () {
		return path;
	}

	/**
	 * Set the value related to the column: PATH
	 * @param path the PATH value
	 */
	public void setPath (java.lang.String path) {
		this.path = path;
	}


	/**
	 * Return the value associated with the column: BIZ_CODE
	 */
	public java.lang.String getBizCode () {
		return bizCode;
	}

	/**
	 * Set the value related to the column: BIZ_CODE
	 * @param bizCode the BIZ_CODE value
	 */
	public void setBizCode (java.lang.String bizCode) {
		this.bizCode = bizCode;
	}


	/**
	 * Return the value associated with the column: BIZ_NAME
	 */
	public java.lang.String getBizName () {
		return bizName;
	}

	/**
	 * Set the value related to the column: BIZ_NAME
	 * @param bizName the BIZ_NAME value
	 */
	public void setBizName (java.lang.String bizName) {
		this.bizName = bizName;
	}


	/**
	 * Return the value associated with the column: IS_LEAF
	 */
	public java.lang.Boolean getIsLeaf () {
		return isLeaf;
	}

	/**
	 * Set the value related to the column: IS_LEAF
	 * @param isLeaf the IS_LEAF value
	 */
	public void setIsLeaf (java.lang.Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}


	/**
	 * Return the value associated with the column: TREE_ID
	 */
	public java.lang.String getTreeId () {
		return treeId;
	}

	/**
	 * Set the value related to the column: TREE_ID
	 * @param treeId the TREE_ID value
	 */
	public void setTreeId (java.lang.String treeId) {
		this.treeId = treeId;
	}


	/**
	 * Return the value associated with the column: PARENT_ID
	 */
	public com.justonetech.biz.domain.DocCategory getParent () {
		return parent;
	}

	/**
	 * Set the value related to the column: PARENT_ID
	 * @param parent the PARENT_ID value
	 */
	public void setParent (com.justonetech.biz.domain.DocCategory parent) {
		this.parent = parent;
	}


	/**
	 * Return the value associated with the column: docCategories
	 */
	public java.util.Set<com.justonetech.biz.domain.DocCategory> getDocCategories () {
		if(docCategories == null){
			docCategories = new java.util.LinkedHashSet<com.justonetech.biz.domain.DocCategory>();
		}
		return docCategories;
	}

	/**
	 * Set the value related to the column: docCategories
	 * @param docCategories the docCategories value
	 */
	public void setDocCategories (java.util.Set<com.justonetech.biz.domain.DocCategory> docCategories) {
		this.docCategories = docCategories;
	}

	public void addTodocCategories (com.justonetech.biz.domain.DocCategory docCategory) {
		if (null == getDocCategories()) setDocCategories(new java.util.LinkedHashSet<com.justonetech.biz.domain.DocCategory>());
		getDocCategories().add(docCategory);
	}


	/**
	 * Return the value associated with the column: docDocuments
	 */
	public java.util.Set<com.justonetech.biz.domain.DocDocument> getDocDocuments () {
		if(docDocuments == null){
			docDocuments = new java.util.LinkedHashSet<com.justonetech.biz.domain.DocDocument>();
		}
		return docDocuments;
	}

	/**
	 * Set the value related to the column: docDocuments
	 * @param docDocuments the docDocuments value
	 */
	public void setDocDocuments (java.util.Set<com.justonetech.biz.domain.DocDocument> docDocuments) {
		this.docDocuments = docDocuments;
	}

	public void addTodocDocuments (com.justonetech.biz.domain.DocDocument docDocument) {
		if (null == getDocDocuments()) setDocDocuments(new java.util.LinkedHashSet<com.justonetech.biz.domain.DocDocument>());
		getDocDocuments().add(docDocument);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.DocCategory)) return false;
		else {
			com.justonetech.biz.domain.DocCategory docCategory = (com.justonetech.biz.domain.DocCategory) obj;
			if (null == this.getId() || null == docCategory.getId()) return false;
			else return (this.getId().equals(docCategory.getId()));
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
		builder.append(name);
		builder.append(path);
		builder.append(bizCode);
		builder.append(bizName);
		builder.append(isLeaf);
		builder.append(treeId);
		return builder.toString();
	}


}