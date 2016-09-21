<%@page import="org.apache.http.client.utils.URLEncodedUtils"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page
	import="com.justonetech.portal.feedback.service.FeedbackLocalServiceUtil"%>
<%@page import="com.justonetech.portal.feedback.model.Feedback"%>
<%@page import="com.justonetech.sys.service.DictionaryLocalServiceUtil"%>
<%@page import="com.justonetech.sys.model.Dictionary"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contextPath"
	value="${request.contextPath}/portlet/feedback" />
<portlet:renderURL var="searchURL" />
<%
	PortletPreferences preferences = renderRequest.getPreferences();
	String displayPage = preferences.getValue("displayPage", StringPool.BLANK);
	renderRequest.setAttribute("displayPage", displayPage);
	String action = preferences.getValue("action", StringPool.BLANK);

	String zt = ParamUtil.getString(request, "zt");
	Long lxId = ParamUtil.getLong(request, "lxId",-1);
	long fkrId = user.getUserId();
	long currentUserId = PortalUtil.getUserId(request);
	long[] roleIds = user.getRoleIds();

 	fkrId = Validator.equals(action, "aply")?-1:fkrId;
 	
%>
<aui:form name="fm" id="fm" method="post" action="${searchURL }">
	<div class="main">
		<div class="head"></div>
		<div class="body">
			<table class="thead">
				<tr>
					<td colspan="2" class="td"><span
						style="width: 5px; height: 20px; background-color: #ffa200; display: inline-block"></span><span>回复查询</span>
					</td>
				</tr>
			</table>
		</div>
		<aui:row>
			<aui:col span="12" cssClass="text-center" style="margin-top:15px">
				<aui:input type="text" name="zt" label="主题" inlineLabel="left"
					inlineField="true"></aui:input>
				<aui:select name="lxId" label="类型" showEmptyOption="true"
					inlineLabel="left" inlineField="true">
					<%
						Dictionary dictionary = DictionaryLocalServiceUtil.findByCode("hdfklx");
						if (Validator.isNotNull(dictionary)) {
							List<Dictionary> dictionaries = DictionaryLocalServiceUtil.findByParentId(dictionary.getDictionaryId(), -1, -1);
							for (Dictionary dic : dictionaries) {
								request.setAttribute("dic", dic);
					%>
					<aui:option value="${dic.dictionaryId }" label="${dic.name }" selected="${lxId eq dic.dictionaryId}"/>
					<%
							}
						}
					%>
				</aui:select>
			</aui:col>
		</aui:row>
		<aui:button-row cssClass="text-center">
			<aui:button type="submit" value="查询"></aui:button>
		</aui:button-row>
	</div>
</aui:form>
<liferay-ui:search-container emptyResultsMessage="没有互动反馈数据。">
	<liferay-ui:search-container-results results="<%=FeedbackLocalServiceUtil.getFeedbacks(zt, lxId, fkrId, searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%=FeedbackLocalServiceUtil.getFeedbacksCount(zt, lxId, fkrId) %>"/>
	<liferay-ui:search-container-row
		className="Feedback"
		keyProperty="feedbackId" modelVar="feedback">
		<%
			String lx=Validator.equals(0, feedback.getLxId())?"":DictionaryLocalServiceUtil.getDictionary(GetterUtil.getLong(feedback.getLxId())).getName();
		%>
		<liferay-ui:search-container-column-text property="zt" name="主题" />
		<liferay-ui:search-container-column-text name="类型" value="<%=lx %>"/>
		<liferay-ui:search-container-column-text name="反馈日期" value="<%=DateUtil.getDate(feedback.getFkrq(), \"yyyy-MM-dd\", locale, timeZone)%>" />
		<liferay-ui:search-container-column-text name="回复日期"  value="<%=Validator.isNotNull(feedback.getHfrq())?DateUtil.getDate(feedback.getHfrq(), \"yyyy-MM-dd\", locale, timeZone):\"\"%>" />
		<liferay-ui:search-container-column-text name="action">
			<liferay-ui:icon-menu>
				<portlet:renderURL var="viewFeedbackURL">
					<portlet:param name="mvcPath" value="${contextPath }/view-feedback.jsp"/>
					<portlet:param name="feedbackId" value="${feedback.feedbackId }"/>
					<portlet:param name="lx" value="<%=lx %>"/>
				</portlet:renderURL>
				<liferay-ui:icon image="view" label="查看" url="${viewFeedbackURL }" />
				<c:if test='<%=Validator.equals(action, "aply") %>'>
					<portlet:renderURL var="replyFeedbackURL">
						<portlet:param name="mvcPath" value="${contextPath }/reply-feedback.jsp"/>
						<portlet:param name="feedbackId" value="${feedback.feedbackId }"/>
						<portlet:param name="lx" value="<%=lx %>"/>
					</portlet:renderURL>
					<liferay-ui:icon image="reply" label="回复" url="${replyFeedbackURL }" />
				</c:if>

			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>