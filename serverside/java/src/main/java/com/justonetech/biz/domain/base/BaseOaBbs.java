package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_BBS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 员工论坛
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 员工论坛
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_BBS"
 */

public abstract class BaseOaBbs  implements Serializable,Auditable {

	public static String REF = "OaBbs";
	public static String PROP_PARENT = "parent";
	public static String PROP_DOCUMENT = "document";
	public static String PROP_REPLY_TIMES = "replyTimes";
	public static String PROP_PERSON_NAME = "personName";
	public static String PROP_TYPE = "type";
	public static String PROP_IS_TOP = "isTop";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_TYPE_NAME = "typeName";
	public static String PROP_TITLE = "title";
	public static String PROP_VISIT_TIMES = "visitTimes";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_DEPT_NAME = "deptName";
	public static String PROP_IS_VALID = "isValid";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_ID = "id";
	public static String PROP_CONTENT = "content";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseOaBbs () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaBbs (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*类型中文描述(冗余)*/
    /*类型中文描述(冗余)*/
	private String typeName;
	
    /*主题名称*/
    /*主题名称*/
	private String title;
	
    /*主要内容*/
    /*主要内容*/
	private String content;
	
    /*访问次数*/
    /*访问次数*/
	private Integer visitTimes;
	
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
	
    /*发布人姓名(冗余)*/
    /*发布人姓名(冗余)*/
	private String personName;
	
    /*是否有效*/
    /*是否有效*/
	private Boolean isValid;
	
    /*是否精华*/
    /*是否精华*/
	private Boolean isTop;
	
    /*回复次数*/
    /*回复次数*/
	private Integer replyTimes;
	
    /*所属部门名称(冗余)*/
    /*所属部门名称(冗余)*/
	private String deptName;
	

	// many to one
	private com.justonetech.biz.domain.DocDocument document;
	private com.justonetech.system.domain.SysCodeDetail type;
	private com.justonetech.biz.domain.OaBbs parent;

	// collections
	private java.util.Set<com.justonetech.biz.domain.OaBbs> oaBbs;



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
	 * Return the value associated with the column: TYPE_NAME
	 */
	public String getTypeName () {
		return typeName;
	}

	/**
	 * Set the value related to the column: TYPE_NAME
	 * @param typeName the TYPE_NAME value
	 */
	public void setTypeName (String typeName) {
		this.typeName = typeName;
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
	 * Return the value associated with the column: VISIT_TIMES
	 */
	public Integer getVisitTimes () {
		return visitTimes;
	}

	/**
	 * Set the value related to the column: VISIT_TIMES
	 * @param visitTimes the VISIT_TIMES value
	 */
	public void setVisitTimes (Integer visitTimes) {
		this.visitTimes = visitTimes;
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
	 * Return the value associated with the column: PERSON_NAME
	 */
	public String getPersonName () {
		return personName;
	}

	/**
	 * Set the value related to the column: PERSON_NAME
	 * @param personName the PERSON_NAME value
	 */
	public void setPersonName (String personName) {
		this.personName = personName;
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
	 * Return the value associated with the column: IS_TOP
	 */
	public Boolean getIsTop () {
		return isTop;
	}

	/**
	 * Set the value related to the column: IS_TOP
	 * @param isTop the IS_TOP value
	 */
	public void setIsTop (Boolean isTop) {
		this.isTop = isTop;
	}


	/**
	 * Return the value associated with the column: REPLY_TIMES
	 */
	public Integer getReplyTimes () {
		return replyTimes;
	}

	/**
	 * Set the value related to the column: REPLY_TIMES
	 * @param replyTimes the REPLY_TIMES value
	 */
	public void setReplyTimes (Integer replyTimes) {
		this.replyTimes = replyTimes;
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
	 * Return the value associated with the column: DOCUMENT_ID
	 */
	public com.justonetech.biz.domain.DocDocument getDocument () {
		return document;
	}

	/**
	 * Set the value related to the column: DOCUMENT_ID
	 * @param document the DOCUMENT_ID value
	 */
	public void setDocument (com.justonetech.biz.domain.DocDocument document) {
		this.document = document;
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
	 * Return the value associated with the column: PARENT_ID
	 */
	public com.justonetech.biz.domain.OaBbs getParent () {
		return parent;
	}

	/**
	 * Set the value related to the column: PARENT_ID
	 * @param parent the PARENT_ID value
	 */
	public void setParent (com.justonetech.biz.domain.OaBbs parent) {
		this.parent = parent;
	}


	/**
	 * Return the value associated with the column: oaBbs
	 */
	public java.util.Set<com.justonetech.biz.domain.OaBbs> getOaBbs () {
		if(oaBbs == null){
			oaBbs = new java.util.LinkedHashSet<com.justonetech.biz.domain.OaBbs>();
		}
		return oaBbs;
	}

	/**
	 * Set the value related to the column: oaBbs
	 * @param oaBbs the oaBbs value
	 */
	public void setOaBbs (java.util.Set<com.justonetech.biz.domain.OaBbs> oaBbs) {
		this.oaBbs = oaBbs;
	}

	public void addTooaBbs (com.justonetech.biz.domain.OaBbs oaBbs) {
		if (null == getOaBbs()) setOaBbs(new java.util.LinkedHashSet<com.justonetech.biz.domain.OaBbs>());
		getOaBbs().add(oaBbs);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaBbs)) return false;
		else {
			com.justonetech.biz.domain.OaBbs oaBbs = (com.justonetech.biz.domain.OaBbs) obj;
			if (null == this.getId() || null == oaBbs.getId()) return false;
			else return (this.getId().equals(oaBbs.getId()));
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
		builder.append(typeName);
		builder.append(title);
		builder.append(content);
		builder.append(visitTimes);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		builder.append(personName);
		builder.append(isValid);
		builder.append(isTop);
		builder.append(replyTimes);
		builder.append(deptName);
		return builder.toString();
	}


}