<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contextPath"
	value="${request.contextPath}/portlet/office-supply" />
<portlet:renderURL var="viewURL" />
<portlet:actionURL var="deleteOfficeSuppliesURL" name="deleteOfficeSupplies">
	<portlet:param name="redirect" value="${viewURL}" />
</portlet:actionURL>
<aui:form action="${viewURL }" name="fm">
	<aui:nav-bar>
		<aui:nav>
			<portlet:renderURL var="addOfficeSupplyURL">
				<portlet:param name="mvcPath"
					value="${contextPath }/edit-office-supply.jsp" />
			</portlet:renderURL>
			<aui:nav-item href="<%=addOfficeSupplyURL%>" iconCssClass="icon-plus"
				label="添加" />
		</aui:nav>
		<aui:nav-bar-search cssClass="pull-right">
			<div class="form-search">
				<liferay-ui:input-search />
			</div>
		</aui:nav-bar-search>
	</aui:nav-bar>
	<aui:button-row>
		<aui:button disabled="<%=true%>" name="deleteOfficeSuppliesBtn" value="删除" onClick='<%=renderResponse.getNamespace() + "deleteOfficeSupplies();"%>' />
	</aui:button-row>
	<liferay-ui:search-container emptyResultsMessage="没有找到办公用品。" rowChecker="<%=new RowChecker(renderResponse)%>">
		<liferay-ui:search-container-results results="${officeSupplies }"
			total="${officeSuppliesCount }">
		</liferay-ui:search-container-results>
		<liferay-ui:search-container-row className="OfficeSupply" modelVar="officeSupply" keyProperty="officeSupplyId">
			<liferay-ui:search-container-column-text property="name" name="办公用品名称" />
			<liferay-ui:search-container-column-text property="model" name="型号" />
			<liferay-ui:search-container-column-text property="unit" name="单位" />
			<liferay-ui:search-container-column-text property="unitPrice" name="单价"/>
			<liferay-ui:search-container-column-text property="quantity" name="库存"/>
			<liferay-ui:search-container-column-text>
				<liferay-ui:icon-menu>
					<portlet:actionURL var="editOfficeSupplyURL" name="editOfficeSupply">
						<portlet:param name="officeSupplyId" value="${officeSupply.officeSupplyId}" />
						<portlet:param name="mvcPath" value="${contextPath }/edit-office-supply.jsp" />
					</portlet:actionURL>
					<liferay-ui:icon image="edit" label="编辑" url="${editOfficeSupplyURL}" />
					<liferay-ui:icon image="delete" label="删除" url="javascript:void(0);" onClick='<%=renderResponse.getNamespace() + "deleteOfficeSupplies("+officeSupply.getOfficeSupplyId()+");"%>' />
				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator/>
	</liferay-ui:search-container>
</aui:form>

<aui:script>
	
	Liferay.Util.toggleSearchContainerButton('#<portlet:namespace />deleteOfficeSuppliesBtn', '#<portlet:namespace /><%=searchContainerReference.getId("searchContainer")%>SearchContainer', document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
	
	Liferay.provide(
			window,
			'<portlet:namespace />deleteOfficeSupplies',
			function(officeSupplyIds) {
				if(confirm("确定要删除所选数据吗？")){
					if(!officeSupplyIds){
						officeSupplyIds = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
					}
					location.href="<%=deleteOfficeSuppliesURL%>&<portlet:namespace />officeSupplyIds="+ officeSupplyIds;
				}
			},
			['liferay-util-list-fields']
		);
</aui:script>