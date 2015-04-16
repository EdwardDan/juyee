package com.justonetech.biz.manager.workflow;

import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.domain.bean.column.ColumnParam;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.biz.manager.MsgMessageManager;
import com.justonetech.biz.manager.SysWorkCalendarManager;
import com.justonetech.biz.manager.workflow.handler.ProcessHandler;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.JaxbUtil;
import com.justonetech.biz.utils.jbpm.node.TaskNodeDefinition;
import com.justonetech.biz.utils.jbpm.service.JbpmService;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysUser;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.comparators.ComparableComparator;
import org.apache.commons.collections.comparators.ComparatorChain;
import org.apache.commons.lang.StringUtils;
import org.jbpm.graph.def.Node;
import org.jbpm.graph.def.Transition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.xml.bind.JAXBException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.*;

/**
 * @author tcg
 */
@Service
public class BpmTaskInstanceManager {

    private Logger logger = LoggerFactory.getLogger(BpmTaskInstanceManager.class);

    @Autowired
    private BpmFormTemplateService bpmFormTemplateService;

    @Autowired
    private JbpmService jbpmService;

    @Autowired
    private BpmTaskInstanceService bpmTaskInstanceService;

    @Autowired
    private BpmNodeDefinitionService bpmNodeDefinitionService;

    @Autowired
    private BpmFormTemplateManager bpmFormTemplateManager;

    @Autowired
    private BpmProcessInstanceService bpmProcessInstanceService;

    @Autowired
    private BpmFormDataService bpmFormDataService;

    @Autowired
    private BpmProcessDefinitionManager bpmProcessDefinitionManager;

    @Autowired
    private BpmProcessFormDataManager bpmProcessFormDataManager;

    @Autowired
    private SysWorkCalendarManager sysWorkCalendarManager;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private OaTaskManager oaTaskManager;

    @Autowired
    private MsgMessageManager msgMessageManager;

    @Autowired
    private BpmProcessInstanceManager bpmProcessInstanceManager;

    /**
     * 得到流程前一个表单操作的表单
     *
     * @param bpmTaskInstance
     * @return
     * @throws javax.xml.bind.JAXBException
     */
    public BpmFormTemplate getPreBpmFormTemplate(BpmTaskInstance bpmTaskInstance) throws JAXBException {
        BpmProcessInstance bpmProcessInstance = bpmTaskInstance.getProcessInstance();

        Set<BpmTaskInstance> taskInstances = bpmProcessInstance.getBpmTaskInstances();
        //取出process instance的task instance,按倒序排列后放入list
        List<BpmTaskInstance> bpmTaskInstances = new ArrayList<BpmTaskInstance>();
        bpmTaskInstances.addAll(taskInstances);
        Comparator descOrder = ComparableComparator.getInstance();
        //倒序
        descOrder = ComparatorUtils.reversedComparator(descOrder);
        BeanComparator beanComparator = new BeanComparator("id", descOrder);
        Collections.sort(bpmTaskInstances, beanComparator);

        for (BpmTaskInstance taskInstance : bpmTaskInstances) {
            BpmFormAction bpmFormAction = taskInstance.getBpmFormAction();
            if (bpmFormAction != null && isChildOf(bpmTaskInstance, taskInstance)) {
                return bpmFormAction.getFormTemplate();
            }
        }
        return null;
    }

    /**
     * todo
     *
     * @param child
     * @param parent
     * @return
     */
    public boolean isChildOf(BpmTaskInstance child, BpmTaskInstance parent) {
//        BpmNodeDefinition childNodeDefinition = child.getTaskDefinition();
//        Long childNodeId = childNodeDefinition.getId();
//        BpmNodeDefinition parentNodeDefinition = parent.getTaskDefinition();
//        Long parentNodeId = parentNodeDefinition.getId();
//
//        //取出本流程的所有transition
//        String hql = "from BpmProcessTransition t where t.processDefinition.id="+child.getProcessInstance().getProcessDefinition().getId();
//        List<BpmProcessTransition> processTransitions = bpmProcessTransitionService.findByQuery(hql);
//
//        Queue toVisitedNodesQueue = new LinkedList();
//        Map<Long,Long> visitedNodes = new HashMap<Long,Long>();
//        for (BpmProcessTransition bpmProcessTransition : processTransitions) {
////            bpmProcessTransition.
//        }

        return true;
    }

