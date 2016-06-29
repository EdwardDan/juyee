<%@include file="/common/init.jsp"%>
<%@include file="/common/init-ext.jsp"%>
<%@ page contentType="text/html;charset=utf-8"%>

<portlet:actionURL var="input" name="inputCodeSet"> 
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
	<aui:input type="text" label="编码：" name="code" value="${code}">
		<aui:validator name="required" errorMessage="这里不可空白!"></aui:validator>
	</aui:input>
	<aui:input type="text" label="名称:" name="name" value="${name}">
		<aui:validator name="required" errorMessage="这里不可空白!"></aui:validator>
	</aui:input>
	<%
		if (Validator.isNotNull(dictionaryId)) {
	%>
	<aui:input type="number" max="90000" label="排序号:" name="sortNo" value="${sortNo}"></aui:input>
	<%
		}
	%>
	<aui:input type="text" label="备注:" name="desc" value="${desc}"></aui:input>
	<aui:button type="submit"></aui:button>
	<aui:button type="reset" value="重置"></aui:button>
</aui:form>