<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="../init.jsp"%>
<style type="text/css">
table {
	text-align: center;
}
</style>
<%
	long permitId = ParamUtil.getLong(request, "permitId");
	request.setAttribute("permitId", permitId);
	List<ApplyMaterial> applyMaterials = ApplyMaterialLocalServiceUtil.findByPermitId(permitId, -1, -1);
	request.setAttribute("applyMaterials", applyMaterials);
	int num = 1;
%>
<table class="table table-bordered table-hover table-striped" style="width: 100%">
	<thead>
		<th style="text-align: center">序号</th>
		<th style="text-align: center">提交材料名称</th>
		<th style="text-align: center">审核要求</th>
		<th style="text-align: center">受理意见</th>
		<th style="text-align: center">审核意见</th>
		<th style="text-align: center">审批意见</th>
	</thead>
	<tbody id="applyMaterials">
		<c:if test="${!empty applyMaterials}">
			<c:forEach items="<%=applyMaterials%>" var="applyMaterial">
				<tr>
					<td><%=String.valueOf(num)%></td>
					<td>${applyMaterial.clmc}</td>
					<td>${applyMaterial.shyq}</td>
					<td>${applyMaterial.csyj}</td>
					<td>${applyMaterial.fhyj}</td>
					<td>${applyMaterial.shyj}</td>
				</tr>
				<%
					num++;
				%>
			</c:forEach>
		</c:if>
	</tbody>
</table>
