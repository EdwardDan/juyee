<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contentPath"
	value="${request.contextPath}/portlet/office-supply-application" />
<portlet:renderURL var="viewURL" />
<aui:nav-bar>
	<aui:nav>
		<portlet:renderURL var="addOfficeSupplyApplicationURL">
			<portlet:param name="mvcPath"
				value="${contentPath }/edit-office-supply-application.jsp" />
		</portlet:renderURL>
		<aui:nav-item href="<%=addOfficeSupplyApplicationURL%>"
			iconCssClass="icon-plus" label="添加" />
	</aui:nav>
</aui:nav-bar>
<liferay-ui:search-container emptyResultsMessage="没有找到办公用品申请。">
	<liferay-ui:search-container-results
		results="${officeSupplyApplications}"
		total="${OfficeSupplyApplicationsCount}">
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="OfficeSupplyApplication"
		modelVar="officeSupplyApplication"
		keyProperty="officeSupplyApplicationId">
		<liferay-ui:search-container-column-text property="deptName"
			name="申请部门" />
		<liferay-ui:search-container-column-text property="userName"
			name="申请人" />
		<%
			Date createDate = officeSupplyApplication.getCreateTime();
					String createTime = DateUtil.getDate(createDate, defaultDateFormatPattern, locale, timeZone);
		%>
		<liferay-ui:search-container-column-text value="<%=createTime%>"
			name="申请时间" />
		<liferay-ui:search-container-column-text name="状态" value="填写" />
		<liferay-ui:search-container-column-text name="action">
			<portlet:actionURL var="editOfficeSupplyApplicationURL"
				name="editOfficeSupplyApplication">
				<portlet:param name="mvcPath"
					value="${contentPath }/edit-office-supply-application.jsp" />
				<portlet:param name="officeSupplyApplicationId"
					value="${officeSupplyApplication.officeSupplyApplicationId}" />
			</portlet:actionURL>
			<portlet:actionURL var="deleteOfficeSupplyApplicationURL"
				name="deleteOfficeSupplyApplication">
				<portlet:param name="officeSupplyApplicationId"
					value="${officeSupplyApplication.officeSupplyApplicationId}" />
				<portlet:param name="redirect" value="${viewURL }" />
			</portlet:actionURL>
			<portlet:actionURL var="viewOfficeSupplyApplicationURL"
				name="viewOfficeSupplyApplication">
				<portlet:param name="mvcPath"
					value="${contentPath }/view-office-supply-application.jsp" />
				<portlet:param name="officeSupplyApplicationId"
					value="${officeSupplyApplication.officeSupplyApplicationId}" />
			</portlet:actionURL>

			<liferay-ui:icon-menu>
				<liferay-ui:icon image="edit"
					url="${editOfficeSupplyApplicationURL}" />
				<liferay-ui:icon-delete image="delete"
					url="${deleteOfficeSupplyApplicationURL}" />
				<liferay-ui:icon image="view"
					url="${viewOfficeSupplyApplicationURL}" />
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

