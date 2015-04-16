package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHARE_PRO_CONTRACT_LOG table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 合同备案日志
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 合同备案日志
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : share
 * Projectable : false
 *
 * @hibernate.class
 *  table="SHARE_PRO_CONTRACT_LOG"
 */

public abstract class BaseShareProContractLog  implements Serializable {

	public static String REF = "ShareProContractLog";
	public static String PROP_CONT_TYPE = "contType";
	public static String PROP_UPDATE_STATUS = "updateStatus";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_CONT_ID = "contId";
	public static String PROP_NET_CODE = "netCode";


	// constructors
	public BaseShareProContractLog () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShareProContractLog (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*合同备案申请号*/
    /*合同备案申请号*/
	private java.lang.String netCode;
	
    /*合同类别*/
    /*合同类别*/
	private java.lang.String contType;
	
    /*合同表ID*/
    /*合同表ID*/
	private java.lang.Long contId;
	
    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updateTime;
	
    /*更新状态 0更新，1 删除*/
    /*更新状态 0更新，1 删除*/
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
	 * Return the value associated with the column: NET_CODE
	 */
	public java.lang.String getNetCode () {
		return netCode;
	}

	/**
	 * Set the value related to the column: NET_CODE
	 * @param netCode the NET_CODE value
	 */
	public void setNetCode (java.lang.String netCode) {
		this.netCode = netCode;
	}


	/**
	 * Return the value associated with the column: CONT_TYPE
	 */
	public java.lang.String getContType () {
		return contType;
	}

	/**
	 * Set the value related to the column: CONT_TYPE
	 * @param contType the CONT_TYPE value
	 */
	public void setContType (java.lang.String contType) {
		this.contType = contType;
	}


	/**
	 * Return the value associated with the column: CONT_ID
	 */
	public java.lang.Long getContId () {
		return contId;
	}

	/**
	 * Set the value related to the column: CONT_ID
	 * @param contId the CONT_ID value
	 */
	public void setContId (java.lang.Long contId) {
		this.contId = contId;
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
		if (!(obj instanceof com.justonetech.biz.domain.ShareProContractLog)) return false;
		else {
			com.justonetech.biz.domain.ShareProContractLog shareProContractLog = (com.justonetech.biz.domain.ShareProContractLog) obj;
			if (null == this.getId() || null == shareProContractLog.getId()) return false;
			else return (this.getId().equals(shareProContractLog.getId()));
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
		builder.append(netCode);
		builder.append(contType);
		builder.append(contId);
		builder.append(updateTime);
		builder.append(updateStatus);
		return builder.toString();
	}


}