package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseOaLeaveApply;
import com.justonetech.biz.utils.enums.OaLeaveApplyStatus;


public class OaLeaveApply extends BaseOaLeaveApply {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public OaLeaveApply () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public OaLeaveApply (java.lang.Long id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

    //获取状态的名称
    public String getStatusName() {
        return OaLeaveApplyStatus.getColorNameByCode(this.getStatus());
    }

}