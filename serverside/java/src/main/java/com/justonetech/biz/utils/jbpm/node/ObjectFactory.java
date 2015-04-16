package com.justonetech.biz.utils.jbpm.node;

import javax.xml.bind.annotation.XmlRegistry;


@XmlRegistry
public class ObjectFactory {

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.justonetech.ipromis.core.jbpm.task
     */
    public ObjectFactory() {
    }


    /**
     * Create an instance of {@link DecisionDefinition }
     */
    public DecisionDefinition createDecisionDefinition() {
        return new DecisionDefinition();
    }

    /**
     * Create an instance of {@link TaskNodeDefinition }
     */
    public TaskNodeDefinition createTaskNodeDefinition() {
        return new TaskNodeDefinition();
    }

}
