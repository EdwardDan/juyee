<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label">人员：</td>
            <td class="form_content">&nbsp;
                ${userName}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">分管部门：</td>
            <td class="form_content">
                ${fgDept}
            </td>
        </tr>
        <tr class="tr_light">
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