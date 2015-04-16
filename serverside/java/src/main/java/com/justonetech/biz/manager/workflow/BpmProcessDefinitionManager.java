package com.justonetech.biz.manager.workflow;

import com.justonetech.core.service.HibernateService;
import com.justonetech.core.utils.ParFileUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.SwimlaneManager;
import com.justonetech.biz.manager.workflow.handler.ProcessHandler;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.jbpm.node.DecisionDefinition;
import com.justonetech.biz.utils.jbpm.node.TaskNodeDefinition;
import com.justonetech.biz.utils.jbpm.service.JbpmService;
import com.justonetech.biz.utils.process.model.Node;
import com.justonetech.biz.utils.process.model.ProcessGraphic;
import com.justonetech.biz.utils.process.model.Swimlane;
import com.justonetech.biz.utils.process.util.JbpmXmlDefTransfer;
import com.justonetech.biz.utils.process.util.VmlHtmHelper;
import com.justonetech.biz.utils.process.visio.Page;
import com.justonetech.biz.utils.process.visio.VisioDocument;
import com.justonetech.biz.utils.process.visio.XMLReader;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.utils.SpringContextUtil;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.comparators.ComparatorChain;
import org.apache.xml.serializer.Method;
import org.apache.xml.serializer.OutputPropertiesFactory;
import org.apache.xml.serializer.Serializer;
import org.apache.xml.serializer.SerializerFactory;
import org.hibernate.EntityMode;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.def.Transition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.xml.sax.ContentHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.*;
import java.util.zip.ZipEntry;


/**
 * 流程定义
 *
 * @version 1.0
 * @author: Ma Ji
 * @since: 2009-4-20
 */
@Service
public class BpmProcessDefinitionManager {

    private Logger logger = LoggerFactory.getLogger(BpmProcessDefinitionManager.class);

    @Autowired
    private BpmProcessDefinitionService bpmProcessDefinitionService;

    @Autowired
    private BpmProcessTransitionService bpmProcessTransitionService;

    @Autowired
    private BpmProcessDefinitionFormService bpmProcessDefinitionFormService;

    @Autowired
    private BpmNodeDefinitionService bpmNodeDefinitionService;

    @Autowired
    private BpmProcessSwimlaneService bpmProcessSwimlaneService;

    @Autowired
    private BpmTaskSwimlaneService bpmTaskSwimlaneService;

    @Autowired
    private JbpmService jbpmService;

    @Autowired
    private BpmProcessTemplateService bpmProcessTemplateService;

    @Autowired
    private SwimlaneManager swimlaneManager;

    @Autowired
    private BpmProcessInstanceManager bpmProcessInstanceManager;

    @Autowired
    private HibernateService hibernateService;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    private SysCodeManager sysCodeManager;

    /**
     * 本方法用于从bpmProcessDefinetionId中的
     * byte[]型的VisioPar文件中取得文件名为fileName的文件内容
     *
     * @param bpmProcessDefinetionId
     * @param fileName
     * @return byte[]文件内容，找不到则返回null
     * @throws java.io.IOException
     */
    public byte[] getFileBytesFromParFile(Long bpmProcessDefinetionId, String fileName) throws IOException {
        byte[] ret = null;
        BpmProcessDefinition bpmProcessDefinition = bpmProcessDefinitionService.get(bpmProcessDefinetionId);
        byte[] bytes = bpmProcessDefinition.getProcessTemplate().getVisioPar();
        ZipEntry[] zipEntries = ParFileUtils.readEntriesFromByteArray(bytes);
        for (ZipEntry zipEntry : zipEntries) {
            if (zipEntry.getName().endsWith(fileName)) {
                ret = ParFileUtils.readFileContentFromByteArray(bytes, zipEntry.getName());
                break;
            }
        }
        return ret;
    }

