package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PROJ_EXTEND_SCHEDULE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目建设情况
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 项目建设情况
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : project
 * Projectable : false
 *
 * @hibernate.class
 *  table="PROJ_EXTEND_SCHEDULE"
 */

public abstract class BaseProjExtendSchedule  implements Serializable,Auditable {

	public static String REF = "ProjExtendSchedule";
	public static String PROP_PROJ_PROGRESS = "projProgress";
	public static String PROP_YEAR = "year";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_QUESTION = "question";
	public static String PROP_IMPROVE_OPINION = "improveOpinion";
	public static String PROP_ID = "id";
	public static String PROP_MONTH = "month";
	public static String PROP_PROJ_EXTEND = "projExtend";
	public static String PROP_TITLE = "title";


	// constructors
	public BaseProjExtendSchedule () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProjExtendSchedule (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*年*/
    /*年*/
	private Integer year;
	
    /*月*/
    /*月*/
	private Integer month;
	
    /*时间（冗余字段）*/
    /*时间（冗余字段）*/
	private String title;
	
    /*项目进展情况*/
    /*项目进展情况*/
	private String projProgress;
	
    /*存在问题*/
    /*存在问题*/
	private String question;
	
    /*改进意见*/
    /*改进意见*/
	private String improveOpinion;
	
    /*备注*/
    /*备注*/
	private String description;
	

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
	 * Return the value associated with the column: PROJ_PROGRESS
	 */
	public String getProjProgress () {
		return projProgress;
	}

	/**
	 * Set the value related to the column: PROJ_PROGRESS
	 * @param projProgress the PROJ_PROGRESS value
	 */
	public void setProjProgress (String projProgress) {
		this.projProgress = projProgress;
	}


	/**
	 * Return the value associated with the column: QUESTION
	 */
	public String getQuestion () {
		return question;
	}

	/**
	 * Set the value related to the column: QUESTION
	 * @param question the QUESTION value
	 */
	public void setQuestion (String question) {
		this.question = question;
	}


	/**
	 * Return the value associated with the column: IMPROVE_OPINION
	 */
	public String getImproveOpinion () {
		return improveOpinion;
	}

	/**
	 * Set the value related to the column: IMPROVE_OPINION
	 * @param improveOpinion the IMPROVE_OPINION value
	 */
	public void setImproveOpinion (String improveOpinion) {
		this.improveOpinion = improveOpinion;
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
		if (!(obj instanceof com.justonetech.biz.domain.ProjExtendSchedule)) return false;
		else {
			com.justonetech.biz.domain.ProjExtendSchedule projExtendSchedule = (com.justonetech.biz.domain.ProjExtendSchedule) obj;
			if (null == this.getId() || null == projExtendSchedule.getId()) return false;
			else return (this.getId().equals(projExtendSchedule.getId()));
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
		builder.append(year);
		builder.append(month);
		builder.append(title);
		builder.append(projProgress);
		builder.append(question);
		builder.append(improveOpinion);
		builder.append(description);
		return builder.toString();
	}


}