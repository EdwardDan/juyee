<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ page import="com.justonetech.cp.permit.model.UnitProject"%>
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

<portlet:actionURL var="saveUnitProjects" name="saveUnitProjects">
</portlet:actionURL>
<aui:form action="" onSubmit="false">
	<table border="1" width="100%" class="table table-bordered table-hover">
		<tr height="29px">
			<td style="width: 15%; text-align: center">单位工程编号</td>
			<td style="width: 15%; text-align: center">单位工程名称</td>
			<td style="width: 15%; text-align: center">单位工程类别</td>
			<td style="width: 45%; text-align: center">建设内容</td>
			<td style="width: 10%; text-align: center"><input type="button" value="添加" class="btn" style="width: 100%;" onclick="changeLine(this)" /></td>
		</tr>
		<tbody id="unitProjects">
			<c:if test="${!empty unitProjects}">
				<c:forEach items="${unitProjects}" var="unitProject">
					<tr>
						<td style="width: 15%; text-align: center"><input name="<portlet:namespace/>gcbh" value="${unitProject.gcbh}" readonly="true" /></td>
						<td style="width: 15%; text-align: center"><input name="<portlet:namespace/>gcmc" value="${unitProject.gcmc}" /></td>
						<td style="width: 15%; text-align: center"><input name="<portlet:namespace/>gcmc" value="${unitProject.gclb}" /></td>
						<td style="width: 45%; text-align: center"><input name="<portlet:namespace/>jsnr" value="${unitProject.jsnr}" /></td>
						<td style="width: 10%; text-align: center"><input type="button" class="btn" value="删除" onclick="changeLine(this)" style="width: 100%;" /></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	<table style="display: none;" border="1" width="90%">
		<tbody id="hiddenStyle">
			<tr>
				<td style="width: 15%; text-align: center"><input name="<portlet:namespace/>gcbh" readonly="true"></td>
				<td style="width: 15%; text-align: center"><input name="<portlet:namespace/>gcmc"></td>
				<td style="width: 15%; text-align: center"><input name="<portlet:namespace/>gclb"></td>
				<td style="width: 45%; text-align: center"><input name="<portlet:namespace/>jsnr"></td>
				<td style="width: 10%; text-align: center"><input type="button" class="btn" value="删除" onclick="changeLine(this)" style="width: 100%;" /></td>
			</tr>
		</tbody>
	</table>
	<aui:button-row>
		<aui:button type="submit" value="保存"/>
		<aui:button type="cancel" value="取消" href="#" />
	</aui:button-row>

	<div>注释：单位工程名称请参考规划许可证内容填写</div>

</aui:form>
<script>
	function changeLine(obj) {
		if (obj.value == "添加") {
			$("#unitProjects").append($("#hiddenStyle").html());
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
		} else {
			if (confirm("确定要删除吗？")) {
				var trObj = obj.parentNode.parentNode;
				trObj.parentElement.removeChild(trObj);
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
		}
	}
</script>