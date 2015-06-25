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
                <input type="text" name="name" class="input_text" style="width:98%" value="${bean.name}"
                       title="${bean.name}" readonly>
            </td>
            <td>
                <input type="text" name="model" class="input_text" style="width: 95%" value="${bean.model}"
                       title="${bean.model}" readonly>
            </td>

            <td>
                <input type="text" name="unit" class="input_text" style="width: 95%" value="${bean.unit}"
                       title="${bean.unit}" readonly>
            </td>
            <td>
                <input type="text" name="price" class="input_text" style="width: 95%" value="${bean.price}"
                       title="${bean.price}" readonly>
            </td>
            <td>
                <input type="text" name="amount" class="input_text" style="width: 95%" value="${bean.amount}"
                       title="${bean.amount}" readonly>
            </td>
        </tr>
    </table>
    <div style="text-align: center;position: absolute;top: 65px;width: 100%;" class="tr_button" >
        <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
    </div>
</div>
