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
	request.setAttribute("qxslzx",PropsUtil.get("qxslzx"));
	request.setAttribute("qxslry",PropsUtil.get("qxslry"));
	request.setAttribute("qxshry",PropsUtil.get("qxshry"));
	request.setAttribute("qxspry",PropsUtil.get("qxspry"));
%>
<c:choose>
	<c:when test="${(sqztInit=='2'&&fn:contains(roles,qxslzx))||(sqztInit=='8'&&fn:contains(roles,qxslzx))||(sqztInit=='9'&&fn:contains(roles,qxslzx))}">
		受理中心收件<jsp:include page="${contextPath }/approval-current-county/sj.jsp" />
	</c:when>
	<c:when test="${sqztInit=='3'&&fn:contains(roles,qxslry) }">
		区县受理<jsp:include page="${contextPath }/approval-current-county/sl.jsp" />
	</c:when>
	<c:when test="${sqztInit=='5'&&fn:contains(roles,qxshry) }">
		区县审核<jsp:include page="${contextPath }/approval-current-county/sh.jsp" />
	</c:when>
	<c:when test="${sqztInit=='6'&&fn:contains(roles,qxspry) }">
		区县审批<jsp:include page="${contextPath }/approval-current-county/sp.jsp" />
	</c:when>
</c:choose>