package com.justonetech.biz.domain.base;

import com.justonetech.system.domain.SysCodeDetail;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;


/**
 * This is an object that contains data related to the POLLING_BELONG_AREA table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 巡查属地区域
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 巡查属地区域
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : polling
 * Projectable : false
 *
 * @hibernate.class
 *  table="POLLING_BELONG_AREA"
 */
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public abstract class BasePollingBelongArea implements Serializable {

	public static String REF = "PollingBelongArea";
	public static String PROP_ID = "id";
	public static String PROP_BELONG_AREA = "belongArea";
	public static String PROP_GROUP = "group";


	// constructors
	public BasePollingBelongArea() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePollingBelongArea(Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// many to one
	private com.justonetech.biz.domain.PollingWorkGroup group;
	private com.justonetech.system.domain.SysCodeDetail belongArea;



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
	 * Return the value associated with the column: GROUP_ID
	 */
	public com.justonetech.biz.domain.PollingWorkGroup getGroup () {
		return group;
	}

	/**
	 * Set the value related to the column: GROUP_ID
	 * @param group the GROUP_ID value
	 */
	public void setGroup (com.justonetech.biz.domain.PollingWorkGroup group) {
		this.group = group;
	}


	/**
	 * Return the value associated with the column: BELONG_AREA_ID
	 */
	public SysCodeDetail getBelongArea () {
		return belongArea;
	}

	/**
	 * Set the value related to the column: BELONG_AREA_ID
	 * @param belongArea the BELONG_AREA_ID value
	 */
	public void setBelongArea (SysCodeDetail belongArea) {
		this.belongArea = belongArea;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.PollingBelongArea)) return false;
		else {
			com.justonetech.biz.domain.PollingBelongArea pollingBelongArea = (com.justonetech.biz.domain.PollingBelongArea) obj;
			if (null == this.getId() || null == pollingBelongArea.getId()) return false;
			else return (this.getId().equals(pollingBelongArea.getId()));
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
		return builder.toString();
	}


}