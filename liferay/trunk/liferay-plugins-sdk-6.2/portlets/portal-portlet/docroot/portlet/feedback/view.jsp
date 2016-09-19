<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%
	PortletPreferences preferences = renderRequest.getPreferences();
	String displayPage = preferences.getValue("displayPage", StringPool.BLANK);
	renderRequest.setAttribute("displayPage", displayPage);
%>
<c:choose>
	<c:when test='${!themeDisplay.isSignedIn()}'>
		<jsp:include page='login.jsp'></jsp:include>
	</c:when>
	<c:otherwise>
		<c:choose>
			<c:when test='${displayPage eq ""}'>
				<liferay-ui:message key="请配置显示页面"></liferay-ui:message>
			</c:when>
			<c:otherwise>
				<jsp:include page='${displayPage}'></jsp:include>
			</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose>
