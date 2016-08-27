<%@page import="com.sun.xml.internal.bind.CycleRecoverable.Context"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
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
<%@ page import="com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil"%>
<%@ page import="com.liferay.portlet.expando.model.ExpandoValue"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<c:set var="contextPath" value="${request.contextPath}/portlet/dept-weekly-work" />
<portlet:renderURL var="viewURL" />
<script type="text/javascript">
	document.write("<script src='${staticServerURL}/jquery/jquery-1.12.4.min.js'>" + "<"+"/script>");
</script>
<%!private boolean isAssignedToUser(long assigneeUserId, User user) {
		if (assigneeUserId == user.getUserId()) {
			return true;
		}
		return false;
	}%>
<%
	String randomId = StringPool.BLANK;
	randomId = StringUtil.randomId();
	String strBackUrl = PortalUtil.getPortalURL(request);
	Long organizationId = 0L;
	try {
		request.setAttribute("userId",user.getUserId());
		List<Role> userRoles = RoleLocalServiceUtil.getUserRoles(user.getUserId());
		ArrayList<String> roles = new ArrayList<String>();
		for (Role role : userRoles) {
			roles.add(role.getRoleId()+"");
		}
		request.setAttribute("roles", roles.toString());
		System.out.println("roles:" + roles.toString());
		List<UserGroupRole> userGroupRoles = UserGroupRoleLocalServiceUtil. getUserGroupRoles(themeDisplay.getUserId());
		List<UserGroupRole> organizationRoles = new ArrayList<UserGroupRole>();
		List<UserGroupRole> siteRoles = new ArrayList<UserGroupRole>();
		Set<Long> kezhangRole = new HashSet<Long>();
		Set<Long> kezhangGroup = new HashSet<Long>();
		if(userGroupRoles!=null&&userGroupRoles.size()>0){
			organizationId = userGroupRoles.get(0).getGroupId()-1;
		}
		
		for(UserGroupRole userGroupRole : userGroupRoles) {
		int roleType = userGroupRole.getRole().getType();
		if (roleType == RoleConstants.TYPE_ORGANIZATION) {
		
	organizationRoles.add(userGroupRole);
	kezhangRole.add(userGroupRole.getRoleId());
	kezhangGroup.add(userGroupRole.getGroupId());
	}
		if (roleType == RoleConstants.TYPE_SITE) {
		siteRoles.add(userGroupRole);
	}
		}
		request.setAttribute("kezhangGroup",kezhangGroup.toString());
		request.setAttribute("kezhangRole",kezhangRole.toString());
		System.out.println("kezhangRole:" + kezhangRole.toString());
		System.out.println("kezhangGroup:"+ kezhangGroup.toString() );
	} catch (SystemException e) {
		e.printStackTrace();
	}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String[] status=new String[]{"未知状态","填写","提交","科长审核通过","科长审核退回","分管领导审核通过","分管领导审核退回","系统记录"};
%>

<aui:nav-bar>
	<aui:nav>
		<portlet:renderURL var="addDeptWeeklyWorkURL">
			<portlet:param name="mvcPath" value="${contextPath }/edit-dept-weekly-work.jsp" />
		</portlet:renderURL>
		<aui:nav-item href="<%=addDeptWeeklyWorkURL%>" iconCssClass="icon-plus" label="添加" />
	</aui:nav>
