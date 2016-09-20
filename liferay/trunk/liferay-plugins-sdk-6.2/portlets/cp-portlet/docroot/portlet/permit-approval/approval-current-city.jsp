<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<%
	long permitIdInit = ParamUtil.getLong(request, "permitId");
	request.setAttribute("permitId", permitIdInit);
	Integer sqztInit = (Integer) request.getAttribute("sqztInit");
	request.setAttribute("sqztInit", sqztInit);
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
	<c:when test="${sqztInit=='2'&&fn:contains(roles,'25422') }">
		<jsp:include page="${contextPath }/approval-current-city/ys.jsp" />
	</c:when>
	<c:when
		test="${(sqztInit=='3'&&fn:contains(roles,'25423'))||(sqztInit=='10'&&fn:contains(roles,'25423'))||(sqztInit=='23'&&fn:contains(roles,'25423')) }">
		<jsp:include page="${contextPath }/approval-current-city/sj.jsp" />
	</c:when>
	<c:when test="${(sqztInit=='5'&&fn:contains(roles,'25424'))||(sqztInit=='24'&&fn:contains(roles,'25424')) }">
		<jsp:include page="${contextPath }/approval-current-city/cs.jsp" />
	</c:when>
	<c:when test="${sqztInit=='7'&&fn:contains(roles,'25425') }">
		<jsp:include page="${contextPath }/approval-current-city/fh.jsp" />
	</c:when>
	<c:when
		test="${(sqztInit=='8'&&fn:contains(roles,'25426'))||(sqztInit=='12'&&fn:contains(roles,'25426'))||(sqztInit=='14'&&fn:contains(roles,'25426'))}">
		<jsp:include page="${contextPath }/approval-current-city/sh.jsp" />
	</c:when>
	<c:when test="${sqztInit=='9'&&fn:contains(roles,'25427') }">
		<jsp:include page="${contextPath }/approval-current-city/fgldsh.jsp" />
	</c:when>
	<c:when
		test="${(sqztInit=='11'&&fn:contains(roles,'25428'))|| (sqztInit=='17'&&fn:contains(roles,'25428'))}">
		<jsp:include page="${contextPath }/approval-current-city/zxldsh.jsp" />
	</c:when>
	<c:when
		test="${(sqztInit=='13'&&fn:contains(roles,'25429'))||(sqztInit=='20'&&fn:contains(roles,'25429')) }">
		<jsp:include page="${contextPath }/approval-current-city/wjscsh.jsp" />
	</c:when>
	<c:when
		test="${(sqztInit=='15'&&fn:contains(roles,'25430'))||(sqztInit=='16'&&fn:contains(roles,'25430')) }">
		<jsp:include page="${contextPath }/approval-current-city/wspcsh.jsp" />
	</c:when>
	<c:when
		test="${(sqztInit=='18'&&fn:contains(roles,'25431'))|| (sqztInit=='19'&&fn:contains(roles,'25431'))}">
		<jsp:include page="${contextPath }/approval-current-city/wldsh.jsp" />
	</c:when>
</c:choose>