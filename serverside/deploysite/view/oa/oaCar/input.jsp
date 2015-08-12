<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "applyDept", rule: "validate[required]"},
            {name: "applyUser", rule: "validate[required]"},
            {name: "useDate", rule: "validate[required]"},
            {name: "personNum", rule: "validate[required,custom[integer]]"},
            {name: "address", rule: "validate[required]"},
            {name: "driverMobile", rule: "validate[custom[phone]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(t, btn) {
        if (!validateForm(formId)) {
            return;
        }

        if (($("#beginHour").val() > $("#endHour").val()) || (($("#beginHour").val() == $("#endHour").val()) && ($("#beginMin").val() >= $("#endMin").val()))) {
            $.messager.confirm("系统提示", "使用截止时间必须大于开始时间！", null)
            return;
        }

        $("#beginTime").val($("#useDate").val() + " " + $("#beginHour").val() + ":" + $("#beginMin").val() + ":00.0");
        $("#endTime").val($("#useDate").val() + " " + $("#endHour").val() + ":" + $("#endMin").val() + ":00.0");

        //修改状态
        if (t == '${STATUS_EDIT}') {
            $("#status").val('${STATUS_EDIT}');
            saveAjaxData("${ctx}/oaCar/save.do", formId);
        } else if (t == '${STATUS_SUBMIT}') {
            $("#status").val('${STATUS_SUBMIT}');
            //提交表单
            $.messager.confirm('系统提示', "确定提交吗？提交后将不能修改！", function (r) {
                if (r) {
                    //提交表单
                    saveAjaxData("${ctx}/oaCar/save.do", formId);
                }
            });
        }

    }

    function showDriver() {
        if (document.getElementById("isAgree").checked) {
            $("#isAgree").val("true");
            document.getElementById("agreeDriver").style.display = "";
        } else {
            $("#isAgree").val("false");
            document.getElementById("agreeDriver").style.display = "none";
        }
    }

</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="status"/>

    <div class="form_div">
        <fieldset class="form_fieldset">
            <legend class="form_legend">
                车辆申请信息
            </legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_label_right" width="15%">申请部门：</td>
                    <td class="form_content">
                        <input type="text" name="applyDeptName" id="applyDeptName" class="input_datetime"
                               value="${bean.applyDept.name}"
                               readonly="true"/>
                        <input type="hidden" name="applyDeptId" id="applyDeptId" value="${bean.applyDept.id}"/>
                        <input type="button" value=" " class="button_select"
                               onclick="selectSysDept('applyDeptId','applyDeptName')" title="点击选择申请部门">
                    </td>
                    <td class="form_label_right" width="15%">申请人：</td>
                    <td class="form_content" width="35%">
                        <input type="text" name="applyUserName" id="applyUserName" class="input_text"
                               value="${bean.applyUser.displayName}" readonly="true"/>
                        <input type="hidden" name="applyUserId" id="applyUserId" value="${bean.applyUser.id}"/>
                        <input type="button" value=" " class="button_select"
                               onclick="selectSysUser('applyUserId','applyUserName');" title="点击申请人">
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" width="15%">使用车辆日期：</td>
                    <td class="form_content" width="35%">
                        <input type="text" name="useDate" id="useDate" class="input_date"
                               value="<fmt:formatDate value="${bean.beginTime}" pattern="yyyy-MM-dd"/>"
                               readonly="true"/>
                        <input type="button" class="button_calendar" value=" " onClick="calendar('useDate')">
                    </td>
                    <td class="form_label_right" width="15%">用车起止时间：</td>
                    <td class="form_content" width="35%">
                        <select name="beginHour" id="beginHour" style="width: 40px">${startHour}</select>时
                        <select name="beginMin" id="beginMin" style="width: 40px">${startMinute}<</select>分~
                        <select name="endHour" id="endHour" style="width: 40px">${endHour}<</select>时
                        <select name="endMin" id="endMin" style="width: 40px">${endMinute}<</select>分

                        <input type="hidden" name="beginTime" id="beginTime" class="input_date" value=""/>
                        <input type="hidden" name="endTime" id="endTime" class="input_date" value=""/>

                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" width="15%">用车人数：</td>
                    <td class="form_content" colspan="3">
                        <form:input path="personNum" cssClass="input_text"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" width="15%">用车事由：</td>
                    <td class="form_content" colspan="3">
                        <form:textarea path="useCause" cssClass="input_textarea_long"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" width="15%">目的地：</td>
                    <td class="form_content" colspan="3">
                        <form:input path="address" cssClass="input_text_long"/>
                    </td>
                </tr>
            </table>
        </fieldset>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_button">
                <td style="text-align: center" colspan="4">
                    <c:if test="${bean.status==STATUS_EDIT|| empty bean.status || bean.status==STATUS_BRANCH_BACK || bean.status==STATUS_MAIN_BACK}">
                        <input type="button" value="提交" class="button_confirm" onclick="save('${STATUS_SUBMIT}',this)">&nbsp;
                        <input type="button" value="暂存" class="button_confirm" onclick="save('${STATUS_EDIT}',this)">&nbsp;
                    </c:if>
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>