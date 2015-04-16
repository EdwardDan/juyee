package com.justonetech.biz.utils.calendar;

import javax.xml.bind.annotation.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: wisewang
 * Date: 2009-6-1
 * Time: 14:44:19
 * .
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "WorkCalendar")
public class WorkCalendar {
    //from sunday
    @XmlElement
    WeekDay[] defaultWorkDaysInWeek = new WeekDay[]{new WeekDay(false), new WeekDay(true), new WeekDay(true), new WeekDay(true), new WeekDay(true), new WeekDay(true), new WeekDay(false)};
    @XmlElement
    TimeRange[] defaultWorkTimeInDay;
    @XmlElement
    SpecialDay[] specialDays;
    private static final int ONE_DAY = 24 * 60 * 60 * 1000;

    public WeekDay[] getDefaultWorkDaysInWeek() {
        return defaultWorkDaysInWeek;
    }

    public void setDefaultWorkDaysInWeek(WeekDay[] defaultWorkDaysInWeek) {
        if (defaultWorkDaysInWeek != null) {
            boolean allTrue = true;
            for (WeekDay weekDay : defaultWorkDaysInWeek) {
                if (weekDay.isWorkDay) {
                    allTrue = false;
                    break;
                }
            }
            if (allTrue)
                throw new RuntimeException("can't set all days of a week to holiday!");

            for (WeekDay weekDay : defaultWorkDaysInWeek) {
                if (weekDay.isWorkDay && (weekDay.getTimeRanges() == null || weekDay.getTimeRanges().length == 0)) {
                    weekDay.setTimeRanges(defaultWorkTimeInDay);
                }
            }
        }
        this.defaultWorkDaysInWeek = defaultWorkDaysInWeek;
    }

    public TimeRange[] getDefaultWorkTimeInDay() {
        return defaultWorkTimeInDay;
    }

    public void setDefaultWorkTimeInDay(TimeRange[] defaultWorkTimeInDay) {
        if (null != defaultWorkTimeInDay)
            Arrays.sort(defaultWorkTimeInDay);
        this.defaultWorkTimeInDay = defaultWorkTimeInDay;
    }

    public SpecialDay[] getSpecialDays() {
        return specialDays;
    }

    public void setSpecialDays(SpecialDay[] specialDays) {
        if (specialDays != null)
            Arrays.sort(specialDays);
        this.specialDays = specialDays;
    }

    /**
     * @param date, 2009-6-1 16:46:33
     * @return 2006-6-1 0:0:0
     */
    public Date truncateDate(Date date) {
        int year = date.getYear();
        int month = date.getMonth();
        int day = date.getDate();
        return new Date(year, month, day);
    }

    public SpecialDay getSpecailDay(Date date) {
        Date mydate = truncateDate(date);
        for (SpecialDay specialDay : specialDays) {
            if (specialDay.getTheDay().equals(mydate))
                return specialDay;
        }

        //if not find the defined special day then
        //return a "special day" according to the week work time definition
        int day = mydate.getDay();
        SpecialDay specialDay = new SpecialDay();
        specialDay.setHoliday(!defaultWorkDaysInWeek[day].isWorkDay);
        specialDay.setTheDay(mydate);
        specialDay.setTimeRanges(defaultWorkDaysInWeek[day].getTimeRanges());
        return specialDay;
    }

    public boolean isWorkTime(Date date) {
        //step1. is Specail day?
        SpecialDay specialDay = getSpecailDay(date);
        //step2. is a Holiday, return false
        //step2.1. is a work day,continue
        if (specialDay.isHoliday)
            return false;
        else {
            //step 3. is not a special day, continue with default policy,get the weekday
            TimeRange[] ranges = defaultWorkTimeInDay;

            if (null != specialDay.getTimeRanges() && 0 < specialDay.getTimeRanges().length) {
                ranges = specialDay.getTimeRanges();
            }
            for (TimeRange timeRange : ranges) {
                if (timeRange.isInRange(date))
                    return true;
            }
            return false;
        }
    }

     public Timestamp getNearestWorkTime(Timestamp date) {
        if (isWorkTime(date))
            return date;
        else   //get the nearest worktime after the date
        {
            //search next day until successfully
            Date mydate = truncateDate(date);
            do {
                //next day
                mydate = new Date(mydate.getTime() + ONE_DAY);
                SpecialDay specialDay = getSpecailDay(mydate);

                if (!specialDay.isHoliday) {
                    //get the ranges
                    TimeRange[] ranges = defaultWorkTimeInDay;
                    if (null != specialDay.getTimeRanges() && 0 < specialDay.getTimeRanges().length)
                        ranges = specialDay.getTimeRanges();

                    TimeRange range = ranges[0];
                    Time startTime = range.getStartTime();
                    int hours = startTime.getHours();
                    int minutes = startTime.getMinutes();
                    int seconds = startTime.getSeconds();
                    return new Timestamp(mydate.getTime() + hours * 60 * 60 * 1000 + minutes * 60 * 1000 + seconds * 1000);
                }
            } while (true);
        }
    }

    
}
