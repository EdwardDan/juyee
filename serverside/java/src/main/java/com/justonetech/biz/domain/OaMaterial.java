package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseOaMaterial;
import com.justonetech.biz.utils.enums.OaMaterialStatus;


public class OaMaterial extends BaseOaMaterial {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public OaMaterial () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public OaMaterial (java.lang.Long id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

    //获取状态的名称
    public String getStatusName() {
        return OaMaterialStatus.getColorNameByCode(this.getStatus());
    }

}