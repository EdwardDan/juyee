<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<portlet:renderURL var="viewURL" />
<c:set var="contextPath"
	value="${request.contextPath}/portlet/permit-application" />
<liferay-ui:header title="施工许可申请查看" backURL="${viewURL }" />
<%
	long permitIdInit = ParamUtil.getLong(request, "permitId");
	Permit permitInit = PermitLocalServiceUtil.getPermit(permitIdInit);
	Project projectInit = ProjectLocalServiceUtil.getProject(permitInit
			.getBjbh());
	int status = PermitLocalServiceUtil.getPermit(permitIdInit).getStatus();
	String tabNames = "工程概况,参建单位,单位工程,申请材料";
	Boolean canView=false;
	if (projectInit.getLxjb().equals("区县级机关或区县级单位")) {
		if (permitInit.getStatus() == 4) {
			tabNames = "审核意见,工程概况,参建单位,单位工程,申请材料";
			canView=true;
		}
	} else {
		if (permitInit.getStatus() == 4 || permitInit.getStatus() == 17) {
			tabNames = "审核意见,工程概况,参建单位,单位工程,申请材料";
			canView=true;
		}
	}
%>
<liferay-ui:tabs names="<%=tabNames%>" refresh="false">
<c:if test="<%=canView %>">
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-permit/approval.jsp" />
	</liferay-ui:section>
	</c:if>
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-permit/projectprofile.jsp" />
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-permit/participationunits.jsp" />
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-permit/unitprojects.jsp" />
	</liferay-ui:section>
	<liferay-ui:section>
		<jsp:include page="${contextPath }/view-permit/applymaterials.jsp" />
	</liferay-ui:section>
</liferay-ui:tabs>
<portlet:resourceURL var="viewCertificateURL" id="view">
	<portlet:param name="permitId" value="${permitInit}"/>
</portlet:resourceURL>
<c:if test="<%=status!=CityPermitStatus.STATUS_SJ_BACK.getCode()||status!=CityPermitStatus.STATUS_CS_BACK.getCode()||status!=CountyPermitStatus.STATUS_SJ_BACK.getCode()%>" >
<aui:button-row cssClass="text-center">
	<a class="btn" onclick="viewCertificate()">预览施工许可证书</a>
</aui:button-row>
</c:if>
<script type="text/javascript">
	function viewCertificate(){
		window.location = '${viewCertificateURL}';
	}
</script>


