package com.justonetech.biz.manager.workflow;

import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.daoservice.BpmProcessInstanceService;
import com.justonetech.biz.daoservice.BpmTaskInstanceService;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.utils.JaxbUtil;
import com.justonetech.biz.utils.jbpm.node.TaskNodeDefinition;
import com.justonetech.biz.utils.jbpm.service.JbpmService;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 本类主要用于对流程定义进行检查，并给出建议，
 * 使定义流程者能更好的定义流程
 *
 * @version 1.0
 * @author: MaJi
 * @since: 2009-7-16
 */
@Service
public class BpmProcessCheckManager {

    @Autowired
    BpmProcessDefinitionManager bpmProcessDefinitionManager;


    @Autowired
    BpmProcessInstanceManager bpmProcessInstanceManager;


    @Autowired
    BpmTaskInstanceManager bpmTaskInstanceManager;


    @Autowired
    SysUserManager sysUserManager;

    @Autowired
    BpmTimeoutManager bpmTimeoutManager;

    @Autowired
    private JbpmService jbpmService;

    @Autowired
    private BpmTaskInstanceService bpmTaskInstanceService;

    @Autowired
    private BpmProcessInstanceService bpmProcessInstanceService;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 用来检查bpmProcessDefinition的数据完整性
     *
     * @param bpmProcessDefinition
     * @return
     */
    public List<Map> checkProcessDefinition(BpmProcessDefinition bpmProcessDefinition) {
        List<Map> errors = new ArrayList<Map>();
        //
        checkNodeDefinition(bpmProcessDefinition, errors);

        checkNodeSwimlane(bpmProcessDefinition, errors);

        checkProcessSwimlane(bpmProcessDefinition, errors);

        checkJbpmDeploy(bpmProcessDefinition, errors);

        return errors;
    }

    /**
     * 检查swimlane是否定义完整
     *
     * @param bpmProcessDefinition
     * @param errors
     */
    private void checkProcessSwimlane(BpmProcessDefinition bpmProcessDefinition, List<Map> errors) {
        Set<BpmProcessSwimlane> swimlanes = bpmProcessDefinition.getBpmProcessSwimlanes();
        for (BpmProcessSwimlane swimlane : swimlanes) {
            //如果泳道为空
            if (swimlane.getSwimlaneDefinition() == null && swimlane.getSwimlane() == null) {
                Map<String, String> map = getErrorMap(swimlane);
                errors.add(map);
            }
        }
    }


    /**
     * 检查jBPM发布的结果，是否有业务记录与jBPM的关联不完整
     *
     * @param bpmProcessDefinition
     * @param errors
     */
    private void checkJbpmDeploy(BpmProcessDefinition bpmProcessDefinition, List<Map> errors) {
        if (bpmProcessDefinition.getJbpmDefinitionId() != null) {
            Set<BpmNodeDefinition> set = bpmProcessDefinition.getBpmNodeDefinitions();
            for (BpmNodeDefinition bpmNodeDefinition : set) {
                if (bpmNodeDefinition.getJbpmNodeId() == null) {
                    Map<String, String> map = getErrorMap(bpmNodeDefinition, "节点jBPM ID不能为空！");
                    errors.add(map);
                }
            }

            Set<BpmProcessTransition> processTransitionSet = bpmProcessDefinition.getBpmProcessTransitions();
            for (BpmProcessTransition bpmProcessTransition : processTransitionSet) {
                if (bpmProcessTransition.getJbpmTransitionId() == null) {
                    Map<String, String> map = getErrorMap(bpmProcessTransition);
                    errors.add(map);
                }
            }
        }
    }

