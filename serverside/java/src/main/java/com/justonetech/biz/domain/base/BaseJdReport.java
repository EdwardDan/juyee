package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the JD_REPORT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 监督报告
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 监督报告
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : report
 * Projectable : false
 *
 * @hibernate.class
 *  table="JD_REPORT"
 */

public abstract class BaseJdReport  implements Serializable {

	public static String REF = "JdReport";
	public static String PROP_REPORT_TYPE = "reportType";
	public static String PROP_PROJECT_NAME = "projectName";
	public static String PROP_PRINT_USER = "printUser";
	public static String PROP_REPORT_DATE = "reportDate";
	public static String PROP_BJBH = "bjbh";
	public static String PROP_FLOW_CODE = "flowCode";
	public static String PROP_BUILD_UNIT = "buildUnit";
	public static String PROP_ID = "id";
	public static String PROP_PRINT_REPORT = "printReport";
	public static String PROP_PRINT_DATETIME = "printDatetime";
    public static String PROP_REPORT_PERSON = "reportPerson";
    public static String PROP_REPORT_TYPE_DESC = "reportTypeDesc";
    public static String PROP_JD_TASK_CODE = "jdTaskCode";


	// constructors
	public BaseJdReport () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseJdReport (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
        /*监督任务书编号*/
    /*监督任务书编号*/
    private String jdTaskCode;
    /*报告类型中文描述*/
    /*报告类型中文描述*/
    private String reportTypeDesc;

    /*监督报告编制人*/
    /*监督报告编制人*/
    private java.lang.String reportPerson;

    /*报建编号*/
    /*报建编号*/
	private java.lang.String bjbh;

    /*建设单位*/
    /*建设单位*/
	private java.lang.String buildUnit;

    /*工程名称(取监督任务书中的名称）*/
    /*工程名称(取监督任务书中的名称）*/
	private java.lang.String projectName;

    /*监督报告日期*/
    /*监督报告日期*/
	private java.sql.Date reportDate;

    /*打印内容*/
    /*打印内容*/
	private java.lang.String printReport;

    /*打印时间*/
    /*打印时间*/
	private java.sql.Timestamp printDatetime;


	// many to one
	private com.justonetech.system.domain.SysCodeDetail reportType;
	private com.justonetech.system.domain.SysUser printUser;

	// collections
	private java.util.Set<com.justonetech.biz.domain.JdReportDwgc> jdReportDwgcs;



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
     * Return the value associated with the column: JD_TASK_CODE
     */
    public String getJdTaskCode () {
        return jdTaskCode;
    }

    /**
     * Set the value related to the column: JD_TASK_CODE
     * @param jdTaskCode the JD_TASK_CODE value
     */
    public void setJdTaskCode (String jdTaskCode) {
        this.jdTaskCode = jdTaskCode;
    }

    /**
     * Return the value associated with the column: REPORT_TYPE_DESC
     */
    public String getReportTypeDesc () {
        return reportTypeDesc;
    }

    /**
     * Set the value related to the column: REPORT_TYPE_DESC
     * @param reportTypeDesc the REPORT_TYPE_DESC value
     */
    public void setReportTypeDesc (String reportTypeDesc) {
        this.reportTypeDesc = reportTypeDesc;
    }

    /**
     * Return the value associated with the column: REPORT_PERSON
     */
    public java.lang.String getReportPerson () {
        return reportPerson;
    }

    /**
     * Set the value related to the column: REPORT_PERSON
     * @param reportPerson the REPORT_PERSON value
     */
    public void setReportPerson (java.lang.String reportPerson) {
        this.reportPerson = reportPerson;
    }


	/**
	 * Return the value associated with the column: BJBH
	 */
	public java.lang.String getBjbh () {
		return bjbh;
	}

	/**
	 * Set the value related to the column: BJBH
	 * @param bjbh the BJBH value
	 */
	public void setBjbh (java.lang.String bjbh) {
		this.bjbh = bjbh;
	}


	/**
	 * Return the value associated with the column: BUILD_UNIT
	 */
	public java.lang.String getBuildUnit () {
		return buildUnit;
	}

	/**
	 * Set the value related to the column: BUILD_UNIT
	 * @param buildUnit the BUILD_UNIT value
	 */
	public void setBuildUnit (java.lang.String buildUnit) {
		this.buildUnit = buildUnit;
	}


	/**
	 * Return the value associated with the column: PROJECT_NAME
	 */
	public java.lang.String getProjectName () {
		return projectName;
	}

	/**
	 * Set the value related to the column: PROJECT_NAME
	 * @param projectName the PROJECT_NAME value
	 */
	public void setProjectName (java.lang.String projectName) {
		this.projectName = projectName;
	}


	/**
	 * Return the value associated with the column: REPORT_DATE
	 */
	public java.sql.Date getReportDate () {
		return reportDate;
	}

	/**
	 * Set the value related to the column: REPORT_DATE
	 * @param reportDate the REPORT_DATE value
	 */
	public void setReportDate (java.sql.Date reportDate) {
		this.reportDate = reportDate;
	}


	/**
	 * Return the value associated with the column: PRINT_REPORT
	 */
	public java.lang.String getPrintReport () {
		return printReport;
	}

	/**
	 * Set the value related to the column: PRINT_REPORT
	 * @param printReport the PRINT_REPORT value
	 */
	public void setPrintReport (java.lang.String printReport) {
		this.printReport = printReport;
	}


	/**
	 * Return the value associated with the column: PRINT_DATETIME
	 */
	public java.sql.Timestamp getPrintDatetime () {
		return printDatetime;
	}

	/**
	 * Set the value related to the column: PRINT_DATETIME
	 * @param printDatetime the PRINT_DATETIME value
	 */
	public void setPrintDatetime (java.sql.Timestamp printDatetime) {
		this.printDatetime = printDatetime;
	}


	/**
	 * Return the value associated with the column: REPORT_TYPE
	 */
	public com.justonetech.system.domain.SysCodeDetail getReportType () {
		return reportType;
	}

	/**
	 * Set the value related to the column: REPORT_TYPE
	 * @param reportType the REPORT_TYPE value
	 */
	public void setReportType (com.justonetech.system.domain.SysCodeDetail reportType) {
		this.reportType = reportType;
	}


	/**
	 * Return the value associated with the column: PRINT_USER_ID
	 */
	public com.justonetech.system.domain.SysUser getPrintUser () {
		return printUser;
	}

	/**
	 * Set the value related to the column: PRINT_USER_ID
	 * @param printUser the PRINT_USER_ID value
	 */
	public void setPrintUser (com.justonetech.system.domain.SysUser printUser) {
		this.printUser = printUser;
	}


	/**
	 * Return the value associated with the column: jdReportDwgcs
	 */
	public java.util.Set<com.justonetech.biz.domain.JdReportDwgc> getJdReportDwgcs () {
		if(jdReportDwgcs == null){
			jdReportDwgcs = new java.util.LinkedHashSet<com.justonetech.biz.domain.JdReportDwgc>();
		}
		return jdReportDwgcs;
	}

	/**
	 * Set the value related to the column: jdReportDwgcs
	 * @param jdReportDwgcs the jdReportDwgcs value
	 */
	public void setJdReportDwgcs (java.util.Set<com.justonetech.biz.domain.JdReportDwgc> jdReportDwgcs) {
		this.jdReportDwgcs = jdReportDwgcs;
	}

	public void addTojdReportDwgcs (com.justonetech.biz.domain.JdReportDwgc jdReportDwgc) {
		if (null == getJdReportDwgcs()) setJdReportDwgcs(new java.util.LinkedHashSet<com.justonetech.biz.domain.JdReportDwgc>());
		getJdReportDwgcs().add(jdReportDwgc);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.JdReport)) return false;
		else {
			com.justonetech.biz.domain.JdReport jdReport = (com.justonetech.biz.domain.JdReport) obj;
			if (null == this.getId() || null == jdReport.getId()) return false;
			else return (this.getId().equals(jdReport.getId()));
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
        builder.append(jdTaskCode);
        builder.append(reportTypeDesc);
		builder.append(bjbh);
		builder.append(buildUnit);
		builder.append(projectName);
        builder.append(reportPerson);
		builder.append(reportDate);
		builder.append(printReport);
		builder.append(printDatetime);
		return builder.toString();
	}


}