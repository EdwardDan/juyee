package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the AREA_SG_MATERIAL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 区县施工材料
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 区县施工材料
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : area
 * Projectable : false
 *
 * @hibernate.class
 *  table="AREA_SG_MATERIAL"
 */

public abstract class BaseAreaSgMaterial  implements Serializable {

	public static String REF = "AreaSgMaterial";
	public static String PROP_DOC = "doc";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_SG_PERMIT = "sgPermit";
	public static String PROP_NUM = "num";
	public static String PROP_SJ_NUM = "sjNum";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_YJ_NUM = "yjNum";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_IS_FULL = "isFull";
	public static String PROP_ID = "id";
	public static String PROP_NO = "no";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseAreaSgMaterial () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAreaSgMaterial (java.lang.Long id) {
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
	private java.lang.Long no;
	
    /*材料齐全情况*/
    /*材料齐全情况*/
	private java.lang.Boolean isFull;
	
    /*份数*/
    /*份数*/
	private java.lang.Long num;
	
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
	
    /*应交份数*/
    /*应交份数*/
	private java.lang.Long yjNum;
	
    /*实交份数*/
    /*实交份数*/
	private java.lang.Long sjNum;
	

	// many to one
	private com.justonetech.biz.domain.DocDocument doc;
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
	 * Return the value associated with the column: NO
	 */
	public java.lang.Long getNo () {
		return no;
	}

	/**
	 * Set the value related to the column: NO
	 * @param no the NO value
	 */
	public void setNo (java.lang.Long no) {
		this.no = no;
	}


	/**
	 * Return the value associated with the column: IS_FULL
	 */
	public java.lang.Boolean getIsFull () {
		return isFull;
	}

	/**
	 * Set the value related to the column: IS_FULL
	 * @param isFull the IS_FULL value
	 */
	public void setIsFull (java.lang.Boolean isFull) {
		this.isFull = isFull;
	}


	/**
	 * Return the value associated with the column: NUM
	 */
	public java.lang.Long getNum () {
		return num;
	}

	/**
	 * Set the value related to the column: NUM
	 * @param num the NUM value
	 */
	public void setNum (java.lang.Long num) {
		this.num = num;
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
	 * Return the value associated with the column: YJ_NUM
	 */
	public java.lang.Long getYjNum () {
		return yjNum;
	}

	/**
	 * Set the value related to the column: YJ_NUM
	 * @param yjNum the YJ_NUM value
	 */
	public void setYjNum (java.lang.Long yjNum) {
		this.yjNum = yjNum;
	}


	/**
	 * Return the value associated with the column: SJ_NUM
	 */
	public java.lang.Long getSjNum () {
		return sjNum;
	}

	/**
	 * Set the value related to the column: SJ_NUM
	 * @param sjNum the SJ_NUM value
	 */
	public void setSjNum (java.lang.Long sjNum) {
		this.sjNum = sjNum;
	}


	/**
	 * Return the value associated with the column: DOC_ID
	 */
	public com.justonetech.biz.domain.DocDocument getDoc () {
		return doc;
	}

	/**
	 * Set the value related to the column: DOC_ID
	 * @param doc the DOC_ID value
	 */
	public void setDoc (com.justonetech.biz.domain.DocDocument doc) {
		this.doc = doc;
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
		if (!(obj instanceof com.justonetech.biz.domain.AreaSgMaterial)) return false;
		else {
			com.justonetech.biz.domain.AreaSgMaterial areaSgMaterial = (com.justonetech.biz.domain.AreaSgMaterial) obj;
			if (null == this.getId() || null == areaSgMaterial.getId()) return false;
			else return (this.getId().equals(areaSgMaterial.getId()));
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
		builder.append(isFull);
		builder.append(num);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		builder.append(yjNum);
		builder.append(sjNum);
		return builder.toString();
	}


}