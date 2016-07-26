<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<div class="portlet-body">
	<form action="/web/jtjs/test?p_p_id=58&amp;p_p_lifecycle=1&amp;p_p_state=normal&amp;p_p_mode=view&amp;p_p_col_id=column-1&amp;p_p_col_count=1&amp;_58_struts_action=%2Flogin%2Flogin" class="form sign-in-form " id="_58_fm" method="post" name="_58_fm" autocomplete="on">
		<fieldset class="input-container" disabled="disabled">
			<input type="hidden" id="cCert" name="cCert" value="" /> <input type="hidden" id="cSign" name="cSign" value="" /> <input type="hidden" id="<portlet:namespace/>content" name="<portlet:namespace/>content" value="${UUID}" /> <input name="_58_formDate" type="hidden" value="1469076641141" /> <input class="field" id="_58_saveLastPath" name="_58_saveLastPath" type="hidden" value="false" /> <input class="field" id="_58_redirect" name="_58_redirect" type="hidden" value="" /> <input class="field" id="_58_doActionAfterLogin" name="_58_doActionAfterLogin" type="hidden" value="false" />
			<fieldset class="fieldset ">
				<div class="">
					<div class="control-group input-text-wrapper">
						<label class="control-label" for="_58_login"> </label> <input class="field clearable" id="_58_login" name="_58_login" type="hidden" value="" />
					</div>
					<div class="control-group input-text-wrapper">
						<label class="control-label" for="_58_password"> 密码 </label> <input class="field" id="_58_password" name="_58_password" type="password" maxlength="10" value="" />
					</div>
				</div>
			</fieldset>
			<div class="button-holder ">
				<button class="btn btn-primary" type='submit' id="btnSub" name="btnSub">登录</button>
			</div>
			<div>
				<OBJECT ID="SafeEngineCtl" CLASSID="CLSID:B48B9648-E9F0-48A3-90A5-8C588CE0898F" width="300" height="50" border=0 hidden="hidden"></OBJECT>
			</div>
			<div>
				请先插入数字证书后再输入密码<br> <a href="" target="_blank"><font color="blue">【数字证书管理器及控件下载】</font></a>
			</div>
			<div>
				数字证书使用注意事项：<a href="" target="_blank"><font color="blue">【帮助文档下载】</font></a> <br /> 1、请使用IE浏览器（32位），其他浏览器不支持；<br /> 2、首次使用必须安装证书驱动；<br /> 3、首次使用IE浏览器会弹出控件提示栏，请选择“运行加载项”。<br />
			</div>
		</fieldset>
	</form>
</div>
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
		if (!tmpobj || typeof (tmpobj.SEH_InitialSession) == 'unknow' || typeof (tmpobj.SEH_InitialSession) == 'undefined') {
			alert('数字证书驱动未装或者驱动程序未注册，请点击按钮边上"数字证书管理器及控件下载"下载驱动程序并安装！');
		} else {
			rtnVal = true;
		}
		return rtnVal;
	}
