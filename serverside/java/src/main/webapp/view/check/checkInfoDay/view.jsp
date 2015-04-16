<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>

<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label">姓名：</td>
            <td class="form_content">
                &nbsp;${bean.manager.name}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">未考勤理由：</td>
            <td class="form_content">
                <div style="width:95%;word-break:break-all">&nbsp;<sys:toHtml>${bean.checkReason}</sys:toHtml></div>
            </td>
        </tr>
        <tr class="tr_button">
            <td class="form_border" colspan="2">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>
