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
	value="${request.contextPath}/portlet/permit-approval/approval-history-city" />
<portlet:renderURL var="ysURL">
	<portlet:param name="mvcPath" value="${contextPath}/ys.jsp" />
</portlet:renderURL>
<portlet:renderURL var="sjURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/sj.jsp" />
</portlet:renderURL>
<portlet:renderURL var="csURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/cs.jsp" />
</portlet:renderURL>
<portlet:renderURL var="fhURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/fh.jsp" />
</portlet:renderURL>
<portlet:renderURL var="shURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/sh.jsp" />
</portlet:renderURL>
<portlet:renderURL var="fgldshURL" >
	<portlet:param name="mvcPath" value="${contextPath}/fgldsh.jsp" />
</portlet:renderURL>
<portlet:renderURL var="zxldshURL" >
	<portlet:param name="mvcPath" value="${contextPath}/zxldsh.jsp" />
</portlet:renderURL>
<portlet:renderURL var="wjscshURL" >
	<portlet:param name="mvcPath" value="${contextPath}/wjscsh.jsp" />
</portlet:renderURL>
<portlet:renderURL var="wspcshURL">
	<portlet:param name="mvcPath" value="${contextPath}/wspcsh.jsp" />
</portlet:renderURL>
<portlet:renderURL var="wldshURL" >
	<portlet:param name="mvcPath" value="${contextPath}/wldsh.jsp" />
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
				if(WorkflowInstanceLinkLocalServiceUtil.hasWorkflowInstanceLink(me.getCompanyId(), 0L, "com.justonetech.cp.permit.model.Permit", permit.getPermitId())){
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
					   String comment="";
					   if(workflowLog.getState().equals("yushen")){state="预审";}
					   if(workflowLog.getState().equals("shoujian")){state="<a onclick='sj()'>收件</a>";}
					   if(workflowLog.getState().equals("chushen")){state="<a onclick='cs()'>初审</a>";}
					   if(workflowLog.getState().equals("fuhe")){state="<a onclick='fh()'>复核</a>";}
					   if(workflowLog.getState().equals("shenhe")){state="<a onclick='sh()'>审核</a>";}
					   if(workflowLog.getState().equals("fenguanlingdao")){state="分管领导审核";}
					   if(workflowLog.getState().equals("zhongxinlingdao")){state="中心领导审核";}
					   if(workflowLog.getState().equals("weijianshechu")){state="委建设处审核";}
					   if(workflowLog.getState().equals("weishenpichu")){state="委审批处审核";}
					   if(workflowLog.getState().equals("weilingdao")){state="委领导审核";}
					   if(workflowLog.getState().equals("update")){continue;}
				%>
<tr>
							<td><%=state%></td>
							<td><%=workflowLog.getComment() %></td>
							<td><%= auditName%></td>
		<td><%=dateFormatDateTime.format(workflowLog.getCreateDate())%></td>
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
	Liferay.provide(window, 'cs', function() {
		Liferay.Util.openWindow({
			dialog : {
				centered : true,
				width : 800,
				height : 600
			},
			id : 'popup',
			title : '初审',
			uri : '${csURL}',
			destroyOnClose : true
		});
	}, [ 'aui-dialog' ]);
	Liferay.provide(window, 'fh', function() {
		Liferay.Util.openWindow({
			dialog : {
				centered : true,
				width : 800,
				height : 600
			},
			id : 'popup',
			title : '复核',
			uri : '${fhURL}',
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
</script>
