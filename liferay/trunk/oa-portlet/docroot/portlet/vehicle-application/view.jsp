<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ page import="java.text.SimpleDateFormat"%>

<c:set var="contentPath"
	value="${request.contextPath}/portlet/vehicle-requisition" />
<portlet:renderURL var="viewURL" />
<portlet:actionURL var="deleteVehicleRequisitionsURL" name="deleteVehicleRequisitions">
	<portlet:param name="redirect" value="${viewURL}" />
</portlet:actionURL>
<% 
	SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
%>
<aui:form action="${viewURL }" name="fm">
	<aui:nav-bar>
		<aui:nav>
			<portlet:renderURL var="addVehicleRequisitionURL">
				<portlet:param name="mvcPath"
					value="${contentPath }/edit-vehicle-requisition.jsp" />
			</portlet:renderURL>
			<aui:nav-item href="<%=addVehicleRequisitionURL%>" iconCssClass="icon-plus"
				label="添加" />
		</aui:nav>
		<aui:nav-bar-search cssClass="pull-right">
			<div class="form-search">
				<liferay-ui:input-search />
			</div>
		</aui:nav-bar-search>
	</aui:nav-bar>
	<aui:button-row>
		<aui:button disabled="<%=true%>" name="deleteVehicleRequisitionsBtn" value="删除" onClick='<%=renderResponse.getNamespace() + "deleteVehicleRequisitions();"%>' />
	</aui:button-row>
	<liferay-ui:search-container emptyResultsMessage="没有找到车辆申请信息。" rowChecker="<%=new RowChecker(renderResponse)%>">
		<liferay-ui:search-container-results results="${vehicleRequisitions }"
			total="${vehicleRequisitionsCount }">
		</liferay-ui:search-container-results>
		<liferay-ui:search-container-row className="VehicleRequisition" modelVar="vehicleRequisition" keyProperty="vehicleRequisitionId">
			<liferay-ui:search-container-column-text property="applicantDeptName" name="申请部门" />
			<liferay-ui:search-container-column-text property="applicantName" name="申请人" />
			<liferay-ui:search-container-column-text  name="用车开始时间" value="<%=df.format(vehicleRequisition.getStartTime())%>" />
			<liferay-ui:search-container-column-text  name="用车结束时间" value="<%=df.format(vehicleRequisition.getEndTime()) %>"/> 
			<liferay-ui:search-container-column-text property="reason" name="用车事由" />
			<liferay-ui:search-container-column-text>
				<liferay-ui:icon-menu>
					<portlet:actionURL var="editVehicleRequisitionURL" name="editVehicleRequisition">
						<portlet:param name="vehicleRequisitionId" value="${vehicleRequisition.vehicleRequisitionId}" />
						<portlet:param name="mvcPath" value="${contentPath }/edit-vehicle-requisition.jsp" />
					</portlet:actionURL>
					<liferay-ui:icon image="edit" label="编辑" url="${editVehicleRequisitionURL}" />
					<liferay-ui:icon image="delete" label="删除" url="javascript:void(0);" onClick='<%=renderResponse.getNamespace() + "deleteVehicleRequisitions("+vehicleRequisition.getVehicleRequisitionId()+");"%>' />
				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator/>
	</liferay-ui:search-container>
</aui:form>

<aui:script>
	
	Liferay.Util.toggleSearchContainerButton('#<portlet:namespace />deleteVehicleRequisitionsBtn', '#<portlet:namespace /><%=searchContainerReference.getId("searchContainer")%>SearchContainer', document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
	
	Liferay.provide(
			window,
			'<portlet:namespace />deleteVehicleRequisitions',
			function(vehicleRequisitionIds) {
				if(confirm("确定要删除所选数据吗？")){
					if(!vehicleRequisitionIds){
						vehicleRequisitionIds = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
					}
					location.href="<%=deleteVehicleRequisitionsURL%>&<portlet:namespace />vehicleRequisitionIds="+ vehicleRequisitionIds;
				}
			},
			['liferay-util-list-fields']
		);
</aui:script>