<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<%
	long permitIdInit = ParamUtil.getLong(request, "permitId");
	if (permitIdInit != 0) {
		Permit permitInit = PermitLocalServiceUtil
				.getPermit(permitIdInit);
		String sqztInit = permitInit.getSqzt();
		String bjbhInit = permitInit.getBjbh();
		//根据报建编号获取报建项目信息
		/* Project projectInit = ProjectLocalServiceUtil
				.getProject(bjbhInit); */
		/* String lxjbInit = projectInit.getLxjb();
		String qxLxjbInit = "区县级机关或区县级单位"; */
	}
%>
<c:choose>
	<c:when test="${lxjbInit==qxLxjbInit}">
		<jsp:include page="${contextPath }/approval-history-county.jsp" />
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>
		<jsp:include page="${contextPath }/approval-history-city.jsp" />
