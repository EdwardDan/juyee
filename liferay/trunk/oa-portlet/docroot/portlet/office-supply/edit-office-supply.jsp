
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
	<aui:row>
		<aui:col span="6">
			<aui:input name="officeSupplyId" type="hidden" />
			<aui:input name="name" label="名称" required="true"/>
		</aui:col>
		<aui:col span="6">
			<aui:input name="model" label="型号" />
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6">
			<aui:input name="unit" label="单位" />
		</aui:col>
		<aui:col span="6">
			<aui:input name="unitPrice" label="单价" />
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6">
			<aui:input name="quantity" label="库存" />
		</aui:col>
		<aui:col span="6">
		</aui:col>
	</aui:row>



	<aui:button-row>
		<aui:button type="submit" value="提交" />
		<aui:button type="cancel" value="取消" href="${viewURL }" />
	</aui:button-row>
</aui:form>