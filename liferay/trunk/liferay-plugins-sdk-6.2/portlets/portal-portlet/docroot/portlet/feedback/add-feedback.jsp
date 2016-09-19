<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<link rel="stylesheet" type="text/css" href="/portal-portlet/portlet/feedback/css/query.css" />
<portlet:renderURL var="viewURL" />
<portlet:actionURL var="savFeedBack" name="saveFeedBack">
	<portlet:param name="redirect" value="${viewURL}"/>
</portlet:actionURL>
<aui:form id="fm" action="${savFeedBack }">
	<div class="out">
		<div class="middle"></div>
		<div class="in">
			<table class="thead">
				<tr>
					<td colspan="2" class="head"><span
						style="width: 5px; height: 20px; background-color: #ffa200; display: inline-block"></span><span>主任信箱</span>
					</td>
				</tr>
			</table>
		</div>
	<br>
	<aui:row style="margin-left:15px">
		<aui:col span="11">
			<aui:input name="zt" label="主题" type="text" cssClass="span12">
				<aui:validator name="required" errorMessage=""></aui:validator>
			</aui:input>
			最多可以再输入<span id="ztCounter" style="color: red"></span>个汉字</aui:col>
	</aui:row>
	<br>
	<aui:row style="margin-left:15px">
		<aui:col span="11">
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
	<br>
	</div>
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
	






