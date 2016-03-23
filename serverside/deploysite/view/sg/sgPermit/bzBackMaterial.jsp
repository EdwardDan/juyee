<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
  function bzBackData() {
    var val = $("#backMaterial").val();
    $(document.getElementById("tab1").contentWindow.document).find("#bzBackMaterial").val(val);
    if ($(document.getElementById("tab1").contentWindow.document).find("#bzBackMaterial").val()) {
      document.getElementById("tab1").contentWindow.savaAudit("审批退回");
    }
  }
</script>
<div class="form_div">
  <table cellpadding="0" cellspacing="0" class="form_table">
    <tr class="tr_dark">
      <td class="form_label_right">补正材料：</td>
      <td class="form_content">
        <textarea class="input_textarea" style="width: 96%;" name="backMaterial" id="backMaterial"></textarea>
      </td>
    </tr>
    <tr class="tr_button">
      <td style="text-align: center;" colspan="2">
        <input type="button" value="确定" class="button_confirm"
               onclick="closeWindow();bzBackData();">&nbsp;
        <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
      </td>
    </tr>
  </table>
</div>
