package com.justonetech.biz.utils;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2009-5-8
 * Time: 13:23:38
 * To change this template use File | Settings | File Templates.
 */
public class BizDataGenerator {
    protected static void createParentElements(HashMap elementsMap, String key)
    {
        if (elementsMap.containsKey(key))
            return;

        if (key.indexOf("/") < 0)
        {
            String parentXPath = "root";
            Element parentElement = (Element) elementsMap.get(parentXPath);
            String xmlName = "";

            if (key.charAt(key.length() - 1) == ']')
            {
                xmlName = key.substring(key.lastIndexOf("/") + 1, key.lastIndexOf("["));
            }
            else
            {
                xmlName = key;
            }
            elementsMap.put(key, parentElement.addElement(xmlName));
        }
        else
        {
            String parentXPath = key.substring(0, key.lastIndexOf("/"));
            createParentElements(elementsMap, parentXPath);
            Element parentElement = (Element) elementsMap.get(parentXPath);
            String xmlName = "";

            if (key.charAt(key.length() - 1) == ']')
            {
                xmlName = key.substring(key.lastIndexOf("/") + 1, key.lastIndexOf("["));
            }
            else
            {
                xmlName = key.substring(key.lastIndexOf("/") + 1);
            }
            elementsMap.put(key, parentElement.addElement(xmlName));
        }
    }

    /**
     * convert RawData Element
     *
     * @param elementsMap
     * @param e
     */
    protected static void convertRawDataElement(HashMap elementsMap, Element e)
    {
        String key = e.attributeValue("key");

        String value = e.getStringValue();
        List childrenList = e.elements();

        if (key.indexOf("/") > 0)
        {
            createParentElements(elementsMap, key.substring(0, key.lastIndexOf("/")));
        }

        Element parentElement = null;
        String parentElementXPath = "";
        if (key.indexOf("/") < 0)
        {
            parentElementXPath = "root";
        }
        else
        {
            parentElementXPath = key.substring(0, key.lastIndexOf("/"));
        }
        parentElement = (Element) elementsMap.get(parentElementXPath);


        String xmlName = "";

        if (key.charAt(key.length() - 1) == ']')
        {
            xmlName = key.substring(key.lastIndexOf("/") + 1, key.lastIndexOf("["));
        }
        else
        {
            xmlName = key.substring(key.lastIndexOf("/") + 1);
        }

        if (childrenList != null && childrenList.size() > 0)
        {
            for (int i = 0; i < childrenList.size(); i++)
            {
                Element child = (Element) childrenList.get(i);

                Element element = parentElement.addElement(xmlName).addElement(child.getName());
                element.addAttribute("user", child.attributeValue("user"));
                element.addAttribute("time", child.attributeValue("time"));
                element.addCDATA(child.getText());
            }
        }
        else
        {
            if (e.nodeCount() > 0 && e.node(0).getNodeType() == Node.CDATA_SECTION_NODE)
                parentElement.addElement(xmlName)
                        .addCDATA(value);
            else
                parentElement.addElement(xmlName)
                        .addText(value);
        }
    }

