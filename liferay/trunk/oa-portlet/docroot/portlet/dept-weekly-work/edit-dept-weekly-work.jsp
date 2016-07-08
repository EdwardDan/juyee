<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="/common/init.jsp"%>

<script type="text/javascript"
	src="/html/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
 function doSave(status){
	   document.getElementById("status").value=status;
	   document.forms[0].submit();
 }
</script>

<%
	User currentUser = PortalUtil.getUser(request);

	Organization organization = currentUser.getOrganizations()
	.iterator().next();
	request.setAttribute("currentUser", currentUser);
	request.setAttribute("organization", organization);
	/* request.setAttribute("deptWorkItems", new ArrayList<DeptWorkItem>()); */
%>
<c:set var="contentPath"
	value="${request.contextPath}/portlet/dept-weekly-work" />
<portlet:renderURL var="viewUrl" />
<liferay-ui:header title='${empty deptWork?"添加":"编辑"}科室一周工作安排'
	backURL="${viewURL }" />
<portlet:actionURL name="saveDeptWork" var="saveDeptWorkUrl">
	<portlet:param name="redirect" value="${viewUrl}" />
</portlet:actionURL>
<aui:model-context bean="${deptWork}" model="<%=DeptWork.class%>" />
<aui:form action="<%=saveDeptWorkUrl%>" name="fm">
	<div class="row-fluid">
		<aui:fieldset cssClass="fieldset span6">
			<aui:input name="deptWorkId" type="hidden" />
			<aui:input name="status" type="hidden" />

			<aui:input name="deptName" type="text" inlineLabel="true"
				value="${organization.name }" label="上报科室">
				<aui:validator name="required" errorMessage="上报科室不能为空！"></aui:validator>
				<aui:validator name="maxLength">75</aui:validator>
			</aui:input>
			<aui:field-wrapper name="上报时间" inlineLabel="true">
				<input name='<portlet:namespace/>startDate' id="startDate"
					type="text" readonly="readonly" class="Wdate"
					onClick="WdatePicker({lang:'zh-cn'})"
					value='<fmt:formatDate value="${deptWork.startDate }" pattern="yyyy-MM-dd"/>' />~
				<input name="<portlet:namespace/>endDate" type="text"
					readonly="readonly"
					value='<fmt:formatDate value="${deptWork.startDate }" pattern="yyyy-MM-dd"/>'
					class="Wdate" onClick="WdatePicker({lang:'zh-cn'})" />

			</aui:field-wrapper>
		</aui:fieldset>
		<aui:fieldset cssClass="fieldset span6">
			<aui:input name="userName" type="text" inlineLabel="true" label="上报人"
				value="${currentUser.fullName }">
			</aui:input>
		</aui:fieldset>
	</div>
	<div id="member-fields">
		<c:if test="${empty deptWorkItems }">
			<div class="lfr-form-row lfr-form-row-inline">
				<div class="row-fields" style="display: flex;">
					<aui:input fieldParam='sortNo' name="sortNo0" type="text" label="序号"
						value="">
						<aui:validator name="required" errorMessage="这里不可空白!"></aui:validator>
					</aui:input>
					<aui:input name="dutyPerosn0" type="text" inlineLabel="true"
						value="" label="责任人">
						<aui:validator name="required" errorMessage="这里不可空白!"></aui:validator>
					</aui:input>
					<aui:input fieldParam='mainWork' name="mainWork0" value=""
						type="text" inlineLabel="true" label="重点工作 " />
					<aui:input fieldParam='schedule' name="schedule0" value=""
						type="text" inlineLabel="true" label="工作进度" />
					<aui:input fieldParam='content' name="content0" value="" type="text"
						inlineLabel="true" label="工作内容" />
					<aui:input fieldParam='agentPerson' value="" name="agentPerson0"
						type="text" inlineLabel="true" label="经办人" />
				</div>
			</div>
		</c:if>
		<c:forEach items="${deptWorkItems }" var="deptWorkItem"
			varStatus="status">

			<div class="lfr-form-row lfr-form-row-inline">
				<div class="row-fields" style="display: flex;">
					<aui:input fieldParam='sortNo' name="sortNo${status.index+1 }"
						type="text" label="序号" value="${deptWorkItem.sortNo }">
						<aui:validator name="required" errorMessage="这里不可空白!"></aui:validator>
					</aui:input>
					<aui:input name="dutyPerosn${status.index+1 }" type="text"
						inlineLabel="true" value="${deptWorkItem.dutyPerosn }" label="责任人">
						<aui:validator name="required" errorMessage="这里不可空白!"></aui:validator>
					</aui:input>
					<aui:input fieldParam='mainWork' name="mainWork${status.index+1 }"
						value="${deptWorkItem.mainWork }" type="text" inlineLabel="true"
						label="重点工作 " />
					<aui:input fieldParam='schedule' name="schedule${status.index+1 }"
						value="${deptWorkItem.schedule }" type="text" inlineLabel="true"
						label="工作进度" />
					<aui:input fieldParam='content' name="content${status.index+1 }"
						value="${deptWorkItem.content }" type="text" inlineLabel="true"
						label="工作内容" />
					<aui:input fieldParam='agentPerson'
						value="${deptWorkItem.agentPerson }"
						name="agentPerson${status.index+1 }" type="text"
						inlineLabel="true" label="经办人" />
				</div>
			</div>

		</c:forEach>
	</div>

	<aui:button-row>
		<aui:button type="button" cssClass="btn btn-primary" value="提交"
			onClick="doSave(1)" />
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewUrl %>"></aui:button>
	</aui:button-row>
</aui:form>

<aui:script>
AUI().use('liferay-auto-fields',function(A) { 
 new Liferay.AutoFields(
       {
           contentBox: '#member-fields',
           fieldIndexes: '<portlet:namespace />rowIndexes'
       }
   ).render();
   });
   
</aui:script>
	

























































