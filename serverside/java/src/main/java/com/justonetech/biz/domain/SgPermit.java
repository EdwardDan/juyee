package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseSgPermit;
import com.justonetech.biz.utils.enums.SgPermitStatus;


public class SgPermit extends BaseSgPermit {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public SgPermit () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public SgPermit (Long id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/


	public String getZh() {
		String year = "";
		String num = "";
		if (null != this.getHjgYear()) {
			year = this.getHjgYear() + "";
		}
		if (null != this.getHjgNum()) {
			num = this.getHjgNum() + "";
		}
		return "沪交管收字" + year + "第" + num + "号";
	}

    public String getStatusName() {
        return SgPermitStatus.getColorNameByCode(this.getStatus());
    }
}