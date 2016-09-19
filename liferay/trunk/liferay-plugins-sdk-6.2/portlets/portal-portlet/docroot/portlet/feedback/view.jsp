<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%
	PortletPreferences preferences = renderRequest.getPreferences();
	String displayPage = preferences.getValue("displayPage", StringPool.BLANK);
	renderRequest.setAttribute("displayPage", displayPage);
%>
<!--
根据不同的权限加载不同的页面
1. 如果用户没有登录则加载登录页面
2. 如果用户登录并且角色为user，并且默认页面为add-feedback.jsp，则加载add-feedback.jsp
3. 如果用户登录并且角色为user，并且默认页面为query.jsp，则加载query.jsp，但是query页面中没有回复，并且查询的记录根据当前用户过滤
4. 如果用户登录并且角色为“互动平台回复人员”，并且默认页面为query.jsp，则加载query.jsp，但是页面中有回复操作，同时不需要根据当前用户过滤
于雷可暂时不实现权限的问题开发添加反馈信息和query.jsp页面
-->
<!-- 登录 -->
<%-- <jsp:include page='login.jsp'></jsp:include> --%>
<!-- 添加反馈信息 -->
<%-- <jsp:include page='add-feedback.jsp'></jsp:include>--%>

<!-- 查询反馈信息 -->
<%-- <jsp:include page='query.jsp'></jsp:include> --%>


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
