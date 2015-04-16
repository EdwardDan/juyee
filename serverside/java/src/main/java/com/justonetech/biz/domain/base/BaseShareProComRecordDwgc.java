package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHARE_PRO_COM_RECORD_DWGC table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 竣工备案单位工程明细
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 竣工备案单位工程明细
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : share
 * Projectable : false
 *
 * @hibernate.class
 *  table="SHARE_PRO_COM_RECORD_DWGC"
 */

public abstract class BaseShareProComRecordDwgc  implements Serializable {

	public static String REF = "ShareProComRecordDwgc";
	public static String PROP_COMPLETED_RECORD_ID = "completedRecordId";
	public static String PROP_DWGC_NAME = "dwgcName";
	public static String PROP_BJBH = "bjbh";
	public static String PROP_ID = "id";
	public static String PROP_DWGC_CODE = "dwgcCode";


	// constructors
	public BaseShareProComRecordDwgc () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShareProComRecordDwgc (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*竣工备案标识*/
    /*竣工备案标识*/
	private java.lang.Long completedRecordId;
	
    /*报建编号*/
    /*报建编号*/
	private java.lang.String bjbh;
	
    /*单位工程号*/
    /*单位工程号*/
	private java.lang.String dwgcCode;
	
    /*单位工程名称*/
    /*单位工程名称*/
	private java.lang.String dwgcName;
	



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
	 * Return the value associated with the column: COMPLETED_RECORD_ID
	 */
	public java.lang.Long getCompletedRecordId () {
		return completedRecordId;
	}

	/**
	 * Set the value related to the column: COMPLETED_RECORD_ID
	 * @param completedRecordId the COMPLETED_RECORD_ID value
	 */
	public void setCompletedRecordId (java.lang.Long completedRecordId) {
		this.completedRecordId = completedRecordId;
	}


	/**
	 * Return the value associated with the column: BJBH
	 */
	public java.lang.String getBjbh () {
		return bjbh;
	}

	/**
	 * Set the value related to the column: BJBH
	 * @param bjbh the BJBH value
	 */
	public void setBjbh (java.lang.String bjbh) {
		this.bjbh = bjbh;
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



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ShareProComRecordDwgc)) return false;
		else {
			com.justonetech.biz.domain.ShareProComRecordDwgc shareProComRecordDwgc = (com.justonetech.biz.domain.ShareProComRecordDwgc) obj;
			if (null == this.getId() || null == shareProComRecordDwgc.getId()) return false;
			else return (this.getId().equals(shareProComRecordDwgc.getId()));
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
		builder.append(completedRecordId);
		builder.append(bjbh);
		builder.append(dwgcCode);
		builder.append(dwgcName);
		return builder.toString();
	}


}