package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PROJ_NODE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目形象进度节点管理
 * SyncTemplatepatterns : tree\w*
 * SyncDao : false
 * TableName : 项目形象进度节点管理
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : true
 * SubSystem : project
 * Projectable : false
 *
 * @hibernate.class
 *  table="PROJ_NODE"
 */

public abstract class BaseProjNode  implements Serializable {

	public static String REF = "ProjNode";
	public static String PROP_NAME = "name";
	public static String PROP_PARENT = "parent";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_IS_LEAF = "isLeaf";
	public static String PROP_IS_VALID = "isValid";
	public static String PROP_ID = "id";
	public static String PROP_TREE_ID = "treeId";
	public static String PROP_CODE = "code";


	// constructors
	public BaseProjNode () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProjNode (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*编码*/
    /*编码*/
	private String code;
	
    /*名称*/
    /*名称*/
	private String name;
	
    /*是否有效*/
    /*是否有效*/
	private Boolean isValid;
	
    /*备注*/
    /*备注*/
	private String description;
	
    /*是否叶节点*/
    /*是否叶节点*/
	private Boolean isLeaf;
	
    /*树形层次*/
    /*树形层次*/
	private String treeId;
	

	// many to one
	private com.justonetech.biz.domain.ProjNode parent;

	// collections
	private java.util.Set<com.justonetech.biz.domain.ProjNode> projNodes;



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
	 * Return the value associated with the column: NAME
	 */
	public String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: NAME
	 * @param name the NAME value
	 */
	public void setName (String name) {
		this.name = name;
	}


	/**
	 * Return the value associated with the column: IS_VALID
	 */
	public Boolean getIsValid () {
		return isValid;
	}

	/**
	 * Set the value related to the column: IS_VALID
	 * @param isValid the IS_VALID value
	 */
	public void setIsValid (Boolean isValid) {
		this.isValid = isValid;
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
	 * Return the value associated with the column: IS_LEAF
	 */
	public Boolean getIsLeaf () {
		return isLeaf;
	}

	/**
	 * Set the value related to the column: IS_LEAF
	 * @param isLeaf the IS_LEAF value
	 */
	public void setIsLeaf (Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}


	/**
	 * Return the value associated with the column: TREE_ID
	 */
	public String getTreeId () {
		return treeId;
	}

	/**
	 * Set the value related to the column: TREE_ID
	 * @param treeId the TREE_ID value
	 */
	public void setTreeId (String treeId) {
		this.treeId = treeId;
	}


	/**
	 * Return the value associated with the column: PARENT_ID
	 */
	public com.justonetech.biz.domain.ProjNode getParent () {
		return parent;
	}

	/**
	 * Set the value related to the column: PARENT_ID
	 * @param parent the PARENT_ID value
	 */
	public void setParent (com.justonetech.biz.domain.ProjNode parent) {
		this.parent = parent;
	}


	/**
	 * Return the value associated with the column: projNodes
	 */
	public java.util.Set<com.justonetech.biz.domain.ProjNode> getProjNodes () {
		if(projNodes == null){
			projNodes = new java.util.LinkedHashSet<com.justonetech.biz.domain.ProjNode>();
		}
		return projNodes;
	}

	/**
	 * Set the value related to the column: projNodes
	 * @param projNodes the projNodes value
	 */
	public void setProjNodes (java.util.Set<com.justonetech.biz.domain.ProjNode> projNodes) {
		this.projNodes = projNodes;
	}

	public void addToprojNodes (com.justonetech.biz.domain.ProjNode projNode) {
		if (null == getProjNodes()) setProjNodes(new java.util.LinkedHashSet<com.justonetech.biz.domain.ProjNode>());
		getProjNodes().add(projNode);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ProjNode)) return false;
		else {
			com.justonetech.biz.domain.ProjNode projNode = (com.justonetech.biz.domain.ProjNode) obj;
			if (null == this.getId() || null == projNode.getId()) return false;
			else return (this.getId().equals(projNode.getId()));
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
		builder.append(isValid);
		builder.append(description);
		builder.append(isLeaf);
		builder.append(treeId);
		return builder.toString();
	}


}