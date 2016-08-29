<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowTask"%>
<%@ page
	import="com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil"%>
<%@ page import="com.liferay.portal.workflow.kaleo.service.*"%>
<%@ page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@ page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowException"%>
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
<script type="text/javascript">
	document.write("<script src='${staticServerURL}/jquery/jquery-1.12.4.min.js'>" + "<"+"/script>");
</script>
<portlet:renderURL var="viewURL" />
<portlet:resourceURL var="notifyURL" id="stateToReviewByKezhang"/>
<%
	long userId = PortalUtil.getUserId(request);
	String strBackUrl = "http://" + request.getServerName() //服务器地址  
			+ ":" + request.getServerPort(); //端口号  
	User _user = UserServiceUtil.getUserById(userId);
	OfficeSupplyApplication officeSupplyApplication = (OfficeSupplyApplication) request
			.getAttribute("officeSupplyApplication");
	List<Organization> organizations = _user.getOrganizations();
	String organizationName = organizations.get(0).getName();
	Long organizationId = organizations.get(0).getOrganizationId();
	String userName = PortalUtil.getUserName(userId, "");
	request.setAttribute("organizationName", organizationName);
	request.setAttribute("userName", userName);
	String url = "";
	if (null != officeSupplyApplication) {
		String[] assetTypes = new String[1];
		assetTypes[0] = "com.justonetech.oa.model.OfficeSupplyApplication";
		OrderByComparator orderByComparator = null;
		List<WorkflowTask> results1 = null;
		User me = PortalUtil.getUser(request);
		try {
			results1 = WorkflowTaskManagerUtil.search(me.getCompanyId(), me.getUserId(), null, assetTypes,
					null, null, -1, -1, orderByComparator);
		} catch (WorkflowException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		long workflowTaskId = 0L;
		long people = 0L;
		for (WorkflowTask task : results1) {
			if (KaleoTaskInstanceTokenLocalServiceUtil.getKaleoTaskInstanceToken(task.getWorkflowTaskId())
					.getClassPK() == officeSupplyApplication.getOfficeSupplyApplicationId()) {
				workflowTaskId = task.getWorkflowTaskId();
				people = task.getAssigneeUserId();
			}
		}
		String token = com.liferay.portal.security.auth.AuthTokenUtil.getToken(request);
		url = strBackUrl
				+ "/group/control_panel/manage/-/my_workflow_tasks/view/"
				+ workflowTaskId
				+ "?p_auth="
				+ token
				+ "&p_p_lifecycle=1&doAsGroupId="
				+ PortalUtil.getUser(request).getGroupId()
				+ "&refererPlid=25177&controlPanelCategory=my&_153_cmd=save&_153_assigneeUserId="
				+ people
				+ "&_153_redirect="
				+ strBackUrl
				+ "/web/guest/sy&_153_struts_action=/my_workflow_tasks/edit_workflow_task&_153_transitionName=调度";
	}
%>
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
	function validate1() {
		if ($("#<portlet:namespace/>sum").val() == "" || $("#<portlet:namespace/>sum").val() == 0) {
			alert("请添加数据！");
			return false;
		}
		$.ajax({			
			type:"GET",
			url:"<%=notifyURL%>",
			data:{
				"<portlet:namespace/>organizationId":<%=organizationId%>,			
				}
		});
	}
	function validate2() {
		if ($("#<portlet:namespace/>sum").val() == "" || $("#<portlet:namespace/>sum").val() == 0) {
			alert("请添加数据！");
			return false;
		}
		$("#<portlet:namespace/>status").val("save");
	}
	function validate3() {
		$("#<portlet:namespace/>status").val("appoint");
	}
</script>

<liferay-ui:header
	title="${empty officeSupplyApplication?'':'编辑'}办公用品申请"
	backURL="${viewURL}" />
<portlet:actionURL var="saveOfficeSupplyApplicationURL"
	name="saveOfficeSupplyApplication">
	<portlet:param name="redirect" value="${viewURL }" />
</portlet:actionURL>
<portlet:actionURL var="appointClerkURL"
	name="saveOfficeSupplyApplication">
	<portlet:param name="redirect" value="<%=url%>" />
</portlet:actionURL>
<portlet:resourceURL var="addURL" id="add" />
<portlet:resourceURL var="deleteURL" id="delete" />
<aui:form
	action="${officeSupplyApplication.status!=5?saveOfficeSupplyApplicationURL:appointClerkURL}">
	<aui:row>
		<aui:col span="6">
			<aui:input type="hidden" name="officeSupplyApplicationId"
				value="${officeSupplyApplication.officeSupplyApplicationId}"/>
			<aui:input name="type" value="submit" id="status" type="hidden" />
			<aui:input name="deptName" label="申请部门"
				value="${officeSupplyApplication.status==5?officeSupplyApplication.getDeptName():organizationName}"
				inlineField="true" readonly="true" />
		</aui:col>
		<aui:col span="6">
			<aui:input name="userName" label="申请人"
				value="${officeSupplyApplication.status==5?officeSupplyApplication.getUserName():userName}"
				readonly="true" />
		</aui:col>
	</aui:row>
	<table border="1" width="100%" class="table table-bordered table-hover">
		<tr align="center" height="29px">
			<td style="width: 20%">申请物品</td>
			<td style="width: 20%">型号</td>
			<td style="width: 15%">单位</td>
			<td style="width: 20%">预计单价</td>
			<td style="width: 20%">数量</td>
			<td style="width: 5%"><input type="button" value="添加"
				class="btn" style="width: 100%;" onclick="changeLine(this)" /></td>
		</tr>
		<c:if test="${!empty officeSupplyApplication}">
			<c:forEach items="${officeSupplyApplicationItems}" var="item">
				<tr align="center">
					<td><input name="<portlet:namespace/>name"
						value="${item.name}" readonly="${officeSupplyApplication.status==5?true:false}"/></td>
					<td><input name="<portlet:namespace/>model"
						value="${item.model}" readonly="${officeSupplyApplication.status==5?true:false}"/></td>
					<td><input name="<portlet:namespace/>unit"
						value="${item.unit}" readonly="${officeSupplyApplication.status==5?true:false}"/></td>
					<td><input name="<portlet:namespace/>unitPrice"
						placeholder="请输入正数" value="${item.unitPrice}" onchange="count()"
						onkeyup="value=value.replace(/[^\d.]/g,'')" readonly="${officeSupplyApplication.status==5?true:false}"/></td>
					<td><input name="<portlet:namespace/>quantity"
						placeholder="请输入正整数" value="${item.quantity}" onchange="count()"
						onkeyup="this.value=this.value.replace(/[^\d]/ig,'')" readonly="${officeSupplyApplication.status==5?true:false}"/></td>
					<td><input type="button" class="btn" value="删除"
						onclick="changeLine(this)" style="width: 100%;" readonly="${officeSupplyApplication.status==5?true:false}"/></td>
				</tr>
			</c:forEach>
		</c:if>
		<tbody id="officeSupplyApplicationItems">
		</tbody>
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
				value="${officeSupplyApplication.introductions}" cssClass="span12" readonly="${officeSupplyApplication.status==5?true:false}"/>
		</aui:col>
	</aui:row>
	<c:if test="${officeSupplyApplication.status==5}">
		<aui:input type="text" name="perposeClerk" label="指派科员">
			<aui:validator name="required" errorMessage="请指派科员购买物品！"></aui:validator>
		</aui:input>
	</c:if>
	<aui:button-row>
		<c:if
			test="${officeSupplyApplication.status!=5&&officeSupplyApplication==null}">
			<aui:button onClick="return validate1()" type="submit" value="提交" />
			<aui:button onClick="return validate2()" type="submit" value="暂存" />
		</c:if>
		<c:if
			test="${officeSupplyApplication.status==1||officeSupplyApplication.status==4||officeSupplyApplication.status==6}">
			<aui:button onClick="return validate2()" type="submit" value="暂存" />
		</c:if>
		<c:if test="${officeSupplyApplication.status==5}">
			<aui:button type="submit" value="调度" onClick="return validate3()" />
		</c:if>
		<aui:button type="cancel" value="取消" href="${viewURL }" />
	</aui:button-row>
</aui:form>

<table style="display: none;" border="1" width="90%">
	<tbody id="hiddenStyle">
		<tr align="center">
			<td><input name="<portlet:namespace/>name"></td>
			<td><input name="<portlet:namespace/>model"></td>
			<td><input name="<portlet:namespace/>unit"></td>
			<td><input name="<portlet:namespace/>unitPrice"
				onkeyup="value=value.replace(/[^\d.]/g,'')" onchange="count()"
				placeholder="请输入正数" required="required"></td>
			<td><input name="<portlet:namespace/>quantity"
				placeholder="请输入正整数" required="required"
				onkeyup="this.value=this.value.replace(/[^\d]/ig,'')"
				onchange="count()"></td>
			<td><input type="button" class="btn" value="删除"
				onclick="changeLine(this)" style="width: 100%;" /></td>
		</tr>
	</tbody>
</table>






