<%@ page import="org.hibernate.util.StringHelper" %>
<%@ page import="org.springframework.security.web.authentication.AbstractProcessingFilter" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%
    String serverName = request.getServerName();
    if(!StringHelper.isEmpty(serverName)){
        if(serverName.startsWith("www.sjqjgs.com.cn")){
            response.sendRedirect("http://www.sjqjgs.com.cn/site/index.do");
            return;
        }
    }
    String remoteAddr = request.getRemoteAddr();
    System.out.println("remoteAddr = " + remoteAddr);
    String[] ips={"192.168.3.","127.0.0."};
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>上海市交通建设工程管理系统</title>
    <%@include file="/common/header.jsp" %>
    <script type="text/javascript">
        $(function() {
            adjustDivPostionCenter("loginDiv");
            <%
                if (session.getAttribute(AbstractProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY) != null) {
            %>

            var errMsg = "${SPRING_SECURITY_LAST_EXCEPTION.message}";
            var emptyErr = "${not empty param.login_error}";
            if (errMsg != "" && emptyErr == "true") {
                showErrorMsg(errMsg);
            }
            <%
                }
            %>
        });
        $(window).resize(function() {
            adjustDivPostionCenter("loginDiv");
        });

        function reloadImage() {
            document.getElementById("pic").src = "${ctx}/common/imageCode.jsp?p=" + Math.random();
        }

        function submitForm(form) {
            var loginName = document.getElementById("j_username").value;
            var password = document.getElementById("j_password").value;
            var validation_code = document.getElementById("j_validation_code").value;

            if (loginName == null || loginName == "" || loginName == "请输入用户名") {
                $.messager.alert("系统提示", "用户名必须输入！", "warning", function() {
                    document.getElementById("j_username").focus();
                });
                return false;
            }

            if (password == null || password == "" || password == "请输入登录密码") {
                $.messager.alert("系统提示", "密码必须输入！", "warning", function() {
                    document.getElementById("j_password").focus();
                });
                return false;
            }

            if (validation_code == null || validation_code == "") {
                $.messager.alert("系统提示", "验证码必须输入！", "warning", function() {
                    document.getElementById("j_validation_code").focus();
                });
                return false;
            }
            return true;
        }
    </script>
    <link type="text/css" rel="stylesheet" href="${themePath}/login.css" media="screen"/>
</head>

<body class="userlogin_body">
<c:choose>
    <c:when test="<%=remoteAddr.startsWith(ips[0])||remoteAddr.startsWith(ips[1])%>">
<form id="loginForm" name="loginForm" action="j_spring_security_check" method="post" onsubmit="return submitForm(this)">
    <div id="loginDiv" class="loginDiv" style="width:916px;height:490px;">
        <div style="width:230px; height:170px;float:right;margin-right:95px;margin-top:140px">
            <div style="height:50px"></div>
            <div style="height:45px">
                <span style="width:70px">用户名：</span>
                <input type="text" name="j_username" id="j_username" class="login_input" maxlength="20"
                       value="<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>">

            </div>
            <div style="height:45px">
                <span style="width:70px">密&nbsp;&nbsp;码：</span>
                <input type="password" name="j_password" id="j_password" class="login_input" maxlength="10">

            </div>
            <div style="height:45px">
                <span style="width:70px">验证码：</span>
                <input type="text" name="j_validation_code" id="j_validation_code" class="login_input" maxlength="4"
                       style="width:83px">
                <img id="pic" src="<c:url value="common/imageCode.jsp"/>" onclick="reloadImage();" height="20"
                     title="点击更换图片" style="vertical-align: middle;cursor:pointer">
            </div>
            <div style="height:45px">
                <span style="width:70px"><a href="${ctx}/sysRegPerson/indexInput.do?flag=fromIndex" target="_blank">用户注册</a></span>
                <input type="submit" name="btnSub" class="login_ok" value=" ">&nbsp;
                <input type="reset" name="btnReset" class="login_cancel" value=" ">
            </div>
        </div>
    </div>
</form>
    </c:when>
    <c:otherwise>
        <div style="text-align: left;">
            <h3>&nbsp;&nbsp;关于更换系统服务器的通知</h3>
            <br>

            <h3>
                &nbsp;&nbsp;本系统将于2016年9月1日——2016年9月6日进行服务器升级，各单位急需办理的施工许可业务，公路、港口、航道类请联系
                施伟13901989413，市政基础设施类请联系顾顺兴13386029910。由此带来的不便敬请谅解。
            </h3><br><br>

            <h3>&nbsp;&nbsp;上海市交通建设工程管理中心</h3><br>

            <h3>&nbsp;&nbsp;2016年8月31日</h3>
        </div>
    </c:otherwise>
</c:choose>
    </body>
</html>
