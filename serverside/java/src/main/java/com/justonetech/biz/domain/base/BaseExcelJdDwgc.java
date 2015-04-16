package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the EXCEL_JD_DWGC table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : Excel监督单位工程
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : Excel监督单位工程
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : syn
 * Projectable : false
 *
 * @hibernate.class
 *  table="EXCEL_JD_DWGC"
 */

public abstract class BaseExcelJdDwgc  implements Serializable {

	public static String REF = "ExcelJdDwgc";
	public static String PROP_TS = "ts";
	public static String PROP_DWGC_NAME = "dwgcName";
	public static String PROP_DWGC_MONEY = "dwgcMoney";
	public static String PROP_UP_CS = "upCs";
	public static String PROP_DWGC_AREA = "dwgcArea";
	public static String PROP_CUSTOM_CODE = "customCode";
	public static String PROP_DWGC_CODE = "dwgcCode";
	public static String PROP_PROJECT_TYPE = "projectType";
	public static String PROP_FLOW_CODE = "flowCode";
	public static String PROP_JD_TASK_CODE = "jdTaskCode";
	public static String PROP_ID = "id";
	public static String PROP_STRUCT_TYPE = "structType";
	public static String PROP_SYN_DATETIME = "synDatetime";
	public static String PROP_PRO_SCHEDULE = "proSchedule";
	public static String PROP_CHANGETIME = "changetime";
	public static String PROP_DOWN_CS = "downCs";


