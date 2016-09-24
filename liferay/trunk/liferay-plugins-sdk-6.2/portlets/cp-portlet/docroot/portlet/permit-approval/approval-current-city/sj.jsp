<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@ include file="../init.jsp"%>
<style>
input, textarea {
	margin-bottom: 10px !important;
}

span {
	font-size: 15px;
	font-weight: 200;
	padding-top: 5px;
	padding-left: 5px;
	padding-right: 5px;
	top: -4px;
}
</style>
<%
	long permitId = ParamUtil.getLong(request, "permitId");
	request.setAttribute("permitId", permitId);
	Permit permit = PermitLocalServiceUtil.getPermit(permitId);
	List<ApplyMaterial> materialList=ApplyMaterialLocalServiceUtil.findByPermitId(permitId, -1, -1);
	request.setAttribute("applyMaterials", materialList);
	Map<Long,List<DLFileEntry>> map=new HashMap<Long,List<DLFileEntry>>();
	Map<Long,List<DLFileEntry>> mapBzcl=new HashMap<Long,List<DLFileEntry>>();
	if(null!=materialList){
		for(int i=0;i<materialList.size();i++){
	
		ApplyMaterial applyMaterial=materialList.get(i);
		String fileEntryIds=applyMaterial.getFileEntryIds();
		String[] fileEntryIdsArr=fileEntryIds.split("\\,");
		List<DLFileEntry> list=new ArrayList<DLFileEntry>();
		if(null!=fileEntryIdsArr&&fileEntryIdsArr.length>0){
		for(int j=0;j<fileEntryIdsArr.length;j++){
	if(Validator.isNotNull(fileEntryIdsArr[j])){
		String fileEntryId=fileEntryIdsArr[j].split("\\|")[0];
		DLFileEntry dlFileEntry=DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(fileEntryId));
	list.add(dlFileEntry);
		}
		
	}
		map.put(materialList.get(i).getMaterialId(), list);
		}
		
		String bzclIds=applyMaterial.getBzclIds();
		if(Validator.isNotNull(bzclIds)){
		String[] bzclIdsArr=bzclIds.split("\\,");
		List<DLFileEntry> listBzcl=new ArrayList<DLFileEntry>();
		if(null!=bzclIdsArr&&bzclIdsArr.length>0){
		for(int j=0;j<bzclIdsArr.length;j++){
	if(Validator.isNotNull(bzclIdsArr[j])){
		String fileEntryId=bzclIdsArr[j].split("\\|")[0];
		DLFileEntry dlFileEntry=DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(fileEntryId));
	listBzcl.add(dlFileEntry);
		}
	
	}
		mapBzcl.put(materialList.get(i).getMaterialId(), listBzcl);
		}
		}
		}
		}
		String jpg = "jpg";
		String pdf = "pdf";
		request.setAttribute("jpg", jpg);
		request.setAttribute("pdf", pdf);
		request.setAttribute("map", map);
		request.setAttribute("mapBzcl", mapBzcl);
	request.setAttribute("permit", permit);
%>
<portlet:actionURL var="saveSjURL" name="saveSj">
	<portlet:param name="permitId" value="${permitId}" />
	<portlet:param name="redirectURL" value="${approvalCurrentURL}" />
