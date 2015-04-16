<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "applyDept", rule: "validate[required,maxSize[100]]"},
            {name: "applyPerson", rule: "validate[required,maxSize[50]]"},
            {name: "useReason", rule: "validate[required,maxSize[500]]"},
            {name: "personNum", rule: "validate[required,maxSize[20]"},
            {name: "useDate", rule: "validate[required,custom[date],maxSize[20]"},
            {name: "arrivalPlace", rule: "validate[required,maxSize[300]]"}
        ];

        validateInit(validateCondition, formId);

    });
    //保存操作
    function save(status, buttonName) {
        if (!validateForm(formId)) {
            return;
        }

        //加入其他业务判断
        //用车时间的判断
        var beginHour = $("#beginHour").val();
        var endHour = $("#endHour").val();
        var beginMinute = $("#beginMinute").val();
        var endMinute = $("#endMinute").val();
        if (endHour < beginHour || endHour == beginHour && endMinute <= beginMinute) {
            showInfoMsg("用车时间必须大于开始时间！", null);
            return false;
        }
        //提交表单
        if (buttonName != "") {
            if (confirm("是否确定执行 " + buttonName + " 操作？")) {
                saveAjaxData("${ctx}/oaCar/save.do?status=" + status, formId);
            }
        } else {
            saveAjaxData("${ctx}/oaCar/save.do?status=" + status, formId);
        }
    }
</script>

<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="isArrangeDriver"/>
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr>
                <td colspan="2">
                    <fieldset style="width: 90%;margin:0px auto">
                        <legend class="form_legend">申请</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_light">
                                <td class="form_label" width="20%" nowrap>申请部门：</td>
                                <td class="form_content" width="30%" nowrap>
                                    <input type="text" name="applyDept" id="applyDept" class="input_text"
                                           value="${bean.applyDept}"
                                           readonly="true">
                                    <input type="hidden" name="sysDeptId" id="sysDeptId" value=""/>
                                    <input type="button" class="button_select"
                                           onclick="selectSysDept('sysDeptId','applyDept')"
                                           title="点击选择申请部门">
                                </td>
                                <td class="form_label" width="15%">申请人：</td>
                                <td class="form_content" width="35%" nowrap>
                                    <input type="text" name="applyPerson" id="applyPerson" class="input_text"
                                           value="${bean.applyPerson}" readonly="true"/>
                                    <input type="hidden" name="person" id="person" value=""/>
                                    <input type="button" class="button_select"
                                           onclick="selectSysPerson('person','applyPerson');"
                                           title="点击选择申请人员">
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label" width="15%" nowrap>使用车辆日期：</td>
                                <td class="form_content" width="35%">
                                    <form:input path="useDate" cssClass="input_date" readonly="true"/>
                                    <input type="button" class="button_calendar" value=" "
                                           onClick="calendar('useDate');">
                                </td>
                                <td class="form_label" width="15%">用车起止时间：</td>
                                <td align="left" nowrap>
                                    <select name="beginHour" id="beginHour" size="1" title="请选择开始时间（时）">
                                            ${beginHourSelectOptions}
                                    </select>时
                                    <select name="beginMinute" id="beginMinute" size="1" title="请选择开始时间（分）">
                                            ${beginMinuteSelectOptions}
                                    </select>分&nbsp;~
                                    <select name="endHour" id="endHour" size="1" title="请选择结束时间（时）">
                                            ${endHourSelectOptions}
                                    </select>时
                                    <select name="endMinute" id="endMinute" size="1" title="请选择结束时间（分）">
                                            ${endMinuteSelectOptions}
                                    </select>分
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label">用车人数：</td>
                                <td class="form_content">
                                    <form:input path="personNum" cssClass="input_text"/>
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label">用车事由：</td>
                                <td class="form_content" colspan="4">
                                    <form:textarea path="useReason" cssClass="input_textarea_long"
                                                   cssStyle="width:100%"/>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label">目的地：</td>
                                <td class="form_content" colspan="4" rowspan="2">
                                    <form:input path="arrivalPlace" cssClass="input_text" cssStyle="width:100%"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_border">
                    <input type="button" value="提交" class="button_confirm"
                           onclick="save('${STATUS_SUBMIT}',this.value)">&nbsp;
                    <input type="button" value="暂存" class="button_confirm"
                           onclick="save('${STATUS_EDIT}','')">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>