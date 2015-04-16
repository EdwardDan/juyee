package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseJdCysb;
import com.justonetech.biz.utils.enums.JdCysbStatus;


public class JdCysb extends BaseJdCysb {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public JdCysb () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public JdCysb (Long id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/
//获取状态的名称
public String getStatusName() {
    return JdCysbStatus.getColorNameByCode(this.getStatus());
}

}