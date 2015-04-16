package com.justonetech.biz.utils.process.util;

import com.justonetech.core.utils.ParFileUtils;
import com.justonetech.biz.utils.process.model.*;
import com.justonetech.biz.utils.process.visio.Page;
import com.justonetech.biz.utils.process.visio.VisioDocument;
import com.justonetech.biz.utils.process.visio.XMLReader;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;

public class JbpmXmlDefTransfer {
    private String nodeEnterActionHandlerClassName = "com.justonetech.biz.utils.jbpm.handler.NodeEnterActionHandler";
    private String timerCreateActionHandlerClassName = "com.justonetech.biz.utils.jbpm.handler.TimerCreateActionHandler";
    private String timerActionHandlerClassName = "com.justonetech.biz.utils.handler.TimerActionHandler";
    private String decisionActionHandlerClassName = "com.justonetech.biz.utils.jbpm.handler.DecisionActionHandler";

    public String getNodeEnterActionHandlerClassName() {
        return nodeEnterActionHandlerClassName;
    }

    public void setNodeEnterActionHandlerClassName(String nodeEnterActionHandlerClassName) {
        this.nodeEnterActionHandlerClassName = nodeEnterActionHandlerClassName;
    }

    public String getTimerCreateActionHandlerClassName() {
        return timerCreateActionHandlerClassName;
    }

    public void setTimerCreateActionHandlerClassName(String timerCreateActionHandlerClassName) {
        this.timerCreateActionHandlerClassName = timerCreateActionHandlerClassName;
    }

    public String getTimerActionHandlerClassName() {
        return timerActionHandlerClassName;
    }

    public void setTimerActionHandlerClassName(String timerActionHandlerClassName) {
        this.timerActionHandlerClassName = timerActionHandlerClassName;
    }

    public String getDecisionActionHandlerClassName() {
        return decisionActionHandlerClassName;
    }

    public void setDecisionActionHandlerClassName(String decisionActionHandlerClassName) {
        this.decisionActionHandlerClassName = decisionActionHandlerClassName;
    }

    /**
     * 读取visio par包（本质是zip包）的xml文件，生成jbpm流程定义文件的内容。
     *
     * @param parFile
     * @return
     * @throws java.io.IOException
     * @throws javax.xml.bind.JAXBException
     */
    public String getJbpmXmlFromParFile(File parFile) throws IOException, JAXBException {
        //1.extract topology.xml from parfile
        String fileName = "";
        ZipEntry[] zipEntries = ParFileUtils.readEntriesFromZipfile(parFile);
        for (ZipEntry zipEntry : zipEntries) {
            if (zipEntry.getName().endsWith("topology.xml")) {
                fileName = zipEntry.getName();
            }
        }

        byte[] topology = ParFileUtils.readFileContentFromZipfile(parFile, fileName);
        if (topology == null) {
            throw new RuntimeException("读取topology.xml失败！");
        }
        String topologyXml = new String(topology, "UTF-8");
        return getJbpmXmlFromTopologyXml(topologyXml);


    }

    public String getJbpmXmlFromTopologyXml(String topologyXml) throws JAXBException {
        //2.unmarsh to processGraphic
        XMLReader reader = new XMLReader();
        VisioDocument visioDocument = reader.loadFromXml(topologyXml);
        Page page = visioDocument.getPages().getPage().get(0);
        ProcessGraphic processGraphic = new ProcessGraphic(page);

        //3.check model
        //todo:当前仅返回true
        boolean hasPassCheck = checkModel(processGraphic);
        if (!hasPassCheck) {
            log.error("没有通过合法性检查！");
            throw new RuntimeException("没有通过合法性检查！");
        }

        //4.mode to xml and return
        return modelToXml(processGraphic);
    }

