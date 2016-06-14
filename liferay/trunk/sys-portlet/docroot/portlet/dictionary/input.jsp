<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@include file="/common/init.jsp"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>

<portlet:actionURL var="input" name="input">
	<portlet:param name="redirect" value="${def}" />
</portlet:actionURL>
<portlet:renderURL var="def" />
<%
	Long dictionaryId = (Long) request.getAttribute("dictionaryId");
	if (Validator.isNotNull(dictionaryId)) {
%>
<liferay-ui:header title="编辑代码集" backURL="${def}" />

<%
	} else {
%>
<liferay-ui:header title="添加代码集" backURL="${def}" />
<%
	}
%>
<aui:form action="${input}" method="post">
	<aui:input name="dictionaryId" type="hidden" value="<%=dictionaryId%>" />
	<aui:input type="text" label="编码：" name="code" value="${code}"></aui:input>
	<aui:input type="text" label="名称:" name="name" value="${name}"></aui:input>
	<aui:input type="content" label="备注:" name="desc" value="${desc}"></aui:input>
	<aui:button type="submit"></aui:button>
	<aui:button type="reset" value="重置"></aui:button>
</aui:form>