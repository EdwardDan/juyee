<%@include file="/common/init.jsp"%>
<%@ page contentType="text/html;charset=utf-8"%>

<%
	Long dictionaryId = (Long) request.getAttribute("dictionaryId");
%>
<portlet:actionURL var="add" name="add">
	<portlet:param name="redirect" value="${def}" />
</portlet:actionURL>
<portlet:renderURL var="def" />
<liferay-ui:header title="添加代码项" backURL="${def}" />

<aui:form action="${add}" method="post">
	<aui:input name="dictionaryId" type="hidden" value="<%=dictionaryId%>" />
	<aui:input type="text" label="编码：" name="code" value="${code}"></aui:input>
	<aui:input type="text" label="名称:" name="name" value="${name}"></aui:input>
	<aui:input type="number" label="特殊标记:" name="tag" value="${name}"></aui:input>
	<aui:select name="isValid" label="是否有效:">
	<aui:option value="1">是</aui:option>
	<aui:option value="2">否</aui:option>
	</aui:select>
	<aui:input type="content" label="备注:" name="desc" value="${desc}"></aui:input>
	<aui:button type="submit"></aui:button>
	<aui:button type="reset" value="重置"></aui:button>
</aui:form>