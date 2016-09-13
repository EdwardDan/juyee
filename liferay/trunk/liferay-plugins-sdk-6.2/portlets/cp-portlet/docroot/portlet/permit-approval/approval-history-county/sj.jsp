<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="../init.jsp"%>
<style type="text/css">
table {
	width: 100%
}

tr.body td.title {
	width: 20%;
	text-align: right;
}

tr.body td.content {
	width: 30%;
	background-color: white;
}
</style>
<%
	long permitId = ParamUtil.getLong(request, "permitId");
	request.setAttribute("permitId", permitId);
	Permit permit = PermitLocalServiceUtil.getPermit(permitId);
	request.setAttribute("permit", permit);
	
%>
<table class="table table-bordered">
	<tr class="body">
		<td class="title">受理编号</td>
		<td class="content">${permit.slbh}</td>
		<td class="title">材料提交人</td>
		<td class="content">${permit.cltjr}</td>
	</tr>
	<tr class="body">
		<td class="title">沪交管收字</td>
		<td class="content">字(${permit.hjgsz})第(${permit.hjgsh})号</td>
		<td class="title">联系电话</td>
		<td class="content">${permit.cltjrlxdh}</td>
	</tr>
	<tr class="body">
		<td class="title">申请人</td>
		<td class="content">${permit.sqr}</td>
		<td class="title">联系地址</td>
		<td class="content">${permit.cltjrlxdz}</td>
	</tr>
	<tr class="body">
		<td class="title">申请事项</td>
		<td class="content">${permit.sqsx}</td>
		<td class="title">收件人</td>
		<td class="content">${permit.sjr}</td>
	</tr>
	<tr class="body">
		<td class="title">申请号</td>
		<td class="content">${permit.sqh}</td>
		<td class="title">联系电话</td>
		<td class="content">${permit.sjrlxdh}</td>
	</tr>
</table>
<aui:button-row cssClass="text-center">
	<aui:button type="cancel" value="关闭" href="#" />
</aui:button-row>