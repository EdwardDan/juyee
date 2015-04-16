package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHARE_GD_DWGC table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 工地单位工程
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 工地单位工程
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : share
 * Projectable : false
 *
 * @hibernate.class
 *  table="SHARE_GD_DWGC"
 */

public abstract class BaseShareGdDwgc  implements Serializable {

	public static String REF = "ShareGdDwgc";
	public static String PROP_PRO_TYPE = "proType";
	public static String PROP_DWGC_NAME = "dwgcName";
	public static String PROP_ZJ_STATUS_NAME = "zjStatusName";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_BUILD_AREA = "buildArea";
	public static String PROP_FLOOR_COUNT = "floorCount";
	public static String PROP_GROUND_FLOOR_COUNT = "groundFloorCount";
	public static String PROP_DWGC_CODE = "dwgcCode";
	public static String PROP_BJBH = "bjbh";
	public static String PROP_ID = "id";
	public static String PROP_PRO_TYPE_NAME = "proTypeName";
	public static String PROP_PRO_COST = "proCost";
	public static String PROP_ZJ_STATUS = "zjStatus";


	// constructors
	public BaseShareGdDwgc () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShareGdDwgc (com.justonetech.biz.domain.ShareGdDwgcPK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private com.justonetech.biz.domain.ShareGdDwgcPK id;

	// fields
    /*报建编号*/
    /*报建编号*/
	private java.lang.String bjbh;
	
    /*单位工程号*/
    /*单位工程号*/
	private java.lang.String dwgcCode;
	
    /*单位工程名称*/
    /*单位工程名称*/
	private java.lang.String dwgcName;
	
    /*工程类型*/
    /*工程类型*/
	private java.lang.String proType;
	
    /*工程类型翻译*/
    /*工程类型翻译*/
	private java.lang.String proTypeName;
	
    /*建筑面积*/
    /*建筑面积*/
	private java.lang.Double buildArea;
	
    /*工程造价*/
    /*工程造价*/
	private java.lang.Double proCost;
	
    /*层数*/
    /*层数*/
	private java.lang.Long floorCount;
	
    /*地下层数*/
    /*地下层数*/
	private java.lang.String groundFloorCount;
	
    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updateTime;
	
    /*在监状态*/
    /*在监状态*/
	private java.lang.String zjStatus;
	
    /*在监状态翻译*/
    /*在监状态翻译*/
	private java.lang.String zjStatusName;
	



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public com.justonetech.biz.domain.ShareGdDwgcPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 * @deprecated
	 */
	public void setId (com.justonetech.biz.domain.ShareGdDwgcPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: BJBH
	 */
	public java.lang.String getBjbh () {
		return bjbh;
	}

	/**
	 * Set the value related to the column: BJBH
	 * @param bjbh the BJBH value
	 */
	public void setBjbh (java.lang.String bjbh) {
		this.bjbh = bjbh;
	}


	/**
	 * Return the value associated with the column: DWGC_CODE
	 */
	public java.lang.String getDwgcCode () {
		return dwgcCode;
	}

	/**
	 * Set the value related to the column: DWGC_CODE
	 * @param dwgcCode the DWGC_CODE value
	 */
	public void setDwgcCode (java.lang.String dwgcCode) {
		this.dwgcCode = dwgcCode;
	}


	/**
	 * Return the value associated with the column: DWGC_NAME
	 */
	public java.lang.String getDwgcName () {
		return dwgcName;
	}

	/**
	 * Set the value related to the column: DWGC_NAME
	 * @param dwgcName the DWGC_NAME value
	 */
	public void setDwgcName (java.lang.String dwgcName) {
		this.dwgcName = dwgcName;
	}


	/**
	 * Return the value associated with the column: PRO_TYPE
	 */
	public java.lang.String getProType () {
		return proType;
	}

	/**
	 * Set the value related to the column: PRO_TYPE
	 * @param proType the PRO_TYPE value
	 */
	public void setProType (java.lang.String proType) {
		this.proType = proType;
	}


	/**
	 * Return the value associated with the column: PRO_TYPE_NAME
	 */
	public java.lang.String getProTypeName () {
		return proTypeName;
	}

	/**
	 * Set the value related to the column: PRO_TYPE_NAME
	 * @param proTypeName the PRO_TYPE_NAME value
	 */
	public void setProTypeName (java.lang.String proTypeName) {
		this.proTypeName = proTypeName;
	}


	/**
	 * Return the value associated with the column: BUILD_AREA
	 */
	public java.lang.Double getBuildArea () {
		return buildArea;
	}

	/**
	 * Set the value related to the column: BUILD_AREA
	 * @param buildArea the BUILD_AREA value
	 */
	public void setBuildArea (java.lang.Double buildArea) {
		this.buildArea = buildArea;
	}


	/**
	 * Return the value associated with the column: PRO_COST
	 */
	public java.lang.Double getProCost () {
		return proCost;
	}

	/**
	 * Set the value related to the column: PRO_COST
	 * @param proCost the PRO_COST value
	 */
	public void setProCost (java.lang.Double proCost) {
		this.proCost = proCost;
	}


	/**
	 * Return the value associated with the column: FLOOR_COUNT
	 */
	public java.lang.Long getFloorCount () {
		return floorCount;
	}

	/**
	 * Set the value related to the column: FLOOR_COUNT
	 * @param floorCount the FLOOR_COUNT value
	 */
	public void setFloorCount (java.lang.Long floorCount) {
		this.floorCount = floorCount;
	}


	/**
	 * Return the value associated with the column: GROUND_FLOOR_COUNT
	 */
	public java.lang.String getGroundFloorCount () {
		return groundFloorCount;
	}

	/**
	 * Set the value related to the column: GROUND_FLOOR_COUNT
	 * @param groundFloorCount the GROUND_FLOOR_COUNT value
	 */
	public void setGroundFloorCount (java.lang.String groundFloorCount) {
		this.groundFloorCount = groundFloorCount;
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
	 * Return the value associated with the column: ZJ_STATUS
	 */
	public java.lang.String getZjStatus () {
		return zjStatus;
	}

	/**
	 * Set the value related to the column: ZJ_STATUS
	 * @param zjStatus the ZJ_STATUS value
	 */
	public void setZjStatus (java.lang.String zjStatus) {
		this.zjStatus = zjStatus;
	}


	/**
	 * Return the value associated with the column: ZJ_STATUS_NAME
	 */
	public java.lang.String getZjStatusName () {
		return zjStatusName;
	}

	/**
	 * Set the value related to the column: ZJ_STATUS_NAME
	 * @param zjStatusName the ZJ_STATUS_NAME value
	 */
	public void setZjStatusName (java.lang.String zjStatusName) {
		this.zjStatusName = zjStatusName;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ShareGdDwgc)) return false;
		else {
			com.justonetech.biz.domain.ShareGdDwgc shareGdDwgc = (com.justonetech.biz.domain.ShareGdDwgc) obj;
			if (null == this.getId() || null == shareGdDwgc.getId()) return false;
			else return (this.getId().equals(shareGdDwgc.getId()));
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
		builder.append(dwgcCode);
		builder.append(dwgcName);
		builder.append(proType);
		builder.append(proTypeName);
		builder.append(buildArea);
		builder.append(proCost);
		builder.append(floorCount);
		builder.append(groundFloorCount);
		builder.append(updateTime);
		builder.append(zjStatus);
		builder.append(zjStatusName);
		return builder.toString();
	}


}