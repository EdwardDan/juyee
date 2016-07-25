<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="com.justonetech.sys.model.Dictionary"%>
<%@ page import="com.justonetech.proj.model.*"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.*"%>
<%@page import="com.justonetech.proj.manager.project.*"%>
<%@page import="java.util.*"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.justonetech.sys.service.*"%>
<%@page import="com.justonetech.proj.service.*"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>

<%
	String staticServerURL = PropsUtil.get("static.server.url");
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