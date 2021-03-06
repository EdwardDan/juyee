<%@page import="com.justonetech.expert.service.ExpertLocalServiceUtil"%>
<%@page import="com.justonetech.expert.model.Expert"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<portlet:defineObjects />
<%
	int sqbz = 1;
	long userId = user.getUserId();
	List<Expert> experts = ExpertLocalServiceUtil.getExperts(userId, -1, -1);
	long expertId = 0l;
	if(experts.size()>0){
		expertId = experts.get(0).getExpertId();
		sqbz = experts.get(0).getSqbz()<5 ? experts.get(0).getSqbz()+1 : 5;
	}
	int tabNum = ParamUtil.getInteger(request, "tabNum",1);
	tabNum = tabNum>sqbz?sqbz:tabNum;
	request.setAttribute("expertId", expertId);
	request.setAttribute("sqbz", sqbz);
	request.setAttribute("tabNum", tabNum);
%>
<c:if test="${expertId ne 0}">
	<c:set var="addExpertUrl"
		value="${addExpertUrl}&${renderResponse.namespace}expertId=${expertId}"></c:set>
</c:if>

<%-- <liferay-ui:header title="添加专家申报" backURL="${viewURL }" /> --%>

<ul class="nav nav-tabs">
	<li class="${tabNum eq 1?"active":"" }">
		<a href="${addExpertUrl }&_${portletDisplay.id }_tabNum=1">基本信息</a>
	</li>
	<li class="${tabNum eq 2?"active":"" }${sqbz lt 2?"disabled":"" }">
		<a href="${sqbz lt 2?"javascript:void(0);":addExpertUrl.concat("&_").concat(portletDisplay.id).concat("_tabNum=2") }">学历信息</a>
	</li>
	<li class="${tabNum eq 3?"active":"" }${sqbz lt 3?"disabled":"" }">
		<a href="${sqbz lt 3?"javascript:void(0);":addExpertUrl.concat("&_").concat(portletDisplay.id).concat("_tabNum=3") }">工作简历</a>
	</li>
	<li class="${tabNum eq 4?"active":"" }${sqbz lt 4?"disabled":"" }">
		<a href="${sqbz lt 4?"javascript:void(0);":addExpertUrl.concat("&_").concat(portletDisplay.id).concat("_tabNum=4") }">在其它专家库任职情况</a>
	</li>
	<li class="${tabNum eq 5?"active":"" }${sqbz lt 5?"disabled":"" }">
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
