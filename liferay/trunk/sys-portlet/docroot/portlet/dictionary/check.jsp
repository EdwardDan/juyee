<%@include file="/common/init.jsp"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>


<%
	Long dictionaryId = (Long) request.getAttribute("dictionaryId");
    Integer totalSize=(Integer)request.getAttribute("totalSize");
%>
<portlet:renderURL var="def" />
<portlet:renderURL var="add">
	<portlet:param name="mvcPath" value="/portlet/dictionary/add.jsp" />
	<portlet:param name="dictionaryId" value="${dictionaryId}" />
</portlet:renderURL>
<portlet:actionURL var="find" name="find">
<portlet:param name="mvcPath" value="/portlet/dictionary/check.jsp"/>
<portlet:param name="dictionaryId" value="${dictionaryId}"/>
</portlet:actionURL>
<liferay-ui:header title="查看代码集" backURL="${def}" />
<aui:form action="${input}" method="post">
	<aui:input type="text" label="编码：" name="code" value="${code}"></aui:input>
	<aui:input type="text" label="名称:" name="name" value="${name}"></aui:input>
	<aui:input type="content" label="备注:" name="desc" value="${desc}"></aui:input>
</aui:form>


<h4>代码明细列表</h4>
<portlet:actionURL var="check" name="check">
	<portlet:param name="mvcPath" value="/portlet/dictionary/check.jsp" />
</portlet:actionURL>
<form action="${find}" method="post">
	<table align="center" width="100%">
		<tr>
			<td><form class="form-search">
					<input type="text" placeholder="请输入关键字..."
						class="input-medium search-query"
						name="<portlet:namespace/>keywords" value="${keywords}"/>
					<button type="submit" class="btn">
						<i class="icon-search"></i>查询
					</button>
				</form></td>
			<td align="right"><a href="${add}" class="btn"><i
					class="icon-plus"></i>添加代码项</a></td>
		</tr>
	</table>
</form>
<liferay-ui:search-container delta="15" emptyResultsMessage="没有找到数据!">
	<liferay-ui:search-container-results results="${dics}" total="<%=totalSize%>"/>
	<liferay-ui:search-container-row className="Dictionary" modelVar="dic"
		keyProperty="dictionaryId">
		<liferay-ui:search-container-column-text name="编码" property="code" />
		<liferay-ui:search-container-column-text name="名称" property="name" />
		<liferay-ui:search-container-column-text name="特殊标记" property="tag" />
		<liferay-ui:search-container-column-text name="是否有效"
			property="isValid" />
		<liferay-ui:search-container-column-text name="备注" property="desc" />
		<liferay-ui:search-container-column-text name="action">
			<portlet:actionURL var="del" name="del">
				<portlet:param name="dictionaryId" value="${dic.dictionaryId}" />
			</portlet:actionURL>
			<portlet:actionURL var="modify" name="modify">
				<portlet:param name="mvcPath" value="/portlet/dictionary/add.jsp" />
				<portlet:param name="dictionaryId" value="${dic.dictionaryId}" />
			</portlet:actionURL>
			<liferay-ui:icon-menu>
				<liferay-ui:icon-delete image="delete" url="${del}" />
				<liferay-ui:icon image="edit" url="${modify}" />
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

