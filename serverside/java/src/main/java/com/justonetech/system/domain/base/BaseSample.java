package com.justonetech.system.domain.base;

import com.justonetech.system.domain.SysDept;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SAMPLE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * Treeable : true
 * SyncDao : false
 * SyncTemplatepatterns : tree\w*
 * Projectable : false
 * SyncJsp : true
 * SyncBoolean : get
 *
 * @hibernate.class
 *  table="SAMPLE"
 */

public abstract class BaseSample  implements Serializable {

	public static String REF = "Sample";
	public static String PROP_PARENT = "parent";
	public static String PROP_AGE = "age";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_DEPT = "sysDept";
	public static String PROP_IS_MARRIED = "isMarried";
	public static String PROP_NAME = "name";
	public static String PROP_BIRTHDAY = "birthday";
	public static String PROP_EDUCATION = "education";
	public static String PROP_IS_LEAF = "isLeaf";
	public static String PROP_REGISTER_TIME = "registerTime";
	public static String PROP_IMAGE = "image";
	public static String PROP_POSSESSION = "possession";
	public static String PROP_ID = "id";
	public static String PROP_TREE_ID = "treeId";


	// constructors
	public BaseSample () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSample (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseSample (
		java.lang.Long id,
		java.lang.String name) {

		this.setId(id);
		this.setName(name);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String name;
	
	private java.sql.Date birthday;
	
	private double possession;
	
	private java.lang.Integer age;
	
	private java.sql.Timestamp registerTime;
	
	private java.lang.Boolean isMarried;
	
	private java.lang.String description;
	
	private java.lang.Boolean isLeaf;
	
	private java.lang.String treeId;
	
	private Byte[] image;
	

	// many to one
	private com.justonetech.system.domain.SysDept sysDept;
	private com.justonetech.system.domain.SysCodeDetail education;
	private com.justonetech.system.domain.Sample parent;

	// collections
	private java.util.Set<com.justonetech.system.domain.Sample> samples;



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
	 * Return the value associated with the column: NAME
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: NAME
	 * @param name the NAME value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}


	/**
	 * Return the value associated with the column: BIRTHDAY
	 */
	public java.sql.Date getBirthday () {
		return birthday;
	}

	/**
	 * Set the value related to the column: BIRTHDAY
	 * @param birthday the BIRTHDAY value
	 */
	public void setBirthday (java.sql.Date birthday) {
		this.birthday = birthday;
	}


	/**
	 * Return the value associated with the column: POSSESSION
	 */
	public double getPossession () {
		return possession;
	}

	/**
	 * Set the value related to the column: POSSESSION
	 * @param possession the POSSESSION value
	 */
	public void setPossession (double possession) {
		this.possession = possession;
	}


	/**
	 * Return the value associated with the column: AGE
	 */
	public java.lang.Integer getAge () {
		return age;
	}

	/**
	 * Set the value related to the column: AGE
	 * @param age the AGE value
	 */
	public void setAge (java.lang.Integer age) {
		this.age = age;
	}


	/**
	 * Return the value associated with the column: REGISTER_TIME
	 */
	public java.sql.Timestamp getRegisterTime () {
		return registerTime;
	}

	/**
	 * Set the value related to the column: REGISTER_TIME
	 * @param registerTime the REGISTER_TIME value
	 */
	public void setRegisterTime (java.sql.Timestamp registerTime) {
		this.registerTime = registerTime;
	}


	/**
	 * Return the value associated with the column: IS_MARRIED
	 */
	public java.lang.Boolean getIsMarried () {
		return isMarried;
	}

	/**
	 * Set the value related to the column: IS_MARRIED
	 * @param isMarried the IS_MARRIED value
	 */
	public void setIsMarried (java.lang.Boolean isMarried) {
		this.isMarried = isMarried;
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
	 * Return the value associated with the column: IS_LEAF
	 */
	public java.lang.Boolean getIsLeaf () {
		return isLeaf;
	}

	/**
	 * Set the value related to the column: IS_LEAF
	 * @param isLeaf the IS_LEAF value
	 */
	public void setIsLeaf (java.lang.Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}


	/**
	 * Return the value associated with the column: TREE_ID
	 */
	public java.lang.String getTreeId () {
		return treeId;
	}

	/**
	 * Set the value related to the column: TREE_ID
	 * @param treeId the TREE_ID value
	 */
	public void setTreeId (java.lang.String treeId) {
		this.treeId = treeId;
	}


	/**
	 * Return the value associated with the column: IMAGE
	 */
	public Byte[] getImage () {
		return image;
	}

	/**
	 * Set the value related to the column: IMAGE
	 * @param image the IMAGE value
	 */
	public void setImage (Byte[] image) {
		this.image = image;
	}


    public SysDept getSysDept() {
        return sysDept;
    }

    public void setSysDept(SysDept sysDept) {
        this.sysDept = sysDept;
    }

    /**
	 * Return the value associated with the column: EDUCATION_ID
	 */
	public com.justonetech.system.domain.SysCodeDetail getEducation () {
		return education;
	}

	/**
	 * Set the value related to the column: EDUCATION_ID
	 * @param education the EDUCATION_ID value
	 */
	public void setEducation (com.justonetech.system.domain.SysCodeDetail education) {
		this.education = education;
	}


	/**
	 * Return the value associated with the column: PARENT_ID
	 */
	public com.justonetech.system.domain.Sample getParent () {
		return parent;
	}

	/**
	 * Set the value related to the column: PARENT_ID
	 * @param parent the PARENT_ID value
	 */
	public void setParent (com.justonetech.system.domain.Sample parent) {
		this.parent = parent;
	}


	/**
	 * Return the value associated with the column: samples
	 */
	public java.util.Set<com.justonetech.system.domain.Sample> getSamples () {
		if(samples == null){
			samples = new java.util.LinkedHashSet<com.justonetech.system.domain.Sample>();
		}
		return samples;
	}

	/**
	 * Set the value related to the column: samples
	 * @param samples the samples value
	 */
	public void setSamples (java.util.Set<com.justonetech.system.domain.Sample> samples) {
		this.samples = samples;
	}

	public void addTosamples (com.justonetech.system.domain.Sample sample) {
		if (null == getSamples()) setSamples(new java.util.LinkedHashSet<com.justonetech.system.domain.Sample>());
		getSamples().add(sample);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.system.domain.Sample)) return false;
		else {
			com.justonetech.system.domain.Sample sample = (com.justonetech.system.domain.Sample) obj;
			if (null == this.getId() || null == sample.getId()) return false;
			else return (this.getId().equals(sample.getId()));
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
		builder.append(birthday);
		builder.append(possession);
		builder.append(age);
		builder.append(registerTime);
		builder.append(isMarried);
		builder.append(description);
		builder.append(isLeaf);
		builder.append(treeId);
		builder.append(image);
		return builder.toString();
	}


}