<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {

    });

    //控制页面的跳转
    function jumpUrl() {
        var year = $("#year").val();
        var month = $("#month").val();
        loadAjaxDataCallback(null, "${ctx}/reportMonth/ajaxYearMonth.do?year=" + year + "&month=" + month + "&code=${code}", callbackEvent);
    }
    //回调函数处理跳转页面
    function callbackEvent(ret) {
        var obj = eval("(" + ret + ")");
        if (obj.success) {
            openWindow("修改${name}综合报表月份上报", "${ctx}/reportMonth/modify.do?id=" + obj.id, true, 900, 550);
        } else {
            openWindow("添加${name}综合报表月份上报", "${ctx}/reportMonth/add.do?year=" + obj.year + "&month=" + obj.month + "&code=${code}", true, 900, 550);
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
                    选择报表年月：
                    <select name="year" id="year">
                            ${yearOptions}
                    </select>&nbsp;年&nbsp;
                    <select name="month" id="month">
                            ${monthOptions}
                    </select>&nbsp;月
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
