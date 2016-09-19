<%@page
	import="com.justonetech.portal.feedback.service.FeedbackLocalServiceUtil"%>
<%@page import="com.justonetech.portal.feedback.model.Feedback"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<style type="text/css">
	<%@ include file="/portlet/feedback/css/query.css"%>
</style>
<portlet:renderURL var="searchURL" />
<%
	String zt = ParamUtil.getString(request, "zt");
	String lx = ParamUtil.getString(request, "lx");
	long fkrId = 0L;
	long currentUserId = PortalUtil.getUserId(request);
	request.setAttribute("zt", zt);
	request.setAttribute("lx", lx);
%>
<aui:form name="fm" id="fm" method="post" action="${searchURL }">
	<div class="out">
		<div class="middle"></div>
		<div class="in">
			<table class="thead">
				<tr>
					<td colspan="2" class="head"><span
						style="width: 5px; height: 20px; background-color: #ffa200; display: inline-block"></span><span>回复查询</span>
					</td>
				</tr>
			</table>
		</div>
		<aui:row>
			<aui:col span="12" cssClass="text-center" style="margin-top:15px">
				<aui:input type="text" name="zt" label="主题" inlineLabel="left"
					inlineField="true"></aui:input>
				<aui:select name="lx" label="类型" showEmptyOption="true"
					inlineLabel="left" inlineField="true">
					<aui:option value="zrxx">主任信箱</aui:option>
					<aui:option value="ywzx">业务咨询</aui:option>
					<aui:option value="jy">建议</aui:option>
					<aui:option value="wsts">网上投诉</aui:option>
				</aui:select>
			</aui:col>
		</aui:row>
		<aui:button-row cssClass="text-center">
			<aui:button type="submit" value="查询"></aui:button>
		</aui:button-row>
	</div>
</aui:form>
<liferay-ui:search-container emptyResultsMessage="没有互动反馈数据。">
	<liferay-ui:search-container-results results="<%=FeedbackLocalServiceUtil.getFeedbacks(zt, lx, -1, searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%=FeedbackLocalServiceUtil.getFeedbacksCount(zt, lx, -1) %>">
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row
		className="com.justonetech.portal.feedback.model.Feedback"
		keyProperty="feedbackId" modelVar="feedback">
		<liferay-ui:search-container-column-text property="zt" name="主题" />
		<liferay-ui:search-container-column-text property="lx" name="类型" />
		<liferay-ui:search-container-column-text name="反馈日期"
			value="<%=DateUtil.getDate(feedback.getFkrq(), \"yyyy-MM-dd\", locale, timeZone)%>" />
		<liferay-ui:search-container-column-text name="回复日期"
			value="<%=DateUtil.getDate(feedback.getHfrq(), \"yyyy-MM-dd\", locale, timeZone)%>" />
		<liferay-ui:search-container-column-text name="action">
			<liferay-ui:icon-menu>
				<liferay-ui:icon image="view" label="查看" url="http://www.baidu.com" />
				<liferay-ui:icon image="reply" label="回复" url="http://www.baidu.com" />
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>