    /**
     * 简单检查topology.xml文件是否正确
     *
     * @return
     */
    public String checkTopology(String topologyXml) {
        XMLReader reader = new XMLReader();
        VisioDocument visioDocument = null;
        try {
            visioDocument = reader.loadFromXml(topologyXml);
        } catch (JAXBException e) {
//            e.printStackTrace();
            logger.debug(e.getMessage());
        }
        Page page = null;
        if (visioDocument != null) {
            page = visioDocument.getPages().getPage().get(0);
        }
        ProcessGraphic graphic = new ProcessGraphic();
        graphic.processAllShapes(page);
        return graphic.checkRalationships();
    }

    /**
     * 获取流程VML页面代码(process shape + swimlane shape + emz link + group tag)
     *
     * @param bpmProcessTemplateId .
     * @return .
     * @throws Exception .
     */
    public String getVmlHtml(Long bpmProcessTemplateId) throws Exception {
        String vmlBlock = "";
        BpmProcessTemplate template = bpmProcessTemplateService.get(bpmProcessTemplateId);
        String vmlHtml = template.getVmlHtml();
        String topologyXml = template.getTopologyXml();

        //因html代码js段中包含有group标记，所以不能直接取group段代码。
        vmlBlock = StringHelper.getElementValue(vmlHtml, "<body", "</body>");
        String startTag = "<v:group";
        String endTag = "</v:group>";
        vmlBlock = StringHelper.getElementValue(vmlBlock, startTag, endTag);

        //替换其中的图片链接(2个参数均可)
        //vmlBlock = StringHelperer.findAndReplace(vmlBlock, "vml_1.emz","${ctx}/workflow/bpmProcessDefinition/getEmz.html?id="+processDefinitionId);
        vmlBlock = StringHelper.findAndReplace(vmlBlock, "vml_1.emz", "../bpmProcessDefinition/getEmz.do?processTemplateId=" + bpmProcessTemplateId);

        String swimlanes = VmlHtmHelper.getSwimlaneShapesVml(topologyXml, vmlHtml);

        return startTag + vmlBlock + swimlanes + endTag;
    }

    /**
     * 根据topology.xml生成ProcessGraphic，并填写各bpm表
     *
     * @param bpmProcessDefinition
     */
    public void cascadeSaveProcessDefinition(BpmProcessDefinition bpmProcessDefinition) {
        ProcessGraphic graphic = getProcessGraphic(bpmProcessDefinition);

        if (graphic != null) {
            Map<String, BpmProcessSwimlane> swimlaneMap = new HashMap<String, BpmProcessSwimlane>();

            //写与BpmProcessDefinition相关联的BpmProcessSwimlane
            List<Swimlane> swimlanes = graphic.getSwimlanes();
            for (Swimlane swimlane : swimlanes) {
                BpmProcessSwimlane bpmProcessSwimlane = new BpmProcessSwimlane();
                bpmProcessSwimlane.setName(swimlane.getText());
                bpmProcessSwimlane.setShapeId(swimlane.getId());
                if (swimlane.getId() == null) {
                    logger.warn(swimlane.getText() + ": 该图形节点的id为空");
                }
                bpmProcessSwimlane.setProcessDefinition(bpmProcessDefinition);
                bpmProcessSwimlaneService.save(bpmProcessSwimlane);
                swimlaneMap.put(bpmProcessSwimlane.getName(), bpmProcessSwimlane);
            }

            //写与BpmProcessDefinition相关联的BpmNodeDefinition
            List<Node> nodes = graphic.getNodes();

            for (Node node : nodes) {
                logger.debug("the node is:" + node.getText());
                BpmNodeDefinition definition = getNodeDefinition(node);
                definition.setProcessDefinition(bpmProcessDefinition);
                definition.setName(node.getText());
                definition.setShapeId(node.getId());
                if (node.getId() == null) {
                    logger.warn(node.getText() + ": 该图形节点的id为空");
                }
                bpmNodeDefinitionService.save(definition);

                //算出任务所属的process swimlane
                Swimlane swimlane = node.getSwimlane();
                BpmTaskSwimlane bpmTaskSwimlane = new BpmTaskSwimlane();
                bpmTaskSwimlane.setName(node.getText());
                bpmTaskSwimlane.setTask(definition);
                BpmProcessSwimlane bpmProcessSwimlane = swimlaneMap.get(swimlane.getText());
                logger.debug("bpmProcessSwimlane is {},and swimlane.getText() is {}", bpmProcessSwimlane, swimlane.getText());
                bpmTaskSwimlane.setProcessSwimlane(bpmProcessSwimlane);

                bpmTaskSwimlaneService.save(bpmTaskSwimlane);
            }

            //得到图中的transition
            List<com.justonetech.biz.utils.process.model.Transition> transitions = graphic.getTransitions();
            for (com.justonetech.biz.utils.process.model.Transition transition : transitions) {
                BpmProcessTransition bpmProcessTransition = new BpmProcessTransition();
                bpmProcessTransition.setName(transition.getText());
                bpmProcessTransition.setShapeId(transition.getId());
                if (transition.getId() == null) {
                    logger.warn(transition.getText() + ": 该图形节点的id为空");
                }
                bpmProcessTransition.setFrom(getNodeByShapeId(bpmProcessDefinition.getId(), transition.getFromNode().getId()));
                bpmProcessTransition.setTo(getNodeByShapeId(bpmProcessDefinition.getId(), transition.getToNode().getId()));
                bpmProcessTransition.setProcessDefinition(bpmProcessDefinition);
                bpmProcessTransitionService.save(bpmProcessTransition);
            }
        }
    }

