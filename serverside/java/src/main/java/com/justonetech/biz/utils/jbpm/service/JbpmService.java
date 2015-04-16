package com.justonetech.biz.utils.jbpm.service;

import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.utils.jbpm.node.TaskNodeDefinition;
import org.jbpm.JbpmContext;
import org.jbpm.JbpmException;
import org.jbpm.db.GraphSession;
import org.jbpm.db.TaskMgmtSession;
import org.jbpm.graph.def.Node;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.def.Transition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.graph.exe.Token;
import org.jbpm.taskmgmt.def.Task;
import org.jbpm.taskmgmt.exe.PooledActor;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.jbpm.taskmgmt.exe.TaskMgmtInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springmodules.workflow.jbpm31.JbpmCallback;
import org.springmodules.workflow.jbpm31.support.JbpmDaoSupport;

import java.util.*;

/**
 * @version 1.0
 * @author: MaJi
 * @since: 2009-4-21
 */
public class JbpmService extends JbpmDaoSupport {

    private Logger logger = LoggerFactory.getLogger(JbpmService.class);

    private Object execute(final JbpmCallback callback) {
        return getTemplate().execute(callback);
    }

    public ProcessDefinition getProcessDefinition(final long processDefinitionId) {
        return (ProcessDefinition) execute(new JbpmCallback() {
            public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
                return jbpmContext.getGraphSession().loadProcessDefinition(processDefinitionId);
            }
        });
    }

    public void deployProcessDefinition(final ProcessDefinition processDefinition) {
        execute(new JbpmCallback() {
            public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
                jbpmContext.deployProcessDefinition(processDefinition);
                return null;
            }
        });
    }

    public ProcessInstance getProcessInstance(final long processInstanceId) {
        return (ProcessInstance) execute(new JbpmCallback() {
            public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
                return jbpmContext.loadProcessInstance(processInstanceId);
            }
        });
    }

    public void saveProcessInstance(ProcessInstance processInstance) {
        getTemplate().saveProcessInstance(processInstance);
    }

    public TaskInstance getTaskInstance(final long taskInstanceId) {
        return (TaskInstance) execute(new JbpmCallback() {
            public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
                return jbpmContext.getTaskInstance(taskInstanceId);
            }
        });
    }

    public void saveTaskInstance(final TaskInstance taskInstance) {
        execute(new JbpmCallback() {
            public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
                jbpmContext.save(taskInstance);
                return null;
            }
        });
    }

    public Task getTask(final long taskId) {
        return (Task) execute(new JbpmCallback() {
            public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
                return jbpmContext.getSession().load(Task.class, new Long(taskId));
            }
        });
    }

    public void setActId(final String actId) {
        execute(new JbpmCallback() {
            public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
                jbpmContext.setActorId(actId);
                return null;
            }
        });
    }

    public Node getNode(final long nodeId) {
        return (Node) execute(new JbpmCallback() {
            public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
                return jbpmContext.getSession().load(Node.class, new Long(nodeId));
            }
        });
    }

    public Transition getTransition(final long transitionId) {
        return (Transition) execute(new JbpmCallback() {
            public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
                return jbpmContext.getSession().load(Transition.class, new Long(transitionId));
            }
        });
    }

    public List findTaskInstance(final String actId) {
        return (List) execute(new JbpmCallback() {
            public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
                return jbpmContext.getTaskMgmtSession().findTaskInstances(actId);
            }
        });
    }

    public GraphSession getGraphSession() {
        return (GraphSession) execute(new JbpmCallback() {
            public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
                return jbpmContext.getGraphSession();
            }
        });
    }

    public void flush() {
        execute(new JbpmCallback() {
            public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
                jbpmContext.getSession().flush();
                return null;
            }
        });
    }

    public void clear() {
        execute(new JbpmCallback() {
            public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
                jbpmContext.getSession().clear();
                return null;
            }
        });
    }

    public void evict(final Object o) {
        execute(new JbpmCallback() {
            public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
                jbpmContext.getSession().evict(o);
                return null;
            }
        });
    }

    public void startJobExecutor() {
        execute(new JbpmCallback() {
            public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
                jbpmContext.getJbpmConfiguration().getJobExecutor().start();
                return null;
            }
        });
    }

    //=====================================================================================================
    public ProcessInstance startProcessInstance(final Long jbpmProcessDefinitionId, final String actorId) {
        return (ProcessInstance) execute(new JbpmCallback() {
            public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
                ProcessInstance processInstance = null;
                try {
                    GraphSession graphSession = jbpmContext.getGraphSession();
                    jbpmContext.setActorId(actorId);
                    ProcessDefinition processDefinition = graphSession.loadProcessDefinition(jbpmProcessDefinitionId);

                    // create a new process instance to run
                    processInstance = new ProcessInstance(processDefinition);
                    Task startTask = processInstance.getProcessDefinition().getTaskMgmtDefinition().getStartTask();
                    if (startTask != null) {
                        // create a new taskinstance for the start task
                        TaskInstance startTaskInstance = processInstance.getTaskMgmtInstance().createStartTaskInstance();
                        startTaskInstance.start();
                        //startTaskInstance.end();
                    } else {
                        processInstance.getContextInstance().setVariable("actorids", actorId);
//                        // jump to the first task-node
//                        processInstance.signal();
                    }
                    // Save the process instance along with the task instance
                    jbpmContext.save(processInstance);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return processInstance;
            }
        });
    }

    public List getUnfinishedTaskInstances(final String actor) {

        return (List) execute(new JbpmCallback() {
            public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
                TaskMgmtSession taskMgmtSession = jbpmContext.getTaskMgmtSession();

                List pustList = taskMgmtSession.findTaskInstances(actor);
                List pullList = new ArrayList();
                pullList = taskMgmtSession.findPooledTaskInstances(actor);
                //merge two list
                pustList.addAll(pullList);

                ArrayList taskInstanceList = new ArrayList();
                for (Object aPustList : pustList) {
                    TaskInstance taskInstance = (TaskInstance) aPustList;
                    if (!taskInstance.hasEnded())
                        taskInstanceList.add(taskInstance);
                }
                return taskInstanceList;
            }
        });
    }

    public List getUnfinishedTaskInstances(final long processInstanceId) throws Exception {
        return (List) execute(new JbpmCallback() {
            public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
                ProcessInstance processInstance = jbpmContext.loadProcessInstance(processInstanceId);
                Token rootToken = processInstance.getRootToken();
                Map map = rootToken.getActiveChildren();
                Set<String> keys = map.keySet();

                TaskMgmtInstance taskMgmtInstance = processInstance.getTaskMgmtInstance();
                Collection col = taskMgmtInstance.getUnfinishedTasks(processInstance.getRootToken());
                List list = new ArrayList();
                if (!col.isEmpty())
                    list.addAll(col);
                for (String key : keys) {
                    Token token = (Token) map.get(key);
                    Collection unfinishedTasks = taskMgmtInstance.getUnfinishedTasks(token);
                    list.addAll(unfinishedTasks);
                }
                return list;
            }
        });
    }

    public List<TaskInstance> getTaskInstance(Long jbpmProcessInstanceId, String actorId) throws Exception {
        List<TaskInstance> ret = new ArrayList<TaskInstance>();
        List<TaskInstance> taskInstances = getUnfinishedTaskInstances(jbpmProcessInstanceId);
        for (TaskInstance taskInstance : taskInstances) {
            String taskActorId = taskInstance.getActorId();
            if (!StringHelper.isEmpty(taskActorId)) {
                if (actorId.equals(taskActorId)) {
                    ret.add(taskInstance);
                }
            } else {
                Set<PooledActor> actors = taskInstance.getPooledActors();
                for (PooledActor actor : actors) {
                    taskActorId = actor.getActorId();
                    if (actorId.equals(taskActorId)) {
                        ret.add(taskInstance);
                        break;
                    }
                }
            }
        }
        return ret;
    }

    public void endTaskInstance(TaskInstance taskInstance, String taskType, String actorId, String transitionName) {
        //todo:为什么会lock,没有明白
        Token token = taskInstance.getToken();
        if (token.isLocked()) {
            token.unlock("token[" + token.getId() + "]");
        }

        if (TaskNodeDefinition.MULTI_EXCLUSIVE.equals(taskType)) {//多人排他
            taskInstance.setActorId(actorId);
            endByTransition(taskInstance, transitionName);
        } else if (TaskNodeDefinition.MULTI_SHARE.equals(taskType)) {//多人共享
            taskInstance.setActorId(actorId);
            endByTransition(taskInstance, transitionName);
        } else if (TaskNodeDefinition.MULTI_SYNC.equals(taskType)) {//多人会签
            taskInstance.setActorId(actorId);
            endByTransition(taskInstance, transitionName);
            TaskMgmtInstance taskMgmtInstance = taskInstance.getTaskMgmtInstance();
            Collection<TaskInstance> taskInstances = taskMgmtInstance.getUnfinishedTasks(taskInstance.getToken());
            if (taskInstances.size() == 0) {
                //disabled by chenjp at 20111019 由于后台在多人会签提交结束时报错：“couldn't signal token : token has ended”，故注释下面代码
//                taskInstance.getProcessInstance().signal();
            }
        } else {
            throw new RuntimeException("bad task node definition task type!");
        }
    }

    private void endByTransition(TaskInstance taskInstance, String transitionName) {
        if (transitionName == null) {
            taskInstance.end();
        } else {
            taskInstance.end(transitionName);
        }
    }


    public void sendMessage() {

    }

    public void forwardTaskInstance(long taskInstanceId, String actorId) {
        TaskInstance taskInstance = getTaskInstance(taskInstanceId);
        taskInstance.setActorId(actorId);
        saveTaskInstance(taskInstance);
//        flush();
    }

    public void setLock(TaskInstance taskInstance, String actorId) {
        taskInstance.setActorId(actorId);
        saveTaskInstance(taskInstance);
//        flush();
    }

    public void cancelLock(TaskInstance taskInstance) {
        //如果PooledActors为空则不能取消独占
        if (taskInstance.getPooledActors() != null) {
            taskInstance.setActorId(null);
            saveTaskInstance(taskInstance);
        }
//        flush();
    }

    public String[] getUnfinishedTaskInstanceActorIds(Long processInstanceId) throws Exception {
        List<TaskInstance> taskInstances = getUnfinishedTaskInstances(processInstanceId);
        List<String> actorIds = new ArrayList<String>();
        for (TaskInstance taskInstance : taskInstances) {
            actorIds.add(taskInstance.getActorId());
        }
        return actorIds.toArray(new String[actorIds.size()]);
    }

    public TaskInstance createTaskInstance(final TaskMgmtInstance taskMgmtInstance, final Task task, final Token token) {
        return (TaskInstance) execute(new JbpmCallback() {
            public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
                return taskMgmtInstance.createTaskInstance(task, token);
            }
        });
    }
}
