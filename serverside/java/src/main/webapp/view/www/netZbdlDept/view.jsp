<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label">购买标书单位：</td>
            <td class="form_content">&nbsp;
                ${bean.signUnit}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">联系人：</td>
            <td class="form_content">&nbsp;
                ${bean.linkPerson}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">联系电话：</td>
            <td class="form_content">&nbsp;
                ${bean.linkTel}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">购买标书时间：</td>
            <td class="form_content">&nbsp;
                <fmt:formatDate value="${bean.signDate}" pattern="yyyy-MM-dd HH:mm:ss"/>

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