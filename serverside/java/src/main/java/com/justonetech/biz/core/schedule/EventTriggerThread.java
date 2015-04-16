package com.justonetech.biz.core.schedule;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * User: juyee
 * Date: 12-9-17
 * Time: 下午2:58
 * To change this template use File | Settings | File Templates.
 */
public class EventTriggerThread<E> extends Thread {

    private Logger logger = LoggerFactory.getLogger(EventTriggerThread.class);

    final Vector<E> vector = new Vector<E>();

    private boolean isRun = true;

    private Scheduler scheduler;

    private JobDetail jobDetail;

    public EventTriggerThread() {
    }

    public void init() {
        logger.debug("启动线程！");
        this.start();
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void setJobDetail(JobDetail jobDetail) {
        this.jobDetail = jobDetail;
    }

    public void setRun(boolean run) {
        isRun = run;
    }

    public void putObject(E e) {
        if (isRun) {
            synchronized (this.vector) {
                this.vector.add(e);
                this.vector.notify();
            }
            logger.debug("添加元素完毕！");
        } else {
            logger.warn("线程已结束！");
        }
    }

    public Vector<E> getVector() {
        return vector;
    }

    public void run() {
        while (isRun) {
            synchronized (this.vector) {
                while (vector.isEmpty() && isRun) {
                    try {
                        logger.debug("队列为空，进入等待！");
                        this.vector.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                logger.debug("vector.size() = " + vector.size());
                logger.debug("执行任务！vector.clear();");
                vector.clear();
                scheduler.triggerJob(jobDetail.getName(), jobDetail.getGroup());
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }
        this.vector.clear();
        logger.debug("线程执行结束！");
    }

    public void close() {
        this.isRun = false;
        logger.debug("结束线程！");
    }
}
