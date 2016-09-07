<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="../init.jsp"%>
审核
<table border="1" style="width: 100%">
	<tr>
		<td class="title">序号</td>
		<td class="content">提交材料名称</td>
		<td class="title">审核要求</td>
		<td class="content">初审意见</td>
		<td class="content">复核意见</td>
		<td class="content">审核意见</td>
	</tr>
	<c:forEach items="">
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</c:forEach>
	<tr>
		<td class="title">审核意见：</td>
		<td class="content" colspan="5"></td>
	</tr>
</table>