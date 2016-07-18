<%@ page contentType="text/html;charset=utf-8"%>
<%@include file="/common/init.jsp"%>
<%@include file="/common/init-ext.jsp"%>
<script src="${staticServerURL}/My97DatePicker/WdatePicker.js"></script>
<c:set var="contentPath" value="${request.contextPath}/portlet/project" />
<portlet:renderURL var="add">
	<portlet:param name="mvcPath" value="${contentPath }/edit-project.jsp" />
</portlet:renderURL>
<portlet:renderURL var="query" />
<aui:form action="${query }" name="fm">
	<table align="center" width="100%">
		<tr>
			<td><input type="text" placeholder="请输入关键字..."
				class="input-medium search-query" name="<portlet:namespace/>keyword"
				value="${keyword}" />
				<button type="submit" class="btn">
					<i class="icon-search"></i>查询
				</button></td>
			<td align="right"><a href="<%=add%>" class="btn"><i
					class="icon-plus"></i>添加</a></td>
		</tr>
	</table>
	<liferay-ui:search-container delta="10" emptyResultsMessage="没有找到项目。">
		<liferay-ui:search-container-results results="${projects}"
			total="${totalSize}" />
		<liferay-ui:search-container-row className="Project" modelVar="proj"
			keyProperty="projectId">
			<liferay-ui:search-container-column-text name="项目名称"
				property="projName" />
			<liferay-ui:search-container-column-text name="所属区县"
				property="belongCounty" />
			<liferay-ui:search-container-column-text name="项目状态"
				property="projStatus" />
			<liferay-ui:search-container-column-text name="业态类别"
				property="industryCategory" />
			<liferay-ui:search-container-column-text name="工可批复总投资(亿元)"
				property="gkpfTotle" />
			<liferay-ui:search-container-column-text name="action">
				<portlet:actionURL var="del" name="doDelete">
					<portlet:param name="projectId" value="${proj.projectId}" />
				</portlet:actionURL>
				<portlet:renderURL var="edit">
					<portlet:param name="mvcPath"
						value="/portlet/project/edit_project.jsp" />
					<portlet:param name="projectId" value="${proj.projectId}" />
				</portlet:renderURL>
				<liferay-ui:icon-menu>
					<liferay-ui:icon-delete image="delete" url="${del}" />
					<liferay-ui:icon image="edit" url="${edit}" />
				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator>

		</liferay-ui:search-iterator>
	</liferay-ui:search-container>
</aui:form>



