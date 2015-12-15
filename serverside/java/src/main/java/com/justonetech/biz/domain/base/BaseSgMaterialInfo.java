package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;
import com.justonetech.core.entity.Treeable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SG_MATERIAL_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 施工材料信息
 * SyncTemplatepatterns : tree\w*
 * SyncDao : false
 * TableName : 施工材料信息
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : true
 * SubSystem : sg
 * Projectable : false
 *
 * @hibernate.class
 *  table="SG_MATERIAL_INFO"
 */

public abstract class BaseSgMaterialInfo  implements Serializable, Treeable, Auditable {

	public static String REF = "SgMaterialInfo";
	public static String PROP_PARENT = "parent";
	public static String PROP_PROJECT_TYPE = "projectType";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_IS_LEAF = "isLeaf";
	public static String PROP_AUDIT_REQ = "auditReq";
	public static String PROP_TYPE = "type";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_NO = "no";
	public static String PROP_TREE_ID = "treeId";
	public static String PROP_MATERIAL_NAME = "materialName";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseSgMaterialInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSgMaterialInfo (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*序号*/
    /*序号*/
	private Integer no;

    /*类型*/
    /*类型*/
	private String type;

    /*材料名称*/
    /*材料名称*/
	private String materialName;

    /*审核要求*/
    /*审核要求*/
	private String auditReq;

	/*应交份数*/
    /*应交份数*/
	private Long yjNum;

    /*叶子节点*/
    /*叶子节点*/
	private Boolean isLeaf;

    /*树节点*/
    /*树节点*/
	private String treeId;

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
	private com.justonetech.system.domain.SysCodeDetail projectType;
	private com.justonetech.biz.domain.SgMaterialInfo parent;



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
	 * Return the value associated with the column: NO
	 */
	public Integer getNo () {
		return no;
	}

	/**
	 * Set the value related to the column: NO
	 * @param no the NO value
	 */
	public void setNo (Integer no) {
		this.no = no;
	}


	/**
	 * Return the value associated with the column: TYPE
	 */
	public String getType () {
		return type;
	}

	/**
	 * Set the value related to the column: TYPE
	 * @param type the TYPE value
	 */
	public void setType (String type) {
		this.type = type;
	}


	/**
	 * Return the value associated with the column: MATERIAL_NAME
	 */
	public String getMaterialName () {
		return materialName;
	}

	/**
	 * Set the value related to the column: MATERIAL_NAME
	 * @param materialName the MATERIAL_NAME value
	 */
	public void setMaterialName (String materialName) {
		this.materialName = materialName;
	}


	/**
	 * Return the value associated with the column: AUDIT_REQ
	 */
	public String getAuditReq () {
		return auditReq;
	}

	/**
	 * Set the value related to the column: AUDIT_REQ
	 * @param auditReq the AUDIT_REQ value
	 */
	public void setAuditReq (String auditReq) {
		this.auditReq = auditReq;
	}

	public Long getYjNum() {
		return yjNum;
	}

	public void setYjNum(Long yjNum) {
		this.yjNum = yjNum;
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
	 * Return the value associated with the column: PARENT_ID
	 */
	public com.justonetech.biz.domain.SgMaterialInfo getParent () {
		return parent;
	}

	/**
	 * Set the value related to the column: PARENT_ID
	 * @param parent the PARENT_ID value
	 */
	public void setParent (com.justonetech.biz.domain.SgMaterialInfo parent) {
		this.parent = parent;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.SgMaterialInfo)) return false;
		else {
			com.justonetech.biz.domain.SgMaterialInfo sgMaterialInfo = (com.justonetech.biz.domain.SgMaterialInfo) obj;
			if (null == this.getId() || null == sgMaterialInfo.getId()) return false;
			else return (this.getId().equals(sgMaterialInfo.getId()));
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
