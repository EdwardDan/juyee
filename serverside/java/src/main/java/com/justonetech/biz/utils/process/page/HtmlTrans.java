package com.justonetech.biz.utils.process.page;

import com.justonetech.core.utils.StringHelper;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.visitors.HtmlPage;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * author: tcg
 * Date: 2009-6-18
 * Time: 12:11:39
 */
public class HtmlTrans extends HtmlPage {

    private String privilege = "";
    private String[] privileges;
    private Map defaultDataMap = new HashMap();
    private String xml = "";

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public Map getDefaultDataMap() {
        return defaultDataMap;
    }

    public void setDefaultDataMap(Map defaultDataMap) {
        this.defaultDataMap = defaultDataMap;
    }

    public String[] getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String[] privileges) {
        this.privileges = privileges;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public HtmlTrans(Parser parser) {
        super(parser);
    }

    /**
     * 返回缺省的值
     *
     * @param key
     * @return
     */
    public String getDefaultValue(String key) {
        Object defaultValue = this.defaultDataMap.get(key);
        if (null != defaultValue) {
            return String.valueOf(defaultValue);
        } else {
            return key;
        }
    }

    public void visitTag(Tag tag) {
        super.visitTag(tag);
        try {
            generateXml(tag);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将tag中的缺省value添加到xml
     *
     * @param tag
     * @throws IllegalAccessException
     * @throws org.dom4j.DocumentException
     */
    public void generateXml(Tag tag) throws IllegalAccessException, DocumentException {
        if (tag.getTagName().equalsIgnoreCase("TD")) {
            String xml = getXml();
            HtmlTag htmlTag = HtmlForm.CreateInputTag(tag);
            String key = htmlTag.getKey();
            String defaultValue = htmlTag.getDefaultValue();
            String privilegeCope = htmlTag.getPrivilege();

            if (!StringHelper.isEmpty(key)) {
                //获取缺省值
                if (StringHelper.isEmpty(defaultValue)) {
                    defaultValue = "";
                } else {
                    //如果缺省值存在，判断其是否为取系统缺省值
                    defaultValue = getDefaultValue(defaultValue);
                }
                //如果该区域没有设置权限，直接生成xml,如果有权限，则判断权限
                if (StringHelper.isEmpty(privilegeCope)) {
                    xml = generateXml(xml, key, defaultValue);
                } else if (!StringHelper.isEmpty(privilegeCope) && !StringHelper.isEmpty(privilege)) {
                    if (privilege.indexOf(privilegeCope) >= 0) {
                        xml = generateXml(xml, key, defaultValue);
                    }
                } else if (!StringHelper.isEmpty(privilegeCope) && null != privileges) {
                    String tempprivileges = StringHelper.stringArrayToString(privileges, ",");
                    tempprivileges = tempprivileges.substring(0, tempprivileges.length() - 1);
                    if (tempprivileges.indexOf(privilegeCope) >= 0) {
                        xml = generateXml(xml, key, defaultValue);
                    }
                }
            }
            setXml(xml);
        }
    }

    /**
     * 生成xml数据源 （orgXml现有的xml，key 和value待加入到xml中）
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
