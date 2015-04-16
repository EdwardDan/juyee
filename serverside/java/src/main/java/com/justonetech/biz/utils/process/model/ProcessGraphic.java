package com.justonetech.biz.utils.process.model;

import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.utils.process.visio.Page;
import com.justonetech.biz.utils.process.visio.Shape;
import com.justonetech.biz.utils.process.visio.Shapes;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;


public class ProcessGraphic extends GraphicElement {
    private static final Log log = LogFactory.getLog(ProcessGraphic.class);

    private List<Swimlane> swimlanes = new ArrayList<Swimlane>();

    private List<Start> starts = new ArrayList<Start>();

    private List<End> ends = new ArrayList<End>();

    private List<TaskNode> taskNodes = new ArrayList<TaskNode>();

    private List<Decision> decisions = new ArrayList<Decision>();

    private List<Fork> forks = new ArrayList<Fork>();

    private List<Join> joins = new ArrayList<Join>();

    private List<Transition> transitions = new ArrayList<Transition>();

    private List<Node> nodes = new ArrayList<Node>();

    public List<Swimlane> getSwimlanes() {
        return swimlanes;
    }

    public void setSwimlanes(List<Swimlane> swimlanes) {
        this.swimlanes = swimlanes;
    }

    public List<Start> getStarts() {
        return starts;
    }

    public void setStarts(List<Start> starts) {
        this.starts = starts;
    }

    public List<End> getEnds() {
        return ends;
    }

    public void setEnds(List<End> ends) {
        this.ends = ends;
    }

    public List<TaskNode> getTaskNodes() {
        return taskNodes;
    }

    public void setTaskNodes(List<TaskNode> taskNodes) {
        this.taskNodes = taskNodes;
    }

    public List<Decision> getDecisions() {
        return decisions;
    }

    public void setDecisions(List<Decision> decisions) {
        this.decisions = decisions;
    }

    public List<Fork> getForks() {
        return forks;
    }

    public void setForks(List<Fork> forks) {
        this.forks = forks;
    }

    public List<Join> getJoins() {
        return joins;
    }

