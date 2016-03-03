package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the AREA_PERMIT_OPERATION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 区县施工许可流转操作
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 区县施工许可流转操作
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : area
 * Projectable : false
 *
 * @hibernate.class
 *  table="AREA_PERMIT_OPERATION"
 */

public abstract class BaseAreaPermitOperation  implements Serializable {

	public static String REF = "AreaPermitOperation";
	public static String PROP_STATUS = "status";
	public static String PROP_OPTION_USER = "optionUser";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_SG_PERMIT = "sgPermit";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_OPTION_CODE = "optionCode";
	public static String PROP_OPTION_NAME = "optionName";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseAreaPermitOperation () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAreaPermitOperation (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*操作编码*/
    /*操作编码*/
	private java.lang.String optionCode;
	
    /*操作名称*/
    /*操作名称*/
	private java.lang.String optionName;
	
    /*审核操作人*/
    /*审核操作人*/
	private java.lang.String optionUser;
	
    /*状态*/
    /*状态*/
	private java.lang.Integer status;
	
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
	private com.justonetech.biz.domain.AreaSgPermit sgPermit;



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
	 * Return the value associated with the column: OPTION_CODE
	 */
	public java.lang.String getOptionCode () {
		return optionCode;
	}

	/**
	 * Set the value related to the column: OPTION_CODE
	 * @param optionCode the OPTION_CODE value
	 */
	public void setOptionCode (java.lang.String optionCode) {
		this.optionCode = optionCode;
	}


	/**
	 * Return the value associated with the column: OPTION_NAME
	 */
	public java.lang.String getOptionName () {
		return optionName;
	}

	/**
	 * Set the value related to the column: OPTION_NAME
	 * @param optionName the OPTION_NAME value
	 */
	public void setOptionName (java.lang.String optionName) {
		this.optionName = optionName;
	}


	/**
	 * Return the value associated with the column: OPTION_USER
	 */
	public java.lang.String getOptionUser () {
		return optionUser;
	}

	/**
	 * Set the value related to the column: OPTION_USER
	 * @param optionUser the OPTION_USER value
	 */
	public void setOptionUser (java.lang.String optionUser) {
		this.optionUser = optionUser;
	}


	/**
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.Integer getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (java.lang.Integer status) {
		this.status = status;
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
	 * Return the value associated with the column: SG_PERMIT_ID
	 */
	public com.justonetech.biz.domain.AreaSgPermit getSgPermit () {
		return sgPermit;
	}

	/**
	 * Set the value related to the column: SG_PERMIT_ID
	 * @param sgPermit the SG_PERMIT_ID value
	 */
	public void setSgPermit (com.justonetech.biz.domain.AreaSgPermit sgPermit) {
		this.sgPermit = sgPermit;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.AreaPermitOperation)) return false;
		else {
			com.justonetech.biz.domain.AreaPermitOperation areaPermitOperation = (com.justonetech.biz.domain.AreaPermitOperation) obj;
			if (null == this.getId() || null == areaPermitOperation.getId()) return false;
			else return (this.getId().equals(areaPermitOperation.getId()));
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
		builder.append(optionCode);
		builder.append(optionName);
		builder.append(optionUser);
		builder.append(status);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}