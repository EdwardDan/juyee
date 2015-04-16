package com.justonetech.biz.manager.workflow;

import com.justonetech.core.service.HibernateService;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.daoservice.BpmFormActionService;
import com.justonetech.biz.daoservice.BpmProcessDefinitionService;
import com.justonetech.biz.daoservice.BpmProcessInstanceService;
import com.justonetech.biz.daoservice.BpmTaskInstanceService;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.workflow.handler.ProcessHandler;
import com.justonetech.biz.utils.BizDataGenerator;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.dom4j.xpath.DefaultXPath;
import org.htmlparser.util.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.xml.bind.JAXBException;
import java.io.Serializable;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * 本类拟作为jBPM模块保存表单数据，
 * 但目前没有重构，只是作为流程与业务对象进行数据交互
 *
 * @version 1.0
 * @author: Ma Ji,Chen Junping
 * @since: 2009-7-14
 */
@Service
public class BpmProcessFormDataManager {
    private Logger logger = LoggerFactory.getLogger(BpmProcessDefinitionManager.class);

    @Autowired
    private BpmProcessDefinitionService bpmProcessDefinitionService;

    @Autowired
    private BpmProcessInstanceService bpmProcessInstanceService;

    @Autowired
    private BpmTaskInstanceManager bpmTaskInstanceManager;

    @Autowired
    private BpmFormActionService bpmFormActionService;

    @Autowired
    private BpmTaskInstanceService bpmTaskInstanceService;

    @Autowired
    private BpmProcessInstanceManager bpmProcessInstanceManager;

    @Autowired
    private HibernateService hibernateService;

    @Autowired
    private BpmProcessDefinitionManager bpmProcessDefinitionManager;

    /**
     * 保存表单数据，此处为进入流程的第一个节点的时候，把从业务表单读取过来的数据写入表单
     * todo:此方法与BpmProcessInstanceManager的方法有重合的地方，待整合
     *
     * @param xmlData
     * @param bpmTaskInstance
     * @throws javax.xml.bind.JAXBException
     * @throws javax.script.ScriptException
     * @throws org.dom4j.DocumentException
     * @throws ParserException
     */
    public void saveFormData(String xmlData, BpmTaskInstance bpmTaskInstance) throws Exception, ScriptException, DocumentException, ParserException {
        BpmFormAction bpmFormAction = new BpmFormAction();
        String savedXml = bpmFormAction.getFormXml();

        // 根据bpmTaskInstance取对应模板
        BpmFormTemplate bpmFormTemplate = bpmTaskInstanceManager.getBpmFormTemplate(bpmTaskInstance);

        BpmFormData bpmFormData = bpmProcessInstanceManager.getBpmFormData(bpmTaskInstance.getProcessInstance(), bpmFormTemplate);
        if (bpmFormData != null && StringHelper.isEmpty(savedXml)) {
            savedXml = bpmFormData.getFormXml();
        }

        if (!StringHelper.isEmpty(savedXml)) {
            xmlData = BizDataGenerator.generateBizData(xmlData, savedXml);
//        } else {
//            xmlData = BizDataGenerator.generateBizData(xmlData);
        }

        //保存数据
        bpmFormAction.setFormXml(xmlData);
        bpmFormAction.setTaskInstance(bpmTaskInstance);
        bpmFormAction.setProcessInstance(bpmTaskInstance.getProcessInstance());

        bpmTaskInstanceService.save(bpmTaskInstance);
        bpmFormActionService.save(bpmFormAction);

        //保存
        bpmTaskInstanceManager.saveCustomColumnData(bpmTaskInstance, bpmFormData, xmlData);
    }

