package com.justonetech.biz.utils.jbpm.db;

import com.justonetech.core.utils.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jbpm.graph.def.ActionHandler;
import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.job.Timer;
import org.jbpm.taskmgmt.exe.PooledActor;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TimerActionHandler implements ActionHandler {

    public void execute(ExecutionContext executionContext) throws Exception {
        Timer timer = executionContext.getTimer();
        log.debug("timer " + timer.getName() + " is running ! DueDate:" + timer.getDueDate());
        TaskInstance taskInstance = timer.getTaskInstance();
        String actorId = taskInstance.getActorId();
        if (StringHelper.isEmpty(actorId)) {//
            System.out.println("actorId = " + actorId);
        } else {
            Set<PooledActor> actors = taskInstance.getPooledActors();
            for (PooledActor actor : actors) {
                long actId = actor.getId();
                System.out.println("actId = " + actId);
            }
        }
    }
    private static final Log log = LogFactory.getLog(TimerActionHandler.class);
}