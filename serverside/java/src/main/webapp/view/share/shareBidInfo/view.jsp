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
                ${bean.projectName}
            </td>
        </tr>

        <tr class="tr_light">
            <td class="form_label">承包类型：</td>
            <td class="form_content">&nbsp;
                ${bean.shouldZbType}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">承包单位：</td>
            <td class="form_content">&nbsp;
                ${bean.zbAgentUnit}

            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">中标价格（万元）：</td>
            <td class="form_content">&nbsp;
                ${fee}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">中标日期：</td>
            <td class="form_content">&nbsp;
                <fmt:formatDate value="${bean.bidDate}" pattern="yyyy-MM-dd"/>

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