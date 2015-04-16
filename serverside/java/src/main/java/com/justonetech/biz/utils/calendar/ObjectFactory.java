package com.justonetech.biz.utils.calendar;

import javax.xml.bind.annotation.XmlRegistry;


@XmlRegistry
public class ObjectFactory {

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.justonetech.ipromis.core.jbpm.task
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SpecialDay }
     */
    public SpecialDay createSpecialDay() {
        return new SpecialDay();
    }

    /**
     * Create an instance of {@link TimeRange }
     */
    public TimeRange createTimeRange() {
        return new TimeRange();
    }

//        /**
//     * Create an instance of {@link Time }
//     */
//    public Time createTime() {
//        return Time.valueOf("00:00:00");
//    }

    /**
     * Create an instance of {@link WorkCalendar }
     */
    public WorkCalendar createWorkCalendar() {
        return new WorkCalendar();
    }

    /**
     * Create an instance of {@link WeekDay }
     */
    public WeekDay createWeekDay() {
        return new WeekDay();
    }

}