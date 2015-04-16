package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PAD_VERSION_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 手持版本信息
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 手持版本信息
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : pad
 * Projectable : false
 *
 * @hibernate.class
 *  table="PAD_VERSION_INFO"
 */

public abstract class BasePadVersionInfo  implements Serializable,Auditable {

	public static String REF = "PadVersionInfo";
	public static String PROP_VERSION_FORCE_FLAGE = "versionForceFlage";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_VERSION_CODE = "versionCode";
	public static String PROP_APK_DOC = "apkDoc";
	public static String PROP_VERSION_DESC = "versionDesc";
	public static String PROP_ID = "id";
	public static String PROP_VERSION_TYPE = "versionType";


	// constructors
	public BasePadVersionInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePadVersionInfo (Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePadVersionInfo (
		Long id,
		String versionCode) {

		this.setId(id);
		this.setVersionCode(versionCode);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*版本号*/
    /*版本号*/
	private String versionCode;

    /*强制更新标记*/
    /*强制更新标记*/
	private String versionForceFlage;

    /*版本描述*/
    /*版本描述*/
	private String versionDesc;

    /*版本类型（1 普通版、2 领导版）*/
    /*版本类型（1 普通版、2 领导版）*/
	private Long versionType;

    /*创建时间*/
    /*创建时间*/
	private java.sql.Timestamp createTime;

    /*创建人*/
    /*创建人*/
	private String createUser;


	// many to one
	private com.justonetech.biz.domain.DocDocument apkDoc;



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
	 * Return the value associated with the column: VERSION_CODE
	 */
	public String getVersionCode () {
		return versionCode;
}

	/**
	 * Set the value related to the column: VERSION_CODE
	 * @param versionCode the VERSION_CODE value
	 */
	public void setVersionCode (String versionCode) {
		this.versionCode = versionCode;
	}


	/**
	 * Return the value associated with the column: VERSION_FORCE_FLAGE
	 */
	public String getVersionForceFlage () {
		return versionForceFlage;
	}

	/**
	 * Set the value related to the column: VERSION_FORCE_FLAGE
	 * @param versionForceFlage the VERSION_FORCE_FLAGE value
	 */
	public void setVersionForceFlage (String versionForceFlage) {
		this.versionForceFlage = versionForceFlage;
	}


	/**
	 * Return the value associated with the column: VERSION_DESC
	 */
	public String getVersionDesc () {
		return versionDesc;
	}

	/**
	 * Set the value related to the column: VERSION_DESC
	 * @param versionDesc the VERSION_DESC value
	 */
	public void setVersionDesc (String versionDesc) {
		this.versionDesc = versionDesc;
	}


	/**
	 * Return the value associated with the column: VERSION_TYPE
	 */
	public Long getVersionType () {
		return versionType;
	}

	/**
	 * Set the value related to the column: VERSION_TYPE
	 * @param versionType the VERSION_TYPE value
	 */
	public void setVersionType (Long versionType) {
		this.versionType = versionType;
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
	 * Return the value associated with the column: APK_DOC_ID
	 */
	public com.justonetech.biz.domain.DocDocument getApkDoc () {
		return apkDoc;
	}

	/**
	 * Set the value related to the column: APK_DOC_ID
	 * @param apkDoc the APK_DOC_ID value
	 */
	public void setApkDoc (com.justonetech.biz.domain.DocDocument apkDoc) {
		this.apkDoc = apkDoc;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.PadVersionInfo)) return false;
		else {
			com.justonetech.biz.domain.PadVersionInfo padVersionInfo = (com.justonetech.biz.domain.PadVersionInfo) obj;
			if (null == this.getId() || null == padVersionInfo.getId()) return false;
			else return (this.getId().equals(padVersionInfo.getId()));
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
		builder.append(versionCode);
		builder.append(versionForceFlage);
		builder.append(versionDesc);
		builder.append(versionType);
		builder.append(createTime);
		builder.append(createUser);
		return builder.toString();
	}


}