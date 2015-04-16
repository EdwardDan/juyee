package com.justonetech.biz.utils.process.model;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class Fork extends Node {

    public Fork() {
        this.setNodeType(Node.FORK_Element);
    }

    public Element toXml() {
       Element element = DocumentHelper.createElement("fork");
        element.addAttribute("name", this.getText());
        for (int i = 0; i < this.getOutTransitions().size(); i++) {
            Transition transition = this.getOutTransitions().get(i);
            element.add(transition.toXml());
        }
        return element;
    }
}
