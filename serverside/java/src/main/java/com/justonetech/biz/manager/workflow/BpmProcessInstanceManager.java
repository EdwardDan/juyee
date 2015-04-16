package com.justonetech.biz.manager.workflow;

import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.biz.manager.SwimlaneManager;
import com.justonetech.biz.manager.workflow.handler.ProcessHandler;
import com.justonetech.biz.utils.BizDataGenerator;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.JaxbUtil;
import com.justonetech.biz.utils.jbpm.node.TaskNodeDefinition;
import com.justonetech.biz.utils.jbpm.service.JbpmService;
import com.justonetech.biz.utils.process.page.BizHtmlToXml;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import com.justonetech.system.utils.UserSessionUtils;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.comparators.ComparableComparator;
import org.apache.commons.collections.comparators.ComparatorChain;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.DocumentException;
import org.jbpm.graph.def.Node;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.graph.node.TaskNode;
import org.jbpm.taskmgmt.exe.PooledActor;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.sql.Timestamp;
import java.util.*;

/**
 * @version 1.0
 * @author: Ma Ji,Tian Chungang
 * @since: 2009-5-12
 */
@Service
public class BpmProcessInstanceManager {

    private static final Log logger = LogFactory.getLog(BpmProcessInstanceManager.class);

    @Autowired
    private BpmProcessDefinitionService bpmProcessDefinitionService;

    @Autowired
    private BpmProcessInstanceService bpmProcessInstanceService;

    @Autowired
    private JbpmService jbpmService;

    @Autowired
    private BpmNodeDefinitionService bpmNodeDefinitionService;

    @Autowired
    private BpmTaskInstanceManager bpmTaskInstanceManager;

    @Autowired
    private BpmStandardActionService bpmStandardActionService;

    @Autowired
    private BpmFormDataService bpmFormDataService;

    @Autowired
    private BpmFormActionService bpmFormActionService;

    @Autowired
    private BpmTaskInstanceService bpmTaskInstanceService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SwimlaneManager swimlaneManager;

    @Autowired
    private BpmGetDefaultValueManager bpmGetDefaultValueManager;

    @Autowired
    private BpmProcessFormDataManager bpmProcessFormDataManager;

    @Autowired
    private BpmFormTemplateManager bpmFormTemplateManager;

    @Autowired
    private BpmSwimlaneManager bpmSwimlaneManager;

    @Autowired
    private BpmProcessDefinitionManager bpmProcessDefinitionManager;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private OaTaskManager oaTaskManager;

//    @Autowired
//    private BpmProcessSendMsgManager bpmProcessSendMsgManager;

    /**
     * 开始一个BPM流程
     *
     * @param bpmProcessDefinition
     * @param user
     * @return
     */
    public BpmProcessInstance startBpmProcessInstance(BpmProcessDefinition bpmProcessDefinition, SysUser user) {
        BpmProcessInstance bpmProcessInstance = setBpmProcessInstance(bpmProcessDefinition, user);
        bpmProcessInstanceService.save(bpmProcessInstance);

        startProcessInstance(bpmProcessDefinition, user, bpmProcessInstance);
        return bpmProcessInstance;
    }

    /**
     * 开始一个BPM流程，并与业务表进行关联
     *
     * @param bpmProcessDefinition
     * @param user
     * @param bizObjectId
     * @return
     */
    public BpmProcessInstance startBpmProcessInstance(BpmProcessDefinition bpmProcessDefinition, SysUser user, Long bizObjectId) {
        BpmProcessInstance bpmProcessInstance = setBpmProcessInstance(bpmProcessDefinition, user);
        //设置关联业务ID
        bpmProcessInstance.setBizObjectId(bizObjectId);
        bpmProcessInstanceService.save(bpmProcessInstance);

        startProcessInstance(bpmProcessDefinition, user, bpmProcessInstance);
        return bpmProcessInstance;
    }

    /**
     * @param bizObject   类名
     * @param user
     * @param bizObjectId 记录id
     * @return
     */
    public BpmProcessInstance startBpmProcessInstanceWithCode(String bizObject, SysUser user, Long bizObjectId) {
//        String hql = "from BpmProcessDefinition t where t.bizObject='{0}' and t.isValid =1";
//        BpmProcessDefinition processDefinition = bpmProcessDefinitionService.findUnique(FormatUtil.format(hql, bizObject));
        BpmProcessDefinition processDefinition = bpmProcessDefinitionManager.getValidBpmProcessDefinition(bizObject);
        logger.debug("bpm process definition is :" + processDefinition);
        return startBpmProcessInstance(processDefinition, user, bizObjectId);
    }

    /**
     * 开始一个jBPM流程
     *
     * @param bpmProcessDefinition
     * @param user
     * @param bpmProcessInstance
     */
    private void startProcessInstance(BpmProcessDefinition bpmProcessDefinition, SysUser user, BpmProcessInstance bpmProcessInstance) {
        ProcessInstance processInstance = jbpmService.startProcessInstance(bpmProcessDefinition.getJbpmDefinitionId(), String.valueOf(user.getId()));
        bpmProcessInstance.setJbpmProcessInstanceId(processInstance.getId());
        bpmProcessInstanceService.save(bpmProcessInstance);
        bpmProcessInstanceService.flush();
        processInstance.signal();
    }

