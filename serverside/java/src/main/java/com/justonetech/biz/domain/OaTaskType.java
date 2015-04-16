package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseOaTaskType;



public class OaTaskType extends BaseOaTaskType {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public OaTaskType () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public OaTaskType (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public OaTaskType (
		java.lang.Long id,
		java.lang.String name) {

		super (
			id,
			name);
	}

/*[CONSTRUCTOR MARKER END]*/


}