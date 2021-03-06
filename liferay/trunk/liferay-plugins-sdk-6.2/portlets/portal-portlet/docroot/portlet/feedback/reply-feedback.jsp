<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contextPath"
	value="${request.contextPath}/portlet/feedback" />
<style type="text/css">
div.hf {
	padding: 15px;
}
</style>
<%
	long feedbackId = ParamUtil.getLong(request, "feedbackId");
	String lx = ParamUtil.getString(request, "lx");
	Feedback feedback = FeedbackLocalServiceUtil.getFeedback(feedbackId);
	request.setAttribute("feedback", feedback);
	request.setAttribute("feedbackId", feedbackId);
%>
<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="${contextPath}/view.jsp"/>
</portlet:renderURL>
<portlet:actionURL var="saveReplyFeedBackURL" name="saveReplyFeedback"> 
	<portlet:param name="feedbackId" value="${feedbackId}"/>
</portlet:actionURL>
<div class="main">
	<div class="head"></div>
	<div class="body">
		<table class="thead">
			<tr>
				<td colspan="2" class="td"><span
					style="width: 5px; height: 20px; background-color: #ffa200; display: inline-block"></span><span>回复反馈</span>
				</td>
			</tr>
		</table>
	</div><br>
	<aui:form id="fm" method="post" action="${saveReplyFeedBackURL}">
		<aui:row style="margin-left:15px">
		<aui:col span="2">
			主题:
		</aui:col>
		<aui:col span="10">
			${feedback.zt}
		</aui:col>
	</aui:row>
	<aui:row style="margin-left:15px">
		<aui:col span="2">
			类型:
		</aui:col>
		<aui:col span="4">
			<%=lx %>
		</aui:col>
		<aui:col span="2">
			反馈日期:
		</aui:col>
		<aui:col span="4">
			<fmt:formatDate value="${feedback.fkrq}" pattern="yyyy-MM-dd" />
		</aui:col>
	</aui:row>
	<aui:row style="margin-left:15px">
		<aui:col span="11">
			<aui:input name="fknr" label="内容" type="textarea" cssClass="span12"
				disabled="true" value="${feedback.fknr}" style="height:100px" />
		</aui:col>
	</aui:row><br>
	<aui:row style="margin-left:15px">
		<aui:col span="11">
			<aui:input name="hfjg" label="回复结果" type="textarea" cssClass="span12" id="hfjg"
				  style="height:100px"  value="<%=Validator.isNotNull(feedback.getHfjg())?feedback.getHfjg():\"\" %>"/>
				  最多可以再输入<span id="contentCounter" style="color: red"></span>个汉字</aui:col>
	</aui:row>
		<div class="hf">
			<aui:button type="submit" value="提交" />
			<aui:button type="cancel" value="取消" href="${viewURL }" />
		</div>
	</aui:form>
</div>
<aui:script use="aui-char-counter">
	var counterVariable = new A.CharCounter({
		input : '#<portlet:namespace/>hfjg',
		counter : '#contentCounter',
		maxLength : 2000
	});
</aui:script>
