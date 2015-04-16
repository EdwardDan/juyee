package com.justonetech.biz.utils.jbpm.handler;

import com.justonetech.biz.domain.BpmNodeDefinition;
import com.justonetech.biz.manager.workflow.ProcessDataManager;
import com.justonetech.biz.utils.jbpm.node.TaskNodeDefinition;
import org.jbpm.graph.def.ActionHandler;
import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.graph.node.TaskNode;
import org.jbpm.taskmgmt.def.Task;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.jbpm.taskmgmt.exe.TaskMgmtInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class NodeEnterActionHandler implements ActionHandler {
    public void execute(ExecutionContext executionContext) throws Exception {
        //there are two tasks:task assignment and create task instance.
        //1. get the task node uniqueid
        //2. get the definition of the task node by unique id from database:swimlane and actions
        //3. calc the actors for swimlane * skillful
        //3.1 filter positions by user grouptype and positiontype
        //3.2 filter members by extend attribute
        //4. create the taskinstance by task type, task type is defined in database
        //5. assign taskinstance with actors
        //6. set task other attribute such as warning and due date


        log.debug("current thread id is " + Thread.currentThread().getId() + " and name is " + Thread.currentThread().getName());
        //得到当前Jbpm Node名称
        TaskMgmtInstance taskMgmtInstance = executionContext.getTaskMgmtInstance();
        TaskNode node = (TaskNode) executionContext.getNode();
        log.debug("node = " + node.getName());

        BpmNodeDefinition bpmNodeDefinition = ProcessDataManager.getBpmNodeDefinition(node);
        TaskNodeDefinition taskNodeDefinition = ProcessDataManager.getTaskNodeDefinition(bpmNodeDefinition);
        String[] userIds = getUserIds(executionContext, node, bpmNodeDefinition);

        //得到当前步骤的所有JbpmTaskInstance，用于删除无效的系统任务列表
        List<TaskInstance> list = new ArrayList<TaskInstance>();

        Set<Task> tasks = node.getTasks();
        //对每个任务操作，根据任务类型创建任务
        //如果任务为会签模式则根据人员数创建task,否则只创建一个task分配给每个人
        for (Task task : tasks) {
            String taskType = taskNodeDefinition.getTaskCreateType();
            log.info("taskName is:" + task.getName() + ", task type is:" + taskType);
            if (TaskNodeDefinition.MULTI_EXCLUSIVE.equals(taskType)) {//多人排他
                //分配任务
//                TaskInstance taskInstance = taskMgmtInstance.createTaskInstance(task, executionContext.getToken());
                TaskInstance taskInstance = ProcessDataManager.createTaskInstance(taskMgmtInstance, task, executionContext.getToken());
                if (userIds.length == 1) {
                    taskInstance.setActorId(userIds[0]);
                } else {
                    taskInstance.setPooledActors(userIds);
                }
                ProcessDataManager.saveBpmTaskInstance(taskInstance, bpmNodeDefinition, userIds);
                list.add(taskInstance);

            } else if (TaskNodeDefinition.MULTI_SHARE.equals(taskType)) {//多人共享
                //分配任务
                TaskInstance taskInstance = taskMgmtInstance.createTaskInstance(task, executionContext.getToken());
                taskInstance.setPooledActors(userIds);
                ProcessDataManager.saveBpmTaskInstance(taskInstance, bpmNodeDefinition, userIds);
                list.add(taskInstance);

            } else if (TaskNodeDefinition.MULTI_SYNC.equals(taskType)) {//多人会签
                for (String userId : userIds) {
                    TaskInstance taskInstance = taskMgmtInstance.createTaskInstance(task, executionContext.getToken());
                    taskInstance.setActorId(userId);
                    ProcessDataManager.saveBpmTaskInstance(taskInstance, bpmNodeDefinition, new String[]{userId});
                    list.add(taskInstance);
                }
            } else {
                throw new RuntimeException("bad task node definition task type!");
            }
        }

        //移除非当前的系统任务
        ProcessDataManager.removeOtherSysTask(list);
    }

    private String[] getUserIds(ExecutionContext executionContext, TaskNode node, BpmNodeDefinition bpmNodeDefinition) throws Exception {
        //userIds从流程实例上下文中取变量，如存在userIds变量，则认为是预设的人员
        String[] userIds = (String[]) executionContext.getVariable(node.getName());
        if (userIds != null) {
            log.info("get user ids from executionContext! userIds:" + Arrays.toString(userIds));
            //流程实例上下文的变量为一次性的变量，用完设置为空，不对下一节点造成影响
            executionContext.setVariable(node.getName(), null);
        } else {
            ProcessInstance processInstance = executionContext.getProcessInstance();

            userIds = ProcessDataManager.getLastTimeUserIds(processInstance, bpmNodeDefinition);
            log.info("get last time user ids is :" + Arrays.toString(userIds));

            if (userIds == null) {
                //从数据库中取出任务的泳道
                userIds = ProcessDataManager.getUserIds(bpmNodeDefinition, processInstance);
                log.info("get user ids from swimlane! userIds:" + Arrays.toString(userIds));
            }
        }
        return userIds;
    }

    private Logger log = LoggerFactory.getLogger(NodeEnterActionHandler.class);
}