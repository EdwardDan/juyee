package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the WORKER_SCHOOL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 务工人员学校管理
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 务工人员学校管理
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : worker
 * Projectable : false
 *
 * @hibernate.class
 *  table="WORKER_SCHOOL"
 */

public abstract class BaseWorkerSchool  implements Serializable ,Auditable {

	public static String REF = "WorkerSchool";
	public static String PROP_XZ_NAME = "xzName";
	public static String PROP_PROJECT_NAME = "projectName";
	public static String PROP_SG_DEPT = "sgDept";
	public static String PROP_XZ_TEL = "xzTel";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ZZ_DEPT = "zzDept";
	public static String PROP_XZ_DEPT = "xzDept";
	public static String PROP_JS_DEPT = "jsDept";
	public static String PROP_JS_DEPT_LXR = "jsDeptLxr";
	public static String PROP_SG_DEPT_LXR = "sgDeptLxr";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_BJBH = "bjbh";
	public static String PROP_PROJECT_ADDRESS = "projectAddress";
	public static String PROP_ZZ_NAME = "zzName";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_JS_DEPT_TEL = "jsDeptTel";
	public static String PROP_ID = "id";
	public static String PROP_ZZ_TEL = "zzTel";
	public static String PROP_SG_DEPT_TEL = "sgDeptTel";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseWorkerSchool () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWorkerSchool (Long id) {
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
	
    /*项目地点*/
    /*项目地点*/
	private String projectAddress;
	
    /*建设单位名称*/
    /*建设单位名称*/
	private String jsDept;
	
    /*建设单位负责人*/
    /*建设单位负责人*/
	private String jsDeptLxr;
	
    /*建设单位联系电话*/
    /*建设单位联系电话*/
	private String jsDeptTel;
	
    /*施工单位名称*/
    /*施工单位名称*/
	private String sgDept;
	
    /*施工单位负责人*/
    /*施工单位负责人*/
	private String sgDeptLxr;
	
    /*施工单位联系电话*/
    /*施工单位联系电话*/
	private String sgDeptTel;
	
    /*校长姓名*/
    /*校长姓名*/
	private String xzName;
	
    /*校长电话*/
    /*校长电话*/
	private String xzTel;
	
    /*校长所属单位名称*/
    /*校长所属单位名称*/
	private String xzDept;
	
    /*组长姓名*/
    /*组长姓名*/
	private String zzName;
	
    /*组长电话*/
    /*组长电话*/
	private String zzTel;
	
    /*组长所属单位名称*/
    /*组长所属单位名称*/
	private String zzDept;
	
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
	

	// collections
	private java.util.Set<com.justonetech.biz.domain.WorkerSchoolActivity> workerSchoolActivities;



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
	 * Return the value associated with the column: PROJECT_ADDRESS
	 */
	public String getProjectAddress () {
		return projectAddress;
	}

	/**
	 * Set the value related to the column: PROJECT_ADDRESS
	 * @param projectAddress the PROJECT_ADDRESS value
	 */
	public void setProjectAddress (String projectAddress) {
		this.projectAddress = projectAddress;
	}


	/**
	 * Return the value associated with the column: JS_DEPT
	 */
	public String getJsDept () {
		return jsDept;
	}

	/**
	 * Set the value related to the column: JS_DEPT
	 * @param jsDept the JS_DEPT value
	 */
	public void setJsDept (String jsDept) {
		this.jsDept = jsDept;
	}


	/**
	 * Return the value associated with the column: JS_DEPT_LXR
	 */
	public String getJsDeptLxr () {
		return jsDeptLxr;
	}

	/**
	 * Set the value related to the column: JS_DEPT_LXR
	 * @param jsDeptLxr the JS_DEPT_LXR value
	 */
	public void setJsDeptLxr (String jsDeptLxr) {
		this.jsDeptLxr = jsDeptLxr;
	}


	/**
	 * Return the value associated with the column: JS_DEPT_TEL
	 */
	public String getJsDeptTel () {
		return jsDeptTel;
	}

	/**
	 * Set the value related to the column: JS_DEPT_TEL
	 * @param jsDeptTel the JS_DEPT_TEL value
	 */
	public void setJsDeptTel (String jsDeptTel) {
		this.jsDeptTel = jsDeptTel;
	}


	/**
	 * Return the value associated with the column: SG_DEPT
	 */
	public String getSgDept () {
		return sgDept;
	}

	/**
	 * Set the value related to the column: SG_DEPT
	 * @param sgDept the SG_DEPT value
	 */
	public void setSgDept (String sgDept) {
		this.sgDept = sgDept;
	}


	/**
	 * Return the value associated with the column: SG_DEPT_LXR
	 */
	public String getSgDeptLxr () {
		return sgDeptLxr;
	}

	/**
	 * Set the value related to the column: SG_DEPT_LXR
	 * @param sgDeptLxr the SG_DEPT_LXR value
	 */
	public void setSgDeptLxr (String sgDeptLxr) {
		this.sgDeptLxr = sgDeptLxr;
	}


	/**
	 * Return the value associated with the column: SG_DEPT_TEL
	 */
	public String getSgDeptTel () {
		return sgDeptTel;
	}

	/**
	 * Set the value related to the column: SG_DEPT_TEL
	 * @param sgDeptTel the SG_DEPT_TEL value
	 */
	public void setSgDeptTel (String sgDeptTel) {
		this.sgDeptTel = sgDeptTel;
	}


	/**
	 * Return the value associated with the column: XZ_NAME
	 */
	public String getXzName () {
		return xzName;
	}

	/**
	 * Set the value related to the column: XZ_NAME
	 * @param xzName the XZ_NAME value
	 */
	public void setXzName (String xzName) {
		this.xzName = xzName;
	}


	/**
	 * Return the value associated with the column: XZ_TEL
	 */
	public String getXzTel () {
		return xzTel;
	}

	/**
	 * Set the value related to the column: XZ_TEL
	 * @param xzTel the XZ_TEL value
	 */
	public void setXzTel (String xzTel) {
		this.xzTel = xzTel;
	}


	/**
	 * Return the value associated with the column: XZ_DEPT
	 */
	public String getXzDept () {
		return xzDept;
	}

	/**
	 * Set the value related to the column: XZ_DEPT
	 * @param xzDept the XZ_DEPT value
	 */
	public void setXzDept (String xzDept) {
		this.xzDept = xzDept;
	}


	/**
	 * Return the value associated with the column: ZZ_NAME
	 */
	public String getZzName () {
		return zzName;
	}

	/**
	 * Set the value related to the column: ZZ_NAME
	 * @param zzName the ZZ_NAME value
	 */
	public void setZzName (String zzName) {
		this.zzName = zzName;
	}


	/**
	 * Return the value associated with the column: ZZ_TEL
	 */
	public String getZzTel () {
		return zzTel;
	}

	/**
	 * Set the value related to the column: ZZ_TEL
	 * @param zzTel the ZZ_TEL value
	 */
	public void setZzTel (String zzTel) {
		this.zzTel = zzTel;
	}


	/**
	 * Return the value associated with the column: ZZ_DEPT
	 */
	public String getZzDept () {
		return zzDept;
	}

	/**
	 * Set the value related to the column: ZZ_DEPT
	 * @param zzDept the ZZ_DEPT value
	 */
	public void setZzDept (String zzDept) {
		this.zzDept = zzDept;
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
	 * Return the value associated with the column: workerSchoolActivities
	 */
	public java.util.Set<com.justonetech.biz.domain.WorkerSchoolActivity> getWorkerSchoolActivities () {
		if(workerSchoolActivities == null){
			workerSchoolActivities = new java.util.LinkedHashSet<com.justonetech.biz.domain.WorkerSchoolActivity>();
		}
		return workerSchoolActivities;
	}

	/**
	 * Set the value related to the column: workerSchoolActivities
	 * @param workerSchoolActivities the workerSchoolActivities value
	 */
	public void setWorkerSchoolActivities (java.util.Set<com.justonetech.biz.domain.WorkerSchoolActivity> workerSchoolActivities) {
		this.workerSchoolActivities = workerSchoolActivities;
	}

	public void addToworkerSchoolActivities (com.justonetech.biz.domain.WorkerSchoolActivity workerSchoolActivity) {
		if (null == getWorkerSchoolActivities()) setWorkerSchoolActivities(new java.util.LinkedHashSet<com.justonetech.biz.domain.WorkerSchoolActivity>());
		getWorkerSchoolActivities().add(workerSchoolActivity);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.WorkerSchool)) return false;
		else {
			com.justonetech.biz.domain.WorkerSchool workerSchool = (com.justonetech.biz.domain.WorkerSchool) obj;
			if (null == this.getId() || null == workerSchool.getId()) return false;
			else return (this.getId().equals(workerSchool.getId()));
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
		builder.append(projectAddress);
		builder.append(jsDept);
		builder.append(jsDeptLxr);
		builder.append(jsDeptTel);
		builder.append(sgDept);
		builder.append(sgDeptLxr);
		builder.append(sgDeptTel);
		builder.append(xzName);
		builder.append(xzTel);
		builder.append(xzDept);
		builder.append(zzName);
		builder.append(zzTel);
		builder.append(zzDept);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}