    /**
     * 从流程定义中得到ProcessGraphic对象
     *
     * @param bpmProcessDefinition
     * @return
     */
    private ProcessGraphic getProcessGraphic(BpmProcessDefinition bpmProcessDefinition) {
        BpmProcessTemplate template = bpmProcessDefinition.getProcessTemplate();
        ProcessGraphic graphic = null;

        try {
            graphic = unmarsh2ProcessGraphic(template.getTopologyXml());
        } catch (JAXBException e) {
            logger.error("can't unmarsh topology xml to process definition!", e);
//            e.printStackTrace();
        }
        return graphic;
    }

    /**
     * 得到指定node的swimlane
     *
     * @param bpmNodeDefinition
     * @return
     */
    private Swimlane getVisioSwimlane(BpmNodeDefinition bpmNodeDefinition) {
        Long shapeId = bpmNodeDefinition.getShapeId();
        ProcessGraphic graphic = getProcessGraphic(bpmNodeDefinition.getProcessDefinition());
        List<Node> nodes = graphic.getNodes();
        for (Node node : nodes) {
            if (shapeId.equals(node.getId())) {
                return node.getSwimlane();
            }
        }
        logger.error("can not find swimlane,shapeId is :" + shapeId);
        return null;
    }

    /**
     * 得到指定node的swimlan的id
     *
     * @param bpmNodeDefinition
     * @return
     */
    public Long getVisioSwimlaneId(BpmNodeDefinition bpmNodeDefinition) {
        if (bpmNodeDefinition == null) {
            return null;
        }
        Swimlane swimlane = getVisioSwimlane(bpmNodeDefinition);
        return swimlane.getId();
    }

    /**
     * 通过processDefinitionId，shapeId查找BpmNodeDefinition
     *
     * @param processDefinitionId
     * @param shapeId
     * @return
     */
    public BpmNodeDefinition getNodeByShapeId(Long processDefinitionId, Long shapeId) {
        String hql = "from BpmNodeDefinition t where t.processDefinition.id=" + processDefinitionId + " and t.shapeId=" + shapeId;
        return bpmNodeDefinitionService.findUnique(hql);
    }

