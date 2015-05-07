<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label">编号：</td>
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
            <td class="form_label">路径：</td>
            <td class="form_content">
                ${bean.path}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">业务编码：</td>
            <td class="form_content">
                ${bean.bizCode}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">业务名称：</td>
            <td class="form_content">
                ${bean.bizName}
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