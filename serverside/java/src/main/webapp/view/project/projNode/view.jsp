<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label_right" width="20%">编码：</td>
            <td class="form_content" width="30%">
                ${bean.code}
            </td>
            <td class="form_label_right" width="15%">名称：</td>
            <td class="form_content" width="35%">
                ${bean.name}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">是否有效：</td>
            <td class="form_content" colspan="3">
                <c:choose><c:when test="${bean.isValid}">是</c:when><c:otherwise>否</c:otherwise></c:choose>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">备注：</td>
            <td class="form_content" colspan="3">
                <sys:toHtml> ${bean.description}</sys:toHtml>
            </td>
        </tr>
        <tr class="tr_button">
            <td align="center" colspan="4">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>