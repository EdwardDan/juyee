package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseOaMeetingOuter;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.enums.OaMeetingStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;


public class OaMeetingOuter extends BaseOaMeetingOuter {
    private static final long serialVersionUID = 1L;


    /*[CONSTRUCTOR MARKER BEGIN]*/
    public OaMeetingOuter() {
        super();
    }

    /**
     * Constructor for primary key
     */
    public OaMeetingOuter(Long id) {
        super(id);
    }

/*[CONSTRUCTOR MARKER END]*/

    public String getStatusName() {
        return OaMeetingStatus.getColorNameByCode(getStatus());
    }

    public Integer getStatusCode() {
        return getStatus();
    }

    public String getMeetTime() {
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        SimpleDateFormat sp2 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sp3 = new SimpleDateFormat("hh:mm");
        String end = sp.format(getEndTime());
        if (sp2.format(getBeginTime()).equals(sp2.format(getEndTime()))) {
            end =sp3.format(getEndTime());
        }
        return sp.format(getBeginTime()) + " ~ " + end;
    }

}