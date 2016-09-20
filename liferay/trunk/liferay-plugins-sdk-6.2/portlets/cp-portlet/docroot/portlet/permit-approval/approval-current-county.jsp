<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<%
	Integer sqztInit = (Integer) request.getAttribute("sqztInit");
	request.setAttribute("sqztInit", sqztInit);
	long permitIdInit = ParamUtil.getLong(request, "permitId");
	request.setAttribute("permitId",permitIdInit);
	User me = PortalUtil.getUser(request);
	List<Role> userRoles = RoleLocalServiceUtil.getUserRoles(me
			.getUserId());
	ArrayList<String> roles = new ArrayList<String>();
	for (Role role : userRoles) {
		roles.add(role.getRoleId() + "");
	}
	request.setAttribute("roles", roles.toString());
%>
<c:choose>
	<c:when test="${(sqztInit=='2'&&fn:contains(roles,'25982'))||(sqztInit=='8'&&fn:contains(roles,'25982'))||(sqztInit=='9'&&fn:contains(roles,'25982'))}">
		<jsp:include page="${contextPath }/approval-current-county/sj.jsp" />
	</c:when>
	<c:when test="${sqztInit=='3'&&fn:contains(roles,'25983') }">
		<jsp:include page="${contextPath }/approval-current-county/sl.jsp" />
	</c:when>
	<c:when test="${sqztInit=='5'&&fn:contains(roles,'25984') }">
		<jsp:include page="${contextPath }/approval-current-county/sh.jsp" />
	</c:when>
	<c:when test="${sqztInit=='6'&&fn:contains(roles,'25986') }">
		<jsp:include page="${contextPath }/approval-current-county/sp.jsp" />
	</c:when>
</c:choose>