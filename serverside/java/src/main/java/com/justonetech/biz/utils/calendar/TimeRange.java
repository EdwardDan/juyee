package com.justonetech.biz.utils.calendar;

import javax.xml.bind.annotation.*;
import java.sql.Time;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: wisewang
 * Date: 2009-6-1
 * Time: 14:40:01
 * To change this template use File | Settings | File Templates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "TimeRange")
public class TimeRange implements Comparable {
//    Time startTime;
//    Time endTime;
    @XmlAttribute
    String start;
    @XmlAttribute
    String end;

//    public Time getStartTime() {
//        return startTime;
//    }
//
//    public void setStartTime(Time startTime) {
//        this.startTime = startTime;
//    }
//
//    public Time getEndTime() {
//        return endTime;
//    }
//
//    public void setEndTime(Time endTime) {
//        this.endTime = endTime;
//    }

    public Time getStartTime() {
        return Time.valueOf(start);
    }

    public void setStartTime(Time startTime) {
        this.start = String.valueOf(startTime);
    }

    public Time getEndTime() {
        return Time.valueOf(end);
     }

    public void setEndTime(Time endTime) {
        this.end = String.valueOf(endTime);
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
        this.setStartTime(Time.valueOf(this.start));
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
        this.setEndTime(Time.valueOf(this.end));
    }

    public boolean isInRange(Date date) {
        int hours = date.getHours();
        int minutes = date.getMinutes();
        int seconds = date.getSeconds();

        Time time = new Time(hours, minutes, seconds);

        return (getStartTime().getTime() <= time.getTime() && time.getTime() <= getEndTime().getTime());
    }

    @Override
    public String toString() {
        return "[" + getStartTime() + "," + getEndTime() + "]";    //To change body of overridden methods use File | Settings | File Templates.
    }

    public int compareTo(Object o) {
        TimeRange tmp = (TimeRange) o;
        if (null == tmp)
            return -1;
        else
            return this.getStartTime().compareTo(tmp.getStartTime());
    }
}
