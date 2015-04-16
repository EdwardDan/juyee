package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the NET_APPLY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目报建
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 项目报建
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : net
 * Projectable : false
 *
 * @hibernate.class
 *  table="NET_APPLY"
 */

public abstract class BaseNetApply  implements Serializable,Auditable {

	public static String REF = "NetApply";
	public static String PROP_PROJECT_NAME = "projectName";
	public static String PROP_IS_CHECK_DRAW = "isCheckDraw";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_NET_DATE = "netDate";
	public static String PROP_BUILD_ADDRESS = "buildAddress";
	public static String PROP_ACCEPT_STATUS = "acceptStatus";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_BJBH = "bjbh";
	public static String PROP_BUILD_UNIT_NAME = "buildUnitName";
	public static String PROP_IS_IMPORTANT = "isImportant";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_ID = "id";
	public static String PROP_APPLY_UNIT_NAME = "applyUnitName";
	public static String PROP_NET_CODE = "netCode";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseNetApply () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseNetApply (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*网上受理编号*/
    /*网上受理编号*/
	private String netCode;
	
    /*网上提交日期*/
    /*网上提交日期*/
	private java.sql.Date netDate;
	
    /*报建编号*/
    /*报建编号*/
	private String bjbh;
	
    /*项目名称*/
    /*项目名称*/
	private String projectName;
	
    /*建设单位*/
    /*建设单位*/
	private String buildUnitName;
	
    /*建设地点*/
    /*建设地点*/
	private String buildAddress;
	
    /*申请单位*/
    /*申请单位*/
	private String applyUnitName;
	
    /*是否需要施工图审查*/
    /*是否需要施工图审查*/
	private Boolean isCheckDraw;
	
    /*是否重大推进项目*/
    /*是否重大推进项目*/
	private Boolean isImportant;
	
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
	private com.justonetech.biz.domain.NetAcceptStatus acceptStatus;

	// collections
	private java.util.Set<com.justonetech.biz.domain.NetMonitor> netMonitors;
	private java.util.Set<com.justonetech.biz.domain.NetApplyFbType> netApplyFbTypes;
	private java.util.Set<com.justonetech.biz.domain.NetCfb> netCfbs;
	private java.util.Set<com.justonetech.biz.domain.NetContract> netContracts;
	private java.util.Set<com.justonetech.biz.domain.NetSgpermit> netSgpermits;



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
	 * Return the value associated with the column: NET_CODE
	 */
	public String getNetCode () {
		return netCode;
	}

	/**
	 * Set the value related to the column: NET_CODE
	 * @param netCode the NET_CODE value
	 */
	public void setNetCode (String netCode) {
		this.netCode = netCode;
	}


	/**
	 * Return the value associated with the column: NET_DATE
	 */
	public java.sql.Date getNetDate () {
		return netDate;
	}

	/**
	 * Set the value related to the column: NET_DATE
	 * @param netDate the NET_DATE value
	 */
	public void setNetDate (java.sql.Date netDate) {
		this.netDate = netDate;
	}


	/**
	 * Return the value associated with the column: BJBH
	 */
	public String getBjbh () {
		return bjbh;
	}

	/**
	 * Set the value related to the column: BJBH
	 * @param bjbh the BJBH value
	 */
	public void setBjbh (String bjbh) {
		this.bjbh = bjbh;
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
	 * Return the value associated with the column: APPLY_UNIT_NAME
	 */
	public String getApplyUnitName () {
		return applyUnitName;
	}

	/**
	 * Set the value related to the column: APPLY_UNIT_NAME
	 * @param applyUnitName the APPLY_UNIT_NAME value
	 */
	public void setApplyUnitName (String applyUnitName) {
		this.applyUnitName = applyUnitName;
	}


	/**
	 * Return the value associated with the column: IS_CHECK_DRAW
	 */
	public Boolean getIsCheckDraw () {
		return isCheckDraw;
	}

	/**
	 * Set the value related to the column: IS_CHECK_DRAW
	 * @param isCheckDraw the IS_CHECK_DRAW value
	 */
	public void setIsCheckDraw (Boolean isCheckDraw) {
		this.isCheckDraw = isCheckDraw;
	}


	/**
	 * Return the value associated with the column: IS_IMPORTANT
	 */
	public Boolean getIsImportant () {
		return isImportant;
	}

	/**
	 * Set the value related to the column: IS_IMPORTANT
	 * @param isImportant the IS_IMPORTANT value
	 */
	public void setIsImportant (Boolean isImportant) {
		this.isImportant = isImportant;
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
	 * Return the value associated with the column: ACCEPT_STATUS_ID
	 */
	public com.justonetech.biz.domain.NetAcceptStatus getAcceptStatus () {
		return acceptStatus;
	}

	/**
	 * Set the value related to the column: ACCEPT_STATUS_ID
	 * @param acceptStatus the ACCEPT_STATUS_ID value
	 */
	public void setAcceptStatus (com.justonetech.biz.domain.NetAcceptStatus acceptStatus) {
		this.acceptStatus = acceptStatus;
	}


	/**
	 * Return the value associated with the column: netMonitors
	 */
	public java.util.Set<com.justonetech.biz.domain.NetMonitor> getNetMonitors () {
		return netMonitors;
	}

	/**
	 * Set the value related to the column: netMonitors
	 * @param netMonitors the netMonitors value
	 */
	public void setNetMonitors (java.util.Set<com.justonetech.biz.domain.NetMonitor> netMonitors) {
		this.netMonitors = netMonitors;
	}


	/**
	 * Return the value associated with the column: netApplyFbTypes
	 */
	public java.util.Set<com.justonetech.biz.domain.NetApplyFbType> getNetApplyFbTypes () {
		return netApplyFbTypes;
	}

	/**
	 * Set the value related to the column: netApplyFbTypes
	 * @param netApplyFbTypes the netApplyFbTypes value
	 */
	public void setNetApplyFbTypes (java.util.Set<com.justonetech.biz.domain.NetApplyFbType> netApplyFbTypes) {
		this.netApplyFbTypes = netApplyFbTypes;
	}


	/**
	 * Return the value associated with the column: netCfbs
	 */
	public java.util.Set<com.justonetech.biz.domain.NetCfb> getNetCfbs () {
		return netCfbs;
	}

	/**
	 * Set the value related to the column: netCfbs
	 * @param netCfbs the netCfbs value
	 */
	public void setNetCfbs (java.util.Set<com.justonetech.biz.domain.NetCfb> netCfbs) {
		this.netCfbs = netCfbs;
	}


	/**
	 * Return the value associated with the column: netContracts
	 */
	public java.util.Set<com.justonetech.biz.domain.NetContract> getNetContracts () {
		return netContracts;
	}

	/**
	 * Set the value related to the column: netContracts
	 * @param netContracts the netContracts value
	 */
	public void setNetContracts (java.util.Set<com.justonetech.biz.domain.NetContract> netContracts) {
		this.netContracts = netContracts;
	}


	/**
	 * Return the value associated with the column: netSgpermits
	 */
	public java.util.Set<com.justonetech.biz.domain.NetSgpermit> getNetSgpermits () {
		return netSgpermits;
	}

	/**
	 * Set the value related to the column: netSgpermits
	 * @param netSgpermits the netSgpermits value
	 */
	public void setNetSgpermits (java.util.Set<com.justonetech.biz.domain.NetSgpermit> netSgpermits) {
		this.netSgpermits = netSgpermits;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.NetApply)) return false;
		else {
			com.justonetech.biz.domain.NetApply netApply = (com.justonetech.biz.domain.NetApply) obj;
			if (null == this.getId() || null == netApply.getId()) return false;
			else return (this.getId().equals(netApply.getId()));
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
		builder.append(netCode);
		builder.append(netDate);
		builder.append(bjbh);
		builder.append(projectName);
		builder.append(buildUnitName);
		builder.append(buildAddress);
		builder.append(applyUnitName);
		builder.append(isCheckDraw);
		builder.append(isImportant);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}