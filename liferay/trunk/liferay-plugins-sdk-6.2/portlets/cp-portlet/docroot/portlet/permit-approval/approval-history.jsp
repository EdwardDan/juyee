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
	value="${request.contextPath}/portlet/permit-approval/approval-history-city" />
<portlet:renderURL var="ysURL">
	<portlet:param name="mvcPath" value="${contextPath}/ys.jsp" />
</portlet:renderURL>
<portlet:renderURL var="sjURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/sj.jsp" />
</portlet:renderURL>
<portlet:renderURL var="csURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/cs.jsp" />
</portlet:renderURL>
<portlet:renderURL var="fhURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/fh.jsp" />
</portlet:renderURL>
<portlet:renderURL var="shURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/sh.jsp" />
</portlet:renderURL>
历史审核步骤
<table border="1" style="width: 100% ；text-align:center;">
	<tr>
		<td>审核步骤</td>
		<td>审核意见</td>
		<td>审核人</td>
		<td>审核时间</td>
	</tr>
	<tr>
		<td>预审/td>
		<td>材料符合要求，审核通过</td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td><a onclick="sj()">收件</a></td>
		<td><a onclick="sj()"></a></td>
		<td><a onclick="sj()"></a></td>
		<td><a onclick="sj()"></a></td>
	</tr>
	<tr>
		<td><a onclick="cs()">初审</a></td>
		<td><a onclick="cs()"></a></td>
		<td><a onclick="cs()"></a></td>
		<td><a onclick="cs()"></a></td>
	</tr>
	<tr>
		<td><a onclick="fh()">复核</a></td>
		<td><a onclick="fh()"></a></td>
		<td><a onclick="fh()"></a></td>
		<td><a onclick="fh()"></a></td>
	</tr>
	<tr>
		<td><a onclick="sh()">审核</a></td>
		<td><a onclick="sh()"></a></td>
		<td><a onclick="sh()"></a></td>
		<td><a onclick="sh()"></a></td>
	</tr>
	<tr>
		<td>分管领导审核</td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td>中心领导审核</td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td>委建设处审核</td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td>委审批处审核</td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td>委领导审核</td>
		<td></td>
		<td></td>
		<td></td>
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
	Liferay.provide(window, 'cs', function() {
		Liferay.Util.openWindow({
			dialog : {
				centered : true,
				width : 800,
				height : 600
			},
			id : 'popup',
			title : '初审',
			uri : '${csURL}',
			destroyOnClose : true
		});
	}, [ 'aui-dialog' ]);
	Liferay.provide(window, 'fh', function() {
		Liferay.Util.openWindow({
			dialog : {
				centered : true,
				width : 800,
				height : 600
			},
			id : 'popup',
			title : '复核',
			uri : '${fhURL}',
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
</script>
