<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label">主题：</td>
            <td class="form_content">&nbsp;
                ${bean.title}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">提交人：</td>
            <td class="form_content">&nbsp;
                ${bean.reportPerson}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">提交部门：</td>
            <td class="form_content">&nbsp;
                ${bean.reportDept}
            </td>
        </tr>
        <%--<tr class="tr_dark">--%>
        <%--<td class="form_label">主要内容(预留)：</td>--%>
        <%--<td class="form_content">&nbsp;--%>
        <%--${bean.content}                   --%>
        <%--</td>--%>
        <%--</tr>--%>

        <tr class="tr_light">
            <td class="form_label">附件：</td>
            <td class="form_content">&nbsp;
                ${docButton}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">状态：</td>
            <td class="form_content">&nbsp;
                ${bean.statusName}
            </td>
        </tr>
        <c:if test="${bean.status==STATUS_PASS || bean.status==STATUS_BACK}">
            <tr class="tr_light">
                <td class="form_label">审核意见：</td>
                <td class="form_content">&nbsp;
                    <sys:toHtml>${bean.officeOpinion}</sys:toHtml>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">审核时间：</td>
                <td class="form_content">&nbsp;
                    <fmt:formatDate value="${bean.officeAuditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
            </tr>
        </c:if>
        <tr class="tr_button">
            <td class="form_border" colspan="4" align="center">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>

    </table>
</div>