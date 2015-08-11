<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        doSumData();
    });
    function doSumData() {
        var year = $("#year").val();
        var month = $("#month").val();
        var prjInfoIds = $("#prjInfoIds").val();
        loadAjaxData("sumData", "${ctx}/dataStageReportSum/sumData.do?year=" + year + "&month=" + month + "&prjInfoIds=" + prjInfoIds);
    }
</script>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr>
            <td style="height: 100px;text-align: center;">
                选择汇总年月：
                <select name="year" id="year" class="form_select_long" style="width: 70px;">
                    ${yearSelectOptions}
                </select>&nbsp;年&nbsp;
                <select name="month" id="month" class="form_select_long" style="width: 50px;">
                    ${monthSelectOptions}
                </select>&nbsp;月&nbsp;&nbsp;
                选择需要汇总的项目：
                <select id="prjInfoNames" name="prjInfoNames" size="3" class="form_multi_select"></select>
                <input type="hidden" name="prjInfoIds" id="prjInfoIds" value="">
                <input type="button" value=" " class="button_select_add"
                       onClick="multiSelectUnitPrjs('prjInfoNames','prjInfoIds','');"/>
                <input type="button" value=" " class="button_select_remove"
                       onClick="removeMultiSelectOpt('prjInfoNames','prjInfoIds','');"/>&nbsp;&nbsp;
                <input type="button" value="汇总" class="button_all" onclick="doSumData()">
            </td>
        </tr>
        <tr align="center">
            <td align="center">
                <div id="sumData"></div>
            </td>
        </tr>
        <tr class="tr_button">
            <td>&nbsp;</td>
        </tr>
    </table>
</div>
