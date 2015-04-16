package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHARE_PRO_DWGC_MONITOR_LOG table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目报监单位工程信息日志
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 项目报监单位工程信息日志
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : share
 * Projectable : false
 *
 * @hibernate.class
 *  table="SHARE_PRO_DWGC_MONITOR_LOG"
 */

public abstract class BaseShareProDwgcMonitorLog  implements Serializable {

	public static String REF = "ShareProDwgcMonitorLog";
	public static String PROP_BJBH = "bjbh";
	public static String PROP_FBID = "fbid";
	public static String PROP_UPDATE_STATUS = "updateStatus";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_DWGC_MONITOR_ID = "dwgcMonitorId";


	// constructors
	public BaseShareProDwgcMonitorLog () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShareProDwgcMonitorLog (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*报监单位工程标识*/
    /*报监单位工程标识*/
	private java.lang.Long dwgcMonitorId;
	
    /*报建编号*/
    /*报建编号*/
	private java.lang.String bjbh;
	
    /*报监附表id*/
    /*报监附表id*/
	private java.lang.String fbid;
	
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
	 * Return the value associated with the column: DWGC_MONITOR_ID
	 */
	public java.lang.Long getDwgcMonitorId () {
		return dwgcMonitorId;
	}

	/**
	 * Set the value related to the column: DWGC_MONITOR_ID
	 * @param dwgcMonitorId the DWGC_MONITOR_ID value
	 */
	public void setDwgcMonitorId (java.lang.Long dwgcMonitorId) {
		this.dwgcMonitorId = dwgcMonitorId;
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
	 * Return the value associated with the column: FBID
	 */
	public java.lang.String getFbid () {
		return fbid;
	}

	/**
	 * Set the value related to the column: FBID
	 * @param fbid the FBID value
	 */
	public void setFbid (java.lang.String fbid) {
		this.fbid = fbid;
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
		if (!(obj instanceof com.justonetech.biz.domain.ShareProDwgcMonitorLog)) return false;
		else {
			com.justonetech.biz.domain.ShareProDwgcMonitorLog shareProDwgcMonitorLog = (com.justonetech.biz.domain.ShareProDwgcMonitorLog) obj;
			if (null == this.getId() || null == shareProDwgcMonitorLog.getId()) return false;
			else return (this.getId().equals(shareProDwgcMonitorLog.getId()));
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
		builder.append(dwgcMonitorId);
		builder.append(bjbh);
		builder.append(fbid);
		builder.append(updateTime);
		builder.append(updateStatus);
		return builder.toString();
	}


}