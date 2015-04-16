package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the NET_CFB table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目承发包
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 项目承发包
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : net
 * Projectable : false
 *
 * @hibernate.class
 *  table="NET_CFB"
 */

public abstract class BaseNetCfb  implements Serializable,Auditable {

	public static String REF = "NetCfb";
	public static String PROP_FB_TYPE= "fbType";
	public static String PROP_BID_METHOD_CODE = "bidMethodCode";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_NET_DATE = "netDate";
	public static String PROP_ACCEPT_STATUS = "acceptStatus";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_FB_TYPE_DESC = "fbTypeDesc";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_ID = "id";
	public static String PROP_APPLY = "apply";
	public static String PROP_BDH = "bdh";
	public static String PROP_NET_CODE = "netCode";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BaseNetCfb () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseNetCfb (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*招标方式编码*/
    /*招标方式编码*/
	private String bidMethodCode;
	
    /*发包类型中文描述*/
    /*发包类型中文描述*/
	private String fbTypeDesc;
	
    /*网上受理编号*/
    /*网上受理编号*/
	private String netCode;
	
    /*网上提交日期*/
    /*网上提交日期*/
	private java.sql.Date netDate;
	
    /*标段编号*/
    /*标段编号*/
	private String bdh;

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
	private com.justonetech.biz.domain.NetAcceptStatus acceptStatus;
	private com.justonetech.system.domain.SysCodeDetail fbType;
	private com.justonetech.biz.domain.NetApply apply;



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
	 * Return the value associated with the column: BID_METHOD_CODE
	 */
	public String getBidMethodCode () {
		return bidMethodCode;
	}

	/**
	 * Set the value related to the column: BID_METHOD_CODE
	 * @param bidMethodCode the BID_METHOD_CODE value
	 */
	public void setBidMethodCode (String bidMethodCode) {
		this.bidMethodCode = bidMethodCode;
	}


	/**
	 * Return the value associated with the column: FB_TYPE_DESC
	 */
	public String getFbTypeDesc () {
		return fbTypeDesc;
	}

	/**
	 * Set the value related to the column: FB_TYPE_DESC
	 * @param fbTypeDesc the FB_TYPE_DESC value
	 */
	public void setFbTypeDesc (String fbTypeDesc) {
		this.fbTypeDesc = fbTypeDesc;
	}


	/**
	 * Return the value associated with the column: NET_CODE
	 */
	public String getNetCode () {
		return netCode;
	}

	/**
	 * Set the value related to the column: NET_CODE
	 * @param netCode the NET_CODE value
	 */
	public void setNetCode (String netCode) {
		this.netCode = netCode;
	}


	/**
	 * Return the value associated with the column: NET_DATE
	 */
	public java.sql.Date getNetDate () {
		return netDate;
	}

	/**
	 * Set the value related to the column: NET_DATE
	 * @param netDate the NET_DATE value
	 */
	public void setNetDate (java.sql.Date netDate) {
		this.netDate = netDate;
	}




	/**
	 * Return the value associated with the column: BDH
	 */
	public String getBdh () {
		return bdh;
	}

	/**
	 * Set the value related to the column: BDH
	 * @param bdh the BDH value
	 */
	public void setBdh (String bdh) {
		this.bdh = bdh;
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
	 * Return the value associated with the column: ACCEPT_STATUS_ID
	 */
	public com.justonetech.biz.domain.NetAcceptStatus getAcceptStatus () {
		return acceptStatus;
	}

	/**
	 * Set the value related to the column: ACCEPT_STATUS_ID
	 * @param acceptStatus the ACCEPT_STATUS_ID value
	 */
	public void setAcceptStatus (com.justonetech.biz.domain.NetAcceptStatus acceptStatus) {
		this.acceptStatus = acceptStatus;
	}


	/**
	 * Return the value associated with the column: FB_TYPE_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getFbType () {
		return fbType;
	}

	/**
	 * Set the value related to the column: FB_TYPE_ID
	 * @param fbType the FB_TYPE_ID value
	 */
	public void setFbType (com.justonetech.system.domain.SysCodeDetail fbType) {
		this.fbType = fbType;
	}


	/**
	 * Return the value associated with the column: APPLY_ID
	 */
	public com.justonetech.biz.domain.NetApply getApply () {
		return apply;
	}

	/**
	 * Set the value related to the column: APPLY_ID
	 * @param apply the APPLY_ID value
	 */
	public void setApply (com.justonetech.biz.domain.NetApply apply) {
		this.apply = apply;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.NetCfb)) return false;
		else {
			com.justonetech.biz.domain.NetCfb netCfb = (com.justonetech.biz.domain.NetCfb) obj;
			if (null == this.getId() || null == netCfb.getId()) return false;
			else return (this.getId().equals(netCfb.getId()));
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
		builder.append(bidMethodCode);
		builder.append(fbTypeDesc);
		builder.append(netCode);
		builder.append(netDate);
		builder.append(bdh);
		builder.append(createTime);
		builder.append(createUser);
		builder.append(updateTime);
		builder.append(updateUser);
		return builder.toString();
	}


}