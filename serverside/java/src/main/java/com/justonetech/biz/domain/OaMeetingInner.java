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


    public String getMeetTime()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String meetTime = "";
        if (getBeginTime() != null)
        {
            meetTime = formatter.format(getBeginTime());
        }
        if (getEndTime() != null)
        {
            meetTime += "~" + formatter.format(getEndTime());
        }
        return meetTime;

    }

}