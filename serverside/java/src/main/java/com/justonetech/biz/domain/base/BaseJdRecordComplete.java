package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;
import java.sql.Date;


/**
 * This is an object that contains data related to the JD_RECORD_COMPLETE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 安全质量监督--竣工验收
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 安全质量监督--竣工验收
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : jd
 * Projectable : false
 *
 * @hibernate.class
 *  table="JD_RECORD_COMPLETE"
 */

public abstract class BaseJdRecordComplete  implements Serializable,Auditable {

	public static String REF = "JdRecordComplete";
	public static String PROP_KC_DEPT = "kcDept";
	public static String PROP_JD_DATETIME = "jdDatetime";
	public static String PROP_CODE = "code";
	public static String PROP_SJ_DEPT = "sjDept";
	public static String PROP_JS_DEPT = "jsDept";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_AUDIT_TIME = "auditTime";
	public static String PROP_JL_DEPT = "jlDept";
	public static String PROP_BJBH = "bjbh";
	public static String PROP_FLOW_CODE = "flowCode";
	public static String PROP_JD_TASK_CODE = "jdTaskCode";
	public static String PROP_UPDATE_USER = "updateUser";
	public static String PROP_WEATHER = "weather";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_DOCUMENT = "document";
	public static String PROP_PROJECT_NAME = "projectName";
	public static String PROP_JD_MANAGER = "jdManager";
	public static String PROP_SG_DEPT = "sgDept";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_JC_DEPT = "jcDept";
	public static String PROP_DEAL_OPINION = "dealOpinion";
	public static String PROP_AUDIT_USER = "auditUser";
	public static String PROP_STATUS = "status";
	public static String PROP_ATTEND_PERSONS = "attendPersons";
	public static String PROP_JD_MANAGER_NAME = "jdManagerName";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_ID = "id";
    public static String PROP_JD_TYPE_CODE = "jdTypeCode";


