package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the DATA_STAGE_REPORT_LOG table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 办证推进填报历史
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 办证推进填报历史
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : data
 * Projectable : false
 *
 * @hibernate.class
 *  table="DATA_STAGE_REPORT_LOG"
 */

public abstract class BaseDataStageReportLog  implements Serializable, Auditable {

	public static String REF = "DataStageReportLog";
	public static String PROP_STEP = "step";
	public static String PROP_RESULT = "result";
	public static String PROP_STAGE_REPORT = "stageReport";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_RESULT_DESC = "resultDesc";
	public static String PROP_DEAL_DATE = "dealDate";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_STAGE = "stage";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseDataStageReportLog () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDataStageReportLog (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*推进结果中文描述*/
    /*推进结果中文描述*/
	private String resultDesc;
	
    /*计划日期/办结日期/问题*/
    /*计划日期/办结日期/问题*/
	private String dealDate;
	
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
	private com.justonetech.system.domain.SysCodeDetail result;
	private com.justonetech.biz.domain.DataStageReport stageReport;
	private com.justonetech.system.domain.SysCodeDetail step;
	private com.justonetech.biz.domain.ProjStage stage;



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
	 * Return the value associated with the column: RESULT_DESC
	 */
	public String getResultDesc () {
		return resultDesc;
	}

	/**
	 * Set the value related to the column: RESULT_DESC
	 * @param resultDesc the RESULT_DESC value
	 */
	public void setResultDesc (String resultDesc) {
		this.resultDesc = resultDesc;
	}


	/**
	 * Return the value associated with the column: DEAL_DATE
	 */
	public String getDealDate () {
		return dealDate;
	}

	/**
	 * Set the value related to the column: DEAL_DATE
	 * @param dealDate the DEAL_DATE value
	 */
	public void setDealDate (String dealDate) {
		this.dealDate = dealDate;
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
	 * Return the value associated with the column: RESULT_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getResult () {
		return result;
	}

	/**
	 * Set the value related to the column: RESULT_ID
	 * @param result the RESULT_ID value
	 */
	public void setResult (com.justonetech.system.domain.SysCodeDetail result) {
		this.result = result;
	}


	/**
	 * Return the value associated with the column: STAGE_REPORT_ID
	 */
	public com.justonetech.biz.domain.DataStageReport getStageReport () {
		return stageReport;
	}

	/**
	 * Set the value related to the column: STAGE_REPORT_ID
	 * @param stageReport the STAGE_REPORT_ID value
	 */
	public void setStageReport (com.justonetech.biz.domain.DataStageReport stageReport) {
		this.stageReport = stageReport;
	}


	/**
	 * Return the value associated with the column: STEP_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getStep () {
		return step;
	}

	/**
	 * Set the value related to the column: STEP_ID
	 * @param step the STEP_ID value
	 */
	public void setStep (com.justonetech.system.domain.SysCodeDetail step) {
		this.step = step;
	}


	/**
	 * Return the value associated with the column: STAGE_ID
	 */
	public com.justonetech.biz.domain.ProjStage getStage () {
		return stage;
	}

	/**
	 * Set the value related to the column: STAGE_ID
	 * @param stage the STAGE_ID value
	 */
	public void setStage (com.justonetech.biz.domain.ProjStage stage) {
		this.stage = stage;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.DataStageReportLog)) return false;
		else {
			com.justonetech.biz.domain.DataStageReportLog dataStageReportLog = (com.justonetech.biz.domain.DataStageReportLog) obj;
			if (null == this.getId() || null == dataStageReportLog.getId()) return false;
			else return (this.getId().equals(dataStageReportLog.getId()));
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
		builder.append(resultDesc);
		builder.append(dealDate);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}