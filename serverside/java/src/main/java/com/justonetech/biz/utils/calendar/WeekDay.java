package com.justonetech.biz.utils.calendar;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: wisewang
 * Date: 2009-6-1
 * Time: 14:46:13
 * WeekDay 定义一周的工作日及工作日的工作时间
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "WeekDay")
public class WeekDay {
    @XmlAttribute
    boolean isWorkDay;
    @XmlElement
    TimeRange[] timeRanges;

    public WeekDay() {
    }

    public WeekDay(boolean workDay) {
        isWorkDay = workDay;
    }

    public boolean getIsWorkDay() {
        return isWorkDay;
    }

    public void setWorkDay(boolean workDay) {
        isWorkDay = workDay;
    }

    public TimeRange[] getTimeRanges() {
        return timeRanges;
    }

    public void setTimeRanges(TimeRange[] timeRanges) {
        if (null != timeRanges)
            Arrays.sort(timeRanges);
        this.timeRanges = timeRanges;
    }
}