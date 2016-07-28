<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contextPath"
	value="${request.contextPath}/portlet/construction-permit-material" />
<portlet:defineObjects />
<portlet:renderURL var="inputURL">
	<portlet:param name="mvcPath" value="${contextPath}/input.jsp" />
	<portlet:param name="sortNoMax" value="${constructionPermitMaterialsCount}" />
</portlet:renderURL>
<portlet:renderURL var="viewURL" /> 
<%
	long type=ParamUtil.getLong(request, "type");
%>
<select name="projectType" onchange="projectType()">
	<%
		Dictionary dictionary = DictionaryLocalServiceUtil
				.findByCode("ProjectType");
		if (null != dictionary) {
			List<Dictionary> dictionaries = DictionaryLocalServiceUtil
					.findByParentId(dictionary.getDictionaryId(), -1, -1);
			for (Dictionary dic : dictionaries) {
	%>
	<option value="<%=dic.getDictionaryId()%>"
		<c:if test="<%=type==dic.getDictionaryId()%>">selected</c:if>><%=dic.getName()%></option>
	<%
		}}
	%>
</select>
<aui:form action="${viewURL }" name="fm">
	<aui:nav-bar>
		<aui:nav>
			<portlet:renderURL var="addDispatchURL">
				<portlet:param name="mvcPath"
					value="${contextPath }/edit-dispatch.jsp" />
			</portlet:renderURL>
			<aui:nav-item iconCssClass="icon-plus" label="添加" onclick="add()" />
		</aui:nav>
	</aui:nav-bar>
	<liferay-ui:search-container delta="5" emptyResultsMessage="没有找到施工材料信息。">
		<liferay-ui:search-container-results results="${constructionPermitMaterials}"
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
			<%-- <liferay-ui:search-container-column-text name="绿色审核要求"
				property="auditReqGreen" />
			<liferay-ui:search-container-column-text name="应交份数" property="yjNum" /> --%>
			<liferay-ui:search-container-column-text>
				<liferay-ui:icon-menu>
					<portlet:actionURL var="editConstructionPermitMaterialURL"
						name="editConstructionPermitMaterial">
						<portlet:param name="sortNo" value="${constructionPermitMaterial.sortNo}" />
						<portlet:param name="dictionaryId"
							value="${constructionPermitMaterial.dictionaryId}" />
							<portlet:param name="type" value="${constructionPermitMaterial.type }"/>
						<portlet:param name="mvcPath" value="${contextPath}/input.jsp" />
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
		window.location.href = "${inputURL}&<portlet:namespace/>dictionaryId="
				+ document.getElementsByName("projectType")[0].value;
	}
	function projectType() {
		window.location.href = "${viewURL}&<portlet:namespace/>type="
				+ document.getElementsByName("projectType")[0].value;
	}
</script>