    /**
     * 获取流程模板
     *
     * @param bpmTaskInstance
     * @return
     * @throws javax.xml.bind.JAXBException
     */
    public BpmFormTemplate getBpmFormTemplate(BpmTaskInstance bpmTaskInstance) throws JAXBException {
        BpmNodeDefinition nodeDefinition = bpmTaskInstance.getTaskDefinition();
        BpmFormTemplate bpmFormTemplate = getBpmFormTemplate(nodeDefinition);
        if (bpmFormTemplate == null) {
            bpmFormTemplate = getPreBpmFormTemplate(bpmTaskInstance);
        }
        return bpmFormTemplate;
    }

    /**
     * 通过节点获取表单模板
     *
     * @param bpmNodeDefinition
     * @return
     * @throws javax.xml.bind.JAXBException
     */
    public BpmFormTemplate getBpmFormTemplate(BpmNodeDefinition bpmNodeDefinition) throws JAXBException {
        TaskNodeDefinition taskNodeDefinition = getTaskNodeDefinition(bpmNodeDefinition);
        Long id = taskNodeDefinition.getFormId();
        BpmFormTemplate bpmFormTemplate = null;
        if (id != null) {
            bpmFormTemplate = bpmFormTemplateService.get(id);
        }
        return bpmFormTemplate;
    }


    /**
     * 获取节点定义
     *
     * @param bpmNodeDefinition
     * @return
     * @throws javax.xml.bind.JAXBException
     */
    public TaskNodeDefinition getTaskNodeDefinition(BpmNodeDefinition bpmNodeDefinition) throws JAXBException {
        if (bpmNodeDefinition.getNodeDefinition() != null) {
            return JaxbUtil.unmarshall(TaskNodeDefinition.class, bpmNodeDefinition.getNodeDefinition());
        }
        return null;
    }

    /**
     * 取得节点是否定义人员
     *
     * @param bpmNodeDefinition
     * @return 无定义则返回false
     * @throws javax.xml.bind.JAXBException
     */
    public boolean getIsSelectUser(BpmNodeDefinition bpmNodeDefinition) throws JAXBException {
        String nodeType = bpmNodeDefinition.getNodeType();
        //不是任务结点则返回false
        if (!"K".equals(nodeType)) {
            return false;
        }
        TaskNodeDefinition taskNodeDefinition = getTaskNodeDefinition(bpmNodeDefinition);
        return taskNodeDefinition != null && taskNodeDefinition.isSelectUser();
    }

    /**
     * 取节点上操作时间限制
     *
     * @param taskNodeDefinition
     * @return
     */
    public double getHours(TaskNodeDefinition taskNodeDefinition, BpmTaskInstance bpmTaskInstance) {
        double hours = -1;
        // 获取时间限制
        Integer limit = taskNodeDefinition.getDateLimit();

        Timestamp startTime = bpmTaskInstance.getStartTime();
        if (startTime != null && limit != null) {
            //计算距当前到设定的时间的时间差
            hours = 24 * limit - (System.currentTimeMillis() - startTime.getTime()) / (3600 * 24);
        }
        return hours;
    }

    public Boolean isNodeTimeout(TaskNodeDefinition taskNodeDefinition, BpmTaskInstance bpmTaskInstance) throws Exception {
        // 获取时间限制
        Integer limit = taskNodeDefinition.getDateLimit();
        Timestamp startTime = bpmTaskInstance.getStartTime();
        Timestamp endTime = bpmTaskInstance.getEndTime();
        if (startTime != null && limit != null) {
            if (endTime == null) {
                return sysWorkCalendarManager.isTimeout(startTime, limit);
            } else {
                return sysWorkCalendarManager.isTimeout(startTime, limit, endTime.getDate());
            }
        }
        return false;
    }


