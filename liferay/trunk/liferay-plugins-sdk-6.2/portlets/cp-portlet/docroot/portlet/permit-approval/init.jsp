<c:set var="contextPath"
	value="${request.contextPath}/portlet/permit-approval" />
<portlet:renderURL var="viewURL" />
<liferay-portlet:renderURL var="approvalCurrentURL">
	<portlet:param name="mvcPath" value="${contextPath }/approval-permit.jsp" />
	</liferay-portlet:renderURL>