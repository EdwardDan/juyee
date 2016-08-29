<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowTask"%>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil"%>
<%@ page import="com.liferay.portal.workflow.kaleo.service.*"%>
<%@ page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@ page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowException"%>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowLog"%>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowLogManagerUtil"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page import="com.liferay.portal.kernel.workflow.comparator.WorkflowComparatorFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<c:set var="contextPath" value="${request.contextPath}/portlet/dept-weekly-work" />

<script type="text/javascript">
	document.write("<script src='${staticServerURL}/jquery/jquery-1.12.4.min.js'>" + "<"+"/script>");
</script>
<style type="text/css">
	.table tr td{
		border:1px solid #ddd;
	}
</style>
<%
	String isView = request.getParameter("isView");
	DeptWork deptWork = (DeptWork) request.getAttribute("deptWork");
	Long leaderId = ParamUtil.getLong(request, "leaderId");
	Long userId = ParamUtil.getLong(request, "userId");
	System.out.println(leaderId+";"+userId);
%>
<portlet:resourceURL var="stateReject" id="stateReject" />
<portlet:resourceURL var="stateToReviewByBranchedLeader" id="stateToReviewByBranchedLeader" />
<script>
function stateReject() {
	$.ajax({
		type:"GET",
		url:"<%=stateReject%>",
				data : {
					'<portlet:namespace/>userId_' : <%=deptWork.getUserId()%>,
				},
				error : function(err) {
					alert("通知失败!");
				},
				success : function(data) {
					
					
				}
			});
}
function stateToReviewByBranchedLeader() {
	$.ajax({
		type:"GET",
		url:"<%=stateToReviewByBranchedLeader%>",
				data : {
					'<portlet:namespace/>leaderId' : <%=leaderId%>,
				},
				error : function(err) {
					alert("通知失败!");
				},
				success : function(data) {
					
					
				}
			});
}
</script>
<portlet:renderURL var="viewURL" />
<liferay-ui:header title="查看一周科室工作" backURL="${viewURL}" />
<aui:row>
	<aui:col span="6">
		<aui:input name="deptName" label="上报科室" value="${deptWork.deptName}" inlineField="true" disabled="true" />
	</aui:col>
	<aui:col span="6">
		<aui:input name="userName" label="申请人" value="${deptWork.userName}" disabled="true" />
	</aui:col>
</aui:row>
<aui:field-wrapper name="上报时间" inlineLabel="true">
	<input name='<portlet:namespace/>startDate' readonly="readonly" value='<fmt:formatDate value="${deptWork.startDate }" pattern="yyyy-MM-dd"/>' />　~　
				<input name="<portlet:namespace/>endDate" readonly="readonly" value='<fmt:formatDate value="${deptWork.endDate }" pattern="yyyy-MM-dd"/>' />
</aui:field-wrapper>
<liferay-ui:search-container>
	<liferay-ui:search-container-results results="${deptWorkItems}">
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="DeptWorkItem" modelVar="DeptWorkItem" keyProperty="deptWorkItemId">
		<liferay-ui:search-container-column-text property="sortNo" name="序号" />
		<liferay-ui:search-container-column-text property="dutyPerson" name="责任人" />
		<liferay-ui:search-container-column-text name="是否重点工作" value="${DeptWorkItem.mainWork ? '是':'否'}" />
		<liferay-ui:search-container-column-text property="content" name="工作内容" />
		<liferay-ui:search-container-column-text property="schedule" name="工作进度" />
		<liferay-ui:search-container-column-text property="agentPerson" name="经办人" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>


