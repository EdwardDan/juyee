package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_QUARTERPLAN_SUM_ITEM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 季度年度总结计划汇总明细
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 季度年度总结计划汇总明细
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_QUARTERPLAN_SUM_ITEM"
 */

public abstract class BaseOaQuarterplanSumItem  implements Serializable {

	public static String REF = "OaQuarterplanSumItem";
	public static String PROP_REPORT_DEPT = "reportDept";
	public static String PROP_REPORT_PERSON = "reportPerson";
	public static String PROP_ORDER_NO = "orderNo";
	public static String PROP_ID = "id";
	public static String PROP_QUARTERPLAN_SUM = "quarterplanSum";
	public static String PROP_CONTENT = "content";
	public static String PROP_QUARTERPLAN_ITEM = "quarterplanItem";


	// constructors
	public BaseOaQuarterplanSumItem () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaQuarterplanSumItem (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*序号*/
    /*序号*/
	private Integer orderNo;
	
    /*工作内容*/
    /*工作内容*/
	private String content;
	
    /*提交部门*/
    /*提交部门*/
	private String reportDept;
	
    /*责任人*/
    /*责任人*/
	private String reportPerson;
	

	// many to one
	private com.justonetech.biz.domain.OaQuarterplanSum quarterplanSum;
	private com.justonetech.biz.domain.OaQuarterplan quarterplanItem;



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
	 * Return the value associated with the column: ORDER_NO
	 */
	public Integer getOrderNo () {
		return orderNo;
	}

	/**
	 * Set the value related to the column: ORDER_NO
	 * @param orderNo the ORDER_NO value
	 */
	public void setOrderNo (Integer orderNo) {
		this.orderNo = orderNo;
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
	 * Return the value associated with the column: REPORT_DEPT
	 */
	public String getReportDept () {
		return reportDept;
	}

	/**
	 * Set the value related to the column: REPORT_DEPT
	 * @param reportDept the REPORT_DEPT value
	 */
	public void setReportDept (String reportDept) {
		this.reportDept = reportDept;
	}


	/**
	 * Return the value associated with the column: REPORT_PERSON
	 */
	public String getReportPerson () {
		return reportPerson;
	}

	/**
	 * Set the value related to the column: REPORT_PERSON
	 * @param reportPerson the REPORT_PERSON value
	 */
	public void setReportPerson (String reportPerson) {
		this.reportPerson = reportPerson;
	}


	/**
	 * Return the value associated with the column: QUARTERPLAN_SUM_ID
	 */
	public com.justonetech.biz.domain.OaQuarterplanSum getQuarterplanSum () {
		return quarterplanSum;
	}

	/**
	 * Set the value related to the column: QUARTERPLAN_SUM_ID
	 * @param quarterplanSum the QUARTERPLAN_SUM_ID value
	 */
	public void setQuarterplanSum (com.justonetech.biz.domain.OaQuarterplanSum quarterplanSum) {
		this.quarterplanSum = quarterplanSum;
	}


	/**
	 * Return the value associated with the column: QUARTERPLAN_ITEM_ID
	 */
	public com.justonetech.biz.domain.OaQuarterplan getQuarterplanItem () {
		return quarterplanItem;
	}

	/**
	 * Set the value related to the column: QUARTERPLAN_ITEM_ID
	 * @param quarterplanItem the QUARTERPLAN_ITEM_ID value
	 */
	public void setQuarterplanItem (com.justonetech.biz.domain.OaQuarterplan quarterplanItem) {
		this.quarterplanItem = quarterplanItem;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaQuarterplanSumItem)) return false;
		else {
			com.justonetech.biz.domain.OaQuarterplanSumItem oaQuarterplanSumItem = (com.justonetech.biz.domain.OaQuarterplanSumItem) obj;
			if (null == this.getId() || null == oaQuarterplanSumItem.getId()) return false;
			else return (this.getId().equals(oaQuarterplanSumItem.getId()));
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
		builder.append(content);
		builder.append(reportDept);
		builder.append(reportPerson);
		return builder.toString();
	}


}