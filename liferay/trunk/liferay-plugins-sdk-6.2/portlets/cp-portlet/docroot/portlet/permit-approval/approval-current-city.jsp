<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<%
	long permitIdInit = ParamUtil.getLong(request, "permitId");
	request.setAttribute("permitId", permitIdInit);
	 ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitIdInit);
	 Dictionary dictionary = DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmlx());
	 request.setAttribute("xmlx",dictionary.getName());
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
	<c:when test="${(sqztInit=='2'&&fn:contains(roles,'42444')&&xmlx=='公路')||(sqztInit=='2'&&fn:contains(roles,'42444')&&xmlx=='航道')||(sqztInit=='2'&&fn:contains(roles,'42444')&&xmlx=='港口设施')||(sqztInit=='2'&&fn:contains(roles,'42445')&&fn:contains(xmlx,'市政'))}">
		<jsp:include page="${contextPath }/approval-current-city/ys.jsp" />
	</c:when>
	<c:when
		test="${(sqztInit=='3'&&fn:contains(roles,'25423'))||(sqztInit=='10'&&fn:contains(roles,'25423'))||(sqztInit=='23'&&fn:contains(roles,'25423')) }">
		<jsp:include page="${contextPath }/approval-current-city/sj.jsp" />
	</c:when>
	<c:when test="${(sqztInit=='5'&&fn:contains(roles,'42454')&&xmlx=='公路')||(sqztInit=='5'&&fn:contains(roles,'42454')&&xmlx=='航道')||(sqztInit=='5'&&fn:contains(roles,'42454')&&xmlx=='港口设施')||(sqztInit=='5'&&fn:contains(roles,'42455')&&fn:contains(xmlx,'市政'))||(sqztInit=='24'&&fn:contains(roles,'42454')&&xmlx=='公路')||(sqztInit=='24'&&fn:contains(roles,'42454')&&xmlx=='航道')||(sqztInit=='24'&&fn:contains(roles,'42454')&&xmlx=='港口设施')||(sqztInit=='24'&&fn:contains(roles,'42455')&&fn:contains(xmlx,'市政'))}">
		<jsp:include page="${contextPath }/approval-current-city/cs.jsp" />
	</c:when>
	<c:when test="${(sqztInit=='7'&&fn:contains(roles,'42456')&&xmlx=='公路')||(sqztInit=='7'&&fn:contains(roles,'42456')&&xmlx=='航道')||(sqztInit=='7'&&fn:contains(roles,'42456')&&xmlx=='港口设施')||(sqztInit=='7'&&fn:contains(roles,'42457')&&fn:contains(xmlx,'市政'))}">
		<jsp:include page="${contextPath }/approval-current-city/fh.jsp" />
	</c:when>
	<c:when
		test="${(sqztInit=='8'&&fn:contains(roles,'42458')&&xmlx=='公路')||(sqztInit=='8'&&fn:contains(roles,'42458')&&xmlx=='航道')||(sqztInit=='8'&&fn:contains(roles,'42458')&&xmlx=='港口设施')||(sqztInit=='8'&&fn:contains(roles,'42459')&&fn:contains(xmlx,'市政'))||(sqztInit=='12'&&fn:contains(roles,'42458')&&xmlx=='公路')||(sqztInit=='12'&&fn:contains(roles,'42458')&&xmlx=='航道')||(sqztInit=='12'&&fn:contains(roles,'42458')&&xmlx=='港口设施')||(sqztInit=='12'&&fn:contains(roles,'42459')&&fn:contains(xmlx,'市政'))||(sqztInit=='14'&&fn:contains(roles,'42458')&&xmlx=='公路')||(sqztInit=='14'&&fn:contains(roles,'42458')&&xmlx=='航道')||(sqztInit=='14'&&fn:contains(roles,'42458')&&xmlx=='港口设施')||(sqztInit=='14'&&fn:contains(roles,'42459')&&fn:contains(xmlx,'市政'))}">
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
		test="${(sqztInit=='13'&&fn:contains(roles,'42460')&&xmlx=='公路')||(sqztInit=='13'&&fn:contains(roles,'42460')&&xmlx=='市政基础设施-城市道路')||(sqztInit=='13'&&fn:contains(roles,'42461')&&xmlx=='港口设施')||(sqztInit=='13'&&fn:contains(roles,'42461')&&xmlx=='航道')||(sqztInit=='13'&&fn:contains(roles,'42462')&&xmlx=='市政基础设施-隧道')||(sqztInit=='13'&&fn:contains(roles,'42463')&&xmlx=='市政基础设施-轨道')||(sqztInit=='13'&&fn:contains(roles,'42464')&&xmlx=='市政基础设施-公交场站')||(sqztInit=='20'&&fn:contains(roles,'42460')&&xmlx=='公路')||(sqztInit=='20'&&fn:contains(roles,'42460')&&xmlx=='市政基础设施-城市道路')||(sqztInit=='20'&&fn:contains(roles,'42461')&&xmlx=='港口设施')||(sqztInit=='20'&&fn:contains(roles,'42461')&&xmlx=='航道')||(sqztInit=='20'&&fn:contains(roles,'42462')&&xmlx=='市政基础设施-隧道')||(sqztInit=='20'&&fn:contains(roles,'42463')&&xmlx=='市政基础设施-轨道')||(sqztInit=='20'&&fn:contains(roles,'42464')&&xmlx=='市政基础设施-公交场站')}">
		<jsp:include page="${contextPath }/approval-current-city/wjscsh.jsp" />
	</c:when>
	<c:when
		test="${(sqztInit=='15'&&fn:contains(roles,'25431'))|| (sqztInit=='16'&&fn:contains(roles,'25431'))}">
		<jsp:include page="${contextPath }/approval-current-city/wldsh.jsp" />
	</c:when>
</c:choose>