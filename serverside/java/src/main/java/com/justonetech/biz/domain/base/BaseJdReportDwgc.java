package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the JD_REPORT_DWGC table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 监督报告单位工程
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 监督报告单位工程
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : report
 * Projectable : false
 *
 * @hibernate.class
 *  table="JD_REPORT_DWGC"
 */

public abstract class BaseJdReportDwgc  implements Serializable {

	public static String REF = "JdReportDwgc";
	public static String PROP_JD_REPORT = "jdReport";
	public static String PROP_JD_TASK_DWGC = "jdTaskDwgc";
	public static String PROP_ID = "id";


	// constructors
	public BaseJdReportDwgc () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseJdReportDwgc (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// many to one
	private com.justonetech.biz.domain.ExcelJdDwgc excelJdDwgc;
	private com.justonetech.biz.domain.JdReport jdReport;



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
	 * Return the value associated with the column: JD_TASK_DWGC_ID
	 */
	public com.justonetech.biz.domain.ExcelJdDwgc getExcelJdDwgc () {
		return excelJdDwgc;
	}

	/**
	 * Set the value related to the column: JD_TASK_DWGC_ID
	 * @param excelJdDwgc the JD_TASK_DWGC_ID value
	 */
	public void setExcelJdDwgc (com.justonetech.biz.domain.ExcelJdDwgc excelJdDwgc) {
		this.excelJdDwgc = excelJdDwgc;
	}


	/**
	 * Return the value associated with the column: JD_REPORT_ID
	 */
	public com.justonetech.biz.domain.JdReport getJdReport () {
		return jdReport;
	}

	/**
	 * Set the value related to the column: JD_REPORT_ID
	 * @param jdReport the JD_REPORT_ID value
	 */
	public void setJdReport (com.justonetech.biz.domain.JdReport jdReport) {
		this.jdReport = jdReport;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.JdReportDwgc)) return false;
		else {
			com.justonetech.biz.domain.JdReportDwgc jdReportDwgc = (com.justonetech.biz.domain.JdReportDwgc) obj;
			if (null == this.getId() || null == jdReportDwgc.getId()) return false;
			else return (this.getId().equals(jdReportDwgc.getId()));
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