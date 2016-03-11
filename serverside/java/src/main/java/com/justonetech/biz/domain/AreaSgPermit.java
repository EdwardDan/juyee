package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseAreaSgPermit;
import com.justonetech.biz.utils.enums.SgPermitStatus;


public class AreaSgPermit extends BaseAreaSgPermit {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public AreaSgPermit () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public AreaSgPermit (java.lang.Long id) {
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

	public String getStatusNameBJ() {
		String statusName = "办理中";
		if (this.getStatus() > SgPermitStatus.STATUS_EDIT.getCode()) {
			if (this.getStatus() == SgPermitStatus.STATUS_SLZX_BACK.getCode()) {
				statusName = "审核不通过";
			} else if (this.getStatus() == SgPermitStatus.STATUS_WLD_PASS.getCode()) {
				statusName = "审核通过";
			}
		} else {
			statusName = SgPermitStatus.STATUS_EDIT.getName();
		}

		return statusName;
	}


}
