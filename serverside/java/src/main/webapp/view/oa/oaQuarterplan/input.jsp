<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "reportDept", rule: "validate[required,maxSize[100]]"},
            {name: "reportPerson", rule: "validate[required,maxSize[50]]"},
            {name: "year", rule: "validate[required,custom[integer],maxSize[4]"},
            {name: "reportDate", rule: "validate[required,custom[date],maxSize[20]"}
        ];
        validateInit(validateCondition, formId);
    });
    //保存操作
    function save(status, buttonName) {
        if (!validateForm(formId)) {
            return;
        }
        var content = $("#content").val();
        if (content == '') {
            showInfoMsg("内容未输入！", null);
            return false;
        }
        //提交表单
        if (buttonName != "") {
            if (confirm("提交之后将不能再修改，确定继续吗？")) {
                saveAjaxData("${ctx}/oaQuarterplan/save.do?status=" + status, formId);
            }
        } else {
            saveAjaxData("${ctx}/oaQuarterplan/save.do?status=" + status, formId);
        }
    }

</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr>
                <td colspan="2">
                    <fieldset style="width: 90%;margin:0px auto">
                        <legend class="form_legend">年度季度计划</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_light">
                                <td class="form_label_right" width="20%" nowrap>提交部门：</td>
                                <td class="form_content" width="30%" nowrap>
                                    <input type="text" name="reportDept" id="reportDept" class="input_text"
                                           value="${bean.reportDept}"
                                           readonly="true">
                                    <input type="hidden" name="sysDeptId" id="sysDeptId" value=""/>
                                    <input type="button" class="button_select"
                                           onclick="selectSysDept('sysDeptId','reportDept')"
                                           title="点击选择申请部门">
                                </td>
                                <td class="form_label_right" width="15%">责任人：</td>
                                <td class="form_content" width="35%" nowrap>
                                    <input type="text" name="reportPerson" id="reportPerson" class="input_text"
                                           value="${bean.reportPerson}" readonly="true"/>
                                    <input type="hidden" name="person" id="person" value=""/>
                                    <input type="button" class="button_select"
                                           onclick="selectSysPerson('person','reportPerson');"
                                           title="点击选择申请人员">
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">报告时间：</td>
                                <td align="left">
                                    <select name="year" id="year" size="1" title="请选择年份">
                                            ${yearSelectOptions}
                                    </select>年
                                    <select name="period" id="period" size="1" title="请选择季度">
                                        <option value='' selected>请选择</option>
                                            ${quarterSelectOptions}
                                    </select>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">内容：</td>
                                <td class="form_content" colspan="3">
                                    <form:textarea path="content" cssClass="input_textarea_long"
                                                   cssStyle="width:100%"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </td>
            </tr>
            <tr class="tr_button" align="center">
                <td class="form_border" colspan="7">
                    <input type="button" value="提交" class="button_confirm"
                           onclick="save('${STATUS_SUBMIT}',this.value)">&nbsp;
                    <input type="button" value="暂存" class="button_confirm" onclick="save('${STATUS_EDIT}','')">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>