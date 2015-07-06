<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function reBackData(obj, bidId, stepId, stageId) {
        parent.flag = true;
        if (${result.code==result1}) {
            $("#dealDate_" + bidId + "_" + stepId + "_" + stageId).val($("#planDate").val());
        } else if (${result.code==result4}) {
            $("#dealDate_" + bidId + "_" + stepId + "_" + stageId).val($("#question").val());
            document.getElementById("dealDate_" + bidId + "_" + stepId + "_" + stageId).title = document.getElementById("question").value;
        }
    }
</script>
<fieldset class="form_fieldset">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <c:if test="${result.code==result1}">
            <tr class="tr_dark">
                <td class="form_content">请选择计划完成日期：</td>
            </tr>
            <br>
            <tr class="tr_dark">
                <td class="form_content">
                    计划日期：
                    <input type="text" class="input_date" name="planDate" id="planDate" value="${currentDate}"
                           readonly="true">
                    <input type="button" class="button_calendar" value="" onClick="calendar('planDate','')">
                </td>
            </tr>
        </c:if>
        <c:if test="${result.code==result4}">
            <tr class="tr_dark">
                <td class="form_content">请填写办理受阻问题：</td>
            </tr>
            <tr class="tr_dark">
                <td style="text-align: center;">
                    <textarea class="input_textarea" name="question" id="question">${dealDate}</textarea>
                </td>
            </tr>
        </c:if>
        <tr class="tr_dark">
            <td style="text-align: center;">
                <input type="button" value="确定" class="button_confirm"
                       onclick="reBackData(this,'${bidId}','${stepId}','${stageId}');closeWindow();">&nbsp;
                <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</fieldset>
<div class="div_space"></div>