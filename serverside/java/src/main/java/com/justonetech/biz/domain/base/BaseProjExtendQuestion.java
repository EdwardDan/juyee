package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PROJ_EXTEND_QUESTION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目问题清单
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 项目问题清单
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : project
 * Projectable : false
 *
 * @hibernate.class
 *  table="PROJ_EXTEND_QUESTION"
 */

public abstract class BaseProjExtendQuestion  implements Serializable, Auditable {

	public static String REF = "ProjExtendQuestion";
	public static String PROP_DEPT_IDS = "deptIds";
	public static String PROP_YEAR = "year";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_QD_TYPE = "qdType";
	public static String PROP_DEPT_NAME = "deptName";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_QUESTION = "question";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_MONTH = "month";
	public static String PROP_PROJ_EXTEND = "projExtend";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseProjExtendQuestion () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProjExtendQuestion (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*年*/
    /*年*/
	private java.lang.Integer year;

    /*月*/
    /*月*/
	private java.lang.Integer month;

    /*存在问题*/
    /*存在问题*/
	private java.lang.String question;

    /*责任部门IDS*/
    /*责任部门IDS*/
	private java.lang.String deptIds;

    /*责任部门名称（冗余）*/
    /*责任部门名称（冗余）*/
	private java.lang.String deptName;

    /*清单类型*/
    /*清单类型*/
	private java.lang.String qdType;

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
	private com.justonetech.biz.domain.ProjExtend projExtend;



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
	 * Return the value associated with the column: YEAR
	 */
	public java.lang.Integer getYear () {
		return year;
	}

	/**
	 * Set the value related to the column: YEAR
	 * @param year the YEAR value
	 */
	public void setYear (java.lang.Integer year) {
		this.year = year;
	}


	/**
	 * Return the value associated with the column: MONTH
	 */
	public java.lang.Integer getMonth () {
		return month;
	}

	/**
	 * Set the value related to the column: MONTH
	 * @param month the MONTH value
	 */
	public void setMonth (java.lang.Integer month) {
		this.month = month;
	}


	/**
	 * Return the value associated with the column: QUESTION
	 */
	public java.lang.String getQuestion () {
		return question;
	}

	/**
	 * Set the value related to the column: QUESTION
	 * @param question the QUESTION value
	 */
	public void setQuestion (java.lang.String question) {
		this.question = question;
	}


	/**
	 * Return the value associated with the column: DEPT_IDS
	 */
	public java.lang.String getDeptIds () {
		return deptIds;
	}

	/**
	 * Set the value related to the column: DEPT_IDS
	 * @param deptIds the DEPT_IDS value
	 */
	public void setDeptIds (java.lang.String deptIds) {
		this.deptIds = deptIds;
	}


	/**
	 * Return the value associated with the column: DEPT_NAME
	 */
	public java.lang.String getDeptName () {
		return deptName;
	}

	/**
	 * Set the value related to the column: DEPT_NAME
	 * @param deptName the DEPT_NAME value
	 */
	public void setDeptName (java.lang.String deptName) {
		this.deptName = deptName;
	}


	/**
	 * Return the value associated with the column: QD_TYPE
	 */
	public java.lang.String getQdType () {
		return qdType;
	}

	/**
	 * Set the value related to the column: QD_TYPE
	 * @param qdType the QD_TYPE value
	 */
	public void setQdType (java.lang.String qdType) {
		this.qdType = qdType;
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
	 * Return the value associated with the column: PROJ_EXTEND_ID
	 */
	public com.justonetech.biz.domain.ProjExtend getProjExtend () {
		return projExtend;
	}

	/**
	 * Set the value related to the column: PROJ_EXTEND_ID
	 * @param projExtend the PROJ_EXTEND_ID value
	 */
	public void setProjExtend (com.justonetech.biz.domain.ProjExtend projExtend) {
		this.projExtend = projExtend;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ProjExtendQuestion)) return false;
		else {
			com.justonetech.biz.domain.ProjExtendQuestion projExtendQuestion = (com.justonetech.biz.domain.ProjExtendQuestion) obj;
			if (null == this.getId() || null == projExtendQuestion.getId()) return false;
			else return (this.getId().equals(projExtendQuestion.getId()));
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
		builder.append(month);
		builder.append(question);
		builder.append(deptIds);
		builder.append(deptName);
		builder.append(qdType);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}
