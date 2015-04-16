package com.justonetech.biz.manager.workflow;

import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.daoservice.BpmFormTemplateService;
import com.justonetech.biz.domain.BpmFormData;
import com.justonetech.biz.domain.BpmFormTemplate;
import com.justonetech.biz.domain.BpmProcessInstance;
import com.justonetech.biz.domain.bean.column.ColumnDefinition;
import com.justonetech.biz.domain.bean.column.ColumnParam;
import com.justonetech.biz.utils.JaxbUtil;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * author:Chen Junping
 */
@Service
public class BpmFormTemplateManager {
    private Logger logger = LoggerFactory.getLogger(BpmFormTemplateManager.class);

    @Autowired
    private BpmFormTemplateService bpmFormTemplateService;

    @Autowired
    private BpmProcessInstanceManager bpmProcessInstanceManager;

    /**
     * 数据库字段 modifyByCMJ 2010.1.27 增加location，用于分项工程的自定义字段保存
     */
    private String[] columns = {"code", "title", "reportDate", "deptName", "personName", "content", "bizData1", "bizData2", "bizData3", "bizData4", "bizData5"};
    /**
     * 数据库字段对应名称  modifyByCMJ 2010.1.27 增加部位，用于分项工程的自定义字段保存
     */
    private String[] columnNames = {"编号", "标题", "填写日期", "单位名称", "填写人", "主要内容", "", "", "", "", ""};

    /**
     * 将集合转成xml
     *
     * @param list
     * @return
     */
    public String toXml(List<ColumnParam> list) {
        String xml = "";
        try {
            ColumnDefinition definition = new ColumnDefinition();
            definition.setColumnParam(list);
            xml = JaxbUtil.marshall(definition);
        } catch (JAXBException e) {
            logger.debug("...toXml error");
        }
        return xml;
    }

    /**
     * 根据xml得到显示列的集合
     *
     * @param columnXml
     * @return
     */
    private HashMap getColumnHM(String columnXml) {
        HashMap hm = new HashMap();
        if (StringHelper.isEmpty(columnXml)) return hm;
        ColumnDefinition columnDefinition;
        try {
            columnDefinition = JaxbUtil.unmarshall(ColumnDefinition.class, columnXml);
            if (columnDefinition != null) {
                List<ColumnParam> columnParams = columnDefinition.getColumnParam();
                for (ColumnParam columnParam : columnParams) {
                    hm.put(columnParam.getColumn(), columnParam);
                }
            }
        } catch (JAXBException e) {
            logger.debug("...getColumnHM error");
        }
        return hm;
    }

    /**
     * 获取字段映射配置
     *
     * @param columnXml .
     * @return .
     */
    public List<ColumnParam> getColumnList(String columnXml) {
        List<ColumnParam> list = new ArrayList<ColumnParam>();

        HashMap columnHM = getColumnHM(columnXml);
        for (int i = 0; i < columns.length; i++) {
            String column = columns[i];
            ColumnParam param = (ColumnParam) columnHM.get(column);
            if (param == null) {
                param = new ColumnParam();
                param.setColumn(column);
                param.setKey("");
                param.setIsValid(false);
                param.setIsGridShow(false);
                param.setGridName(columnNames[i]);
                if (!StringHelper.isEmpty(columnNames[i])) {
                    param.setGridWidth("20");
                } else {
                    param.setGridWidth("");
                }
            }
            list.add(param);
        }
        return list;
    }

    /**
     * 获取列表显示配置
     *
     * @param columnXml .
     * @return .
     */
    public List<ColumnParam> getColumnGridList(String columnXml) {
        List<ColumnParam> list = new ArrayList<ColumnParam>();
        List<ColumnParam> columnList = getColumnList(columnXml);
        for (ColumnParam param : columnList) {
            if (param.getIsGridShow()) {
                if (StringHelper.isEmpty(param.getGridWidth())) {
                    param.setGridWidth("20");
                }
                list.add(param);
            }
        }
        return list;
    }

