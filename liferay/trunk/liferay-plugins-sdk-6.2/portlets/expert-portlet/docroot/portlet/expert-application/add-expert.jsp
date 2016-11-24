<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<portlet:defineObjects />

<c:set var="contextPath"
	value="${request.contextPath}/portlet/expert-application" />
<ul class="nav nav-tabs">
	<li class="${tabSqbz eq 1?"active":"" }">
		<a href="${editPermitURL }&_${portletDisplay.id }_tabSqbz=1">基本信息</a>
	</li>
	<li class="${tabSqbz eq 2?"active":"" } ${sqbz lt 2?"disabled":"" }">
		<a href="${sqbz lt 2?"javascript:void(0);":editPermitURL.concat("&_").concat(portletDisplay.id).concat("_tabSqbz=2") }">学历信息</a>
	</li>
	<li class="${tabSqbz eq 3?"active":"" } ${sqbz lt 3?"disabled":"" }">
		<a href="${sqbz lt 3?"javascript:void(0);":editPermitURL.concat("&_").concat(portletDisplay.id).concat("_tabSqbz=3") }">工作简历</a>
	</li>
	<li class="${tabSqbz eq 4?"active":"" } ${sqbz lt 4?"disabled":"" }">
		<a href="${sqbz lt 4?"javascript:void(0);":editPermitURL.concat("&_").concat(portletDisplay.id).concat("_tabSqbz=4") }">在其它专家库任职情况</a>
	</li>
	<li class="${tabSqbz eq 5?"active":"" } ${sqbz lt 5?"disabled":"" }">
		<a href="${sqbz lt 5?"javascript:void(0);":editPermitURL.concat("&_").concat(portletDisplay.id).concat("_tabSqbz=5") }">专业申请</a>
	</li>
</ul>
<c:choose>
	<c:when test="${tabSqbz eq 1}">
		<jsp:include page="${contextPath }/add-jbxx.jsp"/>
	</c:when>
	<c:when test="${tabSqbz eq 2}">
		<jsp:include page="${contextPath }/add-xlxx.jsp"/>
	</c:when>
	<c:when test="${tabSqbz eq 3}">
		<jsp:include page="${contextPath }/add-gzjl.jsp"/>
	</c:when>
	<c:when test="${tabSqbz eq 4}">
		<jsp:include page="${contextPath }/add-zqtzjkrzxx.jsp"/>
	</c:when>
	<c:when test="${tabSqbz eq 5}">
		<jsp:include page="${contextPath }/add-zysq.jsp"/>
	</c:when>
</c:choose>
