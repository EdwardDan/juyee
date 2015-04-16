package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_MONTHPLAN_ITEM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 月度总结和计划明细
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 月度总结和计划明细
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_MONTHPLAN_ITEM"
 */

public abstract class BaseOaMonthplanItem  implements Serializable {

	public static String REF = "OaMonthplanItem";
	public static String PROP_REPORT_TYPE = "reportType";
	public static String PROP_TIME_NODE = "timeNode";
	public static String PROP_ORDER_NO = "orderNo";
	public static String PROP_IS_COMPLETE = "isComplete";
	public static String PROP_IS_SUM_DELETE = "isSumDelete";
	public static String PROP_MONTHPLAN = "monthplan";
	public static String PROP_ID = "id";
	public static String PROP_CONTENT = "content";


	// constructors
	public BaseOaMonthplanItem () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaMonthplanItem (Long id) {
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

    /*是否删除*/
    /*是否删除*/
	private Boolean isSumDelete;


	// many to one
	private com.justonetech.biz.domain.OaMonthplan monthplan;

	// collections
	private java.util.Set<com.justonetech.biz.domain.OaMonthplanSumItem> oaMonthplanSumItems;



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
     * Return the value associated with the column: IS_COMPLETE
     */
    public Boolean getIsSumDelete() {
        return this.isSumDelete;
    }

    /**
     * Set the value related to the column: IS_COMPLETE
     * @param isSumDelete the IS_COMPLETE value
     */
    public void setIsSumDelete(Boolean isSumDelete) {
        this.isSumDelete = isSumDelete;
    }


	/**
	 * Return the value associated with the column: MONTHPLAN_ID
	 */
	public com.justonetech.biz.domain.OaMonthplan getMonthplan () {
		return monthplan;
	}

	/**
	 * Set the value related to the column: MONTHPLAN_ID
	 * @param monthplan the MONTHPLAN_ID value
	 */
	public void setMonthplan (com.justonetech.biz.domain.OaMonthplan monthplan) {
		this.monthplan = monthplan;
	}


	/**
	 * Return the value associated with the column: oaMonthplanSumItems
	 */
	public java.util.Set<com.justonetech.biz.domain.OaMonthplanSumItem> getOaMonthplanSumItems () {
		if(oaMonthplanSumItems == null){
			oaMonthplanSumItems = new java.util.LinkedHashSet<com.justonetech.biz.domain.OaMonthplanSumItem>();
		}
		return oaMonthplanSumItems;
	}

	/**
	 * Set the value related to the column: oaMonthplanSumItems
	 * @param oaMonthplanSumItems the oaMonthplanSumItems value
	 */
	public void setOaMonthplanSumItems (java.util.Set<com.justonetech.biz.domain.OaMonthplanSumItem> oaMonthplanSumItems) {
		this.oaMonthplanSumItems = oaMonthplanSumItems;
	}

	public void addTooaMonthplanSumItems (com.justonetech.biz.domain.OaMonthplanSumItem oaMonthplanSumItem) {
		if (null == getOaMonthplanSumItems()) setOaMonthplanSumItems(new java.util.LinkedHashSet<com.justonetech.biz.domain.OaMonthplanSumItem>());
		getOaMonthplanSumItems().add(oaMonthplanSumItem);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaMonthplanItem)) return false;
		else {
			com.justonetech.biz.domain.OaMonthplanItem oaMonthplanItem = (com.justonetech.biz.domain.OaMonthplanItem) obj;
			if (null == this.getId() || null == oaMonthplanItem.getId()) return false;
			else return (this.getId().equals(oaMonthplanItem.getId()));
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
		return builder.toString();
	}


}