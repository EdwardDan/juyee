package com.justonetech.biz.manager.workflow;

import com.justonetech.core.utils.StringHelper;
import com.justonetech.core.utils.XmlHelper;
import com.justonetech.biz.daoservice.BpmNodeDefinitionService;
import com.justonetech.biz.daoservice.BpmProcessInstanceService;
import com.justonetech.biz.daoservice.BpmTaskInstanceService;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.biz.manager.SwimlaneManager;
import com.justonetech.biz.utils.JaxbUtil;
import com.justonetech.biz.utils.jbpm.node.DecisionDefinition;
import com.justonetech.biz.utils.jbpm.node.TaskNodeDefinition;
import com.justonetech.biz.utils.jbpm.service.JbpmService;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.comparators.ComparableComparator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.DocumentException;
import org.htmlparser.util.ParserException;
import org.jbpm.graph.def.Node;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.graph.exe.Token;
import org.jbpm.taskmgmt.def.Task;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.jbpm.taskmgmt.exe.TaskMgmtInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.xml.bind.JAXBException;
import java.sql.Timestamp;
import java.util.*;

/**
 * 本类的方法为jBPM的handler准备，
 * jBPM的handler需要访问数据库，但又不能做为service以单例的形式存在
 *
 * @version 1.0
 * @author: Ma Ji
 * @since: 2009-5-8
 */
@Service
public class ProcessDataManager {
    private static final Log logger = LogFactory.getLog(ProcessDataManager.class);

    private static BpmNodeDefinitionService bpmNodeDefinitionService;
    private static BpmProcessInstanceService bpmProcessInstanceService;
    private static BpmTaskInstanceService bpmTaskInstanceService;
    private static BpmSwimlaneManager bpmSwimlaneManager;
    private static JbpmService jbpmService;
    private static BpmProcessFormDataManager bpmProcessFormDataManager;
    private static BpmProcessInstanceManager bpmProcessInstanceManager;
    private static SwimlaneManager swimlaneManager;
    private static OaTaskManager oaTaskManager;
    private static SysUserManager sysUserManager;

    @Autowired
    public void setBpmNodeDefinitionService(BpmNodeDefinitionService bpmNodeDefinitionService) {
        ProcessDataManager.bpmNodeDefinitionService = bpmNodeDefinitionService;
    }

    @Autowired
    public void setBpmProcessInstanceService(BpmProcessInstanceService bpmProcessInstanceService) {
        ProcessDataManager.bpmProcessInstanceService = bpmProcessInstanceService;
    }

    @Autowired
    public void setBpmTaskInstanceService(BpmTaskInstanceService bpmTaskInstanceService) {
        ProcessDataManager.bpmTaskInstanceService = bpmTaskInstanceService;
    }

    @Autowired
    public void setBpmSwimlaneManager(BpmSwimlaneManager bpmSwimlaneManager) {
        ProcessDataManager.bpmSwimlaneManager = bpmSwimlaneManager;
    }

    @Autowired
    public void setJbpmService(JbpmService jbpmService) {
        ProcessDataManager.jbpmService = jbpmService;
    }

    @Autowired
    public void setBpmProcessFormDataManager(BpmProcessFormDataManager bpmProcessFormDataManager) {
        ProcessDataManager.bpmProcessFormDataManager = bpmProcessFormDataManager;
    }

    @Autowired
    public void setBpmProcessInstanceManager(BpmProcessInstanceManager bpmProcessInstanceManager) {
        ProcessDataManager.bpmProcessInstanceManager = bpmProcessInstanceManager;
    }

    @Autowired
    public void setSwimlaneManager(SwimlaneManager swimlaneManager) {
        ProcessDataManager.swimlaneManager = swimlaneManager;
    }

    @Autowired
    public void setOaTaskManager(OaTaskManager oaTaskManager) {
        ProcessDataManager.oaTaskManager = oaTaskManager;
    }

    @Autowired
    public void setSysUserManager(SysUserManager sysUserManager) {
        ProcessDataManager.sysUserManager = sysUserManager;
    }

    /**
     * @param bpmNodeDefinition
     * @return
     * @throws javax.xml.bind.JAXBException
     */
    public static TaskNodeDefinition getTaskNodeDefinition(BpmNodeDefinition bpmNodeDefinition) throws JAXBException {
        String nodeDefinition = bpmNodeDefinition.getNodeDefinition();
        return JaxbUtil.unmarshall(TaskNodeDefinition.class, nodeDefinition);
    }

    public static DecisionDefinition getDecisionDefinition(BpmNodeDefinition bpmNodeDefinition) throws JAXBException {
        String nodeDefinition = bpmNodeDefinition.getNodeDefinition();
        return JaxbUtil.unmarshall(DecisionDefinition.class, nodeDefinition);
    }

    /**
     * @param node
     * @return
     */
    public static BpmNodeDefinition getBpmNodeDefinition(Node node) {
        String hql = "from BpmNodeDefinition t where t.jbpmNodeId = " + node.getId();
        return bpmNodeDefinitionService.findUnique(hql);
    }

