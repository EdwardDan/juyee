package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the JD_REFORM_REPLY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 安全质量监督--整改回复单
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 安全质量监督--整改回复单
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : jd
 * Projectable : false
 *
 * @hibernate.class
 *  table="JD_REFORM_REPLY"
 */

public abstract class BaseJdReformReply  implements Serializable,Auditable {

	public static String REF = "JdReformReply";
	public static String PROP_SIGN_PERSON = "signPerson";
	public static String PROP_DOCUMENT = "document";
	public static String PROP_EXIST_QUESTION = "existQuestion";
	public static String PROP_RECEIVE_USERNAME = "receiveUsername";
	public static String PROP_REPLY_CONTENT = "replyContent";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_RECEIVE_PERSON = "receivePerson";
	public static String PROP_LIMIT_DATE = "limitDate";
	public static String PROP_SIGN_DATE = "signDate";
	public static String PROP_STATUS = "status";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_STOP_FORM = "stopForm";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_ID = "id";
	public static String PROP_OPINION = "opinion";
	public static String PROP_UPDATE_USER = "updateUser";
	public static String PROP_REPLY_USERNAME = "replyUsername";
	public static String PROP_REPLY_PERSON = "replyPerson";
	public static String PROP_REPLY_DATE = "replyDate";
	public static String PROP_SIGN_USERNAME = "signUsername";


