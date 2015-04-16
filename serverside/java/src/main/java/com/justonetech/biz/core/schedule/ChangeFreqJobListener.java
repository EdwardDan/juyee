/* 
 * Copyright 2005 - 2009 Terracotta, Inc. 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not 
 * use this file except in compliance with the License. You may obtain a copy 
 * of the License at 
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the 
 * License for the specific language governing permissions and limitations 
 * under the License.
 * 
 */

package com.justonetech.biz.core.schedule;


import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wkratzer
 *         <p/>
 *         <p/>
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class ChangeFreqJobListener implements JobListener {

    private static Logger _log = LoggerFactory.getLogger(ChangeFreqJobListener.class);

    private Trigger maxFreqTrigger;

    private Trigger minFreqTrigger;

    private long delayMillisChange;

    private Map listenData = new HashMap();

    private String name;

    public ChangeFreqJobListener() {
    }

    public ChangeFreqJobListener(Trigger maxFreqTrigger, Trigger minFreqTrigger, long delayMillisChange, String name) {
        this.maxFreqTrigger = maxFreqTrigger;
        this.minFreqTrigger = minFreqTrigger;
        this.delayMillisChange = delayMillisChange;
        this.name = name;
    }

    public void setMaxFreqTrigger(Trigger maxFreqTrigger) {
        this.maxFreqTrigger = maxFreqTrigger;
    }

    public void setMinFreqTrigger(Trigger minFreqTrigger) {
        this.minFreqTrigger = minFreqTrigger;
    }

    public void setDelayMillisChange(long delayMillisChange) {
        this.delayMillisChange = delayMillisChange;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Map getListenData() {
        return listenData;
    }

    public void jobToBeExecuted(JobExecutionContext inContext) {
//        _log.info("Job1Listener says: Job Is about to be executed.");
    }

    public void jobExecutionVetoed(JobExecutionContext inContext) {
//        _log.info("Job1Listener says: Job Execution was vetoed.");
    }

    public void jobWasExecuted(JobExecutionContext inContext,
                               JobExecutionException inException) {

        Object lastJobTriggerTime = this.listenData.get(ScheduleManager.LAST_JOB_TRIGGER_TIME);

        Scheduler scheduler = inContext.getScheduler();
        if (lastJobTriggerTime != null) {
            //延迟多少秒后切换触发器
            if (System.currentTimeMillis() - (Long) lastJobTriggerTime > delayMillisChange) {
                try {
                    if (scheduler.getTrigger(maxFreqTrigger.getName(), maxFreqTrigger.getGroup()) != null) {
                        inContext.getScheduler().rescheduleJob(maxFreqTrigger.getName(), maxFreqTrigger.getGroup(), minFreqTrigger);
                    }
                } catch (SchedulerException e) {
                    e.printStackTrace();
                }
            }
        }
        _log.info("ChangeFreqJobListener says: Job was executed.");
    }

}
