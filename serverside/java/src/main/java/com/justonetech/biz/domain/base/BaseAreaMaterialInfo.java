package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the AREA_MATERIAL_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 区县施工材料信息
 * SyncTemplatepatterns : tree\w*
 * SyncDao : false
 * TableName : 区县施工材料信息
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : true
 * SubSystem : area
 * Projectable : false
 *
 * @hibernate.class
 *  table="AREA_MATERIAL_INFO"
 */

public abstract class BaseAreaMaterialInfo  implements Serializable {

	public static String REF = "AreaMaterialInfo";
	public static String PROP_PARENT = "parent";
	public static String PROP_AUDIT_REQ = "auditReq";
	public static String PROP_TYPE = "type";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_NO = "no";
	public static String PROP_PROJECT_TYPE = "projectType";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_IS_LEAF = "isLeaf";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_YJ_NUM = "yjNum";
	public static String PROP_AUDIT_REQ_GREEN = "auditReqGreen";
	public static String PROP_ID = "id";
	public static String PROP_MATERIAL_NAME = "materialName";
	public static String PROP_TREE_ID = "treeId";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseAreaMaterialInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAreaMaterialInfo (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*序号*/
    /*序号*/
	private java.lang.Integer no;
	
    /*类型*/
    /*类型*/
	private java.lang.String type;
	
    /*材料名称*/
    /*材料名称*/
	private java.lang.String materialName;
	
    /*审核要求*/
    /*审核要求*/
	private java.lang.String auditReq;
	
    /*绿色审核要求*/
    /*绿色审核要求*/
	private java.lang.String auditReqGreen;
	
    /*应交份数*/
    /*应交份数*/
	private java.lang.Integer yjNum;
	
    /*叶子节点*/
    /*叶子节点*/
	private java.lang.Boolean isLeaf;
	
    /*树节点*/
    /*树节点*/
	private java.lang.String treeId;
	
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
	private com.justonetech.biz.domain.AreaMaterialInfo parent;
	private com.justonetech.system.domain.SysCodeDetail projectType;

	// collections
	private java.util.Set<com.justonetech.biz.domain.AreaMaterialInfo> areaMaterialInfos;



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
	 * Return the value associated with the column: NO
	 */
	public java.lang.Integer getNo () {
		return no;
	}

	/**
	 * Set the value related to the column: NO
	 * @param no the NO value
	 */
	public void setNo (java.lang.Integer no) {
		this.no = no;
	}


	/**
	 * Return the value associated with the column: TYPE
	 */
	public java.lang.String getType () {
		return type;
	}

	/**
	 * Set the value related to the column: TYPE
	 * @param type the TYPE value
	 */
	public void setType (java.lang.String type) {
		this.type = type;
	}


	/**
	 * Return the value associated with the column: MATERIAL_NAME
	 */
	public java.lang.String getMaterialName () {
		return materialName;
	}

	/**
	 * Set the value related to the column: MATERIAL_NAME
	 * @param materialName the MATERIAL_NAME value
	 */
	public void setMaterialName (java.lang.String materialName) {
		this.materialName = materialName;
	}


	/**
	 * Return the value associated with the column: AUDIT_REQ
	 */
	public java.lang.String getAuditReq () {
		return auditReq;
	}

	/**
	 * Set the value related to the column: AUDIT_REQ
	 * @param auditReq the AUDIT_REQ value
	 */
	public void setAuditReq (java.lang.String auditReq) {
		this.auditReq = auditReq;
	}


	/**
	 * Return the value associated with the column: AUDIT_REQ_GREEN
	 */
	public java.lang.String getAuditReqGreen () {
		return auditReqGreen;
	}

	/**
	 * Set the value related to the column: AUDIT_REQ_GREEN
	 * @param auditReqGreen the AUDIT_REQ_GREEN value
	 */
	public void setAuditReqGreen (java.lang.String auditReqGreen) {
		this.auditReqGreen = auditReqGreen;
	}


	/**
	 * Return the value associated with the column: YJ_NUM
	 */
	public java.lang.Integer getYjNum () {
		return yjNum;
	}

	/**
	 * Set the value related to the column: YJ_NUM
	 * @param yjNum the YJ_NUM value
	 */
	public void setYjNum (java.lang.Integer yjNum) {
		this.yjNum = yjNum;
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
	 * Return the value associated with the column: PARENT_ID
	 */
	public com.justonetech.biz.domain.AreaMaterialInfo getParent () {
		return parent;
	}

	/**
	 * Set the value related to the column: PARENT_ID
	 * @param parent the PARENT_ID value
	 */
	public void setParent (com.justonetech.biz.domain.AreaMaterialInfo parent) {
		this.parent = parent;
	}


	/**
	 * Return the value associated with the column: PROJECT_TYPE_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getProjectType () {
		return projectType;
	}

	/**
	 * Set the value related to the column: PROJECT_TYPE_ID
	 * @param projectType the PROJECT_TYPE_ID value
	 */
	public void setProjectType (com.justonetech.system.domain.SysCodeDetail projectType) {
		this.projectType = projectType;
	}


	/**
	 * Return the value associated with the column: areaMaterialInfos
	 */
	public java.util.Set<com.justonetech.biz.domain.AreaMaterialInfo> getAreaMaterialInfos () {
		if(areaMaterialInfos == null){
			areaMaterialInfos = new java.util.LinkedHashSet<com.justonetech.biz.domain.AreaMaterialInfo>();
		}
		return areaMaterialInfos;
	}

	/**
	 * Set the value related to the column: areaMaterialInfos
	 * @param areaMaterialInfos the areaMaterialInfos value
	 */
	public void setAreaMaterialInfos (java.util.Set<com.justonetech.biz.domain.AreaMaterialInfo> areaMaterialInfos) {
		this.areaMaterialInfos = areaMaterialInfos;
	}

	public void addToareaMaterialInfos (com.justonetech.biz.domain.AreaMaterialInfo areaMaterialInfo) {
		if (null == getAreaMaterialInfos()) setAreaMaterialInfos(new java.util.LinkedHashSet<com.justonetech.biz.domain.AreaMaterialInfo>());
		getAreaMaterialInfos().add(areaMaterialInfo);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.AreaMaterialInfo)) return false;
		else {
			com.justonetech.biz.domain.AreaMaterialInfo areaMaterialInfo = (com.justonetech.biz.domain.AreaMaterialInfo) obj;
			if (null == this.getId() || null == areaMaterialInfo.getId()) return false;
			else return (this.getId().equals(areaMaterialInfo.getId()));
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
		builder.append(no);
		builder.append(type);
		builder.append(materialName);
		builder.append(auditReq);
		builder.append(auditReqGreen);
		builder.append(yjNum);
		builder.append(isLeaf);
		builder.append(treeId);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}