package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHARE_ACCIDENT_SWRY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 事故伤亡人员
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 事故伤亡人员
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : share
 * Projectable : false
 *
 * @hibernate.class
 *  table="SHARE_ACCIDENT_SWRY"
 */

public abstract class BaseShareAccidentSwry  implements Serializable {

	public static String REF = "ShareAccidentSwry";
	public static String PROP_SWRY_SWQK = "swrySwqk";
	public static String PROP_SWRY_WORK_CLASS = "swryWorkClass";
	public static String PROP_SWRY_AGE_STAGE_DESC = "swryAgeStageDesc";
	public static String PROP_ACCIDENT_ID = "accidentId";
	public static String PROP_SWRY_SEX = "swrySex";
	public static String PROP_SWRY_WORK_CLASS_DESC = "swryWorkClassDesc";
	public static String PROP_SWRY_SWQK_DESC = "swrySwqkDesc";
	public static String PROP_ID = "id";
	public static String PROP_SWRY_SEX_DESC = "swrySexDesc";
	public static String PROP_SWRY_AGE_STAGE = "swryAgeStage";
	public static String PROP_SWRY_NAME = "swryName";
	public static String PROP_SWRY_CARD = "swryCard";


	// constructors
	public BaseShareAccidentSwry () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShareAccidentSwry (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*事故标识*/
    /*事故标识*/
	private java.lang.Long accidentId;
	
    /*姓名*/
    /*姓名*/
	private java.lang.String swryName;
	
    /*身份证*/
    /*身份证*/
	private java.lang.String swryCard;
	
    /*性别*/
    /*性别*/
	private java.lang.String swrySex;
	
    /*性别描述*/
    /*性别描述*/
	private java.lang.String swrySexDesc;
	
    /*年龄阶段*/
    /*年龄阶段*/
	private java.lang.Long swryAgeStage;
	
    /*年龄阶段描述*/
    /*年龄阶段描述*/
	private java.lang.String swryAgeStageDesc;
	
    /*工种*/
    /*工种*/
	private java.lang.Long swryWorkClass;
	
    /*工种描述*/
    /*工种描述*/
	private java.lang.String swryWorkClassDesc;
	
    /*伤亡情况（死亡、伤亡）*/
    /*伤亡情况（死亡、伤亡）*/
	private java.lang.String swrySwqk;
	
    /*伤亡情况描述*/
    /*伤亡情况描述*/
	private java.lang.String swrySwqkDesc;
	



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
	 * Return the value associated with the column: ACCIDENT_ID
	 */
	public java.lang.Long getAccidentId () {
		return accidentId;
	}

	/**
	 * Set the value related to the column: ACCIDENT_ID
	 * @param accidentId the ACCIDENT_ID value
	 */
	public void setAccidentId (java.lang.Long accidentId) {
		this.accidentId = accidentId;
	}


	/**
	 * Return the value associated with the column: SWRY_NAME
	 */
	public java.lang.String getSwryName () {
		return swryName;
	}

	/**
	 * Set the value related to the column: SWRY_NAME
	 * @param swryName the SWRY_NAME value
	 */
	public void setSwryName (java.lang.String swryName) {
		this.swryName = swryName;
	}


	/**
	 * Return the value associated with the column: SWRY_CARD
	 */
	public java.lang.String getSwryCard () {
		return swryCard;
	}

	/**
	 * Set the value related to the column: SWRY_CARD
	 * @param swryCard the SWRY_CARD value
	 */
	public void setSwryCard (java.lang.String swryCard) {
		this.swryCard = swryCard;
	}


	/**
	 * Return the value associated with the column: SWRY_SEX
	 */
	public java.lang.String getSwrySex () {
		return swrySex;
	}

	/**
	 * Set the value related to the column: SWRY_SEX
	 * @param swrySex the SWRY_SEX value
	 */
	public void setSwrySex (java.lang.String swrySex) {
		this.swrySex = swrySex;
	}


	/**
	 * Return the value associated with the column: SWRY_SEX_DESC
	 */
	public java.lang.String getSwrySexDesc () {
		return swrySexDesc;
	}

	/**
	 * Set the value related to the column: SWRY_SEX_DESC
	 * @param swrySexDesc the SWRY_SEX_DESC value
	 */
	public void setSwrySexDesc (java.lang.String swrySexDesc) {
		this.swrySexDesc = swrySexDesc;
	}


	/**
	 * Return the value associated with the column: SWRY_AGE_STAGE
	 */
	public java.lang.Long getSwryAgeStage () {
		return swryAgeStage;
	}

	/**
	 * Set the value related to the column: SWRY_AGE_STAGE
	 * @param swryAgeStage the SWRY_AGE_STAGE value
	 */
	public void setSwryAgeStage (java.lang.Long swryAgeStage) {
		this.swryAgeStage = swryAgeStage;
	}


	/**
	 * Return the value associated with the column: SWRY_AGE_STAGE_DESC
	 */
	public java.lang.String getSwryAgeStageDesc () {
		return swryAgeStageDesc;
	}

	/**
	 * Set the value related to the column: SWRY_AGE_STAGE_DESC
	 * @param swryAgeStageDesc the SWRY_AGE_STAGE_DESC value
	 */
	public void setSwryAgeStageDesc (java.lang.String swryAgeStageDesc) {
		this.swryAgeStageDesc = swryAgeStageDesc;
	}


	/**
	 * Return the value associated with the column: SWRY_WORK_CLASS
	 */
	public java.lang.Long getSwryWorkClass () {
		return swryWorkClass;
	}

	/**
	 * Set the value related to the column: SWRY_WORK_CLASS
	 * @param swryWorkClass the SWRY_WORK_CLASS value
	 */
	public void setSwryWorkClass (java.lang.Long swryWorkClass) {
		this.swryWorkClass = swryWorkClass;
	}


	/**
	 * Return the value associated with the column: SWRY_WORK_CLASS_DESC
	 */
	public java.lang.String getSwryWorkClassDesc () {
		return swryWorkClassDesc;
	}

	/**
	 * Set the value related to the column: SWRY_WORK_CLASS_DESC
	 * @param swryWorkClassDesc the SWRY_WORK_CLASS_DESC value
	 */
	public void setSwryWorkClassDesc (java.lang.String swryWorkClassDesc) {
		this.swryWorkClassDesc = swryWorkClassDesc;
	}


	/**
	 * Return the value associated with the column: SWRY_SWQK
	 */
	public java.lang.String getSwrySwqk () {
		return swrySwqk;
	}

	/**
	 * Set the value related to the column: SWRY_SWQK
	 * @param swrySwqk the SWRY_SWQK value
	 */
	public void setSwrySwqk (java.lang.String swrySwqk) {
		this.swrySwqk = swrySwqk;
	}


	/**
	 * Return the value associated with the column: SWRY_SWQK_DESC
	 */
	public java.lang.String getSwrySwqkDesc () {
		return swrySwqkDesc;
	}

	/**
	 * Set the value related to the column: SWRY_SWQK_DESC
	 * @param swrySwqkDesc the SWRY_SWQK_DESC value
	 */
	public void setSwrySwqkDesc (java.lang.String swrySwqkDesc) {
		this.swrySwqkDesc = swrySwqkDesc;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ShareAccidentSwry)) return false;
		else {
			com.justonetech.biz.domain.ShareAccidentSwry shareAccidentSwry = (com.justonetech.biz.domain.ShareAccidentSwry) obj;
			if (null == this.getId() || null == shareAccidentSwry.getId()) return false;
			else return (this.getId().equals(shareAccidentSwry.getId()));
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
		builder.append(accidentId);
		builder.append(swryName);
		builder.append(swryCard);
		builder.append(swrySex);
		builder.append(swrySexDesc);
		builder.append(swryAgeStage);
		builder.append(swryAgeStageDesc);
		builder.append(swryWorkClass);
		builder.append(swryWorkClassDesc);
		builder.append(swrySwqk);
		builder.append(swrySwqkDesc);
		return builder.toString();
	}


}