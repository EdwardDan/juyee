package com.justonetech.biz.utils.jbpm.handler;

import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.domain.BpmNodeDefinition;
import com.justonetech.biz.manager.workflow.ProcessDataManager;
import com.justonetech.biz.utils.jbpm.node.TaskNodeDefinition;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jbpm.graph.def.ActionHandler;
import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.graph.node.TaskNode;
import org.jbpm.job.Timer;
import org.jbpm.taskmgmt.exe.PooledActor;
import org.jbpm.taskmgmt.exe.TaskInstance;

import java.util.Set;

/**
 * @version 1.0
 * @author: MaJi
 * @since: 2009-5-5
 */
public class DeadlineTimerActionHandler implements ActionHandler {

    public void execute(ExecutionContext executionContext) throws Exception {
        Timer timer = executionContext.getTimer();
        log.debug("timer " + timer.getName() + " is running ! DueDate:" + timer.getDueDate());
        TaskInstance taskInstance = timer.getTaskInstance();
        String actorId = taskInstance.getActorId();

        //得到过期动作
        TaskNode node = (TaskNode) executionContext.getNode();
        BpmNodeDefinition bpmNodeDefinition = ProcessDataManager.getBpmNodeDefinition(node);
        TaskNodeDefinition taskNodeDefinition = ProcessDataManager.getTaskNodeDefinition(bpmNodeDefinition);
        String timeOutAction = taskNodeDefinition.getTimeOutAction();

        //先发过期消息，再执行过期动作
        if (!StringHelper.isEmpty(actorId)) {//
            //todo:发送过期消息
            System.out.println("actorId = " + actorId);
        } else {
            Set<PooledActor> actors = taskInstance.getPooledActors();
            for (PooledActor actor : actors) {
                long actId = actor.getId();
                //todo:发送过期消息
                System.out.println("actId = " + actId);
            }
        }

        //执行过期动作
        if (TaskNodeDefinition.ACTION_CONTINUE.equals(timeOutAction)) {
            timer.setTransitionName(taskNodeDefinition.getDefaultTransitionName());
            taskInstance.end();
        } else if (TaskNodeDefinition.ACTION_PAUSE.equals(timeOutAction)) {
            //暂停时执行的动作
        }
    }

    private static final Log log = LogFactory.getLog(DeadlineTimerActionHandler.class);
}