<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contextPath"
	value="${request.contextPath}/portlet/construction-permit-material" />
<%
	long dictionaryId = ParamUtil.getLong(request, "dictionaryId");
	int id = ParamUtil.getInteger(request, "id");
	int sortNoMax = ParamUtil.getInteger(request, "sortNoMax");//renderURL点击添加时传递过来的参数
	request.setAttribute("sortNoMax", sortNoMax + 1);
	Dictionary typeDictionary = DictionaryLocalServiceUtil.getDictionary(dictionaryId);
	request.setAttribute("typeDictionary", typeDictionary.getName());
	String type = ParamUtil.getString(request, "type");
	request.setAttribute("type", type);
	Dictionary apply = DictionaryLocalServiceUtil.findByCode("apply");
	request.setAttribute("apply", apply.getDictionaryId());
	Dictionary submit = DictionaryLocalServiceUtil.findByCode("submit");
	request.setAttribute("submit", submit.getDictionaryId());
	Dictionary dictionary = DictionaryLocalServiceUtil
			.findByCode("materialType");
	List<Dictionary> dictionaries=null;
	if (null != dictionary) {
		 dictionaries = DictionaryLocalServiceUtil
				.findByParentId(
						dictionary.getDictionaryId(), -1,
						-1);
	}
%>
<portlet:renderURL var="viewURL" />
<portlet:renderURL var="thisURL">
	<portlet:param name="mvcPath" value="${contextPath }/edit-construction-permit-material.jsp" />
</portlet:renderURL>
<aui:model-context bean="${constructionPermitMaterial}"
	model="<%=ConstructionPermitMaterial.class %>" />
<liferay-ui:header
	title="${empty constructionPermitMaterial?'添加':'编辑'}${typeDictionary}材料"
	backURL="${viewURL }" />
<portlet:actionURL var="saveConstructionPermitMaterialURL"
	name="saveConstructionPermitMaterial">
	<portlet:param name="redirect" value="${viewURL }" />
</portlet:actionURL>
<aui:form action="${saveConstructionPermitMaterialURL}">
	<aui:fieldset>
		<aui:input name="dictionaryId" type="hidden" value="<%=dictionaryId%>" />
		<div style="display: none">
			<aui:input name="id" type="text" value="<%=id%>" />
		</div>
		<aui:select name="type" id="type" label="材料类型">
		<c:forEach items="<%=dictionaries%>" var="dictionary">
			<aui:option value="${dictionary.dictionaryId}">${dictionary.name }</aui:option>
			</c:forEach>
		</aui:select>
		<aui:input type="text" name="sortNo" label="序号" value="${sortNoMax}">
			<aui:validator name="required" errorMessage="请输入序号！" />
			<aui:validator name="number" />
		</aui:input>
		<aui:input type="text" name="materialName" label="材料名称">
			<aui:validator name="required" errorMessage="请输入材料名称！" />
		</aui:input>
		<c:if test="${type==submit}">
			<aui:input type="text" name="auditReq" label="审核要求">
				<%-- <aui:validator name="required" errorMessage="请输入审核要求！" /> --%>
			</aui:input>
			<aui:input type="text" name="auditReqGreen" label="绿色审核要求">
				<%-- <aui:validator name="required" errorMessage="请输入绿色审核要求！" /> --%>
			</aui:input>
		</c:if>
		<c:if test="${type==apply||type==''}">
			<aui:input id="yjNum" type="text" name="yjNum" label="应交份数">
				<aui:validator name="number" />
			</aui:input>
		</c:if>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" value="提交" />
		<aui:button type="cancel" value="取消" href="${viewURL }" />
	</aui:button-row>
</aui:form>
<aui:script use="aui-base">
	var myselect = A.one("#<portlet:namespace/>type");
	var firstSelect = A.one("#<portlet:namespace/>type").get(0).val();
	var dictionaryId = A.one("#<portlet:namespace/>dictionaryId").val();
	var sortNo = A.one("#<portlet:namespace/>sortNo").val();
	var materialName = A.one("#<portlet:namespace/>materialName").val();
	var id = A.one("#<portlet:namespace/>id").val();
	myselect
			.on(
					"change",
					function(event) {
						myselect
								.all("option:selected")
								.each(
										function(node) {
											var selected = node.val();
											if (selected == firstSelect) {
												window.location.href = "${thisURL}&<portlet:namespace/>dictionaryId="
														+ dictionaryId
														+ "&<portlet:namespace/>id="
														+ id
														+ "&<portlet:namespace/>type="
														+ selected
														+ "&<portlet:namespace/>sortNo="
														+ sortNo
														+ "&<portlet:namespace/>materialName="
														+ materialName;
											} else {
												window.location.href = "${thisURL}&<portlet:namespace/>dictionaryId="
														+ dictionaryId
														+ "&<portlet:namespace/>id="
														+ id
														+ "&<portlet:namespace/>type="
														+ selected
														+ "&<portlet:namespace/>sortNo="
														+ sortNo
														+ "&<portlet:namespace/>materialName="
														+ materialName;
											}
										});
					});
</aui:script>
