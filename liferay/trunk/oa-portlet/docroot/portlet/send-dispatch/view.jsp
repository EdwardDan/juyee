<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contentPath"
	value="${request.contextPath}/portlet/send-dispatch" />
<portlet:renderURL var="viewURL" />
<portlet:actionURL var="deleteDispatchesURL" name="deleteDispatches">
	<portlet:param name="redirect" value="${viewURL}" />
</portlet:actionURL>
<aui:form action="${viewURL }" name="fm">
	<aui:nav-bar>
		<aui:nav>
			<portlet:renderURL var="addDispatchURL">
				<portlet:param name="mvcPath"
					value="${contentPath }/edit-dispatch.jsp" />
			</portlet:renderURL>
			<aui:nav-item href="<%=addDispatchURL%>" iconCssClass="icon-plus"
				label="添加" />
		</aui:nav>
		<aui:nav-bar-search cssClass="pull-right">
			<div class="form-search">
				<liferay-ui:input-search />
			</div>
		</aui:nav-bar-search>
	</aui:nav-bar>
	<aui:button-row>
		<aui:button disabled="<%=true%>" name="deleteDispatchesBtn" value="删除" onClick='<%=renderResponse.getNamespace() + "deleteDispatches();"%>' />
	</aui:button-row>
	<liferay-ui:search-container emptyResultsMessage="没有找到发文记录。" rowChecker="<%=new RowChecker(renderResponse)%>">
		<liferay-ui:search-container-results results="${dispatches}"
			total="${dispatchesCount}">
		</liferay-ui:search-container-results>
		<liferay-ui:search-container-row className="Dispatch" modelVar="dispatch" keyProperty="dispatchId">
			 <%
			Dictionary rocordType = DictionaryLocalServiceUtil.getDictionary(dispatch.getRocordType());
			%> 
			<liferay-ui:search-container-column-text name="文种" value="<%=rocordType.getName()%>" />
			 <%
			Dictionary securityLevel = DictionaryLocalServiceUtil.getDictionary(dispatch.getSecurityLevel());
			%> 
			<liferay-ui:search-container-column-text name="密级" value="<%=securityLevel.getName()%>"/>
			 <%
			Dictionary organaAbbreviation = DictionaryLocalServiceUtil.getDictionary(dispatch.getOrganaAbbreviation());
			%> 
			<liferay-ui:search-container-column-text name="发文机关代字" value="<%=organaAbbreviation.getName()%>"/>
			 <%
			Dictionary year = DictionaryLocalServiceUtil.getDictionary(dispatch.getYear());
			%> 
			<liferay-ui:search-container-column-text name="发文年份" value="<%=year.getName()%>"/>
			<liferay-ui:search-container-column-text property="serialNo" name="文件顺序号" />
			<liferay-ui:search-container-column-text property="title" name="发文标题" />
			<liferay-ui:search-container-column-text property="sendOrgan" name="主送机关"/>
			<liferay-ui:search-container-column-text property="ccOrgan" name="抄送机关"/>
			<liferay-ui:search-container-column-text property="writtenOrgan" name="成文机关"/>
			<liferay-ui:search-container-column-text name="成文日期" value="<%=DateUtil.getDate(dispatch.getWrittenDate(), defaultDateFormatPattern, locale, timeZone) %>"/>
			 <%
			Dictionary urgencyDegree = DictionaryLocalServiceUtil.getDictionary(dispatch.getUrgencyDegree());
			%> 
			<liferay-ui:search-container-column-text name="紧急程度" value="<%=urgencyDegree.getName()%>"/>
			<liferay-ui:search-container-column-text>
				<liferay-ui:icon-menu>
					<portlet:actionURL var="editDispatchURL" name="editDispatch">
						<portlet:param name="dispatchId" value="${dispatch.dispatchId}" />
						<portlet:param name="mvcPath" value="${contentPath}/edit-dispatch.jsp" />
					</portlet:actionURL>
					<liferay-ui:icon image="edit" label="编辑" url="${editDispatchURL}" />
					<liferay-ui:icon image="delete" label="删除" url="javascript:void(0);" onClick='<%=renderResponse.getNamespace() + "deleteDispatches("+dispatch.getDispatchId()+");"%>' />
				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator/>
	</liferay-ui:search-container>
</aui:form>

<aui:script>
	
	Liferay.Util.toggleSearchContainerButton('#<portlet:namespace />deleteDispatchesBtn', '#<portlet:namespace /><%=searchContainerReference.getId("searchContainer")%>SearchContainer', document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
	
	Liferay.provide(
			window,
			'<portlet:namespace />deleteDispatches',
			function(dispatchIds) {
				if(confirm("确定要删除所选数据吗？")){
					if(!dispatchIds){
						dispatchIds = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
					}
					location.href="<%=deleteDispatchesURL%>&<portlet:namespace/>dispatchIds="+ dispatchIds;
				}
			},
			['liferay-util-list-fields']
		);
</aui:script>