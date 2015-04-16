<%--@elvariable id="siteName" type="java"--%>
<%--@elvariable id="attach" type="java.util.List"--%>
<%--@elvariable id="attachs" type="java.lang.StackTraceElement"--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<link href="${ctx}/view/www/images/style.css" rel="stylesheet" type="text/css"/>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<head>
    <title>${siteName}</title>
</head>
<body>
<%@ include file="top.jsp" %>
<div class="ContentHome">
    <div class="fous">
        <div class="one">
            <div class="left"></div>
        </div>
        <div class="two">
            <table align="center">
                <tr>
                    <td style="width:100%; height:100px;font-size:20px">${bean.title}</td>
                </tr>
            </table>
            <hr>
        </div>
        <div style="height:825px;word-break:break-all;font-size:17px;width:100%; text-align:center;overflow-x:hidden; overflow-y:auto;">
            <c:forEach items="${attach}" var="img">
                <div>
                    <img id="${img.id}" src="${ctx}/displayPhoto.do?id=${img.id}"
                         alt="${img.fileName}" style="padding-top:15px;width:400px;height:350px;"/>
                </div>
            </c:forEach>
        </div>
    </div>
    <%@include file="right.jsp" %>
</body>
<%@include file="bottom.jsp" %>
</html>