    public String modelToXml(ProcessGraphic processGraphic) {
        Document document = DocumentHelper.createDocument();

        //create root element
        Element rootElement = DocumentHelper.createElement("process-definition");
        rootElement.addAttribute("xmlns", "");
        rootElement.addAttribute("name", processGraphic.getText());
        document.add(rootElement);

        //暂时不支持多个开始节点的情况
        if (processGraphic.getStarts().size() > 1 || processGraphic.getStarts().size() < 0) {
            log.error("流程有且只能有一个开始节点！");
            throw new RuntimeException("流程有且只能有一个开始节点！");
        }

        //start
        log.debug("start node to xml");
        List<Start> starts = processGraphic.getStarts();
        for (Start start : starts) {
            Element element = DocumentHelper.createElement("start-state");
            element.addAttribute("name", start.getText());

            for (int i = 0; i < start.getOutTransitions().size(); i++) {
                Transition transition = start.getOutTransitions().get(i);
                element.add(transition2Xml(transition));
            }
            document.getRootElement().add(element);
        }

        //task node
        log.debug("task node to xml");
        List<TaskNode> taskNodes = processGraphic.getTaskNodes();
        for (TaskNode taskNode : taskNodes) {
            Element element = DocumentHelper.createElement("task-node");
            element.addAttribute("name", taskNode.getText());
            element.addAttribute("create-tasks", "false");

            //设置node enter事件
            Element nodeElement = DocumentHelper.createElement("event");
            nodeElement.addAttribute("type", "node-enter");
            Element enterActionElement = DocumentHelper.createElement("action");

            enterActionElement.addAttribute("class", nodeEnterActionHandlerClassName);
            nodeElement.add(enterActionElement);
            element.add(nodeElement);

            //设置timer create 事件
//            Element timerCreateElement = DocumentHelper.createElement("event");
//            timerCreateElement.addAttribute("type", "timer-create");
//            timerCreateElement.addAttribute("duedate", "0 seconds");
//            timerCreateElement.addAttribute("repeat", "3 seconds");
//            Element createActionElement = DocumentHelper.createElement("action");
//            createActionElement.addAttribute("name", "createTimer");
//            createActionElement.addAttribute("class", timerCreateActionHandlerClassName);
//            Element timerNameElement = DocumentHelper.createElement("timerName");
//            timerNameElement.setText("aTaskTimer");
//            createActionElement.add(timerNameElement);
//            timerCreateElement.add(createActionElement);
//            element.add(timerCreateElement);
//
            Element taskElement = DocumentHelper.createElement("task");
            taskElement.addAttribute("name", taskNode.getText());
//            Element timerElement = DocumentHelper.createElement("timer");
//            timerElement.addAttribute("name", "taskTimer");
//            Element timerActionElement = DocumentHelper.createElement("action");
//            timerActionElement.addAttribute("class", timerActionHandlerClassName);
//            timerElement.add(timerActionElement);
//            taskElement.add(timerElement);
            element.add(taskElement);

            log.debug("taskNode " + taskNode.getText() + "\'s transition to xml");
            for (int i = 0; i < taskNode.getOutTransitions().size(); i++) {
                Transition transition = taskNode.getOutTransitions().get(i);
                element.add(transition2Xml(transition));
            }
            document.getRootElement().add(element);
        }

        //fork
        log.debug("fork to xml");
        List<Fork> forks = processGraphic.getForks();
        for (Fork fork : forks) {
            Element element = DocumentHelper.createElement("fork");
            element.addAttribute("name", fork.getText());
            log.debug("fork " + fork.getText() + "\'s transition to xml");
            for (int i = 0; i < fork.getOutTransitions().size(); i++) {
                Transition transition = fork.getOutTransitions().get(i);
                element.add(transition2Xml(transition));
            }
            document.getRootElement().add(element);
        }

        //join
        log.debug("join to xml");
        List<Join> joins = processGraphic.getJoins();
        for (Join join : joins) {
            Element element = DocumentHelper.createElement("join");
            element.addAttribute("name", join.getText());
            log.debug("join " + join.getText() + "\'s transition to xml");
            for (int i = 0; i < join.getOutTransitions().size(); i++) {
                Transition transition = join.getOutTransitions().get(i);
                element.add(transition2Xml(transition));
            }
            document.getRootElement().add(element);
        }

        //decision
        log.debug("decision node to xml");
        List<Decision> decisions = processGraphic.getDecisions();
        for (Decision decision : decisions) {
            Element element = DocumentHelper.createElement("decision");
            element.addAttribute("name", decision.getText());

            Element handlerElement = DocumentHelper.createElement("handler");
            handlerElement.addAttribute("class", decisionActionHandlerClassName);
            element.add(handlerElement);
            log.debug("decision " + decision.getText() + "\'s transition to xml");
            for (int i = 0; i < decision.getOutTransitions().size(); i++) {
                Transition transition = decision.getOutTransitions().get(i);
                element.add(transition2Xml(transition));
            }
            document.getRootElement().add(element);
        }

        //end
        log.debug("end node to xml");
        List<End> ends = processGraphic.getEnds();
        for (End end : ends) {
            Element element = DocumentHelper.createElement("end-state");

            element.addAttribute("name", end.getText());
            log.debug("end " + end.getText() + "\'s transition to xml");
            for (int i = 0; i < end.getOutTransitions().size(); i++) {
                Transition transition = end.getOutTransitions().get(i);
                element.add(transition2Xml(transition));
            }
            document.getRootElement().add(element);
        }

        //System.out.println("document = " + document.asXML());
        return document.asXML();
    }

