<%@ page contentType="text/html; charset=UTF-8"%>
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
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.justonetech.cyzt.leo.model.*"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.*"%>
<%@page import="com.justonetech.cyzt.leo.service.*"%>
