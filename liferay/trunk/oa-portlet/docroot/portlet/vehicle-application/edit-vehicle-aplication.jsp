<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<script src="${staticServerURL}/My97DatePicker/WdatePicker.js"></script>
<c:set var="contentPath"
	value="${request.contextPath}/portlet/vehicle-application" />
<portlet:renderURL var="viewURL" />
<aui:model-context bean="${vehicleApplication}"
	model="<%=VehicleApplication.class %>" />
<portlet:renderURL var="viewURL" />
 <%
	VehicleApplication vehicleApplication = (VehicleApplication) request.getAttribute("vehicleApplication");
 	SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	String startTimes="";
	String endTimes="";
	if(null!=vehicleApplication){
		startTimes=df.format(vehicleApplication.getStartTime());
		endTimes=df.format(vehicleApplication.getEndTime());
		if(Validator.isBlank(vehicleApplication.getDestination())){
			vehicleApplication.setDestination("上海市(    )区(    )路(    )号");
		}
	}
	
%>
<liferay-ui:header title='${empty vehicleApplication?"添加":"编辑"}车辆申请'
	backURL="${viewURL }" />
<portlet:actionURL var="saveVehicleApplicationURL" name="saveVehicleApplication">
	<portlet:param name="redirect" value="${viewURL }" />
</portlet:actionURL>
<aui:form action="${saveVehicleApplicationURL}">
	<aui:fieldset>
		<aui:input name="vehicleApplicationId" type="hidden" />
		<aui:input name="applicantDeptName" label="申请部门名称" required="true" />
		<aui:input name="applicantName" label="申请人" required="true"/>
		<aui:input type="text" cssClass="Wdate" name="startTimes" value="<%=startTimes %>"
			label="开始时间" onfocus="WdatePicker({lang:'zh-cn', dateFmt:'yyyy/MM/dd HH:mm'})" required="true"/>
		<aui:input type="text" cssClass="Wdate" name="endTimes" value="<%=endTimes %>"
			label="结束时间" onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy/MM/dd HH:mm'})" required="true"/>
		<aui:input name="passengerNum" label="用车人数" required="true"/>
		
		<aui:input name="reason" label="用车事由" />
		<aui:input name="destination" label="目的地" required="true" value="上海市(    )区(    )路(    )号"/>
		
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" value="提交" />
		<aui:button type="cancel" value="取消" href="${viewURL }" />
	</aui:button-row>
</aui:form> 