    /**
     * 设置BpmProcessInstance
     *
     * @param bpmProcessDefinition
     * @param user
     * @return
     */
    private BpmProcessInstance setBpmProcessInstance(BpmProcessDefinition bpmProcessDefinition, SysUser user) {
        BpmProcessInstance bpmProcessInstance = new BpmProcessInstance();
        bpmProcessInstance.setProcessDefinition(bpmProcessDefinition);
        bpmProcessInstance.setStartTime(new Timestamp(System.currentTimeMillis()));
        bpmProcessInstance.setReportDate(new java.sql.Date(System.currentTimeMillis()));
        bpmProcessInstance.setStatus(Constants.BPM_STATUS_RUN);
        bpmProcessInstance.setTitle(bpmProcessDefinition.getName() + "_" + System.currentTimeMillis());
        bpmProcessInstance.setPersonName(user.getDisplayName());
        return bpmProcessInstance;
    }

    /**
     * 获取流程状态
     *
     * @param bpmProcessInstance
     * @return
     */
    public String getStatusName(BpmProcessInstance bpmProcessInstance) {
        String status = "";
        if (Constants.BPM_STATUS_RUN.equalsIgnoreCase(bpmProcessInstance.getStatus())) {
            BpmNodeDefinition nodeDefinition = bpmTaskInstanceManager.getCurrentBpmNodeDefinition(bpmProcessInstance);
            if (nodeDefinition != null) {
                status = nodeDefinition.getName();
            }
        } else if (Constants.BPM_STATUS_START.equalsIgnoreCase(bpmProcessInstance.getStatus())) {
            status = "开启中";
        } else if (Constants.BPM_STATUS_END.equalsIgnoreCase(bpmProcessInstance.getStatus())) {
            status = "已结束";
        } else if (Constants.BPM_STATUS_CANCEL.equalsIgnoreCase(bpmProcessInstance.getStatus())) {
            status = "已取消";
        } else if (Constants.BPM_STATUS_HISTORY.equalsIgnoreCase(bpmProcessInstance.getStatus())) {
            status = "历史数据";
        }
        return status;
    }

    private String img = "<input type='button' title='{0}' class='{1}' value=' ' onClick='{2}dealEvent(\"{3}\")'>";    //必须转义，否则grid无法显示

    /**
     * 1.检查用户是否具有查看流程实例权限
     * 2.过滤流程为待审，已审，还是其它
     *
     * @param bpmProcessInstances
     * @param userId
     * @return
     * @throws Exception
     */
    public List<BpmProcessInstance> filterProcessInstance(List<BpmProcessInstance> bpmProcessInstances, String userId, String type) throws Exception {
        List<BpmProcessInstance> ret = new ArrayList<BpmProcessInstance>();

        for (BpmProcessInstance bpmProcessInstance : bpmProcessInstances) {

            //
            if (!hasViewProcessInstancePrivilege(bpmProcessInstance, userId)) {
                continue;
            }

            BpmTaskInstance bpmTaskInstance = bpmTaskInstanceManager.getBpmTaskInstance(bpmProcessInstance, userId);
            //执行中
            if (Constants.BPM_STATUS_RUN.equalsIgnoreCase(bpmProcessInstance.getStatus())) {
                //有权限审核
                if (bpmTaskInstance != null) {
                    if (type.equals("waitAudit")) {
                        ret.add(bpmProcessInstance);
                    }
                } else {
                    if (type.equals("hasAudit")) {
                        ret.add(bpmProcessInstance);
                    }
                }
            } else {
                if (type.equals("other")) {
                    ret.add(bpmProcessInstance);
                }
            }
        }
        return ret;
    }

    /**
     * 获取审核图标
     *
     * @param bpmProcessInstance
     * @param userId
     * @return
     * @throws Exception
     */
    public String getAuditImg(BpmProcessInstance bpmProcessInstance, Long userId) throws Exception {
        String auditImg = "";

        BpmTaskInstance bpmTaskInstance = bpmTaskInstanceManager.getBpmTaskInstance(bpmProcessInstance, String.valueOf(userId));

        List<String> currentActorIds = getCurrentActorIds(bpmProcessInstance);
        //执行中
        if (Constants.BPM_STATUS_RUN.equalsIgnoreCase(bpmProcessInstance.getStatus())) {
            String actorNames = "";
            if (currentActorIds.size() > 0) {
                for (String actorId : currentActorIds) {
                    try {
                        SysUser sysUser = sysUserService.get(Long.valueOf(actorId));
                        actorNames += "," + sysUser.getDisplayName();
                    } catch (NumberFormatException e) {
                        logger.debug(e.getMessage());
                    }
                }
                if (!"".equals(actorNames)) {
                    actorNames = actorNames.substring(1);
                    actorNames = "等待" + actorNames + "审核";
                }
            }
            //有权限审核
            if (bpmTaskInstance != null) {
                auditImg = FormatUtils.format(img, actorNames, "flow_button_audit", "", String.valueOf(bpmTaskInstance.getId()));
            } else {
                auditImg = FormatUtils.format(img, actorNames, "flow_button_audit_disabled", "return;", "");
            }
        } else if (Constants.BPM_STATUS_END.equalsIgnoreCase(bpmProcessInstance.getStatus())) {
            auditImg = FormatUtils.format(img, "已结束", "flow_button_end", "return;", "");
        } else if (Constants.BPM_STATUS_CANCEL.equalsIgnoreCase(bpmProcessInstance.getStatus())) {
            auditImg = FormatUtils.format(img, "已取消", "flow_button_cancel", "return;", "");
        } else if (Constants.BPM_STATUS_HISTORY.equalsIgnoreCase(bpmProcessInstance.getStatus())) {
            auditImg = FormatUtils.format(img, "历史记录", "flow_button_history", "return;", "");
        }
        auditImg += " <input type='button' title='查看流转示意图' class='button_normal' value='图示' onClick='viewFlowPic(\"" + bpmProcessInstance.getId() + "\")'>";
        return auditImg;
    }