    /**
     * 设置下一步的人员
     * 注意：把下步审核的人员放在流程的上下文中，变量名为设置人员的节点名称
     *
     * @param processInstance
     * @param nodeName
     * @param actorIds
     */
    public void setNextNodeActorIds(ProcessInstance processInstance, String nodeName, String[] actorIds) {
        processInstance.getContextInstance().setVariable(nodeName, actorIds);
    }

    /**
     * 设置下一步的人员
     * 注意：把下步审核的人员放在流程的上下文中，变量名为设置人员的节点名称
     *
     * @param bpmTaskInstance
     * @param nodeName
     * @param actorIds
     */
    public void setNextNodeActorIds(BpmTaskInstance bpmTaskInstance, String nodeName, String[] actorIds) {
        ProcessInstance processInstance = getProcessInstance(bpmTaskInstance);
        setNextNodeActorIds(processInstance, nodeName, actorIds);
    }

    /**
     * 结束当前任务实例
     *
     * @param bpmTaskInstance
     * @param actorId
     * @param bpmProcessTransition
     * @throws Exception
     */
    public void endTaskInstance(BpmTaskInstance bpmTaskInstance, String actorId, BpmProcessTransition bpmProcessTransition) throws Exception {
        String transitionName = null;
        if (bpmProcessTransition != null) {
            Transition transition = jbpmService.getTransition(bpmProcessTransition.getJbpmTransitionId());
            transitionName = transition.getName();
        }
        String nodeDefinition = bpmTaskInstance.getTaskDefinition().getNodeDefinition();
        TaskNodeDefinition taskNodeDefinition = JaxbUtil.unmarshall(TaskNodeDefinition.class, nodeDefinition);
        String taskType = taskNodeDefinition.getTaskCreateType();

        //得到当前Jbpm Node名称
        TaskInstance taskInstance = getTaskInstance(bpmTaskInstance);
        jbpmService.endTaskInstance(taskInstance, taskType, actorId, transitionName);
        //end bpm task instance
        bpmTaskInstance.setEndTime(new Timestamp(System.currentTimeMillis()));
        ProcessInstance processInstance = getProcessInstance(taskInstance);
        boolean hasEnd = processInstance.hasEnded();
        if (hasEnd) {
            BpmProcessInstance bpmProcessInstance = bpmTaskInstance.getProcessInstance();
            bpmProcessInstance.setEndTime(new Timestamp(System.currentTimeMillis()));
            bpmProcessInstance.setStatus(Constants.BPM_STATUS_END);

            //保存数据到业务表
            Object bizObject = bpmProcessFormDataManager.getBizObjectByProcessInstance(bpmProcessInstance);
            if (bizObject != null) {
                bpmProcessFormDataManager.updateBizData(bizObject, bpmProcessInstance.getProcessDefinition().getFinishScript(), bpmTaskInstance.getBpmFormAction().getFormXml());

                //调用ProcessHandler的实现类的onFinish方法
                ProcessHandler processHandler = bpmProcessDefinitionManager.getProcessHandler(bpmProcessInstance.getProcessDefinition());
                if (processHandler != null) {
                    processHandler.onFinish(bizObject);
                }
            }
            sendSmsMessageToStartUser(bpmProcessInstance);
        }

        jbpmService.flush();
    }

