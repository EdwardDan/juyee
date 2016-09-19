<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<portlet:renderURL var="viewURL"/>
<liferay-portlet:actionURL portletConfiguration="true"
	var="configurationUrl" />
<aui:form method="post" action="<%=configurationUrl%>">
	<aui:fieldset>
		<aui:input type="text" name="loginPage" label="登录前页面"
			value="${loginPage}" required="true" />
		<aui:input type="text" name="loggedInPage" label="登录后页面"
			value="${loggedInPage}" required="true" />
		<aui:input type="text" name="redirectPage" label="登录后跳转页面"
			value="${redirectPage}" required="true" />
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%=viewURL.toString()%>"></aui:button>
	</aui:button-row>
</aui:form>