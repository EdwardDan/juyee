package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseOaThingsApply;
import com.justonetech.biz.utils.enums.OaThingsApplyStatus;


public class OaThingsApply extends BaseOaThingsApply {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public OaThingsApply () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public OaThingsApply (Long id) {
		super(id);
	}
    //获取状态的名称
    public String getStatusName() {
        return OaThingsApplyStatus.getColorNameByCode(this.getStatus());
    }

/*[CONSTRUCTOR MARKER END]*/


}