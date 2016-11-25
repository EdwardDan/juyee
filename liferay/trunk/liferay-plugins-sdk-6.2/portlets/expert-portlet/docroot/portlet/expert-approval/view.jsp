<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>

<c:set var="contextPath" value="${request.contextPath}/portlet/expert-approval" />

<style>
.aui .navbar .btn{
margin-top:0px;
}

 .aui .container-fluid{
margin-top:9px;
}
</style>
<portlet:renderURL var="viewExpertURL" />
<aui:form  action="${viewExpertURL}" name="fm">
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
				关键字:<input name="<portlet:namespace/>keyword"  class="input-medium" type="text" value="${keyword}" style="width:300px" placeholder="请输入姓名、职称、执业资格或从事专业查询"/>&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="submit" >搜索</button>
		</div>
	</div>
</div>


<liferay-ui:search-container emptyResultsMessage="没有找到专家审批信息"  rowChecker="<%=new RowChecker(renderResponse)%>">
		<liferay-ui:search-container-results results="${list}"
			total="${zysqlbsCount}">
		</liferay-ui:search-container-results>
		<liferay-ui:search-container-row className="java.util.Map" modelVar="map" keyProperty="">
			
			<!-- 点击姓名时跳转的页面 -->
			<liferay-portlet:renderURL varImpl="rowURL">
				<portlet:param name="zysqlbId" value="${map.zysqlbId}" />
				<portlet:param name="mvcPath" value="${contextPath}/viewDetail.jsp" />
			</liferay-portlet:renderURL> 

			<liferay-ui:search-container-column-text  name="姓名" href="${rowURL}">
			${map.name}
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text   name="性别" >
			${map.sex}
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text  name="申请事项" >
			${map.sx}
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text  name="申请专业" >
			${map.zy}
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text  name="状态" >
			${map.zt}
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text>
				<liferay-ui:icon-menu>
				
					<!--查看的页面  -->
					<portlet:actionURL var="viewURL" name="viewZysqlb">
						<portlet:param name="zysqlbId" value="${map.zysqlbId}" />
						<portlet:param name="mvcPath" value="${contextPath }/viewDetail.jsp" />
					</portlet:actionURL>
					
					<!--审核的页面  -->
					 <portlet:renderURL var="approvalURL" windowState="pop_up">
   						<portlet:param name="zysqlbId" value="${map.zysqlbId}"/>
   						<portlet:param name="mvcPath" value="${contextPath }/expertApproval.jsp" />
					</portlet:renderURL>
					<liferay-ui:icon image="view" label="查看" url="${viewURL}" />
					<liferay-ui:icon image="checked" label="审批" url="javascript:void(0);" onClick="newWindow('${approvalURL}');" />
				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator>
			<% PortletURL portletURL = searchContainer.getIteratorURL();
			String keyword = ParamUtil.getString(request, "keyword");
			portletURL.setParameter("keyword", keyword);
			%>
		</liferay-ui:search-iterator>
	</liferay-ui:search-container>
</aui:form>	

<aui:script use="liferay-util-window">
Liferay.provide(window, 'newWindow', function(url) {		
	var instance = this;
	Liferay.Util.openWindow({
		dialog : {
			centered: true,
			height: 800,
			modal: true,
			width: 800
		},
		id: '<portlet:namespace/>dialog',
		title : '专家审核',
		uri : url,
		destroyOnClose : true
	});
}, [ 'aui-dialog' ]);


Liferay.provide(window,'closeYourPopUp',
        function(dialogId) {
            var A = AUI();
            var dialog = Liferay.Util.Window.getById(dialogId);
            dialog.destroy();
        },
        ['liferay-util-window']
);


</aui:script>
