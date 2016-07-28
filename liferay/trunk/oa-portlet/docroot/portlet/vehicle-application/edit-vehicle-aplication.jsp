<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<script src="${staticServerURL}/My97DatePicker/WdatePicker.js"></script>
<c:set var="contextPath"
	value="${request.contextPath}/portlet/vehicle-application" />
<c:set var="namespace" value="<%=renderResponse.getNamespace()%>" />
<portlet:renderURL var="viewURL" />
<aui:model-context bean="${vehicleApplication}"
	model="<%=VehicleApplication.class %>" />
<portlet:renderURL var="viewURL" />
<%
	VehicleApplication vehicleApplication = (VehicleApplication) request.getAttribute("vehicleApplication");
	String startDate = "";
	String startDates = "";
	String endDate = "";
	String endDates = "";
	String startTimes = "";
	String endTimes = "";
	if (null != vehicleApplication) {
		startDate = DateUtil.getDate(vehicleApplication.getStartTime(), defaultDateFormatPattern, locale,
				timeZone);
		startDates = DateUtil.getDate(vehicleApplication.getStartTime(), defaultTimeFormatPattern, locale,
				timeZone);
		endDate = DateUtil.getDate(vehicleApplication.getEndTime(), defaultDateFormatPattern, locale, timeZone);
		endDates = DateUtil
				.getDate(vehicleApplication.getEndTime(), defaultTimeFormatPattern, locale, timeZone);
		String sTimes = startDate + " " + startDates;
		String eTimes = endDate + " " + endDates;
		startTimes = sTimes.substring(0, 16);
		endTimes = eTimes.substring(0, 16);
		if (Validator.isBlank(vehicleApplication.getDestination())) {
			vehicleApplication.setDestination("上海市(    )区(    )路(    )号");
		}
	}
	request.setAttribute("startTimes", startTimes);
	request.setAttribute("endTimes", endTimes);
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
			<aui:col span="6" cssClass="">
				<aui:input name="vehicleApplicationId" type="hidden" />
				<aui:input name="applicantDeptName" label="申请部门名称:" required="true" />
			</aui:col>
			<aui:col span="6" cssClass="">
				<aui:input name="applicantName" label="申请人:" required="true" />
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="6" cssClass="">
		开始时间：<br>
				<input type="text" class="Wdate" id="startTime"
					name="<portlet:namespace/>startTime" value="${startTimes}"
					onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endTime\')}',lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm'})"
					required="true" />
				<br>
			</aui:col>
			<aui:col span="6" cssClass="">
		结束时间：<br>
				<input type="text" class="Wdate" id="endTime"
					name="<portlet:namespace/>endTime" value="${endTimes}"
					onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startTime\')}',lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm'})"
					required="true" />
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="6">
				<aui:input name="vehicleApplicationId" type="hidden" />
				<aui:input name="applicantDeptName" label="申请部门名称:" required="true" />
			</aui:col>
			<aui:col span="6">
				<aui:input name="applicantName" label="申请人:" required="true" />
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="6" cssClass="">
				<aui:input name="passengerNum" label="用车人数" required="true">
					<aui:validator name="digits" />
					<aui:validator name="min">0</aui:validator>
				</aui:input>
			</aui:col>
			<aui:col span="6" cssClass="">
				<aui:input name="destination" label="目的地" required="true"
					value="上海市(    )区(    )路(    )号" />
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" name="startTimeFmt" label="开始时间"
					cssClass="Wdate" required="true"
					onfocus="WdatePicker({maxDate:'#F{$dp.$D(\\'${namespace }endTimeFmt\\')}',dateFmt:'${timeFormatPattern}'})"
					value="${startTimeFmt}"></aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input type="text" name="endTimeFmt" label="结束时间"
					cssClass="Wdate" required="true"
					onfocus="WdatePicker({minDate:'#F{$dp.$D(\\'${namespace }startTimeFmt\\')}',dateFmt:'${timeFormatPattern}'})"
					value="${endTimeFmt}"></aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="12" cssClass="">
				<aui:input name="reason" label="用车事由" type="textarea" />
			</aui:col>
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
