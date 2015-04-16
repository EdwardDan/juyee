package com.justonetech.system.domain;

import com.justonetech.system.domain.base.BaseSysDeptUser;



public class SysDeptUser extends BaseSysDeptUser {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public SysDeptUser () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public SysDeptUser (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public SysDeptUser (
		java.lang.Long id,
		com.justonetech.system.domain.SysDept dept,
		com.justonetech.system.domain.SysUser user) {

		super (
			id,
			dept,
			user);
	}

/*[CONSTRUCTOR MARKER END]*/


}