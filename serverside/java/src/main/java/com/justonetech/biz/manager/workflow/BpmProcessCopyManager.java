package com.justonetech.biz.manager.workflow;

import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Ma Ji
 * @version 1.0
 * @since <pre>2010-5-19</pre>
 */
@Service
public class BpmProcessCopyManager {
    private static final Log log = LogFactory.getLog(BpmProcessCopyManager.class);

    @Autowired
    private BpmProcessDefinitionService bpmProcessDefinitionService;

    @Autowired
    private BpmProcessTransitionService bpmProcessTransitionService;

    @Autowired
    private BpmProcessDefinitionFormService bpmProcessDefinitionFormService;

    @Autowired
    private BpmNodeDefinitionService bpmNodeDefinitionService;

    @Autowired
    private BpmProcessSwimlaneService bpmProcessSwimlaneService;

    @Autowired
    private BpmTaskSwimlaneService bpmTaskSwimlaneService;

    @Autowired
    private BpmSwimlaneService bpmSwimlaneService;

    @Autowired
    private BpmSwimlaneManager bpmSwimlaneManager;

    /**
     * 流程版本升级
     * setp:
     * 1.copy process definition
     * 2.copy process definition form
     * 3.copy process swimlane
     * 4.copy node definition
     * 5.copy task swimlane
     * 6.set new process definition version
     * 7.set new process definition enabled
     * 8.return new process definition
     *
     * @param bpmProcessDefinition
     * @return
     */
    public BpmProcessDefinition upgradeProcessDefinition(BpmProcessDefinition bpmProcessDefinition) {
        //set old process definition valid
        bpmProcessDefinition.setIsValid(false);
        bpmProcessDefinitionService.save(bpmProcessDefinition);

        //copy process definition
        BpmProcessDefinition targetProcess = copyProcessDefinition(bpmProcessDefinition);

        //copy process definition form
        copyProcessDefinitionForm(bpmProcessDefinition, targetProcess);

        //copy process swimlane
        copyProcessSwimlane(bpmProcessDefinition, targetProcess);

        //copy node definition
        Map<Long, BpmNodeDefinition> nodeDefinitionMap = copyNodeDefinition(bpmProcessDefinition, targetProcess);

        //copy process definition transition
        copyProcessTransition(bpmProcessDefinition, targetProcess, nodeDefinitionMap);

        //set process definition version
        targetProcess.setVersion(bpmProcessDefinition.getVersion() + 1);

        targetProcess.setIsValid(true);

        return targetProcess;
    }

    /**
     * 从另一个项目导入流程定义
     *
     * @param bpmProcessDefinition
     * @return
     */
    public BpmProcessDefinition importProcessDefinition(BpmProcessDefinition bpmProcessDefinition) {

        //copy process definition
        BpmProcessDefinition targetProcess = copyProcessDefinition(bpmProcessDefinition);

        //copy process definition form
        copyProcessDefinitionForm(bpmProcessDefinition, targetProcess);

        //copy process swimlane
        copyProcessSwimlane(bpmProcessDefinition, targetProcess);

        //copy node definition
        Map<Long, BpmNodeDefinition> nodeDefinitionMap = copyNodeDefinition(bpmProcessDefinition, targetProcess);

        //copy process definition transition
        copyProcessTransition(bpmProcessDefinition, targetProcess, nodeDefinitionMap);

        //set process definition version
        targetProcess.setVersion(1);

        targetProcess.setIsValid(true);

        return targetProcess;
    }

    /**
     * @param bpmProcessDefinition
     * @param targetProcess
     * @param nodeDefinitionMap
     */
    private void copyProcessTransition(BpmProcessDefinition bpmProcessDefinition, BpmProcessDefinition targetProcess, Map<Long, BpmNodeDefinition> nodeDefinitionMap) {
        Set<BpmProcessTransition> processTransitions = bpmProcessDefinition.getBpmProcessTransitions();
        for (BpmProcessTransition processTransition : processTransitions) {
            BpmProcessTransition targetProcessTransition = new BpmProcessTransition();
            String[] exceptNodeProperties = {
                    "id",
                    "jbpmTransitionId"
            };
            BeanUtils.copyProperties(processTransition, targetProcessTransition, exceptNodeProperties);
            targetProcessTransition.setProcessDefinition(targetProcess);
            targetProcessTransition.setFrom(nodeDefinitionMap.get(processTransition.getFrom().getId()));
            targetProcessTransition.setTo(nodeDefinitionMap.get(processTransition.getTo().getId()));
            bpmProcessTransitionService.save(targetProcessTransition);
        }
    }

