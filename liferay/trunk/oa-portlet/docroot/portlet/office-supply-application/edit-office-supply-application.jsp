<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<portlet:renderURL var="viewURL" />
<%
	long userId = PortalUtil.getUserId(request);
	String userName = PortalUtil.getUserName(userId, "default");
%>
<liferay-ui:header title='办公用品申请' backURL="${viewURL}"/>
<portlet:actionURL var="saveOfficeSupplyApplicationURL" name="saveOfficeSupplyApplication">  
	<portlet:param name="redirect" value="${viewURL }" />
</portlet:actionURL>
<aui:form action="${saveOfficeSupplyApplicationURL}">
	<aui:fieldset>
		<aui:input name="deptName" label="申请部门"/>
		<aui:input name="userName" label="申请人" value="<%=userName%>"/>
	</aui:fieldset>
	<div id="member-fields">
		<div class="lfr-form-row lfr-form-row-inline">	
			<div class="row-fields" style="display: flex;">
				<aui:input fieldParam='name1' id='name1' name="name1" label="申请物品" required="true" />
				<aui:input fieldParam='model1' id='model1' name="model1" label="型号"/>
				<aui:input fieldParam='unit1' id='unit1' name="unit1" label="单位"/>
				<aui:input fieldParam='unitPrice1' id='unitPrice1' name="unitPrice1" label="预计单价"/>
				<aui:input fieldParam='quantity1' id='quantity1' name="quantity1" label="数量" type="number" required="true"/>
			</div>
		</div>
	</div>
	<aui:input type="textarea" name="introductions" label="申请说明"/>
	<aui:button-row>
		<aui:button type="submit" value="提交" />
		<aui:button type="cancel" value="取消" href="${viewURL }" />
	</aui:button-row>
</aui:form>

<aui:script>
AUI().use('liferay-auto-fields',function(A) { 
 new Liferay.AutoFields(
       {
           contentBox: '#member-fields',
           fieldIndexes: '<portlet:namespace/>rowIndexes'
       }
   ).render();
   });
</aui:script>