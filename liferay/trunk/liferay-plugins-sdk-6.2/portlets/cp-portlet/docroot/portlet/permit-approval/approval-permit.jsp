<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="com.justonetech.cp.permit.service.ProjectProfileLocalServiceUtil"%>
<%@ include file="/common/init.jsp"%>
<%
	long permitId = ParamUtil.getLong(request, "permitId");
	long xmlx = ProjectProfileLocalServiceUtil.getProjectProfile(permitId).getXmlx();
%>
<liferay-ui:tabs names="工程概况,参建单位,单位工程,申请材料" refresh="false">
	<liferay-ui:section>
		工程概况
	</liferay-ui:section>
	<liferay-ui:section>
		参建单位
	</liferay-ui:section>
	<liferay-ui:section>
		单位工程
	</liferay-ui:section>
	<liferay-ui:section>
		申请材料
	</liferay-ui:section>
</liferay-ui:tabs>