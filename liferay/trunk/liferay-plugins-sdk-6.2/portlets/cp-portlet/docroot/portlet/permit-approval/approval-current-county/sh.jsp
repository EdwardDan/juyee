<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="../init.jsp"%>
<%
	long permitId = ParamUtil.getLong(request, "permitId");
	request.setAttribute("permitId", permitId);
	List<ApplyMaterial> applyMaterials = ApplyMaterialLocalServiceUtil.findByPermitId(permitId, -1, -1);
	request.setAttribute("applyMaterials", applyMaterials);
	int num = 1;
%>

<portlet:actionURL var="saveFhURL" name="saveFh">
	<portlet:param name="permitId" value="${permitId}" />
</portlet:actionURL>
<aui:form action="${saveFhURL}" method="post">
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
							<td>${applyMaterial.csyj}</td>
							<td><aui:select name="fhyj" label="" cssClass="span11">
									<c:if test="${applyMaterial.fhyj==''}">
										<aui:option value="符合">符合</aui:option>
										<aui:option value="不符合">不符合</aui:option>
									</c:if>
									<c:if test="${applyMaterial.fhyj=='符合'}">
										<aui:option value="符合">符合</aui:option>
										<aui:option value="不符合">不符合</aui:option>
									</c:if>
									<c:if test="${applyMaterial.fhyj=='不符合'}">
										<aui:option value="符合">符合</aui:option>
										<aui:option value="不符合" selected="true">不符合</aui:option>
									</c:if>
								</aui:select></td>
						</tr>
						<%
							num++;
						%>
					</c:forEach>
				</c:if>
			</tbody>

		</table>

		<!-- <div>
			审核意见：
			<textarea rows="3" name="shyj" style="width: 70%; margin-bottom: 15px; margin-top: 15px"></textarea>
		</div> -->
		<br>
		<div>
			<div class="btn-group">
				<aui:button name="pass" type="submit" value="保存" cssClass="btn btn-primary" />
			</div>
			<%-- <div class="btn-group">
				<aui:button name="pass" value="审核通过" cssClass="btn" />
			</div> --%>
			<div class="btn-group">
				<aui:button name="close" value="关闭" cssClass="btn" href="${viewURL}" />
			</div>
		</div>
	</div>
</aui:form>