<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"no", rule:"validate[required,custom[integer],maxSize[3]"},
            {name:"name", rule:"validate[required,maxSize[50]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        //提交表单
        saveAjaxData("${ctx}/netAcceptStatus/save.do", formId,null);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <input type="hidden" name="acceptStep" id="acceptStep" value="${bean.acceptStep.id}"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">序号：</td>
                <td class="form_content">
                    <form:input path="no" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">状态名称：</td>
                <td class="form_content">
                    <form:input path="name" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">是否通过：</td>
                <td class="form_content">
                    <form:checkbox path="isPass" value="1"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">是否开始状态：</td>
                <td class="form_content">
                    <form:checkbox path="isStart" value="1"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">是否结束状态：</td>
                <td class="form_content">
                    <form:checkbox path="isEnd" value="1"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">受理日期重命名：</td>
                <td class="form_content">
                    <form:input path="label" cssClass="input_text"/>
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