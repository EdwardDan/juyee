<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //sum area ids
        var ids = getSelectValues(document.getElementById("privilegeSelect"));
        $("#privilegeIds").val(ids);

        //页面验证初始化
        var validateCondition = [
            {name:"code", rule:"validate[required,maxSize[50]]"},
            {name:"name", rule:"validate[required,maxSize[100]]"}
            //{name:"url", rule:"validate[required,maxSize[200]]"},
            //{name:"isWorkflow", rule:"validate[required,maxSize[1]]"},
            //{name:"isValid", rule:"validate[required,maxSize[1]]"},
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
        saveAjaxData("${ctx}/oaTaskType/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <input type="hidden" name="parent" id="parent" value="${bean.parent.id}"/>

    <div class="form_div">

        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">编码：</td>
                <td class="form_content">
                    <form:input path="code" cssClass="input_text"/>(使用类名ClassName)
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">名称：</td>
                <td class="form_content">
                    <form:input path="name" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">执行链接：</td>
                <td class="form_content">
                    <form:input path="url" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">查看链接：</td>
                <td class="form_content">
                    <form:input path="viewUrl" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">是否流程任务：</td>
                <td class="form_content">
                    <form:checkbox path="isWorkflow" value="1"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">是否有效：</td>
                <td class="form_content">
                    <form:checkbox path="isValid" value="1"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">任务脚本：</td>
                <td class="form_content">
                    <form:textarea path="script" cssClass="input_textarea_long"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">内容模板：</td>
                <td class="form_content">
                    <form:textarea path="titleTemplate" cssClass="input_textarea_long"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">查看权限：</td>
                <td class="form_content">
                    <select name="privilegeSelect" id="privilegeSelect" multiple="5" class="form_multi_select_long">
                        <c:forEach items="${bean.oaTaskTypePrivileges}" var="item">
                            <option value="${item.privilege.id}">${item.privilege.name}</option>
                        </c:forEach>
                    </select>
                    <input type="button" value=" " class="button_select_add"
                           onclick="multiSelectPrivilege('privilegeSelect','privilegeIds','')" title="点击选择权限">
                    <input type="button" value=" " class="button_select_remove"
                           onclick="removeMultiSelectOpt('privilegeSelect','privilegeIds','')" title="点击移除权限">
                    <input type="hidden" id="privilegeIds" name="privilegeIds">
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