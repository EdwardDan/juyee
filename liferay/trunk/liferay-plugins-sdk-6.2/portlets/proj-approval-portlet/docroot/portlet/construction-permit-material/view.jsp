<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contextPath"
	value="${request.contextPath}/portlet/construction-permit-material" />
<portlet:defineObjects />
<portlet:renderURL var="inputURL">
	<portlet:param name="mvcPath" value="${contextPath}/edit-construction-permit-material.jsp" />
	<portlet:param name="sortNoMax"
		value="${constructionPermitMaterialsCount}" />
</portlet:renderURL>
<portlet:renderURL var="viewURL" />
<%
	long type=ParamUtil.getLong(request, "type");
request.setAttribute("type", type);
Dictionary dictionary = DictionaryLocalServiceUtil.findByCode("projectType");
List<Dictionary> dictionaries=null;
if (null != dictionary) {
dictionaries = DictionaryLocalServiceUtil.findByParentId(dictionary.getDictionaryId(), -1, -1);
}
%>
<aui:form action="${viewURL }" name="fm">
	<portlet:renderURL var="addDispatchURL">
		<portlet:param name="mvcPath"
			value="${contextPath }/edit-dispatch.jsp" />
	</portlet:renderURL>
	<aui:row style="margin-bottom:-20px">
		<aui:col span="6">
		<aui:select id="projectType" name="projectType" label="项目类型："
		inlineField="true" inlineLabel="left" onchange="projectType()" >
		<c:forEach items="<%=dictionaries%>" var="dictionary">
		<option value="${dictionary.dictionaryId}"	<c:if test="${type eq dictionary.dictionaryId }">selected</c:if>>${dictionary.name}</option>
		</c:forEach>
		</aui:select>
	<aui:button value="添加" onclick="add()" icon="icon-plus"></aui:button>
	</aui:col>
	</aui:row>
	<liferay-ui:search-container delta="5"
		emptyResultsMessage="没有找到施工材料信息。">
		<liferay-ui:search-container-results
			results="${constructionPermitMaterials}"
			total="${constructionPermitMaterialsCount}">
		</liferay-ui:search-container-results>
		<liferay-ui:search-container-row
			className="ConstructionPermitMaterial"
			modelVar="constructionPermitMaterial" keyProperty="dictionaryId">

			<liferay-ui:search-container-column-text name="序号" property="sortNo" />
			<%
				Dictionary projectType=DictionaryLocalServiceUtil.getDictionary(constructionPermitMaterial.getDictionaryId());
					if(null!=projectType){
			%>
			<liferay-ui:search-container-column-text name="项目类型"
				value="<%=projectType.getName()%>" />
			<%
				}
			%>
			<%
				Dictionary materialType = DictionaryLocalServiceUtil.getDictionary(constructionPermitMaterial.getType());
			%>
			<liferay-ui:search-container-column-text name="材料类型"
				value="<%=materialType.getName()%>" />
			<liferay-ui:search-container-column-text name="材料名称"
				property="materialName" />
			<liferay-ui:search-container-column-text name="审核要求"
				property="auditReq" />
			<liferay-ui:search-container-column-text>
				<liferay-ui:icon-menu>
					<portlet:actionURL var="editConstructionPermitMaterialURL"
						name="editConstructionPermitMaterial">
						<portlet:param name="sortNo"
							value="${constructionPermitMaterial.sortNo}" />
						<portlet:param name="dictionaryId"
							value="${constructionPermitMaterial.dictionaryId}" />
						<portlet:param name="type"
							value="${constructionPermitMaterial.type }" />
						<portlet:param name="mvcPath" value="${contextPath}/edit-construction-permit-material.jsp" />
					</portlet:actionURL>
					<portlet:actionURL var="deleteConstructionPermitMaterialURL"
						name="deleteConstructionPermitMaterial">
						<portlet:param name="id" value="${constructionPermitMaterial.id}" />
						<portlet:param name="dictionaryId"
							value="${constructionPermitMaterial.dictionaryId}" />
						<portlet:param name="redirect" value="${viewURL}" />
					</portlet:actionURL>
					<liferay-ui:icon image="edit" label="编辑"
						url="${editConstructionPermitMaterialURL}" />
					<liferay-ui:icon image="delete" label="删除"
						url="${deleteConstructionPermitMaterialURL}" />
				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator>
			<%
				String typeChoosen = ParamUtil.getString(request,
										"type");
								if (null == typeChoosen) {
								} else {
									searchContainer.getIteratorURL().setParameter(
											"type", typeChoosen);
								}
			%>
		</liferay-ui:search-iterator>
	</liferay-ui:search-container>
</aui:form>
<script>
	function add() {
		if (document.getElementsByName("<portlet:namespace/>projectType")[0].value != "") {
			window.location.href = "${inputURL}&<portlet:namespace/>dictionaryId="
					+ document
							.getElementsByName("<portlet:namespace/>projectType")[0].value;
		} else {
			alert("系统字典项目类型未维护！");
		}

	}
	function projectType() {
		window.location.href = "${viewURL}&<portlet:namespace/>type="
				+ document.getElementsByName("<portlet:namespace/>projectType")[0].value;
	}
</script>
