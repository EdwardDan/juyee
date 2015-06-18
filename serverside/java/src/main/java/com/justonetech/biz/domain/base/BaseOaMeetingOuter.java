package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_MEETING_OUTER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 外部会议
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 外部会议
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_MEETING_OUTER"
 */

public abstract class BaseOaMeetingOuter  implements Serializable {

	public static String REF = "OaMeetingOuter";
	public static String PROP_ZR_AUDIT_OPINION = "zrAuditOpinion";
	public static String PROP_DOC = "doc";
	public static String PROP_TYPE = "type";
	public static String PROP_FG_AUDIT_OPINION = "fgAuditOpinion";
	public static String PROP_WORK_ADVISE = "workAdvise";
	public static String PROP_ZR_AUDIT_USER = "zrAuditUser";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_FG_AUDIT_USER = "fgAuditUser";
	public static String PROP_CONTENT = "content";
	public static String PROP_UPDATE_USER = "updateUser";
	public static String PROP_INNER_PERSONS = "innerPersons";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_LEADER = "leader";
	public static String PROP_START_DEPT = "startDept";
	public static String PROP_FG_AUDIT_TIME = "fgAuditTime";
	public static String PROP_TITLE = "title";
	public static String PROP_STATUS = "status";
	public static String PROP_BEGIN_TIME = "beginTime";
	public static String PROP_CHARGE_PERSON = "chargePerson";
	public static String PROP_ADDRESS = "address";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_END_TIME = "endTime";
	public static String PROP_ID = "id";
	public static String PROP_ZR_AUDIT_TIME = "zrAuditTime";
	public static String PROP_RELATE_MATTER = "relateMatter";


