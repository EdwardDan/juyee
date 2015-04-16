package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BPM_PROJECT_GROUP_DUTY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目组岗位
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 项目组岗位
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : workflow
 * Projectable : false
 *
 * @hibernate.class
 *  table="BPM_PROJECT_GROUP_DUTY"
 */

public abstract class BaseBpmProjectGroupDuty  implements Serializable {

	public static String REF = "BpmProjectGroupDuty";
	public static String PROP_PROJECT_GROUP = "projectGroup";
	public static String PROP_NAME = "name";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_ATTRIBUTES = "attributes";
	public static String PROP_TYPE = "type";
	public static String PROP_IS_VALID = "isValid";
	public static String PROP_ID = "id";
	public static String PROP_CODE = "code";


	// constructors
	public BaseBpmProjectGroupDuty () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBpmProjectGroupDuty (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBpmProjectGroupDuty (
		java.lang.Long id,
		com.justonetech.biz.domain.BpmProjectGroup projectGroup,
		java.lang.String name) {

		this.setId(id);
		this.setProjectGroup(projectGroup);
		this.setName(name);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*岗位编码*/
    /*岗位编码*/
	private java.lang.String code;
	
    /*岗位名称*/
    /*岗位名称*/
	private java.lang.String name;
	
    /*扩展属性*/
    /*扩展属性*/
	private java.lang.String attributes;
	
    /*备注*/
    /*备注*/
	private java.lang.String description;
	
    /*是否有效*/
    /*是否有效*/
	private java.lang.Boolean isValid;
	

	// many to one
	private com.justonetech.biz.domain.BpmProjectGroup projectGroup;
	private com.justonetech.system.domain.SysCodeDetail type;

	// collections
	private java.util.Set<com.justonetech.biz.domain.BpmDutyPerson> bpmDutyPersons;



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
	 * Return the value associated with the column: CODE
	 */
	public java.lang.String getCode () {
		return code;
	}

	/**
	 * Set the value related to the column: CODE
	 * @param code the CODE value
	 */
	public void setCode (java.lang.String code) {
		this.code = code;
	}


	/**
	 * Return the value associated with the column: NAME
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: NAME
	 * @param name the NAME value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}


	/**
	 * Return the value associated with the column: ATTRIBUTES
	 */
	public java.lang.String getAttributes () {
		return attributes;
	}

	/**
	 * Set the value related to the column: ATTRIBUTES
	 * @param attributes the ATTRIBUTES value
	 */
	public void setAttributes (java.lang.String attributes) {
		this.attributes = attributes;
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
	 * Return the value associated with the column: IS_VALID
	 */
	public java.lang.Boolean getIsValid () {
		return isValid;
	}

	/**
	 * Set the value related to the column: IS_VALID
	 * @param isValid the IS_VALID value
	 */
	public void setIsValid (java.lang.Boolean isValid) {
		this.isValid = isValid;
	}


	/**
	 * Return the value associated with the column: PROJECT_GROUP_ID
	 */
	public com.justonetech.biz.domain.BpmProjectGroup getProjectGroup () {
		return projectGroup;
	}

	/**
	 * Set the value related to the column: PROJECT_GROUP_ID
	 * @param projectGroup the PROJECT_GROUP_ID value
	 */
	public void setProjectGroup (com.justonetech.biz.domain.BpmProjectGroup projectGroup) {
		this.projectGroup = projectGroup;
	}


	/**
	 * Return the value associated with the column: TYPE
	 */
	public com.justonetech.system.domain.SysCodeDetail getType () {
		return type;
	}

	/**
	 * Set the value related to the column: TYPE
	 * @param type the TYPE value
	 */
	public void setType (com.justonetech.system.domain.SysCodeDetail type) {
		this.type = type;
	}


	/**
	 * Return the value associated with the column: bpmDutyPersons
	 */
	public java.util.Set<com.justonetech.biz.domain.BpmDutyPerson> getBpmDutyPersons () {
		if(bpmDutyPersons == null){
			bpmDutyPersons = new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmDutyPerson>();
		}
		return bpmDutyPersons;
	}

	/**
	 * Set the value related to the column: bpmDutyPersons
	 * @param bpmDutyPersons the bpmDutyPersons value
	 */
	public void setBpmDutyPersons (java.util.Set<com.justonetech.biz.domain.BpmDutyPerson> bpmDutyPersons) {
		this.bpmDutyPersons = bpmDutyPersons;
	}

	public void addTobpmDutyPersons (com.justonetech.biz.domain.BpmDutyPerson bpmDutyPerson) {
		if (null == getBpmDutyPersons()) setBpmDutyPersons(new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmDutyPerson>());
		getBpmDutyPersons().add(bpmDutyPerson);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.BpmProjectGroupDuty)) return false;
		else {
			com.justonetech.biz.domain.BpmProjectGroupDuty bpmProjectGroupDuty = (com.justonetech.biz.domain.BpmProjectGroupDuty) obj;
			if (null == this.getId() || null == bpmProjectGroupDuty.getId()) return false;
			else return (this.getId().equals(bpmProjectGroupDuty.getId()));
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
		builder.append(code);
		builder.append(name);
		builder.append(attributes);
		builder.append(description);
		builder.append(isValid);
		return builder.toString();
	}


}