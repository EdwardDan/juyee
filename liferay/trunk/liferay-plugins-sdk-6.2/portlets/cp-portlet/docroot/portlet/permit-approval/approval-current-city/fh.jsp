<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="../init.jsp"%>
<%
	long permitId = ParamUtil.getLong(request, "permitId");
	request.setAttribute("permitId", permitId);
	List<ApplyMaterial> applyMaterials = ApplyMaterialLocalServiceUtil.findByPermitId(permitId, -1, -1);
	request.setAttribute("applyMaterials", applyMaterials);
	int num = 1;
%>

<portlet:actionURL var="saveFhURL" name="saveFh">
	<portlet:param name="permitId" value="${permitId}" />
	 <portlet:param name="redirectURL" value="${approvalCurrentURL}"/>
</portlet:actionURL>
<aui:form action="${saveFhURL}" method="post">
	<table style="width: 100%" class="table table-striped table-bordered table-hover">
		<thead>
				<th width="5%" class="text-center">序号</th>
				<th width="30%" class="text-center">材料提交名称</th>
				<th width="45%" class="text-center">审核要求</th>
				<th width="10%" class="text-center">初审意见</th>
				<th width="10%" class="text-center">复核意见</th>
		</thead>
		<tbody id="applyMaterials">
			<c:if test="${!empty applyMaterials}">
				<c:forEach items="<%=applyMaterials%>" var="applyMaterial">
					<tr>
						<td class="text-center"><%=String.valueOf(num)%></td>
						<td class="text-left">${applyMaterial.clmc}</td>
						<td class="text-left">${applyMaterial.shyq}</td>
						<td>${applyMaterial.csyj}</td>
						<td><aui:select name="fhyj" label="" cssClass="span11">
								<c:if test="${applyMaterial.fhyj==''}">
									<aui:option value="符合">符合</aui:option>
									<aui:option value="不符合">不符合</aui:option>
								</c:if>
								<c:if test="${applyMaterial.fhyj=='符合'}">
									<aui:option value="符合">符合</aui:option>
									<aui:option value="不符合">不符合</aui:option>
								</c:if>
								<c:if test="${applyMaterial.fhyj=='不符合'}">
									<aui:option value="符合">符合</aui:option>
									<aui:option value="不符合" selected="true">不符合</aui:option>
								</c:if>
							</aui:select></td>
					</tr>
					</tr>
					<%
						num++;
					%>
				</c:forEach>
			</c:if>
		</tbody>

	</table>
	</div>
	<div class="text-center">
		<div class="btn-group">
				<aui:button-row>
				<div class="btn-group">
			<aui:button name="pass" type="submit" value="保存" cssClass="btn btn-primary" />
		</div>
		<%
		Long permitIdInit=ParamUtil.getLong(request,"permitId");
		String randomId = StringPool.BLANK;
		randomId = StringUtil.randomId();
		Permit permit=PermitLocalServiceUtil.getPermit(permitIdInit);
		String strBackUrl = "http://" + request.getServerName() //服务器地址  
        + ":"   
        + request.getServerPort() ;          //端口号  
				String[] assetTypes = new String[1];
		    	assetTypes[0]="com.justonetech.cp.permit.model.Permit";
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
		    	if(null!=permit){
		    		if(results1.size()>0){
		    		//工作流任务
		    	for(WorkflowTask task:results1){
		    		if(null!=task){
		    			if(KaleoTaskInstanceTokenLocalServiceUtil.getKaleoTaskInstanceToken(task.getWorkflowTaskId()).getClassPK()==permit.getPermitId()){
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
				url=strBackUrl+"/group/control_panel/manage/-/my_workflow_tasks/view/"+workflowTaskId+"?p_auth="+token+"&p_p_lifecycle=1&doAsGroupId="+PortalUtil.getUser(request).getGroupId()+"&refererPlid=25177&controlPanelCategory=my&_153_cmd=save&_153_assigneeUserId="+people+"&_153_redirect="+strBackUrl+themeDisplay.getURLCurrent()+"&_153_struts_action=/my_workflow_tasks/edit_workflow_task&_153_transitionName="+message;
				%>
				<div class="hide" id="<%= randomId %>updateComments">
	<aui:input cols="55" name="_153_comment" id="_153_comment" label="审核意见" useNamespace="false" rows="10" type="textarea" />
</div>
<c:if test='<%=message.equals("通过")&&!Validator.isBlank(applyMaterials.get(0).getFhyj())%>'>
		<liferay-ui:icon
				cssClass='<%= "workflow-task-" + randomId + " task-change-status-link" %>'
				id='<%= randomId + HtmlUtil.escapeAttribute(transitionName) + "taskChangeStatusLink" %>'
				image="shtg"
				message="<%= message %>"
				method="get"
				url="<%= url %>"
				onClick="fhyj()"
			/>
			</c:if>
			<c:if test='<%=message.equals("不通过")&&!Validator.isBlank(applyMaterials.get(0).getFhyj())%>'>
		<liferay-ui:icon
				cssClass='<%= "workflow-task-" + randomId + " task-change-status-link" %>'
				id='<%= randomId + HtmlUtil.escapeAttribute(transitionName) + "taskChangeStatusLink" %>'
				image="shth"
				message="<%= message %>"
				method="get"
				url="<%= url %>"
				onClick="noFhyj()"
			/>
			</c:if>
			<aui:script use="liferay-workflow-tasks">
var onTaskClickFn = A.rbind('onTaskClick', Liferay.WorkflowTasks,'<%= randomId %>',true);
Liferay.delegateClick('<portlet:namespace /><%= randomId + HtmlUtil.escapeJS(transitionName) %>taskChangeStatusLink', onTaskClickFn);
</aui:script>
<c:if test='<%=message.equals("通过")&&Validator.isBlank(applyMaterials.get(0).getFhyj())%>'>
<liferay-ui:icon
				cssClass='<%= "workflow-task-" + randomId + " task-change-status-link" %>'
				id='<%= randomId + HtmlUtil.escapeAttribute(transitionName) + "taskChangeStatusLink" %>'
				image="shtgx"
				message="<%= message %>"
				method="get"
			/>
</c:if>
<c:if test='<%=message.equals("不通过")&&Validator.isBlank(applyMaterials.get(0).getFhyj())%>'>
<liferay-ui:icon
				cssClass='<%= "workflow-task-" + randomId + " task-change-status-link" %>'
				id='<%= randomId + HtmlUtil.escapeAttribute(transitionName) + "taskChangeStatusLink" %>'
				image="shthx"
				message="<%= message %>"
				method="get"
			/>
</c:if>
				<%
		    		}
		    	}
		%>
		<div class="btn-group">
			<aui:button name="close" value="关闭" cssClass="btn" href="${viewURL}" />
		</div>
	</aui:button-row>
		</div>
	</div>
	</div>
</aui:form>
<script type="text/javascript">
function fhyj(){
	$("#_153_comment").val("经复审，所提交材料符合要求。");
}
function noFhyj(){
	$("#_153_comment").val("");
}
</script>