<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "selectItems", rule: "validate[required,maxSize[50]]"},
            {name: "typeId", rule: "validate[required]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        //提交表单
        saveAjaxData("${ctx}/jdRecordCompCheckitem/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label">类别：</td>
                <td class="form_content">
                    <sys:code code="${type}" name="typeId" id="typeId" type="select" sysCodeDetailId="${bean.type.id}" style="width:200px"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">序号：</td>
                <td class="form_content">
                    <form:input path="orderNo" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">竣工验收条件：</td>
                <td class="form_content">
                    <form:textarea path="condition" cssClass="input_textarea"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">符合形式：</td>
                <td class="form_content">
                    <form:input path="selectItems" cssClass="input_text"/>
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