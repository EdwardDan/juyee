<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<c:choose>
	<c:when test='${displayPage eq ""}'>
		<liferay-ui:message key="请配置资源展示页"></liferay-ui:message>
	</c:when>
	<c:otherwise>
		<jsp:include page='display/${displayPage}'></jsp:include>
	</c:otherwise>
</c:choose>