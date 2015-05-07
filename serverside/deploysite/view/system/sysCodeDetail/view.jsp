<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label">编码：</td>
            <td class="form_content">
                ${bean.code}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">名称：</td>
            <td class="form_content">
                ${bean.name}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">是否系统定义：</td>
            <td class="form_content">
                <c:choose><c:when test="${bean.isReserved}">是</c:when><c:otherwise>否</c:otherwise></c:choose>

                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">特殊标记：</td>
            <td class="form_content">
                ${bean.tag}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">是否有效：</td>
            <td class="form_content">
                <c:choose><c:when test="${bean.isValid}">是</c:when><c:otherwise>否</c:otherwise></c:choose>

                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">备注：</td>
            <td class="form_content">
                <sys:toHtml>${bean.description}</sys:toHtml>
                &nbsp;
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