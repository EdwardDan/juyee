<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/init.jsp"%>

<table cellpadding="0" cellspacing="0"
	class="table table-bordered table-hover" border="1" id="table1">
	<tr align="center" height="29px">
		<td style="width: 10%; text-align: center;" nowrap>序号</td>
		<td style="width: 18%; text-align: center;" nowrap>合同信息报送编号</td>
		<td style="width: 18%; text-align: center;" nowrap>单位类型</td>
		<td style="width: 18%; text-align: center;" nowrap>单位名称</td>
		<td style="width: 16%; text-align: center;" nowrap>单位负责人</td>
		<td style="width: 20%; text-align: center;" nowrap>电话号码</td>

	</tr>
	<c:if test="${not empty constructionParticipantUnitsS}">
		<c:forEach items="${constructionParticipantUnitsS}" var="item">

			<tr align="center">
				<td style="text-align: center">${item.sortNo}</td>
				<td style="text-align: center">${item.contractInfoSubmitNum}</td>
				<td style="text-align: center">${item.unitType}</td>
				<td style="text-align: center">${item.unitName}</td>
				<td style="text-align: center">${item.projectLeader}</td>
				<td style="text-align: center">${item.telephoneNum}</td>
			</tr>
		</c:forEach>
	</c:if>

</table>
