<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<portlet:defineObjects />

申请（按钮）

列表
<c:set var="contextPath"
	value="${request.contextPath}/portlet/expert-application" />
<portlet:renderURL var="addExpertURL">
	<portlet:param name="mvcPath" value="${contextPath}/add-expert.jsp"/>
</portlet:renderURL>

<aui:button href="${addExpertURL}" value="申请"></aui:button>