    /**
     * 从业务表单读取数据写入表单
     * initXml:初始化脚本
     * eg:var orgXml=null;scriptHelper.generateXml(orgXml,'ykbm',biz.requireDeptName);
     *
     * @param bpmTaskInstance
     * @throws javax.script.ScriptException
     * @throws javax.xml.bind.JAXBException
     * @throws org.dom4j.DocumentException
     * @throws ParserException
     */
    public void saveFormDataFromBizObject(BpmTaskInstance bpmTaskInstance) throws Exception, JAXBException, DocumentException, ParserException {
        BpmProcessInstance bpmProcessInstance = bpmTaskInstance.getProcessInstance();
        if (bpmProcessInstanceManager.isTokenInFirstTaskNode(bpmProcessInstance)) {
            Object bizObject = getBizObjectByProcessInstance(bpmProcessInstance);
            if (bizObject != null) {
                String initXml = processScript(bizObject, bpmProcessInstance.getProcessDefinition().getInitScript());
                logger.debug("get init xml is :" + initXml);
                saveFormData(initXml, bpmTaskInstance);

                //调用ProcessHandler的实现类的onCreate方法
                ProcessHandler processHandler = bpmProcessDefinitionManager.getProcessHandler(bpmProcessInstance.getProcessDefinition());
                if (processHandler != null) {
                    System.out.println(">>.................. =%5%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%444444444 ");
                    processHandler.onCreate(bizObject);
                }
            }
        }
    }

    /**
     * 查找业务类对应的流程定义
     *
     * @param className
     * @return
     */
    public BpmProcessDefinition getProcessDefinitionByBizClass(String className) {
        List<BpmProcessDefinition> bpmProcessDefinitions = bpmProcessDefinitionService.findAll();
        for (BpmProcessDefinition bpmProcessDefinition : bpmProcessDefinitions) {
            String bizClassName = bpmProcessDefinition.getBizObject();
            if (className.equals(bizClassName)) {
                return bpmProcessDefinition;
            }
        }

        return null;
    }

    /**
     * 通过process instance得到业务对象
     *
     * @param bpmProcessInstance
     * @return
     */
    public Object getBizObjectByProcessInstance(BpmProcessInstance bpmProcessInstance) {
        Long id = bpmProcessInstance.getBizObjectId();
        logger.debug("id = " + id);
        String objectClass = bpmProcessInstance.getProcessDefinition().getBizObject();
        logger.debug("objectClass = " + objectClass);
        if (objectClass != null && id != null) {
            String hql = "from " + objectClass + " t where 1=1 and t.id=" + id;
            return hibernateService.findUnique(hql);
        }
        return null;
    }

    /**
     * 执行脚本读取业务对象的属性
     *
     * @param bizObject
     * @param initScript
     * @return
     * @throws javax.script.ScriptException
     */
    public String processScript(Object bizObject, String initScript) throws ScriptException {
        String ret = "";
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        engine.put("biz", bizObject);
        ScriptHelper scriptHelper = new ScriptHelper();
        engine.put("scriptHelper", scriptHelper);
        if (!StringUtils.isBlank(initScript)) {

            ret = String.valueOf(engine.eval(initScript));
        }
        return ret;
    }


    /**
     * 用表单数据更新业务对象
     * eg:scriptHelper .setBeanProperties(biz,’ requireDeptName’,orgXml,’ykbm’)
     *
     * @param bizObject
     * @param script
     * @param orgXml
     * @throws javax.script.ScriptException
     */
    public void updateBizData(Object bizObject, String script, String orgXml) throws ScriptException {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        engine.put("biz", bizObject);
        ScriptHelper scriptHelper = new ScriptHelper();
        engine.put("scriptHelper", scriptHelper);
        engine.put("orgXml", orgXml);
        if (!StringUtils.isBlank(script)) {
            bizObject = engine.eval(script);
            hibernateService.save((Serializable) bizObject);
        }
    }

    /**
     * 根据业务对象名和业务记录ID获取流程实例
     *
     * @param bizObject   .
     * @param bizObjectId .
     * @return .
     */
    public BpmProcessInstance getBpmProcessInstance(String bizObject, Long bizObjectId) {
        String hql = "from BpmProcessInstance where processDefinition.bizObject='{0}' and bizObjectId={1}";
        List<BpmProcessInstance> list = bpmProcessInstanceService.findByQuery(FormatUtils.format(hql, bizObject, String.valueOf(bizObjectId)));
        if (list.size() > 0) {
            return list.iterator().next();
        } else {
            return null;
        }
    }

