package com.justonetech.system.domain.base;

import com.justonetech.core.entity.Auditable;
import com.justonetech.core.entity.Treeable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SYS_DEPT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 单位部门
 * SyncTemplatepatterns : tree\w*
 * SyncDao : false
 * TableName : 单位部门
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : true
 * SubSystem : system
 * Projectable : false
 *
 * @hibernate.class
 *  table="SYS_DEPT"
 */

public abstract class BaseSysDept  implements Serializable,Auditable,Treeable {

	public static String REF = "SysDept";
	public static String PROP_CITY_NAME = "cityName";
	public static String PROP_CODE = "code";
	public static String PROP_ZIPCODE = "zipcode";
	public static String PROP_CARD_NO = "cardNo";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_ORDER_NO = "orderNo";
	public static String PROP_IS_LEAF = "isLeaf";
	public static String PROP_LINK_ADDRESS = "linkAddress";
	public static String PROP_IS_VALID = "isValid";
	public static String PROP_MANAGER = "manager";
	public static String PROP_PROVINCE_CODE = "provinceCode";
	public static String PROP_PROVINCE_NAME = "provinceName";
	public static String PROP_TEL = "tel";
	public static String PROP_UPDATE_USER = "updateUser";
	public static String PROP_PARENT = "parent";
	public static String PROP_FAX = "fax";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_CITY_CODE = "cityCode";
	public static String PROP_NAME = "name";
	public static String PROP_CATEGORY = "category";
	public static String PROP_IS_TAG = "isTag";
	public static String PROP_ADDRESS = "address";
	public static String PROP_SHORT_NAME = "shortName";
	public static String PROP_MEMO = "memo";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_ID = "id";
	public static String PROP_TREE_ID = "treeId";


