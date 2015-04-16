package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_LEAVE_APPLY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 请假单
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 请假单
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_LEAVE_APPLY"
 */

public abstract class BaseOaLeaveApply  implements Serializable,Auditable {

	public static String REF = "OaLeaveApply";
	public static String PROP_DAY_COUNT = "dayCount";
	public static String PROP_REPORT_DEPT = "reportDept";
	public static String PROP_OFFICE_AUDIT_TIME = "officeAuditTime";
	public static String PROP_LEADER_OPINION = "leaderOpinion";
	public static String PROP_IS_SEND_SMS = "isSendSms";
	public static String PROP_DUTY = "duty";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_SMS_TIMEAREA = "smsTimearea";
	public static String PROP_DURATION_TIME = "durationTime";
	public static String PROP_OFFICE_OPINION = "officeOpinion";
	public static String PROP_LEADER_AUDIT_USER = "leaderAuditUser";
	public static String PROP_STATUS = "status";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_SMS_CONTENT = "smsContent";
	public static String PROP_REPORT_DATE = "reportDate";
	public static String PROP_REPORT_PERSON = "reportPerson";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_OFFICE_AUDIT_USER = "officeAuditUser";
	public static String PROP_ID = "id";
	public static String PROP_CAUSE = "cause";
	public static String PROP_LEADER_AUDIT_TIME = "leaderAuditTime";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseOaLeaveApply () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaLeaveApply (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*申请人*/
    /*申请人*/
	private String reportPerson;
	
    /*申请部门*/
    /*申请部门*/
	private String reportDept;
	
    /*申请时间*/
    /*申请时间*/
	private java.sql.Date reportDate;
	
    /*岗位*/
    /*岗位*/
	private String duty;
	
    /*请假起始时间*/
    /*请假起始时间*/
	private String durationTime;
	
    /*请假事由*/
    /*请假事由*/
	private String cause;
	
    /*状态*/
    /*状态*/
	private Integer status;
	
    /*办公室审核意见*/
    /*办公室审核意见*/
	private String officeOpinion;
	
    /*办公室审核时间*/
    /*办公室审核时间*/
	private java.sql.Timestamp officeAuditTime;
	
    /*办公室审核用户名*/
    /*办公室审核用户名*/
	private String officeAuditUser;
	
    /*主管领导审核意见*/
    /*主管领导审核意见*/
	private String leaderOpinion;
	
    /*主管领导审核时间*/
    /*主管领导审核时间*/
	private java.sql.Timestamp leaderAuditTime;
	
    /*主管领导审核用户名*/
    /*主管领导审核用户名*/
	private String leaderAuditUser;
	
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
	
    /*请假天数*/
    /*请假天数*/
	private double dayCount;
	
    /*短信时间段*/
    /*短信时间段*/
	private String smsTimearea;
	
    /*短信内容*/
    /*短信内容*/
	private String smsContent;
	
    /*是否发送短信*/
    /*是否发送短信*/
	private Boolean isSendSms;
	



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
	 * Return the value associated with the column: REPORT_PERSON
	 */
	public String getReportPerson () {
		return reportPerson;
	}

	/**
	 * Set the value related to the column: REPORT_PERSON
	 * @param reportPerson the REPORT_PERSON value
	 */
	public void setReportPerson (String reportPerson) {
		this.reportPerson = reportPerson;
	}


	/**
	 * Return the value associated with the column: REPORT_DEPT
	 */
	public String getReportDept () {
		return reportDept;
	}

	/**
	 * Set the value related to the column: REPORT_DEPT
	 * @param reportDept the REPORT_DEPT value
	 */
	public void setReportDept (String reportDept) {
		this.reportDept = reportDept;
	}


	/**
	 * Return the value associated with the column: REPORT_DATE
	 */
	public java.sql.Date getReportDate () {
		return reportDate;
	}

	/**
	 * Set the value related to the column: REPORT_DATE
	 * @param reportDate the REPORT_DATE value
	 */
	public void setReportDate (java.sql.Date reportDate) {
		this.reportDate = reportDate;
	}


	/**
	 * Return the value associated with the column: DUTY
	 */
	public String getDuty () {
		return duty;
	}

	/**
	 * Set the value related to the column: DUTY
	 * @param duty the DUTY value
	 */
	public void setDuty (String duty) {
		this.duty = duty;
	}


	/**
	 * Return the value associated with the column: DURATION_TIME
	 */
	public String getDurationTime () {
		return durationTime;
	}

	/**
	 * Set the value related to the column: DURATION_TIME
	 * @param durationTime the DURATION_TIME value
	 */
	public void setDurationTime (String durationTime) {
		this.durationTime = durationTime;
	}


	/**
	 * Return the value associated with the column: CAUSE
	 */
	public String getCause () {
		return cause;
	}

	/**
	 * Set the value related to the column: CAUSE
	 * @param cause the CAUSE value
	 */
	public void setCause (String cause) {
		this.cause = cause;
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
	 * Return the value associated with the column: OFFICE_OPINION
	 */
	public String getOfficeOpinion () {
		return officeOpinion;
	}

	/**
	 * Set the value related to the column: OFFICE_OPINION
	 * @param officeOpinion the OFFICE_OPINION value
	 */
	public void setOfficeOpinion (String officeOpinion) {
		this.officeOpinion = officeOpinion;
	}


	/**
	 * Return the value associated with the column: OFFICE_AUDIT_TIME
	 */
	public java.sql.Timestamp getOfficeAuditTime () {
		return officeAuditTime;
	}

	/**
	 * Set the value related to the column: OFFICE_AUDIT_TIME
	 * @param officeAuditTime the OFFICE_AUDIT_TIME value
	 */
	public void setOfficeAuditTime (java.sql.Timestamp officeAuditTime) {
		this.officeAuditTime = officeAuditTime;
	}


	/**
	 * Return the value associated with the column: OFFICE_AUDIT_USER
	 */
	public String getOfficeAuditUser () {
		return officeAuditUser;
	}

	/**
	 * Set the value related to the column: OFFICE_AUDIT_USER
	 * @param officeAuditUser the OFFICE_AUDIT_USER value
	 */
	public void setOfficeAuditUser (String officeAuditUser) {
		this.officeAuditUser = officeAuditUser;
	}


	/**
	 * Return the value associated with the column: LEADER_OPINION
	 */
	public String getLeaderOpinion () {
		return leaderOpinion;
	}

	/**
	 * Set the value related to the column: LEADER_OPINION
	 * @param leaderOpinion the LEADER_OPINION value
	 */
	public void setLeaderOpinion (String leaderOpinion) {
		this.leaderOpinion = leaderOpinion;
	}


	/**
	 * Return the value associated with the column: LEADER_AUDIT_TIME
	 */
	public java.sql.Timestamp getLeaderAuditTime () {
		return leaderAuditTime;
	}

	/**
	 * Set the value related to the column: LEADER_AUDIT_TIME
	 * @param leaderAuditTime the LEADER_AUDIT_TIME value
	 */
	public void setLeaderAuditTime (java.sql.Timestamp leaderAuditTime) {
		this.leaderAuditTime = leaderAuditTime;
	}


	/**
	 * Return the value associated with the column: LEADER_AUDIT_USER
	 */
	public String getLeaderAuditUser () {
		return leaderAuditUser;
	}

	/**
	 * Set the value related to the column: LEADER_AUDIT_USER
	 * @param leaderAuditUser the LEADER_AUDIT_USER value
	 */
	public void setLeaderAuditUser (String leaderAuditUser) {
		this.leaderAuditUser = leaderAuditUser;
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
	 * Return the value associated with the column: DAY_COUNT
	 */
	public double getDayCount () {
		return dayCount;
	}

	/**
	 * Set the value related to the column: DAY_COUNT
	 * @param dayCount the DAY_COUNT value
	 */
	public void setDayCount (double dayCount) {
		this.dayCount = dayCount;
	}


	/**
	 * Return the value associated with the column: SMS_TIMEAREA
	 */
	public String getSmsTimearea () {
		return smsTimearea;
	}

	/**
	 * Set the value related to the column: SMS_TIMEAREA
	 * @param smsTimearea the SMS_TIMEAREA value
	 */
	public void setSmsTimearea (String smsTimearea) {
		this.smsTimearea = smsTimearea;
	}


	/**
	 * Return the value associated with the column: SMS_CONTENT
	 */
	public String getSmsContent () {
		return smsContent;
	}

	/**
	 * Set the value related to the column: SMS_CONTENT
	 * @param smsContent the SMS_CONTENT value
	 */
	public void setSmsContent (String smsContent) {
		this.smsContent = smsContent;
	}


	/**
	 * Return the value associated with the column: IS_SEND_SMS
	 */
	public Boolean getIsSendSms () {
		return isSendSms;
	}

	/**
	 * Set the value related to the column: IS_SEND_SMS
	 * @param isSendSms the IS_SEND_SMS value
	 */
	public void setIsSendSms (Boolean isSendSms) {
		this.isSendSms = isSendSms;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaLeaveApply)) return false;
		else {
			com.justonetech.biz.domain.OaLeaveApply oaLeaveApply = (com.justonetech.biz.domain.OaLeaveApply) obj;
			if (null == this.getId() || null == oaLeaveApply.getId()) return false;
			else return (this.getId().equals(oaLeaveApply.getId()));
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
		builder.append(reportPerson);
		builder.append(reportDept);
		builder.append(reportDate);
		builder.append(duty);
		builder.append(durationTime);
		builder.append(cause);
		builder.append(status);
		builder.append(officeOpinion);
		builder.append(officeAuditTime);
		builder.append(officeAuditUser);
		builder.append(leaderOpinion);
		builder.append(leaderAuditTime);
		builder.append(leaderAuditUser);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		builder.append(dayCount);
		builder.append(smsTimearea);
		builder.append(smsContent);
		builder.append(isSendSms);
		return builder.toString();
	}


}