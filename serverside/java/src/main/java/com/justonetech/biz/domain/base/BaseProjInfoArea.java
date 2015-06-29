package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PROJ_INFO_AREA table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目涉及区县
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 项目涉及区县
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : project
 * Projectable : true
 *
 * @hibernate.class
 *  table="PROJ_INFO_AREA"
 */

public abstract class BaseProjInfoArea  implements Serializable {

	public static String REF = "ProjInfoArea";
	public static String PROP_ID = "id";
	public static String PROP_PROJECT = "project";
	public static String PROP_BELONG_AREA = "belongArea";


	// constructors
	public BaseProjInfoArea () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProjInfoArea (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// many to one
	private com.justonetech.system.domain.SysCodeDetail belongArea;
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
	 * Return the value associated with the column: BELONG_AREA_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getBelongArea () {
		return belongArea;
	}

	/**
	 * Set the value related to the column: BELONG_AREA_ID
	 * @param belongArea the BELONG_AREA_ID value
	 */
	public void setBelongArea (com.justonetech.system.domain.SysCodeDetail belongArea) {
		this.belongArea = belongArea;
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
		if (!(obj instanceof com.justonetech.biz.domain.ProjInfoArea)) return false;
		else {
			com.justonetech.biz.domain.ProjInfoArea projInfoArea = (com.justonetech.biz.domain.ProjInfoArea) obj;
			if (null == this.getId() || null == projInfoArea.getId()) return false;
			else return (this.getId().equals(projInfoArea.getId()));
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