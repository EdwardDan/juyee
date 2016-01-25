package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SG_PERMIT_HD_EXTEND table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 施工许可_航道扩展信息
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 施工许可_航道扩展信息
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : sg
 * Projectable : false
 *
 * @hibernate.class
 *  table="SG_PERMIT_HD_EXTEND"
 */

public abstract class BaseSgPermitHdExtend  implements Serializable {

	public static String REF = "SgPermitHdExtend";
	public static String PROP_GKPZ_CODE = "gkpzCode";
	public static String PROP_MAIN_SG_ZZDJ = "mainSgZzdj";
	public static String PROP_HZ_DATE = "hzDate";
	public static String PROP_MAIN_JL_ZSBH2 = "mainJlZsbh2";
	public static String PROP_PF_DATE = "pfDate";
	public static String PROP_PF_GQ = "pfGq";
	public static String PROP_MAIN_SJ_UNIT = "mainSjUnit";
	public static String PROP_MAIN_SJ_ZBFS = "mainSjZbfs";
	public static String PROP_MAIN_SG_XMFZR = "mainSgXmfzr";
	public static String PROP_MAIN_JL_ZBJ = "mainJlZbj";
	public static String PROP_MAIN_JL_ZSBH = "mainJlZsbh";
	public static String PROP_MAIN_JL_ZBFS = "mainJlZbfs";
	public static String PROP_MAIN_SG_UNIT = "mainSgUnit";
	public static String PROP_MAIN_SJ_ZSBH = "mainSjZsbh";
	public static String PROP_PLAN_COST = "planCost";
	public static String PROP_MAIN_SJ_ZZDJ = "mainSjZzdj";
	public static String PROP_SG_PERMIT = "sgPermit";
	public static String PROP_MAIN_JL_XMFZR = "mainJlXmfzr";
	public static String PROP_MAIN_SJ_XMFZR = "mainSjXmfzr";
	public static String PROP_MAIN_SG_ZBFS = "mainSgZbfs";
	public static String PROP_MAIN_SJ_ZBJ = "mainSjZbj";
	public static String PROP_MAIN_JL_ZZDJ = "mainJlZzdj";
	public static String PROP_MAIN_SG_ZSBH2 = "mainSgZsbh2";
	public static String PROP_PZJG_CODE = "pzjgCode";
	public static String PROP_CBSH_CODE = "cbshCode";
	public static String PROP_MAIN_JL_UNIT = "mainJlUnit";
	public static String PROP_COST_FROM = "costFrom";
	public static String PROP_MAIN_SG_ZSBH = "mainSgZsbh";
	public static String PROP_MAIN_SG_ZBJ = "mainSgZbj";
	public static String PROP_ID = "id";
	public static String PROP_TOTAL_GS = "totalGs";
	public static String PROP_MAIN_SJ_ZSBH2 = "mainSjZsbh2";