    /**
     * 当流程全部结束时给流程创建者发送消息
     *
     * @param bpmProcessInstance 流程实例
     * @throws Exception
     */
    public void sendSmsMessageToStartUser(BpmProcessInstance bpmProcessInstance) throws Exception {
        String code = bpmProcessInstance.getCode();
        String title = bpmProcessInstance.getTitle();
        String taskTitle = "";
        if (!StringHelper.isEmpty(code)) {
            taskTitle += "编号【" + code + "】";
        }
        if (!StringHelper.isEmpty(title)) {
            if (!"".equals(taskTitle)) taskTitle += "，";
            taskTitle += "标题【" + title + "】";
        }
        if (!"".equals(taskTitle)) {
            taskTitle += "的" + bpmProcessInstance.getProcessDefinition().getName() + "已全部结束";
        }

        Set<Long> userIds = getFirstTaskNodeUserIds(bpmProcessInstance);
        if (userIds != null) {
            msgMessageManager.sendSmsByUser(taskTitle, null, StringUtils.join(userIds, ",").split(","));
        }
    }

    public Set<Long> getFirstTaskNodeUserIds(BpmProcessInstance bpmProcessInstance) {
        BpmProcessDefinition bpmProcessDefinition = bpmProcessInstance.getProcessDefinition();
        BpmNodeDefinition firstNodeDefinition = null;
        Set<BpmNodeDefinition> bpmNodeDefinitions = bpmProcessDefinition.getBpmNodeDefinitions();
        for (BpmNodeDefinition bpmNodeDefinition : bpmNodeDefinitions) {
            if (bpmProcessInstanceManager.isFirstTaskNode(bpmNodeDefinition)) {
                firstNodeDefinition = bpmNodeDefinition;
            }
        }
        return getTaskHistoryUserIds(bpmProcessInstance, firstNodeDefinition);
    }

    /**
     * @param taskInstance
     * @return
     */
    private ProcessInstance getProcessInstance(TaskInstance taskInstance) {
        return taskInstance.getProcessInstance();
    }

    /**
     * @param bpmTaskInstance
     * @return
     */
    private TaskInstance getTaskInstance(BpmTaskInstance bpmTaskInstance) {
        return jbpmService.getTaskInstance(bpmTaskInstance.getJbpmTaskInstanceId());
    }

    /**
     * @param bpmTaskInstance
     * @return
     */
    public ProcessInstance getProcessInstance(BpmTaskInstance bpmTaskInstance) {
        TaskInstance taskInstance = getTaskInstance(bpmTaskInstance);
        return getProcessInstance(taskInstance);
    }

    /**
     * 获取用户在该流程实例中的task实例
     *
     * @param bpmProcessInstance
     * @param actorId
     * @return
     * @throws Exception
     */
    public BpmTaskInstance getBpmTaskInstance(BpmProcessInstance bpmProcessInstance, String actorId) throws Exception {
        List<TaskInstance> taskInstances = jbpmService.getTaskInstance(bpmProcessInstance.getJbpmProcessInstanceId(), actorId);
        TaskInstance taskInstance = null;
        if (taskInstances.size() > 0) {
            taskInstance = taskInstances.get(0);
        }
        BpmTaskInstance bpmTaskInstance = null;
        if (taskInstance != null) {
            bpmTaskInstance = bpmTaskInstanceService.findUnique("from BpmTaskInstance where jbpmTaskInstanceId=" + taskInstance.getId());
        }
        return bpmTaskInstance;
    }

    /**
     * 获取流程当前任务实例
     *
     * @param bpmProcessInstance .
     * @return .
     */
    public BpmNodeDefinition getCurrentBpmNodeDefinition(BpmProcessInstance bpmProcessInstance) {
        Long processInstanceId = bpmProcessInstance.getJbpmProcessInstanceId();
        ProcessInstance processInstance = jbpmService.getProcessInstance(processInstanceId);
        Node node = processInstance.getRootToken().getNode();
        String hql = "from BpmNodeDefinition t where t.jbpmNodeId=" + node.getId();
        return bpmNodeDefinitionService.findUnique(hql);
    }

