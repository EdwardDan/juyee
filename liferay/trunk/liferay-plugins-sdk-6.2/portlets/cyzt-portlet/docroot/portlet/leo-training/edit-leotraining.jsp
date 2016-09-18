<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<portlet:renderURL var="viewURL" />
<portlet:actionURL var="saveLeoTrainingsURL" name="saveLEOTrainings">
	<portlet:param name="redirect" value="${viewURL }" />
</portlet:actionURL>
<style>
.divAccordion-inner {
	padding: 9px 15px;
}

.table tr td input {
	width: 100%;
	height: 28px;
	color: #8B8B83;
	border: #D4D4D4 1px solid;
}
</style>
<%
	String certificateId = ParamUtil.getString(renderRequest, "certificateId");
List<LEOTraining> leoTrainings=LEOTrainingLocalServiceUtil.findByZjbh(certificateId,-1,-1);
LEOCertificate lEOCertificate=LEOCertificateLocalServiceUtil.getLEOCertificate(certificateId);
request.setAttribute("leoTrainings", leoTrainings);
request.setAttribute("lEOCertificate", lEOCertificate);
%>
<aui:form action="${saveLeoTrainingsURL }">
	<aui:input name="certificateId" type="hidden"
		value="<%=certificateId%>" />
	<div class="divAccordion-inner">
		<aui:row>
			<aui:col span="12">
				<input type="button" value="添加" class="btn" style=""
					onclick="${renderResponse.namespace}changeLine(this)" />
				<input type="button" value="删除" class="btn" style=""
					onclick="${renderResponse.namespace}changeLine(this)" />

			</aui:col>
		</aui:row>
	</div>
	<div class="accordion-inner">
		<table border="1" width="100%"
			class="table table-bordered table-hover">
			<tr height="29px">
				<td style="width: 2%; text-align: center"></td>
				<td style="width: 15%; text-align: center">姓名</td>
				<td style="width: 20%; text-align: center">培训时间</td>
				<td style="width: 20%; text-align: center">下次教育时间</td>
				<td style="width: 43%; text-align: center">培训内容</td>
			</tr>

			<tbody id="leoTrainings">
				<c:if test="${!empty leoTrainings}">
					<c:forEach items="${leoTrainings}" var="leoTraining">
						<tr height="29px">
							<td style="width: 2%; text-align: center"><input
								type="checkbox" name="<portlet:namespace/>isDelete" /></td>
							<td style="width: 15%; text-align: center">${lEOCertificate.xm }</td>
							<td style="width: 20%; text-align: center"><input
								style="width: 98%" name="<portlet:namespace/>pxsj" id="pxsj"
								class="Wdate"
								value="<fmt:formatDate value='${leoTraining.pxsj }' pattern='yyyy-MM-dd'/>"
								onfocus="WdatePicker({pxsj,lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" /></td>
							<td style="width: 20%; text-align: center"><input
								style="width: 95%" name="<portlet:namespace/>xcjysj" id="xcjysj"
								class="Wdate"
								value="<fmt:formatDate value='${leoTraining.xcjysj }' pattern='yyyy-MM-dd'/>"
								onfocus="WdatePicker({xcjysj,lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"></td>
							<td style="width: 43%; text-align: center"><aui:input
									style="width: 95%" name="pxnr" label="" type="textarea"
									value="${leoTraining.pxnr }">
								</aui:input></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>

	<aui:button-row>
		<div style="text-align: center">
			<aui:button type="submit" value="保存" />
			<aui:button type="cancel" value="返回" href="${viewURL}" />
		</div>
	</aui:button-row>

</aui:form>
<table style="display: none;" border="1">
	<tbody id="hiddenStyle">
		<tr height="29px">
			<td style="width: 2%; text-align: center"><input type="checkbox"
				name="<portlet:namespace/>isDelete" /></td>
			<td style="width: 15%; text-align: center">${lEOCertificate.xm }</td>
			<td style="width: 20%; text-align: center"><input
				style="width: 95%" name="<portlet:namespace/>pxsj" id="pxsj"
				value="" class="Wdate"
				onfocus="WdatePicker({pxsj,lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" /></td>
			<td style="width: 20%; text-align: center"><input
				style="width: 95%" name="<portlet:namespace/>xcjysj" id="xcjysj"
				value="" class="Wdate"
				onfocus="WdatePicker({xcjysj,lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" />
			</td>
			<td style="width: 43%; text-align: center"><aui:input
					type="textarea" style="width: 95%" name="pxnr" label="" value="">
				</aui:input></td>
		</tr>
	</tbody>
</table>
<script>
	function <portlet:namespace/>changeLine(obj) {
		if (obj.value == "添加") {
			$("#leoTrainings").append($("#hiddenStyle").html());
		} else {
			if (confirm("确定要删除吗？")) {
				$("input[name='<portlet:namespace/>isDelete']").each(
						function() {
							if (this.checked) {
								$(this).parent().parent().remove();
							}
						});
			}
		}
	}
</script>