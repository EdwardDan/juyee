package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHARE_SAFETY_ACCIDENT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 安全事故信息
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 安全事故信息
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : share
 * Projectable : false
 *
 * @hibernate.class
 *  table="SHARE_SAFETY_ACCIDENT"
 */

public abstract class BaseShareSafetyAccident  implements Serializable {

	public static String REF = "ShareSafetyAccident";
	public static String PROP_ACCIDENT_LEVEL_DESC = "accidentLevelDesc";
	public static String PROP_LABOUR_UNIT_NAME = "labourUnitName";
	public static String PROP_ACCOUR_POSITION_DESC = "accourPositionDesc";
	public static String PROP_ACCOUR_RANGE = "accourRange";
	public static String PROP_ACCEPT_UNIT_NAME = "acceptUnitName";
	public static String PROP_BELONG_AREA_DESC = "belongAreaDesc";
	public static String PROP_DIE_NOT_SG_NUM = "dieNotSgNum";
	public static String PROP_ACCIDENT_ANALYSE = "accidentAnalyse";
	public static String PROP_SG_PERMIT_BH = "sgPermitBh";
	public static String PROP_DIE_SG_NUM = "dieSgNum";
	public static String PROP_ACCOUR_RANGE_DESC = "accourRangeDesc";
	public static String PROP_SUBJECT_CB_UNIT_NAME = "subjectCbUnitName";
	public static String PROP_JL_UNIT_NAME = "jlUnitName";
	public static String PROP_ACCIDENT_PRO_TYPE_DESC = "accidentProTypeDesc";
	public static String PROP_WEATHER_CODE_DESC = "weatherCodeDesc";
	public static String PROP_BID_NOTICE_BH = "bidNoticeBh";
	public static String PROP_ACCOUR_POSITION = "accourPosition";
	public static String PROP_INJURE_SG_NUM = "injureSgNum";
	public static String PROP_INJURE_NUM = "injureNum";
	public static String PROP_ACCOUR_DATETIME = "accourDatetime";
	public static String PROP_MONITOR_STATION = "monitorStation";
	public static String PROP_MONITOR_STATION_DESC = "monitorStationDesc";
	public static String PROP_ACCIDENT_PRO_TYPE = "accidentProType";
	public static String PROP_PROJECT_NAME = "projectName";
	public static String PROP_ACCIDENT_LEVEL = "accidentLevel";
	public static String PROP_ACCIDENT_TYPE = "accidentType";
	public static String PROP_CHANGE_DATETIME = "changeDatetime";
	public static String PROP_INJURE_NOT_SG_NUM = "injureNotSgNum";
	public static String PROP_ACCOUR_ADDRESS = "accourAddress";
	public static String PROP_JBR = "jbr";
	public static String PROP_DIE_NUM = "dieNum";
	public static String PROP_ACCEPT_DATE = "acceptDate";
	public static String PROP_BUILD_UNIT_NAME = "buildUnitName";
	public static String PROP_ACCEPT_UNIT_CODE = "acceptUnitCode";
	public static String PROP_WEATHER_CODE = "weatherCode";
	public static String PROP_ID = "id";
	public static String PROP_BELONG_AREA = "belongArea";
	public static String PROP_SG_MAIN_UNIT_NAME = "sgMainUnitName";
	public static String PROP_ACCIDENT_TYPE_DESC = "accidentTypeDesc";


