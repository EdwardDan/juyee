package com.justonetech.biz.core.schedule;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * User: juyee
 * Date: 12-9-13
 * Time: 上午11:39
 * To change this template use File | Settings | File Templates.
 */
public class ScheduleManager {

    public static final String LAST_JOB_TRIGGER_TIME = "lastTriggerJobTime";

    private Trigger maxFreqTrigger;

    private Trigger minFreqTrigger;

    private Scheduler scheduler;

    private ChangeFreqJobListener changeFreqJobListener;

    public ScheduleManager() {
    }

    public ScheduleManager(Trigger maxFreqTrigger, Trigger minFreqTrigger, Scheduler scheduler, ChangeFreqJobListener changeFreqJobListener) {
        this.maxFreqTrigger = maxFreqTrigger;
        this.minFreqTrigger = minFreqTrigger;
        this.scheduler = scheduler;
        this.changeFreqJobListener = changeFreqJobListener;
    }

    public void setMaxFreqTrigger(Trigger maxFreqTrigger) {
        this.maxFreqTrigger = maxFreqTrigger;
    }

    public void setMinFreqTrigger(Trigger minFreqTrigger) {
        this.minFreqTrigger = minFreqTrigger;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void setChangeFreqJobListener(ChangeFreqJobListener changeFreqJobListener) {
        this.changeFreqJobListener = changeFreqJobListener;
    }

    /**
     * 主动触发时切换到高频率的扫描
     */
    private void changeToMaxFreqTrigger() {
        try {
            if (scheduler.getTrigger(maxFreqTrigger.getName(), maxFreqTrigger.getGroup()) == null
                    && scheduler.getTrigger(minFreqTrigger.getName(), minFreqTrigger.getGroup()) != null) {
                scheduler.rescheduleJob(minFreqTrigger.getName(), minFreqTrigger.getGroup(), maxFreqTrigger);
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 当webservice等调用时进行触发
     */
    public void triggerJob() {
        changeFreqJobListener.getListenData().put(LAST_JOB_TRIGGER_TIME, System.currentTimeMillis());
        changeToMaxFreqTrigger();
    }

    /**
     * 主动触发时切换到低频率的扫描
     */
    private void changeToMinFreqTrigger() {
        try {
            if (scheduler.getTrigger(minFreqTrigger.getName(), minFreqTrigger.getGroup()) == null
                    && scheduler.getTrigger(maxFreqTrigger.getName(), maxFreqTrigger.getGroup()) != null) {
                scheduler.rescheduleJob(maxFreqTrigger.getName(), maxFreqTrigger.getGroup(), minFreqTrigger);
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