    /**
     * 获取文档挂接，根据审核类型在标准操作和表单操作中查找
     *
     * @param bpmTaskInstance
     * @return
     * @throws javax.xml.bind.JAXBException
     */
    public DocDocument getFileDocument(BpmTaskInstance bpmTaskInstance) throws JAXBException {
        String operateType = getOperateType(bpmTaskInstance);
        //如果是标准操作,则标准操作与文档表关联...
        DocCategory fileCategory = bpmTaskInstance.getProcessInstance().getProcessDefinition().getFileCategory();
        DocDocument fileDocument = null;
        if (TaskNodeDefinition.OPERATION_TYPE_FORM.equalsIgnoreCase(operateType)) {
            BpmFormAction bpmFormAction = bpmTaskInstance.getBpmFormAction();
            if (bpmFormAction != null) {
                fileDocument = bpmFormAction.getDocument();
            }
        } else if (TaskNodeDefinition.OPERATION_TYPE_STANDARD.equalsIgnoreCase(operateType)) {
            BpmStandardAction standardAction = bpmTaskInstance.getBpmStandardAction();
            if (standardAction != null) {
                fileDocument = standardAction.getDocument();
            }
        }
        if (fileDocument == null) {
            fileDocument = new DocDocument();
        }
        fileDocument.setCategory(fileCategory);
        return fileDocument;
    }

    /**
     * 获取任务操作类型
     *
     * @param bpmTaskInstance
     * @return
     */
    public String getOperateType(BpmTaskInstance bpmTaskInstance) throws JAXBException {
        TaskNodeDefinition taskNodeDefinition = getTaskNodeDefinition(bpmTaskInstance.getTaskDefinition());
        return taskNodeDefinition.getOperateType();
    }

    /**
     * 获取任务操作日志
     *
     * @param bpmProcessInstance
     * @return
     * @throws javax.xml.bind.JAXBException
     */
    public List<Map<String, Object>> getLogs(BpmProcessInstance bpmProcessInstance) throws JAXBException {
        //仅列出已操作的步骤
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        //1.1表单操作
        Set<BpmFormAction> bpmFormActionSet = bpmProcessInstance.getBpmFormActions();
        for (BpmFormAction bpmFormAction : bpmFormActionSet) {
            BpmTaskInstance taskInstance = bpmFormAction.getTaskInstance();

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("bpmTaskInstanceId", taskInstance.getId());
            map.put("operateType", TaskNodeDefinition.OPERATION_TYPE_FORM);
            map.put("opTime", bpmFormAction.getSubmitTime());
            if (bpmFormAction.getSubmitUser() != null) {
                map.put("actor", bpmFormAction.getSubmitUser().getDisplayName());
            }
            map.put("documentLink", documentManager.getDownloadButton(bpmFormAction.getDocument()));
            map.put("name", taskInstance.getTaskDefinition().getName());
            list.add(map);
        }

        //1.2标准操作
        Set<BpmStandardAction> standardActionSet = bpmProcessInstance.getBpmStandardActions();
        for (BpmStandardAction bpmStandardAction : standardActionSet) {
            BpmTaskInstance taskInstance = bpmStandardAction.getTaskInstance();

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("bpmTaskInstanceId", taskInstance.getId());
            map.put("operateType", TaskNodeDefinition.OPERATION_TYPE_STANDARD);
            map.put("opTime", bpmStandardAction.getSubmitTime());
            if (bpmStandardAction.getSubmitUser() != null) {
                map.put("actor", bpmStandardAction.getSubmitUser().getDisplayName());
            }
            map.put("documentLink", documentManager.getDownloadButton(bpmStandardAction.getDocument()));
            map.put("name", taskInstance.getTaskDefinition().getName());
            map.put("opinion", bpmStandardAction.getOpinion());
            list.add(map);
        }

        //按操作时间排序
        ArrayList<Object> sortFields = new ArrayList<Object>();
        sortFields.add(new BeanComparator("opTime", ComparatorUtils.NATURAL_COMPARATOR));     //按字段opTime排序
        ComparatorChain multiSort = new ComparatorChain(sortFields);
        Collections.sort(list, multiSort);

        //下述逻辑无法实现按操作时间排序，故暂时不用
//        String hql = "from BpmTaskInstance where processInstance.id=" + bpmProcessInstance.getId() + " order by taskDefinition.name asc,id desc";
//        List<BpmTaskInstance> bpmTaskInstances = bpmTaskInstanceService.findByQuery(hql);
//        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//        for (BpmTaskInstance bpmTaskInstance : bpmTaskInstances) {
//            //通过endTime来判断任务时候被完成
//            if (bpmTaskInstance.getEndTime() != null) {
//                Map<String, Object> map = new HashMap<String, Object>();
//                map.put("bpmTaskInstanceId", bpmTaskInstance.getId());
//                String operateType = getOperateType(bpmTaskInstance);
//                map.put("operateType", operateType);
//                if (TaskNodeDefinition.OPERATION_TYPE_STANDARD.equalsIgnoreCase(operateType)) {
//                    BpmStandardAction bpmStandardAction = bpmTaskInstance.getBpmStandardAction();
//                    if (bpmStandardAction != null) {
//                        map.put("opTime", bpmStandardAction.getSubmitTime());
//                        if (bpmStandardAction.getSubmitUser() != null) {
//                            map.put("actor", bpmStandardAction.getSubmitUser().getDisplayName());
//                        }
//                        map.put("opinion", bpmStandardAction.getOpinion());
//                        if (bpmStandardAction.getDocument() != null) {
//                            map.put("documentLink", documentManager.getDownloadButton(bpmStandardAction.getDocument()));
//                        }
//                    }
//                } else if (TaskNodeDefinition.OPERATION_TYPE_FORM.equalsIgnoreCase(operateType)) {
//                    BpmFormAction bpmFormAction = bpmTaskInstance.getBpmFormAction();
//                    if (bpmFormAction != null) {
//                        map.put("opTime", bpmFormAction.getSubmitTime());
//                        if (bpmFormAction.getSubmitUser() != null) {
//                            map.put("actor", bpmFormAction.getSubmitUser().getDisplayName());
//                        }
//                        if (bpmFormAction.getDocument() != null) {
//                            map.put("documentLink", documentManager.getDownloadButton(bpmFormAction.getDocument()));
//                        }
//                    }
//                }
//                String name = bpmTaskInstance.getTaskDefinition().getName();
//                map.put("name", name);
//                list.add(map);
//            }
//        }
        return list;
    }