    /**
     * 清空被级联保存的process definition
     *
     * @param bpmProcessDefinition
     */
    public void clearProcessDefintion(BpmProcessDefinition bpmProcessDefinition) {

        //delete process transition
        Set<BpmProcessTransition> processTransitions = bpmProcessDefinition.getBpmProcessTransitions();
        for (BpmProcessTransition processTransition : processTransitions) {
            bpmProcessTransitionService.delete(processTransition);
        }

        //delete process node and task swimlane
        Set<BpmNodeDefinition> bpmNodeDefinitions = bpmProcessDefinition.getBpmNodeDefinitions();
        for (BpmNodeDefinition bpmNodeDefinition : bpmNodeDefinitions) {
            BpmTaskSwimlane taskSwimlane = bpmNodeDefinition.getBpmTaskSwimlane();
            if (taskSwimlane != null) {
                bpmTaskSwimlaneService.delete(taskSwimlane);
            }
            bpmNodeDefinitionService.delete(bpmNodeDefinition);
        }

        //delete process swimlane
        Set<BpmProcessSwimlane> swimlanes = bpmProcessDefinition.getBpmProcessSwimlanes();
        for (BpmProcessSwimlane swimlane : swimlanes) {
            bpmProcessSwimlaneService.delete(swimlane);
        }

        bpmProcessDefinitionService.save(bpmProcessDefinition);
    }

    /**
     * 布署bpmProcessDefinition。
     * 步骤：先布署jbpmProcessDefinition,再把信息回填到各bpm表中
     *
     * @param bpmProcessDefinition
     * @throws javax.xml.bind.JAXBException
     */
    public void deployBpmProcessDefinition(BpmProcessDefinition bpmProcessDefinition) throws JAXBException {
        //        if (!checkProcessDefinition(bpmProcessDefinition)) {
        //            throw new RuntimeException("process definition can not throgh pass check!");
        //        }

        //step1:deploy jBPM process definition
        String topologyXml = bpmProcessDefinition.getProcessTemplate().getTopologyXml();
        JbpmXmlDefTransfer jbpmXmlDefTransfer = new JbpmXmlDefTransfer();
        String processDefinitionXml = jbpmXmlDefTransfer.getJbpmXmlFromTopologyXml(topologyXml);
        logger.debug("processDefinitionXml is {}", processDefinitionXml);
        ProcessDefinition processDefinition = ProcessDefinition.parseXmlString(processDefinitionXml);
        jbpmService.deployProcessDefinition(processDefinition);

        //step2:set jBPM process definition id
        bpmProcessDefinition.setJbpmDefinitionId(processDefinition.getId());
        bpmProcessDefinitionService.save(bpmProcessDefinition);

        //step3:set jBPM process node id
        Map nodesMap = processDefinition.getNodesMap();
        Set<BpmNodeDefinition> bpmNodeDefinitions = bpmProcessDefinition.getBpmNodeDefinitions();
        for (BpmNodeDefinition bpmNodeDefinition : bpmNodeDefinitions) {
            org.jbpm.graph.def.Node node = (org.jbpm.graph.def.Node) nodesMap.get(bpmNodeDefinition.getName());
            if (node != null) {
                bpmNodeDefinition.setJbpmNodeId(node.getId());
            }

            //step4:set jBPM transition id
            List<Transition> leavingTransitions = node.getLeavingTransitions();
            Map<String, Transition> transitionMap = new HashMap<String, Transition>();
            if (leavingTransitions != null) {
                for (Transition leavingTransition : leavingTransitions) {
                    transitionMap.put(leavingTransition.getName(), leavingTransition);
                }

                List<BpmProcessTransition> processTransitions = getLeavingTransitions(bpmNodeDefinition);
                for (BpmProcessTransition processTransition : processTransitions) {
                    Transition transition = transitionMap.get(processTransition.getName());
                    if (transition != null) {
                        processTransition.setJbpmTransitionId(transition.getId());
                    }
                }
            }
        }
    }

