package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseOaMeetingInner;

import java.text.SimpleDateFormat;


public class OaMeetingInner extends BaseOaMeetingInner
{
    private static final long serialVersionUID = 1L;

    /*[CONSTRUCTOR MARKER BEGIN]*/
    public OaMeetingInner()
    {
        super();
    }

    /**
     * Constructor for primary key
     */
    public OaMeetingInner(Long id)
    {
        super(id);
    }

/*[CONSTRUCTOR MARKER END]*/


    public String getMeetTime() {
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat sp2 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sp3 = new SimpleDateFormat("HH:mm");
        String end = sp.format(getEndTime());
        if (sp2.format(getBeginTime()).equals(sp2.format(getEndTime()))) {
            end =sp3.format(getEndTime());
        }
        return sp.format(getBeginTime()) + " ~ " + end;
    }


}