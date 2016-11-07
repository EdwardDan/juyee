<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<style>
.sp{
	margin-right: 30px;
}
</style>
<%
	long permitId = ParamUtil.getLong(request, "permitId");
Permit permit = PermitLocalServiceUtil.getPermit(permitId);
	long xmlx = ProjectProfileLocalServiceUtil.getProjectProfile(permitId).getXmlx();
	String curTab = ParamUtil.getString(request, "curTab" , "审核");
	request.setAttribute("curTab", curTab);
	String contractId = ParamUtil.getString(request, "contractId");
	Project project = null;
	ProjectProfile projectProfile = null;
	Contract contract = null;
	if (Validator.isNotNull(contractId)) {
		contract = ContractLocalServiceUtil.getContract(contractId);
		renderRequest.setAttribute("contract", contract);
		renderRequest.setAttribute("bdh", contract.getBdh());
	}
	if (permitId != 0) {
		projectProfile = ProjectProfileLocalServiceUtil
				.getProjectProfile(permitId);
		renderRequest.setAttribute("bdh", permit.getBdh());
		renderRequest.setAttribute("bjbh",permit.getBjbh());
		renderRequest.setAttribute("xmmc", projectProfile.getGcmc());
	} else {
		String bjbh = ParamUtil.getString(request, "bjbh");
		project = ProjectLocalServiceUtil.getProject(bjbh);
		renderRequest.setAttribute("bjbh",bjbh);
		renderRequest.setAttribute("xmmc", project.getXmmc());
	}
%>
<liferay-ui:header title="施工许可申请审核" backURL="${viewURL }" />
<div class="alert alert-info"><span class="sp">当前报建编号：${bjbh}</span><span class="sp">项目名称：${xmmc}</span><span class="sp">标段号:${bdh}</span></div>
<liferay-ui:tabs names="审核,工程概况,参建单位,单位工程,申请材料" refresh="false" value="${curTab}">
	<liferay-ui:section>
		<liferay-ui:panel-container accordion="false" extended="true">
			<liferay-ui:panel title="历史审核步骤" collapsible="true">
				<jsp:include page="${contextPath }/approval-history.jsp" />
			</liferay-ui:panel>
			<liferay-ui:panel title="当前审核步骤" collapsible="false">
				<jsp:include page="${contextPath }/approval-current.jsp" />
			</liferay-ui:panel>
		</liferay-ui:panel-container>
	</liferay-ui:section>
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