    /**
     * 如果是第一次调用，则nodeDefinition字段为空，需要初始化
     *
     * @param bpmNodeDefinition
     * @throws javax.xml.bind.JAXBException
     * @throws java.io.IOException
     */
    public void initTaskNodeDefinition(BpmNodeDefinition bpmNodeDefinition) throws JAXBException, IOException {
        TaskNodeDefinition taskNodeDefinition = new TaskNodeDefinition();
        taskNodeDefinition.setCanForward(false);
        taskNodeDefinition.setCanTerminate(false);
        taskNodeDefinition.setDefaultTransitionName("");
        taskNodeDefinition.setEarlyWarningType("");
        taskNodeDefinition.setInitScript("");
        taskNodeDefinition.setTaskCreateType("");
        taskNodeDefinition.setTimeOutAction("");
        taskNodeDefinition.setSelectUser(false);
        taskNodeDefinition.setOperateType(TaskNodeDefinition.OPERATION_TYPE_STANDARD);
        taskNodeDefinition.setDateType(TaskNodeDefinition.DAY_TYPE_WORK_DAY);
        List<BpmProcessTransition> leavingTransitions = getLeavingTransitions(bpmNodeDefinition);
        if (leavingTransitions != null && leavingTransitions.size() > 0) {
            taskNodeDefinition.setDefaultTransitionName(String.valueOf(leavingTransitions.get(0).getId()));
        }
        Set<BpmProcessDefinitionForm> bpmProcessDefinitionFormSet = bpmNodeDefinition.getProcessDefinition().getBpmProcessDefinitionForms();
        if (bpmProcessDefinitionFormSet != null && bpmProcessDefinitionFormSet.size() > 0) {
            Iterator<BpmProcessDefinitionForm> formIterator = bpmProcessDefinitionFormSet.iterator();
            BpmProcessDefinitionForm bpmProcessDefinitionForm = formIterator.next();
            taskNodeDefinition.setFormId(bpmProcessDefinitionForm.getFormTemplate().getId());
        }

        String s = marshallTaskNodeDefinition(taskNodeDefinition);
        bpmNodeDefinition.setNodeDefinition(s);
    }

    /**
     * 如果是第一次调用，则nodeDefinition字段为空，需要初始化
     *
     * @param bpmNodeDefinition
     * @throws javax.xml.bind.JAXBException
     */
    public void initDecisionNodeDefinition(BpmNodeDefinition bpmNodeDefinition) throws JAXBException, IOException {
        List<BpmProcessTransition> leavingTransitions = getLeavingTransitions(bpmNodeDefinition);

        String transitions[] = new String[leavingTransitions.size()];
        String conditions[] = new String[leavingTransitions.size()];
        String defaultTransition = "";

        for (int i = 0; i < leavingTransitions.size(); i++) {
            BpmProcessTransition leavingTransition = leavingTransitions.get(i);
            if (defaultTransition.equals("")) {
                defaultTransition = leavingTransition.getName();
            }
            transitions[i] = leavingTransition.getName();
        }
        DecisionDefinition decisionDefinition = new DecisionDefinition();
        decisionDefinition.setConditions(conditions);
        decisionDefinition.setTransitions(transitions);
        decisionDefinition.setDefaultTransition(defaultTransition);
        String s = marshallDecisionDefinition(decisionDefinition);
        logger.debug("marshalled decision definition is {}", s);
        bpmNodeDefinition.setNodeDefinition(s);
    }

    /**
     * 得到TransitionMap
     *
     * @param bpmNodeDefinition
     * @return
     */
    public Map<String, String> getTransitionMap(BpmNodeDefinition bpmNodeDefinition) {
        Map<String, String> transitionMap = new HashMap<String, String>();
        List<BpmProcessTransition> leavingTransitions = getLeavingTransitions(bpmNodeDefinition);
        for (BpmProcessTransition leavingTransition : leavingTransitions) {
            transitionMap.put(leavingTransition.getName(), leavingTransition.getTo().getName());
        }
        return transitionMap;
    }


    /**
     * 根据BpmNodeDefinition得到jbpmNodeId,再得到node的leaving transition
     *
     * @return
     */
    public List<BpmProcessTransition> getLeavingTransitions(BpmNodeDefinition bpmNodeDefinition) {
        String hql = "from BpmProcessTransition t where t.from.id =" + bpmNodeDefinition.getId();
        return bpmProcessTransitionService.findByQuery(hql);
    }

