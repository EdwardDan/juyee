<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<%@ page import="com.justonetech.expert.service.ZysqlbLocalServiceUtil"%>
<%@ page import="com.justonetech.expert.model.Zysqlb"%>
<%@page import="com.justonetech.sys.service.DictionaryLocalServiceUtil"%>
<%@page import="com.justonetech.expert.util.*"%>
<style type="text/css">
tr.body td.content {
	background-color: white;
}

.divAccordion-inner {
	padding: 9px 15px;
}
</style>
<%
	long expertId = ParamUtil.getLong(request, "expertId");
	List<Zysqlb> zysqlbs = ZysqlbLocalServiceUtil.getZysqlbs(expertId, -1, -1);
	int zysqlbsCount = zysqlbs.size();
	int sortNo = 0;
	request.setAttribute("expertId", expertId);
	request.setAttribute("zysqlbs", zysqlbs);
	request.setAttribute("zysqlbsCount", zysqlbsCount);
%>
<portlet:renderURL var="addZysqURL">
	<portlet:param name="mvcPath" value="${contextPath }/add-zysqnr.jsp" />
	<portlet:param name="expertId" value="${expertId}" />
</portlet:renderURL>
<tr style="height: 40px;">
	<td colspan="4" align="center" class="bg-white"><aui:button
			type="button" value="添加" href="${addZysqURL}"></aui:button></td>
</tr>
<liferay-ui:search-container emptyResultsMessage="没有数据。">
	<liferay-ui:search-container-results results="${zysqlbs}"
		total="${zysqlbsCount}">
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row
		className="com.justonetech.expert.model.Zysqlb" keyProperty="zysqlbId"
		modelVar="zysqlb">
		<portlet:renderURL var="viewZysqlbURL">
			<portlet:param name="mvcPath" value="${contextPath}/view-zysqnr.jsp" />
			<portlet:param name="zysqlbId" value="${zysqlb.zysqlbId}" />
			<portlet:param name="expertId" value="${expertId}" />
		</portlet:renderURL>
		<liferay-ui:search-container-column-text name="序号"
			value="<%=String.valueOf(++sortNo)%>" />
		<liferay-ui:search-container-column-text name="一级（事项）"
			value="<%=DictionaryLocalServiceUtil.getDictionary(
							Long.parseLong(zysqlb.getSx())).getName()%>" />
		<liferay-ui:search-container-column-text name="二级（专业）"
			value="${zysqlb.zy}" />
		<liferay-ui:search-container-column-text name="状态"
			value="<%=ExpertApprovalStatus.getColorNameByCode(zysqlb.getZt()) %>" />
		<liferay-ui:search-container-column-text name="操作">
			<portlet:actionURL var="deleteZysqlbURL" name="deleteZysqlb">
				<portlet:param name="zysqlbId" value="${zysqlb.zysqlbId}" />
				<portlet:param name="redirect" value="${addExpertUrl }" />
			</portlet:actionURL>
			<liferay-portlet:actionURL var="editZysqlbURL" name="editZysqlb">
				<portlet:param name="zysqlbId" value="${zysqlb.zysqlbId}" />
				<portlet:param name="expertId" value="${expertId}" />
				<portlet:param name="mvcPath" value="${contextPath }/add-zysqnr.jsp" />
			</liferay-portlet:actionURL>
			<liferay-ui:icon-menu>
				<liferay-ui:icon image="view" url="${viewZysqlbURL }" />
				<liferay-ui:icon image="edit" url="${editZysqlbURL }" />
				<liferay-ui:icon-delete url="${deleteZysqlbURL}" />
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