    /**
     * 查看流程图
     */
    private String bizViewFlowImg = "&lt;input type='button' title='{0}' class='{1}' value=' ' onClick='viewBizFlow(\"{2}\")'&gt;";    //必须转义，否则grid无法显示

    /**
     * todo
     *
     * @param bizObject   .
     * @param bizObjectId .
     * @return .
     */
    public String getBizViewFlowImg(String bizObject, Long bizObjectId) {
        BpmProcessInstance processInstance = getBpmProcessInstance(bizObject, bizObjectId);
        if (processInstance != null) {
            return FormatUtils.format(bizViewFlowImg, "查看流程", "button_biz_flow", String.valueOf(processInstance.getId()));
        } else {
            return "";
        }
    }

    /**
     * 设置业务模块调用流程标记
     *
     * @param bizObject   .
     * @param bizObjectId .
     * @param model       .
     */
    public void setBizFlowTag(String bizObject, Long bizObjectId, Model model) {
        if (bpmProcessDefinitionManager.getValidBpmProcessDefinition(bizObject) != null && bizObjectId != null) {
            model.addAttribute("bizObject", bizObject);
            model.addAttribute("bizObjectId", bizObjectId);
        }
    }

    /**
     * 根据调用流程标记判断是否需要启动流程
     *
     * @param model .
     */
    public void getBizFlowTag(Model model) {
        model.addAttribute("startBizFlow", false);
        if (model.containsAttribute("bizObject")) {
            Map<String, Object> objectMap = model.asMap();
            if (objectMap.get("bizObjectId") != null) {
                BpmProcessInstance processInstance = getBpmProcessInstance(JspHelper.getString(objectMap.get("bizObject")), JspHelper.getLong(objectMap.get("bizObjectId")));
                if (processInstance == null) {
                    model.addAttribute("startBizFlow", true);
                }
            }
        }
    }

    /**
     * 脚本助手类
     * 在书写脚本时，为了方便不用写过多的script，要用一些辅助方法
     */
    class ScriptHelper {
        /**
         * @param orgXml
         * @param key
         * @param value
         * @return
         * @throws org.dom4j.DocumentException
         */
        public String generateXml(String orgXml, String key, String value) throws DocumentException {
            System.out.println("key = " + key);
            System.out.println("value = " + value);
            if (value == null) {
                return orgXml;
            }

            Document document;
            Element element;
            if (StringHelper.isEmpty(orgXml)) {
                document = DocumentHelper.createDocument();
                element = document.addElement("bizdata");
            } else {
                SAXReader saxReader = new SAXReader();
                StringReader sr = new StringReader(orgXml);
                document = saxReader.read(sr);
                element = document.getRootElement();
            }
            Element newElement = element.addElement(key);
            newElement.setText(value);
            return document.asXML();
        }

        public Object setBeanProperties(Object bizObject, String properties, String orgXml, String key) throws InvocationTargetException, DocumentException, IllegalAccessException {
            if (StringHelper.isEmpty(orgXml)) {
                return bizObject;
            } else {
                Document document = DocumentHelper.parseText(orgXml);
                XPath xPath = new DefaultXPath("//bizdata/" + key + "");
                Element element = (Element) xPath.selectSingleNode(document);
                logger.debug("element = " + element);
                if (element != null && !StringHelper.isEmpty(String.valueOf(element.getData()))) {
                    BeanUtils.copyProperty(bizObject, properties, element.getData());
                }
            }

            return bizObject;
        }

        public Object setBeanProperties(Object bizObject, String properties, String value) throws InvocationTargetException, DocumentException, IllegalAccessException {
            if (value != null) {
                BeanUtils.copyProperty(bizObject, properties, value);
            }

            return bizObject;
        }
    }
}

