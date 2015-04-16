package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseWorkerSchoolActivity;



public class WorkerSchoolActivity extends BaseWorkerSchoolActivity {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public WorkerSchoolActivity () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public WorkerSchoolActivity (Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public WorkerSchoolActivity (
		Long id,
		com.justonetech.biz.domain.WorkerSchool school) {

		super (
			id,
			school);
	}

/*[CONSTRUCTOR MARKER END]*/


}