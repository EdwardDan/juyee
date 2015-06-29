package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PROJ_BID table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目标段管理
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 项目标段管理
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : project
 * Projectable : false
 *
 * @hibernate.class
 *  table="PROJ_BID"
 */

public abstract class BaseProjBid  implements Serializable,Auditable {

	public static String REF = "ProjBid";
	public static String PROP_PROJECT = "project";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_CODE = "code";
	public static String PROP_NAME = "name";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_START_DATE = "startDate";
	public static String PROP_LINK_TEL = "linkTel";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_BUILD_MILEAGE = "buildMileage";
	public static String PROP_ID = "id";
	public static String PROP_PROJ_LINK = "projLink";
	public static String PROP_UPDATE_USER = "updateUser";
	public static String PROP_TYPE_CODE = "typeCode";


	// constructors
	public BaseProjBid () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProjBid (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*标段编号*/
    /*标段编号*/
	private String code;
	
    /*标段名称*/
    /*标段名称*/
	private String name;

    /*标段类别编码*/
    /*标段类别编码*/
	private String typeCode;

    /*建设里程*/
    /*建设里程*/
	private String buildMileage;
	
    /*项目联系人*/
    /*项目联系人*/
	private String projLink;
	
    /*联系电话*/
    /*联系电话*/
	private String linkTel;
	
    /*开工日期*/
    /*开工日期*/
	private java.sql.Date startDate;
	
    /*创建时间*/
    /*创建时间*/
	private java.sql.Timestamp createTime;
	
    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updateTime;
	
    /*创建人*/
    /*创建人(记录帐号）*/
	private String createUser;
	
    /*更新人*/
    /*更新人(记录帐号）*/
	private String updateUser;
	

	// many to one
	private com.justonetech.biz.domain.ProjInfo project;

	// collections
	private java.util.Set<com.justonetech.biz.domain.DataNodeReport> dataNodeReports;
	private java.util.Set<com.justonetech.biz.domain.DataStageReport> dataStageReports;



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
	 * Return the value associated with the column: CODE
	 */
	public String getCode () {
		return code;
	}

	/**
	 * Set the value related to the column: CODE
	 * @param code the CODE value
	 */
	public void setCode (String code) {
		this.code = code;
	}


	/**
	 * Return the value associated with the column: NAME
	 */
	public String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: NAME
	 * @param name the NAME value
	 */
	public void setName (String name) {
		this.name = name;
	}


	/**
	 * Return the value associated with the column: BUILD_MILEAGE
	 */
	public String getBuildMileage () {
		return buildMileage;
	}

	/**
	 * Set the value related to the column: BUILD_MILEAGE
	 * @param buildMileage the BUILD_MILEAGE value
	 */
	public void setBuildMileage (String buildMileage) {
		this.buildMileage = buildMileage;
	}


	/**
	 * Return the value associated with the column: PROJ_LINK
	 */
	public String getProjLink () {
		return projLink;
	}

	/**
	 * Set the value related to the column: PROJ_LINK
	 * @param projLink the PROJ_LINK value
	 */
	public void setProjLink (String projLink) {
		this.projLink = projLink;
	}


	/**
	 * Return the value associated with the column: LINK_TEL
	 */
	public String getLinkTel () {
		return linkTel;
	}

	/**
	 * Set the value related to the column: LINK_TEL
	 * @param linkTel the LINK_TEL value
	 */
	public void setLinkTel (String linkTel) {
		this.linkTel = linkTel;
	}


	/**
	 * Return the value associated with the column: START_DATE
	 */
	public java.sql.Date getStartDate () {
		return startDate;
	}

	/**
	 * Set the value related to the column: START_DATE
	 * @param startDate the START_DATE value
	 */
	public void setStartDate (java.sql.Date startDate) {
		this.startDate = startDate;
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

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }


	/**
	 * Return the value associated with the column: POJECT_ID
	 */
	public com.justonetech.biz.domain.ProjInfo getProject () {
		return project;
	}

	/**
	 * Set the value related to the column: PROJECT_ID
	 * @param project the PROJECT_ID value
	 */
	public void setProject (com.justonetech.biz.domain.ProjInfo project) {
		this.project = project;
	}


	/**
	 * Return the value associated with the column: dataNodeReports
	 */
	public java.util.Set<com.justonetech.biz.domain.DataNodeReport> getDataNodeReports () {
		return dataNodeReports;
	}

	/**
	 * Set the value related to the column: dataNodeReports
	 * @param dataNodeReports the dataNodeReports value
	 */
	public void setDataNodeReports (java.util.Set<com.justonetech.biz.domain.DataNodeReport> dataNodeReports) {
		this.dataNodeReports = dataNodeReports;
	}


	/**
	 * Return the value associated with the column: dataStageReports
	 */
	public java.util.Set<com.justonetech.biz.domain.DataStageReport> getDataStageReports () {
		return dataStageReports;
	}

	/**
	 * Set the value related to the column: dataStageReports
	 * @param dataStageReports the dataStageReports value
	 */
	public void setDataStageReports (java.util.Set<com.justonetech.biz.domain.DataStageReport> dataStageReports) {
		this.dataStageReports = dataStageReports;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ProjBid)) return false;
		else {
			com.justonetech.biz.domain.ProjBid projBid = (com.justonetech.biz.domain.ProjBid) obj;
			if (null == this.getId() || null == projBid.getId()) return false;
			else return (this.getId().equals(projBid.getId()));
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
		builder.append(code);
		builder.append(name);
		builder.append(typeCode);
		builder.append(buildMileage);
		builder.append(projLink);
		builder.append(linkTel);
		builder.append(startDate);
		builder.append(createTime);
		builder.append(updateTime);
		builder.append(createUser);
		builder.append(updateUser);
		return builder.toString();
	}


}