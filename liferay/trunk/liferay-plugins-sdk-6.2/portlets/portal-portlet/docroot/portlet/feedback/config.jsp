<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<portlet:renderURL var="viewURL" />
<liferay-portlet:actionURL portletConfiguration="true"
	var="configurationURL" />
<aui:form method="post" action="<%=configurationURL%>">
	<aui:fieldset>
		<aui:input type="text" name="displayPage" label="显示页面"
			value="${displayPage}" required="true" />
		<aui:select name="lx" label="类型" required="true"
			showEmptyOption="true">
			<aui:option label="主任信箱" value="主任信箱" />
			<aui:option label="业务咨询" value="业务咨询" />
			<aui:option label="建议" value="建议" />
			<aui:option label="网上投诉" value="网上投诉" />
		</aui:select>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel" onClick="<%=viewURL.toString()%>" />
	</aui:button-row>
</aui:form>