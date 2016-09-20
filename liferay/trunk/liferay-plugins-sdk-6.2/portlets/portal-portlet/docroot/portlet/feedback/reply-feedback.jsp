<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<link rel="stylesheet" type="text/css"
	href="/portal-portlet/portlet/feedback/css/query.css" />
<style type="text/css">
div.hf {
	margin-top: 20px;
	padding: 15px;
}

div.hf textarea {
	width: 450px;
	height: 200px;
}

div.hf button {
	width: 100px;
}
</style>
<%
	long feedbackId = ParamUtil.getLong(request, "feedbackId");
	Feedback feedback = FeedbackLocalServiceUtil.getFeedback(feedbackId);
	request.setAttribute("feedback", feedback);
	request.setAttribute("feedbackId", feedbackId);
%>
<portlet:actionURL var="saveReplyFeedBackURL" name="saveReplyFeedback"> 
	<portlet:param name="feedbackId" value="${feedbackId}"/>
</portlet:actionURL>
<div class="out">
	<div class="middle"></div>
	<div class="in">
		<table class="thead">
			<tr>
				<td colspan="2" class="head"><span
					style="width: 5px; height: 20px; background-color: #ffa200; display: inline-block"></span><span>回复反馈</span>
				</td>
			</tr>
		</table>
	</div>
	<aui:form id="fm" method="post" action="${saveReplyFeedBackURL}">
		<div class="hf">主题: ${feedback.zt}</div>
		<div class="hf">类型:
			${feedback.lx}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;反馈日期:<fmt:formatDate value="${feedback.hfrq}" pattern="yyyy-MM-dd" /></div>
		<div class="hf">反馈内容:</div>
		<div class="hf">
			<textarea readonly="readonly">${feedback.fknr}</textarea>
		</div>
		<div class="hf">回复结果:</div>
		<div class="hf">
			<aui:input name="hfjg" type="textarea" label=""></aui:input>
		</div>
		<div class="hf" style="width: 450px; text-align: center">
			<aui:button type="submit" value="提交" />
			<aui:button type="cancel" value="取消" href="${viewURL }" />
		</div>
	</aui:form>
</div>
