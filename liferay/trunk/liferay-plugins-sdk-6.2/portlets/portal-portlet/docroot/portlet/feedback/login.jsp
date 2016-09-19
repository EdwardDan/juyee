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

.login_input{
	margin: 10px auto 0px !important;
	border-radius: 5px !important;
}

.login_input_yzm{
	margin: 10px auto 0px !important;
	border-radius: 5px !important;
	width:25% !important;
}
</style>
<script type="text/javascript">
    window.jQuery || document.write("<script src='/static/jquery/jquery-1.12.4.min.js'>"+"<"+"/script>");
</script> 
<div class="main">
	<div class="head"></div>
	<div class="body">
		<table class="thead">
			<tr>
				<td colspan="2" class="head"><span style="width: 5px; height: 20px; background-color: #ffa200; display: inline-block"></span><span>用户登录</span>
				</td>
			</tr>
		</table>
	</div>
	<div class="text-center">
		<form
			action="${themeDisplay.getURLCurrent()}?p_p_id=58&amp;p_p_lifecycle=1&amp;p_p_state=normal&amp;p_p_mode=view&amp;p_p_col_id=column-1&amp;p_p_col_pos=2&amp;p_p_col_count=3&amp;_58_struts_action=%2Flogin%2Flogin"
			class="form sign-in-form " id="<portlet:namespace/>_58_fm" method="post" name="<portlet:namespace/>_58_fm" autocomplete="off">
			<input class="field" id="_58_saveLastPath"
				name="_58_saveLastPath" type="hidden" value="false"> <input class="field" id="_58_redirect" name="_58_redirect" type="hidden"
				value="${themeDisplay.getURLCurrent()}"> <input class="field" id="_58_doActionAfterLogin" name="_58_doActionAfterLogin"
				type="hidden" value="false">
			<div class="login_div_user">
				<input name="_58_login" id="_58_login" value="请输入用户名" style="color: #cccccc;" class="login_input" type="text"
					onfocus="userFocus(this)" onblur="userBlur(this)">
			</div>

			<div class="login_div_password">
				<input name="_58_password" id="_58_password" value="请输入密码" style="color: #cccccc;" class="login_input" type="text"
					onfocus="passwordFocus(this)" onblur="passwordBlur(this)">
			</div>
			<div>
				<aui:input name="yzm" placeholder="验证码" label="" cssClass="login_input_yzm" ></aui:input>
				<br>
			</div>
			<div id="loginMessage" class="loginMessage"></div>
			<div>
				<aui:button type="submit" value="登录" />
				<aui:button name="register" value="注册" href="${registerURL}" />
			</div>
		</form>
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

	function validateForm(){
			$.ajax({
				type:"post",
				url:"<%=loginUrl%>",
					data : {
						'<portlet:namespace/>_58_login' : $('#_58_login').val(),
						'<portlet:namespace/>_58_password' : $('#_58_password').val()
					},
					error : function(err) {
						alert("提交失败!");
					},
					success : function(data) {
						var strJson = eval("(" + data + ")");
						if (strJson.loginState == true) {
							document.getElementById("<portlet:namespace/>_58_fm").submit();
						} else {
							$("#loginMessage").text(strJson.responseContent);
							document.getElementById("loginMessage").style.visibility = "visible";
						}

					}
				});
	}
</script>