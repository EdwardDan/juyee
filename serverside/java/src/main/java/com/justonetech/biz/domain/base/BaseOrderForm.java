package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ORDER_FORM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 监督预约
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 监督预约
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : order
 * Projectable : false
 *
 * @hibernate.class
 *  table="ORDER_FORM"
 */

public abstract class BaseOrderForm implements Serializable,Auditable {

	public static String REF = "OrderForm";
	public static String PROP_PLAN_SG_DATATIME = "planSgDatatime";
	public static String PROP_FORM_DOC = "formDoc";
	public static String PROP_ORDER_STATUS = "orderStatus";
	public static String PROP_PROJECT_NAME = "projectName";
	public static String PROP_BUILD_LEGAL_PERSON = "buildLegalPerson";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_SG_UNIT_NAME = "sgUnitName";
	public static String PROP_BUILD_AREA = "buildArea";
	public static String PROP_ORDER_DATETIME = "orderDatetime";
	public static String PROP_BUILD_ADDRESS = "buildAddress";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_FLOW_CODE = "flowCode";
	public static String PROP_JD_TASK_CODE = "jdTaskCode";
	public static String PROP_BUILD_UNIT_NAME = "buildUnitName";
	public static String PROP_STRUCTURE = "structure";
	public static String PROP_BUILD_LEGAL_PHONE = "buildLegalPhone";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_ORDER_CODE = "orderCode";
	public static String PROP_ID = "id";
	public static String PROP_INPUT_TIME = "inputTime";
	public static String PROP_PROJECT_MANAGER = "projectManager";
	public static String PROP_LINK_MAN = "linkMan";
	public static String PROP_UPDATE_USER = "updateUser";
	public static String PROP_SG_POSITION = "sgPosition";
	public static String PROP_LINK_MAN_PHONE = "linkManPhone";


