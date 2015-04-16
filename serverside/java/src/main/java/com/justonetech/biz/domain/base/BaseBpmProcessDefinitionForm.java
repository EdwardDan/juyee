package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BPM_PROCESS_DEFINITION_FORM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 业务流程关联表单模板
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 业务流程关联表单模板
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : workflow
 * Projectable : false
 *
 * @hibernate.class
 *  table="BPM_PROCESS_DEFINITION_FORM"
 */

public abstract class BaseBpmProcessDefinitionForm  implements Serializable {

	public static String REF = "BpmProcessDefinitionForm";
	public static String PROP_PROCESS_DEFINITION = "processDefinition";
	public static String PROP_ID = "id";
	public static String PROP_FORM_TEMPLATE = "formTemplate";


	// constructors
	public BaseBpmProcessDefinitionForm () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBpmProcessDefinitionForm (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// many to one
	private com.justonetech.biz.domain.BpmFormTemplate formTemplate;
	private com.justonetech.biz.domain.BpmProcessDefinition processDefinition;



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
	 * Return the value associated with the column: FORM_TEMPLATE_ID
	 */
	public com.justonetech.biz.domain.BpmFormTemplate getFormTemplate () {
		return formTemplate;
	}

	/**
	 * Set the value related to the column: FORM_TEMPLATE_ID
	 * @param formTemplate the FORM_TEMPLATE_ID value
	 */
	public void setFormTemplate (com.justonetech.biz.domain.BpmFormTemplate formTemplate) {
		this.formTemplate = formTemplate;
	}


	/**
	 * Return the value associated with the column: PROCESS_DEFINITION_ID
	 */
	public com.justonetech.biz.domain.BpmProcessDefinition getProcessDefinition () {
		return processDefinition;
	}

	/**
	 * Set the value related to the column: PROCESS_DEFINITION_ID
	 * @param processDefinition the PROCESS_DEFINITION_ID value
	 */
	public void setProcessDefinition (com.justonetech.biz.domain.BpmProcessDefinition processDefinition) {
		this.processDefinition = processDefinition;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.BpmProcessDefinitionForm)) return false;
		else {
			com.justonetech.biz.domain.BpmProcessDefinitionForm bpmProcessDefinitionForm = (com.justonetech.biz.domain.BpmProcessDefinitionForm) obj;
			if (null == this.getId() || null == bpmProcessDefinitionForm.getId()) return false;
			else return (this.getId().equals(bpmProcessDefinitionForm.getId()));
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
		return builder.toString();
	}


}