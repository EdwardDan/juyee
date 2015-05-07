<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>MIS系统</title>

</head>

<body scroll=no>
<table border="0" align="center" cellpadding="0" cellspacing="0" class="table_frame" height="100%" width="100%">
    <tr>
        <td class="top_left" nowrap></td>
        <td class="top_bg">
            <%--<img src="${themePath}/icons/help.png" align="absmiddle">--%>
            <!-- title begin -->
            查看（${column}）
            <!-- title begin -->
        </td>
        <td class="top_right" nowrap></td>
    </tr>
    <tr>
        <td colspan="3">
            <table border="0" align="center" cellpadding="0" cellspacing="0" width="100%">
                <tr>
                    <td class="middle_left" nowrap></td>
                    <td valign="top">
                        <!-- main content begin -->
                        <textarea rows="32" cols="100" style="width:100%;">${templateCode}</textarea>
                        <!-- main content end -->
                    </td>
                    <td class="middle_right" nowrap></td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td class="bottom_left"></td>
        <td class="bottom_bg"></td>
        <td class="bottom_right"></td>
    </tr>
</table>
</body>
</html>