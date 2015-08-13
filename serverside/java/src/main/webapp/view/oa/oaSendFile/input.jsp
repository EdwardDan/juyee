<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "fileTitle", rule: "validate[required,maxSize[100]]"},
            {name: "fileCode", rule: "validate[required,maxSize[100]]"},
            {name: "sendDept", rule: "validate[required,maxSize[200]]"},
            {name: "ccDept", rule: "validate[required,maxSize[200]]"},
            {name: "writtenDept", rule: "validate[required,maxSize[200]]"},
            {name: "writtenDate", rule: "validate[required,maxSize[20]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        disableBtn(btn);
        //提交表单
        saveAjaxData("${ctx}/oaSendFile/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_title">
                <td colspan="5">上海市政局</td>
            </tr>
            <tr class="tr_light">
                <td class="form_content" style="width: 10%;"></td>
                <td class="form_content" style="width: 33%;">
                    文种：<sys:code code="${type}" type="select" name="type" id="type" sysCodeDetailId="${bean.type.id}"/>
                </td>
                <td class="form_content" style="width: 33%;">
                    密级：<sys:code code="${secret}" type="select" name="secret" id="secret" sysCodeDetailId="${bean.secret.id}"/>
                </td>
                <td class="form_content" style="width: 33%;">
                    （<form:input path="fileCode" cssClass="input_number"/> ）号
                </td>
                <td class="form_content" style="width: 10%;"></td>
            </tr>
            <tr>
                <td colspan="5">
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
                            <td class="form_label_right">发文标题：</td>
                            <td class="form_content" colspan="3">
                                <form:input path="fileTitle" cssClass="input_text_long" cssStyle="width: 96%;"/>
                            </td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right">主送机关：</td>
                            <td class="form_content" colspan="3">
                                <form:input path="sendDept" cssClass="input_text_long" cssStyle="width: 96%;"/>
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right">抄送机关：</td>
                            <td class="form_content" colspan="3">
                                <form:input path="ccDept" cssClass="input_text_long" cssStyle="width: 96%;"/>
                            </td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right">成文机关：</td>
                            <td class="form_content" colspan="3">
                                <form:input path="writtenDept" cssClass="input_text_long" cssStyle="width: 96%;"/>
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right" style="width: 15%;">成文日期：</td>
                            <td class="form_content" style="width: 35%;">
                                <form:input path="writtenDate" cssClass="input_date" readonly="true"/>
                                <input type="button" class="button_calendar" value=" "
                                       onClick="calendar('writtenDate');">
                            </td>
                            <td class="form_label_right" style="width: 15%;">紧急程度：</td>
                            <td class="form_content" style="width: 35%;">
                                <sys:code code="${emergency}" type="select" name="emergency" id="emergency" sysCodeDetailId="${bean.emergency.id}"/>
                            </td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right">附件：</td>
                            <td class="form_content" colspan="3">
                                    ${uploadButton}
                            </td>
                        </tr>

                    </table>
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_content" colspan="5" style="text-align: center;">
                    <input type="button" name="btn" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>