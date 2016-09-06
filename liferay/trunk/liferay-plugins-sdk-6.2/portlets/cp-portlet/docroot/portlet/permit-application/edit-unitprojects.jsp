<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.justonetech.cp.permit.model.UnitProject"%>
<%@ page import="com.justonetech.cp.permit.service.UnitProjectLocalServiceUtil"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<portlet:actionURL var="saveUnitProjectsURL" name="saveUnitProjects">
	<portlet:param name="redirectURL" value="${editPermitURL }"/>
</portlet:actionURL>
<%
	Long permitId = ParamUtil.getLong(request, "permitId");
	List<UnitProject> unitProjects = UnitProjectLocalServiceUtil.findByPermitId(permitId, -1, -1);
	renderRequest.setAttribute("unitProjects", unitProjects);
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
</style>
<aui:form action="${saveUnitProjectsURL}">
	<aui:input name="bjbh" value="${bjbh }" type="hidden"></aui:input>
	<aui:input name="permitId" value="<%=permitId %>" type="hidden"></aui:input>
	<table border="1" width="100%" class="table table-bordered table-hover">
		<tr height="29px">
			<td style="width: 10%; text-align: center">单位工程编号</td>
			<td style="width: 20%; text-align: center">单位工程名称</td>
			<td style="width: 65%; text-align: center">建设内容</td>
			<td style="width: 5%; text-align: center"><input type="button" value="添加" class="btn" style="width: 100%;" onclick="${renderResponse.namespace}changeLine(this)" /></td>
		</tr>
		<tbody id="unitProjects">
			<c:if test="${!empty unitProjects}">
				<c:forEach items="<%=unitProjects%>" var="unitProject">
					<tr>
						<td><input name="<portlet:namespace/>gcbh" value="${unitProject.gcbh}" readonly="true" /></td>
						<td><input name="<portlet:namespace/>gcmc" value="${unitProject.gcmc}" /></td>
						<td><input name="<portlet:namespace/>jsnr" value="${unitProject.jsnr}" /></td>
						<td><input type="button" class="btn" value="删除" onclick="${renderResponse.namespace}changeLine(this)" style="width: 100%;" /></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	<table style="display: none;" border="1" width="90%">
		<tbody id="hiddenStyle">
			<tr>
				<td><input name="<portlet:namespace/>gcbh" readonly="true"></td>
				<td><input name="<portlet:namespace/>gcmc"></td>
				<td><input name="<portlet:namespace/>jsnr"></td>
				<td><input type="button" class="btn" value="删除" onclick="${renderResponse.namespace}changeLine(this)" style="width: 100%;" /></td>
			</tr>
		</tbody>
	</table>
	<aui:button-row>
		<span style="position: relative; left: 45%"> <aui:button type="submit" value="保存" /> <aui:button type="cancel" value="取消" href="#" />
		</span>
	</aui:button-row>

	<div>注释：单位工程名称请参考规划许可证内容填写</div>

</aui:form>
<script>
	function <portlet:namespace/>changeLine(obj) {
		if (obj.value == "添加") {
			$("#unitProjects").append($("#hiddenStyle").html());
			setGcbh();
		} else {
			if (confirm("确定要删除吗？")) {
				var trObj = obj.parentNode.parentNode;
				trObj.parentElement.removeChild(trObj);
				setGcbh();
			}
		}
	}

	function setGcbh() {
		var gcbhs = document.getElementsByName("<portlet:namespace/>gcbh");
		for (var i = 1; i < gcbhs.length; i++) {
			if (i.toString().length == 1) {
				gcbhs[i - 1].value = "D00" + i;
			} else if (i.toString().length == 2) {
				gcbhs[i - 1].value = "D0" + i;
			} else if (i.toString().length == 3) {
				gcbhs[i - 1].value = "D" + i;
			} else {
				alert("超出工程编号范围！");
			}
		}
	}
</script>