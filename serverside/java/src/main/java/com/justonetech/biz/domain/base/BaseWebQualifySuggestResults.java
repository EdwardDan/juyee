package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the WEB_QUALIFY_SUGGEST_RESULTS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 企业资质审查结果
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 企业资质审查结果
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : web
 * Projectable : false
 *
 * @hibernate.class
 *  table="WEB_QUALIFY_SUGGEST_RESULTS"
 */

public abstract class BaseWebQualifySuggestResults  implements Serializable {

	public static String REF = "WebQualifySuggestResults";
	public static String PROP_QUALIFY_SUGGEST = "qualifySuggest";
	public static String PROP_AYYLY = "ayyly";
	public static String PROP_ID = "id";
	public static String PROP_ADVICE = "advice";
	public static String PROP_CONTENT = "content";


	// constructors
	public BaseWebQualifySuggestResults () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWebQualifySuggestResults (Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Long id;

	// fields
    /*受理事项*/
    /*受理事项*/
	private String ayyly;
	
    /*公示意见*/
    /*公示意见*/
	private String advice;
	
    /*公示内容*/
    /*公示内容*/
	private String content;
	

	// many to one
	private com.justonetech.biz.domain.WebUnitQualifySuggest qualifySuggest;



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
	 * Return the value associated with the column: AYYLY
	 */
	public String getAyyly () {
		return ayyly;
	}

	/**
	 * Set the value related to the column: AYYLY
	 * @param ayyly the AYYLY value
	 */
	public void setAyyly (String ayyly) {
		this.ayyly = ayyly;
	}


	/**
	 * Return the value associated with the column: ADVICE
	 */
	public String getAdvice () {
		return advice;
	}

	/**
	 * Set the value related to the column: ADVICE
	 * @param advice the ADVICE value
	 */
	public void setAdvice (String advice) {
		this.advice = advice;
	}


	/**
	 * Return the value associated with the column: CONTENT
	 */
	public String getContent () {
		return content;
	}

	/**
	 * Set the value related to the column: CONTENT
	 * @param content the CONTENT value
	 */
	public void setContent (String content) {
		this.content = content;
	}


	/**
	 * Return the value associated with the column: QUALIFY_SUGGEST_ID
	 */
	public com.justonetech.biz.domain.WebUnitQualifySuggest getQualifySuggest () {
		return qualifySuggest;
	}

	/**
	 * Set the value related to the column: QUALIFY_SUGGEST_ID
	 * @param qualifySuggest the QUALIFY_SUGGEST_ID value
	 */
	public void setQualifySuggest (com.justonetech.biz.domain.WebUnitQualifySuggest qualifySuggest) {
		this.qualifySuggest = qualifySuggest;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.WebQualifySuggestResults)) return false;
		else {
			com.justonetech.biz.domain.WebQualifySuggestResults webQualifySuggestResults = (com.justonetech.biz.domain.WebQualifySuggestResults) obj;
			if (null == this.getId() || null == webQualifySuggestResults.getId()) return false;
			else return (this.getId().equals(webQualifySuggestResults.getId()));
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
		builder.append(ayyly);
		builder.append(advice);
		builder.append(content);
		return builder.toString();
	}


}