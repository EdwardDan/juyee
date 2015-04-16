package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the NET_ACCEPT_STATUS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目审批_受理状态设置
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 项目审批_受理状态设置
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : net
 * Projectable : false
 *
 * @hibernate.class
 *  table="NET_ACCEPT_STATUS"
 */

public abstract class BaseNetAcceptStatus  implements Serializable {

	public static String REF = "NetAcceptStatus";
	public static String PROP_NAME = "name";
	public static String PROP_IS_PASS = "isPass";
	public static String PROP_ACCEPT_STEP = "acceptStep";
	public static String PROP_ID = "id";
	public static String PROP_LABEL = "label";
	public static String PROP_NO = "no";
	public static String PROP_IS_END = "isEnd";
	public static String PROP_IS_START = "isStart";


	// constructors
	public BaseNetAcceptStatus () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseNetAcceptStatus (Long id) {
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
	
    /*状态名称*/
    /*状态名称*/
	private String name;
	
    /*受理日期重命名*/
    /*受理日期重命名*/
	private String label;
	
    /*是否通过*/
    /*是否通过*/
	private Boolean isPass;
	
    /*是否开始状态*/
    /*是否开始状态*/
	private Boolean isStart;
	
    /*是否结束状态*/
    /*是否结束状态*/
	private Boolean isEnd;
	

	// many to one
	private com.justonetech.biz.domain.NetAcceptStep acceptStep;

	// collections
	private java.util.Set<com.justonetech.biz.domain.NetOpLog> netOpLogs;
	private java.util.Set<com.justonetech.biz.domain.NetMonitor> netMonitors;
	private java.util.Set<com.justonetech.biz.domain.NetApply> netApplies;
	private java.util.Set<com.justonetech.biz.domain.NetContract> netContracts;
	private java.util.Set<com.justonetech.biz.domain.NetCfb> netCfbs;
	private java.util.Set<com.justonetech.biz.domain.NetSgpermit> netSgpermits;



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
	 * Return the value associated with the column: LABEL
	 */
	public String getLabel () {
		return label;
	}

	/**
	 * Set the value related to the column: LABEL
	 * @param label the LABEL value
	 */
	public void setLabel (String label) {
		this.label = label;
	}


	/**
	 * Return the value associated with the column: IS_PASS
	 */
	public Boolean getIsPass () {
		return isPass;
	}

	/**
	 * Set the value related to the column: IS_PASS
	 * @param isPass the IS_PASS value
	 */
	public void setIsPass (Boolean isPass) {
		this.isPass = isPass;
	}


	/**
	 * Return the value associated with the column: IS_START
	 */
	public Boolean getIsStart () {
		return isStart;
	}

	/**
	 * Set the value related to the column: IS_START
	 * @param isStart the IS_START value
	 */
	public void setIsStart (Boolean isStart) {
		this.isStart = isStart;
	}


	/**
	 * Return the value associated with the column: IS_END
	 */
	public Boolean getIsEnd () {
		return isEnd;
	}

	/**
	 * Set the value related to the column: IS_END
	 * @param isEnd the IS_END value
	 */
	public void setIsEnd (Boolean isEnd) {
		this.isEnd = isEnd;
	}


	/**
	 * Return the value associated with the column: ACCEPT_STEP_ID
	 */
	public com.justonetech.biz.domain.NetAcceptStep getAcceptStep () {
		return acceptStep;
	}

	/**
	 * Set the value related to the column: ACCEPT_STEP_ID
	 * @param acceptStep the ACCEPT_STEP_ID value
	 */
	public void setAcceptStep (com.justonetech.biz.domain.NetAcceptStep acceptStep) {
		this.acceptStep = acceptStep;
	}


	/**
	 * Return the value associated with the column: netOpLogs
	 */
	public java.util.Set<com.justonetech.biz.domain.NetOpLog> getNetOpLogs () {
		if(netOpLogs == null){
			netOpLogs = new java.util.LinkedHashSet<com.justonetech.biz.domain.NetOpLog>();
		}
		return netOpLogs;
	}

	/**
	 * Set the value related to the column: netOpLogs
	 * @param netOpLogs the netOpLogs value
	 */
	public void setNetOpLogs (java.util.Set<com.justonetech.biz.domain.NetOpLog> netOpLogs) {
		this.netOpLogs = netOpLogs;
	}

	public void addTonetOpLogs (com.justonetech.biz.domain.NetOpLog netOpLog) {
		if (null == getNetOpLogs()) setNetOpLogs(new java.util.LinkedHashSet<com.justonetech.biz.domain.NetOpLog>());
		getNetOpLogs().add(netOpLog);
	}


	/**
	 * Return the value associated with the column: netMonitors
	 */
	public java.util.Set<com.justonetech.biz.domain.NetMonitor> getNetMonitors () {
		if(netMonitors == null){
			netMonitors = new java.util.LinkedHashSet<com.justonetech.biz.domain.NetMonitor>();
		}
		return netMonitors;
	}

	/**
	 * Set the value related to the column: netMonitors
	 * @param netMonitors the netMonitors value
	 */
	public void setNetMonitors (java.util.Set<com.justonetech.biz.domain.NetMonitor> netMonitors) {
		this.netMonitors = netMonitors;
	}

	public void addTonetMonitors (com.justonetech.biz.domain.NetMonitor netMonitor) {
		if (null == getNetMonitors()) setNetMonitors(new java.util.LinkedHashSet<com.justonetech.biz.domain.NetMonitor>());
		getNetMonitors().add(netMonitor);
	}


	/**
	 * Return the value associated with the column: netApplies
	 */
	public java.util.Set<com.justonetech.biz.domain.NetApply> getNetApplies () {
		if(netApplies == null){
			netApplies = new java.util.LinkedHashSet<com.justonetech.biz.domain.NetApply>();
		}
		return netApplies;
	}

	/**
	 * Set the value related to the column: netApplies
	 * @param netApplies the netApplies value
	 */
	public void setNetApplies (java.util.Set<com.justonetech.biz.domain.NetApply> netApplies) {
		this.netApplies = netApplies;
	}

	public void addTonetApplies (com.justonetech.biz.domain.NetApply netApply) {
		if (null == getNetApplies()) setNetApplies(new java.util.LinkedHashSet<com.justonetech.biz.domain.NetApply>());
		getNetApplies().add(netApply);
	}


	/**
	 * Return the value associated with the column: netContracts
	 */
	public java.util.Set<com.justonetech.biz.domain.NetContract> getNetContracts () {
		if(netContracts == null){
			netContracts = new java.util.LinkedHashSet<com.justonetech.biz.domain.NetContract>();
		}
		return netContracts;
	}

	/**
	 * Set the value related to the column: netContracts
	 * @param netContracts the netContracts value
	 */
	public void setNetContracts (java.util.Set<com.justonetech.biz.domain.NetContract> netContracts) {
		this.netContracts = netContracts;
	}

	public void addTonetContracts (com.justonetech.biz.domain.NetContract netContract) {
		if (null == getNetContracts()) setNetContracts(new java.util.LinkedHashSet<com.justonetech.biz.domain.NetContract>());
		getNetContracts().add(netContract);
	}


	/**
	 * Return the value associated with the column: netCfbs
	 */
	public java.util.Set<com.justonetech.biz.domain.NetCfb> getNetCfbs () {
		if(netCfbs == null){
			netCfbs = new java.util.LinkedHashSet<com.justonetech.biz.domain.NetCfb>();
		}
		return netCfbs;
	}

	/**
	 * Set the value related to the column: netCfbs
	 * @param netCfbs the netCfbs value
	 */
	public void setNetCfbs (java.util.Set<com.justonetech.biz.domain.NetCfb> netCfbs) {
		this.netCfbs = netCfbs;
	}

	public void addTonetCfbs (com.justonetech.biz.domain.NetCfb netCfb) {
		if (null == getNetCfbs()) setNetCfbs(new java.util.LinkedHashSet<com.justonetech.biz.domain.NetCfb>());
		getNetCfbs().add(netCfb);
	}


	/**
	 * Return the value associated with the column: netSgpermits
	 */
	public java.util.Set<com.justonetech.biz.domain.NetSgpermit> getNetSgpermits () {
		if(netSgpermits == null){
			netSgpermits = new java.util.LinkedHashSet<com.justonetech.biz.domain.NetSgpermit>();
		}
		return netSgpermits;
	}

	/**
	 * Set the value related to the column: netSgpermits
	 * @param netSgpermits the netSgpermits value
	 */
	public void setNetSgpermits (java.util.Set<com.justonetech.biz.domain.NetSgpermit> netSgpermits) {
		this.netSgpermits = netSgpermits;
	}

	public void addTonetSgpermits (com.justonetech.biz.domain.NetSgpermit netSgpermit) {
		if (null == getNetSgpermits()) setNetSgpermits(new java.util.LinkedHashSet<com.justonetech.biz.domain.NetSgpermit>());
		getNetSgpermits().add(netSgpermit);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.NetAcceptStatus)) return false;
		else {
			com.justonetech.biz.domain.NetAcceptStatus netAcceptStatus = (com.justonetech.biz.domain.NetAcceptStatus) obj;
			if (null == this.getId() || null == netAcceptStatus.getId()) return false;
			else return (this.getId().equals(netAcceptStatus.getId()));
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
		builder.append(name);
		builder.append(label);
		builder.append(isPass);
		builder.append(isStart);
		builder.append(isEnd);
		return builder.toString();
	}


}