</portlet:actionURL>
<form class="form-horizontal" action="${saveSjURL}" method="post">

	<table class="table table-bordered" style="font-size: 14px;"
		id="fileTable">
		<tr style="text-align: center; height: 45px;">
			<td style="text-align: center; width: 4%;">序号</td>
			<td style="text-align: center; width: 20%;">申请材料名称</td>
			<td style="text-align: center; width: 20%;">附件</td>
			<td style="text-align: center; width: 20%;">补正材料</td>
			<td style="text-align: center; width: 20%;">审核要求</td>
			<td style="text-align: center; width: 8%;">应收附件</td>
			<td style="text-align: center; width: 8%;">实收附件</td>
		</tr>
		<c:forEach items="${applyMaterials }" var="material"
			varStatus="status">
			<tr style="text-align: center" class="fileTr">
				<td style="text-align: center" class="fileNo"><input
					type="hidden" name="<portlet:namespace/>materialId"
					value="${material.materialId }">${material.xh}</td>
				<td>${material.clmc}</td>
				<td style="text-align: center">
					<div class="${material.materialId}">
						<c:if test="${not empty material.fileEntryIds}">
							<c:forEach items="${map[material.materialId]}" var="dlFileEntry"
								varStatus="varNo">
								<div>
									<c:set var="filePath"
										value="${dlFileEntry.groupId }/${dlFileEntry.folderId}/${dlFileEntry.title }" />
									<c:set var="fileName"
										value="${material.clmc }-${varNo.index+1 }.${dlFileEntry.extension }" />
									<c:if test="${dlFileEntry. extension eq jpg}">
										<a href="#"
											onclick="previewJpg(${material.materialId},${dlFileEntry.fileEntryId})">${material.clmc }-${varNo.index+1 }.${dlFileEntry.extension }</a>
										<img src="/documents/${filePath }" style="display: none;"
											id="${dlFileEntry.fileEntryId}" alt="${dlFileEntry.title}">
									</c:if>
									<c:if test="${dlFileEntry.extension eq pdf}">
										<a href="#" onclick="previewPdf('/documents/${filePath}')">${material.clmc }-${varNo.index+1 }.${dlFileEntry.extension }</a>
									</c:if>
									<a href="/documents/${filePath }?&download=true">下载</a>
								</div>
							</c:forEach>
						</c:if>
					</div>
				</td>

				<td style="text-align: center">
					<div class="${material.materialId}">
						<c:if test="${not empty material.bzclIds}">
							<c:forEach items="${mapBzcl[material.materialId]}"
								var="dlFileEntry" varStatus="varStausNo">
								<div>
									<c:set var="filePathBzcl"
										value="${dlFileEntry.groupId }/${dlFileEntry.folderId}/${dlFileEntry.title }" />
									<c:set var="fileNameBzcl"
										value="${material.clmc }-${varStausNo.index+1 }.${dlFileEntry.extension }" />
									<c:if test="${dlFileEntry. extension eq jpg}">
										<a href="#"
											onclick="previewJpg(${material.materialId},${dlFileEntry.fileEntryId})">${material.clmc }补正材料-${varStausNo.index+1 }.${dlFileEntry.extension }</a>
										<img src="/documents/${filePathBzcl }" style="display: none;"
											id="${dlFileEntry.fileEntryId}" alt="${dlFileEntry.title}">
									</c:if>
									<c:if test="${dlFileEntry.extension eq pdf}">
										<a href="#" onclick="previewPdf('/documents/${filePathBzcl}')">${material.clmc }补正材料-${varStausNo.index+1 }.${dlFileEntry.extension }</a>
									</c:if>
									<a href="/documents/${filePathBzcl }?&download=true">下载</a>
								</div>
							</c:forEach>
						</c:if>
					</div>
				</td>
				<td style="text-align: left">${material.shyq}</td>
				<td style="text-align: center">${material.yjfs}</td>
				<td style="text-align: center"><aui:input name="sjfs" label=""
						cssClass="input-mini text-center" value="${material.sjfs}">
						<aui:validator name="number" />
					</aui:input></td>
			</tr>
		</c:forEach>

	</table>


	<aui:row>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="slbh">受理编号：</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>slbh"
					value="${permit.slbh}">
			</div>
		</aui:col>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="cltjr">材料提交人：</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>cltjr"
					value="${permit.cltjr}">
			</div>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="hjgsz">沪交管收字（</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>hjgsz"
					style="width: 10%" value="${permit.hjgsz}">&nbsp;&nbsp;<span>)&nbsp;第</span><input
					type="text" name="<portlet:namespace/>hjgsh" style="width: 5%"
					value="${permit.hjgsh}"><span>号</span>
			</div>
		</aui:col>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="lxdh">联系电话：</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>cltjrlxdh"
					value="${permit.cltjrlxdh}">
			</div>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="sqr">申请人：</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>sqr"
					value="${permit.sqr}">
			</div>
		</aui:col>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="lxdz">联系地址：</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>cltjrlxdz"
					value="${permit.cltjrlxdz}">
			</div>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="sqsx">申请事项：</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>sqsx"
					value="${permit.sqsx}">
			</div>
		</aui:col>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="sjr">收件人：</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>sjr"
					value="${permit.sjr}">
			</div>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="sqh">申请号：</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>sqh"
					value="${permit.sqh}">
			</div>
		</aui:col>
		<aui:col span="6" cssClass="text-left">
			<label class="control-label" for="lxdh">联系电话：</label>
			<div class="controls">
				<input type="text" name="<portlet:namespace/>sjrlxdh"
					value="${permit.sjrlxdh}">
			</div>
		</aui:col>
	</aui:row>

	<div class="text-center">
		<div class="btn-group">
			<aui:button name="submit" type="submit" value="保存"
				cssClass="btn btn-primary" />
		</div>
		<div class="btn-group">
			<!-- <aui:button name="pass" value="审核通过" cssClass="btn btn-primary" /> -->
			<aui:button-row>
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
				<div class="hide" id="<%=randomId%>updateComments">
					<aui:input cols="55" name="_153_comment" id="_153_comment"
						label="审核意见" useNamespace="false" rows="10" type="textarea" />
				</div>
				<c:choose>
