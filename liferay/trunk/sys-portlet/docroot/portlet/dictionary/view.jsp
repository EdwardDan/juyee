<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contextPath"
	value="${request.contextPath}/portlet/dictionary" />
<portlet:renderURL var="viewURL" >
	<portlet:param name="parentId" value="${parentDictionary.dictionaryId}" />
</portlet:renderURL>
<portlet:actionURL var="deleteDictionariesURL" name="deleteDictionaries">
	<portlet:param name="parentId" value="${parentDictionary.dictionaryId}" />
	<portlet:param name="redirect" value="${viewURL}" />
</portlet:actionURL>
<c:choose>
<c:when test="${!empty parentDictionary }">
	<portlet:renderURL var="backURL">
		<portlet:param name="parentId" value="${parentDictionary.parentId}" />
	</portlet:renderURL>
	<liferay-ui:header title="${parentDictionary.name}" backURL="${backURL}" />
</c:when>
<c:otherwise>
	<liferay-ui:header title="系统字典"/>
</c:otherwise>
</c:choose> 
<aui:form action="${viewURL }" name="fm">
	<aui:row>
		<aui:col span="6">
			<portlet:actionURL var="addDictionaryURL" name="editDictionary">
				<portlet:param name="mvcPath"
					value="${contextPath }/edit-dictionary.jsp" />
				<portlet:param name="parentId" value="${parentDictionary.dictionaryId}" />
			</portlet:actionURL>
			<aui:button value="添加" href="${addDictionaryURL }" icon="icon-plus"/>
			<aui:button disabled="<%=true%>" icon="icon-remove" name="deleteDictionariesBtn" value="删除" onClick='<%=renderResponse.getNamespace() + "deleteDictionaries();"%>' />
		</aui:col>
		<aui:col span="6" cssClass="text-right">
			<div class="form-search">
			<liferay-ui:input-search />
			</div>
		</aui:col>
	</aui:row>
	<liferay-ui:search-container emptyResultsMessage="没有找到代码。" rowChecker="<%=new RowChecker(renderResponse)%>">
		<liferay-ui:search-container-results results="${dictionaries }"
			total="${dictionariesCount }">
		</liferay-ui:search-container-results>
		<liferay-ui:search-container-row className="com.justonetech.sys.model.Dictionary" modelVar="dictionary" keyProperty="dictionaryId" >
			<liferay-portlet:renderURL varImpl="rowURL">
				<portlet:param name="parentId" value="${dictionary.dictionaryId}" />
			</liferay-portlet:renderURL>
			<liferay-ui:search-container-column-text property="name" name="代码名称" href="${rowURL}"  />
			<liferay-ui:search-container-column-text property="code" name="代码编码" href="${rowURL}"/>
			<liferay-ui:search-container-column-text name="是否有效" value='${dictionary.isValid?"是":"否" }' href="${rowURL}"/>
			<liferay-ui:search-container-column-text>
				<liferay-ui:icon-menu>
					<portlet:actionURL var="editDictionaryURL" name="editDictionary">
						<portlet:param name="dictionaryId" value="${dictionary.dictionaryId}" />
						<portlet:param name="mvcPath" value="${contextPath }/edit-dictionary.jsp" />
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