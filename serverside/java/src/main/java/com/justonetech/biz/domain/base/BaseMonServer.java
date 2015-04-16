package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MON_SERVER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 视频服务器
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 视频服务器
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : monitor
 * Projectable : false
 *
 * @hibernate.class
 *  table="MON_SERVER"
 */

public abstract class BaseMonServer  implements Serializable {

	public static String REF = "MonServer";
	public static String PROP_IP = "ip";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_PORT = "port";
	public static String PROP_PROJECT_NAME = "name";
	public static String PROP_PROXY_NAME = "proxyName";
	public static String PROP_LOGIN_NAME = "loginName";
	public static String PROP_PASSWORD = "password";
	public static String PROP_ID = "id";
	public static String PROP_SERVER_TYPE = "serverType";
	public static String PROP_PROXY_IP = "proxyIp";
	public static String PROP_SERVER_NAME = "serverName";
	public static String PROP_CONNECT_TYPE = "connectType";


	// constructors
	public BaseMonServer () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMonServer (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*项目名称*/
    /*项目名称*/
	private String name;
	
    /*主机名*/
    /*主机名*/
	private String serverName;
	
    /*IP*/
    /*IP*/
	private String ip;
	
    /*端口*/
    /*端口*/
	private String port;
	
    /*代理IP地址*/
    /*代理IP地址*/
	private String proxyIp;
	
    /*代理IP主机名*/
    /*代理IP主机名*/
	private String proxyName;
	
    /*登录名*/
    /*登录名*/
	private String loginName;
	
    /*密码*/
    /*密码*/
	private String password;
	
    /*备注*/
    /*备注*/
	private String description;
	

	// many to one
	private com.justonetech.system.domain.SysCodeDetail connectType;
	private com.justonetech.system.domain.SysCodeDetail serverType;

	// collections
	private java.util.Set<com.justonetech.biz.domain.MonCamera> monCameras;



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
	 * Return the value associated with the column: Name
	 */
	public String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: PROJECT_NAME
	 * @param name the PROJECT_NAME value
	 */
	public void setName (String name) {
		this.name = name;
	}


	/**
	 * Return the value associated with the column: SERVER_NAME
	 */
	public String getServerName () {
		return serverName;
	}

	/**
	 * Set the value related to the column: SERVER_NAME
	 * @param serverName the SERVER_NAME value
	 */
	public void setServerName (String serverName) {
		this.serverName = serverName;
	}


	/**
	 * Return the value associated with the column: IP
	 */
	public String getIp () {
		return ip;
	}

	/**
	 * Set the value related to the column: IP
	 * @param ip the IP value
	 */
	public void setIp (String ip) {
		this.ip = ip;
	}


	/**
	 * Return the value associated with the column: PORT
	 */
	public String getPort () {
		return port;
	}

	/**
	 * Set the value related to the column: PORT
	 * @param port the PORT value
	 */
	public void setPort (String port) {
		this.port = port;
	}


	/**
	 * Return the value associated with the column: PROXY_IP
	 */
	public String getProxyIp () {
		return proxyIp;
	}

	/**
	 * Set the value related to the column: PROXY_IP
	 * @param proxyIp the PROXY_IP value
	 */
	public void setProxyIp (String proxyIp) {
		this.proxyIp = proxyIp;
	}


	/**
	 * Return the value associated with the column: PROXY_NAME
	 */
	public String getProxyName () {
		return proxyName;
	}

	/**
	 * Set the value related to the column: PROXY_NAME
	 * @param proxyName the PROXY_NAME value
	 */
	public void setProxyName (String proxyName) {
		this.proxyName = proxyName;
	}


	/**
	 * Return the value associated with the column: LOGIN_NAME
	 */
	public String getLoginName () {
		return loginName;
	}

	/**
	 * Set the value related to the column: LOGIN_NAME
	 * @param loginName the LOGIN_NAME value
	 */
	public void setLoginName (String loginName) {
		this.loginName = loginName;
	}


	/**
	 * Return the value associated with the column: PASSWORD
	 */
	public String getPassword () {
		return password;
	}

	/**
	 * Set the value related to the column: PASSWORD
	 * @param password the PASSWORD value
	 */
	public void setPassword (String password) {
		this.password = password;
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
	 * Return the value associated with the column: CONNECT_TYPE_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getConnectType () {
		return connectType;
	}

	/**
	 * Set the value related to the column: CONNECT_TYPE_ID
	 * @param connectType the CONNECT_TYPE_ID value
	 */
	public void setConnectType (com.justonetech.system.domain.SysCodeDetail connectType) {
		this.connectType = connectType;
	}


	/**
	 * Return the value associated with the column: SERVER_TYPE_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getServerType () {
		return serverType;
	}

	/**
	 * Set the value related to the column: SERVER_TYPE_ID
	 * @param serverType the SERVER_TYPE_ID value
	 */
	public void setServerType (com.justonetech.system.domain.SysCodeDetail serverType) {
		this.serverType = serverType;
	}


	/**
	 * Return the value associated with the column: monCameras
	 */
	public java.util.Set<com.justonetech.biz.domain.MonCamera> getMonCameras () {
		if(monCameras == null){
			monCameras = new java.util.LinkedHashSet<com.justonetech.biz.domain.MonCamera>();
		}
		return monCameras;
	}

	/**
	 * Set the value related to the column: monCameras
	 * @param monCameras the monCameras value
	 */
	public void setMonCameras (java.util.Set<com.justonetech.biz.domain.MonCamera> monCameras) {
		this.monCameras = monCameras;
	}

	public void addTomonCameras (com.justonetech.biz.domain.MonCamera monCamera) {
		if (null == getMonCameras()) setMonCameras(new java.util.LinkedHashSet<com.justonetech.biz.domain.MonCamera>());
		getMonCameras().add(monCamera);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.MonServer)) return false;
		else {
			com.justonetech.biz.domain.MonServer monServer = (com.justonetech.biz.domain.MonServer) obj;
			if (null == this.getId() || null == monServer.getId()) return false;
			else return (this.getId().equals(monServer.getId()));
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
		builder.append(serverName);
		builder.append(ip);
		builder.append(port);
		builder.append(proxyIp);
		builder.append(proxyName);
		builder.append(loginName);
		builder.append(password);
		builder.append(description);
		return builder.toString();
	}


}