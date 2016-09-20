<%@page import="com.justonetech.sys.service.DictionaryLocalServiceUtil"%>
<%@page import="com.justonetech.sys.model.Dictionary"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>

<%
String lxId = (String)renderRequest.getAttribute("lxId");
String lxName="";
if(!Validator.isBlank(lxId)){
	lxName = DictionaryLocalServiceUtil.getDictionary(GetterUtil.getLong(lxId)).getName();
}
%>
<liferay-ui:error key="captcha-fail" message="${errorMessages }" />

<portlet:renderURL var="viewURL" />
<portlet:actionURL var="saveFeedBack" name="saveFeedBack">
	<portlet:param name="redirect" value="${viewURL}" />
</portlet:actionURL>
<aui:form id="fm" action="${saveFeedBack }">
	<div class="main">
		<div class="head"></div>
		<div class="body">
			<table class="thead">
				<tr>
					<td colspan="2" class="td"><span
						style="width: 5px; height: 20px; background-color: #ffa200; display: inline-block"></span><span><%=lxName %></span>
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
		<portlet:resourceURL var="captchaURL" id="ajaxCaptcha">
		</portlet:resourceURL>

		<aui:row style="margin-left:15px">
			<aui:col span="11">
				<div class="taglib-captcha">
					<aui:input label="验证码" name="captchaText" size="10" type="text"
						value="">
						<aui:validator name="required" />
						<aui:validator name="custom" errorMessage="错误的验证码。">
		        				function(val, fieldNode, ruleValue){ 
		        					if (val.trim().length != 4) 
		        						return false;
		        					var url = Liferay.Util.addParams('<portlet:namespace />captchaText=' + val, '${captchaURL }');
		        					var ret = false;
		        					AUI().use('aui-io-request', function(A){
						       		A.io.request(url, {
							        	  sync: true,
										  on: {
											   success: function() {
											   	 ret = (this.get('responseData') == "true");   
											   }
										  }
									});
							    });
		        					return ret;
	       					}
		    			</aui:validator>
					</aui:input>
					<img alt="<liferay-ui:message key="text-to-identify" />"
						class="captcha" id="<portlet:namespace />captcha"
						src="${captchaURL }" />

					<liferay-ui:icon cssClass="refresh" id="refreshCaptcha"
						image="../portlet/refresh" label="<%=false%>"
						localizeMessage="<%=true%>" message="refresh-captcha"
						url="javascript:;" />
				</div>

				<aui:script use="aui-base">
					A.one('#<portlet:namespace />refreshCaptcha').on(
							'click',
							function() {
								var url = Liferay.Util.addParams('t='
										+ A.Lang.now(), '${captchaURL }');

								A.one('#<portlet:namespace />captcha').attr(
										'src', url);
							});
				</aui:script>
				</aui:col>
		</aui:row>
		<aui:row>
			<aui:col span="12" cssClass="text-center">
				<aui:button type="submit" value="提交" />
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
	






