    /**
     * 检查是否有节点的定义没有定义
     *
     * @param bpmProcessDefinition
     * @param errors
     */
    private void checkNodeDefinition(BpmProcessDefinition bpmProcessDefinition, List<Map> errors) {
        Set<BpmNodeDefinition> bpmNodeDefinitions = bpmProcessDefinition.getBpmNodeDefinitions();
        for (BpmNodeDefinition bpmNodeDefinition : bpmNodeDefinitions) {
            //start,process,decision需要检查
            boolean isRequireCheckNode = (bpmNodeDefinition.getNodeType().equals("C")
                    || bpmNodeDefinition.getNodeType().equals("D"));
            if (isRequireCheckNode && bpmNodeDefinition.getNodeDefinition() == null) {
                Map<String, String> map = getErrorMap(bpmNodeDefinition, "节点定义不能为空！");
                errors.add(map);
            }

            //判断节点的泳道是否有人
            String[] userIds = new String[0];
            try {
                userIds = ProcessDataManager.getUserIds(bpmNodeDefinition);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (userIds == null || userIds.length == 0) {
                if (!"结束".equals(bpmNodeDefinition.getName())) {
                    Map<String, String> map = getErrorMap(bpmNodeDefinition, "节点泳道定义下没有人员或是设置了变量！");
                    errors.add(map);
                }
            }
        }
    }

    /**
     * 检查节点的泳道定义
     *
     * @param bpmProcessDefinition
     * @param errors
     */
    private void checkNodeSwimlane(BpmProcessDefinition bpmProcessDefinition, List<Map> errors) {
        Set<BpmNodeDefinition> bpmNodeDefinitions = bpmProcessDefinition.getBpmNodeDefinitions();
        for (BpmNodeDefinition bpmNodeDefinition : bpmNodeDefinitions) {
            //判断start,taskNode的swimlane是否已定义(是否ProcessSwimlane和SwimlaneDefinition是否都为空)
            if (bpmNodeDefinition.getNodeType().equals("R")
                    || bpmNodeDefinition.getNodeType().equals("C")) {
                BpmTaskSwimlane taskSwimlane = bpmNodeDefinition.getBpmTaskSwimlane();
                if (taskSwimlane == null) {
                    Map<String, String> map = getErrorMap(bpmNodeDefinition, "泳道不能为空！");
                    errors.add(map);
                } else {//taskSwimlanes.size() == 1
                    if (taskSwimlane.getProcessSwimlane() == null && taskSwimlane.getSwimlaneDefinition() == null) {
                        Map<String, String> map = getErrorMap(bpmNodeDefinition, "泳道不能为空！");
                        errors.add(map);
                    }
                }
            }
        }
    }

    private Map<String, String> getErrorMap(BpmNodeDefinition bpmNodeDefinition, String info) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", String.valueOf(bpmNodeDefinition.getId()));
        map.put("name", bpmNodeDefinition.getName());
        map.put("info", info);
        return map;
    }

