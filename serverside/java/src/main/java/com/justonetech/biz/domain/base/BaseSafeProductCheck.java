package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SAFE_PRODUCT_CHECK table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 安全生产季度考核
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 安全生产季度考核
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : safe
 * Projectable : false
 *
 * @hibernate.class
 *  table="SAFE_PRODUCT_CHECK"
 */

public abstract class BaseSafeProductCheck  implements Serializable, Auditable {

	public static String REF = "SafeProductCheck";
	public static String PROP_JLDWMC = "jldwmc";
	public static String PROP_STOPFORM_NUM = "stopformNum";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_PROJECT_NAME = "projectName";
	public static String PROP_QUARTER = "quarter";
	public static String PROP_PLAN_CHECK_NUM = "planCheckNum";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_SGDWMC = "sgdwmc";
	public static String PROP_TOTAL_SCORE = "totalScore";
	public static String PROP_ACTUAL_CHECK_NUM = "actualCheckNum";
	public static String PROP_GD_CODE = "gdCode";
	public static String PROP_STATUS = "status";
	public static String PROP_YEAR = "year";
	public static String PROP_OTHER_NUM = "otherNum";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_LEVEL_ID = "levelId";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_LEVEL_DESC = "levelDesc";
	public static String PROP_ID = "id";
	public static String PROP_PUNISH_NUM = "punishNum";
	public static String PROP_CONTENT = "content";
	public static String PROP_REFORM_NUM = "reformNum";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseSafeProductCheck () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSafeProductCheck (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*工地编号*/
    /*工地编号*/
	private String gdCode;
	
    /*项目名称*/
    /*项目名称*/
	private String projectName;
	
    /*施工单位*/
    /*施工单位*/
	private String sgdwmc;
	
    /*监理单位*/
    /*监理单位*/
	private String jldwmc;
	
    /*年份*/
    /*年份*/
	private Integer year;
	
    /*季度*/
    /*季度*/
	private Integer quarter;
	
    /*总分*/
    /*总分*/
	private Integer totalScore;
	
    /*情况说明*/
    /*情况说明*/
	private String content;
	
    /*整改单数量*/
    /*整改单数量*/
	private Integer reformNum;
	
    /*暂缓单数量*/
    /*暂缓单数量*/
	private Integer stopformNum;
	
    /*处罚数量*/
    /*处罚数量*/
	private Integer punishNum;
	
    /*其他数量*/
    /*其他数量*/
	private Integer otherNum;
	
    /*确认等级中文描述*/
    /*确认等级中文描述*/
	private String levelDesc;
	
    /*企业应到现场检查次数*/
    /*企业应到现场检查次数*/
	private Integer planCheckNum;
	
    /*企业实到现场检查次数*/
    /*企业实到现场检查次数*/
	private Integer actualCheckNum;
	
    /*状态*/
    /*状态*/
	private Integer status;
	
    /*备注*/
    /*备注*/
	private String description;
	
    /*创建时间*/
    /*创建时间*/
	private java.sql.Timestamp createTime;
	
    /*创建用户名*/
    /*创建用户名*/
	private String createUser;
	
    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updateTime;
	
    /*更新用户名*/
    /*更新用户名*/
	private String updateUser;
	

	// many to one
	private com.justonetech.system.domain.SysCodeDetail levelId;

	// collections
	private java.util.Set<com.justonetech.biz.domain.SafeProductCheckItem> safeProductCheckItems;

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
	 * Return the value associated with the column: GD_CODE
	 */
	public String getGdCode () {
		return gdCode;
	}

	/**
	 * Set the value related to the column: GD_CODE
	 * @param gdCode the GD_CODE value
	 */
	public void setGdCode (String gdCode) {
		this.gdCode = gdCode;
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
	 * Return the value associated with the column: SGDWMC
	 */
	public String getSgdwmc () {
		return sgdwmc;
	}

	/**
	 * Set the value related to the column: SGDWMC
	 * @param sgdwmc the SGDWMC value
	 */
	public void setSgdwmc (String sgdwmc) {
		this.sgdwmc = sgdwmc;
	}


	/**
	 * Return the value associated with the column: JLDWMC
	 */
	public String getJldwmc () {
		return jldwmc;
	}

	/**
	 * Set the value related to the column: JLDWMC
	 * @param jldwmc the JLDWMC value
	 */
	public void setJldwmc (String jldwmc) {
		this.jldwmc = jldwmc;
	}


	/**
	 * Return the value associated with the column: YEAR
	 */
	public Integer getYear () {
		return year;
	}

	/**
	 * Set the value related to the column: YEAR
	 * @param year the YEAR value
	 */
	public void setYear (Integer year) {
		this.year = year;
	}


	/**
	 * Return the value associated with the column: QUARTER
	 */
	public Integer getQuarter () {
		return quarter;
	}

	/**
	 * Set the value related to the column: QUARTER
	 * @param quarter the QUARTER value
	 */
	public void setQuarter (Integer quarter) {
		this.quarter = quarter;
	}


	/**
	 * Return the value associated with the column: TOTAL_SCORE
	 */
	public Integer getTotalScore () {
		return totalScore;
	}

	/**
	 * Set the value related to the column: TOTAL_SCORE
	 * @param totalScore the TOTAL_SCORE value
	 */
	public void setTotalScore (Integer totalScore) {
		this.totalScore = totalScore;
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
	 * Return the value associated with the column: REFORM_NUM
	 */
	public Integer getReformNum () {
		return reformNum;
	}

	/**
	 * Set the value related to the column: REFORM_NUM
	 * @param reformNum the REFORM_NUM value
	 */
	public void setReformNum (Integer reformNum) {
		this.reformNum = reformNum;
	}


	/**
	 * Return the value associated with the column: STOPFORM_NUM
	 */
	public Integer getStopformNum () {
		return stopformNum;
	}

	/**
	 * Set the value related to the column: STOPFORM_NUM
	 * @param stopformNum the STOPFORM_NUM value
	 */
	public void setStopformNum (Integer stopformNum) {
		this.stopformNum = stopformNum;
	}


	/**
	 * Return the value associated with the column: PUNISH_NUM
	 */
	public Integer getPunishNum () {
		return punishNum;
	}

	/**
	 * Set the value related to the column: PUNISH_NUM
	 * @param punishNum the PUNISH_NUM value
	 */
	public void setPunishNum (Integer punishNum) {
		this.punishNum = punishNum;
	}


	/**
	 * Return the value associated with the column: OTHER_NUM
	 */
	public Integer getOtherNum () {
		return otherNum;
	}

	/**
	 * Set the value related to the column: OTHER_NUM
	 * @param otherNum the OTHER_NUM value
	 */
	public void setOtherNum (Integer otherNum) {
		this.otherNum = otherNum;
	}


	/**
	 * Return the value associated with the column: LEVEL_DESC
	 */
	public String getLevelDesc () {
		return levelDesc;
	}

	/**
	 * Set the value related to the column: LEVEL_DESC
	 * @param levelDesc the LEVEL_DESC value
	 */
	public void setLevelDesc (String levelDesc) {
		this.levelDesc = levelDesc;
	}


	/**
	 * Return the value associated with the column: PLAN_CHECK_NUM
	 */
	public Integer getPlanCheckNum () {
		return planCheckNum;
	}

	/**
	 * Set the value related to the column: PLAN_CHECK_NUM
	 * @param planCheckNum the PLAN_CHECK_NUM value
	 */
	public void setPlanCheckNum (Integer planCheckNum) {
		this.planCheckNum = planCheckNum;
	}


	/**
	 * Return the value associated with the column: ACTUAL_CHECK_NUM
	 */
	public Integer getActualCheckNum () {
		return actualCheckNum;
	}

	/**
	 * Set the value related to the column: ACTUAL_CHECK_NUM
	 * @param actualCheckNum the ACTUAL_CHECK_NUM value
	 */
	public void setActualCheckNum (Integer actualCheckNum) {
		this.actualCheckNum = actualCheckNum;
	}


	/**
	 * Return the value associated with the column: STATUS
	 */
	public Integer getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (Integer status) {
		this.status = status;
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
	 * Return the value associated with the column: CREATE_TIME
	 */
	public java.sql.Timestamp getCreateTime () {
		return createTime;
	}

	/**
	 * Set the value related to the column: CREATE_TIME
	 * @param createTime the CREATE_TIME value
	 */
	public void setCreateTime (java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}


	/**
	 * Return the value associated with the column: CREATE_USER
	 */
	public String getCreateUser () {
		return createUser;
	}

	/**
	 * Set the value related to the column: CREATE_USER
	 * @param createUser the CREATE_USER value
	 */
	public void setCreateUser (String createUser) {
		this.createUser = createUser;
	}


	/**
	 * Return the value associated with the column: UPDATE_TIME
	 */
	public java.sql.Timestamp getUpdateTime () {
		return updateTime;
	}

	/**
	 * Set the value related to the column: UPDATE_TIME
	 * @param updateTime the UPDATE_TIME value
	 */
	public void setUpdateTime (java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}


	/**
	 * Return the value associated with the column: UPDATE_USER
	 */
	public String getUpdateUser () {
		return updateUser;
	}

	/**
	 * Set the value related to the column: UPDATE_USER
	 * @param updateUser the UPDATE_USER value
	 */
	public void setUpdateUser (String updateUser) {
		this.updateUser = updateUser;
	}


	/**
	 * Return the value associated with the column: LEVEL_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getLevelId () {
		return levelId;
	}

	/**
	 * Set the value related to the column: LEVEL_ID
	 * @param levelId the LEVEL_ID value
	 */
	public void setLevelId (com.justonetech.system.domain.SysCodeDetail levelId) {
		this.levelId = levelId;
	}


	/**
	 * Return the value associated with the column: safeProductCheckItems
	 */
	public java.util.Set<com.justonetech.biz.domain.SafeProductCheckItem> getSafeProductCheckItems () {
		if(safeProductCheckItems == null){
			safeProductCheckItems = new java.util.LinkedHashSet<com.justonetech.biz.domain.SafeProductCheckItem>();
		}
		return safeProductCheckItems;
	}

	/**
	 * Set the value related to the column: safeProductCheckItems
	 * @param safeProductCheckItems the safeProductCheckItems value
	 */
	public void setSafeProductCheckItems (java.util.Set<com.justonetech.biz.domain.SafeProductCheckItem> safeProductCheckItems) {
		this.safeProductCheckItems = safeProductCheckItems;
	}

	public void addTosafeProductCheckItems (com.justonetech.biz.domain.SafeProductCheckItem safeProductCheckItem) {
		if (null == getSafeProductCheckItems()) setSafeProductCheckItems(new java.util.LinkedHashSet<com.justonetech.biz.domain.SafeProductCheckItem>());
		getSafeProductCheckItems().add(safeProductCheckItem);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.SafeProductCheck)) return false;
		else {
			com.justonetech.biz.domain.SafeProductCheck safeProductCheck = (com.justonetech.biz.domain.SafeProductCheck) obj;
			if (null == this.getId() || null == safeProductCheck.getId()) return false;
			else return (this.getId().equals(safeProductCheck.getId()));
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
		builder.append(gdCode);
		builder.append(projectName);
		builder.append(sgdwmc);
		builder.append(jldwmc);
		builder.append(year);
		builder.append(quarter);
		builder.append(totalScore);
		builder.append(content);
		builder.append(reformNum);
		builder.append(stopformNum);
		builder.append(punishNum);
		builder.append(otherNum);
		builder.append(levelDesc);
		builder.append(planCheckNum);
		builder.append(actualCheckNum);
		builder.append(status);
		builder.append(description);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}