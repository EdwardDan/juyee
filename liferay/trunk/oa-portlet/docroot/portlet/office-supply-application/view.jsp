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
<c:set var="contextPath"
	value="${request.contextPath}/portlet/office-supply-application" />
<portlet:renderURL var="viewURL" />
<%!private boolean isAssignedToUser(long assigneeUserId, User user) {
			if (assigneeUserId == user.getUserId()) {
				return true;
			}
			return false;
	}%>
	<%
		String randomId = StringPool.BLANK;

		String strBackUrl = "http://" + request.getServerName() //服务器地址  
		                    + ":"   
		                    + request.getServerPort() ;          //端口号  
		System.out.println("strBackUrl=" + strBackUrl);
		try {
			request.setAttribute("userId", user.getUserId());
			System.out.println("userId=" + user.getUserId());
			List<UserGroupRole> userGroupRoles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(themeDisplay.getUserId());
			Set<Long> siteRole = new HashSet<Long>();
			 for(UserGroupRole userGroupRole : userGroupRoles) {
				int roleType = userGroupRole.getRole().getType();
					if (roleType == RoleConstants.TYPE_SITE) {
						siteRole.add(userGroupRole.getRoleId());
				}
			}
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
			request.setAttribute("siteRole", siteRole);
			System.out.println("kezhangRole===========" + kezhangRole.toString());
			System.out.println("kezhangGroup=== " + kezhangGroup.toString());
			System.out.println("siteRole=== " + siteRole);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String[] status = new String[] { "未知状态", "填写", "提交", "科长审核通过", "科长审核退回", "办公室主任审核通过", "办公室主任审核退回",
				"已指派科员购买" };
	%>
<aui:nav-bar>
	<aui:nav>
		<portlet:renderURL var="addOfficeSupplyApplicationURL">
			<portlet:param name="mvcPath"
				value="${contextPath }/edit-office-supply-application.jsp" />
		</portlet:renderURL>
		<aui:nav-item href="<%=addOfficeSupplyApplicationURL%>"
			iconCssClass="icon-plus" label="添加" />
	</aui:nav>
</aui:nav-bar>
<liferay-ui:search-container emptyResultsMessage="没有找到办公用品申请信息。">
	<liferay-ui:search-container-results
		results="${officeSupplyApplications}"
		total="${OfficeSupplyApplicationsCount}">
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="OfficeSupplyApplication"
		modelVar="officeSupplyApplication"
		keyProperty="officeSupplyApplicationId">
		<liferay-ui:search-container-column-text property="deptName"
			name="申请部门" />
		<liferay-ui:search-container-column-text property="userName"
			name="申请人" />
		<%
			Date createDate = officeSupplyApplication.getCreateTime();
					String createTime = DateUtil.getDate(createDate, defaultDateFormatPattern, locale, timeZone);
		%>
		<liferay-ui:search-container-column-text value="<%=createTime%>"
			name="申请时间" />
		<liferay-ui:search-container-column-text
			name="status" value="<%=status[officeSupplyApplication.getStatus()]%>"/>
		<liferay-ui:search-container-column-text name="action">
			<portlet:actionURL var="editOfficeSupplyApplicationURL"
				name="editOfficeSupplyApplication">
				<portlet:param name="mvcPath"
					value="${contextPath }/edit-office-supply-application.jsp" />
				<portlet:param name="officeSupplyApplicationId"
					value="${officeSupplyApplication.officeSupplyApplicationId}" />
			</portlet:actionURL>
			<portlet:actionURL var="deleteOfficeSupplyApplicationURL"
				name="deleteOfficeSupplyApplication">
				<portlet:param name="officeSupplyApplicationId"
					value="${officeSupplyApplication.officeSupplyApplicationId}" />
				<portlet:param name="redirect" value="${viewURL }" />
			</portlet:actionURL>
			<portlet:actionURL var="viewOfficeSupplyApplicationURL"
				name="viewOfficeSupplyApplication">
				<portlet:param name="mvcPath"
					value="${contextPath }/view-office-supply-application.jsp" />
				<portlet:param name="officeSupplyApplicationId"
					value="${officeSupplyApplication.officeSupplyApplicationId}" />
			</portlet:actionURL>
			<portlet:actionURL var="approvalOfficeSupplyApplicationURL"
				name="viewOfficeSupplyApplication">
				<portlet:param name="mvcPath"
					value="${contextPath }/view-office-supply-application.jsp" />
				<portlet:param name="officeSupplyApplicationId"
					value="${officeSupplyApplication.officeSupplyApplicationId}" />
				<portlet:param name="isAudit" value="1"/>
			</portlet:actionURL>		

			<liferay-ui:icon-menu>
				<%	//查看登陆人是否符合同一组织内
				randomId = StringUtil.randomId();
					List<UserGroupRole> userGroupRoles = UserGroupRoleLocalServiceUtil
											.getUserGroupRoles(officeSupplyApplication.getUserId());
					List<UserGroupRole> organizationRoles = new ArrayList<UserGroupRole>();
					Set<Long> keyuanGroup = new HashSet<Long>();
					for (UserGroupRole userGroupRole : userGroupRoles) {
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
					String[] assetTypes = new String[1];
				    assetTypes[0]="com.justonetech.oa.model.OfficeSupplyApplication";
				    OrderByComparator orderByComparator = null;				    
				    List<WorkflowTask> results1=null;
			    	User curUser=PortalUtil.getUser(request);
			    	if(null!=curUser){
			    		results1 = WorkflowTaskManagerUtil.search(curUser.getCompanyId(), curUser.getUserId(), null, assetTypes, null, null, -1, -1, orderByComparator);			    	
			    	long workflowTaskId=0L;
			    	long people=0L;
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
			    		request.setAttribute("people", people);
			    		token=com.liferay.portal.security.auth.AuthTokenUtil.getToken(request);
			        if(workflowTaskId==0){
			        	transitionNames=new ArrayList<String>();
			        }else{
			    	transitionNames=WorkflowTaskManagerUtil.getNextTransitionNames(curUser.getCompanyId(), curUser.getUserId(), workflowTaskId);
			    	}
			    	}
			    	String assignToMeURL=strBackUrl+"/group/control_panel/manage/-/my_workflow_tasks/view/"+workflowTaskId+"?p_auth="+token+"&p_p_lifecycle=1&doAsGroupId="+PortalUtil.getUser(request).getGroupId()+"&refererPlid=26954&controlPanelCategory=my&_153_cmd=assign&_153_assigneeUserId="+curUser.getUserId()+"&_153_redirect="+strBackUrl+"/web/guest/sy&_153_struts_action=/my_workflow_tasks/edit_workflow_task";
			    	request.setAttribute("isAssignedToUser",isAssignedToUser(people,curUser));
			    	for(int i=transitionNames.size()-1;i>=0;i--){
	    				String transitionName=transitionNames.get(i);
						String message = "proceed";
						if (Validator.isNotNull(transitionName)) {
							message = HtmlUtil.escape(transitionName);
						}
						request.setAttribute("message", message);
					 url=strBackUrl+"/group/control_panel/manage/-/my_workflow_tasks/view/"+workflowTaskId+"?p_auth="+token+"&p_p_lifecycle=1&doAsGroupId="+PortalUtil.getUser(request).getGroupId()+"&refererPlid=25177&controlPanelCategory=my&_153_cmd=save&_153_assigneeUserId="+people+"&_153_redirect="+strBackUrl+"/web/guest/sy&_153_struts_action=/my_workflow_tasks/edit_workflow_task&_153_transitionName="+message; 
					%>
				<c:if
					test="${(officeSupplyApplication.status==1&&officeSupplyApplication.userId==userId)||(officeSupplyApplication.status==4&&officeSupplyApplication.userId==userId)||(officeSupplyApplication.status==6&&officeSupplyApplication.userId==userId)}">
				 	<liferay-ui:icon
						cssClass='<%= "workflow-task-" + randomId + " task-change-status-link" %>'
						id='<%= randomId + "taskChangeStatusLink" %>'
						image="../aui/random" message="<%=message%>" method="get"
						url="<%=url%>" />
			    </c:if>
				<%
					}
				%>
				<c:if
					test="${officeSupplyApplication.status==2&&fn:contains(kezhangRole,'29656')&&fn:contains(kezhangGroup,oneGroup)&&people<0}">
					<liferay-ui:icon
						cssClass='<%= "workflow-task-" + randomId + " task-assign-to-me-link" %>'
						iconCssClass="icon-signin"
						id='<%= randomId + "taskAssignToMeLink" %>' message="assign-to-me"
						method="get" url="<%= assignToMeURL %>" />
				</c:if>
			 <%-- 	<c:if
					test="${officeSupplyApplication.status==3&&fn:contains(siteRole,'29658')&&isAssignedToUser}">
					<liferay-ui:icon
						cssClass='<%= "workflow-task-" + randomId + " task-assign-to-me-link" %>'
						iconCssClass="icon-signin"
						id='<%= randomId + "taskAssignToMeLink" %>' message="assign-to-me"
						method="get" url="<%= assignToMeURL %>" />
				</c:if>  --%>
				<%
					}
			    %>
				<div class="hide" id="<%=randomId%>updateComments">
					<aui:input cols="55" name="_153_comment" id="_153_comment"
						label="备注" useNamespace="false" rows="10" type="textarea" />
				</div>
				<div class="hide" id="<%=randomId%>updateAsigneeToMe">
					<aui:input name="asigneeUserId" type="hidden"
						value="<%=user.getUserId()%>" />
				</div>
				<c:if test="${(officeSupplyApplication.status==1&&officeSupplyApplication.userId==userId)||(officeSupplyApplication.status==4&&officeSupplyApplication.userId==userId)||(officeSupplyApplication.status==6&&officeSupplyApplication.userId==userId)}">
				<liferay-ui:icon image="edit"
					url="${editOfficeSupplyApplicationURL}" /></c:if>
				<c:if test="${officeSupplyApplication.status==5&&fn:contains(siteRole,'29658')}">
					<liferay-ui:icon image="appoint" url="${editOfficeSupplyApplicationURL}" />
				</c:if>
				<c:if test="${officeSupplyApplication.status==1&&officeSupplyApplication.userId==userId}">				
				<liferay-ui:icon-delete image="delete"
					url="${deleteOfficeSupplyApplicationURL}" /></c:if>
				<liferay-ui:icon image="view"
					url="${viewOfficeSupplyApplicationURL}" />
				<c:if test="${(officeSupplyApplication.status==2&&fn:contains(kezhangRole,'29656')&&isAssignedToUser)||(officeSupplyApplication.status==3&&!fn:contains(kezhangRole,'29656')&&isAssignedToUser)}">
				<liferay-ui:icon image="checked" url="${approvalOfficeSupplyApplicationURL}" /></c:if>
				<aui:script use="liferay-workflow-tasks">
					var onTaskClickFn = A.rbind('onTaskClick', Liferay.WorkflowTasks, '<%= randomId %>');
					Liferay.delegateClick('<portlet:namespace /><%= randomId %>taskAssignToMeLink', onTaskClickFn);						
				</aui:script>
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
  	<liferay-ui:search-iterator />
</liferay-ui:search-container>
