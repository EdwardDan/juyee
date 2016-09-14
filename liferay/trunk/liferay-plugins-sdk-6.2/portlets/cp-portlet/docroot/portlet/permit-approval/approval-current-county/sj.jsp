<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="../init.jsp"%>
<style>
input,textarea{
	margin-bottom: 10px !important;
}
span{
    font-size: 15px;
    font-weight: 200;
    padding-top: 5px;
    padding-left: 5px;
    padding-right: 5px;
    position: relative;
    top: -4px;
}
</style>
<%
	long permitId = ParamUtil.getLong(request, "permitId");
	request.setAttribute("permitId", permitId);
	Permit permit = PermitLocalServiceUtil.getPermit(permitId);
	request.setAttribute("permit", permit);
%>

<portlet:actionURL var="saveSjURL" name="saveSj">
<portlet:param name="permitId" value="${permitId}"/>
</portlet:actionURL>
<form class="form-horizontal" action="${saveSjURL}" method="post">
	<aui:row>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="slbh">受理编号：</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>slbh" value="${permit.slbh}">
			</div>
		</aui:col>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="cltjr">材料提交人：</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>cltjr" value="${permit.cltjr}">
			</div>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="hjgsz">沪交管收字（</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>hjgsz" style="width: 10%" value="${permit.hjgsz}">&nbsp;&nbsp;<span>)&nbsp;第</span><input type="text" name="<portlet:namespace/>hjgsh" style="width: 5%" value="${permit.hjgsh}"><span>号</span>
			</div>
		</aui:col>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="cltjrlxdh">联系电话：</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>cltjrlxdh" value="${permit.cltjrlxdh}">
			</div>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="sqr">申请人：</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>sqr" value="${permit.sqr}">
			</div>
		</aui:col>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="cltjrlxdz">联系地址：</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>cltjrlxdz" value="${permit.cltjrlxdz}">
			</div>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="sqsx">申请事项：</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>sqsx" value="${permit.sqsx}">
			</div>
		</aui:col>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="sjr">收件人：</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>sjr" value="${permit.sjr}">
			</div>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="sqh">申请号：</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>sqh" value="${permit.sqh}">
			</div>
		</aui:col>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="sjrlxdh">联系电话：</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>sjrlxdh" value="${permit.sjrlxdh}">
			</div>
		</aui:col>
	</aui:row>
		</div>
	</div> 
	<div class="text-center">
		<div class="btn-group">
				<aui:button-row>
				<aui:button name="submit"  type="submit" value="保存" cssClass="btn btn-primary" />
		<%
		String randomId = StringPool.BLANK;
		randomId = StringUtil.randomId();
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
		<liferay-ui:icon
				cssClass='<%= "workflow-task-" + randomId + " task-change-status-link" %>'
				id='<%= randomId + HtmlUtil.escapeAttribute(transitionName) + "taskChangeStatusLink" %>'
				image="check"
				message="<%= message %>"
				method="get"
				url="<%= url %>"
			/>
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
</form>