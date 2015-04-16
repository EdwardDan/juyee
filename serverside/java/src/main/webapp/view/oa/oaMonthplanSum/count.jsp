<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [];
        validateInit(validateCondition, formId);
    });

    //控制页面的跳转
    function jumpUrl() {
        //option的个数
        var length = $("#yearPeriod").find("option").length;
        var yearPeriod = $("#yearPeriod option:selected").val();
        if (yearPeriod == '' && length == 1) {
            showInfoMsg('没有可以汇总的数据！');
        } else if (yearPeriod == '' && length > 1) {
            showInfoMsg('请先选择要汇总数据！');
        } else {
            openWindow("添加月度总结和计划汇总", "${ctx}/oaMonthplanSum/add.do?yearPeriod=" + yearPeriod, true, 900, 550);
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
                    选择汇总年月：
                    <select name="yearPeriod" id="yearPeriod">
                        <option value="">==请选择==</option>
                            ${yearPeriodSelectOptions}
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
