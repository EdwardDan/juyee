<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"code", rule:"validate[required,maxSize[100]]"},
            {name:"name", rule:"validate[required,maxSize[200]]"},
            {name:"path", rule:"validate[required,maxSize[200]]"},
            {name:"bizCode", rule:"validate[required,maxSize[100]]"},
            {name:"bizName", rule:"validate[required,maxSize[100]]"}
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
        saveAjaxData("${ctx}/docCategory/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <input type="hidden" name="parent" value="${bean.parent.id}"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">编号：</td>
                <td class="form_content">
                    <form:input path="code" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">名称：</td>
                <td class="form_content">
                    <form:input path="name" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">路径：</td>
                <td class="form_content">
                    <form:input path="path" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">业务编码：</td>
                <td class="form_content">
                    <form:input path="bizCode" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">业务名称：</td>
                <td class="form_content">
                    <form:input path="bizName" cssClass="input_text"/>
                </td>
            </tr>

            <tr class="tr_button">
                <td class="form_label"></td>
                <td class="form_content">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>