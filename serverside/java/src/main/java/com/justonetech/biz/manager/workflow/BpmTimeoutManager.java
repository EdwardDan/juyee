package com.justonetech.biz.manager.workflow;

import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.daoservice.BpmFormActionService;
import com.justonetech.biz.daoservice.BpmProcessTransitionService;
import com.justonetech.biz.daoservice.BpmStandardActionService;
import com.justonetech.biz.daoservice.BpmTaskInstanceService;
import com.justonetech.biz.domain.BpmNodeDefinition;
import com.justonetech.biz.domain.BpmProcessTransition;
import com.justonetech.biz.domain.BpmStandardAction;
import com.justonetech.biz.domain.BpmTaskInstance;
import com.justonetech.biz.manager.SysWorkCalendarManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.JaxbUtil;
import com.justonetech.biz.utils.jbpm.node.TaskNodeDefinition;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * author: Chen Junping
 * Date: 2009-12-1
 */
@Service
public class BpmTimeoutManager {
    private Logger logger = LoggerFactory.getLogger(BpmTimeoutManager.class);

    @Autowired
    private BpmTaskInstanceService bpmTaskInstanceService;

    @Autowired
    private BpmTaskInstanceManager bpmTaskInstanceManager;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private BpmStandardActionService bpmStandardActionService;

    @Autowired
    private BpmFormActionService bpmFormActionService;

    @Autowired
    private BpmProcessTransitionService bpmProcessTransitionService;

    @Autowired
    private BpmProcessInstanceManager bpmProcessInstanceManager;

    @Autowired
    private SysWorkCalendarManager sysWorkCalendarManager;

    public void scan() throws Exception {
        logger.debug("....................Workflow Scan Timeout Task:" + DateTimeHelper.formatTimestamp(new Timestamp(System.currentTimeMillis()), "HH:MM:SS"));
        scanTaskInstance();
//        BpmTaskInstance taskInstance = bpmTaskInstanceService.get(1761L);
//        BpmNodeDefinition nodeDefinition = taskInstance.getTaskDefinition();
//        if (!StringHelper.isEmpty(nodeDefinition.getNodeDefinition())) {
//            TaskNodeDefinition taskNodeDefinition = JaxbUtil.unmarshall(TaskNodeDefinition.class, nodeDefinition.getNodeDefinition());
//            formSave(taskInstance,taskNodeDefinition);
//        }
    }

    public void scanTaskInstance() throws Exception {
//        logger.debug("....................Workflow Scan Timeout Task:" + DateTimeHelp.formatTimestamp(new Timestamp(System.currentTimeMillis()), "HH:MM:SS"));

        String hql = "from BpmTaskInstance t where t.processInstance.status={0} and t.processInstance.processDefinition.isValid={1}";  //有效流程定义
        hql += " and instr(t.taskDefinition.nodeDefinition,'timeOutAction=\"1\"')>0";      //继续执行
        hql += " and instr(t.taskDefinition.nodeDefinition,'defaultTransitionName=\"')>0"; //有默认分支
        hql += " and t.endTime is null";
        hql = FormatUtils.format(hql, Constants.BPM_STATUS_RUN, Constants.FLAG_TRUE);
        List<BpmTaskInstance> taskInstanceList = bpmTaskInstanceService.findByQuery(hql);
        for (BpmTaskInstance taskInstance : taskInstanceList) {
            BpmNodeDefinition nodeDefinition = taskInstance.getTaskDefinition();
            if (!StringHelper.isEmpty(nodeDefinition.getNodeDefinition())) {
                TaskNodeDefinition taskNodeDefinition = JaxbUtil.unmarshall(TaskNodeDefinition.class, nodeDefinition.getNodeDefinition());
                //超时处理
                if (bpmTaskInstanceManager.isNodeTimeout(taskNodeDefinition, taskInstance)) {
                    if ("2".equals(taskNodeDefinition.getOperateType())) {   //标准操作
                        standardSave(taskInstance, taskNodeDefinition);
                    } else {
                        formSave(taskInstance, taskNodeDefinition);            //表单操作
                    }
                }
            }
        }
        logger.debug("......................hql=" + hql);
        logger.debug("..............size=" + taskInstanceList.size());
    }

    /**
     * 标准操作---超时处理
     *
     * @param bpmTaskInstance
     */
    public void standardSave(BpmTaskInstance bpmTaskInstance, TaskNodeDefinition taskNodeDefinition) throws Exception {

        SysUser submitUser = sysUserManager.getAdminUser();

        BpmStandardAction data = new BpmStandardAction();
        data.setProcessInstance(bpmTaskInstance.getProcessInstance());
        data.setTaskInstance(bpmTaskInstance);
        data.setIsRead(false);
        data.setPermitValue(Constants.FLAG_TRUE);
        data.setOpinion("通过(超时)");
        data.setSubmitUser(submitUser);                                 //默认为系统管理员
        data.setSubmitTime(new Timestamp(System.currentTimeMillis()));  //默认为当前时间
        bpmStandardActionService.save(data);

        //获取下层节点任务
        String defaultTransitionId = taskNodeDefinition.getDefaultTransitionName();
        BpmProcessTransition bpmProcessTransition = null;
        if (!StringHelper.isEmpty(defaultTransitionId)) {
            bpmProcessTransition = bpmProcessTransitionService.get(Long.valueOf(defaultTransitionId));
        }

        //结束任务实例
        bpmTaskInstanceManager.endTaskInstance(bpmTaskInstance, String.valueOf(submitUser.getId()), bpmProcessTransition);
    }

    /**
     * 表单操作---超时处理
     *
     * @param bpmTaskInstance
     */
    public void formSave(BpmTaskInstance bpmTaskInstance, TaskNodeDefinition taskNodeDefinition) throws Exception {
        SysUser submitUser = sysUserManager.getAdminUser();
        String xmlData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><bizdata></bizdata>";
        bpmProcessInstanceManager.saveAndSubmit(xmlData, bpmTaskInstance, submitUser, null);

        //获取下层节点任务
        String defaultTransitionId = taskNodeDefinition.getDefaultTransitionName();
        BpmProcessTransition bpmProcessTransition = null;
        if (!StringHelper.isEmpty(defaultTransitionId)) {
            bpmProcessTransition = bpmProcessTransitionService.get(Long.valueOf(defaultTransitionId));
        }

        //结束任务实例
        bpmTaskInstanceManager.endTaskInstance(bpmTaskInstance, String.valueOf(submitUser.getId()), bpmProcessTransition);
    }
}
