package com.justonetech.biz.controller.workflow;

import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.Candidate;
import com.justonetech.biz.manager.SwimlaneManager;
import com.justonetech.biz.manager.workflow.BpmProcessDefinitionManager;
import com.justonetech.biz.manager.workflow.BpmSwimlaneManager;
import com.justonetech.biz.utils.CollectionUtils;
import com.justonetech.biz.utils.JaxbUtil;
import com.justonetech.biz.utils.jbpm.node.DecisionDefinition;
import com.justonetech.biz.utils.jbpm.node.TaskNodeDefinition;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysCodeDetailService;
import com.justonetech.system.domain.SysPerson;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.tree.ZTreeBranch;
import com.justonetech.system.tree.ZTreeNode;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.*;


/**
 * note:任务节点定义表
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class BpmNodeDefinitionController extends BaseCRUDActionController<BpmNodeDefinition> {
    private Logger logger = LoggerFactory.getLogger(BpmNodeDefinitionController.class);

    @Autowired
    private BpmSwimlaneService bpmSwimlaneService;

    @Autowired
    private BpmTaskSwimlaneService bpmTaskSwimlaneService;

    @Autowired
    private BpmProcessSwimlaneService bpmProcessSwimlaneService;

    @Autowired
    private BpmNodeDefinitionService bpmNodeDefinitionService;

    @Autowired
    private BpmProcessDefinitionManager bpmProcessDefinitionManager;

    @Autowired
    private BpmSwimlaneDefinitionService bpmSwimlaneDefinitionService;

    @Autowired
    private SysCodeDetailService sysCodeDetailService;

    @Autowired
    private BpmSwimlaneManager bpmSwimlaneManager;

    @Autowired
    private SysUserManager sysUserManager;

    @RequestMapping
    public String processSwimlaneDefinition(@RequestParam Long id, @RequestParam Long shapeId, Model model) throws JAXBException, IOException {
        List<BpmSwimlane> swimlanes = bpmSwimlaneService.findAll();
        String hql = "from BpmProcessSwimlane t where t.processDefinition.id=" + id + " and t.shapeId=" + shapeId;
        BpmProcessSwimlane bpmProcessSwimlane = bpmProcessSwimlaneService.findUnique(hql);
        BpmSwimlane projectSwimlane = null;
        String swimlaneType;
        if (bpmProcessSwimlane.getSwimlaneDefinition() != null) {
            swimlaneType = TaskNodeDefinition.SWIMLANE_TYPE_PROCESS;
        } else {
            swimlaneType = TaskNodeDefinition.SWIMLANE_TYPE_GLOBAL;
            projectSwimlane = bpmProcessSwimlane.getSwimlane();
        }

        model.addAttribute("bean", bpmProcessSwimlane);
        model.addAttribute("swimlaneType", swimlaneType);
        model.addAttribute("projectSwimlane", projectSwimlane);
        model.addAttribute("swimlanes", swimlanes);
        return "view/workflow/bpmNodeDefinition/processSwimlaneDefinition";
    }

    @RequestMapping
    public void saveProcessSwimlane(@RequestParam Long id,
                                    @RequestParam String swimlaneType,
                                    Long projectSwimlaneId,
                                    @RequestParam Long groupId,
                                    @RequestParam Long positionTypeId,
                                    @RequestParam String expression,
                                    HttpServletResponse response,
                                    Model model) throws Exception, IOException {
        BpmProcessSwimlane target;

        target = bpmProcessSwimlaneService.get(id);
//        System.out.println("swimlaneType = " + swimlaneType);
        if (swimlaneType.equals(TaskNodeDefinition.SWIMLANE_TYPE_GLOBAL) && projectSwimlaneId != null) {
            target.setSwimlane(bpmSwimlaneService.get(projectSwimlaneId));
            target.setSwimlaneDefinition(null);
        } else if (swimlaneType.equals(TaskNodeDefinition.SWIMLANE_TYPE_PROCESS)) {
            target.setSwimlane(null);
            BpmSwimlaneDefinition definition;
            definition = target.getSwimlaneDefinition();
            if (definition == null) {
                definition = new BpmSwimlaneDefinition();
            }
            definition.setGroup(sysCodeDetailService.get(groupId));
            definition.setPositionType(sysCodeDetailService.get(positionTypeId));
            definition.setExpression(expression);
            bpmSwimlaneDefinitionService.save(definition);
            target.setSwimlaneDefinition(definition);
        }
        bpmProcessSwimlaneService.save(target);
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 查看人员
     */
    @RequestMapping
    public String processSwimlanePerson(HttpServletRequest request, @RequestParam Long id, Model model) throws Exception {
        BpmProcessSwimlane bpmProcessSwimlane = bpmProcessSwimlaneService.get(id);
        BpmSwimlane swimlane = bpmProcessSwimlane.getSwimlane();
        BpmSwimlaneDefinition definition;// = swimlane.getSwimlaneDefinition();
        if (swimlane == null) {
            definition = bpmProcessSwimlane.getSwimlaneDefinition();
        } else {
            definition = swimlane.getSwimlaneDefinition();
        }
        String expression = (definition == null ? null : definition.getExpression());

        List<Map> varNames = new ArrayList<Map>();
        Map<String, String> varMap = new HashMap<String, String>();
        if (!StringHelper.isEmpty(expression)) {
            Set<String> varNameSet = SwimlaneManager.extractVarNames(expression);
            for (String varName : varNameSet) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("varName", varName);
                String varValue = request.getParameter(varName);
                logger.debug("varValue is " + varValue);
                if (varValue == null) {
                    varValue = "";
                }
                map.put("varValue", varValue);
                varNames.add(map);
                varMap.put(varName, varValue);
            }
        }

