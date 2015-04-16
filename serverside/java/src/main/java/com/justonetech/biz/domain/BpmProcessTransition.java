package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseBpmProcessTransition;



public class BpmProcessTransition extends BaseBpmProcessTransition {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BpmProcessTransition () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BpmProcessTransition (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BpmProcessTransition (
		java.lang.Long id,
		java.lang.String name) {

		super (
			id,
			name);
	}

/*[CONSTRUCTOR MARKER END]*/


}