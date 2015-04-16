<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@ include file="/common/header.jsp" %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎访问${siteName}--${typeName}</title>
    <link href="${ctx}/view/www/images/style.css" rel="stylesheet" type="text/css"/>
    <script src="${ctx}/js/document.js"></script>
</head>
<body>
<%--<%@ include file="top.jsp" %>--%>
<div class="ContentHome">
    <div class="fousInfo">

        <div>
            <table align="center">
                <tr>
                    <td class="info_title">${bean.title}</td>
                </tr>
                <tr>
                    <td align="center">来源：${bean.createDeptName}&nbsp;&nbsp;发布时间：${bean.reportDate}</td>
                </tr>
            </table>
            <hr>
        </div>
        <div style=" width:100% ;min-height:600px;height:auto;">
            <div style="width:920px;padding-bottom:5px; padding-left:20px;" class="info_text">${bean.content}</div>
            <c:if test="${not empty document}"><br/>&nbsp;&nbsp;&nbsp;&nbsp;附件:<br/>${document}
               </c:if>
        </div>
        <div class="clr"></div>
    </div>
</div>
<%--<%@include file="bottom.jsp" %>--%>

</body>
</html>