	// constructors
	public BaseShareSafetyAccident () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShareSafetyAccident (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*事故工程分类*/
    /*事故工程分类*/
	private java.lang.Long accidentProType;
	
    /*事故工程分类描述*/
    /*事故工程分类描述*/
	private java.lang.String accidentProTypeDesc;
	
    /*中标通知书编号*/
    /*中标通知书编号*/
	private java.lang.String bidNoticeBh;
	
    /*施工许可证编号*/
    /*施工许可证编号*/
	private java.lang.String sgPermitBh;
	
    /*事故发生时间*/
    /*事故发生时间*/
	private java.sql.Timestamp accourDatetime;
	
    /*事故所在区县*/
    /*事故所在区县*/
	private java.lang.String belongArea;
	
    /*事故所在区县翻译*/
    /*事故所在区县翻译*/
	private java.lang.String belongAreaDesc;
	
    /*事故所辖安监站*/
    /*事故所辖安监站*/
	private java.lang.String monitorStation;
	
    /*事故所辖安监站翻译*/
    /*事故所辖安监站翻译*/
	private java.lang.String monitorStationDesc;
	
    /*事故天气代码*/
    /*事故天气代码*/
	private java.lang.Long weatherCode;
	
    /*事故天气代码描述*/
    /*事故天气代码描述*/
	private java.lang.String weatherCodeDesc;
	
    /*事故发生地点*/
    /*事故发生地点*/
	private java.lang.String accourAddress;
	
    /*事故区域类型*/
    /*事故区域类型*/
	private java.lang.Long accourRange;
	
    /*事故区域类型翻译*/
    /*事故区域类型翻译*/
	private java.lang.String accourRangeDesc;
	
    /*事故发生部位*/
    /*事故发生部位*/
	private java.lang.Long accourPosition;
	
    /*事故发生部位描述*/
    /*事故发生部位描述*/
	private java.lang.String accourPositionDesc;
	
    /*事故类型*/
    /*事故类型*/
	private java.lang.Long accidentType;
	
    /*事故类型翻译*/
    /*事故类型翻译*/
	private java.lang.String accidentTypeDesc;
	
    /*事故级别*/
    /*事故级别*/
	private java.lang.Long accidentLevel;
	
    /*事故级别翻译*/
    /*事故级别翻译*/
	private java.lang.String accidentLevelDesc;
	
    /*事故分析*/
    /*事故分析*/
	private java.lang.String accidentAnalyse;
	
    /*工程名称*/
    /*工程名称*/
	private java.lang.String projectName;
	
    /*死亡总人数*/
    /*死亡总人数*/
	private java.lang.Long dieNum;
	
    /*死亡施工人员人数*/
    /*死亡施工人员人数*/
	private java.lang.Long dieSgNum;
	
    /*死亡非施工人员人数*/
    /*死亡非施工人员人数*/
	private java.lang.Long dieNotSgNum;
	
    /*重伤总人数*/
    /*重伤总人数*/
	private java.lang.Long injureNum;
	
    /*重伤施工人员人数*/
    /*重伤施工人员人数*/
	private java.lang.Long injureSgNum;
	
    /*重伤非施工人员总数*/
    /*重伤非施工人员总数*/
	private java.lang.Long injureNotSgNum;
	
    /*经办人*/
    /*经办人*/
	private java.lang.String jbr;
	
    /*经办人单位代码*/
    /*经办人单位代码*/
	private java.lang.String acceptUnitCode;
	
    /*经办单位名称*/
    /*经办单位名称*/
	private java.lang.String acceptUnitName;
	
    /*经办日期*/
    /*经办日期*/
	private java.sql.Date acceptDate;
	
    /*建设单位名称*/
    /*建设单位名称*/
	private java.lang.String buildUnitName;
	
    /*监理单位名称*/
    /*监理单位名称*/
	private java.lang.String jlUnitName;
	
    /*施工总包单位名称*/
    /*施工总包单位名称*/
	private java.lang.String sgMainUnitName;
	
    /*专业承包单位名称*/
    /*专业承包单位名称*/
	private java.lang.String subjectCbUnitName;
	
    /*劳务分包单位名称*/
    /*劳务分包单位名称*/
	private java.lang.String labourUnitName;
	
    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp changeDatetime;
	



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
	 * Return the value associated with the column: ACCIDENT_PRO_TYPE
	 */
	public java.lang.Long getAccidentProType () {
		return accidentProType;
	}

	/**
	 * Set the value related to the column: ACCIDENT_PRO_TYPE
	 * @param accidentProType the ACCIDENT_PRO_TYPE value
	 */
	public void setAccidentProType (java.lang.Long accidentProType) {
		this.accidentProType = accidentProType;
	}


	/**
	 * Return the value associated with the column: ACCIDENT_PRO_TYPE_DESC
	 */
	public java.lang.String getAccidentProTypeDesc () {
		return accidentProTypeDesc;
	}

	/**
	 * Set the value related to the column: ACCIDENT_PRO_TYPE_DESC
	 * @param accidentProTypeDesc the ACCIDENT_PRO_TYPE_DESC value
	 */
	public void setAccidentProTypeDesc (java.lang.String accidentProTypeDesc) {
		this.accidentProTypeDesc = accidentProTypeDesc;
	}


	/**
	 * Return the value associated with the column: BID_NOTICE_BH
	 */
	public java.lang.String getBidNoticeBh () {
		return bidNoticeBh;
	}

	/**
	 * Set the value related to the column: BID_NOTICE_BH
	 * @param bidNoticeBh the BID_NOTICE_BH value
	 */
	public void setBidNoticeBh (java.lang.String bidNoticeBh) {
		this.bidNoticeBh = bidNoticeBh;
	}


	/**
	 * Return the value associated with the column: SG_PERMIT_BH
	 */
	public java.lang.String getSgPermitBh () {
		return sgPermitBh;
	}

	/**
	 * Set the value related to the column: SG_PERMIT_BH
	 * @param sgPermitBh the SG_PERMIT_BH value
	 */
	public void setSgPermitBh (java.lang.String sgPermitBh) {
		this.sgPermitBh = sgPermitBh;
	}


	/**
	 * Return the value associated with the column: ACCOUR_DATETIME
	 */
	public java.sql.Timestamp getAccourDatetime () {
		return accourDatetime;
	}

	/**
	 * Set the value related to the column: ACCOUR_DATETIME
	 * @param accourDatetime the ACCOUR_DATETIME value
	 */
	public void setAccourDatetime (java.sql.Timestamp accourDatetime) {
		this.accourDatetime = accourDatetime;
	}


	/**
	 * Return the value associated with the column: BELONG_AREA
	 */
	public java.lang.String getBelongArea () {
		return belongArea;
	}

	/**
	 * Set the value related to the column: BELONG_AREA
	 * @param belongArea the BELONG_AREA value
	 */
	public void setBelongArea (java.lang.String belongArea) {
		this.belongArea = belongArea;
	}


	/**
	 * Return the value associated with the column: BELONG_AREA_DESC
	 */
	public java.lang.String getBelongAreaDesc () {
		return belongAreaDesc;
	}

	/**
	 * Set the value related to the column: BELONG_AREA_DESC
	 * @param belongAreaDesc the BELONG_AREA_DESC value
	 */
	public void setBelongAreaDesc (java.lang.String belongAreaDesc) {
		this.belongAreaDesc = belongAreaDesc;
	}


	/**
	 * Return the value associated with the column: MONITOR_STATION
	 */
	public java.lang.String getMonitorStation () {
		return monitorStation;
	}

	/**
	 * Set the value related to the column: MONITOR_STATION
	 * @param monitorStation the MONITOR_STATION value
	 */
	public void setMonitorStation (java.lang.String monitorStation) {
		this.monitorStation = monitorStation;
	}


	/**
	 * Return the value associated with the column: MONITOR_STATION_DESC
	 */
	public java.lang.String getMonitorStationDesc () {
		return monitorStationDesc;
	}

	/**
	 * Set the value related to the column: MONITOR_STATION_DESC
	 * @param monitorStationDesc the MONITOR_STATION_DESC value
	 */
	public void setMonitorStationDesc (java.lang.String monitorStationDesc) {
		this.monitorStationDesc = monitorStationDesc;
	}


	/**
	 * Return the value associated with the column: WEATHER_CODE
	 */
	public java.lang.Long getWeatherCode () {
		return weatherCode;
	}

	/**
	 * Set the value related to the column: WEATHER_CODE
	 * @param weatherCode the WEATHER_CODE value
	 */
	public void setWeatherCode (java.lang.Long weatherCode) {
		this.weatherCode = weatherCode;
	}


	/**
	 * Return the value associated with the column: WEATHER_CODE_DESC
	 */
	public java.lang.String getWeatherCodeDesc () {
		return weatherCodeDesc;
	}

	/**
	 * Set the value related to the column: WEATHER_CODE_DESC
	 * @param weatherCodeDesc the WEATHER_CODE_DESC value
	 */
	public void setWeatherCodeDesc (java.lang.String weatherCodeDesc) {
		this.weatherCodeDesc = weatherCodeDesc;
	}


	/**
	 * Return the value associated with the column: ACCOUR_ADDRESS
	 */
	public java.lang.String getAccourAddress () {
		return accourAddress;
	}

	/**
	 * Set the value related to the column: ACCOUR_ADDRESS
	 * @param accourAddress the ACCOUR_ADDRESS value
	 */
	public void setAccourAddress (java.lang.String accourAddress) {
		this.accourAddress = accourAddress;
	}


	/**
	 * Return the value associated with the column: ACCOUR_RANGE
	 */
	public java.lang.Long getAccourRange () {
		return accourRange;
	}

	/**
	 * Set the value related to the column: ACCOUR_RANGE
	 * @param accourRange the ACCOUR_RANGE value
	 */
	public void setAccourRange (java.lang.Long accourRange) {
		this.accourRange = accourRange;
	}


	/**
	 * Return the value associated with the column: ACCOUR_RANGE_DESC
	 */
	public java.lang.String getAccourRangeDesc () {
		return accourRangeDesc;
	}

	/**
	 * Set the value related to the column: ACCOUR_RANGE_DESC
	 * @param accourRangeDesc the ACCOUR_RANGE_DESC value
	 */
	public void setAccourRangeDesc (java.lang.String accourRangeDesc) {
		this.accourRangeDesc = accourRangeDesc;
	}


	/**
	 * Return the value associated with the column: ACCOUR_POSITION
	 */
	public java.lang.Long getAccourPosition () {
		return accourPosition;
	}

	/**
	 * Set the value related to the column: ACCOUR_POSITION
	 * @param accourPosition the ACCOUR_POSITION value
	 */
	public void setAccourPosition (java.lang.Long accourPosition) {
		this.accourPosition = accourPosition;
	}


	/**
	 * Return the value associated with the column: ACCOUR_POSITION_DESC
	 */
	public java.lang.String getAccourPositionDesc () {
		return accourPositionDesc;
	}

	/**
	 * Set the value related to the column: ACCOUR_POSITION_DESC
	 * @param accourPositionDesc the ACCOUR_POSITION_DESC value
	 */
	public void setAccourPositionDesc (java.lang.String accourPositionDesc) {
		this.accourPositionDesc = accourPositionDesc;
	}


	/**
	 * Return the value associated with the column: ACCIDENT_TYPE
	 */
	public java.lang.Long getAccidentType () {
		return accidentType;
	}

	/**
	 * Set the value related to the column: ACCIDENT_TYPE
	 * @param accidentType the ACCIDENT_TYPE value
	 */
	public void setAccidentType (java.lang.Long accidentType) {
		this.accidentType = accidentType;
	}


	/**
	 * Return the value associated with the column: ACCIDENT_TYPE_DESC
	 */
	public java.lang.String getAccidentTypeDesc () {
		return accidentTypeDesc;
	}

	/**
	 * Set the value related to the column: ACCIDENT_TYPE_DESC
	 * @param accidentTypeDesc the ACCIDENT_TYPE_DESC value
	 */
	public void setAccidentTypeDesc (java.lang.String accidentTypeDesc) {
		this.accidentTypeDesc = accidentTypeDesc;
	}


	/**
	 * Return the value associated with the column: ACCIDENT_LEVEL
	 */
	public java.lang.Long getAccidentLevel () {
		return accidentLevel;
	}

	/**
	 * Set the value related to the column: ACCIDENT_LEVEL
	 * @param accidentLevel the ACCIDENT_LEVEL value
	 */
	public void setAccidentLevel (java.lang.Long accidentLevel) {
		this.accidentLevel = accidentLevel;
	}


	/**
	 * Return the value associated with the column: ACCIDENT_LEVEL_DESC
	 */
	public java.lang.String getAccidentLevelDesc () {
		return accidentLevelDesc;
	}

	/**
	 * Set the value related to the column: ACCIDENT_LEVEL_DESC
	 * @param accidentLevelDesc the ACCIDENT_LEVEL_DESC value
	 */
	public void setAccidentLevelDesc (java.lang.String accidentLevelDesc) {
		this.accidentLevelDesc = accidentLevelDesc;
	}


	/**
	 * Return the value associated with the column: ACCIDENT_ANALYSE
	 */
	public java.lang.String getAccidentAnalyse () {
		return accidentAnalyse;
	}

	/**
	 * Set the value related to the column: ACCIDENT_ANALYSE
	 * @param accidentAnalyse the ACCIDENT_ANALYSE value
	 */
	public void setAccidentAnalyse (java.lang.String accidentAnalyse) {
		this.accidentAnalyse = accidentAnalyse;
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
	 * Return the value associated with the column: DIE_NUM
	 */
	public java.lang.Long getDieNum () {
		return dieNum;
	}

	/**
	 * Set the value related to the column: DIE_NUM
	 * @param dieNum the DIE_NUM value
	 */
	public void setDieNum (java.lang.Long dieNum) {
		this.dieNum = dieNum;
	}


	/**
	 * Return the value associated with the column: DIE_SG_NUM
	 */
	public java.lang.Long getDieSgNum () {
		return dieSgNum;
	}

	/**
	 * Set the value related to the column: DIE_SG_NUM
	 * @param dieSgNum the DIE_SG_NUM value
	 */
	public void setDieSgNum (java.lang.Long dieSgNum) {
		this.dieSgNum = dieSgNum;
	}


	/**
	 * Return the value associated with the column: DIE_NOT_SG_NUM
	 */
	public java.lang.Long getDieNotSgNum () {
		return dieNotSgNum;
	}

	/**
	 * Set the value related to the column: DIE_NOT_SG_NUM
	 * @param dieNotSgNum the DIE_NOT_SG_NUM value
	 */
	public void setDieNotSgNum (java.lang.Long dieNotSgNum) {
		this.dieNotSgNum = dieNotSgNum;
	}


	/**
	 * Return the value associated with the column: INJURE_NUM
	 */
	public java.lang.Long getInjureNum () {
		return injureNum;
	}

	/**
	 * Set the value related to the column: INJURE_NUM
	 * @param injureNum the INJURE_NUM value
	 */
	public void setInjureNum (java.lang.Long injureNum) {
		this.injureNum = injureNum;
	}


	/**
	 * Return the value associated with the column: INJURE_SG_NUM
	 */
	public java.lang.Long getInjureSgNum () {
		return injureSgNum;
	}

	/**
	 * Set the value related to the column: INJURE_SG_NUM
	 * @param injureSgNum the INJURE_SG_NUM value
	 */
	public void setInjureSgNum (java.lang.Long injureSgNum) {
		this.injureSgNum = injureSgNum;
	}


	/**
	 * Return the value associated with the column: INJURE_NOT_SG_NUM
	 */
	public java.lang.Long getInjureNotSgNum () {
		return injureNotSgNum;
	}

	/**
	 * Set the value related to the column: INJURE_NOT_SG_NUM
	 * @param injureNotSgNum the INJURE_NOT_SG_NUM value
	 */
	public void setInjureNotSgNum (java.lang.Long injureNotSgNum) {
		this.injureNotSgNum = injureNotSgNum;
	}


	/**
	 * Return the value associated with the column: JBR
	 */
	public java.lang.String getJbr () {
		return jbr;
	}

	/**
	 * Set the value related to the column: JBR
	 * @param jbr the JBR value
	 */
	public void setJbr (java.lang.String jbr) {
		this.jbr = jbr;
	}


	/**
	 * Return the value associated with the column: ACCEPT_UNIT_CODE
	 */
	public java.lang.String getAcceptUnitCode () {
		return acceptUnitCode;
	}

	/**
	 * Set the value related to the column: ACCEPT_UNIT_CODE
	 * @param acceptUnitCode the ACCEPT_UNIT_CODE value
	 */
	public void setAcceptUnitCode (java.lang.String acceptUnitCode) {
		this.acceptUnitCode = acceptUnitCode;
	}


	/**
	 * Return the value associated with the column: ACCEPT_UNIT_NAME
	 */
	public java.lang.String getAcceptUnitName () {
		return acceptUnitName;
	}

	/**
	 * Set the value related to the column: ACCEPT_UNIT_NAME
	 * @param acceptUnitName the ACCEPT_UNIT_NAME value
	 */
	public void setAcceptUnitName (java.lang.String acceptUnitName) {
		this.acceptUnitName = acceptUnitName;
	}


	/**
	 * Return the value associated with the column: ACCEPT_DATE
	 */
	public java.sql.Date getAcceptDate () {
		return acceptDate;
	}

	/**
	 * Set the value related to the column: ACCEPT_DATE
	 * @param acceptDate the ACCEPT_DATE value
	 */
	public void setAcceptDate (java.sql.Date acceptDate) {
		this.acceptDate = acceptDate;
	}


	/**
	 * Return the value associated with the column: BUILD_UNIT_NAME
	 */
	public java.lang.String getBuildUnitName () {
		return buildUnitName;
	}

	/**
	 * Set the value related to the column: BUILD_UNIT_NAME
	 * @param buildUnitName the BUILD_UNIT_NAME value
	 */
	public void setBuildUnitName (java.lang.String buildUnitName) {
		this.buildUnitName = buildUnitName;
	}


	/**
	 * Return the value associated with the column: JL_UNIT_NAME
	 */
	public java.lang.String getJlUnitName () {
		return jlUnitName;
	}

	/**
	 * Set the value related to the column: JL_UNIT_NAME
	 * @param jlUnitName the JL_UNIT_NAME value
	 */
	public void setJlUnitName (java.lang.String jlUnitName) {
		this.jlUnitName = jlUnitName;
	}


	/**
	 * Return the value associated with the column: SG_MAIN_UNIT_NAME
	 */
	public java.lang.String getSgMainUnitName () {
		return sgMainUnitName;
	}

	/**
	 * Set the value related to the column: SG_MAIN_UNIT_NAME
	 * @param sgMainUnitName the SG_MAIN_UNIT_NAME value
	 */
	public void setSgMainUnitName (java.lang.String sgMainUnitName) {
		this.sgMainUnitName = sgMainUnitName;
	}


	/**
	 * Return the value associated with the column: SUBJECT_CB_UNIT_NAME
	 */
	public java.lang.String getSubjectCbUnitName () {
		return subjectCbUnitName;
	}

	/**
	 * Set the value related to the column: SUBJECT_CB_UNIT_NAME
	 * @param subjectCbUnitName the SUBJECT_CB_UNIT_NAME value
	 */
	public void setSubjectCbUnitName (java.lang.String subjectCbUnitName) {
		this.subjectCbUnitName = subjectCbUnitName;
	}


	/**
	 * Return the value associated with the column: LABOUR_UNIT_NAME
	 */
	public java.lang.String getLabourUnitName () {
		return labourUnitName;
	}

	/**
	 * Set the value related to the column: LABOUR_UNIT_NAME
	 * @param labourUnitName the LABOUR_UNIT_NAME value
	 */
	public void setLabourUnitName (java.lang.String labourUnitName) {
		this.labourUnitName = labourUnitName;
	}


	/**
	 * Return the value associated with the column: CHANGE_DATETIME
	 */
	public java.sql.Timestamp getChangeDatetime () {
		return changeDatetime;
	}

	/**
	 * Set the value related to the column: CHANGE_DATETIME
	 * @param changeDatetime the CHANGE_DATETIME value
	 */
	public void setChangeDatetime (java.sql.Timestamp changeDatetime) {
		this.changeDatetime = changeDatetime;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ShareSafetyAccident)) return false;
		else {
			com.justonetech.biz.domain.ShareSafetyAccident shareSafetyAccident = (com.justonetech.biz.domain.ShareSafetyAccident) obj;
			if (null == this.getId() || null == shareSafetyAccident.getId()) return false;
			else return (this.getId().equals(shareSafetyAccident.getId()));
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
		builder.append(accidentProType);
		builder.append(accidentProTypeDesc);
		builder.append(bidNoticeBh);
		builder.append(sgPermitBh);
		builder.append(accourDatetime);
		builder.append(belongArea);
		builder.append(belongAreaDesc);
		builder.append(monitorStation);
		builder.append(monitorStationDesc);
		builder.append(weatherCode);
		builder.append(weatherCodeDesc);
		builder.append(accourAddress);
		builder.append(accourRange);
		builder.append(accourRangeDesc);
		builder.append(accourPosition);
		builder.append(accourPositionDesc);
		builder.append(accidentType);
		builder.append(accidentTypeDesc);
		builder.append(accidentLevel);
		builder.append(accidentLevelDesc);
		builder.append(accidentAnalyse);
		builder.append(projectName);
		builder.append(dieNum);
		builder.append(dieSgNum);
		builder.append(dieNotSgNum);
		builder.append(injureNum);
		builder.append(injureSgNum);
		builder.append(injureNotSgNum);
		builder.append(jbr);
		builder.append(acceptUnitCode);
		builder.append(acceptUnitName);
		builder.append(acceptDate);
		builder.append(buildUnitName);
		builder.append(jlUnitName);
		builder.append(sgMainUnitName);
		builder.append(subjectCbUnitName);
		builder.append(labourUnitName);
		builder.append(changeDatetime);
		return builder.toString();
	}


}