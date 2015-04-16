package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;
import com.justonetech.core.entity.Treeable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SAFE_PRODUCT_STANDARD table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 安全生产标准
 * SyncTemplatepatterns : tree\w*
 * SyncDao : false
 * TableName : 安全生产标准
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : true
 * SubSystem : safe
 * Projectable : false
 *
 * @hibernate.class
 *  table="SAFE_PRODUCT_STANDARD"
 */

public abstract class BaseSafeProductStandard  implements Serializable, Auditable, Treeable {

	public static String REF = "SafeProductStandard";
	public static String PROP_PARENT = "parent";
	public static String PROP_YEAR = "year";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_IS_LEAF = "isLeaf";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_ITEM_NAME = "itemName";
	public static String PROP_ITEM_NO = "itemNo";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_TREE_ID = "treeId";
	public static String PROP_SCORE = "score";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseSafeProductStandard () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSafeProductStandard (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*年份*/
    /*年份*/
	private Integer year;
	
    /*序号*/
    /*序号*/
	private Integer itemNo;
	
    /*检查项名称*/
    /*检查项名称*/
	private String itemName;
	
    /*分数*/
    /*分数*/
	private Integer score;
	
    /*是否叶节点*/
    /*是否叶节点*/
	private Boolean isLeaf;
	
    /*树形层次*/
    /*树形层次*/
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
	private com.justonetech.biz.domain.SafeProductStandard parent;

	// collections
	private java.util.Set<com.justonetech.biz.domain.SafeProductStandard> safeProductStandards;
	private java.util.Set<com.justonetech.biz.domain.SafeProductCheckItem> safeProductCheckItems;



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
	 * Return the value associated with the column: YEAR
	 */
	public Integer getYear () {
		return year;
	}

	/**
	 * Set the value related to the column: YEAR
	 * @param year the YEAR value
	 */
	public void setYear (Integer year) {
		this.year = year;
	}


	/**
	 * Return the value associated with the column: ITEM_NO
	 */
	public Integer getItemNo () {
		return itemNo;
	}

	/**
	 * Set the value related to the column: ITEM_NO
	 * @param itemNo the ITEM_NO value
	 */
	public void setItemNo (Integer itemNo) {
		this.itemNo = itemNo;
	}


	/**
	 * Return the value associated with the column: ITEM_NAME
	 */
	public String getItemName () {
		return itemName;
	}

	/**
	 * Set the value related to the column: ITEM_NAME
	 * @param itemName the ITEM_NAME value
	 */
	public void setItemName (String itemName) {
		this.itemName = itemName;
	}


	/**
	 * Return the value associated with the column: SCORE
	 */
	public Integer getScore () {
		return score;
	}

	/**
	 * Set the value related to the column: SCORE
	 * @param score the SCORE value
	 */
	public void setScore (Integer score) {
		this.score = score;
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
	 * Return the value associated with the column: PARENT_ID
	 */
	public com.justonetech.biz.domain.SafeProductStandard getParent () {
		return parent;
	}

	/**
	 * Set the value related to the column: PARENT_ID
	 * @param parent the PARENT_ID value
	 */
	public void setParent (com.justonetech.biz.domain.SafeProductStandard parent) {
		this.parent = parent;
	}


	/**
	 * Return the value associated with the column: safeProductStandards
	 */
	public java.util.Set<com.justonetech.biz.domain.SafeProductStandard> getSafeProductStandards () {
		if(safeProductStandards == null){
			safeProductStandards = new java.util.LinkedHashSet<com.justonetech.biz.domain.SafeProductStandard>();
		}
		return safeProductStandards;
	}

	/**
	 * Set the value related to the column: safeProductStandards
	 * @param safeProductStandards the safeProductStandards value
	 */
	public void setSafeProductStandards (java.util.Set<com.justonetech.biz.domain.SafeProductStandard> safeProductStandards) {
		this.safeProductStandards = safeProductStandards;
	}

	public void addTosafeProductStandards (com.justonetech.biz.domain.SafeProductStandard safeProductStandard) {
		if (null == getSafeProductStandards()) setSafeProductStandards(new java.util.LinkedHashSet<com.justonetech.biz.domain.SafeProductStandard>());
		getSafeProductStandards().add(safeProductStandard);
	}


	/**
	 * Return the value associated with the column: safeProductCheckItems
	 */
	public java.util.Set<com.justonetech.biz.domain.SafeProductCheckItem> getSafeProductCheckItems () {
		if(safeProductCheckItems == null){
			safeProductCheckItems = new java.util.LinkedHashSet<com.justonetech.biz.domain.SafeProductCheckItem>();
		}
		return safeProductCheckItems;
	}

	/**
	 * Set the value related to the column: safeProductCheckItems
	 * @param safeProductCheckItems the safeProductCheckItems value
	 */
	public void setSafeProductCheckItems (java.util.Set<com.justonetech.biz.domain.SafeProductCheckItem> safeProductCheckItems) {
		this.safeProductCheckItems = safeProductCheckItems;
	}

	public void addTosafeProductCheckItems (com.justonetech.biz.domain.SafeProductCheckItem safeProductCheckItem) {
		if (null == getSafeProductCheckItems()) setSafeProductCheckItems(new java.util.LinkedHashSet<com.justonetech.biz.domain.SafeProductCheckItem>());
		getSafeProductCheckItems().add(safeProductCheckItem);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.SafeProductStandard)) return false;
		else {
			com.justonetech.biz.domain.SafeProductStandard safeProductStandard = (com.justonetech.biz.domain.SafeProductStandard) obj;
			if (null == this.getId() || null == safeProductStandard.getId()) return false;
			else return (this.getId().equals(safeProductStandard.getId()));
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
		builder.append(year);
		builder.append(itemNo);
		builder.append(itemName);
		builder.append(score);
		builder.append(isLeaf);
		builder.append(treeId);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}