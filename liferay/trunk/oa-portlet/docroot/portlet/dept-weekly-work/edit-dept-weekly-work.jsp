<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="/common/init.jsp"%>
<c:set var="contextPath" value="${request.contextPath}/portlet/dept-weekly-work" />
<script type="text/javascript">
	document.write("<script src='${staticServerURL}/jquery/jquery-1.12.4.min.js'>" + "<"+"/script>");
</script>
<style type="text/css">
.table tr td {
	border: 1px solid #ddd;
}
.table tr td input {
	width: 100%;
	height: 28px;
	color: #8B8B83;
	border: #D4D4D4 1px solid;
}
</style>
<script src="${staticServerURL}/My97DatePicker/WdatePicker.js"></script>
<%
	long userId = PortalUtil.getUserId(request);
	User user_ = UserServiceUtil.getUserById(userId);
	List<Organization> organizations = user_.getOrganizations();
	String organzationName = organizations.get(0).getName();
	Long organizationId = organizations.get(0).getOrganizationId();
	String userName = PortalUtil.getUserName(userId, "");
	DeptWork deptWork = (DeptWork)request.getAttribute("deptWork");
	String startDate ="";
	String endDate = "";
	if(Validator.isNotNull(deptWork)){
		startDate = DateUtil.getDate(deptWork.getStartDate(), defaultDateFormatPattern, locale, timeZone);
		endDate = DateUtil.getDate(deptWork.getEndDate(), defaultDateFormatPattern, locale, timeZone);
	}
%>

<portlet:resourceURL var="stateToReviewBySectionChief" id="stateToReviewBySectionChief" />

<script type="text/javascript">
	function changeLine(obj) {
		if (obj.value == "添加") {
			$("#deptWorkItems").append($("#hiddenStyle").html());
		} else {
			if (confirm("确定要删除吗？")) {
				var trObj = obj.parentNode.parentNode;
				trObj.parentElement.removeChild(trObj);
			}
		}
	}

	

	function validate1() {
		if ($("#deptWorkItems").html() == ' ') {
			alert("请添加数据！");
			return false;
		}
		$.ajax({
			type:"GET",
			url:"<%=stateToReviewBySectionChief%>",
			data : {
				'<portlet:namespace/>organizationId' :<%=organizationId%>,
			},
			error : function(err) {
				alert("通知失败!");
			},
			success : function(data) {

			}
		});
	}
	function validate2() {
		if ($("#deptWorkItems").html() == ' ') {
			alert("请添加数据！");
			return false;
		}
		$("#<portlet:namespace/>type").val("save");
	}
</script>
<portlet:renderURL var="viewURL" />
<liferay-ui:header title="${empty deptWork?'添加':'编辑'}科室一周工作安排" backURL="${viewURL}" />
<portlet:actionURL var="saveDeptWorkURL" name="saveDeptWork">
	<portlet:param name="redirect" value="${viewURL }" />
</portlet:actionURL>
<aui:form action="${saveDeptWorkURL}">
	<aui:row>
		<aui:col span="6">
			<aui:input name="deptWorkId" value="${deptWork.deptWorkId}" type="hidden" />
			<aui:input name="type" value="submit" id="type" type="hidden" />
			<aui:input name="deptName" label="上报科室" value="<%=organzationName%>" readonly="true" />
		</aui:col>
		<aui:col span="6">
			<aui:input name="userName" label="上报人" value="<%=userName%>" disabled="true" />
		</aui:col>
	</aui:row>
	<aui:field-wrapper name="上报时间" inlineLabel="true">
		<input type="text" class="Wdate" id="startDate" name="<portlet:namespace/>startDate" value="<%=startDate%>" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')}',lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" required="true" />　~　
		<input type="text" class="Wdate" id="endDate" name="<portlet:namespace/>endDate" value="<%=endDate%>" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDate\')}',lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" required="true" />
	</aui:field-wrapper>
	<table border="1" width="100%" class="table table-bordered table-hover">
		<tr align="center" height="29px">
			<td style="width: 5%">序号</td>
			<td style="width: 10%">责任人</td>
			<td style="width: 10%">是否重点工作</td>
			<td style="width: 28%">工作内容</td>
			<td style="width: 27%">工作进度</td>
			<td style="width: 10%">经办人</td>
			<td style="width: 5%"><input type="button" value="添加" class="btn" style="width: 100%;" onclick="changeLine(this)" /></td>
		</tr>
		<tbody id="deptWorkItems">
			<c:if test="${!empty deptWorkItems}">
				<c:forEach items="${deptWorkItems}" var="item">
				${item.mainWork}
					<tr align="center">
						<td><input name="<portlet:namespace/>sortNo" value="${item.sortNo}" required="required" /></td>
						<td><input name="<portlet:namespace/>dutyPerson" value="${item.dutyPerson}" /></td>
						<td><select name="<portlet:namespace/>mainWork">
								<aui:option value="1" selected="${item.mainWork}">是</aui:option>
								<aui:option value="0" selected="${!item.mainWork}">否</aui:option>
						</select></td>
						<td><input name="<portlet:namespace/>content" value="${item.content}" /></td>
						<td><input name="<portlet:namespace/>schedule" value="${item.schedule}" /></td>
						<td><input name="<portlet:namespace/>agentPerson" value="${item.agentPerson}" /></td>
						<td><input type="button" class="btn" value="删除" onclick="changeLine(this)" style="width: 100%;" /></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	<aui:button-row>
		<c:if test="<%=deptWork == null%>">
			<aui:button onClick="return validate1()" type="submit" value="提交" />
		</c:if>
		<aui:button onClick="return validate2()" type="submit" value="保存" />

		<aui:button type="cancel" value="取消" href="${viewURL}" />
	</aui:button-row>
</aui:form>
<table style="display: none;" border="1" width="90%">
	<tbody id="hiddenStyle">
		<tr align="center">
			<td><input name="<portlet:namespace/>sortNo" required="required"></td>
			<td><input name="<portlet:namespace/>dutyPerson"></td>
			<td><select name="<portlet:namespace/>mainWork">
					<option value="1">是</option>
					<option value="0">否</option>
			</select></td>
			<td><input name="<portlet:namespace/>content"></td>
			<td><input name="<portlet:namespace/>schedule"></td>
			<td><input name="<portlet:namespace/>agentPerson"></td>
			<td><input type="button" class="btn" value="删除" onclick="changeLine(this)" style="width: 100%;" /></td>
		</tr>
	</tbody>
</table>