	// constructors
	public BaseSysDept () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSysDept (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*单位代码*/
    /*单位代码*/
	private String code;
	
    /*单位名称*/
    /*单位名称*/
	private String name;
	
    /*简称*/
    /*简称*/
	private String shortName;
	
    /*叶节点*/
    /*叶节点*/
	private Boolean isLeaf;
	
    /*树形层次*/
    /*树形层次*/
	private String treeId;
	
    /*机构代码证*/
    /*机构代码证*/
	private String cardNo;
	
    /*注册地编码*/
    /*注册地编码*/
	private String cityCode;
	
    /*注册地名称*/
    /*注册地名称*/
	private String cityName;
	
    /*隶属省市代码*/
    /*隶属省市代码*/
	private String provinceCode;
	
    /*隶属省市名称*/
    /*隶属省市名称*/
	private String provinceName;
	
    /*注册地址*/
    /*注册地址*/
	private String address;
	
    /*排序*/
    /*排序*/
	private Long orderNo;
	
    /*单位标志*/
    /*单位标志  0：单位  1：部门*/
	private Boolean isTag;
	
    /*备注*/
    /*备注*/
	private String memo;
	
    /*创建时间*/
    /*创建时间*/
	private java.sql.Timestamp createTime;
	
    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updateTime;
	
    /*创建人*/
    /*创建人(记录帐号）*/
	private String createUser;
	
    /*更新人*/
    /*更新人(记录帐号）*/
	private String updateUser;
	
    /*是否有效*/
    /*是否有效*/
	private Boolean isValid;
	
    /*单位负责人*/
    /*单位负责人*/
	private String manager;
	
    /*通讯地址*/
    /*通讯地址*/
	private String linkAddress;
	
    /*邮编*/
    /*邮编*/
	private String zipcode;
	
    /*电话*/
    /*电话*/
	private String tel;
	
    /*传真*/
    /*传真*/
	private String fax;
	

	// many to one
	private com.justonetech.system.domain.SysDept parent;
	private com.justonetech.system.domain.SysCodeDetail category;

	// collections
	private java.util.Set<com.justonetech.system.domain.SysDept> children;
	private java.util.Set<com.justonetech.system.domain.SysPersonDept> sysPersonDepts;



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
	 * Return the value associated with the column: SHORT_NAME
	 */
	public String getShortName () {
		return shortName;
	}

	/**
	 * Set the value related to the column: SHORT_NAME
	 * @param shortName the SHORT_NAME value
	 */
	public void setShortName (String shortName) {
		this.shortName = shortName;
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
	 * Return the value associated with the column: CARD_NO
	 */
	public String getCardNo () {
		return cardNo;
	}

	/**
	 * Set the value related to the column: CARD_NO
	 * @param cardNo the CARD_NO value
	 */
	public void setCardNo (String cardNo) {
		this.cardNo = cardNo;
	}


	/**
	 * Return the value associated with the column: CITY_CODE
	 */
	public String getCityCode () {
		return cityCode;
	}

	/**
	 * Set the value related to the column: CITY_CODE
	 * @param cityCode the CITY_CODE value
	 */
	public void setCityCode (String cityCode) {
		this.cityCode = cityCode;
	}


	/**
	 * Return the value associated with the column: CITY_NAME
	 */
	public String getCityName () {
		return cityName;
	}

	/**
	 * Set the value related to the column: CITY_NAME
	 * @param cityName the CITY_NAME value
	 */
	public void setCityName (String cityName) {
		this.cityName = cityName;
	}


	/**
	 * Return the value associated with the column: PROVINCE_CODE
	 */
	public String getProvinceCode () {
		return provinceCode;
	}

	/**
	 * Set the value related to the column: PROVINCE_CODE
	 * @param provinceCode the PROVINCE_CODE value
	 */
	public void setProvinceCode (String provinceCode) {
		this.provinceCode = provinceCode;
	}


	/**
	 * Return the value associated with the column: PROVINCE_NAME
	 */
	public String getProvinceName () {
		return provinceName;
	}

	/**
	 * Set the value related to the column: PROVINCE_NAME
	 * @param provinceName the PROVINCE_NAME value
	 */
	public void setProvinceName (String provinceName) {
		this.provinceName = provinceName;
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
	 * Return the value associated with the column: ORDER_NO
	 */
	public Long getOrderNo () {
		return orderNo;
	}

	/**
	 * Set the value related to the column: ORDER_NO
	 * @param orderNo the ORDER_NO value
	 */
	public void setOrderNo (Long orderNo) {
		this.orderNo = orderNo;
	}


	/**
	 * Return the value associated with the column: IS_TAG
	 */
	public Boolean getIsTag () {
		return isTag;
	}

	/**
	 * Set the value related to the column: IS_TAG
	 * @param isTag the IS_TAG value
	 */
	public void setIsTag (Boolean isTag) {
		this.isTag = isTag;
	}


	/**
	 * Return the value associated with the column: MEMO
	 */
	public String getMemo () {
		return memo;
	}

	/**
	 * Set the value related to the column: MEMO
	 * @param memo the MEMO value
	 */
	public void setMemo (String memo) {
		this.memo = memo;
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
	 * Return the value associated with the column: MANAGER
	 */
	public String getManager () {
		return manager;
	}

	/**
	 * Set the value related to the column: MANAGER
	 * @param manager the MANAGER value
	 */
	public void setManager (String manager) {
		this.manager = manager;
	}


	/**
	 * Return the value associated with the column: LINK_ADDRESS
	 */
	public String getLinkAddress () {
		return linkAddress;
	}

	/**
	 * Set the value related to the column: LINK_ADDRESS
	 * @param linkAddress the LINK_ADDRESS value
	 */
	public void setLinkAddress (String linkAddress) {
		this.linkAddress = linkAddress;
	}


	/**
	 * Return the value associated with the column: ZIPCODE
	 */
	public String getZipcode () {
		return zipcode;
	}

	/**
	 * Set the value related to the column: ZIPCODE
	 * @param zipcode the ZIPCODE value
	 */
	public void setZipcode (String zipcode) {
		this.zipcode = zipcode;
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
	 * Return the value associated with the column: FAX
	 */
	public String getFax () {
		return fax;
	}

	/**
	 * Set the value related to the column: FAX
	 * @param fax the FAX value
	 */
	public void setFax (String fax) {
		this.fax = fax;
	}


	/**
	 * Return the value associated with the column: PARENT_ID
	 */
	public com.justonetech.system.domain.SysDept getParent () {
		return parent;
	}

	/**
	 * Set the value related to the column: PARENT_ID
	 * @param parent the PARENT_ID value
	 */
	public void setParent (com.justonetech.system.domain.SysDept parent) {
		this.parent = parent;
	}


	/**
	 * Return the value associated with the column: CATEGORY_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getCategory () {
		return category;
	}

	/**
	 * Set the value related to the column: CATEGORY_ID
	 * @param category the CATEGORY_ID value
	 */
	public void setCategory (com.justonetech.system.domain.SysCodeDetail category) {
		this.category = category;
	}


	/**
	 * Return the value associated with the column: children
	 */
	public java.util.Set<com.justonetech.system.domain.SysDept> getChildren () {
		if(children == null){
			children = new java.util.LinkedHashSet<com.justonetech.system.domain.SysDept>();
		}
		return children;
	}

	/**
	 * Set the value related to the column: children
	 * @param children the children value
	 */
	public void setChildren (java.util.Set<com.justonetech.system.domain.SysDept> children) {
		this.children = children;
	}

	public void addTochildren (com.justonetech.system.domain.SysDept sysDept) {
		if (null == getChildren()) setChildren(new java.util.LinkedHashSet<com.justonetech.system.domain.SysDept>());
		getChildren().add(sysDept);
	}


	/**
	 * Return the value associated with the column: sysPersonDepts
	 */
	public java.util.Set<com.justonetech.system.domain.SysPersonDept> getSysPersonDepts () {
		return sysPersonDepts;
	}

	/**
	 * Set the value related to the column: sysPersonDepts
	 * @param sysPersonDepts the sysPersonDepts value
	 */
	public void setSysPersonDepts (java.util.Set<com.justonetech.system.domain.SysPersonDept> sysPersonDepts) {
		this.sysPersonDepts = sysPersonDepts;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.system.domain.SysDept)) return false;
		else {
			com.justonetech.system.domain.SysDept sysDept = (com.justonetech.system.domain.SysDept) obj;
			if (null == this.getId() || null == sysDept.getId()) return false;
			else return (this.getId().equals(sysDept.getId()));
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
		builder.append(shortName);
		builder.append(isLeaf);
		builder.append(treeId);
		builder.append(cardNo);
		builder.append(cityCode);
		builder.append(cityName);
		builder.append(provinceCode);
		builder.append(provinceName);
		builder.append(address);
		builder.append(orderNo);
		builder.append(isTag);
		builder.append(memo);
		builder.append(createTime);
		builder.append(updateTime);
		builder.append(createUser);
		builder.append(updateUser);
		builder.append(isValid);
		builder.append(manager);
		builder.append(linkAddress);
		builder.append(zipcode);
		builder.append(tel);
		builder.append(fax);
		return builder.toString();
	}


}