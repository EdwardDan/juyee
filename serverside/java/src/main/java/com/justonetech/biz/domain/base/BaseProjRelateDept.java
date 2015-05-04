package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PROJ_RELATE_DEPT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目与单位关联
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 项目与单位关联
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : project
 * Projectable : true
 *
 * @hibernate.class
 *  table="PROJ_RELATE_DEPT"
 */

public abstract class BaseProjRelateDept  implements Serializable {

	public static String REF = "ProjRelateDept";
	public static String PROP_DEPT = "dept";
	public static String PROP_ID = "id";
	public static String PROP_PROJECT = "project";


	// constructors
	public BaseProjRelateDept () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProjRelateDept (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// many to one
	private com.justonetech.system.domain.SysDept dept;
	private com.justonetech.biz.domain.ProjInfo project;



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
	 * Return the value associated with the column: DEPT_ID
	 */
	public com.justonetech.system.domain.SysDept getDept () {
		return dept;
	}

	/**
	 * Set the value related to the column: DEPT_ID
	 * @param dept the DEPT_ID value
	 */
	public void setDept (com.justonetech.system.domain.SysDept dept) {
		this.dept = dept;
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



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ProjRelateDept)) return false;
		else {
			com.justonetech.biz.domain.ProjRelateDept projRelateDept = (com.justonetech.biz.domain.ProjRelateDept) obj;
			if (null == this.getId() || null == projRelateDept.getId()) return false;
			else return (this.getId().equals(projRelateDept.getId()));
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