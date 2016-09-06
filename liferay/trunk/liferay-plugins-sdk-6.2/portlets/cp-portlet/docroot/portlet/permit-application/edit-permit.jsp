<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contextPath"
	value="${request.contextPath}/portlet/permit-application" />
<liferay-ui:header title="施工许可申请" />
<%
	String stepTabsNames = "工程概况,参建单位,单位工程,申请材料";
	String stepTabsValues = "gcgk,cjdw,dwgc,sqcl";
	Long permitId = ParamUtil.getLong(request,"permitId");
	String bjbh = ParamUtil.getString(request,"bjbh");
	String contractId = ParamUtil.getString(request,"contractId");
	Project project = null;
	ProjectProfile projectProfile = null;
	Contract contract = null;
		if (permitId != 0) {
			projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
			renderRequest.setAttribute("xmmc", projectProfile.getGcmc());
		} else {
			project = ProjectLocalServiceUtil.getProject(bjbh);
			renderRequest.setAttribute("xmmc", project.getXmmc());
		}
		if (Validator.isNotNull(contractId)) {
			contract = ContractLocalServiceUtil.getContract(contractId);
			renderRequest.setAttribute("contract", contract);
		}
%>
<%-- 当前步骤：${sqbz}

许可申请ID：${permitId} --%>
当前报建编号：${bjbh}
<br/>
项目名称：${xmmc}
<br/>
标段号：${bdh }
<portlet:renderURL var="editPermitURL">
	<portlet:param name="mvcPath" value="${contextPath }/edit-permit.jsp" />
	<portlet:param name="bjbh" value="${bjbh }"/>
	<portlet:param name="permitId" value="${permitId }"/>
	<portlet:param name="bdh" value="${bdh }"/>
</portlet:renderURL>
<ul class="nav nav-tabs">
	<li class="${sqbz eq 1?"active":"" }">
		<a href="${editPermitURL }&_${portletDisplay.id }_sqbz=1">工程概况</a>
	</li>
	<li class="${sqbz eq 2?"active":"" } ${sqbz lt 2?"disabled":"" }">
		<a href="${sqbz lt 2?"javascript:void(0);":editPermitURL.concat("_").concat(portletDisplay.id).concat("_sqbz=2") }">参建单位</a>
	</li>
	<li class="${sqbz eq 3?"active":"" } ${sqbz lt 3?"disabled":"" }">
		<a href="${sqbz lt 3?"javascript:void(0);":editPermitURL.concat("_").concat(portletDisplay.id).concat("_sqbz=3") }">单位工程</a>
	</li>
	<li class="${sqbz eq 4?"active":"" } ${sqbz lt 4?"disabled":"" }">
		<a href="${sqbz lt 4?"javascript:void(0);":editPermitURL.concat("_").concat(portletDisplay.id).concat("_sqbz=4") }">申请材料</a>
	</li>
</ul>
<c:choose>
	<c:when test="${sqbz eq 1}">
		<jsp:include page="${contextPath }/edit-projectprofile.jsp"/>
	</c:when>
	<c:when test="${sqbz eq 2}">
		<jsp:include page="${contextPath }/edit-participationunits.jsp"/>
	</c:when>
	<c:when test="${sqbz eq 3}">
		<jsp:include page="${contextPath }/edit-unitprojects.jsp"/>
	</c:when>
	<c:when test="${sqbz eq 4}">
		<jsp:include page="${contextPath }/edit-applymaterial.jsp"/>
	</c:when>
</c:choose>