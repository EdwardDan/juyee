/***********************************************************************
 * Module:  Node.java
 * Author:  wangyang
 * Purpose: Defines the Class Node
 ***********************************************************************/

package com.justonetech.biz.utils.process.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Node extends GraphicElement {

    protected final static int START_Element = 1;
    protected final static int END_Element = 2;
    protected final static int STATE_Element = 3;
    protected final static int FORK_Element = 4;
    protected final static int JOIN_Element = 5;
    protected final static int DECISION_Element = 6;
    protected final static int NODE_Element = 7;
    protected final static int TASK_Element = 8;

    private int nodeType;

    private Swimlane swimlane;

    private List<Transition> outTransitions = new ArrayList<Transition>();

    private List<Transition> inTransitions = new ArrayList<Transition>();

    public int getNodeType() {
        return nodeType;
    }

    protected void setNodeType(int nodeType) {
        this.nodeType = nodeType;
    }

    public Swimlane getSwimlane() {
        return swimlane;
    }

    public void setSwimlane(Swimlane swimlane) {
        this.swimlane = swimlane;
    }

    public List<Transition> getOutTransitions() {
        return outTransitions;
    }

    public void setOutTransitions(List<Transition> outTransitions) {
        this.outTransitions = outTransitions;
    }

    public List<Transition> getInTransitions() {
        return inTransitions;
    }

    public void setInTransitions(List<Transition> inTransitions) {
        this.inTransitions = inTransitions;
    }
}