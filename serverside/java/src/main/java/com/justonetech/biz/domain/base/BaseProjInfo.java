package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PROJ_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目基本信息管理
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 项目基本信息管理
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : project
 * Projectable : false
 *
 * @hibernate.class
 *  table="PROJ_INFO"
 */

public abstract class BaseProjInfo  implements Serializable,Auditable {

	public static String REF = "ProjInfo";
	public static String PROP_SG_DEPT_PERSON = "sgDeptPerson";
	public static String PROP_SG_DEPT = "sgDept";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_LOCATION = "location";
	public static String PROP_PROPERTY = "property";
	public static String PROP_NO = "no";
	public static String PROP_JS_DEPT = "jsDept";
	public static String PROP_NAME = "name";
	public static String PROP_YEAR = "year";
	public static String PROP_CATEGORY = "category";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_JL_DEPT_TEL = "jlDeptTel";
	public static String PROP_JL_DEPT = "jlDept";
	public static String PROP_START_DATE = "startDate";
	public static String PROP_JL_DEPT_PERSON = "jlDeptPerson";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_BUILD_MILEAGE = "buildMileage";
	public static String PROP_ID = "id";
	public static String PROP_BELONG_AREA = "belongArea";
	public static String PROP_INTRO = "intro";
	public static String PROP_STAGE = "stage";
	public static String PROP_SG_DEPT_TEL = "sgDeptTel";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseProjInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProjInfo (Long id) {
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
	private String name;
	
    /*年份*/
    /*年份*/
	private Integer year;
	
    /*项目序号*/
    /*项目序号*/
	private Integer no;
	
    /*建设里程*/
    /*建设里程*/
	private String buildMileage;
	
    /*起讫地点*/
    /*起讫地点*/
	private String location;
	
    /*开工日期*/
    /*开工日期*/
	private java.sql.Date startDate;
	
    /*工程简介*/
    /*工程简介*/
	private String intro;
	
    /*建设单位*/
    /*建设单位*/
	private String jsDept;
	
    /*施工单位*/
    /*施工单位*/
	private String sgDept;
	
    /*施工单位联系人*/
    /*施工单位联系人*/
	private String sgDeptPerson;
	
    /*施工单位联系电话*/
    /*施工单位联系电话*/
	private String sgDeptTel;
	
    /*监理单位*/
    /*监理单位*/
	private String jlDept;
	
    /*监理单位联系人*/
    /*监理单位联系人*/
	private String jlDeptPerson;
	
    /*监理单位联系电话*/
    /*监理单位联系电话*/
	private String jlDeptTel;
	
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
	private com.justonetech.system.domain.SysCodeDetail property;
	private com.justonetech.system.domain.SysCodeDetail stage;
	private com.justonetech.system.domain.SysCodeDetail category;
	private com.justonetech.system.domain.SysCodeDetail belongArea;

	// collections
	private java.util.Set<com.justonetech.biz.domain.ProjBid> projBids;
	private java.util.Set<com.justonetech.biz.domain.ProjRelatePerson> projRelatePersons;
	private java.util.Set<com.justonetech.biz.domain.ProjRelateDept> projRelateDepts;
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
	 * Return the value associated with the column: NO
	 */
	public Integer getNo () {
		return no;
	}

	/**
	 * Set the value related to the column: NO
	 * @param no the NO value
	 */
	public void setNo (Integer no) {
		this.no = no;
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
	 * Return the value associated with the column: LOCATION
	 */
	public String getLocation () {
		return location;
	}

	/**
	 * Set the value related to the column: LOCATION
	 * @param location the LOCATION value
	 */
	public void setLocation (String location) {
		this.location = location;
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
	 * Return the value associated with the column: INTRO
	 */
	public String getIntro () {
		return intro;
	}

	/**
	 * Set the value related to the column: INTRO
	 * @param intro the INTRO value
	 */
	public void setIntro (String intro) {
		this.intro = intro;
	}


	/**
	 * Return the value associated with the column: JS_DEPT
	 */
	public String getJsDept () {
		return jsDept;
	}

	/**
	 * Set the value related to the column: JS_DEPT
	 * @param jsDept the JS_DEPT value
	 */
	public void setJsDept (String jsDept) {
		this.jsDept = jsDept;
	}


	/**
	 * Return the value associated with the column: SG_DEPT
	 */
	public String getSgDept () {
		return sgDept;
	}

	/**
	 * Set the value related to the column: SG_DEPT
	 * @param sgDept the SG_DEPT value
	 */
	public void setSgDept (String sgDept) {
		this.sgDept = sgDept;
	}


	/**
	 * Return the value associated with the column: SG_DEPT_PERSON
	 */
	public String getSgDeptPerson () {
		return sgDeptPerson;
	}

	/**
	 * Set the value related to the column: SG_DEPT_PERSON
	 * @param sgDeptPerson the SG_DEPT_PERSON value
	 */
	public void setSgDeptPerson (String sgDeptPerson) {
		this.sgDeptPerson = sgDeptPerson;
	}


	/**
	 * Return the value associated with the column: SG_DEPT_TEL
	 */
	public String getSgDeptTel () {
		return sgDeptTel;
	}

	/**
	 * Set the value related to the column: SG_DEPT_TEL
	 * @param sgDeptTel the SG_DEPT_TEL value
	 */
	public void setSgDeptTel (String sgDeptTel) {
		this.sgDeptTel = sgDeptTel;
	}


	/**
	 * Return the value associated with the column: JL_DEPT
	 */
	public String getJlDept () {
		return jlDept;
	}

	/**
	 * Set the value related to the column: JL_DEPT
	 * @param jlDept the JL_DEPT value
	 */
	public void setJlDept (String jlDept) {
		this.jlDept = jlDept;
	}


	/**
	 * Return the value associated with the column: JL_DEPT_PERSON
	 */
	public String getJlDeptPerson () {
		return jlDeptPerson;
	}

	/**
	 * Set the value related to the column: JL_DEPT_PERSON
	 * @param jlDeptPerson the JL_DEPT_PERSON value
	 */
	public void setJlDeptPerson (String jlDeptPerson) {
		this.jlDeptPerson = jlDeptPerson;
	}


	/**
	 * Return the value associated with the column: JL_DEPT_TEL
	 */
	public String getJlDeptTel () {
		return jlDeptTel;
	}

	/**
	 * Set the value related to the column: JL_DEPT_TEL
	 * @param jlDeptTel the JL_DEPT_TEL value
	 */
	public void setJlDeptTel (String jlDeptTel) {
		this.jlDeptTel = jlDeptTel;
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


	/**
	 * Return the value associated with the column: PROPERTY_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getProperty () {
		return property;
	}

	/**
	 * Set the value related to the column: PROPERTY_ID
	 * @param property the PROPERTY_ID value
	 */
	public void setProperty (com.justonetech.system.domain.SysCodeDetail property) {
		this.property = property;
	}


	/**
	 * Return the value associated with the column: STAGE_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getStage () {
		return stage;
	}

	/**
	 * Set the value related to the column: STAGE_ID
	 * @param stage the STAGE_ID value
	 */
	public void setStage (com.justonetech.system.domain.SysCodeDetail stage) {
		this.stage = stage;
	}


	/**
	 * Return the value associated with the column: CATEGORY_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getCategory () {
		return category;
	}

	/**
	 * Set the value related to the column: CATEGORY_ID
	 * @param category the CATEGORY_ID value
	 */
	public void setCategory (com.justonetech.system.domain.SysCodeDetail category) {
		this.category = category;
	}


	/**
	 * Return the value associated with the column: BELONG_AREA_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getBelongArea () {
		return belongArea;
	}

	/**
	 * Set the value related to the column: BELONG_AREA_ID
	 * @param belongArea the BELONG_AREA_ID value
	 */
	public void setBelongArea (com.justonetech.system.domain.SysCodeDetail belongArea) {
		this.belongArea = belongArea;
	}


	/**
	 * Return the value associated with the column: projBids
	 */
	public java.util.Set<com.justonetech.biz.domain.ProjBid> getProjBids () {
		if(projBids == null){
			projBids = new java.util.LinkedHashSet<com.justonetech.biz.domain.ProjBid>();
		}
		return projBids;
	}

	/**
	 * Set the value related to the column: projBids
	 * @param projBids the projBids value
	 */
	public void setProjBids (java.util.Set<com.justonetech.biz.domain.ProjBid> projBids) {
		this.projBids = projBids;
	}

	public void addToprojBids (com.justonetech.biz.domain.ProjBid projBid) {
		if (null == getProjBids()) setProjBids(new java.util.LinkedHashSet<com.justonetech.biz.domain.ProjBid>());
		getProjBids().add(projBid);
	}


	/**
	 * Return the value associated with the column: projRelatePersons
	 */
	public java.util.Set<com.justonetech.biz.domain.ProjRelatePerson> getProjRelatePersons () {
		return projRelatePersons;
	}

	/**
	 * Set the value related to the column: projRelatePersons
	 * @param projRelatePersons the projRelatePersons value
	 */
	public void setProjRelatePersons (java.util.Set<com.justonetech.biz.domain.ProjRelatePerson> projRelatePersons) {
		this.projRelatePersons = projRelatePersons;
	}


	/**
	 * Return the value associated with the column: projRelateDepts
	 */
	public java.util.Set<com.justonetech.biz.domain.ProjRelateDept> getProjRelateDepts () {
		return projRelateDepts;
	}

	/**
	 * Set the value related to the column: projRelateDepts
	 * @param projRelateDepts the projRelateDepts value
	 */
	public void setProjRelateDepts (java.util.Set<com.justonetech.biz.domain.ProjRelateDept> projRelateDepts) {
		this.projRelateDepts = projRelateDepts;
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
		if (!(obj instanceof com.justonetech.biz.domain.ProjInfo)) return false;
		else {
			com.justonetech.biz.domain.ProjInfo projInfo = (com.justonetech.biz.domain.ProjInfo) obj;
			if (null == this.getId() || null == projInfo.getId()) return false;
			else return (this.getId().equals(projInfo.getId()));
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
		builder.append(name);
		builder.append(year);
		builder.append(no);
		builder.append(buildMileage);
		builder.append(location);
		builder.append(startDate);
		builder.append(intro);
		builder.append(jsDept);
		builder.append(sgDept);
		builder.append(sgDeptPerson);
		builder.append(sgDeptTel);
		builder.append(jlDept);
		builder.append(jlDeptPerson);
		builder.append(jlDeptTel);
		builder.append(createTime);
		builder.append(updateTime);
		builder.append(createUser);
		builder.append(updateUser);
		return builder.toString();
	}


}