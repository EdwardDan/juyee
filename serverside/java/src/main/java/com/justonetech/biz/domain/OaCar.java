package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseOaCar;
import com.justonetech.biz.utils.enums.OaCarStatus;


public class OaCar extends BaseOaCar {
    private static final long serialVersionUID = 1L;

    /*[CONSTRUCTOR MARKER BEGIN]*/
    public OaCar() {
        super();
    }

    /**
     * Constructor for primary key
     */
    public OaCar(Long id) {
        super(id);
    }

/*[CONSTRUCTOR MARKER END]*/

    public String getStatu() {
        return getStatus() != null ? OaCarStatus.getColorNameByCode(getStatus()) : "";
    }

    //获取填报人姓名
    public String getApplyUserName() {
        return this.getApplyUser().getDisplayName();
    }
}