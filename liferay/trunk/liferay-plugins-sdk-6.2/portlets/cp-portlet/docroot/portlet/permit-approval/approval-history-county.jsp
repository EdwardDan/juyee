<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<style type="text/css">
	a{
		cursor: pointer;
	}
	table{
		width:100%;
		text-align:center;
	}
</style>
<c:set var="contextPath"
	value="${request.contextPath}/portlet/permit-approval/approval-history-county" />
<portlet:renderURL var="sjURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/sj.jsp" />
</portlet:renderURL>
<portlet:renderURL var="slURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/sl.jsp" />
</portlet:renderURL>
<portlet:renderURL var="shURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/sh.jsp" />
</portlet:renderURL>
<portlet:renderURL var="spURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/sp.jsp" />
</portlet:renderURL>
<table class="table table-bordered table-hover" style="width: 100% ；text-align:center;">
	<tr>
		<td>审核步骤</td>
		<td>审核意见</td>
		<td>审核人</td>
		<td>审核时间</td>
	</tr>
	<tr>
		<td><a onclick="sj()">收件</a></td>
		<td><a onclick="sj()"></a></td>
		<td><a onclick="sj()"></a></td>
		<td><a onclick="sj()"></a></td>
	</tr>
	<tr>
		<td><a onclick="sl()">受理</a></td>
		<td><a onclick="sl()"></a></td>
		<td><a onclick="sl()"></a></td>
		<td><a onclick="sl()"></a></td>
	</tr>
	<tr>
		<td><a onclick="sh()">审核</a></td>
		<td><a onclick="sh()"></a></td>
		<td><a onclick="sh()"></a></td>
		<td><a onclick="sh()"></a></td>
	</tr>
	<tr>
		<td><a onclick="sp()">审批</a></td>
		<td><a onclick="sp()"></a></td>
		<td><a onclick="sp()"></a></td>
		<td><a onclick="sp()"></a></td>
	</tr>
</table>
<script>
	Liferay.provide(window, 'sj', function() {
		Liferay.Util.openWindow({
			dialog : {
				centered : true,
				width : 800,
				height : 600
			},
			id : 'popup',
			title : '收件',
			uri : '${sjURL}',
			destroyOnClose : true
		});
	}, [ 'aui-dialog' ]);
	Liferay.provide(window, 'sl', function() {
		Liferay.Util.openWindow({
			dialog : {
				centered : true,
				width : 800,
				height : 600
			},
			id : 'popup',
			title : '受理',
			uri : '${slURL}',
			destroyOnClose : true
		});
	}, [ 'aui-dialog' ]);
	Liferay.provide(window, 'sh', function() {
		Liferay.Util.openWindow({
			dialog : {
				centered : true,
				width : 800,
				height : 600
			},
			id : 'popup',
			title : '审核',
			uri : '${shURL}',
			destroyOnClose : true
		});
	}, [ 'aui-dialog' ]);
	Liferay.provide(window, 'sp', function() {
		Liferay.Util.openWindow({
			dialog : {
				centered : true,
				width : 800,
				height : 600
			},
			id : 'popup',
			title : '审批',
			uri : '${spURL}',
			destroyOnClose : true
		});
	}, [ 'aui-dialog' ]);
</script>