package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;
import com.justonetech.core.entity.Treeable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_FGLD_SET table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 分管领导审批设置
 * SyncTemplatepatterns : tree\w*
 * SyncDao : false
 * TableName : 分管领导审批设置
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : true
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_FGLD_SET"
 */

public abstract class BaseOaFgldSet  implements Serializable,Treeable, Auditable {

	public static String REF = "OaFgldSet";
	public static String PROP_USER = "user";
	public static String PROP_PARENT = "parent";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_IS_LEAF = "isLeaf";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_TREE_ID = "treeId";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseOaFgldSet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaFgldSet (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*备注*/
    /*备注*/
	private String description;
	
    /*树形层次*/
    /*树形层次*/
	private String treeId;
	
    /*是否叶节点*/
    /*是否叶节点*/
	private Boolean isLeaf;
	
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
	private com.justonetech.biz.domain.OaFgldSet parent;
	private com.justonetech.system.domain.SysUser user;

	// collections
	private java.util.Set<com.justonetech.biz.domain.OaFgldSetItem> oaFgldSetItems;
	private java.util.Set<com.justonetech.biz.domain.OaFgldSet> childsets;



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
	 * Return the value associated with the column: PARENT_ID
	 */
	public com.justonetech.biz.domain.OaFgldSet getParent () {
		return parent;
	}

	/**
	 * Set the value related to the column: PARENT_ID
	 * @param parent the PARENT_ID value
	 */
	public void setParent (com.justonetech.biz.domain.OaFgldSet parent) {
		this.parent = parent;
	}


	/**
	 * Return the value associated with the column: USER_ID
	 */
	public com.justonetech.system.domain.SysUser getUser () {
		return user;
	}

	/**
	 * Set the value related to the column: USER_ID
	 * @param user the USER_ID value
	 */
	public void setUser (com.justonetech.system.domain.SysUser user) {
		this.user = user;
	}


	/**
	 * Return the value associated with the column: oaFgldSetItems
	 */
	public java.util.Set<com.justonetech.biz.domain.OaFgldSetItem> getOaFgldSetItems () {
		if(oaFgldSetItems == null){
			oaFgldSetItems = new java.util.LinkedHashSet<com.justonetech.biz.domain.OaFgldSetItem>();
		}
		return oaFgldSetItems;
	}

	/**
	 * Set the value related to the column: oaFgldSetItems
	 * @param oaFgldSetItems the oaFgldSetItems value
	 */
	public void setOaFgldSetItems (java.util.Set<com.justonetech.biz.domain.OaFgldSetItem> oaFgldSetItems) {
		this.oaFgldSetItems = oaFgldSetItems;
	}

	public void addTooaFgldSetItems (com.justonetech.biz.domain.OaFgldSetItem oaFgldSetItem) {
		if (null == getOaFgldSetItems()) setOaFgldSetItems(new java.util.LinkedHashSet<com.justonetech.biz.domain.OaFgldSetItem>());
		getOaFgldSetItems().add(oaFgldSetItem);
	}


	/**
	 * Return the value associated with the column: childsets
	 */
	public java.util.Set<com.justonetech.biz.domain.OaFgldSet> getChildsets () {
		if(childsets == null){
			childsets = new java.util.LinkedHashSet<com.justonetech.biz.domain.OaFgldSet>();
		}
		return childsets;
	}

	/**
	 * Set the value related to the column: childsets
	 * @param childsets the childsets value
	 */
	public void setChildsets (java.util.Set<com.justonetech.biz.domain.OaFgldSet> childsets) {
		this.childsets = childsets;
	}

	public void addTochildsets (com.justonetech.biz.domain.OaFgldSet oaFgldSet) {
		if (null == getChildsets()) setChildsets(new java.util.LinkedHashSet<com.justonetech.biz.domain.OaFgldSet>());
		getChildsets().add(oaFgldSet);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaFgldSet)) return false;
		else {
			com.justonetech.biz.domain.OaFgldSet oaFgldSet = (com.justonetech.biz.domain.OaFgldSet) obj;
			if (null == this.getId() || null == oaFgldSet.getId()) return false;
			else return (this.getId().equals(oaFgldSet.getId()));
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
		builder.append(description);
		builder.append(treeId);
		builder.append(isLeaf);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}