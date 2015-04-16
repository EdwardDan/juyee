<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<h1>欢迎使用本系统!</h1>

<div><c:forEach items="${pics}" var="pic">
    <c:forEach items="${pic.value}" var="imagesurls">
           <c:forEach items="${imagesurls}" var="imageurl">
               ${imageurl.key}
        </c:forEach>
    </c:forEach>
</c:forEach></div>

