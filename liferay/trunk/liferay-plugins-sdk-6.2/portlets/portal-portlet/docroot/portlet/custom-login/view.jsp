<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>

<c:choose>
	<c:when test='${loginPage eq "" or loggedInPage eq "" }'>
		<liferay-ui:message key="请配置登录前及登录后页面"></liferay-ui:message>
	</c:when>
	<c:otherwise>
		<c:choose>
			<c:when test='${!themeDisplay.isSignedIn()}'>
				<jsp:include page='display/${loginPage}'></jsp:include>
			</c:when>
			<c:otherwise>
				<jsp:include page='display/${loggedInPage}'></jsp:include>
			</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose>
