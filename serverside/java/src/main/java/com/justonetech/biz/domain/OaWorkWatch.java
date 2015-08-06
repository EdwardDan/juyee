package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseOaWorkWatch;
import com.justonetech.biz.utils.enums.OaWorkWatchStatus;


public class OaWorkWatch extends BaseOaWorkWatch {
    private static final long serialVersionUID = 1L;

    /*[CONSTRUCTOR MARKER BEGIN]*/
    public OaWorkWatch() {
        super();
    }

    /**
     * Constructor for primary key
     */
    public OaWorkWatch(Long id) {
        super(id);
    }

    public String getStatusName() {
        Integer status = getStatus();
        String statusName = "";
        if (null != status) {
            statusName = OaWorkWatchStatus.getColorNameByCode(status);
        }
        return statusName;
    }

/*[CONSTRUCTOR MARKER END]*/
}