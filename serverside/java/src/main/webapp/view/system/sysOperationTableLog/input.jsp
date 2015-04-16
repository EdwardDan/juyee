<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"table"},
            {name:"logXml"},
            {name:"ipAddress"},
            {name:"createTime", rule:"validate[required,maxSize[19]]"},
            {name:"updateTime", rule:"validate[required,maxSize[19]]"},
            {name:"updateUser", rule:"validate[required,maxSize[100]]"},
            {name:"createUser", rule:"validate[required,maxSize[100]]"}
            //{name:"logType", rule:"validate[required,maxSize[20]]"},
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        //提交表单
        saveAjaxData("${ctx}/sysOperationTableLog/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label">操作日志：</td>
                <td class="form_content">
                    <form:textarea path="logXml" cssClass="input_textarea"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">IP地址：</td>
                <td class="form_content">
                    <form:input path="ipAddress" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">创建时间：</td>
                <td class="form_content">
                    <input type="text" name="createTime" id="createTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                           readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('createTime','all')">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">更新时间：</td>
                <td class="form_content">
                    <input type="text" name="updateTime" id="updateTime" class="input_datetime"
                           value="<fmt:formatDate value="${bean.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                           readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('updateTime','all')">

                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">更新人：</td>
                <td class="form_content">
                    <form:input path="updateUser" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">创建人：</td>
                <td class="form_content">
                    <form:input path="createUser" cssClass="input_text"/>
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