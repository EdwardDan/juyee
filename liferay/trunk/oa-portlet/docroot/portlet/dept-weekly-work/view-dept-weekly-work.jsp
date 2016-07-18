<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contentPath"
	value="${request.contextPath}/portlet/dept-weekly-work" />
<portlet:renderURL var="viewURL"/>
<liferay-ui:header title="查看一周科室工作" backURL="${viewURL}"/>
<aui:row>
	<aui:col span="6">
		<aui:input name="deptName" label="上报科室" value="${deptWork.deptName}"
			inlineField="true" disabled="true" />
	</aui:col>
	<aui:col span="6">
		<aui:input name="userName" label="申请人" value="${deptWork.userName}"
			disabled="true" />
	</aui:col>
</aui:row>
<aui:field-wrapper name="上报时间" inlineLabel="true">
	<input name='<portlet:namespace/>startDate' readonly="readonly"
		value='<fmt:formatDate value="${deptWork.startDate }" pattern="yyyy-MM-dd"/>' />　~　
				<input name="<portlet:namespace/>endDate" readonly="readonly"
		value='<fmt:formatDate value="${deptWork.endDate }" pattern="yyyy-MM-dd"/>' />
</aui:field-wrapper>
<liferay-ui:search-container>
	<liferay-ui:search-container-results results="${deptWorkItems}">
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="DeptWorkItem"
		modelVar="DeptWorkItem" keyProperty="deptWorkItemId">
		<liferay-ui:search-container-column-text property="sortNo" name="序号" />
		<liferay-ui:search-container-column-text property="dutyPerson"
			name="责任人" />
		<liferay-ui:search-container-column-text 
			name="是否重点工作" value="${DeptWorkItem.mainWork ? '是':'否'}"/> 
		<liferay-ui:search-container-column-text property="content"
			name="工作内容" />
		<liferay-ui:search-container-column-text property="schedule"
			name="工作进度" />
		<liferay-ui:search-container-column-text property="agentPerson"
			name="经办人" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
