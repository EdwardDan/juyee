<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.justonetech.oa.model.*"%>
<%@ page import="com.justonetech.sys.model.Dictionary"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.justonetech.oa.service.DispatchLocalService"%>
<%@page import="com.justonetech.sys.service.DictionaryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
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