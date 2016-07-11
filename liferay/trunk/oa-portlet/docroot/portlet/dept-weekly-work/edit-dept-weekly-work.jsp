<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="/common/init.jsp"%>
<c:set var="contentPath"
	value="${request.contextPath}/portlet/dept-weekly-work" />
<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>

<%
	long userId = PortalUtil.getUserId(request);
	String userName = PortalUtil.getUserName(userId, "");
%>
<script>
	function change() {
		$("#<portlet:namespace/>type").val("save");
	}
</script>
<portlet:renderURL var="viewURL" />
<liferay-ui:header title="${empty deptWork?'添加':'编辑'}科室一周工作安排"
	backURL="${viewURL}" />
<portlet:actionURL var="saveDeptWorkURL" name="saveDeptWork">
</portlet:actionURL>
<aui:form action="${saveDeptWorkURL}">
	<aui:row>
		<aui:col span="6">
			<aui:input name="deptWorkId" value="${deptWork.deptWorkId}"
				type="hidden" />
			<aui:input name="type" value="submit" id="type" type="hidden" />
			<aui:input name="deptName" label="上报科室" value="${deptWork.deptName}" />
		</aui:col>
		<aui:col span="6">
			<aui:input name="userName" label="上报人" value="<%=userName%>"
				disabled="true" />
		</aui:col>
	</aui:row>
	<aui:field-wrapper name="上报时间" inlineLabel="true">
		<input type="text" class="Wdate" id="startDate"
			name="<portlet:namespace/>startDate"
			value='<fmt:formatDate value="${deptWork.startDate}" pattern="yyyy-MM-dd"/>'
			onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')}',lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"
			required="true" readonly="readonly" />　~　
		<input type="text" class="Wdate" id="endDate"
			name="<portlet:namespace/>endDate"
			value='<fmt:formatDate value="${deptWork.endDate}" pattern="yyyy-MM-dd"/>'
			onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDate\')}',lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"
			required="true" readonly="readonly" />
	</aui:field-wrapper>
	<c:if test="${empty deptWork}">
		<div class="member-fields">
			<div class="lfr-form-row lfr-form-row-inline">
				<div class="row-fields" style="display: flex;">
					<aui:input fieldParam='sortNo1' name="sortNo1" label="序号"
						type="number">
						<aui:validator name="required"></aui:validator>
						<aui:validator name="number"></aui:validator>
					</aui:input>
					<aui:input fieldParam='dutyPerson1' name="dutyPerson1" label="责任人"
						type="text" required="true" />
					<aui:select name="mainWork1" label="是否重点工作">
						<aui:option value="true" label="是"></aui:option>
						<aui:option value="false" label="否"></aui:option>
					</aui:select>
					<aui:input fieldParam='content1' name="content1" label="工作内容"
						type="textarea" />
					<aui:input fieldParam='schedule1' name="schedule1" label="工作进度"
						type="textarea" />
					<aui:input fieldParam='agentPerson1' name="agentPerson1"
						label="经办人" type="text" />
				</div>
			</div>
		</div>
	</c:if>
	<div class="member-fields">
		<c:forEach items="${deptWorkItems}" var="item" varStatus="status">
			<div class="lfr-form-row lfr-form-row-inline">
				<div class="row-fields" style="display: flex;">
					<aui:input name="sortNo${status.index+1}" label="序号"
						value="${item.sortNo}" required="true" />
					<aui:input name="dutyPerson${status.index+1}" label="责任人"
						value="${item.dutyPerson}" />
					<aui:select name="mainWork${status.index+1}" label="是否重点工作">
						<aui:option value="true" label="是"
							selected="${item.mainWork eq true}"></aui:option>
						<aui:option value="false" label="否"
							selected="${item.mainWork eq false}"></aui:option>
					</aui:select>
					<aui:input name="content${status.index+1}" label="工作内容"
						value="${item.content}" />
					<aui:input name="schedule${status.index+1}" label="工作进度"
						value="${item.schedule}" />
					<aui:input name="agentPerson${status.index+1}" label="序号"
						value="${item.agentPerson}" />
				</div>
			</div>
		</c:forEach>
	</div>
	<aui:script>
		AUI().use('liferay-auto-fields', function(A) {
			new Liferay.AutoFields({
				contentBox : '.member-fields',
				fieldIndexes : '<portlet:namespace />rowIndexes'
			}).render();
		});
	</aui:script>
		


	
	<aui:button-row>
		<aui:button type="submit" value="提交" />
		<aui:button type="submit" value="保存" onClick="change()" />
		<aui:button type="cancel" value="取消" href="${viewURL}" />
	</aui:button-row>
</aui:form>















































































































