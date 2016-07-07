<%@page
	import="com.justonetech.oa.service.OfficeSupplyApplicationItemLocalServiceUtil"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<portlet:renderURL var="viewURL" />
<%
	long userId = PortalUtil.getUserId(request);
	String userName = PortalUtil.getUserName(userId, "default");
%>
<liferay-ui:header
	title='${empty officeSupplyApplication?"":"编辑"}办公用品申请'
	backURL="${viewURL}" />
<portlet:actionURL var="saveOfficeSupplyApplicationURL"
	name="saveOfficeSupplyApplication">
	<portlet:param name="redirect" value="${viewURL }" />
</portlet:actionURL>
<aui:form action="${saveOfficeSupplyApplicationURL}">
	<aui:row>
		<aui:col span="6" cssClass="text-center">
			<aui:input type="hidden" name="officeSupplyApplicationId"
				value="${officeSupplyApplicationId}" />
			<aui:input name="deptName" label="申请部门"
				value="${officeSupplyApplication.deptName}" inlineField="true"
				inlineLabel="left" />
		</aui:col>
		<aui:col span="6" cssClass="text-center">
			<aui:input name="userName" label="申请人" value="<%=userName%>"
				inlineLabel="left" disabled="true"/>
		</aui:col>
	</aui:row>
	<%
		List<OfficeSupplyApplicationItem> officeSupplyApplicationItems = (List<OfficeSupplyApplicationItem>) request
			.getAttribute("officeSupplyApplicationItems");
			Integer size = (Integer)request.getAttribute("size");
		if(Validator.isNotNull(officeSupplyApplicationItems)){
		for(int i=0;i<size;i++) {
	%>
	<div id="member-fields">
		<div class="lfr-form-row lfr-form-row-inline">
			<div class="row-fields" style="display: flex;">
				<aui:input type="hidden" fieldParam='officeSupplyApplicationItemId1'
					id='officeSupplyApplicationItemId1'
					name="officeSupplyApplicationItemId1"
					value="<%=officeSupplyApplicationItems.get(i).getOfficeSupplyApplicationItemId()%>" />
				<aui:input fieldParam='name1' id='name1' name="name1" label="申请物品"
					required="true"
					value="<%=officeSupplyApplicationItems.get(i).getName()%>" />
				<aui:input fieldParam='model1' id='model1' name="model1" label="型号"
					value="<%=officeSupplyApplicationItems.get(i).getModel()%>" />
				<aui:input fieldParam='unit1' id='unit1' name="unit1" label="单位"
					value="<%=officeSupplyApplicationItems.get(i).getUnit()%>" />
				<aui:input fieldParam='unitPrice1' id='unitPrice1' name="unitPrice1"
					label="预计单价" type="number"
					value="<%=officeSupplyApplicationItems.get(i).getUnitPrice()%>" />
				<aui:input fieldParam='quantity1' id='quantity1' name="quantity1"
					label="数量" type="number" required="true"
					value="<%=officeSupplyApplicationItems.get(i).getQuantity()%>" />
			</div>
		</div>
	</div>
	<%
		}}else{
	%>
	<div id="member-fields">
		<div class="lfr-form-row lfr-form-row-inline">
			<div class="row-fields" style="display: flex;">
				<aui:input fieldParam='name1' id='name1' name="name1" label="申请物品"
					required="true" />
				<aui:input fieldParam='model1' id='model1' name="model1" label="型号" />
				<aui:input fieldParam='unit1' id='unit1' name="unit1" label="单位" />
				<aui:input fieldParam='unitPrice1' id='unitPrice1' name="unitPrice1"
					label="预计单价" type="number" />
				<aui:input fieldParam='quantity1' id='quantity1' name="quantity1"
					label="数量" type="number" required="true" />
			</div>
		</div>
	</div>
	<%
		}
	%>
	<aui:row>
		<aui:col span="12">
			<aui:input type="textarea" name="introductions" label="申请说明"
				value="${officeSupplyApplication.introductions}" />
		</aui:col>
	</aui:row>
	<aui:button-row>
		<aui:button type="submit" value="提交" />
		<aui:button type="submit" value="暂存" />
		<aui:button type="cancel" value="取消" href="${viewURL }" />
	</aui:button-row>
</aui:form>

<aui:script>
	AUI().use('liferay-auto-fields', function(A) {
		new Liferay.AutoFields({
			contentBox : '#member-fields',
			fieldIndexes : '<portlet:namespace/>rowIndexes'
		}).render();
	});	
</aui:script>