<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<style>
.sp{
	margin-right: 30px;
}
</style>
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
	String contractId = ParamUtil.getString(request, "contractId");
	Project project = null;
	ProjectProfile projectProfile = null;
	Contract contract = null;
	if (Validator.isNotNull(contractId)) {
		contract = ContractLocalServiceUtil.getContract(contractId);
		renderRequest.setAttribute("contract", contract);
		renderRequest.setAttribute("bdh", contract.getBdh());
	}
	if (permitIdInit != 0) {
		projectProfile = ProjectProfileLocalServiceUtil
				.getProjectProfile(permitIdInit);
		renderRequest.setAttribute("bdh", permitInit.getBdh());
		renderRequest.setAttribute("bjbh",permitInit.getBjbh());
		renderRequest.setAttribute("xmmc", projectProfile.getGcmc());
	} else {
		String bjbh = ParamUtil.getString(request, "bjbh");
		project = ProjectLocalServiceUtil.getProject(bjbh);
		renderRequest.setAttribute("bjbh",bjbh);
		renderRequest.setAttribute("xmmc", project.getXmmc());
	}
%>
<div class="alert alert-info"><span class="sp">当前报建编号：${bjbh}</span><span class="sp">项目名称：${xmmc}</span><span class="sp">标段号:${bdh}</span></div>
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



