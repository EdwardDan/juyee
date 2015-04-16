package com.justonetech.biz.utils.calendar;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.sql.Time;

public class TimeAdapter extends XmlAdapter<String, Time> {
    public Time unmarshal(String val) throws Exception {
        return Time.valueOf(val);
    }
    public String marshal(Time val) throws Exception {
        return val.toString();
    }
}
