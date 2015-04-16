package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_MEETING table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 会议管理
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 会议管理
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : car
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_MEETING"
 */

public abstract class BaseOaMeeting  implements Serializable , Auditable {

	public static String REF = "OaMeeting";
	public static String PROP_PERSON_NUM = "personNum";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ROOM_DESC = "roomDesc";
	public static String PROP_USE_DATE = "useDate";
	public static String PROP_TITLE = "title";
	public static String PROP_AUDIT_USER = "auditUser";
	public static String PROP_STATUS = "status";
	public static String PROP_ROOM = "room";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_APPLY_PERSON = "applyPerson";
	public static String PROP_OUTER_PERSONS = "outerPersons";
	public static String PROP_AUDIT_TIME = "auditTime";
	public static String PROP_APPLY_DEPT = "applyDept";
	public static String PROP_USE_TIME = "useTime";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_ID = "id";
	public static String PROP_CONTENT = "content";
	public static String PROP_AUDIT_OPINION = "auditOpinion";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseOaMeeting () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaMeeting (java.lang.Long id) {
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
	
    /*申请会议室中文描述*/
    /*申请会议室中文描述*/
	private java.lang.String roomDesc;
	
    /*会议召开时间*/
    /*会议召开时间*/
	private java.sql.Date useDate;
	
    /*会议召开时间上下午*/
    /*会议召开时间上下午*/
	private java.lang.String useTime;
	
    /*预计参与人数*/
    /*预计参与人数*/
	private java.lang.Integer personNum;
	
    /*外部人员*/
    /*外部人员*/
	private java.lang.String outerPersons;
	
    /*会议主题*/
    /*会议主题*/
	private java.lang.String title;
	
    /*会议内容*/
    /*会议内容*/
	private java.lang.String content;
	
    /*备注*/
    /*备注*/
	private java.lang.String description;
	
    /*状态*/
    /*状态*/
	private java.lang.Integer status;
	
    /*审核意见*/
    /*审核意见*/
	private java.lang.String auditOpinion;
	
    /*审核时间*/
    /*审核时间*/
	private java.sql.Timestamp auditTime;
	
    /*审核用户名*/
    /*审核用户名*/
	private java.lang.String auditUser;
	
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
	private com.justonetech.system.domain.SysCodeDetail room;



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
	 * Return the value associated with the column: ROOM_DESC
	 */
	public java.lang.String getRoomDesc () {
		return roomDesc;
	}

	/**
	 * Set the value related to the column: ROOM_DESC
	 * @param roomDesc the ROOM_DESC value
	 */
	public void setRoomDesc (java.lang.String roomDesc) {
		this.roomDesc = roomDesc;
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
	 * Return the value associated with the column: USE_TIME
	 */
	public java.lang.String getUseTime () {
		return useTime;
	}

	/**
	 * Set the value related to the column: USE_TIME
	 * @param useTime the USE_TIME value
	 */
	public void setUseTime (java.lang.String useTime) {
		this.useTime = useTime;
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
	 * Return the value associated with the column: OUTER_PERSONS
	 */
	public java.lang.String getOuterPersons () {
		return outerPersons;
	}

	/**
	 * Set the value related to the column: OUTER_PERSONS
	 * @param outerPersons the OUTER_PERSONS value
	 */
	public void setOuterPersons (java.lang.String outerPersons) {
		this.outerPersons = outerPersons;
	}


	/**
	 * Return the value associated with the column: TITLE
	 */
	public java.lang.String getTitle () {
		return title;
	}

	/**
	 * Set the value related to the column: TITLE
	 * @param title the TITLE value
	 */
	public void setTitle (java.lang.String title) {
		this.title = title;
	}


	/**
	 * Return the value associated with the column: CONTENT
	 */
	public java.lang.String getContent () {
		return content;
	}

	/**
	 * Set the value related to the column: CONTENT
	 * @param content the CONTENT value
	 */
	public void setContent (java.lang.String content) {
		this.content = content;
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
	 * Return the value associated with the column: ROOM_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getRoom () {
		return room;
	}

	/**
	 * Set the value related to the column: ROOM_ID
	 * @param room the ROOM_ID value
	 */
	public void setRoom (com.justonetech.system.domain.SysCodeDetail room) {
		this.room = room;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaMeeting)) return false;
		else {
			com.justonetech.biz.domain.OaMeeting oaMeeting = (com.justonetech.biz.domain.OaMeeting) obj;
			if (null == this.getId() || null == oaMeeting.getId()) return false;
			else return (this.getId().equals(oaMeeting.getId()));
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
		builder.append(roomDesc);
		builder.append(useDate);
		builder.append(useTime);
		builder.append(personNum);
		builder.append(outerPersons);
		builder.append(title);
		builder.append(content);
		builder.append(description);
		builder.append(status);
		builder.append(auditOpinion);
		builder.append(auditTime);
		builder.append(auditUser);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}