package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;
import com.justonetech.system.domain.SysUser;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PLAN_MAIN_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 监督计划
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 监督计划
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : plan
 * Projectable : false
 *
 * @hibernate.class
 *  table="PLAN_MAIN_INFO"
 */

public abstract class BasePlanMainInfo  implements Serializable,Auditable {

	public static String REF = "PlanMainInfo";
	public static String PROP_CHECK_MEMO = "checkMemo";
	public static String PROP_PLAN_DESC = "planDesc";
	public static String PROP_CHECK_USER_NAME = "checkUserName";
	public static String PROP_CHECK_OPINION = "checkOpinion";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_CHECK_USER = "checkUser";
	public static String PROP_PLAN_TYPE = "planType";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_PLAN_NAME = "planName";
	public static String PROP_CREATE_USER_NAME = "createUserName";
	public static String PROP_PLAN_STATUS = "planStatus";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_CHECK_DATE_TIME = "checkDateTime";
	public static String PROP_ID = "id";
	public static String PROP_PLAN_CODE = "planCode";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BasePlanMainInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePlanMainInfo (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*计划名称*/
    /*计划名称*/
	private String planName;
	
    /*计划编号*/
    /*计划编号*/
	private String planCode;
	
    /*计划描述*/
    /*计划描述*/
	private String planDesc;
	
    /*创建人姓名*/
    /*创建人姓名*/
	private String createUserName;
	
    /*创建时间*/
    /*创建时间*/
	private java.sql.Timestamp createTime;
	
    /*审核人姓名*/
    /*审核人姓名*/
	private String checkUserName;
	
    /*审核日期*/
    /*审核日期*/
	private java.sql.Timestamp checkDateTime;
	
    /*审核备注*/
    /*审核备注*/
	private String checkMemo;
	
    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updateTime;
	
    /*更新人*/
    /*更新人*/
	private String updateUser;
	

	// many to one
	private com.justonetech.system.domain.SysUser checkUser;
	private com.justonetech.system.domain.SysCodeDetail planStatus;
	private com.justonetech.system.domain.SysCodeDetail checkOpinion;
	private com.justonetech.system.domain.SysUser cUser;
	private com.justonetech.system.domain.SysCodeDetail planType;

	// collections
	private java.util.Set<com.justonetech.biz.domain.PlanDetail> planDetails;



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
	 * Return the value associated with the column: PLAN_NAME
	 */
	public String getPlanName () {
		return planName;
	}

	/**
	 * Set the value related to the column: PLAN_NAME
	 * @param planName the PLAN_NAME value
	 */
	public void setPlanName (String planName) {
		this.planName = planName;
	}


	/**
	 * Return the value associated with the column: PLAN_CODE
	 */
	public String getPlanCode () {
		return planCode;
	}

	/**
	 * Set the value related to the column: PLAN_CODE
	 * @param planCode the PLAN_CODE value
	 */
	public void setPlanCode (String planCode) {
		this.planCode = planCode;
	}


	/**
	 * Return the value associated with the column: PLAN_DESC
	 */
	public String getPlanDesc () {
		return planDesc;
	}

	/**
	 * Set the value related to the column: PLAN_DESC
	 * @param planDesc the PLAN_DESC value
	 */
	public void setPlanDesc (String planDesc) {
		this.planDesc = planDesc;
	}


	/**
	 * Return the value associated with the column: CREATE_USER_NAME
	 */
	public String getCreateUserName () {
		return createUserName;
	}

	/**
	 * Set the value related to the column: CREATE_USER_NAME
	 * @param createUserName the CREATE_USER_NAME value
	 */
	public void setCreateUserName (String createUserName) {
		this.createUserName = createUserName;
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
	 * Return the value associated with the column: CHECK_USER_NAME
	 */
	public String getCheckUserName () {
		return checkUserName;
	}

	/**
	 * Set the value related to the column: CHECK_USER_NAME
	 * @param checkUserName the CHECK_USER_NAME value
	 */
	public void setCheckUserName (String checkUserName) {
		this.checkUserName = checkUserName;
	}


	/**
	 * Return the value associated with the column: CHECK_DATE_TIME
	 */
	public java.sql.Timestamp getCheckDateTime () {
		return checkDateTime;
	}

	/**
	 * Set the value related to the column: CHECK_DATE_TIME
	 * @param checkDateTime the CHECK_DATE_TIME value
	 */
	public void setCheckDateTime (java.sql.Timestamp checkDateTime) {
		this.checkDateTime = checkDateTime;
	}


	/**
	 * Return the value associated with the column: CHECK_MEMO
	 */
	public String getCheckMemo () {
		return checkMemo;
	}

	/**
	 * Set the value related to the column: CHECK_MEMO
	 * @param checkMemo the CHECK_MEMO value
	 */
	public void setCheckMemo (String checkMemo) {
		this.checkMemo = checkMemo;
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
	 * Return the value associated with the column: CHECK_USER_ID
	 */
	public com.justonetech.system.domain.SysUser getCheckUser () {
		return checkUser;
	}

	/**
	 * Set the value related to the column: CHECK_USER_ID
	 * @param checkUser the CHECK_USER_ID value
	 */
	public void setCheckUser (com.justonetech.system.domain.SysUser checkUser) {
		this.checkUser = checkUser;
	}


	/**
	 * Return the value associated with the column: PLAN_STATUS
	 */
	public com.justonetech.system.domain.SysCodeDetail getPlanStatus () {
		return planStatus;
	}

	/**
	 * Set the value related to the column: PLAN_STATUS
	 * @param planStatus the PLAN_STATUS value
	 */
	public void setPlanStatus (com.justonetech.system.domain.SysCodeDetail planStatus) {
		this.planStatus = planStatus;
	}


	/**
	 * Return the value associated with the column: CHECH_OPINION
	 */
	public com.justonetech.system.domain.SysCodeDetail getCheckOpinion () {
		return checkOpinion;
	}

	/**
	 * Set the value related to the column: CHECH_OPINION
	 * @param checkOpinion the CHECH_OPINION value
	 */
	public void setCheckOpinion (com.justonetech.system.domain.SysCodeDetail checkOpinion) {
		this.checkOpinion = checkOpinion;
	}

//    注意:不能改为createUser否则与Auditable冲突
    public SysUser getcUser() {
        return cUser;
    }

    public void setcUser(SysUser cUser) {
        this.cUser = cUser;
    }

    /**
	 * Return the value associated with the column: PLAN_TYPE
	 */
	public com.justonetech.system.domain.SysCodeDetail getPlanType () {
		return planType;
	}

	/**
	 * Set the value related to the column: PLAN_TYPE
	 * @param planType the PLAN_TYPE value
	 */
	public void setPlanType (com.justonetech.system.domain.SysCodeDetail planType) {
		this.planType = planType;
	}


	/**
	 * Return the value associated with the column: planDetails
	 */
	public java.util.Set<com.justonetech.biz.domain.PlanDetail> getPlanDetails () {
		if(planDetails == null){
			planDetails = new java.util.LinkedHashSet<com.justonetech.biz.domain.PlanDetail>();
		}
		return planDetails;
	}

	/**
	 * Set the value related to the column: planDetails
	 * @param planDetails the planDetails value
	 */
	public void setPlanDetails (java.util.Set<com.justonetech.biz.domain.PlanDetail> planDetails) {
		this.planDetails = planDetails;
	}

	public void addToplanDetails (com.justonetech.biz.domain.PlanDetail planDetail) {
		if (null == getPlanDetails()) setPlanDetails(new java.util.LinkedHashSet<com.justonetech.biz.domain.PlanDetail>());
		getPlanDetails().add(planDetail);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.PlanMainInfo)) return false;
		else {
			com.justonetech.biz.domain.PlanMainInfo planMainInfo = (com.justonetech.biz.domain.PlanMainInfo) obj;
			if (null == this.getId() || null == planMainInfo.getId()) return false;
			else return (this.getId().equals(planMainInfo.getId()));
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
		builder.append(planName);
		builder.append(planCode);
		builder.append(planDesc);
		builder.append(createUserName);
		builder.append(createTime);
		builder.append(checkUserName);
		builder.append(checkDateTime);
		builder.append(checkMemo);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}