package com.justonetech.biz.manager.workflow;

import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.daoservice.BpmFormTemplateService;
import com.justonetech.biz.daoservice.BpmProcessDefinitionService;
import com.justonetech.biz.daoservice.BpmProcessInstanceService;
import com.justonetech.biz.domain.BpmFormData;
import com.justonetech.biz.domain.BpmFormTemplate;
import com.justonetech.biz.domain.BpmProcessInstance;
import com.justonetech.biz.utils.excel.ExcelFormUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.tree.DefaultAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;

/**
 * finereport打印支持类
 * User: Chen Junping
 * Date: 12-5-14
 */
@Service
public class BpmReportManager {
    private Logger logger = LoggerFactory.getLogger(BpmReportManager.class);

    @Autowired
    private BpmProcessDefinitionService bpmProcessDefinitionService;

    @Autowired
    private BpmProcessInstanceService bpmProcessInstanceService;

    @Autowired
    private BpmFormTemplateService bpmFormTemplateService;

    @Autowired
    private BpmProcessInstanceManager bpmProcessInstanceManager;

    /**
     * 获取流程表单数据 -- 单个流程定制
     *
     * @param pid         流程实例ID
     * @param fid         表单模板ID
     * @param columnNames 输出的列（key）
     * @return List
     */
    public List getBpmDataList(Long pid, Long fid, String[] columnNames) {
//        System.out.println("............pid = " + pid);
//        System.out.println("............fid = " + fid);
//        System.out.println("............columnNames = " + columnNames.length);

        BpmProcessInstance bpmProcessInstance = bpmProcessInstanceService.get(pid);
        BpmFormTemplate bpmFormTemplate = bpmFormTemplateService.get(fid);
        BpmFormData bpmFormData = bpmProcessInstanceManager.getBpmFormData(bpmProcessInstance, bpmFormTemplate);

        String xmlData = "";
        if (bpmFormData != null) {
            xmlData = bpmFormData.getFormXml();
        }
        Map<String, Object> mapData = getMapData(xmlData);

        ////////////////////////////////////////////////////////////////////////////////////
        List<Object[]> resultList = new ArrayList<Object[]>();
        for (String column : columnNames) {
            Object[] data = new Object[10];
            data[0] = JspHelper.getString(mapData.get(column));
            resultList.add(data);
        }
        return resultList;
    }

    /**
     * 获取流程表单数据 -- 流程通用
     * 注意：返回的第一行为标题列，用于模板定制使用
     * @param pid      流程实例ID
     * @param fid      表单模板ID
     * @return         .
     * @throws IOException .
     * @throws DocumentException .
     * @throws SAXException  .
     * @throws ParserConfigurationException .
     */
    public String[][] getBpmDatas(Long pid, Long fid) throws IOException, DocumentException, SAXException, ParserConfigurationException {
        System.out.println("............pid = " + pid);
        System.out.println("............fid = " + fid);

        String[][] data = new String[1][10];
        if (fid>0) {

            BpmFormTemplate bpmFormTemplate = bpmFormTemplateService.get(fid);
            List<String> nodeList = ExcelFormUtils.getFormKeys(bpmFormTemplate.getParXml());
            String[] columnNames = new String[nodeList.size()];
            for (int i = 0; i < nodeList.size(); i++) {
                columnNames[i] = nodeList.get(i);
            }
            if (pid>0) {
                BpmProcessInstance bpmProcessInstance = bpmProcessInstanceService.get(pid);
                BpmFormData bpmFormData = bpmProcessInstanceManager.getBpmFormData(bpmProcessInstance, bpmFormTemplate);

                String xmlData = "";
                if (bpmFormData != null) {
                    xmlData = bpmFormData.getFormXml();
                }
                Map<String, Object> mapData = getMapData(xmlData);
                data = new String[2][columnNames.length];
                int i = 0;
                for (String column : columnNames) {

                    data[1][i] = JspHelper.getString(mapData.get(column));
                    System.out.println(column+" = " + data[1][i]);
                    i++;
                }
            }else{
                data = new String[1][columnNames.length];
            }
            data[0] = columnNames;
        }

        return data;
//        String[][] a = {{"城市", "销售员", "销售额"},{"江苏", "Anna", "230"},{"江苏", "Alex", "190"},{"江苏","Jack","320"},{"江苏","Apple","210"},{"浙江","Faye","150"},{"浙江","Sammi","280"}};
//        return a;
    }