<c:when test='<%=message.equals("通过")&&!Validator.isBlank(permit.getSlbh())%>'>
<liferay-ui:icon
				cssClass='<%= "workflow-task-" + randomId + " task-change-status-link" %>'
				id='<%= randomId + HtmlUtil.escapeAttribute(transitionName) + "taskChangeStatusLink" %>'
				image="sjtg"
				message="<%= message %>"
				method="get"
				url="<%= url %>"
			/> 
			</c:when>
			<c:when test='<%=message.equals("不通过")&&!Validator.isBlank(permit.getSlbh())%>'>
<liferay-ui:icon
				cssClass='<%= "workflow-task-" + randomId + " task-change-status-link" %>'
				id='<%= randomId + HtmlUtil.escapeAttribute(transitionName) + "taskChangeStatusLink" %>'
				image="sjth"
				message="<%= message %>"
				method="get"
				url="<%= url %>"
			/> 
			</c:when>
			<c:when test='<%=message.equals("通过")&&Validator.isBlank(permit.getSlbh())%>'>
<liferay-ui:icon
				cssClass='<%= "workflow-task-" + randomId + " task-change-status-link" %>'
				id='<%= randomId + HtmlUtil.escapeAttribute(transitionName) + "taskChangeStatusLink" %>'
				image="sjtgx"
				message="<%= message %>"
				method="get"
			/> 
			</c:when>
			<c:when test='<%=message.equals("不通过")&&Validator.isBlank(permit.getSlbh())%>'>
<liferay-ui:icon
				cssClass='<%= "workflow-task-" + randomId + " task-change-status-link" %>'
				id='<%= randomId + HtmlUtil.escapeAttribute(transitionName) + "taskChangeStatusLink" %>'
				image="sjthx"
				message="<%= message %>"
				method="get"
			/> 
			</c:when>
			
</c:choose>
			<c:if test="<%=!Validator.isBlank(permit.getSlbh())%>">
			<aui:script use="liferay-workflow-tasks">
var onTaskClickFn = A.rbind('onTaskClick', Liferay.WorkflowTasks,'<%= randomId %>',true);
Liferay.delegateClick('<portlet:namespace /><%= randomId + HtmlUtil.escapeJS(transitionName) %>taskChangeStatusLink', onTaskClickFn);
</aui:script></c:if>
				
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