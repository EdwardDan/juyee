package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;
import com.justonetech.system.domain.SysCodeDetail;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_RECEIVE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 收文管理
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 收文管理
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_RECEIVE"
 */

public abstract class BaseOaReceive  implements Serializable,Auditable {

	public static String REF = "OaReceive";
    public static String PROP_ID = "id";
    public static String PROP_STEP = "step";
    public static String PROP_SECRET = "secret";
    public static String PROP_SOURCE_DEPT = "sourceDept";
    public static String PROP_DEAL_DEPTS = "dealDepts";
    public static String PROP_DEAL_CONTENT = "dealContent";
    public static String PROP_TYPE = "type";
    public static String PROP_FILE_CODE = "fileCode";
    public static String PROP_START_DEPT= "startDept";
    public static String PROP_URGENT = "urgent";
    public static String PROP_CODE = "code";
    public static String PROP_TITLE = "title";
    public static String PROP_LIMIT_DATE = "limitDate";
    public static String PROP_NODE_RECEIVE_TIME = "nodeReceiveTime";
    public static String PROP_DEPT_NAME = "deptName";
    public static String PROP_WRITTEN_DATE = "writtenDate";
    public static String PROP_FILE_TYPE = "fileType";
    public static String PROP_RECEIVE_DATE = "receiveDate";
    public static String PROP_DEAL_PERSONS = "dealPersons";
    public static String PROP_BLJG_PERSONS = "bljgPersons";
    public static String PROP_FS = "fs";
    public static String PROP_YS = "ys";
    public static String PROP_DOC = "doc";
    public static String PROP_CREATE_USER = "createUser";
    public static String PROP_CREATE_TIME = "createTime";
    public static String PROP_UPDATE_TIME = "updateTime";
    public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseOaReceive () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaReceive (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*收文编号*/
    /*收文编号*/
	private String code;

    // fields
    /*年份*/
    /*年份*/
    private Integer year;

    // fields
    /*序号*/
    /*序号*/
    private Integer orderNo;
	
    /*来文文号*/
    /*来文文号*/
	private String fileCode;
	
    /*标题*/
    /*标题*/
	private String title;
	
    /*来文单位*/
    /*来文单位*/
	private String sourceDept;
	
    /*登记日期*/
    /*登记日期*/
	private java.sql.Timestamp receiveDate;
	
    /*提供部门*/
    /*提供部门*/
	private String deptName;
	
    /*成文日期*/
    /*成文日期*/
	private java.sql.Timestamp writtenDate;
	
    /*办理时限*/
    /*办理时限*/
	private java.sql.Timestamp limitDate;

	/*记录各审核步骤收到时间*/
    /*记录各审核步骤收到时间*/
	private java.sql.Timestamp nodeReceiveTime;

    /*份数*/
    /*份数*/
	private Integer fs;
	
    /*页数*/
    /*页数*/
	private Integer ys;
	
    /*牵头部门ID*/
    /*牵头部门ID*/
	private String startDept;
	
    /*处理人IDs*/
    /*处理人IDs*/
	private String dealPersons;

    /*处理部门IDs*/
    /*处理部门IDs*/
	private String dealDepts;

    /*办理结果审核人IDs*/
    /*办理结果审核人IDs*/
    private String bljgPersons;

    /*批办*/
    /*批办*/
	private String dealContent;

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
	private com.justonetech.biz.domain.DocDocument doc;
	private com.justonetech.system.domain.SysCodeDetail fileType;
	private com.justonetech.system.domain.SysCodeDetail urgent;
	private com.justonetech.system.domain.SysCodeDetail type;
	private com.justonetech.biz.domain.OaReceiveStep step;
	private com.justonetech.system.domain.SysCodeDetail secret;
	private com.justonetech.system.domain.SysCodeDetail lwdw;

	// collections
	private java.util.Set<com.justonetech.biz.domain.OaReceiveNode> oaReceiveNodes;



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
     * Return the value associated with the column: ORDER_NO
     */
    public Integer getOrderNo () {
        return orderNo;
    }

    /**
     * Set the value related to the column: ORDER_NO
     * @param orderNo the ORDER_NO value
     */
    public void setOrderNo (Integer orderNo) {
        this.orderNo = orderNo;
    }

	/**
	 * Return the value associated with the column: FILE_CODE
	 */
	public String getFileCode () {
		return fileCode;
	}

	/**
	 * Set the value related to the column: FILE_CODE
	 * @param fileCode the FILE_CODE value
	 */
	public void setFileCode (String fileCode) {
		this.fileCode = fileCode;
	}


	/**
	 * Return the value associated with the column: TITLE
	 */
	public String getTitle () {
		return title;
	}

	/**
	 * Set the value related to the column: TITLE
	 * @param title the TITLE value
	 */
	public void setTitle (String title) {
		this.title = title;
	}


	/**
	 * Return the value associated with the column: SOURCE_DEPT
	 */
	public String getSourceDept () {
		return sourceDept;
	}

	/**
	 * Set the value related to the column: SOURCE_DEPT
	 * @param sourceDept the SOURCE_DEPT value
	 */
	public void setSourceDept (String sourceDept) {
		this.sourceDept = sourceDept;
	}


	/**
	 * Return the value associated with the column: RECEIVE_DATE
	 */
	public java.sql.Timestamp getReceiveDate () {
		return receiveDate;
	}

	/**
	 * Set the value related to the column: RECEIVE_DATE
	 * @param receiveDate the RECEIVE_DATE value
	 */
	public void setReceiveDate (java.sql.Timestamp receiveDate) {
		this.receiveDate = receiveDate;
	}


	/**
	 * Return the value associated with the column: DEPT_NAME
	 */
	public String getDeptName () {
		return deptName;
	}

	/**
	 * Set the value related to the column: DEPT_NAME
	 * @param deptName the DEPT_NAME value
	 */
	public void setDeptName (String deptName) {
		this.deptName = deptName;
	}


	/**
	 * Return the value associated with the column: WRITTEN_DATE
	 */
	public java.sql.Timestamp getWrittenDate () {
		return writtenDate;
	}

	/**
	 * Set the value related to the column: WRITTEN_DATE
	 * @param writtenDate the WRITTEN_DATE value
	 */
	public void setWrittenDate (java.sql.Timestamp writtenDate) {
		this.writtenDate = writtenDate;
	}


	/**
	 * Return the value associated with the column: LIMIT_DATE
	 */
	public java.sql.Timestamp getLimitDate () {
		return limitDate;
	}

	/**
	 * Set the value related to the column: LIMIT_DATE
	 * @param limitDate the LIMIT_DATE value
	 */
	public void setLimitDate (java.sql.Timestamp limitDate) {
		this.limitDate = limitDate;
	}

	/**
	 * Return the value associated with the column: NODE_RECEIVE_TIME
	 */
	public java.sql.Timestamp getNodeReceiveTime () {
		return nodeReceiveTime;
	}

	/**
	 * Set the value related to the column: NODE_RECEIVE_TIME
	 * @param nodeReceiveTime the NODE_RECEIVE_TIME value
	 */
	public void setNodeReceiveTime (java.sql.Timestamp nodeReceiveTime) {
		this.nodeReceiveTime = nodeReceiveTime;
	}


	/**
	 * Return the value associated with the column: FS
	 */
	public Integer getFs () {
		return fs;
	}

	/**
	 * Set the value related to the column: FS
	 * @param fs the FS value
	 */
	public void setFs (Integer fs) {
		this.fs = fs;
	}


	/**
	 * Return the value associated with the column: YS
	 */
	public Integer getYs () {
		return ys;
	}

	/**
	 * Set the value related to the column: YS
	 * @param ys the YS value
	 */
	public void setYs (Integer ys) {
		this.ys = ys;
	}


	/**
	 * Return the value associated with the column: START_DEPT_ID
	 */
	public String getStartDept () {
		return startDept;
	}

	/**
	 * Set the value related to the column: START_DEPT
	 * @param startDept the START_DEPT value
	 */
	public void setStartDept (String startDept) {
		this.startDept = startDept;
	}


	/**
	 * Return the value associated with the column: DEAL_PERSONS
	 */
	public String getDealPersons () {
		return dealPersons;
	}

	/**
	 * Set the value related to the column: DEAL_PERSONS
	 * @param dealPersons the DEAL_PERSONS value
	 */
	public void setDealPersons (String dealPersons) {
		this.dealPersons = dealPersons;
	}


	/**
	 * Return the value associated with the column: DEAL_DEPTS
	 */
	public String getDealDepts () {
		return dealDepts;
	}

	/**
	 * Set the value related to the column: DEAL_DEPTS
	 * @param dealDepts the DEAL_DEPTS value
	 */
	public void setDealDepts (String dealDepts) {
		this.dealDepts = dealDepts;
	}
/**
	 * Return the value associated with the column: BLJG_PERSONS
	 */
	public String getBljgPersons () {
		return bljgPersons;
	}

	/**
	 * Set the value related to the column: BLJG_PERSONS
	 * @param bljgPersons the BLJG_PERSONS value
	 */
	public void setBljgPersons (String bljgPersons) {
		this.bljgPersons = bljgPersons;
	}

/**
	 * Return the value associated with the column: DEAL_CONTENT
	 */
	public String getDealContent() {
		return dealContent;
	}

	/**
	 * Set the value related to the column: DEAL_CONTENT
	 * @param dealContent the DEAL_CONTENT value
	 */
	public void setDealContent (String dealContent) {
		this.dealContent = dealContent;
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
	 * Return the value associated with the column: DOC_ID
	 */
	public com.justonetech.biz.domain.DocDocument getDoc () {
		return doc;
	}

	/**
	 * Set the value related to the column: DOC_ID
	 * @param doc the DOC_ID value
	 */
	public void setDoc (com.justonetech.biz.domain.DocDocument doc) {
		this.doc = doc;
	}


	/**
	 * Return the value associated with the column: FILE_TYPE_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getFileType () {
		return fileType;
	}

	/**
	 * Set the value related to the column: FILE_TYPE_ID
	 * @param fileType the FILE_TYPE_ID value
	 */
	public void setFileType (com.justonetech.system.domain.SysCodeDetail fileType) {
		this.fileType = fileType;
	}


	/**
	 * Return the value associated with the column: URGENT_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getUrgent () {
		return urgent;
	}

	/**
	 * Set the value related to the column: URGENT_ID
	 * @param urgent the URGENT_ID value
	 */
	public void setUrgent (com.justonetech.system.domain.SysCodeDetail urgent) {
		this.urgent = urgent;
	}


	/**
	 * Return the value associated with the column: TYPE_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getType () {
		return type;
	}

	/**
	 * Set the value related to the column: TYPE_ID
	 * @param type the TYPE_ID value
	 */
	public void setType (com.justonetech.system.domain.SysCodeDetail type) {
		this.type = type;
	}


	/**
	 * Return the value associated with the column: STEP_ID
	 */
	public com.justonetech.biz.domain.OaReceiveStep getStep () {
		return step;
	}

	/**
	 * Set the value related to the column: STEP_ID
	 * @param step the STEP_ID value
	 */
	public void setStep (com.justonetech.biz.domain.OaReceiveStep step) {
		this.step = step;
	}


	/**
	 * Return the value associated with the column: SECRET_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getSecret () {
		return secret;
	}

	/**
	 * Set the value related to the column: SECRET_ID
	 * @param secret the SECRET_ID value
	 */
	public void setSecret (com.justonetech.system.domain.SysCodeDetail secret) {
		this.secret = secret;
	}

    public SysCodeDetail getLwdw() {
        return lwdw;
    }

    public void setLwdw(SysCodeDetail lwdw) {
        this.lwdw = lwdw;
    }

    /**
	 * Return the value associated with the column: oaReceiveNodes
	 */
	public java.util.Set<com.justonetech.biz.domain.OaReceiveNode> getOaReceiveNodes () {
		if(oaReceiveNodes == null){
			oaReceiveNodes = new java.util.LinkedHashSet<com.justonetech.biz.domain.OaReceiveNode>();
		}
		return oaReceiveNodes;
	}

	/**
	 * Set the value related to the column: oaReceiveNodes
	 * @param oaReceiveNodes the oaReceiveNodes value
	 */
	public void setOaReceiveNodes (java.util.Set<com.justonetech.biz.domain.OaReceiveNode> oaReceiveNodes) {
		this.oaReceiveNodes = oaReceiveNodes;
	}

	public void addTooaReceiveNodes (com.justonetech.biz.domain.OaReceiveNode oaReceiveNode) {
		if (null == getOaReceiveNodes()) setOaReceiveNodes(new java.util.LinkedHashSet<com.justonetech.biz.domain.OaReceiveNode>());
		getOaReceiveNodes().add(oaReceiveNode);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaReceive)) return false;
		else {
			com.justonetech.biz.domain.OaReceive oaReceive = (com.justonetech.biz.domain.OaReceive) obj;
			if (null == this.getId() || null == oaReceive.getId()) return false;
			else return (this.getId().equals(oaReceive.getId()));
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
		builder.append(fileCode);
		builder.append(title);
		builder.append(sourceDept);
		builder.append(receiveDate);
		builder.append(deptName);
		builder.append(writtenDate);
		builder.append(limitDate);
		builder.append(nodeReceiveTime);
		builder.append(fs);
		builder.append(ys);
		builder.append(startDept);
		builder.append(dealPersons);
		builder.append(dealDepts);
        builder.append(bljgPersons);
        builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}