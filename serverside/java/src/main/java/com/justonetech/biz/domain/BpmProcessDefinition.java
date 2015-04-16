package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseBpmProcessDefinition;



public class BpmProcessDefinition extends BaseBpmProcessDefinition {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BpmProcessDefinition () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BpmProcessDefinition (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BpmProcessDefinition (
		java.lang.Long id,
		java.lang.String code,
		java.lang.String name) {

		super (
			id,
			code,
			name);
	}

/*[CONSTRUCTOR MARKER END]*/


}