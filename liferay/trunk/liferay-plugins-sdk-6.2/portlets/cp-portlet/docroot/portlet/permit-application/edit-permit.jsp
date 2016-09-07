<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<liferay-ui:header title="施工许可申请" />
<%
	int sqbz = 1;
	long permitId = ParamUtil.getInteger(request, "permitId", 0);
	renderRequest.setAttribute("permitId", permitId);
	Permit permit = null;
	if (!Validator.equals(permitId, 0)) {
		permit = PermitLocalServiceUtil.getPermit(permitId);
		sqbz = permit.getSqbz() < 4 ? permit.getSqbz() + 1 : 4;
	}
	int tabSqbz = ParamUtil.getInteger(request, "tabSqbz", sqbz);
	tabSqbz = tabSqbz > sqbz ? sqbz : tabSqbz;
	renderRequest.setAttribute("tabSqbz", tabSqbz);
	renderRequest.setAttribute("sqbz", sqbz);
	String bjbh = ParamUtil.getString(request, "bjbh");
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
		renderRequest.setAttribute("xmmc", projectProfile.getGcmc());
	} else {
		project = ProjectLocalServiceUtil.getProject(bjbh);
		renderRequest.setAttribute("xmmc", project.getXmmc());
	}
%>
<c:if test="${permitId ne 0}">
	<c:set var="editPermitURL"
		value="${editPermitURL }&${renderResponse.namespace}permitId=${permitId}"></c:set>
</c:if>
当前报建编号：${param.bjbh}&nbsp;&nbsp;项目名称：${xmmc}&nbsp;&nbsp;标段号:${bdh}
<ul class="nav nav-tabs">
	<li class="${tabSqbz eq 1?"active":"" }">
		<a href="${editPermitURL }&_${portletDisplay.id }_tabSqbz=1">工程概况</a>
	</li>
	<li class="${tabSqbz eq 2?"active":"" } ${sqbz lt 2?"disabled":"" }">
		<a href="${sqbz lt 2?"javascript:void(0);":editPermitURL.concat("&_").concat(portletDisplay.id).concat("_tabSqbz=2") }">参建单位</a>
	</li>
	<li class="${tabSqbz eq 3?"active":"" } ${sqbz lt 3?"disabled":"" }">
		<a href="${sqbz lt 3?"javascript:void(0);":editPermitURL.concat("&_").concat(portletDisplay.id).concat("_tabSqbz=3") }">单位工程</a>
	</li>
	<li class="${tabSqbz eq 4?"active":"" } ${sqbz lt 4?"disabled":"" }">
		<a href="${sqbz lt 4?"javascript:void(0);":editPermitURL.concat("&_").concat(portletDisplay.id).concat("_tabSqbz=4") }">申请材料</a>
	</li>
</ul>
<c:choose>
	<c:when test="${tabSqbz eq 1}">
		<jsp:include page="${contextPath }/edit-projectprofile.jsp"/>
	</c:when>
	<c:when test="${tabSqbz eq 2}">
		<jsp:include page="${contextPath }/edit-participationunits.jsp"/>
	</c:when>
	<c:when test="${tabSqbz eq 3}">
		<jsp:include page="${contextPath }/edit-unitprojects.jsp"/>
	</c:when>
	<c:when test="${tabSqbz eq 4}">
		<jsp:include page="${contextPath }/edit-applymaterials.jsp"/>
	</c:when>
</c:choose>