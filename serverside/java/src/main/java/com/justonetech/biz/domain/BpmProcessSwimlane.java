package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseBpmProcessSwimlane;



public class BpmProcessSwimlane extends BaseBpmProcessSwimlane {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BpmProcessSwimlane () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BpmProcessSwimlane (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BpmProcessSwimlane (
		java.lang.Long id,
		java.lang.String name) {

		super (
			id,
			name);
	}

/*[CONSTRUCTOR MARKER END]*/


}