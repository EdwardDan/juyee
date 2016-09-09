<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<%
	Integer sqztInit = (Integer) request.getAttribute("sqztInit");
	boolean issb = sqztInit
			==CityPermitStatus.STATUS_SB.getCode();
	boolean isys = sqztInit==CityPermitStatus.STATUS_YS_PASS
			.getCode();
	boolean issj = sqztInit==CityPermitStatus.STATUS_SJ_PASS
			.getCode();
	boolean iscs = sqztInit==CityPermitStatus.STATUS_CS_PASS
			.getCode();
	boolean isfh = sqztInit==CityPermitStatus.STATUS_FH_PASS
			.getCode();
	boolean issh = sqztInit==CityPermitStatus.STATUS_SH_PASS
			.getCode();
	boolean isfgld = sqztInit==CityPermitStatus.STATUS_FGLD_PASS
			.getCode();
	boolean iszxld = sqztInit==CityPermitStatus.STATUS_ZXLD_PASS
			.getCode();
	boolean isjscxk = sqztInit==CityPermitStatus.STATUS_JSC_XK
			.getCode();
	boolean isjscbxk = sqztInit==CityPermitStatus.STATUS_JSC_BXK
			.getCode();
	boolean isspcxk = sqztInit==CityPermitStatus.STATUS_SPC_XK
			.getCode();
	boolean isspcbxk = sqztInit==CityPermitStatus.STATUS_SPC_BXK
			.getCode();
	boolean iswld = sqztInit==CityPermitStatus.STATUS_WLD_PASS
			.getCode();
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