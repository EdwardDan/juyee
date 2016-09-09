<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="../init.jsp"%>
<%
	Long permitId = ParamUtil.getLong(request, "permitId");
	List<UnitProject> unitProjects = UnitProjectLocalServiceUtil.findByPermitId(permitId, -1, -1);
	request.setAttribute("unitProjects", unitProjects);
%>
<style>
.table tr td {
	border: 1px solid #ddd;
}

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
	<tr height="29px">
		<td style="width: 10%; text-align: center">单位工程编号</td>
		<td style="width: 20%; text-align: center">单位工程名称</td>
		<td style="width: 65%; text-align: center">建设内容</td>
	</tr>
	<tbody id="unitProjects">
		<c:if test="${!empty unitProjects}">
			<c:forEach items="<%=unitProjects%>" var="unitProject">
				<tr>
					<td style="width: 10%; text-align: center">${unitProject.gcbh}</td>
					<td style="width: 10%; text-align: center">${unitProject.gcmc}</td>
					<td style="width: 10%; text-align: center">${unitProject.jsnr}</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>




