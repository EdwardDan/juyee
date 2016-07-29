<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/init.jsp"%>

<table cellpadding="0" cellspacing="0"
	class="table table-bordered table-hover" border="1" id="table2">
	<tr align="center" height="29px">
		<td style="width: 10%; text-align: center;" nowrap>序号</td>
		<td style="width: 30%; text-align: center;" nowrap>单位工程编号</td>
		<td style="width: 30%; text-align: center;" nowrap>单位工程名称</td>
		<td style="width: 30%; text-align: center;" nowrap>建设内容</td>

	</tr>
	<c:if test="${not empty constructionUnitProjects}">
		<c:forEach items="${constructionUnitProjects}" var="item">
			
			<tr align="center">
				<td style="text-align: center">${item.sortNo}</td>
				<td style="text-align: center">${item.unitProjectNum}</td>
				<td style="text-align: center">${item.unitProjectName}</td>
				<td style="text-align: center">${item.constructionContent}</td>
			</tr>
		</c:forEach>
	</c:if>

</table>
