<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="init.jsp"%>
<style type="text/css">
a {
	cursor: pointer;
}

table {
	width: 100%;
	text-align: center;
}
</style>
<%
	long permitId = ParamUtil.getLong(request, "permitId");
	request.setAttribute("permitId", permitId);
%>
<c:set var="contextPath"
	value="${request.contextPath}/portlet/permit-approval/approval-history-county" />
<portlet:renderURL var="sjURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/sj.jsp" />
	<portlet:param name="permitId" value="${permitId }" />
</portlet:renderURL>
<portlet:renderURL var="slURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/sl.jsp" />
	<portlet:param name="permitId" value="${permitId }" />
</portlet:renderURL>
<portlet:renderURL var="shURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/sh.jsp" />
	<portlet:param name="permitId" value="${permitId }" />
</portlet:renderURL>
<portlet:renderURL var="spURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/sp.jsp" />
	<portlet:param name="permitId" value="${permitId }" />
</portlet:renderURL>
<table class="table table-border table-hover table-striped"
	style="width: 100% ；text-align:center;">
	<thead>
		<th style="text-align: center;width:20%;border:1px solid #ddd;">审核步骤</th>
		<th style="text-align: center;width:40%;border:1px solid #ddd;">审核意见</th>
		<th style="text-align: center;width:20%;border:1px solid #ddd;">审核人</th>
		<th style="text-align: center;width:20%;border:1px solid #ddd;">审核时间</th>
	</thead>
	<%
		Long permitIdInit=ParamUtil.getLong(request,"permitId");
		Permit permit=PermitLocalServiceUtil.getPermit(permitIdInit);
		User me=PortalUtil.getUser(request);
			Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);
			List<Integer> logTypes = new ArrayList<Integer>();
			logTypes.add(WorkflowLog.TASK_COMPLETION);
			String transition="";
			if(WorkflowInstanceLinkLocalServiceUtil.hasWorkflowInstanceLink(me.getCompanyId(), 0L, "com.justonetech.cp.permit.model.Permit", permit.getPermitId())){
			List<WorkflowLog> workflowLogs = WorkflowLogManagerUtil.getWorkflowLogsByWorkflowInstance(company.getCompanyId(), WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(me.getCompanyId(), 0L, "com.justonetech.cp.permit.model.Permit", permit.getPermitId()).getWorkflowInstanceId(), logTypes, QueryUtil.ALL_POS, QueryUtil.ALL_POS, WorkflowComparatorFactoryUtil.getLogCreateDateComparator(true));
			for(int i=0;i<workflowLogs.size();i++){
				Role curRole = null;
				User curUser = null;
				User auditUser=null;
				String actorName = null;
				String auditName=null;
				if (workflowLogs.get(i).getRoleId() != 0) {
					curRole = RoleLocalServiceUtil.getRole(workflowLogs.get(i).getRoleId());
					actorName = curRole.getDescriptiveName();
				}
				else if (workflowLogs.get(i).getUserId() != 0) {
					curUser = UserLocalServiceUtil.getUser(workflowLogs.get(i).getUserId());
					actorName = curUser.getFullName();
				}
				if(workflowLogs.get(i).getAuditUserId()!=0){
					 auditUser = UserLocalServiceUtil.getUser(workflowLogs.get(i).getAuditUserId());
					auditName=auditUser.getFirstName();
				}
			   String state="";
			   if(workflowLogs.get(i).getState().equals("shoulizhongxin")){state="<a onclick='sj()'>收件</a>";}
			   if(workflowLogs.get(i).getState().equals("quxianshouli")){state="<a onclick='sl()'>受理</a>";}
			   if(workflowLogs.get(i).getState().equals("quxianshenhe")){state="<a onclick='sh()'>审核</a>";}
			   if(workflowLogs.get(i).getState().equals("quxianshenpi")){state="<a onclick='sp()'>审批</a>";}
			   if(workflowLogs.get(i).getState().equals("update2")){continue;}
			   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state3")){transition="收件退回";}
			   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state4")){transition="收件通过";}
			   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state5")){transition="受理通过";}
			   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state6")){transition="审核通过";}
			   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state30")){transition="审批通过";}
			   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state7")){transition="审批退回";}
			   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state41")){transition="补正退回";}
	%>
	<tr>
		<td style="border:1px solid #ddd;"><%=state%>-<%=transition%></td>
		<td style="border:1px solid #ddd;"><%=workflowLogs.get(i).getComment().equals("Assigned initial task.")?"":workflowLogs.get(i).getComment()%></td>
		<td style="border:1px solid #ddd;"><%=auditName%></td>
		<td style="border:1px solid #ddd;"><%=dateFormatDateTime.format(workflowLogs.get(i).getCreateDate())%></td>
	</tr>
	<%
		}
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