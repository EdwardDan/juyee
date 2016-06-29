<%@include file="/common/init.jsp"%>
<%@include file="/common/init-ext.jsp"%>
<%@ page contentType="text/html;charset=utf-8"%>
<c:set var="contentPath"
	value="${request.contextPath}/portlet/dictionary" />
<portlet:renderURL var="inputCodeSet">
	<portlet:param name="mvcPath"
		value="/portlet/dictionary/input-code-set.jsp" />
</portlet:renderURL>
<portlet:renderURL var="query" />

<aui:form action="${query }" name="fm">
	<aui:form action="${query}" method="post">
		<aui:nav-bar>
			<aui:nav>
				<portlet:renderURL var="inputCode">
					<portlet:param name="mvcPath"
						value="${contentPath}/input-code-set.jsp" />
				</portlet:renderURL>
				<aui:nav-item href="<%=inputCode%>" iconCssClass="icon-plus"
					label="添加" />
			</aui:nav>
			<aui:nav-bar-search cssClass="pull-right">
				<div class="form-search">
					<liferay-ui:input-search />
				</div>
			</aui:nav-bar-search>
		</aui:nav-bar>
	</aui:form>
	<liferay-ui:search-container delta="5" emptyResultsMessage="没有找到数据!">
		<liferay-ui:search-container-results results="${dictionaries}"
			total="${totalSize}" />
		<liferay-ui:search-container-row className="Dictionary" modelVar="dic"
			keyProperty="dictionaryId">
			<liferay-ui:search-container-column-text name="代码集" property="name" />
			<liferay-ui:search-container-column-text name="编码" property="code" />
			<liferay-ui:search-container-column-text name="备注" property="desc" />
			<liferay-ui:search-container-column-text name="action">
				<portlet:actionURL var="del" name="deleteCodeSet">
					<portlet:param name="dictionaryId" value="${dic.dictionaryId}" />
				</portlet:actionURL>
				<portlet:actionURL var="edit" name="editCodeSet">
					<portlet:param name="mvcPath"
						value="/portlet/dictionary/input-code-set.jsp" />
					<portlet:param name="dictionaryId" value="${dic.dictionaryId}" />
				</portlet:actionURL>
				<portlet:actionURL var="view" name="viewCodeSet">
					<portlet:param name="mvcPath"
						value="/portlet/dictionary/view-code-set.jsp" />
					<portlet:param name="dictionaryId" value="${dic.dictionaryId}" />
				</portlet:actionURL>
				<portlet:renderURL var="inputCode">
					<portlet:param name="mvcPath"
						value="/portlet/dictionary/input-code.jsp" />
					<portlet:param name="dictionaryId" value="${dic.dictionaryId}" />
				</portlet:renderURL>
				<liferay-ui:icon-menu>
					<liferay-ui:icon-delete image="delete" url="${del}" />
					<liferay-ui:icon image="edit" url="${edit}" />
					<liferay-ui:icon image="view" label="查看" url="${view}" />
					<liferay-ui:icon image="add" label="添加代码项" url="${inputCode}" />
				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</aui:form>
