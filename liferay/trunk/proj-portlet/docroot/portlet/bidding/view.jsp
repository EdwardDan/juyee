<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contextPath" value="${request.contextPath}/portlet/bidding" />
<portlet:renderURL var="viewURL" />
<portlet:renderURL var="add">
	<portlet:param name="mvcPath" value="${contextPath }/edit-project.jsp" />
</portlet:renderURL>
<portlet:actionURL var="deleteProjectsURL" name="deleteProjects">
	<portlet:param name="redirect" value="${viewURL}" />
</portlet:actionURL>
<aui:form action="${viewURL}" name="fm">
	<aui:nav-bar>
		<aui:nav-bar-search cssClass="pull-right">
			<div class="form-search">
				<liferay-ui:input-search />
			</div>
		</aui:nav-bar-search>
	</aui:nav-bar>
	<liferay-ui:search-container emptyResultsMessage="没有找到项目。">
		<liferay-ui:search-container-results results="${projects}"
			total="${projectCount}" />
		<liferay-ui:search-container-row className="Project" modelVar="proj"
			keyProperty="projectId">
			<liferay-ui:search-container-column-text name="项目名称"
				property="projName" />
			<liferay-ui:search-container-column-text name="项目性质"
				value="${proj.manageAttribute==24530?'市属':'区属'}" />
			<liferay-ui:search-container-column-text name="项目状态"
				value="<%=DictionaryLocalServiceUtil.getDictionary(proj.getProjStatus()).getName()%>" />
			<liferay-ui:search-container-column-text name="业态类别"
				value="<%=DictionaryLocalServiceUtil.getDictionary(proj.getIndustryCategory()).getName()%>" />
			<liferay-ui:search-container-column-text name="工可批复总投资(亿元)"
				property="feasibilityTotalInvestment" />
			<liferay-ui:search-container-column-text name="标段数"
				value="${biddingCount[proj.projectId]}" />
			<liferay-ui:search-container-column-text name="action">
				<portlet:renderURL var="viewBidding">
					<portlet:param name="projectId" value="${proj.projectId}" />
					<portlet:param name="mvcPath"
						value="${contextPath }/view-bidding.jsp" />
				</portlet:renderURL>
				<aui:button value="维护标段" href="${viewBidding}"></aui:button>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</aui:form>
<aui:script>
	Liferay.Util.toggleSearchContainerButton('#<portlet:namespace />deleteProjectsBtn',
			'#<portlet:namespace /><%=searchContainerReference.getId("searchContainer")%>SearchContainer',
			document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');

	Liferay.provide(window, '<portlet:namespace />deleteProjects', function(projectIds) {
		if (confirm("确定要删除所选数据吗？")) {
			if (!projectIds) {
				projectIds = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm,
						'<portlet:namespace />allRowIds');
			}
			location.href = "<%=deleteProjectsURL%>&<portlet:namespace/>projectIds=" + projectIds;
		}
	}, [ 'liferay-util-list-fields' ]);
</aui:script>

































