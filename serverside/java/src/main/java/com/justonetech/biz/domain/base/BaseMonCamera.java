package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MON_CAMERA table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 视频探头
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 视频探头
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : monitor
 * Projectable : false
 *
 * @hibernate.class
 *  table="MON_CAMERA"
 */

public abstract class BaseMonCamera  implements Serializable {

	public static String REF = "MonCamera";
	public static String PROP_NAME = "name";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_MON_SERVER = "monServer";
	public static String PROP_ORDER_NO = "orderNo";
	public static String PROP_CAMERA_TYPE = "cameraType";
	public static String PROP_ID = "id";


	// constructors
	public BaseMonCamera () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMonCamera (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*探头名称*/
    /*探头名称*/
	private String name;
	
    /*探头序号*/
    /*探头序号*/
	private Integer orderNo;
	
    /*备注*/
    /*备注*/
	private String description;
	

	// many to one
	private com.justonetech.biz.domain.MonServer monServer;
	private com.justonetech.system.domain.SysCodeDetail cameraType;



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
	 * Return the value associated with the column: ORDER_NO
	 */
	public Integer getOrderNo () {
		return orderNo;
	}

	/**
	 * Set the value related to the column: ORDER_NO
	 * @param orderNo the ORDER_NO value
	 */
	public void setOrderNo (Integer orderNo) {
		this.orderNo = orderNo;
	}


	/**
	 * Return the value associated with the column: DESCRIPTION
	 */
	public String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: DESCRIPTION
	 * @param description the DESCRIPTION value
	 */
	public void setDescription (String description) {
		this.description = description;
	}


	/**
	 * Return the value associated with the column: MON_SERVER_ID
	 */
	public com.justonetech.biz.domain.MonServer getMonServer () {
		return monServer;
	}

	/**
	 * Set the value related to the column: MON_SERVER_ID
	 * @param monServer the MON_SERVER_ID value
	 */
	public void setMonServer (com.justonetech.biz.domain.MonServer monServer) {
		this.monServer = monServer;
	}


	/**
	 * Return the value associated with the column: CAMERA_TYPE_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getCameraType () {
		return cameraType;
	}

	/**
	 * Set the value related to the column: CAMERA_TYPE_ID
	 * @param cameraType the CAMERA_TYPE_ID value
	 */
	public void setCameraType (com.justonetech.system.domain.SysCodeDetail cameraType) {
		this.cameraType = cameraType;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.MonCamera)) return false;
		else {
			com.justonetech.biz.domain.MonCamera monCamera = (com.justonetech.biz.domain.MonCamera) obj;
			if (null == this.getId() || null == monCamera.getId()) return false;
			else return (this.getId().equals(monCamera.getId()));
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
		builder.append(name);
		builder.append(orderNo);
		builder.append(description);
		return builder.toString();
	}


}