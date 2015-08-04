package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_WORK_PLAN_SUM_ITEM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 科室上报汇总明细
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 科室上报汇总明细
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_WORK_PLAN_SUM_ITEM"
 */

public abstract class BaseOaWorkPlanSumItem  implements Serializable {

	public static String REF = "OaWorkPlanSumItem";
	public static String PROP_SCHEDULE = "schedule";
	public static String PROP_DUTY_PEROSN = "dutyPerosn";
	public static String PROP_ORDER_NO = "orderNo";
	public static String PROP_WORK_PLAN_SUM = "workPlanSum";
	public static String PROP_ID = "id";
	public static String PROP_JBR = "jbr";
	public static String PROP_CONTENT = "content";
	public static String PROP_WORK_PLAN_ITEM = "workPlanItem";
	public static String PROP_KEY_WORK = "keyWork";


	// constructors
	public BaseOaWorkPlanSumItem () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaWorkPlanSumItem (Long id) {
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
	
    /*责任人*/
    /*责任人*/
	private String dutyPerosn;
	
    /*重点工作*/
    /*重点工作*/
	private String keyWork;
	
    /*工作内容*/
    /*工作内容*/
	private String content;
	
    /*工作进度*/
    /*工作进度*/
	private String schedule;
	
    /*经办人*/
    /*经办人*/
	private String jbr;
	

	// many to one
	private com.justonetech.biz.domain.OaWorkPlanItem workPlanItem;
	private com.justonetech.biz.domain.OaWorkPlanSum workPlanSum;



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
	 * Return the value associated with the column: DUTY_PEROSN
	 */
	public String getDutyPerosn () {
		return dutyPerosn;
	}

	/**
	 * Set the value related to the column: DUTY_PEROSN
	 * @param dutyPerosn the DUTY_PEROSN value
	 */
	public void setDutyPerosn (String dutyPerosn) {
		this.dutyPerosn = dutyPerosn;
	}


	/**
	 * Return the value associated with the column: KEY_WORK
	 */
	public String getKeyWork () {
		return keyWork;
	}

	/**
	 * Set the value related to the column: KEY_WORK
	 * @param keyWork the KEY_WORK value
	 */
	public void setKeyWork (String keyWork) {
		this.keyWork = keyWork;
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
	 * Return the value associated with the column: SCHEDULE
	 */
	public String getSchedule () {
		return schedule;
	}

	/**
	 * Set the value related to the column: SCHEDULE
	 * @param schedule the SCHEDULE value
	 */
	public void setSchedule (String schedule) {
		this.schedule = schedule;
	}


	/**
	 * Return the value associated with the column: JBR
	 */
	public String getJbr () {
		return jbr;
	}

	/**
	 * Set the value related to the column: JBR
	 * @param jbr the JBR value
	 */
	public void setJbr (String jbr) {
		this.jbr = jbr;
	}


	/**
	 * Return the value associated with the column: WORK_PLAN_ITEM_ID
	 */
	public com.justonetech.biz.domain.OaWorkPlanItem getWorkPlanItem () {
		return workPlanItem;
	}

	/**
	 * Set the value related to the column: WORK_PLAN_ITEM_ID
	 * @param workPlanItem the WORK_PLAN_ITEM_ID value
	 */
	public void setWorkPlanItem (com.justonetech.biz.domain.OaWorkPlanItem workPlanItem) {
		this.workPlanItem = workPlanItem;
	}


	/**
	 * Return the value associated with the column: WORK_PLAN_SUM_ID
	 */
	public com.justonetech.biz.domain.OaWorkPlanSum getWorkPlanSum () {
		return workPlanSum;
	}

	/**
	 * Set the value related to the column: WORK_PLAN_SUM_ID
	 * @param workPlanSum the WORK_PLAN_SUM_ID value
	 */
	public void setWorkPlanSum (com.justonetech.biz.domain.OaWorkPlanSum workPlanSum) {
		this.workPlanSum = workPlanSum;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaWorkPlanSumItem)) return false;
		else {
			com.justonetech.biz.domain.OaWorkPlanSumItem oaWorkPlanSumItem = (com.justonetech.biz.domain.OaWorkPlanSumItem) obj;
			if (null == this.getId() || null == oaWorkPlanSumItem.getId()) return false;
			else return (this.getId().equals(oaWorkPlanSumItem.getId()));
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
		builder.append(dutyPerosn);
		builder.append(keyWork);
		builder.append(content);
		builder.append(schedule);
		builder.append(jbr);
		return builder.toString();
	}


}