	// constructors
	public BaseSgPermitHdExtend () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSgPermitHdExtend (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*主要设计单位*/
    /*主要设计单位*/
	private java.lang.String mainSjUnit;

	/*主要设计招标方式*/
    /*主要设计招标方式*/
	private java.lang.String mainSjZbfs;

	/*主要设计中标价*/
    /*主要设计中标价*/
	private java.lang.Double mainSjZbj;

	/*主要设计资质等级*/
    /*主要设计资质等级*/
	private java.lang.String mainSjZzdj;

	/*主要设计项目负责人*/
    /*主要设计项目负责人*/
	private java.lang.String mainSjXmfzr;

	/*主要设计证书编号*/
    /*主要设计证书编号*/
	private java.lang.String mainSjZsbh;

	/*主要设计证书编号2*/
    /*主要设计证书编号2*/
	private java.lang.String mainSjZsbh2;

	/*主要监理单位*/
    /*主要监理单位*/
	private java.lang.String mainJlUnit;

	/*主要监理招标方式*/
    /*主要监理招标方式*/
	private java.lang.String mainJlZbfs;

	/*主要监理中标价*/
    /*主要监理中标价*/
	private java.lang.Double mainJlZbj;

	/*主要监理资质等级*/
    /*主要监理资质等级*/
	private java.lang.String mainJlZzdj;

	/*主要监理项目负责人*/
    /*主要监理项目负责人*/
	private java.lang.String mainJlXmfzr;

	/*主要监理证书编号*/
    /*主要监理证书编号*/
	private java.lang.String mainJlZsbh;

	/*主要监理证书编号2*/
    /*主要监理证书编号2*/
	private java.lang.String mainJlZsbh2;

	/*主要施工单位*/
    /*主要施工单位*/
	private java.lang.String mainSgUnit;

	/*主要施工招标方式*/
    /*主要施工招标方式*/
	private java.lang.String mainSgZbfs;

	/*主要施工中标价*/
    /*主要施工中标价*/
	private java.lang.Double mainSgZbj;

	/*主要施工资质等级*/
    /*主要施工资质等级*/
	private java.lang.String mainSgZzdj;

	/*主要施工项目负责人*/
    /*主要施工项目负责人*/
	private java.lang.String mainSgXmfzr;

	/*主要施工证书编号*/
    /*主要施工证书编号*/
	private java.lang.String mainSgZsbh;

	/*主要施工证书编号2*/
    /*主要施工证书编号2*/
	private java.lang.String mainSgZsbh2;

	/*工可批准或核准机关和文号*/
    /*工可批准或核准机关和文号*/
	private java.lang.String gkpzCode;

	/*批复或核准日期*/
    /*批复或核准日期*/
	private java.sql.Date hzDate;

	/*投资估算*/
    /*投资估算*/
	private java.lang.Double planCost;

	/*初步设计批准机关和文号*/
    /*初步设计批准机关和文号*/
	private java.lang.String cbshCode;

	/*批复日期*/
    /*批复日期*/
	private java.sql.Date pfDate;

	/*批复工期*/
    /*批复工期*/
	private java.lang.Integer pfGq;

	/*总概算*/
    /*总概算*/
	private java.lang.Double totalGs;

	/*批准机关和文号*/
    /*批准机关和文号*/
	private java.lang.String pzjgCode;

	/*投资来源*/
    /*投资来源*/
	private java.lang.String costFrom;


	// many to one
	private com.justonetech.biz.domain.SgPermit sgPermit;



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
	 * Return the value associated with the column: MAIN_SJ_UNIT
	 */
	public java.lang.String getMainSjUnit () {
		return mainSjUnit;
	}

	/**
	 * Set the value related to the column: MAIN_SJ_UNIT
	 * @param mainSjUnit the MAIN_SJ_UNIT value
	 */
	public void setMainSjUnit (java.lang.String mainSjUnit) {
		this.mainSjUnit = mainSjUnit;
	}


	/**
	 * Return the value associated with the column: MAIN_SJ_ZBFS
	 */
	public java.lang.String getMainSjZbfs () {
		return mainSjZbfs;
	}

	/**
	 * Set the value related to the column: MAIN_SJ_ZBFS
	 * @param mainSjZbfs the MAIN_SJ_ZBFS value
	 */
	public void setMainSjZbfs (java.lang.String mainSjZbfs) {
		this.mainSjZbfs = mainSjZbfs;
	}


	/**
	 * Return the value associated with the column: MAIN_SJ_ZBJ
	 */
	public java.lang.Double getMainSjZbj () {
		return mainSjZbj;
	}

	/**
	 * Set the value related to the column: MAIN_SJ_ZBJ
	 * @param mainSjZbj the MAIN_SJ_ZBJ value
	 */
	public void setMainSjZbj (java.lang.Double mainSjZbj) {
		this.mainSjZbj = mainSjZbj;
	}


	/**
	 * Return the value associated with the column: MAIN_SJ_ZZDJ
	 */
	public java.lang.String getMainSjZzdj () {
		return mainSjZzdj;
	}

	/**
	 * Set the value related to the column: MAIN_SJ_ZZDJ
	 * @param mainSjZzdj the MAIN_SJ_ZZDJ value
	 */
	public void setMainSjZzdj (java.lang.String mainSjZzdj) {
		this.mainSjZzdj = mainSjZzdj;
	}


	/**
	 * Return the value associated with the column: MAIN_SJ_XMFZR
	 */
	public java.lang.String getMainSjXmfzr () {
		return mainSjXmfzr;
	}

	/**
	 * Set the value related to the column: MAIN_SJ_XMFZR
	 * @param mainSjXmfzr the MAIN_SJ_XMFZR value
	 */
	public void setMainSjXmfzr (java.lang.String mainSjXmfzr) {
		this.mainSjXmfzr = mainSjXmfzr;
	}


	/**
	 * Return the value associated with the column: MAIN_SJ_ZSBH
	 */
	public java.lang.String getMainSjZsbh () {
		return mainSjZsbh;
	}

	/**
	 * Set the value related to the column: MAIN_SJ_ZSBH
	 * @param mainSjZsbh the MAIN_SJ_ZSBH value
	 */
	public void setMainSjZsbh (java.lang.String mainSjZsbh) {
		this.mainSjZsbh = mainSjZsbh;
	}


	/**
	 * Return the value associated with the column: MAIN_SJ_ZSBH2
	 */
	public java.lang.String getMainSjZsbh2 () {
		return mainSjZsbh2;
	}

	/**
	 * Set the value related to the column: MAIN_SJ_ZSBH2
	 * @param mainSjZsbh2 the MAIN_SJ_ZSBH2 value
	 */
	public void setMainSjZsbh2 (java.lang.String mainSjZsbh2) {
		this.mainSjZsbh2 = mainSjZsbh2;
	}


	/**
	 * Return the value associated with the column: MAIN_JL_UNIT
	 */
	public java.lang.String getMainJlUnit () {
		return mainJlUnit;
	}

	/**
	 * Set the value related to the column: MAIN_JL_UNIT
	 * @param mainJlUnit the MAIN_JL_UNIT value
	 */
	public void setMainJlUnit (java.lang.String mainJlUnit) {
		this.mainJlUnit = mainJlUnit;
	}


	/**
	 * Return the value associated with the column: MAIN_JL_ZBFS
	 */
	public java.lang.String getMainJlZbfs () {
		return mainJlZbfs;
	}

	/**
	 * Set the value related to the column: MAIN_JL_ZBFS
	 * @param mainJlZbfs the MAIN_JL_ZBFS value
	 */
	public void setMainJlZbfs (java.lang.String mainJlZbfs) {
		this.mainJlZbfs = mainJlZbfs;
	}


	/**
	 * Return the value associated with the column: MAIN_JL_ZBJ
	 */
	public java.lang.Double getMainJlZbj () {
		return mainJlZbj;
	}

	/**
	 * Set the value related to the column: MAIN_JL_ZBJ
	 * @param mainJlZbj the MAIN_JL_ZBJ value
	 */
	public void setMainJlZbj (java.lang.Double mainJlZbj) {
		this.mainJlZbj = mainJlZbj;
	}


	/**
	 * Return the value associated with the column: MAIN_JL_ZZDJ
	 */
	public java.lang.String getMainJlZzdj () {
		return mainJlZzdj;
	}

	/**
	 * Set the value related to the column: MAIN_JL_ZZDJ
	 * @param mainJlZzdj the MAIN_JL_ZZDJ value
	 */
	public void setMainJlZzdj (java.lang.String mainJlZzdj) {
		this.mainJlZzdj = mainJlZzdj;
	}


	/**
	 * Return the value associated with the column: MAIN_JL_XMFZR
	 */
	public java.lang.String getMainJlXmfzr () {
		return mainJlXmfzr;
	}

	/**
	 * Set the value related to the column: MAIN_JL_XMFZR
	 * @param mainJlXmfzr the MAIN_JL_XMFZR value
	 */
	public void setMainJlXmfzr (java.lang.String mainJlXmfzr) {
		this.mainJlXmfzr = mainJlXmfzr;
	}


	/**
	 * Return the value associated with the column: MAIN_JL_ZSBH
	 */
	public java.lang.String getMainJlZsbh () {
		return mainJlZsbh;
	}

	/**
	 * Set the value related to the column: MAIN_JL_ZSBH
	 * @param mainJlZsbh the MAIN_JL_ZSBH value
	 */
	public void setMainJlZsbh (java.lang.String mainJlZsbh) {
		this.mainJlZsbh = mainJlZsbh;
	}


	/**
	 * Return the value associated with the column: MAIN_JL_ZSBH2
	 */
	public java.lang.String getMainJlZsbh2 () {
		return mainJlZsbh2;
	}

	/**
	 * Set the value related to the column: MAIN_JL_ZSBH2
	 * @param mainJlZsbh2 the MAIN_JL_ZSBH2 value
	 */
	public void setMainJlZsbh2 (java.lang.String mainJlZsbh2) {
		this.mainJlZsbh2 = mainJlZsbh2;
	}


	/**
	 * Return the value associated with the column: MAIN_SG_UNIT
	 */
	public java.lang.String getMainSgUnit () {
		return mainSgUnit;
	}

	/**
	 * Set the value related to the column: MAIN_SG_UNIT
	 * @param mainSgUnit the MAIN_SG_UNIT value
	 */
	public void setMainSgUnit (java.lang.String mainSgUnit) {
		this.mainSgUnit = mainSgUnit;
	}


	/**
	 * Return the value associated with the column: MAIN_SG_ZBFS
	 */
	public java.lang.String getMainSgZbfs () {
		return mainSgZbfs;
	}

	/**
	 * Set the value related to the column: MAIN_SG_ZBFS
	 * @param mainSgZbfs the MAIN_SG_ZBFS value
	 */
	public void setMainSgZbfs (java.lang.String mainSgZbfs) {
		this.mainSgZbfs = mainSgZbfs;
	}


	/**
	 * Return the value associated with the column: MAIN_SG_ZBJ
	 */
	public java.lang.Double getMainSgZbj () {
		return mainSgZbj;
	}

	/**
	 * Set the value related to the column: MAIN_SG_ZBJ
	 * @param mainSgZbj the MAIN_SG_ZBJ value
	 */
	public void setMainSgZbj (java.lang.Double mainSgZbj) {
		this.mainSgZbj = mainSgZbj;
	}


	/**
	 * Return the value associated with the column: MAIN_SG_ZZDJ
	 */
	public java.lang.String getMainSgZzdj () {
		return mainSgZzdj;
	}

	/**
	 * Set the value related to the column: MAIN_SG_ZZDJ
	 * @param mainSgZzdj the MAIN_SG_ZZDJ value
	 */
	public void setMainSgZzdj (java.lang.String mainSgZzdj) {
		this.mainSgZzdj = mainSgZzdj;
	}


	/**
	 * Return the value associated with the column: MAIN_SG_XMFZR
	 */
	public java.lang.String getMainSgXmfzr () {
		return mainSgXmfzr;
	}

	/**
	 * Set the value related to the column: MAIN_SG_XMFZR
	 * @param mainSgXmfzr the MAIN_SG_XMFZR value
	 */
	public void setMainSgXmfzr (java.lang.String mainSgXmfzr) {
		this.mainSgXmfzr = mainSgXmfzr;
	}


	/**
	 * Return the value associated with the column: MAIN_SG_ZSBH
	 */
	public java.lang.String getMainSgZsbh () {
		return mainSgZsbh;
	}

	/**
	 * Set the value related to the column: MAIN_SG_ZSBH
	 * @param mainSgZsbh the MAIN_SG_ZSBH value
	 */
	public void setMainSgZsbh (java.lang.String mainSgZsbh) {
		this.mainSgZsbh = mainSgZsbh;
	}


	/**
	 * Return the value associated with the column: MAIN_SG_ZSBH2
	 */
	public java.lang.String getMainSgZsbh2 () {
		return mainSgZsbh2;
	}

	/**
	 * Set the value related to the column: MAIN_SG_ZSBH2
	 * @param mainSgZsbh2 the MAIN_SG_ZSBH2 value
	 */
	public void setMainSgZsbh2 (java.lang.String mainSgZsbh2) {
		this.mainSgZsbh2 = mainSgZsbh2;
	}


	/**
	 * Return the value associated with the column: GKPZ_CODE
	 */
	public java.lang.String getGkpzCode () {
		return gkpzCode;
	}

	/**
	 * Set the value related to the column: GKPZ_CODE
	 * @param gkpzCode the GKPZ_CODE value
	 */
	public void setGkpzCode (java.lang.String gkpzCode) {
		this.gkpzCode = gkpzCode;
	}


	/**
	 * Return the value associated with the column: HZ_DATE
	 */
	public java.sql.Date getHzDate () {
		return hzDate;
	}

	/**
	 * Set the value related to the column: HZ_DATE
	 * @param hzDate the HZ_DATE value
	 */
	public void setHzDate (java.sql.Date hzDate) {
		this.hzDate = hzDate;
	}


	/**
	 * Return the value associated with the column: PLAN_COST
	 */
	public java.lang.Double getPlanCost () {
		return planCost;
	}

	/**
	 * Set the value related to the column: PLAN_COST
	 * @param planCost the PLAN_COST value
	 */
	public void setPlanCost (java.lang.Double planCost) {
		this.planCost = planCost;
	}


	/**
	 * Return the value associated with the column: CBSH_CODE
	 */
	public java.lang.String getCbshCode () {
		return cbshCode;
	}

	/**
	 * Set the value related to the column: CBSH_CODE
	 * @param cbshCode the CBSH_CODE value
	 */
	public void setCbshCode (java.lang.String cbshCode) {
		this.cbshCode = cbshCode;
	}


	/**
	 * Return the value associated with the column: PF_DATE
	 */
	public java.sql.Date getPfDate () {
		return pfDate;
	}

	/**
	 * Set the value related to the column: PF_DATE
	 * @param pfDate the PF_DATE value
	 */
	public void setPfDate (java.sql.Date pfDate) {
		this.pfDate = pfDate;
	}


	/**
	 * Return the value associated with the column: PF_GQ
	 */
	public java.lang.Integer getPfGq () {
		return pfGq;
	}

	/**
	 * Set the value related to the column: PF_GQ
	 * @param pfGq the PF_GQ value
	 */
	public void setPfGq (java.lang.Integer pfGq) {
		this.pfGq = pfGq;
	}


	/**
	 * Return the value associated with the column: TOTAL_GS
	 */
	public java.lang.Double getTotalGs () {
		return totalGs;
	}

	/**
	 * Set the value related to the column: TOTAL_GS
	 * @param totalGs the TOTAL_GS value
	 */
	public void setTotalGs (java.lang.Double totalGs) {
		this.totalGs = totalGs;
	}


	/**
	 * Return the value associated with the column: PZJG_CODE
	 */
	public java.lang.String getPzjgCode () {
		return pzjgCode;
	}

	/**
	 * Set the value related to the column: PZJG_CODE
	 * @param pzjgCode the PZJG_CODE value
	 */
	public void setPzjgCode (java.lang.String pzjgCode) {
		this.pzjgCode = pzjgCode;
	}


	/**
	 * Return the value associated with the column: COST_FROM
	 */
	public java.lang.String getCostFrom () {
		return costFrom;
	}

	/**
	 * Set the value related to the column: COST_FROM
	 * @param costFrom the COST_FROM value
	 */
	public void setCostFrom (java.lang.String costFrom) {
		this.costFrom = costFrom;
	}


	/**
	 * Return the value associated with the column: SG_PERMIT_ID
	 */
	public com.justonetech.biz.domain.SgPermit getSgPermit () {
		return sgPermit;
	}

	/**
	 * Set the value related to the column: SG_PERMIT_ID
	 * @param sgPermit the SG_PERMIT_ID value
	 */
	public void setSgPermit (com.justonetech.biz.domain.SgPermit sgPermit) {
		this.sgPermit = sgPermit;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.SgPermitHdExtend)) return false;
		else {
			com.justonetech.biz.domain.SgPermitHdExtend sgPermitHdExtend = (com.justonetech.biz.domain.SgPermitHdExtend) obj;
			if (null == this.getId() || null == sgPermitHdExtend.getId()) return false;
			else return (this.getId().equals(sgPermitHdExtend.getId()));
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
		builder.append(mainSjUnit);
		builder.append(mainSjZbfs);
		builder.append(mainSjZbj);
		builder.append(mainSjZzdj);
		builder.append(mainSjXmfzr);
		builder.append(mainSjZsbh);
		builder.append(mainSjZsbh2);
		builder.append(mainJlUnit);
		builder.append(mainJlZbfs);
		builder.append(mainJlZbj);
		builder.append(mainJlZzdj);
		builder.append(mainJlXmfzr);
		builder.append(mainJlZsbh);
		builder.append(mainJlZsbh2);
		builder.append(mainSgUnit);
		builder.append(mainSgZbfs);
		builder.append(mainSgZbj);
		builder.append(mainSgZzdj);
		builder.append(mainSgXmfzr);
		builder.append(mainSgZsbh);
		builder.append(mainSgZsbh2);
		builder.append(gkpzCode);
		builder.append(hzDate);
		builder.append(planCost);
		builder.append(cbshCode);
		builder.append(pfDate);
		builder.append(pfGq);
		builder.append(totalGs);
		builder.append(pzjgCode);
		builder.append(costFrom);
		return builder.toString();
	}


}
