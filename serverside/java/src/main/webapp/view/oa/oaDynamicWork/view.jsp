<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label_right" width="15%">内容：</td>
            <td class="form_content">&nbsp;
                <sys:toHtml> ${bean.content}</sys:toHtml>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">提交部门：</td>
            <td class="form_content">&nbsp;
                ${bean.reportDept}
            </td>
        </tr>

        <tr class="tr_light">
            <td class="form_label_right">提交时间：</td>
            <td class="form_content">&nbsp;
                <fmt:formatDate value="${bean.updateTime}" pattern="yyyy-MM-dd HH:mm"/>
            </td>
        </tr>
        <%--<tr class="tr_light">--%>
        <%--<td class="form_label_right">是否有效：</td>--%>
        <%--<td class="form_content">&nbsp;--%>
        <%--<c:choose><c:when test="${bean.isValid}">是</c:when><c:otherwise>否</c:otherwise></c:choose>--%>
        <%--</td>--%>
        <%--</tr>--%>
        <tr class="tr_button">
            <td class="form_label_right"></td>
            <td class="form_content">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>