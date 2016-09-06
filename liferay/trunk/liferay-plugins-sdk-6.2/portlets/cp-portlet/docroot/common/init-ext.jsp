<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="com.justonetech.cp.project.service.ProjectLocalServiceUtil"%>
<%@page import="com.justonetech.cp.project.model.Project"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%
	String staticServerURL = PropsUtil.get("static.server.url");
	request.setAttribute("staticServerURL", staticServerURL);
	String reportServerURL = PropsUtil.get("report.server.url");
	request.setAttribute("reportServerURL", reportServerURL);
	String defaultDateFormatPattern = PropsUtil
			.get("default.date.format.pattern");
	request.setAttribute("defaultDateFormatPattern",
			defaultDateFormatPattern);
	String defaultTimeFormatPattern = PropsUtil
			.get("default.time.format.pattern");
	request.setAttribute("defaultTimeFormatPattern",
			defaultTimeFormatPattern);
%>
<script type="text/javascript" src="/static/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
    window.jQuery || document.write("<script src='/static/jquery/jquery-1.12.4.min.js'>"+"<"+"/script>");
</script> 

<%@page import="com.justonetech.cp.util.PortletKeys"%>
<%@page import="com.justonetech.cp.contract.model.*"%> 
<%@page import="com.justonetech.cp.permit.model.*"%>
<%@page import="com.justonetech.cp.permit.service.*"%>
<%@page import="com.justonetech.cp.contract.service.ContractLocalServiceUtil"%>
<%@page import="com.justonetech.sys.service.DictionaryLocalServiceUtil"%>
<%@ page import="com.justonetech.sys.model.Dictionary"%>