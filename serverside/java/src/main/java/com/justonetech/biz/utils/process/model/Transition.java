package com.justonetech.biz.utils.process.model;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class Transition extends GraphicElement {

    private Node fromNode;

    private Node toNode;

    private String condition;

    public Node getFromNode() {
        return fromNode;
    }

    public void setFromNode(Node fromNode) {
        this.fromNode = fromNode;
    }

    public Node getToNode() {
        return toNode;
    }

    public void setToNode(Node toNode) {
        this.toNode = toNode;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Element toXml() {
        Element element = DocumentHelper.createElement("transition");
        element.addAttribute("to", this.getToNode().getText());
        element.addAttribute("name", this.getText());
        return element;
    }
}