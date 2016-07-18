<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<portlet:renderURL var="viewURL" />
<liferay-ui:header title="查看办公用品申请" backURL="${viewURL}"></liferay-ui:header>
<c:set var="contentPath"
	value="${request.contextPath}/portlet/office-supply-application" />
<aui:row>
	<aui:col span="6">
		<aui:input type="hidden" name="officeSupplyApplicationId"
			value="${officeSupplyApplicationId}" />
		<aui:input name="deptName" label="申请部门"
			value="${officeSupplyApplication.deptName}" inlineField="true"
			disabled="true" />
	</aui:col>
	<aui:col span="6">
		<aui:input name="userName" label="申请人"
			value="${officeSupplyApplication.userName}" disabled="true" />
	</aui:col>
</aui:row>
<liferay-ui:search-container>
	<liferay-ui:search-container-results
		results="${officeSupplyApplicationItems}">
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row
		className="OfficeSupplyApplicationItem"
		modelVar="OfficeSupplyApplicationItem"
		keyProperty="officeSupplyApplicationItemId">
		<liferay-ui:search-container-column-text property="name" name="申请物品" />
		<liferay-ui:search-container-column-text property="model" name="型号" />
		<liferay-ui:search-container-column-text property="unit" name="单位" />
		<liferay-ui:search-container-column-text property="unitPrice"
			name="预计单价" />
		<liferay-ui:search-container-column-text property="quantity" name="数量" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
<aui:row>
	<aui:col span="6"></aui:col>
	<aui:col span="6">
		<aui:input name="sum"  label="预计总价" value="${sum}"
			disabled="true" />
	</aui:col>
</aui:row>
<aui:row>
	<aui:col span="12">
		<aui:input type="textarea" name="introductions" label="申请说明"
			value="${officeSupplyApplication.introductions}" disabled="true"
			cssClass="input-block-level" />
	</aui:col>
</aui:row>