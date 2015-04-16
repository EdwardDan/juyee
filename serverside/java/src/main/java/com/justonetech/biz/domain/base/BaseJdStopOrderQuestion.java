package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the JD_STOP_ORDER_QUESTION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 安全质量监督--整改指令单选择问题
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 安全质量监督--整改指令单选择问题
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : jd
 * Projectable : false
 *
 * @hibernate.class
 *  table="JD_STOP_ORDER_QUESTION"
 */

public abstract class BaseJdStopOrderQuestion  implements Serializable {

	public static String REF = "JdStopOrderQuestion";
	public static String PROP_ID = "id";
	public static String PROP_REFORM_ORDER = "reformOrder";
	public static String PROP_RECORD_QUESTION = "recordQuestion";


	// constructors
	public BaseJdStopOrderQuestion () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseJdStopOrderQuestion (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// many to one
	private com.justonetech.biz.domain.JdRecordQuestion recordQuestion;
	private com.justonetech.biz.domain.JdStopOrder reformOrder;



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
	 * Return the value associated with the column: RECORD_QUESTION_ID
	 */
	public com.justonetech.biz.domain.JdRecordQuestion getRecordQuestion () {
		return recordQuestion;
	}

	/**
	 * Set the value related to the column: RECORD_QUESTION_ID
	 * @param recordQuestion the RECORD_QUESTION_ID value
	 */
	public void setRecordQuestion (com.justonetech.biz.domain.JdRecordQuestion recordQuestion) {
		this.recordQuestion = recordQuestion;
	}


	/**
	 * Return the value associated with the column: REFORM_ORDER_ID
	 */
	public com.justonetech.biz.domain.JdStopOrder getReformOrder () {
		return reformOrder;
	}

	/**
	 * Set the value related to the column: REFORM_ORDER_ID
	 * @param reformOrder the REFORM_ORDER_ID value
	 */
	public void setReformOrder (com.justonetech.biz.domain.JdStopOrder reformOrder) {
		this.reformOrder = reformOrder;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.JdStopOrderQuestion)) return false;
		else {
			com.justonetech.biz.domain.JdStopOrderQuestion jdStopOrderQuestion = (com.justonetech.biz.domain.JdStopOrderQuestion) obj;
			if (null == this.getId() || null == jdStopOrderQuestion.getId()) return false;
			else return (this.getId().equals(jdStopOrderQuestion.getId()));
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
		return builder.toString();
	}


}