    private Element transition2Xml(Transition transition) {
        Element element = DocumentHelper.createElement("transition");
        element.addAttribute("to", transition.getToNode().getText());
        element.addAttribute("name", transition.getText());
        return element;
    }

    /**
     * 对传入的ProcessGraphic对象进行图形合法性检查
     *
     * @param processGraphic
     * @return
     */
    public boolean checkModel(ProcessGraphic processGraphic) {
        Map<String, Long> nameMap = new HashMap<String, Long>();
        List<Start> starts = processGraphic.getStarts();
        if (starts.size() != 1) {
            log.error("流程有且只能有一个开始节点！");
        }
        for (Start start : starts) {
            checkName(start, "开始_", nameMap);
        }

        List<End> ends = processGraphic.getEnds();
        if (ends.size() != 1) {
            log.error("流程有且只能有一个结束节点！");
        }
        for (End end : ends) {
            checkName(end, "结束_", nameMap);
        }

        List<TaskNode> taskNodes = processGraphic.getTaskNodes();
        for (TaskNode taskNode : taskNodes) {
            checkName(taskNode, "结点_", nameMap);
        }

        List<Fork> forks = processGraphic.getForks();
        for (Fork fork : forks) {
            checkName(fork, "分发_", nameMap);
        }

        List<Join> joins = processGraphic.getJoins();
        for (Join join : joins) {
            checkName(join, "提交_", nameMap);
        }

        List<Decision> decisions = processGraphic.getDecisions();
        for (Decision decision : decisions) {
            checkName(decision, "选择_", nameMap);
        }

        List<Transition> transitions = processGraphic.getTransitions();
        for (Transition transition : transitions) {
            boolean hasConnected = checkTransition(transition);
            if (!hasConnected) {
                log.warn("ID为" + transition.getId() + "的边没有from结点或to结点，将被舍弃！");
                transitions.remove(transition);
            }
            checkName(transition, "提交_", nameMap);
        }

        //todo:目前没有对图的连通性进行检查
        //todo:目前只返回true
        return true;
    }

    /**
     * 对传入的GraphicElement对象进行名称检查
     * 1.名称为空，程序自动加上名称
     * 2.名称中含有特殊实际字符则去除
     * 3.名称重复，为第二个发现的对象改变名称
     *
     * @param graphicElement
     * @param elementPrefix
     * @param nameMap
     */
    private void checkName(GraphicElement graphicElement, String elementPrefix, Map<String, Long> nameMap) {
        String oldName = graphicElement.getText();
        //1.名称为空，程序自动加上名称
        if (oldName == null || oldName.equals("")) {
            oldName = elementPrefix + graphicElement.getId();
            log.warn("ID为" + graphicElement.getId() + "的结点名称为空，系统将自动修正，从" + graphicElement.getText() + "->" + oldName);
        }

        //2.名称中含有特殊实际字符则去除
        oldName = replaceSpecialChar(oldName);

        //3.名称重复，为第二个发现的对象改变名称
        Long Id = nameMap.get(oldName);
        //如果名称存在,加入map,如果名称存在，则修正名称，并加入map
        if (Id == null) {
            nameMap.put(oldName, graphicElement.getId());
        } else {
            //
            oldName = oldName + "_" + graphicElement.getId();
            log.warn("ID为" + graphicElement.getId() + "的结点名称重复，系统将自动修正，从" + graphicElement.getText() + "->" + oldName);
            nameMap.put(oldName, graphicElement.getId());
        }
        graphicElement.setText(oldName);
    }

    /**
     * 检查Transition是不是两端都是连接的
     *
     * @param transition 被检查
     */
    private boolean checkTransition(Transition transition) {
        boolean isChecked = true;
        String from = transition.getFrom();
        if (from == null || from.equals("")) {
            log.warn("transition " + transition.getText() + "\'s from is null");
            isChecked = false;
        }
        String to = transition.getTo();
        if (to == null || to.equals("")) {
            log.warn("transition " + transition.getText() + "\'s to is null");
            isChecked = false;
        }
        return isChecked;
    }

    public String replaceSpecialChar(String s) {
        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        Matcher m = p.matcher(s);
        s = m.replaceAll("");
        // 清除掉所有特殊字符
        String regEx = "[ `~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        p = Pattern.compile(regEx);
        m = p.matcher(s);
        return m.replaceAll("").trim();
    }

    private static final Log log = LogFactory.getLog(JbpmXmlDefTransfer.class);
}
