package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_CAR table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 车辆管理
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 车辆管理
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : car
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_CAR"
 */

public abstract class BaseOaCar  implements Serializable ,Auditable{

	public static String REF = "OaCar";
	public static String PROP_PERSON_NUM = "personNum";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_USE_REASON = "useReason";
	public static String PROP_DRIVER_NAME = "driverName";
	public static String PROP_IS_ARRANGE_DRIVER = "isArrangeDriver";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_USE_DATE = "useDate";
	public static String PROP_AUDIT_USER = "auditUser";
	public static String PROP_USE_END_TIME = "useEndTime";
	public static String PROP_STATUS = "status";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_CAR_NO = "carNo";
	public static String PROP_APPLY_PERSON = "applyPerson";
	public static String PROP_AUDIT_TIME = "auditTime";
	public static String PROP_APPLY_DEPT = "applyDept";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_DRIVER_TEL = "driverTel";
	public static String PROP_ID = "id";
	public static String PROP_USE_BEGIN_TIME = "useBeginTime";
	public static String PROP_AUDIT_OPINION = "auditOpinion";
	public static String PROP_ARRIVAL_PLACE = "arrivalPlace";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseOaCar () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaCar (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*申请部门名称*/
    /*申请部门名称*/
	private java.lang.String applyDept;
	
    /*申请人*/
    /*申请人*/
	private java.lang.String applyPerson;
	
    /*用车事由*/
    /*用车事由*/
	private java.lang.String useReason;
	
    /*使用车辆日期*/
    /*使用车辆日期*/
	private java.sql.Date useDate;
	
    /*使用车辆开始时间*/
    /*使用车辆开始时间*/
	private java.lang.String useBeginTime;
	
    /*使用车辆结束时间*/
    /*使用车辆结束时间*/
	private java.lang.String useEndTime;
	
    /*目的地*/
    /*目的地*/
	private java.lang.String arrivalPlace;
	
    /*审核意见*/
    /*审核意见*/
	private java.lang.String auditOpinion;
	
    /*审核时间*/
    /*审核时间*/
	private java.sql.Timestamp auditTime;
	
    /*审核用户名*/
    /*审核用户名*/
	private java.lang.String auditUser;
	
    /*用车人数*/
    /*用车人数*/
	private java.lang.Integer personNum;
	
    /*备注*/
    /*备注*/
	private java.lang.String description;
	
    /*状态*/
    /*状态*/
	private java.lang.Integer status;
	
    /*拟派车牌号*/
    /*拟派车牌号*/
	private java.lang.String carNo;
	
    /*是否拟派司机*/
    /*是否拟派司机*/
	private java.lang.Boolean isArrangeDriver;
	
    /*拟派司机*/
    /*拟派司机*/
	private java.lang.String driverName;
	
    /*司机联系方式*/
    /*司机联系方式*/
	private java.lang.String driverTel;
	
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
	 * Return the value associated with the column: APPLY_DEPT
	 */
	public java.lang.String getApplyDept () {
		return applyDept;
	}

	/**
	 * Set the value related to the column: APPLY_DEPT
	 * @param applyDept the APPLY_DEPT value
	 */
	public void setApplyDept (java.lang.String applyDept) {
		this.applyDept = applyDept;
	}


	/**
	 * Return the value associated with the column: APPLY_PERSON
	 */
	public java.lang.String getApplyPerson () {
		return applyPerson;
	}

	/**
	 * Set the value related to the column: APPLY_PERSON
	 * @param applyPerson the APPLY_PERSON value
	 */
	public void setApplyPerson (java.lang.String applyPerson) {
		this.applyPerson = applyPerson;
	}


	/**
	 * Return the value associated with the column: USE_REASON
	 */
	public java.lang.String getUseReason () {
		return useReason;
	}

	/**
	 * Set the value related to the column: USE_REASON
	 * @param useReason the USE_REASON value
	 */
	public void setUseReason (java.lang.String useReason) {
		this.useReason = useReason;
	}


	/**
	 * Return the value associated with the column: USE_DATE
	 */
	public java.sql.Date getUseDate () {
		return useDate;
	}

	/**
	 * Set the value related to the column: USE_DATE
	 * @param useDate the USE_DATE value
	 */
	public void setUseDate (java.sql.Date useDate) {
		this.useDate = useDate;
	}


	/**
	 * Return the value associated with the column: USE_BEGIN_TIME
	 */
	public java.lang.String getUseBeginTime () {
		return useBeginTime;
	}

	/**
	 * Set the value related to the column: USE_BEGIN_TIME
	 * @param useBeginTime the USE_BEGIN_TIME value
	 */
	public void setUseBeginTime (java.lang.String useBeginTime) {
		this.useBeginTime = useBeginTime;
	}


	/**
	 * Return the value associated with the column: USE_END_TIME
	 */
	public java.lang.String getUseEndTime () {
		return useEndTime;
	}

	/**
	 * Set the value related to the column: USE_END_TIME
	 * @param useEndTime the USE_END_TIME value
	 */
	public void setUseEndTime (java.lang.String useEndTime) {
		this.useEndTime = useEndTime;
	}


	/**
	 * Return the value associated with the column: ARRIVAL_PLACE
	 */
	public java.lang.String getArrivalPlace () {
		return arrivalPlace;
	}

	/**
	 * Set the value related to the column: ARRIVAL_PLACE
	 * @param arrivalPlace the ARRIVAL_PLACE value
	 */
	public void setArrivalPlace (java.lang.String arrivalPlace) {
		this.arrivalPlace = arrivalPlace;
	}


	/**
	 * Return the value associated with the column: AUDIT_OPINION
	 */
	public java.lang.String getAuditOpinion () {
		return auditOpinion;
	}

	/**
	 * Set the value related to the column: AUDIT_OPINION
	 * @param auditOpinion the AUDIT_OPINION value
	 */
	public void setAuditOpinion (java.lang.String auditOpinion) {
		this.auditOpinion = auditOpinion;
	}


	/**
	 * Return the value associated with the column: AUDIT_TIME
	 */
	public java.sql.Timestamp getAuditTime () {
		return auditTime;
	}

	/**
	 * Set the value related to the column: AUDIT_TIME
	 * @param auditTime the AUDIT_TIME value
	 */
	public void setAuditTime (java.sql.Timestamp auditTime) {
		this.auditTime = auditTime;
	}


	/**
	 * Return the value associated with the column: AUDIT_USER
	 */
	public java.lang.String getAuditUser () {
		return auditUser;
	}

	/**
	 * Set the value related to the column: AUDIT_USER
	 * @param auditUser the AUDIT_USER value
	 */
	public void setAuditUser (java.lang.String auditUser) {
		this.auditUser = auditUser;
	}


	/**
	 * Return the value associated with the column: PERSON_NUM
	 */
	public java.lang.Integer getPersonNum () {
		return personNum;
	}

	/**
	 * Set the value related to the column: PERSON_NUM
	 * @param personNum the PERSON_NUM value
	 */
	public void setPersonNum (java.lang.Integer personNum) {
		this.personNum = personNum;
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
	 * Return the value associated with the column: CAR_NO
	 */
	public java.lang.String getCarNo () {
		return carNo;
	}

	/**
	 * Set the value related to the column: CAR_NO
	 * @param carNo the CAR_NO value
	 */
	public void setCarNo (java.lang.String carNo) {
		this.carNo = carNo;
	}


	/**
	 * Return the value associated with the column: IS_ARRANGE_DRIVER
	 */
	public java.lang.Boolean getIsArrangeDriver () {
		return isArrangeDriver;
	}

	/**
	 * Set the value related to the column: IS_ARRANGE_DRIVER
	 * @param isArrangeDriver the IS_ARRANGE_DRIVER value
	 */
	public void setIsArrangeDriver (java.lang.Boolean isArrangeDriver) {
		this.isArrangeDriver = isArrangeDriver;
	}


	/**
	 * Return the value associated with the column: DRIVER_NAME
	 */
	public java.lang.String getDriverName () {
		return driverName;
	}

	/**
	 * Set the value related to the column: DRIVER_NAME
	 * @param driverName the DRIVER_NAME value
	 */
	public void setDriverName (java.lang.String driverName) {
		this.driverName = driverName;
	}


	/**
	 * Return the value associated with the column: DRIVER_TEL
	 */
	public java.lang.String getDriverTel () {
		return driverTel;
	}

	/**
	 * Set the value related to the column: DRIVER_TEL
	 * @param driverTel the DRIVER_TEL value
	 */
	public void setDriverTel (java.lang.String driverTel) {
		this.driverTel = driverTel;
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



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaCar)) return false;
		else {
			com.justonetech.biz.domain.OaCar oaCar = (com.justonetech.biz.domain.OaCar) obj;
			if (null == this.getId() || null == oaCar.getId()) return false;
			else return (this.getId().equals(oaCar.getId()));
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
		builder.append(applyDept);
		builder.append(applyPerson);
		builder.append(useReason);
		builder.append(useDate);
		builder.append(useBeginTime);
		builder.append(useEndTime);
		builder.append(arrivalPlace);
		builder.append(auditOpinion);
		builder.append(auditTime);
		builder.append(auditUser);
		builder.append(personNum);
		builder.append(description);
		builder.append(status);
		builder.append(carNo);
		builder.append(isArrangeDriver);
		builder.append(driverName);
		builder.append(driverTel);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}