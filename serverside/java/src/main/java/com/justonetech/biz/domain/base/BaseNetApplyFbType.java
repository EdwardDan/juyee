package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the NET_APPLY_FB_TYPE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目报建_发包类型
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 项目报建_发包类型
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : net
 * Projectable : false
 *
 * @hibernate.class
 *  table="NET_APPLY_FB_TYPE"
 */

public abstract class BaseNetApplyFbType  implements Serializable {

	public static String REF = "NetApplyFbType";
	public static String PROP_FB_TYPE_DESC = "fbTypeDesc";
	public static String PROP_FB_TYPE_ID = "fbTypeId";
	public static String PROP_ID = "id";
	public static String PROP_APPLY = "apply";
	public static String PROP_IS_BID = "isBid";


	// constructors
	public BaseNetApplyFbType () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseNetApplyFbType (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*发包类型中文描述*/
    /*发包类型中文描述*/
	private String fbTypeDesc;
	
    /*是否招标*/
    /*是否招标*/
	private Boolean isBid;
	

	// many to one
	private com.justonetech.biz.domain.NetApply apply;
	private com.justonetech.system.domain.SysCodeDetail fbTypeId;



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
	 * Return the value associated with the column: FB_TYPE_DESC
	 */
	public String getFbTypeDesc () {
		return fbTypeDesc;
	}

	/**
	 * Set the value related to the column: FB_TYPE_DESC
	 * @param fbTypeDesc the FB_TYPE_DESC value
	 */
	public void setFbTypeDesc (String fbTypeDesc) {
		this.fbTypeDesc = fbTypeDesc;
	}


	/**
	 * Return the value associated with the column: IS_BID
	 */
	public Boolean getIsBid () {
		return isBid;
	}

	/**
	 * Set the value related to the column: IS_BID
	 * @param isBid the IS_BID value
	 */
	public void setIsBid (Boolean isBid) {
		this.isBid = isBid;
	}


	/**
	 * Return the value associated with the column: APPLY_ID
	 */
	public com.justonetech.biz.domain.NetApply getApply () {
		return apply;
	}

	/**
	 * Set the value related to the column: APPLY_ID
	 * @param apply the APPLY_ID value
	 */
	public void setApply (com.justonetech.biz.domain.NetApply apply) {
		this.apply = apply;
	}


	/**
	 * Return the value associated with the column: FB_TYPE_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getFbTypeId () {
		return fbTypeId;
	}

	/**
	 * Set the value related to the column: FB_TYPE_ID
	 * @param fbTypeId the FB_TYPE_ID value
	 */
	public void setFbTypeId (com.justonetech.system.domain.SysCodeDetail fbTypeId) {
		this.fbTypeId = fbTypeId;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.NetApplyFbType)) return false;
		else {
			com.justonetech.biz.domain.NetApplyFbType netApplyFbType = (com.justonetech.biz.domain.NetApplyFbType) obj;
			if (null == this.getId() || null == netApplyFbType.getId()) return false;
			else return (this.getId().equals(netApplyFbType.getId()));
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
		builder.append(fbTypeDesc);
		builder.append(isBid);
		return builder.toString();
	}


}