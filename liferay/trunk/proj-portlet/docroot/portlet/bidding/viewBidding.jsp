<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/init.jsp"%>

<%
	long projectId = ParamUtil.getLong(request, "projectId"); 
if(Validator.isNull(projectId)){
	 projectId=(Long)request.getAttribute("projectId"); 
}
System.out.println("111-------------------------------"+request.getAttribute("projectId"));
List<Bidding> biddings = null;
int biddingsCount = 0;
if (Validator.isNotNull(projectId)) {
	biddings=BiddingLocalServiceUtil.findByProjectId(projectId);
	biddingsCount = BiddingLocalServiceUtil.getBiddingsCount();
}

request.setAttribute("biddings", biddings);
request.setAttribute("projectId", projectId);
request.setAttribute("biddingsCount", biddingsCount);
%>
<c:set var="contentPath" value="${request.contextPath}/portlet/bidding" />
<portlet:renderURL var="viewURL" />
<portlet:actionURL var="doViewBidding" name="doViewBiddings">
	<portlet:param name="projectId" value="${projectId}" />
	<portlet:param name="mvcPath" value="${contentPath }/viewBidding.jsp" />
</portlet:actionURL>
<portlet:renderURL var="addBidding">
	<portlet:param name="projectId" value="${projectId }" />
	<portlet:param name="mvcPath" value="${contentPath }/edit-bidding.jsp" />
</portlet:renderURL>
<portlet:actionURL var="deleteBiddingsURL" name="deleteBiddings">
	<portlet:param name="projectId" value="${projectId}" />
	<portlet:param name="mvcPath" value="${contentPath }/viewBidding.jsp" />
</portlet:actionURL>
<aui:form action="${doViewBidding }" name="fm">
	<aui:nav-bar>
		<aui:nav>
			<aui:nav-item href="<%=addBidding%>" iconCssClass="icon-plus"
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
	<liferay-ui:search-container emptyResultsMessage="没有找到标段。"
		rowChecker="<%=new RowChecker (renderResponse)%>">
		<liferay-ui:search-container-results results="${biddings}"
			total="${biddingsCount}" />
		<liferay-ui:search-container-row className="Bidding"
			modelVar="bidding" keyProperty="biddingId">
			<liferay-ui:search-container-column-text name="标段编号"
				property="bidCode" />
			<liferay-ui:search-container-column-text name="标段名称"
				property="bidName" />
			<liferay-ui:search-container-column-text name="建设里程"
				property="buildMileage" />
			<liferay-ui:search-container-column-text name="涉及区（县）"
				property="involveCounty" />
			<liferay-ui:search-container-column-text name="action">

				<portlet:renderURL var="view">
					<portlet:param name="biddingId" value="${bidding.biddingId}" />
					<portlet:param name="mvcPath"
						value="${contentPath }/view-bidding.jsp" />
				</portlet:renderURL>
				<portlet:actionURL var="delete" name="deleteBiddings">
					<portlet:param name="biddingIds" value="${bidding.biddingId}" />
					<portlet:param name="projectId" value="${projectId}" />
				</portlet:actionURL>
				<portlet:renderURL var="edit">
					<portlet:param name="biddingId" value="${bidding.biddingId}" />
					<portlet:param name="mvcPath"
						value="${contentPath }/edit-bidding.jsp" />
				</portlet:renderURL>
				<liferay-ui:icon-menu>
					<liferay-ui:icon image="view" url="${view}" />
					<liferay-ui:icon image="edit" url="${edit}" />
					<liferay-ui:icon-delete image="delete" url="${delete}" />
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
	




















































