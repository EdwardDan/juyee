package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the REPORT_MONTH_DETAIL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 综合报表月份上报明细
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 综合报表月份上报明细
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : report
 * Projectable : false
 *
 * @hibernate.class
 *  table="REPORT_MONTH_DETAIL"
 */

public abstract class BaseReportMonthDetail  implements Serializable {

	public static String REF = "ReportMonthDetail";
	public static String PROP_ACCU_VALUE = "accuValue";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_PERCENT_HB = "percentHb";
	public static String PROP_REPORT_STRUCTURE = "reportStructure";
	public static String PROP_REPORT_MONTH = "reportMonth";
	public static String PROP_ID = "id";
	public static String PROP_PERCENT_TB = "percentTb";
	public static String PROP_MONTH_VALUE = "monthValue";


	// constructors
	public BaseReportMonthDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseReportMonthDetail (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*本月填报*/
    /*本月填报*/
	private Double monthValue;
	
    /*累计*/
    /*累计*/
	private Double accuValue;
	
    /*环比*/
    /*环比*/
	private Double percentHb;
	
    /*同比*/
    /*同比*/
	private Double percentTb;
	
    /*备注*/
    /*备注*/
	private String description;
	

	// many to one
	private com.justonetech.biz.domain.ReportMonth reportMonth;
	private com.justonetech.biz.domain.ReportStructure reportStructure;



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
	 * Return the value associated with the column: MONTH_VALUE
	 */
	public Double getMonthValue () {
		return monthValue;
	}

	/**
	 * Set the value related to the column: MONTH_VALUE
	 * @param monthValue the MONTH_VALUE value
	 */
	public void setMonthValue (Double monthValue) {
		this.monthValue = monthValue;
	}


	/**
	 * Return the value associated with the column: ACCU_VALUE
	 */
	public Double getAccuValue () {
		return accuValue;
	}

	/**
	 * Set the value related to the column: ACCU_VALUE
	 * @param accuValue the ACCU_VALUE value
	 */
	public void setAccuValue (Double accuValue) {
		this.accuValue = accuValue;
	}


	/**
	 * Return the value associated with the column: PERCENT_HB
	 */
	public Double getPercentHb () {
		return percentHb;
	}

	/**
	 * Set the value related to the column: PERCENT_HB
	 * @param percentHb the PERCENT_HB value
	 */
	public void setPercentHb (Double percentHb) {
		this.percentHb = percentHb;
	}


	/**
	 * Return the value associated with the column: PERCENT_TB
	 */
	public Double getPercentTb () {
		return percentTb;
	}

	/**
	 * Set the value related to the column: PERCENT_TB
	 * @param percentTb the PERCENT_TB value
	 */
	public void setPercentTb (Double percentTb) {
		this.percentTb = percentTb;
	}


	/**
	 * Return the value associated with the column: DESCRIPTION
	 */
	public String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: DESCRIPTION
	 * @param description the DESCRIPTION value
	 */
	public void setDescription (String description) {
		this.description = description;
	}


	/**
	 * Return the value associated with the column: REPORT_MONTH_ID
	 */
	public com.justonetech.biz.domain.ReportMonth getReportMonth () {
		return reportMonth;
	}

	/**
	 * Set the value related to the column: REPORT_MONTH_ID
	 * @param reportMonth the REPORT_MONTH_ID value
	 */
	public void setReportMonth (com.justonetech.biz.domain.ReportMonth reportMonth) {
		this.reportMonth = reportMonth;
	}


	/**
	 * Return the value associated with the column: REPORT_STRUCTURE_ID
	 */
	public com.justonetech.biz.domain.ReportStructure getReportStructure () {
		return reportStructure;
	}

	/**
	 * Set the value related to the column: REPORT_STRUCTURE_ID
	 * @param reportStructure the REPORT_STRUCTURE_ID value
	 */
	public void setReportStructure (com.justonetech.biz.domain.ReportStructure reportStructure) {
		this.reportStructure = reportStructure;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ReportMonthDetail)) return false;
		else {
			com.justonetech.biz.domain.ReportMonthDetail reportMonthDetail = (com.justonetech.biz.domain.ReportMonthDetail) obj;
			if (null == this.getId() || null == reportMonthDetail.getId()) return false;
			else return (this.getId().equals(reportMonthDetail.getId()));
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
		builder.append(monthValue);
		builder.append(accuValue);
		builder.append(percentHb);
		builder.append(percentTb);
		builder.append(description);
		return builder.toString();
	}


}