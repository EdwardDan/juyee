package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BPM_DUTY_PERSON table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : workflow
 * Projectable : false
 *
 * @hibernate.class
 *  table="BPM_DUTY_PERSON"
 */

public abstract class BaseBpmDutyPerson  implements Serializable {

	public static String REF = "BpmDutyPerson";
	public static String PROP_ID = "id";
	public static String PROP_PERSON = "person";
	public static String PROP_GROUP_DUTY = "groupDuty";


	// constructors
	public BaseBpmDutyPerson () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBpmDutyPerson (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBpmDutyPerson (
		java.lang.Long id,
		com.justonetech.biz.domain.BpmProjectGroupDuty groupDuty,
		com.justonetech.system.domain.SysPerson person) {

		this.setId(id);
		this.setGroupDuty(groupDuty);
		this.setPerson(person);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// many to one
	private com.justonetech.biz.domain.BpmProjectGroupDuty groupDuty;
	private com.justonetech.system.domain.SysPerson person;



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
	 * Return the value associated with the column: GROUP_DUTY_ID
	 */
	public com.justonetech.biz.domain.BpmProjectGroupDuty getGroupDuty () {
		return groupDuty;
	}

	/**
	 * Set the value related to the column: GROUP_DUTY_ID
	 * @param groupDuty the GROUP_DUTY_ID value
	 */
	public void setGroupDuty (com.justonetech.biz.domain.BpmProjectGroupDuty groupDuty) {
		this.groupDuty = groupDuty;
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
		if (!(obj instanceof com.justonetech.biz.domain.BpmDutyPerson)) return false;
		else {
			com.justonetech.biz.domain.BpmDutyPerson bpmDutyPerson = (com.justonetech.biz.domain.BpmDutyPerson) obj;
			if (null == this.getId() || null == bpmDutyPerson.getId()) return false;
			else return (this.getId().equals(bpmDutyPerson.getId()));
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