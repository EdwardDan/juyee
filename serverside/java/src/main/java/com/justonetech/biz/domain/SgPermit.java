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
        return "沪交管收字" + this.getHjgYear() + "第" + this.getHjgNum() + "号";
    }

    public String getStatusName() {
        return SgPermitStatus.getColorNameByCode(this.getStatus());
    }
}