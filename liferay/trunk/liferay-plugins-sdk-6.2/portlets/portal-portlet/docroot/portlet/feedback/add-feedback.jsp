<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<link rel="stylesheet" type="text/css"
	href="/portal-portlet/portlet/feedback/css/query.css" />
<liferay-ui:error key="captcha-fail" message="${errorMessages }" />

<portlet:renderURL var="viewURL" />
<portlet:actionURL var="saveFeedBack" name="saveFeedBack">
	<portlet:param name="redirect" value="${viewURL}" />
</portlet:actionURL>
<aui:form id="fm" action="${saveFeedBack }">
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
		<portlet:resourceURL var="captchaURL" id="ajaxCaptcha">
		</portlet:resourceURL>

		<aui:row style="margin-left:15px">
			<aui:col span="11">
				<div class="taglib-captcha">
					<aui:input label="验证码" name="captchaText" size="10" type="text"
						value="" inlineLabel="true">
						<aui:validator name="required" />
						<aui:validator name="custom" errorMessage="错误的验证码。">
        				function(val, fieldNode, ruleValue){ 
        					if (val.trim().length != 4) 
        						return false;
        					var url = Liferay.Util.addParams('<portlet:namespace />captchaText=' + val, '${captchaURL }');
        					console.log("url:" + url);
        					var ret = false;
        					AUI().use('aui-io-request', function(A){
						        A.io.request(url, {
						        	  sync: true,
									  on: {
									   success: function() {
									     console.log("reponse:" + this.get('responseData'));
									   	 ret = (this.get('responseData') == "true");   
									   }
									  }
									});
						    });
						    console.log("ret:" + ret);
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
	






















