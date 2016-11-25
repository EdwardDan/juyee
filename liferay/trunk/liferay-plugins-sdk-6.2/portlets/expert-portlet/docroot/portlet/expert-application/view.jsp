<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<%@ page import="com.justonetech.expert.model.Expert"%>
<%@	page import="com.justonetech.expert.service.ExpertLocalServiceUtil"%>
<portlet:defineObjects />
<%
	int defaultDelta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
	int delta = ParamUtil.getInteger(renderRequest, "delta", defaultDelta);
	int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
	int start = delta * (cur - 1);
	int end = delta * cur;
	List<Expert> experts = ExpertLocalServiceUtil.getExperts(start, end);
	int expertsCount = ExpertLocalServiceUtil.getExperts(-1, -1).size();
	request.setAttribute("experts", experts);
	request.setAttribute("expertsCount", expertsCount);
%>

<portlet:renderURL var="viewURL"></portlet:renderURL>

<style>
.application {
	position: relative;
	left: 93%;
}
</style>
<aui:button href="${addExpertUrl}" value="申请" cssClass="application"></aui:button>


<portlet:renderURL var="searchURL">
	<liferay-portlet:param name="cur" value="${cur }" />
	<liferay-portlet:param name="delta" value="${delta }" />
</portlet:renderURL>

<liferay-ui:search-container emptyResultsMessage="没有专家申请信息。">

	<liferay-ui:search-container-results results="${experts}" total="${expertsCount}">
	</liferay-ui:search-container-results>
	
	<liferay-ui:search-container-row
		className="com.justonetech.expert.model.Expert" keyProperty="expertId"
		modelVar="expert">

		<liferay-ui:search-container-column-text property="xm" name="姓名" />
		
		<liferay-ui:search-container-column-text property="xb" name="性别" />
		
		<liferay-ui:search-container-column-text property="sjhm" name="手机号码" />

		<liferay-ui:search-container-column-text property="gzdw" name="工作单位" />

		<liferay-ui:search-container-column-text name="action">
		
			<portlet:renderURL var="viewExpertURL">
				<portlet:param name="mvcPath" value="${contextPath }/view-expert.jsp"/>
				<portlet:param name="expertId" value="${expert.expertId}" />
			</portlet:renderURL>
			
			<portlet:renderURL var="editExpertURL">
				<portlet:param name="mvcPath" value="${contextPath }/add-expert.jsp"/>
				<portlet:param name="expertId" value="${expert.expertId}" />
			</portlet:renderURL>
			
			<portlet:actionURL var="deleteExpertURL" name="deleteExpert">
				<portlet:param name="expertId" value="${expert.expertId}" />
				<portlet:param name="redirect" value="${viewURL }" />
			</portlet:actionURL>
			
			<liferay-ui:icon-menu>
				<liferay-ui:icon image="view" url="${viewExpertURL}" />
				<liferay-ui:icon image="edit" url="${editExpertURL}" />
				<liferay-ui:icon-delete url="${deleteExpertURL}" />
			</liferay-ui:icon-menu>
			
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator>
	</liferay-ui:search-iterator>
</liferay-ui:search-container>

