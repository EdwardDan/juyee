<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contextPath"
	value="${request.contextPath}/portlet/permit-application" />
<portlet:renderURL var="searchURL">
	<portlet:param name="mvcPath" value="${contextPath }/apply-permit.jsp" />
</portlet:renderURL>
<portlet:actionURL var="deletePermitsURL" name="deletePermits">
	<portlet:param name="redirect" value="${viewURL}" />
</portlet:actionURL>
<%
	int rowNo = 0;
%>
<portlet:renderURL var="selectContractURL">
	<portlet:param name="mvcPath"
		value="${contextPath }/select-contract.jsp" />
</portlet:renderURL>
<liferay-ui:panel-container accordion="false" extended="true">
	<liferay-ui:panel title="查询条件" collapsible="true">
		<aui:form name="fm" method="get" action="${searchURL }">
			<aui:input name="p_p_id" type="hidden" useNamespace="false"
				value="${portletDisplay.id }"></aui:input>
			<aui:input name="mvcPath" type="hidden" useNamespace="false"
				value="${contextPath }/apply-permit.jsp"></aui:input>
			<aui:input type="hidden" name="delta" value="${delta}"></aui:input>
			<table style="width: 100%;" border="1">
				<tr>
					<td style="width: 10%;">报建编号</td>
					<td style="width: 40%;"><aui:input type="text" name="bjbh"
							style="width:80%" label="" /></td>
					<td style="width: 10%;">工程名称</td>
					<td style="width: 40%;"><aui:input type="text" name="gcmc"
							style="width:80%" label="" /></td>
				</tr>
				<tr style="height: 40px;">
					<td colspan="4" align="center"><aui:button type="submit"
							value="查询"></aui:button> <aui:button type="button" value="申请"
							href="${selectContractURL}"></aui:button></td>
				</tr>
			</table>
		</aui:form>
	</liferay-ui:panel>

	<liferay-ui:panel title="施工许可列表" collapsible="false">
		<liferay-ui:search-container emptyResultsMessage="没有施工许可数据。">
			<liferay-ui:search-container-results results="${permits}"
				total="${permitsCount }">
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row
				className="com.justonetech.cp.permit.model.Permit"
				keyProperty="permitId" modelVar="permit">
				<liferay-portlet:renderURL varImpl="rowURL">
					<portlet:param name="bjbh" value="${permit.bjbh}" />
					<portlet:param name="sqbz" value="${permit.sqbz}" />
					<portlet:param name="permitId" value="${permit.permitId}" />
					<portlet:param name="bdh" value="${permit.bdh }" />
					<%-- <portlet:param name="gcmc" value="${permit.gcmc }"/> --%>
					<portlet:param name="mvcPath"
						value="${contextPath }/edit-permit.jsp" />
				</liferay-portlet:renderURL>
				<liferay-ui:search-container-column-text
					value="<%=String.valueOf(++rowNo)%>" />
				<%
					ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permit.getPermitId());
					Dictionary xmlx=null;
					String xmlxName="";
					if(projectProfile.getXmlx()!=0){
						try{
					  xmlx = DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmlx());
					 xmlxName=xmlx.getName(); 
						}catch(Exception e){
						}
						}
				%>
				<liferay-ui:search-container-column-text name="项目类型"
					value="<%=xmlxName %>" />
				<liferay-ui:search-container-column-text property="bjbh" name="报建编号" />
				<liferay-ui:search-container-column-text property="bdh"
					name="施工许可标段号" />
				<liferay-ui:search-container-column-text
					value="<%=projectProfile.getGcmc() %>" name="工程名称"
					href="${rowURL }" />
				<liferay-ui:search-container-column-text property="sqzt" name="申请状态" />
				<liferay-ui:search-container-column-text name="操作">
					<liferay-ui:icon-menu>
						<liferay-ui:icon image="edit" url="${rowURL}" />
						<liferay-ui:icon image="delete" label="删除" url="javascript:void(0);" onClick='<%=renderResponse.getNamespace() + "deletePermits("+permit.getPermitId()+");"%>' />
					</liferay-ui:icon-menu>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator>
				<%
					String bjbh = (String) renderRequest.getAttribute("bjbh");
					String zzjgdm = (String) renderRequest.getAttribute("zzjgdm");
					String wssqbh = (String) renderRequest.getAttribute("wssqbh");
					String gcmc = (String) renderRequest.getAttribute("gcmc");
					PortletURL portletURL = searchContainer.getIteratorURL();
					portletURL.setParameter("bjbh", bjbh);
					portletURL.setParameter("zzjgdm", zzjgdm);
					portletURL.setParameter("wssqbh", wssqbh);
					portletURL.setParameter("gcmc", gcmc);
				%>
			</liferay-ui:search-iterator>
		</liferay-ui:search-container>
	</liferay-ui:panel>
</liferay-ui:panel-container>
<aui:script>
	
	Liferay.Util.toggleSearchContainerButton('#<portlet:namespace />deletePermitsBtn', '#<portlet:namespace /><%=searchContainerReference.getId("searchContainer")%>SearchContainer', document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
	
	Liferay.provide(
			window,
			'<portlet:namespace />deletePermits',
			function(permitIds) {
				if(confirm("确定要删除所选数据吗？")){
					if(!permitIds){
						permitIds = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
					}
					location.href="<%=deletePermitsURL%>&<portlet:namespace/>permitIds="+ permitIds;
				}
			},
			['liferay-util-list-fields']
		);
</aui:script>