<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<portlet:renderURL var="viewURL" />
<c:set var="contextPath"
	value="${request.contextPath}/portlet/complete-application" />
<liferay-ui:header title="竣工备案申请查看"  backURL="${viewURL }"/>
<liferay-ui:tabs names="工程概况,单位工程,文件或证明材料" refresh="false">
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-complete/projectprofile.jsp"/>
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-complete/unitprojects.jsp"/>
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-complete/applymaterials.jsp"/>
	</liferay-ui:section>
</liferay-ui:tabs>
<portlet:renderURL var="viewURL" />