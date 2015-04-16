package com.justonetech.biz.utils.process.page;

import org.apache.commons.lang.StringUtils;
import org.htmlparser.Parser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author tcg
 */
public class BizHtml
{
    String htmlTemplate;
    String privilege;
    String bizData;
    String user;
    Map defaultValues = new HashMap();

    Map variables = new HashMap();

    public BizHtml(String htmlTemplate, String bizData)
    {
        this.htmlTemplate = htmlTemplate;
        this.bizData = bizData;
    }

    public BizHtml(String htmlTemplate, String privilege, String bizData, String user)
    {
        this.htmlTemplate = htmlTemplate;
        this.privilege = privilege;
        this.bizData = bizData;
        this.user = user;
    }

     public BizHtml(String htmlTemplate, String privilege, String bizData, String user,Map defalueValueMap)
    {
       this(htmlTemplate,privilege,bizData,user);
       this.defaultValues = defalueValueMap;
    }

    public String getHtmlTemplate()
    {
        return htmlTemplate;
    }

    public void setHtmlTemplate(String htmlTemplate)
    {
        this.htmlTemplate = htmlTemplate;
    }

    public String getPrivilege()
    {
        return privilege;
    }

    public void setPrivilege(String privilege)
    {
        this.privilege = privilege;
    }

    public String getBizData()
    {
        return bizData;
    }

    public void setBizData(String bizData)
    {
        this.bizData = bizData;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public void set(String key, Object value)
    {
        if (value != null)
            variables.put(key, value);
    }

    public Map getDefaultValues() {
        return defaultValues;
    }

    public void setDefaultValues(Map defaultValues) {
        this.defaultValues = defaultValues;
    }

    /**
     * generate input html page, from htmltemplate, privilege, bizdata, user
     * @return
     * @throws Exception
     */
    public String process() throws Exception
    {
        return process("");
    }
    public String process(String action) throws Exception
    {
        return process(action,"");// BizProcessInstance.Status.RUN);      todo
    }
    /**
     * generate input html page, from htmltemplate, privilege, bizdata, user
     * @return
     * @throws Exception
     */
    public String process(String action,String status) throws Exception
    {
        try
        {
            //Map keyvValuesMap =XMLFileHelper.getKeyValues(bizDataXML);
            String htmlcode = htmlTemplate;
            Parser parser = Parser.createParser(htmlcode, "utf-8");
            HtmlPageEx visitor = new HtmlPageEx(parser, bizData, privilege, user,action,status,defaultValues);
            parser.visitAllNodesWith(visitor);
            String html = visitor.getHTMLContent();

            if (!variables.isEmpty())
            {
                Iterator keys = variables.keySet().iterator();
                while (keys.hasNext())
                {
                    String key = (String) keys.next();
                    Object value = variables.get(key);
                    html = StringUtils.replace(html, key, value.toString());
                }
            }
            return html;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }
}