    /**
     * @param node
     * @return
     */
    private BpmNodeDefinition getNodeDefinition(Node node) {
        BpmNodeDefinition bpmNodeDefinition = new BpmNodeDefinition();
        bpmNodeDefinition.setName(node.getName());
        bpmNodeDefinition.setNodeType(toJbpmNodeType(node.getNodeType()));
        return bpmNodeDefinition;
    }

    /**
     * @param topologyXml
     * @return
     * @throws javax.xml.bind.JAXBException
     */
    private ProcessGraphic unmarsh2ProcessGraphic(String topologyXml) throws JAXBException {
        XMLReader reader = new XMLReader();
        VisioDocument visioDocument = reader.loadFromXml(topologyXml);
        Page page = visioDocument.getPages().getPage().get(0);
        ProcessGraphic graphic = new ProcessGraphic(page);
        JbpmXmlDefTransfer jbpmXmlDefTransfer = new JbpmXmlDefTransfer();
        //检查名称
        jbpmXmlDefTransfer.checkModel(graphic);
        return graphic;
    }

    /**
     * @param taskNodeDefinition
     * @return
     * @throws java.io.IOException
     * @throws javax.xml.bind.JAXBException
     */
    public String marshallTaskNodeDefinition(TaskNodeDefinition taskNodeDefinition) throws IOException, JAXBException {
        // specify which of your elements you want to be handled as CDATA.
        // The use of the '^' between the namespaceURI and the localname
        // seems to be an implementation detail of the xerces code.
        // When processing xml that doesn't use namespaces, simply omit the
        // namespace prefix as shown in the third CDataElemen

        Properties props = OutputPropertiesFactory.getDefaultMethodProperties(Method.XML);
        props.setProperty("cdata-section-elements", "defaultTransition;conditions");

        return marshall(taskNodeDefinition, props);
    }

    /**
     * @param decisionDefinition
     * @return
     * @throws java.io.IOException
     * @throws javax.xml.bind.JAXBException
     */
    public String marshallDecisionDefinition(DecisionDefinition decisionDefinition) throws IOException, JAXBException {
        // specify which of your elements you want to be handled as CDATA.
        // The use of the '^' between the namespaceURI and the localname
        // seems to be an implementation detail of the xerces code.
        // When processing xml that doesn't use namespaces, simply omit the
        // namespace prefix as shown in the third CDataElemen

        Properties props = OutputPropertiesFactory.getDefaultMethodProperties(Method.XML);
        props.setProperty("cdata-section-elements", "defaultTransition conditions");

        return marshall(decisionDefinition, props);
    }

    /**
     * @param o
     * @param props
     * @return
     * @throws javax.xml.bind.JAXBException
     * @throws java.io.IOException
     */
    private String marshall(Object o, Properties props) throws JAXBException, IOException {
        // set any other options you'd like

        //该属性设置为true，生成的xml会缩进
        props.setProperty("indent", "no");

        Serializer serializer = SerializerFactory.getSerializer(props);

        Writer writer = new StringWriter();
        serializer.setWriter(writer);

        ContentHandler contentHandler = serializer.asContentHandler();

        JAXBContext jc = JAXBContext.newInstance(o.getClass());
        Marshaller marshaller = jc.createMarshaller();
        marshaller.marshal(o, contentHandler);

        return writer.toString();
    }

    /**
     * C: org.jbpm.graph.node.ProcessState
     * D: org.jbpm.graph.node.Decision
     * E: org.jbpm.graph.node.EndState
     * F: org.jbpm.graph.node.Fork
     * J: org.jbpm.graph.node.Join
     * K: org.jbpm.graph.node.TaskNode
     * N: org.jbpm.graph.def.Node
     * R: org.jbpm.graph.node.StartState
     * S: org.jbpm.graph.node.State
     * U: org.jbpm.graph.def.SuperState
     * protected final static int START_Element = 1;
     * protected final static int END_Element = 2;
     * protected final static int STATE_Element = 3;
     * protected final static int FORK_Element = 4;
     * protected final static int JOIN_Element = 5;
     * protected final static int DECISION_Element = 6;
     * protected final static int NODE_Element = 7;
     * protected final static int TASK_Element = 8;
     */
    public String toJbpmNodeType(int nodeType) {
        switch (nodeType) {
            case 1:
                return "R";
            case 2:
                return "E";
            case 3:
                return "S";
            case 4:
                return "F";
            case 5:
                return "J";
            case 6:
                return "D";
            case 7:
                return "N";
            case 8:
                return "K";
            default:
                return "";
        }
    }

