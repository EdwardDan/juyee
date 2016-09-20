<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="../init.jsp"%>
<%
	Long completeId = ParamUtil.getLong(request, "completeId");
	List<CompleteUnitProject> completeUnitProjects = CompleteUnitProjectLocalServiceUtil.findByCompleteId(completeId, -1, -1);
	request.setAttribute("completeUnitProjects", completeUnitProjects);
%>

<table width="100%" class="table table-striped table-bordered table-hover">
	<thead>
		<th style="width: 10%; text-align: center">施工许可证编号</th>
		<th style="width: 10%; text-align: center">单位工程编号</th>
		<th style="width: 20%; text-align: center">单位工程名称</th>
		<th style="width: 65%; text-align: center">建设内容</th>
	</thead>
	<tbody id="conpleteUnitProjects">
		<c:if test="${!empty completeUnitProjects}">
			<c:forEach items="<%=completeUnitProjects%>" var="unitProject">
				<tr>
					<td style="width: 10%; text-align: center">${unitProject.sgxkzbh}</td>
					<td style="width: 10%; text-align: center">${unitProject.gcbh}</td>
					<td style="width: 10%; text-align: center">${unitProject.gcmc}</td>
					<td style="width: 10%; text-align: center">${unitProject.jsnr}</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>




