package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseOaMeeting;
import com.justonetech.biz.utils.enums.OaInnerMeetingStatus;


public class OaMeeting extends BaseOaMeeting {
    private static final long serialVersionUID = 1L;

    /*[CONSTRUCTOR MARKER BEGIN]*/
    public OaMeeting() {
        super();
    }

    /**
     * Constructor for primary key
     */
    public OaMeeting(Long id) {
        super(id);
    }

    /*[CONSTRUCTOR MARKER END]*/
    public String getStatusName() {
        return OaInnerMeetingStatus.getColorNameByCode(this.getStatus());

    }
}