    /**
     * 删除流程定义上的所有实例
     *
     * @param bpmProcessDefinition
     */
    public void removeProcessInstanceByDefinition(BpmProcessDefinition bpmProcessDefinition) {
        Set<BpmProcessInstance> bpmProcessInstances = bpmProcessDefinition.getBpmProcessInstances();
        for (BpmProcessInstance bpmProcessInstance : bpmProcessInstances) {
            bpmProcessInstanceManager.removeProcessInstance(bpmProcessInstance);
        }
    }

    /**
     * 删除流程定义
     *
     * @param bpmProcessDefinition
     */
    public void removeProcessDefintion(BpmProcessDefinition bpmProcessDefinition) {
        Set<BpmProcessDefinitionForm> bpmProcessDefinitionForms = bpmProcessDefinition.getBpmProcessDefinitionForms();
        for (BpmProcessDefinitionForm bpmProcessDefinitionForm : bpmProcessDefinitionForms) {
            bpmProcessDefinitionFormService.delete(bpmProcessDefinitionForm);
        }
        clearProcessDefintion(bpmProcessDefinition);
        bpmProcessDefinitionService.delete(bpmProcessDefinition);
    }

    /**
     * 得到所有业务类名及中文表名
     *
     * @return
     */
    public List<Map> getAllBizClass() {
        List<Map> bizClasses = new ArrayList<Map>();
        Map<String, String> comments = getComments();
        Map allClassMetadata = hibernateService.getSession().getSessionFactory().getAllClassMetadata();
        for (Object key : allClassMetadata.keySet()) {
            Object value = allClassMetadata.get(key);
            if (value instanceof AbstractEntityPersister) {
                AbstractEntityPersister abstractEntityPersister = (AbstractEntityPersister) value;
                Class clazz = abstractEntityPersister.getMappedClass(EntityMode.POJO);
                String packageName = clazz.getPackage().getName();
                if (packageName.endsWith("domain")) {
                    Map<String, String> bizClass = new HashMap<String, String>();
                    String tableName = abstractEntityPersister.getTableName().toUpperCase();
                    String comment = comments.get(tableName);
                    bizClass.put("tableName", tableName);
                    if (StringHelper.isEmpty(comment)) {
                        comment = tableName;
                    }
                    bizClass.put("comment", comment);
                    bizClass.put("className", clazz.getName());
                    bizClasses.add(bizClass);
                }
            }
        }

        //顺序
        Comparator mycmp = ComparatorUtils.NATURAL_COMPARATOR;
        ArrayList<Object> sortFields = new ArrayList<Object>();
        //按字段submitTime排序
        sortFields.add(new BeanComparator("comment", mycmp));
        ComparatorChain multiSort = new ComparatorChain(sortFields);
        Collections.sort(bizClasses, multiSort);
        return bizClasses;
    }

    /**
     * 从数据库中获取表名和注释
     *
     * @return
     */
    public Map<String, String> getComments() {
        Map<String, String> comments = new HashMap<String, String>();
        String sql = "select u.table_name,u.comments from user_tab_comments u";
        List<Object[]> list = hibernateService.findBySql(sql);
        for (Object[] objects : list) {
            String tableName = (String) objects[0];
            String comment = (String) objects[1];
            if (comment == null) {
                comment = tableName;
            }
            comments.put(tableName, comment);
        }
        return comments;
    }

