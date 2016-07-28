<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contextPath" value="${request.contextPath}/portlet/project" />
<portlet:renderURL var="viewURL" />
<portlet:actionURL var="addProjectURL" name="editProject">
	<portlet:param name="mvcPath" value="${contextPath }/edit-project.jsp" />
</portlet:actionURL>
<portlet:actionURL var="deleteProjectsURL" name="deleteProjects">
	<portlet:param name="redirect" value="${viewURL}" />
</portlet:actionURL>
<aui:form action="${viewURL }" name="fm">
	<aui:row>
		<aui:col span="6">
			<aui:button value="添加" href="${addProjectURL}" icon="icon-plus"/>
			<aui:button disabled="<%=true%>" icon="icon-remove" name="deleteProjectsBtn" value="删除" onClick='<%=renderResponse.getNamespace() + "deleteProjects();"%>' />
		</aui:col>
		<aui:col span="6" cssClass="text-right">
			<div class="form-search">
			<liferay-ui:input-search />
			</div>
		</aui:col>
	</aui:row>
	<liferay-ui:search-container emptyResultsMessage="没有找到项目基本信息。"
		rowChecker="<%=new RowChecker (renderResponse)%>">
		<liferay-ui:search-container-results results="${projects}"
			total="${projectCount}" />
		<liferay-ui:search-container-row className="Project" modelVar="proj"
			keyProperty="projectId">
			<liferay-ui:search-container-column-text name="项目名称"
				property="projName" />
			<liferay-ui:search-container-column-text name="所属区县"
				value="${proj.belongCounty==0?'上海市':''}" />
			<liferay-ui:search-container-column-text name="项目状态">
				<c:if test="${!empty projectStatuses}">
					<%=DictionaryLocalServiceUtil.getDictionary(proj.getProjStatus()).getName()%>
				</c:if>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="业态类别">
			<c:if test="${!empty industryCategories}">
				<%=DictionaryLocalServiceUtil.getDictionary(proj.getIndustryCategory()).getName()%>
			</c:if>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="工可批复总投资(亿元)"
				property="feasibilityTotalInvestment" />
			<liferay-ui:search-container-column-text name="action">
				<portlet:actionURL var="viewProjectURL" name="viewProject">
					<portlet:param name="projectId" value="${proj.projectId}" />
					<portlet:param name="mvcPath"
						value="${contextPath }/view-project.jsp" />
				</portlet:actionURL>
				<portlet:actionURL var="deleteURL">
					<portlet:param name="projectId" value="${proj.projectId}" />
				</portlet:actionURL>
				<portlet:actionURL var="editProjectURL" name="editProject">
					<portlet:param name="projectId" value="${proj.projectId}" />
					<portlet:param name="mvcPath"
						value="${contextPath }/edit-project.jsp" />
				</portlet:actionURL>
				<liferay-ui:icon-menu>
					<liferay-ui:icon image="view" url="${viewProjectURL}" />
					<liferay-ui:icon image="edit" url="${editProjectURL}" />
					<liferay-ui:icon image="delete" label="删除"
						url="javascript:void(0);"
						onClick='<%=renderResponse.getNamespace()+"deleteProjects("+proj.getProjectId()+");"%>' />
				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</aui:form>
<aui:script>
	Liferay.Util.toggleSearchContainerButton('#<portlet:namespace />deleteProjectsBtn', '#<portlet:namespace /><%=searchContainerReference.getId("searchContainer")%>SearchContainer', document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
	Liferay.provide(
			window,
			'<portlet:namespace />deleteProjects',
			function(projectIds) {
				if(confirm("确定要删除所选数据吗？")){
					if(!projectIds){
						projectIds = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
					}
					location.href="<%=deleteProjectsURL%>&<portlet:namespace/>projectIds="+ projectIds;
				}
			},
			['liferay-util-list-fields']
		);
</aui:script>
	










































