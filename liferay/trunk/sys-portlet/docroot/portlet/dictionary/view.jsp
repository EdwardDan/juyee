<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contentPath"
	value="${request.contextPath}/portlet/dictionary" />
 
<portlet:renderURL var="viewURL" >
	<portlet:param name="parentId" value="${parentDictionary.dictionaryId}" />
</portlet:renderURL>

<portlet:actionURL var="deleteDictionariesURL" name="deleteDictionaries">
	<portlet:param name="parentId" value="${parentDictionary.dictionaryId}" />
	<portlet:param name="redirect" value="${viewURL}" />
</portlet:actionURL>
 
<c:if test="${!empty parentDictionary }">
	<portlet:renderURL var="backURL">
		<portlet:param name="parentId" value="${parentDictionary.parentId}" />
	</portlet:renderURL>
	<liferay-ui:header title="${parentDictionary.name}" backURL="${backURL}" />
</c:if>
<aui:form action="${viewURL }" name="fm">
	<aui:nav-bar>
		<aui:nav>
			<portlet:actionURL var="addDictionaryURL" name="editDictionary">
				<portlet:param name="mvcPath"
					value="${contentPath }/edit-dictionary.jsp" />
				<portlet:param name="parentId" value="${parentDictionary.dictionaryId}" />
			</portlet:actionURL>
			<aui:nav-item href="<%=addDictionaryURL%>" iconCssClass="icon-plus"
				label="添加" />
		</aui:nav>
		<aui:nav-bar-search cssClass="pull-right">
			<div class="form-search">
				<liferay-ui:input-search />
			</div>
		</aui:nav-bar-search>
	</aui:nav-bar>
	<aui:button-row>
		<aui:button disabled="<%=true%>" name="deleteDictionariesBtn" value="删除" onClick='<%=renderResponse.getNamespace() + "deleteDictionaries();"%>' />
	</aui:button-row>
	<liferay-ui:search-container emptyResultsMessage="没有找到代码。" rowChecker="<%=new RowChecker(renderResponse)%>">
		<liferay-ui:search-container-results results="${dictionaries }"
			total="${dictionariesCount }">
		</liferay-ui:search-container-results>
		<liferay-ui:search-container-row className="com.justonetech.sys.model.Dictionary" modelVar="dictionary" keyProperty="dictionaryId" >
			<liferay-portlet:renderURL varImpl="rowURL">
				<portlet:param name="parentId" value="${dictionary.dictionaryId}" />
			</liferay-portlet:renderURL>
			<liferay-ui:search-container-column-text property="name" name="代码名称" href="${rowURL}"/>
			<liferay-ui:search-container-column-text property="code" name="代码编码" href="${rowURL}"/>
			<liferay-ui:search-container-column-text name="是否有效" value='${dictionary.isValid?"是":"否" }' href="${rowURL}"/>
			<liferay-ui:search-container-column-text>
				<liferay-ui:icon-menu>
					<portlet:actionURL var="editDictionaryURL" name="editDictionary">
						<portlet:param name="dictionaryId" value="${dictionary.dictionaryId}" />
						<portlet:param name="mvcPath" value="${contentPath }/edit-dictionary.jsp" />
					</portlet:actionURL>
					<liferay-ui:icon image="edit" label="编辑" url="${editDictionaryURL}" />
					<liferay-ui:icon image="delete" label="删除" url="javascript:void(0);" onClick='<%=renderResponse.getNamespace() + "deleteDictionaries("+dictionary.getDictionaryId()+");"%>' />
				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator>
		<%
			String parentId = renderRequest.getAttribute("parentId")+"";
			PortletURL portletURL = searchContainer.getIteratorURL();
			portletURL.setParameter("parentId", parentId);
		%>
		</liferay-ui:search-iterator>
	</liferay-ui:search-container>
</aui:form>

<aui:script>
	
	Liferay.Util.toggleSearchContainerButton('#<portlet:namespace />deleteDictionariesBtn', '#<portlet:namespace /><%=searchContainerReference.getId("searchContainer")%>SearchContainer', document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
	
	Liferay.provide(
			window,
			'<portlet:namespace />deleteDictionaries',
			function(dictionaryIds) {
				if(confirm("确定要删除所选数据吗？")){
					if(!dictionaryIds){
						dictionaryIds = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
					}
					location.href="<%=deleteDictionariesURL%>&<portlet:namespace />dictionaryIds="+ dictionaryIds;
				}
			},
			['liferay-util-list-fields']
		);
</aui:script>