package com.justonetech.biz.utils.process.model;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class Decision extends Node {
    public Decision() {
        this.setNodeType(Node.DECISION_Element);
    }

    public Element toXml() {
        Element element = DocumentHelper.createElement("decision");
        element.addAttribute("name", this.getText());

        Element assignmentElement = DocumentHelper.createElement("assignment");
        assignmentElement.addAttribute("class", "com.juyee.task.WriteRequestAssignmentHandler");

        for (int i = 0; i < this.getOutTransitions().size(); i++) {
            Transition transition = this.getOutTransitions().get(i);
            element.add(transition.toXml());
        }
        return element;
    }
}