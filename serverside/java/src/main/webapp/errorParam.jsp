<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<html>
<head>
    <title>系统提示</title>
</head>

<body>
<div style="margin-top:5%">
    <table width="450" height="250" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td>
                <table width="476" height="250" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                        <td colspan="2" height="40"></td>
                    </tr>
                    <tr>
                        <td width="120">&nbsp;</td>
                        <td height="130" style="word-break:break-all" class="msg_hints">
                            操作失败，输入内容中包含有非法字符或参数！<br>
                            <%=session.getAttribute("sqlInjectError")%>
                            <!--<a href="javascript:void(0)" onclick="history.back()" target="_self">[返回]</a>-->
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" height="50"></td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</div>
</body>
</html>