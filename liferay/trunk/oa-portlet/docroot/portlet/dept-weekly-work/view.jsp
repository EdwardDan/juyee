<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contentPath"
	value="${request.contextPath}/portlet/dept-weekly-work" />
<portlet:renderURL var="viewURL" />
<aui:nav-bar>
	<aui:nav>
		<portlet:renderURL var="addDeptWeeklyWorkURL">
			<portlet:param name="mvcPath"
				value="${contentPath }/edit-dept-weekly-work.jsp" />
		</portlet:renderURL>
		<aui:nav-item href="<%=addDeptWeeklyWorkURL%>"
			iconCssClass="icon-plus" label="添加" />
	</aui:nav>
</aui:nav-bar>
<liferay-ui:search-container emptyResultsMessage="没有找到科室一周工作。">
	<liferay-ui:search-container-results results="${deptWorks}"
		total="${deptWorkCount}">
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="DeptWork"
		modelVar="deptWork" keyProperty="deptWorkId">
		<liferay-ui:search-container-column-text property="deptName"
			name="上报科室" />
		<liferay-ui:search-container-column-text property="userName"
			name="提交人" />
		<liferay-ui:search-container-column-text name="工作时间">
			<%=DateUtil.getDate(deptWork.getStartDate(), "yyyy-MM-dd", locale, timeZone)%>~
				<%=DateUtil.getDate(deptWork.getEndDate(), "yyyy-MM-dd", locale, timeZone)%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text property="status" name="状态" />
		<liferay-ui:search-container-column-text>
			<portlet:actionURL var="editDeptWeeklyWorkURL"
				name="editDeptWeeklyWork">
					<portlet:param name="deptWorkId" value="${deptWork.deptWorkId}" />
					<portlet:param name="mvcPath" value="${contentPath}/edit-dept-weekly-work.jsp"/>
			</portlet:actionURL>
			<portlet:actionURL var="deleteDeptWeeklyWorkURL"
				name="deleteDeptWeeklyWork">
				<portlet:param name="deptWorkId" value="${deptWork.deptWorkId}" />
			</portlet:actionURL>
			<portlet:actionURL var="viewDeptWeeklyWorkURL"
				name="viewDeptWeeklyWork">
				<portlet:param name="deptWorkId" value="${deptWork.deptWorkId}" />
			</portlet:actionURL>
			<liferay-ui:icon-menu>
				<liferay-ui:icon image="edit" url="${editDeptWeeklyWorkURL}" />
				<liferay-ui:icon-delete image="delete"
					url="${deleteDeptWeeklyWorkURL}" />
				<liferay-ui:icon image="view" url="${viewDeptWeeklyWorkURL}" />
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
</liferay-ui:search-container>