    /**
     * 根据业务编码获取有效流程定义--用于业务绑定流程
     *
     * @param bizCode
     * @return
     */
    public BpmProcessDefinition getValidBpmProcessDefinition(String bizCode) {
        List<BpmProcessDefinition> list = bpmProcessDefinitionService.findByQuery("from BpmProcessDefinition where bizObject='" + bizCode + "' and isValid=1 order by version desc");
        if (list.size() > 0) {
            return list.iterator().next();
        } else {
            return null;
        }
    }

    /**
     * 根据流程编码获取有效流程定义
     *
     * @param processDefinitionCode
     * @return
     */
    public BpmProcessDefinition getBpmProcessDefinition(String processDefinitionCode) {
        List<BpmProcessDefinition> list = bpmProcessDefinitionService.findByQuery("from BpmProcessDefinition where code='" + processDefinitionCode + "' and isValid=1 order by version desc");
        if (list.size() > 0) {
            return list.iterator().next();
        } else {
            return null;
        }
    }

    /**
     * 根据流程定义关联的业务对象取出process handler
     * process handler的类名定义规则为:业务对象类名＋ProcessHandler
     * 获取失败不抛出异常
     *
     * @param bpmProcessDefinition
     * @return
     */
    public ProcessHandler getProcessHandler(BpmProcessDefinition bpmProcessDefinition) {
        String bizClassName = bpmProcessDefinition.getBizObject();
        ProcessHandler processHandler = null;
        try {
            Class bizClass = Class.forName(bizClassName);
            if (bizClass != null) {
                String bizClassSimpleName = bizClass.getSimpleName();
                //首字母改为小写
                bizClassSimpleName = bizClassSimpleName.substring(0, 1).toLowerCase() + bizClassSimpleName.substring(1, bizClassSimpleName.length());
                processHandler = (ProcessHandler) SpringContextUtil.getBean(bizClassSimpleName + "ProcessHandler");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return processHandler;
    }

    /**
     * 获取不重复的最新版本的流程定义---供业务流程实例调用
     *
     * @return .
     */
    public List<BpmProcessDefinition> getBpmProcessDefinitionList(Long categoryId) {
        return getBpmProcessDefinitionList(categoryId, true);
    }

    /**
     * 获取不重复的最新版本的流程定义---供流程定义调用
     *
     * @param isShowInValid 是否显示未生效的定义
     * @return .
     */
    public List<BpmProcessDefinition> getBpmProcessDefinitionListByCode(String categoryCode, Boolean isShowInValid) {
        if (!StringHelper.isEmpty(categoryCode)) {
            if (!"all".equals(categoryCode)) {
                SysCodeDetail detailByCode = sysCodeManager.getCodeDetailByCode(Constants.BPM_PROCESS_DEFINITION_CATEGORY, categoryCode);
                if (detailByCode != null) {
                    return getBpmProcessDefinitionList(detailByCode.getId(), isShowInValid);
                }
            } else {
                return getBpmProcessDefinitionList(null, isShowInValid);
            }
        }
        return new ArrayList<BpmProcessDefinition>();
    }

    public List<BpmProcessDefinition> getBpmProcessDefinitionList(Long categoryId, Boolean isShowInValid) {
        List<BpmProcessDefinition> ret = new ArrayList<BpmProcessDefinition>();

        String hql = "from BpmProcessDefinition where 1=1";
        if (categoryId != null) {
            hql += " and category.id=" + categoryId;
        }
        if (!isShowInValid) {
            hql += " and isValid=1";
        }
        hql += " order by orderNo asc,version desc";
        List<BpmProcessDefinition> bpmProcessDefinitions = bpmProcessDefinitionService.findByQuery(hql);

        HashSet hs = new HashSet();
        for (BpmProcessDefinition bpmProcessDefinition : bpmProcessDefinitions) {
            String code = bpmProcessDefinition.getCode();
            if (!hs.contains(code)) {
                hs.add(code);
                ret.add(bpmProcessDefinition);
            }
        }
        return ret;
    }
}
