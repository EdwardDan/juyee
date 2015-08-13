package com.justonetech.biz.domain.base;

import com.justonetech.biz.domain.DocDocument;
import com.justonetech.biz.domain.OaSendFile;
import com.justonetech.core.entity.Auditable;
import com.justonetech.system.domain.SysCodeDetail;

import java.io.Serializable;
import java.sql.Date;


/**
 * This is an object that contains data related to the OA_SEND_FILE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 发文记录
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 发文记录
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_SEND_FILE"
 */

public abstract class BaseOaSendFile implements Serializable,Auditable {

	public static String REF = "OaSendFile";
    public static String PROP_ID = "id";
    public static String PROP_FILE_CODE = "fileCode";
    public static String PROP_FILE_TITLE = "fileTitle";
    public static String PROP_SEND_DEPT = "sendDept";
    public static String PROP_CC_DEPT = "ccDept";
    public static String PROP_WRITTEN_DEPT = "writtenDept";
    public static String PROP_WRITTEN_DATE = "writtenDate";
    public static String PROP_DESCRIPTION = "description";
    public static String PROP_CREATE_USER = "createUser";
    public static String PROP_CREATE_TIME = "createTime";
    public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_UPDATE_USER = "updateUser";
    public static String PROP_FILE_DOC = "fileDoc";
    public static String PROP_TYPE = "type";
    public static String PROP_SECRET = "secret";
    public static String PROP_EMERGENCY = "emergency";


	// constructors
	public BaseOaSendFile() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaSendFile(Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*发文标题*/
    /*发文标题*/
	private String fileTitle;

    /*发文字号*/
    /*发文字号*/
	private String fileCode;

    /*主送机关*/
    /*主送机关*/
	private String sendDept;

	/*抄送机关*/
    /*抄送机关*/
	private String ccDept;

	/*成文机关*/
    /*成文机关*/
	private String writtenDept;

    /*成文日期*/
    /*成文日期*/
	private java.sql.Date writtenDate;

    /*备注*/
    /*备注*/
    private java.lang.String description;

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
	private DocDocument fileDoc;
    private SysCodeDetail type;
    private SysCodeDetail secret;
    private SysCodeDetail emergency;

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
	 * Return the value associated with the column: FILE_TITLE
	 */
	public String getFileTitle () {
		return fileTitle;
	}

	/**
	 * Set the value related to the column: FILE_TITLE
	 * @param fileTitle the FILE_TITLE value
	 */
	public void setFileTitle (String fileTitle) {
		this.fileTitle = fileTitle;
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
	 * Return the value associated with the column: SEND_DEPT
	 */
	public String getSendDept () {
		return sendDept;
	}

	/**
	 * Set the value related to the column: SEND_DEPT
	 * @param sendDept the SEND_DEPT value
	 */
	public void setSendDept (String sendDept) {
		this.sendDept = sendDept;
	}

    public String getCcDept() {
        return ccDept;
    }

    public void setCcDept(String ccDept) {
        this.ccDept = ccDept;
    }

    public String getWrittenDept() {
        return writtenDept;
    }

    public void setWrittenDept(String writtenDept) {
        this.writtenDept = writtenDept;
    }

    public Date getWrittenDate() {
        return writtenDate;
    }

    public void setWrittenDate(Date writtenDate) {
        this.writtenDate = writtenDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
	 * Return the value associated with the column: FILE_DOC_ID
	 */
	public DocDocument getFileDoc () {
		return fileDoc;
	}

	/**
	 * Set the value related to the column: FILE_DOC_ID
	 * @param fileDoc the FILE_DOC_ID value
	 */
	public void setFileDoc (DocDocument fileDoc) {
		this.fileDoc = fileDoc;
	}

    public SysCodeDetail getType() {
        return type;
    }

    public void setType(SysCodeDetail type) {
        this.type = type;
    }

    public SysCodeDetail getSecret() {
        return secret;
    }

    public void setSecret(SysCodeDetail secret) {
        this.secret = secret;
    }

    public SysCodeDetail getEmergency() {
        return emergency;
    }

    public void setEmergency(SysCodeDetail emergency) {
        this.emergency = emergency;
    }

    public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof OaSendFile)) return false;
		else {
			OaSendFile oaSendFile = (OaSendFile) obj;
			if (null == this.getId() || null == oaSendFile.getId()) return false;
			else return (this.getId().equals(oaSendFile.getId()));
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
		builder.append(fileTitle);
		builder.append(fileCode);
		builder.append(sendDept);
		builder.append(ccDept);
		builder.append(writtenDept);
		builder.append(writtenDate);
		builder.append(writtenDate);
		builder.append(createTime);
		builder.append(updateTime);
		builder.append(updateUser);
		builder.append(createUser);
		return builder.toString();
	}


}