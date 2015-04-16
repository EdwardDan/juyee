package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the WORKER_INSPECT_RECORD table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 现场检查记录
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 现场检查记录
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : worker
 * Projectable : false
 *
 * @hibernate.class
 *  table="WORKER_INSPECT_RECORD"
 */

public abstract class BaseWorkerInspectRecord  implements Serializable ,Auditable{

	public static String REF = "WorkerInspectRecord";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_CHECK_PERSON = "checkPerson";
	public static String PROP_CHECK_CONTENT = "checkContent";
	public static String PROP_CHECK_ADDRESS = "checkAddress";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_FR = "fr";
	public static String PROP_IS_FROM_ANDROID = "isFromAndroid";
	public static String PROP_BJBH = "bjbh";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_ADDRESS = "address";
	public static String PROP_ID = "id";
	public static String PROP_END_TIME = "endTime";
	public static String PROP_CURRENT_PERSON = "currentPerson";
	public static String PROP_RECORD_PERSON = "recordPerson";
	public static String PROP_CHECK_DATE = "checkDate";
	public static String PROP_START_TIME = "startTime";
	public static String PROP_TEL = "tel";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseWorkerInspectRecord () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWorkerInspectRecord (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*报建编号*/
    /*报建编号*/
	private String bjbh;
	
    /*检查地点*/
    /*检查地点*/
	private String checkAddress;
	
    /*检查日期*/
    /*检查日期*/
	private java.sql.Date checkDate;
	
    /*检查起始时分*/
    /*检查起始时分*/
	private String startTime;
	
    /*检查结束时分*/
    /*检查结束时分*/
	private String endTime;
	
    /*当事人*/
    /*当事人*/
	private String currentPerson;
	
    /*地址*/
    /*地址*/
	private String address;
	
    /*法定代表人*/
    /*法定代表人*/
	private String fr;
	
    /*电话*/
    /*电话*/
	private String tel;
	
    /*检查人员*/
    /*检查人员*/
	private String checkPerson;
	
    /*记录人*/
    /*记录人*/
	private String recordPerson;
	
    /*现场检查情况*/
    /*现场检查情况*/
	private String checkContent;
	
    /*是否来源手持终端*/
    /*是否来源手持终端*/
	private Boolean isFromAndroid;
	
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
	 * Return the value associated with the column: CHECK_ADDRESS
	 */
	public String getCheckAddress () {
		return checkAddress;
	}

	/**
	 * Set the value related to the column: CHECK_ADDRESS
	 * @param checkAddress the CHECK_ADDRESS value
	 */
	public void setCheckAddress (String checkAddress) {
		this.checkAddress = checkAddress;
	}


	/**
	 * Return the value associated with the column: CHECK_DATE
	 */
	public java.sql.Date getCheckDate () {
		return checkDate;
	}

	/**
	 * Set the value related to the column: CHECK_DATE
	 * @param checkDate the CHECK_DATE value
	 */
	public void setCheckDate (java.sql.Date checkDate) {
		this.checkDate = checkDate;
	}


	/**
	 * Return the value associated with the column: START_TIME
	 */
	public String getStartTime () {
		return startTime;
	}

	/**
	 * Set the value related to the column: START_TIME
	 * @param startTime the START_TIME value
	 */
	public void setStartTime (String startTime) {
		this.startTime = startTime;
	}


	/**
	 * Return the value associated with the column: END_TIME
	 */
	public String getEndTime () {
		return endTime;
	}

	/**
	 * Set the value related to the column: END_TIME
	 * @param endTime the END_TIME value
	 */
	public void setEndTime (String endTime) {
		this.endTime = endTime;
	}


	/**
	 * Return the value associated with the column: CURRENT_PERSON
	 */
	public String getCurrentPerson () {
		return currentPerson;
	}

	/**
	 * Set the value related to the column: CURRENT_PERSON
	 * @param currentPerson the CURRENT_PERSON value
	 */
	public void setCurrentPerson (String currentPerson) {
		this.currentPerson = currentPerson;
	}


	/**
	 * Return the value associated with the column: ADDRESS
	 */
	public String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: ADDRESS
	 * @param address the ADDRESS value
	 */
	public void setAddress (String address) {
		this.address = address;
	}


	/**
	 * Return the value associated with the column: FR
	 */
	public String getFr () {
		return fr;
	}

	/**
	 * Set the value related to the column: FR
	 * @param fr the FR value
	 */
	public void setFr (String fr) {
		this.fr = fr;
	}


	/**
	 * Return the value associated with the column: TEL
	 */
	public String getTel () {
		return tel;
	}

	/**
	 * Set the value related to the column: TEL
	 * @param tel the TEL value
	 */
	public void setTel (String tel) {
		this.tel = tel;
	}


	/**
	 * Return the value associated with the column: CHECK_PERSON
	 */
	public String getCheckPerson () {
		return checkPerson;
	}

	/**
	 * Set the value related to the column: CHECK_PERSON
	 * @param checkPerson the CHECK_PERSON value
	 */
	public void setCheckPerson (String checkPerson) {
		this.checkPerson = checkPerson;
	}


	/**
	 * Return the value associated with the column: RECORD_PERSON
	 */
	public String getRecordPerson () {
		return recordPerson;
	}

	/**
	 * Set the value related to the column: RECORD_PERSON
	 * @param recordPerson the RECORD_PERSON value
	 */
	public void setRecordPerson (String recordPerson) {
		this.recordPerson = recordPerson;
	}


	/**
	 * Return the value associated with the column: CHECK_CONTENT
	 */
	public String getCheckContent () {
		return checkContent;
	}

	/**
	 * Set the value related to the column: CHECK_CONTENT
	 * @param checkContent the CHECK_CONTENT value
	 */
	public void setCheckContent (String checkContent) {
		this.checkContent = checkContent;
	}


	/**
	 * Return the value associated with the column: IS_FROM_ANDROID
	 */
	public Boolean getIsFromAndroid () {
		return isFromAndroid;
	}

	/**
	 * Set the value related to the column: IS_FROM_ANDROID
	 * @param isFromAndroid the IS_FROM_ANDROID value
	 */
	public void setIsFromAndroid (Boolean isFromAndroid) {
		this.isFromAndroid = isFromAndroid;
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



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.WorkerInspectRecord)) return false;
		else {
			com.justonetech.biz.domain.WorkerInspectRecord workerInspectRecord = (com.justonetech.biz.domain.WorkerInspectRecord) obj;
			if (null == this.getId() || null == workerInspectRecord.getId()) return false;
			else return (this.getId().equals(workerInspectRecord.getId()));
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
		builder.append(bjbh);
		builder.append(checkAddress);
		builder.append(checkDate);
		builder.append(startTime);
		builder.append(endTime);
		builder.append(currentPerson);
		builder.append(address);
		builder.append(fr);
		builder.append(tel);
		builder.append(checkPerson);
		builder.append(recordPerson);
		builder.append(checkContent);
		builder.append(isFromAndroid);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}