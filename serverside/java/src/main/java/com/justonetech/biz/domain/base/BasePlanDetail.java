package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PLAN_DETAIL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 计划明细
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 计划明细
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : plan
 * Projectable : false
 *
 * @hibernate.class
 *  table="PLAN_DETAIL"
 */

public abstract class BasePlanDetail  implements Serializable,Auditable {

	public static String REF = "PlanDetail";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_SG_UNIT_NAME = "sgUnitName";
	public static String PROP_GROUP = "group";
	public static String PROP_STATUS = "status";
	public static String PROP_GD_NAME = "gdName";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_BJBH = "bjbh";
	public static String PROP_FLOW_CODE = "flowCode";
	public static String PROP_BUILD_UNIT_NAME = "buildUnitName";
	public static String PROP_PLAN_END_TIME = "planEndTime";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_ID = "id";
	public static String PROP_PLAN_ACT_TIME = "planActTime";
	public static String PROP_BDH = "bdh";
	public static String PROP_PLAN = "plan";
	public static String PROP_UPDATE_USER = "updateUser";
	public static String PROP_SELECT_CAUSE = "selectCause";
	public static String PROP_SELECT_CAUSE_OTHER = "selectCauseOther";


	// constructors
	public BasePlanDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePlanDetail (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*监督任务书编号*/
    /*监督任务书编号*/
	private String jdTaskCode;
	
    /*报建编号*/
    /*报建编号*/
	private String bjbh;
	
    /*标段号*/
    /*标段号*/
	private String bdh;
	
    /*建设单位*/
    /*建设单位*/
	private String buildUnitName;
	
    /*施工单位*/
    /*施工单位*/
	private String sgUnitName;
	
    /*工地名称*/
    /*工地名称*/
	private String gdName;
	
    /*计划完成日期*/
    /*计划完成日期*/
	private java.sql.Timestamp planEndTime;
	
    /*实际完成日期*/
    /*实际完成日期*/
	private java.sql.Timestamp planActTime;
	
    /*创建时间*/
    /*创建时间*/
	private java.sql.Timestamp createTime;
	
    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updateTime;
	
    /*创建人*/
    /*创建人*/
	private String createUser;
	
    /*更新人*/
    /*更新人*/
	private String updateUser;

    /*选择原因*/
    /*选择原因*/
	private String selectCause;

    /*选择原因_其他*/
    /*选择原因_其他*/
	private String selectCauseOther;


	// many to one
	private com.justonetech.biz.domain.PollingWorkGroup group;
	private com.justonetech.biz.domain.PlanMainInfo plan;
	private com.justonetech.system.domain.SysCodeDetail status;
    // collections
    private java.util.Set<com.justonetech.biz.domain.PlanDetailUser> planDetailUsers;


    /**
     * Return the value associated with the column: planDetails
     */
    public java.util.Set<com.justonetech.biz.domain.PlanDetailUser> getPlanDetailUsers () {
        if(planDetailUsers == null){
            planDetailUsers = new java.util.LinkedHashSet<com.justonetech.biz.domain.PlanDetailUser>();
        }
        return planDetailUsers;
    }

    /**
     * Set the value related to the column: planDetails
     * @param planDetailUsers the planDetails value
     */
    public void setPlanDetailUsers (java.util.Set<com.justonetech.biz.domain.PlanDetailUser> planDetailUsers) {
        this.planDetailUsers = planDetailUsers;
    }

    public void addToplanDetailUsers (com.justonetech.biz.domain.PlanDetailUser PlanDetailUser) {
        if (null == getPlanDetailUsers()) setPlanDetailUsers(new java.util.LinkedHashSet<com.justonetech.biz.domain.PlanDetailUser>());
        getPlanDetailUsers().add(PlanDetailUser);
    }


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
	 * Return the value associated with the column: jd_Task_Code
	 */
	public String getJdTaskCode () {
		return jdTaskCode;
	}

	/**
	 * Set the value related to the column: jd_Task_Code
	 * @param jdTaskCode the jd_Task_Code value
	 */
	public void setJdTaskCode (String jdTaskCode) {
		this.jdTaskCode = jdTaskCode;
	}


	/**
	 * Return the value associated with the column: BJBH
	 */
	public String getBjbh () {
		return bjbh;
	}

	/**
	 * Set the value related to the column: BJBH
	 * @param bjbh the BJBH value
	 */
	public void setBjbh (String bjbh) {
		this.bjbh = bjbh;
	}


	/**
	 * Return the value associated with the column: BDH
	 */
	public String getBdh () {
		return bdh;
	}

	/**
	 * Set the value related to the column: BDH
	 * @param bdh the BDH value
	 */
	public void setBdh (String bdh) {
		this.bdh = bdh;
	}


	/**
	 * Return the value associated with the column: BUILD_UNIT_NAME
	 */
	public String getBuildUnitName () {
		return buildUnitName;
	}

	/**
	 * Set the value related to the column: BUILD_UNIT_NAME
	 * @param buildUnitName the BUILD_UNIT_NAME value
	 */
	public void setBuildUnitName (String buildUnitName) {
		this.buildUnitName = buildUnitName;
	}


	/**
	 * Return the value associated with the column: SG_UNIT_NAME
	 */
	public String getSgUnitName () {
		return sgUnitName;
	}

	/**
	 * Set the value related to the column: SG_UNIT_NAME
	 * @param sgUnitName the SG_UNIT_NAME value
	 */
	public void setSgUnitName (String sgUnitName) {
		this.sgUnitName = sgUnitName;
	}


	/**
	 * Return the value associated with the column: GD_NAME
	 */
	public String getGdName () {
		return gdName;
	}

	/**
	 * Set the value related to the column: GD_NAME
	 * @param gdName the GD_NAME value
	 */
	public void setGdName (String gdName) {
		this.gdName = gdName;
	}


	/**
	 * Return the value associated with the column: PLAN_END_TIME
	 */
	public java.sql.Timestamp getPlanEndTime () {
		return planEndTime;
	}

	/**
	 * Set the value related to the column: PLAN_END_TIME
	 * @param planEndTime the PLAN_END_TIME value
	 */
	public void setPlanEndTime (java.sql.Timestamp planEndTime) {
		this.planEndTime = planEndTime;
	}


	/**
	 * Return the value associated with the column: PLAN_ACT_TIME
	 */
	public java.sql.Timestamp getPlanActTime () {
		return planActTime;
	}

	/**
	 * Set the value related to the column: PLAN_ACT_TIME
	 * @param planActTime the PLAN_ACT_TIME value
	 */
	public void setPlanActTime (java.sql.Timestamp planActTime) {
		this.planActTime = planActTime;
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
	 * Return the value associated with the column: GROUP_ID
	 */
	public com.justonetech.biz.domain.PollingWorkGroup getGroup () {
		return group;
	}

	/**
	 * Set the value related to the column: GROUP_ID
	 * @param group the GROUP_ID value
	 */
	public void setGroup (com.justonetech.biz.domain.PollingWorkGroup group) {
		this.group = group;
	}


	/**
	 * Return the value associated with the column: PLAN_ID
	 */
	public com.justonetech.biz.domain.PlanMainInfo getPlan () {
		return plan;
	}

	/**
	 * Set the value related to the column: PLAN_ID
	 * @param plan the PLAN_ID value
	 */
	public void setPlan (com.justonetech.biz.domain.PlanMainInfo plan) {
		this.plan = plan;
	}


	/**
	 * Return the value associated with the column: STATUS
	 */
	public com.justonetech.system.domain.SysCodeDetail getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (com.justonetech.system.domain.SysCodeDetail status) {
		this.status = status;
	}

    public String getSelectCause() {
        return selectCause;
    }

    public void setSelectCause(String selectCause) {
        this.selectCause = selectCause;
    }

    public String getSelectCauseOther() {
        return selectCauseOther;
    }

    public void setSelectCauseOther(String selectCauseOther) {
        this.selectCauseOther = selectCauseOther;
    }

    public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.PlanDetail)) return false;
		else {
			com.justonetech.biz.domain.PlanDetail planDetail = (com.justonetech.biz.domain.PlanDetail) obj;
			if (null == this.getId() || null == planDetail.getId()) return false;
			else return (this.getId().equals(planDetail.getId()));
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
		builder.append(jdTaskCode);
		builder.append(bjbh);
		builder.append(bdh);
		builder.append(buildUnitName);
		builder.append(sgUnitName);
		builder.append(gdName);
		builder.append(planEndTime);
		builder.append(planActTime);
		builder.append(createTime);
		builder.append(updateTime);
		builder.append(createUser);
		builder.append(updateUser);
		builder.append(selectCause);
		builder.append(selectCauseOther);
		return builder.toString();
	}


}