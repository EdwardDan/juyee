package com.justonetech.biz.utils.process.model;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class End extends Node {
    public End() {
        this.setNodeType(Node.END_Element);
    }

    public Element toXml() {
        Element element = DocumentHelper.createElement("end-state");

        element.addAttribute("name", this.getText());
        for (int i = 0; i < this.getOutTransitions().size(); i++) {
            Transition transition = this.getOutTransitions().get(i);
            element.add(transition.toXml());
        }
        return element;
    }
}