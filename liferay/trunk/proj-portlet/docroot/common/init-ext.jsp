<%@ page contentType="text/html;charset=utf-8"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>

<%
	String staticServerURL = PropsUtil.get("static.server.url");
	System.out.println("staticServerURL=" + staticServerURL);
	request.setAttribute("staticServerURL", staticServerURL);
	String defaultDateFormatPattern = PropsUtil
			.get("default.data.format.pattern");
	request.setAttribute("defaultDateFormatPattern",
			defaultDateFormatPattern);
	String defaultTimeFormatPattern = PropsUtil
			.get("default.time.format.pattern");
	request.setAttribute("defaultTimeFormatPattern",
			defaultTimeFormatPattern);
%>