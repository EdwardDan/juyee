<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/init.jsp"%>


 
<c:set var="contentPath"
	value="${request.contextPath}/portlet/construction-permit-application" />

<c:set var="namespace"
	value="<%=renderResponse.getNamespace()%>" />

<%
		long groupId = PortalUtil.getScopeGroupId(request);
			Dictionary projTypeDic = DictionaryLocalServiceUtil
		.findByGroupIdAndCode(groupId, "ProjectType");
			
			Dictionary consPerStaQueryDic = DictionaryLocalServiceUtil
					.findByGroupIdAndCode(groupId, "ConstructionPermitStatusQuery");
			
			List<Dictionary> projTypeDics=new ArrayList<Dictionary>();
			List<Dictionary> consPerStaQueryDics=new ArrayList<Dictionary>();
			
		if (null != projTypeDic) {
			projTypeDics = DictionaryLocalServiceUtil
		.findByGroupIdAndParentId(groupId,
				projTypeDic.getDictionaryId(), -1, -1);
		}
		if (null != consPerStaQueryDic) {
			consPerStaQueryDics = DictionaryLocalServiceUtil
		.findByGroupIdAndParentId(groupId,
				consPerStaQueryDic.getDictionaryId(), -1, -1);
		}
%>

<!--各种查询和按状态查询  -->
<portlet:renderURL var="viewURL" />

<!-- 删除 -->
<portlet:actionURL var="deleteConstructionPermitsURL" name="deleteConstructionPermits">
	<portlet:param name="redirect" value="${viewURL}" />
</portlet:actionURL>


<!-- 添加功能 -->
<portlet:renderURL var="addConstructionPermitURL">
				<portlet:param name="mvcPath"
					value="${contentPath}/edit.jsp" />
</portlet:renderURL>


<aui:form action="${viewURL}" name="fm">
	<aui:nav-bar>
		<aui:nav>
		
		<!--原来的用法  -->
		<aui:nav-item dropdown="true" iconCssClass="icon-plus" label="添加">
			<%
		for (Dictionary dic : projTypeDics) {
			Boolean pageType=false;
			if(dic.getName().equals("航道")){
				pageType=true;
			}
		%>	
		<aui:nav-item   href='<%=addConstructionPermitURL+"&"+renderResponse.getNamespace()+"pageType="
	+pageType+"&"+renderResponse.getNamespace()+"projTypeName="+dic.getName()+"&"+renderResponse.getNamespace()
	+"projType="+dic.getDictionaryId()%>'			
			 iconCssClass="icon-file" label="<%=dic.getName()%>"/>
			<%
			}
		%>
		</aui:nav-item>
				
		<%-- <aui:nav-item dropdown="true" iconCssClass="icon-plus" label="添加">
			<c:forEach items="<%=dictionaries%>" var="dictionary">
			<c:if test='${dictionary.name eq "航道"}'><c:set var="pageType" value="true"/></c:if>	
			<aui:nav-item   href='${addConstructionPermitURL}&${namespace}pageType=${pageType}&
			${namespace}projTypeName=${dictionary.name}&${namespace}projType=${dictionary.dictionaryId}'			
			 iconCssClass="icon-file" label="${dictionary.name}"/>
			<c:set var="pageType" value="false"/>
			</c:forEach> 
		</aui:nav-item> --%>

		</aui:nav>
		<aui:nav>
		<aui:nav-item dropdown="true" label="按状态查询">
		<c:forEach items="<%=consPerStaQueryDics%>" var="consPerStaQuery">
			<aui:nav-item   href='${viewURL}&${namespace}statusName=${consPerStaQuery.name}'			
				 iconCssClass="icon-file" label="${consPerStaQuery.name}"/>			
		</c:forEach>
		</aui:nav-item>
		
		</aui:nav>
		
		<aui:nav-bar-search cssClass="pull-right">
			<div class="form-search">
				<liferay-ui:input-search />
			</div>
		</aui:nav-bar-search>
	</aui:nav-bar>
	
<!-- 删除功能 -->	
	<aui:button-row>
		<aui:button disabled="true" name="deleteConstructionPermitsBtn" value="删除" onClick='<%=renderResponse.getNamespace() + "deleteDictionaries();"%>' />
	</aui:button-row> 
	
<!-- 页面展示 -->

	<liferay-ui:search-container emptyResultsMessage="没有找到代码。"  rowChecker="<%=new RowChecker(renderResponse)%>">
		<liferay-ui:search-container-results results="${constructionPermits}"
			total="${constructionPermitsCount}">
		</liferay-ui:search-container-results>
		<liferay-ui:search-container-row className="com.justonetech.projApproval.model.ConstructionPermit" modelVar="constructionPermit" keyProperty="constructionPermitId" >
			
			<%-- <liferay-portlet:renderURL varImpl="rowURL">
				<portlet:param name="parentId" value="${dictionary.dictionaryId}" />
			</liferay-portlet:renderURL> --%>
			
			<liferay-ui:search-container-column-text property="businessCode" name="业务编码" href="${rowURL}"/>
			<liferay-ui:search-container-column-text property="constructionCode" name="报建编号" href="${rowURL}"/>
			<liferay-ui:search-container-column-text property="projName" name="项目名称" href="${rowURL}"/>
			<liferay-ui:search-container-column-text property="projTypeStr" name="项目类型" href="${rowURL}"/>
			<liferay-ui:search-container-column-text property="company" name="建设单位" href="${rowURL}"/>
			<liferay-ui:search-container-column-text>
				<liferay-ui:icon-menu>
					<portlet:actionURL var="editConstructionPermitURL" name="editConstructionPermit">
						<portlet:param name="constructionPermitId" value="${constructionPermit.constructionPermitId}" />
						<portlet:param name="mvcPath" value="${contentPath }/edit.jsp" />
					</portlet:actionURL>
					<portlet:actionURL var="viewConstructionPermitURL" name="viewConstructionPermit">
						<portlet:param name="constructionPermitId" value="${constructionPermit.constructionPermitId}" />
						<portlet:param name="mvcPath" value="${contentPath }/view.jsp" />
					</portlet:actionURL>
					<liferay-ui:icon image="view" label="查看" url="${viewConstructionPermitURL}" />
					<liferay-ui:icon image="edit" label="编辑" url="${editConstructionPermitURL}" />
					<liferay-ui:icon image="delete" label="删除" url="javascript:void(0);" onClick='<%=renderResponse.getNamespace() + "deleteConstructionPermits("+constructionPermit.getConstructionPermitId()+");"%>' />
				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator>
		</liferay-ui:search-iterator>
	</liferay-ui:search-container>
	
</aui:form>	
	
	
<aui:script>
	
	Liferay.Util.toggleSearchContainerButton('#<portlet:namespace />deleteConstructionPermitsBtn', '#<portlet:namespace /><%=searchContainerReference.getId("searchContainer")%>SearchContainer', document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
	
	Liferay.provide(
			window,
			'<portlet:namespace />deleteConstructionPermits',
			function(constructionPermitIds) {
				if(confirm("确定要删除所选数据吗？")){
					if(!constructionPermitIds){
						constructionPermitIds = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
					}
					location.href="<%=deleteConstructionPermitsURL%>&<portlet:namespace />constructionPermitIds="+ constructionPermitIds;
				}
			},
			['liferay-util-list-fields']
		);
</aui:script>