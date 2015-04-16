package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;
import com.justonetech.biz.domain.DocDocument;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_PUBLIC_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 公共信息发布
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 公共信息发布
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_PUBLIC_INFO"
 */

public abstract class BaseOaPublicInfo implements Serializable, Auditable {

	public static String REF = "OaPublicInfo";
	public static String PROP_USER = "user";
	public static String PROP_CREATE_DEPT_NAME = "createDeptName";
	public static String PROP_DOCUMENT_ID = "documentId";
	public static String PROP_TYPE = "type";
	public static String PROP_IS_TOP = "isTop";
	public static String PROP_CREATE_DATE = "createDate";
	public static String PROP_TITLE = "title";
	public static String PROP_ICON_IMAGE = "iconImage";
	public static String PROP_VISIT_TIMES = "visitTimes";
	public static String PROP_REPORT_DATE = "reportDate";
	public static String PROP_ACCESS_RANGE = "accessRange";
	public static String PROP_IS_VALID = "isValid";
	public static String PROP_IS_PUBLIC = "isPublic";
	public static String PROP_ID = "id";
	public static String PROP_CONTENT = "content";
	public static String PROP_THUMBNAIL = "thumbnail";
	public static String PROP_OUTER_ID = "outerId";


	// constructors
	public BaseOaPublicInfo() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaPublicInfo(Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*标题*/
    /*标题*/
	private String title;

    /*内容*/
    /*内容*/
	private String content;

    /*来源单位/部门名称*/
    /*来源单位/部门名称*/
	private String createDeptName;

    /*创建日期*/
    /*创建日期*/
	private java.sql.Date createDate;

    /*是否发布*/
    /*是否发布*/
	private Boolean isPublic;

    /*发布时间*/
    /*发布时间*/
	private java.sql.Date reportDate;

    /*访问次数*/
    /*访问次数*/
	private Long visitTimes;

    /*是否有效*/
    /*是否有效*/
	private Boolean isValid;

    /*是否置顶*/
    /*是否置顶*/
	private Boolean isTop;

    //缩略图
	private String thumbnail;

    private Long outerId;  //外部记录ID


	// many to one
	private com.justonetech.system.domain.SysUser user;
	private com.justonetech.system.domain.SysCodeDetail accessRange;
	private com.justonetech.system.domain.SysCodeDetail type;
	private DocDocument iconImage;
    /*附件*/
	private DocDocument document;



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


    public DocDocument getIconImage() {
        return iconImage;
    }

    public void setIconImage(DocDocument iconImage) {
        this.iconImage = iconImage;
    }

    public DocDocument getDocument() {
        return document;
    }

    public void setDocument(DocDocument document) {
        this.document = document;
    }

    /**
	 * Return the value associated with the column: CREATE_DEPT_NAME
	 */
	public String getCreateDeptName () {
		return createDeptName;
	}

	/**
	 * Set the value related to the column: CREATE_DEPT_NAME
	 * @param createDeptName the CREATE_DEPT_NAME value
	 */
	public void setCreateDeptName (String createDeptName) {
		this.createDeptName = createDeptName;
	}


	/**
	 * Return the value associated with the column: CREATE_DATE
	 */
	public java.sql.Date getCreateDate () {
		return createDate;
	}

	/**
	 * Set the value related to the column: CREATE_DATE
	 * @param createDate the CREATE_DATE value
	 */
	public void setCreateDate (java.sql.Date createDate) {
		this.createDate = createDate;
	}


	/**
	 * Return the value associated with the column: IS_PUBLIC
	 */
	public Boolean getIsPublic () {
		return isPublic;
	}

	/**
	 * Set the value related to the column: IS_PUBLIC
	 * @param isPublic the IS_PUBLIC value
	 */
	public void setIsPublic (Boolean isPublic) {
		this.isPublic = isPublic;
	}


	/**
	 * Return the value associated with the column: REPORT_DATE
	 */
	public java.sql.Date getReportDate () {
		return reportDate;
	}

	/**
	 * Set the value related to the column: REPORT_DATE
	 * @param reportDate the REPORT_DATE value
	 */
	public void setReportDate (java.sql.Date reportDate) {
		this.reportDate = reportDate;
	}


	/**
	 * Return the value associated with the column: VISIT_TIMES
	 */
	public Long getVisitTimes () {
		return visitTimes;
	}

	/**
	 * Set the value related to the column: VISIT_TIMES
	 * @param visitTimes the VISIT_TIMES value
	 */
	public void setVisitTimes (Long visitTimes) {
		this.visitTimes = visitTimes;
	}


//	/**
//	 * Return the value associated with the column: DOCUMENT_ID
//	 */
//	public java.lang.Long getDocumentId () {
//		return documentId;
//	}
//
//	/**
//	 * Set the value related to the column: DOCUMENT_ID
//	 * @param documentId the DOCUMENT_ID value
//	 */
//	public void setDocumentId (java.lang.Long documentId) {
//		this.documentId = documentId;
//	}


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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Long getOuterId() {
        return outerId;
    }

    public void setOuterId(Long outerId) {
        this.outerId = outerId;
    }

    /**
	 * Return the value associated with the column: USER_ID
	 */
	public com.justonetech.system.domain.SysUser getUser () {
		return user;
	}

	/**
	 * Set the value related to the column: USER_ID
	 * @param user the USER_ID value
	 */
	public void setUser (com.justonetech.system.domain.SysUser user) {
		this.user = user;
	}


	/**
	 * Return the value associated with the column: ACCESS_RANGE
	 */
	public com.justonetech.system.domain.SysCodeDetail getAccessRange () {
		return accessRange;
	}

	/**
	 * Set the value related to the column: ACCESS_RANGE
	 * @param accessRange the ACCESS_RANGE value
	 */
	public void setAccessRange (com.justonetech.system.domain.SysCodeDetail accessRange) {
		this.accessRange = accessRange;
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



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaPublicInfo)) return false;
		else {
			com.justonetech.biz.domain.OaPublicInfo oaPublicInfo = (com.justonetech.biz.domain.OaPublicInfo) obj;
			if (null == this.getId() || null == oaPublicInfo.getId()) return false;
			else return (this.getId().equals(oaPublicInfo.getId()));
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
		builder.append(title);
		builder.append(content);
		builder.append(iconImage);
		builder.append(createDeptName);
		builder.append(createDate);
		builder.append(isPublic);
		builder.append(reportDate);
		builder.append(visitTimes);
		builder.append(document);
		builder.append(isValid);
		builder.append(isTop);
		builder.append(thumbnail);
		builder.append(outerId);
		return builder.toString();
	}


}