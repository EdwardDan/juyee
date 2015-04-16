package com.justonetech.biz.utils.jbpm.db;

import com.justonetech.biz.utils.jbpm.node.DecisionDefinition;
import com.justonetech.biz.utils.jbpm.node.TaskNodeDefinition;

public interface ProcessDataHandler {
//    DecisionActionData getDecisionActionData(String nodeName);
//
//    NodeEnterActionData getNodeEnterActionData(String nodeName);
//
//    TimerCreateActionData getTimerCreateActionData(String nodeName);

    TaskNodeDefinition getTaskNodeDefinition();
    DecisionDefinition getDecisionDefinition();
}
