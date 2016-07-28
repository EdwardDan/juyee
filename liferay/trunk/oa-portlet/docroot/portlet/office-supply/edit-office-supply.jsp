<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<script src="${staticServerURL}/My97DatePicker/WdatePicker.js"></script>
<c:set var="contextPath"
	value="${request.contextPath}/portlet/vehicle-application" />
<c:set var="namespace" value="<%=renderResponse.getNamespace()%>" />
<aui:model-context bean="${vehicleApplication}"
	model="<%=VehicleApplication.class %>" />
<portlet:renderURL var="viewURL" />
<%
    String timeFormatPattern = defaultDateFormatPattern + " " + defaultTimeFormatPattern.substring(0, 5);
    request.setAttribute("timeFormatPattern", timeFormatPattern);
    VehicleApplication vehicleApplication = (VehicleApplication) request.getAttribute("vehicleApplication");
    String startTimeFmt = "";
    String endTimeFmt = "";
    if (null != vehicleApplication) {

        startTimeFmt = DateUtil.getDate(vehicleApplication.getStartTime(), timeFormatPattern, locale, timeZone);
        request.setAttribute("startTimeFmt", startTimeFmt);
        endTimeFmt = DateUtil.getDate(vehicleApplication.getStartTime(), timeFormatPattern, locale, timeZone);
        request.setAttribute("endTimeFmt", endTimeFmt);
        if (Validator.isBlank(vehicleApplication.getDestination())) {
            vehicleApplication.setDestination("上海市(    )区(    )路(    )号");
        }
    }
%>
<liferay-ui:header title='${empty vehicleApplication?"添加":"编辑"}车辆申请'
	backURL="${viewURL }" />
<portlet:actionURL var="saveVehicleApplicationURL"
	name="saveVehicleApplication">
	<portlet:param name="redirect" value="${viewURL }" />
</portlet:actionURL>
<aui:form action="${saveVehicleApplicationURL}">

	<aui:fieldset>
		<aui:row>
			<aui:col span="6">
				<aui:input name="vehicleApplicationId" type="hidden" />
				<aui:input name="applicantDeptName" label="申请部门名称" required="true" />
			</aui:col>
			<aui:col span="6">
				<aui:input name="applicantName" label="申请人" required="true" />
			</aui:col>
		</aui:row>
		<aui:row> 
			<aui:col span="6">
				<aui:input type="text" name="startTimeFmt" label="开始时间"
					cssClass="Wdate"  required="true"
					onfocus="WdatePicker({maxDate:'#F{$dp.$D(\\'${namespace }endTimeFmt\\')}',dateFmt:'${timeFormatPattern}'})"
					value="${startTimeFmt}"/>
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" name="endTimeFmt" label="结束时间"
					cssClass="Wdate" required="true"
					onfocus="WdatePicker({minDate:'#F{$dp.$D(\\'${namespace }startTimeFmt\\')}',dateFmt:'${timeFormatPattern}'})"
					value="${endTimeFmt}"/>
			</aui:col> 
		</aui:row>
		<aui:row>
			<aui:col span="6">
				<aui:input name="passengerNum" label="用车人数">
					<aui:validator name="digits" />
					<aui:validator name="min" errorMessage="请输入大于0的值。">0</aui:validator>
				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input name="destination" label="目的地" required="true"
					value="上海市(    )区(    )路(    )号" />
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="12">
				<aui:input name="reason" label="用车事由" type="textarea" />
			</aui:col>
		</aui:row>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" value="提交" />
		<aui:button type="cancel" value="取消" href="${viewURL }" />
	</aui:button-row>
</aui:form>
