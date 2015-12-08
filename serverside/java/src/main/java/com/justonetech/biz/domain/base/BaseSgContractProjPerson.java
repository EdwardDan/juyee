package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SG_CONTRACT_PROJ_PERSON table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 合同项目负责人信息
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 合同项目负责人信息
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : sg
 * Projectable : false
 *
 * @hibernate.class
 *  table="SG_CONTRACT_PROJ_PERSON"
 */

public abstract class BaseSgContractProjPerson  implements Serializable {

	public static String REF = "SgContractProjPerson";
	public static String PROP_UNIT_PHONE = "unitPhone";
	public static String PROP_UNIT_NAME = "unitName";
	public static String PROP_CONTRACT_CODE = "contractCode";
	public static String PROP_UNIT_MAIN_PERSON = "unitMainPerson";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_SG_PERMIT = "sgPermit";
	public static String PROP_NUM = "num";
	public static String PROP_UNIT_ID_CARD = "unitIdCard";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_UNIT_TYPE = "unitType";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseSgContractProjPerson () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSgContractProjPerson (java.lang.Long id) {
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
	private java.lang.Integer num;
	
    /*合同信息报送编号*/
    /*合同信息报送编号*/
	private java.lang.String contractCode;
	
    /*单位名称*/
    /*单位名称*/
	private java.lang.String unitName;
	
    /*单位负责人*/
    /*单位负责人*/
	private java.lang.String unitMainPerson;
	
    /*身份证号*/
    /*身份证号*/
	private java.lang.String unitIdCard;
	
    /*电话*/
    /*电话*/
	private java.lang.String unitPhone;
	
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
	private com.justonetech.system.domain.SysCodeDetail unitType;
	private com.justonetech.biz.domain.SgPermit sgPermit;



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
	 * Return the value associated with the column: NUM
	 */
	public java.lang.Integer getNum () {
		return num;
	}

	/**
	 * Set the value related to the column: NUM
	 * @param num the NUM value
	 */
	public void setNum (java.lang.Integer num) {
		this.num = num;
	}


	/**
	 * Return the value associated with the column: CONTRACT_CODE
	 */
	public java.lang.String getContractCode () {
		return contractCode;
	}

	/**
	 * Set the value related to the column: CONTRACT_CODE
	 * @param contractCode the CONTRACT_CODE value
	 */
	public void setContractCode (java.lang.String contractCode) {
		this.contractCode = contractCode;
	}


	/**
	 * Return the value associated with the column: UNIT_NAME
	 */
	public java.lang.String getUnitName () {
		return unitName;
	}

	/**
	 * Set the value related to the column: UNIT_NAME
	 * @param unitName the UNIT_NAME value
	 */
	public void setUnitName (java.lang.String unitName) {
		this.unitName = unitName;
	}


	/**
	 * Return the value associated with the column: UNIT_MAIN_PERSON
	 */
	public java.lang.String getUnitMainPerson () {
		return unitMainPerson;
	}

	/**
	 * Set the value related to the column: UNIT_MAIN_PERSON
	 * @param unitMainPerson the UNIT_MAIN_PERSON value
	 */
	public void setUnitMainPerson (java.lang.String unitMainPerson) {
		this.unitMainPerson = unitMainPerson;
	}


	/**
	 * Return the value associated with the column: UNIT_ID_CARD
	 */
	public java.lang.String getUnitIdCard () {
		return unitIdCard;
	}

	/**
	 * Set the value related to the column: UNIT_ID_CARD
	 * @param unitIdCard the UNIT_ID_CARD value
	 */
	public void setUnitIdCard (java.lang.String unitIdCard) {
		this.unitIdCard = unitIdCard;
	}


	/**
	 * Return the value associated with the column: UNIT_PHONE
	 */
	public java.lang.String getUnitPhone () {
		return unitPhone;
	}

	/**
	 * Set the value related to the column: UNIT_PHONE
	 * @param unitPhone the UNIT_PHONE value
	 */
	public void setUnitPhone (java.lang.String unitPhone) {
		this.unitPhone = unitPhone;
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
	 * Return the value associated with the column: UNIT_TYPE_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getUnitType () {
		return unitType;
	}

	/**
	 * Set the value related to the column: UNIT_TYPE_ID
	 * @param unitType the UNIT_TYPE_ID value
	 */
	public void setUnitType (com.justonetech.system.domain.SysCodeDetail unitType) {
		this.unitType = unitType;
	}


	/**
	 * Return the value associated with the column: SG_PERMIT_ID
	 */
	public com.justonetech.biz.domain.SgPermit getSgPermit () {
		return sgPermit;
	}

	/**
	 * Set the value related to the column: SG_PERMIT_ID
	 * @param sgPermit the SG_PERMIT_ID value
	 */
	public void setSgPermit (com.justonetech.biz.domain.SgPermit sgPermit) {
		this.sgPermit = sgPermit;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.SgContractProjPerson)) return false;
		else {
			com.justonetech.biz.domain.SgContractProjPerson sgContractProjPerson = (com.justonetech.biz.domain.SgContractProjPerson) obj;
			if (null == this.getId() || null == sgContractProjPerson.getId()) return false;
			else return (this.getId().equals(sgContractProjPerson.getId()));
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
		builder.append(num);
		builder.append(contractCode);
		builder.append(unitName);
		builder.append(unitMainPerson);
		builder.append(unitIdCard);
		builder.append(unitPhone);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}