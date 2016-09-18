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

<portlet:actionURL var="saveShURL" name="saveSh">
	<portlet:param name="permitId" value="${permitId}" />
</portlet:actionURL>
<aui:form action="${saveShURL}" method="post">
	<div class="text-center">
		<table style="width: 98%" border="1">
			<tr>
				<td width="5%">序号</td>
				<td width="30%">材料提交名称</td>
				<td width="44%">审核要求</td>
				<td width="7%">初审意见</td>
				<td width="7%">复核意见</td>
				<td width="7%">审核意见</td>
			</tr>
			<tbody id="applyMaterials">
				<c:if test="${!empty applyMaterials}">
					<c:forEach items="<%=applyMaterials%>" var="applyMaterial">
						<tr>
							<td><%=String.valueOf(num)%></td>
							<td>${applyMaterial.clmc}</td>
							<td>${applyMaterial.shyq}</td>
							<td>${applyMaterial.csyj}</td>
							<td>${applyMaterial.fhyj}</td>
							<td>
								<aui:select name="shyj" label="" cssClass="span11">
									<c:if test="${applyMaterial.shyj==''}">
										<aui:option value="符合">符合</aui:option>
										<aui:option value="不符合">不符合</aui:option>
									</c:if>
									<c:if test="${applyMaterial.shyj=='符合'}">
										<aui:option value="符合">符合</aui:option>
										<aui:option value="不符合">不符合</aui:option>
									</c:if>
									<c:if test="${applyMaterial.shyj=='不符合'}">
										<aui:option value="符合">符合</aui:option>
										<aui:option value="不符合" selected="true">不符合</aui:option>
									</c:if>
								</aui:select></td>
						</tr>
						<%
							num++;
						%>
					</c:forEach>
				</c:if>
			</tbody>

		</table>

		<br>
				
			</div>
		</div>
		<div class="text-center">
		<div class="btn-group">
				<aui:button-row>
				<aui:button name="pass" type="submit" value="保存" cssClass="btn btn-primary" />
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
		<c:if test='<%=message.equals("通过") %>'>
		<liferay-ui:icon
				cssClass='<%= "workflow-task-" + randomId + " task-change-status-link" %>'
				id='<%= randomId + HtmlUtil.escapeAttribute(transitionName) + "taskChangeStatusLink" %>'
				image="shtg"
				message="<%= message %>"
				method="get"
				url="<%= url %>"
			/>
			</c:if>
			<c:if test='<%=message.equals("不通过") %>'>
		<liferay-ui:icon
				cssClass='<%= "workflow-task-" + randomId + " task-change-status-link" %>'
				id='<%= randomId + HtmlUtil.escapeAttribute(transitionName) + "taskChangeStatusLink" %>'
				image="shth"
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
		    		}
		    	}
		%>
	</aui:button-row>
		</div>
		<div class="btn-group">
			<aui:button name="close" value="关闭" cssClass="btn" href="${viewURL}" />
		</div>
	</div>
	</div>
</aui:form>
<portlet:renderURL var="shthUrl" windowState="pop_up">
	<portlet:param name="mvcPath" value="${contextPath }/approval-current-city/sh-shth.jsp" />
</portlet:renderURL>
<aui:script>
	function shth() {
		AUI().use('aui-modal', 'aui-dialog-iframe-deprecated', 'io-plugin-deprecated', function(A) {
			var url = '${shthUrl}';
			var modal = new A.Modal({
				bodyContent : '正文件',
				centered : true,
				headerContent : '<h3>退回选择页面</h3>',
				modal : false,
				destroyOnHide : true,
				render : '#modal',
				width : 750,
				height : 600,
				toolbars : {
					footer : [ {
						label : '取消',
						on : {
							click : function() {
								modal.hide();
							}
						}
					}, {
						label : '确定',
						on : {
							click : function() {
								alert('点击了确定，可以在这里调用其他函数');
							}
						},
						primary : true
					} ]
				}
			}).plug(A.Plugin.DialogIframe, {
				uri : url,
			}).render();
		});
	}

	
</aui:script>