    /**
     * 获取列表显示配置
     * .
     *
     * @return .
     */
    public List<ColumnParam> getColumnGridList() {
        List<ColumnParam> list = new ArrayList<ColumnParam>();
        for (int i = 0; i < 3; i++) {
            ColumnParam columnParam = new ColumnParam();
            columnParam.setKey(columns[i]);
            columnParam.setColumn(columns[i]);
            columnParam.setGridName(columnNames[i]);
            columnParam.setIsValid(true);
            columnParam.setIsGridShow(true);
            columnParam.setGridWidth("20");
            list.add(columnParam);
        }
        return list;
    }

    /**
     * 获取XML中的值
     *
     * @param docStr   .
     * @param xpathStr .
     * @return .
     * @throws org.dom4j.DocumentException .
     */

    public String getValue(String docStr, String xpathStr) throws DocumentException {
        String rootKey = "/bizdata/";
        SAXReader saxReader = new SAXReader();
        StringReader sr = new StringReader(docStr);
        Document document = saxReader.read(sr);
        Element element = (Element) document.selectSingleNode(rootKey + xpathStr);
        if (element != null)
            return element.getText();
        return "";
    }

    /**
     * 通过模板名称获取表单模板
     *
     * @param code
     * @return
     */
    public BpmFormTemplate getBpmFormTemplate(String code) {
//        FilterBeforeOperator.closeFilter();
        BpmFormTemplate template = bpmFormTemplateService.findUnique("from BpmFormTemplate t where t.code='" + code + "'");
//        FilterBeforeOperator.openFilter();
        return template;
    }

    /**
     * 通过模板名获取表单数据
     *
     * @param bpmProcessInstance
     * @param name
     * @return
     */
    public String getBpmFormXml(BpmProcessInstance bpmProcessInstance, String name) {
        BpmFormTemplate bpmFormTemplate = getBpmFormTemplate(name);
        String xmlData = "";
        BpmFormData bpmFormData = bpmProcessInstanceManager.getBpmFormData(bpmProcessInstance, bpmFormTemplate);
        if (null != bpmFormData) {
            xmlData = bpmFormData.getFormXml();
        }
        return xmlData;
    }

    /**
     * 通过key来获取表单数据中key对应的数据
     *
     * @param bpmProcessInstance
     * @param formName
     * @param key
     * @return
     * @throws org.dom4j.DocumentException
     */
    public String getDataFromXml(BpmProcessInstance bpmProcessInstance, String formName, String key) throws DocumentException {
        String ret = "";
        String bpmFormXml = getBpmFormXml(bpmProcessInstance, formName);
        if (!StringHelper.isEmpty(bpmFormXml)) {
            ret = getValue(bpmFormXml, key);
        }
        return ret;
    }

    /**
     * 通过key来获取表单数据中key对应的数据
     *
     * @param bpmProcessInstance
     * @param key
     * @return
     * @throws org.dom4j.DocumentException
     */
    public String getDataFromXml(BpmProcessInstance bpmProcessInstance, String key) throws DocumentException {
        String ret = "";
        Set<BpmFormData> bpmFormDatas = bpmProcessInstance.getBpmFormDatas();
        for (BpmFormData bpmFormData : bpmFormDatas) {
            String bpmFormXml = bpmFormData.getFormXml();
            if (!StringHelper.isEmpty(bpmFormXml)) {
                ret = getValue(bpmFormXml, key);
                if (!"".equals(ret)) {
                    return ret;
                }
            }
        }
        return ret;
    }

    /**
     * 将key和value搭配形成所需要的xml
     *
     * @param orgXml
     * @param key
     * @param value
     * @return
     * @throws org.dom4j.DocumentException
     */
    public String generateXml(String orgXml, String key, String value) throws DocumentException {

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

}
