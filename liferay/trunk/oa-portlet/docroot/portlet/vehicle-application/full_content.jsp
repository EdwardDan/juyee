<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="com.justonetech.oa.model.VehicleApplication"%>   
<%@ include file="/common/init.jsp" %>   
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowTask" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil" %>
<%@ page import="com.liferay.portal.workflow.kaleo.service.*" %>
<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowException" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowLog" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowLogManagerUtil" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.workflow.comparator.WorkflowComparatorFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%   
String randomId = StringPool.BLANK;
randomId = StringUtil.randomId();
String isAudit=request.getParameter("isAudit");
VehicleApplication vehicleApplication = (VehicleApplication)request.getAttribute("vehicleApplication");   
String proposeVehicle="";
if(vehicleApplication.getProposeVehicle()!=0&&vehicleApplication.getProposeVehicle()!=1){
	proposeVehicle=DictionaryLocalServiceUtil.getDictionary(vehicleApplication.getProposeVehicle()).getName();
}
%>   
<portlet:renderURL var="viewURL" />
<aui:fieldset>
		<aui:row>
			<aui:col span="6" cssClass="">
				<aui:input name="applicantDeptName" label="申请部门名称:" value="<%= vehicleApplication.getApplicantDeptName()%>" readonly="true"/>
			</aui:col>
			<aui:col span="6" cssClass="">
				<aui:input name="applicantName" label="申请人:" value="<%= vehicleApplication.getApplicantName()%>" readonly="true"/>
			</aui:col>
		</aui:row>
		 <aui:row>
			<aui:col span="6" cssClass="">
					<aui:input name="startTime" label="开始时间:" value="<%= DateUtil.getDate(vehicleApplication.getStartTime(), defaultDateFormatPattern, locale, timeZone)%>" readonly="true"></aui:input>
				<br>
			</aui:col>
			<aui:col span="6" cssClass="">
				<aui:input name="endTime" label="结束时间:" value="<%= DateUtil.getDate(vehicleApplication.getEndTime(), defaultDateFormatPattern, locale, timeZone)%>" readonly="true"></aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="6" cssClass="">
				<aui:input name="passengerNum" label="用车人数:" value="<%= vehicleApplication.getPassengerNum()%>" readonly="true">
				</aui:input>
			</aui:col>
			<aui:col span="6" cssClass="">
				<aui:input name="destination" label="目的地:" value="<%= vehicleApplication.getDestination()%>" readonly="true"/>
			</aui:col>
		</aui:row>
		
		<aui:row>
			<aui:col span="12">
				<aui:input name="reason" label="用车事由:" type="textarea" value="<%= vehicleApplication.getReason()%>" readonly="true" style="width:45%;height:100px"/>
			</aui:col>
		</aui:row> 
		<c:if test="${vehicleApplication.status==7}">
		<aui:row>
		<aui:col span="6" cssClass="">
			<aui:input name="isProposeDriver" type="text"  label="是否拟派车辆:" value="${vehicleApplication.isProposeDriver==1?'是':'否'}" readonly="true"/>
			</aui:col>
			<aui:col span="6" cssClass="">
			<aui:input name="proposeVehicle" label="拟派车辆:" value="<%=proposeVehicle%>" readonly="true"/>
				<%-- <aui:select name="proposeVehicle" label="拟派车辆:" inlineField="true"
					inlineLabel="left" type="select" style="width:100px">
					<aui:option value="0" selected="${vehicleApplication.proposeVehicle eq 0}">沪A12345</aui:option>
					<aui:option value="1" selected="${vehicleApplication.proposeVehicle eq 1}">沪B12345</aui:option>
				</aui:select> --%>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="6" cssClass="">
				<aui:input name="driver" label="司机:" value="${vehicleApplication.driver}" readonly="true">
				</aui:input>
			</aui:col>
			<aui:col span="6" cssClass="">
				<aui:input name="phone" label="电话:" value="${vehicleApplication.phone}" readonly="true"></aui:input>
			</aui:col>
		</aui:row>
		</c:if>
	</aui:fieldset>
	<aui:button-row>
		<%
		String strBackUrl = "http://" + request.getServerName() //服务器地址  
        + ":"   
        + request.getServerPort() ;          //端口号  
       System.out.println("strBackUrl="+strBackUrl);
				String[] assetTypes = new String[1];
		    	assetTypes[0]="com.justonetech.oa.model.VehicleApplication";
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
		    	/* long workflowInstance=0L; */
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
		    		token=com.liferay.portal.security.auth.AuthTokenUtil.getToken(request);
		        if(workflowTaskId==0){
		        	transitionNames=new ArrayList<String>();
		        }else{
		    	transitionNames=WorkflowTaskManagerUtil.getNextTransitionNames(me.getCompanyId(), me.getUserId(), workflowTaskId);
		    	}
		    	}
		    			for(int i=transitionNames.size()-1;i>=0;i--){
		    				String transitionName=transitionNames.get(i);
					String message = "proceed";
					if (Validator.isNotNull(transitionName)) {
						message = HtmlUtil.escape(transitionName);
					}
				 url=strBackUrl+"/group/control_panel/manage/-/my_workflow_tasks/view/"+workflowTaskId+"?p_auth="+token+"&p_p_lifecycle=1&doAsGroupId="+PortalUtil.getUser(request).getGroupId()+"&refererPlid=25177&controlPanelCategory=my&_153_cmd=save&_153_assigneeUserId="+people+"&_153_redirect="+strBackUrl+"/web/guest/shouye&_153_struts_action=/my_workflow_tasks/edit_workflow_task&_153_transitionName="+message;
				 if(isAudit!=null){
						if(isAudit.equals("1")){

				%>
				<div class="hide" id="<%= randomId %>updateComments">
	<aui:input cols="55" name="_153_comment" id="_153_comment" label="审核意见" useNamespace="false" rows="10" type="textarea" />
</div>
		<%-- <aui:button type="button" value="<%=message %>" href="<%=url %>"/>  --%>
		<c:if test='<%=message.equals("通过") %>'>
		<liferay-ui:icon
				cssClass='<%= "workflow-task-" + randomId + " task-change-status-link" %>'
				id='<%= randomId + HtmlUtil.escapeAttribute(transitionName) + "taskChangeStatusLink" %>'
				image="check"
				message="<%= message %>"
				method="get"
				url="<%= url %>"
			/>
			</c:if>
			<c:if test='<%=message.equals("驳回") %>'>
		<liferay-ui:icon
				cssClass='<%= "workflow-task-" + randomId + " task-change-status-link" %>'
				id='<%= randomId + HtmlUtil.escapeAttribute(transitionName) + "taskChangeStatusLink" %>'
				image="close"
				message="<%= message %>"
				method="get"
				url="<%= url %>"
			/>
			</c:if>
			<aui:script use="liferay-workflow-tasks">
var onTaskClickFn = A.rbind('onTaskClick', Liferay.WorkflowTasks,'<%= randomId %>');
Liferay.delegateClick('<portlet:namespace /><%= randomId + HtmlUtil.escapeJS(transitionName) %>taskChangeStatusLink', onTaskClickFn);
</aui:script>
		
				<%
		}}
		    		}
		    	}
		%>
		<aui:button type="cancel" value="返回" href="${viewURL }" />
	</aui:button-row>
	<% User me=PortalUtil.getUser(request);
				if(null!=me){%>
	<liferay-ui:panel defaultState="open" title="审核活动">

<table border="1" class="table table-bordered table-hover">
	<tr>

		<th>时间</th>
		<th>活动</th>
		<th>意见</th>
	</tr>



				<%
				Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);
				List<Integer> logTypes = new ArrayList<Integer>();
				
				System.out.println("me.getCompanyId(), me.getGroupId()"+me.getCompanyId()+","+me.getGroupId());
				logTypes.add(WorkflowLog.TASK_ASSIGN);
				logTypes.add(WorkflowLog.TASK_COMPLETION);
				logTypes.add(WorkflowLog.TASK_UPDATE);
				logTypes.add(WorkflowLog.TRANSITION);
				System.out.println("this is ="+WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(me.getCompanyId(), 0L, "com.justonetech.oa.model.VehicleApplication", vehicleApplication.getVehicleApplicationId()).getWorkflowInstanceId());
				List<WorkflowLog> workflowLogs = WorkflowLogManagerUtil.getWorkflowLogsByWorkflowInstance(company.getCompanyId(), WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(me.getCompanyId(), 0L, "com.justonetech.oa.model.VehicleApplication", vehicleApplication.getVehicleApplicationId()).getWorkflowInstanceId(), logTypes, QueryUtil.ALL_POS, QueryUtil.ALL_POS, WorkflowComparatorFactoryUtil.getLogCreateDateComparator(true));

				for (WorkflowLog workflowLog : workflowLogs) {
					Role curRole = null;
					User curUser = null;
					String actorName = null;

					if (workflowLog.getRoleId() != 0) {
						curRole = RoleLocalServiceUtil.getRole(workflowLog.getRoleId());
						actorName = curRole.getDescriptiveName();
					}
					else if (workflowLog.getUserId() != 0) {
						curUser = UserLocalServiceUtil.getUser(workflowLog.getUserId());
						actorName = curUser.getFullName();
					}
				%>
<tr>

		<td><%=dateFormatDateTime.format(workflowLog.getCreateDate())%></td>
		<td><c:choose>
								<c:when test="<%= workflowLog.getType() == WorkflowLog.TASK_COMPLETION %>">
									<%= LanguageUtil.format(pageContext, "x-completed-the-task-x", new Object[] {HtmlUtil.escape(actorName), HtmlUtil.escape(workflowLog.getState())}) %>
								</c:when>
								<c:when test="<%= workflowLog.getType() == WorkflowLog.TASK_UPDATE %>">
									<%= LanguageUtil.format(pageContext, "x-updated-the-due-date", HtmlUtil.escape(actorName)) %>
								</c:when>
								<c:when test="<%= (workflowLog.getType() == WorkflowLog.TRANSITION) %>">
									<%= LanguageUtil.format(pageContext, "x-changed-the-state-from-x-to-x", new Object[] {HtmlUtil.escape(actorName), HtmlUtil.escape(workflowLog.getPreviousState()), HtmlUtil.escape(workflowLog.getState())}) %>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="<%= (workflowLog.getPreviousUserId() == 0) && (curUser != null) %>">
											<%= LanguageUtil.format(pageContext, curUser.isMale() ? "x-assigned-the-task-to-himself" : "x-assigned-the-task-to-herself", HtmlUtil.escape(curUser.getFullName())) %>
										</c:when>
										<c:otherwise>

											<%
											String previousActorName = null;

											if (curRole == null) {
												previousActorName = PortalUtil.getUserName(workflowLog.getPreviousUserId(), StringPool.BLANK);
											%>

												<%= LanguageUtil.format(pageContext, "task-assigned-to-x.-previous-assignee-was-x", new Object[] {HtmlUtil.escape(actorName), HtmlUtil.escape(previousActorName)}) %>

											<%
											}
											else {
												previousActorName = curRole.getDescriptiveName();
											%>

												<%= LanguageUtil.format(pageContext, "task-initially-assigned-to-the-x-role", new Object[] {HtmlUtil.escape(actorName)}) %>

											<%
											}
											%>

										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose></td>
		<td><%= workflowLog.getComment() %></td>
		</tr>
				<%
				}
				
				%>

			</liferay-ui:panel>
	<%}%>
	
	

