<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ include file="/common/init.jsp"%>
<portlet:defineObjects />
<script type="text/javascript">
	
	
	$(function() {
		getExplorer();
		document.onkeydown=keyDownSearch;  
	});
	
	function keyDownSearch(e) {    
	    // 兼容FF和IE和Opera    
	    var theEvent = e || window.event;    
	    var code = theEvent.keyCode || theEvent.which || theEvent.charCode;    
	    if (code == 13) { 
	    	 setTimeout(function(){
	 	    	loginToBSDT();
	         },0);
	         e.preventDefault ? e.preventDefault() : (e.returnValue = false);

	    }    
	} 
	
	//判断是否ie
	function getExplorer() {
		var explorer = window.navigator.userAgent;

		var isClose = false;
		if ((explorer.indexOf("MSIE") >= 0) && !(explorer.indexOf("MSIE 10") >= 0)
				&& !(explorer.indexOf("MSIE 9") >= 0) && !(explorer.indexOf("MSIE 8") >= 0)) {
			isClose = true;
		}
		if (explorer.indexOf("Opera") >= 0) {
			isClose = true;
		}
		if (explorer.indexOf("Firefox") >= 0) {
			isClose = true;
		}
		if (explorer.indexOf("Safari") >= 0) {
			isClose = true;
		}

		if (isClose) {
			alert("请使用ie8或以上版本浏览器访问本页面！");
			window.opener = null;
			window.open('', '_self');
			window.close(); 
		}
		$("#_58_fm").removeAttr("hidden");
	}

</script>

<style type="text/css">
.bg1 {
	background: url(/documents/20181/0/login_back.jpg/12516d4e-8d05-4fab-adf3-b7c066799875?t=1471228073000);
	background-repeat: no-repeat;
	background-clip: content-box;
	background-size: cover;
	overflow: hidden
}

.login {
	width: 50%;
	height: 40%;
	background: url(/documents/20181/0/login_form.png/4e09dfaf-30b8-4465-a65f-be713276692a?t=1471245176656) no-repeat;
	background-size: 100% 100%;
	-moz-box-shadow: 5px 5px 5px #999; /* For Firefox3.6+ */
	-webkit-box-shadow: 5px 5px 5px #999; /* For Chrome5+, Safari5+ */
	box-shadow: 5px 5px 5px #999; /* For Latest Opera */
	position: absolute;
	left: 25%;
	top: 35%;
	border-radius: 5px;
	filter: alpha(opacity = 95);
	opacity: .95;
	-webkit-box-shadow: 5px 5px 5px #999; /* For Chrome5+, Safari5+ */
	box-shadow: 5px 5px 5px #999;
	box-shadow: 5px 5px 5px #999;
}

.login_div {
	position: relative;
	top: 45%;
	left: 5.5%;
	width: 50%;
	height: 10%;
}

.login .login_div .login_input {
	position: relative;
	width: 77%;
	height: 100%;
	border-radius: 3px;
	border: 1px solid #cccccc;
}

.login_tip {
	position: relative;
	top: 50%;
	left: 5.5%;
	width: 50%;
	font-size: 12px;
	color: #0066FF;
}

.login_btn {
	position: relative;
	top: 55%;
	left: 5.5%;
	width: 50%;
	height: 10%;
	font-size: 12px;
	color: #0066FF;
}

.submit_button {
	background-color: #0081dc;
	border: none;
	border-radius: 5px;
	left: 5.5%;
	width: 80%;
	color: #ffffff;
	font-size: 14px;
	font-family: 微软雅黑;
	height: 100%;
}

.login_description {
	position: relative;
	top: 20%;
	left: 55%;
	width: 40%;
	font-size: 14px;
	color: #8C96A2;
}

.login .login_div .password_input {
	vertical-align: middle;
	border: 1px solid #9e9e9e;
	background-image: url(/documents/20181/0/input_bg2.jpg/e3769618-8713-49fe-a7a9-83730c998d9d?t=1471228064000);
	background-repeat: no-repeat;
	background-position: left;
	text-indent: 25px;
	-moz-border-radius: 6px;
	-webkit-border-radius: 6px;
	border-radius: 6px;
}

form.login_form {
	margin: 0;
}

#p_p_id_customlogin_WAR_portalportlet_ .portlet-borderless-container {
	background-color: transparent;
}
</style>

<form action="${themeDisplay.getURLCurrent()}?p_p_id=58&amp;p_p_lifecycle=1&amp;p_p_state=normal&amp;p_p_mode=view&amp;p_p_col_id=column-1&amp;p_p_col_pos=2&amp;p_p_col_count=3&amp;_58_struts_action=%2Flogin%2Flogin" class="form sign-in-form " id="_58_fm" method="post" name="_58_fm" autocomplete="off" hidden="true">
	<div id="login_div">
		<div id="login_form" class="login">
			<div class="login_div">
				<input type="hidden" id="cCert" name="cCert" value="" /> <input type="hidden" id="cSign" name="cSign" value="" /> <input type="hidden" id="<portlet:namespace/>content" name="<portlet:namespace/>content" value="${UUID}" /> <input name="_58_formDate" type="hidden" value="1470964064174"> <input class="field" id="_58_saveLastPath" name="_58_saveLastPath" type="hidden" value="false"> <input class="field" id="_58_redirect" name="_58_redirect" type="hidden" value="${redirectPage}"> <input class="field" id="_58_doActionAfterLogin" name="_58_doActionAfterLogin" type="hidden" value="false"> <input class="field clearable" id="_58_login" name="_58_login" type="hidden" value="" /> <input
					id="_58_password" name="_58_password" maxlength="10" type="password" value="" placeholder="密　码" class="login_input password_input">
			</div>
			<div>
				<OBJECT ID="SafeEngineCtl" CLASSID="CLSID:B48B9648-E9F0-48A3-90A5-8C588CE0898F" width="300" height="50" border=0 hidden="hidden"></OBJECT>
			</div>
			<div class="login_tip">
				请先插入数字证书后再输入密码<br /> 请使用IE浏览器访问本系统
			</div>

			<div class="login_btn">
				<button class="submit_button" type='button' id="btnSub" name="btnSub" onclick="loginToBSDT()">登录</button>
			</div>

			<div class="login_description">
				1、企业用户请持法人一证通登录。<a href="https://www.ciac.sh.cn/CIACuserportal/Help/AboutLogin.aspx" target="_Blank">查看登录流程</a><br /> 2、证书驱动<a href="http://www.962600.com/Service/Index/16?subId=19" target="_Blank">下载地址</a><br /> 3、数字证书<a href="https://www.ciac.sh.cn/CIACuserportal/Content/File/%E6%95%B0%E5%AD%97%E8%AF%81%E4%B9%A6%E5%8A%9E%E7%90%86%E9%A1%BB%E7%9F%A5.doc" target="_Blank">办理须知</a>
			</div>
		</div>
	</div>
