<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.model.Portlet"%>
<%@include file="/common/init.jsp"%>
<%@ page import="com.justonetech.sys.model.Dictionary"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ page contentType="text/html;charset=utf-8"%>
<portlet:renderURL var="input">
	<portlet:param name="mvcPath" value="/portlet/dictionary/input.jsp" />
</portlet:renderURL>
<portlet:renderURL var="query" />
<aui:form action="${query }" name="fm">
	<form action="${query}" method="post">
		<table align="center" width="100%">
			<tr>
				<td><form class="form-search">
						<input type="text" placeholder="请输入关键字..."
							class="input-medium search-query"
							name="<portlet:namespace/>keyword" value="${keyword}" />
						<button type="submit" class="btn">
							<i class="icon-search"></i>查询
						</button>
					</form></td>
				<td align="right"><a href="<%=input%>" class="btn"><i
						class="icon-plus"></i>添加代码集</a></td>
			</tr>
		</table>
	</form>
	<liferay-ui:search-container delta="10" emptyResultsMessage="没有找到数据!">
		<liferay-ui:search-container-results results="${dics}"
			total="${totalSize}" />
		<liferay-ui:search-container-row className="Dictionary" modelVar="dic"
			keyProperty="dictionaryId">
			<liferay-ui:search-container-column-text name="代码集" property="name" />
			<liferay-ui:search-container-column-text name="编码" property="code" />
			<liferay-ui:search-container-column-text name="action">
				<portlet:actionURL var="del" name="delete">
					<portlet:param name="dictionaryId" value="${dic.dictionaryId}" />
				</portlet:actionURL>
				<portlet:actionURL var="edit" name="edit">
					<portlet:param name="mvcPath" value="/portlet/dictionary/input.jsp" />
					<portlet:param name="dictionaryId" value="${dic.dictionaryId}" />
				</portlet:actionURL>
				<portlet:actionURL var="check" name="check">
					<portlet:param name="mvcPath" value="/portlet/dictionary/check.jsp" />
					<portlet:param name="dictionaryId" value="${dic.dictionaryId}" />
				</portlet:actionURL>
				<liferay-ui:icon-menu>
					<liferay-ui:icon-delete image="delete" url="${del}" />
					<liferay-ui:icon image="edit" url="${edit}" />
					<liferay-ui:icon image="view" label="查看" url="${check}" />
				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator>
			<!-- 查询分页 -->
			<%
				String keyword = (String) renderRequest
									.getAttribute("keyword");
							PortletURL portletURL = searchContainer
									.getIteratorURL();
							portletURL.setParameter("keyword", keyword);
			%>
		</liferay-ui:search-iterator>
	</liferay-ui:search-container>
</aui:form>

