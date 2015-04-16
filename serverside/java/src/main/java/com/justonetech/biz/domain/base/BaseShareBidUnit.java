package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHARE_BID_UNIT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 承发包中标单位
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 承发包中标单位
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : share
 * Projectable : false
 *
 * @hibernate.class
 *  table="SHARE_BID_UNIT"
 */

public abstract class BaseShareBidUnit  implements Serializable {

	public static String REF = "ShareBidUnit";
	public static String PROP_MAIN_JL_CERTIFICATE = "mainJlCertificate";
	public static String PROP_MAIN_JL_NAME = "mainJlName";
	public static String PROP_MANAGER_CARD = "managerCard";
	public static String PROP_BID_UNIT = "bidUnit";
	public static String PROP_MANAGER_NAME = "managerName";
	public static String PROP_ID = "id";


	// constructors
	public BaseShareBidUnit () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShareBidUnit (com.justonetech.biz.domain.ShareBidUnitPK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private com.justonetech.biz.domain.ShareBidUnitPK id;

	// fields
    /*中标单位*/
    /*中标单位*/
	private java.lang.String bidUnit;
	
    /*项目经理姓名*/
    /*项目经理姓名*/
	private java.lang.String managerName;
	
    /*项目经理身份证号*/
    /*项目经理身份证号*/
	private java.lang.String managerCard;
	
    /*项目总监姓名*/
    /*项目总监姓名*/
	private java.lang.String mainJlName;
	
    /*项目总监证书号*/
    /*项目总监证书号*/
	private java.lang.String mainJlCertificate;
	



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public com.justonetech.biz.domain.ShareBidUnitPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 * @deprecated
	 */
	public void setId (com.justonetech.biz.domain.ShareBidUnitPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: BID_UNIT
	 */
	public java.lang.String getBidUnit () {
		return bidUnit;
	}

	/**
	 * Set the value related to the column: BID_UNIT
	 * @param bidUnit the BID_UNIT value
	 */
	public void setBidUnit (java.lang.String bidUnit) {
		this.bidUnit = bidUnit;
	}


	/**
	 * Return the value associated with the column: MANAGER_NAME
	 */
	public java.lang.String getManagerName () {
		return managerName;
	}

	/**
	 * Set the value related to the column: MANAGER_NAME
	 * @param managerName the MANAGER_NAME value
	 */
	public void setManagerName (java.lang.String managerName) {
		this.managerName = managerName;
	}


	/**
	 * Return the value associated with the column: MANAGER_CARD
	 */
	public java.lang.String getManagerCard () {
		return managerCard;
	}

	/**
	 * Set the value related to the column: MANAGER_CARD
	 * @param managerCard the MANAGER_CARD value
	 */
	public void setManagerCard (java.lang.String managerCard) {
		this.managerCard = managerCard;
	}


	/**
	 * Return the value associated with the column: MAIN_JL_NAME
	 */
	public java.lang.String getMainJlName () {
		return mainJlName;
	}

	/**
	 * Set the value related to the column: MAIN_JL_NAME
	 * @param mainJlName the MAIN_JL_NAME value
	 */
	public void setMainJlName (java.lang.String mainJlName) {
		this.mainJlName = mainJlName;
	}


	/**
	 * Return the value associated with the column: MAIN_JL_CERTIFICATE
	 */
	public java.lang.String getMainJlCertificate () {
		return mainJlCertificate;
	}

	/**
	 * Set the value related to the column: MAIN_JL_CERTIFICATE
	 * @param mainJlCertificate the MAIN_JL_CERTIFICATE value
	 */
	public void setMainJlCertificate (java.lang.String mainJlCertificate) {
		this.mainJlCertificate = mainJlCertificate;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ShareBidUnit)) return false;
		else {
			com.justonetech.biz.domain.ShareBidUnit shareBidUnit = (com.justonetech.biz.domain.ShareBidUnit) obj;
			if (null == this.getId() || null == shareBidUnit.getId()) return false;
			else return (this.getId().equals(shareBidUnit.getId()));
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
		builder.append(bidUnit);
		builder.append(managerName);
		builder.append(managerCard);
		builder.append(mainJlName);
		builder.append(mainJlCertificate);
		return builder.toString();
	}


}