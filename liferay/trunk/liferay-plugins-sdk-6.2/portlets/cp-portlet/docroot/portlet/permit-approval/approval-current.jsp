<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>

<c:choose>
	<c:when test="${lxjbInit==qxLxjbInit}">
		<jsp:include page="${contextPath }/approval-current-county.jsp" />
	</c:when>
	<c:otherwise>
		<jsp:include page="${contextPath }/approval-current-city.jsp" />
	</c:otherwise>
</c:choose>