</aui:nav-bar>
<liferay-ui:search-container emptyResultsMessage="没有找到科室一周工作。">
	<liferay-ui:search-container-results results="${deptWorks}" total="${deptWorkCount}">
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="DeptWork" modelVar="deptWork" keyProperty="deptWorkId">
		<liferay-ui:search-container-column-text property="deptName" name="上报科室" />
		<liferay-ui:search-container-column-text property="userName" name="提交人" />
		<liferay-ui:search-container-column-text name="工作时间">
			<%=DateUtil.getDate(deptWork.getStartDate(), "yyyy-MM-dd", locale, timeZone)%>　~　
				<%=DateUtil.getDate(deptWork.getEndDate(), "yyyy-MM-dd", locale, timeZone)%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="状态" value="<%=status[deptWork.getStatus()]%>" />
		<liferay-ui:search-container-column-text>
			<liferay-ui:icon-menu>
				<%
					//查看登陆人是否符合同一组织内
									List<UserGroupRole> userGroupRoles = UserGroupRoleLocalServiceUtil. getUserGroupRoles(deptWork.getUserId());
									List<UserGroupRole> organizationRoles = new ArrayList<UserGroupRole>();
									Set<Long> keyuanGroup = new HashSet<Long>();
									for(UserGroupRole userGroupRole : userGroupRoles) {
									int roleType = userGroupRole.getRole().getType();
										if (roleType == RoleConstants.TYPE_ORGANIZATION) {
											keyuanGroup.add(userGroupRole.getGroupId());
											}
										}
									Iterator<Long> it = keyuanGroup.iterator();
									Long oneGroup=0L;
									while(it.hasNext()){
										//一般科员只有一个部门
									oneGroup=it.next();
									}
									//用来判断，提交人的groupId是否和科长的groupId一致
									request.setAttribute("oneGroup", oneGroup.toString());
									Long leaderId=0L;
									User user3=null;
									Group group2=GroupLocalServiceUtil.getGroup(oneGroup);
									ExpandoValue a = ExpandoValueLocalServiceUtil.getValue(20154L,"com.liferay.portal.model.Organization", "CUSTOM_FIELDS", "分管领导", group2.getClassPK());
									if(null!=a){
										DynamicQuery dq = DynamicQueryFactoryUtil.forClass(User.class).add(PropertyFactoryUtil.forName("firstName").like("%"+a.getData()+"%"));
										List<User> list = UserLocalServiceUtil.dynamicQuery(dq);
										
										for(User c:list){
										leaderId=c.getUserId();
										}
									}
									request.setAttribute("leaderId", leaderId);
									
									
											String[] assetTypes = new String[1];
													assetTypes[0]="com.justonetech.oa.model.DeptWork";
													OrderByComparator orderByComparator=null;
																	    	
													List<WorkflowTask> results1=null;
													User me=PortalUtil.getUser(request);
													if(null!=me){
														try {
															//遍历工作流任务
															results1= WorkflowTaskManagerUtil.search(me.getCompanyId(), me.getUserId(), null, assetTypes, null, null, -1, -1, orderByComparator);
														} catch (WorkflowException e3) {
															// TODO Auto-generated catch block
															e3.printStackTrace();
														}
														long workflowTaskId=0L;
														long people=0L;
														String url="";
														List<String> transitionNames = null;//遍历工作流任务
														String token="";//授权随机代码
														if(null!=deptWork){
															if(results1.size()>0){
																//工作流任务
																for(WorkflowTask task:results1){
																	if(null!=task){
																		if(KaleoTaskInstanceTokenLocalServiceUtil.getKaleoTaskInstanceToken(task.getWorkflowTaskId()).getClassPK()==deptWork.getDeptWorkId()){
																		    workflowTaskId=task.getWorkflowTaskId();
																			people=task.getAssigneeUserId();
																	}
																}
															}
														}
													request.setAttribute("people", people);
													token=com.liferay.portal.security.auth.AuthTokenUtil.getToken(request);
													if(workflowTaskId==0){
														transitionNames=new ArrayList<String>();
													}else{
														transitionNames=WorkflowTaskManagerUtil.getNextTransitionNames(me.getCompanyId(), me.getUserId(), workflowTaskId);
													}
												}
												String assignToMeURL=strBackUrl+"/group/control_panel/manage/-/my_workflow_tasks/view/"+workflowTaskId+"?p_auth="+token+"&p_p_lifecycle=1&doAsGroupId="+PortalUtil.getUser(request).getGroupId()+"&refererPlid=25177&controlPanelCategory=my&_153_cmd=assign&_153_assigneeUserId="+me.getUserId()+"&_153_redirect="+strBackUrl+"/group/zhxx/-&_153_struts_action=/my_workflow_tasks/edit_workflow_task";
												request.setAttribute("isAssignedToUser",isAssignedToUser(people,me));
												for(int i=transitionNames.size()-1;i>=0;i--){
													String transitionName=transitionNames.get(i);
													String message = "proceed";
												if (Validator.isNotNull(transitionName)) {
													message = HtmlUtil.escape(transitionName);
												}
												url=strBackUrl+"/group/control_panel/manage/-/my_workflow_tasks/view/"+workflowTaskId+"?p_auth="+token+"&p_p_lifecycle=1&doAsGroupId="+PortalUtil.getUser(request).getGroupId()+"&refererPlid=25177&controlPanelCategory=my&_153_cmd=save&_153_assigneeUserId="+people+"&_153_redirect="+strBackUrl+"/group/zhxx/-&_153_struts_action=/my_workflow_tasks/edit_workflow_task&_153_transitionName="+message;
				%>
				<c:if test="${(deptWork.status==1&&deptWork.userId==userId)||(deptWork.status==4&&deptWork.userId==userId)||(deptWork.status==6&&deptWork.userId==userId)}">
					<liferay-ui:icon cssClass='<%="workflow-task-" + randomId + " task-change-status-link"%>' id='<%=randomId + "taskChangeStatusLink"%>' image="../aui/random" message="<%=message%>" method="get" url="<%=url%>" onClick="stateToReviewBySectionChief()" />
				</c:if>
				<%
					}
				%>
				<c:if test="${deptWork.status==2&&fn:contains(kezhangRole,'29829')&&people<0}">
					<liferay-ui:icon cssClass='<%="workflow-task-" + randomId + " task-assign-to-me-link"%>' iconCssClass="icon-signin" id='<%=randomId + "taskAssignToMeLink"%>' message="assign-to-me" method="get" url="<%=assignToMeURL%>" />
				</c:if>
				<c:if test="${deptWork.status==3&&leaderId==userId&&people<0}">
					<liferay-ui:icon cssClass='<%="workflow-task-" + randomId + " task-assign-to-me-link"%>' iconCssClass="icon-signin" id='<%=randomId + "taskAssignToMeLink"%>' message="assign-to-me" method="get" url="<%=assignToMeURL%>" />
				</c:if>
				<%
					}
				%>
				<div class="hide" id="<%=randomId%>updateComments">
					<aui:input cols="55" name="comment" rows="10" type="textarea" />
				</div>
				<div class="hide" id="<%=randomId%>updateAsigneeToMe">
					<aui:input name="asigneeUserId" type="hidden" value="<%=user.getUserId()%>" />
				</div>

				<c:set var="contextPath" value="${request.contextPath}/portlet/dept-weekly-work" />

				<portlet:actionURL var="editDeptWeeklyWorkURL" name="editDeptWeeklyWork">
					<portlet:param name="deptWorkId" value="${deptWork.deptWorkId}" />
					<portlet:param name="mvcPath" value="${contextPath}/edit-dept-weekly-work.jsp" />
				</portlet:actionURL>

				<portlet:actionURL var="viewDeptWeeklyWorkURL" name="viewDeptWeeklyWork">
					<portlet:param name="deptWorkId" value="${deptWork.deptWorkId}" />
					<portlet:param name="mvcPath" value="${contextPath}/view-dept-weekly-work.jsp" />
					<portlet:param name="isView" value="true" />
				</portlet:actionURL>

				<portlet:actionURL var="checkDeptWeeklyWorkURL" name="viewDeptWeeklyWork">
					<portlet:param name="deptWorkId" value="${deptWork.deptWorkId}" />
					<portlet:param name="mvcPath" value="${contextPath}/view-dept-weekly-work.jsp" />
					<portlet:param name="isView" value="false" />
					<portlet:param name="leaderId" value="${leaderId}" />
					<portlet:param name="userId" value="${user.getUserId()}" />
				</portlet:actionURL>

				<portlet:actionURL var="deleteDeptWeeklyWorkURL" name="deleteDeptWeeklyWork">
					<portlet:param name="deptWorkId" value="${deptWork.deptWorkId}" />
					<portlet:param name="redirect" value="${viewURL}" />
				</portlet:actionURL>

				<liferay-ui:icon image="view" label="view" url="${viewDeptWeeklyWorkURL}" />

				<c:if test="${deptWork.status==2&&fn:contains(kezhangRole,'29829')&&isAssignedToUser}">
					<liferay-ui:icon image="checked" label="checked" url="${checkDeptWeeklyWorkURL}" />
				</c:if>

				<c:if test="${deptWork.status==3&&leaderId==userId&&isAssignedToUser}">
					<liferay-ui:icon image="checked" label="checked" url="${checkDeptWeeklyWorkURL}" />
				</c:if>

				<c:if test="${deptWork.status == 0&&userId==deptWork.userId || deptWork.status == 1&&userId==deptWork.userId || deptWork.status == 4&&userId==deptWork.userId || deptWork.status == 6&&userId==deptWork.userId}">
					<liferay-ui:icon image="edit" label="edit" url="${editDeptWeeklyWorkURL}" />
					<liferay-ui:icon-delete image="delete" url="${deleteDeptWeeklyWorkURL}" />
				</c:if>
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>



<aui:script use="liferay-workflow-tasks">
	var onTaskClickFn = A.rbind(Liferay.WorkflowTasks.onTaskClick, Liferay.WorkflowTasks, '');
	Liferay.delegateClick('<portlet:namespace />taskAssignToMeLink', onTaskClickFn);
</aui:script>

<portlet:resourceURL var="stateToReviewBySectionChief" id="stateToReviewBySectionChief" />
<script>
	function stateToReviewBySectionChief(){
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
</script>