    /**
     * 保存流程实例及流程数据表
     *
     * @param bpmTaskInstance .
     * @param bpmFormData     .
     * @param xmlData         .
     * @throws Exception .
     */
    public void saveCustomColumnData(BpmTaskInstance bpmTaskInstance, BpmFormData bpmFormData, String xmlData) throws Exception {
        BpmProcessInstance bpmProcessInstance = bpmTaskInstance.getProcessInstance();
        //当前表单模板
        BpmFormTemplate bpmFormTemplate = getBpmFormTemplate(bpmTaskInstance);

        //1、提取操作数据保存到---流程实例表
        List<ColumnParam> processDefinitionColumns = bpmFormTemplateManager.getColumnList(bpmProcessInstance.getProcessDefinition().getColumnXml());
        for (ColumnParam param : processDefinitionColumns) {
            String key = param.getKey();
            String column = param.getColumn();
            if (!param.getIsValid() || StringHelper.isEmpty(param.getKey())) {
                continue;
            }

            //不同表单提取不同内容
            if (!String.valueOf(bpmFormTemplate.getId()).equals(param.getFormId())) {
                continue;
            }

            String value = "";
            if (!StringHelper.isEmpty(xmlData)) {
                value = bpmFormTemplateManager.getValue(xmlData, key);
            }
            if (!StringHelper.isEmpty(column)) {
                //利用反射保存数据
                //先得到字段的类型，后面取方法时会用到
                if ("reportDate".equals(column)) {
                    if (!StringHelper.isEmpty(value)) {
                        bpmProcessInstance.setReportDate(DateTimeHelper.getDateByString(value));
                    } else {
                        bpmProcessInstance.setReportDate(null);
                    }
                } else {
                    PropertyUtils.setProperty(bpmProcessInstance, column, value);
                }
            }
        }
        bpmProcessInstanceService.save(bpmProcessInstance);


        //2、提取操作数据保存到---表单数据表
        if (bpmFormData != null) {

            List<ColumnParam> formTemplateColumns = bpmFormTemplateManager.getColumnList(bpmFormTemplate.getColumnXml());
            for (ColumnParam param : formTemplateColumns) {
                String key = param.getKey();
                String column = param.getColumn();
                if (!param.getIsValid() || StringHelper.isEmpty(param.getKey())) {
                    continue;
                }
                String value = "";
                if (!StringHelper.isEmpty(xmlData)) {
                    value = bpmFormTemplateManager.getValue(xmlData, key);
                }
                if (!StringHelper.isEmpty(column)) {
                    //利用反射保存数据
                    //eg.setCode
                    if ("reportDate".equals(column)) {
                        if (!StringHelper.isEmpty(value)) {
                            bpmFormData.setReportDate(DateTimeHelper.getDateByString(value));
                        } else {
                            bpmFormData.setReportDate(null);
                        }
                    } else {
                        String methodName = "set" + column.substring(0, 1).toUpperCase() + column.substring(1);
                        Method bpmFormDataMethod = bpmFormData.getClass().getMethod(methodName, String.class);
                        bpmFormDataMethod.invoke(bpmFormData, value);
                    }
                }
            }
            bpmFormDataService.save(bpmFormData);
        }
    }