	// constructors
	public BaseJdReformReply () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseJdReformReply (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*回复内容*/
    /*回复内容*/
	private java.lang.String replyContent;
	
    /*回复人用户名*/
    /*回复人用户名*/
	private java.lang.String replyUsername;
	
    /*回复人姓名*/
    /*回复人姓名*/
	private java.lang.String replyPerson;
	
    /*回复日期*/
    /*回复日期*/
	private java.sql.Date replyDate;
	
    /*接收人用户名*/
    /*接收人用户名*/
	private java.lang.String receiveUsername;
	
    /*接收人姓名*/
    /*接收人姓名*/
	private java.lang.String receivePerson;
	
    /*存在问题*/
    /*存在问题*/
	private java.lang.String existQuestion;
	
    /*整改时限*/
    /*整改时限*/
	private java.sql.Date limitDate;
	
    /*签发人用户名*/
    /*签发人用户名*/
	private java.lang.String signUsername;
	
    /*签发人姓名*/
    /*签发人姓名*/
	private java.lang.String signPerson;
	
    /*签发日期*/
    /*签发日期*/
	private java.sql.Date signDate;
	
    /*创建时间*/
    /*创建时间*/
	private java.sql.Timestamp createTime;
	
    /*创建用户名*/
    /*创建用户名*/
	private java.lang.String createUser;
	
    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updateTime;
	
    /*更新用户名*/
    /*更新用户名*/
	private java.lang.String updateUser;
	
    /*状态*/
    /*状态*/
	private java.lang.Integer status;
	

	// many to one
	private com.justonetech.biz.domain.JdStopOrder stopForm;
	private com.justonetech.biz.domain.DocDocument document;
	private com.justonetech.system.domain.SysCodeDetail opinion;



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
	 * Return the value associated with the column: REPLY_CONTENT
	 */
	public java.lang.String getReplyContent () {
		return replyContent;
	}

	/**
	 * Set the value related to the column: REPLY_CONTENT
	 * @param replyContent the REPLY_CONTENT value
	 */
	public void setReplyContent (java.lang.String replyContent) {
		this.replyContent = replyContent;
	}


	/**
	 * Return the value associated with the column: REPLY_USERNAME
	 */
	public java.lang.String getReplyUsername () {
		return replyUsername;
	}

	/**
	 * Set the value related to the column: REPLY_USERNAME
	 * @param replyUsername the REPLY_USERNAME value
	 */
	public void setReplyUsername (java.lang.String replyUsername) {
		this.replyUsername = replyUsername;
	}


	/**
	 * Return the value associated with the column: REPLY_PERSON
	 */
	public java.lang.String getReplyPerson () {
		return replyPerson;
	}

	/**
	 * Set the value related to the column: REPLY_PERSON
	 * @param replyPerson the REPLY_PERSON value
	 */
	public void setReplyPerson (java.lang.String replyPerson) {
		this.replyPerson = replyPerson;
	}


	/**
	 * Return the value associated with the column: REPLY_DATE
	 */
	public java.sql.Date getReplyDate () {
		return replyDate;
	}

	/**
	 * Set the value related to the column: REPLY_DATE
	 * @param replyDate the REPLY_DATE value
	 */
	public void setReplyDate (java.sql.Date replyDate) {
		this.replyDate = replyDate;
	}


	/**
	 * Return the value associated with the column: RECEIVE_USERNAME
	 */
	public java.lang.String getReceiveUsername () {
		return receiveUsername;
	}

	/**
	 * Set the value related to the column: RECEIVE_USERNAME
	 * @param receiveUsername the RECEIVE_USERNAME value
	 */
	public void setReceiveUsername (java.lang.String receiveUsername) {
		this.receiveUsername = receiveUsername;
	}


	/**
	 * Return the value associated with the column: RECEIVE_PERSON
	 */
	public java.lang.String getReceivePerson () {
		return receivePerson;
	}

	/**
	 * Set the value related to the column: RECEIVE_PERSON
	 * @param receivePerson the RECEIVE_PERSON value
	 */
	public void setReceivePerson (java.lang.String receivePerson) {
		this.receivePerson = receivePerson;
	}


	/**
	 * Return the value associated with the column: EXIST_QUESTION
	 */
	public java.lang.String getExistQuestion () {
		return existQuestion;
	}

	/**
	 * Set the value related to the column: EXIST_QUESTION
	 * @param existQuestion the EXIST_QUESTION value
	 */
	public void setExistQuestion (java.lang.String existQuestion) {
		this.existQuestion = existQuestion;
	}


	/**
	 * Return the value associated with the column: LIMIT_DATE
	 */
	public java.sql.Date getLimitDate () {
		return limitDate;
	}

	/**
	 * Set the value related to the column: LIMIT_DATE
	 * @param limitDate the LIMIT_DATE value
	 */
	public void setLimitDate (java.sql.Date limitDate) {
		this.limitDate = limitDate;
	}


	/**
	 * Return the value associated with the column: SIGN_USERNAME
	 */
	public java.lang.String getSignUsername () {
		return signUsername;
	}

	/**
	 * Set the value related to the column: SIGN_USERNAME
	 * @param signUsername the SIGN_USERNAME value
	 */
	public void setSignUsername (java.lang.String signUsername) {
		this.signUsername = signUsername;
	}


	/**
	 * Return the value associated with the column: SIGN_PERSON
	 */
	public java.lang.String getSignPerson () {
		return signPerson;
	}

	/**
	 * Set the value related to the column: SIGN_PERSON
	 * @param signPerson the SIGN_PERSON value
	 */
	public void setSignPerson (java.lang.String signPerson) {
		this.signPerson = signPerson;
	}


	/**
	 * Return the value associated with the column: SIGN_DATE
	 */
	public java.sql.Date getSignDate () {
		return signDate;
	}

	/**
	 * Set the value related to the column: SIGN_DATE
	 * @param signDate the SIGN_DATE value
	 */
	public void setSignDate (java.sql.Date signDate) {
		this.signDate = signDate;
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
	public java.lang.String getCreateUser () {
		return createUser;
	}

	/**
	 * Set the value related to the column: CREATE_USER
	 * @param createUser the CREATE_USER value
	 */
	public void setCreateUser (java.lang.String createUser) {
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
	public java.lang.String getUpdateUser () {
		return updateUser;
	}

	/**
	 * Set the value related to the column: UPDATE_USER
	 * @param updateUser the UPDATE_USER value
	 */
	public void setUpdateUser (java.lang.String updateUser) {
		this.updateUser = updateUser;
	}


	/**
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.Integer getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (java.lang.Integer status) {
		this.status = status;
	}


	/**
	 * Return the value associated with the column: STOP_FORM_ID
	 */
	public com.justonetech.biz.domain.JdStopOrder getStopForm () {
		return stopForm;
	}

	/**
	 * Set the value related to the column: STOP_FORM_ID
	 * @param stopForm the STOP_FORM_ID value
	 */
	public void setStopForm (com.justonetech.biz.domain.JdStopOrder stopForm) {
		this.stopForm = stopForm;
	}


	/**
	 * Return the value associated with the column: DOCUMENT_ID
	 */
	public com.justonetech.biz.domain.DocDocument getDocument () {
		return document;
	}

	/**
	 * Set the value related to the column: DOCUMENT_ID
	 * @param document the DOCUMENT_ID value
	 */
	public void setDocument (com.justonetech.biz.domain.DocDocument document) {
		this.document = document;
	}


	/**
	 * Return the value associated with the column: OPINION_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getOpinion () {
		return opinion;
	}

	/**
	 * Set the value related to the column: OPINION_ID
	 * @param opinion the OPINION_ID value
	 */
	public void setOpinion (com.justonetech.system.domain.SysCodeDetail opinion) {
		this.opinion = opinion;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.JdReformReply)) return false;
		else {
			com.justonetech.biz.domain.JdReformReply jdReformReply = (com.justonetech.biz.domain.JdReformReply) obj;
			if (null == this.getId() || null == jdReformReply.getId()) return false;
			else return (this.getId().equals(jdReformReply.getId()));
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
		builder.append(replyContent);
		builder.append(replyUsername);
		builder.append(replyPerson);
		builder.append(replyDate);
		builder.append(receiveUsername);
		builder.append(receivePerson);
		builder.append(existQuestion);
		builder.append(limitDate);
		builder.append(signUsername);
		builder.append(signPerson);
		builder.append(signDate);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		builder.append(status);
		return builder.toString();
	}


}