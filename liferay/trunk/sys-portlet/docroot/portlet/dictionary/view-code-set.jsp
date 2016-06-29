<%@include file="/common/init.jsp"%>
<%@include file="/common/init-ext.jsp"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
	Long dictionaryId = (Long) request.getAttribute("dictionaryId");
	Integer totalSize = (Integer) request.getAttribute("totalSize");
	List<Dictionary> dictionaries = (List<Dictionary>)request.getAttribute("dictionaries");
%>
<portlet:renderURL var="def" />
<portlet:renderURL var="inputCode">
	<portlet:param name="mvcPath"
		value="/portlet/dictionary/input-code.jsp" />
	<portlet:param name="dictionaryId" value="${dictionaryId}" />
</portlet:renderURL>

<liferay-ui:header title="查看代码集" backURL="${def}" />
<aui:form action="${input}" method="post">
	<aui:input type="text" label="编码：" name="code" value="${code}"></aui:input>
	<aui:input type="text" label="名称:" name="name" value="${name}"></aui:input>
	<aui:input type="content" label="备注:" name="desc" value="${desc}"></aui:input>
</aui:form>


<h4>代码明细列表</h4>
<form action="${find}" method="post">
	<table align="center" width="100%">
		<tr>
			<td align="right"><a href="${inputCode}" class="btn"><i
					class="icon-plus"></i>添加代码项</a></td>
		</tr>
	</table>
</form>
<liferay-ui:search-container emptyResultsMessage="没有找到数据!">
	<liferay-ui:search-container-results results="${dictionaries}" />
	<liferay-ui:search-container-row className="Dictionary" modelVar="dic"
		keyProperty="dictionaryId">
		<liferay-ui:search-container-column-text name="编码" property="code" />
		<liferay-ui:search-container-column-text name="名称" property="name" />
		<liferay-ui:search-container-column-text name="特殊标记" property="tag" />
		<liferay-ui:search-container-column-text name="是否有效"
			property="isValid" />
		<liferay-ui:search-container-column-text name="备注" property="desc" />
		<liferay-ui:search-container-column-text name="action">
			<portlet:actionURL var="del" name="deleteCode"> 
				<portlet:param name="dictionaryId" value="${dic.dictionaryId}" />
			</portlet:actionURL>
			<portlet:actionURL var="edit" name="editCode"> 
				<portlet:param name="mvcPath" value="/portlet/dictionary/input-code.jsp" />
				<portlet:param name="dictionaryId" value="${dic.dictionaryId}" />
			</portlet:actionURL>
			<liferay-ui:icon-menu>
				<liferay-ui:icon-delete image="delete" url="${del}" />
				<liferay-ui:icon image="edit" url="${edit}" />
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

