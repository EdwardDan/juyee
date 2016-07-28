<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ page import="java.text.SimpleDateFormat"%>

<c:set var="contextPath"
	value="${request.contextPath}/portlet/vehicle-application" />
<portlet:renderURL var="viewURL" />
<portlet:actionURL var="deleteVehicleApplicationsURL" name="deleteVehicleApplications">
	<portlet:param name="redirect" value="${viewURL}" />
</portlet:actionURL>
<% 
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<aui:form action="${viewURL }" name="fm">
	<aui:nav-bar>
		<aui:nav>
			<portlet:renderURL var="addVehicleApplicationURL">
				<portlet:param name="mvcPath"
					value="${contextPath }/edit-vehicle-aplication.jsp" />
			</portlet:renderURL>
			<aui:nav-item href="<%=addVehicleApplicationURL%>" iconCssClass="icon-plus"
				label="添加" />
		</aui:nav>
		<aui:nav-bar-search cssClass="pull-right">
			<div class="form-search">
				<liferay-ui:input-search />
			</div>
		</aui:nav-bar-search>
	</aui:nav-bar>
	<aui:button-row>
		<aui:button disabled="<%=true%>" name="deleteVehicleApplicationsBtn" value="删除" onClick='<%=renderResponse.getNamespace() + "deleteVehicleApplications();"%>' />
	</aui:button-row>
	<liferay-ui:search-container emptyResultsMessage="没有找到车辆申请信息。" rowChecker="<%=new RowChecker(renderResponse)%>">
		<liferay-ui:search-container-results results="${vehicleApplications }"
			total="${vehicleApplicationsCount }">
		</liferay-ui:search-container-results>
		<liferay-ui:search-container-row className="VehicleApplication" modelVar="vehicleApplication" keyProperty="vehicleApplicationId">
			<liferay-ui:search-container-column-text property="applicantDeptName" name="申请部门" />
			<liferay-ui:search-container-column-text property="applicantName" name="申请人" />
			<liferay-ui:search-container-column-text  name="用车开始时间" value="<%=df.format(vehicleApplication.getStartTime())%>" />
			<liferay-ui:search-container-column-text  name="用车结束时间" value="<%=df.format(vehicleApplication.getEndTime()) %>"/> 
			<liferay-ui:search-container-column-text property="reason" name="用车事由" />
			<liferay-ui:search-container-column-text>
				<liferay-ui:icon-menu>
					<portlet:actionURL var="editVehicleApplicationURL" name="editVehicleApplication">
						<portlet:param name="vehicleApplicationId" value="${vehicleApplication.vehicleApplicationId}" />
						<portlet:param name="mvcPath" value="${contextPath }/edit-vehicle-aplication.jsp" />
					</portlet:actionURL>
					<liferay-ui:icon image="edit" label="编辑" url="${editVehicleApplicationURL}" />
					<liferay-ui:icon image="delete" label="删除" url="javascript:void(0);" onClick='<%=renderResponse.getNamespace() + "deleteVehicleApplications("+vehicleApplication.getVehicleApplicationId()+");"%>' />
				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator/>
	</liferay-ui:search-container>
</aui:form>

<aui:script>
	
	Liferay.Util.toggleSearchContainerButton('#<portlet:namespace />deleteVehicleApplicationsBtn', '#<portlet:namespace /><%=searchContainerReference.getId("searchContainer")%>SearchContainer', document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
	
	Liferay.provide(
			window,
			'<portlet:namespace />deleteVehicleApplications',
			function(vehicleApplicationIds) {
				if(confirm("确定要删除所选数据吗？")){
					if(!vehicleApplicationIds){
						vehicleApplicationIds = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
					}
					location.href="<%=deleteVehicleApplicationsURL%>&<portlet:namespace />vehicleApplicationIds="+ vehicleApplicationIds;
				}
			},
			['liferay-util-list-fields']
		);
</aui:script>