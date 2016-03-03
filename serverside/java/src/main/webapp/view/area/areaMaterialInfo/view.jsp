<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label">材料类型：</td>
            <td class="form_content">
                <c:if test="${bean.type == 'apply'}">申请材料</c:if>
                <c:if test="${bean.type == 'submit'}">提交材料</c:if>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">序号：</td>
            <td class="form_content">${bean.no}</td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">材料名称：</td>
            <td class="form_content">
                <sys:toHtml>${bean.materialName}</sys:toHtml>
            </td>
        </tr>
        <c:if test="${bean.type == 'apply'}">
            <tr class="tr_light" id="tr_num">
                <td class="form_label">应交份数：</td>
                <td class="form_content">${bean.yjNum}</td>
            </tr>
        </c:if>
        <c:if test="${bean.type == 'submit'}">
            <tr class="tr_light" id="tr1">
                <td class="form_label">审核要求：</td>
                <td class="form_content">
                    <sys:toHtml>${bean.auditReq}</sys:toHtml>
                </td>
            </tr>
            <tr class="tr_dark" id="tr2">
                <td class="form_label">绿色审核要求：</td>
                <td class="form_content">
                    <sys:toHtml>${bean.auditReqGreen}</sys:toHtml>
                </td>
            </tr>
        </c:if>
        <tr class="tr_button">
            <td class="form_content" colspan="2" style="text-align: center;">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>
