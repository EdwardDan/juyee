package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the JD_RECORD_COMP_CHECKITEM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 安全质量监督--竣工验收--验收条件设置
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 安全质量监督--竣工验收--验收条件设置
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : jd
 * Projectable : false
 *
 * @hibernate.class
 *  table="JD_RECORD_COMP_CHECKITEM"
 */

public abstract class BaseJdRecordCompCheckitem  implements Serializable {

	public static String REF = "JdRecordCompCheckitem";
	public static String PROP_CONDITION = "condition";
	public static String PROP_ORDER_NO = "orderNo";
	public static String PROP_TYPE = "type";
	public static String PROP_ID = "id";
	public static String PROP_SELECT_ITEMS = "selectItems";


	// constructors
	public BaseJdRecordCompCheckitem () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseJdRecordCompCheckitem (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*序号*/
    /*序号*/
	private java.lang.Long orderNo;
	
    /*竣工验收条件*/
    /*竣工验收条件*/
	private java.lang.String condition;
	
    /*符合形式*/
    /*符合形式*/
	private java.lang.String selectItems;
	

	// many to one
	private com.justonetech.system.domain.SysCodeDetail type;

	// collections
	private java.util.Set<com.justonetech.biz.domain.JdRecordCompleteResult> jdRecordCompleteResults;



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
	 * Return the value associated with the column: ORDER_NO
	 */
	public java.lang.Long getOrderNo () {
		return orderNo;
	}

	/**
	 * Set the value related to the column: ORDER_NO
	 * @param orderNo the ORDER_NO value
	 */
	public void setOrderNo (java.lang.Long orderNo) {
		this.orderNo = orderNo;
	}


	/**
	 * Return the value associated with the column: CONDITION
	 */
	public java.lang.String getCondition () {
		return condition;
	}

	/**
	 * Set the value related to the column: CONDITION
	 * @param condition the CONDITION value
	 */
	public void setCondition (java.lang.String condition) {
		this.condition = condition;
	}


	/**
	 * Return the value associated with the column: SELECT_ITEMS
	 */
	public java.lang.String getSelectItems () {
		return selectItems;
	}

	/**
	 * Set the value related to the column: SELECT_ITEMS
	 * @param selectItems the SELECT_ITEMS value
	 */
	public void setSelectItems (java.lang.String selectItems) {
		this.selectItems = selectItems;
	}


	/**
	 * Return the value associated with the column: TYPE_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getType () {
		return type;
	}

	/**
	 * Set the value related to the column: TYPE_ID
	 * @param type the TYPE_ID value
	 */
	public void setType (com.justonetech.system.domain.SysCodeDetail type) {
		this.type = type;
	}


	/**
	 * Return the value associated with the column: jdRecordCompleteResults
	 */
	public java.util.Set<com.justonetech.biz.domain.JdRecordCompleteResult> getJdRecordCompleteResults () {
		if(jdRecordCompleteResults == null){
			jdRecordCompleteResults = new java.util.LinkedHashSet<com.justonetech.biz.domain.JdRecordCompleteResult>();
		}
		return jdRecordCompleteResults;
	}

	/**
	 * Set the value related to the column: jdRecordCompleteResults
	 * @param jdRecordCompleteResults the jdRecordCompleteResults value
	 */
	public void setJdRecordCompleteResults (java.util.Set<com.justonetech.biz.domain.JdRecordCompleteResult> jdRecordCompleteResults) {
		this.jdRecordCompleteResults = jdRecordCompleteResults;
	}

	public void addTojdRecordCompleteResults (com.justonetech.biz.domain.JdRecordCompleteResult jdRecordCompleteResult) {
		if (null == getJdRecordCompleteResults()) setJdRecordCompleteResults(new java.util.LinkedHashSet<com.justonetech.biz.domain.JdRecordCompleteResult>());
		getJdRecordCompleteResults().add(jdRecordCompleteResult);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.JdRecordCompCheckitem)) return false;
		else {
			com.justonetech.biz.domain.JdRecordCompCheckitem jdRecordCompCheckitem = (com.justonetech.biz.domain.JdRecordCompCheckitem) obj;
			if (null == this.getId() || null == jdRecordCompCheckitem.getId()) return false;
			else return (this.getId().equals(jdRecordCompCheckitem.getId()));
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
		builder.append(orderNo);
		builder.append(condition);
		builder.append(selectItems);
		return builder.toString();
	}


}