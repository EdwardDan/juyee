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
	/* request.setAttribute("jgzxysryhgg",PropsUtil.get("jgzxysryhgg"));
	request.setAttribute("jgzxysrysz",PropsUtil.get("jgzxysrysz")); */
	request.setAttribute("slzx",PropsUtil.get("slzx"));
	request.setAttribute("jgzxcsryhgg",PropsUtil.get("jgzxcsryhgg"));
	request.setAttribute("jgzxcsrysz",PropsUtil.get("jgzxcsrysz"));
	request.setAttribute("jgzxfhryhgg",PropsUtil.get("jgzxfhryhgg"));
	request.setAttribute("jgzxfhrysz",PropsUtil.get("jgzxfhrysz"));
	request.setAttribute("jgzxshryhgg",PropsUtil.get("jgzxshryhgg"));
	request.setAttribute("jgzxshrysz",PropsUtil.get("jgzxshrysz"));
	request.setAttribute("jgzxfgld",PropsUtil.get("jgzxfgld"));
	request.setAttribute("jgzxld",PropsUtil.get("jgzxld"));
	request.setAttribute("wjscglcsdl",PropsUtil.get("wjscglcsdl"));
	request.setAttribute("wjscgkhd",PropsUtil.get("wjscgkhd"));
	request.setAttribute("wjscsd",PropsUtil.get("wjscsd"));
	request.setAttribute("wjscgd",PropsUtil.get("wjscgd"));
	request.setAttribute("wjscgj",PropsUtil.get("wjscgj"));
	request.setAttribute("wld",PropsUtil.get("wld"));
%>

<c:choose>
	<%-- <c:when test="${(sqztInit=='2'&&fn:contains(roles,jgzxysryhgg)&&xmlx=='公路')||(sqztInit=='2'&&fn:contains(roles,jgzxysryhgg)&&xmlx=='航道')||(sqztInit=='2'&&fn:contains(roles,jgzxysryhgg)&&xmlx=='港口设施')||(sqztInit=='2'&&fn:contains(roles,jgzxysrysz)&&fn:contains(xmlx,'市政'))}">
		<jsp:include page="${contextPath }/approval-current-city/ys.jsp" />
	</c:when> --%>
	<c:when test="${(sqztInit=='2'&&fn:contains(roles,jgzxcsryhgg)&&xmlx=='公路')||(sqztInit=='2'&&fn:contains(roles,jgzxcsryhgg)&&xmlx=='航道')||(sqztInit=='2'&&fn:contains(roles,jgzxcsryhgg)&&xmlx=='港口设施')||(sqztInit=='2'&&fn:contains(roles,jgzxcsrysz)&&fn:contains(xmlx,'市政'))||(sqztInit=='6'&&fn:contains(roles,jgzxcsryhgg)&&xmlx=='公路')||(sqztInit=='6'&&fn:contains(roles,jgzxcsryhgg)&&xmlx=='航道')||(sqztInit=='6'&&fn:contains(roles,jgzxcsryhgg)&&xmlx=='港口设施')||(sqztInit=='6'&&fn:contains(roles,jgzxcsrysz)&&fn:contains(xmlx,'市政'))}">
		<jsp:include page="${contextPath }/approval-current-city/cs.jsp" />
	</c:when>
	<c:when test="${(sqztInit=='3'&&fn:contains(roles,jgzxfhryhgg)&&xmlx=='公路')||(sqztInit=='3'&&fn:contains(roles,jgzxfhryhgg)&&xmlx=='航道')||(sqztInit=='3'&&fn:contains(roles,jgzxfhryhgg)&&xmlx=='港口设施')||(sqztInit=='3'&&fn:contains(roles,jgzxfhrysz)&&fn:contains(xmlx,'市政'))||(sqztInit=='8'&&fn:contains(roles,jgzxfhryhgg)&&xmlx=='公路')||(sqztInit=='8'&&fn:contains(roles,jgzxfhryhgg)&&xmlx=='航道')||(sqztInit=='8'&&fn:contains(roles,jgzxfhryhgg)&&xmlx=='港口设施')||(sqztInit=='8'&&fn:contains(roles,jgzxfhrysz)&&fn:contains(xmlx,'市政'))}">
		<jsp:include page="${contextPath }/approval-current-city/fh.jsp" />
	</c:when>
	<c:when
		test="${(sqztInit=='5'&&fn:contains(roles,jgzxshryhgg)&&xmlx=='公路')||(sqztInit=='5'&&fn:contains(roles,jgzxshryhgg)&&xmlx=='航道')||(sqztInit=='5'&&fn:contains(roles,jgzxshryhgg)&&xmlx=='港口设施')||(sqztInit=='5'&&fn:contains(roles,jgzxshrysz)&&fn:contains(xmlx,'市政'))||(sqztInit=='10'&&fn:contains(roles,jgzxshryhgg)&&xmlx=='公路')||(sqztInit=='10'&&fn:contains(roles,jgzxshryhgg)&&xmlx=='航道')||(sqztInit=='10'&&fn:contains(roles,jgzxshryhgg)&&xmlx=='港口设施')||(sqztInit=='10'&&fn:contains(roles,jgzxshrysz)&&fn:contains(xmlx,'市政'))}">
		<jsp:include page="${contextPath }/approval-current-city/sh.jsp" />
	</c:when>
	<c:when test="${(sqztInit=='7'&&fn:contains(roles,jgzxfgld))||(sqztInit=='12'&&fn:contains(roles,jgzxfgld)) }">
		<jsp:include page="${contextPath }/approval-current-city/fgldsh.jsp" />
	</c:when>
	<c:when
		test="${(sqztInit=='9'&&fn:contains(roles,jgzxld))|| (sqztInit=='16'&&fn:contains(roles,jgzxld))}">
		<jsp:include page="${contextPath }/approval-current-city/zxldsh.jsp" />
	</c:when>
	<c:when
		test="${(sqztInit=='11'&&fn:contains(roles,slzx))||(sqztInit=='17'&&fn:contains(roles,slzx))}">
		<jsp:include page="${contextPath }/approval-current-city/sj.jsp" />
	</c:when> 
	<c:when
		test="${(sqztInit=='13'&&fn:contains(roles,wjscglcsdl)&&xmlx=='公路')||(sqztInit=='13'&&fn:contains(roles,wjscglcsdl)&&xmlx=='市政基础设施-城市道路')||(sqztInit=='13'&&fn:contains(roles,wjscgkhd)&&xmlx=='港口设施')||(sqztInit=='13'&&fn:contains(roles,wjscgkhd)&&xmlx=='航道')||(sqztInit=='13'&&fn:contains(roles,wjscsd)&&xmlx=='市政基础设施-隧道')||(sqztInit=='13'&&fn:contains(roles,wjscgd)&&xmlx=='市政基础设施-轨道')||(sqztInit=='13'&&fn:contains(roles,wjscgj)&&xmlx=='市政基础设施-公交场站')}">
		<jsp:include page="${contextPath }/approval-current-city/wjscsh.jsp" />
	</c:when>
	<c:when
		test="${(sqztInit=='14'&&fn:contains(roles,wld))|| (sqztInit=='15'&&fn:contains(roles,wld))}">
		<jsp:include page="${contextPath }/approval-current-city/wldsh.jsp" />
	</c:when>
</c:choose>