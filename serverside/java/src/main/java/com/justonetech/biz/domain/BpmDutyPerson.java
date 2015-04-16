package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseBpmDutyPerson;



public class BpmDutyPerson extends BaseBpmDutyPerson {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BpmDutyPerson () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BpmDutyPerson (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BpmDutyPerson (
		java.lang.Long id,
		com.justonetech.biz.domain.BpmProjectGroupDuty groupDuty,
		com.justonetech.system.domain.SysPerson person) {

		super (
			id,
			groupDuty,
			person);
	}

/*[CONSTRUCTOR MARKER END]*/


}