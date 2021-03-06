<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<%@ page import="com.justonetech.cp.permit.model.ParticipationUnit"%>

<!-- <style>

.aui .control-group {
    margin-bottom: 0px;
}


</style> -->
<%
renderRequest.setAttribute("completeId", ParamUtil.getLong(request, "completeId"));
renderRequest.setAttribute("bjbh", ParamUtil.getString(request, "bjbh"));
%>
	<c:set var="editCompleteURL"
		value="${editCompleteURL }&${renderResponse.namespace}completeId=${completeId}&${renderResponse.namespace}bjbh=${bjbh }"></c:set>
<liferay-ui:header title="单位工程列表" backURL='${editCompleteURL.concat("&_").concat(portletDisplay.id).concat("_tabSqbz=2")}'></liferay-ui:header>
<c:set var="contextPath"
	value="${request.contextPath}/portlet/complete-application" />
<portlet:renderURL var="searchURL">
	<portlet:param name="mvcPath"
		value="${contextPath }/select-permit-unitProject.jsp" />
</portlet:renderURL>
<aui:form name="fm" method="get" action="${searchURL }">
	<%
		int num = 1;
		String n = num + "";
	%>

	<liferay-portlet:renderURL var="selectUnitProjectsURL">
		<portlet:param name="mvcPath"
			value="${contextPath }/edit-complete.jsp" />
		<portlet:param name="completeId" value="${completeId}" />
		<portlet:param name="permitUnitProjectIds"
			value="${permitUnitProjectIds}" />
		<portlet:param name="bjbh" value="${bjbh}" />
		<portlet:param name="tabSqbz" value="2" />
	</liferay-portlet:renderURL>

	<aui:button-row>
		<aui:button disabled="<%=true%>" name="deleteOfficeSuppliesBtn"
			value="选择"
			onClick='<%=renderResponse.getNamespace() + "selectUnitProjects();"%>' />
	</aui:button-row>


	<liferay-ui:panel title="单位工程信息列表" collapsible="false">
		<liferay-ui:search-container emptyResultsMessage="没有找到已单位工程信息"
			rowChecker="<%=new RowChecker(renderResponse)%>">
			<liferay-ui:search-container-results results="${unitProjects}"
				total="${unitProjectCount}">
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="UnitProject"
				modelVar="unitProject" keyProperty="projectId">
				<liferay-ui:search-container-column-text value="<%=n%>" name="序号 " />
				<%
					num = num + 1;
											n = num + "";
				%>
				<liferay-ui:search-container-column-text property="bjbh" name="报建编号" />
				<liferay-ui:search-container-column-text property="gcbh" name="工程编号" />
				<liferay-ui:search-container-column-text property="gcmc" name="工程名称" />
				<liferay-ui:search-container-column-text property="jsnr" name="建设内容" />
				<portlet:renderURL var="editUnitProjectURL">
					<portlet:param name="mvcPath" value="${editCompleteNewURL}" />
				</portlet:renderURL>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator>
				<%
					String bjbh = ParamUtil.getString(request, "bjbh");
							String completeId= renderRequest.getParameter("completeId");
							PortletURL portletURL = searchContainer.getIteratorURL();
							portletURL.setParameter("mvcPath", "/portlet/complete-application/select-permit-unitProject.jsp");
							portletURL.setParameter("bjbh", bjbh);
							portletURL.setParameter("completeId", completeId);
				%>
			</liferay-ui:search-iterator>
		</liferay-ui:search-container>
	</liferay-ui:panel>

</aui:form>

<aui:script>
	
Liferay.Util.toggleSearchContainerButton('#<portlet:namespace />deleteOfficeSuppliesBtn', '#<portlet:namespace /><%=searchContainerReference.getId("searchContainer")%>SearchContainer', document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
	
	Liferay.provide(
			window,
			'<portlet:namespace />selectUnitProjects',
			function(projectIds) {
				if(confirm("确定所选单位工程吗？")){
					if(!projectIds){
						projectIds = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
					}
					if(''!=projectIds){
						if(''!='${permitUnitProjectIds}'){
						projectIds=projectIds+","+'${permitUnitProjectIds}';
						}
					}else{
						projectIds=permitUnitProjectIds;
					}
					location.href="${selectUnitProjectsURL}&<portlet:namespace />projectIds="+ projectIds;
				}
			},
			['liferay-util-list-fields']
		);
</aui:script>