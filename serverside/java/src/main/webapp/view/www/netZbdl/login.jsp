<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>网上办事平台</title>
    <%@include file="/common/header.jsp" %>
    <script type="text/javascript">
        //登录页居中
        function adjustDivPostionCenter2(divName) {
            var postop = ($(document).height() - $("#" + divName).height()) / 2;
            var posleft = ($(window).width() - $("#" + divName).width()) / 2;
            var loginTop = 12;
            if (postop < loginTop) postop = loginTop;
            $("#" + divName).css({"left": posleft + "px", "top": postop + "px"});
            $("#" + divName).show();
        }
        $(function () {
            adjustDivPostionCenter2("loginDiv");

            var errMsg = "${errMsg}";
            if (errMsg != "") {
                showErrorMsg(errMsg);
            }
        });

        $(window).resize(function () {
            adjustDivPostionCenter2("loginDiv");
        });

        function submitForm(form) {
        <c:if test="${certSwitch==false}">
            var userName = document.getElementById("userName").value;
            if (userName == null || userName == "") {
                alert("请输入用户名！");
                document.getElementById("userName").focus();
                return false;
            }
        </c:if>
            var password = document.getElementById("prikeypwd").value;
            if (password == null || password == "") {
                alert("请输入密码！");
                document.getElementById("prikeypwd").focus();
                return false;
            }
        <c:if test="${certSwitch==true}">
            document.getElementById("btnSub").disabled = true;

            // 判断数字证书插件是否安装
            if (!checkCaObj()) return false;

            /* 初始化KEY */
            SafeEngineCtl.SEH_InitialSession(0xa, "com1", password, 0, 0xa, "com1", "");
            if (SafeEngineCtl.ErrorCode != 0) {
                var errCode = SafeEngineCtl.ErrorCode;
                var msg = "（错误代码:" + errCode + "）";
                if(errCode == -2113667017 || errCode == -2113667069){
                    msg = "证书密码错误！";
                }
                alert("验证失败！" + msg);
//                alert("SEH_InitialSession Error:" + SafeEngineCtl.ErrorCode);
                SafeEngineCtl.SEH_ClearSession();
                document.getElementById("btnSub").disabled = false;
                return false;
            }

        <%--/* 获取客户端KEY中证书 */--%>
            var strCert = SafeEngineCtl.SEH_GetSelfCertificate(0xa, "com1", "");
            if (SafeEngineCtl.ErrorCode != 0) {
                alert("SEH_GetSelfCertificate error:" + SafeEngineCtl.ErrorCode);
                SafeEngineCtl.SEH_ClearSession();
                document.getElementById("btnSub").disabled = false;
                return false;
            }

            /* 配置函数（0为不验证黑名单，建议选择“0”）*/
            var i = SafeEngineCtl.SEH_SetConfiguration(0);
            if (SafeEngineCtl.ErrorCode != 0) {
                alert("SEH_SetConfiguration Error:" + SafeEngineCtl.ErrorCode);
                SafeEngineCtl.SEH_ClearSession();
                document.getElementById("btnSub").disabled = false;
                return false;
            }


            /* 签名随机数 */
            var strSigned = SafeEngineCtl.SEH_SignData("${UUID}", 3);
            /*本Demo中随机数“abcd1234”固定写死，没有用函数生成*/
            if (SafeEngineCtl.ErrorCode != 0) {
                alert("SEH_SignData Error. Return:" + SafeEngineCtl.ErrorCode);
                SafeEngineCtl.SEH_ClearSession();
                document.getElementById("btnSub").disabled = false;
                return false;
            }

            /* 释放 */
            SafeEngineCtl.SEH_ClearSession();

            document.loginForm.cCert.value = strCert;
            document.loginForm.cSign.value = strSigned;

        </c:if>

            return true;
        }
        function checkCaObj() {
            var rtnVal = false;
            var tmpobj = document.getElementById("SafeEngineCtl");

            if (!tmpobj || typeof (tmpobj.SEH_InitialSession) == 'unknow' || typeof (tmpobj.SEH_InitialSession) == 'undefined') {
                alert('数字证书驱动未装或者驱动程序未注册，请点击按钮边上"数字证书管理器及控件下载"下载驱动程序并安装！');
            }
            else {
                rtnVal = true;
            }
            return rtnVal;
        }
    </script>
    <link type="text/css" rel="stylesheet" href="${ctx}/skin/default/login2.css" media="screen"/>
</head>

<body style="width: 98%;text-align: center;background-color: #CBE7F3">
<form id="loginForm" name="loginForm" action="${ctx}/netZbdl/checkLogin.do" method="post"
      onsubmit="return submitForm(this)">
    <input type="hidden" name="cCert" value="">
    <input type="hidden" name="cSign" value="">
    <input type="hidden" name="content" value="${UUID}">

    <div id="loginDiv" class="loginDiv_net" style="width:1000px;height:700px;">
        <div style="width:300px; height:200px;float:left;margin-left:250px;margin-top:310px;">
            <table width="300" cellpadding="0" cellspacing="0" border="0">
                <c:if test="${certSwitch==false}">
                    <tr>
                        <td height="40" align="left" style="color: white;font-weight: bold;">
                            用户名：<br><input type="text" name="userName" id="userName" class="login_input"
                                                                 maxlength="20" value=""/>
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <td height="40" align="left" style="color: white;font-weight: bold;">
                        密&nbsp;&nbsp;码：<br><input type="password" name="prikeypwd" id="prikeypwd" class="login_input"
                                                                        maxlength="10" value=""/>
                    </td>
                </tr>
                <tr><td height="30">&nbsp;</td></tr>
                <tr>
                    <td height="40" align="left">
                        <input type="submit" id="btnSub" name="btnSub" class="login_ok" value=" ">&nbsp;
                        <input type="reset" id="btnReset" name="btnReset" class="login_cancel" value=" ">
                    </td>
                </tr>
                <tr><td height="15">&nbsp;</td></tr>
                <tr>
                    <td height="30" align="left">
                        请先插入数字证书后再输入密码<br>
                    <a href="${ctx}/tools/CertHelpSetup.rar" target="_blank"><font color="blue">【数字证书管理器及控件下载】</font></a>
                    </td>
                </tr>
            </table>
        </div>
        <div style="width: 400px;height: 40px;text-align: left;margin-left: 250px;float: left;">
            数字证书使用注意事项：<a href="${ctx}/tools/数字证书用户操作说明.doc" target="_blank"><font color="blue">【帮助文档下载】</font></a><br>
            1、请使用IE浏览器（32位），其他浏览器不支持；<br>
            2、首次使用必须安装证书驱动；<br>
            3、首次使用IE浏览器会弹出控件提示栏，请选择“运行加载项”。<br>
        </div>
    </div>

</form>
<c:if test="${certSwitch==true}">
    <div style="display: none">
        <OBJECT ID="SafeEngineCtl" CLASSID="CLSID:B48B9648-E9F0-48A3-90A5-8C588CE0898F" width="300" height="50"
                border=0></OBJECT>
    </div>
</c:if>
</body>
</html>