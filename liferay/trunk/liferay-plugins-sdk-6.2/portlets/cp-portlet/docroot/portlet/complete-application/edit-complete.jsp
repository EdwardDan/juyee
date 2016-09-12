<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<liferay-ui:header title="竣工备案申请" />
<%
	
	int sqbz = 1;
	long completeId = ParamUtil.getLong(request, "completeId", 0);
	renderRequest.setAttribute("completeId", completeId);
	Complete complete = null;
	if (!Validator.equals(completeId, 0)) {
		complete = CompleteLocalServiceUtil.getComplete(completeId);
		sqbz = complete.getSqbz() < 3 ? complete.getSqbz() + 1 : 3;
	}
	int tabSqbz = ParamUtil.getInteger(request, "tabSqbz", sqbz);
	tabSqbz = tabSqbz > sqbz ? sqbz : tabSqbz;
	renderRequest.setAttribute("tabSqbz", tabSqbz);
	renderRequest.setAttribute("sqbz", sqbz);
	Project project = null;
	CompleteProjectProfile projectProfile = null;
	if (completeId != 0) {
		projectProfile = CompleteProjectProfileLocalServiceUtil
				.getCompleteProjectProfile(completeId);
		renderRequest.setAttribute("xmmc", projectProfile.getGcmc());
		renderRequest.setAttribute("bjbh", complete.getBjbh());
	} else {
		String bjbh = ParamUtil.getString(request, "bjbh");
		project = ProjectLocalServiceUtil.getProject(bjbh);
		renderRequest.setAttribute("bjbh", bjbh);
		renderRequest.setAttribute("xmmc", project.getXmmc());
	}
%>
<style>
.sp {
	margin-right: 30px;
}
</style>
<c:if test="${completeId ne 0}">
	<c:set var="editCompleteURL"
		value="${editCompleteURL }&${renderResponse.namespace}completeId=${completeId}"></c:set>
</c:if>
<div class="alert alert-info">
	<span class="sp">当前报建编号：${bjbh}</span><span class="sp">项目名称：${xmmc}</span>
</div>
<ul class="nav nav-tabs">
	<li class="${tabSqbz eq 1?"active":"" }">
		<a href="${editPermitURL }&_${portletDisplay.id }_tabSqbz=1">工程概况</a>
	</li>
	<li class="${tabSqbz eq 2?"active":"" } ${sqbz lt 2?"disabled":"" }">
		<a href="${sqbz lt 2?"javascript:void(0);":editCompleteURL.concat("&_").concat(portletDisplay.id).concat("_tabSqbz=2") }">单位工程列表</a>
	</li>
	<li class="${tabSqbz eq 3?"active":"" } ${sqbz lt 3?"disabled":"" }">
		<a href="${sqbz lt 3?"javascript:void(0);":editCompleteURL.concat("&_").concat(portletDisplay.id).concat("_tabSqbz=3") }">文件或证明材料</a>
	</li>
</ul>
<c:choose>
	<c:when test="${tabSqbz eq 1}">
		<jsp:include page="${contextPath }/edit-projectprofile.jsp" />
	</c:when>
	<c:when test="${tabSqbz eq 2}">
		<jsp:include page="${contextPath }/edit-unitprojects.jsp" />
	</c:when>
	<c:when test="${tabSqbz eq 3}">
		<jsp:include page="${contextPath }/edit-completematerials.jsp" />
	</c:when>
</c:choose>