	// constructors
	public BaseOrderForm() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOrderForm(Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*预约单号*/
    /*预约单号*/
	private String orderCode;
	
    /*监督任务书编号*/
    /*监督任务书编号*/
	private String jdTaskCode;
	
    /*建设单位*/
    /*建设单位*/
	private String buildUnitName;
	
    /*施工单位*/
    /*施工单位*/
	private String sgUnitName;
	
    /*工程名称*/
    /*工程名称*/
	private String projectName;
	
    /*工程地点*/
    /*工程地点*/
	private String buildAddress;
	
    /*建筑面积*/
    /*建筑面积*/
	private Double buildArea;
	
    /*结构层次*/
    /*结构层次*/
	private String structure;
	
    /*隐蔽工程部位*/
    /*隐蔽工程部位*/
	private String sgPosition;
	
    /*建设单位法人代表*/
    /*建设单位法人代表*/
	private String buildLegalPerson;
	
    /*联系电话*/
    /*联系电话*/
	private String buildLegalPhone;
	
    /*项目经理*/
    /*项目经理*/
	private String projectManager;
	
    /*计划隐蔽日期*/
    /*计划隐蔽日期*/
	private java.sql.Timestamp planSgDatatime;
	
    /*预约日期*/
    /*预约日期*/
	private java.sql.Timestamp orderDatetime;
	
    /*填表日期*/
    /*填表日期*/
	private java.sql.Timestamp inputTime;
	
    /*联系人*/
    /*联系人*/
	private String linkMan;

    /*联系人手机*/
    /*联系人手机*/
	private String linkManPhone;

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
	

	// many to one
	private com.justonetech.system.domain.SysCodeDetail orderStatus;
	private com.justonetech.biz.domain.DocDocument formDoc;

	// collections
	private java.util.Set<com.justonetech.biz.domain.OrderFormDeploy> orderFormDeploies;



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
	 * Return the value associated with the column: ORDER_CODE
	 */
	public String getOrderCode () {
		return orderCode;
	}

	/**
	 * Set the value related to the column: ORDER_CODE
	 * @param orderCode the ORDER_CODE value
	 */
	public void setOrderCode (String orderCode) {
		this.orderCode = orderCode;
	}


	/**
	 * Return the value associated with the column: FLOW_CODE
	 */
	public String getJdTaskCode () {
		return jdTaskCode;
	}

	/**
	 * Set the value related to the column: FLOW_CODE
	 * @param jdTaskCode the FLOW_CODE value
	 */
	public void setJdTaskCode (String jdTaskCode) {
		this.jdTaskCode = jdTaskCode;
	}


	/**
	 * Return the value associated with the column: BUILD_UNIT_NAME
	 */
	public String getBuildUnitName () {
		return buildUnitName;
	}

	/**
	 * Set the value related to the column: BUILD_UNIT_NAME
	 * @param buildUnitName the BUILD_UNIT_NAME value
	 */
	public void setBuildUnitName (String buildUnitName) {
		this.buildUnitName = buildUnitName;
	}


	/**
	 * Return the value associated with the column: SG_UNIT_NAME
	 */
	public String getSgUnitName () {
		return sgUnitName;
	}

	/**
	 * Set the value related to the column: SG_UNIT_NAME
	 * @param sgUnitName the SG_UNIT_NAME value
	 */
	public void setSgUnitName (String sgUnitName) {
		this.sgUnitName = sgUnitName;
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
	 * Return the value associated with the column: BUILD_AREA
	 */
	public Double getBuildArea () {
		return buildArea;
	}

	/**
	 * Set the value related to the column: BUILD_AREA
	 * @param buildArea the BUILD_AREA value
	 */
	public void setBuildArea (Double buildArea) {
		this.buildArea = buildArea;
	}


	/**
	 * Return the value associated with the column: STRUCTURE
	 */
	public String getStructure () {
		return structure;
	}

	/**
	 * Set the value related to the column: STRUCTURE
	 * @param structure the STRUCTURE value
	 */
	public void setStructure (String structure) {
		this.structure = structure;
	}


	/**
	 * Return the value associated with the column: SG_POSITION
	 */
	public String getSgPosition () {
		return sgPosition;
	}

	/**
	 * Set the value related to the column: SG_POSITION
	 * @param sgPosition the SG_POSITION value
	 */
	public void setSgPosition (String sgPosition) {
		this.sgPosition = sgPosition;
	}


	/**
	 * Return the value associated with the column: BUILD_LEGAL_PERSON
	 */
	public String getBuildLegalPerson () {
		return buildLegalPerson;
	}

	/**
	 * Set the value related to the column: BUILD_LEGAL_PERSON
	 * @param buildLegalPerson the BUILD_LEGAL_PERSON value
	 */
	public void setBuildLegalPerson (String buildLegalPerson) {
		this.buildLegalPerson = buildLegalPerson;
	}


	/**
	 * Return the value associated with the column: BUILD_LEGAL_PHONE
	 */
	public String getBuildLegalPhone () {
		return buildLegalPhone;
	}

	/**
	 * Set the value related to the column: BUILD_LEGAL_PHONE
	 * @param buildLegalPhone the BUILD_LEGAL_PHONE value
	 */
	public void setBuildLegalPhone (String buildLegalPhone) {
		this.buildLegalPhone = buildLegalPhone;
	}


	/**
	 * Return the value associated with the column: PROJECT_MANAGER
	 */
	public String getProjectManager () {
		return projectManager;
	}

	/**
	 * Set the value related to the column: PROJECT_MANAGER
	 * @param projectManager the PROJECT_MANAGER value
	 */
	public void setProjectManager (String projectManager) {
		this.projectManager = projectManager;
	}


	/**
	 * Return the value associated with the column: PLAN_SG_DATATIME
	 */
	public java.sql.Timestamp getPlanSgDatatime () {
		return planSgDatatime;
	}

	/**
	 * Set the value related to the column: PLAN_SG_DATATIME
	 * @param planSgDatatime the PLAN_SG_DATATIME value
	 */
	public void setPlanSgDatatime (java.sql.Timestamp planSgDatatime) {
		this.planSgDatatime = planSgDatatime;
	}


	/**
	 * Return the value associated with the column: ORDER_DATETIME
	 */
	public java.sql.Timestamp getOrderDatetime () {
		return orderDatetime;
	}

	/**
	 * Set the value related to the column: ORDER_DATETIME
	 * @param orderDatetime the ORDER_DATETIME value
	 */
	public void setOrderDatetime (java.sql.Timestamp orderDatetime) {
		this.orderDatetime = orderDatetime;
	}


	/**
	 * Return the value associated with the column: INPUT_TIME
	 */
	public java.sql.Timestamp getInputTime () {
		return inputTime;
	}

	/**
	 * Set the value related to the column: INPUT_TIME
	 * @param inputTime the INPUT_TIME value
	 */
	public void setInputTime (java.sql.Timestamp inputTime) {
		this.inputTime = inputTime;
	}


	/**
	 * Return the value associated with the column: LINK_MAN
	 */
	public String getLinkMan () {
		return linkMan;
	}

	/**
	 * Set the value related to the column: LINK_MAN
	 * @param linkMan the LINK_MAN value
	 */
	public void setLinkMan (String linkMan) {
		this.linkMan = linkMan;
	}

    public String getLinkManPhone() {
        return linkManPhone;
    }

    public void setLinkManPhone(String linkManPhone) {
        this.linkManPhone = linkManPhone;
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
	 * Return the value associated with the column: ORDER_STATUS
	 */
	public com.justonetech.system.domain.SysCodeDetail getOrderStatus () {
		return orderStatus;
	}

	/**
	 * Set the value related to the column: ORDER_STATUS
	 * @param orderStatus the ORDER_STATUS value
	 */
	public void setOrderStatus (com.justonetech.system.domain.SysCodeDetail orderStatus) {
		this.orderStatus = orderStatus;
	}


	/**
	 * Return the value associated with the column: FORM_DOC_ID
	 */
	public com.justonetech.biz.domain.DocDocument getFormDoc () {
		return formDoc;
	}

	/**
	 * Set the value related to the column: FORM_DOC_ID
	 * @param formDoc the FORM_DOC_ID value
	 */
	public void setFormDoc (com.justonetech.biz.domain.DocDocument formDoc) {
		this.formDoc = formDoc;
	}


	/**
	 * Return the value associated with the column: orderFormDeploies
	 */
	public java.util.Set<com.justonetech.biz.domain.OrderFormDeploy> getOrderFormDeploies () {
		if(orderFormDeploies == null){
			orderFormDeploies = new java.util.LinkedHashSet<com.justonetech.biz.domain.OrderFormDeploy>();
		}
		return orderFormDeploies;
	}

	/**
	 * Set the value related to the column: orderFormDeploies
	 * @param orderFormDeploies the orderFormDeploies value
	 */
	public void setOrderFormDeploies (java.util.Set<com.justonetech.biz.domain.OrderFormDeploy> orderFormDeploies) {
		this.orderFormDeploies = orderFormDeploies;
	}

	public void addToorderFormDeploies (com.justonetech.biz.domain.OrderFormDeploy orderFormDeploy) {
		if (null == getOrderFormDeploies()) setOrderFormDeploies(new java.util.LinkedHashSet<com.justonetech.biz.domain.OrderFormDeploy>());
		getOrderFormDeploies().add(orderFormDeploy);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OrderForm)) return false;
		else {
			com.justonetech.biz.domain.OrderForm orderForm = (com.justonetech.biz.domain.OrderForm) obj;
			if (null == this.getId() || null == orderForm.getId()) return false;
			else return (this.getId().equals(orderForm.getId()));
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
		builder.append(orderCode);
		builder.append(jdTaskCode);
		builder.append(buildUnitName);
		builder.append(sgUnitName);
		builder.append(projectName);
		builder.append(buildAddress);
		builder.append(buildArea);
		builder.append(structure);
		builder.append(sgPosition);
		builder.append(buildLegalPerson);
		builder.append(buildLegalPhone);
		builder.append(projectManager);
		builder.append(planSgDatatime);
		builder.append(orderDatetime);
		builder.append(inputTime);
		builder.append(linkMan);
		builder.append(linkManPhone);
		builder.append(createTime);
		builder.append(updateTime);
		builder.append(updateUser);
		builder.append(createUser);
		return builder.toString();
	}


}