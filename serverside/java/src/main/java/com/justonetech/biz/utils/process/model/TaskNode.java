package com.justonetech.biz.utils.process.model;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class TaskNode extends Node {
    public TaskNode() {
        this.setNodeType(Node.TASK_Element);
    }

    public Element toXml() {
        Element element = DocumentHelper.createElement("task-node");
        element.addAttribute("name", this.getText());
        element.addAttribute("create-tasks", "false");

        Element eventElement = DocumentHelper.createElement("event");
        eventElement.addAttribute("type", "node-enter");
        Element actionElement = DocumentHelper.createElement("action");
        actionElement.addAttribute("class", "com.juyee.jbpm.handler.TaskActionHandler");
        eventElement.add(actionElement);
        element.add(eventElement);

        Element taskElement = DocumentHelper.createElement("task");
        taskElement.addAttribute("name", this.getText());
        element.add(taskElement);

        for (int i = 0; i < this.getOutTransitions().size(); i++) {
            Transition transition = this.getOutTransitions().get(i);
            element.add(transition.toXml());
        }
        return element;
    }
}