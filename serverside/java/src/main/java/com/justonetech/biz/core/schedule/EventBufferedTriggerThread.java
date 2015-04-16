package com.justonetech.biz.core.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: wangyang
 * Date: 12-9-17
 * Time: 下午9:57
 * To change this template use File | Settings | File Templates.
 */
public class EventBufferedTriggerThread<E> extends Thread {

    private Logger logger = LoggerFactory.getLogger(EventBufferedTriggerThread.class);

    final Vector<E> events = new Vector<E>();

    private Object targetObject;
    private String targetMethod;

    private boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public EventBufferedTriggerThread() {
    }

    public Object getTargetObject() {
        return targetObject;
    }

    public void setTargetObject(Object targetObject) {
        this.targetObject = targetObject;
    }

    public String getTargetMethod() {
        return targetMethod;
    }

    public void setTargetMethod(String targetMethod) {
        this.targetMethod = targetMethod;
    }

    public void init() {
        logger.debug("启动线程！");
        this.start();
    }

    public void fireEvent(E e) {
        if (isRunning) {
            synchronized (this.events) {
                this.events.add(e);
                this.events.notifyAll();
            }
            logger.debug("添加event完毕！");
        } else {
            logger.warn("线程已结束！");
        }
    }

    public void fireEvent() {
        fireEvent(null);
    }

    public void run() {
        Method method = null;
        try {
            //get the method with no params
            method = targetObject.getClass().getMethod(targetMethod);
        } catch (NoSuchMethodException e) {
            logger.warn(String.format("no such method " + targetMethod + " for class " + targetObject.getClass().getName()));
        }

        while (isRunning) {
            synchronized (this.events) {
                while (events.isEmpty() && isRunning) {
                    try {
                        logger.debug("队列为空，进入等待！");
                        this.events.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (isRunning) {
                try {
                    logger.debug("events.size() = " + events.size());
                    logger.debug(this.targetMethod + ":执行任务！events.clear();");
                    events.clear();
//                scheduler.triggerJob(jobDetail.getName(), jobDetail.getGroup());
                    if (method != null) {
                        //call the method with no params
                        method.invoke(targetObject);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        events.clear();
        logger.debug("线程执行结束！");
    }

    public void close() {
        this.isRunning = false;
        synchronized (this.events) {
            this.events.notifyAll();
        }

        logger.debug("结束线程...");
    }
}
