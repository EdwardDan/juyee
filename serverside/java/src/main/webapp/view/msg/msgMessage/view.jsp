<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label">消息内容：</td>
            <td class="form_content">&nbsp;
                ${bean.content}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">发送人：</td>
            <td class="form_content">&nbsp;
                ${bean.sender}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">内部接收人：</td>
            <td class="form_content">&nbsp;
                ${bean.innerPersonNames}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">工地接收人：</td>
            <td class="form_content">&nbsp;
                ${bean.gdPersonNames}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">手机号码：</td>
            <td class="form_content">&nbsp;
                ${bean.mobiles}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">是否发送短信：</td>
            <td class="form_content">&nbsp;
                <c:choose><c:when test="${bean.isSendSms}">是</c:when><c:otherwise>否</c:otherwise></c:choose>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">发送时间：</td>
            <td class="form_content">&nbsp;
                <fmt:formatDate value="${bean.sendTime}" pattern="yyyy-MM-dd HH:mm:ss"/>

            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">是否已发送：</td>
            <td class="form_content">&nbsp;
                <c:choose><c:when test="${bean.isSend}">是</c:when><c:otherwise>否</c:otherwise></c:choose>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">发送明细：</td>
            <td class="form_content">
                <c:forEach items="${bean.msgSendDetails}" var="item">
                    <div style="line-height: 30px">
                        ◎
                            <c:choose>
                                <c:when test="${not empty item.receiveName}">
                                    <b>${item.receiveName}</b>（手机：${item.receiveMobile}）&nbsp;&nbsp;
                                    <c:choose><c:when test="${not empty item.readTime}"><font color="red">读取时间：${item.readTime}</font></c:when><c:otherwise><font color="red">未读</font></c:otherwise></c:choose>
                                </c:when>
                                <c:otherwise>
                                    ${item.receiveMobile}
                                </c:otherwise>
                            </c:choose>
                    </div>
                </c:forEach>
            </td>
        </tr>
        <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>