package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHARE_PRO_COMPLETED_RECORD_LOG table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 竣工备案日志
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 竣工备案日志
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : share
 * Projectable : false
 *
 * @hibernate.class
 *  table="SHARE_PRO_COMPLETED_RECORD_LOG"
 */

public abstract class BaseShareProCompletedRecordLog  implements Serializable {

	public static String REF = "ShareProCompletedRecordLog";
	public static String PROP_BJBH = "bjbh";
	public static String PROP_UPDATE_STATUS = "updateStatus";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_COM_RECORD_ID = "comRecordId";


	// constructors
	public BaseShareProCompletedRecordLog () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShareProCompletedRecordLog (java.lang.Long id) {
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
	private java.lang.Long comRecordId;
	
    /*报建编号*/
    /*报建编号*/
	private java.lang.String bjbh;
	
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
	 * Return the value associated with the column: COM_RECORD_ID
	 */
	public java.lang.Long getComRecordId () {
		return comRecordId;
	}

	/**
	 * Set the value related to the column: COM_RECORD_ID
	 * @param comRecordId the COM_RECORD_ID value
	 */
	public void setComRecordId (java.lang.Long comRecordId) {
		this.comRecordId = comRecordId;
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
		if (!(obj instanceof com.justonetech.biz.domain.ShareProCompletedRecordLog)) return false;
		else {
			com.justonetech.biz.domain.ShareProCompletedRecordLog shareProCompletedRecordLog = (com.justonetech.biz.domain.ShareProCompletedRecordLog) obj;
			if (null == this.getId() || null == shareProCompletedRecordLog.getId()) return false;
			else return (this.getId().equals(shareProCompletedRecordLog.getId()));
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
		builder.append(comRecordId);
		builder.append(bjbh);
		builder.append(updateTime);
		builder.append(updateStatus);
		return builder.toString();
	}


}