package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the POLLING_LAW table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 法律法规查询
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 法律法规查询
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : polling
 * Projectable : false
 *
 * @hibernate.class
 *  table="POLLING_LAW"
 */

public abstract class BasePollingLaw  implements Serializable {

	public static String REF = "PollingLaw";
	public static String PROP_TKSM = "tksm";
	public static String PROP_JDFL = "jdfl";
	public static String PROP_SHOTDES = "shotdes";
	public static String PROP_LX = "lx";
	public static String PROP_TYPE = "type";
	public static String PROP_IITEMNO = "iitemno";
	public static String PROP_ID = "id";
	public static String PROP_CATALOG = "catalog";
	public static String PROP_TKBH = "tkbh";
	public static String PROP_DESCRIPTIONS = "descriptions";
	public static String PROP_STDDOCID = "stddocid";


	// constructors
	public BasePollingLaw () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePollingLaw (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*关联字段ID*/
    /*关联字段ID*/
	private Long stddocid;
	
    /*条款编号*/
    /*条款编号*/
	private String catalog;
	
    /*条款内容*/
    /*条款内容*/
	private String descriptions;
	
    /*标准名称*/
    /*标准名称*/
	private String tksm;
	
    /*标准编号*/
    /*标准编号*/
	private String tkbh;
	
    /*分类*/
    /*分类*/
	private String lx;
	
    /*监督分类*/
    /*监督分类*/
	private String jdfl;
	
    /*序号*/
    /*序号*/
	private String iitemno;
	
    /*类型*/
    /*类型*/
	private Integer type;
	
    /*条款简述*/
    /*条款简述*/
	private String shotdes;
	



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
	 * Return the value associated with the column: STDDOCID
	 */
	public Long getStddocid () {
		return stddocid;
	}

	/**
	 * Set the value related to the column: STDDOCID
	 * @param stddocid the STDDOCID value
	 */
	public void setStddocid (Long stddocid) {
		this.stddocid = stddocid;
	}


	/**
	 * Return the value associated with the column: CATALOG
	 */
	public String getCatalog () {
		return catalog;
	}

	/**
	 * Set the value related to the column: CATALOG
	 * @param catalog the CATALOG value
	 */
	public void setCatalog (String catalog) {
		this.catalog = catalog;
	}


	/**
	 * Return the value associated with the column: DESCRIPTIONS
	 */
	public String getDescriptions () {
		return descriptions;
	}

	/**
	 * Set the value related to the column: DESCRIPTIONS
	 * @param descriptions the DESCRIPTIONS value
	 */
	public void setDescriptions (String descriptions) {
		this.descriptions = descriptions;
	}


	/**
	 * Return the value associated with the column: TKSM
	 */
	public String getTksm () {
		return tksm;
	}

	/**
	 * Set the value related to the column: TKSM
	 * @param tksm the TKSM value
	 */
	public void setTksm (String tksm) {
		this.tksm = tksm;
	}


	/**
	 * Return the value associated with the column: TKBH
	 */
	public String getTkbh () {
		return tkbh;
	}

	/**
	 * Set the value related to the column: TKBH
	 * @param tkbh the TKBH value
	 */
	public void setTkbh (String tkbh) {
		this.tkbh = tkbh;
	}


	/**
	 * Return the value associated with the column: LX
	 */
	public String getLx () {
		return lx;
	}

	/**
	 * Set the value related to the column: LX
	 * @param lx the LX value
	 */
	public void setLx (String lx) {
		this.lx = lx;
	}


	/**
	 * Return the value associated with the column: JDFL
	 */
	public String getJdfl () {
		return jdfl;
	}

	/**
	 * Set the value related to the column: JDFL
	 * @param jdfl the JDFL value
	 */
	public void setJdfl (String jdfl) {
		this.jdfl = jdfl;
	}


	/**
	 * Return the value associated with the column: IITEMNO
	 */
	public String getIitemno () {
		return iitemno;
	}

	/**
	 * Set the value related to the column: IITEMNO
	 * @param iitemno the IITEMNO value
	 */
	public void setIitemno (String iitemno) {
		this.iitemno = iitemno;
	}


	/**
	 * Return the value associated with the column: TYPE
	 */
	public Integer getType () {
		return type;
	}

	/**
	 * Set the value related to the column: TYPE
	 * @param type the TYPE value
	 */
	public void setType (Integer type) {
		this.type = type;
	}


	/**
	 * Return the value associated with the column: SHOTDES
	 */
	public String getShotdes () {
		return shotdes;
	}

	/**
	 * Set the value related to the column: SHOTDES
	 * @param shotdes the SHOTDES value
	 */
	public void setShotdes (String shotdes) {
		this.shotdes = shotdes;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.PollingLaw)) return false;
		else {
			com.justonetech.biz.domain.PollingLaw pollingLaw = (com.justonetech.biz.domain.PollingLaw) obj;
			if (null == this.getId() || null == pollingLaw.getId()) return false;
			else return (this.getId().equals(pollingLaw.getId()));
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
		builder.append(stddocid);
		builder.append(catalog);
		builder.append(descriptions);
		builder.append(tksm);
		builder.append(tkbh);
		builder.append(lx);
		builder.append(jdfl);
		builder.append(iitemno);
		builder.append(type);
		builder.append(shotdes);
		return builder.toString();
	}


}