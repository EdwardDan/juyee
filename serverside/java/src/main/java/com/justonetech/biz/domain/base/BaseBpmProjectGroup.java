package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BPM_PROJECT_GROUP table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目组
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 项目组
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : workflow
 * Projectable : false
 *
 * @hibernate.class
 *  table="BPM_PROJECT_GROUP"
 */

public abstract class BaseBpmProjectGroup  implements Serializable {

	public static String REF = "BpmProjectGroup";
	public static String PROP_NAME = "name";
	public static String PROP_ATTRIBUTES = "attributes";
	public static String PROP_TYPE = "type";
	public static String PROP_IS_VALID = "isValid";
	public static String PROP_ID = "id";
	public static String PROP_STAMPER = "stamper";
	public static String PROP_CODE = "code";


	// constructors
	public BaseBpmProjectGroup () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBpmProjectGroup (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBpmProjectGroup (
		java.lang.Long id,
		java.lang.String name) {

		this.setId(id);
		this.setName(name);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*项目组编码*/
    /*项目组编码*/
	private java.lang.String code;
	
    /*项目组名称*/
    /*项目组名称*/
	private java.lang.String name;
	
    /*印章名称*/
    /*印章名称*/
	private java.lang.String stamper;
	
    /*扩展属性*/
    /*扩展属性*/
	private java.lang.String attributes;
	
    /*是否有效*/
    /*是否有效*/
	private java.lang.Boolean isValid;
	

	// many to one
	private com.justonetech.system.domain.SysCodeDetail type;

	// collections
	private java.util.Set<com.justonetech.biz.domain.BpmProjectGroupDuty> bpmProjectGroupDuties;



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
	 * Return the value associated with the column: STAMPER
	 */
	public java.lang.String getStamper () {
		return stamper;
	}

	/**
	 * Set the value related to the column: STAMPER
	 * @param stamper the STAMPER value
	 */
	public void setStamper (java.lang.String stamper) {
		this.stamper = stamper;
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
	 * Return the value associated with the column: bpmProjectGroupDuties
	 */
	public java.util.Set<com.justonetech.biz.domain.BpmProjectGroupDuty> getBpmProjectGroupDuties () {
		if(bpmProjectGroupDuties == null){
			bpmProjectGroupDuties = new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmProjectGroupDuty>();
		}
		return bpmProjectGroupDuties;
	}

	/**
	 * Set the value related to the column: bpmProjectGroupDuties
	 * @param bpmProjectGroupDuties the bpmProjectGroupDuties value
	 */
	public void setBpmProjectGroupDuties (java.util.Set<com.justonetech.biz.domain.BpmProjectGroupDuty> bpmProjectGroupDuties) {
		this.bpmProjectGroupDuties = bpmProjectGroupDuties;
	}

	public void addTobpmProjectGroupDuties (com.justonetech.biz.domain.BpmProjectGroupDuty bpmProjectGroupDuty) {
		if (null == getBpmProjectGroupDuties()) setBpmProjectGroupDuties(new java.util.LinkedHashSet<com.justonetech.biz.domain.BpmProjectGroupDuty>());
		getBpmProjectGroupDuties().add(bpmProjectGroupDuty);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.BpmProjectGroup)) return false;
		else {
			com.justonetech.biz.domain.BpmProjectGroup bpmProjectGroup = (com.justonetech.biz.domain.BpmProjectGroup) obj;
			if (null == this.getId() || null == bpmProjectGroup.getId()) return false;
			else return (this.getId().equals(bpmProjectGroup.getId()));
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
		builder.append(stamper);
		builder.append(attributes);
		builder.append(isValid);
		return builder.toString();
	}


}