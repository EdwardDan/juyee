package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseSafeProductCheck;



public class SafeProductCheck extends BaseSafeProductCheck {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public SafeProductCheck () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public SafeProductCheck (Long id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

    //考核季度
    public String getExamQuarter() {
        if (null == this.getQuarter()) {
            return this.getYear() + "年";
        } else {
            return this.getYear() + "年第" + this.getQuarter() + "季度";
        }
    }

    //状态名称
    public String getStatusName() {

        return "";
    }
}