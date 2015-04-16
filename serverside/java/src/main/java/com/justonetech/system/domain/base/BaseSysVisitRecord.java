package com.justonetech.system.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SYS_VISIT_RECORD table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 系统用户最后访问记录时间
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 系统用户最后访问记录时间
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * Projectable : false
 *
 * @hibernate.class
 *  table="SYS_VISIT_RECORD"
 */

public abstract class BaseSysVisitRecord  implements Serializable {

	public static String REF = "SysVisitRecord";
	public static String PROP_MENU = "menu";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_ID = "id";
	public static String PROP_TABLE_NAME = "tableName";
	public static String PROP_USER_NAME = "userName";
	public static String PROP_TABLE_ID = "tableId";


	// constructors
	public BaseSysVisitRecord () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSysVisitRecord (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*用户名*/
    /*用户名*/
	private java.lang.Long userName;
	
    /*表名*/
    /*表名*/
	private java.lang.String tableName;
	
    /*主键*/
    /*主键*/
	private java.lang.Long tableId;
	
    /*创建时间*/
    /*创建时间*/
	private java.sql.Timestamp createTime;
	
    /*创建用户名*/
    /*创建用户名*/
	private java.lang.String createUser;
	

	// many to one
	private com.justonetech.system.domain.SysMenu menu;



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
	 * Return the value associated with the column: USER_NAME
	 */
	public java.lang.Long getUserName () {
		return userName;
	}

	/**
	 * Set the value related to the column: USER_NAME
	 * @param userName the USER_NAME value
	 */
	public void setUserName (java.lang.Long userName) {
		this.userName = userName;
	}


	/**
	 * Return the value associated with the column: TABLE_NAME
	 */
	public java.lang.String getTableName () {
		return tableName;
	}

	/**
	 * Set the value related to the column: TABLE_NAME
	 * @param tableName the TABLE_NAME value
	 */
	public void setTableName (java.lang.String tableName) {
		this.tableName = tableName;
	}


	/**
	 * Return the value associated with the column: TABLE_ID
	 */
	public java.lang.Long getTableId () {
		return tableId;
	}

	/**
	 * Set the value related to the column: TABLE_ID
	 * @param tableId the TABLE_ID value
	 */
	public void setTableId (java.lang.Long tableId) {
		this.tableId = tableId;
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
	public java.lang.String getCreateUser () {
		return createUser;
	}

	/**
	 * Set the value related to the column: CREATE_USER
	 * @param createUser the CREATE_USER value
	 */
	public void setCreateUser (java.lang.String createUser) {
		this.createUser = createUser;
	}


	/**
	 * Return the value associated with the column: MENU_ID
	 */
	public com.justonetech.system.domain.SysMenu getMenu () {
		return menu;
	}

	/**
	 * Set the value related to the column: MENU_ID
	 * @param menu the MENU_ID value
	 */
	public void setMenu (com.justonetech.system.domain.SysMenu menu) {
		this.menu = menu;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.system.domain.SysVisitRecord)) return false;
		else {
			com.justonetech.system.domain.SysVisitRecord sysVisitRecord = (com.justonetech.system.domain.SysVisitRecord) obj;
			if (null == this.getId() || null == sysVisitRecord.getId()) return false;
			else return (this.getId().equals(sysVisitRecord.getId()));
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
		builder.append(userName);
		builder.append(tableName);
		builder.append(tableId);
		builder.append(createTime);
		builder.append(createUser);
		return builder.toString();
	}


}