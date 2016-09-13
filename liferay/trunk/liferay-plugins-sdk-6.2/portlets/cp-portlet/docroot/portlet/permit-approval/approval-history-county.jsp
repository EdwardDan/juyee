<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<style type="text/css">
	a{
		cursor: pointer;
	}
	table{
		width:100%;
		text-align:center;
	}
</style>
<c:set var="contextPath"
	value="${request.contextPath}/portlet/permit-approval/approval-history-county" />
<portlet:renderURL var="sjURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/sj.jsp" />
</portlet:renderURL>
<portlet:renderURL var="slURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/sl.jsp" />
</portlet:renderURL>
<portlet:renderURL var="shURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/sh.jsp" />
</portlet:renderURL>
<portlet:renderURL var="spURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/sp.jsp" />
</portlet:renderURL>
<table class="table table-border table-hover table-striped" style="width: 100% ；text-align:center;">
	<thead>
		<th style="text-align: center" style="width:20%">审核步骤</th>
		<th style="text-align: center" style="width:40%">审核意见</th>
		<th style="text-align: center" style="width:20%">审核人</th>
		<th style="text-align: center" style="width:20%">审核时间</th>
	</thead>
	<%
	Long permitIdInit=ParamUtil.getLong(request,"permitId");
	Permit permit=PermitLocalServiceUtil.getPermit(permitIdInit);
	User me=PortalUtil.getUser(request);
				Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);
				List<Integer> logTypes = new ArrayList<Integer>();
				logTypes.add(WorkflowLog.TASK_COMPLETION);
				List<WorkflowLog> workflowLogs = WorkflowLogManagerUtil.getWorkflowLogsByWorkflowInstance(company.getCompanyId(), WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(me.getCompanyId(), 0L, "com.justonetech.cp.permit.model.Permit", permit.getPermitId()).getWorkflowInstanceId(), logTypes, QueryUtil.ALL_POS, QueryUtil.ALL_POS, WorkflowComparatorFactoryUtil.getLogCreateDateComparator(true));
				for (WorkflowLog workflowLog : workflowLogs) {
					Role curRole = null;
					User curUser = null;
					User auditUser=null;
					String actorName = null;
					String auditName=null;
					if (workflowLog.getRoleId() != 0) {
						curRole = RoleLocalServiceUtil.getRole(workflowLog.getRoleId());
						actorName = curRole.getDescriptiveName();
					}
					else if (workflowLog.getUserId() != 0) {
						curUser = UserLocalServiceUtil.getUser(workflowLog.getUserId());
						actorName = curUser.getFullName();
					}
					if(workflowLog.getAuditUserId()!=0){
						 auditUser = UserLocalServiceUtil.getUser(workflowLog.getAuditUserId());
						auditName=auditUser.getFirstName();
					}
				   String state="";
				   if(workflowLog.getState().equals("shoulizhongxin")){state="<a onclick='sj()'>收件</a>";}
				   if(workflowLog.getState().equals("quxianshouli")){state="<a onclick='sl()'>受理</a>";}
				   if(workflowLog.getState().equals("quxianshenhe")){state="<a onclick='sh()'>审核</a>";}
				   if(workflowLog.getState().equals("quxianshenpi")){state="<a onclick='sp()'>审批</a>";}
				   if(workflowLog.getState().equals("update2")){continue;}
				%>
<tr>
							<td><%=state%></td>
							<td><%= workflowLog.getComment().equals("Assigned initial task.")?"":workflowLog.getComment() %></td>
							<td><%= auditName%></td>
		<td><%=dateFormatDateTime.format(workflowLog.getCreateDate())%></td>
		</tr>
				<%
				}
				
				%>
</table>
<script>
	Liferay.provide(window, 'sj', function() {
		Liferay.Util.openWindow({
			dialog : {
				centered : true,
				width : 800,
				height : 600
			},
			id : 'popup',
			title : '收件',
			uri : '${sjURL}',
			destroyOnClose : true
		});
	}, [ 'aui-dialog' ]);
	Liferay.provide(window, 'sl', function() {
		Liferay.Util.openWindow({
			dialog : {
				centered : true,
				width : 800,
				height : 600
			},
			id : 'popup',
			title : '受理',
			uri : '${slURL}',
			destroyOnClose : true
		});
	}, [ 'aui-dialog' ]);
	Liferay.provide(window, 'sh', function() {
		Liferay.Util.openWindow({
			dialog : {
				centered : true,
				width : 800,
				height : 600
			},
			id : 'popup',
			title : '审核',
			uri : '${shURL}',
			destroyOnClose : true
		});
	}, [ 'aui-dialog' ]);
	Liferay.provide(window, 'sp', function() {
		Liferay.Util.openWindow({
			dialog : {
				centered : true,
				width : 800,
				height : 600
			},
			id : 'popup',
			title : '审批',
			uri : '${spURL}',
			destroyOnClose : true
		});
	}, [ 'aui-dialog' ]);
</script>