    /**
     * translate rawData to bizData
     *
     * @param rawData
     */
    public static String generateBizData(String rawData)
    {
        String bizData = "";

        HashMap elementsMap = new HashMap();
        try
        {
            //construct the XSDXML document object
            Document bizDocument = DocumentHelper.createDocument();
            Element xmlRoot = bizDocument.addElement("bizdata");

            elementsMap.put("root", xmlRoot);

            //read xml file and parse it
            SAXReader saxReader = new SAXReader();
            StringReader sr = new StringReader(rawData);
            Document rawDocument = saxReader.read(sr);
            //get root element
            Element xsdRoot = rawDocument.getRootElement();
            int i = 0;
            Iterator it = xsdRoot.elementIterator();
            while (it.hasNext())
            {
                Element e = (Element) it.next();
                convertRawDataElement(elementsMap, e);
                i++;
            }

            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("UTF-8");
            StringWriter sw = new StringWriter();
            XMLWriter writer = new XMLWriter(sw, format);
            try
            {
                writer.write(bizDocument);

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                writer.close();
            }

            bizData = sw.getBuffer().toString();
            //System.out.print(xsdDocument.asXML());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return bizData;
    }

    /**
     * replace or add element to bizData according to rawData
     *
     * @param rawData
     * @param bizData
     * @return
     */
    public static String generateBizData(String rawData, String bizData)
    {
        //read xml file and parse it
        try
        {
            SAXReader saxReader = new SAXReader();
            StringReader sr = new StringReader(rawData);
            Document partDocument = saxReader.read(sr);
            sr = new StringReader(bizData);
            Document document = saxReader.read(sr);

            Element rootElement = document.getRootElement();
            Element partRootElement = partDocument.getRootElement();
            List partElementList = partRootElement.elements();
            // loop for part element
            for (int i = 0; i < partElementList.size(); i++)
            {
                Element partElement = (Element) partElementList.get(i);
                String xpath = "/bizdata/" + partElement.attributeValue("key");

                // get element from bizData
                Element element = (Element) document.selectSingleNode(xpath);
                if (element != null)
                {
                    // If has child elements, it's separated value for mulitple user
                    List partSeparateValues = partElement.elements();
                    if (partSeparateValues != null && partSeparateValues.size() > 0)
                    {
                        Element partSeparateValue = (Element) partSeparateValues.get(0);
                        String user = partSeparateValue.attributeValue("user");
                        Element seperateValue = (Element) document.selectSingleNode(xpath + "/value[@user='" + user + "']");
                        // remove old seperate value
                        if (seperateValue != null)
                            element.remove(seperateValue);
                        // attach new seperate value
                        partSeparateValue.setParent(null);
                        element.add(partSeparateValue);
                    }
                    else
                    {
                        // normal value
                        if (partElement.nodeCount() > 0 && partElement.node(0).getNodeType() == Node.CDATA_SECTION_NODE)
                        {
                            element.clearContent();
                            element.addCDATA(partElement.getText());
                        }
                        else
                        {
                            element.setText(partElement.getText());
                        }
                    }
                }
                else
                {
                    HashMap elementsMap = new HashMap();
                    elementsMap.put("root", rootElement);
                    convertRawDataElement(elementsMap, partElement);
//                    partElement.setParent();
                }
            }

            // output xml string
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("GBK");
            StringWriter sw = new StringWriter();
            XMLWriter writer = new XMLWriter(sw, format);
            try
            {
                writer.write(document);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                writer.close();
            }

            bizData = sw.getBuffer().toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return bizData;
    }

    public static String initBizData(String bizData, String condition)
    {
        try
        {
            SAXReader saxReader = new SAXReader();
            StringReader sr = new StringReader(condition);
            Document conditionDocument = saxReader.read(sr);
            sr = new StringReader(bizData);
            Document document = saxReader.read(sr);

            Element root = conditionDocument.getRootElement();
            List conditions = root.elements();
            for (Iterator iterator = conditions.iterator(); iterator.hasNext();)
            {
                Element conditionElement = (Element) iterator.next();
                String conditionname = conditionElement.attributeValue("name");
                String conditionvalue = conditionElement.attributeValue("value");
                Element element = (Element)document.selectSingleNode("bizdata/" + conditionname);
                if (element != null)
                {
                    element.setText(conditionvalue);
                }
            }

            // output xml string
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("GBK");
            StringWriter sw = new StringWriter();
            XMLWriter writer = new XMLWriter(sw, format);
            try
            {
                writer.write(document);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                writer.close();
            }

            bizData = sw.getBuffer().toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return bizData;
    }

    /**
     * 合并两个xml(将orgXml中含有而newXml中不含有的key-value添加到newXml中)
     * @param orgXml
     * @param newXml
     * @return
     * @throws org.dom4j.DocumentException
     */
    public static String mergeXml(String orgXml,String newXml) throws DocumentException {
        Document document;
        Element elementOrg;
        Element elementNew;
        SAXReader saxReader = new SAXReader();
        StringReader sr = new StringReader(orgXml);
        document = saxReader.read(sr);
        elementOrg = document.getRootElement();

        sr = new StringReader(newXml);
        document = saxReader.read(sr);
        elementNew = document.getRootElement();
        //遍历element1,查询element1中含有并且在element2中不含有的元素，将其添加的element2中
        List <Element> list = elementOrg.elements();
        for (Element childElement : list) {
            String path = childElement.getPath();
            String name =childElement.getName();
            String text =childElement.getText();
            Node node = document.selectSingleNode(path);
            if(null==node){
                 Element element = elementNew.addElement(name);
                 element.setText(text);
            }
        }
        return document.asXML();
    }
}
