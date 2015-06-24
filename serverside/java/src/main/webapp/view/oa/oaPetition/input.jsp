<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        var validateCondition = [
            //{name:"code", rule:"validate[required,maxSize[50]]"},
            //{name:"statusDesc", rule:"validate[required,maxSize[50]]"},
            //{name:"sourceDesc", rule:"validate[required,maxSize[50]]"},
            //{name:"typeDesc", rule:"validate[required,maxSize[50]]"},
            //{name:"person", rule:"validate[required,maxSize[500]]"},
            //{name:"tel", rule:"validate[required,maxSize[50]]"},
            //{name:"receiveDate", rule:"validate[required,custom[date],maxSize[7]"},
            //{name:"address", rule:"validate[required,maxSize[200]]"},
            //{name:"jbrName", rule:"validate[required,maxSize[50]]"},
            //{name:"endDate", rule:"validate[required,custom[date],maxSize[7]"},
            <%--//{name:"content", rule:"validate[required,maxSize[${prop.length}]]"},            --%>
            <%--//{name:"dealResult", rule:"validate[required,maxSize[${prop.length}]]"},            --%>
            <%--//{name:"description", rule:"validate[required,maxSize[${prop.length}]]"},            --%>
            //{name:"createTime", rule:"validate[required,maxSize[7]]"},
            //{name:"createUser", rule:"validate[required,maxSize[100]]"},
            //{name:"updateTime", rule:"validate[required,maxSize[7]]"},
            //{name:"updateUser", rule:"validate[required,maxSize[100]]"},
        ];
        validateInit(validateCondition, formId);
    });

    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        saveAjaxData("${ctx}/oaPetition/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right" style="width:15%;" nowrap>受理编号：</td>
                <td class="form_content" style="width:35%;">
                    <form:input path="code" cssClass="input_text"/>
                </td>
                <td class="form_label_right" style="width:15%;" nowrap>受理状态：</td>
                <td class="form_content" style="width:25%;">
                    <sys:code type="select" code="${status}" id="status" name="status" sysCodeDetailId="${bean.status.id}" style="form_select"></sys:code>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">信访来源：</td>
                <td class="form_content">
                    <sys:code type="select" code="${source}" id="source" name="source" sysCodeDetailId="${bean.source.id}"></sys:code>
                </td>
                <td class="form_label_right">信访种类：</td>
                <td class="form_content">
                    <sys:code type="select" code="${type}" id="type" name="type" sysCodeDetailId="${bean.type.id}"></sys:code>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">信访人：</td>
                <td class="form_content">
                    <form:input path="person" cssClass="input_text"/>
                </td>
                <td class="form_label_right">联系电话：</td>
                <td class="form_content">
                    <form:input path="tel" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">收信日期：</td>
                <td class="form_content">
                    <form:input path="receiveDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value="" onClick="calendar('receiveDate');">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">联系地址：</td>
                <td class="form_content" colspan="3">
                    <form:input path="address" cssClass="input_text_long" cssStyle="width: 90%"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">经办人：</td>
                <td class="form_content">
                    <form:input path="jbrName" cssClass="input_text" readonly="true"/>
                    <input type="button" title="请选择一个经办人" class="button_select"
                           onclick="selectSysUser('jbrId', 'jbrName')"/>
                    <input type="hidden" id="jbrId" name="jbrId" value="${bean.jbrUser.id}"/>
                </td>
                <td class="form_label_right">结案日期：</td>
                <td class="form_content">
                    <form:input path="endDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('endDate');">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">信访事由：</td>
                <td class="form_content" colspan="3">
                    <form:textarea path="content" cssClass="input_textarea_long" cssStyle="width: 90%"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">处理结果：</td>
                <td class="form_content" colspan="3">
                    <form:textarea path="dealResult" cssClass="input_textarea_long" cssStyle="width: 90%"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">备注：</td>
                <td class="form_content" colspan="3">
                    <form:textarea path="description" cssClass="input_textarea_long" cssStyle="width: 90%"/>
                </td>
            </tr>
            <tr>
                <td class="form_label_right">附件：</td>
                <td class="form_content">${uploadButtonDocument}</td>
            </tr>
            <tr class="tr_button">
                <td class="form_content" style="text-align: center;" colspan="4">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>