	// constructors
	public BaseJdRecordComplete () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseJdRecordComplete (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

    /*监督类别编码*/
    /*监督类别编码*/
    private java.lang.String jdTypeCode;

	// fields
    /*监督记录自动编号*/
    /*监督记录自动编号*/
	private java.lang.String code;

    /*监督任务书编号*/
    /*监督任务书编号*/
	private java.lang.String jdTaskCode;

    /*流转编号*/
    /*流转编号*/
	private java.lang.String flowCode;

    /*报建编号*/
    /*报建编号*/
	private java.lang.String bjbh;

    /*天气*/
    /*天气*/
	private java.lang.String weather;

    /*工程名称*/
    /*工程名称*/
	private java.lang.String projectName;

    /*监督负责人*/
    /*监督负责人*/
	private java.lang.String jdManagerName;

    /*参加监督人员（冗余）*/
    /*参加监督人员（冗余）*/
	private java.lang.String attendPersons;

    /*建设单位*/
    /*建设单位*/
	private java.lang.String jsDept;

    /*勘察单位*/
    /*勘察单位*/
	private java.lang.String kcDept;

    /*设计单位*/
    /*设计单位*/
	private java.lang.String sjDept;

    /*施工单位*/
    /*施工单位*/
	private java.lang.String sgDept;

    /*监理单位*/
    /*监理单位*/
	private java.lang.String jlDept;

    /*检测单位*/
    /*检测单位*/
	private java.lang.String jcDept;

    /*总处理意见*/
    /*总处理意见*/
	private java.lang.String dealOpinion;

    /*备注*/
    /*备注*/
	private java.lang.String description;

    /*监督日期*/
    /*监督日期*/
	private Date jdDatetime;

    /*状态*/
    /*状态*/
	private java.lang.Integer status;

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

    /*审核时间*/
    /*审核时间*/
	private java.sql.Timestamp auditTime;

    /*审核用户名*/
    /*审核用户名*/
	private java.lang.String auditUser;


	// many to one
	private com.justonetech.biz.domain.DocDocument document;
	private com.justonetech.system.domain.SysPerson jdManager;

	// collections
	private java.util.Set<com.justonetech.biz.domain.JdRecordCompleteDwgc> jdRecordCompleteDwgcs;
	private java.util.Set<com.justonetech.biz.domain.JdRecordCompleteResult> jdRecordCompleteResults;



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
     * Return the value associated with the column: JD_TYPE_CODE
     */
    public java.lang.String getJdTypeCode () {
        return jdTypeCode;
    }

    /**
     * Set the value related to the column: JD_TYPE_CODE
     * @param jdTypeCode the JD_TYPE_CODE value
     */
    public void setJdTypeCode (java.lang.String jdTypeCode) {
        this.jdTypeCode = jdTypeCode;
    }


	/**
	 * Return the value associated with the column: CODE
	 */
	public java.lang.String getCode () {
		return code;
	}

	/**
	 * Set the value related to the column: CODE
	 * @param code the CODE value
	 */
	public void setCode (java.lang.String code) {
		this.code = code;
	}


	/**
	 * Return the value associated with the column: JD_TASK_CODE
	 */
	public java.lang.String getJdTaskCode () {
		return jdTaskCode;
	}

	/**
	 * Set the value related to the column: JD_TASK_CODE
	 * @param jdTaskCode the JD_TASK_CODE value
	 */
	public void setJdTaskCode (java.lang.String jdTaskCode) {
		this.jdTaskCode = jdTaskCode;
	}


	/**
	 * Return the value associated with the column: FLOW_CODE
	 */
	public java.lang.String getFlowCode () {
		return flowCode;
	}

	/**
	 * Set the value related to the column: FLOW_CODE
	 * @param flowCode the FLOW_CODE value
	 */
	public void setFlowCode (java.lang.String flowCode) {
		this.flowCode = flowCode;
	}


	/**
	 * Return the value associated with the column: BJBH
	 */
	public java.lang.String getBjbh () {
		return bjbh;
	}

	/**
	 * Set the value related to the column: BJBH
	 * @param bjbh the BJBH value
	 */
	public void setBjbh (java.lang.String bjbh) {
		this.bjbh = bjbh;
	}


	/**
	 * Return the value associated with the column: WEATHER
	 */
	public java.lang.String getWeather () {
		return weather;
	}

	/**
	 * Set the value related to the column: WEATHER
	 * @param weather the WEATHER value
	 */
	public void setWeather (java.lang.String weather) {
		this.weather = weather;
	}


	/**
	 * Return the value associated with the column: PROJECT_NAME
	 */
	public java.lang.String getProjectName () {
		return projectName;
	}

	/**
	 * Set the value related to the column: PROJECT_NAME
	 * @param projectName the PROJECT_NAME value
	 */
	public void setProjectName (java.lang.String projectName) {
		this.projectName = projectName;
	}


	/**
	 * Return the value associated with the column: JD_MANAGER_NAME
	 */
	public java.lang.String getJdManagerName () {
		return jdManagerName;
	}

	/**
	 * Set the value related to the column: JD_MANAGER_NAME
	 * @param jdManagerName the JD_MANAGER_NAME value
	 */
	public void setJdManagerName (java.lang.String jdManagerName) {
		this.jdManagerName = jdManagerName;
	}


	/**
	 * Return the value associated with the column: ATTEND_PERSONS
	 */
	public java.lang.String getAttendPersons () {
		return attendPersons;
	}

	/**
	 * Set the value related to the column: ATTEND_PERSONS
	 * @param attendPersons the ATTEND_PERSONS value
	 */
	public void setAttendPersons (java.lang.String attendPersons) {
		this.attendPersons = attendPersons;
	}


	/**
	 * Return the value associated with the column: JS_DEPT
	 */
	public java.lang.String getJsDept () {
		return jsDept;
	}

	/**
	 * Set the value related to the column: JS_DEPT
	 * @param jsDept the JS_DEPT value
	 */
	public void setJsDept (java.lang.String jsDept) {
		this.jsDept = jsDept;
	}


	/**
	 * Return the value associated with the column: KC_DEPT
	 */
	public java.lang.String getKcDept () {
		return kcDept;
	}

	/**
	 * Set the value related to the column: KC_DEPT
	 * @param kcDept the KC_DEPT value
	 */
	public void setKcDept (java.lang.String kcDept) {
		this.kcDept = kcDept;
	}


	/**
	 * Return the value associated with the column: SJ_DEPT
	 */
	public java.lang.String getSjDept () {
		return sjDept;
	}

	/**
	 * Set the value related to the column: SJ_DEPT
	 * @param sjDept the SJ_DEPT value
	 */
	public void setSjDept (java.lang.String sjDept) {
		this.sjDept = sjDept;
	}


	/**
	 * Return the value associated with the column: SG_DEPT
	 */
	public java.lang.String getSgDept () {
		return sgDept;
	}

	/**
	 * Set the value related to the column: SG_DEPT
	 * @param sgDept the SG_DEPT value
	 */
	public void setSgDept (java.lang.String sgDept) {
		this.sgDept = sgDept;
	}


	/**
	 * Return the value associated with the column: JL_DEPT
	 */
	public java.lang.String getJlDept () {
		return jlDept;
	}

	/**
	 * Set the value related to the column: JL_DEPT
	 * @param jlDept the JL_DEPT value
	 */
	public void setJlDept (java.lang.String jlDept) {
		this.jlDept = jlDept;
	}


	/**
	 * Return the value associated with the column: JC_DEPT
	 */
	public java.lang.String getJcDept () {
		return jcDept;
	}

	/**
	 * Set the value related to the column: JC_DEPT
	 * @param jcDept the JC_DEPT value
	 */
	public void setJcDept (java.lang.String jcDept) {
		this.jcDept = jcDept;
	}


	/**
	 * Return the value associated with the column: DEAL_OPINION
	 */
	public java.lang.String getDealOpinion () {
		return dealOpinion;
	}

	/**
	 * Set the value related to the column: DEAL_OPINION
	 * @param dealOpinion the DEAL_OPINION value
	 */
	public void setDealOpinion (java.lang.String dealOpinion) {
		this.dealOpinion = dealOpinion;
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
	 * Return the value associated with the column: JD_DATETIME
	 */
	public Date getJdDatetime () {
		return jdDatetime;
	}

	/**
	 * Set the value related to the column: JD_DATETIME
	 * @param jdDatetime the JD_DATETIME value
	 */
	public void setJdDatetime (Date jdDatetime) {
		this.jdDatetime = jdDatetime;
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
	 * Return the value associated with the column: DOCUMENT_ID
	 */
	public com.justonetech.biz.domain.DocDocument getDocument () {
		return document;
	}

	/**
	 * Set the value related to the column: DOCUMENT_ID
	 * @param document the DOCUMENT_ID value
	 */
	public void setDocument (com.justonetech.biz.domain.DocDocument document) {
		this.document = document;
	}


	/**
	 * Return the value associated with the column: JD_MANAGER_ID
	 */
	public com.justonetech.system.domain.SysPerson getJdManager () {
		return jdManager;
	}

	/**
	 * Set the value related to the column: JD_MANAGER_ID
	 * @param jdManager the JD_MANAGER_ID value
	 */
	public void setJdManager (com.justonetech.system.domain.SysPerson jdManager) {
		this.jdManager = jdManager;
	}


	/**
	 * Return the value associated with the column: jdRecordCompleteDwgcs
	 */
    public java.util.Set<com.justonetech.biz.domain.JdRecordCompleteDwgc> getJdRecordCompleteDwgcs() {
        if (jdRecordCompleteDwgcs == null) {
            jdRecordCompleteDwgcs = new java.util.LinkedHashSet<com.justonetech.biz.domain.JdRecordCompleteDwgc>();
        }
        return jdRecordCompleteDwgcs;
    }

	/**
	 * Set the value related to the column: jdRecordCompleteDwgcs
	 * @param jdRecordCompleteDwgcs the jdRecordCompleteDwgcs value
	 */
	public void setJdRecordCompleteDwgcs (java.util.Set<com.justonetech.biz.domain.JdRecordCompleteDwgc> jdRecordCompleteDwgcs) {
		this.jdRecordCompleteDwgcs = jdRecordCompleteDwgcs;
	}


	/**
	 * Return the value associated with the column: jdRecordCompleteResults
	 */
    public java.util.Set<com.justonetech.biz.domain.JdRecordCompleteResult> getJdRecordCompleteResults() {
        if (jdRecordCompleteResults == null) {
            jdRecordCompleteResults = new java.util.LinkedHashSet<com.justonetech.biz.domain.JdRecordCompleteResult>();
        }
        return jdRecordCompleteResults;
    }

	/**
	 * Set the value related to the column: jdRecordCompleteResults
	 * @param jdRecordCompleteResults the jdRecordCompleteResults value
	 */
	public void setJdRecordCompleteResults (java.util.Set<com.justonetech.biz.domain.JdRecordCompleteResult> jdRecordCompleteResults) {
		this.jdRecordCompleteResults = jdRecordCompleteResults;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.JdRecordComplete)) return false;
		else {
			com.justonetech.biz.domain.JdRecordComplete jdRecordComplete = (com.justonetech.biz.domain.JdRecordComplete) obj;
			if (null == this.getId() || null == jdRecordComplete.getId()) return false;
			else return (this.getId().equals(jdRecordComplete.getId()));
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
		builder.append(code);
		builder.append(jdTaskCode);
		builder.append(flowCode);
		builder.append(bjbh);
		builder.append(weather);
		builder.append(projectName);
		builder.append(jdManagerName);
		builder.append(attendPersons);
		builder.append(jsDept);
		builder.append(kcDept);
		builder.append(sjDept);
		builder.append(sgDept);
		builder.append(jlDept);
		builder.append(jcDept);
		builder.append(dealOpinion);
		builder.append(description);
		builder.append(jdDatetime);
		builder.append(status);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		builder.append(auditTime);
		builder.append(auditUser);
        builder.append(jdTypeCode);
		return builder.toString();
	}


}