</form>

<script type="text/javascript">
	function checkForm() {
		var password = $("#_58_password").val();
		$("#btnSub").disabled = true;
		// 判断数字证书插件是否安装
		if (!checkCaObj()) {
			return false;
		}

		/* 初始化KEY */
		var tmpobj = document.getElementById("SafeEngineCtl");
		
		tmpobj.SEH_InitialSession(0xa, "com1", password, 0, 0xa, "com1", "");
		if (tmpobj.ErrorCode != 0) {
			var errCode = tmpobj.ErrorCode;
			var msg = "（错误代码:" + errCode + "）";
			if (errCode == -2113667017 || errCode == -2113667069) {
				msg = "证书密码错误！";
			}
			alert("验证失败！" + msg);
			//                alert("SEH_InitialSession Error:" + SafeEngineCtl.ErrorCode);
			tmpobj.SEH_ClearSession();
			$("#btnSub").disabled = false;
			return false;
		}
<%--/* 获取客户端KEY中证书 */--%>
	var strCert = tmpobj.SEH_GetSelfCertificate(0xa, "com1", "");
		if (tmpobj.ErrorCode != 0) {
			alert("SEH_GetSelfCertificate error:" + tmpobj.ErrorCode);
			tmpobj.SEH_ClearSession();
			$("#btnSub").disabled = false;
			return false;
		}

		/* 配置函数（0为不验证黑名单，建议选择“0”）*/
		var i = tmpobj.SEH_SetConfiguration(0);
		if (tmpobj.ErrorCode != 0) {
			alert("SEH_SetConfiguration Error:" + tmpobj.ErrorCode);
			tmpobj.SEH_ClearSession();
			$("#btnSub").disabled = false;
			return false;
		}
			
		/* 签名随机数 */
		var strSigned = tmpobj.SEH_SignData("${UUID}", 3);
		/*本Demo中随机数“abcd1234”固定写死，没有用函数生成*/
		if (tmpobj.ErrorCode != 0) {
			alert("SEH_SignData Error. Return:" + tmpobj.ErrorCode);
			tmpobj.SEH_ClearSession();
			$("#btnSub").disabled = false;
			return false;
		}

		/* 释放 */
		tmpobj.SEH_ClearSession();
		$("#cCert").val(strCert);
		$("#cSign").val(strSigned);

		return true;
	}
	function checkCaObj() {
		var rtnVal = false;
		var tmpobj = document.getElementById("SafeEngineCtl");
		if (!tmpobj || typeof (tmpobj.SEH_InitialSession) == 'unknow'
				|| typeof (tmpobj.SEH_InitialSession) == 'undefined') {
			alert('数字证书驱动未装或者驱动程序未注册，请点击按钮边上"数字证书管理器及控件下载"下载驱动程序并安装！');
		} else {
			rtnVal = true;
		}
		return rtnVal;
	}

	$(document).ready(function() {
		var login_body = document.getElementsByTagName("body");
		login_body[0].className = "bg1";
		login_body[0].style.width = $(window).width() + "px";
		login_body[0].style.height = $(window).height() + "px";
		$("#login_div").height(($(window).height()*0.90) + "px");
		login_body[0].style.backgroundSize = $(window).width() + "px" + " " + $(window).height() + "px";
		$("#login_form").height($("#login_form").width()*398/861);
		$(window).resize(function() {
			login_body[0].style.width = $(window).width() + "px";
			login_body[0].style.height = $(window).height() + "px";
			$("#login_div").height(($(window).height()*0.90) + "px");
			login_body[0].style.backgroundSize = $(window).width() + "px" + " " + $(window).height() + "px";
			$("#login_form").height($("#login_form").width()*398/861);
		});

		/* login_body[0].innerHTML = $("#login_div").html(); */
	});
</script>

<portlet:resourceURL var="loginUrl" id="certificate-login" />
<script type="text/javascript">
	function loginToBSDT(){
		if (checkForm()) {
			$.ajax({
				type:"GET",
				url:"<%=loginUrl%>",
				data : {
					'<portlet:namespace/>cCert' : $('#cCert').val(),
					'<portlet:namespace/>cSign' : $('#cSign').val(),
					'<portlet:namespace/>prikeypwd' : $('#_58_password').val(),
					'<portlet:namespace/>content' : $('#<portlet:namespace/>content').val()
				},
				error : function(err) {
					alert("登录失败，请联系系统管理员!");
				},
				success : function(data) {
					var strJson = eval("(" + data + ")");
					$("#_58_login").val(strJson.screenName);
					$("#_58_fm").submit();
				}
			});
		}
	}
</script>
