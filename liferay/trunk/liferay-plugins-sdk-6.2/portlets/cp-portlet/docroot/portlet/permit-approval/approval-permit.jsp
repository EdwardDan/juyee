<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<%
	long permitId = ParamUtil.getLong(request, "permitId");
	long xmlx = ProjectProfileLocalServiceUtil.getProjectProfile(permitId).getXmlx();
%>
<liferay-ui:tabs names="审核,工程概况,参建单位,单位工程,申请材料" refresh="false">
	<liferay-ui:section>
		审核
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-projectprofile.jsp"/>
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-participationunits.jsp"/>
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-unitprojects.jsp"/>
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-applymaterials.jsp"/>
	</liferay-ui:section>
</liferay-ui:tabs>