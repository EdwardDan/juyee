<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<portlet:actionURL var="saveUnitProjectsURL" name="saveUnitProjects">
	<portlet:param name="redirectURL" value="${editPermitURL }" />
</portlet:actionURL>
<%
	Long completeId = ParamUtil.getLong(request, "completeId");
	System.out.println("completeId=" + completeId);
%>
单位工程列表

