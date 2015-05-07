<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="tr_light" align="center"><b>在 线 用 户 列 表</b></div>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_header">
            <td class="form_border" width="4%">序号</td>
            <td class="form_border" width="16%" align="center">登录名</td>
            <td class="form_border" width="16%">姓名</td>
            <td class="form_border" width="16%">用户IP</td>
            <td class="form_border" width="16%">所属单位</td>
            <td class="form_border" width="16%">登录时间</td>
            <td class="form_border" width="16%">在线时间</td>
        </tr>
        <c:forEach items="${onlineUsers}" var="onlineUser" varStatus="status">
            <tr class="<c:choose><c:when test="${status.index % 2==0}">tr_light</c:when><c:otherwise>tr_dark</c:otherwise></c:choose>">
                <td class="form_border">&nbsp;${status.index+1}</td>
                <td class="form_border">&nbsp;${onlineUser.userName}</td>
                <td class="form_border">&nbsp;${onlineUser.realName}</td>
                <td class="form_border">&nbsp;${onlineUser.ipAddress}</td>
                <td class="form_border">&nbsp;${onlineUser.dept}</td>
                <td class="form_border">
                    <fmt:formatDate value="${onlineUser.loginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
                <td class="form_border">&nbsp;${onlineUser.onlineTimeMinute}分钟</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4" class="form_border"></td>
        </tr>
    </table>
</div>