<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<c:set var="contextPath" value="${request.contextPath}/portlet/feedback" />
<portlet:renderURL var="registerURL">
	<portlet:param name="mvcPath" value="${contextPath}/register.jsp" />
</portlet:renderURL>
<style type="text/css">
div.main {
	border-left: 1px solid #ddd;
	border-bottom: 1px solid #ddd;
	border-right: 1px solid #ddd;
	box-shadow: 2px 2px 2px #e8e8e8;
	border-radius: 5px;
}

div.head {
	background-color: #00a2ee;
	height: 10px;
}

div.body {
	border-bottom: 1px solid #ddd;
}

table.thead tr td.head {
	color: #0073d4;
	font-size: 18px;
	line-height: 30px;
}

table.thead tr td span {
	margin-left: 15px;
	display: inline-block;
	vertical-align: middle;
	font-family: "Microsoft YaHei UI";
}

table.thead tr td a {
	display: inline-block;
	width: 160px;
	height: 30px;
	line-height: 30px;
	text-align: center;
	color: #fff;
	border-radius: 5px;
	text-decoration: none;
	background-color: #ff954f;
	margin-left: 56px
}

table.thead tr td input {
	width: 200px;
	height: 25px;
	border-radius: 5px;
}

table.thead tr td select {
	width: 200px;
	height: 30px;
	border-radius: 5px
}

.login_input {
	margin: 10px auto 0px !important;
}
</style>
<script type="text/javascript">
    window.jQuery || document.write("<script src='/static/jquery/jquery-1.12.4.min.js'>"+"<"+"/script>");
</script>
<liferay-ui:error key="captcha-fail" message="${errorMessages }" />
<div class="main">
	<div class="head"></div>
	<div class="body">
		<table class="thead">
			<tr>
				<td colspan="2" class="head"><span
					style="width: 5px; height: 20px; background-color: #ffa200; display: inline-block"></span><span>用户登录</span>
				</td>
			</tr>
		</table>
	</div>
	<div class="text-center">
		<form
			action="${themeDisplay.getURLHome()}?p_p_id=58&amp;p_p_lifecycle=1&amp;p_p_state=normal&amp;p_p_mode=view&amp;p_p_col_id=column-1&amp;p_p_col_pos=2&amp;p_p_col_count=3&amp;_58_struts_action=%2Flogin%2Flogin"
			class="form sign-in-form " id="<portlet:namespace/>_58_fm"
			method="post" name="<portlet:namespace/>_58_fm" autocomplete="off">
			<input class="field" id="_58_saveLastPath" name="_58_saveLastPath"
				type="hidden" value="false"> <input class="field"
				id="_58_redirect" name="_58_redirect" type="hidden"
				value="${themeDisplay.getURLCurrent()}"> <input
				class="field" id="_58_doActionAfterLogin"
				name="_58_doActionAfterLogin" type="hidden" value="false">
			<div class="login_div_user">
				<input name="_58_login" id="_58_login" value="请输入用户名"
					style="color: #cccccc;" class="login_input" type="text"
					onfocus="userFocus(this)" onblur="userBlur(this)">
			</div>

			<div class="login_div_password">
				<input name="_58_password" id="_58_password" value="请输入密码"
					style="color: #cccccc;" class="login_input" type="text"
					onfocus="passwordFocus(this)" onblur="passwordBlur(this)">
			</div>
			<div id="loginMessage" class="loginMessage"></div>
		</form>
		<aui:form>
			<div>
				<div class="taglib-captcha">
					<portlet:resourceURL var="captchaURL" id="ajaxCaptcha">
					</portlet:resourceURL>
					<aui:input label="" name="captchaText" id="captchaText" size="10"
						type="text" value="请输入验证码" onfocus="PINFocus(this)"
						onblur="PINBlur(this)" inlineLabel="true">
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

				</div>
		</aui:form>
		<div>
			<aui:button name="login" value="登录" onClick="validateForm()" />
			<aui:button name="register" value="注册" href="${registerURL}" />
		</div>
	</div>
</div>
<portlet:resourceURL var="loginUrl" id="feedback" />
<script>
	$(document).ready(
			function() {
				document.onkeydown=keyDownSearch; 
				var login_body = document.getElementsByTagName("body");
				login_body[0].style.width = $(window).width() + "px";
				login_body[0].style.height = $(window).height() + "px";
				login_body[0].style.backgroundSize = $(window).width() + "px"
						+ " " + $(window).height() + "px";
				$(window).resize(
						function() {
							login_body[0].style.width = $(window).width()
									+ "px";
							login_body[0].style.height = $(window).height()
									+ "px";
							login_body[0].style.backgroundSize = $(window)
									.width()
									+ "px" + " " + $(window).height() + "px";
						});
			});
	
	function keyDownSearch(e) {    
	    // 兼容FF和IE和Opera    
	    var theEvent = e || window.event;    
	    var code = theEvent.keyCode || theEvent.which || theEvent.charCode;    
	    if (code == 13) { 
	    	 setTimeout(function(){
	    		 validateForm();
	         },0);
	         e.preventDefault ? e.preventDefault() : (e.returnValue = false);

	    }    
	} 
	
	function userFocus(ele){if(ele.value=='请输入用户名'){ele.value='';ele.style.color='#666666';}
		document.getElementById("loginMessage").style.visibility="hidden";}
	function userBlur(ele){if(ele.value==''){ele.value='请输入用户名';ele.style.color='#cccccc';}}
	function passwordFocus(ele){if(ele.value=='请输入密码'){ele.value='';ele.style.color='#666666'; ele.type='password'};
		document.getElementById("loginMessage").style.visibility="hidden";}
	function passwordBlur(ele){if(ele.value==''){ele.value='请输入密码';ele.style.color='#cccccc';ele.type='text'}}
	function PINFocus(ele){if(ele.value=='请输入验证码'){ele.value='';ele.style.color='#666666'; ele.type='password'};
	document.getElementById("loginMessage").style.visibility="hidden";}
	function PINBlur(ele){if(ele.value==''){ele.value='请输入验证码';ele.style.color='#cccccc';ele.type='text'}}

	
	function validateForm(){
		if($("#_58_login").val()=="请输入用户名"){
			alert("请输入用户名！");
			return false;
		}
		if($("#_58_password").val()=="请输入密码"){
			alert("请输入密码！");
			return false;
		}
		if($("#<portlet:namespace/>captchaText").val()=="请输入验证码"){
			alert("请输入验证码！");
			return false;
		}
		
		if($("#<portlet:namespace/>captchaText").attr("class").toString().indexOf("error-field", 0)>0){
			return false;
		}
		
			$.ajax({
				type:"post",
				url:"<%=loginUrl%>",
					data : {
						'<portlet:namespace/>_58_login' : $('#_58_login').val(),
						'<portlet:namespace/>_58_password' : $('#_58_password')
								.val()
					},
					error : function(err) {
						alert("提交失败!");
					},
					success : function(data) {
						var strJson = eval("(" + data + ")");
						if (strJson.loginState == true) {
							document.getElementById(
									"<portlet:namespace/>_58_fm").submit();
						} else {
							$("#loginMessage").text(strJson.responseContent);
							document.getElementById("loginMessage").style.visibility = "visible";
						}

					}
				});
	}

	function onSubmit() {
		alert($("#<portlet:namespace/>captchaText").val());
		return false;
	}
</script>