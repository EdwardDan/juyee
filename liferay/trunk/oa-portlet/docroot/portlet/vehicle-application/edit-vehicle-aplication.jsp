<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<script src="${staticServerURL}/My97DatePicker/WdatePicker.js"></script>
<c:set var="contentPath" value="${request.contextPath}/portlet/vehicle-application" />
<script src="http://keleyi.com/keleyi/pmedia/jquery/jquery-1.11.0.min.js"></script>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowTask" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil" %>
<%@ page import="com.liferay.portal.workflow.kaleo.service.*" %>
<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowException" %>
<%-- <c:set var="namespace" value="<%=renderResponse.getNamespace()%>" /> --%>
<portlet:renderURL var="viewURL" />
<aui:model-context bean="${vehicleApplication}"
	model="<%=VehicleApplication.class %>" />
<portlet:resourceURL var="ajaxUrl3" id="test3" />
<%
String strBackUrl = "http://" + request.getServerName() //服务器地址  
+ ":"   
+ request.getServerPort() ;          //端口号  
System.out.println("strBackUrl="+strBackUrl);
	VehicleApplication vehicleApplication = (VehicleApplication) request.getAttribute("vehicleApplication");
	String startDate = "";
	String startDates = "";
	String endDate = "";
	String endDates = "";
	String startTimes = "";
	String endTimes = "";
	if (null != vehicleApplication) {
		startDate = DateUtil.getDate(vehicleApplication.getStartTime(), defaultDateFormatPattern, locale,
				timeZone);
		startDates = DateUtil.getDate(vehicleApplication.getStartTime(), defaultTimeFormatPattern, locale,
				timeZone);
		endDate = DateUtil.getDate(vehicleApplication.getEndTime(), defaultDateFormatPattern, locale, timeZone);
		endDates = DateUtil
				.getDate(vehicleApplication.getEndTime(), defaultTimeFormatPattern, locale, timeZone);
		String sTimes = startDate + " " + startDates;
		String eTimes = endDate + " " + endDates;
		startTimes = sTimes.substring(0, 16);
		endTimes = eTimes.substring(0, 16);
		if (Validator.isBlank(vehicleApplication.getDestination())) {
			vehicleApplication.setDestination("上海市(    )区(    )路(    )号");
		}
	}
	request.setAttribute("startTimes", startTimes);
	request.setAttribute("endTimes", endTimes);
	String url="";
	if(null!=vehicleApplication){
				String[] assetTypes = new String[1];
		    	assetTypes[0]="com.justonetech.oa.model.VehicleApplication";
	    	OrderByComparator orderByComparator=null;
		    	List<WorkflowTask> results1=null;
		    User me=PortalUtil.getUser(request);
		    	try {
		    		results1= WorkflowTaskManagerUtil.search(me.getCompanyId(), me.getUserId(), null, assetTypes, null, null, -1, -1, orderByComparator);
				} catch (WorkflowException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
		    	long workflowTaskId=0L;
		    	long people=0L;
		    	for(WorkflowTask task:results1){
						if(KaleoTaskInstanceTokenLocalServiceUtil.getKaleoTaskInstanceToken(task.getWorkflowTaskId()).getClassPK()==vehicleApplication.getVehicleApplicationId()){
							workflowTaskId=task.getWorkflowTaskId();
							people=task.getAssigneeUserId();
					}
		    	}
		    	String token=com.liferay.portal.security.auth.AuthTokenUtil.getToken(request);
		    	url=strBackUrl+"/group/control_panel/manage/-/my_workflow_tasks/view/"+workflowTaskId+"?p_auth="+token+"&p_p_lifecycle=1&doAsGroupId="+PortalUtil.getUser(request).getGroupId()+"&refererPlid=25177&controlPanelCategory=my&_153_cmd=save&_153_assigneeUserId="+people+"&_153_redirect="+strBackUrl+"/web/guest/shouye&_153_struts_action=/my_workflow_tasks/edit_workflow_task&_153_transitionName=调度";
	}
				%>

<liferay-ui:header title='${empty vehicleApplication?"添加":"编辑"}车辆申请'
	backURL="${viewURL }" />
<portlet:actionURL var="saveVehicleApplicationURL"
	name="saveVehicleApplication">
	<portlet:param name="redirect" value="${viewURL }" />
</portlet:actionURL>
<portlet:actionURL var="diaoDuVehicleApplicationURL"
	name="saveVehicleApplication">
	<portlet:param name="redirect" value="<%=url %>" />
</portlet:actionURL> 

<aui:form action="${vehicleApplication.status!=5?saveVehicleApplicationURL:diaoDuVehicleApplicationURL}">
	<aui:fieldset>
	<c:if test="${vehicleApplication.status!=5}">
		<aui:row>
			<aui:col span="6" cssClass="">
				<aui:input name="vehicleApplicationId" type="hidden" />
				<aui:input name="type" value="submit" id="type" type="hidden" />
				<aui:input name="applicantDeptName" type="text" label="申请部门名称:"
					required="true" />
			</aui:col>
			<aui:col span="6" cssClass="">
				<aui:input name="applicantName" label="申请人:" type="text"  required="true" />
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="6" cssClass="">
		开始时间：<br>
				<input type="text" class="Wdate" id="startTime"
					name="<portlet:namespace/>startTime" value="${startTimes}" 
					onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endTime\')}',lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm'})"
					required="true" />
				<br>
			</aui:col>
			<aui:col span="6" cssClass="">
		结束时间：<br>
				<input type="text" class="Wdate" id="endTime"
					name="<portlet:namespace/>endTime" value="${endTimes}" 
					onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startTime\')}',lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm'})"
					required="true" />
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="6" cssClass="">
				<aui:input name="passengerNum"  type="text" label="用车人数" required="true">
					<aui:validator name="digits" />
					<aui:validator name="min">0</aui:validator>
				</aui:input>
			</aui:col>
			<aui:col span="6" cssClass="">
				<aui:input name="destination"   type="text" label="目的地" required="true" 
					value="上海市(    )区(    )路(    )号" ></aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="12">
				<aui:input name="reason" label="用车事由" type="textarea" style="width:45%;height:100px"/>
			</aui:col>
		</aui:row>
		</c:if>
	<c:if test="${vehicleApplication.status==5}">
		<aui:row>
			<aui:col span="6" cssClass="">
				<aui:input name="vehicleApplicationId" type="hidden" />
				<aui:input name="type" value="submit" id="type" type="hidden" />
				<aui:input name="applicantDeptName" type="text" label="申请部门名称:"
					required="true" readonly="true" />
			</aui:col>
			<aui:col span="6" cssClass="">
				<aui:input name="applicantName" label="申请人:" type="text"  required="true"  readonly="true"/>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="6" cssClass="">
		开始时间：<br>
				<input type="text" class="Wdate" id="startTime"
					name="<portlet:namespace/>startTime" value="${startTimes}" 
					onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endTime\')}',lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm'})"
					required="true" />
				<br>
			</aui:col>
			<aui:col span="6" cssClass="">
		结束时间：<br>
				<input type="text" class="Wdate" id="endTime"
					name="<portlet:namespace/>endTime" value="${endTimes}" 
					onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startTime\')}',lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm'})"
					required="true" />
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="6" cssClass="">
				<aui:input name="passengerNum"  type="text" label="用车人数" required="true" readonly="true">
					<aui:validator name="digits" />
					<aui:validator name="min">0</aui:validator>
				</aui:input>
			</aui:col>
			<aui:col span="6" cssClass="">
				<aui:input name="destination"   type="text" label="目的地" required="true" readonly="true"
					value="上海市(    )区(    )路(    )号" ></aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="12">
				<aui:input name="reason" label="用车事由" type="textarea" readonly="true" style="width:45%;height:100px"/>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="12" cssClass="">
			<aui:input name="isProposeDriver" id="isProposeDriver" type="checkbox"  label="是否拟派车辆:" checked="${vehicleApplication.isProposeDriver==1}" onchange="test()"/>
			</aui:col>
		</aui:row>
		<aui:row id="aa" hidden="true">
		<aui:col span="4" cssClass="">
				<aui:select name="proposeVehicle" label="拟派车辆:" inlineField="true" showEmptyOption="true"
					inlineLabel="left" type="select" style="width:100px" onchange="choose()">
					<%
						Dictionary dictionary = DictionaryLocalServiceUtil.findByCode(
													"vehicleApplication");
											if (null != dictionary) {
												List<Dictionary> dictionaries = DictionaryLocalServiceUtil
														.findByParentId( dictionary.getDictionaryId(), -1, -1);
												for (Dictionary dic : dictionaries) {
					%>
					<aui:option value="<%=dic.getDictionaryId()%>"><%=dic.getName()%></aui:option>
					<%
						}
											}
					%>
				</aui:select>
			</aui:col>
			<aui:col span="4" cssClass="">
				<aui:input type="text" name="driver" inlineField="true" readonly="true"
					inlineLabel="left" label="司机:">
				</aui:input>
			</aui:col>
			<aui:col span="4" cssClass="">
				<aui:input type="text" name="phone" inlineField="true" readonly="true"
					inlineLabel="left" label="电话:"></aui:input>
			</aui:col>
		</aui:row>
		</c:if>
	</aui:fieldset>
	<aui:button-row>
		<c:if test="${vehicleApplication.status==null}"><aui:button type="submit" value="提交" /></c:if>
		<c:if test="${vehicleApplication.status==null||vehicleApplication.status==1||vehicleApplication.status==4||vehicleApplication.status==6}"><aui:button type="submit" value="保存"  onClick="change()"/></c:if>
		<c:if test="${vehicleApplication.status==5}"><aui:button type="submit" value="调度"/></c:if>
		<aui:button type="cancel" value="取消" href="${viewURL }" />
	</aui:button-row>
</aui:form>
<script type="text/javascript">
	function change() {
		$("#<portlet:namespace/>type").val("save");
	}
	function test() {
		if($("#<portlet:namespace/>isProposeDriver").val()=="true"){
			$("#<portlet:namespace/>aa").hide();
		}else{
			$("#<portlet:namespace/>aa").show();
		}
	}
	function choose() {
		$.ajax({
			type:"GET",
			url:"<%=ajaxUrl3%>	",
			data : {
				'<portlet:namespace/>proposeVehicle' : $('#<portlet:namespace/>proposeVehicle').val()
			},
			error : function(err) {
				alert("请选择车辆!");
				$("#<portlet:namespace/>driver").val("");
				$("#<portlet:namespace/>phone").val("");
			},
			success : function(data) {
				var strJson=JSON.parse(data);
				$.each(strJson,function(idx,item){ 
					//输出每个root子对象的名称和值 
					$("#<portlet:namespace/>driver").val(item.driver);
					$("#<portlet:namespace/>phone").val(item.phone);
					}); 
		}
	});
	}
	$(document).ready(function(){
		if($("#<portlet:namespace/>isProposeDriver").val()=="true"){
			$("#<portlet:namespace/>aa").show();
		}else{
			$("#<portlet:namespace/>aa").hide();
		}
	});
	
</script>

