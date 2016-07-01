<%@include file="/common/init.jsp"%>
<%@include file="/common/init-ext.jsp"%>
<%@ page contentType="text/html;charset=utf-8"%>
<c:set var="contentPath"
	value="${request.contextPath}/portlet/dictionary" />
<%
	long dictionaryId = ParamUtil.getLong(request, "dictionaryId");
	Long parentId = (Long) request.getAttribute("parentId");
	int edit = ParamUtil.getInteger(request, "edit");
%>
<portlet:actionURL var="addCode" name="addCode">    
	<portlet:param name="redirect" value="${def}" />
</portlet:actionURL> 
<portlet:renderURL var="def" />
<liferay-ui:header title="添加代码" backURL="${def}" />

<aui:form action="${addCode}" method="post">
	<aui:input name="parentId" type="hidden" value="<%=parentId%>" />
	<aui:input name="dictionaryId" type="hidden" value="<%=dictionaryId%>" />
	<aui:input name="edit" type="hidden" value="<%=edit%>" />

	<aui:input type="text" label="编码：" name="code" value="${code}">
		<aui:validator name="required" errorMessage="这里不可空白!"></aui:validator>
	</aui:input>
	<aui:input type="text" label="名称:" name="name" value="${name}">
		<aui:validator name="required" errorMessage="这里不可空白!"></aui:validator>
	</aui:input>
	<%
		if (Validator.isNotNull(parentId)) {
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