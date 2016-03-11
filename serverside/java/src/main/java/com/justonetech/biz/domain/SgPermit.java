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

	public String getStatusNameBJ() {
		String statusName = "办理中";
		if (this.getStatus() == SgPermitStatus.STATUS_JGZX_YS_PASS.getCode()) {
			statusName = "预审通过";
		} else if (this.getStatus() == SgPermitStatus.STATUS_SLZX_PASS.getCode()) {
			statusName = "收件通过";
		} else if (this.getStatus() == SgPermitStatus.STATUS_SH_PASS.getCode()) {
			statusName = "受理通过";
		} else if (this.getStatus() == SgPermitStatus.STATUS_WLD_PASS.getCode()) {
			statusName = "审批通过";
		} else if (this.getStatus() == SgPermitStatus.STATUS_JGZX_YS_BACK.getCode() || this.getStatus() == SgPermitStatus.STATUS_SLZX_BACK.getCode()) {
			statusName = "审核不通过";
		} else if (this.getStatus() == SgPermitStatus.STATUS_EDIT.getCode()) {
			statusName = SgPermitStatus.STATUS_EDIT.getName();
		}
//		if (this.getStatus() > SgPermitStatus.STATUS_EDIT.getCode()) {
//			if (this.getStatus() == SgPermitStatus.STATUS_SLZX_BACK.getCode()) {
//				statusName = "审核不通过";
//			} else if (this.getStatus() == SgPermitStatus.STATUS_WLD_PASS.getCode()) {
//				statusName = "审批通过";
//			}
//		} else {
//			statusName = SgPermitStatus.STATUS_EDIT.getName();
//		}

		return statusName;
	}
}
