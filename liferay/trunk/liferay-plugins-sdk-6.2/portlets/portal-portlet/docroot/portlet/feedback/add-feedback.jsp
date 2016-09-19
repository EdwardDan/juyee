<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<portlet:renderURL var="viewURL" />
<portlet:actionURL var="savFeedBack" name="saveFeedBack">
</portlet:actionURL>
<aui:form id="fm" action="${savFeedBack }">
	<aui:input name="lx" type="hidden" value="主任邮箱" />
	<aui:row>
		<aui:col span="12">
			<aui:input name="zt" label="主题" type="text" cssClass="span12">
				<aui:validator name="required" errorMessage=""></aui:validator>
			</aui:input>
			最多可以再输入<span id="ztCounter" style="color: red"></span>个汉字		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="12">
			<aui:input name="fknr" label="内容" type="textarea" cssClass="span12"
				style="height:100px">
				<aui:validator name="required" errorMessage=""></aui:validator>
			</aui:input>
			最多可以再输入<span id="contentCounter" style="color: red"></span>个汉字
		</aui:col>
	</aui:row>

	<aui:row>
		<aui:col span="12">
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="12" cssClass="text-center">
			<aui:button type="submit" value="提交" />
			<aui:button type="cancel" value="返回" href="${viewURL}" />
		</aui:col>
	</aui:row>
</aui:form>
<aui:script use="aui-char-counter">
	var counterVariable = new A.CharCounter({
		input : '#<portlet:namespace/>fknr',
		counter : '#contentCounter',
		maxLength : 2000
	});
	
	var ztVariable = new A.CharCounter({
		input : '#<portlet:namespace/>zt',
		counter : '#ztCounter',
		maxLength : 30
	});
</aui:script>
	






