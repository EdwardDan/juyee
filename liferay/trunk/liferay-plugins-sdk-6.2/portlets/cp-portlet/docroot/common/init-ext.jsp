<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="com.justonetech.cp.project.service.ProjectLocalServiceUtil"%>
<%@page import="com.justonetech.cp.project.model.Project"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@ page import="com.liferay.portal.theme.PortletDisplay"%>
<%@ page import="com.liferay.counter.service.CounterLocalServiceUtil"%>

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
    window.jQuery || document.write("<script src='/static/jquery/jquery-1.12.4.js'>"+"<"+"/script>");
</script> 
<script type="text/javascript" src="/static/jquery/ajaxfileupload.js"></script>

<%@page import="com.justonetech.cp.util.PortletKeys"%>
<%@page import="com.justonetech.cp.contract.model.*"%> 
<%@page import="com.justonetech.cp.permit.model.*"%>
<%@page import="com.justonetech.cp.permit.service.*"%>
<%@page import="com.justonetech.cp.contract.service.ContractLocalServiceUtil"%>
<%@page import="com.justonetech.sys.service.DictionaryLocalServiceUtil"%>
<%@ page import="com.justonetech.sys.model.Dictionary"%>
<%@page import="com.justonetech.cp.util.CityPermitStatus"%>
<%@page import="com.justonetech.cp.util.CountyPermitStatus"%>
<%@page import="com.justonetech.cp.complete.model.*"%>
<%@page import="com.justonetech.cp.complete.service.*"%>
<%@page import="com.justonetech.cp.complete.model.*"%>
<%@page import="com.justonetech.cp.complete.service.*"%> 


<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowTask" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil" %>
<%@ page import="com.liferay.portal.workflow.kaleo.service.*" %>
<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowException" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowLog" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowLogManagerUtil" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.workflow.comparator.WorkflowComparatorFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@ page import="java.text.*"%>
<%@ page import="com.liferay.portal.service.*"%>
<%@ page import="com.liferay.portal.model.*"%>
<%@page import="com.justonetech.cp.util.CpConstants"%>
