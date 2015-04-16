<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label">报建编号：</td>
            <td class="form_content">&nbsp;
                ${bean.id.bjbh}
            </td>
        </tr>

        <tr class="tr_light">
            <td class="form_label">项目名称：</td>
            <td class="form_content">&nbsp;
                ${bean.proName}
            </td>
        </tr>

        <tr class="tr_light">
            <td class="form_label">施工单位：</td>
            <td class="form_content">&nbsp;
                ${bean.sgZbUnit}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">签证日期：</td>
            <td class="form_content">&nbsp;
                <fmt:formatDate value="${bean.issueDatetime}" pattern="yyyy-MM-dd"/>

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