    private Map<String, String> getErrorMap(BpmProcessSwimlane swimlane) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", String.valueOf(swimlane.getId()));
        map.put("name", swimlane.getName());
        map.put("info", "流程泳道不能为空");
        return map;
    }

    private Map<String, String> getErrorMap(BpmProcessTransition bpmProcessTransition) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", String.valueOf(bpmProcessTransition.getId()));
        map.put("name", bpmProcessTransition.getName());
        map.put("info", "流程的边jBPM ID不能为空!");
        return map;
    }


    public List autoFlowJBPM(String processDefinitionCode, Map<String, String> mapRecord, List<String> mapPath) throws Exception {
        List<String> errors = new ArrayList<String>();

        BpmProcessDefinition definition = bpmProcessDefinitionManager.getBpmProcessDefinition(processDefinitionCode);

        String[] startProcessInstanceActorIds = bpmProcessInstanceManager.getStartProcessInstanceActorIds(definition);

        SysUser startUser = sysUserService.get(Long.valueOf(startProcessInstanceActorIds[0]));
        mapPath.add("开始" + "(" + startUser.getDisplayName() + ")");

        BpmTaskInstance firstBpmTaskInstance = null;
        BpmProcessInstance bpmProcessInstance = null;
        if (definition != null) {
            try {
                bpmProcessInstance = bpmProcessInstanceManager.startBpmProcessInstance(definition, startUser);
                firstBpmTaskInstance = bpmTaskInstanceManager.getBpmTaskInstance(bpmProcessInstance, startProcessInstanceActorIds[0]);
                if (firstBpmTaskInstance == null) {
                    log.error("创建失败，流程定义配置有误,bpmTaskInstance为空！");
                    errors.add("创建失败，流程定义配置有误,bpmTaskInstance为空！");
                }

            } catch (Exception e) {
                log.error("error", e);
                log.error(e.getCause().getMessage());
            }
        } else {
            log.error("创建失败，未找到有效流程");
            errors.add("创建失败，未找到有效流程");
        }

        // 根据bpmTaskInstance取对应模板
        BpmFormTemplate bpmFormTemplate = bpmTaskInstanceManager.getBpmFormTemplate(firstBpmTaskInstance);

        //todo 判断是否第1步，如果第1步不允许采用标准操作方式，必须设置为表单模板方式
        BpmNodeDefinition nodeDefinition = firstBpmTaskInstance.getTaskDefinition();
        boolean firstTaskNode = bpmProcessInstanceManager.isFirstTaskNode(nodeDefinition);
        if (firstTaskNode && bpmFormTemplate == null) {
            log.error("未找到表单模板！请检查是否设置模板或者第1步操作不允许设置为标准操作！");
            errors.add("未找到表单模板！请检查是否设置模板或者第1步操作不允许设置为标准操作！");
        }

        boolean isSelectUser = false;
        int j = 0;
        while (true) {
            if ((j++) > 30) {
                log.warn("流程操作步骤越过30步，请检查，可能是程序死循环错误，或步骤确实过多！");
                break;
            }
            List<TaskInstance> taskInstances = jbpmService.getUnfinishedTaskInstances(bpmProcessInstance.getJbpmProcessInstanceId());
            if (taskInstances.size() == 0) {
                break;
            } else {
                List<String> currentActorIds = bpmProcessInstanceManager.getCurrentActorIds(bpmProcessInstance);

                if (currentActorIds.size() == 0 && !isSelectUser) {
                    log.error("下一步审核人员不能为空");
                    errors.add("下一步审核人员不能为空");
                }

                for (int i = 0; i < taskInstances.size(); i++) {
                    TaskInstance taskInstance = taskInstances.get(i);
                    log.info("................" + taskInstance.getTask().getName());

                    BpmTaskInstance bpmTaskInstance = bpmTaskInstanceService.findUnique("from BpmTaskInstance where jbpmTaskInstanceId=" + taskInstance.getId());
                    processBpmTask(bpmTaskInstance);
                    Set<BpmProcessTransition> processTransitionSet = bpmTaskInstance.getTaskDefinition().getBpmProcessTransitionsByfrom();

                    BpmProcessTransition nextTransition = getNextStep(processDefinitionCode, processTransitionSet, mapRecord, mapPath);
                    mapPath.add(taskInstance.getName() + "(" + sysUserService.get(Long.valueOf(currentActorIds.get(i))).getDisplayName() + ")");
                    if (nextTransition != null) {
                        log.info("下一步节点：" + nextTransition.getName());
                        mapPath.add(nextTransition.getName());
                        isSelectUser = bpmTaskInstanceManager.getIsSelectUser(nextTransition.getTo());
                        bpmTaskInstanceManager.endTaskInstance(bpmTaskInstance, currentActorIds.get(i), nextTransition);
                    } else {
                        errors.add("下一步节点为空！");
                        return errors;
                    }
                }
            }
        }
        return errors;
    }

    public BpmProcessTransition getNextStep(String processDefinitionCode, Set<BpmProcessTransition> processTransitionSet,
                                            Map mapRecord, List mapPath) throws Exception {
        int size = processTransitionSet.size();
        if (size == 0) {
            return null;
        } else if (size == 1) {
            if (!processTransitionSet.iterator().next().getName().contains("退回")) {
                return processTransitionSet.iterator().next();
            }
            log.warn("下一步，只有退回可能会出现死循环！");
        } else {
            Iterator<BpmProcessTransition> transitionIterator = processTransitionSet.iterator();

            BpmProcessTransition bpmProcessTransition;
            List<BpmProcessTransition> notExecTransitionList = new ArrayList<BpmProcessTransition>();
            List<BpmProcessTransition> execTransitionList = new ArrayList<BpmProcessTransition>();
            while (transitionIterator.hasNext()) {
                bpmProcessTransition = transitionIterator.next();
                if (!mapRecord.containsKey(bpmProcessTransition.getId())) {
                    if (bpmProcessTransition.getName().contains("退回")) {
                        mapRecord.put(bpmProcessTransition.getId(), null);
                        return bpmProcessTransition;
                    } else {
                        notExecTransitionList.add(bpmProcessTransition);
                    }
                } else {
                    execTransitionList.add(bpmProcessTransition);
                }
            }
            if (notExecTransitionList.size() == 0) {
                for (int i = 0; i < execTransitionList.size(); i++) {
                    BpmProcessTransition processTransition = execTransitionList.get(i);
                    if (!processTransition.getName().contains("退回")) {
                        return processTransition;
                    }
                }
            } else if (notExecTransitionList.size() > 0) {
                mapRecord.put(notExecTransitionList.get(0).getId(), null);
                if (notExecTransitionList.size() > 1) {
                    autoFlowJBPM(processDefinitionCode, mapRecord, mapPath);
                }
                return notExecTransitionList.get(0);
            }
        }
        return null;
    }

    public void processBpmTask(BpmTaskInstance taskInstance) throws Exception {
        BpmNodeDefinition nodeDefinition = taskInstance.getTaskDefinition();
        if (!StringHelper.isEmpty(nodeDefinition.getNodeDefinition())) {
            TaskNodeDefinition taskNodeDefinition = JaxbUtil.unmarshall(TaskNodeDefinition.class, nodeDefinition.getNodeDefinition());
            //超时处理
            if (bpmTaskInstanceManager.isNodeTimeout(taskNodeDefinition, taskInstance)) {
                if ("2".equals(taskNodeDefinition.getOperateType())) {   //标准操作
                    bpmTimeoutManager.standardSave(taskInstance, taskNodeDefinition);
                } else {
                    bpmTimeoutManager.formSave(taskInstance, taskNodeDefinition);            //表单操作
                }
            }
        }
    }

    private static final Log log = LogFactory.getLog(BpmProcessCheckManager.class);
}
