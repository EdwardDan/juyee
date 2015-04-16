package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_TASK_TYPE_PRIVILEGE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 任务类型关联权限
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 任务类型关联权限
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_TASK_TYPE_PRIVILEGE"
 */

public abstract class BaseOaTaskTypePrivilege  implements Serializable {

	public static String REF = "OaTaskTypePrivilege";
	public static String PROP_PRIVILEGE = "privilege";
	public static String PROP_ID = "id";
	public static String PROP_TASK_TYPE = "taskType";


	// constructors
	public BaseOaTaskTypePrivilege () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaTaskTypePrivilege (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// many to one
	private com.justonetech.system.domain.SysPrivilege privilege;
	private com.justonetech.biz.domain.OaTaskType taskType;



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
	 * Return the value associated with the column: PRIVILEGE_ID
	 */
	public com.justonetech.system.domain.SysPrivilege getPrivilege () {
		return privilege;
	}

	/**
	 * Set the value related to the column: PRIVILEGE_ID
	 * @param privilege the PRIVILEGE_ID value
	 */
	public void setPrivilege (com.justonetech.system.domain.SysPrivilege privilege) {
		this.privilege = privilege;
	}


	/**
	 * Return the value associated with the column: TASK_TYPE_ID
	 */
	public com.justonetech.biz.domain.OaTaskType getTaskType () {
		return taskType;
	}

	/**
	 * Set the value related to the column: TASK_TYPE_ID
	 * @param taskType the TASK_TYPE_ID value
	 */
	public void setTaskType (com.justonetech.biz.domain.OaTaskType taskType) {
		this.taskType = taskType;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaTaskTypePrivilege)) return false;
		else {
			com.justonetech.biz.domain.OaTaskTypePrivilege oaTaskTypePrivilege = (com.justonetech.biz.domain.OaTaskTypePrivilege) obj;
			if (null == this.getId() || null == oaTaskTypePrivilege.getId()) return false;
			else return (this.getId().equals(oaTaskTypePrivilege.getId()));
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
		return builder.toString();
	}


}