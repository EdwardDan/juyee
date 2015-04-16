package com.justonetech.biz.utils.process.page;

import com.justonetech.core.utils.StringHelper;
import org.htmlparser.Parser;
import org.htmlparser.util.ParserException;

import java.util.Map;

/**
 * author: tcg
 * Date: 2009-6-18
 * Time: 13:05:12
 */
public class BizHtmlToXml {
    private String htmlTemplate;
    private String privilege;
    private String[] privileges;
    private Map defaultMap;

    public String getHtmlTemplate() {
        return htmlTemplate;
    }

    public void setHtmlTemplate(String htmlTemplate) {
        this.htmlTemplate = htmlTemplate;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String[] getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String[] privileges) {
        this.privileges = privileges;
    }

    public Map getDefaultMap() {
        return defaultMap;
    }

    public void setDefaultMap(Map defaultMap) {
        this.defaultMap = defaultMap;
    }

    public BizHtmlToXml(String htmlTemplate) {
        this.htmlTemplate = htmlTemplate;
    }

    public BizHtmlToXml(String htmlTemplate, Map defaultMap) {
        this(htmlTemplate);
        this.defaultMap = defaultMap;
    }

    public BizHtmlToXml(String htmlTemplate, String privilege, Map defaultMap) {
        this(htmlTemplate, defaultMap);
        this.privilege = privilege;
    }

    public BizHtmlToXml(String htmlTemplate, String[] privileges, Map defaultMap) {
        this(htmlTemplate, defaultMap);
        this.privileges = privileges;
    }

    /**
     * 生成xml
     *
     * @return
     * @throws org.htmlparser.util.ParserException
     *
     */
    public String generateXml() throws ParserException {
        String htmlcode = this.htmlTemplate;
        Parser parser = Parser.createParser(htmlcode, "utf-8");
        HtmlTrans vistor = new HtmlTrans(parser);
        if (!StringHelper.isEmpty(privilege)) {
            vistor.setPrivilege(privilege);
        } else if (null != privileges) {
            vistor.setPrivileges(privileges);
        }
        vistor.setDefaultDataMap(defaultMap);
        parser.visitAllNodesWith(vistor);
        return vistor.getXml();
    }
}
