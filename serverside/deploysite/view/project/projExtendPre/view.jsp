<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label_right" style="width: 15%;">项目建议书：</td>
            <td class="form_content" style="width: 35%;">${bean.planXmjys.name}</td>
            <td class="form_label_right" style="width: 15%;">完成时间：</td>
            <td class="form_content" style="width: 35%;">
                <fmt:formatDate value="${bean.planXmjysTime}" pattern="yyyy-MM-dd"/>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">工可：</td>
            <td class="form_content">${bean.planGk.name}</td>
            <td class="form_label_right">完成时间：</td>
            <td class="form_content">
                <fmt:formatDate value="${bean.planGkTime}" pattern="yyyy-MM-dd"/>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">初步设计：</td>
            <td class="form_content">${bean.planCbsj.name}</td>
            <td class="form_label_right">完成时间：</td>
            <td class="form_content">
                <fmt:formatDate value="${bean.planCbsjTime}" pattern="yyyy-MM-dd"/>
            </td>
        </tr>
        <tr class="tr_button">
            <td class="form_content" colspan="4" style="text-align: center">
                <input type="button" value="取消" class="button_cancel" onclick="parent.closeWindow()">
            </td>
        </tr>
    </table>
</div>
