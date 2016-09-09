<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="../init.jsp"%>
<%
	String pdfURL = ParamUtil.getString(request, "pdfURL");
%>
<iframe src="/static/pdf/web/viewer.html?file=<%=pdfURL%>" width="98%" height="800px" scrolling="auto" frameborder="0" style="position: relative; left: 1%"> </iframe>

