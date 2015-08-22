<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        disableBtn(btn);
        //提交表单
        doSave(btn, "${ctx}/projExtendPre/save.do");
        <%--saveAjaxData("${ctx}/projExtendPre/save.do", formId);--%>
    }
    function doSave(btn, url) {
        var sendData = "";
        if (formId != null && $('#' + formId).length > 0) {
            sendData = $("#" + formId).serializeArray();
        }
        $.ajax({
            type: "POST",
            url: url,
            data: sendData,
            dataType: "json",
            success: function (data) {
                if (data.success) {
                    showInfoMsg(data.msg);
                } else {
                    showErrorMsg(data.msg);
                }
                enableBtn(btn, "保存")
            },
            error: function (xmlR, status, e) {
                showErrorMsg("[" + e + "]" + xmlR.responseText);
                $(btn).removeAttr("disabled");
            }
        });
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label_right">项目建议书：</td>
                <td class="form_content">
                    <sys:code code="ProjState" name="planXmjys" id="planXmjys" type="select"
                              sysCodeDetailId="${bean.planXmjys.id}"/>
                </td>

                <td class="form_label_right">完成时间：</td>
                <td class="form_content">
                    <form:input path="planXmjysTime" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('planXmjysTime');">
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">工可：</td>
                <td class="form_content">
                    <sys:code code="ProjState" name="planGk" id="planGk" type="select"
                              sysCodeDetailId="${bean.planGk.id}"/>
                </td>

                <td class="form_label_right">完成时间：</td>
                <td class="form_content">
                    <form:input path="planGkTime" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('planGkTime');">
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">初步设计：</td>
                <td class="form_content">
                    <sys:code code="ProjState" name="planCbsj" id="planCbsj" type="select"
                              sysCodeDetailId="${bean.planCbsj.id}"/>
                </td>

                <td class="form_label_right">完成时间：</td>
                <td class="form_content">
                    <form:input path="planCbsjTime" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('planCbsjTime');">
                </td>
            </tr>
        </table>
        <tr class="tr_button">
            <td class="form_content" colspan="6" style="text-align: center">
                <input type="button" value="保存" class="button_confirm" onclick="save(this)">&nbsp;
                <input type="button" value="取消" class="button_cancel" onclick="parent.closeWindow()">
            </td>
        </tr>
        </table>
    </div>
</form:form>