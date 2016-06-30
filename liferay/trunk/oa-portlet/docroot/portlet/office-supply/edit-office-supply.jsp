
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contentPath"
	value="${request.contextPath}/portlet/office-supply" />

<portlet:renderURL var="viewURL" />
<aui:model-context bean="${officeSupply}"
	model="<%=OfficeSupply.class %>" />
<portlet:renderURL var="viewURL" />
<liferay-ui:header title='${empty officeSupply?"添加":"编辑"}办公用品'
	backURL="${viewURL }" />
<portlet:actionURL var="saveOfficeSupplyURL" name="saveOfficeSupply">
	<portlet:param name="redirect" value="${viewURL }" />
</portlet:actionURL>
<aui:form action="${saveOfficeSupplyURL}">
	<aui:fieldset>
		<aui:input name="officeSupplyId" type="hidden" />
		<aui:input name="name" label="名称" />
		<aui:input name="model" label="型号" />
		<aui:input name="unit" label="单位" />
		<aui:input name="unitPrice" label="单价" />
		<aui:input name="quantity" label="库存" />
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" value="提交" />
		<aui:button type="cancel" value="取消" href="${viewURL }" />
	</aui:button-row>
</aui:form>