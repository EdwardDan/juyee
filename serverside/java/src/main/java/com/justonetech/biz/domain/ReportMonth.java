package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseReportMonth;



public class ReportMonth extends BaseReportMonth {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ReportMonth () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ReportMonth (Long id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

    //报表时间
    public String getReportTime() {
        return this.getYear() + "年" + this.getMonth() + "月";
    }
}