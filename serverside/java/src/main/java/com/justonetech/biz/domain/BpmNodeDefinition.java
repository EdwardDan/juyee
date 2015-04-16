package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseBpmNodeDefinition;



public class BpmNodeDefinition extends BaseBpmNodeDefinition {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BpmNodeDefinition () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BpmNodeDefinition (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BpmNodeDefinition (
		java.lang.Long id,
		java.lang.String name) {

		super (
			id,
			name);
	}

/*[CONSTRUCTOR MARKER END]*/


}