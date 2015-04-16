package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Treeable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_TASK_TYPE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 任务类型
 * SyncTemplatepatterns : tree\w*
 * SyncDao : false
 * TableName : 任务类型
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : true
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_TASK_TYPE"
 */

public abstract class BaseOaTaskType  implements Serializable,Treeable {

	public static String REF = "OaTaskType";
	public static String PROP_NAME = "name";
	public static String PROP_PARENT = "parent";
	public static String PROP_SCRIPT = "script";
	public static String PROP_IS_WORKFLOW = "isWorkflow";
	public static String PROP_TITLE_TEMPLATE = "titleTemplate";
	public static String PROP_URL = "url";
	public static String PROP_VIEW_URL = "viewUrl";
	public static String PROP_IS_LEAF = "isLeaf";
	public static String PROP_IS_VALID = "isValid";
	public static String PROP_ID = "id";
	public static String PROP_TREE_ID = "treeId";
	public static String PROP_CODE = "code";


	// constructors
	public BaseOaTaskType () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaTaskType (Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseOaTaskType (
		Long id,
		String name) {

		this.setId(id);
		this.setName(name);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*编码*/
    /*编码*/
	private String code;
	
    /*名称*/
    /*名称*/
	private String name;
	
    /*是否叶节点*/
    /*是否叶节点*/
	private Boolean isLeaf;
	
    /*树型层次*/
    /*树型层次*/
	private String treeId;
	
    /*执行链接*/
    /*执行链接*/
	private String url;
	
    /*查看链接*/
    /*查看链接*/
	private String viewUrl;
	
    /*是否流程任务*/
    /*是否流程任务*/
	private Boolean isWorkflow;
	
    /*是否有效*/
    /*是否有效*/
	private Boolean isValid;
	
    /*任务脚本*/
    /*任务脚本*/
	private String script;
	
    /*任务脚本*/
    /*任务脚本*/
	private String titleTemplate;
	

	// many to one
	private com.justonetech.biz.domain.OaTaskType parent;

	// collections
	private java.util.Set<com.justonetech.biz.domain.OaTaskLog> oaTaskLogs;
	private java.util.Set<com.justonetech.biz.domain.OaTaskType> oaTaskTypes;
	private java.util.Set<com.justonetech.biz.domain.OaTaskTypePrivilege> oaTaskTypePrivileges;
	private java.util.Set<com.justonetech.biz.domain.OaTask> oaTasks;



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
	 * Return the value associated with the column: URL
	 */
	public String getUrl () {
		return url;
	}

	/**
	 * Set the value related to the column: URL
	 * @param url the URL value
	 */
	public void setUrl (String url) {
		this.url = url;
	}


	/**
	 * Return the value associated with the column: VIEW_URL
	 */
	public String getViewUrl () {
		return viewUrl;
	}

	/**
	 * Set the value related to the column: VIEW_URL
	 * @param viewUrl the VIEW_URL value
	 */
	public void setViewUrl (String viewUrl) {
		this.viewUrl = viewUrl;
	}


	/**
	 * Return the value associated with the column: IS_WORKFLOW
	 */
	public Boolean getIsWorkflow () {
		return isWorkflow;
	}

	/**
	 * Set the value related to the column: IS_WORKFLOW
	 * @param isWorkflow the IS_WORKFLOW value
	 */
	public void setIsWorkflow (Boolean isWorkflow) {
		this.isWorkflow = isWorkflow;
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
	 * Return the value associated with the column: SCRIPT
	 */
	public String getScript () {
		return script;
	}

	/**
	 * Set the value related to the column: SCRIPT
	 * @param script the SCRIPT value
	 */
	public void setScript (String script) {
		this.script = script;
	}


	/**
	 * Return the value associated with the column: TITLE_TEMPLATE
	 */
	public String getTitleTemplate () {
		return titleTemplate;
	}

	/**
	 * Set the value related to the column: TITLE_TEMPLATE
	 * @param titleTemplate the TITLE_TEMPLATE value
	 */
	public void setTitleTemplate (String titleTemplate) {
		this.titleTemplate = titleTemplate;
	}


	/**
	 * Return the value associated with the column: PARENT_ID
	 */
	public com.justonetech.biz.domain.OaTaskType getParent () {
		return parent;
	}

	/**
	 * Set the value related to the column: PARENT_ID
	 * @param parent the PARENT_ID value
	 */
	public void setParent (com.justonetech.biz.domain.OaTaskType parent) {
		this.parent = parent;
	}


	/**
	 * Return the value associated with the column: oaTaskLogs
	 */
	public java.util.Set<com.justonetech.biz.domain.OaTaskLog> getOaTaskLogs () {
		return oaTaskLogs;
	}

	/**
	 * Set the value related to the column: oaTaskLogs
	 * @param oaTaskLogs the oaTaskLogs value
	 */
	public void setOaTaskLogs (java.util.Set<com.justonetech.biz.domain.OaTaskLog> oaTaskLogs) {
		this.oaTaskLogs = oaTaskLogs;
	}


	/**
	 * Return the value associated with the column: oaTaskTypes
	 */
	public java.util.Set<com.justonetech.biz.domain.OaTaskType> getOaTaskTypes () {
		if(oaTaskTypes == null){
			oaTaskTypes = new java.util.LinkedHashSet<com.justonetech.biz.domain.OaTaskType>();
		}
		return oaTaskTypes;
	}

	/**
	 * Set the value related to the column: oaTaskTypes
	 * @param oaTaskTypes the oaTaskTypes value
	 */
	public void setOaTaskTypes (java.util.Set<com.justonetech.biz.domain.OaTaskType> oaTaskTypes) {
		this.oaTaskTypes = oaTaskTypes;
	}

	public void addTooaTaskTypes (com.justonetech.biz.domain.OaTaskType oaTaskType) {
		if (null == getOaTaskTypes()) setOaTaskTypes(new java.util.LinkedHashSet<com.justonetech.biz.domain.OaTaskType>());
		getOaTaskTypes().add(oaTaskType);
	}


	/**
	 * Return the value associated with the column: oaTaskTypePrivileges
	 */
	public java.util.Set<com.justonetech.biz.domain.OaTaskTypePrivilege> getOaTaskTypePrivileges () {
		return oaTaskTypePrivileges;
	}

	/**
	 * Set the value related to the column: oaTaskTypePrivileges
	 * @param oaTaskTypePrivileges the oaTaskTypePrivileges value
	 */
	public void setOaTaskTypePrivileges (java.util.Set<com.justonetech.biz.domain.OaTaskTypePrivilege> oaTaskTypePrivileges) {
		this.oaTaskTypePrivileges = oaTaskTypePrivileges;
	}


	/**
	 * Return the value associated with the column: oaTasks
	 */
	public java.util.Set<com.justonetech.biz.domain.OaTask> getOaTasks () {
		return oaTasks;
	}

	/**
	 * Set the value related to the column: oaTasks
	 * @param oaTasks the oaTasks value
	 */
	public void setOaTasks (java.util.Set<com.justonetech.biz.domain.OaTask> oaTasks) {
		this.oaTasks = oaTasks;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaTaskType)) return false;
		else {
			com.justonetech.biz.domain.OaTaskType oaTaskType = (com.justonetech.biz.domain.OaTaskType) obj;
			if (null == this.getId() || null == oaTaskType.getId()) return false;
			else return (this.getId().equals(oaTaskType.getId()));
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
		builder.append(isLeaf);
		builder.append(treeId);
		builder.append(url);
		builder.append(viewUrl);
		builder.append(isWorkflow);
		builder.append(isValid);
		builder.append(script);
		builder.append(titleTemplate);
		return builder.toString();
	}


}