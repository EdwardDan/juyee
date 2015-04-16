package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHARE_GD_INFO_LOG table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 工地基本信息日志
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 工地基本信息日志
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : share
 * Projectable : false
 *
 * @hibernate.class
 *  table="SHARE_GD_INFO_LOG"
 */

public abstract class BaseShareGdInfoLog  implements Serializable {

	public static String REF = "ShareGdInfoLog";
	public static String PROP_GD_CODE = "gdCode";
	public static String PROP_UPDATE_STATUS = "updateStatus";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";


	// constructors
	public BaseShareGdInfoLog () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShareGdInfoLog (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*工地编号*/
    /*工地编号*/
	private java.lang.String gdCode;
	
    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updateTime;
	
    /*更新状态*/
    /*更新状态*/
	private java.lang.String updateStatus;
	



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
	 * Return the value associated with the column: GD_CODE
	 */
	public java.lang.String getGdCode () {
		return gdCode;
	}

	/**
	 * Set the value related to the column: GD_CODE
	 * @param gdCode the GD_CODE value
	 */
	public void setGdCode (java.lang.String gdCode) {
		this.gdCode = gdCode;
	}


	/**
	 * Return the value associated with the column: UPDATE_TIME
	 */
	public java.sql.Timestamp getUpdateTime () {
		return updateTime;
	}

	/**
	 * Set the value related to the column: UPDATE_TIME
	 * @param updateTime the UPDATE_TIME value
	 */
	public void setUpdateTime (java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}


	/**
	 * Return the value associated with the column: UPDATE_STATUS
	 */
	public java.lang.String getUpdateStatus () {
		return updateStatus;
	}

	/**
	 * Set the value related to the column: UPDATE_STATUS
	 * @param updateStatus the UPDATE_STATUS value
	 */
	public void setUpdateStatus (java.lang.String updateStatus) {
		this.updateStatus = updateStatus;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ShareGdInfoLog)) return false;
		else {
			com.justonetech.biz.domain.ShareGdInfoLog shareGdInfoLog = (com.justonetech.biz.domain.ShareGdInfoLog) obj;
			if (null == this.getId() || null == shareGdInfoLog.getId()) return false;
			else return (this.getId().equals(shareGdInfoLog.getId()));
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
		builder.append(gdCode);
		builder.append(updateTime);
		builder.append(updateStatus);
		return builder.toString();
	}


}