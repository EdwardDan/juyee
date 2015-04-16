package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the JD_RECORD_PERSON table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 安全质量监督--监督人员
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 安全质量监督--监督人员
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : jd
 * Projectable : false
 *
 * @hibernate.class
 *  table="JD_RECORD_PERSON"
 */

public abstract class BaseJdRecordPerson  implements Serializable {

	public static String REF = "JdRecordPerson";
	public static String PROP_JD_PERSON = "jdPerson";
	public static String PROP_JD_TYPE_CODE = "jdTypeCode";
	public static String PROP_RECORD_ID = "recordId";
	public static String PROP_ID = "id";
	public static String PROP_JD_PERSON_DESC = "jdPersonDesc";


	// constructors
	public BaseJdRecordPerson () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseJdRecordPerson (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*监督id(首次/安全/质量/竣工)*/
    /*监督id(首次/安全/质量/竣工)*/
	private java.lang.Long recordId;
	
    /*监督类别编码*/
    /*监督类别编码*/
	private java.lang.String jdTypeCode;
	
    /*监督员描述*/
    /*监督员描述*/
	private java.lang.String jdPersonDesc;
	

	// many to one
	private com.justonetech.system.domain.SysPerson jdPerson;



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
	 * Return the value associated with the column: RECORD_ID
	 */
	public java.lang.Long getRecordId () {
		return recordId;
	}

	/**
	 * Set the value related to the column: RECORD_ID
	 * @param recordId the RECORD_ID value
	 */
	public void setRecordId (java.lang.Long recordId) {
		this.recordId = recordId;
	}


	/**
	 * Return the value associated with the column: JD_TYPE_CODE
	 */
	public java.lang.String getJdTypeCode () {
		return jdTypeCode;
	}

	/**
	 * Set the value related to the column: JD_TYPE_CODE
	 * @param jdTypeCode the JD_TYPE_CODE value
	 */
	public void setJdTypeCode (java.lang.String jdTypeCode) {
		this.jdTypeCode = jdTypeCode;
	}


	/**
	 * Return the value associated with the column: JD_PERSON_DESC
	 */
	public java.lang.String getJdPersonDesc () {
		return jdPersonDesc;
	}

	/**
	 * Set the value related to the column: JD_PERSON_DESC
	 * @param jdPersonDesc the JD_PERSON_DESC value
	 */
	public void setJdPersonDesc (java.lang.String jdPersonDesc) {
		this.jdPersonDesc = jdPersonDesc;
	}


	/**
	 * Return the value associated with the column: JD_PERSON_ID
	 */
	public com.justonetech.system.domain.SysPerson getJdPerson () {
		return jdPerson;
	}

	/**
	 * Set the value related to the column: JD_PERSON_ID
	 * @param jdPerson the JD_PERSON_ID value
	 */
	public void setJdPerson (com.justonetech.system.domain.SysPerson jdPerson) {
		this.jdPerson = jdPerson;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.JdRecordPerson)) return false;
		else {
			com.justonetech.biz.domain.JdRecordPerson jdRecordPerson = (com.justonetech.biz.domain.JdRecordPerson) obj;
			if (null == this.getId() || null == jdRecordPerson.getId()) return false;
			else return (this.getId().equals(jdRecordPerson.getId()));
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
		builder.append(recordId);
		builder.append(jdTypeCode);
		builder.append(jdPersonDesc);
		return builder.toString();
	}


}