    public void setJoins(List<Join> joins) {
        this.joins = joins;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<Transition> transitions) {
        this.transitions = transitions;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public Node findNodeById(List<? extends Node> nodes, Long id) {
        for (Node node : nodes) {
            if (node.getId().equals(id))
                return node;
        }
        return null;
    }

    public Node findNodeById(Long id) {
        Node node = findNodeById(nodes, id);
        if (null != node) return node;
        return null;
    }

    public Swimlane findSwimlaneById(List<Swimlane> elements, Long id) {
        for (Swimlane swimlane : elements) {
            if (swimlane.getId().equals(id))
                return swimlane;
        }
        return null;
    }

    public Transition findTransitionById(List<Transition> elements, Long id) {
        for (Transition transition : elements) {
            if (transition.getId().equals(id))
                return transition;
        }
        return null;
    }

    public ProcessGraphic(Page page) {
        processAllShapes(page);
        processRalationships();
    }

    public ProcessGraphic() {
    }

    public void processAllShapes(Page page) {
        Shapes shapes = page.getShapes();
        log.debug("processAllShapes start..");
        for (int i = 0; i < shapes.getShape().size(); i++) {
            Shape shape = shapes.getShape().get(i);

            if (shape.getNameU().startsWith("Vertical holder")) {//垂直支架
                setNormalAttribute(this, shape);
            } else if (shape.getNameU().startsWith("Functional band")) {//职能带区
                Swimlane swimlane = new Swimlane();
                swimlane.setNormalAttribute(swimlane, shape);
                getSwimlanes().add(swimlane);
            } else if (shape.getNameU().startsWith("Dynamic connector")) {//动态连接线
                Transition transition = new Transition();
                transition.setNormalAttribute(transition, shape);
                transition.setFrom(shape.getFrom().getID());
                transition.setTo(shape.getTo().getID());
                getTransitions().add(transition);
            } else if (shape.getNameU().startsWith("Start")) {//开始
                Start start = new Start();
                start.setNormalAttribute(start, shape);
                getStarts().add(start);
                getNodes().add(start);
            } else if (shape.getNameU().startsWith("End")) {//结束
                End end = new End();
                end.setNormalAttribute(end, shape);
                getEnds().add(end);
                getNodes().add(end);
            } else if (shape.getNameU().startsWith("Fork")) {//fork
                Fork fork = new Fork();
                fork.setNormalAttribute(fork, shape);
//                if(fork.getText()==null||fork.getText().trim().equals("")){
//                    fork.setText("分发_"+fork.getId());
//                }
                getForks().add(fork);
                getNodes().add(fork);
            } else if (shape.getNameU().startsWith("Join")) {//join
                Join join = new Join();
                join.setNormalAttribute(join, shape);
//                if(join.getText()==null||join.getText().trim().equals("")){
//                    join.setText("合并_"+join.getId());
//                }
                getJoins().add(join);
                getNodes().add(join);
            } else if (shape.getNameU().startsWith("Decision")) {//判定
                Decision decision = new Decision();
                decision.setNormalAttribute(decision, shape);
                getDecisions().add(decision);
                getNodes().add(decision);
            } else if (shape.getNameU().startsWith("Process")) {//进程
                TaskNode taskNode = new TaskNode();
                taskNode.setNormalAttribute(taskNode, shape);
                getTaskNodes().add(taskNode);
                getNodes().add(taskNode);
            } else {
                log.warn("不能识别的类型！id = " + shape.getID() + ",text=" + shape.getText());
                //throw new RuntimeException("不能识别的类型！id = " + shape.getID());
            }
        }
        log.debug("processAllShapes has ended");
    }

    public void processRalationships() {
        //step1. transition and nodes
        for (Transition transition : transitions) {
            String from = transition.getFrom();
            Node fromNode = findNodeById(Long.valueOf(from));
            if (fromNode == null) {
                log.error("can not find node:id = " + from);
                throw new RuntimeException("can not find node:id = " + from);
            }

            String to = transition.getTo();
            Node toNode = findNodeById(Long.valueOf(to));
            if (toNode == null) {
                log.error("can not find node:id = " + to);
                throw new RuntimeException("can not find node:id = " + to);
            }

            transition.setFromNode(fromNode);
            transition.setToNode(toNode);

//            if (transition.getText() == null || transition.getText().trim().equals("")) {
//                transition.setText("提交" + toNode.getText());
//            }

            fromNode.getOutTransitions().add(transition);
            toNode.getInTransitions().add(transition);
        }

        //step2. node and swimlane
        for (Node node : nodes) {
            node.setSwimlane(findSwimlane(node));
        }
    }

    public String checkRalationships() {
        if (StringHelper.isEmpty(getText())) {
            return "流程模板名称不能为空！";
        }
        for (Transition transition : transitions) {
            String from = transition.getFrom();
            Node fromNode = findNodeById(Long.valueOf(from));
            if (fromNode == null) {
                log.error("can not find node:id = " + from);
                return "找不到结点id为" + from + "的结点！";
            }

            String to = transition.getTo();
            Node toNode = findNodeById(Long.valueOf(to));
            if (toNode == null) {
                log.error("can not find node:id = " + to);
                return "找不到结点id为" + to + "的结点！";
            }
        }

        return "";
    }

    /**
     * 根据坐标算出node属于哪个swimlane
     * 注意：node与swimlane的坐标系相同，但坐标算法是不同的
     * swimlane 的x坐标为（x,x+width）
     * node  的x坐标为(x-width/2,x+width/2)
     *
     * @param node
     * @return
     */
    private Swimlane findSwimlane(Node node) {
        for (Swimlane swimlane : swimlanes) {
            //判断node的坐标范围与swimlane的坐标区域有没有重合
            Double swimlaneLeftX = swimlane.getX();
            Double swimlaneRigthX = swimlane.getX() + swimlane.getWidth();

            Double nodeLeftX = node.getX() - node.getWidth() / 2;
            Double nodeRightX = node.getX() + node.getWidth() / 2;

            if (swimlaneLeftX < nodeLeftX && swimlaneRigthX > nodeRightX) {
                return swimlane;
            }
        }
        log.warn("can not find swimlane for node:" + node.getText());
        return null;
    }


    public Element toXml() {
        Element rootElement = DocumentHelper.createElement("process-definition");
        rootElement.addAttribute("xmlns", "");
        rootElement.addAttribute("name", this.getText());
        return rootElement;
    }


}