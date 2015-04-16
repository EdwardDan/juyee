package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHARE_PRO_SG_PERMIT_DWGC table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 施工许可明细
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 施工许可明细
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : share
 * Projectable : false
 *
 * @hibernate.class
 *  table="SHARE_PRO_SG_PERMIT_DWGC"
 */

public abstract class BaseShareProSgPermitDwgc  implements Serializable {

	public static String REF = "ShareProSgPermitDwgc";
	public static String PROP_DWGC_NAME = "dwgcName";
	public static String PROP_ID = "id";


	// constructors
	public BaseShareProSgPermitDwgc () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShareProSgPermitDwgc (com.justonetech.biz.domain.ShareProSgPermitDwgcPK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private com.justonetech.biz.domain.ShareProSgPermitDwgcPK id;

	// fields
    /*单位工程名称*/
    /*单位工程名称*/
	private java.lang.String dwgcName;
	



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public com.justonetech.biz.domain.ShareProSgPermitDwgcPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 * @deprecated
	 */
	public void setId (com.justonetech.biz.domain.ShareProSgPermitDwgcPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
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
		if (!(obj instanceof com.justonetech.biz.domain.ShareProSgPermitDwgc)) return false;
		else {
			com.justonetech.biz.domain.ShareProSgPermitDwgc shareProSgPermitDwgc = (com.justonetech.biz.domain.ShareProSgPermitDwgc) obj;
			if (null == this.getId() || null == shareProSgPermitDwgc.getId()) return false;
			else return (this.getId().equals(shareProSgPermitDwgc.getId()));
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
		builder.append(dwgcName);
		return builder.toString();
	}


}