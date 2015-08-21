package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PROJ_EXTEND_COST table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目投资情况
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 项目投资情况
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : project
 * Projectable : false
 *
 * @hibernate.class
 *  table="PROJ_EXTEND_COST"
 */

public abstract class BaseProjExtendCost  implements Serializable,Auditable {

	public static String REF = "ProjExtendCost";
	public static String PROP_YEAR = "year";
	public static String PROP_CZZJ_YBF = "czzjYbf";
	public static String PROP_TYPE = "type";
	public static String PROP_CZZJ_YWC = "czzjYwc";
	public static String PROP_HALF = "half";
	public static String PROP_ID = "id";
	public static String PROP_MONTH = "month";
	public static String PROP_PROJ_EXTEND = "projExtend";
	public static String PROP_TITLE = "title";
	public static String PROP_ACC_COMPLETE = "accComplete";


	// constructors
	public BaseProjExtendCost () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProjExtendCost (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*类型*/
    /*类型*/
	private String type;
	
    /*年*/
    /*年*/
	private Integer year;
	
    /*月*/
    /*月*/
	private Integer month;
	
    /*半年*/
    /*半年*/
	private String half;
	
    /*时间（冗余字段）*/
    /*时间（冗余字段）*/
	private String title;
	
    /*累计完成投资（亿元）*/
    /*累计完成投资（亿元）*/
	private Double accComplete;
	
    /*财政资金已拨付额（亿元）*/
    /*财政资金已拨付额（亿元）*/
	private Double czzjYbf;
	
    /*财政资金已完成额（亿元）*/
    /*财政资金已完成额（亿元）*/
	private Double czzjYwc;
	

	// many to one
	private com.justonetech.biz.domain.ProjExtend projExtend;



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
	 * Return the value associated with the column: TYPE
	 */
	public String getType () {
		return type;
	}

	/**
	 * Set the value related to the column: TYPE
	 * @param type the TYPE value
	 */
	public void setType (String type) {
		this.type = type;
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
	 * Return the value associated with the column: MONTH
	 */
	public Integer getMonth () {
		return month;
	}

	/**
	 * Set the value related to the column: MONTH
	 * @param month the MONTH value
	 */
	public void setMonth (Integer month) {
		this.month = month;
	}


	/**
	 * Return the value associated with the column: HALF
	 */
	public String getHalf () {
		return half;
	}

	/**
	 * Set the value related to the column: HALF
	 * @param half the HALF value
	 */
	public void setHalf (String half) {
		this.half = half;
	}


	/**
	 * Return the value associated with the column: TITLE
	 */
	public String getTitle () {
		return title;
	}

	/**
	 * Set the value related to the column: TITLE
	 * @param title the TITLE value
	 */
	public void setTitle (String title) {
		this.title = title;
	}


	/**
	 * Return the value associated with the column: ACC_COMPLETE
	 */
	public Double getAccComplete () {
		return accComplete;
	}

	/**
	 * Set the value related to the column: ACC_COMPLETE
	 * @param accComplete the ACC_COMPLETE value
	 */
	public void setAccComplete (Double accComplete) {
		this.accComplete = accComplete;
	}


	/**
	 * Return the value associated with the column: CZZJ_YBF
	 */
	public Double getCzzjYbf () {
		return czzjYbf;
	}

	/**
	 * Set the value related to the column: CZZJ_YBF
	 * @param czzjYbf the CZZJ_YBF value
	 */
	public void setCzzjYbf (Double czzjYbf) {
		this.czzjYbf = czzjYbf;
	}


	/**
	 * Return the value associated with the column: CZZJ_YWC
	 */
	public Double getCzzjYwc () {
		return czzjYwc;
	}

	/**
	 * Set the value related to the column: CZZJ_YWC
	 * @param czzjYwc the CZZJ_YWC value
	 */
	public void setCzzjYwc (Double czzjYwc) {
		this.czzjYwc = czzjYwc;
	}


	/**
	 * Return the value associated with the column: PROJ_EXTEND_ID
	 */
	public com.justonetech.biz.domain.ProjExtend getProjExtend () {
		return projExtend;
	}

	/**
	 * Set the value related to the column: PROJ_EXTEND_ID
	 * @param projExtend the PROJ_EXTEND_ID value
	 */
	public void setProjExtend (com.justonetech.biz.domain.ProjExtend projExtend) {
		this.projExtend = projExtend;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ProjExtendCost)) return false;
		else {
			com.justonetech.biz.domain.ProjExtendCost projExtendCost = (com.justonetech.biz.domain.ProjExtendCost) obj;
			if (null == this.getId() || null == projExtendCost.getId()) return false;
			else return (this.getId().equals(projExtendCost.getId()));
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
		builder.append(type);
		builder.append(year);
		builder.append(month);
		builder.append(half);
		builder.append(title);
		builder.append(accComplete);
		builder.append(czzjYbf);
		builder.append(czzjYwc);
		return builder.toString();
	}


}