    /**
     * @param bpmTaskInstance
     */
    public static void saveBpmTaskInstance(BpmTaskInstance bpmTaskInstance) {
        bpmTaskInstanceService.save(bpmTaskInstance);
    }

    /**
     * 保存task instance
     *
     * @param taskInstance
     */
    public static void saveTaskInstance(TaskInstance taskInstance) {
        jbpmService.saveTaskInstance(taskInstance);
        jbpmService.flush();
    }


    /**
     * 保存bpm task instance
     *
     * @param taskInstance
     * @param bpmNodeDefinition
     * @param userIds
     * @throws javax.script.ScriptException
     * @throws javax.xml.bind.JAXBException
     * @throws org.dom4j.DocumentException
     * @throws ParserException
     */
    public static void saveBpmTaskInstance(TaskInstance taskInstance, BpmNodeDefinition bpmNodeDefinition, String[] userIds) throws Exception, JAXBException, DocumentException, ParserException {
        ProcessDataManager.saveTaskInstance(taskInstance);

        BpmProcessInstance bpmProcessInstance = getBpmProcessInstance(taskInstance.getProcessInstance().getId());

        BpmTaskInstance bpmTaskInstance = new BpmTaskInstance();
        bpmTaskInstance.setStartTime(new Timestamp(System.currentTimeMillis()));
        bpmTaskInstance.setTaskDefinition(bpmNodeDefinition);
        bpmTaskInstance.setJbpmTaskInstanceId(taskInstance.getId());
        bpmTaskInstance.setProcessInstance(bpmProcessInstance);
        ProcessDataManager.saveBpmTaskInstance(bpmTaskInstance);
        bpmTaskInstanceService.flush();

        //如果是第一个节点则设置业务表数据
        bpmProcessFormDataManager.saveFormDataFromBizObject(bpmTaskInstance);

        //创建任务并发送任务通知（短信、系统消息）
//        if (userIds != null) {
        //第一个节点(开始节点)不发消息
//        System.out.println("begin create task ....");
        if (!bpmProcessInstanceManager.isTokenInFirstTaskNode(bpmProcessInstance)) {
//                bpmProcessSendMsgManager.sendJbpmMsg(bpmTaskInstance, userIds);
//            System.out.println("next task userIds = " + StringHelper.stringArrayToString(userIds, ","));
            createTask(bpmTaskInstance, userIds);
        }
//        }
    }

    //todo 必须移除之前创建的task
    public static void removeOtherSysTask(List<TaskInstance> list) {
        Long bpmProcessInstanceId = null;
        Set<Long> existIds = new HashSet<Long>();
        for (TaskInstance taskInstance : list) {
            if (taskInstance != null) {
                BpmTaskInstance bpmTaskInstance = bpmProcessInstanceManager.getBpmTaskInstance(taskInstance);
                if (bpmTaskInstance != null) {
                    if (bpmProcessInstanceId == null)
                        bpmProcessInstanceId = bpmTaskInstance.getProcessInstance().getId();

                    existIds.add(bpmTaskInstance.getId());
                }
            }
        }
        if (bpmProcessInstanceId != null) {
            List<BpmTaskInstance> bpmTaskInstanceList = bpmProcessInstanceManager.getBpmTaskInstanceList(bpmProcessInstanceId);
            for (BpmTaskInstance instance : bpmTaskInstanceList) {
                if (!existIds.contains(instance.getId())) {
                    System.out.println("remove sys task,referId is " + instance.getId());
                    oaTaskManager.removeTask(BpmTaskInstance.class.getSimpleName(), instance.getId());
                }
            }
        }
    }

    /**
     * 创建系统任务
     *
     * @param data    .
     * @param userIds .
     * @throws Exception .
     */
    private static void createTask(BpmTaskInstance data, String[] userIds) throws Exception {
//        if (userIds != null) {
        BpmProcessInstance processInstance = data.getProcessInstance();
        String code = processInstance.getCode();
        String title = processInstance.getTitle();
        String taskTitle = "";
        if (!StringHelper.isEmpty(code)) {
            taskTitle += "编号【" + code + "】";
        }
        if (!StringHelper.isEmpty(title)) {
            if (!"".equals(taskTitle)) taskTitle += "，";
            taskTitle += "标题【" + title + "】";
        }
        if (!"".equals(taskTitle)) {
            taskTitle += "的" + processInstance.getProcessDefinition().getName() + "已经提交，请及时处理";

            Set<Long> userList = new HashSet<Long>();
            if (userIds != null) {
                for (String userId : userIds) {
                    userList.add(Long.valueOf(userId));
                }
            }
            //注意：由于BpmTaskInstance每次都变化故无法删除原来的task，所以改为BpmProcessInstance实例为主标识
            oaTaskManager.createTask(BpmTaskInstance.class.getSimpleName(), data.getId(), taskTitle, userList);
        }
//        }
    }

