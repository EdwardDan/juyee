<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label">探头序号：</td>
            <td class="form_content">&nbsp;
                ${bean.orderNo}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">探头名称：</td>
            <td class="form_content">&nbsp;
                ${bean.name}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">探头类型：</td>
            <td class="form_content">&nbsp;
                ${bean.cameraType.name}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">备注：</td>
            <td class="form_content">&nbsp;
                ${bean.description}
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