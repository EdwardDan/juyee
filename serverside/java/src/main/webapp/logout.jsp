<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<html>
<head>
    <title>系统提示</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="refresh" content="0;URL=<c:choose><c:when test="${fn:contains(url, 'http')}">${url}</c:when><c:otherwise>${ctx}/${url}</c:otherwise></c:choose>" />
    <style type="text/css">
        .word {
            font-size:13px;
            color:blue;
            font-weight:normal;
        }
    </style>
</head>

<body>
<br>
<table width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td align="center" valign="center" class="word">
           已退出系统，现转向首页......
        </td>
    </tr>
</table>
</body>
</html>