    /**
     * @param bpmProcessDefinition
     * @param targetProcess
     * @return
     */
    private Map<Long, BpmNodeDefinition> copyNodeDefinition(BpmProcessDefinition bpmProcessDefinition, BpmProcessDefinition targetProcess) {
        Map<Long, BpmNodeDefinition> nodeDefinitionMap = new HashMap<Long, BpmNodeDefinition>();
        Set<BpmNodeDefinition> bpmNodeDefinitions = bpmProcessDefinition.getBpmNodeDefinitions();
        for (BpmNodeDefinition bpmNodeDefinition : bpmNodeDefinitions) {
            BpmNodeDefinition targetNode = new BpmNodeDefinition();
            String[] exceptNodeProperties = {
                    "id",
                    "jbpmNodeId",
                    "bpmTaskInstances",
                    "bpmProcessTransitionsByfrom",
                    "bpmProcessTransitionsByto",
                    "bpmTaskSwimlanes"
            };
            BeanUtils.copyProperties(bpmNodeDefinition, targetNode, exceptNodeProperties);
            targetNode.setProcessDefinition(targetProcess);
            bpmNodeDefinitionService.save(targetNode);

            nodeDefinitionMap.put(bpmNodeDefinition.getId(), targetNode);

            //copy task swimlane
            BpmTaskSwimlane taskSwimlane = bpmNodeDefinition.getBpmTaskSwimlane();
            if (taskSwimlane != null) {
                BpmTaskSwimlane targetTaskSwimlane = new BpmTaskSwimlane();
                String[] exceptTaskSwimlaneProperties = {
                        "id"
                };
                BeanUtils.copyProperties(taskSwimlane, targetTaskSwimlane, exceptTaskSwimlaneProperties);
                targetTaskSwimlane.setTask(targetNode);
                bpmTaskSwimlaneService.save(targetTaskSwimlane);
            }
        }
        return nodeDefinitionMap;
    }

    /**
     * @param bpmProcessDefinition
     * @param targetProcess
     */
    private void copyProcessSwimlane(BpmProcessDefinition bpmProcessDefinition, BpmProcessDefinition targetProcess) {
        //准备数据，找出所有当前项目的泳道压入HashMap<泳道名称，泳道对象>中，用于重复泳道不导入
        List<BpmSwimlane> currentSwimlanes = bpmSwimlaneService.findAll();
        HashMap<String, BpmSwimlane> currentSwimlaneHM = new HashMap<String, BpmSwimlane>();
        for (BpmSwimlane currentSwimlane : currentSwimlanes) {
            currentSwimlaneHM.put(currentSwimlane.getName(), currentSwimlane);
        }

        //复制流程泳道
        Set<BpmProcessSwimlane> processSwimlanes = bpmProcessDefinition.getBpmProcessSwimlanes();
        for (BpmProcessSwimlane processSwimlane : processSwimlanes) {

            //先导入项目泳道
            BpmSwimlane fromSwimlane = processSwimlane.getSwimlane();
            BpmSwimlane newSwimlane = bpmSwimlaneManager.importBpmSwimlane(fromSwimlane, currentSwimlaneHM);

            //再导入流程泳道
            BpmProcessSwimlane targetProcessSwimlane = new BpmProcessSwimlane();
            String[] exceptProcessSwimlaneProperties = {
                    "id",
//                    "name",
                    "shapeId",
//                    "swimlaneDefinition",
                    "bpmTaskSwimlanes"
            };
            BeanUtils.copyProperties(processSwimlane, targetProcessSwimlane, exceptProcessSwimlaneProperties);
            targetProcessSwimlane.setProcessDefinition(targetProcess);
            targetProcessSwimlane.setSwimlane(newSwimlane);
            targetProcessSwimlane.setName(processSwimlane.getName());
            targetProcessSwimlane.setSwimlaneDefinition(processSwimlane.getSwimlaneDefinition());

            bpmProcessSwimlaneService.save(targetProcessSwimlane);

        }
    }

    /**
     * @param bpmProcessDefinition
     * @param targetProcess
     */
    private void copyProcessDefinitionForm(BpmProcessDefinition bpmProcessDefinition, BpmProcessDefinition targetProcess) {
        Set<BpmProcessDefinitionForm> bpmProcessDefinitionForms = bpmProcessDefinition.getBpmProcessDefinitionForms();
        for (BpmProcessDefinitionForm bpmProcessDefinitionForm : bpmProcessDefinitionForms) {
            BpmFormTemplate template = bpmProcessDefinitionForm.getFormTemplate();
            BpmProcessDefinitionForm definitionForm = new BpmProcessDefinitionForm();
            definitionForm.setFormTemplate(template);
            definitionForm.setProcessDefinition(targetProcess);
            bpmProcessDefinitionFormService.save(definitionForm);
        }
    }

    /**
     * @param bpmProcessDefinition
     * @return
     */
    private BpmProcessDefinition copyProcessDefinition(BpmProcessDefinition bpmProcessDefinition) {
        BpmProcessDefinition targetProcess = new BpmProcessDefinition();
        String[] exceptProcessProperties = {
                "id",
                "jbpmDefinitionId",
                "bpmNodeDefinitions",
                "bpmProcessDefinitionForms",
                "bpmProcessInstances",
                "bpmProcessTransitions",
                "bpmProcessSwimlanes"
        };
        BeanUtils.copyProperties(bpmProcessDefinition, targetProcess, exceptProcessProperties);
        targetProcess.setCreateTime(new Timestamp(System.currentTimeMillis()));
        targetProcess.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        bpmProcessDefinitionService.save(targetProcess);

        return targetProcess;
    }

}