    /**
     * var xml1 = getFormXml("FormA");
     * var xml2 = getFormXml("FormB");
     * .....
     * return xml3;
     * <p/>
     * setFormValue("FormA","/data/unit",getFormValue("FormB","/data/unit"));
     * setFormValue("FormA","/data/unit",getFormValue("FormB","/data/unit"));
     *
     * @param bpmTaskInstance
     * @param initScript
     * @return
     * @throws javax.script.ScriptException
     */
    public String processInitScript(BpmTaskInstance bpmTaskInstance, String initScript) throws ScriptException {
        String ret = "";
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        engine.put("task", bpmTaskInstance);
        if (!StringUtils.isBlank(initScript)) {

            ret = String.valueOf(engine.eval(initScript));
        }
        return ret;
    }

    public Set<Long> getTaskHistoryUserIds(BpmProcessInstance bpmProcessInstance, BpmNodeDefinition bpmNodeDefinition) {
        String hql = "from BpmTaskInstance t where t.processInstance.id=" + bpmProcessInstance.getId() + " and t.taskDefinition.id=" + bpmNodeDefinition.getId() + " order by id desc";
        List<BpmTaskInstance> bpmTaskInstances = bpmTaskInstanceService.findByQuery(hql);

        if (bpmTaskInstances == null || bpmTaskInstances.size() == 0) {
            return null;
        }

        Set<Long> sysUserIds = new HashSet<Long>();
        for (BpmTaskInstance bpmTaskInstance : bpmTaskInstances) {
            Long jbpmTaskInstanceId = bpmTaskInstance.getJbpmTaskInstanceId();
            TaskInstance taskInstance = jbpmService.getTaskInstance(jbpmTaskInstanceId);
            String actorId = taskInstance.getActorId();
            sysUserIds.add(Long.valueOf(actorId));
        }

        return sysUserIds;
    }

    public List<SysUser> getTaskHistoryUsers(BpmProcessInstance bpmProcessInstance, BpmNodeDefinition bpmNodeDefinition) {
        Set<Long> sysUserIds = getTaskHistoryUserIds(bpmProcessInstance, bpmNodeDefinition);
        if (sysUserIds == null || sysUserIds.size() == 0) {
            return null;
        }

        List<SysUser> sysUsers = new ArrayList<SysUser>();
        for (Long sysUserId : sysUserIds) {
            SysUser sysUser = sysUserService.get(sysUserId);
            sysUsers.add(sysUser);
        }

        return sysUsers;
    }
}
