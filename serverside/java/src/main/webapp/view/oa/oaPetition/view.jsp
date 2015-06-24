<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<style type="text/css">
    .td_area {
        word-break: break-all;
        word-wrap: break-word;
    }
</style>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label_right" style="width:15%;" nowrap>受理编号：</td>
            <td class="form_content" style="width:35%;">${bean.code}
            </td>
            <td class="form_label_right" style="width:15%;" nowrap>受理状态：</td>
            <td class="form_content" style="width:25%;">${bean.status.name}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">信访来源：</td>
            <td class="form_content">${bean.source.name}
            </td>
            <td class="form_label_right">信访种类：</td>
            <td class="form_content">${bean.type.name}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">信访人：</td>
            <td class="form_content">${bean.person}
            </td>
            <td class="form_label_right">联系电话：</td>
            <td class="form_content">${bean.tel}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">收信日期：</td>
            <td class="form_content">${bean.receiveDate}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">联系地址：</td>
            <td class="form_content" colspan="3">${bean.address}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">经办人：</td>
            <td class="form_content">${bean.jbrName}
            </td>
            <td class="form_label_right">结案日期：</td>
            <td class="form_content">${bean.endDate}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">信访事由：</td>
            <td class="form_content td_area" colspan="3">
                <div style="width:90%"><sys:toHtml>${bean.content}</sys:toHtml></div>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right td_area">处理结果：</td>
            <td class="form_content" colspan="3">
                <div style="width:90%"><sys:toHtml>${bean.dealResult}</sys:toHtml></div>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right td_area">备注：</td>
            <td class="form_content" colspan="3">
                <div style="width:90%"><sys:toHtml>${bean.description}</sys:toHtml></div>
            </td>
        </tr>
        <tr>
            <td class="form_label_right">附件：</td>
            <td class="form_content">${downloadButtonDocument}</td>
        </tr>
        <tr class="tr_button">
            <td class="form_content" style="text-align: center;" colspan="4">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>