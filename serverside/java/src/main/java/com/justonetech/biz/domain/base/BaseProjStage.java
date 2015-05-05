package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;
import com.justonetech.core.entity.Treeable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PROJ_STAGE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目办证阶段管理
 * SyncTemplatepatterns : tree\w*
 * SyncDao : false
 * TableName : 项目办证阶段管理
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : true
 * SubSystem : project
 * Projectable : false
 *
 * @hibernate.class
 *  table="PROJ_STAGE"
 */

public abstract class BaseProjStage  implements Serializable,Auditable,Treeable {

	public static String REF = "ProjStage";
	public static String PROP_PARENT = "parent";
	public static String PROP_DEFAULT_DAYS = "defaultDays";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_CODE = "code";
	public static String PROP_LINK_INFO = "linkInfo";
	public static String PROP_NAME = "name";
	public static String PROP_YEAR = "year";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_IS_LEAF = "isLeaf";
	public static String PROP_IS_VALID = "isValid";
	public static String PROP_ALERT_DAYS = "alertDays";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_ID = "id";
	public static String PROP_TREE_ID = "treeId";
	public static String PROP_AUDIT_DEPT = "auditDept";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseProjStage () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProjStage (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*年份*/
    /*年份*/
	private Integer year;
	
    /*编码*/
    /*编码*/
	private String code;
	
    /*名称*/
    /*名称*/
	private String name;
	
    /*审批部门*/
    /*审批部门*/
	private String auditDept;
	
    /*是否有效*/
    /*是否有效*/
	private Boolean isValid;
	
    /*缺省工作周期(天)*/
    /*缺省工作周期(天)*/
	private Integer defaultDays;
	
    /*预警期限(天)*/
    /*预警期限(天)*/
	private Integer alertDays;
	
    /*办证联系信息*/
    /*办证联系信息*/
	private String linkInfo;
	
    /*是否叶节点*/
    /*是否叶节点*/
	private Boolean isLeaf;
	
    /*树形层次*/
    /*树形层次*/
	private String treeId;
	
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
	private com.justonetech.biz.domain.ProjStage parent;

	// collections
	private java.util.Set<com.justonetech.biz.domain.ProjStage> projStages;
	private java.util.Set<com.justonetech.biz.domain.DataStageReportItem> dataStageReportItems;



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
	 * Return the value associated with the column: AUDIT_DEPT
	 */
	public String getAuditDept () {
		return auditDept;
	}

	/**
	 * Set the value related to the column: AUDIT_DEPT
	 * @param auditDept the AUDIT_DEPT value
	 */
	public void setAuditDept (String auditDept) {
		this.auditDept = auditDept;
	}


	/**
	 * Return the value associated with the column: IS_VALID
	 */
	public Boolean getIsValid () {
		return isValid;
	}

	/**
	 * Set the value related to the column: IS_VALID
	 * @param isValid the IS_VALID value
	 */
	public void setIsValid (Boolean isValid) {
		this.isValid = isValid;
	}


	/**
	 * Return the value associated with the column: DEFAULT_DAYS
	 */
	public Integer getDefaultDays () {
		return defaultDays;
	}

	/**
	 * Set the value related to the column: DEFAULT_DAYS
	 * @param defaultDays the DEFAULT_DAYS value
	 */
	public void setDefaultDays (Integer defaultDays) {
		this.defaultDays = defaultDays;
	}


	/**
	 * Return the value associated with the column: ALERT_DAYS
	 */
	public Integer getAlertDays () {
		return alertDays;
	}

	/**
	 * Set the value related to the column: ALERT_DAYS
	 * @param alertDays the ALERT_DAYS value
	 */
	public void setAlertDays (Integer alertDays) {
		this.alertDays = alertDays;
	}


	/**
	 * Return the value associated with the column: LINK_INFO
	 */
	public String getLinkInfo () {
		return linkInfo;
	}

	/**
	 * Set the value related to the column: LINK_INFO
	 * @param linkInfo the LINK_INFO value
	 */
	public void setLinkInfo (String linkInfo) {
		this.linkInfo = linkInfo;
	}


	/**
	 * Return the value associated with the column: IS_LEAF
	 */
	public Boolean getIsLeaf () {
		return isLeaf;
	}

	/**
	 * Set the value related to the column: IS_LEAF
	 * @param isLeaf the IS_LEAF value
	 */
	public void setIsLeaf (Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}


	/**
	 * Return the value associated with the column: TREE_ID
	 */
	public String getTreeId () {
		return treeId;
	}

	/**
	 * Set the value related to the column: TREE_ID
	 * @param treeId the TREE_ID value
	 */
	public void setTreeId (String treeId) {
		this.treeId = treeId;
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
	 * Return the value associated with the column: PARENT_ID
	 */
	public com.justonetech.biz.domain.ProjStage getParent () {
		return parent;
	}

	/**
	 * Set the value related to the column: PARENT_ID
	 * @param parent the PARENT_ID value
	 */
	public void setParent (com.justonetech.biz.domain.ProjStage parent) {
		this.parent = parent;
	}


	/**
	 * Return the value associated with the column: projStages
	 */
	public java.util.Set<com.justonetech.biz.domain.ProjStage> getProjStages () {
		if(projStages == null){
			projStages = new java.util.LinkedHashSet<com.justonetech.biz.domain.ProjStage>();
		}
		return projStages;
	}

	/**
	 * Set the value related to the column: projStages
	 * @param projStages the projStages value
	 */
	public void setProjStages (java.util.Set<com.justonetech.biz.domain.ProjStage> projStages) {
		this.projStages = projStages;
	}

	public void addToprojStages (com.justonetech.biz.domain.ProjStage projStage) {
		if (null == getProjStages()) setProjStages(new java.util.LinkedHashSet<com.justonetech.biz.domain.ProjStage>());
		getProjStages().add(projStage);
	}


	/**
	 * Return the value associated with the column: dataStageReportItems
	 */
	public java.util.Set<com.justonetech.biz.domain.DataStageReportItem> getDataStageReportItems () {
		return dataStageReportItems;
	}

	/**
	 * Set the value related to the column: dataStageReportItems
	 * @param dataStageReportItems the dataStageReportItems value
	 */
	public void setDataStageReportItems (java.util.Set<com.justonetech.biz.domain.DataStageReportItem> dataStageReportItems) {
		this.dataStageReportItems = dataStageReportItems;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ProjStage)) return false;
		else {
			com.justonetech.biz.domain.ProjStage projStage = (com.justonetech.biz.domain.ProjStage) obj;
			if (null == this.getId() || null == projStage.getId()) return false;
			else return (this.getId().equals(projStage.getId()));
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
		builder.append(year);
		builder.append(code);
		builder.append(name);
		builder.append(auditDept);
		builder.append(isValid);
		builder.append(defaultDays);
		builder.append(alertDays);
		builder.append(linkInfo);
		builder.append(isLeaf);
		builder.append(treeId);
		builder.append(createTime);
		builder.append(updateTime);
		builder.append(createUser);
		builder.append(updateUser);
		return builder.toString();
	}


}