//        System.out.println("......................varMap.size() = " + varMap.size());
//        Set<Map.Entry<String, String>> entries = varMap.entrySet();
//        for (Map.Entry<String, String> entry : entries) {
//            System.out.print("-------------entry.getKey() = " + entry.getKey());
//            System.out.println("   entry.getValue() = " + entry.getValue());
//        }

        //get person
        List<Map> persons = new ArrayList<Map>();
        List<Candidate> canditates = bpmSwimlaneManager.getCandidates(definition, varMap);
        for (Candidate canditate : canditates) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("group", canditate.getBpmProjectGroup().getName());
            map.put("duty", canditate.getBpmProjectGroupDuty().getName());
            map.put("person", canditate.getSysPerson().getName());
            persons.add(map);
        }

        model.addAttribute("varNames", varNames);
        model.addAttribute("persons", persons);
        model.addAttribute("bean", bpmProcessSwimlane);
        return "view/workflow/bpmNodeDefinition/processSwimlanePerson";
    }

    /**
     * 人员设置
     *
     * @param id    .
     * @param model .
     * @throws Exception
     */
    @RequestMapping
    public String personLimit(@RequestParam Long id, Model model) throws Exception {
        BpmNodeDefinition bpmNodeDefinition = bpmNodeDefinitionService.get(id);

        BpmTaskSwimlane taskSwimlane = bpmNodeDefinition.getBpmTaskSwimlane();
        String swimlaneType;
        BpmProcessSwimlane processSwimlane = null;
        BpmSwimlaneDefinition definition = null;
        if (taskSwimlane.getProcessSwimlane() != null) {
            processSwimlane = taskSwimlane.getProcessSwimlane();
            swimlaneType = TaskNodeDefinition.SWIMLANE_TYPE_PROCESS;
        } else {
            definition = taskSwimlane.getSwimlaneDefinition();
            swimlaneType = TaskNodeDefinition.SWIMLANE_TYPE_TASK;
        }

        String hql = "from BpmProcessSwimlane t where t.processDefinition.id=" + bpmNodeDefinition.getProcessDefinition().getId();
        List<BpmProcessSwimlane> swimlanes = bpmProcessSwimlaneService.findByQuery(hql);

        model.addAttribute("bean", taskSwimlane);
        model.addAttribute("processSwimlane", processSwimlane);
        model.addAttribute("swimlanes", swimlanes);
        model.addAttribute("swimlaneType", swimlaneType);
        return "view/workflow/bpmNodeDefinition/personLimit";
    }

    /**
     * 保存人员设置
     *
     * @param id                .
     * @param swimlameType      .
     * @param processSwimlaneId .
     * @param definitionId      .
     * @param groupId           .
     * @param positionTypeId    .
     * @param expression        .
     * @param model             .
     * @throws Exception
     */
    @RequestMapping
    public void savePersonLimit(@RequestParam Long id,
                                @RequestParam String swimlameType,
                                @RequestParam Long processSwimlaneId,
                                @RequestParam Long definitionId,
                                @RequestParam Long groupId,
                                @RequestParam Long positionTypeId,
                                @RequestParam String expression,
                                HttpServletResponse response,
                                Model model) throws Exception {
        BpmTaskSwimlane target = bpmTaskSwimlaneService.get(id);
        if (swimlameType.equals(TaskNodeDefinition.SWIMLANE_TYPE_PROCESS)) {
            target.setSwimlaneDefinition(null);
            target.setProcessSwimlane(bpmProcessSwimlaneService.get(processSwimlaneId));
        } else if (swimlameType.equals(TaskNodeDefinition.SWIMLANE_TYPE_TASK)) {
            BpmSwimlaneDefinition definition;
            if (definitionId == null) {
                definition = new BpmSwimlaneDefinition();
            } else {
                definition = bpmSwimlaneDefinitionService.get(definitionId);
            }
            definition.setGroup(sysCodeDetailService.get(groupId));
            definition.setPositionType(sysCodeDetailService.get(positionTypeId));
            definition.setExpression(expression);
            bpmSwimlaneDefinitionService.save(definition);
            target.setProcessSwimlane(null);
            target.setSwimlaneDefinition(definition);
        }
        bpmTaskSwimlaneService.save(target);
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 查看人员
     */
    @RequestMapping
    public String nodePerson(HttpServletRequest request, @RequestParam Long id,
                             HttpServletResponse response, Model model) throws Exception {
        BpmTaskSwimlane bpmTaskSwimlane = bpmTaskSwimlaneService.get(id);
        BpmSwimlaneDefinition definition;// = swimlane.getSwimlaneDefinition();
        if (bpmTaskSwimlane.getSwimlaneDefinition() != null) {
            definition = bpmTaskSwimlane.getSwimlaneDefinition();
        } else {
            BpmProcessSwimlane bpmProcessSwimlane = bpmTaskSwimlane.getProcessSwimlane();
            if (bpmProcessSwimlane.getSwimlaneDefinition() != null) {
                definition = bpmProcessSwimlane.getSwimlaneDefinition();
            } else {
                //added by chenjp at 20110707 增加友好提示
                if (bpmProcessSwimlane.getSwimlane() == null) {
                    model.addAttribute("msg", "{\"type\":\"error\",\"msg\":\"未找到人员，流程泳道未设置！\"}");
                    return "common/msg";
                }
                definition = bpmProcessSwimlane.getSwimlane().getSwimlaneDefinition();
            }
        }
        String expression = definition.getExpression();

        List<Map> varNames = new ArrayList<Map>();
        Map<String, String> varMap = new HashMap<String, String>();
        if (!StringHelper.isEmpty(expression)) {
            Set<String> varNameSet = SwimlaneManager.extractVarNames(expression);
            for (String varName : varNameSet) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("varName", varName);
                String varValue = request.getParameter(varName);
                logger.debug("varValue is " + varValue);
                if (varValue == null) {
                    varValue = "";
                }
                map.put("varValue", varValue);
                varNames.add(map);
                varMap.put(varName, varValue);
            }
        }

        //get person
        List<Map> persons = new ArrayList<Map>();
        List<Candidate> canditates = bpmSwimlaneManager.getCandidates(definition, varMap);
        for (Candidate canditate : canditates) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("group", canditate.getBpmProjectGroup().getName());
            map.put("duty", canditate.getBpmProjectGroupDuty().getName());
            map.put("person", canditate.getSysPerson().getName());
            persons.add(map);
        }

        model.addAttribute("varNames", varNames);
        model.addAttribute("persons", persons);
        model.addAttribute("bean", bpmTaskSwimlane);
        return "view/workflow/bpmNodeDefinition/nodePerson";
    }

    /**
     * 流程选择节点人员树
     *
     * @param request .
     * @param id      .
     * @param icon    .
     * @param model   .
     * @return .
     * @throws Exception .
     */
    @RequestMapping
    public String nodePersonSelect(HttpServletRequest request, @RequestParam String id, @RequestParam Long nodeDefinitionId,
                                   @RequestParam String icon, Model model) throws Exception {

        ZTreeBranch treeBranch = new ZTreeBranch();
        treeBranch.setIcons(icon.split(","));

        if (StringUtils.isEmpty(id)) {
            treeBranch.addTreeNode(treeBranch.getRootNode("根节点"));
        } else if (StringUtils.equals(id, "root")) {
            BpmTaskSwimlane bpmTaskSwimlane = bpmTaskSwimlaneService.findUnique(
                    "from BpmTaskSwimlane where task.id=?", nodeDefinitionId);
            BpmSwimlaneDefinition definition;
            if (bpmTaskSwimlane.getSwimlaneDefinition() != null) {
                definition = bpmTaskSwimlane.getSwimlaneDefinition();
            } else {
                BpmProcessSwimlane bpmProcessSwimlane = bpmTaskSwimlane.getProcessSwimlane();
                if (bpmProcessSwimlane.getSwimlaneDefinition() != null) {
                    definition = bpmProcessSwimlane.getSwimlaneDefinition();
                } else {
                    definition = bpmProcessSwimlane.getSwimlane().getSwimlaneDefinition();
                }
            }
            String expression = definition.getExpression();
            List<Map> varNames = new ArrayList<Map>();
            Map<String, String> varMap = new HashMap<String, String>();
            if (!StringHelper.isEmpty(expression)) {
                Set<String> varNameSet = SwimlaneManager.extractVarNames(expression);
                for (String varName : varNameSet) {
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("varName", varName);
                    String varValue = request.getParameter(varName);
                    logger.debug("varValue is " + varValue);
                    if (varValue == null) {
                        varValue = "";
                    }
                    map.put("varValue", varValue);
                    varNames.add(map);
                    varMap.put(varName, varValue);
                }
            }

            //去除重复人员
            Set<SysUser> norepeatHS = new HashSet<SysUser>();
            List<Candidate> canditates = bpmSwimlaneManager.getCandidates(definition, varMap);
            for (Candidate canditate : canditates) {
                SysPerson sysPerson = canditate.getSysPerson();
                SysUser sysUser = CollectionUtils.getFirstEle(sysPerson.getSysUsers());
                if (sysUser != null) {
                    if(!norepeatHS.contains(sysUser)){
                        norepeatHS.add(sysUser);
                        ZTreeNode treeNode = new ZTreeNode();
                        treeNode.setId(String.valueOf(sysUser.getId()));
                        treeNode.setIsLeaf(true);
                        treeNode.setName(sysPerson.getName());
                        treeNode.setIcon("2");
                        treeNode.setType("data");
                        treeBranch.addTreeNode(treeNode);
                    }
                }
            }
            norepeatHS = null;
        }
        model.addAttribute("msg", treeBranch.toJsonString(true));
        return "common/msg";
    }

    /**
     * @param id      .
     * @param shapeId .
     * @param model   .
     * @throws Exception
     */
    @RequestMapping
    public String nodeDefinition(@RequestParam Long id, @RequestParam Long shapeId, Model model) throws Exception {
        String hql = "from BpmNodeDefinition t where t.processDefinition.id=" + id + " and t.shapeId=" + shapeId;
        BpmNodeDefinition nodeDefinition = bpmNodeDefinitionService.findUnique(hql);
        System.out.println("nodeDefinition = " + nodeDefinition);
        String nodeType = nodeDefinition.getNodeType();
        List<Map> tabs = new ArrayList<Map>();
        if ("D".equals(nodeType)) {//decision
            Map<String, String> map = new HashMap<String, String>();
            map.put("name", "分支设置");
            map.put("url", "decision.do");
            tabs.add(map);
        } else if ("K".equals(nodeType)) {//tasknode
            Map<String, String> map1 = new HashMap<String, String>();
            map1.put("name", "属性设置");
            map1.put("url", "attribute.do");
            tabs.add(map1);
            Map<String, String> map2 = new HashMap<String, String>();
            map2.put("name", "人员限制");
            map2.put("url", "personLimit.do");
            tabs.add(map2);
        } else if ("R".equals(nodeType)) {//start
            Map<String, String> map1 = new HashMap<String, String>();
            map1.put("name", "人员限制");
            map1.put("url", "personLimit.do");
            tabs.add(map1);
        } else {
            Map<String, String> map1 = new HashMap<String, String>();
            map1.put("name", "信息");
            map1.put("url", "info.do");
            tabs.add(map1);
        }
        model.addAttribute("nodeId", nodeDefinition.getId());
        model.addAttribute("tabs", tabs);
        return "view/workflow/bpmNodeDefinition/nodeDefinition";
    }

    /**
     * @throws Exception
     */
    @RequestMapping
    public String info(Model model, HttpServletResponse response) throws Exception {
        return "view/workflow/bpmNodeDefinition/info";
    }

    /**
     * 属性设置
     *
     * @param model 。
     * @throws Exception 。
     */
    @RequestMapping
    public String attribute(@RequestParam Long id, Model model) throws Exception {
        BpmNodeDefinition bpmNodeDefinition = bpmNodeDefinitionService.get(id);

        TaskNodeDefinition taskNodeDefinition = null;
        if (StringHelper.isEmpty(bpmNodeDefinition.getNodeDefinition())) {
            bpmProcessDefinitionManager.initTaskNodeDefinition(bpmNodeDefinition);
        }
        String nodeDefinition = bpmNodeDefinition.getNodeDefinition();
        taskNodeDefinition = JaxbUtil.unmarshall(TaskNodeDefinition.class, nodeDefinition);
        String earlyWarningName[] = {"无", "频繁预警", "非频繁预警"};
        String earlyWarningValue[] = {TaskNodeDefinition.WARNING_NONE, TaskNodeDefinition.WARNING_FREQUENTLY, TaskNodeDefinition.WARNING_UNFREQUENTLY};
        String earlyWarningSelect = JspHelper.getOptionString(earlyWarningName, earlyWarningValue, taskNodeDefinition.getEarlyWarningType());

        String actionTypeName[] = {"单人执行", "多人执行", "多人会签"};
        String actionTypeValue[] = {TaskNodeDefinition.MULTI_EXCLUSIVE, TaskNodeDefinition.MULTI_SHARE, TaskNodeDefinition.MULTI_SYNC};
        String actionTypeSelect = JspHelper.getOptionString(actionTypeName, actionTypeValue, taskNodeDefinition.getTaskCreateType());

//        String forwardTypeName[] = {"弹出窗口", "当前页面"};
//        String forwardTypeValue[] = {"singleExecute", "mutilExecute"};
//        String forwardTypeSelect = JspHelper.getOptionString(forwardTypeName, forwardTypeValue, taskNodeDefinition.get);

        String timeOutActionName[] = {"继续执行", "暂停执行"};
        String timeOutActionValue[] = {TaskNodeDefinition.ACTION_CONTINUE, TaskNodeDefinition.ACTION_PAUSE};
        String timeOutActionSelect = JspHelper.getOptionString(timeOutActionName, timeOutActionValue, taskNodeDefinition.getTimeOutAction());

        List<BpmProcessTransition> leavingTransitions = bpmProcessDefinitionManager.getLeavingTransitions(bpmNodeDefinition);
        String transitions[] = new String[leavingTransitions.size()];
        String transitionIds[] = new String[leavingTransitions.size()];
        for (int i = 0; i < leavingTransitions.size(); i++) {
            BpmProcessTransition transition = leavingTransitions.get(i);
            String transitionName = transition.getName();
            if (transitionName.indexOf("_") > 0) {
                transitionName = transitionName.substring(0, transitionName.indexOf("_"));
            }
            transitions[i] = transitionName;
            transitionIds[i] = String.valueOf(transition.getId());
        }
        String transitionSelect = JspHelper.getOptionString(transitions, transitionIds, taskNodeDefinition.getDefaultTransitionName() == null ? "" : taskNodeDefinition.getDefaultTransitionName());

        Set<BpmProcessDefinitionForm> bpmProcessDefinitionFormSet = bpmNodeDefinition.getProcessDefinition().getBpmProcessDefinitionForms();
        int i = 0;
        String forms[] = new String[bpmProcessDefinitionFormSet.size()];
        String formIds[] = new String[bpmProcessDefinitionFormSet.size()];
        for (BpmProcessDefinitionForm bpmProcessDefinitionForm : bpmProcessDefinitionFormSet) {
            forms[i] = bpmProcessDefinitionForm.getFormTemplate().getName();
            formIds[i] = String.valueOf(bpmProcessDefinitionForm.getFormTemplate().getId());
            i++;
        }
        String formSelect = JspHelper.getOptionString(forms, formIds, String.valueOf(taskNodeDefinition.getFormId()));

        List<Map> privileges = new ArrayList<Map>();
        String privilegeIds = "";
        String[] formPrivileges = taskNodeDefinition.getPrivileges();
        if (formPrivileges != null) {
            for (String privilege : formPrivileges) {
                Map map = new HashMap();
                map.put("id", privilege);
                map.put("name", privilege);
                privileges.add(map);
                privilegeIds += privilege + ",";
            }
        }
        System.out.println("taskNodeDefinition.is = " + taskNodeDefinition.isSelectUser());

        //默认分支需要分析
        model.addAttribute("bean", bpmNodeDefinition);
        model.addAttribute("taskNodeDefinition", taskNodeDefinition);
        model.addAttribute("earlyWarningSelect", earlyWarningSelect);
        model.addAttribute("actionTypeSelect", actionTypeSelect);
//        model.addAttribute("forwardTypeSelect", forwardTypeSelect);
        model.addAttribute("timeOutActionSelect", timeOutActionSelect);
        model.addAttribute("transitionSelect", transitionSelect);
        model.addAttribute("formSelect", formSelect);
        model.addAttribute("privileges", privileges);
        model.addAttribute("privilegeIds", privilegeIds);
        return "view/workflow/bpmNodeDefinition/attribute";
    }

    /**
     * 保存属性设置
     *
     * @param model 。
     * @throws Exception 。
     */
    @RequestMapping
    public void saveAttribute(
            @RequestParam Long id,
            @RequestParam String taskCreateType,//动作类型
            @RequestParam Integer dateLimit,//处理时限
            @RequestParam String dateType,//工作日，自然日
            @RequestParam String earlyWarning,//预警策略
            @RequestParam String timeOutAction,//超时处理动作
            @RequestParam String operateType,//操作类型：标准操作，表单操作
            @RequestParam(required = false) Boolean isCanForward,//允许转发
            @RequestParam(required = false) Boolean isShowPermitted,//批注、否决和保留意见
            @RequestParam(required = false) Boolean isShowRead,//已阅、未阅
            @RequestParam(required = false) Boolean isShowOpinion,//审核意见
            @RequestParam(required = false) Boolean isShowUpload,//附件上传
            @RequestParam(required = false) Boolean isSelectUser,//节点是否要选择人员
            @RequestParam(required = false) Long templateId,//选择模板
            @RequestParam(required = false) String privilegeIds,//模板权限
            @RequestParam(required = false) String initScript,//初始化脚本
            @RequestParam(required = false) String defultTrisition,//选择默认分支
            HttpServletResponse response,
            Model model) throws Exception {
        TaskNodeDefinition taskNodeDefinition = new TaskNodeDefinition();
        taskNodeDefinition.setTaskCreateType(taskCreateType);
        taskNodeDefinition.setCanForward(isCanForward == null ? false : isCanForward);
        taskNodeDefinition.setOperateType(operateType);
        taskNodeDefinition.setDateLimit(dateLimit);
        taskNodeDefinition.setDateType(dateType);
        taskNodeDefinition.setEarlyWarningType(earlyWarning);
        taskNodeDefinition.setTimeOutAction(timeOutAction);
        taskNodeDefinition.setDefaultTransitionName(defultTrisition);
        taskNodeDefinition.setSelectUser(isSelectUser == null ? false : isSelectUser);
        if (operateType.toLowerCase().equals(TaskNodeDefinition.OPERATION_TYPE_STANDARD)) {
            taskNodeDefinition.setShowPermitted(isShowPermitted == null ? false : isShowPermitted);
            taskNodeDefinition.setShowRead(isShowRead == null ? false : isShowRead);
            taskNodeDefinition.setShowOpinion(isShowOpinion == null ? false : isShowOpinion);
            taskNodeDefinition.setShowUpload(isShowUpload == null ? false : isShowUpload);
        } else if (operateType.toLowerCase().equals(TaskNodeDefinition.OPERATION_TYPE_FORM)) {
            taskNodeDefinition.setFormId(templateId);
            taskNodeDefinition.setInitScript(initScript);
            if (!StringHelper.isEmpty(privilegeIds)) {
                String[] privileges = privilegeIds.split(",");
                taskNodeDefinition.setPrivileges(privileges);
            }
        }
        String definition = bpmProcessDefinitionManager.marshallTaskNodeDefinition(taskNodeDefinition);
        BpmNodeDefinition bpmNodeDefinition = bpmNodeDefinitionService.get(id);
        bpmNodeDefinition.setNodeDefinition(definition);
        bpmNodeDefinitionService.save(bpmNodeDefinition);
        sendSuccessJSON(response, "保存成功！");
    }

    /**
     * 分支节点设置
     *
     * @return 。
     * @throws Exception 。
     */
    @RequestMapping
    public String decision(@RequestParam Long id, Model model) throws JAXBException, IOException {
        BpmNodeDefinition bpmNodeDefinition = bpmNodeDefinitionService.get(id);

        DecisionDefinition decisionDefinition = null;
        if (StringHelper.isEmpty(bpmNodeDefinition.getNodeDefinition())) {
            bpmProcessDefinitionManager.initDecisionNodeDefinition(bpmNodeDefinition);
        }

        String nodeDefinition = bpmNodeDefinition.getNodeDefinition();
        decisionDefinition = JaxbUtil.unmarshall(DecisionDefinition.class, nodeDefinition);

        String defaultTransition = decisionDefinition.getDefaultTransition();

        String[] transitions = decisionDefinition.getTransitions();
        String[] conditions = decisionDefinition.getConditions();

        //得到jBPM的Node,再得到leavingTransition，再得到transitionTo的jBPM Node，再得到名称
        Map<String, String> transitionMap = bpmProcessDefinitionManager.getTransitionMap(bpmNodeDefinition);

        //根据xml信息的顺序查找jBPM的Transitions得到名称等信息
        List<Map> decisionTransitions = new ArrayList<Map>();
        for (int i = 0; i < transitions.length; i++) {
            Map<String, String> map = new HashMap<String, String>();

            String tranditionTo = transitionMap.get(transitions[i]);
            map.put("transitionName", transitions[i]);
            if (conditions != null && conditions.length >= i) {
                map.put("condition", conditions[i]);
            } else {
                map.put("condition", "");
            }
            map.put("transitionTo", tranditionTo);

            decisionTransitions.add(map);
        }

        model.addAttribute("bean", bpmNodeDefinition);
        model.addAttribute("decisionTransitions", decisionTransitions);
        model.addAttribute("defaultTransition", defaultTransition);
        return "view/workflow/bpmNodeDefinition/decision";
    }

    /**
     * 分支节点设置
     *
     * @throws Exception 。
     */
    @RequestMapping
    public void saveDecision(@RequestParam Long id, @RequestParam String conditions[], HttpServletResponse response,
                             @RequestParam String transitions[], @RequestParam String defaultTransition, Model model) throws JAXBException, IOException {
        DecisionDefinition decisionDefinition = new DecisionDefinition();
        decisionDefinition.setConditions(conditions);
        decisionDefinition.setTransitions(transitions);
        decisionDefinition.setDefaultTransition(defaultTransition);
        BpmNodeDefinition nodeDefinition = bpmNodeDefinitionService.get(id);

        String s = bpmProcessDefinitionManager.marshallDecisionDefinition(decisionDefinition);
        logger.debug("marshalled decision definition is {}", s);
        nodeDefinition.setNodeDefinition(s);
        bpmNodeDefinitionService.save(nodeDefinition);
        sendSuccessJSON(response, "保存成功！");
    }

    /**
     * 上下移动
     *
     * @throws Exception 。
     */
    @RequestMapping
    public void moveDecision(@RequestParam Long id, @RequestParam int transitionIndex, HttpServletResponse response,
                             @RequestParam String type, Model model) throws JAXBException, IOException {
        BpmNodeDefinition bpmNodeDefinition = bpmNodeDefinitionService.get(id);
        String definition = bpmNodeDefinition.getNodeDefinition();
        DecisionDefinition decisionDefinition = JaxbUtil.unmarshall(DecisionDefinition.class, definition);
        String[] transitions = decisionDefinition.getTransitions();
        String[] conditions = decisionDefinition.getConditions();
        if (type.toLowerCase().equals("up")) {//上移
            if (transitionIndex > 0) {//不是第一个
                swap(transitions, transitionIndex - 1, transitionIndex);
                swap(conditions, transitionIndex - 1, transitionIndex);
            } else {
                logger.debug("this is the frist one!");
            }
        } else if (type.toLowerCase().equals("down")) {//下移
            if (transitionIndex < transitions.length) {//不是最后一个
                swap(transitions, transitionIndex + 1, transitionIndex);
                swap(conditions, transitionIndex + 1, transitionIndex);
            } else {
                logger.debug("this is the frist one!");
            }
        } else {
            logger.debug("the bad type!");
        }
        decisionDefinition.setTransitions(transitions);
        decisionDefinition.setConditions(conditions);
        definition = bpmProcessDefinitionManager.marshallDecisionDefinition(decisionDefinition);
        logger.debug("decision is " + definition);
        bpmNodeDefinition.setNodeDefinition(definition);
        bpmNodeDefinitionService.save(bpmNodeDefinition);
        sendSuccessJSON(response, "移动成功！");
    }

    private void swap(String[] strings, int frist, int second) {
        String temp = strings[frist];
        strings[frist] = strings[second];
        strings[second] = temp;
    }
}