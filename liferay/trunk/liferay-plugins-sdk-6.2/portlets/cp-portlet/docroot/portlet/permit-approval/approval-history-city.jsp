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
<%
	long permitId = ParamUtil.getLong(request, "permitId");
	request.setAttribute("permitId", permitId);
%>
<c:set var="contextPath"
	value="${request.contextPath}/portlet/permit-approval/approval-history-city" />
<portlet:renderURL var="ysURL">
	<portlet:param name="mvcPath" value="${contextPath}/ys.jsp" />
	<portlet:param name="permitId" value="${permitId }" />
</portlet:renderURL>
<portlet:renderURL var="sjURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/sj.jsp" />
	<portlet:param name="permitId" value="${permitId }" />
</portlet:renderURL>
<portlet:renderURL var="csURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/cs.jsp" />
	<portlet:param name="permitId" value="${permitId }" />
</portlet:renderURL>
<portlet:renderURL var="fhURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/fh.jsp" />
	<portlet:param name="permitId" value="${permitId }" />
</portlet:renderURL>
<portlet:renderURL var="shURL" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath}/sh.jsp" />
	<portlet:param name="permitId" value="${permitId }" />
</portlet:renderURL>
<portlet:renderURL var="fgldshURL" >
	<portlet:param name="mvcPath" value="${contextPath}/fgldsh.jsp" />
	<portlet:param name="permitId" value="${permitId }" />
</portlet:renderURL>
<portlet:renderURL var="zxldshURL" >
	<portlet:param name="mvcPath" value="${contextPath}/zxldsh.jsp" />
	<portlet:param name="permitId" value="${permitId }" />
</portlet:renderURL>
<portlet:renderURL var="wjscshURL" >
	<portlet:param name="mvcPath" value="${contextPath}/wjscsh.jsp" />
	<portlet:param name="permitId" value="${permitId }" />
</portlet:renderURL>
<portlet:renderURL var="wldshURL" >
	<portlet:param name="mvcPath" value="${contextPath}/wldsh.jsp" />
	<portlet:param name="permitId" value="${permitId }" />
</portlet:renderURL>
<table class="table table-bordered table-hover table-striped" style="width: 100% ；text-align:center;">
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
					   String comment="";
					  if(workflowLogs.get(i).getState().equals("yushen")){continue;} 
					   if(workflowLogs.get(i).getState().equals("shoujian")){state="<a onclick='sj()'>收件</a>";}
					   if(workflowLogs.get(i).getState().equals("chushen")){state="<a onclick='cs()'>初审</a>";}
					   if(workflowLogs.get(i).getState().equals("fuhe")){state="<a onclick='fh()'>复核</a>";}
					   if(workflowLogs.get(i).getState().equals("shenhe")){state="<a onclick='sh()'>审核</a>";}
					   if(workflowLogs.get(i).getState().equals("fenguanlingdao")){state="分管领导审核";}
					   if(workflowLogs.get(i).getState().equals("zhongxinlingdao")){state="中心领导审核";}
					   if(workflowLogs.get(i).getState().equals("weijianshechu")){state="委建设处审核";}
					   if(workflowLogs.get(i).getState().equals("weishenpichu")){continue;}
					   if(workflowLogs.get(i).getState().equals("weilingdao")){state="委领导审核";}
					   if(workflowLogs.get(i).getState().equals("update")){continue;}
					   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state8")){transition="收件退回";}
					   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state12")){transition="收件通过";}
					   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state13")){transition="初审通过";}
					   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state10")){transition="初审退回";}
					   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state14")){transition="复核通过";}
					   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state12")){transition="复核退回";}
					   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state15")){transition="审核通过";}
					   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state19")){transition="审核退回";}
					   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state17")){transition="审核通过";}
					   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state16")){transition="审核退回";}
					   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state11")){transition="审核通过";}
					   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state18")){transition="审核退回";}
					   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state21")){transition="收件通过";}
					   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state20")){transition="审核退回";}
					   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state22")){transition="受理退回";}
					   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state24")){transition="<span style='color:red'>许可</span>";}
					   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state32")){transition="<span style='color:red'>不许可</span>";}
					   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state33")){transition="<span style='color:red'>许可</span>";}
					   if(KaleoLogLocalServiceUtil.getKaleoLog(workflowLogs.get(i).getWorkflowLogId()+1).getKaleoNodeName().equals("state34")){transition="<span style='color:red'>不许可</span>";}
				%>
<tr>
							<td><%=state%>-<%=transition %></td>
							<td><%=workflowLogs.get(i).getComment().indexOf("&")<0?workflowLogs.get(i).getComment():workflowLogs.get(i).getComment().substring(0,workflowLogs.get(i).getComment().indexOf("&")) %></td>
							<td><%= auditName%></td>
		<td><%=dateFormatDateTime.format(workflowLogs.get(i).getCreateDate())%></td>
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
				height : 600,
				modal : true,
				toolbars : {
					footer : [ {
						label : Liferay.Language.get('close'),
						on : {
							click : function() {
								var dialog = Liferay.Util.Window.getById('<portlet:namespace/>sj');
								dialog.destroy();
							}
						}
					} ]
				}
			},
			id : '<portlet:namespace/>sj',
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
				height : 600,
				modal : true,
				toolbars : {
					footer : [ {
						label : Liferay.Language.get('close'),
						on : {
							click : function() {
								var dialog = Liferay.Util.Window.getById('<portlet:namespace/>cs');
								dialog.destroy();
							}
						}
					} ]
				}
			},
			id : '<portlet:namespace/>cs',
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
				height : 600,
				modal : true,
				toolbars : {
					footer : [ {
						label : Liferay.Language.get('close'),
						on : {
							click : function() {
								var dialog = Liferay.Util.Window.getById('<portlet:namespace/>fh');
								dialog.destroy();
							}
						}
					} ]
				}
			},
			id : '<portlet:namespace/>fh',
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
				height : 600,
				modal : true,
				toolbars : {
					footer : [ {
						label : Liferay.Language.get('close'),
						on : {
							click : function() {
								var dialog = Liferay.Util.Window.getById('<portlet:namespace/>sh');
								dialog.destroy();
							}
						}
					} ]
				}
			},
			id : '<portlet:namespace/>sh',
			title : '审核',
			uri : '${shURL}',
			destroyOnClose : true
		});
	}, [ 'aui-dialog' ]);
</script>