<aui:button-row>
	<%
		String strBackUrl = PortalUtil.getPortalURL(request);
			String randomId = StringPool.BLANK;
			String[] assetTypes = new String[1];
			assetTypes[0] = "com.justonetech.oa.model.DeptWork";
			OrderByComparator orderByComparator = null;
			List<WorkflowTask> results1 = null;
			User me = PortalUtil.getUser(request);
			if (null != me) {
		try {
			//遍历工作流任务
			results1 = WorkflowTaskManagerUtil.search(me.getCompanyId(), me.getUserId(), null, assetTypes, null, null, -1, -1, orderByComparator);
		} catch (WorkflowException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		long workflowTaskId = 0L;
		long people = 0L;
		/* long workflowInstance=0L; */
		String url = "";
		List<String> transitionNames = null;//遍历工作流任务
		String token = "";//授权随机代码
		if (null != deptWork) {
			if (results1.size() > 0) {
		//工作流任务
		for (WorkflowTask task : results1) {
			if (null != task) {
				if (KaleoTaskInstanceTokenLocalServiceUtil.getKaleoTaskInstanceToken(task.getWorkflowTaskId()).getClassPK() == deptWork.getDeptWorkId()) {
					workflowTaskId = task.getWorkflowTaskId();
					people = task.getAssigneeUserId();
				}
			}
		}
			}
			token = com.liferay.portal.security.auth.AuthTokenUtil.getToken(request);
			if (workflowTaskId == 0) {
		transitionNames = new ArrayList<String>();
			} else {
		transitionNames = WorkflowTaskManagerUtil.getNextTransitionNames(me.getCompanyId(), me.getUserId(), workflowTaskId);
			}
		}
		for (int i = transitionNames.size() - 1; i >= 0; i--) {
			String transitionName = transitionNames.get(i);
			String message = "proceed";
			if (Validator.isNotNull(transitionName)) {
		message = HtmlUtil.escape(transitionName);
			}
			url = strBackUrl + "/group/control_panel/manage/-/my_workflow_tasks/view/" + workflowTaskId + "?p_auth=" + token + "&p_p_lifecycle=1&doAsGroupId=" + PortalUtil.getUser(request).getGroupId() + "&refererPlid=25177&controlPanelCategory=my&_153_cmd=save&_153_assigneeUserId=" + people + "&_153_redirect=" + strBackUrl + "/group/zhxx/-&_153_struts_action=/my_workflow_tasks/edit_workflow_task&_153_transitionName=" + message;
			if(isView.equals("false")){
	%>

	<div class="hide" id="<%=randomId%>updateComments">
		<aui:input cols="55" name="_153_comment" id="_153_comment" label="审核意见" useNamespace="false" rows="10" type="textarea" />
	</div>
	<!-- 科长批准按钮 -->
	<c:if test='<%=message.equals("approve")&&!leaderId.equals(userId)%>'>
		<liferay-ui:icon cssClass='<%="workflow-task-" + randomId + " task-change-status-link"%>' id='<%=randomId + HtmlUtil.escapeAttribute(transitionName) + "taskChangeStatusLink"%>' image="check" message="<%=message%>" method="get" url="<%=url%>" onClick="stateToReviewByBranchedLeader()"/>
	</c:if>
	<!-- 分管领导批准按钮 -->
	<c:if test='<%=message.equals("approve")&&leaderId.equals(userId)%>'>
		<liferay-ui:icon cssClass='<%="workflow-task-" + randomId + " task-change-status-link"%>' id='<%=randomId + HtmlUtil.escapeAttribute(transitionName) + "taskChangeStatusLink"%>' image="check" message="<%=message%>" method="get" url="<%=url%>" />
	</c:if>
	<c:if test='<%=message.equals("reject")%>'>
		<liferay-ui:icon cssClass='<%="workflow-task-" + randomId + " task-change-status-link"%>' id='<%=randomId + HtmlUtil.escapeAttribute(transitionName) + "taskChangeStatusLink"%>' image="close" message="<%=message%>" method="get" url="<%=url%>" onClick="stateReject()"/>
	</c:if>
	<aui:script use="liferay-workflow-tasks">
		var onTaskClickFn = A.rbind('onTaskClick', Liferay.WorkflowTasks, '<%= randomId %>');
		Liferay.delegateClick('<portlet:namespace /><%= randomId + HtmlUtil.escapeJS(transitionName) %>taskChangeStatusLink', onTaskClickFn);
	</aui:script>
	
	<%
		}
				}
			}
	%>

	<aui:button type="cancel" value="返回" href="${viewURL }" />
</aui:button-row>
<%
	User me = PortalUtil.getUser(request);
	if (null != me) {
%>




<!-- 审核活动详情 -->
<liferay-ui:panel defaultState="closed" title="审核活动">

	<table border="1" class="table table-bordered table-hover">
		<tr>
			<td>时间</td>
			<td>活动</td>
			<td>意见</td>
		</tr>
		<%
			Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);
					List<Integer> logTypes = new ArrayList<Integer>();
					
					System.out.println("me.getCompanyId(), me.getGroupId()" + me.getCompanyId() + "," + me.getGroupId());
					logTypes.add(WorkflowLog.TASK_ASSIGN);
					logTypes.add(WorkflowLog.TASK_COMPLETION);
					logTypes.add(WorkflowLog.TASK_UPDATE);
					logTypes.add(WorkflowLog.TRANSITION);
					System.out.println("this is =" + WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(me.getCompanyId(), 0L, "com.justonetech.oa.model.DeptWork", deptWork.getDeptWorkId()).getWorkflowInstanceId());
					List<WorkflowLog> workflowLogs = WorkflowLogManagerUtil.getWorkflowLogsByWorkflowInstance(company.getCompanyId(), WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(me.getCompanyId(), 0L, "com.justonetech.oa.model.DeptWork", deptWork.getDeptWorkId()).getWorkflowInstanceId(), logTypes, QueryUtil.ALL_POS, QueryUtil.ALL_POS, WorkflowComparatorFactoryUtil.getLogCreateDateComparator(true));

					for (WorkflowLog workflowLog : workflowLogs) {
						Role curRole = null;
						User curUser = null;
						String actorName = null;

						if (workflowLog.getRoleId() != 0) {
							curRole = RoleLocalServiceUtil.getRole(workflowLog.getRoleId());
							actorName = curRole.getDescriptiveName();
						} else if (workflowLog.getUserId() != 0) {
							curUser = UserLocalServiceUtil.getUser(workflowLog.getUserId());
							actorName = curUser.getFullName();
						}
		%>
		<tr>

			<td><%=dateFormatDateTime.format(workflowLog.getCreateDate())%></td>
			<td><c:choose>
					<c:when test="<%=workflowLog.getType() == WorkflowLog.TASK_COMPLETION%>">
						<%=LanguageUtil.format(pageContext, "x-completed-the-task-x", new Object[] { HtmlUtil.escape(actorName), HtmlUtil.escape(workflowLog.getState()) })%>
					</c:when>
					<c:when test="<%=workflowLog.getType() == WorkflowLog.TASK_UPDATE%>">
						<%=LanguageUtil.format(pageContext, "x-updated-the-due-date", HtmlUtil.escape(actorName))%>
					</c:when>
					<c:when test="<%=(workflowLog.getType() == WorkflowLog.TRANSITION)%>">
						<%=LanguageUtil.format(pageContext, "x-changed-the-state-from-x-to-x", new Object[] { HtmlUtil.escape(actorName), HtmlUtil.escape(workflowLog.getPreviousState()), HtmlUtil.escape(workflowLog.getState()) })%>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="<%=(workflowLog.getPreviousUserId() == 0) && (curUser != null)%>">
								<%=LanguageUtil.format(pageContext, curUser.isMale() ? "x-assigned-the-task-to-himself" : "x-assigned-the-task-to-herself", HtmlUtil.escape(curUser.getFullName()))%>
							</c:when>
							<c:otherwise>

								<%
									String previousActorName = null;

									if (curRole == null) {
										previousActorName = PortalUtil.getUserName(workflowLog.getPreviousUserId(), StringPool.BLANK);
								%>

								<%=LanguageUtil.format(pageContext, "task-assigned-to-x.-previous-assignee-was-x", new Object[] { HtmlUtil.escape(actorName), HtmlUtil.escape(previousActorName) })%>

								<%
									} else {
																	previousActorName = curRole.getDescriptiveName();
								%>

								<%=LanguageUtil.format(pageContext, "task-initially-assigned-to-the-x-role", new Object[] { HtmlUtil.escape(actorName) })%>

								<%
									}
								%>

							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose></td>
			<td><%=workflowLog.getComment()%></td>
		</tr>
		<%
			}
		%>
	
</liferay-ui:panel>
<%
	}
%>
