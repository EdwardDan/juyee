package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseJdInform;
import com.justonetech.biz.utils.enums.JdInformStatus;


public class JdInform extends BaseJdInform {
    private static final long serialVersionUID = 1L;

    /*[CONSTRUCTOR MARKER BEGIN]*/
    public JdInform() {
        super();
    }

    /**
     * Constructor for primary key
     */
    public JdInform(Long id) {
        super(id);
    }

/*[CONSTRUCTOR MARKER END]*/

    //获取状态的名称
    public String getStatusName() {
        return JdInformStatus.getColorNameByCode(this.getStatus());
    }
}