package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseOaTaskLog;



public class OaTaskLog extends BaseOaTaskLog {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public OaTaskLog () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public OaTaskLog (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public OaTaskLog (
		java.lang.Long id,
		java.lang.String title) {

		super (
			id,
			title);
	}

/*[CONSTRUCTOR MARKER END]*/


}