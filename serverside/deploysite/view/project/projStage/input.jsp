<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"code", rule:"validate[required]"},
            {name:"name", rule:"validate[required]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        //提交表单
        saveAjaxData("${ctx}/projStage/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="year"/>
    <input type="hidden" name="parent" id="parent" value="${bean.parent.id}"/>

    <div class="form_div" style="text-align: center">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">编码：</td>
                <td class="form_content">
                    <form:input path="code" cssClass="input_text"/>
                </td>
                <td class="form_label">名称：</td>
                <td class="form_content">
                    <form:input path="name" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">审批部门：</td>
                <td class="form_content">
                    <form:input path="auditDept" cssClass="input_text"/>
                </td>
                <td class="form_label">是否有效：</td>
                <td class="form_content">
                    <form:checkbox path="isValid" value="1"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">缺省工作周期(天)：</td>
                <td class="form_content">
                    <form:input path="defaultDays" cssClass="input_text"/>
                </td>
                <td class="form_label">预警期限(天)：</td>
                <td class="form_content">
                    <form:input path="alertDays" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">办证联系信息：</td>
                <td class="form_content" colspan="3">
                    <form:textarea path="linkInfo" cssClass="input_textarea_long"/>
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_content" colspan="4" style="text-align: center">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>