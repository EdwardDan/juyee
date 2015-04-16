<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [];
        validateInit(validateCondition, formId);
    });

    function jumpUrl() {
        var year = $("#year").val();
        var quarter = $("#quarter").val();
        if ((year != null || year != "") && quarter != null || quarter != "") {
            var msg = getAjaxData("${ctx}/safeProductCheck/checkYearQuarter.do?year=" + year + "&quarter=" + quarter);
            if (msg.success == 'true') {
                showInfoMsg(year + "年第" + quarter + "季度信息已存在，无需再添加！");
                return;
            } else {
                openWindow("添加安全生产季度考核", "${ctx}/safeProductCheck/add.do?year=" + year + "&quarter=" + quarter, true, 900, 550);
            }
        }
    }

</script>
<form:form commandName="bean">
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr height="30">
                <td></td>
            </tr>
            <tr class="tr_dark">
                <td align="center">
                    请选择考核季度：
                    <select name="year" id="year">
                            ${yearOptions}
                    </select>年
                    <select name="quarter" id="quarter">
                            ${quarterOptions}
                    </select>
                </td>
            </tr>
            <tr class="tr_button" align="center">
                <td class="form_border">
                    <input type="button" value="下一步" class="button_normal_long" onclick="jumpUrl()">
                </td>
            </tr>
        </table>
    </div>
</form:form>
