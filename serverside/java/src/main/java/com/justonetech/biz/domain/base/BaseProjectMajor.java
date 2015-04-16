package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PROJECT_MAJOR table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目重大工程
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 项目重大工程
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : project
 * Projectable : false
 *
 * @hibernate.class
 *  table="PROJECT_MAJOR"
 */

public abstract class BaseProjectMajor  implements Serializable,Auditable {

	public static String REF = "ProjectMajor";
	public static String PROP_PROJECT_NAME = "projectName";
	public static String PROP_PROJECT_ADD = "projectAdd";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_PROJECT_TYPE_DESC = "projectTypeDesc";
	public static String PROP_SCHEDULE_DESC = "scheduleDesc";
	public static String PROP_PROJECT_TYPE = "projectType";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_SCHEDULE = "schedule";
	public static String PROP_BJBH = "bjbh";
	public static String PROP_POS_Y = "posY";
	public static String PROP_POS_X = "posX";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_ID = "id";
	public static String PROP_JS_UNIT_NAME = "jsUnitName";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseProjectMajor () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProjectMajor (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*报建编号*/
    /*报建编号*/
	private String bjbh;
	
    /*项目名称*/
    /*项目名称*/
	private String projectName;
	
    /*项目地址*/
    /*项目地址*/
	private String projectAdd;
	
    /*建设单位*/
    /*建设单位*/
	private String jsUnitName;
	
    /*项目类型中文描述*/
    /*项目类型中文描述*/
	private String projectTypeDesc;
	
    /*当前进度中文描述*/
    /*当前进度中文描述*/
	private String scheduleDesc;
	
    /*坐标X*/
    /*坐标X*/
	private Double posX;
	
    /*坐标Y*/
    /*坐标Y*/
	private Double posY;
	
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
	private com.justonetech.system.domain.SysCodeDetail schedule;
	private com.justonetech.system.domain.SysCodeDetail projectType;



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
	 * Return the value associated with the column: PROJECT_NAME
	 */
	public String getProjectName () {
		return projectName;
	}

	/**
	 * Set the value related to the column: PROJECT_NAME
	 * @param projectName the PROJECT_NAME value
	 */
	public void setProjectName (String projectName) {
		this.projectName = projectName;
	}


	/**
	 * Return the value associated with the column: PROJECT_ADD
	 */
	public String getProjectAdd () {
		return projectAdd;
	}

	/**
	 * Set the value related to the column: PROJECT_ADD
	 * @param projectAdd the PROJECT_ADD value
	 */
	public void setProjectAdd (String projectAdd) {
		this.projectAdd = projectAdd;
	}


	/**
	 * Return the value associated with the column: JS_UNIT_NAME
	 */
	public String getJsUnitName () {
		return jsUnitName;
	}

	/**
	 * Set the value related to the column: JS_UNIT_NAME
	 * @param jsUnitName the JS_UNIT_NAME value
	 */
	public void setJsUnitName (String jsUnitName) {
		this.jsUnitName = jsUnitName;
	}


	/**
	 * Return the value associated with the column: PROJECT_TYPE_DESC
	 */
	public String getProjectTypeDesc () {
		return projectTypeDesc;
	}

	/**
	 * Set the value related to the column: PROJECT_TYPE_DESC
	 * @param projectTypeDesc the PROJECT_TYPE_DESC value
	 */
	public void setProjectTypeDesc (String projectTypeDesc) {
		this.projectTypeDesc = projectTypeDesc;
	}


	/**
	 * Return the value associated with the column: SCHEDULE_DESC
	 */
	public String getScheduleDesc () {
		return scheduleDesc;
	}

	/**
	 * Set the value related to the column: SCHEDULE_DESC
	 * @param scheduleDesc the SCHEDULE_DESC value
	 */
	public void setScheduleDesc (String scheduleDesc) {
		this.scheduleDesc = scheduleDesc;
	}


	/**
	 * Return the value associated with the column: POS_X
	 */
	public Double getPosX () {
		return posX;
	}

	/**
	 * Set the value related to the column: POS_X
	 * @param posX the POS_X value
	 */
	public void setPosX (Double posX) {
		this.posX = posX;
	}


	/**
	 * Return the value associated with the column: POS_Y
	 */
	public Double getPosY () {
		return posY;
	}

	/**
	 * Set the value related to the column: POS_Y
	 * @param posY the POS_Y value
	 */
	public void setPosY (Double posY) {
		this.posY = posY;
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
	 * Return the value associated with the column: SCHEDULE_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getSchedule () {
		return schedule;
	}

	/**
	 * Set the value related to the column: SCHEDULE_ID
	 * @param schedule the SCHEDULE_ID value
	 */
	public void setSchedule (com.justonetech.system.domain.SysCodeDetail schedule) {
		this.schedule = schedule;
	}


	/**
	 * Return the value associated with the column: PROJECT_TYPE_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getProjectType () {
		return projectType;
	}

	/**
	 * Set the value related to the column: PROJECT_TYPE_ID
	 * @param projectType the PROJECT_TYPE_ID value
	 */
	public void setProjectType (com.justonetech.system.domain.SysCodeDetail projectType) {
		this.projectType = projectType;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ProjectMajor)) return false;
		else {
			com.justonetech.biz.domain.ProjectMajor projectMajor = (com.justonetech.biz.domain.ProjectMajor) obj;
			if (null == this.getId() || null == projectMajor.getId()) return false;
			else return (this.getId().equals(projectMajor.getId()));
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
		builder.append(bjbh);
		builder.append(projectName);
		builder.append(projectAdd);
		builder.append(jsUnitName);
		builder.append(projectTypeDesc);
		builder.append(scheduleDesc);
		builder.append(posX);
		builder.append(posY);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}