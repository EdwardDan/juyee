<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.workflow.*"%>
<%@ page import="com.liferay.portal.kernel.workflow.comparator.WorkflowComparatorFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@ page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowException"%>
<%@ page import="com.liferay.portal.workflow.kaleo.service.*" %>
<script type="text/javascript">
	document.write("<script src='${staticServerURL}/jquery/jquery-1.12.4.min.js'>" + "<"+"/script>");
</script>
<style type="text/css">
	.table tr td{
		border:1px solid #ddd;
	}
</style>
<portlet:renderURL var="viewURL" />
<portlet:resourceURL var="passURL" id="passURL"/>
<portlet:resourceURL var="rejectURL" id="rejectURL"/>
<liferay-ui:header title="查看办公用品申请" backURL="${viewURL}"></liferay-ui:header>
<c:set var="contextPath"
	value="${request.contextPath}/portlet/office-supply-application" />
<%!private boolean isAssignedToUser(long assigneeUserId, User user) {
		if (assigneeUserId == user.getUserId()) {
			return true;
		}
		return false;
	}%>
<%
	String randomId = StringPool.BLANK;
	randomId = StringUtil.randomId();
	String isAudit=request.getParameter("isAudit");
	Long leaderId = 21356L;
	OfficeSupplyApplication officeSupplyApplication = (OfficeSupplyApplication)request.getAttribute("officeSupplyApplication");
	Long userId = officeSupplyApplication.getUserId();
%>
<aui:row>
	<aui:col span="6">
		<aui:input type="hidden" name="officeSupplyApplicationId"
			value="${officeSupplyApplicationId}" />
		<aui:input name="deptName" label="申请部门"
			value="${officeSupplyApplication.deptName}" inlineField="true"
			disabled="true" />
	</aui:col>
	<aui:col span="6">
		<aui:input name="userName" label="申请人"
			value="${officeSupplyApplication.userName}" disabled="true" />
	</aui:col>
</aui:row>
<liferay-ui:search-container>
	<liferay-ui:search-container-results
		results="${officeSupplyApplicationItems}">
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row
		className="OfficeSupplyApplicationItem"
		modelVar="OfficeSupplyApplicationItem"
		keyProperty="officeSupplyApplicationItemId">
		<liferay-ui:search-container-column-text property="name" name="申请物品" />
		<liferay-ui:search-container-column-text property="model" name="型号" />
		<liferay-ui:search-container-column-text property="unit" name="单位" />
		<liferay-ui:search-container-column-text property="unitPrice"
			name="预计单价" />
		<liferay-ui:search-container-column-text property="quantity" name="数量" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
<table width="100%">
	<tr>
		<td align="right"><aui:input id="sum" name="sum" label="预计总价"
				value="${sum}" inlineLabel="left" readonly="true" /></td>
	</tr>
</table>
<aui:row>
	<aui:col span="12">
		<aui:input type="textarea" name="introductions" label="申请说明"
			value="${officeSupplyApplication.introductions}" disabled="true"
			cssClass="input-block-level" />
	</aui:col>
</aui:row>
<c:if test="${officeSupplyApplication.status==7}">
	<aui:input type="text" name="perposeClerk" label="指派科员" readonly="true"
		value="${officeSupplyApplication.perposeClerk}" />
