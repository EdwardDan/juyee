<c:set var="contextPath"
	value="${request.contextPath}/portlet/complete-application" />
<liferay-portlet:renderURL var="editCompleteURL">
	<portlet:param name="mvcPath" value="${contextPath }/edit-complete.jsp" />
</liferay-portlet:renderURL>