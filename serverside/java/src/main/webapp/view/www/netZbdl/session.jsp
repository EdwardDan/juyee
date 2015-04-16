<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>系统提示</title>
<style type="text/css">
    body {
        font-size: 12px;
    }
</style>
</head>

<body>
当前Session已失效，请重新登录! <a href='<%=request.getContextPath()%>/netProject/login.do' target='_parent'>返回登录页</a>
</body>
</html>