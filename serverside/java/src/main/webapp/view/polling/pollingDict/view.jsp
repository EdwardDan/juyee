<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label">名称：</td>
            <td class="form_content">
                ${bean.name}
                &nbsp;
            </td>
        </tr>
        <c:if test="${level!=1&&level!=2}">
        <tr class="tr_light">
            <td class="form_label">法规依据：</td>
            <td class="form_content">
                <sys:toHtml>${bean.refRule}</sys:toHtml>
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">整改情形：</td>
            <td class="form_content">
                ${bean.reformType.name}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">立案情形：</td>
            <td class="form_content">
                ${bean.registerType.name}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">安全隐患：</td>
            <td class="form_content">
                ${bean.safeType.name}
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
        </c:if>
        <tr class="tr_dark">
            <td class="form_label">排序号：</td>
            <td class="form_content">
                ${bean.orderNo}
                &nbsp;
            </td>
        </tr>
        <c:if test="${level!=1&&level!=2}">
        <tr class="tr_light">
            <td class="form_label">备注：</td>
            <td class="form_content">
                <sys:toHtml>${bean.description}</sys:toHtml>
                &nbsp;
            </td>
        </tr>
        </c:if>
        <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>