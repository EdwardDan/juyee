package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PROJECT_STREET table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 行政区街镇划分
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 行政区街镇划分
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : project
 * Projectable : false
 *
 * @hibernate.class
 *  table="PROJECT_STREET"
 */

public abstract class BaseProjectStreet  implements Serializable {

	public static String REF = "ProjectStreet";
	public static String PROP_YEAR = "year";
	public static String PROP_STREET = "street";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_STREET_NAME = "streetName";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_POINT_DATA = "pointData";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_UPDATE_USER = "updateUser";
	public static String PROP_COLOR = "color";


	// constructors
	public BaseProjectStreet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProjectStreet (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*年份*/
    /*年份*/
	private Integer year;
	
    /*街镇名称*/
    /*街镇名称*/
	private String streetName;
	
    /*颜色*/
    /*颜色*/
	private String color;
	
    /*点数据*/
    /*点数据*/
	private String pointData;
	
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
	private com.justonetech.system.domain.SysCodeDetail street;



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
	 * Return the value associated with the column: STREET_NAME
	 */
	public String getStreetName () {
		return streetName;
	}

	/**
	 * Set the value related to the column: STREET_NAME
	 * @param streetName the STREET_NAME value
	 */
	public void setStreetName (String streetName) {
		this.streetName = streetName;
	}


	/**
	 * Return the value associated with the column: COLOR
	 */
	public String getColor () {
		return color;
	}

	/**
	 * Set the value related to the column: COLOR
	 * @param color the COLOR value
	 */
	public void setColor (String color) {
		this.color = color;
	}


	/**
	 * Return the value associated with the column: POINT_DATA
	 */
	public String getPointData () {
		return pointData;
	}

	/**
	 * Set the value related to the column: POINT_DATA
	 * @param pointData the POINT_DATA value
	 */
	public void setPointData (String pointData) {
		this.pointData = pointData;
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
	 * Return the value associated with the column: STREET_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getStreet () {
		return street;
	}

	/**
	 * Set the value related to the column: STREET_ID
	 * @param street the STREET_ID value
	 */
	public void setStreet (com.justonetech.system.domain.SysCodeDetail street) {
		this.street = street;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ProjectStreet)) return false;
		else {
			com.justonetech.biz.domain.ProjectStreet projectStreet = (com.justonetech.biz.domain.ProjectStreet) obj;
			if (null == this.getId() || null == projectStreet.getId()) return false;
			else return (this.getId().equals(projectStreet.getId()));
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
		builder.append(year);
		builder.append(streetName);
		builder.append(color);
		builder.append(pointData);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}