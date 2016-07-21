<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<script type="text/javascript">
	document.write("<script src='${staticServerURL}/jquery/jquery-1.12.4.min.js'>" + "<"+"/script>");
</script>
<portlet:renderURL var="viewURL" />
<script type="text/javascript">
	function count() {
		var sum = parseFloat(0);
		$("input[name='<portlet:namespace/>quantity']").each(function() {
			var parent = $(this).parents('tr');
			var price = parent.find("input[name='<portlet:namespace/>unitPrice']").val();
			sum += parseFloat(this.value * price);
		});
		$("#<portlet:namespace/>sum").val(sum);
	}

	function changeLine(obj) {
		if (obj.value == "添加") {
			$("#officeSupplyApplicationItems").append($("#hiddenStyle").html());
		} else {
			if (confirm("确定要删除吗？")) {
				var trObj = obj.parentNode.parentNode;
				trObj.parentElement.removeChild(trObj);
				count();
			}
		}
	}
</script>
<%
	long userId = PortalUtil.getUserId(request);
	String userName = PortalUtil.getUserName(userId, "");
%>
<liferay-ui:header
	title="${empty officeSupplyApplication?'':'编辑'}办公用品申请"
	backURL="${viewURL}" />
<portlet:actionURL var="saveOfficeSupplyApplicationURL"
	name="saveOfficeSupplyApplication">
	<portlet:param name="redirect" value="${viewURL }" />
</portlet:actionURL>
<portlet:resourceURL var="addURL" id="add" />
<portlet:resourceURL var="deleteURL" id="delete" />
<aui:form action="${saveOfficeSupplyApplicationURL}">
	<aui:row>
		<aui:col span="6">
			<aui:input type="hidden" name="officeSupplyApplicationId"
				value="${officeSupplyApplication.officeSupplyApplicationId}" />
			<aui:input name="deptName" label="申请部门"
				value="${officeSupplyApplication.deptName}" inlineField="true" />
		</aui:col>
		<aui:col span="6">
			<aui:input name="userName" label="申请人" value="<%=userName%>"
				readonly="true" />
		</aui:col>
	</aui:row>
	<table border="1" width="100%" style="border: solid thin #D4D4D4">
		<tr align="center" height="29px">
			<td style="width: 20%">申请物品</td>
			<td style="width: 20%">型号</td>
			<td style="width: 15%">单位</td>
			<td style="width: 20%">预计单价</td>
			<td style="width: 20%">数量</td>
			<td style="width: 5%"><input type="button" value="添加"
				style="width: 98%;" onclick="changeLine(this)"></td>
		</tr>
		<c:if test="${!empty officeSupplyApplication}">
			<c:forEach items="${officeSupplyApplicationItems}" var="item">
				<tr align="center">
					<td><input name="<portlet:namespace/>name"
						value="${item.name}"
						style="width: 98%; color: #8B8B83; border-top: #D4D4D4 1px solid; border-bottom: #D4D4D4 1px solid; border-left: #D4D4D4 1px solid; border-right: #D4D4D4 1px solid;" /></td>
					<td><input name="<portlet:namespace/>model"
						value="${item.model}"
						style="width: 98%; color: #8B8B83; border-top: #D4D4D4 1px solid; border-bottom: #D4D4D4 1px solid; border-left: #D4D4D4 1px solid; border-right: #D4D4D4 1px solid;" /></td>
					<td><input name="<portlet:namespace/>unit"
						value="${item.unit}"
						style="width: 98%; color: #8B8B83; border-top: #D4D4D4 1px solid; border-bottom: #D4D4D4 1px solid; border-left: #D4D4D4 1px solid; border-right: #D4D4D4 1px solid;" /></td>
					<td><input name="<portlet:namespace/>unitPrice"
						value="${item.unitPrice}"
						style="width: 98%; color: #8B8B83; border-top: #D4D4D4 1px solid; border-bottom: #D4D4D4 1px solid; border-left: #D4D4D4 1px solid; border-right: #D4D4D4 1px solid;" /></td>
					<td><input name="<portlet:namespace/>quantity"
						placeholder="输入正整数" value="${item.quantity}"
						style="width: 98%; color: #8B8B83; border-top: #D4D4D4 1px solid; border-bottom: #D4D4D4 1px solid; border-left: #D4D4D4 1px solid; border-right: #D4D4D4 1px solid;"
						onchange="count()"
						onkeyup="this.value=this.value.replace(/[^\d]/ig,'')" /></td>
					<td><input type="button" value="删除" onclick="changeLine(this)"
						style="width: 98%;" /></td>
				</tr>
			</c:forEach>
		</c:if>
		<tbody id="officeSupplyApplicationItems"></tbody>
	</table>
	</br>
	<table width="100%">
		<tr>
			<td align="right"><aui:input id="sum" name="sum" label="预计总价"
					value="${sum}" inlineLabel="left" readonly="true" /></td>
		</tr>
	</table>
	<aui:row>
		<aui:col span="12">
			<aui:input type="textarea" name="introductions" label="申请说明"
				value="${officeSupplyApplication.introductions}" cssClass="span12" />
		</aui:col>
	</aui:row>
	<aui:button-row>
		<aui:button type="submit" value="提交" />
		<aui:button type="submit" value="暂存" />
		<aui:button type="cancel" value="取消" href="${viewURL }" />
	</aui:button-row>
</aui:form>

<table style="display: none;" border="1" width="90%">
	<tbody id="hiddenStyle">
		<tr align="center">
			<td><input name="<portlet:namespace/>name"
				style="width: 98%; color: #8B8B83; border-top: #D4D4D4 1px solid; border-bottom: #D4D4D4 1px solid; border-left: #D4D4D4 1px solid; border-right: #D4D4D4 1px solid;"></td>
			<td><input name="<portlet:namespace/>model"
				style="width: 98%; color: #8B8B83; border-top: #D4D4D4 1px solid; border-bottom: #D4D4D4 1px solid; border-left: #D4D4D4 1px solid; border-right: #D4D4D4 1px solid;"></td>
			<td><input name="<portlet:namespace/>unit"
				style="width: 98%; color: #8B8B83; border-top: #D4D4D4 1px solid; border-bottom: #D4D4D4 1px solid; border-left: #D4D4D4 1px solid; border-right: #D4D4D4 1px solid;"></td>
			<td><input name="<portlet:namespace/>unitPrice"
				style="width: 98%; color: #8B8B83; border-top: #D4D4D4 1px solid; border-bottom: #D4D4D4 1px solid; border-left: #D4D4D4 1px solid; border-right: #D4D4D4 1px solid;"></td>
			<td><input name="<portlet:namespace/>quantity"
				placeholder="输入正整数"
				onkeyup="this.value=this.value.replace(/[^\d]/ig,'')"
				onchange="count()"
				style="width: 98%; color: #8B8B83; border-top: #D4D4D4 1px solid; border-bottom: #D4D4D4 1px solid; border-left: #D4D4D4 1px solid; border-right: #D4D4D4 1px solid;"></td>
			<td><input type="button" value="删除" onclick="changeLine(this)"
				style="width: 98%;" /></td>
		</tr>
	</tbody>
</table>





