<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<script type="text/javascript">
    function LoadPage(url) {
        window.location = url;
    }
</script>

<c:if test="${empty bizHtml==false}">
    <div align="center" style="height:35px;margin-top:5px">
        <input name="button_sub1" type="button" class="button_cancel" value="关 闭" onclick="window.close();">
    </div>
    <div align="center">${bizHtml}</div>
    <p></p>
</c:if>
<c:if test="${empty bizHtml && empty url==false}">
    <body onload="LoadPage('${url}');">
    </body>
</c:if>