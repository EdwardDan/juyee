<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="namespace"
	value="<%=renderResponse.getNamespace()%>" />
<script type="text/javascript">
	function addLineUnitEngineeing(obj) {
		var objTable = obj.parentNode.parentNode.parentNode.parentNode;
		if (obj.value == '添加') {
			var rowIndex = document.getElementById("table2").rows.length - 1;
			var objRow = objTable.insertRow(rowIndex);
			var objCell;
			var ssa = document.getElementById("hiddenStyle2");
			//列的个数
			for (var i = 0; i < 5; i++) {
				var indexNo = document.getElementById("table2").rows.length - 2;
				objCell = objRow.insertCell(i);
				objCell.noWrap = "true";
				objCell.style.display = ssa.cells[i].style.display;
				if (i == 0) {
					objCell.innerHTML = '<input type="text" style="width: 95%; height: 100%; color: #8B8B83; border: none; background-color: transparent;" name="${namespace}sortNo2" value="' + indexNo + '"/>';
				} else {
					objCell.innerHTML = ssa.cells[i].innerHTML;
				}
			}
		} else {
			if (confirm("确定要删除吗!")) {
				var trObj = obj.parentNode.parentNode;
				trObj.parentElement.deleteRow(trObj.rowIndex);
			}
		}
	}
</script>


<table 
	class="table table-bordered table-hover" border="1" id="table2">
	<tr align="center" height="29px">
		<td style="width: 5%; text-align: center;" nowrap>序号</td>
		<td style="width: 25%; text-align: center;" nowrap>单位工程编号</td>
		<td style="width: 25%; text-align: center;" nowrap>单位工程名称</td>
		<td style="width: 35%; text-align: center;" nowrap>建设内容</td>
		<td style="width: 5%; text-align: center;"><input type='button'
			value='添加' class='btn' onclick='addLineUnitEngineeing(this)'></td>
	</tr>
	<c:if test="${not empty constructionUnitProjects}">
		<c:forEach items="${constructionUnitProjects}" var="item">
			<input type="hidden" name="${namespace}constructionUnitProjectId"
				value="${item.constructionUnitProjectId}">
			<tr align="center">
				<td><input
					style="width: 95%; height: 100%; color: #8B8B83; border: none; background-color: transparent;"
					type="text" name="${namespace}sortNo2" value="${item.sortNo}" />
				</td>
				<td><input type="text"
					style="width: 95%; height: 100%; color: #8B8B83; border-top: #D4D4D4 1px solid; border-bottom: #D4D4D4 1px solid; border-left: #D4D4D4 1px solid; border-right: #D4D4D4 1px solid;"
					name="${namespace}unitProjectNum" value="${item.unitProjectNum}" /></td>
				<td><input type="text"
					style="width: 95%; height: 100%; color: #8B8B83; border-top: #D4D4D4 1px solid; border-bottom: #D4D4D4 1px solid; border-left: #D4D4D4 1px solid; border-right: #D4D4D4 1px solid;"
					name="${namespace}unitProjectName" value="${item.unitProjectName}"></td>
				<td><input type="text"
					style="width: 95%; height: 100%; color: #8B8B83; border-top: #D4D4D4 1px solid; border-bottom: #D4D4D4 1px solid; border-left: #D4D4D4 1px solid; border-right: #D4D4D4 1px solid;"
					name="${namespace}constructionContent" value="${item.constructionContent}"></td>

				<td><input type='button' value='删除'
					class='button_select_remove' onclick='addLineUnitEngineeing(this)'></td>
			</tr>
		</c:forEach>
	</c:if>
	<tr id="hiddenStyle2" style="display: none; height: 30px;">
		<td></td>
		<td><input type="text"
			style="width: 95%; height: 100%; color: #8B8B83; border-top: #D4D4D4 1px solid; border-bottom: #D4D4D4 1px solid; border-left: #D4D4D4 1px solid; border-right: #D4D4D4 1px solid;"
			name="${namespace}unitProjectNum" value="${item.unitProjectNum}" /></td>
		<td><input type="text"
			style="width: 95%; height: 100%; color: #8B8B83; border-top: #D4D4D4 1px solid; border-bottom: #D4D4D4 1px solid; border-left: #D4D4D4 1px solid; border-right: #D4D4D4 1px solid;"
			name="${namespace}unitProjectName" value="${item.unitProjectName}"></td>
		<td><input type="text"
			style="width: 95%; height: 100%; color: #8B8B83; border-top: #D4D4D4 1px solid; border-bottom: #D4D4D4 1px solid; border-left: #D4D4D4 1px solid; border-right: #D4D4D4 1px solid;"
			name="${namespace}constructionContent" value="${item.constructionContent}"></td>

		<td><input type='button' value='删除' class='button_select_remove'
			onclick='addLineUnitEngineeing(this)'></td>

	</tr>
</table>
