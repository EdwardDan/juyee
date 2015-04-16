<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"openDate", rule: "validate[required,custom[date],maxSize[20]"},
            {name:"property", rule:"validate[required,maxSize[25]]"},
            {name:"attendCount", rule: "validate[required,custom[integer],maxSize[6]"},
            {name:"title", rule:"validate[required,maxSize[100]]"},
            {name:"content", rule:"validate[required,maxSize[1000]]"}

        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        //提交表单
        saveAjaxData("${ctx}/workerSchool/actionSave.do", formId);
    }

</script>
<form:form commandName="bean">
    <%--<form:hidden path="id"/>--%>
    <input type="hidden" id="id" name="id" value="${bean.id}"/>
    <input type="hidden" id="schoolId" name="schoolId" value="${schoolId}"/>
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr>
                <td colspan="2">
                    <fieldset style="width: 90%;margin:0px auto">
                        <legend class="form_legend">开展活动信息</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_dark">
                                <td class="form_label_right">活动开展时间：</td>
                                <td class="form_content" colspan="3">
                                        <form:input path="openDate" cssClass="input_datetime" readonly="true" />
                                    <input type="button" class="button_calendar" value=" "   onClick="calendar('openDate')">
                                </td>
                            </tr>

                            <tr class="tr_light">
                                <td class="form_label_right" width="20%">活动性质：</td>
                                <td class="form_content" nowrap width="30">
                                    <form:input path="property" cssClass="input_text"/>
                                </td>
                                <td class="form_label_right" width="20%">参加人数：</td>
                                <td class="form_content" width="30%">
                                    <form:input path="attendCount" cssClass="input_text"/>
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right">活动主题：</td>
                                <td class="form_content" colspan="3">
                                    <form:input path="title" cssClass="input_text_long"/>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right">活动内容：</td>
                                <td class="form_content" colspan="3">
                                    <form:textarea path="content" cssClass="input_textarea_long" cssStyle="width: 100%"/>
                                </td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right" nowrap>附件：</td>
                                <td colspan="3" class="form_content">&nbsp;
                                        ${uploadButton}
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </td>
            </tr>
            <tr class="tr_button">
                <td align="center" colspan="4">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>