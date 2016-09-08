<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="../init.jsp"%>
<%
	List<ApplyMaterial> applyMaterials = ApplyMaterialLocalServiceUtil.getApplyMaterials(-1, -1);
	request.setAttribute("applyMaterials", applyMaterials);
	int num = 1;
%>

<aui:form>
	<div class="text-center">
		<table style="width: 98%" border="1">
			<tr>
				<td width="5%">序号</td>
				<td width="30%">材料提交名称</td>
				<td width="45%">审核要求</td>
				<td width="10%">初审意见</td>
				<td width="10%">复核意见</td>
			</tr>
			<tbody id="applyMaterials">
				<c:if test="${!empty applyMaterials}">
					<c:forEach items="<%=applyMaterials%>" var="applyMaterial">
						<tr>
							<td><%=String.valueOf(num)%></td>
							<td>${applyMaterial.clmc}</td>
							<td>${applyMaterial.shyq}</td>
							<td><aui:select name="csyj" label="" cssClass="span11">
									<aui:option>符合</aui:option>
									<aui:option>不符合</aui:option>
								</aui:select></td>
							<td><aui:select name="fhyj" label="" cssClass="span11">
									<aui:option>符合</aui:option>
									<aui:option>不符合</aui:option>
								</aui:select></td>
						</tr>
						<%
							num++;
						%>
					</c:forEach>
				</c:if>
			</tbody>

		</table>

		<div>
			审核意见：
			<textarea rows="3" name="shyj" style="width: 70%; margin-bottom: 15px; margin-top: 15px"></textarea>
		</div>
		<div>
			<div class="btn-group">
				<aui:button name="pass" value="审核通过" cssClass="btn" />
			</div>
			<div class="btn-group">
				<aui:button name="close" value="关闭" cssClass="btn" href="${viewURL}" />
			</div>
		</div>
	</div>
</aui:form>