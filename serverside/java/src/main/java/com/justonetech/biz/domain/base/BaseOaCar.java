package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_CAR table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 车辆申请
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 车辆申请
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_CAR"
 */

public abstract class BaseOaCar  implements Serializable,Auditable {

	public static String REF = "OaCar";
	public static String PROP_PERSON_NUM = "personNum";
	public static String PROP_ZR_AUDIT_OPINION = "zrAuditOpinion";
	public static String PROP_USE_CAUSE = "useCause";
	public static String PROP_KZ_AUDIT_USER = "kzAuditUser";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_KZ_AUDIT_TIME = "kzAuditTime";
	public static String PROP_DRIVER_MOBILE = "driverMobile";
	public static String PROP_ZR_AUDIT_USER = "zrAuditUser";
	public static String PROP_CAR = "car";
	public static String PROP_STATUS = "status";
	public static String PROP_KZ_AUDIT_OPINION = "kzAuditOpinion";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_APPLY_DEPT = "applyDept";
	public static String PROP_BEGIN_TIME = "beginTime";
	public static String PROP_ADDRESS = "address";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_APPLY_USER = "applyUser";
	public static String PROP_ID = "id";
	public static String PROP_DRIVER_PERSON = "driverPerson";
	public static String PROP_END_TIME = "endTime";
	public static String PROP_ZR_AUDIT_TIME = "zrAuditTime";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseOaCar () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaCar (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*使用车辆开始时间*/
    /*使用车辆开始时间*/
	private java.sql.Timestamp beginTime;
	
    /*使用车辆结束时间*/
    /*使用车辆结束时间*/
	private java.sql.Timestamp endTime;
	
    /*用车人数*/
    /*用车人数*/
	private Integer personNum;
	
    /*用车事由*/
    /*用车事由*/
	private String useCause;
	
    /*目的地*/
    /*目的地*/
	private String address;
	
    /*科长审核意见*/
    /*科长审核意见*/
	private String kzAuditOpinion;
	
    /*科长审核时间*/
    /*科长审核时间*/
	private java.sql.Timestamp kzAuditTime;
	
    /*办公室主任审核意见*/
    /*办公室主任审核意见*/
	private String zrAuditOpinion;
	
    /*办公室主任审核时间*/
    /*办公室主任审核时间*/
	private java.sql.Timestamp zrAuditTime;
	
    /*拟派司机电话*/
    /*拟派司机电话*/
	private String driverMobile;
	
    /*状态*/
    /*状态*/
	private Integer status;
	
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
	private com.justonetech.system.domain.SysUser zrAuditUser;
	private com.justonetech.system.domain.SysUser applyUser;
	private com.justonetech.system.domain.SysUser kzAuditUser;
	private com.justonetech.system.domain.SysCodeDetail car;
	private com.justonetech.system.domain.SysPerson driverPerson;
	private com.justonetech.system.domain.SysDept applyDept;



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
	 * Return the value associated with the column: BEGIN_TIME
	 */
	public java.sql.Timestamp getBeginTime () {
		return beginTime;
	}

	/**
	 * Set the value related to the column: BEGIN_TIME
	 * @param beginTime the BEGIN_TIME value
	 */
	public void setBeginTime (java.sql.Timestamp beginTime) {
		this.beginTime = beginTime;
	}


	/**
	 * Return the value associated with the column: END_TIME
	 */
	public java.sql.Timestamp getEndTime () {
		return endTime;
	}

	/**
	 * Set the value related to the column: END_TIME
	 * @param endTime the END_TIME value
	 */
	public void setEndTime (java.sql.Timestamp endTime) {
		this.endTime = endTime;
	}


	/**
	 * Return the value associated with the column: PERSON_NUM
	 */
	public Integer getPersonNum () {
		return personNum;
	}

	/**
	 * Set the value related to the column: PERSON_NUM
	 * @param personNum the PERSON_NUM value
	 */
	public void setPersonNum (Integer personNum) {
		this.personNum = personNum;
	}


	/**
	 * Return the value associated with the column: USE_CAUSE
	 */
	public String getUseCause () {
		return useCause;
	}

	/**
	 * Set the value related to the column: USE_CAUSE
	 * @param useCause the USE_CAUSE value
	 */
	public void setUseCause (String useCause) {
		this.useCause = useCause;
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
	 * Return the value associated with the column: KZ_AUDIT_OPINION
	 */
	public String getKzAuditOpinion () {
		return kzAuditOpinion;
	}

	/**
	 * Set the value related to the column: KZ_AUDIT_OPINION
	 * @param kzAuditOpinion the KZ_AUDIT_OPINION value
	 */
	public void setKzAuditOpinion (String kzAuditOpinion) {
		this.kzAuditOpinion = kzAuditOpinion;
	}


	/**
	 * Return the value associated with the column: KZ_AUDIT_TIME
	 */
	public java.sql.Timestamp getKzAuditTime () {
		return kzAuditTime;
	}

	/**
	 * Set the value related to the column: KZ_AUDIT_TIME
	 * @param kzAuditTime the KZ_AUDIT_TIME value
	 */
	public void setKzAuditTime (java.sql.Timestamp kzAuditTime) {
		this.kzAuditTime = kzAuditTime;
	}


	/**
	 * Return the value associated with the column: ZR_AUDIT_OPINION
	 */
	public String getZrAuditOpinion () {
		return zrAuditOpinion;
	}

	/**
	 * Set the value related to the column: ZR_AUDIT_OPINION
	 * @param zrAuditOpinion the ZR_AUDIT_OPINION value
	 */
	public void setZrAuditOpinion (String zrAuditOpinion) {
		this.zrAuditOpinion = zrAuditOpinion;
	}


	/**
	 * Return the value associated with the column: ZR_AUDIT_TIME
	 */
	public java.sql.Timestamp getZrAuditTime () {
		return zrAuditTime;
	}

	/**
	 * Set the value related to the column: ZR_AUDIT_TIME
	 * @param zrAuditTime the ZR_AUDIT_TIME value
	 */
	public void setZrAuditTime (java.sql.Timestamp zrAuditTime) {
		this.zrAuditTime = zrAuditTime;
	}


	/**
	 * Return the value associated with the column: DRIVER_MOBILE
	 */
	public String getDriverMobile () {
		return driverMobile;
	}

	/**
	 * Set the value related to the column: DRIVER_MOBILE
	 * @param driverMobile the DRIVER_MOBILE value
	 */
	public void setDriverMobile (String driverMobile) {
		this.driverMobile = driverMobile;
	}


	/**
	 * Return the value associated with the column: STATUS
	 */
	public Integer getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (Integer status) {
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
	 * Return the value associated with the column: ZR_AUDIT_USER_ID
	 */
	public com.justonetech.system.domain.SysUser getZrAuditUser () {
		return zrAuditUser;
	}

	/**
	 * Set the value related to the column: ZR_AUDIT_USER_ID
	 * @param zrAuditUser the ZR_AUDIT_USER_ID value
	 */
	public void setZrAuditUser (com.justonetech.system.domain.SysUser zrAuditUser) {
		this.zrAuditUser = zrAuditUser;
	}


	/**
	 * Return the value associated with the column: APPLY_USER_ID
	 */
	public com.justonetech.system.domain.SysUser getApplyUser () {
		return applyUser;
	}

	/**
	 * Set the value related to the column: APPLY_USER_ID
	 * @param applyUser the APPLY_USER_ID value
	 */
	public void setApplyUser (com.justonetech.system.domain.SysUser applyUser) {
		this.applyUser = applyUser;
	}


	/**
	 * Return the value associated with the column: KZ_AUDIT_USER_ID
	 */
	public com.justonetech.system.domain.SysUser getKzAuditUser () {
		return kzAuditUser;
	}

	/**
	 * Set the value related to the column: KZ_AUDIT_USER_ID
	 * @param kzAuditUser the KZ_AUDIT_USER_ID value
	 */
	public void setKzAuditUser (com.justonetech.system.domain.SysUser kzAuditUser) {
		this.kzAuditUser = kzAuditUser;
	}


	/**
	 * Return the value associated with the column: CAR_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getCar () {
		return car;
	}

	/**
	 * Set the value related to the column: CAR_ID
	 * @param car the CAR_ID value
	 */
	public void setCar (com.justonetech.system.domain.SysCodeDetail car) {
		this.car = car;
	}


	/**
	 * Return the value associated with the column: DRIVER_PERSON_ID
	 */
	public com.justonetech.system.domain.SysPerson getDriverPerson () {
		return driverPerson;
	}

	/**
	 * Set the value related to the column: DRIVER_PERSON_ID
	 * @param driverPerson the DRIVER_PERSON_ID value
	 */
	public void setDriverPerson (com.justonetech.system.domain.SysPerson driverPerson) {
		this.driverPerson = driverPerson;
	}


	/**
	 * Return the value associated with the column: APPLY_DEPT_ID
	 */
	public com.justonetech.system.domain.SysDept getApplyDept () {
		return applyDept;
	}

	/**
	 * Set the value related to the column: APPLY_DEPT_ID
	 * @param applyDept the APPLY_DEPT_ID value
	 */
	public void setApplyDept (com.justonetech.system.domain.SysDept applyDept) {
		this.applyDept = applyDept;
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
		builder.append(beginTime);
		builder.append(endTime);
		builder.append(personNum);
		builder.append(useCause);
		builder.append(address);
		builder.append(kzAuditOpinion);
		builder.append(kzAuditTime);
		builder.append(zrAuditOpinion);
		builder.append(zrAuditTime);
		builder.append(driverMobile);
		builder.append(status);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}