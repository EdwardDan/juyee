package com.justonetech.biz.utils.process.page;

import com.justonetech.core.utils.*;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.Text;
import org.htmlparser.nodes.TextNode;
import org.htmlparser.tags.HeadTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.visitors.HtmlPage;

import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author tcg
 */
public class HtmlPageEx extends HtmlPage {
    private Map keyValuesMap;
    private String headHtml = "";
    private String privilege = "";
    private String user = "";
    private String bizDataXML = "";
    private Document bizdoc;
    private String action;
    private String status;
    private Map defalueValueMap = new HashMap();

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public Map getKeyValuesMap() {
        return keyValuesMap;
    }

    public void setKeyValuesMap(Map keyValuesMap) {
        this.keyValuesMap = keyValuesMap;
    }

    public String getHeadHtml() {
        return headHtml;
    }

    public void setHeadHtml(String headHtml) {
        this.headHtml = headHtml;
    }

    public Document getBizdoc() {
        return bizdoc;
    }

    public void setBizdoc(Document bizdoc) {
        this.bizdoc = bizdoc;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getBizDataXML() {
        return bizDataXML;
    }

    public void setBizDataXML(String bizDataXML) {
        this.bizDataXML = bizDataXML;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map getDefalueValueMap() {
        return defalueValueMap;
    }

    public void setDefalueValueMap(Map defalueValueMap) {
        this.defalueValueMap = defalueValueMap;
    }

    /**
     * @param keyValue
     * @param user
     * @return
     */
    public String getCurrUserSeparateValue(String keyValue, String user) {
        Document doc = null;
        try {
            doc = DocumentHelper.parseText("<root>" + keyValue + "</root>");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Element root = doc.getRootElement();
        Iterator it = root.elementIterator();

        while (it.hasNext()) {
            Element e = (Element) it.next();
            String userValue = e.attributeValue("user");
            if (userValue.equalsIgnoreCase(user)) {
                return e.getText();
            }
        }

        return "";
    }

    /**
     * @param seperateValues
     * @param user
     * @return
     */
    public String getOtherUsersSeparateValue(String seperateValues, String user) {
        Document doc = null;
        String resultStr = "";
        try {
            doc = DocumentHelper.parseText("<root>" + seperateValues + "</root>");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Element root = doc.getRootElement();
        Iterator it = root.elementIterator();
        while (it.hasNext()) {
            Element e = (Element) it.next();
            String userValue = e.attributeValue("user");
            String timeValue = e.attributeValue("time");
            if (!StringHelper.isEmpty(timeValue)) {
                timeValue = timeValue.substring(0, 10);
            }
            if (!userValue.equalsIgnoreCase(user)) {
                //modify by chenjp 20080701
                resultStr = resultStr + e.getText() + " (" + userValue + " " + timeValue + ")\n";
            }
        }
        return resultStr;
    }

    /**
     * @param seperateValues
     * @return
     */
    public String getAllUsersSeparateValue(String seperateValues) {
        Document doc = null;
        String resultStr = "";
        try {
            doc = DocumentHelper.parseText("<root>" + seperateValues + "</root>");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Element root = doc.getRootElement();
        Iterator it = root.elementIterator();
        while (it.hasNext()) {
            Element e = (Element) it.next();
            String user = e.attributeValue("user");
            String time = e.attributeValue("time");
            if (!StringHelper.isEmpty(time)) {
                time = time.substring(0, 10);
            }
            //modify by chenjp 20080701
            resultStr = resultStr + e.getText() + " (" + user + " " + time + ")\n";
        }
        return resultStr;
    }

    public String getValue(String key) {
        if (getKeyValuesMap().containsKey(key)) {
            return (String) getKeyValuesMap().get(key);
        } else {
            try {
                String value = "";
                String xKeyValue = XmlHelper.generateXpathStr(key); //XmlHelper.generateXpathStr(key);
                Element element = (Element) getBizdoc().selectSingleNode(xKeyValue);
                List separateValues = element.elements();
                if (separateValues.size() > 0) {
                    for (int i = 0; i < separateValues.size(); i++) {
                        Element separateValue = (Element) separateValues.get(i);
                        value += separateValue.asXML();
                    }
                } else {
                    value = element.getText();
                }
                getKeyValuesMap().put(key, value);
                return element.getText();

            } catch (Exception e) {
                return null;
                //throw
            }
        }
    }

    public String contentFormat(String content, String type) {
        if (type.equals("4")) {
            if (!StringHelper.isEmpty(content)) {
                Date date = null;
                try {
                    date = DateTimeHelper.getDateByString(content);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if( date != null){
                    return DateTimeHelper.formatDateGBK(date) + "&nbsp;";
                }
            }
        }
        return content + "&nbsp;";

    }

    public String getFromData(HtmlTag htmlTag, String defaultValue) {
        String formData;
        if ((htmlTag.getInputType().equals("radio") || htmlTag.getInputType().equalsIgnoreCase("checkbox")) && !StringHelper.isEmpty(htmlTag.getInputTypeSource())) {
            htmlTag.setDefaultValue(defaultValue);
            formData = htmlTag.getFormValue(this.action);
        } else {
            formData = defaultValue;
        }
        if (htmlTag.getInputType().equals("hidden")) {
            formData = "";
        }
        return formData;
    }

    /**
     * 返回缺省的值
     *
     * @param key
     * @return
     */
    public String getDefaultValue(String key) {
        Object defaultValue = this.defalueValueMap.get(key);
        if (null != defaultValue) {
            return String.valueOf(defaultValue);
        } else {
            return key;
        }
    }

    public String getHTMLContent() {
        return "<html>\n" + getHeadHtml() + "\n<body>\n" + this.getBody().toHtml().toString() + "\n</body>\n</html>";
    }

    public HtmlPageEx(Parser parser, String bizDataXML, String privilege, String user, String action, String status, Map deMap) throws Exception {
        super(parser);
        setKeyValuesMap(new HashMap());
        setPrivilege(privilege);
        setUser(user);
        setBizDataXML(bizDataXML);
        setAction(action);   //added by chenjp 20081121 解决打印与显示分离
        setStatus(status);
        setDefalueValueMap(deMap);

//        keyValuesMap = new HashMap();

        try {
            setBizdoc(DocumentHelper.parseText(bizDataXML));
            //System.out.println(doc.selectSingleNode("//a[@id='1']/b").getText());
        } catch (Exception e) {
            //System.out.println("eeeee"+e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public void visitStringNode(Text text) {
        //System.out.println(text.getText());
        super.visitStringNode(text);
    }

    public void visitTagByPrivilege(Tag tag) throws IllegalAccessException {
        if (tag instanceof HeadTag) {
            setHeadHtml(tag.toHtml());
        }
        if (tag.getTagName().equalsIgnoreCase("TD")) {
            if (tag.getAttribute("inputType") != null) {
                HtmlTag htmlTag = HtmlForm.CreateInputTag(tag);
                String key = htmlTag.getKey();

                String privilege = htmlTag.getPrivilege();   //权限区域
                if (key == null || htmlTag.getInputType() == null) {
                    return;
                }

                //get value from map to replace @
                String resultValue = "";
                if (getValue(key) != null) {
                    resultValue = getValue(key);
                }

                //是否有权限
                //如果privilege=* 表示所有审核人都可以修改
                //如果privilege=1,2,3 表示只有1，2，3权限的审核人才能修改
                Boolean hasPrivilege = (privilege != null && (privilege.equalsIgnoreCase(getPrivilege()) || privilege.equalsIgnoreCase("*") || ("," + getPrivilege() + ",").indexOf("," + privilege + ",") >= 0));

                //缺省信息
                String formDefaultValue = htmlTag.getDefaultValue();
                if (hasPrivilege && htmlTag.getDefaultValue() != null) {
                    if (StringHelper.isEmpty(resultValue)) {
                        resultValue = getDefaultValue(formDefaultValue);
                    }
                }
                htmlTag.setDefaultValue(resultValue);
                //录入
                String inputtype = htmlTag.toHtmlString(hasPrivilege);
                //显示
                String viewValue;

                //会签模式和自动签名时显示用户签名及时间
                if ((htmlTag.getSeperate() != null && htmlTag.getSeperate().equalsIgnoreCase("1"))) {
                    String curUserValue = getCurrUserSeparateValue(resultValue, getUser());
                    String preXMLValue = this.getOtherUsersSeparateValue(resultValue, getUser());
                    if (StringHelper.isEmpty(formDefaultValue)) {
                        htmlTag.setDefaultValue(curUserValue);
                    } else {
                        htmlTag.setDefaultValue(formDefaultValue);
                    }

                    inputtype = htmlTag.toHtmlString(hasPrivilege);

                    preXMLValue = JspHelper.FormatOutPutString(preXMLValue);

                    inputtype = preXMLValue + inputtype;

                    //解决多人会签意见过长遮挡当前输入框的情况--输入页面
                    if (!StringHelper.isEmpty(preXMLValue))
                        inputtype = "<div style=\"overflow:auto;height=100%;width=100%;\">" + inputtype + "</div>";


                    String allXMLValue = this.getAllUsersSeparateValue(resultValue);
                    //add format output string by chenjp 20080701
                    allXMLValue = JspHelper.FormatOutPutString(allXMLValue);
                    viewValue = getFromData(htmlTag, allXMLValue);

                    //解决多人会签意见过长遮挡当前输入框的情况--查看页面
                    viewValue = "<div style=\"overflow:auto;height=100%;width=100%;\">" + viewValue + "</div>";

                } else {
                    resultValue = getFromData(htmlTag, resultValue);
                    resultValue = JspHelper.FormatOutPutString(resultValue);
                    viewValue = resultValue;
                }

                TextNode txt = new TextNode("");
                if (hasPrivilege) {
                    tag.removeAttribute("inputType");
                    tag.removeAttribute("viewType");
                    if (htmlTag.getRequire() != null && htmlTag.getRequire().equalsIgnoreCase("1")) {
                        inputtype += "<font color='red'>*</font>";
                    }
                    if (!StringHelper.isEmpty(htmlTag.getFormula())) {
                        //todo
                    }
                    txt.setText(inputtype);

                } else {
                    tag.removeAttribute("inputType");
                    tag.removeAttribute("key");
                    tag.removeAttribute("privilege");
                    tag.removeAttribute("required");
                    tag.removeAttribute("separate");
                    tag.removeAttribute("viewType");
                    tag.removeAttribute("formula");
                    if (htmlTag.getInputType().equals("date")) {
                        viewValue = contentFormat(viewValue, htmlTag.getViewType());
                    }
                    txt.setText(viewValue);   //todo
                }
                NodeList nodelist = tag.getChildren();
                if (nodelist != null) {
                    nodelist.removeAll();
                    nodelist.add(txt);
                } else {
                    nodelist = new NodeList(txt);
                }
                tag.setChildren(nodelist);
            }
        }
    }

    public void visitViewTag(Tag tag) {
        if (tag instanceof HeadTag) {
            setHeadHtml(tag.toHtml());
        }

        if (tag.getTagName().equalsIgnoreCase("TD")) {
            if (tag.getAttribute("viewtype") != null) {
                String keyName = tag.getAttribute("key");

                //add 080413
                String inputtype = tag.getAttribute("inputType");
                String viewTypeValue = tag.getAttribute("viewType");
                String separateValue = tag.getAttribute("separate");
                String showtypeValue = tag.getAttribute("showtype");
                String printtypeValue = tag.getAttribute("printType");

//                System.out.println(keyName+" = separate:" + separateValue+",viewtype:"+viewTypeValue+",showtype:"+showtypeValue+",printtype:"+printtypeValue);

                //added by chenjp 20081121
                boolean isTextareaView = false; //是否输入框方式查看
                if (!StringHelper.isEmpty(viewTypeValue) && viewTypeValue.indexOf("</textarea>") > 0 && !"print".equals(getAction())) {
                    isTextareaView = true;
                }
                if ("print".equals(getAction()) && !StringHelper.isEmpty(printtypeValue)) {
                    viewTypeValue = printtypeValue;
                }

                String signValue = tag.getAttribute("sign");

                if (keyName == null || viewTypeValue == null) {
                    return;
                }
                //get value from map to replace @
                String replaceValue = "";
                if (getValue(keyName) != null) {
                    replaceValue = getValue(keyName);
                }

                //会签模式和自动签名时显示用户签名及时间
                if ((separateValue != null && separateValue.equalsIgnoreCase("1")) || "1".equals(signValue)) {
                    String allXMLValue = this.getAllUsersSeparateValue(replaceValue);

                    //add format output string by chenjp  20080701
                    if (!isTextareaView)   //输入框方式查看不格式化代码
                    {
                        allXMLValue = JspHelper.FormatOutPutString(allXMLValue);
                    }

                    viewTypeValue = viewTypeValue.replaceAll("@", allXMLValue);

                    //解决多人会签意见过长遮挡当前输入框的情况--查看页面
                    viewTypeValue = "<div style=\"overflow:auto;height=100%;width=100%;\">" + viewTypeValue + "</div>";
                } else {
                    //add format output string by chenjp  20080701
                    if (!isTextareaView)   //输入框方式查看不格式化代码
                    {
                        replaceValue = JspHelper.FormatOutPutString(replaceValue);
                    }

                    //转换日期--如果不转化那么打印输出时日期将显示为数字
                    if (!StringHelper.isEmpty(showtypeValue)) {
                        if ("date".equals(showtypeValue)) {
                            replaceValue += "&nbsp;";
                        } else if ("datetime".equals(showtypeValue)) {
                            if (replaceValue.length() <= 10) replaceValue += " 00:00:000";
                            replaceValue = DateTimeHelper.formatTimestamp(Nulls.getTimestamp(replaceValue), "YYYY-MM-DD HH:MM");
                            replaceValue += "&nbsp;";
                        } else if ("cdate".equals(showtypeValue)) {
                            if (replaceValue.length() > 10) replaceValue = replaceValue.substring(0, 10);
                            replaceValue = DateTimeHelper.formatDateGBK(Nulls.getDate(replaceValue));
                            replaceValue += "&nbsp;";
                        } else if ("cdatetime".equals(showtypeValue)) {
                            if (replaceValue.length() <= 10) replaceValue += " 00:00:000";
                            replaceValue = DateTimeHelper.formatDateGBK(Nulls.getTimestamp(replaceValue));
                            replaceValue += "&nbsp;";
                        }

                    }

                    viewTypeValue = viewTypeValue.replaceAll("@", replaceValue);
                }

                //added by chenjp 20090108 审核结束的表单打印时系统自动在未审核的意见处打印显示“无”字样
                if (inputtype.indexOf("</textarea>") > 0 && "print".equals(getAction()) && true) { //BizProcessInstance.Status.END.equals(getStatus())){
                    if (StringHelper.isEmpty(viewTypeValue)) {
                        viewTypeValue = "无";
                    }                                 //todo
                    viewTypeValue = StringHelper.findAndReplace(viewTypeValue, ";\"></div>", ";\">无</div>");
                }

                TextNode txt = new TextNode("");

                tag.removeAttribute("inputtype");
                tag.removeAttribute("key");
                tag.removeAttribute("privilege");
                tag.removeAttribute("required");
                tag.removeAttribute("separate");
                tag.removeAttribute("viewtype");
                tag.removeAttribute("printtype");
                tag.removeAttribute("formula");
                tag.removeAttribute("msg");
                tag.removeAttribute("showtype");
                tag.removeAttribute("sign");

                txt.setText(viewTypeValue);

                NodeList nodelist = tag.getChildren();
                if (nodelist != null) {
                    nodelist.removeAll();
                    nodelist.add(txt);
                } else {
                    nodelist = new NodeList(txt);
                }
                tag.setChildren(nodelist);

            }

        }


    }

    public void visitTag(Tag tag) {
        super.visitTag(tag);
        if (getUser() == null || getUser().equalsIgnoreCase("")) {
            visitViewTag(tag);
            //System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        } else {
            try {
                visitTagByPrivilege(tag);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            //System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
        }
    }
}
