package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the POLLING_UNLAWFUL_PROJECT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 非法工程信息
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 非法工程信息
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : polling
 * Projectable : false
 *
 * @hibernate.class
 *  table="POLLING_UNLAWFUL_PROJECT"
 */

public abstract class BasePollingUnlawfulProject implements Serializable,Auditable {

	public static String REF = "PollingUnlawfulProject";
	public static String PROP_PROJECT_DOC = "projectDoc";
	public static String PROP_QUESTION_DESC = "questionDesc";
	public static String PROP_BUILD_UNIT_ADDRESS = "buildUnitAddress";
	public static String PROP_BUILD_LINK_PHONE = "buildLinkPhone";
	public static String PROP_BUILD_LINKMAN = "buildLinkman";
	public static String PROP_DEAL_USER = "dealUser";
	public static String PROP_DEAL_TIME = "dealTime";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_GROUP_PERSON = "groupPerson";
	public static String PROP_SG_UNIT_LINK_PHONE = "sgUnitLinkPhone";
	public static String PROP_IS_GHXK = "isGhxk";
	public static String PROP_UPDATE_USER = "updateUser";
	public static String PROP_PAD_IMEI = "padImei";
	public static String PROP_PROJECT_NAME = "projectName";
	public static String PROP_MAIN_PERSON = "mainPerson";
	public static String PROP_DEAL_RESULT = "dealResult";
	public static String PROP_BUILD_UNIT = "buildUnit";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_IS_LX = "isLx";
	public static String PROP_SG_UNIT_LINKMAN = "sgUnitLinkman";
	public static String PROP_BUILD_ADDRESS = "buildAddress";
	public static String PROP_IS_TDQZ = "isTdqz";
	public static String PROP_IS_SGXK = "isSgxk";
	public static String PROP_STATUS = "status";
	public static String PROP_CURRENT_LONGITUDE = "currentLongitude";
	public static String PROP_SG_UNIT = "sgUnit";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_CURRENT_LATITUDE = "currentLatitude";
	public static String PROP_ID = "id";
	public static String PROP_POLLING_GROUP = "pollingGroup";
	public static String PROP_PAD_TIME = "padTime";
    public static String PROP_BELONG_AREA = "belongArea";
    public static String PROP_POS_Y = "posY";
    public static String PROP_POS_X = "posX";

