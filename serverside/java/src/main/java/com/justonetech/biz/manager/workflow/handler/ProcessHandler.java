package com.justonetech.biz.manager.workflow.handler;

/**
 * 本接口为了实现在流程启动、更新、完成时需要自动调用一段程序的需求
 * 本接口的实现类的类名保存在流程定义表中
 * 实现类的相关方法在流程启动、更新、完成时被调用
 *
 * @version 1.0
 * @author: Ma Ji
 * @since: 2009-10-15
 */
public interface ProcessHandler {
    public void onCreate(Object bizObject);

    public void onUpdate(Object bizObject);

    public void onFinish(Object bizObject);
}
