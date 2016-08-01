<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contextPath" value="${request.contextPath}/portlet/bidding" />
<%
	long projectId = ParamUtil.getLong(request, "projectId"); 
	List<Bidding> biddings = null;
	int biddingsCount = 0;
	int delta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
    int pageSize = ParamUtil.getInteger(renderRequest, "delta", delta);
    int pageNumber = ParamUtil.getInteger(renderRequest, "cur", 1);
    int start = pageSize * (pageNumber - 1);
    int end = pageSize * pageNumber;
	if (Validator.isNotNull(projectId)) {
		biddings = BiddingLocalServiceUtil.findByProjectId(projectId);
		biddingsCount = biddings.size();
	}
	request.setAttribute("biddings", biddings);
	request.setAttribute("projectId", projectId);
	request.setAttribute("biddingsCount", biddingsCount);
%>
<portlet:renderURL var="viewURL" />
<portlet:actionURL var="doViewBidding" name="doViewBiddings">
	<portlet:param name="projectId" value="${projectId}" />
	<portlet:param name="mvcPath" value="${contextPath }/view-bidding.jsp" />
</portlet:actionURL>
<portlet:actionURL var="addBiddingURL" name="editBidding">
	<portlet:param name="projectId" value="${projectId}" />
	<portlet:param name="mvcPath" value="${contextPath }/edit-bidding.jsp" />
</portlet:actionURL>
<portlet:actionURL var="deleteBiddingsURL" name="deleteBiddings">
	<portlet:param name="projectId" value="${projectId}" />
	<portlet:param name="redirect" value="${doViewBidding}"/>
</portlet:actionURL>
<liferay-ui:header title="标段维护" backURL="${viewURL}" />
<aui:form action="${doViewBidding }" name="fm">
	<aui:row>
		<aui:col span="6">
			<aui:button value="添加" href="${addBiddingURL}" icon="icon-plus" />
			<aui:button disabled="<%=true%>" icon="icon-remove"
				name="deleteBiddingsBtn" value="删除"
				onClick='<%=renderResponse.getNamespace() + "deleteBiddings();"%>' />
		</aui:col>
		<%-- <aui:col span="6" cssClass="text-right">
			<div class="form-search">
			<liferay-ui:input-search />
			</div>
		</aui:col> --%>
	</aui:row>
	<liferay-ui:search-container emptyResultsMessage="没有找到标段信息。"
		rowChecker="<%=new RowChecker (renderResponse)%>">
		<liferay-ui:search-container-results results="${biddings}"
		total="${biddingsCount}" />
	<liferay-ui:search-container-row className="Bidding" modelVar="bidding"
		keyProperty="biddingId">
		<liferay-ui:search-container-column-text name="标段序号"
			property="sortNo" />
		<liferay-ui:search-container-column-text name="标段名称"
			property="bidName" />
		<liferay-ui:search-container-column-text name="建设里程"
			property="buildMileage" />
		<liferay-ui:search-container-column-text name="项目联系人"
			property="projLinkman" />
		<liferay-ui:search-container-column-text name="联系电话"
			property="linkTel" />
		<liferay-ui:search-container-column-text name="开工日期">
			<%=DateUtil.getDate(bidding.getStartDate(), "yyyy-MM-dd", locale, timeZone)%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="action">
			<portlet:actionURL var="view" name="viewBiddingDetail">
				<portlet:param name="biddingId" value="${bidding.biddingId}" />
				<portlet:param name="mvcPath"
					value="${contextPath }/view-bidding-detail.jsp" />
			</portlet:actionURL>
			<portlet:actionURL var="editURL" name="editBidding"> 
				<portlet:param name="biddingId" value="${bidding.biddingId}" />
				<portlet:param name="mvcPath" value="${contextPath }/edit-bidding.jsp" />
			</portlet:actionURL>
			<liferay-ui:icon-menu>
				<liferay-ui:icon image="view" url="${view}" />
				<liferay-ui:icon image="edit" url="${editURL}" />
				<liferay-ui:icon image="delete" label="删除" url="javascript:void(0);" onClick='<%=renderResponse.getNamespace() + "deleteBiddings("+bidding.getBiddingId()+");"%>'/>
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator>
		<%
			String projectIdStr = renderRequest.getAttribute("projectId")+"";
			PortletURL portletURL = searchContainer.getIteratorURL(); 
			searchContainer.getIteratorURL().setParameter("projectId", projectIdStr);
			searchContainer.getIteratorURL().setParameter("mvcPath", "/portlet/bidding/view-bidding.jsp");			
		%>
	</liferay-ui:search-iterator>
	</liferay-ui:search-container>
</aui:form>
<aui:script>
	Liferay.Util.toggleSearchContainerButton('#<portlet:namespace />deleteBiddingsBtn', '#<portlet:namespace /><%=searchContainerReference.getId("searchContainer")%>SearchContainer', document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
	
	Liferay.provide(
			window,
			'<portlet:namespace />deleteBiddings',
			function(biddingIds) {
				if(confirm("确定要删除所选数据吗？")){
					if(!biddingIds){
						biddingIds = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
					}
					location.href="<%=deleteBiddingsURL%>&<portlet:namespace/>biddingIds="+ biddingIds;
				}
			},
			['liferay-util-list-fields']
		);
</aui:script>
	






















































































