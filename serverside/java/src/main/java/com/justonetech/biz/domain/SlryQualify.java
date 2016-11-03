package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseSlryQualify;
import com.justonetech.biz.utils.enums.SlryQualifyStatus;


public class SlryQualify extends BaseSlryQualify {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public SlryQualify () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public SlryQualify (Long id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

	public String getStatusName()
	{
		return SlryQualifyStatus.getColorNameByCode(getStatus());
	}


}