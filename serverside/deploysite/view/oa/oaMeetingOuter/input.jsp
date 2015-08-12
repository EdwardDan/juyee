<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "beginTime", rule: "validate[required]"},
            {name: "endTime", rule: "validate[required]"},
            {name: "address", rule: "validate[required]"},
            {name: "title", rule: "validate[required]"},
            {name: "content", rule: "validate[required]"}

        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(status, buttonName) {
        if (!validateForm(formId)) {
            return;
        }
        var beginDate = $("#beginTime").val() + ":00";
        var endDate = $("#endTime").val() + ":00";
        var d1 = new Date(beginDate.replace(/\-/g, "\/"));
        var d2 = new Date(endDate.replace(/\-/g, "\/"));

        if (beginDate != "" && endDate != "" && d1 >= d2) {
            alert("开始时间不能大于结束时间！");
            $("#beginTime").focus();
            $("#beginTime").css("background", "red");
            $("#endTime").css("background", "red");
            return;
        }

        $("#beginTime").val($("#beginTime").val() + ":00");
        $("#endTime").val($("#endTime").val() + ":00");
        //提交表单
        if (buttonName != "") {
            if (confirm("是否确定执行 " + buttonName + " 操作？")) {
                saveAjaxData("${ctx}/oaMeetingOuter/save.do?status=" + status, formId);
            }
        } else {
            saveAjaxData("${ctx}/oaMeetingOuter/save.do?status=" + status, formId);
        }

    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <div class="form_div">
        <fieldset class="form_fieldset">
            <legend class="form_legend">外出会议</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_label_right" style="width: 150px">会议时间：</td>
                    <td class="form_content" colspan="3">
                        <input type="text" name="beginTime" id="beginTime" class="input_datetime"
                               value="<fmt:formatDate value="${bean.beginTime}" pattern="yyyy-MM-dd HH:mm"/>"
                               readonly="true"/>
                        <input type="button" class="button_calendar" value=" "
                               onClick="calendar('beginTime','datetime')">
                        ~
                        <input type="text" name="endTime" id="endTime" class="input_datetime"
                               value="<fmt:formatDate value="${bean.endTime}" pattern="yyyy-MM-dd HH:mm"/>"
                               readonly="true"/>
                        <input type="button" class="button_calendar" value=" " onClick="calendar('endTime','datetime')">
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">会议地点：</td>
                    <td class="form_content" colspan="3">
                        <form:input path="address" cssClass="input_text_long" cssStyle="width: 400px"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">主持人：</td>
                    <td class="form_content">
                        <form:input path="chargePerson" cssClass="input_text"/>
                    </td>
                    <td class="form_label_right">发起单位：</td>
                    <td class="form_content">
                        <form:input path="startDept" cssClass="input_text"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">会议领导：</td>
                    <td class="form_content" colspan="3">
                        <form:textarea path="leader" cssClass="input_textarea" cssStyle="height: 30px;width: 400px"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">与会单位：</td>
                    <td class="form_content" colspan="3">
                        <form:textarea path="innerPersons" cssClass="input_textarea"
                                       cssStyle="height: 30px;width: 400px"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">会议名称：</td>
                    <td class="form_content" colspan="3">
                        <form:input path="title" cssClass="input_text_long" cssStyle="width: 400px"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">会议内容：</td>
                    <td class="form_content" colspan="3">
                        <form:textarea path="content" cssClass="input_textarea_long"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">与中心相关事宜：</td>
                    <td class="form_content" colspan="3">
                        <form:textarea path="relateMatter" cssClass="input_textarea_long"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">工作建议：</td>
                    <td class="form_content" colspan="3">
                        <form:textarea path="workAdvise" cssClass="input_textarea_long"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">参会科室：</td>
                    <td class="form_content" colspan="3">
                        <form:textarea path="attendDepts" cssClass="input_textarea"
                                       cssStyle="height: 30px;width: 400px"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">参会人员：</td>
                    <td class="form_content" colspan="3">
                        <form:textarea path="attendPersons" cssClass="input_textarea"
                                       cssStyle="height: 30px;width: 400px"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">附件：</td>
                    <td class="form_content" colspan="3">
                            ${uploadButtonDocument}
                    </td>
                </tr>
            </table>
        </fieldset>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_button">
                <td class="form_content" style="text-align: center">
                    <input type="button" value="提交" class="button_confirm"
                           onclick="save('${STATUS_SUBMIT}',this.value)">&nbsp;
                    <input type="button" value="保存" class="button_confirm"
                           onclick="save('${STATUS_EDIT}','')">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>