    /**
     * 将xml转成map
     *
     * @param xmlData .
     * @return .
     */
    public static Map<String, Object> getMapData(String xmlData) {
//        xmlData = "<?xml version=\"1.0\" encoding=\"GBK\"?>" +
//                "" +
//                "<bizdata>" +
//                "  <bh>关于收集上报工程变更现场勘查会议纪要的通知</bh>  " +
//                "  <fj>无</fj>  " +
//                "  <nigao> " +
//                "    <value user=\"关成江\" time=\"2011-12-06 13:35:20.1\">关成江(12月5日)</value> " +
//                "  </nigao>  " +
//                "  <zhutici>上报 工程变更 纪要</zhutici>  " +
//                "  <zhusong>设计代表 总监办 各驻地办 各施工单位</zhusong>  " +
//                "  <chaosong>存档</chaosong>  " +
//                "  <hw>9</hw>  " +
//                "  <ww/>  " +
//                "  <hegao> " +
//                "    <value user=\"柯欣\" time=\"2011-12-06 13:44:22.381\">柯欣</value> " +
//                "    <value user=\"过震文\" time=\"2011-12-06 13:47:19.928\">过震文</value> " +
//                "  </hegao>  " +
//                "  <huigao> " +
//                "    <value user=\"刘杰\" time=\"2011-12-06 13:44:59.912\"><![CDATA[刘杰]]></value> " +
//                "  </huigao>  " +
//                "  <qianfa> " +
//                "  </qianfa>  " +
//                "  <miji/>  " +
//                "  <wjbh>新交建沪三莎指[2011]46</wjbh>  " +
//                "  <ljh/>  " +
//                "  <dazi>梁菊叶</dazi>  " +
//                "  <jiaodui>李蕾</jiaodui>  " +
//                "  <riqi>2011-12-06</riqi> " +
//                "</bizdata>";
        Map<String, Object> map = new HashMap<String, Object>();
        if (!StringHelper.isEmpty(xmlData)) {
            try {
                Document doc = DocumentHelper.parseText(xmlData);

                Element root = doc.getRootElement();
                Iterator it = root.elementIterator();
                while (it.hasNext()) {
                    Element e = (Element) it.next();
                    String value = getValue(e);
//                System.out.println(e.getName()+" = " + value);
                    map.put(e.getName(), value);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    /**
     * 获取输入值
     *
     * @param e .
     * @return .
     */
    private static String getValue(Element e) {
        String value = e.getTextTrim();
        if (StringHelper.isEmpty(value)) {
            List list = e.elements();
            if (list.size() > 0) {
                for (Object obj : list) {
                    String appendStr = "";
                    Element child = (Element) obj;
                    Iterator iterators = child.attributeIterator();
                    while (iterators.hasNext()) {
                        DefaultAttribute attr = (DefaultAttribute) iterators.next();

                        if ("user".equals(attr.getName())) {
                            appendStr += attr.getValue() + " ";
                        } else if ("time".equals(attr.getName())) {
                            appendStr += attr.getValue().substring(0, 10);
                        }
//                        System.out.println("属性名称 "+attr.getName()+"===="+attr.getValue());
                    }
                    if (!"".equals(appendStr)) {
                        value += child.getStringValue() + "(" + appendStr + ")\n";
                    }
                }
            }
        }
        return value;
    }
}
