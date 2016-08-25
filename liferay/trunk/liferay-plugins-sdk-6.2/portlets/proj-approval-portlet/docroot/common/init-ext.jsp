<%@ page import="com.justonetech.sys.model.*"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@ page import="com.justonetech.sys.model.Dictionary"%>
<%@ page import="com.justonetech.sys.service.DictionaryLocalServiceUtil"%>
<%@page import="com.justonetech.projApproval.model.*"%>
<%
String staticServerURL =PropsUtil.get("static.server.url");
request.setAttribute("staticServerURL", staticServerURL);
String reportServerURL =PropsUtil.get("report.server.url");
request.setAttribute("reportServerURL", reportServerURL);
String defaultDateFormatPattern = PropsUtil.get("default.date.format.pattern");
request.setAttribute("defaultDateFormatPattern", defaultDateFormatPattern);
String defaultTimeFormatPattern = PropsUtil.get("default.time.format.pattern");
request.setAttribute("defaultTimeFormatPattern", defaultTimeFormatPattern);
%>

<script type="text/javascript" src="${staticServerURL}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
    window.jQuery || document.write("<script src='${staticServerURL}/jquery/jquery-1.12.4.min.js'>"+"<"+"/script>");
</script>    


