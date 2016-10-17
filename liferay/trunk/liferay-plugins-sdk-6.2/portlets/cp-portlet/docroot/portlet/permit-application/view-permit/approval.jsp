<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
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
<table class="table table-bordered table-hover table-striped"
	style="width: 100% ；text-align:center;">
	<thead>
		<th style="text-align: center;width:20%;">审核步骤</th>
		<th style="text-align: center;width:40%;">审核意见</th>
		<th style="text-align: center;width:20%;">审核时间</th>
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
			   if(workflowLogs.get(i).getState().equals("shoulizhongxin")){state="收件";}
			   if(workflowLogs.get(i).getState().equals("quxianshouli")){continue;}
			   if(workflowLogs.get(i).getState().equals("chushen")){state="初审";}
			   if(workflowLogs.get(i).getState().equals("shoujian")){state="收件";}
			   if(workflowLogs.get(i).getState().equals("quxianshenhe")){continue;}
			   if(workflowLogs.get(i).getState().equals("quxianshenpi")){continue;}
			   if(workflowLogs.get(i).getState().equals("fuhe")){continue;}
			   if(workflowLogs.get(i).getState().equals("shenhe")){continue;}
			   if(workflowLogs.get(i).getState().equals("fenguanlingdao")){continue;}
			   if(workflowLogs.get(i).getState().equals("zhongxinlingdao")){continue;}
			   if(workflowLogs.get(i).getState().equals("weijianshechu")){continue;}
			   if(workflowLogs.get(i).getState().equals("weilingdao")){continue;}
			   if(workflowLogs.get(i).getState().equals("update")){continue;}
			   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state10")){transition="初审退回";}
			   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state3")){transition="收件退回";}
			   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state20")){transition="不予通过";}
			   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state13")){continue;}
			   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state4")){continue;}
			   
	%>
	<tr>
		<td><%=state%>-<%=transition%></td>
		<td><%=workflowLogs.get(i).getComment().equals("Assigned initial task.")?"":workflowLogs.get(i).getComment()%></td>
		<td><%=dateFormatDateTime.format(workflowLogs.get(i).getCreateDate())%></td>
	</tr>
	<%
		}
			}
	%>
</table>