<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="../init.jsp"%>
<style type="text/css">
	table{
		text-align: center;
	}
</style>
<table border="1" style="width: 100%">
	<tr>
		<td class="title">序号</td>
		<td class="content">提交材料名称</td>
		<td class="title">审核要求</td>
		<td class="content">受理意见</td>
	</tr>
	<c:forEach items="">
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</c:forEach>
	<tr>
		<td class="title">受理意见</td>
		<td class="content" colspan="3"></td>
	</tr>
</table>
<aui:button-row cssClass="text-center">
	<aui:button type="cancel" value="关闭" href="#" />
</aui:button-row>