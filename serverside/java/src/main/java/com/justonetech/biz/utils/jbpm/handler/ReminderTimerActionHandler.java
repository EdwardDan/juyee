package com.justonetech.biz.utils.jbpm.handler;

import com.justonetech.core.utils.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jbpm.graph.def.ActionHandler;
import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.job.Timer;
import org.jbpm.taskmgmt.exe.PooledActor;
import org.jbpm.taskmgmt.exe.TaskInstance;

import java.util.Set;

/**
 * @version 1.0
 * @author: MaJi
 * @since: 2009-5-5
 */
public class ReminderTimerActionHandler implements ActionHandler {
    public void execute(ExecutionContext executionContext) throws Exception {
        Timer timer = executionContext.getTimer();
        log.debug("timer " + timer.getName() + " is running ! DueDate:" + timer.getDueDate());

        //为task instance的actors发送提醒消息
        TaskInstance taskInstance = timer.getTaskInstance();
        String actorId = taskInstance.getActorId();
        if (!StringHelper.isEmpty(actorId)) {//
            //todo:发送提醒消息
            System.out.println("actorId = " + actorId);
        } else {
            Set<PooledActor> actors = taskInstance.getPooledActors();
            for (PooledActor actor : actors) {
                long actId = actor.getId();
                //todo:发送提醒消息
                System.out.println("actId = " + actId);
            }
        }
    }

    private static final Log log = LogFactory.getLog(ReminderTimerActionHandler.class);
}
