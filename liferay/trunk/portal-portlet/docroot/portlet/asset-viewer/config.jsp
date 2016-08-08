<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/portlet/asset-viewer/view.jsp"></portlet:param>
</portlet:renderURL>
<liferay-portlet:actionURL portletConfiguration="true"
	var="configurationUrl" />
<aui:form method="post" action="<%=configurationUrl%>">
	<aui:fieldset>
		<aui:input type="text" name="displayPage" label="显示页面" value="${displayPage}"
			required="true" />
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%=viewURL.toString()%>"></aui:button>
	</aui:button-row>
</aui:form>
