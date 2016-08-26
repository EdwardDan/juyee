<%@page import="com.sun.xml.internal.bind.CycleRecoverable.Context"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowTask" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil" %>
<%@ page import="com.liferay.portal.workflow.kaleo.service.*" %>
<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowException" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.expando.model.ExpandoValue" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.DynamicQuery" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil" %>
<c:set var="contentPath"
	value="${request.contextPath}/portlet/vehicle-application" />
<portlet:renderURL var="viewURL" />
<portlet:actionURL var="deleteVehicleApplicationsURL" name="deleteVehicleApplications">
	<portlet:param name="redirect" value="${viewURL}" />
</portlet:actionURL>
<%!
private boolean isAssignedToUser(long assigneeUserId, User user) {
	if (assigneeUserId == user.getUserId()) {
		return true;
	}

	return false;
}
%>
<% 
String randomId = StringPool.BLANK;
String strBackUrl = "http://" + request.getServerName() //服务器地址  
                    + ":"   
                    + request.getServerPort() ;          //端口号  
                   System.out.println("strBackUrl="+strBackUrl);
try {
	request.setAttribute("userId",user.getUserId());
	System.out.println("userId="+user.getUserId());
	List<Role> userRoles = RoleLocalServiceUtil.getUserRoles(user.getUserId());
	ArrayList<String> roles = new ArrayList<String>();
	for (Role role : userRoles) {
		roles.add(role.getRoleId()+"");
	}
	request.setAttribute("roles", roles.toString());
	System.out.println("roles===========" + roles.toString());
	
	List<UserGroupRole> userGroupRoles = UserGroupRoleLocalServiceUtil. getUserGroupRoles(themeDisplay.getUserId());
	List<UserGroupRole> organizationRoles = new ArrayList<UserGroupRole>();
	Set<Long> kezhangRole = new HashSet<Long>();
	Set<Long> kezhangGroup=new HashSet<Long>();
	for(UserGroupRole userGroupRole : userGroupRoles) {
	int roleType = userGroupRole.getRole().getType();
	if (roleType == RoleConstants.TYPE_ORGANIZATION) {
		organizationRoles.add(userGroupRole);
		kezhangRole.add(userGroupRole.getRoleId());
		kezhangGroup.add(userGroupRole.getGroupId());
		}
	}
	request.setAttribute("kezhangGroup",kezhangGroup.toString());
	request.setAttribute("kezhangRole",kezhangRole.toString());
	System.out.println("kezhangRole===========" + kezhangRole.toString());
	System.out.println("kezhangGroup=== "+ kezhangGroup.toString() );
} catch (SystemException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	String[] status=new String[]{"未知状态","填写","提交","科长审核通过","科长审核退回","办公室主任审核通过","办公室主任审核退回","车辆管理员已调度"};
%>

<aui:form action="${viewURL }" name="fm">
	<aui:nav-bar>
		<aui:nav>
			<portlet:renderURL var="addVehicleApplicationURL">
				<portlet:param name="mvcPath"
					value="${contentPath }/edit-vehicle-aplication.jsp" />
			</portlet:renderURL>
			<c:if test="${!fn:contains(roles,'20162')}">
			<aui:nav-item href="<%=addVehicleApplicationURL%>" iconCssClass="icon-plus"
				label="添加" />
			</c:if>
		</aui:nav>
		<aui:nav-bar-search cssClass="pull-right">
			<div class="form-search">
				<liferay-ui:input-search />
			</div>
		</aui:nav-bar-search>
	</aui:nav-bar>
	<c:if test="${!fn:contains(roles,'20162')}">
	<aui:button-row>
		<aui:button disabled="<%=true%>" name="deleteVehicleApplicationsBtn" value="删除" onClick='<%=renderResponse.getNamespace() + "deleteVehicleApplications();"%>' />
	</aui:button-row>
	</c:if>
	<liferay-ui:search-container emptyResultsMessage="没有找到车辆申请信息。" rowChecker="<%=new RowChecker(renderResponse)%>">
	 <liferay-ui:search-container-results results="${vehicleApplications }"
			total="${vehicleApplicationsCount }">
		</liferay-ui:search-container-results>
		<liferay-ui:search-container-results>
</liferay-ui:search-container-results>
		<liferay-ui:search-container-row className="VehicleApplication" modelVar="vehicleApplication" keyProperty="vehicleApplicationId">
			<liferay-ui:search-container-column-text property="applicantDeptName" name="申请部门" />
			<liferay-ui:search-container-column-text property="applicantName" name="申请人" />
			<liferay-ui:search-container-column-text  name="用车开始时间" value="<%=df.format(vehicleApplication.getStartTime()) %>" />
			<liferay-ui:search-container-column-text  name="用车结束时间" value="<%=df.format(vehicleApplication.getEndTime()) %>"/> 
			<liferay-ui:search-container-column-text property="reason" name="用车事由"/>
			<liferay-ui:search-container-column-text name="状态" value="<%=status[vehicleApplication.getStatus()] %>" />
			<liferay-ui:search-container-column-text>
				<liferay-ui:icon-menu>
				<%
				randomId = StringUtil.randomId();
				//查看登陆人是否符合同一组织内
				 List<UserGroupRole> userGroupRoles = UserGroupRoleLocalServiceUtil. getUserGroupRoles(vehicleApplication.getUserId());
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
			ExpandoValue a=ExpandoValueLocalServiceUtil.getValue(20154L,"com.liferay.portal.model.Organization", "CUSTOM_FIELDS", "分管领导", group2.getClassPK());
			if(null!=a){
				DynamicQuery dq = DynamicQueryFactoryUtil.forClass(User.class).add(PropertyFactoryUtil.forName("firstName").like("%"+a.getData()+"%"));
				List<User> list = UserLocalServiceUtil.dynamicQuery(dq);
				for(User c:list){
					leaderId=c.getUserId();
				}
			}
			request.setAttribute("user3", leaderId);
			
				String[] assetTypes = new String[1];
		    	assetTypes[0]="com.justonetech.oa.model.VehicleApplication";
	    	OrderByComparator orderByComparator=null;
	    	
		    	List<WorkflowTask> results1=null;
		    	User me=PortalUtil.getUser(request);
		    	if(null!=me){
		    		request.setAttribute("me", me.getUserId());
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
		    	if(null!=vehicleApplication){
		    		if(results1.size()>0){
		    		//工作流任务
		    	for(WorkflowTask task:results1){
		    		if(null!=task){
		    			if(KaleoTaskInstanceTokenLocalServiceUtil.getKaleoTaskInstanceToken(task.getWorkflowTaskId()).getClassPK()==vehicleApplication.getVehicleApplicationId()){
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
		    	String assignToMeURL=strBackUrl+"/group/control_panel/manage/-/my_workflow_tasks/view/"+workflowTaskId+"?p_auth="+token+"&p_p_lifecycle=1&doAsGroupId="+PortalUtil.getUser(request).getGroupId()+"&refererPlid=25177&controlPanelCategory=my&_153_cmd=assign&_153_assigneeUserId="+me.getUserId()+"&_153_redirect="+strBackUrl+"/web/guest/shouye&_153_struts_action=/my_workflow_tasks/edit_workflow_task";
		    	request.setAttribute("isAssignedToUser",isAssignedToUser(people,me));
		    	for(int i=transitionNames.size()-1;i>=0;i--){
    				String transitionName=transitionNames.get(i);
					String message = "proceed";
					if (Validator.isNotNull(transitionName)) {
						message = HtmlUtil.escape(transitionName);
					}
				 url=strBackUrl+"/group/control_panel/manage/-/my_workflow_tasks/view/"+workflowTaskId+"?p_auth="+token+"&p_p_lifecycle=1&doAsGroupId="+PortalUtil.getUser(request).getGroupId()+"&refererPlid=25177&controlPanelCategory=my&_153_cmd=save&_153_assigneeUserId="+people+"&_153_redirect="+strBackUrl+"/web/guest/shouye&_153_struts_action=/my_workflow_tasks/edit_workflow_task&_153_transitionName="+message; 
				%>
		<c:if test="${(vehicleApplication.status==1&&vehicleApplication.userId==userId)||(vehicleApplication.status==4&&vehicleApplication.userId==userId)||(vehicleApplication.status==6&&vehicleApplication.userId==userId)}">
			<liferay-ui:icon
				cssClass='<%= "workflow-task-" + randomId + " task-change-status-link" %>'
				id='<%= randomId + "taskChangeStatusLink" %>'
				image="../aui/random"
				message="<%= message %>"
				method="get"
				url="<%=url %>"
			/>
			</c:if>
			<%
		}%>
			<c:if test="${vehicleApplication.status==2&&fn:contains(kezhangRole,'44239')&&fn:contains(kezhangGroup,oneGroup)&&people<0}">
			<liferay-ui:icon
			cssClass='<%= "workflow-task-" + randomId + " task-assign-to-me-link" %>'
			iconCssClass="icon-signin"
			id='<%= randomId + "taskAssignToMeLink" %>'
			message="assign-to-me"
			method="get"
			url="<%= assignToMeURL %>"
		/>
			
		</c:if> 
			<c:if test="${vehicleApplication.status==3&&user3==me&&people<0}">
			<liferay-ui:icon
			cssClass='<%= "workflow-task-" + randomId + " task-assign-to-me-link" %>'
			iconCssClass="icon-signin"
			id='<%= randomId + "taskAssignToMeLink" %>'
			message="assign-to-me"
			method="get"
			url="<%= assignToMeURL %>"
		/>
			</c:if>
			<aui:script use="liferay-workflow-tasks">
var onTaskClickFn = A.rbind('onTaskClick', Liferay.WorkflowTasks,'<%= randomId %>');
Liferay.delegateClick('<portlet:namespace /><%= randomId %>taskAssignToMeLink', onTaskClickFn);
</aui:script>
		<%
		}%>
				<div class="hide" id="<%= randomId %>updateComments">
	<aui:input cols="55" name="_153_comment" id="_153_comment" label="备注" useNamespace="false" rows="10" type="textarea" />
</div>
<div class="hide" id="<%= randomId %>updateAsigneeToMe">
	<aui:input name="asigneeUserId" type="hidden" value="<%= user.getUserId() %>" />
</div>
				
					<portlet:actionURL var="editVehicleApplicationURL" name="editVehicleApplication">
						<portlet:param name="vehicleApplicationId" value="${vehicleApplication.vehicleApplicationId}" />
						<portlet:param name="mvcPath" value="${contentPath }/edit-vehicle-aplication.jsp" />
					</portlet:actionURL>
				 <portlet:actionURL var="viewVehicleApplicationURL" name="editVehicleApplication">
						<portlet:param name="vehicleApplicationId" value="${vehicleApplication.vehicleApplicationId}" />
						<portlet:param name="mvcPath" value="${contentPath }/full_content.jsp" />
				    </portlet:actionURL> 
				     <portlet:actionURL var="auditVehicleApplicationURL" name="editVehicleApplication">
						<portlet:param name="vehicleApplicationId" value="${vehicleApplication.vehicleApplicationId}" />
						<portlet:param name="mvcPath" value="${contentPath }/full_content.jsp" />
						<portlet:param name="isAudit" value="1"/>
				    </portlet:actionURL> 
					<liferay-ui:icon image="view" label="查看" url="${viewVehicleApplicationURL}" />
					<c:if test="${(vehicleApplication.status==1&&vehicleApplication.userId==userId)||(vehicleApplication.status==4&&vehicleApplication.userId==userId)||(vehicleApplication.status==6&&vehicleApplication.userId==userId)||(vehicleApplication.status==5&&fn:contains(roles,'46812'))}"><liferay-ui:icon image="edit" label="编辑" url="${editVehicleApplicationURL}" /> </c:if> 
					<c:if test="${(vehicleApplication.status==2&&fn:contains(kezhangRole,'44239')&&isAssignedToUser)||(vehicleApplication.status==3&&isAssignedToUser)}"><liferay-ui:icon image="checked" label="checked" url="${auditVehicleApplicationURL}" /></c:if>
					<c:if test="${vehicleApplication.status==1&&vehicleApplication.userId==userId}"><liferay-ui:icon image="delete" label="删除" url="javascript:void(0);" onClick='<%=renderResponse.getNamespace() + "deleteVehicleApplications("+vehicleApplication.getVehicleApplicationId()+");"%>' /></c:if>
				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator/>
	</liferay-ui:search-container>
</aui:form>

<aui:script use="liferay-util-window,aui-base">
	
	Liferay.Util.toggleSearchContainerButton('#<portlet:namespace />deleteVehicleApplicationsBtn', '#<portlet:namespace /><%=searchContainerReference.getId("searchContainer")%>SearchContainer', document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
	
	Liferay.provide(
			window,
			'<portlet:namespace />deleteVehicleApplications',
			function(vehicleApplicationIds) {
				if(confirm("确定要删除所选数据吗？")){
					if(!vehicleApplicationIds){
						vehicleApplicationIds = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
					}
					location.href="<%=deleteVehicleApplicationsURL%>&<portlet:namespace />vehicleApplicationIds="+ vehicleApplicationIds;
				}
			},
			['liferay-util-list-fields']
		);
</aui:script>

