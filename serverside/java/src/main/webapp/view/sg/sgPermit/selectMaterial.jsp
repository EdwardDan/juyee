<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function reBackData() {
        var options = $("#selectVal option:selected");  //获取选中的项
        var val = options.val();
        $(document.getElementById("tab1").contentWindow.document).find("#backNum").val(val);
        if ($(document.getElementById("tab1").contentWindow.document).find("#backNum").val()) {
            document.getElementById("tab1").contentWindow.savaAudit("审批退回");
        }
    }
</script>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label_right" nowrap>请选择：</td>
            <td class="form_content">
                <select name="selectVal" id="selectVal" class="form_select" style="width: 240px;">
                    ${options}
                </select>
            </td>
        </tr>
        <tr class="tr_button">
            <td style="text-align: center;" colspan="2">
                <input type="button" value="确定" class="button_confirm"
                       onclick="closeWindow();reBackData();">&nbsp;
                <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>
