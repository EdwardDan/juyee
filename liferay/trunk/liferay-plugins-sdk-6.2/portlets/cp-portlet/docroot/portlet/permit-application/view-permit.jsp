<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<portlet:renderURL var="viewURL" />
<c:set var="contextPath"
	value="${request.contextPath}/portlet/permit-application" />
<liferay-ui:header title="施工许可申请查看"  backURL="${viewURL }"/>
<liferay-ui:tabs names="工程概况,参建单位,单位工程,申请材料" refresh="false">
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
<portlet:renderURL var="viewURL" />