	// constructors
	public BaseExcelJdDwgc () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseExcelJdDwgc (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*流转编号*/
    /*流转编号*/
	private String flowCode;
	
    /*监督任务书编号*/
    /*监督任务书编号*/
	private String jdTaskCode;
	
    /*单位工程编号*/
    /*单位工程编号*/
	private String dwgcCode;
	
    /*自定义单位工程编号*/
    /*自定义单位工程编号*/
	private String customCode;
	
    /*单位工程名称*/
    /*单位工程名称*/
	private String dwgcName;
	
    /*工程类型*/
    /*工程类型*/
	private String projectType;
	
    /*结构类型*/
    /*结构类型*/
	private String structType;
	
    /*建筑面积*/
    /*建筑面积*/
	private Double dwgcArea;
	
    /*工程造价*/
    /*工程造价*/
	private Double dwgcMoney;
	
    /*地上层数*/
    /*地上层数*/
	private String upCs;
	
    /*地下层数*/
    /*地下层数*/
	private String downCs;
	
    /*台数*/
    /*台数*/
	private String ts;
	
    /*工程进度*/
    /*工程进度*/
	private String proSchedule;
	
    /*变化时间*/
    /*变化时间*/
	private java.sql.Timestamp changetime;
	
    /*同步日期*/
    /*同步日期*/
	private java.sql.Timestamp synDatetime;
	



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
	 * Return the value associated with the column: FLOW_CODE
	 */
	public String getFlowCode () {
		return flowCode;
	}

	/**
	 * Set the value related to the column: FLOW_CODE
	 * @param flowCode the FLOW_CODE value
	 */
	public void setFlowCode (String flowCode) {
		this.flowCode = flowCode;
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
	 * Return the value associated with the column: DWGC_CODE
	 */
	public String getDwgcCode () {
		return dwgcCode;
	}

	/**
	 * Set the value related to the column: DWGC_CODE
	 * @param dwgcCode the DWGC_CODE value
	 */
	public void setDwgcCode (String dwgcCode) {
		this.dwgcCode = dwgcCode;
	}


	/**
	 * Return the value associated with the column: CUSTOM_CODE
	 */
	public String getCustomCode () {
		return customCode;
	}

	/**
	 * Set the value related to the column: CUSTOM_CODE
	 * @param customCode the CUSTOM_CODE value
	 */
	public void setCustomCode (String customCode) {
		this.customCode = customCode;
	}


	/**
	 * Return the value associated with the column: DWGC_NAME
	 */
	public String getDwgcName () {
		return dwgcName;
	}

	/**
	 * Set the value related to the column: DWGC_NAME
	 * @param dwgcName the DWGC_NAME value
	 */
	public void setDwgcName (String dwgcName) {
		this.dwgcName = dwgcName;
	}


	/**
	 * Return the value associated with the column: PROJECT_TYPE
	 */
	public String getProjectType () {
		return projectType;
	}

	/**
	 * Set the value related to the column: PROJECT_TYPE
	 * @param projectType the PROJECT_TYPE value
	 */
	public void setProjectType (String projectType) {
		this.projectType = projectType;
	}


	/**
	 * Return the value associated with the column: STRUCT_TYPE
	 */
	public String getStructType () {
		return structType;
	}

	/**
	 * Set the value related to the column: STRUCT_TYPE
	 * @param structType the STRUCT_TYPE value
	 */
	public void setStructType (String structType) {
		this.structType = structType;
	}


	/**
	 * Return the value associated with the column: DWGC_AREA
	 */
	public Double getDwgcArea () {
		return dwgcArea;
	}

	/**
	 * Set the value related to the column: DWGC_AREA
	 * @param dwgcArea the DWGC_AREA value
	 */
	public void setDwgcArea (Double dwgcArea) {
		this.dwgcArea = dwgcArea;
	}


	/**
	 * Return the value associated with the column: DWGC_MONEY
	 */
	public Double getDwgcMoney () {
		return dwgcMoney;
	}

	/**
	 * Set the value related to the column: DWGC_MONEY
	 * @param dwgcMoney the DWGC_MONEY value
	 */
	public void setDwgcMoney (Double dwgcMoney) {
		this.dwgcMoney = dwgcMoney;
	}


	/**
	 * Return the value associated with the column: UP_CS
	 */
	public String getUpCs () {
		return upCs;
	}

	/**
	 * Set the value related to the column: UP_CS
	 * @param upCs the UP_CS value
	 */
	public void setUpCs (String upCs) {
		this.upCs = upCs;
	}


	/**
	 * Return the value associated with the column: DOWN_CS
	 */
	public String getDownCs () {
		return downCs;
	}

	/**
	 * Set the value related to the column: DOWN_CS
	 * @param downCs the DOWN_CS value
	 */
	public void setDownCs (String downCs) {
		this.downCs = downCs;
	}


	/**
	 * Return the value associated with the column: TS
	 */
	public String getTs () {
		return ts;
	}

	/**
	 * Set the value related to the column: TS
	 * @param ts the TS value
	 */
	public void setTs (String ts) {
		this.ts = ts;
	}


	/**
	 * Return the value associated with the column: PRO_SCHEDULE
	 */
	public String getProSchedule () {
		return proSchedule;
	}

	/**
	 * Set the value related to the column: PRO_SCHEDULE
	 * @param proSchedule the PRO_SCHEDULE value
	 */
	public void setProSchedule (String proSchedule) {
		this.proSchedule = proSchedule;
	}


	/**
	 * Return the value associated with the column: CHANGETIME
	 */
	public java.sql.Timestamp getChangetime () {
		return changetime;
	}

	/**
	 * Set the value related to the column: CHANGETIME
	 * @param changetime the CHANGETIME value
	 */
	public void setChangetime (java.sql.Timestamp changetime) {
		this.changetime = changetime;
	}


	/**
	 * Return the value associated with the column: SYN_DATETIME
	 */
	public java.sql.Timestamp getSynDatetime () {
		return synDatetime;
	}

	/**
	 * Set the value related to the column: SYN_DATETIME
	 * @param synDatetime the SYN_DATETIME value
	 */
	public void setSynDatetime (java.sql.Timestamp synDatetime) {
		this.synDatetime = synDatetime;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ExcelJdDwgc)) return false;
		else {
			com.justonetech.biz.domain.ExcelJdDwgc excelJdDwgc = (com.justonetech.biz.domain.ExcelJdDwgc) obj;
			if (null == this.getId() || null == excelJdDwgc.getId()) return false;
			else return (this.getId().equals(excelJdDwgc.getId()));
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
		builder.append(flowCode);
		builder.append(jdTaskCode);
		builder.append(dwgcCode);
		builder.append(customCode);
		builder.append(dwgcName);
		builder.append(projectType);
		builder.append(structType);
		builder.append(dwgcArea);
		builder.append(dwgcMoney);
		builder.append(upCs);
		builder.append(downCs);
		builder.append(ts);
		builder.append(proSchedule);
		builder.append(changetime);
		builder.append(synDatetime);
		return builder.toString();
	}


}