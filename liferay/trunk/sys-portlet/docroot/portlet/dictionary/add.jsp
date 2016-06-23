<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@include file="/common/init.jsp"%>
<%@ page contentType="text/html;charset=utf-8"%>

<%
	long dictionaryId = ParamUtil.getLong(request, "dictionaryId");
	Long parentID = (Long) request.getAttribute("parentId");
%>
<portlet:actionURL var="add" name="add">
	<portlet:param name="redirect" value="${def}" />
</portlet:actionURL>
<portlet:renderURL var="def" />
<liferay-ui:header title="添加代码项" backURL="${def}" />

<aui:form action="${add}" method="post">
	<aui:input name="parentID" type="hidden" value="<%=parentID%>" />
	<aui:input name="dictionaryId" type="hidden" value="<%=dictionaryId%>" />

	<aui:input type="text" label="编码：" name="code" value="${code}">
		<aui:validator name="required" errorMessage="这里不可空白!"></aui:validator>
	</aui:input>
	<aui:input type="text" label="名称:" name="name" value="${name}">
		<aui:validator name="required" errorMessage="这里不可空白!"></aui:validator>
	</aui:input>
	<%
		if (Validator.isNotNull(parentID)) {
	%>
	<aui:input type="number" max="90000" label="排序号:" name="sortNo" value="${sortNo}"></aui:input>
	<%
		}
	%>
	<aui:input type="text" label="特殊标记:" name="tag" value="${tag}"></aui:input>
	<aui:select name="isValid" label="是否有效:">
		<%
			Boolean isValid = (Boolean) request.getAttribute("isValid");
					if (Validator.isNotNull(isValid)) {
						if (isValid == false) {
		%>
		<aui:option value="1">是</aui:option>
		<aui:option value="2" selected="true">否</aui:option>
		<%
			} else {
		%>
		<aui:option value="1" selected="true">是</aui:option>
		<aui:option value="2">否</aui:option>
		<%
			}
					} else {
		%>
		<aui:option value="1">是</aui:option>
		<aui:option value="2">否</aui:option>
		<%
			}
		%>
	</aui:select>
	<aui:input type="text" label="备注:" name="desc" value="${desc}"></aui:input>
	<aui:button type="submit"></aui:button>
	<aui:button type="reset" value="重置"></aui:button>
</aui:form>