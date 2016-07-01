<%@page import="com.justonetech.sys.service.DictionaryLocalServiceUtil"%>
<%@include file="/common/init.jsp"%>
<%@include file="/common/init-ext.jsp"%>
<%@ page contentType="text/html;charset=utf-8"%>
<c:set var="contentPath"
	value="${request.contextPath}/portlet/dictionary" />
<%
	Long dictionaryId = (Long) request.getAttribute("dictionaryId");
	String name = null;
	if (Validator.isNotNull(dictionaryId)) {
	name = DictionaryLocalServiceUtil.getDictionary(dictionaryId).getName();
%>
<portlet:renderURL var="def" />
<liferay-ui:header title="<%=name%>" backURL="${def}" />
<%
	}
%>
<portlet:renderURL var="query" />

<aui:form action="${query }" name="fm">
	<aui:form action="${query}" method="post">
		<aui:nav-bar>
			<aui:nav>
				<portlet:renderURL var="addCode">
					<portlet:param name="mvcPath" value="${contentPath}/add-code.jsp" />
					<portlet:param name="dictionaryId" value="${dictionaryId}" />
				</portlet:renderURL>
				<aui:nav-item href="<%=addCode%>" iconCssClass="icon-plus"
					label="添加" />
			</aui:nav>
			<aui:nav-bar-search cssClass="pull-right">
				<div class="form-search">
					<liferay-ui:input-search />
				</div>
			</aui:nav-bar-search>
		</aui:nav-bar>
	</aui:form>
</aui:form>
<liferay-ui:search-container delta="15" emptyResultsMessage="没有找到编码。">
	<liferay-ui:search-container-results results="${dictionaries}"
		total="${totalSize}" />
	<liferay-ui:search-container-row className="Dictionary" modelVar="dic"
		keyProperty="dictionaryId">
		<portlet:renderURL var="view">
			<portlet:param name="dictionaryId" value="${dic.dictionaryId}" />
		</portlet:renderURL>
		<liferay-ui:search-container-column-text name="编码"
			value="<a href='${view}'>${dic.code}</a>" />
		<liferay-ui:search-container-column-text name="名称"
			value="<a href='${view}'>${dic.name}</a>" />
		<liferay-ui:search-container-column-text name="特殊标记"
			value="<a href='${view}'>${dic.tag}</a>" />
		<liferay-ui:search-container-column-text name="是否有效"
			value="<a href='${view}'>${dic.isValid}</a>" />
		<liferay-ui:search-container-column-text name="备注"
			value="<a href='${view}'>${dic.desc}</a>" />
		<liferay-ui:search-container-column-text name="action">
			<portlet:actionURL var="del" name="deleteCode">
				<portlet:param name="dictionaryId" value="${dic.dictionaryId}" />
			</portlet:actionURL>
			<portlet:actionURL var="edit" name="editCode">
				<portlet:param name="mvcPath"
					value="/portlet/dictionary/add-code.jsp" />
				<portlet:param name="dictionaryId" value="${dic.dictionaryId}" />
				<portlet:param name="edit" value="1" />
			</portlet:actionURL>
			<liferay-ui:icon-menu>
				<liferay-ui:icon-delete image="delete" url="${del}" />
				<liferay-ui:icon image="edit" url="${edit}" />
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>