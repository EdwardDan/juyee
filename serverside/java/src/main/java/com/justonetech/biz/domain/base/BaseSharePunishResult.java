package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHARE_PUNISH_RESULT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 行政处罚结果
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 行政处罚结果
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : share
 * Projectable : false
 *
 * @hibernate.class
 *  table="SHARE_PUNISH_RESULT"
 */

public abstract class BaseSharePunishResult  implements Serializable {

	public static String REF = "SharePunishResult";
	public static String PROP_PUNISH_TYPE_DESC = "punishTypeDesc";
	public static String PROP_PUNISH_CASE_ID = "punishCaseId";
	public static String PROP_MEMO = "memo";
	public static String PROP_PUNISH_TYPE = "punishType";
	public static String PROP_RELATE_MONEY = "relateMoney";
	public static String PROP_ID = "id";
	public static String PROP_RELATE_DAYS = "relateDays";
	public static String PROP_RELATE_MONEY_CHINESE = "relateMoneyChinese";


	// constructors
	public BaseSharePunishResult () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSharePunishResult (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*案件标识*/
    /*案件标识*/
	private java.lang.Long punishCaseId;
	
    /*处罚类型*/
    /*处罚类型*/
	private java.lang.Long punishType;
	
    /*处罚类型描述*/
    /*处罚类型描述*/
	private java.lang.String punishTypeDesc;
	
    /*涉及金额（元）*/
    /*涉及金额（元）*/
	private java.lang.Double relateMoney;
	
    /*涉及金额（大写）*/
    /*涉及金额（大写）*/
	private java.lang.String relateMoneyChinese;
	
    /*涉及时间（天）*/
    /*涉及时间（天）*/
	private java.lang.Long relateDays;
	
    /*其他说明*/
    /*其他说明*/
	private java.lang.String memo;
	



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="com.justonetech.core.orm.hibernate.LongIdGenerator"
     *  column="ID"
     */
	public java.lang.Long getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 * @deprecated
	 */
	public void setId (java.lang.Long id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: PUNISH_CASE_ID
	 */
	public java.lang.Long getPunishCaseId () {
		return punishCaseId;
	}

	/**
	 * Set the value related to the column: PUNISH_CASE_ID
	 * @param punishCaseId the PUNISH_CASE_ID value
	 */
	public void setPunishCaseId (java.lang.Long punishCaseId) {
		this.punishCaseId = punishCaseId;
	}


	/**
	 * Return the value associated with the column: PUNISH_TYPE
	 */
	public java.lang.Long getPunishType () {
		return punishType;
	}

	/**
	 * Set the value related to the column: PUNISH_TYPE
	 * @param punishType the PUNISH_TYPE value
	 */
	public void setPunishType (java.lang.Long punishType) {
		this.punishType = punishType;
	}


	/**
	 * Return the value associated with the column: PUNISH_TYPE_DESC
	 */
	public java.lang.String getPunishTypeDesc () {
		return punishTypeDesc;
	}

	/**
	 * Set the value related to the column: PUNISH_TYPE_DESC
	 * @param punishTypeDesc the PUNISH_TYPE_DESC value
	 */
	public void setPunishTypeDesc (java.lang.String punishTypeDesc) {
		this.punishTypeDesc = punishTypeDesc;
	}


	/**
	 * Return the value associated with the column: RELATE_MONEY
	 */
	public java.lang.Double getRelateMoney () {
		return relateMoney;
	}

	/**
	 * Set the value related to the column: RELATE_MONEY
	 * @param relateMoney the RELATE_MONEY value
	 */
	public void setRelateMoney (java.lang.Double relateMoney) {
		this.relateMoney = relateMoney;
	}


	/**
	 * Return the value associated with the column: RELATE_MONEY_CHINESE
	 */
	public java.lang.String getRelateMoneyChinese () {
		return relateMoneyChinese;
	}

	/**
	 * Set the value related to the column: RELATE_MONEY_CHINESE
	 * @param relateMoneyChinese the RELATE_MONEY_CHINESE value
	 */
	public void setRelateMoneyChinese (java.lang.String relateMoneyChinese) {
		this.relateMoneyChinese = relateMoneyChinese;
	}


	/**
	 * Return the value associated with the column: RELATE_DAYS
	 */
	public java.lang.Long getRelateDays () {
		return relateDays;
	}

	/**
	 * Set the value related to the column: RELATE_DAYS
	 * @param relateDays the RELATE_DAYS value
	 */
	public void setRelateDays (java.lang.Long relateDays) {
		this.relateDays = relateDays;
	}


	/**
	 * Return the value associated with the column: MEMO
	 */
	public java.lang.String getMemo () {
		return memo;
	}

	/**
	 * Set the value related to the column: MEMO
	 * @param memo the MEMO value
	 */
	public void setMemo (java.lang.String memo) {
		this.memo = memo;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.SharePunishResult)) return false;
		else {
			com.justonetech.biz.domain.SharePunishResult sharePunishResult = (com.justonetech.biz.domain.SharePunishResult) obj;
			if (null == this.getId() || null == sharePunishResult.getId()) return false;
			else return (this.getId().equals(sharePunishResult.getId()));
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
		builder.append(punishCaseId);
		builder.append(punishType);
		builder.append(punishTypeDesc);
		builder.append(relateMoney);
		builder.append(relateMoneyChinese);
		builder.append(relateDays);
		builder.append(memo);
		return builder.toString();
	}


}