<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>

<c:set var="contextPath" value="${request.contextPath}/portlet/permit-application" />
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
	<portlet:param name="mvcPath" value="${contextPath }/select-contract.jsp" />
</portlet:renderURL>
<liferay-ui:panel-container accordion="false" extended="true">
	<liferay-ui:panel title="查询条件" collapsible="true">
		<aui:form name="fm" method="get" action="${searchURL }">
			<aui:input name="p_p_id" type="hidden" useNamespace="false" value="${portletDisplay.id }"></aui:input>
			<aui:input name="mvcPath" type="hidden" useNamespace="false" value="${contextPath }/apply-permit.jsp"></aui:input>
			<aui:input type="hidden" name="delta" value="${delta}"></aui:input>
			<table style="width: 100%;" class="table table-bordered">
				<tr>
					<td style="width: 10%;" class="text-right">报建编号</td>
					<td style="width: 40%;" class="bg-white"><aui:input type="text" name="bjbh" style="width:80%" label="" /></td>
					<td style="width: 10%;" class="text-right">工程名称</td>
					<td style="width: 40%;" class="bg-white"><aui:input type="text" name="gcmc" style="width:80%" label="" /></td>
				</tr>
				<tr style="height: 40px;">
					<td colspan="4" align="center" class="bg-white"><aui:button type="submit" value="查询"></aui:button> <aui:button type="button" value="申请"
							href="${selectContractURL}"></aui:button></td>
				</tr>
			</table>
		</aui:form>
	</liferay-ui:panel>

	<liferay-ui:panel title="施工许可列表" collapsible="false">
		<liferay-ui:search-container emptyResultsMessage="没有施工许可数据。">
			<liferay-ui:search-container-results results="${permits}" total="${permitsCount }">
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="com.justonetech.cp.permit.model.Permit" keyProperty="permitId" modelVar="permit">
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
							int applyStatus=permit.getStatus();
							Project project =ProjectLocalServiceUtil.getProject(permit.getBjbh());
							String type="";
							if(project.getLxjb().equals("区县级机关或区县级单位")){
						    			type="quxian";
						    				}else{
						    			type="shishu";
						    				}
							String status="";
							if(project.getLxjb().equals("区县级机关或区县级单位")){
								if(permit.getStatus()==1){
									status="填写";
								}
								if(permit.getStatus()==2){
									status="已上报";
								}
								if(permit.getStatus()>=3&&permit.getStatus()<7||permit.getStatus()>7){
									status="收件通过";
								}
								if(permit.getStatus()==7){
									status="审批通过";
								}
							}else{
								if(permit.getStatus()==1){
									status="填写";
								}
								if(permit.getStatus()==2){
									status="已上报";
								}
								if(permit.getStatus()==3){
									status="初审退回";
								}
								if(permit.getStatus()>3&&permit.getStatus()<13){
									status="已上报";
								}
								if(permit.getStatus()>=13&&permit.getStatus()<17){
									status="收件通过";
								}
								if(permit.getStatus()==17){
									status="收件退回";
								}
								if(permit.getStatus()==18){
									status="委领导许可";
								}
								if(permit.getStatus()==19){
									status="委领导不许可";
								}
							}
				%>

				<liferay-portlet:renderURL varImpl="rowURL">
					<portlet:param name="bjbh" value="${permit.bjbh}" />
					<portlet:param name="sqbz" value="${permit.sqbz}" />
					<portlet:param name="permitId" value="${permit.permitId}" />
					<portlet:param name="bdh" value="${permit.bdh }" />
					<%-- <portlet:param name="gcmc" value="${permit.gcmc }"/> --%>
					<portlet:param name="mvcPath" value="${contextPath }/edit-permit.jsp" />
				</liferay-portlet:renderURL>


				<portlet:renderURL var="viewPermitURL">
					<portlet:param name="mvcPath" value="${contextPath}/view-permit.jsp" />
					<portlet:param name="permitId" value="${permit.permitId}" />
				</portlet:renderURL>

				<liferay-ui:search-container-column-text value="<%=String.valueOf(++rowNo)%>" />

				<liferay-ui:search-container-column-text name="项目类型" value="<%=xmlxName%>" />
				<liferay-ui:search-container-column-text property="bjbh" name="报建编号" />
				<liferay-ui:search-container-column-text property="bdh" name="施工许可标段号" />
				<c:if test="<%=(applyStatus<=2)%>">
					<liferay-ui:search-container-column-text value="<%=projectProfile.getGcmc() %>" name="工程名称" href="${rowURL }" />
				</c:if>
				<c:if test="<%=(applyStatus>2)%>">
					<liferay-ui:search-container-column-text value="<%=projectProfile.getGcmc()%>" name="工程名称" />
				</c:if>
				<liferay-ui:search-container-column-text value="<%=status%>" name="申请状态" />
				<liferay-ui:search-container-column-text name="操作">
					<liferay-ui:icon-menu>
						<c:if test="<%=(applyStatus>2)%>">
							<liferay-ui:icon image="view" url="${viewPermitURL}" />
						</c:if>
						<c:if test='<%=(applyStatus<=2)||(applyStatus==4)||(applyStatus==17&&type.equals("shishu"))%>'>
							<liferay-ui:icon image="edit" url="${rowURL}" />
							<liferay-ui:icon image="delete" label="删除" url="javascript:void(0);"
								onClick='<%=renderResponse.getNamespace() + "deletePermits("+permit.getPermitId()+");"%>' />
						</c:if>
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