<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"signUnit", rule:"validate[required,maxSize[200]]"},
            {name:"linkPerson", rule:"validate[required,maxSize[50]]"},
            {name:"linkTel", rule:"validate[required,custom[phone],maxSize[50]]"},
            {name:"signDate",rule:"validate[required,maxSize[50]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }


        //提交表单
        saveAjaxData("${ctx}/projectBidSignDept/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <input type="hidden" name="projectBidSign" id="projectBidSign" value="${bean.projectBidSign.id}"/>
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right">购买标书单位：</td>
                <td class="form_content">
                    <form:input path="signUnit" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">联系人：</td>
                <td class="form_content">
                    <form:input path="linkPerson" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">联系电话：</td>
                <td class="form_content">
                    <form:input path="linkTel" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">购买标书时间：</td>
                <td class="form_content">
                    <form:input path="signDate" cssClass="input_date_long" readonly="true"/>
                    <input type="button" class="button_calendar" value="" onClick="calendar('signDate','all');">
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