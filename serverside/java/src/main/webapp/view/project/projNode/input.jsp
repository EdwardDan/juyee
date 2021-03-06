<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            //{name:"code", rule:"validate[required,maxSize[200]]"},
            {name:"name", rule:"validate[required,maxSize[200]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        //提交表单
        saveAjaxData("${ctx}/projNode/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="year"/>
    <input type="hidden" name="parent" id="parent" value="${bean.parent.id}"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right" width="20%">编码：</td>
                <td class="form_content" width="30%">
                    <form:input path="code" cssClass="input_text"/>
                </td>
                <td class="form_label_right" width="15%">名称：</td>
                <td class="form_content" width="35%">
                    <form:input path="name" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">是否有效：</td>
                <td class="form_content" colspan="3">
                    <form:radiobutton path="isValid" value="true"/>是
                    <form:radiobutton path="isValid" value="false"/>否
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">备注：</td>
                <td class="form_content" colspan="3">
                    <form:textarea path="description" cssClass="input_textarea_long"/>
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_border" colspan="4" align="center">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>
