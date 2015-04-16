package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the NET_ACCEPT_STEP table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目审批_受理环节设置
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 项目审批_受理环节设置
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : net
 * Projectable : false
 *
 * @hibernate.class
 *  table="NET_ACCEPT_STEP"
 */

public abstract class BaseNetAcceptStep  implements Serializable {

	public static String REF = "NetAcceptStep";
	public static String PROP_NAME = "name";
	public static String PROP_ID = "id";
	public static String PROP_NOTE = "note";
	public static String PROP_MATTER_CODE = "matterCode";
	public static String PROP_NO = "no";
	public static String PROP_CODE = "code";
	public static String PROP_IS_SHOW_BUTTON = "isShowButton";


	// constructors
	public BaseNetAcceptStep () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseNetAcceptStep (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*序号*/
    /*序号*/
	private Integer no;
	
    /*审批事项编码*/
    /*审批事项编码*/
	private String matterCode;
	
    /*受理环节编码*/
    /*受理环节编码*/
	private String code;
	
    /*受理环节名称*/
    /*受理环节名称*/
	private String name;
	
    /*说明*/
    /*说明*/
	private String note;
	
    /*是否显示通过退回按钮*/
    /*是否显示通过退回按钮*/
	private Boolean isShowButton;
	

	// collections
	private java.util.Set<com.justonetech.biz.domain.NetAcceptStatus> netAcceptStatus;



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
	 * Return the value associated with the column: NO
	 */
	public Integer getNo () {
		return no;
	}

	/**
	 * Set the value related to the column: NO
	 * @param no the NO value
	 */
	public void setNo (Integer no) {
		this.no = no;
	}


	/**
	 * Return the value associated with the column: MATTER_CODE
	 */
	public String getMatterCode () {
		return matterCode;
	}

	/**
	 * Set the value related to the column: MATTER_CODE
	 * @param matterCode the MATTER_CODE value
	 */
	public void setMatterCode (String matterCode) {
		this.matterCode = matterCode;
	}


	/**
	 * Return the value associated with the column: CODE
	 */
	public String getCode () {
		return code;
	}

	/**
	 * Set the value related to the column: CODE
	 * @param code the CODE value
	 */
	public void setCode (String code) {
		this.code = code;
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
	 * Return the value associated with the column: NOTE
	 */
	public String getNote () {
		return note;
	}

	/**
	 * Set the value related to the column: NOTE
	 * @param note the NOTE value
	 */
	public void setNote (String note) {
		this.note = note;
	}


	/**
	 * Return the value associated with the column: IS_SHOW_BUTTON
	 */
	public Boolean getIsShowButton () {
		return isShowButton;
	}

	/**
	 * Set the value related to the column: IS_SHOW_BUTTON
	 * @param isShowButton the IS_SHOW_BUTTON value
	 */
	public void setIsShowButton (Boolean isShowButton) {
		this.isShowButton = isShowButton;
	}


	/**
	 * Return the value associated with the column: netAcceptStatus
	 */
	public java.util.Set<com.justonetech.biz.domain.NetAcceptStatus> getNetAcceptStatus () {
		if(netAcceptStatus == null){
			netAcceptStatus = new java.util.LinkedHashSet<com.justonetech.biz.domain.NetAcceptStatus>();
		}
		return netAcceptStatus;
	}

	/**
	 * Set the value related to the column: netAcceptStatus
	 * @param netAcceptStatus the netAcceptStatus value
	 */
	public void setNetAcceptStatus (java.util.Set<com.justonetech.biz.domain.NetAcceptStatus> netAcceptStatus) {
		this.netAcceptStatus = netAcceptStatus;
	}

	public void addTonetAcceptStatus (com.justonetech.biz.domain.NetAcceptStatus netAcceptStatus) {
		if (null == getNetAcceptStatus()) setNetAcceptStatus(new java.util.LinkedHashSet<com.justonetech.biz.domain.NetAcceptStatus>());
		getNetAcceptStatus().add(netAcceptStatus);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.NetAcceptStep)) return false;
		else {
			com.justonetech.biz.domain.NetAcceptStep netAcceptStep = (com.justonetech.biz.domain.NetAcceptStep) obj;
			if (null == this.getId() || null == netAcceptStep.getId()) return false;
			else return (this.getId().equals(netAcceptStep.getId()));
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
		builder.append(no);
		builder.append(matterCode);
		builder.append(code);
		builder.append(name);
		builder.append(note);
		builder.append(isShowButton);
		return builder.toString();
	}


}