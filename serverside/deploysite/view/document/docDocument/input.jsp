<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            //{name:"originCode", rule:"validate[required,maxSize[40]]"},
//            {name:"code", rule:"validate[required,maxSize[40]]"},
//            {name:"name", rule:"validate[required,maxSize[200]]"}
            //{name:"author", rule:"validate[required,maxSize[40]]"},
            //{name:"keywords", rule:"validate[required,maxSize[500]]"},
            //{name:"abstractContent", rule:"validate[required,maxSize[1000]]"},
            //{name:"createUser", rule:"validate[required,maxSize[20]]"},
            //{name:"createDate", rule:"validate[required,custom[date],max[16]"},
            //{name:"achStatus", rule:"validate[required,custom[integer],max[2]"},
            //{name:"description", rule:"validate[required,maxSize[1000]]"},
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
        saveAjaxData("${ctx}/docDocument/save.do?docCategoryId=${docCategoryId}", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">原始编号：</td>
                <td class="form_content">
                    <form:input path="originCode" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">编号：</td>
                <td class="form_content">
                    <form:input path="code" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">标题：</td>
                <td class="form_content">
                    <form:input path="name" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">作者：</td>
                <td class="form_content">
                    <form:input path="author" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">关键字：</td>
                <td class="form_content">
                    <form:input path="keywords" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">附件：</td>
                <td class="form_content">
                        ${uploadButton}
                </td>
            </tr>
            <c:if test="${not empty bean}">
                <tr class="tr_light">
                    <td class="form_label">文档目录：</td>
                    <td class="form_content" name="path">
                            ${docMenu}&nbsp;
                    </td>
                </tr>
            </c:if>
            <tr class="tr_dark">
                <td class="form_label">摘要：</td>
                <td class="form_content">
                    <form:textarea path="abstractContent" cssClass="input_textarea"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">描述：</td>
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