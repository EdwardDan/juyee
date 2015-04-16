package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the JD_RECORD_COMPLETE_DWGC table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 安全质量监督--竣工验收--单位工程
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 安全质量监督--竣工验收--单位工程
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : jd
 * Projectable : false
 *
 * @hibernate.class
 *  table="JD_RECORD_COMPLETE_DWGC"
 */

public abstract class BaseJdRecordCompleteDwgc  implements Serializable {

	public static String REF = "JdRecordCompleteDwgc";
	public static String PROP_DWGC_NAME = "dwgcName";
	public static String PROP_ID = "id";
	public static String PROP_RECORD_COMPLETE = "recordComplete";
	public static String PROP_DWGC_CODE = "dwgcCode";


	// constructors
	public BaseJdRecordCompleteDwgc () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseJdRecordCompleteDwgc (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*单位工程号*/
    /*单位工程号*/
	private java.lang.String dwgcCode;
	
    /*单位名称名称*/
    /*单位名称名称*/
	private java.lang.String dwgcName;
	

	// many to one
	private com.justonetech.biz.domain.JdRecordComplete recordComplete;



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
	 * Return the value associated with the column: DWGC_CODE
	 */
	public java.lang.String getDwgcCode () {
		return dwgcCode;
	}

	/**
	 * Set the value related to the column: DWGC_CODE
	 * @param dwgcCode the DWGC_CODE value
	 */
	public void setDwgcCode (java.lang.String dwgcCode) {
		this.dwgcCode = dwgcCode;
	}


	/**
	 * Return the value associated with the column: DWGC_NAME
	 */
	public java.lang.String getDwgcName () {
		return dwgcName;
	}

	/**
	 * Set the value related to the column: DWGC_NAME
	 * @param dwgcName the DWGC_NAME value
	 */
	public void setDwgcName (java.lang.String dwgcName) {
		this.dwgcName = dwgcName;
	}


	/**
	 * Return the value associated with the column: RECORD_COMPLETE_ID
	 */
	public com.justonetech.biz.domain.JdRecordComplete getRecordComplete () {
		return recordComplete;
	}

	/**
	 * Set the value related to the column: RECORD_COMPLETE_ID
	 * @param recordComplete the RECORD_COMPLETE_ID value
	 */
	public void setRecordComplete (com.justonetech.biz.domain.JdRecordComplete recordComplete) {
		this.recordComplete = recordComplete;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.JdRecordCompleteDwgc)) return false;
		else {
			com.justonetech.biz.domain.JdRecordCompleteDwgc jdRecordCompleteDwgc = (com.justonetech.biz.domain.JdRecordCompleteDwgc) obj;
			if (null == this.getId() || null == jdRecordCompleteDwgc.getId()) return false;
			else return (this.getId().equals(jdRecordCompleteDwgc.getId()));
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
		builder.append(dwgcCode);
		builder.append(dwgcName);
		return builder.toString();
	}


}