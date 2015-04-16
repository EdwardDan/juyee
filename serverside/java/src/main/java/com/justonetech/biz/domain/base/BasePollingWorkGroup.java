package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;
import com.justonetech.biz.domain.PollingBelongArea;
import com.justonetech.biz.domain.PollingGroupUser;

import java.io.Serializable;
import java.util.Set;


/**
 * This is an object that contains data related to the POLLING_WORK_GROUP table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 监督巡查组
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 监督巡查组
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : polling
 * Projectable : false
 *
 * @hibernate.class
 *  table="POLLING_WORK_GROUP"
 */

public abstract class BasePollingWorkGroup implements Serializable, Auditable {

	public static String REF = "PollingWorkGroup";
	public static String PROP_NAME = "name";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_MEMO = "memo";
	public static String PROP_UPDATE_TIME = "updateTime";
	public static String PROP_ID = "id";
	public static String PROP_UPDATE_USER = "updateUser";


	// constructors
	public BasePollingWorkGroup() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePollingWorkGroup(Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*工作组名称*/
    /*工作组名称*/
	private String name;
	
    /*备注*/
    /*备注*/
	private String memo;
	
    /*创建时间*/
    /*创建时间*/
	private java.sql.Timestamp createTime;
	
    /*更新时间*/
    /*更新时间*/
	private java.sql.Timestamp updateTime;
	
    /*更新人*/
    /*更新人*/
	private String updateUser;
	
    /*创建人*/
    /*创建人*/
	private String createUser;

    // collections
	private Set<com.justonetech.biz.domain.PollingBelongArea> pollingBelongAreas;
	private Set<com.justonetech.biz.domain.PollingGroupUser> pollingGroupUsers;




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
	 * Return the value associated with the column: MEMO
	 */
	public String getMemo () {
		return memo;
	}

	/**
	 * Set the value related to the column: MEMO
	 * @param memo the MEMO value
	 */
	public void setMemo (String memo) {
		this.memo = memo;
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

    public Set<PollingBelongArea> getPollingBelongAreas() {
        if(pollingBelongAreas == null){
			pollingBelongAreas = new java.util.LinkedHashSet<com.justonetech.biz.domain.PollingBelongArea>();
		}
        return pollingBelongAreas;
    }

    public void setPollingBelongAreas(Set<PollingBelongArea> pollingBelongAreas) {
        this.pollingBelongAreas = pollingBelongAreas;
    }

    public Set<PollingGroupUser> getPollingGroupUsers() {
        if(pollingGroupUsers == null){
			pollingGroupUsers = new java.util.LinkedHashSet<com.justonetech.biz.domain.PollingGroupUser>();
		}
        return pollingGroupUsers;
    }

    public void setPollingGroupUsers(Set<PollingGroupUser> pollingGroupUsers) {
        this.pollingGroupUsers = pollingGroupUsers;
    }

    public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.PollingWorkGroup)) return false;
		else {
			com.justonetech.biz.domain.PollingWorkGroup pollingWorkGroup = (com.justonetech.biz.domain.PollingWorkGroup) obj;
			if (null == this.getId() || null == pollingWorkGroup.getId()) return false;
			else return (this.getId().equals(pollingWorkGroup.getId()));
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
		builder.append(memo);
		builder.append(createTime);
		builder.append(updateTime);
		builder.append(updateUser);
		builder.append(createUser);
		return builder.toString();
	}


}