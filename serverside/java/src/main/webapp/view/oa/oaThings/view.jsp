<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div" style="position: relative;">
    <table cellpadding="0" cellspacing="0" class="form_table" >
        <tr class="tr_header">
            <td width="8%">办公用品名称</td>
            <td width="8%">型号</td>
            <td width="9%">单价</td>
            <td width="8%">单位</td>
            <td width="8%">库存</td>
        </tr>
        <tr class="tr_dark">
            <td>
                ${bean.name}
            </td>
            <td>
                ${bean.model}
            </td>

            <td>
                ${bean.price}
            </td>
            <td>
                ${bean.unit}
            </td>
            <td>
                ${bean.amount}
            </td>
        </tr>
    </table>
    <div style="text-align: center;position: absolute;top: 65px;width: 100%;" class="tr_button" >
        <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
    </div>
</div>
