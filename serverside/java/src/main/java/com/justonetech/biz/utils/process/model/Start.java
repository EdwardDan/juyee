package com.justonetech.biz.utils.process.model;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class Start extends Node {
    public Start() {
        this.setNodeType(Node.START_Element);
    }

    public Element toXml() {
        Element element = DocumentHelper.createElement("start-state");
        element.addAttribute("name", this.getText());

        Element eventElement = DocumentHelper.createElement("event");
        eventElement.addAttribute("type", "node-enter");
        Element actionElement = DocumentHelper.createElement("action");
        actionElement.addAttribute("class", "com.juyee.jbpm.handler.TaskActionHandler");
        eventElement.add(actionElement);
        element.add(eventElement);

        for (int i = 0; i < this.getOutTransitions().size(); i++) {
            Transition transition = this.getOutTransitions().get(i);
            element.add(transition.toXml());
        }
        return element;
    }
}