<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%@page
	import="com.justonetech.portal.feedback.service.FeedbackLocalServiceUtil"%>
<%@page import="com.justonetech.portal.feedback.model.Feedback"%>
<link rel="stylesheet" type="text/css" href="/portal-portlet/portlet/feedback/css/query.css" />
<portlet:renderURL var="viewURL" />
<%
	long feedbackId = ParamUtil.getLong(request, "feedbackId");
	Feedback feedback = FeedbackLocalServiceUtil.getFeedback(231532);
	request.setAttribute("feedback", feedback);
%>
<aui:form id="fm" action="">
<div class="out">
		<div class="middle"></div>
		<div class="in">
			<table class="thead">
				<tr>
					<td colspan="2" class="head"><span
						style="width: 5px; height: 20px; background-color: #ffa200; display: inline-block"></span><span>查看</span>
					</td>
				</tr>
			</table>
		</div><br>
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
			${feedback.lx}
		</aui:col>
		<aui:col span="2">
			反馈日期:
		</aui:col>
		<aui:col span="4">
			<fmt:formatDate value="${feedback.hfrq}" pattern="yyyy-MM-dd" />
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
			<aui:input name="hfjg" label="回复结果" type="textarea" cssClass="span12"
				disabled="true" value="${feedback.hfjg}" style="height:100px" />
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="11" cssClass="text-center">
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="11" cssClass="text-center">
			<aui:button type="cancel" value="返回" href="${viewURL}" />
		</aui:col>
	</aui:row>
	<br>
	</div>
</aui:form>
