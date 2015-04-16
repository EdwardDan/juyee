package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHARE_PRO_SG_PERMIT_LOG table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目施工许可日志
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 项目施工许可日志
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : share
 * Projectable : false
 *
 * @hibernate.class
 *  table="SHARE_PRO_SG_PERMIT_LOG"
 */

public abstract class BaseShareProSgPermitLog  implements Serializable {

	public static String REF = "ShareProSgPermitLog";
	public static String PROP_BJBH = "bjbh";
	public static String PROP_UPDATE_STATUS = "updateStatus";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_BDH = "bdh";


	// constructors
	public BaseShareProSgPermitLog () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShareProSgPermitLog (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*报建编号*/
    /*报建编号*/
	private java.lang.String bjbh;
	
    /*标段号*/
    /*标段号*/
	private java.lang.String bdh;
	
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
	 * Return the value associated with the column: BDH
	 */
	public java.lang.String getBdh () {
		return bdh;
	}

	/**
	 * Set the value related to the column: BDH
	 * @param bdh the BDH value
	 */
	public void setBdh (java.lang.String bdh) {
		this.bdh = bdh;
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
		if (!(obj instanceof com.justonetech.biz.domain.ShareProSgPermitLog)) return false;
		else {
			com.justonetech.biz.domain.ShareProSgPermitLog shareProSgPermitLog = (com.justonetech.biz.domain.ShareProSgPermitLog) obj;
			if (null == this.getId() || null == shareProSgPermitLog.getId()) return false;
			else return (this.getId().equals(shareProSgPermitLog.getId()));
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
		builder.append(bjbh);
		builder.append(bdh);
		builder.append(updateTime);
		builder.append(updateStatus);
		return builder.toString();
	}


}