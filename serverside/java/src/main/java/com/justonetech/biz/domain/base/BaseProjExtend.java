package com.justonetech.biz.domain.base;

import com.justonetech.biz.domain.ProjExtendQuestion;
import com.justonetech.core.entity.Auditable;

import java.io.Serializable;
import java.util.Set;


/**
 * This is an object that contains data related to the PROJ_EXTEND table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目扩展信息
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 项目扩展信息
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : project
 * Projectable : true
 *
 * @hibernate.class
 *  table="PROJ_EXTEND"
 */

public abstract class BaseProjExtend  implements Serializable,Auditable {

	public static String REF = "ProjExtend";
	public static String PROP_PLAN_CBSJ = "planCbsj";
	public static String PROP_GCJS_BEGIN_TIME = "gcjsBeginTime";
	public static String PROP_GCTX_CSPF_TOTAL = "gctxCspfTotal";
	public static String PROP_GCTX_SOURCE_FUND = "gctxSourceFund";
	public static String PROP_GCJS_IS_BIGIN = "gcjsIsBigin";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_GCJS_IS_END = "gcjsIsEnd";
	public static String PROP_PLAN_GK = "planGk";
	public static String PROP_GCTX_GKPF_TOTAL = "gctxGkpfTotal";
	public static String PROP_PLAN_XMJYS = "planXmjys";
	public static String PROP_PLAN_GK_TIME = "planGkTime";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_PLAN_CBSJ_TIME = "planCbsjTime";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_GCJS_END_TIME = "gcjsEndTime";
	public static String PROP_ID = "id";
	public static String PROP_PROJECT = "project";
	public static String PROP_PLAN_XMJYS_TIME = "planXmjysTime";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseProjExtend () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProjExtend (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*工可批复总投资（亿元）*/
    /*工可批复总投资（亿元）*/
	private Double gctxGkpfTotal;

    /*初设批复总投资（亿元）*/
    /*初设批复总投资（亿元）*/
	private Double gctxCspfTotal;

    /*资金来源*/
    /*资金来源*/
	private String gctxSourceFund;

    /*项目建议书完成时间*/
    /*项目建议书完成时间*/
	private java.sql.Date planXmjysTime;

    /*工可完成时间*/
    /*工可完成时间*/
	private java.sql.Date planGkTime;

    /*初步设计完成时间*/
    /*初步设计完成时间*/
	private java.sql.Date planCbsjTime;

    /*是否开工*/
    /*是否开工*/
	private Boolean gcjsIsBigin;

    /*开工时间*/
    /*开工时间*/
	private java.sql.Date gcjsBeginTime;

    /*是否完工*/
    /*是否完工*/
	private Boolean gcjsIsEnd;

    /*完工时间*/
    /*完工时间*/
	private java.sql.Date gcjsEndTime;

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
	private com.justonetech.system.domain.SysCodeDetail planGk;
	private com.justonetech.biz.domain.ProjInfo project;
	private com.justonetech.system.domain.SysCodeDetail planCbsj;
	private com.justonetech.system.domain.SysCodeDetail planXmjys;

	// collections
	private java.util.Set<com.justonetech.biz.domain.ProjExtendSchedule> projExtendSchedules;
	private java.util.Set<com.justonetech.biz.domain.ProjExtendCost> projExtendCosts;
	private java.util.Set<com.justonetech.biz.domain.ProjExtendQuestion> projExtendQuestions;



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
	 * Return the value associated with the column: GCTX_GKPF_TOTAL
	 */
	public Double getGctxGkpfTotal () {
		return gctxGkpfTotal;
	}

	/**
	 * Set the value related to the column: GCTX_GKPF_TOTAL
	 * @param gctxGkpfTotal the GCTX_GKPF_TOTAL value
	 */
	public void setGctxGkpfTotal (Double gctxGkpfTotal) {
		this.gctxGkpfTotal = gctxGkpfTotal;
	}


	/**
	 * Return the value associated with the column: GCTX_CSPF_TOTAL
	 */
	public Double getGctxCspfTotal () {
		return gctxCspfTotal;
	}

	/**
	 * Set the value related to the column: GCTX_CSPF_TOTAL
	 * @param gctxCspfTotal the GCTX_CSPF_TOTAL value
	 */
	public void setGctxCspfTotal (Double gctxCspfTotal) {
		this.gctxCspfTotal = gctxCspfTotal;
	}


	/**
	 * Return the value associated with the column: GCTX_SOURCE_FUND
	 */
	public String getGctxSourceFund () {
		return gctxSourceFund;
	}

	/**
	 * Set the value related to the column: GCTX_SOURCE_FUND
	 * @param gctxSourceFund the GCTX_SOURCE_FUND value
	 */
	public void setGctxSourceFund (String gctxSourceFund) {
		this.gctxSourceFund = gctxSourceFund;
	}


	/**
	 * Return the value associated with the column: PLAN_XMJYS_TIME
	 */
	public java.sql.Date getPlanXmjysTime () {
		return planXmjysTime;
	}

	/**
	 * Set the value related to the column: PLAN_XMJYS_TIME
	 * @param planXmjysTime the PLAN_XMJYS_TIME value
	 */
	public void setPlanXmjysTime (java.sql.Date planXmjysTime) {
		this.planXmjysTime = planXmjysTime;
	}


	/**
	 * Return the value associated with the column: PLAN_GK_TIME
	 */
	public java.sql.Date getPlanGkTime () {
		return planGkTime;
	}

	/**
	 * Set the value related to the column: PLAN_GK_TIME
	 * @param planGkTime the PLAN_GK_TIME value
	 */
	public void setPlanGkTime (java.sql.Date planGkTime) {
		this.planGkTime = planGkTime;
	}


	/**
	 * Return the value associated with the column: PLAN_CBSJ_TIME
	 */
	public java.sql.Date getPlanCbsjTime () {
		return planCbsjTime;
	}

	/**
	 * Set the value related to the column: PLAN_CBSJ_TIME
	 * @param planCbsjTime the PLAN_CBSJ_TIME value
	 */
	public void setPlanCbsjTime (java.sql.Date planCbsjTime) {
		this.planCbsjTime = planCbsjTime;
	}


	/**
	 * Return the value associated with the column: GCJS_IS_BIGIN
	 */
	public Boolean getGcjsIsBigin () {
		return gcjsIsBigin;
	}

	/**
	 * Set the value related to the column: GCJS_IS_BIGIN
	 * @param gcjsIsBigin the GCJS_IS_BIGIN value
	 */
	public void setGcjsIsBigin (Boolean gcjsIsBigin) {
		this.gcjsIsBigin = gcjsIsBigin;
	}


	/**
	 * Return the value associated with the column: GCJS_BEGIN_TIME
	 */
	public java.sql.Date getGcjsBeginTime () {
		return gcjsBeginTime;
	}

	/**
	 * Set the value related to the column: GCJS_BEGIN_TIME
	 * @param gcjsBeginTime the GCJS_BEGIN_TIME value
	 */
	public void setGcjsBeginTime (java.sql.Date gcjsBeginTime) {
		this.gcjsBeginTime = gcjsBeginTime;
	}


	/**
	 * Return the value associated with the column: GCJS_IS_END
	 */
	public Boolean getGcjsIsEnd () {
		return gcjsIsEnd;
	}

	/**
	 * Set the value related to the column: GCJS_IS_END
	 * @param gcjsIsEnd the GCJS_IS_END value
	 */
	public void setGcjsIsEnd (Boolean gcjsIsEnd) {
		this.gcjsIsEnd = gcjsIsEnd;
	}


	/**
	 * Return the value associated with the column: GCJS_END_TIME
	 */
	public java.sql.Date getGcjsEndTime () {
		return gcjsEndTime;
	}

	/**
	 * Set the value related to the column: GCJS_END_TIME
	 * @param gcjsEndTime the GCJS_END_TIME value
	 */
	public void setGcjsEndTime (java.sql.Date gcjsEndTime) {
		this.gcjsEndTime = gcjsEndTime;
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
	 * Return the value associated with the column: PLAN_GK_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getPlanGk () {
		return planGk;
	}

	/**
	 * Set the value related to the column: PLAN_GK_ID
	 * @param planGk the PLAN_GK_ID value
	 */
	public void setPlanGk (com.justonetech.system.domain.SysCodeDetail planGk) {
		this.planGk = planGk;
	}


	/**
	 * Return the value associated with the column: PROJECT_ID
	 */
	public com.justonetech.biz.domain.ProjInfo getProject () {
		return project;
	}

	/**
	 * Set the value related to the column: PROJECT_ID
	 * @param project the PROJECT_ID value
	 */
	public void setProject (com.justonetech.biz.domain.ProjInfo project) {
		this.project = project;
	}


	/**
	 * Return the value associated with the column: PLAN_CBSJ_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getPlanCbsj () {
		return planCbsj;
	}

	/**
	 * Set the value related to the column: PLAN_CBSJ_ID
	 * @param planCbsj the PLAN_CBSJ_ID value
	 */
	public void setPlanCbsj (com.justonetech.system.domain.SysCodeDetail planCbsj) {
		this.planCbsj = planCbsj;
	}


	/**
	 * Return the value associated with the column: PLAN_XMJYS_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getPlanXmjys () {
		return planXmjys;
	}

	/**
	 * Set the value related to the column: PLAN_XMJYS_ID
	 * @param planXmjys the PLAN_XMJYS_ID value
	 */
	public void setPlanXmjys (com.justonetech.system.domain.SysCodeDetail planXmjys) {
		this.planXmjys = planXmjys;
	}


	/**
	 * Return the value associated with the column: projExtendSchedules
	 */
	public java.util.Set<com.justonetech.biz.domain.ProjExtendSchedule> getProjExtendSchedules () {
		if(projExtendSchedules == null){
			projExtendSchedules = new java.util.LinkedHashSet<com.justonetech.biz.domain.ProjExtendSchedule>();
		}
		return projExtendSchedules;
	}

	/**
	 * Set the value related to the column: projExtendSchedules
	 * @param projExtendSchedules the projExtendSchedules value
	 */
	public void setProjExtendSchedules (java.util.Set<com.justonetech.biz.domain.ProjExtendSchedule> projExtendSchedules) {
		this.projExtendSchedules = projExtendSchedules;
	}

	public void addToprojExtendSchedules (com.justonetech.biz.domain.ProjExtendSchedule projExtendSchedule) {
		if (null == getProjExtendSchedules()) setProjExtendSchedules(new java.util.LinkedHashSet<com.justonetech.biz.domain.ProjExtendSchedule>());
		getProjExtendSchedules().add(projExtendSchedule);
	}


	public Set<ProjExtendQuestion> getProjExtendQuestions() {
		if(projExtendQuestions == null){
			projExtendQuestions = new java.util.LinkedHashSet<ProjExtendQuestion>();
		}
		return projExtendQuestions;
	}

	public void setProjExtendQuestions(Set<ProjExtendQuestion> projExtendQuestions) {
		this.projExtendQuestions = projExtendQuestions;
	}

	public void addToprojExtendQuestions(com.justonetech.biz.domain.ProjExtendQuestion projExtendQuestion) {
		if (null == getProjExtendQuestions()) setProjExtendQuestions(new java.util.LinkedHashSet<com.justonetech.biz.domain.ProjExtendQuestion>());
		getProjExtendQuestions().add(projExtendQuestion);
	}



	/**
	 * Return the value associated with the column: projExtendCosts
	 */
	public java.util.Set<com.justonetech.biz.domain.ProjExtendCost> getProjExtendCosts () {
		if(projExtendCosts == null){
			projExtendCosts = new java.util.LinkedHashSet<com.justonetech.biz.domain.ProjExtendCost>();
		}
		return projExtendCosts;
	}

	/**
	 * Set the value related to the column: projExtendCosts
	 * @param projExtendCosts the projExtendCosts value
	 */
	public void setProjExtendCosts (java.util.Set<com.justonetech.biz.domain.ProjExtendCost> projExtendCosts) {
		this.projExtendCosts = projExtendCosts;
	}

	public void addToprojExtendCosts (com.justonetech.biz.domain.ProjExtendCost projExtendCost) {
		if (null == getProjExtendCosts()) setProjExtendCosts(new java.util.LinkedHashSet<com.justonetech.biz.domain.ProjExtendCost>());
		getProjExtendCosts().add(projExtendCost);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ProjExtend)) return false;
		else {
			com.justonetech.biz.domain.ProjExtend projExtend = (com.justonetech.biz.domain.ProjExtend) obj;
			if (null == this.getId() || null == projExtend.getId()) return false;
			else return (this.getId().equals(projExtend.getId()));
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
		builder.append(gctxGkpfTotal);
		builder.append(gctxCspfTotal);
		builder.append(gctxSourceFund);
		builder.append(planXmjysTime);
		builder.append(planGkTime);
		builder.append(planCbsjTime);
		builder.append(gcjsIsBigin);
		builder.append(gcjsBeginTime);
		builder.append(gcjsIsEnd);
		builder.append(gcjsEndTime);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}