	// constructors
	public BaseOaMeetingOuter () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaMeetingOuter (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*会议开始时间*/
    /*会议开始时间*/
	private java.sql.Timestamp beginTime;
	
    /*会议结束时间*/
    /*会议结束时间*/
	private java.sql.Timestamp endTime;
	
    /*会议地点*/
    /*会议地点*/
	private String address;
	
    /*主持人*/
    /*主持人*/
	private String chargePerson;
	
    /*发起单位*/
    /*发起单位*/
	private String startDept;
	
    /*会议领导*/
    /*会议领导*/
	private String leader;
	
    /*与会单位*/
    /*与会单位*/
	private String innerPersons;
	
    /*会议名称*/
    /*会议名称*/
	private String title;
	
    /*会议内容*/
    /*会议内容*/
	private String content;
	
    /*与中心相关事宜*/
    /*与中心相关事宜*/
	private String relateMatter;
	
    /*工作建议*/
    /*工作建议*/
	private String workAdvise;
	
    /*状态*/
    /*状态*/
	private Integer status;
	
    /*分管领导审核意见*/
    /*分管领导审核意见*/
	private String fgAuditOpinion;
	
    /*分管领导审核时间*/
    /*分管领导审核时间*/
	private java.sql.Timestamp fgAuditTime;
	
    /*主任审核意见*/
    /*主任审核意见*/
	private String zrAuditOpinion;
	
    /*主任审核时间*/
    /*主任审核时间*/
	private java.sql.Timestamp zrAuditTime;
	
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
	private com.justonetech.biz.domain.DocDocument doc;
	private com.justonetech.system.domain.SysCodeDetail type;
	private com.justonetech.system.domain.SysUser fgAuditUser;



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
	 * Return the value associated with the column: CHARGE_PERSON
	 */
	public String getChargePerson () {
		return chargePerson;
	}

	/**
	 * Set the value related to the column: CHARGE_PERSON
	 * @param chargePerson the CHARGE_PERSON value
	 */
	public void setChargePerson (String chargePerson) {
		this.chargePerson = chargePerson;
	}


	/**
	 * Return the value associated with the column: START_DEPT
	 */
	public String getStartDept () {
		return startDept;
	}

	/**
	 * Set the value related to the column: START_DEPT
	 * @param startDept the START_DEPT value
	 */
	public void setStartDept (String startDept) {
		this.startDept = startDept;
	}


	/**
	 * Return the value associated with the column: LEADER
	 */
	public String getLeader () {
		return leader;
	}

	/**
	 * Set the value related to the column: LEADER
	 * @param leader the LEADER value
	 */
	public void setLeader (String leader) {
		this.leader = leader;
	}


	/**
	 * Return the value associated with the column: INNER_PERSONS
	 */
	public String getInnerPersons () {
		return innerPersons;
	}

	/**
	 * Set the value related to the column: INNER_PERSONS
	 * @param innerPersons the INNER_PERSONS value
	 */
	public void setInnerPersons (String innerPersons) {
		this.innerPersons = innerPersons;
	}


	/**
	 * Return the value associated with the column: TITLE
	 */
	public String getTitle () {
		return title;
	}

	/**
	 * Set the value related to the column: TITLE
	 * @param title the TITLE value
	 */
	public void setTitle (String title) {
		this.title = title;
	}


	/**
	 * Return the value associated with the column: CONTENT
	 */
	public String getContent () {
		return content;
	}

	/**
	 * Set the value related to the column: CONTENT
	 * @param content the CONTENT value
	 */
	public void setContent (String content) {
		this.content = content;
	}


	/**
	 * Return the value associated with the column: RELATE_MATTER
	 */
	public String getRelateMatter () {
		return relateMatter;
	}

	/**
	 * Set the value related to the column: RELATE_MATTER
	 * @param relateMatter the RELATE_MATTER value
	 */
	public void setRelateMatter (String relateMatter) {
		this.relateMatter = relateMatter;
	}


	/**
	 * Return the value associated with the column: WORK_ADVISE
	 */
	public String getWorkAdvise () {
		return workAdvise;
	}

	/**
	 * Set the value related to the column: WORK_ADVISE
	 * @param workAdvise the WORK_ADVISE value
	 */
	public void setWorkAdvise (String workAdvise) {
		this.workAdvise = workAdvise;
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
	 * Return the value associated with the column: FG_AUDIT_OPINION
	 */
	public String getFgAuditOpinion () {
		return fgAuditOpinion;
	}

	/**
	 * Set the value related to the column: FG_AUDIT_OPINION
	 * @param fgAuditOpinion the FG_AUDIT_OPINION value
	 */
	public void setFgAuditOpinion (String fgAuditOpinion) {
		this.fgAuditOpinion = fgAuditOpinion;
	}


	/**
	 * Return the value associated with the column: FG_AUDIT_TIME
	 */
	public java.sql.Timestamp getFgAuditTime () {
		return fgAuditTime;
	}

	/**
	 * Set the value related to the column: FG_AUDIT_TIME
	 * @param fgAuditTime the FG_AUDIT_TIME value
	 */
	public void setFgAuditTime (java.sql.Timestamp fgAuditTime) {
		this.fgAuditTime = fgAuditTime;
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
	 * Return the value associated with the column: TYPE_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getType () {
		return type;
	}

	/**
	 * Set the value related to the column: TYPE_ID
	 * @param type the TYPE_ID value
	 */
	public void setType (com.justonetech.system.domain.SysCodeDetail type) {
		this.type = type;
	}


	/**
	 * Return the value associated with the column: FG_AUDIT_USER_ID
	 */
	public com.justonetech.system.domain.SysUser getFgAuditUser () {
		return fgAuditUser;
	}

	/**
	 * Set the value related to the column: FG_AUDIT_USER_ID
	 * @param fgAuditUser the FG_AUDIT_USER_ID value
	 */
	public void setFgAuditUser (com.justonetech.system.domain.SysUser fgAuditUser) {
		this.fgAuditUser = fgAuditUser;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaMeetingOuter)) return false;
		else {
			com.justonetech.biz.domain.OaMeetingOuter oaMeetingOuter = (com.justonetech.biz.domain.OaMeetingOuter) obj;
			if (null == this.getId() || null == oaMeetingOuter.getId()) return false;
			else return (this.getId().equals(oaMeetingOuter.getId()));
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
		builder.append(address);
		builder.append(chargePerson);
		builder.append(startDept);
		builder.append(leader);
		builder.append(innerPersons);
		builder.append(title);
		builder.append(content);
		builder.append(relateMatter);
		builder.append(workAdvise);
		builder.append(status);
		builder.append(fgAuditOpinion);
		builder.append(fgAuditTime);
		builder.append(zrAuditOpinion);
		builder.append(zrAuditTime);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}