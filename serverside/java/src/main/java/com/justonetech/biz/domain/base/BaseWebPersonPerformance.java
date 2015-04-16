package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the WEB_PERSON_PERFORMANCE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 人员业绩
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 人员业绩
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : web
 * Projectable : false
 *
 * @hibernate.class
 *  table="WEB_PERSON_PERFORMANCE"
 */

public abstract class BaseWebPersonPerformance  implements Serializable {

	public static String REF = "WebPersonPerformance";
	public static String PROP_UNIT_PERSON_INFO = "unitPersonInfo";
	public static String PROP_PROJECT_SUMMARY = "projectSummary";
	public static String PROP_PROJECT_NAME = "projectName";
	public static String PROP_RESPONSIBILITY = "responsibility";
	public static String PROP_ID = "id";
	public static String PROP_COMPLETE_UNIT_LEVEL = "completeUnitLevel";
	public static String PROP_START_END_TIME = "startEndTime";


	// constructors
	public BaseWebPersonPerformance () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWebPersonPerformance (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*项目名称*/
    /*项目名称*/
	private String projectName;
	
    /*项目规模及技术指标*/
    /*项目规模及技术指标*/
	private String projectSummary;
	
    /*起止时间*/
    /*起止时间*/
	private String startEndTime;
	
    /*项目中作用*/
    /*项目中作用*/
	private String responsibility;
	
    /*完成项目的单位名称和资质等级*/
    /*完成项目的单位名称和资质等级*/
	private String completeUnitLevel;
	

	// many to one
	private com.justonetech.biz.domain.WebUnitPersonInfo unitPersonInfo;



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
	 * Return the value associated with the column: PROJECT_NAME
	 */
	public String getProjectName () {
		return projectName;
	}

	/**
	 * Set the value related to the column: PROJECT_NAME
	 * @param projectName the PROJECT_NAME value
	 */
	public void setProjectName (String projectName) {
		this.projectName = projectName;
	}


	/**
	 * Return the value associated with the column: PROJECT_SUMMARY
	 */
	public String getProjectSummary () {
		return projectSummary;
	}

	/**
	 * Set the value related to the column: PROJECT_SUMMARY
	 * @param projectSummary the PROJECT_SUMMARY value
	 */
	public void setProjectSummary (String projectSummary) {
		this.projectSummary = projectSummary;
	}


	/**
	 * Return the value associated with the column: START_END_TIME
	 */
	public String getStartEndTime () {
		return startEndTime;
	}

	/**
	 * Set the value related to the column: START_END_TIME
	 * @param startEndTime the START_END_TIME value
	 */
	public void setStartEndTime (String startEndTime) {
		this.startEndTime = startEndTime;
	}


	/**
	 * Return the value associated with the column: RESPONSIBILITY
	 */
	public String getResponsibility () {
		return responsibility;
	}

	/**
	 * Set the value related to the column: RESPONSIBILITY
	 * @param responsibility the RESPONSIBILITY value
	 */
	public void setResponsibility (String responsibility) {
		this.responsibility = responsibility;
	}


	/**
	 * Return the value associated with the column: COMPLETE_UNIT_LEVEL
	 */
	public String getCompleteUnitLevel () {
		return completeUnitLevel;
	}

	/**
	 * Set the value related to the column: COMPLETE_UNIT_LEVEL
	 * @param completeUnitLevel the COMPLETE_UNIT_LEVEL value
	 */
	public void setCompleteUnitLevel (String completeUnitLevel) {
		this.completeUnitLevel = completeUnitLevel;
	}


	/**
	 * Return the value associated with the column: UNIT_PERSON_INFO_ID
	 */
	public com.justonetech.biz.domain.WebUnitPersonInfo getUnitPersonInfo () {
		return unitPersonInfo;
	}

	/**
	 * Set the value related to the column: UNIT_PERSON_INFO_ID
	 * @param unitPersonInfo the UNIT_PERSON_INFO_ID value
	 */
	public void setUnitPersonInfo (com.justonetech.biz.domain.WebUnitPersonInfo unitPersonInfo) {
		this.unitPersonInfo = unitPersonInfo;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.WebPersonPerformance)) return false;
		else {
			com.justonetech.biz.domain.WebPersonPerformance webPersonPerformance = (com.justonetech.biz.domain.WebPersonPerformance) obj;
			if (null == this.getId() || null == webPersonPerformance.getId()) return false;
			else return (this.getId().equals(webPersonPerformance.getId()));
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
		builder.append(projectName);
		builder.append(projectSummary);
		builder.append(startEndTime);
		builder.append(responsibility);
		builder.append(completeUnitLevel);
		return builder.toString();
	}


}