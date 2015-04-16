package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OA_MATERIAL_ITEM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 物资设备采购管理明细
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 物资设备采购管理明细
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : oa
 * Projectable : false
 *
 * @hibernate.class
 *  table="OA_MATERIAL_ITEM"
 */

public abstract class BaseOaMaterialItem  implements Serializable {

	public static String REF = "OaMaterialItem";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_MATERIAL_MODEL = "materialModel";
	public static String PROP_SUPPLIER = "supplier";
	public static String PROP_MATERIAL = "material";
	public static String PROP_MATERIAL_NUM = "materialNum";
	public static String PROP_ID = "id";
	public static String PROP_MATERIAL_NAME = "materialName";
	public static String PROP_MATERIAL_UNIT = "materialUnit";


	// constructors
	public BaseOaMaterialItem () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOaMaterialItem (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*物资设备名称*/
    /*物资设备名称*/
	private java.lang.String materialName;
	
    /*具体规格型号*/
    /*具体规格型号*/
	private java.lang.String materialModel;
	
    /*供应商情况*/
    /*供应商情况*/
	private java.lang.String supplier;
	
    /*数量*/
    /*数量*/
	private java.lang.Double materialNum;
	
    /*单位*/
    /*单位*/
	private java.lang.String materialUnit;
	
    /*备注*/
    /*备注*/
	private java.lang.String description;
	

	// many to one
	private com.justonetech.biz.domain.OaMaterial material;



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
	 * Return the value associated with the column: MATERIAL_NAME
	 */
	public java.lang.String getMaterialName () {
		return materialName;
	}

	/**
	 * Set the value related to the column: MATERIAL_NAME
	 * @param materialName the MATERIAL_NAME value
	 */
	public void setMaterialName (java.lang.String materialName) {
		this.materialName = materialName;
	}


	/**
	 * Return the value associated with the column: MATERIAL_MODEL
	 */
	public java.lang.String getMaterialModel () {
		return materialModel;
	}

	/**
	 * Set the value related to the column: MATERIAL_MODEL
	 * @param materialModel the MATERIAL_MODEL value
	 */
	public void setMaterialModel (java.lang.String materialModel) {
		this.materialModel = materialModel;
	}


	/**
	 * Return the value associated with the column: SUPPLIER
	 */
	public java.lang.String getSupplier () {
		return supplier;
	}

	/**
	 * Set the value related to the column: SUPPLIER
	 * @param supplier the SUPPLIER value
	 */
	public void setSupplier (java.lang.String supplier) {
		this.supplier = supplier;
	}


	/**
	 * Return the value associated with the column: MATERIAL_NUM
	 */
	public java.lang.Double getMaterialNum () {
		return materialNum;
	}

	/**
	 * Set the value related to the column: MATERIAL_NUM
	 * @param materialNum the MATERIAL_NUM value
	 */
	public void setMaterialNum (java.lang.Double materialNum) {
		this.materialNum = materialNum;
	}


	/**
	 * Return the value associated with the column: MATERIAL_UNIT
	 */
	public java.lang.String getMaterialUnit () {
		return materialUnit;
	}

	/**
	 * Set the value related to the column: MATERIAL_UNIT
	 * @param materialUnit the MATERIAL_UNIT value
	 */
	public void setMaterialUnit (java.lang.String materialUnit) {
		this.materialUnit = materialUnit;
	}


	/**
	 * Return the value associated with the column: DESCRIPTION
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: DESCRIPTION
	 * @param description the DESCRIPTION value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}


	/**
	 * Return the value associated with the column: MATERIAL_ID
	 */
	public com.justonetech.biz.domain.OaMaterial getMaterial () {
		return material;
	}

	/**
	 * Set the value related to the column: MATERIAL_ID
	 * @param material the MATERIAL_ID value
	 */
	public void setMaterial (com.justonetech.biz.domain.OaMaterial material) {
		this.material = material;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.OaMaterialItem)) return false;
		else {
			com.justonetech.biz.domain.OaMaterialItem oaMaterialItem = (com.justonetech.biz.domain.OaMaterialItem) obj;
			if (null == this.getId() || null == oaMaterialItem.getId()) return false;
			else return (this.getId().equals(oaMaterialItem.getId()));
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
		builder.append(materialName);
		builder.append(materialModel);
		builder.append(supplier);
		builder.append(materialNum);
		builder.append(materialUnit);
		builder.append(description);
		return builder.toString();
	}


}