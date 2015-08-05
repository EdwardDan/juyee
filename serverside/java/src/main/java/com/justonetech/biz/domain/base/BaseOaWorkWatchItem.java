package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_WORK_WATCH_ITEM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 工作督办明细
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 工作督办明细
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_WORK_WATCH_ITEM"
 */

public abstract class BaseOaWorkWatchItem  implements Serializable ,Auditable{

	public static String REF = "OaWorkWatchItem";
	public static String PROP_TIME_NODE = "timeNode";
	public static String PROP_ORDER_NO = "orderNo";
	public static String PROP_ACTUAL_DESC = "actualDesc";
	public static String PROP_WORK_WATCH = "workWatch";
	public static String PROP_ID = "id";
	public static String PROP_CONTENT = "content";
	public static String PROP_COMPLETE_DESC = "completeDesc";
	public static String PROP_REPORT_METHOD = "reportMethod";


	// constructors
	public BaseOaWorkWatchItem () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaWorkWatchItem (Long id) {
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
	private String timeNode;
	
    /*上报形式*/
    /*上报形式*/
	private String reportMethod;
	
    /*完成情况*/
    /*完成情况*/
	private String completeDesc;
	
    /*核实情况*/
    /*核实情况*/
	private String actualDesc;
	

	// many to one
	private com.justonetech.biz.domain.OaWorkWatch workWatch;



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
	public String getTimeNode () {
		return timeNode;
	}

	/**
	 * Set the value related to the column: TIME_NODE
	 * @param timeNode the TIME_NODE value
	 */
	public void setTimeNode (String timeNode) {
		this.timeNode = timeNode;
	}


	/**
	 * Return the value associated with the column: REPORT_METHOD
	 */
	public String getReportMethod () {
		return reportMethod;
	}

	/**
	 * Set the value related to the column: REPORT_METHOD
	 * @param reportMethod the REPORT_METHOD value
	 */
	public void setReportMethod (String reportMethod) {
		this.reportMethod = reportMethod;
	}


	/**
	 * Return the value associated with the column: COMPLETE_DESC
	 */
	public String getCompleteDesc () {
		return completeDesc;
	}

	/**
	 * Set the value related to the column: COMPLETE_DESC
	 * @param completeDesc the COMPLETE_DESC value
	 */
	public void setCompleteDesc (String completeDesc) {
		this.completeDesc = completeDesc;
	}


	/**
	 * Return the value associated with the column: ACTUAL_DESC
	 */
	public String getActualDesc () {
		return actualDesc;
	}

	/**
	 * Set the value related to the column: ACTUAL_DESC
	 * @param actualDesc the ACTUAL_DESC value
	 */
	public void setActualDesc (String actualDesc) {
		this.actualDesc = actualDesc;
	}


	/**
	 * Return the value associated with the column: WORK_WATCH_ID
	 */
	public com.justonetech.biz.domain.OaWorkWatch getWorkWatch () {
		return workWatch;
	}

	/**
	 * Set the value related to the column: WORK_WATCH_ID
	 * @param workWatch the WORK_WATCH_ID value
	 */
	public void setWorkWatch (com.justonetech.biz.domain.OaWorkWatch workWatch) {
		this.workWatch = workWatch;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaWorkWatchItem)) return false;
		else {
			com.justonetech.biz.domain.OaWorkWatchItem oaWorkWatchItem = (com.justonetech.biz.domain.OaWorkWatchItem) obj;
			if (null == this.getId() || null == oaWorkWatchItem.getId()) return false;
			else return (this.getId().equals(oaWorkWatchItem.getId()));
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
		builder.append(reportMethod);
		builder.append(completeDesc);
		builder.append(actualDesc);
		return builder.toString();
	}


}