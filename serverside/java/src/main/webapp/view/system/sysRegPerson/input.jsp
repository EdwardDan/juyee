<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">

    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "bjbh", rule: "validate[required,maxSize[50]]"},
            {name: "personName", rule: "validate[required,maxSize[50]]"},
            {name: "mobile", rule: "validate[required,custom[mobile]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        var msg = getAjaxData("${ctx}/sysRegPerson/getReg.do?loginName=" + $("#loginName").val + "&bjbh=" + $("#bjbh").val + "&unitCode=" + $("#unitCode").val);
        if (msg.success == "true") {
            document.getElementById("msg").innerHTML = "";
        } else {
            document.getElementById("msg").innerHTML = msg.msg;
            return true;
        }

        //提交表单
        disableBtn(btn);
        saveAjaxData("${ctx}/sysRegPerson/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="regResource"/>
    <input type="hidden" name="acceptOpinion" id="acceptOpinion" value="1">
    <input type="hidden" name="loginName" id="loginName" value="${sysUsers}">

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">报建编号：</td>
                <td class="form_content">
                    <form:input path="bjbh" cssClass="input_text_long"/>
                    <div id="msg" style="color:red;display:inline"></div>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">工程名称：</td>
                <td class="form_content">
                    <form:input path="projectName" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">企业编码：</td>
                <td class="form_content">
                    <form:input path="unitCode" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">企业标识码：</td>
                <td class="form_content">
                    <form:input path="unitIdentifyCode" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">企业名称：</td>
                <td class="form_content">
                    <form:input path="unitName" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">联系人：</td>
                <td class="form_content">
                    <form:input path="personName" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">手机号码：</td>
                <td class="form_content">
                    <form:input path="mobile" cssClass="input_text_long"/>
                </td>
            </tr>
                <%--<tr class="tr_light">--%>
                <%--<td class="form_label">受理描述：</td>--%>
                <%--<td class="form_content">--%>
                <%--<form:textarea path="acceptDesc" cssClass="input_textarea"/>--%>
                <%--</td>--%>
                <%--</tr>--%>
            <tr class="tr_button">
                <td class="form_content" colspan="2" style="text-align: center;">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>