package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseOaTask;



public class OaTask extends BaseOaTask {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public OaTask () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public OaTask (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public OaTask (
		java.lang.Long id,
		java.lang.String title) {

		super (
			id,
			title);
	}

/*[CONSTRUCTOR MARKER END]*/


}