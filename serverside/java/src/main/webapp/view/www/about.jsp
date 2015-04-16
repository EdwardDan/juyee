<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎访问${siteName}--${typeName}</title>
    <link href="${ctx}/view/www/images/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%@ include file="top.jsp" %>
<div class="ContentHome">
    <div class="fousInfo">

        <div class="two">
            <img src="${ctx}/view/www/images/map.jpg" alt="" border="0" usemap="#Map"/>
            <map name="Map" id="Map">
                <area shape="rect" coords="594,264,751,284" href="mailto:sjqjgs@126.com" target="_blank"/>
            </map>
        </div>
    </div>

</div>
<%@include file="bottom.jsp" %>
</body>
</html>



