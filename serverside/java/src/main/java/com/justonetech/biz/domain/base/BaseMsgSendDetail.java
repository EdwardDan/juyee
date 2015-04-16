package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MSG_SEND_DETAIL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 系统消息通知发送明细
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 系统消息通知发送明细
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : sms
 * Projectable : false
 *
 * @hibernate.class
 *  table="MSG_SEND_DETAIL"
 */

public abstract class BaseMsgSendDetail  implements Serializable {

	public static String REF = "MsgSendDetail";
	public static String PROP_SYS_PERSON_ID = "sysPersonId";
	public static String PROP_GD_PERSON_ID = "gdPersonId";
	public static String PROP_ID = "id";
	public static String PROP_SEND_SMS_TIME = "sendSmsTime";
	public static String PROP_RECEIVE_MOBILE = "receiveMobile";
	public static String PROP_SMS_MESSAGE = "smsMessage";
	public static String PROP_READ_TIME = "readTime";
	public static String PROP_RECEIVE_NAME = "receiveName";


	// constructors
	public BaseMsgSendDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMsgSendDetail (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*接收人姓名*/
    /*接收人姓名*/
	private String receiveName;
	
    /*系统人员ID*/
    /*系统人员ID*/
	private Long sysPersonId;
	
    /*工地人员ID*/
    /*工地人员ID*/
	private Long gdPersonId;
	
    /*接收手机号码*/
    /*接收手机号码*/
	private String receiveMobile;
	
    /*发送短信时间*/
    /*发送短信时间*/
	private java.sql.Timestamp sendSmsTime;
	
    /*阅读时间*/
    /*阅读时间*/
	private java.sql.Timestamp readTime;
	

	// many to one
	private com.justonetech.biz.domain.MsgMessage smsMessage;



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
	 * Return the value associated with the column: RECEIVE_NAME
	 */
	public String getReceiveName () {
		return receiveName;
	}

	/**
	 * Set the value related to the column: RECEIVE_NAME
	 * @param receiveName the RECEIVE_NAME value
	 */
	public void setReceiveName (String receiveName) {
		this.receiveName = receiveName;
	}


	/**
	 * Return the value associated with the column: SYS_PERSON_ID
	 */
	public Long getSysPersonId () {
		return sysPersonId;
	}

	/**
	 * Set the value related to the column: SYS_PERSON_ID
	 * @param sysPersonId the SYS_PERSON_ID value
	 */
	public void setSysPersonId (Long sysPersonId) {
		this.sysPersonId = sysPersonId;
	}


	/**
	 * Return the value associated with the column: GD_PERSON_ID
	 */
	public Long getGdPersonId () {
		return gdPersonId;
	}

	/**
	 * Set the value related to the column: GD_PERSON_ID
	 * @param gdPersonId the GD_PERSON_ID value
	 */
	public void setGdPersonId (Long gdPersonId) {
		this.gdPersonId = gdPersonId;
	}


	/**
	 * Return the value associated with the column: RECEIVE_MOBILE
	 */
	public String getReceiveMobile () {
		return receiveMobile;
	}

	/**
	 * Set the value related to the column: RECEIVE_MOBILE
	 * @param receiveMobile the RECEIVE_MOBILE value
	 */
	public void setReceiveMobile (String receiveMobile) {
		this.receiveMobile = receiveMobile;
	}


	/**
	 * Return the value associated with the column: SEND_SMS_TIME
	 */
	public java.sql.Timestamp getSendSmsTime () {
		return sendSmsTime;
	}

	/**
	 * Set the value related to the column: SEND_SMS_TIME
	 * @param sendSmsTime the SEND_SMS_TIME value
	 */
	public void setSendSmsTime (java.sql.Timestamp sendSmsTime) {
		this.sendSmsTime = sendSmsTime;
	}


	/**
	 * Return the value associated with the column: READ_TIME
	 */
	public java.sql.Timestamp getReadTime () {
		return readTime;
	}

	/**
	 * Set the value related to the column: READ_TIME
	 * @param readTime the READ_TIME value
	 */
	public void setReadTime (java.sql.Timestamp readTime) {
		this.readTime = readTime;
	}


	/**
	 * Return the value associated with the column: SMS_MESSAGE_ID
	 */
	public com.justonetech.biz.domain.MsgMessage getSmsMessage () {
		return smsMessage;
	}

	/**
	 * Set the value related to the column: SMS_MESSAGE_ID
	 * @param smsMessage the SMS_MESSAGE_ID value
	 */
	public void setSmsMessage (com.justonetech.biz.domain.MsgMessage smsMessage) {
		this.smsMessage = smsMessage;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.MsgSendDetail)) return false;
		else {
			com.justonetech.biz.domain.MsgSendDetail msgSendDetail = (com.justonetech.biz.domain.MsgSendDetail) obj;
			if (null == this.getId() || null == msgSendDetail.getId()) return false;
			else return (this.getId().equals(msgSendDetail.getId()));
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
		builder.append(receiveName);
		builder.append(sysPersonId);
		builder.append(gdPersonId);
		builder.append(receiveMobile);
		builder.append(sendSmsTime);
		builder.append(readTime);
		return builder.toString();
	}


}