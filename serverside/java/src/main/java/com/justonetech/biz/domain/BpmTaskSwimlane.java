package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseBpmTaskSwimlane;



public class BpmTaskSwimlane extends BaseBpmTaskSwimlane {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BpmTaskSwimlane () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BpmTaskSwimlane (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BpmTaskSwimlane (
		java.lang.Long id,
		java.lang.String name) {

		super (
			id,
			name);
	}

/*[CONSTRUCTOR MARKER END]*/


}