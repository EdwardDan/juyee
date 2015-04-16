package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the POLLING_DICT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 巡查字典
 * SyncTemplatepatterns : tree\w*
 * SyncDao : false
 * TableName : 巡查字典
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : true
 * SubSystem : polling
 * Projectable : false
 *
 * @hibernate.class
 *  table="POLLING_DICT"
 */

public abstract class BasePollingDict implements Serializable, com.justonetech.core.entity.Treeable,Auditable {

	public static String REF = "PollingDict";
	public static String PROP_PARENT = "parent";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_REGISTER_TYPE = "registerType";
	public static String PROP_NAME = "name";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_SAFE_TYPE = "safeType";
	public static String PROP_IS_LEAF = "isLeaf";
	public static String PROP_ORDER_NO = "orderNo";
	public static String PROP_IS_VALID = "isValid";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_ID = "id";
	public static String PROP_REFORM_TYPE = "reformType";
	public static String PROP_REF_RULE = "refRule";
	public static String PROP_TREE_ID = "treeId";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BasePollingDict () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePollingDict (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*法规依据*/
    /*法规依据*/
	private java.lang.String refRule;
	
    /*名称*/
    /*名称*/
	private java.lang.String name;
	
    /*叶节点*/
    /*叶节点*/
	private java.lang.Boolean isLeaf;
	
    /*树形层次*/
    /*树形层次*/
	private java.lang.String treeId;
	
    /*是否有效*/
    /*是否有效*/
	private java.lang.Boolean isValid;
	
    /*排序号*/
    /*排序号*/
	private java.lang.Long orderNo;
	
    /*备注*/
    /*备注*/
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
	private com.justonetech.system.domain.SysCodeDetail reformType;
	private com.justonetech.system.domain.SysCodeDetail registerType;
	private com.justonetech.system.domain.SysCodeDetail safeType;
	private com.justonetech.biz.domain.PollingDict parent;

	// collections
	private java.util.Set<com.justonetech.biz.domain.PollingDict> pollingDicts;



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
	 * Return the value associated with the column: REF_RULE
	 */
	public java.lang.String getRefRule () {
		return refRule;
	}

	/**
	 * Set the value related to the column: REF_RULE
	 * @param refRule the REF_RULE value
	 */
	public void setRefRule (java.lang.String refRule) {
		this.refRule = refRule;
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
	 * Return the value associated with the column: IS_VALID
	 */
	public java.lang.Boolean getIsValid () {
		return isValid;
	}

	/**
	 * Set the value related to the column: IS_VALID
	 * @param isValid the IS_VALID value
	 */
	public void setIsValid (java.lang.Boolean isValid) {
		this.isValid = isValid;
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
	 * Return the value associated with the column: REFORM_TYPE
	 */
	public com.justonetech.system.domain.SysCodeDetail getReformType () {
		return reformType;
	}

	/**
	 * Set the value related to the column: REFORM_TYPE
	 * @param reformType the REFORM_TYPE value
	 */
	public void setReformType (com.justonetech.system.domain.SysCodeDetail reformType) {
		this.reformType = reformType;
	}


	/**
	 * Return the value associated with the column: REGISTER_TYPE
	 */
	public com.justonetech.system.domain.SysCodeDetail getRegisterType () {
		return registerType;
	}

	/**
	 * Set the value related to the column: REGISTER_TYPE
	 * @param registerType the REGISTER_TYPE value
	 */
	public void setRegisterType (com.justonetech.system.domain.SysCodeDetail registerType) {
		this.registerType = registerType;
	}


	/**
	 * Return the value associated with the column: SAFE_TYPE
	 */
	public com.justonetech.system.domain.SysCodeDetail getSafeType () {
		return safeType;
	}

	/**
	 * Set the value related to the column: SAFE_TYPE
	 * @param safeType the SAFE_TYPE value
	 */
	public void setSafeType (com.justonetech.system.domain.SysCodeDetail safeType) {
		this.safeType = safeType;
	}


	/**
	 * Return the value associated with the column: PARENT_ID
	 */
	public com.justonetech.biz.domain.PollingDict getParent () {
		return parent;
	}

	/**
	 * Set the value related to the column: PARENT_ID
	 * @param parent the PARENT_ID value
	 */
	public void setParent (com.justonetech.biz.domain.PollingDict parent) {
		this.parent = parent;
	}


	/**
	 * Return the value associated with the column: pollingDicts
	 */
	public java.util.Set<com.justonetech.biz.domain.PollingDict> getPollingDicts () {
		if(pollingDicts == null){
			pollingDicts = new java.util.LinkedHashSet<com.justonetech.biz.domain.PollingDict>();
		}
		return pollingDicts;
	}

	/**
	 * Set the value related to the column: pollingDicts
	 * @param pollingDicts the pollingDicts value
	 */
	public void setPollingDicts (java.util.Set<com.justonetech.biz.domain.PollingDict> pollingDicts) {
		this.pollingDicts = pollingDicts;
	}

	public void addTopollingDicts (com.justonetech.biz.domain.PollingDict pollingDict) {
		if (null == getPollingDicts()) setPollingDicts(new java.util.LinkedHashSet<com.justonetech.biz.domain.PollingDict>());
		getPollingDicts().add(pollingDict);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.PollingDict)) return false;
		else {
			com.justonetech.biz.domain.PollingDict pollingDict = (com.justonetech.biz.domain.PollingDict) obj;
			if (null == this.getId() || null == pollingDict.getId()) return false;
			else return (this.getId().equals(pollingDict.getId()));
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
		builder.append(refRule);
		builder.append(name);
		builder.append(isLeaf);
		builder.append(treeId);
		builder.append(isValid);
		builder.append(orderNo);
		builder.append(description);
		builder.append(createTime);
		builder.append(updateTime);
		builder.append(updateUser);
		builder.append(createUser);
		return builder.toString();
	}


}