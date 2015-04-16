package com.justonetech.biz.utils.jbpm.handler;

import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.domain.BpmNodeDefinition;
import com.justonetech.biz.manager.workflow.ProcessDataManager;
import com.justonetech.biz.utils.jbpm.node.DecisionDefinition;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jbpm.graph.def.Node;
import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.graph.node.DecisionHandler;
import org.jbpm.taskmgmt.exe.TaskMgmtInstance;

public class DecisionActionHandler implements DecisionHandler {

    public String decide(ExecutionContext executionContext) throws Exception {
        //1. get the decision unique id
        //2. get the definition fo the decision from database,such as condition and default transition
        //3. calc the condition one by one, and return if match
        //4. if none match,return the default transition name
        //得到当前Jbpm Node名称
        TaskMgmtInstance taskMgmtInstance = executionContext.getTaskMgmtInstance();
        Node node = executionContext.getNode();
        log.debug("node = " + node.getName());

        BpmNodeDefinition bpmNodeDefinition = ProcessDataManager.getBpmNodeDefinition(node);
        DecisionDefinition decisionDefinition = ProcessDataManager.getDecisionDefinition(bpmNodeDefinition);

        String[] conditions = decisionDefinition.getConditions();
        String[] transitions = decisionDefinition.getTransitions();
        for (int i = 0; i < conditions.length; i++) {
            String condition = conditions[i];
            if (!StringHelper.isEmpty(condition)) {
                Boolean result = ProcessDataManager.getResult(executionContext.getProcessInstance().getId(), condition);
                if (result) {
                    return transitions[i];
                }
            }
        }

        //return the transition name
        return decisionDefinition.getDefaultTransition();
    }

    private static final Log log = LogFactory.getLog(NodeEnterActionHandler.class);
}
