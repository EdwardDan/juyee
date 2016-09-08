<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="../init.jsp"%>
<%
	long permitId = ParamUtil.getLong(renderRequest, "permitId");
	List<ParticipationUnit> participationUnits = ParticipationUnitLocalServiceUtil.findByPermitId(permitId, -1,
			-1);

	request.setAttribute("participationUnits", participationUnits);
%>
<aui:form action="${saveParticipationUnitsURL }">
	<div class="accordion-inner">
		<table border="1" width="100%"
			class="table table-bordered table-hover">
			<tr height="29px">
				<td style="width: 28%; text-align: center">单位名称</td>
				<td style="width: 13%; text-align: center">单位类型</td>
				<td style="width: 10%; text-align: center">项目负责人</td>
				<td style="width: 12%; text-align: center">证件类型</td>
				<td style="width: 20%; text-align: center">证件号</td>
				<td style="width: 10%; text-align: center">手机号</td>
			</tr>

			<tbody id="participationUnits">
				<c:if test="${!empty participationUnits}">
					<c:forEach items="${participationUnits}" var="participationUnit">
						<tr height="29px">
							<td style="width: 28%; text-align: left">${participationUnit. dwmc}</td>
							<td style="width: 13%; text-align: center">${participationUnit. dwlx }
							</td>
							<td style="width: 10%; text-align: center">${participationUnit. xmfzr}</td>
							<td style="width: 12%; text-align: center">${participationUnit. zjlx }</td>
							<td style="width: 20%; text-align: center">${participationUnit. zjh}</td>
							<td style="width: 10%; text-align: center">${participationUnit. dhhm}</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>

</aui:form>