    /**
     * 根据bpm process instance 得到当前需要执行的人员
     *
     * @param bpmProcessInstance
     * @return
     * @throws Exception
     */
    public List<String> getCurrentActorIds(BpmProcessInstance bpmProcessInstance) throws Exception {
        List<String> ret = new ArrayList<String>();
        Long processInstanceId = bpmProcessInstance.getJbpmProcessInstanceId();
        List<TaskInstance> taskInstances = jbpmService.getUnfinishedTaskInstances(processInstanceId);
        for (TaskInstance taskInstance : taskInstances) {
            TaskNode taskNode = taskInstance.getTask().getTaskNode();
            TaskNodeDefinition taskNodeDefinition = getTaskNodeDefinition(taskNode);
            if (taskNodeDefinition != null) {
                String taskCreateType = taskNodeDefinition.getTaskCreateType();
                if (TaskNodeDefinition.MULTI_EXCLUSIVE.equals(taskCreateType)) {//多人执行
                    String actorId = taskInstance.getActorId();
                    if (!StringHelper.isEmpty(actorId)) {//任务被独占
                        ret.add(actorId);
                    } else {
                        Set<PooledActor> actors = taskInstance.getPooledActors();
                        for (PooledActor actor : actors) {
                            ret.add(actor.getActorId());
                        }
                    }
                } else if (TaskNodeDefinition.MULTI_SHARE.equals(taskCreateType)) {//多人共享
                    Set<PooledActor> actors = taskInstance.getPooledActors();
                    for (PooledActor actor : actors) {
                        ret.add(actor.getActorId());
                    }
                } else if (TaskNodeDefinition.MULTI_SYNC.equals(taskCreateType)) {//多人会签
                    ret.add(taskInstance.getActorId());
                }
            }
        }
        return ret;
    }

    /**
     * get task node definition by jBPM task node
     *
     * @param node
     * @return
     * @throws JAXBException
     */
    public TaskNodeDefinition getTaskNodeDefinition(Node node) throws JAXBException {
        BpmNodeDefinition bpmNodeDefinition = getNodeDefinition(node);
        if (bpmNodeDefinition != null) {
            String xmlNodeDefinition = bpmNodeDefinition.getNodeDefinition();
            return JaxbUtil.unmarshall(TaskNodeDefinition.class, xmlNodeDefinition);
        }
        return null;
    }

    private BpmNodeDefinition getNodeDefinition(Node node) {
        String hql = "from BpmNodeDefinition t where t.jbpmNodeId = " + node.getId();
        return bpmNodeDefinitionService.findUnique(hql);
    }

    /**
     * 获取流程实例对应的表单数据
     *
     * @param bpmProcessInstance
     * @param bpmFormTemplate
     * @return
     */
    public BpmFormData getBpmFormData(BpmProcessInstance bpmProcessInstance, BpmFormTemplate bpmFormTemplate) {
        BpmFormData bpmFormData = null;
        Set<BpmFormData> bpmFormDatas = bpmProcessInstance.getBpmFormDatas();
        if (bpmFormDatas.size() > 0 && bpmFormTemplate != null) {
            for (BpmFormData data : bpmFormDatas) {
                if (data.getFormTemplate().getId().equals(bpmFormTemplate.getId())) {
                    bpmFormData = data;
                    break;
                }
            }
        }
        return bpmFormData;
    }

    /**
     * 得到有权限开始当前流程的人员列表
     *
     * @param bpmProcessDefinition
     * @return
     * @throws Exception
     */
    public String[] getStartProcessInstanceActorIds(BpmProcessDefinition bpmProcessDefinition) throws Exception {
        BpmNodeDefinition startNodeDefinition = null;
        Set<BpmNodeDefinition> bpmNodeDefinitions = bpmProcessDefinition.getBpmNodeDefinitions();
        for (BpmNodeDefinition bpmNodeDefinition : bpmNodeDefinitions) {
            //得到开始节点
            if ("R".equals(bpmNodeDefinition.getNodeType())) {
                startNodeDefinition = bpmNodeDefinition;
                break;
            }
        }

        if (startNodeDefinition != null) {
            BpmSwimlaneDefinition bpmSwimlaneDefinition = bpmSwimlaneManager.getSwimlaneDefinition(startNodeDefinition);
            return bpmSwimlaneManager.getUserIds(bpmSwimlaneDefinition);
        }

        return null;
    }

    /**
     * 判断流程是否处于当前流程的第一个结点
     *
     * @param bpmProcessInstance
     * @return
     */
    public boolean isTokenInFirstTaskNode(BpmProcessInstance bpmProcessInstance) {
        Long jbpmProcessInstanceId = bpmProcessInstance.getJbpmProcessInstanceId();
        ProcessInstance processInstance = jbpmService.getProcessInstance(jbpmProcessInstanceId);
        Node node = processInstance.getRootToken().getNode();
        BpmNodeDefinition nodeDefinition = getNodeDefinition(node);
        return isFirstTaskNode(nodeDefinition);
    }

