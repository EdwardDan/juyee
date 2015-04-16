<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function selectFunction() {
        if ($("#causex").val() == "其它原因") {
            $("#otherReasons").show();
        } else {
            $("#otherReasons").hide();
        }
    }

    function saveReason() {
        var jdTaskCode ='${jdTaskCode}';
        parent.loadProjectData(jdTaskCode,$("#causex").val(), $("#selectCauseOtherx").val());
        closeWindow();
    }
    $(selectFunction());
</script>
<style>
    .tr_darks{
        line-height:10px;
        background-color: #ecf1f7;

    }
</style>
<table cellpadding="0" cellspacing="0" class="form_table">
    <tr class="tr_darks">
        <td align="left">&nbsp;</td>
    </tr>
    <tr class="tr_dark">
        <td align="left" style="padding-left: 30px">
            <sys:code code="${PLAN_DETAIL_SELECT_CAUSE}" isSaveName="true" name="causex" type="select" defaultName=""
                      sysCodeDetailId="" disabled="" id="causex"
                      isAlowedNull="false"
                      onChange="selectFunction()"/>
        </td>
    </tr>
    <tr class="tr_darks">
        <td align="left">&nbsp;</td>
    </tr>
    <tr class="tr_light" id="otherReasons">
        <td align="left" style="padding-left: 30px">
            <textarea name="selectCauseOtherx" class="input_textarea"  style="width:200px;height:60px" id="selectCauseOtherx"></textarea>
        </td>
    </tr>
    <tr class="tr_darks">
        <td align="left">&nbsp;</td>
    </tr>
    <tr class="tr_dark">
        <td align="center">
            <input type="button" value="确定" class="button_confirm" onclick="saveReason()">&nbsp;
            <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
        </td>
    </tr>
</table>
