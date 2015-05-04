package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PROJ_RELATE_PERSON table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目与人员关联
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 项目与人员关联
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : project
 * Projectable : true
 *
 * @hibernate.class
 *  table="PROJ_RELATE_PERSON"
 */

public abstract class BaseProjRelatePerson  implements Serializable {

	public static String REF = "ProjRelatePerson";
	public static String PROP_ID = "id";
	public static String PROP_PROJECT = "project";
	public static String PROP_DUTY_ROLE = "dutyRole";
	public static String PROP_PERSON = "person";


	// constructors
	public BaseProjRelatePerson () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProjRelatePerson (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*承担AB角*/
    /*承担AB角*/
	private String dutyRole;
	

	// many to one
	private com.justonetech.biz.domain.ProjInfo project;
	private com.justonetech.system.domain.SysPerson person;



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
	 * Return the value associated with the column: DUTY_ROLE
	 */
	public String getDutyRole () {
		return dutyRole;
	}

	/**
	 * Set the value related to the column: DUTY_ROLE
	 * @param dutyRole the DUTY_ROLE value
	 */
	public void setDutyRole (String dutyRole) {
		this.dutyRole = dutyRole;
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


	/**
	 * Return the value associated with the column: PERSON_ID
	 */
	public com.justonetech.system.domain.SysPerson getPerson () {
		return person;
	}

	/**
	 * Set the value related to the column: PERSON_ID
	 * @param person the PERSON_ID value
	 */
	public void setPerson (com.justonetech.system.domain.SysPerson person) {
		this.person = person;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ProjRelatePerson)) return false;
		else {
			com.justonetech.biz.domain.ProjRelatePerson projRelatePerson = (com.justonetech.biz.domain.ProjRelatePerson) obj;
			if (null == this.getId() || null == projRelatePerson.getId()) return false;
			else return (this.getId().equals(projRelatePerson.getId()));
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
		builder.append(dutyRole);
		return builder.toString();
	}


}