</script>
<portlet:resourceURL var="loginUrl" id="login" />
<script type="text/javascript">
	Liferay.Portlet
			.onLoad({
				canEditTitle : false,
				columnPos : 0,
				isStatic : "end",
				namespacedId : "p_p_id_58_",
				portletId : "58",
				refreshURL : "\x2fc\x2fportal\x2frender_portlet\x3fp_l_id\x3d20184\x26p_p_id\x3d58\x26p_p_lifecycle\x3d0\x26p_t_lifecycle\x3d0\x26p_p_state\x3dnormal\x26p_p_mode\x3dview\x26p_p_col_id\x3dcolumn-1\x26p_p_col_pos\x3d0\x26p_p_col_count\x3d1\x26p_p_isolated\x3d1\x26currentURL\x3d\x252Fweb\x252Fguest\x252Fhome"
			});
	Liferay.Portlet
			.onLoad({
				canEditTitle : false,
				columnPos : 0,
				isStatic : "end",
				namespacedId : "p_p_id_145_",
				portletId : "145",
				refreshURL : "\x2fc\x2fportal\x2frender_portlet\x3fp_l_id\x3d20184\x26p_p_id\x3d145\x26p_p_lifecycle\x3d0\x26p_t_lifecycle\x3d0\x26p_p_state\x3dnormal\x26p_p_mode\x3dview\x26p_p_col_id\x3dnull\x26p_p_col_pos\x3dnull\x26p_p_col_count\x3dnull\x26p_p_static\x3d1\x26p_p_isolated\x3d1\x26currentURL\x3d\x252Fweb\x252Fguest\x252Fhome"
			});
	Liferay.Portlet
			.onLoad({
				canEditTitle : false,
				columnPos : 0,
				isStatic : "end",
				namespacedId : "p_p_id_47_",
				portletId : "47",
				refreshURL : "\x2fc\x2fportal\x2frender_portlet\x3fp_l_id\x3d20184\x26p_p_id\x3d47\x26p_p_lifecycle\x3d0\x26p_t_lifecycle\x3d0\x26p_p_state\x3dnormal\x26p_p_mode\x3dview\x26p_p_col_id\x3dcolumn-2\x26p_p_col_pos\x3d0\x26p_p_col_count\x3d1\x26p_p_isolated\x3d1\x26currentURL\x3d\x252Fweb\x252Fguest\x252Fhome"
			});
	AUI().use("aui-base", "event-outside", "liferay-form", "liferay-icon", "liferay-menu", "liferay-menu-toggle", "liferay-notice",
			"liferay-poller", "liferay-session", function(a) {
				(function() {
					Liferay.Form.register({
						id : "_58_fm",
						fieldRules : [ {
							body : "",
							custom : false,
							customValidatorRequired : true,
							errorMessage : "",
							fieldName : "_58_login",
						}, {
							body : "",
							custom : false,
							customValidatorRequired : true,
							errorMessage : "",
							fieldName : "_58_password",
							validatorName : "required"
						} ],
						onSubmit : function(b) {
							b.preventDefault()
						}
					});
					a.all("#_58_fm .input-container").removeAttribute("disabled")
				})();
				(function() {
					Liferay.Icon.register({
						forcePost : true,
						id : "_58_rjus_column1_0",
						useDialog : false
					})
				})();
				(function() {
					Liferay.Icon.register({
						forcePost : true,
						id : "_58_ctvk_column1_0",
						useDialog : false
					})
				})();
				(function() {
					Liferay.Icon.register({
						forcePost : true,
						id : "_58_suxb_column1_0",
						useDialog : false
					})
				})();
				(function() {
					var c = a.one(document._58_fm);
					c.on("submit", function(e) {
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
									alert("提交失败!");
								},
								success : function(data) {
									var strJson = eval("(" + data + ")");
									$("#_58_login").val(strJson.screenName);
									var f = c.one("#_58_redirect");
									if (f) {
										var d = f.val();
										f.val(d + window.location.hash)
									}
									submitForm(c)
								}
							});
						}
					});
					var b = c.one("#_58_password");
					if (b) {
						b.on("keypress", function(d) {
							Liferay.Util.showCapsLock(d, "_58_passwordCapsLockSpan")
						})
					}
				})();
				(function() {
					Liferay.Util.addInputType();
					Liferay.Portlet.ready(function(b, c) {
						Liferay.Util.addInputType(c)
					});
					if (a.UA.mobile) {
						Liferay.Util.addInputCancel()
					}
				})();
				(function() {
					new Liferay.Menu();
					var b = Liferay.Data.notices;
					for (var c = 1; c < b.length; c++) {
						new Liferay.Notice(b[c])
					}
				})();
				(function() {
					Liferay.Session = new Liferay.SessionBase({
						autoExtend : true,
						sessionLength : 30,
						redirectOnExpire : false,
						redirectUrl : "http\x3a\x2f\x2flocalhost\x3a8080\x2fweb\x2fguest",
						warningLength : 1
					})
				})();
				(function() {
					a.all("#_145_dockbarResponsiveButton .btn-navbar").each(function(c, b, f) {
						var g = c.attr("id");
						var e = c.attr("data-navid");
						var d = new Liferay.MenuToggle({
							content : "#" + e + "NavbarCollapse, #_145_dockbarResponsiveButton #" + g,
							toggleTouch : true,
							trigger : "#_145_dockbarResponsiveButton #" + g
						})
					})
				})()
			});
</script>
