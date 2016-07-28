<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contentPath" value="${request.contextPath}/portlet/bidding" />
<%
	long projectId = ParamUtil.getLong(request, "projectId"); 
	List<Bidding> biddings = null;
	int biddingsCount = 0;
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
	<portlet:param name="mvcPath" value="${contentPath }/viewBidding.jsp" />
</portlet:actionURL>
<portlet:actionURL var="addBiddingURL" name="editBidding">
	<portlet:param name="projectId" value="${projectId}" />
	<portlet:param name="mvcPath" value="${contentPath }/edit-bidding.jsp" />
</portlet:actionURL>
<portlet:actionURL var="deleteBiddingsURL" name="deleteBiddings">
	<portlet:param name="projectId" value="${projectId}" />
	<portlet:param name="mvcPath" value="${contentPath }/view-bidding.jsp" />
</portlet:actionURL>
<liferay-ui:header title="标段维护" backURL="${viewURL}" />
<aui:form action="${doViewBidding }" name="fm">
	<aui:nav-bar>
		<aui:nav>
			<aui:nav-item href="<%=addBiddingURL%>" iconCssClass="icon-plus"
				label="添加" />
		</aui:nav>
		<aui:nav-bar-search cssClass="pull-right">
			<div class="form-search">
				<liferay-ui:input-search />
			</div>
		</aui:nav-bar-search>
	</aui:nav-bar>
	<aui:button-row>
		<aui:button disabled="<%=true%>" name="deleteBiddingsBtn" value="删除"
			onClick='<%=renderResponse.getNamespace() + "deleteBiddings();"%>' />
	</aui:button-row>
	<liferay-ui:search-container emptyResultsMessage="没有找到项目。"
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
					value="${contentPath }/view-bidding-detail.jsp" />
			</portlet:actionURL>
			<portlet:actionURL var="deleteURL" name="deleteBiddings">
				<portlet:param name="biddingIds" value="${bidding.biddingId}" />
				<portlet:param name="redirect" value="${contentPath }/view-bidding.jsp" />
			</portlet:actionURL>
			<portlet:actionURL var="editURL" name="editBidding"> 
				<portlet:param name="biddingId" value="${bidding.biddingId}" />
				<portlet:param name="mvcPath" value="${contentPath }/edit-bidding.jsp" />
			</portlet:actionURL>
			<liferay-ui:icon-menu>
				<liferay-ui:icon image="view" url="${view}" />
				<liferay-ui:icon image="edit" url="${editURL}" />
				<liferay-ui:icon image="delete" label="删除" url="javascript:void(0);" onClick='<%=renderResponse.getNamespace() + "deleteBiddings("+bidding.getBiddingId()+");"%>'/>
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
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
	





















































































