<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="namespace" value="<%=renderResponse.getNamespace()%>" />

<script type="text/javascript">
	function addLineParticipantUnits(obj) {
		var objTable = obj.parentNode.parentNode.parentNode.parentNode;
		if (obj.value == '添加') {
			var rowIndex = document.getElementById("table1").rows.length - 1;
			var objRow = objTable.insertRow(rowIndex);
			var objCell;
			var ssa = document.getElementById("hiddenStyle");
			//列的个数
			for (var i = 0; i < 7; i++) {
				var indexNo = document.getElementById("table1").rows.length - 2;
				objCell = objRow.insertCell(i);
				objCell.noWrap = "true";
				objCell.style.display = ssa.cells[i].style.display;
				if (i == 0) {
					objCell.innerHTML = '<input type="text" style="width: 95%; height: 100%; color: #8B8B83; border: none; background-color: transparent;" name="${namespace}sortNo1" value="'
							+ indexNo + '"/>';
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



<table class="table table-bordered"  id="table1">
	<tr align="center" height="29px">
		<td style="width: 5%; text-align: center;" nowrap>序号</td>
		<td style="width: 20%; text-align: center;" nowrap>合同信息报送编号</td>
		<td style="width: 15%; text-align: center;" nowrap>单位类型</td>
		<td style="width: 20%; text-align: center;" nowrap>单位名称</td>
		<td style="width: 15%; text-align: center;" nowrap>项目负责人</td>
		<td style="width: 15%; text-align: center;" nowrap>电话号码</td>
		<td style="width: 5%; text-align: center;"><input type='button'
			value='添加' class='btn' onclick='addLineParticipantUnits(this)' /></td>
	</tr>
	<c:if test="${not empty constructionParticipantUnitsS}">
		<c:forEach items="${constructionParticipantUnitsS}" var="item">
			<input type="hidden"
				name="${namespace}constructionParticipantUnitsId"
				value="${item.constructionParticipantUnitsId}" />
			<tr align="center">
				<td><input
					style="width: 95%; height: 100%; color: #8B8B83; border: none; background-color: transparent;"
					type="text" name="${namespace}sortNo1" value="${item.sortNo}" /></td>
				<td><input type="text"
					style="width: 95%; height: 100%; color: #8B8B83; border-top: #D4D4D4 1px solid; border-bottom: #D4D4D4 1px solid; border-left: #D4D4D4 1px solid; border-right: #D4D4D4 1px solid;"
					name="${namespace}contractInfoSubmitNum"
					value="${item.contractInfoSubmitNum}" /></td>
				<td><select 
					style="width: 95%; height: 100%; color: #8B8B83; border-top: #D4D4D4 1px solid; border-bottom: #D4D4D4 1px solid; border-left: #D4D4D4 1px solid; border-right: #D4D4D4 1px solid;"
					name="${namespace}unitType" > </select></td>
				<td><input type="text"
					style="width: 95%; height: 100%; color: #8B8B83; border-top: #D4D4D4 1px solid; border-bottom: #D4D4D4 1px solid; border-left: #D4D4D4 1px solid; border-right: #D4D4D4 1px solid;"
					name="${namespace}unitName" value="${item.unitName}" /></td>
				<td><input type="text"
					style="width: 95%; height: 100%; color: #8B8B83; border-top: #D4D4D4 1px solid; border-bottom: #D4D4D4 1px solid; border-left: #D4D4D4 1px solid; border-right: #D4D4D4 1px solid;"
					name="${namespace}projectLeader" value="${item.projectLeader}" /></td>

				<td><input type="text"
					style="width: 95%; height: 100%; color: #8B8B83; border-top: #D4D4D4 1px solid; border-bottom: #D4D4D4 1px solid; border-left: #D4D4D4 1px solid; border-right: #D4D4D4 1px solid;"
					name="${namespace}telephoneNum" value="${item.telephoneNum}" /></td>
				<td><input type='button' value='删除'
					class='button_select_remove'
					onclick='addLineParticipantUnits(this)' /></td>
			</tr>
		</c:forEach>
	</c:if>
	<tr id="hiddenStyle" style="display: none; height: 30px;">
		<td style="width: 5%; text-align: center;"></td>

		<td style="width: 20%; text-align: center;"><input type="text"
			style="width: 95%; height: 100%; color: #8B8B83; border-top: #D4D4D4 1px solid; border-bottom: #D4D4D4 1px solid; border-left: #D4D4D4 1px solid; border-right: #D4D4D4 1px solid;"
			name="${namespace}contractInfoSubmitNum" /></td>
		<td style="width: 15%; text-align: center;"><input type="text"
			style="width: 95%; height: 100%; color: #8B8B83; border-top: #D4D4D4 1px solid; border-bottom: #D4D4D4 1px solid; border-left: #D4D4D4 1px solid; border-right: #D4D4D4 1px solid;"
			name="${namespace}unitType" value="${item.unitType}" /></td>
		<td style="width: 20%; text-align: center;"><input type="text"
			style="width: 95%; height: 100%; color: #8B8B83; border-top: #D4D4D4 1px solid; border-bottom: #D4D4D4 1px solid; border-left: #D4D4D4 1px solid; border-right: #D4D4D4 1px solid;"
			name="${namespace}unitName" /></td>
		<td style="width: 15%; text-align: center;"><input type="text"
			style="width: 95%; height: 100%; color: #8B8B83; border-top: #D4D4D4 1px solid; border-bottom: #D4D4D4 1px solid; border-left: #D4D4D4 1px solid; border-right: #D4D4D4 1px solid;"
			name="${namespace}projectLeader" /></td>

		<td style="width: 15%; text-align: center;"><input type="text"
			style="width: 95%; height: 100%; color: #8B8B83; border-top: #D4D4D4 1px solid; border-bottom: #D4D4D4 1px solid; border-left: #D4D4D4 1px solid; border-right: #D4D4D4 1px solid;"
			name="${namespace}telephoneNum" /></td>
		<td style="width: 5%; text-align: center;"><input type='button'
			value='删除' class='button_select_remove'
			onclick='addLineParticipantUnits(this)' /></td>
	</tr>
</table>