</c:if>
<aui:button-row>
	<%
		String strBackUrl = "http://" + request.getServerName() //服务器地址  
	        + ":"   
	        + request.getServerPort() ;          //端口号  
	       System.out.println("strBackUrl="+strBackUrl);
	    
	 	try {
		request.setAttribute("userId", user.getUserId());
		System.out.println("userId=" + user.getUserId());
		
		List<Role> userRoles = RoleLocalServiceUtil.getUserRoles(user.getUserId());
		ArrayList<String> roles = new ArrayList<String>();
		for (Role role : userRoles) {
			roles.add(role.getRoleId() + "");
		}
		request.setAttribute("roles", roles.toString());
		System.out.println("roles===========" + roles.toString());
		List<UserGroupRole> userGroupRoles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(themeDisplay
				.getUserId());
		List<UserGroupRole> organizationRoles = new ArrayList<UserGroupRole>();
		Set<Long> kezhangRole = new HashSet<Long>();
		Set<Long> kezhangGroup = new HashSet<Long>();
		for (UserGroupRole userGroupRole : userGroupRoles) {
			int roleType = userGroupRole.getRole().getType();
			if (roleType == RoleConstants.TYPE_ORGANIZATION) {
				organizationRoles.add(userGroupRole);
				kezhangRole.add(userGroupRole.getRoleId());
				kezhangGroup.add(userGroupRole.getGroupId());
			}
		}
		request.setAttribute("kezhangGroup", kezhangGroup.toString());
		request.setAttribute("kezhangRole", kezhangRole.toString());
		System.out.println("kezhangRole===========" + kezhangRole.toString());
		System.out.println("kezhangGroup=== " + kezhangGroup.toString());
			} catch (SystemException e) {
		e.printStackTrace();
			}
			String[] assetTypes = new String[1];
			    	assetTypes[0]="com.justonetech.oa.model.officeSupplyApplication";
		    	OrderByComparator orderByComparator=null;
			    	List<WorkflowTask> results1=null;
			    	User curUser=PortalUtil.getUser(request);
			    	if(null!=curUser){
			    		try {
			    			//遍历工作流任务
			    		results1= WorkflowTaskManagerUtil.search(curUser.getCompanyId(), curUser.getUserId(), null, assetTypes, null, null, -1, -1, orderByComparator);
			} catch (WorkflowException e3) {
				e3.printStackTrace();
			}
			    	long workflowTaskId=0L;
			    	long people=0L;
			    	/* long workflowInstance=0L; */
			    	String url="";
			    	List<String> transitionNames = null;//遍历工作流任务
			    	String token="";//授权随机代码
			    	if(null!=officeSupplyApplication){
			    		if(results1.size()>0){
			    		//工作流任务
			    	for(WorkflowTask task:results1){
			    		if(null!=task){
			    			if(KaleoTaskInstanceTokenLocalServiceUtil.getKaleoTaskInstanceToken(task.getWorkflowTaskId()).getClassPK()==officeSupplyApplication.getOfficeSupplyApplicationId()){
			    				workflowTaskId=task.getWorkflowTaskId();
						people=task.getAssigneeUserId();
				}
			    		}
			    	}
			    		}
			    		token=com.liferay.portal.security.auth.AuthTokenUtil.getToken(request);
			        if(workflowTaskId==0){
			        	transitionNames=new ArrayList<String>();
			        }else{
			    	transitionNames=WorkflowTaskManagerUtil.getNextTransitionNames(curUser.getCompanyId(), curUser.getUserId(), workflowTaskId);
			    	}
			    	}
			    			for(int i=transitionNames.size()-1;i>=0;i--){
			    				String transitionName=transitionNames.get(i);
				String message = "proceed";
				if (Validator.isNotNull(transitionName)) {
					message = HtmlUtil.escape(transitionName);
				}
			 url=strBackUrl+"/group/control_panel/manage/-/my_workflow_tasks/view/"+workflowTaskId+"?p_auth="+token+"&p_p_lifecycle=1&doAsGroupId="+PortalUtil.getUser(request).getGroupId()+"&refererPlid=25177&controlPanelCategory=my&_153_cmd=save&_153_assigneeUserId="+people+"&_153_redirect="+strBackUrl+"/web/guest/sy&_153_struts_action=/my_workflow_tasks/edit_workflow_task&_153_transitionName="+message;
			 if(isAudit!=null){
					if(isAudit.equals("1")){
	%>
	<div class="hide" id="<%=randomId%>updateComments">
		<aui:input cols="55" name="_153_comment" id="_153_comment"
			label="审核意见" useNamespace="false" rows="10" type="textarea" />
	</div>
	<c:if test="${isAudit!=''}">
		<c:if
			test="${officeSupplyApplication.status==2&&fn:contains(kezhangRole,'29656')||officeSupplyApplication.status==3&&fn:contains(roles,'20165')}">
			<c:if test='<%=message.equals("通过")%>'>
				<liferay-ui:icon
					cssClass='<%="workflow-task-" + randomId + " task-change-status-link"%>'
					id='<%=randomId + HtmlUtil.escapeAttribute(transitionName) + "taskChangeStatusLink"%>'
					image="pass" message="<%=message%>" method="get"
					url="<%=url%>" onClick="pass()"/>
			</c:if>
			<c:if test='<%=message.equals("驳回")%>'>
				<liferay-ui:icon
					cssClass='<%="workflow-task-" + randomId + " task-change-status-link"%>'
					id='<%=randomId + HtmlUtil.escapeAttribute(transitionName) + "taskChangeStatusLink"%>'
					image="reject" message="<%=message%>" method="get"
					url="<%=url%>" onClick="reject()"/>
			</c:if>
		</c:if>
	</c:if>
	<aui:script use="liferay-workflow-tasks">
		var onTaskClickFn = A.rbind('onTaskClick', Liferay.WorkflowTasks, '<%= randomId %>');
		Liferay.delegateClick(
				'<portlet:namespace /><%= randomId + HtmlUtil.escapeJS(transitionName) %>taskChangeStatusLink',
				onTaskClickFn);
	</aui:script>	
	<%
					}
				}
			}
		}
	%>
	<aui:button type="cancel" value="返回" href="${viewURL}" />
