package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BasePadVersionInfo;


public class PadVersionInfo extends BasePadVersionInfo {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PadVersionInfo () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PadVersionInfo (Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public PadVersionInfo (
		Long id,
		String versionCode) {

		super (
			id,
			versionCode);
	}

/*[CONSTRUCTOR MARKER END]*/


}