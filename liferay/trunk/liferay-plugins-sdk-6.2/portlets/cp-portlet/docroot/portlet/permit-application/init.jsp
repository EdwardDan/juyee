<c:set var="contextPath"
	value="${request.contextPath}/portlet/permit-application" />
<liferay-portlet:renderURL var="editPermitURL">
	<portlet:param name="mvcPath" value="${contextPath }/edit-permit.jsp" />
</liferay-portlet:renderURL>