    /**
     * 根据jBPM process instance得到BpmProcessInstance
     *
     * @param processInstanceId
     * @return
     */
    public static BpmProcessInstance getBpmProcessInstance(Long processInstanceId) {
        String hql = "from BpmProcessInstance t where t.jbpmProcessInstanceId = " + processInstanceId;
        return bpmProcessInstanceService.findUnique(hql);
    }

    /**
     * 得到前一个task instance
     *
     * @param processInstanceId
     * @return
     */
    public static BpmTaskInstance getPreviousTaskInstance(Long processInstanceId) {
        BpmProcessInstance bpmProcessInstance = getBpmProcessInstance(processInstanceId);

        String hql = "from BpmTaskInstance t where t.processInstance.id=" + bpmProcessInstance.getId();
        List<BpmTaskInstance> taskInstances = bpmTaskInstanceService.findByQuery(hql);
        //取出process instance的task instance,按倒序排列后放入list
        List<BpmTaskInstance> bpmTaskInstances = new ArrayList<BpmTaskInstance>();
        bpmTaskInstances.addAll(taskInstances);
        Comparator descOrder = ComparableComparator.getInstance();
        descOrder = ComparatorUtils.reversedComparator(descOrder); //倒序
        BeanComparator beanComparator = new BeanComparator("id", descOrder);
        Collections.sort(bpmTaskInstances, beanComparator);

        return bpmTaskInstances.get(0);
    }

    /**
     * 计算条件表达式的结果
     *
     * @param processInstanceId
     * @param condition
     * @return
     * @throws javax.script.ScriptException
     */
    public static Boolean getResult(Long processInstanceId, String condition) throws ScriptException {
        BpmTaskInstance bpmTaskInstance = getPreviousTaskInstance(processInstanceId);
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");

        logger.debug("bpmTaskInstance = " + bpmTaskInstance);
        engine.put("task", bpmTaskInstance);
        Boolean result = false;
        if (!StringHelper.isEmpty(condition)) {
            result = (Boolean) engine.eval(condition);
        }
        return result;
    }

    /**
     * 保存form值
     *
     * @param bpmTaskInstance
     * @param key
     * @return
     * @throws Exception
     */
    public static String getFormValue(BpmTaskInstance bpmTaskInstance, String key) throws Exception {
        BpmFormAction bpmFormAction = bpmTaskInstance.getBpmFormAction();
        String formXml = bpmFormAction.getFormXml();
        Map<String, String> map = XmlHelper.getKeyValues(formXml);
        return map.get(key);
    }

    /**
     * 生成task instance
     *
     * @param taskMgmtInstance
     * @param task
     * @param token
     * @return
     */
    public static TaskInstance createTaskInstance(TaskMgmtInstance taskMgmtInstance, Task task, Token token) {
        return jbpmService.createTaskInstance(taskMgmtInstance, task, token);
    }

    public static String[] getUserIds(BpmNodeDefinition bpmNodeDefinition) throws Exception {
        BpmSwimlaneDefinition bpmSwimlaneDefinition = bpmSwimlaneManager.getSwimlaneDefinition(bpmNodeDefinition);
        return bpmSwimlaneManager.getUserIds(bpmSwimlaneDefinition);
    }

    public static String[] getUserIds(BpmNodeDefinition bpmNodeDefinition, ProcessInstance processInstance) throws Exception {
        BpmSwimlaneDefinition bpmSwimlaneDefinition = bpmSwimlaneManager.getSwimlaneDefinition(bpmNodeDefinition);
        Set<String> varNames = SwimlaneManager.extractVarNames(bpmSwimlaneDefinition.getExpression());

        //如果含有变量则从表单中取变量的值
        SysUser sysUser = sysUserManager.getSysUser();  //外网用户开始创建流程时使用
        if (sysUser.getRegPerson() != null && bpmProcessInstanceManager.isFirstTaskNode(bpmNodeDefinition)) {
            return new String[]{sysUser.getId().toString()};
        }
        if (varNames != null && varNames.size() > 0) {
            BpmSwimlaneDefinition definition = bpmSwimlaneManager.getSwimlaneDefinition(bpmNodeDefinition);
            BpmProcessInstance bpmProcessInstance = bpmProcessInstanceManager.getBpmProcessInstance(processInstance.getId());
            String[] userIds = bpmSwimlaneManager.getUserIds(bpmProcessInstance, definition);
            if (userIds != null && userIds.length > 0) {
                return userIds;
            }
        } else {//不含有变量则直接取泳道人员
            return getUserIds(bpmNodeDefinition);
        }
        return new String[0];
    }

    public static String[] getLastTimeUserIds(ProcessInstance processInstance, BpmNodeDefinition bpmNodeDefinition) {
        return bpmProcessInstanceManager.getLastTimeUserIds(processInstance, bpmNodeDefinition);
    }

}
