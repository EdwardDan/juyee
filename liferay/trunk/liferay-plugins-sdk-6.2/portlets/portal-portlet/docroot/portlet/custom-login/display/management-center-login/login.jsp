<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<style>
	html,body{
		height:100%;
	}

    body {
        background: #fff url('/documents/20181/26528/bg2.jpg/790f7e40-1897-4255-bd46-9a2a73e8bb5f?t=1471230827000') 50% 0 no-repeat;
    }
    
    .title {
        position: relative;
        margin: 150px auto 0 auto;
        width: 320px;
        height: 50px;
        background: url('/documents/20181/26528/title.png/a241be9f-cd0a-4693-9872-2dc45cdde235?t=1471247909387') no-repeat;
        background-size: contain;
    }

    .login {
        width: 320px;
        height: 250px;
        box-shadow: 2px 2px 3px #888888;
        background-color: white;
        position: relative;
        border: 1px solid #cccccc;
        border-radius: 5px;
        filter: alpha(opacity = 95);
        opacity: .95;
        font-family: Microsoft Yahei;
        margin: 0px auto 0 auto;
    }

    .login_div_user {
        position: relative;
        width: 78%;
        height: 12%;
        left: 10%;
        margin: 6% 0;
    }

    .login_div_password {
        position: relative;
        width: 78%;
        height: 12%;
        left: 10%;
        margin: 6% 0 3% 0;
    }

    .login_div_btn {
        position: relative;
        width: 78%;
        height: 12%;
        left: 10%;
        margin: 1% 0 0 0;
    }

    .login_tag {
        position: relative;
        left: 10%;
        margin: 8% 0;
        height: 10%;
        width: 78%;
        background: url('/documents/20181/26528/titlez.png/c0971fda-277f-4c99-8905-274a20706c89?t=1471247910203') no-repeat;
        background-size: 100% 100%;
    }

    .login_input_user {
        width: 93% !important;
        height: 80% !important;
        border-radius: 3px !important;
        border: 1px solid #cccccc;
        background-image: url('/documents/20181/26528/yhm.png/4f58e524-167e-4cb6-b442-49001d60a5c7?t=1471247910604');
        background-repeat: no-repeat;
        background-position: left;
        text-indent: 25px;
    }

    .login_input_password {
        background-image: url('/documents/20181/26528/mm.png/87bb62c9-2731-4aba-9e76-e01036916d91?t=1471247908696');
        background-repeat: no-repeat;
        background-position: left;
        text-indent: 25px;
        border-radius: 3px !important;
        border: 1px solid #cccccc;
        width: 93% !important;
        height: 80% !important;
    }

    .login_login_btn {
        width: 246px !important;
        height: 100% !important;
        border-radius: 3px;
        border: none;
        background-color: #0081dc;
        color: white;
    }

    .loginMessage {
        position: relative;
        left: 10%;
        visibility: hidden;
        height: 20px;
        color: red;
        width: 78%;
        font-size: 12px;
        font-family: Microsoft YaHei;
        border: none;
    }

    #_58_login{
        color: #cccccc;
    }

    #_58_password{
        color: #cccccc;
    }
    
    #p_p_id_customlogin_WAR_portalportlet_ .portlet-borderless-container{
		background-color: transparent !important;
    }
</style>

<portlet:resourceURL var="loginUrl" id="Management-Center-login" />

<form action="${themeDisplay.getURLCurrent()}?p_p_id=58&amp;p_p_lifecycle=1&amp;p_p_state=normal&amp;p_p_mode=view&amp;p_p_col_id=column-1&amp;p_p_col_pos=2&amp;p_p_col_count=3&amp;_58_struts_action=%2Flogin%2Flogin" class="form sign-in-form " id="_58_fm" method="post" name="_58_fm" autocomplete="on">
	<input name="_58_formDate" type="hidden" value="1470964064174"> <input class="field" id="_58_saveLastPath" name="_58_saveLastPath" type="hidden" value="false"> <input class="field" id="_58_redirect" name="_58_redirect" type="hidden" value="${redirectPage}"> <input class="field" id="_58_doActionAfterLogin" name="_58_doActionAfterLogin" type="hidden" value="false">
	<input name="_58_login" id="_58_login"  type="hidden"  >
	<input name="_58_password" id="_58_password"  type="hidden"  >
</form>	
	<div id=login_div>
		<div class="title" id="title"></div>
		<div class="login" id="login">
			<div class="login_tag"></div>

			<div class="login_div_user">
				<input id="loginInput" value="请输入用户名" class="login_input_user" type="text" onfocus="userFocus(this)" onblur="userBlur(this)">
			</div>

			<div class="login_div_password">
				<input id="passwordInput" value="请输入密码" class="login_input_password" type="text" onfocus="passwordFocus(this)" onblur="passwordBlur(this)">
			</div>

			<div id="loginMessage" class="loginMessage"></div>

			<div class="login_div_btn">
				<input type="button" class="login_login_btn" onclick="validateForm()" value="登录"><br>
				<span style="font-size: 12px">技术支持电话：15950151489</span>
			</div>
		</div>
	</div>

<script type="text/javascript" src="/portal-portlet/js/des.js"></script>
<script>
$(document).ready(
        function() {
        	document.onkeydown=keyDownSearch;
            var body = document.getElementsByTagName("body");
            body[0].style.backgroundSize = $(window).width() + "px"
            + " " + $(window).height() + "px";
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
				'<portlet:namespace/>_58_login' : $('#loginInput').val(),
				'<portlet:namespace/>_58_password' : $('#passwordInput').val()
			},
			error : function(err) {
				alert("提交失败!");
			},
			success : function(data) {
				var strJson = eval("(" + data + ")");
				if (strJson.loginState == true) {
					var key1 = "1";
					var key2 = "2";
					var key3 = "3";
					
					var login = $('#loginInput').val();
					login = strEnc(login,key1,key2,key3); 	
					var password = $('#passwordInput').val();
					password = strEnc(password,key1,key2,key3); 	
					$('#_58_login').val(login)
					$('#_58_password').val(password)
					document.getElementById("_58_fm").submit();
				} else {
					$("#loginMessage").text(strJson.responseContent);
					document.getElementById("loginMessage").style.visibility = "visible";
				}

			}
		});
	}
</script>