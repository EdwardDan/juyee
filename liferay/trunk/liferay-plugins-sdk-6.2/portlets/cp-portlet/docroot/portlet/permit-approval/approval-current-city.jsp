<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<%
	String sqztInit = (String) request.getAttribute("sqztInit");
	boolean issb = sqztInit
			.equals(CityPermitStatus.STATUS_SB.getCode());
	boolean isys = sqztInit.equals(CityPermitStatus.STATUS_YS_PASS
			.getCode());
	boolean issj = sqztInit.equals(CityPermitStatus.STATUS_SJ_PASS
			.getCode());
	boolean iscs = sqztInit.equals(CityPermitStatus.STATUS_CS_PASS
			.getCode());
	boolean isfh = sqztInit.equals(CityPermitStatus.STATUS_FH_PASS
			.getCode());
	boolean issh = sqztInit.equals(CityPermitStatus.STATUS_SH_PASS
			.getCode());
	boolean isfgld = sqztInit.equals(CityPermitStatus.STATUS_FGLD_PASS
			.getCode());
	boolean iszxld = sqztInit.equals(CityPermitStatus.STATUS_ZXLD_PASS
			.getCode());
	boolean isjscxk = sqztInit.equals(CityPermitStatus.STATUS_JSC_XK
			.getCode());
	boolean isjscbxk = sqztInit.equals(CityPermitStatus.STATUS_JSC_BXK
			.getCode());
	boolean isspcxk = sqztInit.equals(CityPermitStatus.STATUS_SPC_XK
			.getCode());
	boolean isspcbxk = sqztInit.equals(CityPermitStatus.STATUS_SPC_BXK
			.getCode());
	boolean iswld = sqztInit.equals(CityPermitStatus.STATUS_WLD_PASS
			.getCode());
%>

<c:choose>
	<c:when test="<%=issb%>">
		<jsp:include page="${contextPath }/approval-current-city/ys.jsp" />
	</c:when>
	<c:when test="<%=isys%>">
		<jsp:include page="${contextPath }/approval-current-city/sj.jsp" />
	</c:when>
	<c:when test="<%=issj%>">
		<jsp:include page="${contextPath }/approval-current-city/cs.jsp" />
	</c:when>
	<c:when test="<%=iscs%>">
		<jsp:include page="${contextPath }/approval-current-city/fh.jsp" />
	</c:when>
	<c:when test="<%=isfh%>">
		<jsp:include page="${contextPath }/approval-current-city/sh.jsp" />
	</c:when>
	<c:when test="<%=issh%>">
		<jsp:include page="${contextPath }/approval-current-city/fgldsh.jsp" />
	</c:when>
	<c:when test="<%=isfgld%>">
		<jsp:include page="${contextPath }/approval-current-city/zxldsh.jsp" />
	</c:when>
	<c:when test="<%=iszxld%>">
		<jsp:include page="${contextPath }/approval-current-city/wjscsh.jsp" />
	</c:when>
	<c:when test="<%=isjscxk || isjscbxk%>">
		<jsp:include page="${contextPath }/approval-current-city/wspcsh.jsp" />
	</c:when>
	<c:when test="<%=isspcxk || isspcbxk%>">
		<jsp:include page="${contextPath }/approval-current-city/wldsh.jsp" />
	</c:when>
</c:choose>