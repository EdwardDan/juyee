<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<%
	long permitId = ParamUtil.getLong(request, "permitId");
	long xmlx = ProjectProfileLocalServiceUtil.getProjectProfile(permitId).getXmlx();
%>
<liferay-ui:header title="施工许可申请审核"  backURL="${viewURL }"/>
<liferay-ui:tabs names="审核,工程概况,参建单位,单位工程,申请材料" refresh="false">
	<liferay-ui:section>
		<liferay-ui:panel-container accordion="false" extended="true">
			<liferay-ui:panel title="历史审核步骤" collapsible="true">
				<jsp:include page="${contextPath }/approval-history.jsp"/>
			</liferay-ui:panel>
			<liferay-ui:panel title="当前审核步骤" collapsible="false">
				<jsp:include page="${contextPath }/approval-current.jsp"/>
			</liferay-ui:panel>
	</liferay-ui:panel-container>
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-permit/projectprofile.jsp"/>
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-permit/participationunits.jsp"/>
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-permit/unitprojects.jsp"/>
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-permit/applymaterials.jsp"/>
	</liferay-ui:section>
</liferay-ui:tabs>