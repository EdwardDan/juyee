<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<%
	long permitIdInit = ParamUtil.getLong(request, "permitId");
	request.setAttribute("permitId",permitIdInit);
	Permit permitInit = PermitLocalServiceUtil.getPermit(permitIdInit);
	int sqztInit = permitInit.getStatus();
	request.setAttribute("sqztInit", sqztInit);
	String bjbhInit = permitInit.getBjbh();
	//根据报建编号获取报建项目信息
	Project projectInit = ProjectLocalServiceUtil.getProject(bjbhInit);
	String lxjbInit = projectInit.getLxjb();
	String qxLxjbInit = "区县级机关或区县级单位";
%>
<c:choose>
	<c:when test="<%=lxjbInit.equals(qxLxjbInit)%>">
		<jsp:include page="${contextPath }/approval-current-county.jsp" />
	</c:when>
	<c:otherwise>
		<jsp:include page="${contextPath }/approval-current-city.jsp" />
	</c:otherwise>
</c:choose>