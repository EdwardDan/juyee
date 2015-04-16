//package com.justonetech.sjjjw.domain.base;
package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the JD_RECORD_COMPLETE_RESULT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 安全质量监督--竣工验收--验收结果
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 安全质量监督--竣工验收--验收结果
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : jd
 * Projectable : false
 *
 * @hibernate.class
 *  table="JD_RECORD_COMPLETE_RESULT"
 */

public abstract class BaseJdRecordCompleteResult  implements Serializable {

	public static String REF = "JdRecordCompleteResult";
	public static String PROP_CHECK_RESULT = "checkResult";
	public static String PROP_ID = "id";
	public static String PROP_RECORD_COMPLETE = "recordComplete";
	public static String PROP_CHECKITEM = "checkitem";


	// constructors
	public BaseJdRecordCompleteResult () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseJdRecordCompleteResult (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*检查结果*/
    /*检查结果*/
	private java.lang.String checkResult;
	

	// many to one
	private com.justonetech.biz.domain.JdRecordComplete recordComplete;
	private com.justonetech.biz.domain.JdRecordCompCheckitem checkitem;



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
	 * Return the value associated with the column: CHECK_RESULT
	 */
	public java.lang.String getCheckResult () {
		return checkResult;
	}

	/**
	 * Set the value related to the column: CHECK_RESULT
	 * @param checkResult the CHECK_RESULT value
	 */
	public void setCheckResult (java.lang.String checkResult) {
		this.checkResult = checkResult;
	}


	/**
	 * Return the value associated with the column: RECORD_COMPLETE_ID
	 */
	public com.justonetech.biz.domain.JdRecordComplete getRecordComplete () {
		return recordComplete;
	}

	/**
	 * Set the value related to the column: RECORD_COMPLETE_ID
	 * @param recordComplete the RECORD_COMPLETE_ID value
	 */
	public void setRecordComplete (com.justonetech.biz.domain.JdRecordComplete recordComplete) {
		this.recordComplete = recordComplete;
	}


	/**
	 * Return the value associated with the column: CHECKITEM_ID
	 */
	public com.justonetech.biz.domain.JdRecordCompCheckitem getCheckitem () {
		return checkitem;
	}

	/**
	 * Set the value related to the column: CHECKITEM_ID
	 * @param checkitem the CHECKITEM_ID value
	 */
	public void setCheckitem (com.justonetech.biz.domain.JdRecordCompCheckitem checkitem) {
		this.checkitem = checkitem;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.JdRecordCompleteResult)) return false;
		else {
			com.justonetech.biz.domain.JdRecordCompleteResult jdRecordCompleteResult = (com.justonetech.biz.domain.JdRecordCompleteResult) obj;
			if (null == this.getId() || null == jdRecordCompleteResult.getId()) return false;
			else return (this.getId().equals(jdRecordCompleteResult.getId()));
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
		builder.append(checkResult);
		return builder.toString();
	}


}