<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>查看信息</title>
    <link href="${ctx}/view/www/images/style.css" rel="stylesheet" type="text/css"/>
    <script src="${ctx}/js/document.js"></script>
</head>
<body>
<div>
    <div style="width:100%;overflow: scroll;" class="info_text">${bean.content}</div>
    <c:if test="${not empty document}"><br/>&nbsp;&nbsp;&nbsp;&nbsp;附件:<br/>${document}</c:if>
</div>
<div class="clr"></div>
<div style="height: 50px;"></div>
</body>
</html>



