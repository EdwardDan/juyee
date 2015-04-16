package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_MONTHPLAN_SUM_ITEM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 月度总结和计划汇总明细
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 月度总结和计划汇总明细
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_MONTHPLAN_SUM_ITEM"
 */

public abstract class BaseOaMonthplanSumItem  implements Serializable {

	public static String REF = "OaMonthplanSumItem";
	public static String PROP_REPORT_DEPT = "reportDept";
	public static String PROP_MONTHPLAN_ITEM = "monthplanItem";
	public static String PROP_REPORT_TYPE = "reportType";
	public static String PROP_MONTHPLAN_SUM = "monthplanSum";
	public static String PROP_TIME_NODE = "timeNode";
	public static String PROP_REPORT_PERSON = "reportPerson";
	public static String PROP_ORDER_NO = "orderNo";
	public static String PROP_IS_COMPLETE = "isComplete";
	public static String PROP_ID = "id";
	public static String PROP_CONTENT = "content";


	// constructors
	public BaseOaMonthplanSumItem () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaMonthplanSumItem (Long id) {
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
	
    /*时间节点*/
    /*时间节点*/
	private java.sql.Date timeNode;
	
    /*报告类型*/
    /*报告类型*/
	private String reportType;
	
    /*是否完成*/
    /*是否完成*/
	private Boolean isComplete;
	
    /*提交部门*/
    /*提交部门*/
	private String reportDept;
	
    /*责任人*/
    /*责任人*/
	private String reportPerson;
	

	// many to one
	private com.justonetech.biz.domain.OaMonthplanItem monthplanItem;
	private com.justonetech.biz.domain.OaMonthplanSum monthplanSum;



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
	 * Return the value associated with the column: TIME_NODE
	 */
	public java.sql.Date getTimeNode () {
		return timeNode;
	}

	/**
	 * Set the value related to the column: TIME_NODE
	 * @param timeNode the TIME_NODE value
	 */
	public void setTimeNode (java.sql.Date timeNode) {
		this.timeNode = timeNode;
	}


	/**
	 * Return the value associated with the column: REPORT_TYPE
	 */
	public String getReportType () {
		return reportType;
	}

	/**
	 * Set the value related to the column: REPORT_TYPE
	 * @param reportType the REPORT_TYPE value
	 */
	public void setReportType (String reportType) {
		this.reportType = reportType;
	}


	/**
	 * Return the value associated with the column: IS_COMPLETE
	 */
	public Boolean getIsComplete () {
		return isComplete;
	}

	/**
	 * Set the value related to the column: IS_COMPLETE
	 * @param isComplete the IS_COMPLETE value
	 */
	public void setIsComplete (Boolean isComplete) {
		this.isComplete = isComplete;
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
	 * Return the value associated with the column: MONTHPLAN_ITEM_ID
	 */
	public com.justonetech.biz.domain.OaMonthplanItem getMonthplanItem () {
		return monthplanItem;
	}

	/**
	 * Set the value related to the column: MONTHPLAN_ITEM_ID
	 * @param monthplanItem the MONTHPLAN_ITEM_ID value
	 */
	public void setMonthplanItem (com.justonetech.biz.domain.OaMonthplanItem monthplanItem) {
		this.monthplanItem = monthplanItem;
	}


	/**
	 * Return the value associated with the column: MONTHPLAN_SUM_ID
	 */
	public com.justonetech.biz.domain.OaMonthplanSum getMonthplanSum () {
		return monthplanSum;
	}

	/**
	 * Set the value related to the column: MONTHPLAN_SUM_ID
	 * @param monthplanSum the MONTHPLAN_SUM_ID value
	 */
	public void setMonthplanSum (com.justonetech.biz.domain.OaMonthplanSum monthplanSum) {
		this.monthplanSum = monthplanSum;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaMonthplanSumItem)) return false;
		else {
			com.justonetech.biz.domain.OaMonthplanSumItem oaMonthplanSumItem = (com.justonetech.biz.domain.OaMonthplanSumItem) obj;
			if (null == this.getId() || null == oaMonthplanSumItem.getId()) return false;
			else return (this.getId().equals(oaMonthplanSumItem.getId()));
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
		builder.append(timeNode);
		builder.append(reportType);
		builder.append(isComplete);
		builder.append(reportDept);
		builder.append(reportPerson);
		return builder.toString();
	}


}