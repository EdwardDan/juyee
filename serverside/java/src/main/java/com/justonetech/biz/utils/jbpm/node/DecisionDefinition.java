package com.justonetech.biz.utils.jbpm.node;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.xml.bind.annotation.*;

/**
 * @version 1.0
 * @author: MaJi
 * @since: 2009-4-21
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "DecisionDefinition")
public class DecisionDefinition {
    private static final Log log = LogFactory.getLog(DecisionDefinition.class);

    @XmlElement
    String[] transitions;

    @XmlElement
    String[] conditions;

    @XmlElement
    String defaultTransition;

    public String getDefaultTransition() {
        return defaultTransition;
    }

    public void setDefaultTransition(String defaultTransition) {
        this.defaultTransition = defaultTransition;
    }

    public String[] getTransitions() {
        return transitions;
    }

    public void setTransitions(String[] transitions) {
        this.transitions = transitions;
    }

    public String[] getConditions() {
        return conditions;
    }

    public void setConditions(String[] conditions) {
        this.conditions = conditions;
    }
}
