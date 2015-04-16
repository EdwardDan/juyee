<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function addStopOrder(formCode, formName) {
        var checkedValue = gridCheckRadio();
        if (checkedValue != null) {
            var rowData = jQuery("#listGrid").jqGrid('getRowData', checkedValue);
            var rowDataCell = rowData["status"];
            if ("${STATUS_SUBMIT}" == rowDataCell || "${STATUS_SUBMIT_NAME}" == rowDataCell) {
                if (checkedValue != null) {
                    var link = "${ctx}/jdStopOrder/add.do?formCode=" + formCode + "&jdTypeCode=${jdTypeCode}&recordId=" + checkedValue+"&jdAttributeCode=${jdAttributeCode}";
                    parent.openWindow(formName, link, true, 900, 500);
                }
            } else {
                showInfoMsg("只有已提交的记录才能创建指令单!");
            }
        }
    }
</script>
<input type="button" value="创建整改指令单" class="button_add_long" onclick="addStopOrder('${TYPE_REFORM}',this.value)">
<input type="button" value="创建暂缓施工指令单" class="button_add_long" onclick="addStopOrder('${TYPE_SUSPEND}',this.value)">
<input type="button" value="创建停工指令单" class="button_add_long" onclick="addStopOrder('${TYPE_STOP}',this.value)">