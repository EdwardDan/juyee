package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_RECEIVE_OPERATION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 收文管理流转操作
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 收文管理流转操作
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_RECEIVE_OPERATION"
 */

public abstract class BaseOaReceiveOperation  implements Serializable,Auditable {

	public static String REF = "OaReceiveOperation";
    public static String PROP_ID = "id";
    public static String PROP_ORDER_NO = "orderNo";
    public static String PROP_CODE = "code";
    public static String PROP_NAME = "name";
    public static String PROP_STEP = "step";
    public static String PROP_IS_VALID = "isValid";
    public static String PROP_CREATE_USER = "createUser";
    public static String PROP_CREATE_TIME = "createTime";
    public static String PROP_UPDATE_TIME = "updateTime";
    public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseOaReceiveOperation () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaReceiveOperation (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

    // fields
    /*操作序号*/
    /*操作序号*/
    private Long orderNo;

	// fields
    /*操作编码*/
    /*操作编码*/
	private String code;
	
    /*操作名称*/
    /*操作名称*/
	private String name;
	
    /*是否有效*/
    /*是否有效*/
	private Boolean isValid;
	
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
	private com.justonetech.biz.domain.OaReceiveStep step;

	// collections
	private java.util.Set<com.justonetech.biz.domain.OaReceiveNode> oaReceiveNodes;



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
	 * Return the value associated with the column: STEP_ID
	 */
	public com.justonetech.biz.domain.OaReceiveStep getStep () {
		return step;
	}

	/**
	 * Set the value related to the column: STEP_ID
	 * @param step the STEP_ID value
	 */
	public void setStep (com.justonetech.biz.domain.OaReceiveStep step) {
		this.step = step;
	}


	/**
	 * Return the value associated with the column: oaReceiveNodes
	 */
	public java.util.Set<com.justonetech.biz.domain.OaReceiveNode> getOaReceiveNodes () {
		if(oaReceiveNodes == null){
			oaReceiveNodes = new java.util.LinkedHashSet<com.justonetech.biz.domain.OaReceiveNode>();
		}
		return oaReceiveNodes;
	}

	/**
	 * Set the value related to the column: oaReceiveNodes
	 * @param oaReceiveNodes the oaReceiveNodes value
	 */
	public void setOaReceiveNodes (java.util.Set<com.justonetech.biz.domain.OaReceiveNode> oaReceiveNodes) {
		this.oaReceiveNodes = oaReceiveNodes;
	}

	public void addTooaReceiveNodes (com.justonetech.biz.domain.OaReceiveNode oaReceiveNode) {
		if (null == getOaReceiveNodes()) setOaReceiveNodes(new java.util.LinkedHashSet<com.justonetech.biz.domain.OaReceiveNode>());
		getOaReceiveNodes().add(oaReceiveNode);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaReceiveOperation)) return false;
		else {
			com.justonetech.biz.domain.OaReceiveOperation oaReceiveOperation = (com.justonetech.biz.domain.OaReceiveOperation) obj;
			if (null == this.getId() || null == oaReceiveOperation.getId()) return false;
			else return (this.getId().equals(oaReceiveOperation.getId()));
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
        builder.append(orderNo);
        builder.append(code);
		builder.append(name);
		builder.append(isValid);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}