	// constructors
	public BasePollingUnlawfulProject() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePollingUnlawfulProject(Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*工程名称*/
    /*工程名称*/
	private String projectName;
	
    /*建设地址*/
    /*建设地址*/
	private String buildAddress;
	
    /*建设单位*/
    /*建设单位*/
	private String buildUnit;
	
    /*建设单位地址*/
    /*建设单位地址*/
	private String buildUnitAddress;
	
    /*建设单位联系人*/
    /*建设单位联系人*/
	private String buildLinkman;
	
    /*建设单位联系电话*/
    /*建设单位联系电话*/
	private String buildLinkPhone;
	
    /*施工单位*/
    /*施工单位*/
	private String sgUnit;
	
    /*施工单位联系人*/
    /*施工单位联系人*/
	private String sgUnitLinkman;
	
    /*施工单位联系电话*/
    /*施工单位联系电话*/
	private String sgUnitLinkPhone;
	
    /*定位经度*/
    /*定位经度*/
	private Double currentLongitude;
	
    /*定位纬度*/
    /*定位纬度*/
	private Double currentLatitude;
	
    /*监督负责人*/
    /*监督负责人*/
	private String mainPerson;
	
    /*监督员:可能多人*/
    /*监督员:可能多人*/
	private String groupPerson;
	
    /*查验立项申请：无、有*/
    /*查验立项申请：无、有*/
	private Boolean isLx;
	
    /*查验土地权证：无、有*/
    /*查验土地权证：无、有*/
	private Boolean isTdqz;
	
    /*查验规划许可证*/
    /*查验规划许可证*/
	private Boolean isGhxk;
	
    /*查验施工许可证*/
    /*查验施工许可证*/
	private Boolean isSgxk;
	
    /*问题描述*/
    /*问题描述*/
	private String questionDesc;
	
    /*处置结果*/
    /*处置结果*/
	private String dealResult;
	
    /*处理经受人*/
    /*处理经受人*/
	private String dealUser;
	
    /*处理时间*/
    /*处理时间*/
	private java.sql.Timestamp dealTime;
	
    /*创建时间*/
    /*创建时间*/
	private java.sql.Timestamp createTime;
	
    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updateTime;
	
    /*更新人*/
    /*更新人*/
	private String updateUser;
	
    /*创建人*/
    /*创建人*/
	private String createUser;
	
    /*手持提交时间*/
    /*手持提交时间*/
	private java.sql.Timestamp padTime;
	
    /*手持设备号*/
    /*手持设备号*/
	private String padImei;

    /*项目属地*/
    /*项目属地*/
    private String belongArea;

    /*坐标X*/
    /*坐标X*/
    private Double posX;

    /*坐标Y*/
    /*坐标Y*/
    private Double posY;

	// many to one
	private com.justonetech.biz.domain.DocDocument projectDoc;
	private com.justonetech.biz.domain.PollingWorkGroup pollingGroup;
	private com.justonetech.system.domain.SysCodeDetail status;



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
	 * Return the value associated with the column: BUILD_ADDRESS
	 */
	public String getBuildAddress () {
		return buildAddress;
	}

	/**
	 * Set the value related to the column: BUILD_ADDRESS
	 * @param buildAddress the BUILD_ADDRESS value
	 */
	public void setBuildAddress (String buildAddress) {
		this.buildAddress = buildAddress;
	}


	/**
	 * Return the value associated with the column: BUILD_UNIT
	 */
	public String getBuildUnit () {
		return buildUnit;
	}

	/**
	 * Set the value related to the column: BUILD_UNIT
	 * @param buildUnit the BUILD_UNIT value
	 */
	public void setBuildUnit (String buildUnit) {
		this.buildUnit = buildUnit;
	}


	/**
	 * Return the value associated with the column: BUILD_UNIT_ADDRESS
	 */
	public String getBuildUnitAddress () {
		return buildUnitAddress;
	}

	/**
	 * Set the value related to the column: BUILD_UNIT_ADDRESS
	 * @param buildUnitAddress the BUILD_UNIT_ADDRESS value
	 */
	public void setBuildUnitAddress (String buildUnitAddress) {
		this.buildUnitAddress = buildUnitAddress;
	}


	/**
	 * Return the value associated with the column: BUILD_LINKMAN
	 */
	public String getBuildLinkman () {
		return buildLinkman;
	}

	/**
	 * Set the value related to the column: BUILD_LINKMAN
	 * @param buildLinkman the BUILD_LINKMAN value
	 */
	public void setBuildLinkman (String buildLinkman) {
		this.buildLinkman = buildLinkman;
	}


	/**
	 * Return the value associated with the column: BUILD_LINK_PHONE
	 */
	public String getBuildLinkPhone () {
		return buildLinkPhone;
	}

	/**
	 * Set the value related to the column: BUILD_LINK_PHONE
	 * @param buildLinkPhone the BUILD_LINK_PHONE value
	 */
	public void setBuildLinkPhone (String buildLinkPhone) {
		this.buildLinkPhone = buildLinkPhone;
	}


	/**
	 * Return the value associated with the column: SG_UNIT
	 */
	public String getSgUnit () {
		return sgUnit;
	}

	/**
	 * Set the value related to the column: SG_UNIT
	 * @param sgUnit the SG_UNIT value
	 */
	public void setSgUnit (String sgUnit) {
		this.sgUnit = sgUnit;
	}


	/**
	 * Return the value associated with the column: SG_UNIT_LINKMAN
	 */
	public String getSgUnitLinkman () {
		return sgUnitLinkman;
	}

	/**
	 * Set the value related to the column: SG_UNIT_LINKMAN
	 * @param sgUnitLinkman the SG_UNIT_LINKMAN value
	 */
	public void setSgUnitLinkman (String sgUnitLinkman) {
		this.sgUnitLinkman = sgUnitLinkman;
	}


	/**
	 * Return the value associated with the column: SG_UNIT_LINK_PHONE
	 */
	public String getSgUnitLinkPhone () {
		return sgUnitLinkPhone;
	}

	/**
	 * Set the value related to the column: SG_UNIT_LINK_PHONE
	 * @param sgUnitLinkPhone the SG_UNIT_LINK_PHONE value
	 */
	public void setSgUnitLinkPhone (String sgUnitLinkPhone) {
		this.sgUnitLinkPhone = sgUnitLinkPhone;
	}


	/**
	 * Return the value associated with the column: CURRENT_LONGITUDE
	 */
	public Double getCurrentLongitude () {
		return currentLongitude;
	}

	/**
	 * Set the value related to the column: CURRENT_LONGITUDE
	 * @param currentLongitude the CURRENT_LONGITUDE value
	 */
	public void setCurrentLongitude (Double currentLongitude) {
		this.currentLongitude = currentLongitude;
	}


	/**
	 * Return the value associated with the column: CURRENT_LATITUDE
	 */
	public Double getCurrentLatitude () {
		return currentLatitude;
	}

	/**
	 * Set the value related to the column: CURRENT_LATITUDE
	 * @param currentLatitude the CURRENT_LATITUDE value
	 */
	public void setCurrentLatitude (Double currentLatitude) {
		this.currentLatitude = currentLatitude;
	}


	/**
	 * Return the value associated with the column: MAIN_PERSON
	 */
	public String getMainPerson () {
		return mainPerson;
	}

	/**
	 * Set the value related to the column: MAIN_PERSON
	 * @param mainPerson the MAIN_PERSON value
	 */
	public void setMainPerson (String mainPerson) {
		this.mainPerson = mainPerson;
	}


	/**
	 * Return the value associated with the column: GROUP_PERSON
	 */
	public String getGroupPerson () {
		return groupPerson;
	}

	/**
	 * Set the value related to the column: GROUP_PERSON
	 * @param groupPerson the GROUP_PERSON value
	 */
	public void setGroupPerson (String groupPerson) {
		this.groupPerson = groupPerson;
	}


	/**
	 * Return the value associated with the column: IS_LX
	 */
	public Boolean getIsLx () {
		return isLx;
	}

	/**
	 * Set the value related to the column: IS_LX
	 * @param isLx the IS_LX value
	 */
	public void setIsLx (Boolean isLx) {
		this.isLx = isLx;
	}


	/**
	 * Return the value associated with the column: IS_TDQZ
	 */
	public Boolean getIsTdqz () {
		return isTdqz;
	}

	/**
	 * Set the value related to the column: IS_TDQZ
	 * @param isTdqz the IS_TDQZ value
	 */
	public void setIsTdqz (Boolean isTdqz) {
		this.isTdqz = isTdqz;
	}


	/**
	 * Return the value associated with the column: IS_GHXK
	 */
	public Boolean getIsGhxk () {
		return isGhxk;
	}

	/**
	 * Set the value related to the column: IS_GHXK
	 * @param isGhxk the IS_GHXK value
	 */
	public void setIsGhxk (Boolean isGhxk) {
		this.isGhxk = isGhxk;
	}


	/**
	 * Return the value associated with the column: IS_SGXK
	 */
	public Boolean getIsSgxk () {
		return isSgxk;
	}

	/**
	 * Set the value related to the column: IS_SGXK
	 * @param isSgxk the IS_SGXK value
	 */
	public void setIsSgxk (Boolean isSgxk) {
		this.isSgxk = isSgxk;
	}


	/**
	 * Return the value associated with the column: QUESTION_DESC
	 */
	public String getQuestionDesc () {
		return questionDesc;
	}

	/**
	 * Set the value related to the column: QUESTION_DESC
	 * @param questionDesc the QUESTION_DESC value
	 */
	public void setQuestionDesc (String questionDesc) {
		this.questionDesc = questionDesc;
	}


	/**
	 * Return the value associated with the column: DEAL_RESULT
	 */
	public String getDealResult () {
		return dealResult;
	}

	/**
	 * Set the value related to the column: DEAL_RESULT
	 * @param dealResult the DEAL_RESULT value
	 */
	public void setDealResult (String dealResult) {
		this.dealResult = dealResult;
	}


	/**
	 * Return the value associated with the column: DEAL_USER
	 */
	public String getDealUser () {
		return dealUser;
	}

	/**
	 * Set the value related to the column: DEAL_USER
	 * @param dealUser the DEAL_USER value
	 */
	public void setDealUser (String dealUser) {
		this.dealUser = dealUser;
	}


	/**
	 * Return the value associated with the column: DEAL_TIME
	 */
	public java.sql.Timestamp getDealTime () {
		return dealTime;
	}

	/**
	 * Set the value related to the column: DEAL_TIME
	 * @param dealTime the DEAL_TIME value
	 */
	public void setDealTime (java.sql.Timestamp dealTime) {
		this.dealTime = dealTime;
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
	 * Return the value associated with the column: PAD_TIME
	 */
	public java.sql.Timestamp getPadTime () {
		return padTime;
	}

	/**
	 * Set the value related to the column: PAD_TIME
	 * @param padTime the PAD_TIME value
	 */
	public void setPadTime (java.sql.Timestamp padTime) {
		this.padTime = padTime;
	}


	/**
	 * Return the value associated with the column: PAD_IMEI
	 */
	public String getPadImei () {
		return padImei;
	}

	/**
	 * Set the value related to the column: PAD_IMEI
	 * @param padImei the PAD_IMEI value
	 */
	public void setPadImei (String padImei) {
		this.padImei = padImei;
	}


	/**
	 * Return the value associated with the column: PROJECT_DOC_ID
	 */
	public com.justonetech.biz.domain.DocDocument getProjectDoc () {
		return projectDoc;
	}

	/**
	 * Set the value related to the column: PROJECT_DOC_ID
	 * @param projectDoc the PROJECT_DOC_ID value
	 */
	public void setProjectDoc (com.justonetech.biz.domain.DocDocument projectDoc) {
		this.projectDoc = projectDoc;
	}


    /**
     * Return the value associated with the column: BELONG_AREA
     */
    public String getBelongArea() {
        return belongArea;
    }

    /**
     * Set the value related to the column: BELONG_AREA
     *
     * @param belongArea the BELONG_AREA value
     */
    public void setBelongArea(String belongArea) {
        this.belongArea = belongArea;
    }


    /**
     * Return the value associated with the column: POS_X
     */
    public Double getPosX() {
        return posX;
    }

    /**
     * Set the value related to the column: POS_X
     *
     * @param posX the POS_X value
     */
    public void setPosX(Double posX) {
        this.posX = posX;
    }


    /**
     * Return the value associated with the column: POS_Y
     */
    public Double getPosY() {
        return posY;
    }

    /**
     * Set the value related to the column: POS_Y
     *
     * @param posY the POS_Y value
     */
    public void setPosY(Double posY) {
        this.posY = posY;
    }

    /**
	 * Return the value associated with the column: POLLING_GROUP
	 */
	public com.justonetech.biz.domain.PollingWorkGroup getPollingGroup () {
		return pollingGroup;
	}

	/**
	 * Set the value related to the column: POLLING_GROUP
	 * @param pollingGroup the POLLING_GROUP value
	 */
	public void setPollingGroup (com.justonetech.biz.domain.PollingWorkGroup pollingGroup) {
		this.pollingGroup = pollingGroup;
	}


	/**
	 * Return the value associated with the column: STATUS
	 */
	public com.justonetech.system.domain.SysCodeDetail getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (com.justonetech.system.domain.SysCodeDetail status) {
		this.status = status;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.PollingUnlawfulProject)) return false;
		else {
			com.justonetech.biz.domain.PollingUnlawfulProject pollingUnlawfulProject = (com.justonetech.biz.domain.PollingUnlawfulProject) obj;
			if (null == this.getId() || null == pollingUnlawfulProject.getId()) return false;
			else return (this.getId().equals(pollingUnlawfulProject.getId()));
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
		builder.append(buildAddress);
		builder.append(buildUnit);
		builder.append(buildUnitAddress);
		builder.append(buildLinkman);
		builder.append(buildLinkPhone);
		builder.append(sgUnit);
		builder.append(sgUnitLinkman);
		builder.append(sgUnitLinkPhone);
		builder.append(currentLongitude);
		builder.append(currentLatitude);
		builder.append(mainPerson);
		builder.append(groupPerson);
		builder.append(isLx);
		builder.append(isTdqz);
		builder.append(isGhxk);
		builder.append(isSgxk);
		builder.append(questionDesc);
		builder.append(dealResult);
		builder.append(dealUser);
		builder.append(dealTime);
		builder.append(createTime);
		builder.append(updateTime);
		builder.append(updateUser);
		builder.append(createUser);
		builder.append(padTime);
		builder.append(padImei);
        builder.append(belongArea);
        builder.append(posX);
        builder.append(posY);
		return builder.toString();
	}


}