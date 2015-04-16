package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MSG_MESSAGE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 系统消息通知
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 系统消息通知
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : sms
 * Projectable : false
 *
 * @hibernate.class
 *  table="MSG_MESSAGE"
 */

public abstract class BaseMsgMessage  implements Serializable,Auditable {

	public static String REF = "MsgMessage";
	public static String PROP_IS_SEND_SMS = "isSendSms";
	public static String PROP_SEND_TIME = "sendTime";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_MOBILES = "mobiles";
	public static String PROP_SENDER = "sender";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_GD_PERSON_IDS = "gdPersonIds";
	public static String PROP_GD_PERSON_NAMES = "gdPersonNames";
	public static String PROP_IS_SEND = "isSend";
	public static String PROP_INNER_PERSON_IDS = "innerPersonIds";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_INNER_PERSON_NAMES = "innerPersonNames";
	public static String PROP_ID = "id";
	public static String PROP_CONTENT = "content";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseMsgMessage () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMsgMessage (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*消息内容*/
    /*消息内容*/
	private String content;
	
    /*发送人姓名*/
    /*发送人姓名*/
	private String sender;
	
    /*内部接收人IDS*/
    /*内部接收人ID*/
	private String innerPersonIds;
	
    /*内部接收人姓名*/
    /*内部接收人姓名*/
	private String innerPersonNames;
	
    /*工地接收人IDS*/
    /*工地接收人IDS*/
	private String gdPersonIds;
	
    /*工地接收人姓名*/
    /*工地接收人姓名*/
	private String gdPersonNames;
	
    /*手机号码*/
    /*手机号码*/
	private String mobiles;
	
    /*是否已发送*/
    /*是否已发送*/
	private Boolean isSend;
	
    /*发送时间*/
    /*发送时间*/
	private java.sql.Timestamp sendTime;
	
    /*是否发送短信*/
    /*是否发送短信*/
	private Boolean isSendSms;
	
    /*创建时间*/
    /*创建时间*/
	private java.sql.Timestamp createTime;
	
    /*创建用户名*/
    /*创建用户名*/
	private String createUser;
	
    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updateTime;
	
    /*更新用户名*/
    /*更新用户名*/
	private String updateUser;
	

	// collections
	private java.util.Set<com.justonetech.biz.domain.MsgSendDetail> msgSendDetails;



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
	 * Return the value associated with the column: CONTENT
	 */
	public String getContent () {
		return content;
	}

	/**
	 * Set the value related to the column: CONTENT
	 * @param content the CONTENT value
	 */
	public void setContent (String content) {
		this.content = content;
	}


	/**
	 * Return the value associated with the column: SENDER
	 */
	public String getSender () {
		return sender;
	}

	/**
	 * Set the value related to the column: SENDER
	 * @param sender the SENDER value
	 */
	public void setSender (String sender) {
		this.sender = sender;
	}


	/**
	 * Return the value associated with the column: INNER_PERSON_IDS
	 */
	public String getInnerPersonIds () {
		return innerPersonIds;
	}

	/**
	 * Set the value related to the column: INNER_PERSON_IDS
	 * @param innerPersonIds the INNER_PERSON_IDS value
	 */
	public void setInnerPersonIds (String innerPersonIds) {
		this.innerPersonIds = innerPersonIds;
	}


	/**
	 * Return the value associated with the column: INNER_PERSON_NAMES
	 */
	public String getInnerPersonNames () {
		return innerPersonNames;
	}

	/**
	 * Set the value related to the column: INNER_PERSON_NAMES
	 * @param innerPersonNames the INNER_PERSON_NAMES value
	 */
	public void setInnerPersonNames (String innerPersonNames) {
		this.innerPersonNames = innerPersonNames;
	}


	/**
	 * Return the value associated with the column: GD_PERSON_IDS
	 */
	public String getGdPersonIds () {
		return gdPersonIds;
	}

	/**
	 * Set the value related to the column: GD_PERSON_IDS
	 * @param gdPersonIds the GD_PERSON_IDS value
	 */
	public void setGdPersonIds (String gdPersonIds) {
		this.gdPersonIds = gdPersonIds;
	}


	/**
	 * Return the value associated with the column: GD_PERSON_NAMES
	 */
	public String getGdPersonNames () {
		return gdPersonNames;
	}

	/**
	 * Set the value related to the column: GD_PERSON_NAMES
	 * @param gdPersonNames the GD_PERSON_NAMES value
	 */
	public void setGdPersonNames (String gdPersonNames) {
		this.gdPersonNames = gdPersonNames;
	}


	/**
	 * Return the value associated with the column: MOBILES
	 */
	public String getMobiles () {
		return mobiles;
	}

	/**
	 * Set the value related to the column: MOBILES
	 * @param mobiles the MOBILES value
	 */
	public void setMobiles (String mobiles) {
		this.mobiles = mobiles;
	}


	/**
	 * Return the value associated with the column: IS_SEND
	 */
	public Boolean getIsSend () {
		return isSend;
	}

	/**
	 * Set the value related to the column: IS_SEND
	 * @param isSend the IS_SEND value
	 */
	public void setIsSend (Boolean isSend) {
		this.isSend = isSend;
	}


	/**
	 * Return the value associated with the column: SEND_TIME
	 */
	public java.sql.Timestamp getSendTime () {
		return sendTime;
	}

	/**
	 * Set the value related to the column: SEND_TIME
	 * @param sendTime the SEND_TIME value
	 */
	public void setSendTime (java.sql.Timestamp sendTime) {
		this.sendTime = sendTime;
	}


	/**
	 * Return the value associated with the column: IS_SEND_SMS
	 */
	public Boolean getIsSendSms () {
		return isSendSms;
	}

	/**
	 * Set the value related to the column: IS_SEND_SMS
	 * @param isSendSms the IS_SEND_SMS value
	 */
	public void setIsSendSms (Boolean isSendSms) {
		this.isSendSms = isSendSms;
	}


	/**
	 * Return the value associated with the column: CREATE_TIME
	 */
	public java.sql.Timestamp getCreateTime () {
		return createTime;
	}

	/**
	 * Set the value related to the column: CREATE_TIME
	 * @param createTime the CREATE_TIME value
	 */
	public void setCreateTime (java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}


	/**
	 * Return the value associated with the column: CREATE_USER
	 */
	public String getCreateUser () {
		return createUser;
	}

	/**
	 * Set the value related to the column: CREATE_USER
	 * @param createUser the CREATE_USER value
	 */
	public void setCreateUser (String createUser) {
		this.createUser = createUser;
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
	 * Return the value associated with the column: UPDATE_USER
	 */
	public String getUpdateUser () {
		return updateUser;
	}

	/**
	 * Set the value related to the column: UPDATE_USER
	 * @param updateUser the UPDATE_USER value
	 */
	public void setUpdateUser (String updateUser) {
		this.updateUser = updateUser;
	}


	/**
	 * Return the value associated with the column: msgSendDetails
	 */
	public java.util.Set<com.justonetech.biz.domain.MsgSendDetail> getMsgSendDetails () {
		if(msgSendDetails == null){
			msgSendDetails = new java.util.LinkedHashSet<com.justonetech.biz.domain.MsgSendDetail>();
		}
		return msgSendDetails;
	}

	/**
	 * Set the value related to the column: msgSendDetails
	 * @param msgSendDetails the msgSendDetails value
	 */
	public void setMsgSendDetails (java.util.Set<com.justonetech.biz.domain.MsgSendDetail> msgSendDetails) {
		this.msgSendDetails = msgSendDetails;
	}

	public void addTomsgSendDetails (com.justonetech.biz.domain.MsgSendDetail msgSendDetail) {
		if (null == getMsgSendDetails()) setMsgSendDetails(new java.util.LinkedHashSet<com.justonetech.biz.domain.MsgSendDetail>());
		getMsgSendDetails().add(msgSendDetail);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.MsgMessage)) return false;
		else {
			com.justonetech.biz.domain.MsgMessage msgMessage = (com.justonetech.biz.domain.MsgMessage) obj;
			if (null == this.getId() || null == msgMessage.getId()) return false;
			else return (this.getId().equals(msgMessage.getId()));
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
		builder.append(content);
		builder.append(sender);
		builder.append(innerPersonIds);
		builder.append(innerPersonNames);
		builder.append(gdPersonIds);
		builder.append(gdPersonNames);
		builder.append(mobiles);
		builder.append(isSend);
		builder.append(sendTime);
		builder.append(isSendSms);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}