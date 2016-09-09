<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<%
	String sqztInit = (String) request.getAttribute("sqztInit");
	boolean issb = sqztInit.equals(CountyPermitStatus.STATUS_SB
			.getCode());
	boolean issj = sqztInit.equals(CountyPermitStatus.STATUS_SJ_PASS
			.getCode());
	boolean issl = sqztInit.equals(CountyPermitStatus.STATUS_SL_PASS
			.getCode());
	boolean issh = sqztInit.equals(CountyPermitStatus.STATUS_SH_PASS
			.getCode());
	boolean issp = sqztInit.equals(CountyPermitStatus.STATUS_SP_PASS
			.getCode());
%>
<c:choose>
	<c:when test="<%=issb%>">
		<jsp:include page="${contextPath }/approval-current-county/sj.jsp" />
	</c:when>
	<c:when test="<%=issj%>">
		<jsp:include page="${contextPath }/approval-current-county/sl.jsp" />
	</c:when>
	<c:when test="<%=issl%>">
		<jsp:include page="${contextPath }/approval-current-county/sh.jsp" />
	</c:when>
	<c:when test="<%=issh%>">
		<jsp:include page="${contextPath }/approval-current-county/sp.jsp" />
	</c:when>
</c:choose>