package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PROJECT_WORK_SITE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * Treeable : false
 * SyncDao : false
 * SyncTemplatepatterns : list\w*
 * Projectable : false
 * SyncJsp : true
 * SyncBoolean : get
 *
 * @hibernate.class
 *  table="PROJECT_WORK_SITE"
 */

public abstract class BaseProjectWorkSite  implements Serializable,Auditable {

	public static String REF = "ProjectWorkSite";
	public static String PROP_JL_DEPT_NAME = "jlDeptName";
	public static String PROP_DEPT_ID = "deptId";
	public static String PROP_WORK_NAME = "workName";
	public static String PROP_JL_DEPT_CODE = "jlDeptCode";
	public static String PROP_VIDEO_PATH = "videoPath";
	public static String PROP_WORK_CODE = "workCode";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_SG_DEPT_NAME = "sgDeptName";
	public static String PROP_JG_DEPT_CODE = "jgDeptCode";
	public static String PROP_STATUS = "status";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_SG_DEPT_CODE = "sgDeptCode";
	public static String PROP_SELF_DEFINE_NAME = "selfDefineName";
	public static String PROP_STATUS_DESC = "statusDesc";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_ADDRESS = "address";
	public static String PROP_LATITUDE = "latitude";
	public static String PROP_JG_DEPT_NAME = "jgDeptName";
	public static String PROP_ID = "id";
	public static String PROP_LONGITUDE = "longitude";
	public static String PROP_PROJECT_ID = "projectId";
	public static String PROP_IMAGE_PATH = "imagePath";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseProjectWorkSite () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProjectWorkSite (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.Long deptId;
	
	private java.lang.Long projectId;
	
	private java.lang.String workCode;
	
	private java.lang.String workName;
	
	private java.lang.String address;
	
	private java.lang.String status;
	
	private java.lang.String statusDesc;
	
	private java.lang.String jgDeptCode;
	
	private java.lang.String jgDeptName;
	
	private java.lang.String sgDeptCode;
	
	private java.lang.String sgDeptName;
	
	private java.lang.String jlDeptCode;
	
	private java.lang.String jlDeptName;
	
	private java.lang.String selfDefineName;
	
	private java.lang.String videoPath;
	
	private java.lang.String imagePath;
	
	private java.lang.Double longitude;
	
	private java.lang.Double latitude;
	
	private java.sql.Timestamp createTime;
	
	private java.sql.Timestamp updateTime;
	
	private java.lang.String createUser;
	
	private java.lang.String updateUser;
	



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
	 * Return the value associated with the column: DEPT_ID
	 */
	public java.lang.Long getDeptId () {
		return deptId;
	}

	/**
	 * Set the value related to the column: DEPT_ID
	 * @param deptId the DEPT_ID value
	 */
	public void setDeptId (java.lang.Long deptId) {
		this.deptId = deptId;
	}


	/**
	 * Return the value associated with the column: PROJECT_ID
	 */
	public java.lang.Long getProjectId () {
		return projectId;
	}

	/**
	 * Set the value related to the column: PROJECT_ID
	 * @param projectId the PROJECT_ID value
	 */
	public void setProjectId (java.lang.Long projectId) {
		this.projectId = projectId;
	}


	/**
	 * Return the value associated with the column: WORK_CODE
	 */
	public java.lang.String getWorkCode () {
		return workCode;
	}

	/**
	 * Set the value related to the column: WORK_CODE
	 * @param workCode the WORK_CODE value
	 */
	public void setWorkCode (java.lang.String workCode) {
		this.workCode = workCode;
	}


	/**
	 * Return the value associated with the column: WORK_NAME
	 */
	public java.lang.String getWorkName () {
		return workName;
	}

	/**
	 * Set the value related to the column: WORK_NAME
	 * @param workName the WORK_NAME value
	 */
	public void setWorkName (java.lang.String workName) {
		this.workName = workName;
	}


	/**
	 * Return the value associated with the column: ADDRESS
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: ADDRESS
	 * @param address the ADDRESS value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
	}


	/**
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}


	/**
	 * Return the value associated with the column: STATUS_DESC
	 */
	public java.lang.String getStatusDesc () {
		return statusDesc;
	}

	/**
	 * Set the value related to the column: STATUS_DESC
	 * @param statusDesc the STATUS_DESC value
	 */
	public void setStatusDesc (java.lang.String statusDesc) {
		this.statusDesc = statusDesc;
	}


	/**
	 * Return the value associated with the column: JG_DEPT_CODE
	 */
	public java.lang.String getJgDeptCode () {
		return jgDeptCode;
	}

	/**
	 * Set the value related to the column: JG_DEPT_CODE
	 * @param jgDeptCode the JG_DEPT_CODE value
	 */
	public void setJgDeptCode (java.lang.String jgDeptCode) {
		this.jgDeptCode = jgDeptCode;
	}


	/**
	 * Return the value associated with the column: JG_DEPT_NAME
	 */
	public java.lang.String getJgDeptName () {
		return jgDeptName;
	}

	/**
	 * Set the value related to the column: JG_DEPT_NAME
	 * @param jgDeptName the JG_DEPT_NAME value
	 */
	public void setJgDeptName (java.lang.String jgDeptName) {
		this.jgDeptName = jgDeptName;
	}


	/**
	 * Return the value associated with the column: SG_DEPT_CODE
	 */
	public java.lang.String getSgDeptCode () {
		return sgDeptCode;
	}

	/**
	 * Set the value related to the column: SG_DEPT_CODE
	 * @param sgDeptCode the SG_DEPT_CODE value
	 */
	public void setSgDeptCode (java.lang.String sgDeptCode) {
		this.sgDeptCode = sgDeptCode;
	}


	/**
	 * Return the value associated with the column: SG_DEPT_NAME
	 */
	public java.lang.String getSgDeptName () {
		return sgDeptName;
	}

	/**
	 * Set the value related to the column: SG_DEPT_NAME
	 * @param sgDeptName the SG_DEPT_NAME value
	 */
	public void setSgDeptName (java.lang.String sgDeptName) {
		this.sgDeptName = sgDeptName;
	}


	/**
	 * Return the value associated with the column: JL_DEPT_CODE
	 */
	public java.lang.String getJlDeptCode () {
		return jlDeptCode;
	}

	/**
	 * Set the value related to the column: JL_DEPT_CODE
	 * @param jlDeptCode the JL_DEPT_CODE value
	 */
	public void setJlDeptCode (java.lang.String jlDeptCode) {
		this.jlDeptCode = jlDeptCode;
	}


	/**
	 * Return the value associated with the column: JL_DEPT_NAME
	 */
	public java.lang.String getJlDeptName () {
		return jlDeptName;
	}

	/**
	 * Set the value related to the column: JL_DEPT_NAME
	 * @param jlDeptName the JL_DEPT_NAME value
	 */
	public void setJlDeptName (java.lang.String jlDeptName) {
		this.jlDeptName = jlDeptName;
	}


	/**
	 * Return the value associated with the column: SELF_DEFINE_NAME
	 */
	public java.lang.String getSelfDefineName () {
		return selfDefineName;
	}

	/**
	 * Set the value related to the column: SELF_DEFINE_NAME
	 * @param selfDefineName the SELF_DEFINE_NAME value
	 */
	public void setSelfDefineName (java.lang.String selfDefineName) {
		this.selfDefineName = selfDefineName;
	}


	/**
	 * Return the value associated with the column: VIDEO_PATH
	 */
	public java.lang.String getVideoPath () {
		return videoPath;
	}

	/**
	 * Set the value related to the column: VIDEO_PATH
	 * @param videoPath the VIDEO_PATH value
	 */
	public void setVideoPath (java.lang.String videoPath) {
		this.videoPath = videoPath;
	}


	/**
	 * Return the value associated with the column: IMAGE_PATH
	 */
	public java.lang.String getImagePath () {
		return imagePath;
	}

	/**
	 * Set the value related to the column: IMAGE_PATH
	 * @param imagePath the IMAGE_PATH value
	 */
	public void setImagePath (java.lang.String imagePath) {
		this.imagePath = imagePath;
	}


	/**
	 * Return the value associated with the column: LONGITUDE
	 */
	public java.lang.Double getLongitude () {
		return longitude;
	}

	/**
	 * Set the value related to the column: LONGITUDE
	 * @param longitude the LONGITUDE value
	 */
	public void setLongitude (java.lang.Double longitude) {
		this.longitude = longitude;
	}


	/**
	 * Return the value associated with the column: LATITUDE
	 */
	public java.lang.Double getLatitude () {
		return latitude;
	}

	/**
	 * Set the value related to the column: LATITUDE
	 * @param latitude the LATITUDE value
	 */
	public void setLatitude (java.lang.Double latitude) {
		this.latitude = latitude;
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



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ProjectWorkSite)) return false;
		else {
			com.justonetech.biz.domain.ProjectWorkSite projectWorkSite = (com.justonetech.biz.domain.ProjectWorkSite) obj;
			if (null == this.getId() || null == projectWorkSite.getId()) return false;
			else return (this.getId().equals(projectWorkSite.getId()));
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
		builder.append(deptId);
		builder.append(projectId);
		builder.append(workCode);
		builder.append(workName);
		builder.append(address);
		builder.append(status);
		builder.append(statusDesc);
		builder.append(jgDeptCode);
		builder.append(jgDeptName);
		builder.append(sgDeptCode);
		builder.append(sgDeptName);
		builder.append(jlDeptCode);
		builder.append(jlDeptName);
		builder.append(selfDefineName);
		builder.append(videoPath);
		builder.append(imagePath);
		builder.append(longitude);
		builder.append(latitude);
		builder.append(createTime);
		builder.append(updateTime);
		builder.append(createUser);
		builder.append(updateUser);
		return builder.toString();
	}


}