<%@page import="com.justonetech.expert.service.ExpertLocalServiceUtil"%>
<%@page import="com.justonetech.expert.model.Expert"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<portlet:defineObjects />
<%
	int sqbz = 1;
	long expertId = ParamUtil.getLong(request, "expertId",0);
	Expert expert = null;
	if(Validator.isNotNull(expertId)){
		expert = ExpertLocalServiceUtil.getExpert(expertId);
		sqbz = expert.getSqbz()<5 ? expert.getSqbz()+1 : 5;
		System.out.println("sqbz:"+sqbz);
	}
	int tabNum = ParamUtil.getInteger(request, "tabNum",sqbz);
	tabNum = tabNum>sqbz?sqbz:tabNum;
	System.out.println("tabNum:"+tabNum);
	request.setAttribute("expertId", expertId);
	request.setAttribute("sqbz", sqbz);
	request.setAttribute("tabNum", tabNum);
%>
<c:if test="${expertId ne 0}">
	<c:set var="addExpertUrl"
		value="${addExpertUrl}&${renderResponse.namespace}expertId=${expertId}"></c:set>
</c:if>

<liferay-ui:header title="添加专家申报" backURL="${viewURL }" />

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
		<jsp:include page="${contextPath }/add-jbxx.jsp"/>
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
