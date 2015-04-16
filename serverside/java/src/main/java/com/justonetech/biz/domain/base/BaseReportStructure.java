package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;
import com.justonetech.core.entity.Treeable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the REPORT_STRUCTURE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 综合报表结构维护
 * SyncTemplatepatterns : tree\w*
 * SyncDao : false
 * TableName : 综合报表结构维护
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : true
 * SubSystem : report
 * Projectable : false
 *
 * @hibernate.class
 *  table="REPORT_STRUCTURE"
 */

public abstract class BaseReportStructure  implements Serializable,Auditable,Treeable {

	public static String REF = "ReportStructure";
	public static String PROP_PARENT = "parent";
	public static String PROP_REPORT_DEPT_DEFINE = "reportDeptDefine";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_CODE = "code";
	public static String PROP_NAME = "name";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_IS_LEAF = "isLeaf";
	public static String PROP_IS_SUM_ACCU = "isSumAccu";
	public static String PROP_MEASURE_UNIT = "measureUnit";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_ID = "id";
	public static String PROP_VERSION = "version";
	public static String PROP_TREE_ID = "treeId";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseReportStructure () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseReportStructure (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*名称*/
    /*名称*/
	private String name;
	
    /*是否计算累计值*/
    /*是否计算累计值*/
	private Boolean isSumAccu;
	
    /*树形层次*/
    /*树形层次*/
	private String treeId;
	
    /*是否叶节点*/
    /*是否叶节点*/
	private Boolean isLeaf;
	
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
	
    /*编码*/
    /*编码*/
	private String code;
	

	// many to one
	private com.justonetech.biz.domain.ReportDeptDefine reportDeptDefine;
	private com.justonetech.biz.domain.ReportStructure parent;
	private com.justonetech.system.domain.SysCodeDetail measureUnit;
	private com.justonetech.biz.domain.ReportStructureVer version;

	// collections
	private java.util.Set<com.justonetech.biz.domain.ReportStructure> reportStructures;
	private java.util.Set<com.justonetech.biz.domain.ReportMonthDetail> reportMonthDetails;



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
	 * Return the value associated with the column: IS_SUM_ACCU
	 */
	public Boolean getIsSumAccu () {
		return isSumAccu;
	}

	/**
	 * Set the value related to the column: IS_SUM_ACCU
	 * @param isSumAccu the IS_SUM_ACCU value
	 */
	public void setIsSumAccu (Boolean isSumAccu) {
		this.isSumAccu = isSumAccu;
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
	 * Return the value associated with the column: REPORT_DEPT_DEFINE_ID
	 */
	public com.justonetech.biz.domain.ReportDeptDefine getReportDeptDefine () {
		return reportDeptDefine;
	}

	/**
	 * Set the value related to the column: REPORT_DEPT_DEFINE_ID
	 * @param reportDeptDefine the REPORT_DEPT_DEFINE_ID value
	 */
	public void setReportDeptDefine (com.justonetech.biz.domain.ReportDeptDefine reportDeptDefine) {
		this.reportDeptDefine = reportDeptDefine;
	}


	/**
	 * Return the value associated with the column: PARENT_ID
	 */
	public com.justonetech.biz.domain.ReportStructure getParent () {
		return parent;
	}

	/**
	 * Set the value related to the column: PARENT_ID
	 * @param parent the PARENT_ID value
	 */
	public void setParent (com.justonetech.biz.domain.ReportStructure parent) {
		this.parent = parent;
	}


	/**
	 * Return the value associated with the column: MEASURE_UNIT_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getMeasureUnit () {
		return measureUnit;
	}

	/**
	 * Set the value related to the column: MEASURE_UNIT_ID
	 * @param measureUnit the MEASURE_UNIT_ID value
	 */
	public void setMeasureUnit (com.justonetech.system.domain.SysCodeDetail measureUnit) {
		this.measureUnit = measureUnit;
	}


	/**
	 * Return the value associated with the column: VERSION_ID
	 */
	public com.justonetech.biz.domain.ReportStructureVer getVersion () {
		return version;
	}

	/**
	 * Set the value related to the column: VERSION_ID
	 * @param version the VERSION_ID value
	 */
	public void setVersion (com.justonetech.biz.domain.ReportStructureVer version) {
		this.version = version;
	}


	/**
	 * Return the value associated with the column: reportStructures
	 */
	public java.util.Set<com.justonetech.biz.domain.ReportStructure> getReportStructures () {
		if(reportStructures == null){
			reportStructures = new java.util.LinkedHashSet<com.justonetech.biz.domain.ReportStructure>();
		}
		return reportStructures;
	}

	/**
	 * Set the value related to the column: reportStructures
	 * @param reportStructures the reportStructures value
	 */
	public void setReportStructures (java.util.Set<com.justonetech.biz.domain.ReportStructure> reportStructures) {
		this.reportStructures = reportStructures;
	}

	public void addToreportStructures (com.justonetech.biz.domain.ReportStructure reportStructure) {
		if (null == getReportStructures()) setReportStructures(new java.util.LinkedHashSet<com.justonetech.biz.domain.ReportStructure>());
		getReportStructures().add(reportStructure);
	}


	/**
	 * Return the value associated with the column: reportMonthDetails
	 */
	public java.util.Set<com.justonetech.biz.domain.ReportMonthDetail> getReportMonthDetails () {
		return reportMonthDetails;
	}

	/**
	 * Set the value related to the column: reportMonthDetails
	 * @param reportMonthDetails the reportMonthDetails value
	 */
	public void setReportMonthDetails (java.util.Set<com.justonetech.biz.domain.ReportMonthDetail> reportMonthDetails) {
		this.reportMonthDetails = reportMonthDetails;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ReportStructure)) return false;
		else {
			com.justonetech.biz.domain.ReportStructure reportStructure = (com.justonetech.biz.domain.ReportStructure) obj;
			if (null == this.getId() || null == reportStructure.getId()) return false;
			else return (this.getId().equals(reportStructure.getId()));
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
		builder.append(isSumAccu);
		builder.append(treeId);
		builder.append(isLeaf);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		builder.append(code);
		return builder.toString();
	}


}