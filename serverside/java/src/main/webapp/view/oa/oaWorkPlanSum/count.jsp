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
        var beginTime = "";
        if ('' != $("#startSum").val()) {
            beginTime = $("#startSum").val()
        }
        var endTime = "";
        if ('' != $("#endSum").val()) {
            endTime = $("#endSum").val()
        }
        var v = "<beginTime>" + beginTime + "</beginTime><endTime>" + endTime + "</endTime>";
        if (beginTime != '' && endTime != '') {
            openWindow("添加一周工作计划汇总", "${ctx}/oaWorkPlanSum/add.do?queryJson=" + v, true, 900, 550);
        } else{
            showInfoMsg('请输入正确的汇总时间！');
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
                    起始日期：<input type="text" name="startSum" id="startSum" value="" class="input_date"
                                style="width: 120px"
                                onClick="calendar('startSum','startSum');"/>
                </td>
                <td align="center">
                    结束日期：<input type="text" name="endSum" id="endSum" value="" class="input_date"
                                style="width: 120px"
                                onClick="calendar('endSum','endSum');"/>
                </td>
            </tr>
            <tr class="tr_button" align="center">
                <td class="form_border" colspan="2">
                    <input type="button" value="下一步" class="button_normal_long" onclick="jumpUrl()">
                </td>
            </tr>
        </table>
    </div>
</form:form>
