<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ page import="com.justonetech.cp.permit.model.UnitProject"%>

<style>
 .divAccordion-inner {
	padding: 9px 15px;
} 
</style>
<%
	String bjbh = ParamUtil.getString(request, "bjbh");

	Long permitId = ParamUtil.getLong(request, "permitId");
	System.out.println("bjbh=" + bjbh + " permitId=" + permitId);
	ProjectProfile projectProfile = null;
	Project project = null;
	if (permitId != 0) {
		projectProfile = ProjectProfileLocalServiceUtil
		.getProjectProfile(permitId);
		request.setAttribute("projectProfile", projectProfile);
	} else {
		if (Validator.isNotNull(bjbh)) {
	project = ProjectLocalServiceUtil.getProject(bjbh);
	request.setAttribute("project", project);
		}
	}
%>
<portlet:actionURL var="saveUnitProjects" name="saveUnitProjects">
</portlet:actionURL>
<aui:form action="" onSubmit="false">
	<div class="divAccordion-inner">
		<aui:row>
			<aui:col span="12">
				<input type="button" value="添加" class="btn" style=""
					onclick="changeLine(this)" />
			</aui:col>
		</aui:row>
	</div> 
	<div class="accordion-inner">
		<table border="1" width="100%"
			class="table table-bordered table-hover">
			<tr height="29px">
		<!-- 		<td style="width: 10%; text-align: center"><input type="button"
					value="添加" class="btn" style="" onclick="changeLine(this)" /></td> -->
				<td style="width: 30%; text-align: center">单位名称</td>
				<td style="width: 13%; text-align: center">单位类型</td>
				<td style="width: 10%; text-align: center">项目负责人</td>
				<td style="width: 12%; text-align: center">证件类型</td>
				<td style="width: 20%; text-align: center">证件号</td>
				<td style="width: 10%; text-align: center">手机号</td>
				<!-- <td style="width: 10%; text-align: center">操作</td> -->
			</tr>
		<!-- 	<tr height="29px">
				<td style="width: 10%; text-align: center"><input type="button"
					value="添加" class="btn" style="" onclick="changeLine(this)" /></td>
				<td style="width: 20%; text-align: center">单位名称是是是是是是是是是是是是是</td>
				<td style="width: 15%; text-align: center">单位类型</td>
				<td style="width: 15%; text-align: center">黄家辉事</td>
				<td style="width: 15%; text-align: center">证件类型</td>
				<td style="width: 20%; text-align: center">22222222222222222</td>
				<td style="width: 10%; text-align: center">13127667037</td>
				<td style="width: 10%; text-align: center">操作</td>
			</tr> -->

			<tbody id="unitProjects">
				<c:if test="${!empty unitProjects}">
					<c:forEach items="${unitProjects}" var="unitProject">
						<tr>
							<td style="width: 15%; text-align: center"><input
								name="<portlet:namespace/>gcbh" value="" readonly="true" /></td>
							<td style="width: 15%; text-align: center"><input
								name="<portlet:namespace/>gcmc" value="" /></td>
							<td style="width: 15%; text-align: center"><input
								name="<portlet:namespace/>gcmc" value="" /></td>
							<td style="width: 45%; text-align: center"><input
								name="<portlet:namespace/>jsnr" value="" /></td>
							<td style="width: 10%; text-align: center"><input
								type="button" class="btn" value="删除" onclick="changeLine(this)"
								style="width: 100%;" /></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
	<table style="display: none;" border="1" width="90%">
		<tbody id="hiddenStyle">
			<tr>
				<td style="width: 10%; text-align: center"><input type="button"
					class="btn" value="删除" onclick="changeLine(this)"
					style="width: 100%;" /></td>
				<td style="width: 15%; text-align: center"><input
					name="<portlet:namespace/>gcbh" readonly="true"></td>
				<td style="width: 15%; text-align: center"><input
					name="<portlet:namespace/>gcmc"></td>
				<td style="width: 15%; text-align: center"><input
					name="<portlet:namespace/>gclb"></td>
				<td style="width: 35%; text-align: center"><input
					name="<portlet:namespace/>jsnr"></td>
				<td style="width: 10%; text-align: center"><input
					name="<portlet:namespace/>jsnr"></td>

			</tr>
		</tbody>
	</table>
	<aui:button-row>
		<aui:button type="submit" value="保存" />
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
				var gcbhs = document
						.getElementsByName("<portlet:namespace/>gcbh");
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