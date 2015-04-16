package com.justonetech.biz.utils.jbpm.db;

public class DecisionActionData {
    private DecisionTransition[] decisionTransitions;
    private DecisionTransition decisionTransition;

    public DecisionTransition[] getDecisionTransitions() {
        return decisionTransitions;
    }

    public void setDecisionTransitions(DecisionTransition[] decisionTransitions) {
        this.decisionTransitions = decisionTransitions;
    }

    public DecisionTransition getDecisionTransition() {
        return decisionTransition;
    }

    public void setDecisionTransition(DecisionTransition decisionTransition) {
        this.decisionTransition = decisionTransition;
    }
}
