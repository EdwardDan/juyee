<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="../init.jsp"%>
<%
	Long completeId = ParamUtil.getLong(request, "completeId");
%>
<style>
.table tr td input {
	width: 100%;
	height: 28px;
	color: #8B8B83;
	border: #D4D4D4 1px solid;
}

aui:input {
	width: 98%
}
</style>

<table width="100%" class="table table-bordered table-hover">
	<tr height="30px">
		<td style="width: 10%; text-align: center">施工许可证编号</td>
		<td style="width: 10%; text-align: center">单位工程编号</td>
		<td style="width: 20%; text-align: center">单位工程名称</td>
		<td style="width: 65%; text-align: center">建设内容</td>
	</tr>
	<tbody id="unitProjects">

	</tbody>
</table>




