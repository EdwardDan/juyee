<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<portlet:defineObjects />

<ul class="nav nav-tabs">
	<li class="${tabNum eq 1?"active":"" }">
		<a href="${addExpertUrl }&_${portletDisplay.id }_tabNum=1">基本信息</a>
	</li>
	<li class="${tabNum eq 2?"active":"" }">
		<a href="${sqbz lt 2?"javascript:void(0);":addExpertUrl.concat("&_").concat(portletDisplay.id).concat("_tabNum=2") }">学历信息</a>
	</li>
	<li class="${tabNum eq 3?"active":"" }">
		<a href="${sqbz lt 3?"javascript:void(0);":addExpertUrl.concat("&_").concat(portletDisplay.id).concat("_tabNum=3") }">工作简历</a>
	</li>
	<li class="${tabNum eq 4?"active":"" }">
		<a href="${sqbz lt 4?"javascript:void(0);":addExpertUrl.concat("&_").concat(portletDisplay.id).concat("_tabNum=4") }">在其它专家库任职情况</a>
	</li>
	<li class="${tabNum eq 5?"active":"" }">
		<a href="${sqbz lt 5?"javascript:void(0);":addExpertUrl.concat("&_").concat(portletDisplay.id).concat("_tabNum=5") }">专业申请</a>
	</li>
</ul>
<c:choose>
	<c:when test="${tabNum eq 1}">
		<jsp:include page="${contextPath }/add-expert.jsp"/>
	</c:when>
	<c:when test="${tabNum eq 2}">
		<jsp:include page="${contextPath }/add-xlxx.jsp"/>
	</c:when>
	<c:when test="${tabNum eq 3}">
		<jsp:include page="${contextPath }/add-gzjl.jsp"/>
	</c:when>
	<c:when test="${tabNum eq 4}">
		<jsp:include page="${contextPath }/add-zqtzjkrzxx.jsp"/>
	</c:when>
	<c:when test="${tabNum eq 5}">
		<jsp:include page="${contextPath }/add-zysq.jsp"/>
	</c:when>
</c:choose>
