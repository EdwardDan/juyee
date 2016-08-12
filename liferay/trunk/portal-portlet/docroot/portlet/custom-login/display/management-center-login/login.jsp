<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<style>
body {
	background-image:
		url('http://localhost:8080/documents/20181/0/bg2.jpg/0c2b3a54-8c02-490b-bb43-c37cfe80f053?t=1470966094000');
	background-repeat: no-repeat;
	background-clip: content-box;
	background-size: 100% 100%;
}

.title {
	width: 300px;
	height: 40px;
	position: absolute;
	left: calc(50% - 150px);
	top: 30%;
	background:
		url('http://localhost:8080/documents/20181/0/title.png/78c06171-d4cc-4baa-b345-e018023e01a5?t=1470966094633')
		no-repeat;
	background-size: cover;
}

.login {
	width: 300px;
	height: 220px;
	box-shadow: 2px 2px 3px #888888;
	background-color: white;
	position: absolute;
	left: calc(50% - 150px);
	top: 40%;
	border: 1px solid #cccccc;
	border-radius: 5px;
	filter: alpha(opacity = 95);
	opacity: .95;
	font-family: Microsoft Yahei;
}

.login_div {
	position: relative;
	width: 78%;
	height: 12%;
	left: 10%;
	margin: 6% 0;
}

.login_div_btn {
	position: relative;
	width: 78%;
	height: 12%;
	left: 10%;
	margin: 11% 0 0 0;
}

.login_tag {
	position: relative;
	left: 10%;
	margin: 8% 0;
	height: 10%;
	width: 78%;
	background:
		url('http://localhost:8080/documents/20181/0/titlez.png/734762e5-8455-41a0-8b92-e8bb5d8bc3fb?t=1470966095055')
		no-repeat;
	background-size: 100% 100%;
}

.login_input_user {
	width: 93% !important;
	height: 80% !important;
	border-radius: 3px !important;
	border: 1px solid #cccccc;
	background-image:
		url('http://localhost:8080/documents/20181/0/yhm.png/65abb28a-d2b1-46f8-8498-0b521a4b423a?t=1470966095477');
	background-repeat: no-repeat;
	background-position: left;
	text-indent: 25px;
}

.login_input_password {
	background-image:
		url('http://localhost:8080/documents/20181/0/mm.png/e8d67e4d-36a7-4aeb-9da6-475abf3c01d2?t=1470966094242');
	background-repeat: no-repeat;
	background-position: left;
	text-indent: 25px;
	border-radius: 3px !important;
	border: 1px solid #cccccc;
	color: #cccccc;
	width: 93% !important;
	height: 80% !important;
}

.login_login_btn {
	width: 100%;
	height: 100%;
	border-radius: 3px;
	border: none;
	background-color: #0081dc;
	color: white;
}

#p_p_id_managementcenterlogin_WAR_portalportlet_ .portlet-borderless-container
	{
	background-color: transparent !important;
}
</style>

<portlet:resourceURL var="loginUrl" id="login" />

<form class="form sign-in-form " id="_58_fm" method="post" name="_58_fm"
	autocomplete="off">
	<input name="_58_formDate" type="hidden" value="1470964064174">
	<input class="field" id="_58_saveLastPath" name="_58_saveLastPath"
		type="hidden" value="false"> <input class="field"
		id="_58_redirect" name="_58_redirect" type="hidden"
		value="${redirectPage}"> <input class="field"
		id="_58_doActionAfterLogin" name="_58_doActionAfterLogin"
		type="hidden" value="false">
	<div style="width: 100%; height: 400px">
		<div class="title"></div>
		<div class="login">
			<div class="login_tag"></div>

			<div class="login_div">
				<input name="_58_login" id="_58_login" value="请输入用户名" class="login_input_user"
					type="text" style="color: #cccccc;"
					onfocus="if(this.value=='请输入用户名'){this.value='';this.style.color='#666666';}"
					onblur="if(this.value==''){this.value='请输入用户名';this.style.color='#cccccc';}">
			</div>

			<div class="login_div">
				<input name="_58_password" id="_58_password" value="请输入密码"
					class="login_input_password" type="text" style="color: #cccccc;"
					onfocus="if(this.value=='请输入密码'){this.value='';this.style.color='#666666'; this.type='password'}"
					onblur="if(this.value==''){this.value='请输入密码';this.style.color='#cccccc';this.type='text'}">
			</div>

			<div class="login_div_btn">
				<input type="button" class="login_login_btn"
					onclick="validateForm()" style="width: 100%; height: 100%"
					value="登录">
			</div>
		</div>
	</div>
</form>

<script>
	$(document).ready(
			function() {
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

	function validateForm(){
			$.ajax({
				type:"GET",
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
					if(strJson.loginState==true){
						document.getElementById('_58_fm').action ="${themeDisplay.getURLCurrent()}?p_p_id=58&amp;p_p_lifecycle=1&amp;p_p_state=normal&amp;p_p_mode=view&amp;p_p_col_id=column-1&amp;p_p_col_pos=2&amp;p_p_col_count=3&amp;_58_struts_action=%2Flogin%2Flogin";
				        document.getElementById("_58_fm").submit(); 
					}else{
						alert(strJson.responseContent);
					}
					 
				}
			});
	}
</script>