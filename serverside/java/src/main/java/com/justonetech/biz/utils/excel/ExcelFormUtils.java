package com.justonetech.biz.utils.excel;

import com.justonetech.core.utils.ParFileUtils;
import org.apache.commons.beanutils.BeanComparator;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.htmlparser.util.ParserException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.zip.ZipEntry;

/**
 * Created by IntelliJ IDEA.
 * User: wangyang
 * Date: 2009-2-28
 * Time: 11:58:26
 * To change this template use File | Settings | File Templates.
 */
public class ExcelFormUtils {
    /**
     * @param htmlString 待合并的html代码
     * @param xmlString  待合并的xml代码
     * @return 合并后的代码
     * @throws org.htmlparser.util.ParserException
     *                                  .
     * @throws java.io.IOException      .
     * @throws org.xml.sax.SAXException .
     * @throws javax.xml.parsers.ParserConfigurationException
     *                                  .
     */
    public static String Transform(String htmlString, String xmlString) throws ParserException, IOException, SAXException, ParserConfigurationException {
        ExcelForm excelForm = new ExcelForm(htmlString, xmlString);
        return excelForm.getHTMLContent();
    }

    /**
     * 得到 表单模板的权限区域
     *
     * @param formXml .
     * @return .
     * @throws java.io.IOException         .
     * @throws org.xml.sax.SAXException    .
     * @throws javax.xml.parsers.ParserConfigurationException
     *                                     .
     * @throws org.dom4j.DocumentException .
     */
    public static List<String> getFormPrivileges(String formXml) throws IOException, SAXException, ParserConfigurationException, DocumentException {
        org.dom4j.Document document = DocumentHelper.parseText(formXml);
        List<String> privileges = new ArrayList<String>();
        List<Node> nodes = (List<Node>) document.selectNodes("/ExcelDocument/Sheets/Sheet/Items/Item/Property[@Name='privilege']");

        //排序
        BeanComparator beanComparator = new BeanComparator("text");
        Collections.sort(nodes, beanComparator);

        HashSet hs = new HashSet();
        for (Node node : nodes) {
            if (!hs.contains(node.getText())) {
                privileges.add(node.getText());
                hs.add(node.getText());
            }
        }
        return privileges;
    }

    /**
     * 得到 表单模板的所有key
     * Chen Junping
     *
     * @param formXml .
     * @return .
     * @throws java.io.IOException         .
     * @throws org.xml.sax.SAXException    .
     * @throws javax.xml.parsers.ParserConfigurationException
     *                                     .
     * @throws org.dom4j.DocumentException .
     */
    public static List<String> getFormKeys(String formXml) throws IOException, SAXException, ParserConfigurationException, DocumentException {
        org.dom4j.Document document = DocumentHelper.parseText(formXml);
        List<String> keys = new ArrayList<String>();
        List<Node> nodes = (List<Node>) document.selectNodes("/ExcelDocument/Sheets/Sheet/Items/Item/Property[@Name='key']");

        //排序
        BeanComparator beanComparator = new BeanComparator("text");
        Collections.sort(nodes, beanComparator);

        for (Node node : nodes) {
            keys.add(node.getText());
        }
        return keys;
    }

    /**
     * @param parFile 压缩文件，包含了要合并的html文件和xml文件
     * @return .
     * @throws java.io.IOException      .
     * @throws org.xml.sax.SAXException .
     * @throws javax.xml.parsers.ParserConfigurationException
     *                                  .
     * @throws org.htmlparser.util.ParserException
     *                                  .
     */
    public static String Transform(File parFile) throws IOException, SAXException, ParserConfigurationException, ParserException {
//        String baseName = FilenameUtils.getBaseName(parFile.getName());
        String fileName = "";
        ZipEntry[] zipEntries = ParFileUtils.readEntriesFromZipfile(parFile);
        for (ZipEntry zipEntry : zipEntries) {
            if (zipEntry.getName().endsWith(".htm")) {
                fileName = zipEntry.getName();
            }
        }

        byte[] htmlbytes = ParFileUtils.readFileContentFromZipfile(parFile, fileName);
        String htmlString = new String(htmlbytes, "GBK");

        for (ZipEntry zipEntry : zipEntries) {
            if (zipEntry.getName().endsWith(".xml")) {
                fileName = zipEntry.getName();
            }
        }
        byte[] xmlbytes = ParFileUtils.readFileContentFromZipfile(parFile, fileName);
        String xmlString = new String(xmlbytes, "UTF-8");

        return Transform(htmlString, xmlString);
    }


    public static String getFormXml(File parFile) throws IOException, SAXException, ParserConfigurationException, ParserException {
//        String baseName = FilenameUtils.getBaseName(parFile.getName());
        String fileName = "";
        ZipEntry[] zipEntries = ParFileUtils.readEntriesFromZipfile(parFile);
        for (ZipEntry zipEntry : zipEntries) {
            if (zipEntry.getName().endsWith(".xml")) {
                fileName = zipEntry.getName();
            }
        }
        byte[] xmlbytes = ParFileUtils.readFileContentFromZipfile(parFile, fileName);
        return new String(xmlbytes, "UTF-8");
    }


    /**
     * @param xmlString .
     * @return 返回xml解析器
     * @throws java.io.IOException      .
     * @throws javax.xml.parsers.ParserConfigurationException
     *                                  .
     * @throws org.xml.sax.SAXException .
     */
    public static Document getDocument(String xmlString) throws ParserConfigurationException, IOException, SAXException {
        StringReader stringReader = new StringReader(xmlString);
        InputSource inputSource = new InputSource(stringReader);
        Document document;
        document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);

        return document;
    }
}
