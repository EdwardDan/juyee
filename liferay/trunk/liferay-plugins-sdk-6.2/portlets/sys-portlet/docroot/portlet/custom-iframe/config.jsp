<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/portlet/custom-iframe/view.jsp"></portlet:param>
</portlet:renderURL>
<liferay-portlet:actionURL portletConfiguration="true"
	var="configurationUrl" />
<aui:form method="post" action="<%=configurationUrl%>">
	<aui:fieldset>
		<aui:row>
			<aui:col span="12">
				<aui:input type="text" name="src" label="源URL" value="${src}"
					cssClass="input-xxlarge" />
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="12">
				<aui:input type="text" name="height" label="高度" value="${height}"
					cssClass="input-mini" />
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="12">
				<aui:input type="checkbox" name="isAddUserParam" label="是否附加用户参数"
					value="${isAddUserParam}" />
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="12">
				<aui:input type="checkbox" name="isAddPwdParam" label="是否附加密码参数"
					value="${isAddPwdParam}" />
			</aui:col>
		</aui:row>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" href="${viewURL }"></aui:button>
	</aui:button-row>
</aui:form>