    public boolean isFirstTaskNode(BpmNodeDefinition nodeDefinition) {
        Set<BpmProcessTransition> toTransitions = nodeDefinition.getBpmProcessTransitionsByto();
        for (BpmProcessTransition toTransition : toTransitions) {
            BpmNodeDefinition bpmNodeDefinition = toTransition.getFrom();
            if ("R".equals(bpmNodeDefinition.getNodeType())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断当前节点是否是第一次审核的节点
     *
     * @param bpmProcessInstance
     * @return
     */
    public boolean isFirstAuditTaskNode(BpmProcessInstance bpmProcessInstance) {
        BpmProcessDefinition bpmProcessDefinition = bpmProcessInstance.getProcessDefinition();
        String hql = "from BpmNodeDefinition where processDefinition=? and nodeType='K' order by jbpmNodeId";
        List<BpmNodeDefinition> nodeDefinitionList = bpmNodeDefinitionService.findByQuery(hql, bpmProcessDefinition);
        if (nodeDefinitionList.size() > 0 && nodeDefinitionList.get(0) != null) {
            BpmNodeDefinition bpmNodeDefinition = nodeDefinitionList.get(0);
            BpmNodeDefinition currentBpmNodeDefinition = bpmTaskInstanceManager.getCurrentBpmNodeDefinition(bpmProcessInstance);
            if (bpmNodeDefinition.equals(currentBpmNodeDefinition)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 取消流程实例
     *
     * @param bpmProcessInstance
     */
    public void cancelProcessInstance(BpmProcessInstance bpmProcessInstance) {
        Long processInstanceId = bpmProcessInstance.getJbpmProcessInstanceId();
        ProcessInstance processInstance = jbpmService.getProcessInstance(processInstanceId);

        //挂起当前流程
        processInstance.setSuperProcessToken(processInstance.getRootToken());

        //在业务表中把流程实例的状态设置为取消
        bpmProcessInstance.setStatus(Constants.BPM_STATUS_CANCEL);
        bpmProcessInstanceService.save(bpmProcessInstance);
    }

    /**
     * 删除流程实例
     *
     * @param bpmProcessInstance
     */
    public void removeProcessInstance(BpmProcessInstance bpmProcessInstance) {
        Long processInstanceId = bpmProcessInstance.getJbpmProcessInstanceId();

        //删除jBPM流程实例
        ProcessInstance processInstance = jbpmService.getProcessInstance(processInstanceId);
        processInstance.removeCascadeProcessInstances();

        //删除业务表中的流程实例
        Set<BpmFormAction> bpmFormActions = bpmProcessInstance.getBpmFormActions();
        for (BpmFormAction bpmFormAction : bpmFormActions) {
            bpmFormActionService.delete(bpmFormAction);
        }

        Set<BpmStandardAction> standardActions = bpmProcessInstance.getBpmStandardActions();
        for (BpmStandardAction standardAction : standardActions) {
            bpmStandardActionService.delete(standardAction);
        }

        Set<BpmFormData> bpmFormDatas = bpmProcessInstance.getBpmFormDatas();
        for (BpmFormData bpmFormData : bpmFormDatas) {
            bpmFormDataService.delete(bpmFormData);
        }

        Set<BpmTaskInstance> bpmTaskInstances = bpmProcessInstance.getBpmTaskInstances();
        for (BpmTaskInstance bpmTaskInstance : bpmTaskInstances) {
            bpmTaskInstanceService.delete(bpmTaskInstance);
        }

        bpmProcessInstanceService.delete(bpmProcessInstance);
    }

    /**
     * 删除流程实例
     *
     * @param simpleName
     * @param bizObjectId
     */
    public void removeProcessInstance(String simpleName, Long bizObjectId) {
        String bizObject = "com.justonetech.biz.domain." + simpleName;
        BpmProcessInstance processInstance = bpmProcessFormDataManager.getBpmProcessInstance(bizObject, bizObjectId);
        if (processInstance != null) {
            removeProcessInstance(processInstance);
        }
    }


    public void saveFormData(String xmlData, Long bpmTaskInstanceId, String ccUserIds) throws Exception {
        BpmTaskInstance bpmTaskInstance = bpmTaskInstanceService.get(bpmTaskInstanceId);
        BpmProcessInstance bpmProcessInstance = bpmTaskInstance.getProcessInstance();
        BpmProcessDefinition bpmProcessDefinition = bpmProcessInstance.getProcessDefinition();
        //如果当前操作人员已经保存过数据savedXml，取已经保存的数据，否则获取上一步骤所保存的数据
        BpmFormAction bpmFormAction = bpmTaskInstance.getBpmFormAction();
        if (bpmFormAction == null) {
            bpmFormAction = new BpmFormAction();
        }
        String savedXml = bpmFormAction.getFormXml();

        // 根据bpmTaskInstance取对应模板
        BpmFormTemplate bpmFormTemplate = bpmTaskInstanceManager.getBpmFormTemplate(bpmTaskInstance);

        BpmFormData bpmFormData = getBpmFormData(bpmProcessInstance, bpmFormTemplate);
        if (bpmFormData != null) {
            savedXml = bpmFormData.getFormXml();
        } else {
            bpmFormData = new BpmFormData();
        }

        if (!StringHelper.isEmpty(savedXml)) {
            xmlData = BizDataGenerator.generateBizData(xmlData, savedXml);
        } else {
            xmlData = BizDataGenerator.generateBizData(xmlData);
        }

        //为表单添加缺省值(根据脚本语言从其他表单中获取)
        String initScript = "";
        String[] privileges = null;
        if (bpmTaskInstance.getTaskDefinition().getNodeDefinition() != null) {
            TaskNodeDefinition taskNodeDefinition = JaxbUtil.unmarshall(TaskNodeDefinition.class, bpmTaskInstance.getTaskDefinition().getNodeDefinition());
            privileges = taskNodeDefinition.getPrivileges();
            initScript = taskNodeDefinition.getInitScript();
            String otherFormXmlData = bpmTaskInstanceManager.processInitScript(bpmTaskInstance, initScript);
            if (!StringHelper.isEmpty(otherFormXmlData)) {
                xmlData = BizDataGenerator.mergeXml(otherFormXmlData, xmlData);
            }
        }
        //为表单添加缺省值(获取模板中的缺省值)
        BpmFormTemplate template = bpmTaskInstanceManager.getBpmFormTemplate(bpmTaskInstance);
        String htmlTemplate = template.getHtmlTemplate();
        Map defaultValueMap = bpmGetDefaultValueManager.getDefaultValueMap();
        BizHtmlToXml bizHtmlToXml = new BizHtmlToXml(htmlTemplate, privileges, defaultValueMap);
        String defaultXml = bizHtmlToXml.generateXml();
        if (!StringHelper.isEmpty(defaultXml)) {
            xmlData = BizDataGenerator.mergeXml(defaultXml, xmlData);
        }
        //保存数据
        SysUser user = UserSessionUtils.getInstance().getLoginedUser();
        bpmFormAction.setFormXml(xmlData);
        bpmFormAction.setTaskInstance(bpmTaskInstance);
        bpmFormAction.setFormTemplate(template);
        bpmFormAction.setProcessInstance(bpmProcessInstance);
        bpmFormAction.setSubmitTime(new Timestamp(System.currentTimeMillis()));
        bpmFormAction.setSubmitUser(user);

        //add by maji 2009-09-21
        bpmFormData.setFormXml(xmlData);
        bpmFormData.setFormTemplate(bpmFormTemplate);
        bpmFormData.setProcessInstance(bpmProcessInstance);

        //保存数据到业务表
        Object bizObject = bpmProcessFormDataManager.getBizObjectByProcessInstance(bpmProcessInstance);
        if (bizObject != null) {
            bpmProcessFormDataManager.updateBizData(bizObject, bpmProcessDefinition.getUpdateScript(), xmlData);

            //调用ProcessHandler的实现类的onUpdate方法
            ProcessHandler processHandler = bpmProcessDefinitionManager.getProcessHandler(bpmProcessInstance.getProcessDefinition());
            if (processHandler != null) {
                processHandler.onUpdate(bizObject);
            }
        }

        //保存抄送用户ids
        saveCcUserIds(bpmProcessInstance, ccUserIds);

        bpmTaskInstanceService.save(bpmTaskInstance);
        bpmFormActionService.save(bpmFormAction);
        bpmFormDataService.save(bpmFormData);

        //保存自定义字段
        bpmTaskInstanceManager.saveCustomColumnData(bpmTaskInstance, bpmFormData, xmlData);
    }

    /**
     * 表单提交审核
     *
     * @param xmlData
     * @param bpmTaskInstance
     * @param systemUser      系统用户---仅用于处理超时任务实例
     * @throws Exception
     */
    public void saveAndSubmit(String xmlData, BpmTaskInstance bpmTaskInstance, SysUser systemUser, String ccUserIds) throws Exception {
        // 根据bpmTaskInstance取对应模板
        BpmFormTemplate bpmFormTemplate = bpmTaskInstanceManager.getBpmFormTemplate(bpmTaskInstance);

        BpmProcessInstance bpmProcessInstance = bpmTaskInstance.getProcessInstance();
        BpmProcessDefinition bpmProcessDefinition = bpmProcessInstance.getProcessDefinition();

        BpmFormData bpmFormData = getBpmFormData(bpmProcessInstance, bpmFormTemplate);
        if (bpmFormData == null) {
            bpmFormData = new BpmFormData();
        }
        String savedXml = bpmFormData.getFormXml();
        if (!StringHelper.isEmpty(savedXml)) {
            xmlData = BizDataGenerator.generateBizData(xmlData, savedXml);
        } else {
            xmlData = BizDataGenerator.generateBizData(xmlData);
        }

        //为表单添加缺省值(根据脚本语言从其他表单中获取)
        String initScript = "";
        String[] privileges = null;
        if (null != bpmTaskInstance.getTaskDefinition().getNodeDefinition()) {
            TaskNodeDefinition taskNodeDefinition = JaxbUtil.unmarshall(TaskNodeDefinition.class, bpmTaskInstance.getTaskDefinition().getNodeDefinition());
            privileges = taskNodeDefinition.getPrivileges();
            initScript = taskNodeDefinition.getInitScript();
            String otherFormXmlData = bpmTaskInstanceManager.processInitScript(bpmTaskInstance, initScript);
            if (!StringHelper.isEmpty(otherFormXmlData)) {
                xmlData = BizDataGenerator.mergeXml(otherFormXmlData, xmlData);
            }
        }

        //为表单添加缺省值(获取模板中的缺省值)
        BpmFormTemplate template = bpmTaskInstanceManager.getBpmFormTemplate(bpmTaskInstance);
        String htmlTemplate = template.getHtmlTemplate();

        //添加默认值
        Map defaultValueMap = null;
        SysUser user = null;
        if (systemUser == null) {
            defaultValueMap = bpmGetDefaultValueManager.getDefaultValueMap();
            user = UserSessionUtils.getInstance().getLoginedUser();
        } else {
            defaultValueMap = bpmGetDefaultValueManager.getDefaultValueMap(systemUser);
            user = systemUser;
        }
        BizHtmlToXml bizHtmlToXml = new BizHtmlToXml(htmlTemplate, privileges, defaultValueMap);
        String defaultXml = bizHtmlToXml.generateXml();
        if (!StringHelper.isEmpty(defaultXml)) {
            xmlData = BizDataGenerator.mergeXml(defaultXml, xmlData);
        }

        BpmFormAction bpmFormAction = bpmTaskInstance.getBpmFormAction();
        if (bpmFormAction == null) {
            bpmFormAction = new BpmFormAction();
        }
        bpmFormAction.setFormXml(xmlData);
        bpmFormAction.setTaskInstance(bpmTaskInstance);
        bpmTaskInstance.setBpmFormAction(bpmFormAction);
        bpmFormAction.setFormTemplate(bpmTaskInstanceManager.getBpmFormTemplate(bpmTaskInstance));
        bpmFormAction.setProcessInstance(bpmTaskInstance.getProcessInstance());
        bpmFormAction.setSubmitTime(new Timestamp(System.currentTimeMillis()));
        bpmFormAction.setSubmitUser(user);

        bpmFormData.setFormXml(xmlData);
        bpmFormData.setFormTemplate(bpmFormTemplate);
        bpmFormData.setProcessInstance(bpmProcessInstance);

        //保存数据到业务表
        Object bizObject = bpmProcessFormDataManager.getBizObjectByProcessInstance(bpmProcessInstance);
        if (bizObject != null) {
            bpmProcessFormDataManager.updateBizData(bizObject, bpmProcessDefinition.getUpdateScript(), xmlData);

            //调用ProcessHandler的实现类的onUpdate方法
            ProcessHandler processHandler = bpmProcessDefinitionManager.getProcessHandler(bpmProcessInstance.getProcessDefinition());
            if (processHandler != null) {
                processHandler.onUpdate(bizObject);
            }
        }

        //保存抄送用户ids
        saveCcUserIds(bpmProcessInstance, ccUserIds);

        //如果是第一个审核步骤的节点再发消息
//        if (isFirstAuditTaskNode(bpmProcessInstance)) {
//            bpmProcessSendMsgManager.sendJbpmCCMsg(bpmTaskInstance);
//        }

        //保存自定义字段
        bpmTaskInstanceManager.saveCustomColumnData(bpmTaskInstance, bpmFormData, xmlData);

        logger.debug("start bpmTaskInstanceService");
        bpmTaskInstanceService.save(bpmTaskInstance);
        logger.debug("end bpmTaskInstanceService");
        logger.debug("start bpmFormActionService");
        bpmFormActionService.save(bpmFormAction);
        logger.debug("end bpmFormActionService");
        logger.debug("start bpmFormDataService");
        bpmFormDataService.save(bpmFormData);
        logger.debug("end bpmFormDataService");
        bpmFormData.setFormXml(xmlData);
        bpmFormData.setFormTemplate(bpmFormTemplate);
        bpmFormData.setProcessInstance(bpmTaskInstance.getProcessInstance());
        bpmFormDataService.save(bpmFormData);

    }

    /**
     * 判断用户是否具有本流程实例的权限
     * 拥有权限有二种情况：
     * 1.用户操作过流程
     * 2.用户属于流程的查看泳道
     * 注意：用户待审的流程会返回false
     *
     * @param bpmProcessInstance
     * @param userId
     * @return
     * @throws Exception
     */
    public boolean hasViewProcessInstancePrivilege(BpmProcessInstance bpmProcessInstance, String userId) throws Exception {
        //1.检查用户是否属于流程泳道
        Set<String> swimlaneActors = getViewSwimlaneActors(bpmProcessInstance.getProcessDefinition());
        if (swimlaneActors.contains(userId)) {
            return true;
        }

        //2.检查用户是否操作过流程
        ProcessInstance processInstance = jbpmService.getProcessInstance(bpmProcessInstance.getJbpmProcessInstanceId());
        Collection<TaskInstance> taskInstances = processInstance.getTaskMgmtInstance().getTaskInstances();
        for (TaskInstance taskInstance : taskInstances) {
            if (userId.equals(taskInstance.getActorId())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断用户是否在泳道定义中
     *
     * @param bpmSwimlaneDefinition
     * @param userId
     * @return
     * @throws Exception
     */
    public boolean hasSwimlanePrivilege(BpmSwimlaneDefinition bpmSwimlaneDefinition, String userId) throws Exception {
        Set<String> swimlaneActors = bpmSwimlaneManager.getSwimlaneActors(bpmSwimlaneDefinition);
        return swimlaneActors.contains(userId);
    }

    /**
     * 判断用户是否有删除流程实例的权限
     * @param bpmProcessInstance
     * @param sysUser
     * @return
     */
    public boolean hasDeletePrivilege(BpmProcessInstance bpmProcessInstance,SysUser sysUser){
        boolean hasPrivilege = false;
        if (sysUserManager.hasPrivilege(PrivilegeCode.BPM_PROCESS_INSTANCE_FORCE_DELETE)) {
            hasPrivilege = true;
        }
        if(!hasPrivilege){
            if (Constants.BPM_STATUS_START.equals(bpmProcessInstance.getStatus())) {
                if (sysUser.getDisplayName().equals(bpmProcessInstance.getPersonName())) {
                    hasPrivilege = true;
                }
            }
        }
        if(!hasPrivilege){
            hasPrivilege = true;
            Set<BpmTaskInstance> taskInstances = bpmProcessInstance.getBpmTaskInstances();
            for(BpmTaskInstance instance:taskInstances){
                if(instance.getEndTime() != null){
                    hasPrivilege = false;
                    break;
                }
            }
        }
        return hasPrivilege;
    }

    /**
     * 得到查看流程泳道的人员
     *
     * @param bpmProcessDefinition
     * @return Set<userId>
     * @throws Exception
     */
    public Set<String> getViewSwimlaneActors(BpmProcessDefinition bpmProcessDefinition) throws Exception {
        BpmSwimlaneDefinition bpmSwimlaneDefinition = bpmProcessDefinition.getViewSwimlaneDefinition();
        return bpmSwimlaneManager.getSwimlaneActors(bpmSwimlaneDefinition);
    }


    /**
     * 流程转发
     * manager 代理，控制事务
     *
     * @param taskInstanceId
     * @param actorId
     */
    public void forwardTaskInstance(Long taskInstanceId, String actorId) {
        jbpmService.forwardTaskInstance(taskInstanceId, actorId);
    }

    /**
     * 流程锁定
     * manager 代理，控制事务
     *
     * @param taskInstance
     * @param actorId
     */
    public void setLock(TaskInstance taskInstance, String actorId) {
        jbpmService.setLock(taskInstance, actorId);
    }

    /**
     * 流程解锁
     * manager 代理，控制事务
     *
     * @param taskInstance
     */
    public void cancelLock(TaskInstance taskInstance) {
        jbpmService.cancelLock(taskInstance);
    }


    /**
     * 根据userId得到用户code为processDefinitionCode的流程定义并且在项目id为projectId的项目的待审列表
     * @param processDefinitionCode
     * @param userId
     * @return
     */
    public List<BpmProcessInstance> getWaitAuditList(String processDefinitionCode, Long userId) {
        SysUser sysUser = sysUserService.get(userId);
        //待审列表分为两部分：
        List<BpmProcessInstance> list = new ArrayList<BpmProcessInstance>();

        //1.流程的任务实例分配给pool actor
        String hql1 = "select distinct p " +
                "from BpmProcessInstance p,org.jbpm.taskmgmt.exe.TaskInstance t,org.jbpm.taskmgmt.exe.PooledActor a " +
                "where t.end is null and t.isCancelled=false and (t.actorId is null and a.actorId = '" + userId + "')"+
                "and p.jbpmProcessInstanceId=t.processInstance.id and t.id in elements(a.taskInstances) ";

        //2.流程的任务实例分配给actorId
        String hql2 = "select distinct p " +
                "from BpmProcessInstance p,org.jbpm.taskmgmt.exe.TaskInstance t " +
                "where p.jbpmProcessInstanceId=t.processInstance.id ";
//                "and t.end is null and t.isCancelled=false and t.actorId=" + userId + "";
        if(sysUser.getRegPerson() != null){   //外网用户可以查看自己创建的流程实例
            hql2 += "and t.end is null and t.isCancelled=false and (t.actorId=" + userId + " or p.createUser='"+sysUser.getLoginName()+"')";
        }else{                                //内网用户只能查看自己待审的流程实例
            hql2 += "and t.end is null and t.isCancelled=false and (t.actorId=" + userId + ")";
        }
        if (!"all".equals(processDefinitionCode)) {
            hql1 += " and p.processDefinition.code = '" + processDefinitionCode + "'";
            hql2 += " and p.processDefinition.code = '" + processDefinitionCode + "'";
        }

        List<BpmProcessInstance> list1 = bpmProcessInstanceService.findByQuery(hql1);
        List<BpmProcessInstance> list2 = bpmProcessInstanceService.findByQuery(hql2);
//        //因为hql暂时没办法把两者合在一起，所以不能采用hql分页,把两者合并
//        list.addAll(list1);
//        list.addAll(list2);

        //去除重复记录
        Set<Long> norepeatHS = new HashSet<Long>();
        for (BpmProcessInstance bpmProcessInstance : list1) {
            if(!norepeatHS.contains(bpmProcessInstance.getId())){
                norepeatHS.add(bpmProcessInstance.getId());
                list.add(bpmProcessInstance);
            }
        }
        for (BpmProcessInstance bpmProcessInstance : list2) {
            if(!norepeatHS.contains(bpmProcessInstance.getId())){
                norepeatHS.add(bpmProcessInstance.getId());
                list.add(bpmProcessInstance);
            }
        }
        norepeatHS = null;

        try {
            Comparator mycmp = ComparableComparator.getInstance();
            //倒序
            mycmp = ComparatorUtils.reversedComparator(mycmp);
            ArrayList<Object> sortFields = new ArrayList<Object>();
            //按字段reportDate排序
            sortFields.add(new BeanComparator("id", mycmp));
            ComparatorChain multiSort = new ComparatorChain(sortFields);
            Collections.sort(list, multiSort);
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }

        return list;
    }

    /**
     * 获取已审记录
     * @param processDefinitionCode
     * @param userId
     * @param orderBy
     * @return
     */
    public String getHasAuditHql(String processDefinitionCode, Long userId,String orderBy) {
        //已审列表表示所有该用户参与过的流程
        String hql = "select distinct p " +
                "from BpmProcessInstance p,org.jbpm.taskmgmt.exe.TaskInstance t " +
                "where p.jbpmProcessInstanceId=t.processInstance.id " +
                "and t.end is not null and t.actorId=" + userId;
        if (!"all".equals(processDefinitionCode)) {
            hql += " and p.processDefinition.code = '" + processDefinitionCode + "'";
        }
        if(StringHelper.isEmpty(orderBy)){
            orderBy = " order by p.reportDate desc,p.id desc";
        }
        return (hql += orderBy);
    }
    public List<BpmProcessInstance> getHasAuditList(String processDefinitionCode, Long userId) {
       return bpmProcessInstanceService.findByQuery(getHasAuditHql(processDefinitionCode,userId,null));
    }


    public Map<String, String> getVariableMap(BpmProcessInstance bpmProcessInstance, String formName, String key, String expression) throws DocumentException {
        List<Map> varNames = new ArrayList<Map>();
        Map<String, String> varMap = new HashMap<String, String>();
        if (!StringHelper.isEmpty(expression)) {
            Set<String> varNameSet = SwimlaneManager.extractVarNames(expression);
            for (String varName : varNameSet) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("varName", varName);
                String varValue = bpmFormTemplateManager.getDataFromXml(bpmProcessInstance, formName, key);
                logger.debug("varValue is " + varValue);
                if (varValue == null) {
                    varValue = "";
                }
                map.put("varValue", varValue);
                varNames.add(map);
                varMap.put(varName, varValue);
            }
        }

        return varMap;
    }

    public BpmProcessInstance getBpmProcessInstance(Long jbpmProcessInstanceId) {
        String hql = "from BpmProcessInstance t where t.jbpmProcessInstanceId=?";
        return bpmProcessInstanceService.findUnique(hql, jbpmProcessInstanceId);
    }

    /**
     * 保存抄送用户ids
     *
     * @param bpmProcessInstance
     * @param ccUserIds
     */
    public void saveCcUserIds(BpmProcessInstance bpmProcessInstance, String ccUserIds) {
        if (StringUtils.isNotBlank(ccUserIds)) {
            bpmProcessInstance.setCcUserIds(ccUserIds);
            bpmProcessInstanceService.save(bpmProcessInstance);
        }
    }

    /**
     * 获取最后审核用户集合
     *
     * @param processInstance
     * @param bpmNodeDefinition
     * @return
     */
    public String[] getLastTimeUserIds(ProcessInstance processInstance, BpmNodeDefinition bpmNodeDefinition) {
        String nodeDefinition = bpmNodeDefinition.getNodeDefinition();
        TaskNodeDefinition taskNodeDefinition = null;
        try {
            taskNodeDefinition = JaxbUtil.unmarshall(TaskNodeDefinition.class, nodeDefinition);
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }

        String taskType = taskNodeDefinition.getTaskCreateType();
        //如果是会签节点不需要记住
        if (TaskNodeDefinition.MULTI_SYNC.equals(taskType)) {
            return null;
        }

        BpmProcessInstance bpmProcessInstance = getBpmProcessInstance(processInstance.getId());
        BpmTaskInstance bpmTaskInstance = getLatstTaskInstance(bpmProcessInstance, bpmNodeDefinition);
        if (bpmTaskInstance == null) {
            return null;
        }
        TaskInstance taskInstance = jbpmService.getTaskInstance(bpmTaskInstance.getJbpmTaskInstanceId());

        return new String[]{taskInstance.getActorId()};
    }

    /**
     * 获取最后一步
     *
     * @param bpmProcessInstance
     * @param bpmNodeDefinition
     * @return
     */
    public BpmTaskInstance getLatstTaskInstance(BpmProcessInstance bpmProcessInstance, BpmNodeDefinition bpmNodeDefinition) {
        String hql = "from BpmTaskInstance t where t.processInstance.id=" + bpmProcessInstance.getId() + " and t.taskDefinition=" + bpmNodeDefinition.getId() + " order by id desc";
        List<BpmTaskInstance> bpmTaskInstances = bpmTaskInstanceService.findByQuery(hql);
        if (bpmTaskInstances == null || bpmTaskInstances.size() == 0) {
            return null;
        }
        return bpmTaskInstances.iterator().next();
    }

    /**
     * 获取流程实例的所有附件
     *
     * @param bpmProcessInstance
     * @return
     */
    public List<DocDocumentAttach> getFileDocumentAttachs(BpmProcessInstance bpmProcessInstance) {
        List<DocDocumentAttach> documentAttaches = new ArrayList<DocDocumentAttach>();
        //表单操作
        Set<BpmFormAction> bpmFormActions = bpmProcessInstance.getBpmFormActions();
        for (BpmFormAction formAction : bpmFormActions) {
            DocDocument document = formAction.getDocument();
            if (document != null) {
                Set<DocDocumentAttach> attaches = document.getDocDocumentAttachs();
                documentAttaches.addAll(attaches);
            }
        }
        //标准操作
        Set<BpmStandardAction> bpmStandardActions = bpmProcessInstance.getBpmStandardActions();
        for (BpmStandardAction bpmStandardAction : bpmStandardActions) {
            DocDocument document = bpmStandardAction.getDocument();
            if (document != null) {
                Set<DocDocumentAttach> attaches = document.getDocDocumentAttachs();
                documentAttaches.addAll(attaches);
            }
        }
        return documentAttaches;
    }

    /**
     * 获取流程实例有效发布的附件
     *
     * @param bpmProcessInstance
     * @return
     */
    public List<DocDocumentAttach> getFileDocumentAttachsForPublic(BpmProcessInstance bpmProcessInstance) {
        List<DocDocumentAttach> list = new ArrayList<DocDocumentAttach>();
        List<DocDocumentAttach> documentAttaches = getFileDocumentAttachs(bpmProcessInstance);
        for (DocDocumentAttach attach : documentAttaches) {
            list.add(attach);
        }
        return list;
    }

    /**
     * 根据jbpm任务实例得到bpm任务实例
     * @param taskInstance .
     * @return .
     */
    public BpmTaskInstance getBpmTaskInstance(TaskInstance taskInstance) {
        System.out.println("..............taskInstance = " + taskInstance);
        String hql = "from BpmTaskInstance t where t.jbpmTaskInstanceId=" + taskInstance.getId() +" order by id desc";
        List<BpmTaskInstance> list = bpmTaskInstanceService.findByQuery(hql);
        if (list.size() >= 0) {
            return list.iterator().next();
        }
        return null;
    }

    /**
     * 获取一个流程实例的所有任务实例
     * @param bpmProcessInstanceId .
     * @return .
     */
    public List<BpmTaskInstance> getBpmTaskInstanceList(Long bpmProcessInstanceId) {
        String hql = "from BpmTaskInstance t where t.processInstance.id=" + bpmProcessInstanceId + " order by id asc";
        return bpmTaskInstanceService.findByQuery(hql);
    }


    /**
     * 创建系统任务--转发
     *
     * @param data    .
     * @param userIds .
     * @throws Exception .
     */
    public void createForwardTask(BpmTaskInstance data, String[] userIds) throws Exception {
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
}
