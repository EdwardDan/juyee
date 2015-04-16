<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label">类型：</td>
            <td class="form_content">&nbsp;
                ${bean.type.name}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">序号：</td>
            <td class="form_content">&nbsp;
                ${bean.orderNo}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">竣工验收条件：</td>
            <td class="form_content">&nbsp;
                <sys:toHtml>${bean.condition}</sys:toHtml>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">符合形式：</td>
            <td class="form_content">&nbsp;
                ${bean.selectItems}
            </td>
        </tr>
        <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content"> &nbsp;
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>