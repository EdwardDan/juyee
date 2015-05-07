<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"code", rule:"validate[required,maxSize[50]]"},
            {name:"name", rule:"validate[required,maxSize[40]]"},
            {name:"tag", rule:"validate[custom[integer],maxSize[10]"},
            {name:"url", rule:"validate[maxSize[200]"},
            {name:"definition", rule:"validate[maxSize[500]]"},
            {name:"description", rule:"validate[maxSize[50]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        //提交表单
        disableBtn(btn);
        saveAjaxData("${ctx}/sysPrivilege/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="parent" value="${bean.parent.id}"/>
    <form:hidden path="platform"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">权限编码:</td>
                <td class="form_content">
                    <form:input path="code" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">权限名称:</td>
                <td class="form_content">
                    <form:input path="name" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">权限类型:</td>
                <td class="form_content">
                    <sys:code code="${typeCode}" sysCodeDetailId="${bean.type.id}" type="select" name="type"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">TAG:</td>
                <td class="form_content">
                    <form:input path="tag" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">页面地址:</td>
                <td class="form_content">
                    <form:input path="url" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">定义:</td>
                <td class="form_content">
                    <form:textarea path="definition" cssClass="input_textarea"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">描述:</td>
                <td class="form_content">
                    <form:textarea path="description" cssClass="input_textarea"/>
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