<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@page
	import="com.justonetech.portal.feedback.service.FeedbackLocalServiceUtil"%>
<%@page import="com.justonetech.portal.feedback.model.Feedback"%>
<portlet:renderURL var="viewURL" />
<%
	long feedbackId = ParamUtil.getLong(request, "feedbackId");
	Feedback feedback = FeedbackLocalServiceUtil.getFeedback(feedbackId);
	request.setAttribute("feedback", feedback);
%>
<aui:form id="fm" action="">
	<aui:row>
		<aui:col span="2">
			主题
		</aui:col>
		<aui:col span="10">
			${feedback.zt}
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="2">
			类型
		</aui:col>
		<aui:col span="4">
			${feedback.lx}
		</aui:col>
		<aui:col span="2">
			反馈日期
		</aui:col>
		<aui:col span="4">
			<fmt:formatDate value="${feedback.hfrq}" pattern="yyyy-MM-dd" />
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="12">
			<aui:input name="fknr" label="内容" type="textarea" cssClass="span12"
				disabled="true" value="${feedback.fknr}" style="height:100px" />
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="12">
			<aui:input name="hfjg" label="回复结果" type="textarea" cssClass="span12"
				disabled="true" value="${feedback.hfjg}" style="height:100px" />
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="12" cssClass="text-center">
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="12" cssClass="text-center">
			<aui:button type="cancel" value="返回" href="${viewURL}" />
		</aui:col>
	</aui:row>
</aui:form>
