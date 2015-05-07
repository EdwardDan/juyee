<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <%@include file="/common/header.jsp" %>

</head>

<body>
<table border="0" align="center" cellpadding="1" cellspacing="1" width="100%"  class="form_table">
    <tr class="tr_header" style="height: 20px">
        <td width="10%">序号</td>
        <td width="10%">版本号</td>
        <td width="20%">名称</td>
        <td width="10%">实例数</td>
        <td width="25%">创建时间</td>
        <td width="25%">修改时间</td>
    </tr>
    <c:forEach var="bean" items="${definitions}"
               varStatus="status">
    <c:choose>
    <c:when test="${status.count%2==0}">
    <tr class="tr_light" align="center" height="20" style="margin-top: 0px">
        </c:when>
        <c:otherwise>
    <tr class="tr_dark" align="center" height="20">
        </c:otherwise>
        </c:choose>
        <td>${status.count}&nbsp;</td>
        <td>${bean.version}&nbsp;</td>
        <td>${bean.name}&nbsp;</td>
        <td>${fn:length(bean['bpmProcessInstances'])}&nbsp;</td>
        <td><fmt:formatDate
                value="${bean.createTime}"
                pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;</td>
        <td><fmt:formatDate
                value="${bean.updateTime}"
                pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;</td>
    </tr>
    </c:forEach>
</table>

</body>
</html>