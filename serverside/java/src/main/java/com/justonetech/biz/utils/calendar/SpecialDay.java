package com.justonetech.biz.utils.calendar;

import javax.xml.bind.annotation.*;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: wisewang
 * Date: 2009-6-1
 * Time: 14:46:13
 * SpecialDay定义特殊日期是否法定假日及对应的工作范围.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "SpecialDay")
public class SpecialDay implements Comparable {
    @XmlAttribute
    boolean isHoliday;
    @XmlAttribute
    Date theDay;
    @XmlElement
    TimeRange[] timeRanges;

    public SpecialDay() {
    }

    public SpecialDay(boolean holiday, Date theDay) {
        this.isHoliday = holiday;
        this.theDay = theDay;
    }

    public boolean getIsHoliday() {
        return isHoliday;
    }

    public void setHoliday(boolean holiday) {
        isHoliday = holiday;
    }

    public Date getTheDay() {
        return theDay;
    }

    public void setTheDay(Date theDay) {
        this.theDay = theDay;
    }

    public TimeRange[] getTimeRanges() {
        return timeRanges;
    }

    public void setTimeRanges(TimeRange[] timeRanges) {
        if (null != timeRanges)
            Arrays.sort(timeRanges);
        this.timeRanges = timeRanges;
    }

    public int compareTo(Object o) {
        SpecialDay tmp = (SpecialDay) o;
        if (null == tmp)
            return -1;
        else
            return this.theDay.compareTo(tmp.theDay);
    }
}