</aui:button-row>
<script>
	function pass(){
		$.ajax({
			type:"GET",
			url:"<%=passURL%>",
			data:{
				'<portlet:namespace/>leaderId' :<%=leaderId%>,
			}
		});
	}
	
	function reject(){		
		$.ajax({
			type:"GET",
			url:"<%=rejectURL%>",
			data:{
				'<portlet:namespace/>userId' :<%=userId%>,
			}
		});
		alert(123456);
	}
</script>	
<%
	User me = PortalUtil.getUser(request);
	if (null != me) {
%>
<liferay-ui:panel defaultState="open" title="审核活动">
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
					System.out.println("this is ="
							+ WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(me.getCompanyId(), 0L,
									"com.justonetech.oa.model.OfficeSupplyApplication",
									officeSupplyApplication.getOfficeSupplyApplicationId()).getWorkflowInstanceId());
					List<WorkflowLog> workflowLogs = WorkflowLogManagerUtil.getWorkflowLogsByWorkflowInstance(
							company.getCompanyId(),
							WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(me.getCompanyId(), 0L,
									"com.justonetech.oa.model.OfficeSupplyApplication",
									officeSupplyApplication.getOfficeSupplyApplicationId()).getWorkflowInstanceId(),
							logTypes, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
							WorkflowComparatorFactoryUtil.getLogCreateDateComparator(true));

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
					<c:when
						test="<%=workflowLog.getType() == WorkflowLog.TASK_COMPLETION%>">
						<%=LanguageUtil.format(pageContext, "x-completed-the-task-x", new Object[] {
										HtmlUtil.escape(actorName), HtmlUtil.escape(workflowLog.getState()) })%>
					</c:when>
					<c:when
						test="<%=workflowLog.getType() == WorkflowLog.TASK_UPDATE%>">
						<%=LanguageUtil.format(pageContext, "x-updated-the-due-date",
										HtmlUtil.escape(actorName))%>
					</c:when>
					<c:when
						test="<%=(workflowLog.getType() == WorkflowLog.TRANSITION)%>">
						<%=LanguageUtil.format(
										pageContext,
										"x-changed-the-state-from-x-to-x",
										new Object[] { HtmlUtil.escape(actorName),
												HtmlUtil.escape(workflowLog.getPreviousState()),
												HtmlUtil.escape(workflowLog.getState()) })%>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when
								test="<%=(workflowLog.getPreviousUserId() == 0) && (curUser != null)%>">
								<%=LanguageUtil.format(pageContext,
												curUser.isMale() ? "x-assigned-the-task-to-himself"
														: "x-assigned-the-task-to-herself", HtmlUtil.escape(curUser
														.getFullName()))%>
							</c:when>
							<c:otherwise>

								<%
									String previousActorName = null;

																if (curRole == null) {
																	previousActorName = PortalUtil.getUserName(workflowLog.getPreviousUserId(),
																			StringPool.BLANK);
								%>

								<%=LanguageUtil.format(
													pageContext,
													"task-assigned-to-x.-previous-assignee-was-x",
													new Object[] { HtmlUtil.escape(actorName),
															HtmlUtil.escape(previousActorName) })%>

								<%
									} else {
																	previousActorName = curRole.getDescriptiveName();
								%>

								<%=LanguageUtil.format(pageContext,
													"task-initially-assigned-to-the-x-role",
													new Object[] { HtmlUtil.escape(actorName) })%>

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

