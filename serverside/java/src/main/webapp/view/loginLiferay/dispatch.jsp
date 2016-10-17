<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>系统登录</title>
    <%@include file="/common/header.jsp" %>
    <script type="text/javascript">
        $(function () {
            document.loginForm1.submit();
        });
    </script>
    <link type="text/css" rel="stylesheet" href="${themePath}/login.css" media="screen"/>
</head>

<body style="width: 100%;text-align: center">
<form id="loginForm1" name="loginForm1" action="${ctx}/j_spring_security_check" method="post">
    <input type="hidden" name="j_username" id="j_username" value="${j_username}">
    <input type="hidden" name="j_password" id="j_password" value="${j_password}">
    <input type="hidden" name="j_validation_code" id="j_validation_code" value="${j_validation_code}">
</form>
</body>
</html>